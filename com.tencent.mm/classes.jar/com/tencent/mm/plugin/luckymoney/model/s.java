package com.tencent.mm.plugin.luckymoney.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.u;
import com.tencent.mm.wallet_core.d.e;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class s
  implements com.tencent.mm.ai.f, e
{
  HashSet<m> gKK;
  HashSet<m> gKL;
  private Set<Integer> gLa;
  private Context mContext;
  private String mProcessName;
  private com.tencent.mm.wallet_core.d.f oou;
  com.tencent.mm.ui.base.p tipDialog;
  
  public s(Context paramContext, com.tencent.mm.wallet_core.d.f paramf)
  {
    AppMethodBeat.i(42341);
    this.oou = null;
    this.gKK = new HashSet();
    this.gKL = new HashSet();
    this.tipDialog = null;
    this.gLa = new HashSet();
    this.mContext = paramContext;
    this.oou = paramf;
    AppMethodBeat.o(42341);
  }
  
  private void j(m paramm)
  {
    AppMethodBeat.i(142026);
    if ((paramm != null) && ((paramm instanceof u))) {
      ((u)paramm).setProcessName(this.mProcessName);
    }
    AppMethodBeat.o(142026);
  }
  
  public final void a(m paramm, boolean paramBoolean)
  {
    AppMethodBeat.i(42342);
    j(paramm);
    this.gKK.add(paramm);
    if ((paramBoolean) && ((this.tipDialog == null) || ((this.tipDialog != null) && (!this.tipDialog.isShowing()))))
    {
      if (this.tipDialog != null) {
        this.tipDialog.dismiss();
      }
      this.tipDialog = h.b(this.mContext, this.mContext.getString(2131301086), false, new s.1(this));
    }
    g.RM();
    g.RK().eHt.a(paramm, 0);
    AppMethodBeat.o(42342);
  }
  
  public final void addSceneEndListener(int paramInt)
  {
    AppMethodBeat.i(42345);
    this.gLa.add(Integer.valueOf(paramInt));
    g.RM();
    g.RK().eHt.a(paramInt, this);
    AppMethodBeat.o(42345);
  }
  
  public final void bNp()
  {
    AppMethodBeat.i(42349);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    AppMethodBeat.o(42349);
  }
  
  public final void doSceneProgress(m paramm, boolean paramBoolean)
  {
    AppMethodBeat.i(42343);
    ab.d("MicroMsg.WalletNetSceneMgr", "isShowProgress ".concat(String.valueOf(paramBoolean)));
    j(paramm);
    this.gKL.add(paramm);
    if ((paramBoolean) && ((this.tipDialog == null) || ((this.tipDialog != null) && (!this.tipDialog.isShowing()))))
    {
      if (this.tipDialog != null) {
        this.tipDialog.dismiss();
      }
      this.tipDialog = h.a(this.mContext, 3, this.mContext.getString(2131301086), true, new s.2(this));
    }
    g.RM();
    g.RK().eHt.a(paramm, 0);
    AppMethodBeat.o(42343);
  }
  
  public final void forceCancel()
  {
    AppMethodBeat.i(42344);
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    Iterator localIterator = this.gKK.iterator();
    m localm;
    while (localIterator.hasNext())
    {
      localm = (m)localIterator.next();
      g.RM();
      g.RK().eHt.a(localm);
    }
    localIterator = this.gKL.iterator();
    while (localIterator.hasNext())
    {
      localm = (m)localIterator.next();
      g.RM();
      g.RK().eHt.a(localm);
    }
    this.gKK.clear();
    this.gKL.clear();
    AppMethodBeat.o(42344);
  }
  
  public final boolean isProcessing()
  {
    AppMethodBeat.i(42348);
    if ((this.gKL.isEmpty()) && (this.gKK.isEmpty()))
    {
      AppMethodBeat.o(42348);
      return false;
    }
    AppMethodBeat.o(42348);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(42347);
    int i;
    if (this.gKL.contains(paramm))
    {
      this.gKL.remove(paramm);
      ab.d("MicroMsg.WalletNetSceneMgr", "has find scene ");
      i = 1;
    }
    for (;;)
    {
      if ((this.gKL.isEmpty()) && (this.gKK.isEmpty())) {
        if (this.tipDialog != null)
        {
          this.tipDialog.dismiss();
          this.tipDialog = null;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        if ((i != 0) && (this.oou != null)) {
          this.oou.onSceneEnd(paramInt1, paramInt2, paramString, paramm, bool);
        }
        AppMethodBeat.o(42347);
        return;
        if (!this.gKK.contains(paramm)) {
          break label154;
        }
        this.gKK.remove(paramm);
        ab.d("MicroMsg.WalletNetSceneMgr", "has find forcescenes ");
        i = 1;
        break;
      }
      label154:
      i = 0;
    }
  }
  
  public final void removeSceneEndListener(int paramInt)
  {
    AppMethodBeat.i(42346);
    g.RM();
    g.RK().eHt.b(paramInt, this);
    this.gLa.remove(Integer.valueOf(paramInt));
    if (this.gLa.isEmpty())
    {
      forceCancel();
      this.oou = null;
      this.mContext = null;
    }
    AppMethodBeat.o(42346);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.s
 * JD-Core Version:    0.7.0.1
 */