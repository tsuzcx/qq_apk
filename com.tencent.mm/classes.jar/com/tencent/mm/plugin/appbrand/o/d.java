package com.tencent.mm.plugin.appbrand.o;

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
  private DialogInterface.OnCancelListener Vb;
  private av irp;
  public android.arch.a.c.a<Context, k.a> kTO;
  private k.a kTP;
  private boolean mCanceled = false;
  private boolean mDismissed = false;
  
  public final d a(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(147345);
    this.Vb = paramOnCancelListener;
    if (this.kTP != null) {
      this.kTP.setOnCancelListener(this.Vb);
    }
    AppMethodBeat.o(147345);
    return this;
  }
  
  public final void ag(final AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(147344);
    if (!aq.isMainThread())
    {
      aq.f(new Runnable()
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
    this.irp = new av(Looper.getMainLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(147343);
        if ((d.a(d.this)) || (d.b(d.this)))
        {
          AppMethodBeat.o(147343);
          return false;
        }
        Object localObject1 = com.tencent.mm.sdk.f.a.iV(paramAppBrandRuntime.mContext);
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
            paramAppBrandRuntime.hKb.b((k)localObject2);
            d.a(d.this, (k.a)localObject2);
            AppMethodBeat.o(147343);
            return false;
          }
        }
      }
    }, false);
    this.irp.av(500L, 500L);
    AppMethodBeat.o(147344);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(147346);
    this.mCanceled = true;
    if (this.kTP != null)
    {
      this.kTP.cancel();
      AppMethodBeat.o(147346);
      return;
    }
    if (this.Vb != null) {
      this.Vb.onCancel(this);
    }
    AppMethodBeat.o(147346);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(147347);
    this.mDismissed = true;
    if (this.kTP != null) {
      this.kTP.dismiss();
    }
    AppMethodBeat.o(147347);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.d
 * JD-Core Version:    0.7.0.1
 */