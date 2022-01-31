package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.luggage.sdk.b.a.c.3;
import com.tencent.luggage.sdk.b.a.c.4;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.j;
import java.io.File;
import java.io.IOException;

public final class l
{
  public static boolean CM(String paramString)
  {
    AppMethodBeat.i(131477);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(131477);
      return true;
    }
    AppMethodBeat.o(131477);
    return false;
  }
  
  public static String a(com.tencent.luggage.sdk.b.a.c paramc, String paramString, boolean paramBoolean)
  {
    Object localObject = null;
    AppMethodBeat.i(131476);
    if (paramc == null)
    {
      AppMethodBeat.o(131476);
      return null;
    }
    String str = paramc.getAppId();
    if (bo.isNullOrNil(paramString))
    {
      if (!paramBoolean)
      {
        AppMethodBeat.o(131476);
        return null;
      }
      paramc.runOnUiThread(new c.3(paramc));
      paramc.a(new c.4(paramc));
      if (paramc.wX() == null)
      {
        ab.e("MicroMsg.ShareHelper", "tryToGetLocalFilePath NULL fs with appId(%s)", new Object[] { paramc.getAppId() });
        AppMethodBeat.o(131476);
        return null;
      }
      paramString = paramc.wX().zh("share_" + System.currentTimeMillis());
      if (paramString == null)
      {
        AppMethodBeat.o(131476);
        return null;
      }
      paramString = j.p(paramString.dQJ());
      localObject = new Bundle();
      ((Bundle)localObject).putInt("action", 1);
      f.a("com.tencent.mm", (Parcelable)localObject, a.class, null);
      paramc.wp().a(new l.1(paramString, paramc));
      paramc = "delayLoadFile://".concat(String.valueOf(paramString));
      AppMethodBeat.o(131476);
      return paramc;
    }
    if (paramString.startsWith("wxfile://"))
    {
      paramString = paramc.wX().zg(paramString);
      paramc = (com.tencent.luggage.sdk.b.a.c)localObject;
      if (paramString != null) {
        if (paramString.exists()) {
          break label248;
        }
      }
      label248:
      for (paramc = (com.tencent.luggage.sdk.b.a.c)localObject;; paramc = "file://" + paramString.getAbsolutePath())
      {
        AppMethodBeat.o(131476);
        return paramc;
      }
    }
    if ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://")))
    {
      localObject = AppBrandLocalMediaObjectManager.genMediaFilePath(str, "share_" + System.currentTimeMillis());
      paramc = t.j(paramc.wj(), paramString);
      if ((paramc != null) && (!paramc.isRecycled()))
      {
        try
        {
          d.a(paramc, 100, Bitmap.CompressFormat.PNG, (String)localObject, true);
          if ((paramc != null) && (!paramc.isRecycled()))
          {
            ab.i("MicroMsg.ShareHelper", "bitmap recycle %s", new Object[] { paramc });
            paramc.recycle();
          }
        }
        catch (IOException paramString)
        {
          for (;;)
          {
            ab.w("MicroMsg.ShareHelper", "save temp bitmap to file failed, . exception : %s", new Object[] { paramString });
            if ((paramc != null) && (!paramc.isRecycled()))
            {
              ab.i("MicroMsg.ShareHelper", "bitmap recycle %s", new Object[] { paramc });
              paramc.recycle();
            }
          }
        }
        finally
        {
          if ((paramc == null) || (paramc.isRecycled())) {
            break label471;
          }
          ab.i("MicroMsg.ShareHelper", "bitmap recycle %s", new Object[] { paramc });
          paramc.recycle();
          AppMethodBeat.o(131476);
        }
        paramc = "file://".concat(String.valueOf(localObject));
        AppMethodBeat.o(131476);
        return paramc;
      }
      label471:
      AppMethodBeat.o(131476);
      return null;
    }
    AppMethodBeat.o(131476);
    return null;
  }
  
  public static String getRealPath(String paramString)
  {
    AppMethodBeat.i(131478);
    if (paramString == null)
    {
      AppMethodBeat.o(131478);
      return null;
    }
    if (paramString.startsWith("file://"))
    {
      paramString = paramString.replace("file://", "");
      AppMethodBeat.o(131478);
      return paramString;
    }
    if (paramString.startsWith("delayLoadFile://"))
    {
      paramString = paramString.replace("delayLoadFile://", "");
      AppMethodBeat.o(131478);
      return paramString;
    }
    AppMethodBeat.o(131478);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.l
 * JD-Core Version:    0.7.0.1
 */