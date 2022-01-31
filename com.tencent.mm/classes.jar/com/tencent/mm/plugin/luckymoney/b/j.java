package com.tencent.mm.plugin.luckymoney.b;

import android.content.Context;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.s;
import com.tencent.mm.wallet_core.d.e;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class j
  implements com.tencent.mm.ah.f, e
{
  private String dIA;
  HashSet<m> fti = new HashSet();
  HashSet<m> ftj = new HashSet();
  private Set<Integer> fty = new HashSet();
  private com.tencent.mm.wallet_core.d.f lQE = null;
  private Context mContext;
  com.tencent.mm.ui.base.p tipDialog = null;
  
  public j(Context paramContext, com.tencent.mm.wallet_core.d.f paramf)
  {
    this.mContext = paramContext;
    this.lQE = paramf;
  }
  
  private void k(m paramm)
  {
    if ((paramm != null) && ((paramm instanceof s))) {
      ((s)paramm).dIA = this.dIA;
    }
  }
  
  public final void a(m paramm, boolean paramBoolean)
  {
    k(paramm);
    this.fti.add(paramm);
    if ((paramBoolean) && ((this.tipDialog == null) || ((this.tipDialog != null) && (!this.tipDialog.isShowing()))))
    {
      if (this.tipDialog != null) {
        this.tipDialog.dismiss();
      }
      this.tipDialog = h.b(this.mContext, this.mContext.getString(a.i.loading_tips), false, new j.1(this));
    }
    g.DQ();
    g.DO().dJT.a(paramm, 0);
  }
  
  public final void b(m paramm, boolean paramBoolean)
  {
    y.d("MicroMsg.WalletNetSceneMgr", "isShowProgress " + paramBoolean);
    k(paramm);
    this.ftj.add(paramm);
    if ((paramBoolean) && ((this.tipDialog == null) || ((this.tipDialog != null) && (!this.tipDialog.isShowing()))))
    {
      if (this.tipDialog != null) {
        this.tipDialog.dismiss();
      }
      this.tipDialog = h.b(this.mContext, this.mContext.getString(a.i.loading_tips), true, new j.2(this));
    }
    g.DQ();
    g.DO().dJT.a(paramm, 0);
  }
  
  public final void bfH()
  {
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    Iterator localIterator = this.fti.iterator();
    m localm;
    while (localIterator.hasNext())
    {
      localm = (m)localIterator.next();
      g.DQ();
      g.DO().dJT.c(localm);
    }
    localIterator = this.ftj.iterator();
    while (localIterator.hasNext())
    {
      localm = (m)localIterator.next();
      g.DQ();
      g.DO().dJT.c(localm);
    }
    this.fti.clear();
    this.ftj.clear();
  }
  
  public final boolean bfI()
  {
    return (!this.ftj.isEmpty()) || (!this.fti.isEmpty());
  }
  
  public final void bfJ()
  {
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
  }
  
  public final void kh(int paramInt)
  {
    this.fty.add(Integer.valueOf(paramInt));
    g.DQ();
    g.DO().dJT.a(paramInt, this);
  }
  
  public final void ki(int paramInt)
  {
    g.DQ();
    g.DO().dJT.b(paramInt, this);
    this.fty.remove(Integer.valueOf(paramInt));
    if (this.fty.isEmpty())
    {
      bfH();
      this.lQE = null;
      this.mContext = null;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    int i;
    if (this.ftj.contains(paramm))
    {
      this.ftj.remove(paramm);
      y.d("MicroMsg.WalletNetSceneMgr", "has find scene ");
      i = 1;
    }
    for (;;)
    {
      if ((this.ftj.isEmpty()) && (this.fti.isEmpty())) {
        if (this.tipDialog != null)
        {
          this.tipDialog.dismiss();
          this.tipDialog = null;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        if ((i != 0) && (this.lQE != null)) {
          this.lQE.b(paramInt1, paramInt2, paramString, paramm, bool);
        }
        return;
        if (!this.fti.contains(paramm)) {
          break label144;
        }
        this.fti.remove(paramm);
        y.d("MicroMsg.WalletNetSceneMgr", "has find forcescenes ");
        i = 1;
        break;
      }
      label144:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.b.j
 * JD-Core Version:    0.7.0.1
 */