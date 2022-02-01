package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vending.g.d.b;
import com.tencent.mm.vfs.k;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public final class r
{
  public static boolean Rh(String paramString)
  {
    AppMethodBeat.i(46813);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(46813);
      return true;
    }
    AppMethodBeat.o(46813);
    return false;
  }
  
  public static String Ri(String paramString)
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
    if (bu.isNullOrNil(paramString))
    {
      if (!paramBoolean)
      {
        AppMethodBeat.o(46812);
        return null;
      }
      paramc.Ew();
      if (paramc.Fl() == null)
      {
        ae.e("MicroMsg.ShareHelper", "tryToGetLocalFilePath NULL fs with appId(%s)", new Object[] { paramc.getAppId() });
        AppMethodBeat.o(46812);
        return null;
      }
      paramString = paramc.Fl().MR("share_" + System.nanoTime());
      if (paramString == null)
      {
        AppMethodBeat.o(46812);
        return null;
      }
      paramString = com.tencent.mm.vfs.w.B(paramString.fTh());
      if (paramc.Q(com.tencent.luggage.game.page.d.class) != null)
      {
        a(paramc, paramString, paramc.bvz());
        AppMethodBeat.o(46812);
        return paramString;
      }
      localObject = new Bundle();
      ((Bundle)localObject).putInt("action", 1);
      com.tencent.mm.ipcinvoker.h.a("com.tencent.mm", (Parcelable)localObject, a.class, null);
      paramc.Eu().a(com.tencent.mm.vending.h.d.LFp, new d.b() {});
      paramc = "delayLoadFile://".concat(String.valueOf(paramString));
      AppMethodBeat.o(46812);
      return paramc;
    }
    if (paramString.startsWith("wxfile://"))
    {
      paramString = paramc.Fl().MP(paramString);
      paramc = (com.tencent.luggage.sdk.b.a.c)localObject;
      if (paramString != null) {
        if (paramString.exists()) {
          break label256;
        }
      }
      label256:
      for (paramc = (com.tencent.luggage.sdk.b.a.c)localObject;; paramc = "file://" + com.tencent.mm.vfs.w.B(paramString.fTh()))
      {
        AppMethodBeat.o(46812);
        return paramc;
      }
    }
    if ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://")))
    {
      localObject = AppBrandLocalMediaObjectManager.genMediaFilePath(str, "share_" + System.nanoTime());
      paramc = com.tencent.mm.plugin.appbrand.page.w.k(paramc.Eq(), paramString);
      if ((paramc != null) && (!paramc.isRecycled()))
      {
        try
        {
          com.tencent.mm.sdk.platformtools.h.a(paramc, 100, Bitmap.CompressFormat.PNG, (String)localObject, true);
          if ((paramc != null) && (!paramc.isRecycled()))
          {
            ae.i("MicroMsg.ShareHelper", "bitmap recycle %s", new Object[] { paramc });
            paramc.recycle();
          }
        }
        catch (IOException paramString)
        {
          for (;;)
          {
            ae.w("MicroMsg.ShareHelper", "save temp bitmap to file failed, . exception : %s", new Object[] { paramString });
            if ((paramc != null) && (!paramc.isRecycled()))
            {
              ae.i("MicroMsg.ShareHelper", "bitmap recycle %s", new Object[] { paramc });
              paramc.recycle();
            }
          }
        }
        finally
        {
          if ((paramc == null) || (paramc.isRecycled())) {
            break label483;
          }
          ae.i("MicroMsg.ShareHelper", "bitmap recycle %s", new Object[] { paramc });
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
  
  static void a(z paramz, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(222678);
    if (paramBitmap != null) {}
    try
    {
      if (!paramBitmap.isRecycled())
      {
        long l = System.currentTimeMillis();
        com.tencent.mm.sdk.platformtools.h.a(paramBitmap, 100, Bitmap.CompressFormat.JPEG, paramString, true);
        ae.i("MicroMsg.ShareHelper", "saveFile(appId : %s, pageView : %s, saveFileCost : %sms)", new Object[] { paramz.getAppId(), Integer.valueOf(paramz.hashCode()), Long.valueOf(System.currentTimeMillis() - l) });
        paramz = new Bundle();
        paramz.putString("delay_load_img_path", "file://".concat(String.valueOf(paramString)));
        new r.1(l, paramz).run();
      }
      return;
    }
    catch (Exception paramz)
    {
      ae.w("MicroMsg.ShareHelper", "save temp bitmap to file failed, . exception : %s", new Object[] { paramz });
      return;
    }
    finally
    {
      if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
      {
        ae.i("MicroMsg.ShareHelper", "bitmap recycle %s", new Object[] { paramBitmap });
        paramBitmap.recycle();
      }
      AppMethodBeat.o(222678);
    }
    AppMethodBeat.o(222678);
  }
  
  public static void a(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt2, String paramString9, String paramString10, int paramInt3, String paramString11, int paramInt4, int paramInt5, String paramString12)
  {
    AppMethodBeat.i(222679);
    if (bu.isNullOrNil(paramString1))
    {
      ae.e("MicroMsg.ShareHelper", "appId is Null!");
      AppMethodBeat.o(222679);
      return;
    }
    localObject1 = "";
    try
    {
      localObject2 = com.tencent.mm.compatible.util.q.encode(bu.nullAsNil(paramString6), "UTF-8");
      localObject1 = localObject2;
    }
    catch (UnsupportedEncodingException paramString10)
    {
      try
      {
        str1 = com.tencent.mm.compatible.util.q.encode(bu.nullAsNil(paramString7), "UTF-8");
        localObject2 = str1;
      }
      catch (UnsupportedEncodingException paramString10)
      {
        try
        {
          str1 = com.tencent.mm.compatible.util.q.encode(bu.nullAsNil(paramString10), "UTF-8");
        }
        catch (UnsupportedEncodingException paramString10)
        {
          try
          {
            paramString11 = com.tencent.mm.compatible.util.q.encode(bu.nullAsNil(paramString11), "UTF-8");
          }
          catch (UnsupportedEncodingException paramString10)
          {
            try
            {
              for (;;)
              {
                Object localObject2;
                String str1;
                str3 = com.tencent.mm.compatible.util.q.encode(bu.nullAsNil(paramString5), "UTF-8");
                paramInt3 += 1000;
                paramString5 = "";
                try
                {
                  String str4 = com.tencent.mm.compatible.util.q.encode(bu.nullAsNil(paramString12), "UTF-8");
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
                    ae.e("MicroMsg.ShareHelper", "encode messageExtraData error!");
                    paramString10 = paramString5;
                  }
                }
                ae.d("MicroMsg.ShareHelper", "stev report(%s), appId %s, scene %s, sceneNote %s, sessionId %s, currentPath %s, currentTitle %s,shareTitle %s, sharePath %s, shareActionId %s, destinationUserCount %s, destinationUserName %s, appServiceType %s, thumbIconUrl %s, appVersion %d , destinationType %d, messageExtraData %s", new Object[] { Integer.valueOf(14077), paramString1, Integer.valueOf(paramInt1), paramString2, paramString3, paramString7, paramString8, str3, paramString6, paramString9, Integer.valueOf(paramInt2), paramString4, Integer.valueOf(paramInt3), paramString11, Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), paramString12 });
                com.tencent.mm.plugin.report.service.g.yxI.f(14077, new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, paramString3, localObject2, paramString8, str3, localObject1, paramString9, "", Integer.valueOf(paramInt2), paramString4, str1, Integer.valueOf(paramInt3), paramString11, Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), paramString10 });
                AppMethodBeat.o(222679);
                return;
                localUnsupportedEncodingException1 = localUnsupportedEncodingException1;
                ae.e("MicroMsg.ShareHelper", "encode share page path error!");
                continue;
                localUnsupportedEncodingException2 = localUnsupportedEncodingException2;
                ae.e("MicroMsg.ShareHelper", "encode current page path error!");
                continue;
                paramString10 = paramString10;
                ae.e("MicroMsg.ShareHelper", "encode current html url error!");
                str2 = "";
                continue;
                paramString10 = paramString10;
                ae.e("MicroMsg.ShareHelper", "encode thumb Icon url error!");
                paramString11 = "";
              }
            }
            catch (UnsupportedEncodingException paramString10)
            {
              for (;;)
              {
                ae.e("MicroMsg.ShareHelper", "encode shareTitle error!");
                String str3 = paramString5;
              }
            }
          }
        }
      }
    }
    localObject2 = "";
  }
  
  public static StringBuilder bI(String paramString, int paramInt)
  {
    AppMethodBeat.i(180275);
    int i = ((com.tencent.mm.plugin.appbrand.appstorage.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.appstorage.a.a.class)).Ng(paramString);
    StringBuilder localStringBuilder = new StringBuilder("1_");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(aj.ej(p.getString(i)));
    localStringBuilder.append("_");
    localStringBuilder.append(bu.aRi());
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