package com.tencent.mm.plugin.appbrand.jsapi.ah;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils.TruncateAt;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.f.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.media.e.a;
import com.tencent.mm.plugin.appbrand.widget.c.a;
import java.lang.ref.WeakReference;

public final class c
{
  /* Error */
  public static void a(a parama, org.json.JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: ldc 20
    //   2: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnull +7 -> 13
    //   9: aload_1
    //   10: ifnonnull +9 -> 19
    //   13: ldc 20
    //   15: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   18: return
    //   19: aload_1
    //   20: ldc 31
    //   22: invokevirtual 37	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   25: astore_2
    //   26: aload_2
    //   27: invokestatic 43	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   30: ifne +13 -> 43
    //   33: aload_0
    //   34: aload_2
    //   35: invokestatic 49	com/tencent/mm/plugin/appbrand/af/i:agv	(Ljava/lang/String;)I
    //   38: invokeinterface 52 2 0
    //   43: aload_0
    //   44: iconst_0
    //   45: aload_1
    //   46: ldc 54
    //   48: invokevirtual 58	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   51: d2f
    //   52: invokestatic 62	com/tencent/mm/plugin/appbrand/af/i:bW	(F)F
    //   55: invokeinterface 66 3 0
    //   60: aload_1
    //   61: ldc 68
    //   63: invokevirtual 37	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   66: astore_2
    //   67: ldc 70
    //   69: aload_2
    //   70: invokevirtual 76	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   73: ifeq +107 -> 180
    //   76: aload_0
    //   77: iconst_3
    //   78: invokeinterface 79 2 0
    //   83: aload_1
    //   84: ldc 81
    //   86: invokevirtual 37	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   89: astore_2
    //   90: ldc 83
    //   92: aload_2
    //   93: invokevirtual 76	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   96: ifeq +122 -> 218
    //   99: aload_0
    //   100: iconst_1
    //   101: invokeinterface 87 2 0
    //   106: aload_0
    //   107: aload_1
    //   108: ldc 89
    //   110: aload_0
    //   111: invokeinterface 93 1 0
    //   116: ldc 94
    //   118: fmul
    //   119: invokestatic 100	java/lang/Math:round	(F)I
    //   122: invokestatic 103	com/tencent/mm/plugin/appbrand/af/i:a	(Lorg/json/JSONObject;Ljava/lang/String;I)I
    //   125: invokeinterface 106 2 0
    //   130: aload_1
    //   131: ldc 108
    //   133: invokevirtual 37	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   136: astore_2
    //   137: ldc 110
    //   139: aload_2
    //   140: invokevirtual 76	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   143: ifeq +98 -> 241
    //   146: aload_0
    //   147: getstatic 116	android/text/TextUtils$TruncateAt:END	Landroid/text/TextUtils$TruncateAt;
    //   150: invokeinterface 120 2 0
    //   155: aload_0
    //   156: iconst_1
    //   157: invokeinterface 123 2 0
    //   162: aload_0
    //   163: aload_1
    //   164: ldc 125
    //   166: invokevirtual 37	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   169: invokeinterface 129 2 0
    //   174: ldc 20
    //   176: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   179: return
    //   180: ldc 131
    //   182: aload_2
    //   183: invokevirtual 76	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   186: ifeq +13 -> 199
    //   189: aload_0
    //   190: iconst_1
    //   191: invokeinterface 79 2 0
    //   196: goto -113 -> 83
    //   199: ldc 133
    //   201: aload_2
    //   202: invokevirtual 76	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   205: ifeq -122 -> 83
    //   208: aload_0
    //   209: iconst_5
    //   210: invokeinterface 79 2 0
    //   215: goto -132 -> 83
    //   218: ldc 135
    //   220: aload_2
    //   221: invokevirtual 76	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   224: ifeq -118 -> 106
    //   227: aload_0
    //   228: iconst_0
    //   229: invokeinterface 87 2 0
    //   234: goto -128 -> 106
    //   237: astore_2
    //   238: goto -132 -> 106
    //   241: ldc 137
    //   243: aload_2
    //   244: invokevirtual 76	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   247: ifeq +13 -> 260
    //   250: aload_0
    //   251: iconst_1
    //   252: invokeinterface 123 2 0
    //   257: goto -95 -> 162
    //   260: ldc 139
    //   262: aload_2
    //   263: invokevirtual 76	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   266: ifeq +13 -> 279
    //   269: aload_0
    //   270: iconst_0
    //   271: invokeinterface 123 2 0
    //   276: goto -114 -> 162
    //   279: ldc 141
    //   281: aload_2
    //   282: invokevirtual 76	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   285: ifeq -123 -> 162
    //   288: aload_0
    //   289: iconst_0
    //   290: invokeinterface 123 2 0
    //   295: goto -133 -> 162
    //   298: astore_0
    //   299: ldc 20
    //   301: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0: ldc 148
    //   2: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_2
    //   6: ifnull +7 -> 13
    //   9: aload_3
    //   10: ifnonnull +9 -> 19
    //   13: ldc 148
    //   15: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   18: return
    //   19: aload_0
    //   20: aload_2
    //   21: aload_3
    //   22: invokestatic 153	com/tencent/mm/plugin/appbrand/jsapi/y/d:a	(Lcom/tencent/mm/plugin/appbrand/jsapi/f;Lcom/tencent/mm/plugin/appbrand/jsapi/y/b;Lorg/json/JSONObject;)Ljava/lang/String;
    //   25: astore 5
    //   27: aload_3
    //   28: ldc 155
    //   30: invokevirtual 158	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   33: astore_3
    //   34: aload_3
    //   35: invokestatic 164	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   38: ifne +313 -> 351
    //   41: aload_3
    //   42: ldc 166
    //   44: invokevirtual 169	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   47: ifeq +235 -> 282
    //   50: aload_3
    //   51: ldc 171
    //   53: invokevirtual 174	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   56: ifeq +226 -> 282
    //   59: ldc 176
    //   61: ldc 178
    //   63: iconst_1
    //   64: anewarray 4	java/lang/Object
    //   67: dup
    //   68: iconst_0
    //   69: aload_3
    //   70: aastore
    //   71: invokestatic 183	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   74: aload_3
    //   75: aload_3
    //   76: ldc 185
    //   78: invokevirtual 188	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   81: bipush 7
    //   83: iadd
    //   84: invokevirtual 192	java/lang/String:substring	(I)Ljava/lang/String;
    //   87: invokevirtual 196	java/lang/String:trim	()Ljava/lang/String;
    //   90: iconst_0
    //   91: invokestatic 202	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   94: astore_3
    //   95: aload_3
    //   96: ifnull +8 -> 104
    //   99: aload_3
    //   100: arraylength
    //   101: ifne +24 -> 125
    //   104: ldc 176
    //   106: ldc 204
    //   108: invokestatic 207	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   111: aload 4
    //   113: aconst_null
    //   114: invokeinterface 211 2 0
    //   119: ldc 148
    //   121: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   124: return
    //   125: new 213	android/graphics/BitmapFactory$Options
    //   128: dup
    //   129: invokespecial 217	android/graphics/BitmapFactory$Options:<init>	()V
    //   132: astore 6
    //   134: aload 6
    //   136: iconst_1
    //   137: putfield 221	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   140: new 223	java/io/ByteArrayInputStream
    //   143: dup
    //   144: aload_3
    //   145: invokespecial 226	java/io/ByteArrayInputStream:<init>	([B)V
    //   148: astore 5
    //   150: invokestatic 230	com/tencent/mm/plugin/appbrand/jsapi/ah/c:csY	()Lcom/tencent/mm/plugin/appbrand/jsapi/media/e;
    //   153: aload 5
    //   155: aload 6
    //   157: invokeinterface 235 3 0
    //   162: pop
    //   163: aload 4
    //   165: aload 6
    //   167: invokeinterface 211 2 0
    //   172: aload 5
    //   174: invokevirtual 238	java/io/ByteArrayInputStream:close	()V
    //   177: aload_2
    //   178: aload_3
    //   179: invokeinterface 243 2 0
    //   184: ldc 148
    //   186: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   189: return
    //   190: astore 6
    //   192: aload 5
    //   194: invokevirtual 238	java/io/ByteArrayInputStream:close	()V
    //   197: ldc 148
    //   199: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   202: aload 6
    //   204: athrow
    //   205: astore 5
    //   207: ldc 176
    //   209: ldc 245
    //   211: iconst_3
    //   212: anewarray 4	java/lang/Object
    //   215: dup
    //   216: iconst_0
    //   217: aload_0
    //   218: invokeinterface 250 1 0
    //   223: aastore
    //   224: dup
    //   225: iconst_1
    //   226: iload_1
    //   227: invokestatic 256	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   230: aastore
    //   231: dup
    //   232: iconst_2
    //   233: aload 5
    //   235: aastore
    //   236: invokestatic 259	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   239: aload 4
    //   241: aconst_null
    //   242: invokeinterface 211 2 0
    //   247: goto -70 -> 177
    //   250: astore_0
    //   251: ldc 176
    //   253: aload_0
    //   254: ldc_w 261
    //   257: iconst_0
    //   258: anewarray 4	java/lang/Object
    //   261: invokestatic 265	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   264: ldc 148
    //   266: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   269: return
    //   270: astore 5
    //   272: aload 6
    //   274: aload 5
    //   276: invokevirtual 271	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   279: goto -82 -> 197
    //   282: aload_0
    //   283: ldc_w 273
    //   286: invokeinterface 277 2 0
    //   291: checkcast 273	com/tencent/mm/plugin/appbrand/f/b
    //   294: aload_0
    //   295: aload_3
    //   296: invokeinterface 280 3 0
    //   301: astore_3
    //   302: aload_0
    //   303: ldc_w 282
    //   306: invokeinterface 277 2 0
    //   311: checkcast 282	com/tencent/mm/plugin/appbrand/f/a
    //   314: aload_3
    //   315: aload 5
    //   317: invokestatic 286	com/tencent/mm/plugin/appbrand/jsapi/y/d:abw	(Ljava/lang/String;)Ljava/util/Map;
    //   320: new 6	com/tencent/mm/plugin/appbrand/jsapi/ah/c$1
    //   323: dup
    //   324: aload_3
    //   325: aload 4
    //   327: new 288	java/lang/ref/WeakReference
    //   330: dup
    //   331: aload_0
    //   332: invokespecial 291	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   335: new 288	java/lang/ref/WeakReference
    //   338: dup
    //   339: aload_2
    //   340: invokespecial 291	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   343: invokespecial 294	com/tencent/mm/plugin/appbrand/jsapi/ah/c$1:<init>	(Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/jsapi/ah/c$b;Ljava/lang/ref/WeakReference;Ljava/lang/ref/WeakReference;)V
    //   346: invokeinterface 297 4 0
    //   351: ldc 148
    //   353: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   356: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	357	0	paramh	com.tencent.mm.plugin.appbrand.jsapi.h
    //   0	357	1	paramInt	int
    //   0	357	2	parama	a
    //   0	357	3	paramJSONObject	org.json.JSONObject
    //   0	357	4	paramb	b
    //   25	168	5	localObject1	Object
    //   205	29	5	localException	java.lang.Exception
    //   270	46	5	localThrowable	java.lang.Throwable
    //   132	34	6	localOptions	BitmapFactory.Options
    //   190	83	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   150	172	190	finally
    //   140	150	205	java/lang/Exception
    //   172	177	205	java/lang/Exception
    //   197	205	205	java/lang/Exception
    //   272	279	205	java/lang/Exception
    //   19	95	250	java/lang/NullPointerException
    //   99	104	250	java/lang/NullPointerException
    //   104	119	250	java/lang/NullPointerException
    //   125	140	250	java/lang/NullPointerException
    //   140	150	250	java/lang/NullPointerException
    //   172	177	250	java/lang/NullPointerException
    //   177	184	250	java/lang/NullPointerException
    //   197	205	250	java/lang/NullPointerException
    //   207	247	250	java/lang/NullPointerException
    //   272	279	250	java/lang/NullPointerException
    //   282	351	250	java/lang/NullPointerException
    //   192	197	270	finally
  }
  
  static com.tencent.mm.plugin.appbrand.jsapi.media.e csY()
  {
    AppMethodBeat.i(325957);
    com.tencent.mm.plugin.appbrand.jsapi.media.e locale = e.a.a((com.tencent.mm.plugin.appbrand.jsapi.media.e)com.tencent.luggage.a.e.T(com.tencent.mm.plugin.appbrand.jsapi.media.e.class));
    AppMethodBeat.o(325957);
    return locale;
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
    public abstract void c(BitmapFactory.Options paramOptions);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ah.c
 * JD-Core Version:    0.7.0.1
 */