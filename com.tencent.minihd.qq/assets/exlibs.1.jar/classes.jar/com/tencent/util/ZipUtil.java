package com.tencent.util;

public class ZipUtil
{
  public static final int a = 4096;
  
  /* Error */
  public static void a(android.content.Context paramContext, java.lang.String paramString1, java.lang.String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 6
    //   6: iconst_0
    //   7: istore_3
    //   8: aload_1
    //   9: ifnonnull +4 -> 13
    //   12: return
    //   13: new 19	java/io/File
    //   16: dup
    //   17: aload_2
    //   18: invokespecial 22	java/io/File:<init>	(Ljava/lang/String;)V
    //   21: invokevirtual 26	java/io/File:listFiles	()[Ljava/io/File;
    //   24: astore 7
    //   26: aload 7
    //   28: ifnull +29 -> 57
    //   31: aload 7
    //   33: arraylength
    //   34: istore 4
    //   36: iload_3
    //   37: iload 4
    //   39: if_icmpge +18 -> 57
    //   42: aload 7
    //   44: iload_3
    //   45: aaload
    //   46: invokevirtual 30	java/io/File:delete	()Z
    //   49: pop
    //   50: iload_3
    //   51: iconst_1
    //   52: iadd
    //   53: istore_3
    //   54: goto -18 -> 36
    //   57: new 32	java/util/zip/ZipInputStream
    //   60: dup
    //   61: new 34	java/io/BufferedInputStream
    //   64: dup
    //   65: aload_0
    //   66: invokevirtual 40	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   69: aload_1
    //   70: invokevirtual 46	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   73: invokespecial 49	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   76: invokespecial 50	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   79: astore 8
    //   81: aconst_null
    //   82: astore_0
    //   83: aload 8
    //   85: invokevirtual 54	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   88: astore_1
    //   89: aload_1
    //   90: ifnull +316 -> 406
    //   93: aload_1
    //   94: invokevirtual 60	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   97: ifnull -14 -> 83
    //   100: aload_1
    //   101: invokevirtual 60	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   104: ldc 62
    //   106: invokevirtual 68	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   109: istore 5
    //   111: iload 5
    //   113: ifne -30 -> 83
    //   116: sipush 4096
    //   119: newarray byte
    //   121: astore 7
    //   123: aload_1
    //   124: invokevirtual 60	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   127: astore_1
    //   128: new 19	java/io/File
    //   131: dup
    //   132: new 70	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   139: aload_2
    //   140: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload_1
    //   144: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokespecial 22	java/io/File:<init>	(Ljava/lang/String;)V
    //   153: astore_1
    //   154: new 19	java/io/File
    //   157: dup
    //   158: aload_1
    //   159: invokevirtual 81	java/io/File:getParent	()Ljava/lang/String;
    //   162: invokespecial 22	java/io/File:<init>	(Ljava/lang/String;)V
    //   165: astore 6
    //   167: aload 6
    //   169: invokevirtual 84	java/io/File:exists	()Z
    //   172: ifne +9 -> 181
    //   175: aload 6
    //   177: invokevirtual 87	java/io/File:mkdirs	()Z
    //   180: pop
    //   181: new 89	java/io/FileOutputStream
    //   184: dup
    //   185: aload_1
    //   186: invokespecial 92	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   189: astore_1
    //   190: new 94	java/io/BufferedOutputStream
    //   193: dup
    //   194: aload_1
    //   195: sipush 4096
    //   198: invokespecial 97	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   201: astore 6
    //   203: aload 8
    //   205: aload 7
    //   207: iconst_0
    //   208: sipush 4096
    //   211: invokevirtual 101	java/util/zip/ZipInputStream:read	([BII)I
    //   214: istore_3
    //   215: iload_3
    //   216: iconst_m1
    //   217: if_icmpeq +55 -> 272
    //   220: aload 6
    //   222: aload 7
    //   224: iconst_0
    //   225: iload_3
    //   226: invokevirtual 105	java/io/BufferedOutputStream:write	([BII)V
    //   229: goto -26 -> 203
    //   232: astore_0
    //   233: aload 6
    //   235: astore_0
    //   236: aload_0
    //   237: ifnull +11 -> 248
    //   240: aload_0
    //   241: invokevirtual 108	java/io/BufferedOutputStream:flush	()V
    //   244: aload_0
    //   245: invokevirtual 111	java/io/BufferedOutputStream:close	()V
    //   248: aload_0
    //   249: astore 7
    //   251: aload_1
    //   252: ifnull +14 -> 266
    //   255: aload_1
    //   256: invokevirtual 112	java/io/FileOutputStream:flush	()V
    //   259: aload_1
    //   260: invokevirtual 113	java/io/FileOutputStream:close	()V
    //   263: aload_0
    //   264: astore 7
    //   266: aload 7
    //   268: astore_0
    //   269: goto -186 -> 83
    //   272: aload 6
    //   274: ifnull +13 -> 287
    //   277: aload 6
    //   279: invokevirtual 108	java/io/BufferedOutputStream:flush	()V
    //   282: aload 6
    //   284: invokevirtual 111	java/io/BufferedOutputStream:close	()V
    //   287: aload 6
    //   289: astore 7
    //   291: aload_1
    //   292: ifnull -26 -> 266
    //   295: aload_1
    //   296: invokevirtual 112	java/io/FileOutputStream:flush	()V
    //   299: aload_1
    //   300: invokevirtual 113	java/io/FileOutputStream:close	()V
    //   303: aload 6
    //   305: astore 7
    //   307: goto -41 -> 266
    //   310: astore_0
    //   311: aload_0
    //   312: invokevirtual 116	java/io/IOException:printStackTrace	()V
    //   315: aload 6
    //   317: astore 7
    //   319: goto -53 -> 266
    //   322: astore_0
    //   323: aload 8
    //   325: ifnull -313 -> 12
    //   328: aload 8
    //   330: invokevirtual 117	java/util/zip/ZipInputStream:close	()V
    //   333: return
    //   334: astore_0
    //   335: aload_0
    //   336: invokevirtual 116	java/io/IOException:printStackTrace	()V
    //   339: return
    //   340: astore_1
    //   341: aload_1
    //   342: invokevirtual 116	java/io/IOException:printStackTrace	()V
    //   345: aload_0
    //   346: astore 7
    //   348: goto -82 -> 266
    //   351: astore_0
    //   352: aload 8
    //   354: ifnull +8 -> 362
    //   357: aload 8
    //   359: invokevirtual 117	java/util/zip/ZipInputStream:close	()V
    //   362: aload_0
    //   363: athrow
    //   364: astore_0
    //   365: aload_1
    //   366: astore_2
    //   367: aload_0
    //   368: astore_1
    //   369: aload 6
    //   371: ifnull +13 -> 384
    //   374: aload 6
    //   376: invokevirtual 108	java/io/BufferedOutputStream:flush	()V
    //   379: aload 6
    //   381: invokevirtual 111	java/io/BufferedOutputStream:close	()V
    //   384: aload_2
    //   385: ifnull +11 -> 396
    //   388: aload_2
    //   389: invokevirtual 112	java/io/FileOutputStream:flush	()V
    //   392: aload_2
    //   393: invokevirtual 113	java/io/FileOutputStream:close	()V
    //   396: aload_1
    //   397: athrow
    //   398: astore_0
    //   399: aload_0
    //   400: invokevirtual 116	java/io/IOException:printStackTrace	()V
    //   403: goto -7 -> 396
    //   406: aload 8
    //   408: ifnull -396 -> 12
    //   411: aload 8
    //   413: invokevirtual 117	java/util/zip/ZipInputStream:close	()V
    //   416: return
    //   417: astore_0
    //   418: aload_0
    //   419: invokevirtual 116	java/io/IOException:printStackTrace	()V
    //   422: return
    //   423: astore_1
    //   424: aload_1
    //   425: invokevirtual 116	java/io/IOException:printStackTrace	()V
    //   428: goto -66 -> 362
    //   431: astore_0
    //   432: aconst_null
    //   433: astore 8
    //   435: goto -83 -> 352
    //   438: astore_0
    //   439: aload 6
    //   441: astore 8
    //   443: goto -120 -> 323
    //   446: astore_1
    //   447: aload 9
    //   449: astore_2
    //   450: aload_0
    //   451: astore 6
    //   453: goto -84 -> 369
    //   456: astore 6
    //   458: aload_1
    //   459: astore_2
    //   460: aload 6
    //   462: astore_1
    //   463: aload_0
    //   464: astore 6
    //   466: goto -97 -> 369
    //   469: astore_1
    //   470: aconst_null
    //   471: astore_1
    //   472: goto -236 -> 236
    //   475: astore 6
    //   477: goto -241 -> 236
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	480	0	paramContext	android.content.Context
    //   0	480	1	paramString1	java.lang.String
    //   0	480	2	paramString2	java.lang.String
    //   7	219	3	i	int
    //   34	6	4	j	int
    //   109	3	5	bool	boolean
    //   4	448	6	localObject1	Object
    //   456	5	6	localObject2	Object
    //   464	1	6	localContext	android.content.Context
    //   475	1	6	localException	java.lang.Exception
    //   24	323	7	localObject3	Object
    //   79	363	8	localObject4	Object
    //   1	447	9	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   203	215	232	java/lang/Exception
    //   220	229	232	java/lang/Exception
    //   277	287	310	java/io/IOException
    //   295	303	310	java/io/IOException
    //   83	89	322	java/lang/Exception
    //   93	111	322	java/lang/Exception
    //   240	248	322	java/lang/Exception
    //   255	263	322	java/lang/Exception
    //   277	287	322	java/lang/Exception
    //   295	303	322	java/lang/Exception
    //   311	315	322	java/lang/Exception
    //   341	345	322	java/lang/Exception
    //   374	384	322	java/lang/Exception
    //   388	396	322	java/lang/Exception
    //   396	398	322	java/lang/Exception
    //   399	403	322	java/lang/Exception
    //   328	333	334	java/io/IOException
    //   240	248	340	java/io/IOException
    //   255	263	340	java/io/IOException
    //   83	89	351	finally
    //   93	111	351	finally
    //   240	248	351	finally
    //   255	263	351	finally
    //   277	287	351	finally
    //   295	303	351	finally
    //   311	315	351	finally
    //   341	345	351	finally
    //   374	384	351	finally
    //   388	396	351	finally
    //   396	398	351	finally
    //   399	403	351	finally
    //   203	215	364	finally
    //   220	229	364	finally
    //   374	384	398	java/io/IOException
    //   388	396	398	java/io/IOException
    //   411	416	417	java/io/IOException
    //   357	362	423	java/io/IOException
    //   13	26	431	finally
    //   31	36	431	finally
    //   42	50	431	finally
    //   57	81	431	finally
    //   13	26	438	java/lang/Exception
    //   31	36	438	java/lang/Exception
    //   42	50	438	java/lang/Exception
    //   57	81	438	java/lang/Exception
    //   116	181	446	finally
    //   181	190	446	finally
    //   190	203	456	finally
    //   116	181	469	java/lang/Exception
    //   181	190	469	java/lang/Exception
    //   190	203	475	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.util.ZipUtil
 * JD-Core Version:    0.7.0.1
 */