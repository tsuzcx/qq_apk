package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.io.FileInputStream;
import java.util.zip.ZipInputStream;

final class b$2
  implements Runnable
{
  b$2(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(128926);
    long l = bo.aoy();
    int i = -1;
    try
    {
      int j = k.a(new ZipInputStream(new FileInputStream(new File("/sdcard/test_zip.zip"))), "/sdcard/test_zip/");
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("[ZIP]", "unzip Java ex=%s", new Object[] { localException });
      }
    }
    ab.i("[ZIP]", "unzip Java %d, cost %d", new Object[] { Integer.valueOf(i), Long.valueOf(bo.aoy() - l) });
    AppMethodBeat.o(128926);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.b.2
 * JD-Core Version:    0.7.0.1
 */