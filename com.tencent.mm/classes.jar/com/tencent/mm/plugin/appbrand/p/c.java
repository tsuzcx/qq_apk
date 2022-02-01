package com.tencent.mm.plugin.appbrand.p;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Looper;
import androidx.a.a.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.widget.dialog.f;
import com.tencent.mm.plugin.appbrand.widget.dialog.j;
import com.tencent.mm.plugin.appbrand.widget.dialog.j.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.l;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.system.AndroidContextUtil;

public final class c
  implements DialogInterface
{
  private DialogInterface.OnCancelListener fs;
  private boolean mCanceled = false;
  private boolean mDismissed = false;
  private MTimerHandler ndv;
  public a<Context, j.a> qhv;
  j.a qhw;
  int qhx;
  
  public final c a(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(147345);
    this.fs = paramOnCancelListener;
    if (this.qhw != null) {
      this.qhw.setOnCancelListener(this.fs);
    }
    AppMethodBeat.o(147345);
    return this;
  }
  
  public final void ab(final AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(147344);
    if (!MMHandlerThread.isMainThread())
    {
      MMHandlerThread.postToMainThread(new c.1(this, paramAppBrandRuntime));
      AppMethodBeat.o(147344);
      return;
    }
    this.ndv = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(147343);
        if ((c.a(c.this)) || (c.b(c.this)))
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
          if (c.c(c.this) == null) {}
          for (j.a locala = null;; locala = (j.a)c.c(c.this).apply(localObject1))
          {
            Object localObject2 = locala;
            if (locala == null) {
              localObject2 = new f((Context)localObject1);
            }
            ((j.a)localObject2).setOnCancelListener(c.d(c.this));
            ((j.a)localObject2).setCancelable(true);
            ((j.a)localObject2).setCanceledOnTouchOutside(false);
            paramAppBrandRuntime.msX.a((j)localObject2);
            c.a(c.this, (j.a)localObject2);
            if ((c.e(c.this) > 0) && ((c.f(c.this) instanceof f))) {
              ((f)c.f(c.this)).setProgress(c.e(c.this));
            }
            AppMethodBeat.o(147343);
            return false;
          }
        }
      }
    }, false);
    this.ndv.startTimer(500L);
    AppMethodBeat.o(147344);
  }
  
  public final void b(a<Context, j.a> parama)
  {
    this.qhv = parama;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(147346);
    this.mCanceled = true;
    if (this.qhw != null)
    {
      this.qhw.cancel();
      AppMethodBeat.o(147346);
      return;
    }
    if (this.fs != null) {
      this.fs.onCancel(this);
    }
    AppMethodBeat.o(147346);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(147347);
    this.mDismissed = true;
    if (this.qhw != null) {
      this.qhw.dismiss();
    }
    AppMethodBeat.o(147347);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.p.c
 * JD-Core Version:    0.7.0.1
 */