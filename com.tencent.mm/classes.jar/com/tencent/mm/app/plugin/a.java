package com.tencent.mm.app.plugin;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.protocal.protobuf.ewg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a
  implements com.tencent.mm.am.h
{
  String brD;
  private a hkr;
  boolean hks;
  Runnable hkt;
  Runnable hku;
  private AtomicBoolean hkv;
  Context mContext;
  int mScene;
  private w tipDialog;
  
  public a(Context paramContext, int paramInt, String paramString, a parama)
  {
    AppMethodBeat.i(239330);
    this.hkv = new AtomicBoolean(false);
    this.mContext = paramContext;
    this.hkr = parama;
    this.tipDialog = null;
    this.mScene = paramInt;
    this.brD = paramString;
    AppMethodBeat.o(239330);
  }
  
  private void a(ewg paramewg)
  {
    AppMethodBeat.i(239332);
    if (this.hkr != null) {
      this.hkr.a(this.mContext, paramewg);
    }
    AppMethodBeat.o(239332);
  }
  
  private void aDM()
  {
    AppMethodBeat.i(239334);
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    AppMethodBeat.o(239334);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(239354);
    Log.d("MicroMsg.AddContact", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2 + "," + paramString);
    if ((!(paramp instanceof com.tencent.mm.app.plugin.a.a)) || (paramp.getType() != 4790))
    {
      Log.w("MicroMsg.AddContact", "not expected scene,  type = " + paramp.getType());
      AppMethodBeat.o(239354);
      return;
    }
    if (this.hks)
    {
      if (this.hku != null) {
        MMHandlerThread.removeRunnable(this.hku);
      }
      aDM();
    }
    MMHandlerThread.removeRunnable(this.hkt);
    com.tencent.mm.kernel.h.baD().mCm.b(4790, this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      a((ewg)c.c.b(((com.tencent.mm.app.plugin.a.a)paramp).rr.otC));
      AppMethodBeat.o(239354);
      return;
    }
    if (!Util.isNullOrNil(paramString)) {
      k.c(this.mContext, paramString, "", true);
    }
    a(null);
    AppMethodBeat.o(239354);
  }
  
  public static abstract interface a
  {
    public abstract void a(Context paramContext, ewg paramewg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.app.plugin.a
 * JD-Core Version:    0.7.0.1
 */