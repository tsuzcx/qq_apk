package com.tencent.mm.chatroom.d;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.chatroom.ui.a.i;
import com.tencent.mm.protocal.protobuf.akp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import java.util.concurrent.atomic.AtomicBoolean;

public final class h
  implements com.tencent.mm.am.h
{
  public boolean hks;
  public Runnable hkt;
  public Runnable hku;
  private AtomicBoolean hkv;
  private a lyg;
  private Context mContext;
  private w tipDialog;
  
  public h(Context paramContext, a parama)
  {
    AppMethodBeat.i(241421);
    this.hkv = new AtomicBoolean(false);
    this.mContext = paramContext;
    this.lyg = parama;
    this.tipDialog = null;
    AppMethodBeat.o(241421);
  }
  
  private void a(boolean paramBoolean, akp paramakp, int paramInt)
  {
    AppMethodBeat.i(241423);
    if (this.lyg != null) {
      this.lyg.b(paramBoolean, paramakp, paramInt);
    }
    AppMethodBeat.o(241423);
  }
  
  private void onStop()
  {
    AppMethodBeat.i(241426);
    if (this.hks)
    {
      if (this.hku != null) {
        MMHandlerThread.removeRunnable(this.hku);
      }
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
    }
    MMHandlerThread.removeRunnable(this.hkt);
    com.tencent.mm.kernel.h.baD().mCm.b(6217, this);
    AppMethodBeat.o(241426);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(241441);
    Log.i("MicroMsg.CheckFinderManagerSwithFun", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2 + "," + paramString);
    if ((!(paramp instanceof m)) || (paramp.getType() != 6217))
    {
      Log.w("MicroMsg.CheckFinderManagerSwithFun", "not expected scene,  type = " + paramp.getType());
      AppMethodBeat.o(241441);
      return;
    }
    onStop();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      a(true, (akp)c.c.b(((m)paramp).rr.otC), 0);
      AppMethodBeat.o(241441);
      return;
    }
    if (!Util.isNullOrNil(paramString)) {
      k.c(this.mContext, paramString, "", true);
    }
    a(false, null, paramInt2);
    AppMethodBeat.o(241441);
  }
  
  public static abstract interface a
  {
    public abstract void b(boolean paramBoolean, akp paramakp, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.h
 * JD-Core Version:    0.7.0.1
 */