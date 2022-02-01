package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.vending.g.d.b;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public final class r
{
  public static boolean Nb(String paramString)
  {
    AppMethodBeat.i(46813);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(46813);
      return true;
    }
    AppMethodBeat.o(46813);
    return false;
  }
  
  public static String Nc(String paramString)
  {
    AppMethodBeat.i(46814);
    if (paramString == null)
    {
      AppMethodBeat.o(46814);
      return null;
    }
    if (paramString.startsWith("file://"))
    {
      paramString = paramString.replace("file://", "");
      AppMethodBeat.o(46814);
      return paramString;
    }
    if (paramString.startsWith("delayLoadFile://"))
    {
      paramString = paramString.replace("delayLoadFile://", "");
      AppMethodBeat.o(46814);
      return paramString;
    }
    AppMethodBeat.o(46814);
    return paramString;
  }
  
  public static String a(com.tencent.luggage.sdk.b.a.c paramc, final String paramString, boolean paramBoolean)
  {
    Object localObject = null;
    AppMethodBeat.i(46812);
    if (paramc == null)
    {
      AppMethodBeat.o(46812);
      return null;
    }
    String str = paramc.getAppId();
    if (bs.isNullOrNil(paramString))
    {
      if (!paramBoolean)
      {
        AppMethodBeat.o(46812);
        return null;
      }
      paramc.CV();
      if (paramc.DH() == null)
      {
        ac.e("MicroMsg.ShareHelper", "tryToGetLocalFilePath NULL fs with appId(%s)", new Object[] { paramc.getAppId() });
        AppMethodBeat.o(46812);
        return null;
      }
      paramString = paramc.DH().IU("share_" + System.nanoTime());
      if (paramString == null)
      {
        AppMethodBeat.o(46812);
        return null;
      }
      paramString = q.B(paramString.fxV());
      if (paramc.Q(com.tencent.luggage.game.page.d.class) != null)
      {
        a(paramc, paramString, paramc.bqN());
        AppMethodBeat.o(46812);
        return paramString;
      }
      localObject = new Bundle();
      ((Bundle)localObject).putInt("action", 1);
      com.tencent.mm.ipcinvoker.h.a("com.tencent.mm", (Parcelable)localObject, a.class, null);
      paramc.CT().a(com.tencent.mm.vending.h.d.Jri, new d.b() {});
      paramc = "delayLoadFile://".concat(String.valueOf(paramString));
      AppMethodBeat.o(46812);
      return paramc;
    }
    if (paramString.startsWith("wxfile://"))
    {
      paramString = paramc.DH().IS(paramString);
      paramc = (com.tencent.luggage.sdk.b.a.c)localObject;
      if (paramString != null) {
        if (paramString.exists()) {
          break label256;
        }
      }
      label256:
      for (paramc = (com.tencent.luggage.sdk.b.a.c)localObject;; paramc = "file://" + q.B(paramString.fxV()))
      {
        AppMethodBeat.o(46812);
        return paramc;
      }
    }
    if ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://")))
    {
      localObject = AppBrandLocalMediaObjectManager.genMediaFilePath(str, "share_" + System.nanoTime());
      paramc = x.k(paramc.CO(), paramString);
      if ((paramc != null) && (!paramc.isRecycled()))
      {
        try
        {
          f.a(paramc, 100, Bitmap.CompressFormat.PNG, (String)localObject, true);
          if ((paramc != null) && (!paramc.isRecycled()))
          {
            ac.i("MicroMsg.ShareHelper", "bitmap recycle %s", new Object[] { paramc });
            paramc.recycle();
          }
        }
        catch (IOException paramString)
        {
          for (;;)
          {
            ac.w("MicroMsg.ShareHelper", "save temp bitmap to file failed, . exception : %s", new Object[] { paramString });
            if ((paramc != null) && (!paramc.isRecycled()))
            {
              ac.i("MicroMsg.ShareHelper", "bitmap recycle %s", new Object[] { paramc });
              paramc.recycle();
            }
          }
        }
        finally
        {
          if ((paramc == null) || (paramc.isRecycled())) {
            break label483;
          }
          ac.i("MicroMsg.ShareHelper", "bitmap recycle %s", new Object[] { paramc });
          paramc.recycle();
          AppMethodBeat.o(46812);
        }
        paramc = "file://".concat(String.valueOf(localObject));
        AppMethodBeat.o(46812);
        return paramc;
      }
      label483:
      AppMethodBeat.o(46812);
      return null;
    }
    AppMethodBeat.o(46812);
    return null;
  }
  
  static void a(aa paramaa, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(186767);
    if (paramBitmap != null) {}
    try
    {
      if (!paramBitmap.isRecycled())
      {
        long l = System.currentTimeMillis();
        f.a(paramBitmap, 100, Bitmap.CompressFormat.JPEG, paramString, true);
        ac.i("MicroMsg.ShareHelper", "saveFile(appId : %s, pageView : %s, saveFileCost : %sms)", new Object[] { paramaa.getAppId(), Integer.valueOf(paramaa.hashCode()), Long.valueOf(System.currentTimeMillis() - l) });
        paramaa = new Bundle();
        paramaa.putString("delay_load_img_path", "file://".concat(String.valueOf(paramString)));
        new r.1(l, paramaa).run();
      }
      return;
    }
    catch (Exception paramaa)
    {
      ac.w("MicroMsg.ShareHelper", "save temp bitmap to file failed, . exception : %s", new Object[] { paramaa });
      return;
    }
    finally
    {
      if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
      {
        ac.i("MicroMsg.ShareHelper", "bitmap recycle %s", new Object[] { paramBitmap });
        paramBitmap.recycle();
      }
      AppMethodBeat.o(186767);
    }
    AppMethodBeat.o(186767);
  }
  
  public static void a(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt2, String paramString9, String paramString10, int paramInt3, String paramString11, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(180276);
    if (bs.isNullOrNil(paramString1))
    {
      ac.e("MicroMsg.ShareHelper", "appId is Null!");
      AppMethodBeat.o(180276);
      return;
    }
    localObject1 = "";
    try
    {
      localObject2 = com.tencent.mm.compatible.util.p.encode(bs.nullAsNil(paramString6), "UTF-8");
      localObject1 = localObject2;
    }
    catch (UnsupportedEncodingException paramString10)
    {
      try
      {
        str = com.tencent.mm.compatible.util.p.encode(bs.nullAsNil(paramString7), "UTF-8");
        localObject2 = str;
      }
      catch (UnsupportedEncodingException paramString10)
      {
        try
        {
          paramString10 = com.tencent.mm.compatible.util.p.encode(bs.nullAsNil(paramString10), "UTF-8");
        }
        catch (UnsupportedEncodingException paramString10)
        {
          try
          {
            for (;;)
            {
              Object localObject2;
              String str;
              paramString11 = com.tencent.mm.compatible.util.p.encode(bs.nullAsNil(paramString11), "UTF-8");
              try
              {
                str = com.tencent.mm.compatible.util.p.encode(bs.nullAsNil(paramString5), "UTF-8");
                paramString5 = str;
              }
              catch (UnsupportedEncodingException localUnsupportedEncodingException3)
              {
                for (;;)
                {
                  ac.e("MicroMsg.ShareHelper", "encode shareTitle error!");
                }
              }
              paramInt3 += 1000;
              ac.d("MicroMsg.ShareHelper", "stev report(%s), appId %s, scene %s, sceneNote %s, sessionId %s, currentPath %s, currentTitle %s,shareTitle %s, sharePath %s, shareActionId %s, destinationUserCount %s, destinationUserName %s, appServiceType %s, thumbIconUrl %s, appVersion %d , destinationType %d", new Object[] { Integer.valueOf(14077), paramString1, Integer.valueOf(paramInt1), paramString2, paramString3, paramString7, paramString8, paramString5, paramString6, paramString9, Integer.valueOf(paramInt2), paramString4, Integer.valueOf(paramInt3), paramString11, Integer.valueOf(paramInt4), Integer.valueOf(paramInt5) });
              com.tencent.mm.plugin.report.service.h.wUl.f(14077, new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, paramString3, localObject2, paramString8, paramString5, localObject1, paramString9, "", Integer.valueOf(paramInt2), paramString4, paramString10, Integer.valueOf(paramInt3), paramString11, Integer.valueOf(paramInt4), Integer.valueOf(paramInt5) });
              AppMethodBeat.o(180276);
              return;
              localUnsupportedEncodingException1 = localUnsupportedEncodingException1;
              ac.e("MicroMsg.ShareHelper", "encode share page path error!");
              continue;
              localUnsupportedEncodingException2 = localUnsupportedEncodingException2;
              ac.e("MicroMsg.ShareHelper", "encode current page path error!");
              continue;
              paramString10 = paramString10;
              ac.e("MicroMsg.ShareHelper", "encode current html url error!");
              paramString10 = "";
            }
          }
          catch (UnsupportedEncodingException paramString11)
          {
            for (;;)
            {
              ac.e("MicroMsg.ShareHelper", "encode thumb Icon url error!");
              paramString11 = "";
            }
          }
        }
      }
    }
    localObject2 = "";
  }
  
  public static StringBuilder bC(String paramString, int paramInt)
  {
    AppMethodBeat.i(180275);
    int i = ((com.tencent.mm.plugin.appbrand.appstorage.a.a)g.ab(com.tencent.mm.plugin.appbrand.appstorage.a.a.class)).Ji(paramString);
    StringBuilder localStringBuilder = new StringBuilder("1_");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(ah.dg(com.tencent.mm.b.p.getString(i)));
    localStringBuilder.append("_");
    localStringBuilder.append(bs.aNx());
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt);
    AppMethodBeat.o(180275);
    return localStringBuilder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.r
 * JD-Core Version:    0.7.0.1
 */