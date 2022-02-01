package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.g.d.b;
import com.tencent.mm.vfs.o;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public final class y
{
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
    if (Util.isNullOrNil(paramString))
    {
      if (!paramBoolean)
      {
        AppMethodBeat.o(46812);
        return null;
      }
      paramc.NV();
      if (paramc.getFileSystem() == null)
      {
        Log.e("MicroMsg.ShareHelper", "tryToGetLocalFilePath NULL fs with appId(%s)", new Object[] { paramc.getAppId() });
        AppMethodBeat.o(46812);
        return null;
      }
      paramString = paramc.getFileSystem().Wa("share_" + System.nanoTime());
      if (paramString == null)
      {
        AppMethodBeat.o(46812);
        return null;
      }
      paramString = com.tencent.mm.vfs.aa.z(paramString.her());
      if (paramc.S(com.tencent.luggage.game.page.d.class) != null)
      {
        a(paramc, paramString, paramc.bRB());
        AppMethodBeat.o(46812);
        return paramString;
      }
      localObject = new Bundle();
      ((Bundle)localObject).putInt("action", 1);
      com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, (Parcelable)localObject, a.class, null);
      paramc.NT().a(com.tencent.mm.vending.h.d.HEAVY_WORK, new d.b() {});
      paramc = "delayLoadFile://".concat(String.valueOf(paramString));
      AppMethodBeat.o(46812);
      return paramc;
    }
    if (paramString.startsWith("wxfile://"))
    {
      paramString = paramc.getFileSystem().VY(paramString);
      paramc = (com.tencent.luggage.sdk.b.a.c)localObject;
      if (paramString != null) {
        if (paramString.exists()) {
          break label257;
        }
      }
      label257:
      for (paramc = (com.tencent.luggage.sdk.b.a.c)localObject;; paramc = "file://" + com.tencent.mm.vfs.aa.z(paramString.her()))
      {
        AppMethodBeat.o(46812);
        return paramc;
      }
    }
    if ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://")))
    {
      localObject = AppBrandLocalMediaObjectManager.genMediaFilePath(str, "share_" + System.nanoTime());
      paramc = com.tencent.mm.plugin.appbrand.page.z.k(paramc.NP(), paramString);
      if ((paramc != null) && (!paramc.isRecycled()))
      {
        try
        {
          BitmapUtil.saveBitmapToImage(paramc, 100, Bitmap.CompressFormat.PNG, (String)localObject, true);
          if ((paramc != null) && (!paramc.isRecycled()))
          {
            Log.i("MicroMsg.ShareHelper", "bitmap recycle %s", new Object[] { paramc });
            paramc.recycle();
          }
        }
        catch (IOException paramString)
        {
          for (;;)
          {
            Log.w("MicroMsg.ShareHelper", "save temp bitmap to file failed, . exception : %s", new Object[] { paramString });
            if ((paramc != null) && (!paramc.isRecycled()))
            {
              Log.i("MicroMsg.ShareHelper", "bitmap recycle %s", new Object[] { paramc });
              paramc.recycle();
            }
          }
        }
        finally
        {
          if ((paramc == null) || (paramc.isRecycled())) {
            break label484;
          }
          Log.i("MicroMsg.ShareHelper", "bitmap recycle %s", new Object[] { paramc });
          paramc.recycle();
          AppMethodBeat.o(46812);
        }
        paramc = "file://".concat(String.valueOf(localObject));
        AppMethodBeat.o(46812);
        return paramc;
      }
      label484:
      AppMethodBeat.o(46812);
      return null;
    }
    AppMethodBeat.o(46812);
    return null;
  }
  
  static void a(ac paramac, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(226990);
    if (paramBitmap != null) {}
    try
    {
      if (!paramBitmap.isRecycled())
      {
        long l = System.currentTimeMillis();
        BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.JPEG, paramString, true);
        Log.i("MicroMsg.ShareHelper", "saveFile(appId : %s, pageView : %s, saveFileCost : %sms)", new Object[] { paramac.getAppId(), Integer.valueOf(paramac.hashCode()), Long.valueOf(System.currentTimeMillis() - l) });
        paramac = new Bundle();
        paramac.putString("delay_load_img_path", "file://".concat(String.valueOf(paramString)));
        new y.1(l, paramac).run();
      }
      return;
    }
    catch (Exception paramac)
    {
      Log.w("MicroMsg.ShareHelper", "save temp bitmap to file failed, . exception : %s", new Object[] { paramac });
      return;
    }
    finally
    {
      if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
      {
        Log.i("MicroMsg.ShareHelper", "bitmap recycle %s", new Object[] { paramBitmap });
        paramBitmap.recycle();
      }
      AppMethodBeat.o(226990);
    }
    AppMethodBeat.o(226990);
  }
  
  public static void a(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt2, String paramString9, String paramString10, int paramInt3, String paramString11, int paramInt4, int paramInt5, String paramString12)
  {
    AppMethodBeat.i(226991);
    if (Util.isNullOrNil(paramString1))
    {
      Log.e("MicroMsg.ShareHelper", "appId is Null!");
      AppMethodBeat.o(226991);
      return;
    }
    localObject1 = "";
    try
    {
      localObject2 = com.tencent.mm.compatible.util.q.encode(Util.nullAsNil(paramString6), "UTF-8");
      localObject1 = localObject2;
    }
    catch (UnsupportedEncodingException paramString10)
    {
      try
      {
        str1 = com.tencent.mm.compatible.util.q.encode(Util.nullAsNil(paramString7), "UTF-8");
        localObject2 = str1;
      }
      catch (UnsupportedEncodingException paramString10)
      {
        try
        {
          str1 = com.tencent.mm.compatible.util.q.encode(Util.nullAsNil(paramString10), "UTF-8");
        }
        catch (UnsupportedEncodingException paramString10)
        {
          try
          {
            paramString11 = com.tencent.mm.compatible.util.q.encode(Util.nullAsNil(paramString11), "UTF-8");
          }
          catch (UnsupportedEncodingException paramString10)
          {
            try
            {
              for (;;)
              {
                Object localObject2;
                String str1;
                str3 = com.tencent.mm.compatible.util.q.encode(Util.nullAsNil(paramString5), "UTF-8");
                int j = paramInt3 + 1000;
                paramString5 = "";
                try
                {
                  String str4 = com.tencent.mm.compatible.util.q.encode(Util.nullAsNil(paramString12), "UTF-8");
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
                    Log.e("MicroMsg.ShareHelper", "encode messageExtraData error!");
                    paramString10 = paramString5;
                    continue;
                    paramInt3 = paramString5.msM;
                    continue;
                    int i = paramString5.msQ;
                  }
                }
                paramString5 = aa.aaM(paramString9);
                if (paramString5 != null) {
                  break;
                }
                paramInt3 = 0;
                if (paramString5 != null) {
                  break label601;
                }
                i = 0;
                Log.d("MicroMsg.ShareHelper", "stev report(%s), appId %s, scene %s, sceneNote %s, sessionId %s, currentPath %s, currentTitle %s,shareTitle %s, sharePath %s, shareActionId %s, destinationUserCount %s, toUsername %s, htmlUrl %s, appServiceType %s, thumbIconUrl %s, appVersion %d , destinationType %d, messageExtraData %s,shareActionType:%d, shareSourceType:%d", new Object[] { Integer.valueOf(14077), paramString1, Integer.valueOf(paramInt1), paramString2, paramString3, paramString7, paramString8, str3, paramString6, paramString9, Integer.valueOf(paramInt2), paramString4, str1, Integer.valueOf(j), paramString11, Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), paramString12, Integer.valueOf(paramInt3), Integer.valueOf(i) });
                com.tencent.mm.plugin.report.service.h.CyF.a(14077, new Object[] { paramString1, Integer.valueOf(paramInt1), paramString2, paramString3, localObject2, paramString8, str3, localObject1, paramString9, "", Integer.valueOf(paramInt2), paramString4, str1, Integer.valueOf(j), paramString11, Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), paramString10, Integer.valueOf(paramInt3), Integer.valueOf(i) });
                AppMethodBeat.o(226991);
                return;
                localUnsupportedEncodingException1 = localUnsupportedEncodingException1;
                Log.e("MicroMsg.ShareHelper", "encode share page path error!");
                continue;
                localUnsupportedEncodingException2 = localUnsupportedEncodingException2;
                Log.e("MicroMsg.ShareHelper", "encode current page path error!");
                continue;
                paramString10 = paramString10;
                Log.e("MicroMsg.ShareHelper", "encode current html url error!");
                str2 = "";
                continue;
                paramString10 = paramString10;
                Log.e("MicroMsg.ShareHelper", "encode thumb Icon url error!");
                paramString11 = "";
              }
            }
            catch (UnsupportedEncodingException paramString10)
            {
              for (;;)
              {
                Log.e("MicroMsg.ShareHelper", "encode shareTitle error!");
                String str3 = paramString5;
              }
            }
          }
        }
      }
    }
    localObject2 = "";
  }
  
  public static boolean aaK(String paramString)
  {
    AppMethodBeat.i(46813);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(46813);
      return true;
    }
    AppMethodBeat.o(46813);
    return false;
  }
  
  public static String aaL(String paramString)
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
  
  public static StringBuilder bN(String paramString, int paramInt)
  {
    AppMethodBeat.i(180275);
    int i = ((com.tencent.mm.plugin.appbrand.appstorage.a.a)g.af(com.tencent.mm.plugin.appbrand.appstorage.a.a.class)).Wp(paramString);
    StringBuilder localStringBuilder = new StringBuilder("1_");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(MD5Util.getMD5String(p.getString(i)));
    localStringBuilder.append("_");
    localStringBuilder.append(Util.nowSecond());
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt);
    AppMethodBeat.o(180275);
    return localStringBuilder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.y
 * JD-Core Version:    0.7.0.1
 */