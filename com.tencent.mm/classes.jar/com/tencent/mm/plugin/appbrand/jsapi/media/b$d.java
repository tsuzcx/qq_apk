package com.tencent.mm.plugin.appbrand.jsapi.media;

final class b$d
  implements b.c
{
  /* Error */
  public final b.a a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, java.lang.String paramString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_1
    //   4: ifnull +10 -> 14
    //   7: aload_1
    //   8: instanceof 26
    //   11: ifne +21 -> 32
    //   14: ldc 28
    //   16: ldc 30
    //   18: invokestatic 36	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: new 38	com/tencent/mm/plugin/appbrand/jsapi/media/b$a
    //   24: dup
    //   25: iconst_0
    //   26: ldc 40
    //   28: invokespecial 43	com/tencent/mm/plugin/appbrand/jsapi/media/b$a:<init>	(ZLjava/lang/String;)V
    //   31: areturn
    //   32: aload_1
    //   33: invokeinterface 49 1 0
    //   38: astore 6
    //   40: aload 6
    //   42: ifnonnull +21 -> 63
    //   45: ldc 28
    //   47: ldc 51
    //   49: invokestatic 36	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: new 38	com/tencent/mm/plugin/appbrand/jsapi/media/b$a
    //   55: dup
    //   56: iconst_0
    //   57: ldc 53
    //   59: invokespecial 43	com/tencent/mm/plugin/appbrand/jsapi/media/b$a:<init>	(ZLjava/lang/String;)V
    //   62: areturn
    //   63: aload_1
    //   64: checkcast 26	com/tencent/mm/plugin/appbrand/o
    //   67: invokevirtual 57	com/tencent/mm/plugin/appbrand/o:getRuntime	()Lcom/tencent/mm/plugin/appbrand/i;
    //   70: aload_2
    //   71: invokestatic 62	com/tencent/mm/plugin/appbrand/appcache/aq:d	(Lcom/tencent/mm/plugin/appbrand/i;Ljava/lang/String;)Ljava/io/InputStream;
    //   74: astore 7
    //   76: aload 7
    //   78: ifnonnull +21 -> 99
    //   81: ldc 28
    //   83: ldc 64
    //   85: invokestatic 36	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: new 38	com/tencent/mm/plugin/appbrand/jsapi/media/b$a
    //   91: dup
    //   92: iconst_0
    //   93: ldc 66
    //   95: invokespecial 43	com/tencent/mm/plugin/appbrand/jsapi/media/b$a:<init>	(ZLjava/lang/String;)V
    //   98: areturn
    //   99: new 68	android/graphics/BitmapFactory$Options
    //   102: dup
    //   103: invokespecial 69	android/graphics/BitmapFactory$Options:<init>	()V
    //   106: astore 8
    //   108: aload 7
    //   110: aconst_null
    //   111: aload 8
    //   113: iconst_0
    //   114: invokestatic 75	com/tencent/mm/sdk/platformtools/MMBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;I)Landroid/graphics/Bitmap;
    //   117: astore 9
    //   119: aload 9
    //   121: ifnonnull +50 -> 171
    //   124: ldc 28
    //   126: ldc 77
    //   128: invokestatic 80	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   131: new 38	com/tencent/mm/plugin/appbrand/jsapi/media/b$a
    //   134: dup
    //   135: iconst_0
    //   136: ldc 82
    //   138: invokespecial 43	com/tencent/mm/plugin/appbrand/jsapi/media/b$a:<init>	(ZLjava/lang/String;)V
    //   141: astore_1
    //   142: aload_1
    //   143: areturn
    //   144: astore_1
    //   145: ldc 28
    //   147: ldc 84
    //   149: iconst_1
    //   150: anewarray 4	java/lang/Object
    //   153: dup
    //   154: iconst_0
    //   155: aload_1
    //   156: aastore
    //   157: invokestatic 87	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   160: new 38	com/tencent/mm/plugin/appbrand/jsapi/media/b$a
    //   163: dup
    //   164: iconst_0
    //   165: ldc 89
    //   167: invokespecial 43	com/tencent/mm/plugin/appbrand/jsapi/media/b$a:<init>	(ZLjava/lang/String;)V
    //   170: areturn
    //   171: aload 8
    //   173: invokestatic 94	com/tencent/mm/plugin/appbrand/v/a:a	(Landroid/graphics/BitmapFactory$Options;)Z
    //   176: ifeq +161 -> 337
    //   179: ldc 96
    //   181: astore_1
    //   182: new 98	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   189: getstatic 105	com/tencent/mm/compatible/util/e:dzD	Ljava/lang/String;
    //   192: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: ldc 111
    //   197: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: invokestatic 117	java/lang/System:currentTimeMillis	()J
    //   203: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   206: ldc 122
    //   208: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: aload_1
    //   212: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: astore 4
    //   220: aload 8
    //   222: invokestatic 94	com/tencent/mm/plugin/appbrand/v/a:a	(Landroid/graphics/BitmapFactory$Options;)Z
    //   225: ifeq +118 -> 343
    //   228: getstatic 132	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   231: astore_2
    //   232: aload 9
    //   234: iload_3
    //   235: aload_2
    //   236: aload 4
    //   238: iconst_1
    //   239: invokestatic 137	com/tencent/mm/sdk/platformtools/c:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)V
    //   242: aload 8
    //   244: invokestatic 94	com/tencent/mm/plugin/appbrand/v/a:a	(Landroid/graphics/BitmapFactory$Options;)Z
    //   247: ifeq +10 -> 257
    //   250: aload 7
    //   252: aload 4
    //   254: invokestatic 142	com/tencent/mm/plugin/appbrand/h/b:a	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   257: new 144	com/tencent/mm/plugin/appbrand/u/k
    //   260: dup
    //   261: invokespecial 145	com/tencent/mm/plugin/appbrand/u/k:<init>	()V
    //   264: astore_2
    //   265: aload 6
    //   267: new 147	java/io/File
    //   270: dup
    //   271: aload 4
    //   273: invokespecial 150	java/io/File:<init>	(Ljava/lang/String;)V
    //   276: aload_1
    //   277: iconst_0
    //   278: aload_2
    //   279: invokeinterface 155 5 0
    //   284: getstatic 161	com/tencent/mm/plugin/appbrand/appstorage/h:fGU	Lcom/tencent/mm/plugin/appbrand/appstorage/h;
    //   287: if_acmpeq +63 -> 350
    //   290: ldc 28
    //   292: ldc 163
    //   294: invokestatic 36	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   297: new 38	com/tencent/mm/plugin/appbrand/jsapi/media/b$a
    //   300: dup
    //   301: iconst_0
    //   302: ldc 165
    //   304: invokespecial 43	com/tencent/mm/plugin/appbrand/jsapi/media/b$a:<init>	(ZLjava/lang/String;)V
    //   307: astore_1
    //   308: aload_1
    //   309: areturn
    //   310: astore_1
    //   311: ldc 28
    //   313: ldc 167
    //   315: iconst_1
    //   316: anewarray 4	java/lang/Object
    //   319: dup
    //   320: iconst_0
    //   321: aload_1
    //   322: aastore
    //   323: invokestatic 87	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   326: new 38	com/tencent/mm/plugin/appbrand/jsapi/media/b$a
    //   329: dup
    //   330: iconst_0
    //   331: ldc 169
    //   333: invokespecial 43	com/tencent/mm/plugin/appbrand/jsapi/media/b$a:<init>	(ZLjava/lang/String;)V
    //   336: areturn
    //   337: ldc 171
    //   339: astore_1
    //   340: goto -158 -> 182
    //   343: getstatic 174	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   346: astore_2
    //   347: goto -115 -> 232
    //   350: ldc 28
    //   352: ldc 176
    //   354: iconst_2
    //   355: anewarray 4	java/lang/Object
    //   358: dup
    //   359: iconst_0
    //   360: aload 4
    //   362: aastore
    //   363: dup
    //   364: iconst_1
    //   365: aload_2
    //   366: getfield 180	com/tencent/mm/plugin/appbrand/u/k:value	Ljava/lang/Object;
    //   369: aastore
    //   370: invokestatic 183	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   373: new 38	com/tencent/mm/plugin/appbrand/jsapi/media/b$a
    //   376: dup
    //   377: iconst_1
    //   378: aload_2
    //   379: getfield 180	com/tencent/mm/plugin/appbrand/u/k:value	Ljava/lang/Object;
    //   382: checkcast 185	java/lang/String
    //   385: invokespecial 43	com/tencent/mm/plugin/appbrand/jsapi/media/b$a:<init>	(ZLjava/lang/String;)V
    //   388: astore_1
    //   389: aload_1
    //   390: areturn
    //   391: astore_1
    //   392: aload 5
    //   394: astore_2
    //   395: ldc 28
    //   397: ldc 187
    //   399: iconst_1
    //   400: anewarray 4	java/lang/Object
    //   403: dup
    //   404: iconst_0
    //   405: aload_1
    //   406: aastore
    //   407: invokestatic 87	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   410: aload_2
    //   411: invokestatic 193	com/tencent/mm/a/e:deleteFile	(Ljava/lang/String;)Z
    //   414: pop
    //   415: new 38	com/tencent/mm/plugin/appbrand/jsapi/media/b$a
    //   418: dup
    //   419: iconst_0
    //   420: ldc 195
    //   422: invokespecial 43	com/tencent/mm/plugin/appbrand/jsapi/media/b$a:<init>	(ZLjava/lang/String;)V
    //   425: areturn
    //   426: astore_1
    //   427: aload 4
    //   429: astore_2
    //   430: goto -35 -> 395
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	433	0	this	d
    //   0	433	1	paramc	com.tencent.mm.plugin.appbrand.jsapi.c
    //   0	433	2	paramString	java.lang.String
    //   0	433	3	paramInt	int
    //   218	210	4	str	java.lang.String
    //   1	392	5	localObject	Object
    //   38	228	6	localk	com.tencent.mm.plugin.appbrand.appstorage.k
    //   74	177	7	localInputStream	java.io.InputStream
    //   106	137	8	localOptions	android.graphics.BitmapFactory.Options
    //   117	116	9	localBitmap	android.graphics.Bitmap
    // Exception table:
    //   from	to	target	type
    //   99	119	144	java/lang/OutOfMemoryError
    //   124	142	144	java/lang/OutOfMemoryError
    //   171	179	144	java/lang/OutOfMemoryError
    //   182	220	144	java/lang/OutOfMemoryError
    //   220	232	144	java/lang/OutOfMemoryError
    //   232	257	144	java/lang/OutOfMemoryError
    //   257	308	144	java/lang/OutOfMemoryError
    //   343	347	144	java/lang/OutOfMemoryError
    //   350	389	144	java/lang/OutOfMemoryError
    //   99	119	310	java/lang/NullPointerException
    //   124	142	310	java/lang/NullPointerException
    //   171	179	310	java/lang/NullPointerException
    //   182	220	310	java/lang/NullPointerException
    //   220	232	310	java/lang/NullPointerException
    //   232	257	310	java/lang/NullPointerException
    //   257	308	310	java/lang/NullPointerException
    //   343	347	310	java/lang/NullPointerException
    //   350	389	310	java/lang/NullPointerException
    //   99	119	391	java/lang/Exception
    //   124	142	391	java/lang/Exception
    //   171	179	391	java/lang/Exception
    //   182	220	391	java/lang/Exception
    //   220	232	426	java/lang/Exception
    //   232	257	426	java/lang/Exception
    //   257	308	426	java/lang/Exception
    //   343	347	426	java/lang/Exception
    //   350	389	426	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.b.d
 * JD-Core Version:    0.7.0.1
 */