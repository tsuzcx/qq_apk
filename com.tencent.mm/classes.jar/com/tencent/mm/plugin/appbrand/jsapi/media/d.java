package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.appstorage.k;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d
  extends com.tencent.mm.plugin.appbrand.jsapi.a<o>
{
  public static final int CTRL_INDEX = 30;
  public static final String NAME = "previewImage";
  private final int gwm = 524288;
  
  private String a(Context paramContext, q paramq, String paramString, JSONObject paramJSONObject)
  {
    Object localObject2 = paramJSONObject.optJSONArray("urls");
    if (localObject2 == null) {
      return h("fail:invalid data", null);
    }
    Object localObject1 = new String[((JSONArray)localObject2).length()];
    int i = 0;
    while (i < ((JSONArray)localObject2).length())
    {
      localObject1[i] = ((JSONArray)localObject2).optString(i);
      i += 1;
    }
    paramJSONObject = paramJSONObject.opt("current");
    if ((paramJSONObject instanceof Integer)) {
      i = ((Integer)paramJSONObject).intValue();
    }
    for (;;)
    {
      int j = 0;
      while (j < localObject1.length)
      {
        paramJSONObject = paramq.Zl().rx(localObject1[j]);
        if (paramJSONObject != null) {
          localObject1[j] = paramJSONObject.getAbsolutePath();
        }
        j += 1;
        continue;
        if (!(paramJSONObject instanceof String)) {
          break label779;
        }
        int k = 0;
        j = 0;
        for (;;)
        {
          i = k;
          if (j >= localObject1.length) {
            break;
          }
          if (paramJSONObject.equals(localObject1[j])) {
            k = j;
          }
          j += 1;
        }
      }
      localObject2 = new String[localObject1.length];
      j = 0;
      if (j < localObject1.length)
      {
        if ((localObject1[j] != null) && (localObject1[j].startsWith("data:image/")))
        {
          paramJSONObject = localObject1[j];
          if (TextUtils.isEmpty(paramJSONObject))
          {
            paramJSONObject = "";
            label255:
            localObject2[j] = paramJSONObject;
          }
        }
        for (;;)
        {
          j += 1;
          break;
          paramJSONObject = ur(paramJSONObject.substring(paramJSONObject.indexOf("base64,") + 7).trim());
          break label255;
          localObject2[j] = localObject1[j];
        }
      }
      paramJSONObject = new ArrayList();
      j = 0;
      while (j < localObject2.length)
      {
        if ((localObject2[j] != null) && (localObject1[j] != null) && (!localObject2[j].equals(localObject1[j]))) {
          paramJSONObject.add(localObject2[j]);
        }
        j += 1;
      }
      paramJSONObject = (String[])paramJSONObject.toArray(new String[paramJSONObject.size()]);
      j = i;
      if (i >= localObject2.length) {
        j = 0;
      }
      if (!(paramContext instanceof MMActivity)) {
        return h("fail:internal error invalid android context", null);
      }
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("nowUrl", localObject2[j]);
      ((Intent)localObject1).putExtra("urlList", (String[])localObject2);
      ((Intent)localObject1).putExtra("type", -255);
      ((Intent)localObject1).putExtra("isFromWebView", true);
      localObject2 = (com.tencent.mm.plugin.appbrand.o.a)paramq.D(com.tencent.mm.plugin.appbrand.o.a.class);
      if ((localObject2 != null) && (!bk.bl(((com.tencent.mm.plugin.appbrand.o.a)localObject2).referer))) {
        ((Intent)localObject1).putExtra("IsFromWebViewReffer", ((com.tencent.mm.plugin.appbrand.o.a)localObject2).referer);
      }
      for (;;)
      {
        ((Intent)localObject1).putExtra("shouldShowScanQrCodeMenu", true);
        ((Intent)localObject1).putExtra("scanQrCodeGetA8KeyScene", 44);
        ((Intent)localObject1).putExtra("scanCodeTypes", new int[] { 3 });
        ((Intent)localObject1).putExtra("scanResultCodeTypes", new int[] { 22 });
        localObject2 = new Bundle();
        ((Bundle)localObject2).putInt("stat_scene", 6);
        ((Bundle)localObject2).putString("stat_app_id", paramString);
        ((Bundle)localObject2).putString("stat_url", paramq.getURL());
        ((Intent)localObject1).putExtra("_stat_obj", (Bundle)localObject2);
        ((Intent)localObject1).setClassName(paramContext, paramContext.getPackageName() + ".plugin.subapp.ui.gallery.GestureGalleryUI");
        try
        {
          i = ((Intent)localObject1).getExtras().toString().length();
          if (i <= 524288) {
            break;
          }
          y.e("MicroMsg.JsApiPreviewImage", "data too large size:%d", new Object[] { Integer.valueOf(i) });
          paramContext = h("fail:data too large", null);
          return paramContext;
        }
        catch (Exception paramContext)
        {
          y.printErrStackTrace("MicroMsg.JsApiPreviewImage", paramContext, "JsApiPreviewImage get size error", new Object[0]);
          return h("fail", null);
        }
        y.w("MicroMsg.JsApiPreviewImage", "config.referer is null");
      }
      ((MMActivity)paramContext).gJb = new d.1(this, paramJSONObject);
      com.tencent.mm.br.d.a(paramContext, "subapp", ".ui.gallery.GestureGalleryUI", (Intent)localObject1, 0xFFFF & hashCode(), false);
      return h("ok", null);
      label779:
      i = 0;
    }
  }
  
  /* Error */
  private static String ur(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: invokestatic 302	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   5: astore_2
    //   6: aload_2
    //   7: ifnull +8 -> 15
    //   10: aload_2
    //   11: arraylength
    //   12: ifne +6 -> 18
    //   15: ldc 102
    //   17: areturn
    //   18: new 78	java/io/File
    //   21: dup
    //   22: invokestatic 308	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   25: invokevirtual 312	android/content/Context:getCacheDir	()Ljava/io/File;
    //   28: new 216	java/lang/StringBuilder
    //   31: dup
    //   32: ldc_w 314
    //   35: invokespecial 317	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   38: invokestatic 323	java/lang/System:currentTimeMillis	()J
    //   41: invokevirtual 326	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   44: ldc_w 328
    //   47: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: aload_0
    //   51: invokevirtual 329	java/lang/String:hashCode	()I
    //   54: invokevirtual 332	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   57: invokevirtual 231	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokespecial 335	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   63: astore_3
    //   64: aconst_null
    //   65: astore_1
    //   66: new 337	java/io/FileOutputStream
    //   69: dup
    //   70: aload_3
    //   71: invokespecial 340	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   74: astore_0
    //   75: aload_0
    //   76: aload_2
    //   77: invokevirtual 344	java/io/FileOutputStream:write	([B)V
    //   80: aload_0
    //   81: invokevirtual 347	java/io/FileOutputStream:close	()V
    //   84: aload_3
    //   85: invokevirtual 82	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   88: areturn
    //   89: astore_0
    //   90: aload_1
    //   91: astore_0
    //   92: aload_0
    //   93: ifnull -78 -> 15
    //   96: aload_0
    //   97: invokevirtual 347	java/io/FileOutputStream:close	()V
    //   100: ldc 102
    //   102: areturn
    //   103: astore_0
    //   104: ldc 102
    //   106: areturn
    //   107: astore_0
    //   108: aconst_null
    //   109: astore_1
    //   110: aload_1
    //   111: ifnull +7 -> 118
    //   114: aload_1
    //   115: invokevirtual 347	java/io/FileOutputStream:close	()V
    //   118: aload_0
    //   119: athrow
    //   120: astore_0
    //   121: goto -37 -> 84
    //   124: astore_1
    //   125: goto -7 -> 118
    //   128: astore_1
    //   129: aload_0
    //   130: astore_2
    //   131: aload_1
    //   132: astore_0
    //   133: aload_2
    //   134: astore_1
    //   135: goto -25 -> 110
    //   138: astore_1
    //   139: goto -47 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	paramString	String
    //   65	50	1	localObject1	Object
    //   124	1	1	localIOException	java.io.IOException
    //   128	4	1	localObject2	Object
    //   134	1	1	localObject3	Object
    //   138	1	1	localException	Exception
    //   5	129	2	localObject4	Object
    //   63	22	3	localFile	File
    // Exception table:
    //   from	to	target	type
    //   66	75	89	java/lang/Exception
    //   96	100	103	java/io/IOException
    //   66	75	107	finally
    //   80	84	120	java/io/IOException
    //   114	118	124	java/io/IOException
    //   75	80	128	finally
    //   75	80	138	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.d
 * JD-Core Version:    0.7.0.1
 */