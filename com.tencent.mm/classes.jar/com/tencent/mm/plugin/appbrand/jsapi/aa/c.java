package com.tencent.mm.plugin.appbrand.jsapi.aa;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.f.a.c;
import com.tencent.mm.plugin.appbrand.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.s.d;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public final class c
{
  public static InputStream G(InputStream paramInputStream)
  {
    AppMethodBeat.i(197279);
    if (paramInputStream.markSupported())
    {
      AppMethodBeat.o(197279);
      return paramInputStream;
    }
    if ((paramInputStream instanceof FileInputStream))
    {
      paramInputStream = new c.a((FileInputStream)paramInputStream);
      AppMethodBeat.o(197279);
      return paramInputStream;
    }
    paramInputStream = new BufferedInputStream(paramInputStream);
    AppMethodBeat.o(197279);
    return paramInputStream;
  }
  
  /* Error */
  public static void a(android.widget.TextView paramTextView, JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: ldc 47
    //   2: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnull +7 -> 13
    //   9: aload_1
    //   10: ifnonnull +9 -> 19
    //   13: ldc 47
    //   15: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   18: return
    //   19: aload_1
    //   20: ldc 49
    //   22: invokevirtual 55	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   25: astore_3
    //   26: aload_3
    //   27: invokestatic 61	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   30: ifne +11 -> 41
    //   33: aload_0
    //   34: aload_3
    //   35: invokestatic 67	com/tencent/mm/plugin/appbrand/y/g:VH	(Ljava/lang/String;)I
    //   38: invokevirtual 72	android/widget/TextView:setTextColor	(I)V
    //   41: aload_0
    //   42: iconst_0
    //   43: aload_1
    //   44: ldc 74
    //   46: invokevirtual 78	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   49: d2f
    //   50: invokestatic 82	com/tencent/mm/plugin/appbrand/y/g:aJ	(F)F
    //   53: invokevirtual 86	android/widget/TextView:setTextSize	(IF)V
    //   56: aload_1
    //   57: ldc 88
    //   59: invokevirtual 55	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   62: astore_3
    //   63: ldc 90
    //   65: aload_3
    //   66: invokevirtual 96	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   69: ifeq +108 -> 177
    //   72: aload_0
    //   73: iconst_3
    //   74: invokevirtual 99	android/widget/TextView:setGravity	(I)V
    //   77: aload_1
    //   78: ldc 101
    //   80: invokevirtual 55	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   83: astore_3
    //   84: ldc 103
    //   86: aload_3
    //   87: invokevirtual 96	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   90: ifeq +121 -> 211
    //   93: aload_0
    //   94: invokevirtual 107	android/widget/TextView:getPaint	()Landroid/text/TextPaint;
    //   97: iconst_1
    //   98: invokevirtual 113	android/text/TextPaint:setFakeBoldText	(Z)V
    //   101: aload_1
    //   102: ldc 115
    //   104: aload_0
    //   105: invokevirtual 119	android/widget/TextView:getTextSize	()F
    //   108: ldc 120
    //   110: fmul
    //   111: invokestatic 126	java/lang/Math:round	(F)I
    //   114: invokestatic 129	com/tencent/mm/plugin/appbrand/y/g:a	(Lorg/json/JSONObject;Ljava/lang/String;I)I
    //   117: istore_2
    //   118: aload_0
    //   119: instanceof 131
    //   122: ifeq +11 -> 133
    //   125: aload_0
    //   126: checkcast 131	com/tencent/mm/plugin/appbrand/widget/e
    //   129: iload_2
    //   130: invokevirtual 134	com/tencent/mm/plugin/appbrand/widget/e:setLineHeight	(I)V
    //   133: aload_1
    //   134: ldc 136
    //   136: invokevirtual 55	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   139: astore_3
    //   140: ldc 138
    //   142: aload_3
    //   143: invokevirtual 96	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   146: ifeq +89 -> 235
    //   149: aload_0
    //   150: getstatic 144	android/text/TextUtils$TruncateAt:END	Landroid/text/TextUtils$TruncateAt;
    //   153: invokevirtual 148	android/widget/TextView:setEllipsize	(Landroid/text/TextUtils$TruncateAt;)V
    //   156: aload_0
    //   157: iconst_1
    //   158: invokevirtual 151	android/widget/TextView:setSingleLine	(Z)V
    //   161: aload_0
    //   162: aload_1
    //   163: ldc 153
    //   165: invokevirtual 55	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   168: invokevirtual 157	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   171: ldc 47
    //   173: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   176: return
    //   177: ldc 159
    //   179: aload_3
    //   180: invokevirtual 96	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   183: ifeq +11 -> 194
    //   186: aload_0
    //   187: iconst_1
    //   188: invokevirtual 99	android/widget/TextView:setGravity	(I)V
    //   191: goto -114 -> 77
    //   194: ldc 161
    //   196: aload_3
    //   197: invokevirtual 96	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   200: ifeq -123 -> 77
    //   203: aload_0
    //   204: iconst_5
    //   205: invokevirtual 99	android/widget/TextView:setGravity	(I)V
    //   208: goto -131 -> 77
    //   211: ldc 163
    //   213: aload_3
    //   214: invokevirtual 96	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   217: ifeq -116 -> 101
    //   220: aload_0
    //   221: invokevirtual 107	android/widget/TextView:getPaint	()Landroid/text/TextPaint;
    //   224: iconst_0
    //   225: invokevirtual 113	android/text/TextPaint:setFakeBoldText	(Z)V
    //   228: goto -127 -> 101
    //   231: astore_3
    //   232: goto -131 -> 101
    //   235: ldc 165
    //   237: aload_3
    //   238: invokevirtual 96	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   241: ifeq +11 -> 252
    //   244: aload_0
    //   245: iconst_1
    //   246: invokevirtual 151	android/widget/TextView:setSingleLine	(Z)V
    //   249: goto -88 -> 161
    //   252: ldc 167
    //   254: aload_3
    //   255: invokevirtual 96	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   258: ifeq +11 -> 269
    //   261: aload_0
    //   262: iconst_0
    //   263: invokevirtual 151	android/widget/TextView:setSingleLine	(Z)V
    //   266: goto -105 -> 161
    //   269: ldc 169
    //   271: aload_3
    //   272: invokevirtual 96	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   275: ifeq -114 -> 161
    //   278: aload_0
    //   279: iconst_0
    //   280: invokevirtual 151	android/widget/TextView:setSingleLine	(Z)V
    //   283: goto -122 -> 161
    //   286: astore_0
    //   287: ldc 47
    //   289: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   292: return
    //   293: astore_3
    //   294: goto -238 -> 56
    //   297: astore_3
    //   298: goto -257 -> 41
    //   301: astore_3
    //   302: goto -225 -> 77
    //   305: astore_3
    //   306: goto -145 -> 161
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	309	0	paramTextView	android.widget.TextView
    //   0	309	1	paramJSONObject	JSONObject
    //   117	13	2	i	int
    //   25	189	3	str	String
    //   231	41	3	localJSONException1	org.json.JSONException
    //   293	1	3	localJSONException2	org.json.JSONException
    //   297	1	3	localJSONException3	org.json.JSONException
    //   301	1	3	localJSONException4	org.json.JSONException
    //   305	1	3	localJSONException5	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   77	101	231	org/json/JSONException
    //   211	228	231	org/json/JSONException
    //   161	171	286	org/json/JSONException
    //   41	56	293	org/json/JSONException
    //   19	41	297	org/json/JSONException
    //   56	77	301	org/json/JSONException
    //   177	191	301	org/json/JSONException
    //   194	208	301	org/json/JSONException
    //   133	161	305	org/json/JSONException
    //   235	249	305	org/json/JSONException
    //   252	266	305	org/json/JSONException
    //   269	283	305	org/json/JSONException
  }
  
  public static void a(com.tencent.mm.plugin.appbrand.jsapi.e parame, com.tencent.mm.plugin.appbrand.widget.b.a parama, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(137889);
    if ((parama == null) || (paramJSONObject == null))
    {
      AppMethodBeat.o(137889);
      return;
    }
    try
    {
      String str = d.a(parame, parama, paramJSONObject);
      paramJSONObject = paramJSONObject.optString("iconPath");
      if (!TextUtils.isEmpty(paramJSONObject))
      {
        if ((paramJSONObject.startsWith("data:image/")) && (paramJSONObject.contains("base64")))
        {
          ae.i("Luggage.ViewAttributeHelper", "it is data:image/ format file, iconPath:%s", new Object[] { paramJSONObject });
          parame = Base64.decode(paramJSONObject.substring(paramJSONObject.indexOf("base64,") + 7).trim(), 0);
          if ((parame == null) || (parame.length == 0))
          {
            ae.i("Luggage.ViewAttributeHelper", "bytes is empty");
            AppMethodBeat.o(137889);
            return;
          }
          parama.setImageByteArray(parame);
          AppMethodBeat.o(137889);
          return;
        }
        paramJSONObject = ((b)parame.K(b.class)).b(parame, paramJSONObject);
        ((com.tencent.mm.plugin.appbrand.f.a)parame.K(com.tencent.mm.plugin.appbrand.f.a.class)).a(paramJSONObject, d.Re(str), new a.c()
        {
          public final void D(InputStream paramAnonymousInputStream)
          {
            AppMethodBeat.i(197275);
            if (paramAnonymousInputStream == null)
            {
              ae.e("Luggage.ViewAttributeHelper", "attachImageViewAttribute, openRead failed, url=%s", new Object[] { this.hTt });
              AppMethodBeat.o(197275);
              return;
            }
            paramAnonymousInputStream = c.G(paramAnonymousInputStream);
            paramAnonymousInputStream.mark(c.getCompatibleRewindBufferSize());
            Object localObject = new BitmapFactory.Options();
            ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
            c.bkN().b(paramAnonymousInputStream, (BitmapFactory.Options)localObject);
            localObject = ((BitmapFactory.Options)localObject).outMimeType;
            int i = -1;
            switch (((String)localObject).hashCode())
            {
            }
            for (;;)
            {
              switch (i)
              {
              }
              try
              {
                paramAnonymousInputStream.reset();
                localObject = c.bkN().decodeStream(paramAnonymousInputStream);
                org.apache.commons.a.e.Z(paramAnonymousInputStream);
                if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
                {
                  paramAnonymousInputStream = (com.tencent.mm.plugin.appbrand.jsapi.c)this.daA.get();
                  locala = (com.tencent.mm.plugin.appbrand.widget.b.a)this.lyg.get();
                  if ((paramAnonymousInputStream != null) && (locala != null)) {
                    paramAnonymousInputStream.K(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(197274);
                        locala.setImageBitmap(this.val$bmp);
                        AppMethodBeat.o(197274);
                      }
                    });
                  }
                }
                AppMethodBeat.o(197275);
                return;
              }
              catch (Throwable paramAnonymousInputStream)
              {
                final com.tencent.mm.plugin.appbrand.widget.b.a locala;
                ae.e("Luggage.ViewAttributeHelper", "attachImageViewAttribute, setImageBitmap failed, url=%s", new Object[] { this.hTt });
                AppMethodBeat.o(197275);
              }
              if (((String)localObject).equals("image/gif"))
              {
                i = 0;
                continue;
                if (((String)localObject).equals("image/GIF")) {
                  i = 1;
                }
              }
            }
            try
            {
              paramAnonymousInputStream.reset();
              localObject = org.apache.commons.a.e.toByteArray(paramAnonymousInputStream);
              org.apache.commons.a.e.Z(paramAnonymousInputStream);
              paramAnonymousInputStream = (com.tencent.mm.plugin.appbrand.jsapi.c)this.daA.get();
              locala = (com.tencent.mm.plugin.appbrand.widget.b.a)this.lyg.get();
              if ((paramAnonymousInputStream != null) && (locala != null)) {
                paramAnonymousInputStream.K(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(137887);
                    locala.setImageByteArray(this.lyi);
                    AppMethodBeat.o(137887);
                  }
                });
              }
              AppMethodBeat.o(197275);
              return;
            }
            catch (Throwable paramAnonymousInputStream)
            {
              ae.e("Luggage.ViewAttributeHelper", "attachImageViewAttribute, setImageByteArray failed, url=%s", new Object[] { this.hTt });
              AppMethodBeat.o(197275);
              return;
            }
          }
        });
      }
      AppMethodBeat.o(137889);
      return;
    }
    catch (NullPointerException parame)
    {
      ae.printErrStackTrace("Luggage.ViewAttributeHelper", parame, "attachImageViewAttribute", new Object[0]);
      AppMethodBeat.o(137889);
    }
  }
  
  public static int getCompatibleRewindBufferSize()
  {
    AppMethodBeat.i(197278);
    if ("HUAWEI".equals(Build.MANUFACTURER))
    {
      AppMethodBeat.o(197278);
      return 8388608;
    }
    AppMethodBeat.o(197278);
    return 8388608;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.c
 * JD-Core Version:    0.7.0.1
 */