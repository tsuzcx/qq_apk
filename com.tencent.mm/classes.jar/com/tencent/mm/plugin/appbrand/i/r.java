package com.tencent.mm.plugin.appbrand.i;

import android.os.Environment;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;

public final class r
{
  private static String gII;
  
  public static String alA()
  {
    if (!bk.bl(gII)) {
      return gII;
    }
    try
    {
      Object localObject = (IPCString)XIPCInvoker.a("com.tencent.mm", IPCVoid.dHo, r.a.class);
      if (localObject == null)
      {
        String str2 = Environment.getExternalStorageDirectory().getAbsolutePath();
        localObject = str2;
        if (!str2.endsWith("/")) {
          localObject = str2 + "/";
        }
        return (String)localObject + "Tencent/MicroMsg/wxajscache";
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.V8CodeCachePathRetriever", "retrieve ipc ex = %s", new Object[] { localException });
        str1 = null;
      }
      String str1 = str1.value;
      gII = str1;
      return str1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.i.r
 * JD-Core Version:    0.7.0.1
 */