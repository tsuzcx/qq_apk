package com.tencent.mm.plugin.appbrand.jsapi.ac;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.os.Build;
import android.text.TextUtils.TruncateAt;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.f.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.media.e.a;
import com.tencent.mm.plugin.appbrand.widget.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;

public final class c
{
  public static InputStream F(InputStream paramInputStream)
  {
    AppMethodBeat.i(193731);
    if (paramInputStream.markSupported())
    {
      AppMethodBeat.o(193731);
      return paramInputStream;
    }
    if ((paramInputStream instanceof FileInputStream))
    {
      paramInputStream = new c.c((FileInputStream)paramInputStream);
      AppMethodBeat.o(193731);
      return paramInputStream;
    }
    paramInputStream = new BufferedInputStream(paramInputStream);
    AppMethodBeat.o(193731);
    return paramInputStream;
  }
  
  /* Error */
  public static void a(a parama, org.json.JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: ldc 52
    //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnull +7 -> 13
    //   9: aload_1
    //   10: ifnonnull +9 -> 19
    //   13: ldc 52
    //   15: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   18: return
    //   19: aload_1
    //   20: ldc 54
    //   22: invokevirtual 60	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   25: astore_2
    //   26: aload_2
    //   27: invokestatic 66	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   30: ifne +13 -> 43
    //   33: aload_0
    //   34: aload_2
    //   35: invokestatic 72	com/tencent/mm/plugin/appbrand/ac/g:afD	(Ljava/lang/String;)I
    //   38: invokeinterface 75 2 0
    //   43: aload_0
    //   44: iconst_0
    //   45: aload_1
    //   46: ldc 77
    //   48: invokevirtual 81	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   51: d2f
    //   52: invokestatic 85	com/tencent/mm/plugin/appbrand/ac/g:aT	(F)F
    //   55: invokeinterface 89 3 0
    //   60: aload_1
    //   61: ldc 91
    //   63: invokevirtual 60	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   66: astore_2
    //   67: ldc 93
    //   69: aload_2
    //   70: invokevirtual 99	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   73: ifeq +107 -> 180
    //   76: aload_0
    //   77: iconst_3
    //   78: invokeinterface 102 2 0
    //   83: aload_1
    //   84: ldc 104
    //   86: invokevirtual 60	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   89: astore_2
    //   90: ldc 106
    //   92: aload_2
    //   93: invokevirtual 99	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   96: ifeq +122 -> 218
    //   99: aload_0
    //   100: iconst_1
    //   101: invokeinterface 110 2 0
    //   106: aload_0
    //   107: aload_1
    //   108: ldc 112
    //   110: aload_0
    //   111: invokeinterface 116 1 0
    //   116: ldc 117
    //   118: fmul
    //   119: invokestatic 123	java/lang/Math:round	(F)I
    //   122: invokestatic 126	com/tencent/mm/plugin/appbrand/ac/g:a	(Lorg/json/JSONObject;Ljava/lang/String;I)I
    //   125: invokeinterface 129 2 0
    //   130: aload_1
    //   131: ldc 131
    //   133: invokevirtual 60	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   136: astore_2
    //   137: ldc 133
    //   139: aload_2
    //   140: invokevirtual 99	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   143: ifeq +98 -> 241
    //   146: aload_0
    //   147: getstatic 139	android/text/TextUtils$TruncateAt:END	Landroid/text/TextUtils$TruncateAt;
    //   150: invokeinterface 143 2 0
    //   155: aload_0
    //   156: iconst_1
    //   157: invokeinterface 146 2 0
    //   162: aload_0
    //   163: aload_1
    //   164: ldc 148
    //   166: invokevirtual 60	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   169: invokeinterface 152 2 0
    //   174: ldc 52
    //   176: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   179: return
    //   180: ldc 154
    //   182: aload_2
    //   183: invokevirtual 99	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   186: ifeq +13 -> 199
    //   189: aload_0
    //   190: iconst_1
    //   191: invokeinterface 102 2 0
    //   196: goto -113 -> 83
    //   199: ldc 156
    //   201: aload_2
    //   202: invokevirtual 99	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   205: ifeq -122 -> 83
    //   208: aload_0
    //   209: iconst_5
    //   210: invokeinterface 102 2 0
    //   215: goto -132 -> 83
    //   218: ldc 158
    //   220: aload_2
    //   221: invokevirtual 99	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   224: ifeq -118 -> 106
    //   227: aload_0
    //   228: iconst_0
    //   229: invokeinterface 110 2 0
    //   234: goto -128 -> 106
    //   237: astore_2
    //   238: goto -132 -> 106
    //   241: ldc 160
    //   243: aload_2
    //   244: invokevirtual 99	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   247: ifeq +13 -> 260
    //   250: aload_0
    //   251: iconst_1
    //   252: invokeinterface 146 2 0
    //   257: goto -95 -> 162
    //   260: ldc 162
    //   262: aload_2
    //   263: invokevirtual 99	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   266: ifeq +13 -> 279
    //   269: aload_0
    //   270: iconst_0
    //   271: invokeinterface 146 2 0
    //   276: goto -114 -> 162
    //   279: ldc 164
    //   281: aload_2
    //   282: invokevirtual 99	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   285: ifeq -123 -> 162
    //   288: aload_0
    //   289: iconst_0
    //   290: invokeinterface 146 2 0
    //   295: goto -133 -> 162
    //   298: astore_0
    //   299: ldc 52
    //   301: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   304: return
    //   305: astore_2
    //   306: goto -246 -> 60
    //   309: astore_2
    //   310: goto -267 -> 43
    //   313: astore_2
    //   314: goto -231 -> 83
    //   317: astore_2
    //   318: goto -156 -> 162
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	321	0	parama	a
    //   0	321	1	paramJSONObject	org.json.JSONObject
    //   25	196	2	str	String
    //   237	45	2	localJSONException1	org.json.JSONException
    //   305	1	2	localJSONException2	org.json.JSONException
    //   309	1	2	localJSONException3	org.json.JSONException
    //   313	1	2	localJSONException4	org.json.JSONException
    //   317	1	2	localJSONException5	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   83	106	237	org/json/JSONException
    //   218	234	237	org/json/JSONException
    //   162	174	298	org/json/JSONException
    //   43	60	305	org/json/JSONException
    //   19	43	309	org/json/JSONException
    //   60	83	313	org/json/JSONException
    //   180	196	313	org/json/JSONException
    //   199	215	313	org/json/JSONException
    //   130	162	317	org/json/JSONException
    //   241	257	317	org/json/JSONException
    //   260	276	317	org/json/JSONException
    //   279	295	317	org/json/JSONException
  }
  
