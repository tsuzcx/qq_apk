package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class b$1
  implements Runnable
{
  b$1(b paramb) {}
  
  public final void run()
  {
    long l = bk.UY();
    y.i("[ZIP]", "unzip JNI %d, cost %d", new Object[] { Integer.valueOf(ZipJNI.unzip("/sdcard/test_zip.zip", "/sdcard/test_zip/", null)), Long.valueOf(bk.UY() - l) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.b.1
 * JD-Core Version:    0.7.0.1
 */