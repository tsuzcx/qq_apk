package com.tencent.mm.plugin.appbrand.config;

import android.database.ContentObserver;
import android.os.Handler;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;

public final class e$1
  extends ContentObserver
{
  public e$1(e parame, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  public final boolean deliverSelfNotifications()
  {
    return true;
  }
  
  public final void onChange(boolean paramBoolean)
  {
    super.onChange(paramBoolean);
    y.i("MicroMsg.AppBrandDeviceOrientationHandler", "hy: lock orientation settings changed! request now");
    if ((e.a(this.fOp) != null) && (e.b(this.fOp).get() != null))
    {
      y.i("MicroMsg.AppBrandDeviceOrientationHandler", "hy: need change");
      this.fOp.a(e.b(e.a(this.fOp)), null);
      e.c(this.fOp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.e.1
 * JD-Core Version:    0.7.0.1
 */