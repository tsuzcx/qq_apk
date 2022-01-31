package com.tencent.mm.plugin.appbrand.k;

import android.arch.a.c.a;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.widget.b.g;
import com.tencent.mm.plugin.appbrand.widget.b.k;
import com.tencent.mm.plugin.appbrand.widget.b.k.a;
import com.tencent.mm.plugin.appbrand.widget.b.l;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;

public final class d
  implements DialogInterface
{
  private DialogInterface.OnCancelListener NW;
  private ap gIs;
  public a<Context, k.a> irS;
  private k.a irT;
  private boolean mDismissed = false;
  private boolean qM = false;
  
  public final void C(final i parami)
  {
    AppMethodBeat.i(102147);
    if (!al.isMainThread())
    {
      al.d(new d.1(this, parami));
      AppMethodBeat.o(102147);
      return;
    }
    this.gIs = new ap(Looper.getMainLooper(), new ap.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(102146);
        if ((d.a(d.this)) || (d.b(d.this)))
        {
          AppMethodBeat.o(102146);
          return false;
        }
        Object localObject2 = parami.getContext();
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = parami.mContext;
        }
        if (d.c(d.this) == null) {}
        for (localObject1 = null;; localObject1 = (k.a)d.c(d.this).apply(localObject1))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new g(parami.getContext());
          }
          ((k.a)localObject2).setOnCancelListener(d.d(d.this));
          ((k.a)localObject2).setCancelable(true);
          ((k.a)localObject2).setCanceledOnTouchOutside(false);
          parami.gPE.b((k)localObject2);
          d.a(d.this, (k.a)localObject2);
          AppMethodBeat.o(102146);
          return false;
        }
      }
    }, false);
    this.gIs.ag(500L, 500L);
    AppMethodBeat.o(102147);
  }
  
  public final d a(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(102148);
    this.NW = paramOnCancelListener;
    if (this.irT != null) {
      this.irT.setOnCancelListener(this.NW);
    }
    AppMethodBeat.o(102148);
    return this;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(102149);
    this.qM = true;
    if (this.irT != null)
    {
      this.irT.cancel();
      AppMethodBeat.o(102149);
      return;
    }
    if (this.NW != null) {
      this.NW.onCancel(this);
    }
    AppMethodBeat.o(102149);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(102150);
    this.mDismissed = true;
    if (this.irT != null) {
      this.irT.dismiss();
    }
    AppMethodBeat.o(102150);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.k.d
 * JD-Core Version:    0.7.0.1
 */