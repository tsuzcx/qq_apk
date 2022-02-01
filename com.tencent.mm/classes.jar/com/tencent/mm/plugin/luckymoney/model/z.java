package com.tencent.mm.plugin.luckymoney.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.w;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.f;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class z
  implements i, e
{
  HashSet<com.tencent.mm.ak.q> ksO;
  HashSet<com.tencent.mm.ak.q> ksP;
  private Set<Integer> ktd;
  private Context mContext;
  private String mProcessName;
  com.tencent.mm.ui.base.q tipDialog;
  private f yWw;
  
  public z(Context paramContext, f paramf)
  {
    AppMethodBeat.i(65230);
    this.yWw = null;
    this.ksO = new HashSet();
    this.ksP = new HashSet();
    this.tipDialog = null;
    this.ktd = new HashSet();
    this.mContext = paramContext;
    this.yWw = paramf;
    AppMethodBeat.o(65230);
  }
  
  private void k(com.tencent.mm.ak.q paramq)
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
    this.ktd.add(Integer.valueOf(paramInt));
    g.aAi();
    g.aAg().hqi.a(paramInt, this);
    AppMethodBeat.o(65234);
  }
  
  public final void b(com.tencent.mm.ak.q paramq, boolean paramBoolean)
  {
    AppMethodBeat.i(65231);
    k(paramq);
    this.ksO.add(paramq);
    if ((paramBoolean) && ((this.tipDialog == null) || ((this.tipDialog != null) && (!this.tipDialog.isShowing()))))
    {
      if (this.tipDialog != null) {
        this.tipDialog.dismiss();
      }
      this.tipDialog = h.a(this.mContext, this.mContext.getString(2131762446), false, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(65228);
          z.this.forceCancel();
          AppMethodBeat.o(65228);
        }
      });
    }
    g.aAi();
    g.aAg().hqi.a(paramq, 0);
    AppMethodBeat.o(65231);
  }
  
  public final void doSceneProgress(com.tencent.mm.ak.q paramq, boolean paramBoolean)
  {
    AppMethodBeat.i(65232);
    Log.d("MicroMsg.WalletNetSceneMgr", "isShowProgress ".concat(String.valueOf(paramBoolean)));
    k(paramq);
    this.ksP.add(paramq);
    if ((paramBoolean) && ((this.tipDialog == null) || ((this.tipDialog != null) && (!this.tipDialog.isShowing()))))
    {
      if (this.tipDialog != null) {
        this.tipDialog.dismiss();
      }
      this.tipDialog = h.a(this.mContext, 3, this.mContext.getString(2131762446), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(65229);
          if ((z.this.tipDialog != null) && (z.this.ksO.isEmpty()))
          {
            z.this.tipDialog.dismiss();
            paramAnonymousDialogInterface = z.this.ksP.iterator();
            while (paramAnonymousDialogInterface.hasNext())
            {
              com.tencent.mm.ak.q localq = (com.tencent.mm.ak.q)paramAnonymousDialogInterface.next();
              g.aAi();
              g.aAg().hqi.a(localq);
            }
            z.this.ksP.clear();
          }
          AppMethodBeat.o(65229);
        }
      });
    }
    g.aAi();
    g.aAg().hqi.a(paramq, 0);
    AppMethodBeat.o(65232);
  }
  
  public final void efi()
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
    Iterator localIterator = this.ksO.iterator();
    com.tencent.mm.ak.q localq;
    while (localIterator.hasNext())
    {
      localq = (com.tencent.mm.ak.q)localIterator.next();
      g.aAi();
      g.aAg().hqi.a(localq);
    }
    localIterator = this.ksP.iterator();
    while (localIterator.hasNext())
    {
      localq = (com.tencent.mm.ak.q)localIterator.next();
      g.aAi();
      g.aAg().hqi.a(localq);
    }
    this.ksO.clear();
    this.ksP.clear();
    AppMethodBeat.o(65233);
  }
  
  public final boolean isProcessing()
  {
    AppMethodBeat.i(65237);
    if ((this.ksP.isEmpty()) && (this.ksO.isEmpty()))
    {
      AppMethodBeat.o(65237);
      return false;
    }
    AppMethodBeat.o(65237);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(65236);
    int i;
    if (this.ksP.contains(paramq))
    {
      this.ksP.remove(paramq);
      Log.d("MicroMsg.WalletNetSceneMgr", "has find scene ");
      i = 1;
    }
    for (;;)
    {
      if ((this.ksP.isEmpty()) && (this.ksO.isEmpty())) {
        if (this.tipDialog != null)
        {
          this.tipDialog.dismiss();
          this.tipDialog = null;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        if ((i != 0) && (this.yWw != null)) {
          this.yWw.onSceneEnd(paramInt1, paramInt2, paramString, paramq, bool);
        }
        AppMethodBeat.o(65236);
        return;
        if (!this.ksO.contains(paramq)) {
          break label154;
        }
        this.ksO.remove(paramq);
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
    g.aAi();
    g.aAg().hqi.b(paramInt, this);
    this.ktd.remove(Integer.valueOf(paramInt));
    if (this.ktd.isEmpty())
    {
      forceCancel();
      this.yWw = null;
      this.mContext = null;
    }
    AppMethodBeat.o(65235);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.z
 * JD-Core Version:    0.7.0.1
 */