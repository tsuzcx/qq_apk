package com.tencent.mm.plugin.appbrand.n;

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
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;

public final class d
  implements DialogInterface
{
  private DialogInterface.OnCancelListener VW;
  private au iRv;
  public android.arch.a.c.a<Context, k.a> lvt;
  private k.a lvu;
  private boolean mCanceled = false;
  private boolean mDismissed = false;
  
  public final d a(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(147345);
    this.VW = paramOnCancelListener;
    if (this.lvu != null) {
      this.lvu.setOnCancelListener(this.VW);
    }
    AppMethodBeat.o(147345);
    return this;
  }
  
  public final void ag(final AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(147344);
    if (!ap.isMainThread())
    {
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(147342);
          d.this.ag(paramAppBrandRuntime);
          AppMethodBeat.o(147342);
        }
      });
      AppMethodBeat.o(147344);
      return;
    }
    this.iRv = new au(Looper.getMainLooper(), new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(147343);
        if ((d.a(d.this)) || (d.b(d.this)))
        {
          AppMethodBeat.o(147343);
          return false;
        }
        Object localObject1 = com.tencent.mm.sdk.f.a.jg(paramAppBrandRuntime.mContext);
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
            paramAppBrandRuntime.iky.b((k)localObject2);
            d.a(d.this, (k.a)localObject2);
            AppMethodBeat.o(147343);
            return false;
          }
        }
      }
    }, false);
    this.iRv.au(500L, 500L);
    AppMethodBeat.o(147344);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(147346);
    this.mCanceled = true;
    if (this.lvu != null)
    {
      this.lvu.cancel();
      AppMethodBeat.o(147346);
      return;
    }
    if (this.VW != null) {
      this.VW.onCancel(this);
    }
    AppMethodBeat.o(147346);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(147347);
    this.mDismissed = true;
    if (this.lvu != null) {
      this.lvu.dismiss();
    }
    AppMethodBeat.o(147347);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n.d
 * JD-Core Version:    0.7.0.1
 */