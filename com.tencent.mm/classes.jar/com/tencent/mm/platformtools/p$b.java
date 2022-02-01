package com.tencent.mm.platformtools;

import android.content.Context;
import android.net.Uri;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Media;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class p$b
{
  public static Uri O(Context paramContext, String paramString)
  {
    AppMethodBeat.i(223670);
    paramContext = a(paramContext, paramString, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
    AppMethodBeat.o(223670);
    return paramContext;
  }
  
  public static Uri P(Context paramContext, String paramString)
  {
    AppMethodBeat.i(223671);
    Uri localUri2 = a(paramContext, paramString, MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
    Uri localUri1 = localUri2;
    if (localUri2 == null) {
      localUri1 = O(paramContext, paramString);
    }
    AppMethodBeat.o(223671);
    return localUri1;
  }
  
  /* Error */
  private static Uri a(Context paramContext, String paramString, Uri paramUri)
  {
    // Byte code:
    //   0: ldc 40
    //   2: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokestatic 46	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifne +7 -> 16
    //   12: aload_2
    //   13: ifnonnull +10 -> 23
    //   16: ldc 40
    //   18: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aconst_null
    //   22: areturn
    //   23: getstatic 22	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   26: aload_2
    //   27: invokevirtual 52	android/net/Uri:equals	(Ljava/lang/Object;)Z
    //   30: ifne +66 -> 96
    //   33: getstatic 35	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   36: aload_2
    //   37: invokevirtual 52	android/net/Uri:equals	(Ljava/lang/Object;)Z
    //   40: ifne +56 -> 96
    //   43: getstatic 55	android/provider/MediaStore$Audio$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   46: aload_2
    //   47: invokevirtual 52	android/net/Uri:equals	(Ljava/lang/Object;)Z
    //   50: ifne +46 -> 96
    //   53: getstatic 58	android/provider/MediaStore$Downloads:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   56: aload_2
    //   57: invokevirtual 52	android/net/Uri:equals	(Ljava/lang/Object;)Z
    //   60: ifne +36 -> 96
    //   63: ldc 60
    //   65: invokestatic 66	android/provider/MediaStore$Files:getContentUri	(Ljava/lang/String;)Landroid/net/Uri;
    //   68: aload_2
    //   69: invokevirtual 52	android/net/Uri:equals	(Ljava/lang/Object;)Z
    //   72: ifne +24 -> 96
    //   75: ldc 68
    //   77: ldc 70
    //   79: aload_2
    //   80: invokestatic 76	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   83: invokevirtual 80	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   86: invokestatic 86	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: ldc 40
    //   91: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: aconst_null
    //   95: areturn
    //   96: aload_0
    //   97: invokevirtual 92	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   100: aload_2
    //   101: iconst_1
    //   102: anewarray 72	java/lang/String
    //   105: dup
    //   106: iconst_0
    //   107: ldc 94
    //   109: aastore
    //   110: ldc 96
    //   112: iconst_1
    //   113: anewarray 72	java/lang/String
    //   116: dup
    //   117: iconst_0
    //   118: aload_1
    //   119: aastore
    //   120: aconst_null
    //   121: invokevirtual 102	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   124: astore_3
    //   125: aload_3
    //   126: ifnull +51 -> 177
    //   129: aload_3
    //   130: invokeinterface 108 1 0
    //   135: ifeq +42 -> 177
    //   138: aload_2
    //   139: aload_3
    //   140: aload_3
    //   141: ldc 94
    //   143: invokeinterface 112 2 0
    //   148: invokeinterface 116 2 0
    //   153: invokestatic 119	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   156: invokestatic 123	android/net/Uri:withAppendedPath	(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
    //   159: astore_0
    //   160: aload_3
    //   161: ifnull +9 -> 170
    //   164: aload_3
    //   165: invokeinterface 127 1 0
    //   170: ldc 40
    //   172: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   175: aload_0
    //   176: areturn
    //   177: aload_3
    //   178: ifnull +9 -> 187
    //   181: aload_3
    //   182: invokeinterface 127 1 0
    //   187: ldc 40
    //   189: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   192: aconst_null
    //   193: areturn
    //   194: astore_1
    //   195: ldc 40
    //   197: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   200: aload_1
    //   201: athrow
    //   202: astore_0
    //   203: aload_3
    //   204: ifnull +13 -> 217
    //   207: aload_1
    //   208: ifnull +41 -> 249
    //   211: aload_3
    //   212: invokeinterface 127 1 0
    //   217: ldc 40
    //   219: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   222: aload_0
    //   223: athrow
    //   224: astore_0
    //   225: ldc 68
    //   227: aload_0
    //   228: ldc 129
    //   230: iconst_0
    //   231: anewarray 4	java/lang/Object
    //   234: invokestatic 133	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   237: goto -50 -> 187
    //   240: astore_2
    //   241: aload_1
    //   242: aload_2
    //   243: invokevirtual 137	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   246: goto -29 -> 217
    //   249: aload_3
    //   250: invokeinterface 127 1 0
    //   255: goto -38 -> 217
    //   258: astore_0
    //   259: aconst_null
    //   260: astore_1
    //   261: goto -58 -> 203
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	264	0	paramContext	Context
    //   0	264	1	paramString	String
    //   0	264	2	paramUri	Uri
    //   124	126	3	localCursor	android.database.Cursor
    // Exception table:
    //   from	to	target	type
    //   129	160	194	java/lang/Throwable
    //   195	202	202	finally
    //   96	125	224	java/lang/Throwable
    //   164	170	224	java/lang/Throwable
    //   181	187	224	java/lang/Throwable
    //   217	224	224	java/lang/Throwable
    //   241	246	224	java/lang/Throwable
    //   249	255	224	java/lang/Throwable
    //   211	217	240	java/lang/Throwable
    //   129	160	258	finally
  }
  
  /* Error */
  static Uri a(Context paramContext, String paramString1, String paramString2, Uri paramUri)
  {
    // Byte code:
    //   0: ldc 139
    //   2: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokestatic 145	com/tencent/mm/vfs/s:YS	(Ljava/lang/String;)Z
    //   9: ifne +24 -> 33
    //   12: ldc 68
    //   14: ldc 147
    //   16: aload_1
    //   17: invokestatic 76	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   20: invokevirtual 80	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   23: invokestatic 86	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: ldc 139
    //   28: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: aconst_null
    //   32: areturn
    //   33: getstatic 22	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   36: aload_3
    //   37: invokevirtual 52	android/net/Uri:equals	(Ljava/lang/Object;)Z
    //   40: ifeq +37 -> 77
    //   43: getstatic 153	android/os/Environment:DIRECTORY_PICTURES	Ljava/lang/String;
    //   46: astore 6
    //   48: aload 6
    //   50: invokestatic 46	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   53: ifeq +60 -> 113
    //   56: ldc 68
    //   58: ldc 155
    //   60: aload_3
    //   61: invokestatic 76	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   64: invokevirtual 80	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   67: invokestatic 86	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   70: ldc 139
    //   72: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   75: aconst_null
    //   76: areturn
    //   77: getstatic 35	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   80: aload_3
    //   81: invokevirtual 52	android/net/Uri:equals	(Ljava/lang/Object;)Z
    //   84: ifeq +11 -> 95
    //   87: getstatic 153	android/os/Environment:DIRECTORY_PICTURES	Ljava/lang/String;
    //   90: astore 6
    //   92: goto -44 -> 48
    //   95: getstatic 58	android/provider/MediaStore$Downloads:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   98: aload_3
    //   99: invokevirtual 52	android/net/Uri:equals	(Ljava/lang/Object;)Z
    //   102: ifeq +440 -> 542
    //   105: getstatic 158	android/os/Environment:DIRECTORY_DOWNLOADS	Ljava/lang/String;
    //   108: astore 6
    //   110: goto -62 -> 48
    //   113: aload_2
    //   114: invokestatic 163	com/tencent/mm/sdk/system/MimeTypeUtil:getMimeTypeByFilePath	(Ljava/lang/String;)Ljava/lang/String;
    //   117: astore 8
    //   119: new 165	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   126: aload_2
    //   127: invokestatic 171	com/tencent/mm/vfs/s:bpb	(Ljava/lang/String;)Ljava/lang/String;
    //   130: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: ldc 177
    //   135: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload_2
    //   139: invokestatic 180	com/tencent/mm/vfs/s:akC	(Ljava/lang/String;)Ljava/lang/String;
    //   142: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: astore 9
    //   150: aload 8
    //   152: astore 7
    //   154: aload 8
    //   156: invokestatic 46	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   159: ifeq +21 -> 180
    //   162: ldc 68
    //   164: ldc 186
    //   166: aload_1
    //   167: invokestatic 76	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   170: invokevirtual 80	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   173: invokestatic 86	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   176: ldc 188
    //   178: astore 7
    //   180: aload_2
    //   181: aload 6
    //   183: invokevirtual 191	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   186: ifeq +350 -> 536
    //   189: aload_2
    //   190: aload 6
    //   192: invokevirtual 194	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   195: aload 6
    //   197: invokevirtual 198	java/lang/String:length	()I
    //   200: iadd
    //   201: istore 4
    //   203: aload_2
    //   204: getstatic 203	java/io/File:separator	Ljava/lang/String;
    //   207: invokevirtual 206	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   210: istore 5
    //   212: iload 4
    //   214: iload 5
    //   216: if_icmpge +320 -> 536
    //   219: new 165	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   226: aload 6
    //   228: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: aload_2
    //   232: iload 4
    //   234: iload 5
    //   236: invokevirtual 210	java/lang/String:substring	(II)Ljava/lang/String;
    //   239: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   245: astore 6
    //   247: aload 6
    //   249: invokestatic 46	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   252: ifeq +24 -> 276
    //   255: ldc 68
    //   257: ldc 212
    //   259: aload_1
    //   260: invokestatic 76	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   263: invokevirtual 80	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   266: invokestatic 86	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   269: ldc 139
    //   271: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   274: aconst_null
    //   275: areturn
    //   276: new 214	android/content/ContentValues
    //   279: dup
    //   280: invokespecial 215	android/content/ContentValues:<init>	()V
    //   283: astore 8
    //   285: aload 8
    //   287: ldc 217
    //   289: aload 7
    //   291: invokevirtual 220	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   294: aload 8
    //   296: ldc 222
    //   298: aload 9
    //   300: invokevirtual 220	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   303: aload 8
    //   305: ldc 224
    //   307: aload 6
    //   309: invokevirtual 220	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   312: aload_0
    //   313: invokevirtual 92	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   316: astore 6
    //   318: aload 6
    //   320: aload_3
    //   321: aload 8
    //   323: invokevirtual 228	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   326: astore_3
    //   327: aload_3
    //   328: ifnonnull +24 -> 352
    //   331: ldc 68
    //   333: ldc 230
    //   335: aload_2
    //   336: invokestatic 76	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   339: invokevirtual 80	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   342: invokestatic 86	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   345: ldc 139
    //   347: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   350: aconst_null
    //   351: areturn
    //   352: aload 6
    //   354: aload_3
    //   355: invokevirtual 234	android/content/ContentResolver:openOutputStream	(Landroid/net/Uri;)Ljava/io/OutputStream;
    //   358: astore_2
    //   359: new 236	com/tencent/mm/vfs/r
    //   362: dup
    //   363: aload_1
    //   364: invokespecial 239	com/tencent/mm/vfs/r:<init>	(Ljava/lang/String;)V
    //   367: astore 7
    //   369: aload 7
    //   371: aload_2
    //   372: invokestatic 245	org/apache/commons/a/e:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;)I
    //   375: pop
    //   376: aload 7
    //   378: invokevirtual 248	java/io/InputStream:close	()V
    //   381: aload_2
    //   382: ifnull +7 -> 389
    //   385: aload_2
    //   386: invokevirtual 251	java/io/OutputStream:close	()V
    //   389: ldc 139
    //   391: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   394: aload_3
    //   395: areturn
    //   396: astore_1
    //   397: ldc 139
    //   399: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   402: aload_1
    //   403: athrow
    //   404: astore_0
    //   405: aload_1
    //   406: ifnull +90 -> 496
    //   409: aload 7
    //   411: invokevirtual 248	java/io/InputStream:close	()V
    //   414: ldc 139
    //   416: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   419: aload_0
    //   420: athrow
    //   421: astore_1
    //   422: ldc 139
    //   424: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   427: aload_1
    //   428: athrow
    //   429: astore_0
    //   430: aload_2
    //   431: ifnull +11 -> 442
    //   434: aload_1
    //   435: ifnull +78 -> 513
    //   438: aload_2
    //   439: invokevirtual 251	java/io/OutputStream:close	()V
    //   442: ldc 139
    //   444: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   447: aload_0
    //   448: athrow
    //   449: astore_0
    //   450: aload_3
    //   451: astore_1
    //   452: aload_1
    //   453: ifnull +12 -> 465
    //   456: aload 6
    //   458: aload_1
    //   459: aconst_null
    //   460: aconst_null
    //   461: invokevirtual 255	android/content/ContentResolver:delete	(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    //   464: pop
    //   465: ldc 68
    //   467: aload_0
    //   468: ldc_w 257
    //   471: iconst_0
    //   472: anewarray 4	java/lang/Object
    //   475: invokestatic 133	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   478: ldc 139
    //   480: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   483: aconst_null
    //   484: areturn
    //   485: astore 7
    //   487: aload_1
    //   488: aload 7
    //   490: invokevirtual 137	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   493: goto -79 -> 414
    //   496: aload 7
    //   498: invokevirtual 248	java/io/InputStream:close	()V
    //   501: goto -87 -> 414
    //   504: astore_2
    //   505: aload_1
    //   506: aload_2
    //   507: invokevirtual 137	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   510: goto -68 -> 442
    //   513: aload_2
    //   514: invokevirtual 251	java/io/OutputStream:close	()V
    //   517: goto -75 -> 442
    //   520: astore_1
    //   521: goto -56 -> 465
    //   524: astore_0
    //   525: aconst_null
    //   526: astore_1
    //   527: goto -75 -> 452
    //   530: astore_0
    //   531: aconst_null
    //   532: astore_1
    //   533: goto -128 -> 405
    //   536: aconst_null
    //   537: astore 6
    //   539: goto -292 -> 247
    //   542: aconst_null
    //   543: astore 6
    //   545: goto -497 -> 48
    //   548: astore_0
    //   549: aconst_null
    //   550: astore_1
    //   551: goto -121 -> 430
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	554	0	paramContext	Context
    //   0	554	1	paramString1	String
    //   0	554	2	paramString2	String
    //   0	554	3	paramUri	Uri
    //   201	32	4	i	int
    //   210	25	5	j	int
    //   46	498	6	localObject1	Object
    //   152	258	7	localObject2	Object
    //   485	12	7	localThrowable	java.lang.Throwable
    //   117	205	8	localObject3	Object
    //   148	151	9	str	String
    // Exception table:
    //   from	to	target	type
    //   369	376	396	java/lang/Throwable
    //   397	404	404	finally
    //   359	369	421	java/lang/Throwable
    //   376	381	421	java/lang/Throwable
    //   414	421	421	java/lang/Throwable
    //   487	493	421	java/lang/Throwable
    //   496	501	421	java/lang/Throwable
    //   422	429	429	finally
    //   331	345	449	java/lang/Throwable
    //   352	359	449	java/lang/Throwable
    //   385	389	449	java/lang/Throwable
    //   442	449	449	java/lang/Throwable
    //   505	510	449	java/lang/Throwable
    //   513	517	449	java/lang/Throwable
    //   409	414	485	java/lang/Throwable
    //   438	442	504	java/lang/Throwable
    //   456	465	520	java/lang/Throwable
    //   318	327	524	java/lang/Throwable
    //   369	376	530	finally
    //   359	369	548	finally
    //   376	381	548	finally
    //   409	414	548	finally
    //   414	421	548	finally
    //   487	493	548	finally
    //   496	501	548	finally
  }
  
  /* Error */
  public static String h(Context paramContext, Uri paramUri)
  {
    // Byte code:
    //   0: ldc_w 260
    //   3: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 264	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   10: aload_1
    //   11: invokestatic 270	android/provider/DocumentsContract:isDocumentUri	(Landroid/content/Context;Landroid/net/Uri;)Z
    //   14: ifeq +446 -> 460
    //   17: ldc_w 272
    //   20: aload_1
    //   21: invokevirtual 275	android/net/Uri:getAuthority	()Ljava/lang/String;
    //   24: invokevirtual 276	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   27: ifeq +51 -> 78
    //   30: aload_1
    //   31: invokestatic 280	android/provider/DocumentsContract:getDocumentId	(Landroid/net/Uri;)Ljava/lang/String;
    //   34: ldc_w 282
    //   37: invokevirtual 286	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   40: astore_0
    //   41: new 165	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   48: invokestatic 290	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   51: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   54: ldc_w 295
    //   57: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: aload_0
    //   61: iconst_1
    //   62: aaload
    //   63: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: astore_0
    //   70: ldc_w 260
    //   73: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: aload_0
    //   77: areturn
    //   78: ldc_w 297
    //   81: aload_1
    //   82: invokevirtual 275	android/net/Uri:getAuthority	()Ljava/lang/String;
    //   85: invokevirtual 276	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   88: ifeq +66 -> 154
    //   91: aload_1
    //   92: invokestatic 280	android/provider/DocumentsContract:getDocumentId	(Landroid/net/Uri;)Ljava/lang/String;
    //   95: astore_1
    //   96: ldc_w 299
    //   99: invokestatic 302	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   102: aload_1
    //   103: invokestatic 308	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   106: invokestatic 314	android/content/ContentUris:withAppendedId	(Landroid/net/Uri;J)Landroid/net/Uri;
    //   109: astore_1
    //   110: aconst_null
    //   111: astore 4
    //   113: aconst_null
    //   114: astore_3
    //   115: ldc_w 316
    //   118: aload_1
    //   119: invokevirtual 319	android/net/Uri:getScheme	()Ljava/lang/String;
    //   122: invokevirtual 322	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   125: ifeq +303 -> 428
    //   128: ldc_w 324
    //   131: aload_1
    //   132: invokevirtual 275	android/net/Uri:getAuthority	()Ljava/lang/String;
    //   135: invokevirtual 276	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   138: ifeq +115 -> 253
    //   141: aload_1
    //   142: invokevirtual 327	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   145: astore_0
    //   146: ldc_w 260
    //   149: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   152: aload_0
    //   153: areturn
    //   154: ldc_w 329
    //   157: aload_1
    //   158: invokevirtual 275	android/net/Uri:getAuthority	()Ljava/lang/String;
    //   161: invokevirtual 276	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   164: ifeq +296 -> 460
    //   167: aload_1
    //   168: invokestatic 280	android/provider/DocumentsContract:getDocumentId	(Landroid/net/Uri;)Ljava/lang/String;
    //   171: ldc_w 282
    //   174: invokevirtual 286	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   177: astore 5
    //   179: aload 5
    //   181: iconst_0
    //   182: aaload
    //   183: astore_3
    //   184: ldc_w 331
    //   187: aload_3
    //   188: invokevirtual 276	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   191: ifeq +28 -> 219
    //   194: getstatic 22	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   197: astore_1
    //   198: ldc_w 333
    //   201: astore_3
    //   202: iconst_1
    //   203: anewarray 72	java/lang/String
    //   206: astore 4
    //   208: aload 4
    //   210: iconst_0
    //   211: aload 5
    //   213: iconst_1
    //   214: aaload
    //   215: aastore
    //   216: goto -101 -> 115
    //   219: ldc_w 335
    //   222: aload_3
    //   223: invokevirtual 276	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   226: ifeq +10 -> 236
    //   229: getstatic 35	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   232: astore_1
    //   233: goto -35 -> 198
    //   236: ldc_w 337
    //   239: aload_3
    //   240: invokevirtual 276	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   243: ifeq -45 -> 198
    //   246: getstatic 55	android/provider/MediaStore$Audio$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   249: astore_1
    //   250: goto -52 -> 198
    //   253: aload_0
    //   254: invokevirtual 92	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   257: aload_1
    //   258: iconst_1
    //   259: anewarray 72	java/lang/String
    //   262: dup
    //   263: iconst_0
    //   264: ldc_w 339
    //   267: aastore
    //   268: aload_3
    //   269: aload 4
    //   271: aconst_null
    //   272: invokevirtual 102	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   275: astore_3
    //   276: aload_3
    //   277: ifnonnull +21 -> 298
    //   280: aload_3
    //   281: ifnull +9 -> 290
    //   284: aload_3
    //   285: invokeinterface 127 1 0
    //   290: ldc_w 260
    //   293: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   296: aconst_null
    //   297: areturn
    //   298: aload_3
    //   299: ldc_w 339
    //   302: invokeinterface 112 2 0
    //   307: istore_2
    //   308: aload_3
    //   309: invokeinterface 108 1 0
    //   314: ifeq +29 -> 343
    //   317: aload_3
    //   318: iload_2
    //   319: invokeinterface 342 2 0
    //   324: astore_0
    //   325: aload_3
    //   326: ifnull +9 -> 335
    //   329: aload_3
    //   330: invokeinterface 127 1 0
    //   335: ldc_w 260
    //   338: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   341: aload_0
    //   342: areturn
    //   343: aload_3
    //   344: ifnull +9 -> 353
    //   347: aload_3
    //   348: invokeinterface 127 1 0
    //   353: ldc_w 260
    //   356: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   359: aconst_null
    //   360: areturn
    //   361: astore_1
    //   362: ldc_w 260
    //   365: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   368: aload_1
    //   369: athrow
    //   370: astore_0
    //   371: aload_3
    //   372: ifnull +13 -> 385
    //   375: aload_1
    //   376: ifnull +43 -> 419
    //   379: aload_3
    //   380: invokeinterface 127 1 0
    //   385: ldc_w 260
    //   388: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   391: aload_0
    //   392: athrow
    //   393: astore_0
    //   394: ldc 68
    //   396: aload_0
    //   397: ldc_w 344
    //   400: iconst_0
    //   401: anewarray 4	java/lang/Object
    //   404: invokestatic 133	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   407: goto -54 -> 353
    //   410: astore_3
    //   411: aload_1
    //   412: aload_3
    //   413: invokevirtual 137	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   416: goto -31 -> 385
    //   419: aload_3
    //   420: invokeinterface 127 1 0
    //   425: goto -40 -> 385
    //   428: ldc_w 346
    //   431: aload_1
    //   432: invokevirtual 319	android/net/Uri:getScheme	()Ljava/lang/String;
    //   435: invokevirtual 322	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   438: ifeq -85 -> 353
    //   441: aload_1
    //   442: invokevirtual 349	android/net/Uri:getPath	()Ljava/lang/String;
    //   445: astore_0
    //   446: ldc_w 260
    //   449: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   452: aload_0
    //   453: areturn
    //   454: astore_0
    //   455: aconst_null
    //   456: astore_1
    //   457: goto -86 -> 371
    //   460: aconst_null
    //   461: astore 4
    //   463: aconst_null
    //   464: astore_3
    //   465: goto -350 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	468	0	paramContext	Context
    //   0	468	1	paramUri	Uri
    //   307	12	2	i	int
    //   114	266	3	localObject1	Object
    //   410	10	3	localThrowable	java.lang.Throwable
    //   464	1	3	localObject2	Object
    //   111	351	4	arrayOfString1	String[]
    //   177	35	5	arrayOfString2	String[]
    // Exception table:
    //   from	to	target	type
    //   298	325	361	java/lang/Throwable
    //   362	370	370	finally
    //   6	70	393	java/lang/Throwable
    //   78	110	393	java/lang/Throwable
    //   115	146	393	java/lang/Throwable
    //   154	179	393	java/lang/Throwable
    //   184	198	393	java/lang/Throwable
    //   202	208	393	java/lang/Throwable
    //   219	233	393	java/lang/Throwable
    //   236	250	393	java/lang/Throwable
    //   253	276	393	java/lang/Throwable
    //   284	290	393	java/lang/Throwable
    //   329	335	393	java/lang/Throwable
    //   347	353	393	java/lang/Throwable
    //   385	393	393	java/lang/Throwable
    //   411	416	393	java/lang/Throwable
    //   419	425	393	java/lang/Throwable
    //   428	446	393	java/lang/Throwable
    //   379	385	410	java/lang/Throwable
    //   298	325	454	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.platformtools.p.b
 * JD-Core Version:    0.7.0.1
 */