package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.appstorage.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.io.FileInputStream;
import java.util.zip.ZipInputStream;

final class b$2
  implements Runnable
{
  b$2(b paramb) {}
  
  public final void run()
  {
    long l = bk.UY();
    int i = -1;
    try
    {
      int j = i.a(new ZipInputStream(new FileInputStream(new File("/sdcard/test_zip.zip"))), "/sdcard/test_zip/");
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("[ZIP]", "unzip Java ex=%s", new Object[] { localException });
      }
    }
    y.i("[ZIP]", "unzip Java %d, cost %d", new Object[] { Integer.valueOf(i), Long.valueOf(bk.UY() - l) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.b.2
 * JD-Core Version:    0.7.0.1
 */