  /* Error */
  public static void a(com.tencent.mm.plugin.appbrand.jsapi.h paramh, int paramInt, a parama, org.json.JSONObject paramJSONObject, final b paramb)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: ldc 172
    //   5: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_2
    //   9: ifnull +7 -> 16
    //   12: aload_3
    //   13: ifnonnull +9 -> 22
    //   16: ldc 172
    //   18: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: return
    //   22: aload_0
    //   23: aload_2
    //   24: aload_3
    //   25: invokestatic 177	com/tencent/mm/plugin/appbrand/jsapi/u/d:a	(Lcom/tencent/mm/plugin/appbrand/jsapi/f;Lcom/tencent/mm/plugin/appbrand/jsapi/u/b;Lorg/json/JSONObject;)Ljava/lang/String;
    //   28: astore 6
    //   30: aload_3
    //   31: ldc 179
    //   33: invokevirtual 182	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   36: astore_3
    //   37: aload_3
    //   38: invokestatic 188	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   41: ifne +334 -> 375
    //   44: aload_3
    //   45: ldc 190
    //   47: invokevirtual 193	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   50: ifeq +256 -> 306
    //   53: aload_3
    //   54: ldc 195
    //   56: invokevirtual 198	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   59: ifeq +247 -> 306
    //   62: ldc 200
    //   64: ldc 202
    //   66: iconst_1
    //   67: anewarray 4	java/lang/Object
    //   70: dup
    //   71: iconst_0
    //   72: aload_3
    //   73: aastore
    //   74: invokestatic 207	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   77: aload_3
    //   78: aload_3
    //   79: ldc 209
    //   81: invokevirtual 212	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   84: bipush 7
    //   86: iadd
    //   87: invokevirtual 216	java/lang/String:substring	(I)Ljava/lang/String;
    //   90: invokevirtual 220	java/lang/String:trim	()Ljava/lang/String;
    //   93: iconst_0
    //   94: invokestatic 226	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   97: astore 6
    //   99: aload 6
    //   101: ifnull +9 -> 110
    //   104: aload 6
    //   106: arraylength
    //   107: ifne +24 -> 131
    //   110: ldc 200
    //   112: ldc 228
    //   114: invokestatic 231	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   117: aload 4
    //   119: aconst_null
    //   120: invokeinterface 235 2 0
    //   125: ldc 172
    //   127: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   130: return
    //   131: new 237	android/graphics/BitmapFactory$Options
    //   134: dup
    //   135: invokespecial 240	android/graphics/BitmapFactory$Options:<init>	()V
    //   138: astore_3
    //   139: aload_3
    //   140: iconst_1
    //   141: putfield 244	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   144: new 246	java/io/ByteArrayInputStream
    //   147: dup
    //   148: aload 6
    //   150: invokespecial 249	java/io/ByteArrayInputStream:<init>	([B)V
    //   153: astore 7
    //   155: invokestatic 253	com/tencent/mm/plugin/appbrand/jsapi/ac/c:bLi	()Lcom/tencent/mm/plugin/appbrand/jsapi/media/e;
    //   158: aload 7
    //   160: aload_3
    //   161: invokeinterface 258 3 0
    //   166: pop
    //   167: aload 4
    //   169: aload_3
    //   170: invokeinterface 235 2 0
    //   175: aload 7
    //   177: invokevirtual 261	java/io/ByteArrayInputStream:close	()V
    //   180: aload_2
    //   181: aload 6
    //   183: invokeinterface 266 2 0
    //   188: ldc 172
    //   190: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   193: return
    //   194: astore 5
    //   196: ldc 172
    //   198: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   201: aload 5
    //   203: athrow
    //   204: astore_3
    //   205: aload 5
    //   207: ifnull +91 -> 298
    //   210: aload 7
    //   212: invokevirtual 261	java/io/ByteArrayInputStream:close	()V
    //   215: ldc 172
    //   217: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   220: aload_3
    //   221: athrow
    //   222: astore_3
    //   223: ldc 200
    //   225: ldc_w 268
    //   228: iconst_3
    //   229: anewarray 4	java/lang/Object
    //   232: dup
    //   233: iconst_0
    //   234: aload_0
    //   235: invokeinterface 273 1 0
    //   240: aastore
    //   241: dup
    //   242: iconst_1
    //   243: iload_1
    //   244: invokestatic 279	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   247: aastore
    //   248: dup
    //   249: iconst_2
    //   250: aload_3
    //   251: aastore
    //   252: invokestatic 282	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   255: aload 4
    //   257: aconst_null
    //   258: invokeinterface 235 2 0
    //   263: goto -83 -> 180
    //   266: astore_0
    //   267: ldc 200
    //   269: aload_0
    //   270: ldc_w 284
    //   273: iconst_0
    //   274: anewarray 4	java/lang/Object
    //   277: invokestatic 288	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   280: ldc 172
    //   282: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   285: return
    //   286: astore 7
    //   288: aload 5
    //   290: aload 7
    //   292: invokevirtual 292	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   295: goto -80 -> 215
    //   298: aload 7
    //   300: invokevirtual 261	java/io/ByteArrayInputStream:close	()V
    //   303: goto -88 -> 215
    //   306: aload_0
    //   307: ldc_w 294
    //   310: invokeinterface 298 2 0
    //   315: checkcast 294	com/tencent/mm/plugin/appbrand/f/b
    //   318: aload_0
    //   319: aload_3
    //   320: invokeinterface 301 3 0
    //   325: astore_3
    //   326: aload_0
    //   327: ldc_w 303
    //   330: invokeinterface 298 2 0
    //   335: checkcast 303	com/tencent/mm/plugin/appbrand/f/a
    //   338: aload_3
    //   339: aload 6
    //   341: invokestatic 307	com/tencent/mm/plugin/appbrand/jsapi/u/d:aaG	(Ljava/lang/String;)Ljava/util/Map;
    //   344: new 6	com/tencent/mm/plugin/appbrand/jsapi/ac/c$1
    //   347: dup
    //   348: aload_3
    //   349: aload 4
    //   351: new 309	java/lang/ref/WeakReference
    //   354: dup
    //   355: aload_0
    //   356: invokespecial 312	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   359: new 309	java/lang/ref/WeakReference
    //   362: dup
    //   363: aload_2
    //   364: invokespecial 312	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   367: invokespecial 315	com/tencent/mm/plugin/appbrand/jsapi/ac/c$1:<init>	(Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/jsapi/ac/c$b;Ljava/lang/ref/WeakReference;Ljava/lang/ref/WeakReference;)V
    //   370: invokeinterface 318 4 0
    //   375: ldc 172
    //   377: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   380: return
    //   381: astore_3
    //   382: goto -177 -> 205
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	385	0	paramh	com.tencent.mm.plugin.appbrand.jsapi.h
    //   0	385	1	paramInt	int
    //   0	385	2	parama	a
    //   0	385	3	paramJSONObject	org.json.JSONObject
    //   0	385	4	paramb	b
    //   1	1	5	localObject1	Object
    //   194	95	5	localThrowable1	Throwable
    //   28	312	6	localObject2	Object
    //   153	58	7	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   286	13	7	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   155	175	194	java/lang/Throwable
    //   196	204	204	finally
    //   144	155	222	java/lang/Exception
    //   175	180	222	java/lang/Exception
    //   210	215	222	java/lang/Exception
    //   215	222	222	java/lang/Exception
    //   288	295	222	java/lang/Exception
    //   298	303	222	java/lang/Exception
    //   22	99	266	java/lang/NullPointerException
    //   104	110	266	java/lang/NullPointerException
    //   110	125	266	java/lang/NullPointerException
    //   131	144	266	java/lang/NullPointerException
    //   144	155	266	java/lang/NullPointerException
    //   175	180	266	java/lang/NullPointerException
    //   180	188	266	java/lang/NullPointerException
    //   210	215	266	java/lang/NullPointerException
    //   215	222	266	java/lang/NullPointerException
    //   223	263	266	java/lang/NullPointerException
    //   288	295	266	java/lang/NullPointerException
    //   298	303	266	java/lang/NullPointerException
    //   306	375	266	java/lang/NullPointerException
    //   210	215	286	java/lang/Throwable
    //   155	175	381	finally
  }
  
  static com.tencent.mm.plugin.appbrand.jsapi.media.e bLi()
  {
    AppMethodBeat.i(193728);
    com.tencent.mm.plugin.appbrand.jsapi.media.e locale = e.a.a((com.tencent.mm.plugin.appbrand.jsapi.media.e)com.tencent.luggage.a.e.M(com.tencent.mm.plugin.appbrand.jsapi.media.e.class));
    AppMethodBeat.o(193728);
    return locale;
  }
  
  public static int getCompatibleRewindBufferSize()
  {
    AppMethodBeat.i(193730);
    if ("HUAWEI".equals(Build.MANUFACTURER))
    {
      AppMethodBeat.o(193730);
      return 8388608;
    }
    AppMethodBeat.o(193730);
    return 8388608;
  }
  
  public static abstract interface a
  {
    public abstract float getTextSize();
    
    public abstract void setEllipsize(TextUtils.TruncateAt paramTruncateAt);
    
    public abstract void setFakeBoldText(boolean paramBoolean);
    
    public abstract void setGravity(int paramInt);
    
    public abstract void setLineHeight(int paramInt);
    
    public abstract void setSingleLine(boolean paramBoolean);
    
    public abstract void setText(CharSequence paramCharSequence);
    
    public abstract void setTextColor(int paramInt);
    
    public abstract void setTextSize(int paramInt, float paramFloat);
  }
  
  public static abstract interface b
  {
    public abstract void f(BitmapFactory.Options paramOptions);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ac.c
 * JD-Core Version:    0.7.0.1
 */