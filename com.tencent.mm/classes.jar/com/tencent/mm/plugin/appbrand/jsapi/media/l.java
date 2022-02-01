package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.luggage.h.e.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.media.model.AppBrandMediaSource;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class l
  extends com.tencent.mm.plugin.appbrand.jsapi.a<com.tencent.mm.plugin.appbrand.q>
{
  public static final int CTRL_INDEX = 787;
  public static final String NAME = "previewMedia";
  private final int jYf;
  final int jYg;
  
  public l()
  {
    AppMethodBeat.i(180248);
    this.jYf = 524288;
    this.jYg = com.tencent.luggage.sdk.g.a.aD(this);
    AppMethodBeat.o(180248);
  }
  
  /* Error */
  private static String ID(String paramString)
  {
    // Byte code:
    //   0: ldc 49
    //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: iconst_0
    //   7: invokestatic 55	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   10: astore_2
    //   11: aload_2
    //   12: ifnull +8 -> 20
    //   15: aload_2
    //   16: arraylength
    //   17: ifne +11 -> 28
    //   20: ldc 49
    //   22: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   25: ldc 57
    //   27: areturn
    //   28: new 59	java/lang/StringBuilder
    //   31: dup
    //   32: ldc 61
    //   34: invokespecial 64	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   37: invokestatic 70	java/lang/System:currentTimeMillis	()J
    //   40: invokevirtual 74	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   43: ldc 76
    //   45: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_0
    //   49: invokevirtual 85	java/lang/String:hashCode	()I
    //   52: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   55: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: astore_0
    //   59: new 94	com/tencent/mm/vfs/e
    //   62: dup
    //   63: invokestatic 100	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   66: invokevirtual 106	android/content/Context:getCacheDir	()Ljava/io/File;
    //   69: aload_0
    //   70: invokespecial 109	com/tencent/mm/vfs/e:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   73: astore_3
    //   74: aconst_null
    //   75: astore_1
    //   76: aload_3
    //   77: invokestatic 115	com/tencent/mm/vfs/i:ai	(Lcom/tencent/mm/vfs/e;)Ljava/io/OutputStream;
    //   80: astore_0
    //   81: aload_0
    //   82: astore_1
    //   83: aload_0
    //   84: aload_2
    //   85: invokevirtual 121	java/io/OutputStream:write	([B)V
    //   88: aload_0
    //   89: ifnull +7 -> 96
    //   92: aload_0
    //   93: invokevirtual 124	java/io/OutputStream:close	()V
    //   96: aload_3
    //   97: invokevirtual 128	com/tencent/mm/vfs/e:fhU	()Landroid/net/Uri;
    //   100: invokestatic 134	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   103: astore_0
    //   104: ldc 49
    //   106: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: aload_0
    //   110: areturn
    //   111: astore_0
    //   112: aconst_null
    //   113: astore_0
    //   114: aload_0
    //   115: ifnull +7 -> 122
    //   118: aload_0
    //   119: invokevirtual 124	java/io/OutputStream:close	()V
    //   122: ldc 49
    //   124: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   127: ldc 57
    //   129: areturn
    //   130: astore_0
    //   131: aload_1
    //   132: ifnull +7 -> 139
    //   135: aload_1
    //   136: invokevirtual 124	java/io/OutputStream:close	()V
    //   139: ldc 49
    //   141: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   144: aload_0
    //   145: athrow
    //   146: astore_0
    //   147: goto -51 -> 96
    //   150: astore_0
    //   151: goto -29 -> 122
    //   154: astore_1
    //   155: goto -16 -> 139
    //   158: astore_1
    //   159: goto -45 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	paramString	String
    //   75	61	1	str	String
    //   154	1	1	localIOException	java.io.IOException
    //   158	1	1	localException	Exception
    //   10	75	2	arrayOfByte	byte[]
    //   73	24	3	locale	com.tencent.mm.vfs.e
    // Exception table:
    //   from	to	target	type
    //   76	81	111	java/lang/Exception
    //   76	81	130	finally
    //   83	88	130	finally
    //   92	96	146	java/io/IOException
    //   118	122	150	java/io/IOException
    //   135	139	154	java/io/IOException
    //   83	88	158	java/lang/Exception
  }
  
  private String a(Context paramContext, aa paramaa, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(180249);
    Object localObject2 = paramJSONObject.optJSONArray("sources");
    if (localObject2 == null)
    {
      paramContext = e("fail:invalid data", null);
      AppMethodBeat.o(180249);
      return paramContext;
    }
    final String[] arrayOfString = new String[((JSONArray)localObject2).length()];
    Object localObject1 = new ArrayList();
    int i = 0;
    Object localObject3;
    while (i < ((JSONArray)localObject2).length())
    {
      Object localObject4 = ((JSONArray)localObject2).optJSONObject(i);
      localObject3 = new AppBrandMediaSource();
      ((AppBrandMediaSource)localObject3).url = ((JSONObject)localObject4).optString("url");
      ((AppBrandMediaSource)localObject3).gsf = ((JSONObject)localObject4).optString("type");
      ((AppBrandMediaSource)localObject3).gsg = ((JSONObject)localObject4).optString("poster");
      arrayOfString[i] = ((AppBrandMediaSource)localObject3).url;
      if (!TextUtils.isEmpty(((AppBrandMediaSource)localObject3).gsg))
      {
        localObject4 = paramaa.Ee().EP(((AppBrandMediaSource)localObject3).gsg);
        if (localObject4 != null) {
          ((AppBrandMediaSource)localObject3).gsg = com.tencent.mm.vfs.q.B(((com.tencent.mm.vfs.e)localObject4).fhU());
        }
      }
      if (!TextUtils.isEmpty(((AppBrandMediaSource)localObject3).url))
      {
        localObject4 = paramaa.Ee().EP(((AppBrandMediaSource)localObject3).url);
        if (localObject4 != null)
        {
          arrayOfString[i] = com.tencent.mm.vfs.q.B(((com.tencent.mm.vfs.e)localObject4).fhU());
          ((AppBrandMediaSource)localObject3).url = com.tencent.mm.vfs.q.B(((com.tencent.mm.vfs.e)localObject4).fhU());
        }
      }
      ((ArrayList)localObject1).add(localObject3);
      i += 1;
    }
    int k = 0;
    int j = 0;
    localObject2 = paramJSONObject.opt("current");
    if ((localObject2 instanceof Integer)) {}
    for (j = ((Integer)localObject2).intValue();; j = k)
    {
      if (j >= 0)
      {
        i = j;
        if (j < arrayOfString.length) {}
      }
      else
      {
        i = 0;
      }
      localObject3 = o(arrayOfString);
      arrayOfString = a((String[])localObject3, arrayOfString);
      j = i;
      if (i >= localObject3.length) {
        j = 0;
      }
      if (!(paramContext instanceof Activity))
      {
        paramContext = e("fail:internal error invalid android context", null);
        AppMethodBeat.o(180249);
        return paramContext;
        if ((localObject2 instanceof String))
        {
          i = 0;
          for (;;)
          {
            k = j;
            if (i >= arrayOfString.length) {
              break;
            }
            if (localObject2.equals(arrayOfString[i])) {
              j = i;
            }
            i += 1;
          }
        }
      }
      else
      {
        boolean bool = paramJSONObject.optBoolean("showmenu", true);
        ad.i("MicroMsg.JsApiPreviewMedia", "showmenu:%b", new Object[] { Boolean.valueOf(bool) });
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("nowUrl", localObject3[j]);
        ((Intent)localObject2).putParcelableArrayListExtra("mediaSource", (ArrayList)localObject1);
        ((Intent)localObject2).putExtra("urlList", (String[])localObject3);
        ((Intent)localObject2).putExtra("type", -255);
        ((Intent)localObject2).putExtra("isFromWebView", true);
        ((Intent)localObject2).putExtra("isFromAppBrand", true);
        ((Intent)localObject2).putExtra("showmenu", bool);
        localObject1 = (com.tencent.mm.plugin.appbrand.q.a)paramaa.ar(com.tencent.mm.plugin.appbrand.q.a.class);
        if ((localObject1 != null) && (!bt.isNullOrNil(((com.tencent.mm.plugin.appbrand.q.a)localObject1).referer))) {
          q.a(paramaa, paramJSONObject, (Intent)localObject2, ((com.tencent.mm.plugin.appbrand.q.a)localObject1).referer);
        }
        for (;;)
        {
          ((Intent)localObject2).putExtra("shouldShowScanQrCodeMenu", true);
          ((Intent)localObject2).putExtra("scanQrCodeGetA8KeyScene", 44);
          ((Intent)localObject2).putExtra("scanCodeTypes", new int[] { 3 });
          ((Intent)localObject2).putExtra("scanResultCodeTypes", new int[] { 22 });
          paramJSONObject = new Bundle();
          paramJSONObject.putInt("stat_scene", 6);
          paramJSONObject.putString("stat_app_id", paramString);
          paramJSONObject.putString("stat_url", paramaa.jzm);
          ((Intent)localObject2).putExtra("_stat_obj", paramJSONObject);
          ((Intent)localObject2).setClassName(paramContext, paramContext.getPackageName() + ".plugin.subapp.ui.gallery.GestureGalleryUI");
          try
          {
            i = ((Intent)localObject2).getExtras().toString().length();
            if (i <= 524288) {
              break;
            }
            ad.e("MicroMsg.JsApiPreviewMedia", "data too large size:%d", new Object[] { Integer.valueOf(i) });
            paramContext = e("fail:data too large", null);
            AppMethodBeat.o(180249);
            return paramContext;
          }
          catch (Exception paramContext)
          {
            ad.printErrStackTrace("MicroMsg.JsApiPreviewMedia", paramContext, "JsApiPreviewImage get size error", new Object[0]);
            paramContext = e("fail", null);
            AppMethodBeat.o(180249);
            return paramContext;
          }
          ad.w("MicroMsg.JsApiPreviewMedia", "config.referer is null");
        }
        com.tencent.luggage.h.e.az(paramContext).b(new e.b()
        {
          public final boolean b(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
          {
            paramAnonymousInt2 = 0;
            AppMethodBeat.i(180247);
            if (l.this.jYg == paramAnonymousInt1)
            {
              paramAnonymousIntent = arrayOfString;
              paramAnonymousInt1 = paramAnonymousInt2;
            }
            for (;;)
            {
              if (paramAnonymousInt1 < paramAnonymousIntent.length) {}
              try
              {
                i.deleteFile(paramAnonymousIntent[paramAnonymousInt1]);
                label38:
                paramAnonymousInt1 += 1;
                continue;
                AppMethodBeat.o(180247);
                return true;
                AppMethodBeat.o(180247);
                return false;
              }
              catch (Exception localException)
              {
                break label38;
              }
            }
          }
        });
        d.a(paramContext, "subapp", ".ui.gallery.GestureGalleryUI", (Intent)localObject2, this.jYg, false);
        paramContext = e("ok", null);
        AppMethodBeat.o(180249);
        return paramContext;
      }
    }
  }
  
  private static String[] a(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(180251);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayOfString1.length)
    {
      if ((paramArrayOfString1[i] != null) && (paramArrayOfString2[i] != null) && (!paramArrayOfString1[i].equals(paramArrayOfString2[i]))) {
        localArrayList.add(paramArrayOfString1[i]);
      }
      i += 1;
    }
    paramArrayOfString1 = (String[])localArrayList.toArray(new String[localArrayList.size()]);
    AppMethodBeat.o(180251);
    return paramArrayOfString1;
  }
  
  private static String[] o(String[] paramArrayOfString)
  {
    AppMethodBeat.i(180250);
    String[] arrayOfString = new String[paramArrayOfString.length];
    int i = 0;
    if (i < paramArrayOfString.length)
    {
      String str;
      if ((paramArrayOfString[i] != null) && (paramArrayOfString[i].startsWith("data:image/")))
      {
        str = paramArrayOfString[i];
        if (TextUtils.isEmpty(str))
        {
          str = "";
          label52:
          arrayOfString[i] = str;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        str = ID(str.substring(str.indexOf("base64,") + 7).trim());
        break label52;
        arrayOfString[i] = paramArrayOfString[i];
      }
    }
    AppMethodBeat.o(180250);
    return arrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.l
 * JD-Core Version:    0.7.0.1
 */