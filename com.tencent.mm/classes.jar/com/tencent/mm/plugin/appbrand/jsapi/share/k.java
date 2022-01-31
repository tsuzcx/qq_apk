package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.io.IOException;

public final class k
{
  public static String a(q paramq, String paramString, boolean paramBoolean)
  {
    if (paramq == null) {}
    String str;
    do
    {
      do
      {
        do
        {
          do
          {
            return null;
            str = paramq.mAppId;
            if (!bk.bl(paramString)) {
              break;
            }
          } while (!paramBoolean);
          paramq.a(1, null, new Object[0]);
          paramString = AppBrandLocalMediaObjectManager.genMediaFilePath(str, "share_" + System.currentTimeMillis());
          g.a(str, new k.1(str, paramq, paramString));
          return "delayLoadFile://" + paramString;
          if (!paramString.startsWith("wxfile://")) {
            break;
          }
          paramq = paramq.Zl().rx(paramString);
        } while ((paramq == null) || (!paramq.exists()));
        return "file://" + paramq.getAbsolutePath();
      } while ((paramString.startsWith("http://")) || (paramString.startsWith("https://")));
      str = AppBrandLocalMediaObjectManager.genMediaFilePath(str, "share_" + System.currentTimeMillis());
      paramq = p.i(paramq.getRuntime(), paramString);
    } while ((paramq == null) || (paramq.isRecycled()));
    try
    {
      c.a(paramq, 100, Bitmap.CompressFormat.PNG, str, true);
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        y.w("MicroMsg.ShareHelper", "save temp bitmap to file failed, . exception : %s", new Object[] { paramString });
        if ((paramq != null) && (!paramq.isRecycled())) {
          paramq.recycle();
        }
      }
    }
    finally
    {
      if ((paramq == null) || (paramq.isRecycled())) {
        break label292;
      }
      paramq.recycle();
    }
    return "file://" + str;
  }
  
  public static String getRealPath(String paramString)
  {
    String str;
    if (paramString == null) {
      str = null;
    }
    do
    {
      return str;
      if (paramString.startsWith("file://")) {
        return paramString.replace("file://", "");
      }
      str = paramString;
    } while (!paramString.startsWith("delayLoadFile://"));
    return paramString.replace("delayLoadFile://", "");
  }
  
  public static boolean uB(String paramString)
  {
    return bk.bl(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.k
 * JD-Core Version:    0.7.0.1
 */