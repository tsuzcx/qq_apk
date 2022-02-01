package com.tencent.mm.plugin.appbrand.q;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Looper;
import androidx.a.a.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.widget.dialog.j;
import com.tencent.mm.plugin.appbrand.widget.dialog.n;
import com.tencent.mm.plugin.appbrand.widget.dialog.n.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.r;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.system.AndroidContextUtil;

public final class c
  implements DialogInterface
{
  private boolean mCanceled = false;
  private boolean mDismissed = false;
  private DialogInterface.OnCancelListener mOnCancelListener;
  private MTimerHandler qaM;
  public a<Context, n.a> tmg;
  n.a tmh;
  int tmi;
  
  public final c a(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(147345);
    this.mOnCancelListener = paramOnCancelListener;
    if (this.tmh != null) {
      this.tmh.setOnCancelListener(this.mOnCancelListener);
    }
    AppMethodBeat.o(147345);
    return this;
  }
  
  public final void ap(final AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(147344);
    if (!MMHandlerThread.isMainThread())
    {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(147342);
          c.this.ap(paramAppBrandRuntime);
          AppMethodBeat.o(147342);
        }
      });
      AppMethodBeat.o(147344);
      return;
    }
    this.qaM = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
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
          for (n.a locala = null;; locala = (n.a)c.c(c.this).apply(localObject1))
          {
            Object localObject2 = locala;
            if (locala == null) {
              localObject2 = new j((Context)localObject1);
            }
            ((n.a)localObject2).setOnCancelListener(c.d(c.this));
            ((n.a)localObject2).setCancelable(true);
            ((n.a)localObject2).setCanceledOnTouchOutside(false);
            paramAppBrandRuntime.pmu.b((n)localObject2);
            c.a(c.this, (n.a)localObject2);
            if ((c.e(c.this) > 0) && ((c.f(c.this) instanceof j))) {
              ((j)c.f(c.this)).setProgress(c.e(c.this));
            }
            AppMethodBeat.o(147343);
            return false;
          }
        }
      }
    }, false);
    this.qaM.startTimer(500L);
    AppMethodBeat.o(147344);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(147346);
    this.mCanceled = true;
    if (this.tmh != null)
    {
      this.tmh.cancel();
      AppMethodBeat.o(147346);
      return;
    }
    if (this.mOnCancelListener != null) {
      this.mOnCancelListener.onCancel(this);
    }
    AppMethodBeat.o(147346);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(147347);
    this.mDismissed = true;
    if (this.tmh != null) {
      this.tmh.dismiss();
    }
    AppMethodBeat.o(147347);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.c
 * JD-Core Version:    0.7.0.1
 */