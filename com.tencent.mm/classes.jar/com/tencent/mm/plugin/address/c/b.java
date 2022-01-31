package com.tencent.mm.plugin.address.c;

import android.app.Dialog;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class b
  implements f
{
  HashSet<m> gKK;
  HashSet<m> gKL;
  Dialog gKM;
  private a gKZ;
  private Set<Integer> gLa;
  private Context mContext;
  
  public b(Context paramContext, a parama)
  {
    AppMethodBeat.i(16779);
    this.gKZ = null;
    this.gKK = new HashSet();
    this.gKL = new HashSet();
    this.gKM = null;
    this.gLa = new HashSet();
    this.mContext = paramContext;
    this.gKZ = parama;
    AppMethodBeat.o(16779);
  }
  
  public final void addSceneEndListener(int paramInt)
  {
    AppMethodBeat.i(16781);
    this.gLa.add(Integer.valueOf(paramInt));
    aw.Rc().a(paramInt, this);
    AppMethodBeat.o(16781);
  }
  
  public final void e(m paramm)
  {
    AppMethodBeat.i(16780);
    ab.d("MicroMsg.WalletNetSceneMgr", "isShowProgress true");
    this.gKL.add(paramm);
    if ((this.gKM == null) || ((this.gKM != null) && (!this.gKM.isShowing())))
    {
      if (this.gKM != null) {
        this.gKM.dismiss();
      }
      this.gKM = h.b(this.mContext, "", true, new b.1(this));
    }
    aw.Rc().a(paramm, 0);
    AppMethodBeat.o(16780);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    int i = 1;
    AppMethodBeat.i(16783);
    if (this.gKL.contains(paramm))
    {
      this.gKL.remove(paramm);
      ab.d("MicroMsg.WalletNetSceneMgr", "has find scene ");
    }
    for (;;)
    {
      if ((this.gKL.isEmpty()) && (this.gKK.isEmpty()) && (this.gKM != null))
      {
        this.gKM.dismiss();
        this.gKM = null;
      }
      if ((i != 0) && (this.gKZ != null)) {
        this.gKZ.c(paramInt1, paramInt2, paramString, paramm);
      }
      AppMethodBeat.o(16783);
      return;
      if (this.gKK.contains(paramm))
      {
        this.gKK.remove(paramm);
        ab.d("MicroMsg.WalletNetSceneMgr", "has find forcescenes ");
      }
      else
      {
        i = 0;
      }
    }
  }
  
  public final void removeSceneEndListener(int paramInt)
  {
    AppMethodBeat.i(16782);
    aw.Rc().b(paramInt, this);
    this.gLa.remove(Integer.valueOf(paramInt));
    if (this.gLa.isEmpty())
    {
      if (this.gKM != null)
      {
        this.gKM.dismiss();
        this.gKM = null;
      }
      Iterator localIterator = this.gKK.iterator();
      m localm;
      while (localIterator.hasNext())
      {
        localm = (m)localIterator.next();
        aw.Rc().a(localm);
      }
      localIterator = this.gKL.iterator();
      while (localIterator.hasNext())
      {
        localm = (m)localIterator.next();
        aw.Rc().a(localm);
      }
      this.gKK.clear();
      this.gKL.clear();
      this.gKZ = null;
      this.mContext = null;
    }
    AppMethodBeat.o(16782);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.c.b
 * JD-Core Version:    0.7.0.1
 */