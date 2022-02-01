package com.tencent.mm.plugin.luckymoney.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.wallet_core.c.w;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.f;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class aa
  implements i, e
{
  private f EAz;
  private Context mContext;
  private String mProcessName;
  private HashSet<q> nkO;
  private HashSet<q> nkP;
  private Set<Integer> nkQ;
  private s tipDialog;
  
  public aa(Context paramContext, f paramf)
  {
    AppMethodBeat.i(65230);
    this.EAz = null;
    this.nkO = new HashSet();
    this.nkP = new HashSet();
    this.tipDialog = null;
    this.nkQ = new HashSet();
    this.mContext = paramContext;
    this.EAz = paramf;
    AppMethodBeat.o(65230);
  }
  
  private void k(q paramq)
  {
    AppMethodBeat.i(65238);
    if ((paramq != null) && ((paramq instanceof w))) {
      ((w)paramq).setProcessName(this.mProcessName);
    }
    AppMethodBeat.o(65238);
  }
  
  public final void addSceneEndListener(int paramInt)
  {
    AppMethodBeat.i(65234);
    this.nkQ.add(Integer.valueOf(paramInt));
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(paramInt, this);
    AppMethodBeat.o(65234);
  }
  
  public final void b(q paramq, boolean paramBoolean)
  {
    AppMethodBeat.i(65231);
    k(paramq);
    this.nkO.add(paramq);
    if ((paramBoolean) && ((this.tipDialog == null) || ((this.tipDialog != null) && (!this.tipDialog.isShowing()))))
    {
      if (this.tipDialog != null) {
        this.tipDialog.dismiss();
      }
      this.tipDialog = com.tencent.mm.ui.base.h.a(this.mContext, this.mContext.getString(a.i.loading_tips), false, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(65228);
          aa.this.forceCancel();
          AppMethodBeat.o(65228);
        }
      });
    }
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(paramq, 0);
    AppMethodBeat.o(65231);
  }
  
  public final void doSceneProgress(q paramq, boolean paramBoolean)
  {
    AppMethodBeat.i(65232);
    Log.d("MicroMsg.WalletNetSceneMgr", "isShowProgress ".concat(String.valueOf(paramBoolean)));
    k(paramq);
    this.nkP.add(paramq);
    if ((paramBoolean) && ((this.tipDialog == null) || ((this.tipDialog != null) && (!this.tipDialog.isShowing()))))
    {
      if (this.tipDialog != null) {
        this.tipDialog.dismiss();
      }
      this.tipDialog = com.tencent.mm.ui.base.h.a(this.mContext, 3, this.mContext.getString(a.i.loading_tips), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(65229);
          if ((aa.a(aa.this) != null) && (aa.b(aa.this).isEmpty()))
          {
            aa.a(aa.this).dismiss();
            paramAnonymousDialogInterface = aa.c(aa.this).iterator();
            while (paramAnonymousDialogInterface.hasNext())
            {
              q localq = (q)paramAnonymousDialogInterface.next();
              com.tencent.mm.kernel.h.aHH();
              com.tencent.mm.kernel.h.aHF().kcd.a(localq);
            }
            aa.c(aa.this).clear();
          }
          AppMethodBeat.o(65229);
        }
      });
    }
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(paramq, 0);
    AppMethodBeat.o(65232);
  }
  
  public final void eOG()
  {
    AppMethodBeat.i(65239);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    AppMethodBeat.o(65239);
  }
  
  public final void forceCancel()
  {
    AppMethodBeat.i(65233);
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    Iterator localIterator = this.nkO.iterator();
    q localq;
    while (localIterator.hasNext())
    {
      localq = (q)localIterator.next();
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.a(localq);
    }
    localIterator = this.nkP.iterator();
    while (localIterator.hasNext())
    {
      localq = (q)localIterator.next();
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.a(localq);
    }
    this.nkO.clear();
    this.nkP.clear();
    AppMethodBeat.o(65233);
  }
  
  public final boolean isProcessing()
  {
    AppMethodBeat.i(65237);
    if ((this.nkP.isEmpty()) && (this.nkO.isEmpty()))
    {
      AppMethodBeat.o(65237);
      return false;
    }
    AppMethodBeat.o(65237);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(65236);
    int i;
    if (this.nkP.contains(paramq))
    {
      this.nkP.remove(paramq);
      Log.d("MicroMsg.WalletNetSceneMgr", "has find scene ");
      i = 1;
    }
    for (;;)
    {
      if ((this.nkP.isEmpty()) && (this.nkO.isEmpty())) {
        if (this.tipDialog != null)
        {
          this.tipDialog.dismiss();
          this.tipDialog = null;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        if ((i != 0) && (this.EAz != null)) {
          this.EAz.onSceneEnd(paramInt1, paramInt2, paramString, paramq, bool);
        }
        AppMethodBeat.o(65236);
        return;
        if (!this.nkO.contains(paramq)) {
          break label154;
        }
        this.nkO.remove(paramq);
        Log.d("MicroMsg.WalletNetSceneMgr", "has find forcescenes ");
        i = 1;
        break;
      }
      label154:
      i = 0;
    }
  }
  
  public final void removeSceneEndListener(int paramInt)
  {
    AppMethodBeat.i(65235);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(paramInt, this);
    this.nkQ.remove(Integer.valueOf(paramInt));
    if (this.nkQ.isEmpty())
    {
      forceCancel();
      this.EAz = null;
      this.mContext = null;
    }
    AppMethodBeat.o(65235);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.aa
 * JD-Core Version:    0.7.0.1
 */