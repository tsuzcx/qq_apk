package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vending.g.d.b;
import com.tencent.mm.vfs.e;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public final class r
{
  public static boolean Qy(String paramString)
  {
    AppMethodBeat.i(46813);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(46813);
      return true;
    }
    AppMethodBeat.o(46813);
    return false;
  }
  
  public static String Qz(String paramString)
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
    if (bt.isNullOrNil(paramString))
    {
      if (!paramBoolean)
      {
        AppMethodBeat.o(46812);
        return null;
      }
      paramc.Eu();
      if (paramc.Fg() == null)
      {
        ad.e("MicroMsg.ShareHelper", "tryToGetLocalFilePath NULL fs with appId(%s)", new Object[] { paramc.getAppId() });
        AppMethodBeat.o(46812);
        return null;
      }
      paramString = paramc.Fg().Ml("share_" + System.nanoTime());
      if (paramString == null)
      {
        AppMethodBeat.o(46812);
        return null;
      }
      paramString = com.tencent.mm.vfs.q.B(paramString.fOK());
      if (paramc.Q(com.tencent.luggage.game.page.d.class) != null)
      {
        a(paramc, paramString, paramc.buN());
        AppMethodBeat.o(46812);
        return paramString;
      }
      localObject = new Bundle();
      ((Bundle)localObject).putInt("action", 1);
      h.a("com.tencent.mm", (Parcelable)localObject, a.class, null);
      paramc.Es().a(com.tencent.mm.vending.h.d.LiN, new d.b() {});
      paramc = "delayLoadFile://".concat(String.valueOf(paramString));
      AppMethodBeat.o(46812);
      return paramc;
    }
    if (paramString.startsWith("wxfile://"))
    {
      paramString = paramc.Fg().Mj(paramString);
      paramc = (com.tencent.luggage.sdk.b.a.c)localObject;
      if (paramString != null) {
        if (paramString.exists()) {
          break label256;
        }
      }
      label256:
      for (paramc = (com.tencent.luggage.sdk.b.a.c)localObject;; paramc = "file://" + com.tencent.mm.vfs.q.B(paramString.fOK()))
      {
        AppMethodBeat.o(46812);
        return paramc;
      }
    }
    if ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://")))
    {
      localObject = AppBrandLocalMediaObjectManager.genMediaFilePath(str, "share_" + System.nanoTime());
      paramc = x.k(paramc.En(), paramString);
      if ((paramc != null) && (!paramc.isRecycled()))
      {
        try
        {
          com.tencent.mm.sdk.platformtools.g.a(paramc, 100, Bitmap.CompressFormat.PNG, (String)localObject, true);
          if ((paramc != null) && (!paramc.isRecycled()))
          {
            ad.i("MicroMsg.ShareHelper", "bitmap recycle %s", new Object[] { paramc });
            paramc.recycle();
          }
        }
        catch (IOException paramString)
        {
          for (;;)
          {
            ad.w("MicroMsg.ShareHelper", "save temp bitmap to file failed, . exception : %s", new Object[] { paramString });
            if ((paramc != null) && (!paramc.isRecycled()))
            {
              ad.i("MicroMsg.ShareHelper", "bitmap recycle %s", new Object[] { paramc });
              paramc.recycle();
            }
          }
        }
        finally
        {
          if ((paramc == null) || (paramc.isRecycled())) {
            break label483;
          }
          ad.i("MicroMsg.ShareHelper", "bitmap recycle %s", new Object[] { paramc });
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
    AppMethodBeat.i(188528);
    if (paramBitmap != null) {}
    try
    {
      if (!paramBitmap.isRecycled())
      {
        long l = System.currentTimeMillis();
        com.tencent.mm.sdk.platformtools.g.a(paramBitmap, 100, Bitmap.CompressFormat.JPEG, paramString, true);
        ad.i("MicroMsg.ShareHelper", "saveFile(appId : %s, pageView : %s, saveFileCost : %sms)", new Object[] { paramaa.getAppId(), Integer.valueOf(paramaa.hashCode()), Long.valueOf(System.currentTimeMillis() - l) });
        paramaa = new Bundle();
        paramaa.putString("delay_load_img_path", "file://".concat(String.valueOf(paramString)));
        new r.1(l, paramaa).run();
      }
      return;
    }
    catch (Exception paramaa)
    {
      ad.w("MicroMsg.ShareHelper", "save temp bitmap to file failed, . exception : %s", new Object[] { paramaa });
      return;
    }
    finally
    {
      if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
      {
        ad.i("MicroMsg.ShareHelper", "bitmap recycle %s", new Object[] { paramBitmap });
        paramBitmap.recycle();
      }
      AppMethodBeat.o(188528);
    }
    AppMethodBeat.o(188528);
  }
  
  public static void a(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt2, String paramString9, String paramString10, int paramInt3, String paramString11, int paramInt4, int paramInt5, String paramString12)
  {
    AppMethodBeat.i(188529);
    if (bt.isNullOrNil(paramString1))
    {
      ad.e("MicroMsg.ShareHelper", "appId is Null!");
      AppMethodBeat.o(188529);
      return;
    }
    localObject1 = "";
    try
    {
      localObject2 = com.tencent.mm.compatible.util.q.encode(bt.nullAsNil(paramString6), "UTF-8");
      localObject1 = localObject2;
    }
    catch (UnsupportedEncodingException paramString10)
    {
      try
      {
        str1 = com.tencent.mm.compatible.util.q.encode(bt.nullAsNil(paramString7), "UTF-8");
        localObject2 = str1;
      }
      catch (UnsupportedEncodingException paramString10)
      {
        try
        {
          str1 = com.tencent.mm.compatible.util.q.encode(bt.nullAsNil(paramString10), "UTF-8");
        }
        catch (UnsupportedEncodingException paramString10)
        {
          try
          {
            paramString11 = com.tencent.mm.compatible.util.q.encode(bt.nullAsNil(paramString11), "UTF-8");
          }
          catch (UnsupportedEncodingException paramString10)
          {
            try
            {
              for (;;)
              {
                Object localObject2;
                String str1;
                str3 = com.tencent.mm.compatible.util.q.encode(bt.nullAsNil(paramString5), "UTF-8");
                paramInt3 += 1000;
                paramString5 = "";
                try
                {
                  String str4 = com.tencent.mm.compatible.util.q.encode(bt.nullAsNil(paramString12), "UTF-8");
                  paramString10 = str4;
                  paramString5 = str4;
                  if (str4.length() >= 1024)
                  {
                    paramString5 = str4;
                    paramString10 = str4.substring(0, 1024);
                  }
                }
                catch (UnsupportedEncodingException paramString10)
                {
                  for (;;)
                  {
                    String str2;
                    ad.e("MicroMsg.ShareHelper", "encode messageExtraData error!");
                    paramString10 = paramString5;
                  }
                }
                ad.d("MicroMsg.ShareHelper", "stev report(%s), appId %s, scene %s, sceneNote %s, sessionId %s, currentPath %s, currentTitle %s,shareTitle %s, sharePath %s, shareActionId %s, destinationUserCount %s, destinationUserName %s, appServiceType %s, thumbIconUrl %s, appVersion %d , destinationType %d, messageExtraData %s", new Object[] { Integer.valueOf(14077), paramString1, Integer.valueOf(paramInt1), paramString2, paramString3, paramString7, paramString8, str3, paramString6, paramString9, Integer.valueOf(paramInt2), paramString4, Integer.valueOf(paramInt3), paramString11, Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), paramString12 });
                com.tencent.mm.plugin.report.service.g.yhR.f(14077, new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, paramString3, localObject2, paramString8, str3, localObject1, paramString9, "", Integer.valueOf(paramInt2), paramString4, str1, Integer.valueOf(paramInt3), paramString11, Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), paramString10 });
                AppMethodBeat.o(188529);
                return;
                localUnsupportedEncodingException1 = localUnsupportedEncodingException1;
                ad.e("MicroMsg.ShareHelper", "encode share page path error!");
                continue;
                localUnsupportedEncodingException2 = localUnsupportedEncodingException2;
                ad.e("MicroMsg.ShareHelper", "encode current page path error!");
                continue;
                paramString10 = paramString10;
                ad.e("MicroMsg.ShareHelper", "encode current html url error!");
                str2 = "";
                continue;
                paramString10 = paramString10;
                ad.e("MicroMsg.ShareHelper", "encode thumb Icon url error!");
                paramString11 = "";
              }
            }
            catch (UnsupportedEncodingException paramString10)
            {
              for (;;)
              {
                ad.e("MicroMsg.ShareHelper", "encode shareTitle error!");
                String str3 = paramString5;
              }
            }
          }
        }
      }
    }
    localObject2 = "";
  }
  
  public static StringBuilder bF(String paramString, int paramInt)
  {
    AppMethodBeat.i(180275);
    int i = ((com.tencent.mm.plugin.appbrand.appstorage.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.appstorage.a.a.class)).Mz(paramString);
    StringBuilder localStringBuilder = new StringBuilder("1_");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(ai.ee(com.tencent.mm.b.p.getString(i)));
    localStringBuilder.append("_");
    localStringBuilder.append(bt.aQJ());
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt);
    AppMethodBeat.o(180275);
    return localStringBuilder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.r
 * JD-Core Version:    0.7.0.1
 */