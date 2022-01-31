package com.tencent.mm.plugin.appbrand.jsapi.media;

final class b$b
  implements b.c
{
  /* Error */
  public final b.a a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, java.lang.String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokeinterface 30 1 0
    //   6: astore 5
    //   8: aload 5
    //   10: ifnonnull +21 -> 31
    //   13: ldc 32
    //   15: ldc 34
    //   17: invokestatic 40	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   20: new 42	com/tencent/mm/plugin/appbrand/jsapi/media/b$a
    //   23: dup
    //   24: iconst_0
    //   25: ldc 44
    //   27: invokespecial 47	com/tencent/mm/plugin/appbrand/jsapi/media/b$a:<init>	(ZLjava/lang/String;)V
    //   30: areturn
    //   31: aload_1
    //   32: invokeinterface 30 1 0
    //   37: aload_2
    //   38: invokeinterface 53 2 0
    //   43: astore 6
    //   45: aload 6
    //   47: ifnonnull +21 -> 68
    //   50: ldc 32
    //   52: ldc 55
    //   54: invokestatic 40	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: new 42	com/tencent/mm/plugin/appbrand/jsapi/media/b$a
    //   60: dup
    //   61: iconst_0
    //   62: ldc 57
    //   64: invokespecial 47	com/tencent/mm/plugin/appbrand/jsapi/media/b$a:<init>	(ZLjava/lang/String;)V
    //   67: areturn
    //   68: aconst_null
    //   69: astore_2
    //   70: new 59	android/graphics/BitmapFactory$Options
    //   73: dup
    //   74: invokespecial 60	android/graphics/BitmapFactory$Options:<init>	()V
    //   77: astore 7
    //   79: aload 6
    //   81: invokevirtual 66	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   84: aload 7
    //   86: iconst_0
    //   87: invokestatic 72	com/tencent/mm/sdk/platformtools/MMBitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;I)Landroid/graphics/Bitmap;
    //   90: astore 8
    //   92: aload 8
    //   94: ifnonnull +50 -> 144
    //   97: ldc 32
    //   99: ldc 74
    //   101: invokestatic 77	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   104: new 42	com/tencent/mm/plugin/appbrand/jsapi/media/b$a
    //   107: dup
    //   108: iconst_0
    //   109: ldc 79
    //   111: invokespecial 47	com/tencent/mm/plugin/appbrand/jsapi/media/b$a:<init>	(ZLjava/lang/String;)V
    //   114: astore_1
    //   115: aload_1
    //   116: areturn
    //   117: astore_1
    //   118: ldc 32
    //   120: ldc 81
    //   122: iconst_1
    //   123: anewarray 4	java/lang/Object
    //   126: dup
    //   127: iconst_0
    //   128: aload_1
    //   129: aastore
    //   130: invokestatic 84	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   133: new 42	com/tencent/mm/plugin/appbrand/jsapi/media/b$a
    //   136: dup
    //   137: iconst_0
    //   138: ldc 86
    //   140: invokespecial 47	com/tencent/mm/plugin/appbrand/jsapi/media/b$a:<init>	(ZLjava/lang/String;)V
    //   143: areturn
    //   144: aload 7
    //   146: invokestatic 91	com/tencent/mm/plugin/appbrand/v/a:a	(Landroid/graphics/BitmapFactory$Options;)Z
    //   149: ifeq +164 -> 313
    //   152: ldc 93
    //   154: astore_1
    //   155: new 95	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   162: getstatic 102	com/tencent/mm/compatible/util/e:dzD	Ljava/lang/String;
    //   165: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: ldc 108
    //   170: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: invokestatic 114	java/lang/System:currentTimeMillis	()J
    //   176: invokevirtual 117	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   179: ldc 119
    //   181: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: aload_1
    //   185: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: astore 4
    //   193: aload 7
    //   195: invokestatic 91	com/tencent/mm/plugin/appbrand/v/a:a	(Landroid/graphics/BitmapFactory$Options;)Z
    //   198: ifeq +121 -> 319
    //   201: getstatic 128	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   204: astore_2
    //   205: aload 8
    //   207: iload_3
    //   208: aload_2
    //   209: aload 4
    //   211: iconst_1
    //   212: invokestatic 133	com/tencent/mm/sdk/platformtools/c:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)V
    //   215: aload 7
    //   217: invokestatic 91	com/tencent/mm/plugin/appbrand/v/a:a	(Landroid/graphics/BitmapFactory$Options;)Z
    //   220: ifeq +13 -> 233
    //   223: aload 6
    //   225: invokevirtual 66	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   228: aload 4
    //   230: invokestatic 138	com/tencent/mm/plugin/appbrand/h/b:bv	(Ljava/lang/String;Ljava/lang/String;)V
    //   233: new 140	com/tencent/mm/plugin/appbrand/u/k
    //   236: dup
    //   237: invokespecial 141	com/tencent/mm/plugin/appbrand/u/k:<init>	()V
    //   240: astore_2
    //   241: aload 5
    //   243: new 62	java/io/File
    //   246: dup
    //   247: aload 4
    //   249: invokespecial 144	java/io/File:<init>	(Ljava/lang/String;)V
    //   252: aload_1
    //   253: iconst_0
    //   254: aload_2
    //   255: invokeinterface 147 5 0
    //   260: getstatic 153	com/tencent/mm/plugin/appbrand/appstorage/h:fGU	Lcom/tencent/mm/plugin/appbrand/appstorage/h;
    //   263: if_acmpeq +63 -> 326
    //   266: ldc 32
    //   268: ldc 155
    //   270: invokestatic 40	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   273: new 42	com/tencent/mm/plugin/appbrand/jsapi/media/b$a
    //   276: dup
    //   277: iconst_0
    //   278: ldc 157
    //   280: invokespecial 47	com/tencent/mm/plugin/appbrand/jsapi/media/b$a:<init>	(ZLjava/lang/String;)V
    //   283: astore_1
    //   284: aload_1
    //   285: areturn
    //   286: astore_1
    //   287: ldc 32
    //   289: ldc 159
    //   291: iconst_1
    //   292: anewarray 4	java/lang/Object
    //   295: dup
    //   296: iconst_0
    //   297: aload_1
    //   298: aastore
    //   299: invokestatic 84	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   302: new 42	com/tencent/mm/plugin/appbrand/jsapi/media/b$a
    //   305: dup
    //   306: iconst_0
    //   307: ldc 161
    //   309: invokespecial 47	com/tencent/mm/plugin/appbrand/jsapi/media/b$a:<init>	(ZLjava/lang/String;)V
    //   312: areturn
    //   313: ldc 163
    //   315: astore_1
    //   316: goto -161 -> 155
    //   319: getstatic 166	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   322: astore_2
    //   323: goto -118 -> 205
    //   326: ldc 32
    //   328: ldc 168
    //   330: iconst_2
    //   331: anewarray 4	java/lang/Object
    //   334: dup
    //   335: iconst_0
    //   336: aload 4
    //   338: aastore
    //   339: dup
    //   340: iconst_1
    //   341: aload_2
    //   342: getfield 172	com/tencent/mm/plugin/appbrand/u/k:value	Ljava/lang/Object;
    //   345: aastore
    //   346: invokestatic 175	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   349: new 42	com/tencent/mm/plugin/appbrand/jsapi/media/b$a
    //   352: dup
    //   353: iconst_1
    //   354: aload_2
    //   355: getfield 172	com/tencent/mm/plugin/appbrand/u/k:value	Ljava/lang/Object;
    //   358: checkcast 177	java/lang/String
    //   361: invokespecial 47	com/tencent/mm/plugin/appbrand/jsapi/media/b$a:<init>	(ZLjava/lang/String;)V
    //   364: astore_1
    //   365: aload_1
    //   366: areturn
    //   367: astore_1
    //   368: ldc 32
    //   370: ldc 179
    //   372: iconst_1
    //   373: anewarray 4	java/lang/Object
    //   376: dup
    //   377: iconst_0
    //   378: aload_1
    //   379: aastore
    //   380: invokestatic 84	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   383: aload_2
    //   384: invokestatic 185	com/tencent/mm/a/e:deleteFile	(Ljava/lang/String;)Z
    //   387: pop
    //   388: new 42	com/tencent/mm/plugin/appbrand/jsapi/media/b$a
    //   391: dup
    //   392: iconst_0
    //   393: ldc 187
    //   395: invokespecial 47	com/tencent/mm/plugin/appbrand/jsapi/media/b$a:<init>	(ZLjava/lang/String;)V
    //   398: areturn
    //   399: astore_1
    //   400: aload 4
    //   402: astore_2
    //   403: goto -35 -> 368
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	406	0	this	b
    //   0	406	1	paramc	com.tencent.mm.plugin.appbrand.jsapi.c
    //   0	406	2	paramString	java.lang.String
    //   0	406	3	paramInt	int
    //   191	210	4	str	java.lang.String
    //   6	236	5	localk	com.tencent.mm.plugin.appbrand.appstorage.k
    //   43	181	6	localFile	java.io.File
    //   77	139	7	localOptions	android.graphics.BitmapFactory.Options
    //   90	116	8	localBitmap	android.graphics.Bitmap
    // Exception table:
    //   from	to	target	type
    //   70	92	117	java/lang/OutOfMemoryError
    //   97	115	117	java/lang/OutOfMemoryError
    //   144	152	117	java/lang/OutOfMemoryError
    //   155	193	117	java/lang/OutOfMemoryError
    //   193	205	117	java/lang/OutOfMemoryError
    //   205	233	117	java/lang/OutOfMemoryError
    //   233	284	117	java/lang/OutOfMemoryError
    //   319	323	117	java/lang/OutOfMemoryError
    //   326	365	117	java/lang/OutOfMemoryError
    //   70	92	286	java/lang/NullPointerException
    //   97	115	286	java/lang/NullPointerException
    //   144	152	286	java/lang/NullPointerException
    //   155	193	286	java/lang/NullPointerException
    //   193	205	286	java/lang/NullPointerException
    //   205	233	286	java/lang/NullPointerException
    //   233	284	286	java/lang/NullPointerException
    //   319	323	286	java/lang/NullPointerException
    //   326	365	286	java/lang/NullPointerException
    //   70	92	367	java/lang/Exception
    //   97	115	367	java/lang/Exception
    //   144	152	367	java/lang/Exception
    //   155	193	367	java/lang/Exception
    //   193	205	399	java/lang/Exception
    //   205	233	399	java/lang/Exception
    //   233	284	399	java/lang/Exception
    //   319	323	399	java/lang/Exception
    //   326	365	399	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.b.b
 * JD-Core Version:    0.7.0.1
 */