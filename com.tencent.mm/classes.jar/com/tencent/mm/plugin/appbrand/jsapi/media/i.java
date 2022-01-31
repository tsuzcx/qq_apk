package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class i
  extends com.tencent.mm.plugin.appbrand.jsapi.a<r>
{
  public static final int CTRL_INDEX = 30;
  public static final String NAME = "previewImage";
  private final int hSh = 524288;
  
  /* Error */
  private static String Cz(String paramString)
  {
    // Byte code:
    //   0: ldc 28
    //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: iconst_0
    //   7: invokestatic 40	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   10: astore_2
    //   11: aload_2
    //   12: ifnull +8 -> 20
    //   15: aload_2
    //   16: arraylength
    //   17: ifne +11 -> 28
    //   20: ldc 28
    //   22: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   25: ldc 45
    //   27: areturn
    //   28: new 47	java/io/File
    //   31: dup
    //   32: invokestatic 53	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   35: invokevirtual 59	android/content/Context:getCacheDir	()Ljava/io/File;
    //   38: new 61	java/lang/StringBuilder
    //   41: dup
    //   42: ldc 63
    //   44: invokespecial 66	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   47: invokestatic 72	java/lang/System:currentTimeMillis	()J
    //   50: invokevirtual 76	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   53: ldc 78
    //   55: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload_0
    //   59: invokevirtual 87	java/lang/String:hashCode	()I
    //   62: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   65: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokespecial 97	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   71: astore_3
    //   72: aconst_null
    //   73: astore_1
    //   74: new 99	java/io/FileOutputStream
    //   77: dup
    //   78: aload_3
    //   79: invokespecial 102	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   82: astore_0
    //   83: aload_0
    //   84: aload_2
    //   85: invokevirtual 106	java/io/FileOutputStream:write	([B)V
    //   88: aload_0
    //   89: invokevirtual 109	java/io/FileOutputStream:close	()V
    //   92: aload_3
    //   93: invokevirtual 112	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   96: astore_0
    //   97: ldc 28
    //   99: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: aload_0
    //   103: areturn
    //   104: astore_0
    //   105: aload_1
    //   106: astore_0
    //   107: aload_0
    //   108: ifnull +7 -> 115
    //   111: aload_0
    //   112: invokevirtual 109	java/io/FileOutputStream:close	()V
    //   115: ldc 28
    //   117: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: ldc 45
    //   122: areturn
    //   123: astore_0
    //   124: aconst_null
    //   125: astore_1
    //   126: aload_1
    //   127: ifnull +7 -> 134
    //   130: aload_1
    //   131: invokevirtual 109	java/io/FileOutputStream:close	()V
    //   134: ldc 28
    //   136: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   139: aload_0
    //   140: athrow
    //   141: astore_0
    //   142: goto -50 -> 92
    //   145: astore_0
    //   146: goto -31 -> 115
    //   149: astore_1
    //   150: goto -16 -> 134
    //   153: astore_1
    //   154: aload_0
    //   155: astore_2
    //   156: aload_1
    //   157: astore_0
    //   158: aload_2
    //   159: astore_1
    //   160: goto -34 -> 126
    //   163: astore_1
    //   164: goto -57 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	paramString	String
    //   73	58	1	localObject1	Object
    //   149	1	1	localIOException	java.io.IOException
    //   153	4	1	localObject2	Object
    //   159	1	1	localObject3	Object
    //   163	1	1	localException	Exception
    //   10	149	2	localObject4	Object
    //   71	22	3	localFile	File
    // Exception table:
    //   from	to	target	type
    //   74	83	104	java/lang/Exception
    //   74	83	123	finally
    //   88	92	141	java/io/IOException
    //   111	115	145	java/io/IOException
    //   130	134	149	java/io/IOException
    //   83	88	153	finally
    //   83	88	163	java/lang/Exception
  }
  
  private String a(Context paramContext, v paramv, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(131298);
    Object localObject2 = paramJSONObject.optJSONArray("urls");
    if (localObject2 == null)
    {
      paramContext = j("fail:invalid data", null);
      AppMethodBeat.o(131298);
      return paramContext;
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
        paramJSONObject = paramv.wX().zg(localObject1[j]);
        if (paramJSONObject != null) {
          localObject1[j] = paramJSONObject.getAbsolutePath();
        }
        j += 1;
        continue;
        if (!(paramJSONObject instanceof String)) {
          break label830;
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
            label267:
            localObject2[j] = paramJSONObject;
          }
        }
        for (;;)
        {
          j += 1;
          break;
          paramJSONObject = Cz(paramJSONObject.substring(paramJSONObject.indexOf("base64,") + 7).trim());
          break label267;
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
      if (!(paramContext instanceof MMActivity))
      {
        paramContext = j("fail:internal error invalid android context", null);
        AppMethodBeat.o(131298);
        return paramContext;
      }
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("nowUrl", localObject2[j]);
      ((Intent)localObject1).putExtra("urlList", (String[])localObject2);
      ((Intent)localObject1).putExtra("type", -255);
      ((Intent)localObject1).putExtra("isFromWebView", true);
      localObject2 = (com.tencent.mm.plugin.appbrand.m.a)paramv.U(com.tencent.mm.plugin.appbrand.m.a.class);
      if ((localObject2 != null) && (!bo.isNullOrNil(((com.tencent.mm.plugin.appbrand.m.a)localObject2).referer))) {
        ((Intent)localObject1).putExtra("IsFromWebViewReffer", ((com.tencent.mm.plugin.appbrand.m.a)localObject2).referer);
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
        ((Bundle)localObject2).putString("stat_url", paramv.hzM);
        ((Intent)localObject1).putExtra("_stat_obj", (Bundle)localObject2);
        ((Intent)localObject1).setClassName(paramContext, paramContext.getPackageName() + ".plugin.subapp.ui.gallery.GestureGalleryUI");
        try
        {
          i = ((Intent)localObject1).getExtras().toString().length();
          if (i <= 524288) {
            break;
          }
          ab.e("MicroMsg.JsApiPreviewImage", "data too large size:%d", new Object[] { Integer.valueOf(i) });
          paramContext = j("fail:data too large", null);
          AppMethodBeat.o(131298);
          return paramContext;
        }
        catch (Exception paramContext)
        {
          ab.printErrStackTrace("MicroMsg.JsApiPreviewImage", paramContext, "JsApiPreviewImage get size error", new Object[0]);
          paramContext = j("fail", null);
          AppMethodBeat.o(131298);
          return paramContext;
        }
        ab.w("MicroMsg.JsApiPreviewImage", "config.referer is null");
      }
      ((MMActivity)paramContext).mmSetOnActivityResultCallback(new i.1(this, paramJSONObject));
      d.a(paramContext, "subapp", ".ui.gallery.GestureGalleryUI", (Intent)localObject1, 0xFFFF & hashCode(), false);
      paramContext = j("ok", null);
      AppMethodBeat.o(131298);
      return paramContext;
      label830:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.i
 * JD-Core Version:    0.7.0.1
 */