package com.tencent.mm.plugin.address.c;

import android.app.Dialog;
import android.content.Context;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class b
  implements f
{
  HashSet<m> fti = new HashSet();
  HashSet<m> ftj = new HashSet();
  Dialog ftk = null;
  private a ftx = null;
  private Set<Integer> fty = new HashSet();
  private Context mContext;
  
  public b(Context paramContext, a parama)
  {
    this.mContext = paramContext;
    this.ftx = parama;
  }
  
  public final void g(m paramm)
  {
    y.d("MicroMsg.WalletNetSceneMgr", "isShowProgress true");
    this.ftj.add(paramm);
    if ((this.ftk == null) || ((this.ftk != null) && (!this.ftk.isShowing())))
    {
      if (this.ftk != null) {
        this.ftk.dismiss();
      }
      this.ftk = h.b(this.mContext, "", true, new b.1(this));
    }
    au.Dk().a(paramm, 0);
  }
  
  public final void kh(int paramInt)
  {
    this.fty.add(Integer.valueOf(paramInt));
    au.Dk().a(paramInt, this);
  }
  
  public final void ki(int paramInt)
  {
    au.Dk().b(paramInt, this);
    this.fty.remove(Integer.valueOf(paramInt));
    if (this.fty.isEmpty())
    {
      if (this.ftk != null)
      {
        this.ftk.dismiss();
        this.ftk = null;
      }
      Iterator localIterator = this.fti.iterator();
      m localm;
      while (localIterator.hasNext())
      {
        localm = (m)localIterator.next();
        au.Dk().c(localm);
      }
      localIterator = this.ftj.iterator();
      while (localIterator.hasNext())
      {
        localm = (m)localIterator.next();
        au.Dk().c(localm);
      }
      this.fti.clear();
      this.ftj.clear();
      this.ftx = null;
      this.mContext = null;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    int i = 1;
    if (this.ftj.contains(paramm))
    {
      this.ftj.remove(paramm);
      y.d("MicroMsg.WalletNetSceneMgr", "has find scene ");
    }
    for (;;)
    {
      if ((this.ftj.isEmpty()) && (this.fti.isEmpty()) && (this.ftk != null))
      {
        this.ftk.dismiss();
        this.ftk = null;
      }
      if ((i != 0) && (this.ftx != null)) {
        this.ftx.e(paramInt1, paramInt2, paramString, paramm);
      }
      return;
      if (this.fti.contains(paramm))
      {
        this.fti.remove(paramm);
        y.d("MicroMsg.WalletNetSceneMgr", "has find forcescenes ");
      }
      else
      {
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.c.b
 * JD-Core Version:    0.7.0.1
 */