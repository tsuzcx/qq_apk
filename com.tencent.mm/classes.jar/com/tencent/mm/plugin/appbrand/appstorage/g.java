package com.tencent.mm.plugin.appbrand.appstorage;

import android.os.Build.VERSION;
import android.system.Os;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;

final class g
{
  static boolean bd(String paramString1, String paramString2)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      try
      {
        long l = bk.UY();
        new g.a();
        Os.rename(paramString1, paramString2);
        y.d("MicroMsg.AppBrand.FileMove", "move, os rename works, cost = %d", new Object[] { Long.valueOf(bk.UY() - l) });
        return true;
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.AppBrand.FileMove", "move, os rename exp = %s", new Object[] { bk.j(localException) });
      }
    }
    return new File(paramString1).renameTo(new File(paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.g
 * JD-Core Version:    0.7.0.1
 */