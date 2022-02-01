package com.tencent.mm.plugin.luckymoney.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.wallet_core.c.e;
import com.tencent.mm.wallet_core.c.f;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class z
  implements com.tencent.mm.am.h, e
{
  private f Ktp;
  private Context mContext;
  private String mProcessName;
  private HashSet<p> qhX;
  private HashSet<p> qhY;
  private Set<Integer> qhZ;
  private com.tencent.mm.ui.base.w tipDialog;
  
  public z(Context paramContext, f paramf)
  {
    AppMethodBeat.i(65230);
    this.Ktp = null;
    this.qhX = new HashSet();
    this.qhY = new HashSet();
    this.tipDialog = null;
    this.qhZ = new HashSet();
    this.mContext = paramContext;
    this.Ktp = paramf;
    AppMethodBeat.o(65230);
  }
  
  private void k(p paramp)
  {
    AppMethodBeat.i(65238);
    if ((paramp != null) && ((paramp instanceof com.tencent.mm.wallet_core.model.w))) {
      ((com.tencent.mm.wallet_core.model.w)paramp).setProcessName(this.mProcessName);
    }
    AppMethodBeat.o(65238);
  }
  
  public final void addSceneEndListener(int paramInt)
  {
    AppMethodBeat.i(65234);
    this.qhZ.add(Integer.valueOf(paramInt));
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(paramInt, this);
    AppMethodBeat.o(65234);
  }
  
  public final void b(p paramp, boolean paramBoolean)
  {
    AppMethodBeat.i(65231);
    k(paramp);
    this.qhX.add(paramp);
    if ((paramBoolean) && ((this.tipDialog == null) || ((this.tipDialog != null) && (!this.tipDialog.isShowing()))))
    {
      if (this.tipDialog != null) {
        this.tipDialog.dismiss();
      }
      this.tipDialog = k.a(this.mContext, this.mContext.getString(a.i.loading_tips), false, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(65228);
          z.this.forceCancel();
          AppMethodBeat.o(65228);
        }
      });
    }
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(paramp, 0);
    AppMethodBeat.o(65231);
  }
  
  public final void doSceneProgress(p paramp, boolean paramBoolean)
  {
    AppMethodBeat.i(65232);
    Log.d("MicroMsg.WalletNetSceneMgr", "isShowProgress ".concat(String.valueOf(paramBoolean)));
    k(paramp);
    this.qhY.add(paramp);
    if ((paramBoolean) && ((this.tipDialog == null) || ((this.tipDialog != null) && (!this.tipDialog.isShowing()))))
    {
      if (this.tipDialog != null) {
        this.tipDialog.dismiss();
      }
      this.tipDialog = k.a(this.mContext, 3, this.mContext.getString(a.i.loading_tips), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(65229);
          if ((z.a(z.this) != null) && (z.b(z.this).isEmpty()))
          {
            z.a(z.this).dismiss();
            paramAnonymousDialogInterface = z.c(z.this).iterator();
            while (paramAnonymousDialogInterface.hasNext())
            {
              p localp = (p)paramAnonymousDialogInterface.next();
              com.tencent.mm.kernel.h.baF();
              com.tencent.mm.kernel.h.baD().mCm.a(localp);
            }
            z.c(z.this).clear();
          }
          AppMethodBeat.o(65229);
        }
      });
    }
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(paramp, 0);
    AppMethodBeat.o(65232);
  }
  
  public final void fXe()
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
    Iterator localIterator = this.qhX.iterator();
    p localp;
    while (localIterator.hasNext())
    {
      localp = (p)localIterator.next();
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a(localp);
    }
    localIterator = this.qhY.iterator();
    while (localIterator.hasNext())
    {
      localp = (p)localIterator.next();
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a(localp);
    }
    this.qhX.clear();
    this.qhY.clear();
    AppMethodBeat.o(65233);
  }
  
  public final boolean isProcessing()
  {
    AppMethodBeat.i(65237);
    if ((this.qhY.isEmpty()) && (this.qhX.isEmpty()))
    {
      AppMethodBeat.o(65237);
      return false;
    }
    AppMethodBeat.o(65237);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(65236);
    int i;
    if (this.qhY.contains(paramp))
    {
      this.qhY.remove(paramp);
      Log.d("MicroMsg.WalletNetSceneMgr", "has find scene ");
      i = 1;
    }
    for (;;)
    {
      if ((this.qhY.isEmpty()) && (this.qhX.isEmpty())) {
        if (this.tipDialog != null)
        {
          this.tipDialog.dismiss();
          this.tipDialog = null;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        if ((i != 0) && (this.Ktp != null)) {
          this.Ktp.onSceneEnd(paramInt1, paramInt2, paramString, paramp, bool);
        }
        AppMethodBeat.o(65236);
        return;
        if (!this.qhX.contains(paramp)) {
          break label154;
        }
        this.qhX.remove(paramp);
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
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(paramInt, this);
    this.qhZ.remove(Integer.valueOf(paramInt));
    if (this.qhZ.isEmpty())
    {
      forceCancel();
      this.Ktp = null;
      this.mContext = null;
    }
    AppMethodBeat.o(65235);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.z
 * JD-Core Version:    0.7.0.1
 */