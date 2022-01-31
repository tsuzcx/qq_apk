package com.tencent.mm.plugin.appbrand;

import android.os.Looper;
import com.tencent.mm.plugin.appbrand.o.m;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class u$1
  implements Runnable
{
  public final void run()
  {
    long l = bk.UY();
    new m().init();
    y.d("MicroMsg.AppBrandXWebPreloader", "x509 init cost %d", new Object[] { Long.valueOf(bk.UY() - l) });
    u.access$000();
    Looper.myLooper().quit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.1
 * JD-Core Version:    0.7.0.1
 */