package com.tencent.mm.plugin.appbrand.m;

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
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;

public final class d
  implements DialogInterface
{
  private DialogInterface.OnCancelListener XL;
  private av jkD;
  public android.arch.a.c.a<Context, k.a> lUC;
  private k.a lUD;
  private boolean mCanceled = false;
  private boolean mDismissed = false;
  
  public final d a(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(147345);
    this.XL = paramOnCancelListener;
    if (this.lUD != null) {
      this.lUD.setOnCancelListener(this.XL);
    }
    AppMethodBeat.o(147345);
    return this;
  }
  
  public final void aa(final AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(147344);
    if (!aq.isMainThread())
    {
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(147342);
          d.this.aa(paramAppBrandRuntime);
          AppMethodBeat.o(147342);
        }
      });
      AppMethodBeat.o(147344);
      return;
    }
    this.jkD = new av(Looper.getMainLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(147343);
        if ((d.a(d.this)) || (d.b(d.this)))
        {
          AppMethodBeat.o(147343);
          return false;
        }
        Object localObject1 = com.tencent.mm.sdk.f.a.jq(paramAppBrandRuntime.mContext);
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
            paramAppBrandRuntime.iDP.b((k)localObject2);
            d.a(d.this, (k.a)localObject2);
            AppMethodBeat.o(147343);
            return false;
          }
        }
      }
    }, false);
    this.jkD.az(500L, 500L);
    AppMethodBeat.o(147344);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(147346);
    this.mCanceled = true;
    if (this.lUD != null)
    {
      this.lUD.cancel();
      AppMethodBeat.o(147346);
      return;
    }
    if (this.XL != null) {
      this.XL.onCancel(this);
    }
    AppMethodBeat.o(147346);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(147347);
    this.mDismissed = true;
    if (this.lUD != null) {
      this.lUD.dismiss();
    }
    AppMethodBeat.o(147347);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m.d
 * JD-Core Version:    0.7.0.1
 */