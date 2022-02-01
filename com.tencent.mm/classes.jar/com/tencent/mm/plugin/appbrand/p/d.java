package com.tencent.mm.plugin.appbrand.p;

import android.arch.a.c.a;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.widget.dialog.g;
import com.tencent.mm.plugin.appbrand.widget.dialog.k;
import com.tencent.mm.plugin.appbrand.widget.dialog.k.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.system.AndroidContextUtil;

public final class d
  implements DialogInterface
{
  private DialogInterface.OnCancelListener XY;
  private MTimerHandler klF;
  private boolean mCanceled = false;
  private boolean mDismissed = false;
  public a<Context, k.a> ngL;
  k.a ngM;
  int ngN;
  
  public final d a(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(147345);
    this.XY = paramOnCancelListener;
    if (this.ngM != null) {
      this.ngM.setOnCancelListener(this.XY);
    }
    AppMethodBeat.o(147345);
    return this;
  }
  
  public final void ab(final AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(147344);
    if (!MMHandlerThread.isMainThread())
    {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(147342);
          d.this.ab(paramAppBrandRuntime);
          AppMethodBeat.o(147342);
        }
      });
      AppMethodBeat.o(147344);
      return;
    }
    this.klF = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(147343);
        if ((d.a(d.this)) || (d.b(d.this)))
        {
          AppMethodBeat.o(147343);
          return false;
        }
        Object localObject1 = AndroidContextUtil.castActivityOrNull(paramAppBrandRuntime.mContext);
        if (localObject1 == null) {
          localObject1 = paramAppBrandRuntime.mContext;
        }
        for (;;)
        {
          if (d.c(d.this) == null) {}
          for (k.a locala = null;; locala = (k.a)d.c(d.this).apply(localObject1))
          {
            Object localObject2 = locala;
            if (locala == null) {
              localObject2 = new g((Context)localObject1);
            }
            ((k.a)localObject2).setOnCancelListener(d.d(d.this));
            ((k.a)localObject2).setCancelable(true);
            ((k.a)localObject2).setCanceledOnTouchOutside(false);
            paramAppBrandRuntime.jCK.b((k)localObject2);
            d.a(d.this, (k.a)localObject2);
            if ((d.e(d.this) > 0) && ((d.f(d.this) instanceof g))) {
              ((g)d.f(d.this)).setProgress(d.e(d.this));
            }
            AppMethodBeat.o(147343);
            return false;
          }
        }
      }
    }, false);
    this.klF.startTimer(500L);
    AppMethodBeat.o(147344);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(147346);
    this.mCanceled = true;
    if (this.ngM != null)
    {
      this.ngM.cancel();
      AppMethodBeat.o(147346);
      return;
    }
    if (this.XY != null) {
      this.XY.onCancel(this);
    }
    AppMethodBeat.o(147346);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(147347);
    this.mDismissed = true;
    if (this.ngM != null) {
      this.ngM.dismiss();
    }
    AppMethodBeat.o(147347);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.p.d
 * JD-Core Version:    0.7.0.1
 */