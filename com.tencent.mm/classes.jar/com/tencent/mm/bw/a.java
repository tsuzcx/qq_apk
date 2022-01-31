package com.tencent.mm.bw;

import com.tencent.mm.h.a.be;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.ttpic.baseutils.SourcePathUtil;

public final class a
{
  public static final String uar = com.tencent.mm.compatible.util.e.dOQ + "beauty/";
  public static final String uas = uar + "libalgo_rithm_jni.so";
  public static final String uat = uar + "ziran_lf.png";
  public static volatile boolean uau = false;
  public static a uav = new a();
  public c<be> ekJ = new a.1(this);
  
  public static boolean NF()
  {
    if (com.tencent.mm.vfs.e.bK(uas))
    {
      y.i("MicroMsg.BeautyDownloadLogic", "file %s exist, set beauty so path", new Object[] { uas });
      SourcePathUtil.setBeautySoPath(uas);
    }
    for (int i = 1;; i = 0)
    {
      if (com.tencent.mm.vfs.e.bK(uat))
      {
        y.i("MicroMsg.BeautyDownloadLogic", "file %s exist, set filter res path", new Object[] { uat });
        SourcePathUtil.setFilterSourcePath(uat);
      }
      for (int j = 1;; j = 0)
      {
        if ((i != 0) && (j != 0)) {}
        for (boolean bool = true;; bool = false)
        {
          uau = bool;
          if ((i == 0) || (j == 0)) {
            break;
          }
          return true;
        }
        return false;
      }
    }
  }
  
  /* Error */
  private static boolean at(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore 6
    //   9: aconst_null
    //   10: astore 8
    //   12: aconst_null
    //   13: astore 5
    //   15: aconst_null
    //   16: astore 7
    //   18: new 102	java/io/File
    //   21: dup
    //   22: aload_1
    //   23: invokespecial 104	java/io/File:<init>	(Ljava/lang/String;)V
    //   26: astore 10
    //   28: aload 10
    //   30: invokevirtual 107	java/io/File:mkdirs	()Z
    //   33: pop
    //   34: new 109	java/util/zip/ZipFile
    //   37: dup
    //   38: new 102	java/io/File
    //   41: dup
    //   42: aload_0
    //   43: invokespecial 104	java/io/File:<init>	(Ljava/lang/String;)V
    //   46: iconst_1
    //   47: invokespecial 112	java/util/zip/ZipFile:<init>	(Ljava/io/File;I)V
    //   50: astore_3
    //   51: aload 9
    //   53: astore_1
    //   54: aload 8
    //   56: astore 4
    //   58: aload_3
    //   59: invokevirtual 116	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   62: astore 8
    //   64: aload 5
    //   66: astore_0
    //   67: aload_0
    //   68: astore_1
    //   69: aload_0
    //   70: astore 4
    //   72: aload 8
    //   74: invokeinterface 121 1 0
    //   79: ifeq +463 -> 542
    //   82: aload_0
    //   83: astore_1
    //   84: aload_0
    //   85: astore 4
    //   87: aload 8
    //   89: invokeinterface 125 1 0
    //   94: checkcast 127	java/util/zip/ZipEntry
    //   97: astore 7
    //   99: aload_0
    //   100: astore_1
    //   101: aload_0
    //   102: astore 4
    //   104: ldc 71
    //   106: ldc 129
    //   108: iconst_1
    //   109: anewarray 4	java/lang/Object
    //   112: dup
    //   113: iconst_0
    //   114: aload 7
    //   116: invokevirtual 132	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   119: aastore
    //   120: invokestatic 79	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   123: aload_0
    //   124: astore_1
    //   125: aload_0
    //   126: astore 4
    //   128: aload 7
    //   130: invokevirtual 132	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   133: ldc 134
    //   135: invokevirtual 140	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   138: ifne +21 -> 159
    //   141: aload_0
    //   142: astore_1
    //   143: aload_0
    //   144: astore 4
    //   146: aload 7
    //   148: invokevirtual 132	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   151: ldc 142
    //   153: invokevirtual 140	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   156: ifeq +58 -> 214
    //   159: aload_0
    //   160: astore_1
    //   161: aload_0
    //   162: astore 4
    //   164: ldc 71
    //   166: ldc 144
    //   168: iconst_1
    //   169: anewarray 4	java/lang/Object
    //   172: dup
    //   173: iconst_0
    //   174: aload 7
    //   176: aastore
    //   177: invokestatic 79	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   180: goto -113 -> 67
    //   183: astore 4
    //   185: aload_1
    //   186: astore_0
    //   187: aload_3
    //   188: astore_1
    //   189: aload 4
    //   191: astore_3
    //   192: ldc 71
    //   194: aload_3
    //   195: ldc 146
    //   197: iconst_0
    //   198: anewarray 4	java/lang/Object
    //   201: invokestatic 150	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   204: aload_0
    //   205: invokestatic 156	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   208: aload_1
    //   209: invokestatic 156	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   212: iconst_0
    //   213: ireturn
    //   214: aload_0
    //   215: astore_1
    //   216: aload_0
    //   217: astore 4
    //   219: new 102	java/io/File
    //   222: dup
    //   223: aload 10
    //   225: aload 7
    //   227: invokevirtual 132	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   230: invokespecial 159	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   233: astore 5
    //   235: aload_0
    //   236: astore_1
    //   237: aload_0
    //   238: astore 4
    //   240: aload 5
    //   242: invokevirtual 163	java/io/File:getParentFile	()Ljava/io/File;
    //   245: invokevirtual 107	java/io/File:mkdirs	()Z
    //   248: pop
    //   249: aload_0
    //   250: astore_1
    //   251: aload_0
    //   252: astore 4
    //   254: aload 7
    //   256: invokevirtual 166	java/util/zip/ZipEntry:isDirectory	()Z
    //   259: ifne -192 -> 67
    //   262: aload_0
    //   263: astore_1
    //   264: aload_0
    //   265: astore 4
    //   267: new 168	java/io/BufferedInputStream
    //   270: dup
    //   271: aload_3
    //   272: aload 7
    //   274: invokevirtual 172	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   277: invokespecial 175	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   280: astore_0
    //   281: sipush 512
    //   284: newarray byte
    //   286: astore 9
    //   288: new 177	java/io/FileOutputStream
    //   291: dup
    //   292: aload 5
    //   294: invokespecial 180	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   297: astore 4
    //   299: new 182	java/io/BufferedOutputStream
    //   302: dup
    //   303: aload 4
    //   305: sipush 512
    //   308: invokespecial 185	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   311: astore_1
    //   312: aload_1
    //   313: astore 5
    //   315: aload 4
    //   317: astore 6
    //   319: ldc 71
    //   321: ldc 187
    //   323: iconst_2
    //   324: anewarray 4	java/lang/Object
    //   327: dup
    //   328: iconst_0
    //   329: aload 7
    //   331: invokevirtual 132	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   334: aastore
    //   335: dup
    //   336: iconst_1
    //   337: aload_0
    //   338: invokevirtual 191	java/io/BufferedInputStream:available	()I
    //   341: invokestatic 197	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   344: aastore
    //   345: invokestatic 79	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   348: aload_1
    //   349: astore 5
    //   351: aload 4
    //   353: astore 6
    //   355: aload_0
    //   356: invokevirtual 191	java/io/BufferedInputStream:available	()I
    //   359: sipush 512
    //   362: if_icmpgt +64 -> 426
    //   365: aload_1
    //   366: astore 5
    //   368: aload 4
    //   370: astore 6
    //   372: aload_0
    //   373: aload 9
    //   375: iconst_0
    //   376: sipush 512
    //   379: invokevirtual 201	java/io/BufferedInputStream:read	([BII)I
    //   382: istore_2
    //   383: iload_2
    //   384: iconst_m1
    //   385: if_icmpeq +29 -> 414
    //   388: aload_1
    //   389: astore 5
    //   391: aload 4
    //   393: astore 6
    //   395: aload_1
    //   396: aload 9
    //   398: iconst_0
    //   399: iload_2
    //   400: invokevirtual 205	java/io/BufferedOutputStream:write	([BII)V
    //   403: aload_1
    //   404: astore 5
    //   406: aload 4
    //   408: astore 6
    //   410: aload_1
    //   411: invokevirtual 208	java/io/BufferedOutputStream:flush	()V
    //   414: aload 4
    //   416: invokestatic 214	com/tencent/mm/a/e:closeOutputStream	(Ljava/io/OutputStream;)V
    //   419: aload_1
    //   420: invokestatic 214	com/tencent/mm/a/e:closeOutputStream	(Ljava/io/OutputStream;)V
    //   423: goto -356 -> 67
    //   426: aload_1
    //   427: astore 5
    //   429: aload 4
    //   431: astore 6
    //   433: aload_0
    //   434: aload 9
    //   436: iconst_0
    //   437: sipush 512
    //   440: invokevirtual 201	java/io/BufferedInputStream:read	([BII)I
    //   443: istore_2
    //   444: iload_2
    //   445: iconst_m1
    //   446: if_icmpeq +55 -> 501
    //   449: aload_1
    //   450: astore 5
    //   452: aload 4
    //   454: astore 6
    //   456: aload_1
    //   457: aload 9
    //   459: iconst_0
    //   460: iload_2
    //   461: invokevirtual 205	java/io/BufferedOutputStream:write	([BII)V
    //   464: goto -38 -> 426
    //   467: astore 7
    //   469: aload_1
    //   470: astore 5
    //   472: aload 4
    //   474: astore 6
    //   476: ldc 71
    //   478: aload 7
    //   480: ldc 146
    //   482: iconst_0
    //   483: anewarray 4	java/lang/Object
    //   486: invokestatic 150	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   489: aload 4
    //   491: invokestatic 214	com/tencent/mm/a/e:closeOutputStream	(Ljava/io/OutputStream;)V
    //   494: aload_1
    //   495: invokestatic 214	com/tencent/mm/a/e:closeOutputStream	(Ljava/io/OutputStream;)V
    //   498: goto -431 -> 67
    //   501: aload_1
    //   502: astore 5
    //   504: aload 4
    //   506: astore 6
    //   508: aload_1
    //   509: invokevirtual 208	java/io/BufferedOutputStream:flush	()V
    //   512: goto -98 -> 414
    //   515: astore_1
    //   516: aload 6
    //   518: astore 4
    //   520: aload 4
    //   522: invokestatic 214	com/tencent/mm/a/e:closeOutputStream	(Ljava/io/OutputStream;)V
    //   525: aload 5
    //   527: invokestatic 214	com/tencent/mm/a/e:closeOutputStream	(Ljava/io/OutputStream;)V
    //   530: aload_1
    //   531: athrow
    //   532: astore 4
    //   534: aload_3
    //   535: astore_1
    //   536: aload 4
    //   538: astore_3
    //   539: goto -347 -> 192
    //   542: aload_0
    //   543: invokestatic 156	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   546: aload_3
    //   547: invokestatic 156	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   550: iconst_1
    //   551: ireturn
    //   552: astore_1
    //   553: aconst_null
    //   554: astore_3
    //   555: aload 6
    //   557: astore_0
    //   558: aload_0
    //   559: invokestatic 156	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   562: aload_3
    //   563: invokestatic 156	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   566: aload_1
    //   567: athrow
    //   568: astore_1
    //   569: aload 4
    //   571: astore_0
    //   572: goto -14 -> 558
    //   575: astore_1
    //   576: goto -18 -> 558
    //   579: astore 4
    //   581: aload_1
    //   582: astore_3
    //   583: aload 4
    //   585: astore_1
    //   586: goto -28 -> 558
    //   589: astore_3
    //   590: aload 7
    //   592: astore_1
    //   593: aload 4
    //   595: astore_0
    //   596: goto -404 -> 192
    //   599: astore_1
    //   600: aconst_null
    //   601: astore 5
    //   603: aconst_null
    //   604: astore 4
    //   606: goto -86 -> 520
    //   609: astore_1
    //   610: aconst_null
    //   611: astore 5
    //   613: goto -93 -> 520
    //   616: astore 7
    //   618: aconst_null
    //   619: astore_1
    //   620: aconst_null
    //   621: astore 4
    //   623: goto -154 -> 469
    //   626: astore 7
    //   628: aconst_null
    //   629: astore_1
    //   630: goto -161 -> 469
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	633	0	paramString1	String
    //   0	633	1	paramString2	String
    //   382	79	2	i	int
    //   50	533	3	localObject1	Object
    //   589	1	3	localException1	java.lang.Exception
    //   4	159	4	localObject2	Object
    //   183	7	4	localException2	java.lang.Exception
    //   217	304	4	localObject3	Object
    //   532	38	4	localException3	java.lang.Exception
    //   579	15	4	localObject4	Object
    //   604	18	4	localObject5	Object
    //   13	599	5	localObject6	Object
    //   7	549	6	localObject7	Object
    //   16	314	7	localZipEntry	java.util.zip.ZipEntry
    //   467	124	7	localException4	java.lang.Exception
    //   616	1	7	localException5	java.lang.Exception
    //   626	1	7	localException6	java.lang.Exception
    //   10	78	8	localEnumeration	java.util.Enumeration
    //   1	457	9	arrayOfByte	byte[]
    //   26	198	10	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   58	64	183	java/lang/Exception
    //   72	82	183	java/lang/Exception
    //   87	99	183	java/lang/Exception
    //   104	123	183	java/lang/Exception
    //   128	141	183	java/lang/Exception
    //   146	159	183	java/lang/Exception
    //   164	180	183	java/lang/Exception
    //   219	235	183	java/lang/Exception
    //   240	249	183	java/lang/Exception
    //   254	262	183	java/lang/Exception
    //   267	281	183	java/lang/Exception
    //   319	348	467	java/lang/Exception
    //   355	365	467	java/lang/Exception
    //   372	383	467	java/lang/Exception
    //   395	403	467	java/lang/Exception
    //   410	414	467	java/lang/Exception
    //   433	444	467	java/lang/Exception
    //   456	464	467	java/lang/Exception
    //   508	512	467	java/lang/Exception
    //   319	348	515	finally
    //   355	365	515	finally
    //   372	383	515	finally
    //   395	403	515	finally
    //   410	414	515	finally
    //   433	444	515	finally
    //   456	464	515	finally
    //   476	489	515	finally
    //   508	512	515	finally
    //   281	288	532	java/lang/Exception
    //   414	423	532	java/lang/Exception
    //   489	498	532	java/lang/Exception
    //   520	532	532	java/lang/Exception
    //   18	51	552	finally
    //   58	64	568	finally
    //   72	82	568	finally
    //   87	99	568	finally
    //   104	123	568	finally
    //   128	141	568	finally
    //   146	159	568	finally
    //   164	180	568	finally
    //   219	235	568	finally
    //   240	249	568	finally
    //   254	262	568	finally
    //   267	281	568	finally
    //   281	288	575	finally
    //   414	423	575	finally
    //   489	498	575	finally
    //   520	532	575	finally
    //   192	204	579	finally
    //   18	51	589	java/lang/Exception
    //   288	299	599	finally
    //   299	312	609	finally
    //   288	299	616	java/lang/Exception
    //   299	312	626	java/lang/Exception
  }
  
  public static boolean cpo()
  {
    y.i("MicroMsg.BeautyDownloadLogic", "isHasBeautyDownloaded: %s", new Object[] { Boolean.valueOf(uau) });
    return uau;
  }
  
  /* Error */
  public final void d(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 11
    //   3: iconst_1
    //   4: istore 9
    //   6: iconst_0
    //   7: istore 8
    //   9: iconst_0
    //   10: istore 10
    //   12: aload_0
    //   13: monitorenter
    //   14: ldc 71
    //   16: ldc 224
    //   18: iconst_1
    //   19: anewarray 4	java/lang/Object
    //   22: dup
    //   23: iconst_0
    //   24: aload_1
    //   25: aastore
    //   26: invokestatic 79	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   29: aload_1
    //   30: invokestatic 69	com/tencent/mm/vfs/e:bK	(Ljava/lang/String;)Z
    //   33: ifeq +295 -> 328
    //   36: aload_1
    //   37: getstatic 39	com/tencent/mm/bw/a:uar	Ljava/lang/String;
    //   40: invokestatic 226	com/tencent/mm/bw/a:at	(Ljava/lang/String;Ljava/lang/String;)Z
    //   43: istore 12
    //   45: ldc 71
    //   47: ldc 228
    //   49: iconst_1
    //   50: anewarray 4	java/lang/Object
    //   53: dup
    //   54: iconst_0
    //   55: iload 12
    //   57: invokestatic 222	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   60: aastore
    //   61: invokestatic 79	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   64: iload 12
    //   66: ifeq +262 -> 328
    //   69: iload 10
    //   71: istore 7
    //   73: new 19	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   80: getstatic 39	com/tencent/mm/bw/a:uar	Ljava/lang/String;
    //   83: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: ldc 230
    //   88: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: invokestatic 69	com/tencent/mm/vfs/e:bK	(Ljava/lang/String;)Z
    //   97: ifeq +545 -> 642
    //   100: new 19	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   107: getstatic 39	com/tencent/mm/bw/a:uar	Ljava/lang/String;
    //   110: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: ldc 230
    //   115: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: invokestatic 234	com/tencent/mm/vfs/e:bP	(Ljava/lang/String;)Ljava/lang/String;
    //   124: astore_1
    //   125: ldc 71
    //   127: ldc 236
    //   129: iconst_1
    //   130: anewarray 4	java/lang/Object
    //   133: dup
    //   134: iconst_0
    //   135: aload_1
    //   136: aastore
    //   137: invokestatic 79	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   140: new 238	org/json/JSONObject
    //   143: dup
    //   144: aload_1
    //   145: invokespecial 239	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   148: astore 13
    //   150: aload 13
    //   152: ldc 241
    //   154: invokevirtual 245	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   157: astore_1
    //   158: aload 13
    //   160: ldc 247
    //   162: invokevirtual 245	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   165: astore 13
    //   167: iload 10
    //   169: istore 7
    //   171: aload_1
    //   172: ifnull +470 -> 642
    //   175: iload 10
    //   177: istore 7
    //   179: aload 13
    //   181: ifnull +461 -> 642
    //   184: aload_1
    //   185: ldc 249
    //   187: invokevirtual 252	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   190: astore 15
    //   192: aload_1
    //   193: ldc 254
    //   195: invokevirtual 252	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   198: astore 14
    //   200: new 19	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   207: getstatic 39	com/tencent/mm/bw/a:uar	Ljava/lang/String;
    //   210: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: aload 15
    //   215: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: astore_1
    //   222: aload_1
    //   223: invokestatic 259	com/tencent/mm/c/g:bQ	(Ljava/lang/String;)Ljava/lang/String;
    //   226: astore 15
    //   228: aload 15
    //   230: invokestatic 262	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   233: ifne +13 -> 246
    //   236: aload 15
    //   238: aload 14
    //   240: invokevirtual 265	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   243: ifne +88 -> 331
    //   246: ldc 71
    //   248: ldc_w 267
    //   251: iconst_2
    //   252: anewarray 4	java/lang/Object
    //   255: dup
    //   256: iconst_0
    //   257: aload 15
    //   259: aastore
    //   260: dup
    //   261: iconst_1
    //   262: aload 14
    //   264: aastore
    //   265: invokestatic 270	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   268: getstatic 276	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   271: ldc2_w 277
    //   274: ldc2_w 279
    //   277: lconst_1
    //   278: invokevirtual 284	com/tencent/mm/plugin/report/service/h:h	(JJJ)V
    //   281: ldc 71
    //   283: ldc_w 286
    //   286: invokestatic 289	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   289: getstatic 39	com/tencent/mm/bw/a:uar	Ljava/lang/String;
    //   292: iconst_1
    //   293: invokestatic 293	com/tencent/mm/vfs/e:K	(Ljava/lang/String;Z)Z
    //   296: pop
    //   297: iconst_0
    //   298: putstatic 49	com/tencent/mm/bw/a:uau	Z
    //   301: getstatic 276	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   304: sipush 15861
    //   307: iconst_2
    //   308: anewarray 4	java/lang/Object
    //   311: dup
    //   312: iconst_0
    //   313: iconst_2
    //   314: invokestatic 197	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   317: aastore
    //   318: dup
    //   319: iconst_1
    //   320: iconst_0
    //   321: invokestatic 197	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   324: aastore
    //   325: invokevirtual 297	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
    //   328: aload_0
    //   329: monitorexit
    //   330: return
    //   331: aload 13
    //   333: ldc 249
    //   335: invokevirtual 252	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   338: astore 14
    //   340: aload 13
    //   342: ldc 254
    //   344: invokevirtual 252	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   347: astore 13
    //   349: new 19	java/lang/StringBuilder
    //   352: dup
    //   353: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   356: getstatic 39	com/tencent/mm/bw/a:uar	Ljava/lang/String;
    //   359: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: aload 14
    //   364: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   370: astore 14
    //   372: aload 14
    //   374: invokestatic 259	com/tencent/mm/c/g:bQ	(Ljava/lang/String;)Ljava/lang/String;
    //   377: astore 15
    //   379: aload 15
    //   381: invokestatic 262	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   384: ifne +13 -> 397
    //   387: aload 15
    //   389: aload 13
    //   391: invokevirtual 265	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   394: ifne +93 -> 487
    //   397: ldc 71
    //   399: ldc_w 299
    //   402: iconst_2
    //   403: anewarray 4	java/lang/Object
    //   406: dup
    //   407: iconst_0
    //   408: aload 15
    //   410: aastore
    //   411: dup
    //   412: iconst_1
    //   413: aload 13
    //   415: aastore
    //   416: invokestatic 270	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   419: getstatic 276	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   422: ldc2_w 277
    //   425: ldc2_w 300
    //   428: lconst_1
    //   429: invokevirtual 284	com/tencent/mm/plugin/report/service/h:h	(JJJ)V
    //   432: ldc 71
    //   434: ldc_w 286
    //   437: invokestatic 289	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   440: getstatic 39	com/tencent/mm/bw/a:uar	Ljava/lang/String;
    //   443: iconst_1
    //   444: invokestatic 293	com/tencent/mm/vfs/e:K	(Ljava/lang/String;Z)Z
    //   447: pop
    //   448: iconst_0
    //   449: putstatic 49	com/tencent/mm/bw/a:uau	Z
    //   452: getstatic 276	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   455: sipush 15861
    //   458: iconst_2
    //   459: anewarray 4	java/lang/Object
    //   462: dup
    //   463: iconst_0
    //   464: iconst_2
    //   465: invokestatic 197	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   468: aastore
    //   469: dup
    //   470: iconst_1
    //   471: iconst_0
    //   472: invokestatic 197	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   475: aastore
    //   476: invokevirtual 297	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
    //   479: goto -151 -> 328
    //   482: astore_1
    //   483: aload_0
    //   484: monitorexit
    //   485: aload_1
    //   486: athrow
    //   487: ldc 71
    //   489: ldc_w 303
    //   492: invokestatic 289	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   495: getstatic 43	com/tencent/mm/bw/a:uas	Ljava/lang/String;
    //   498: aload_1
    //   499: invokevirtual 265	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   502: ifne +11 -> 513
    //   505: aload_1
    //   506: getstatic 43	com/tencent/mm/bw/a:uas	Ljava/lang/String;
    //   509: invokestatic 306	com/tencent/mm/vfs/e:aA	(Ljava/lang/String;Ljava/lang/String;)Z
    //   512: pop
    //   513: getstatic 47	com/tencent/mm/bw/a:uat	Ljava/lang/String;
    //   516: aload 14
    //   518: invokevirtual 265	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   521: ifne +12 -> 533
    //   524: aload 14
    //   526: getstatic 47	com/tencent/mm/bw/a:uat	Ljava/lang/String;
    //   529: invokestatic 306	com/tencent/mm/vfs/e:aA	(Ljava/lang/String;Ljava/lang/String;)Z
    //   532: pop
    //   533: getstatic 43	com/tencent/mm/bw/a:uas	Ljava/lang/String;
    //   536: invokestatic 69	com/tencent/mm/vfs/e:bK	(Ljava/lang/String;)Z
    //   539: ifeq +439 -> 978
    //   542: ldc 71
    //   544: ldc_w 308
    //   547: iconst_1
    //   548: anewarray 4	java/lang/Object
    //   551: dup
    //   552: iconst_0
    //   553: getstatic 43	com/tencent/mm/bw/a:uas	Ljava/lang/String;
    //   556: aastore
    //   557: invokestatic 79	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   560: getstatic 43	com/tencent/mm/bw/a:uas	Ljava/lang/String;
    //   563: invokestatic 85	com/tencent/ttpic/baseutils/SourcePathUtil:setBeautySoPath	(Ljava/lang/String;)V
    //   566: iconst_1
    //   567: istore 5
    //   569: getstatic 47	com/tencent/mm/bw/a:uat	Ljava/lang/String;
    //   572: invokestatic 69	com/tencent/mm/vfs/e:bK	(Ljava/lang/String;)Z
    //   575: ifeq +397 -> 972
    //   578: ldc 71
    //   580: ldc_w 310
    //   583: iconst_1
    //   584: anewarray 4	java/lang/Object
    //   587: dup
    //   588: iconst_0
    //   589: getstatic 47	com/tencent/mm/bw/a:uat	Ljava/lang/String;
    //   592: aastore
    //   593: invokestatic 79	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   596: getstatic 47	com/tencent/mm/bw/a:uat	Ljava/lang/String;
    //   599: invokestatic 90	com/tencent/ttpic/baseutils/SourcePathUtil:setFilterSourcePath	(Ljava/lang/String;)V
    //   602: iconst_1
    //   603: istore 6
    //   605: iload 10
    //   607: istore 7
    //   609: iload 5
    //   611: ifeq +31 -> 642
    //   614: iload 10
    //   616: istore 7
    //   618: iload 6
    //   620: ifeq +22 -> 642
    //   623: ldc 71
    //   625: ldc_w 312
    //   628: invokestatic 289	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   631: iload 11
    //   633: istore 5
    //   635: iconst_1
    //   636: putstatic 49	com/tencent/mm/bw/a:uau	Z
    //   639: iconst_1
    //   640: istore 7
    //   642: iload 7
    //   644: ifne +53 -> 697
    //   647: ldc 71
    //   649: ldc_w 286
    //   652: invokestatic 289	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   655: getstatic 39	com/tencent/mm/bw/a:uar	Ljava/lang/String;
    //   658: iconst_1
    //   659: invokestatic 293	com/tencent/mm/vfs/e:K	(Ljava/lang/String;Z)Z
    //   662: pop
    //   663: iconst_0
    //   664: putstatic 49	com/tencent/mm/bw/a:uau	Z
    //   667: getstatic 276	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   670: sipush 15861
    //   673: iconst_2
    //   674: anewarray 4	java/lang/Object
    //   677: dup
    //   678: iconst_0
    //   679: iconst_2
    //   680: invokestatic 197	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   683: aastore
    //   684: dup
    //   685: iconst_1
    //   686: iconst_0
    //   687: invokestatic 197	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   690: aastore
    //   691: invokevirtual 297	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
    //   694: goto -366 -> 328
    //   697: ldc 71
    //   699: ldc_w 314
    //   702: invokestatic 289	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   705: getstatic 276	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   708: ldc2_w 277
    //   711: ldc2_w 315
    //   714: lconst_1
    //   715: invokevirtual 284	com/tencent/mm/plugin/report/service/h:h	(JJJ)V
    //   718: getstatic 276	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   721: sipush 15861
    //   724: iconst_2
    //   725: anewarray 4	java/lang/Object
    //   728: dup
    //   729: iconst_0
    //   730: iconst_1
    //   731: invokestatic 197	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   734: aastore
    //   735: dup
    //   736: iconst_1
    //   737: iconst_0
    //   738: invokestatic 197	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   741: aastore
    //   742: invokevirtual 297	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
    //   745: invokestatic 322	com/tencent/mm/pluginsdk/g/a/a/b$c:clv	()Lcom/tencent/mm/pluginsdk/g/a/a/b;
    //   748: iload_2
    //   749: iload_3
    //   750: iload 4
    //   752: invokevirtual 328	com/tencent/mm/pluginsdk/g/a/a/b:af	(III)V
    //   755: goto -427 -> 328
    //   758: astore_1
    //   759: iconst_0
    //   760: istore 5
    //   762: ldc 71
    //   764: aload_1
    //   765: ldc_w 330
    //   768: iconst_1
    //   769: anewarray 4	java/lang/Object
    //   772: dup
    //   773: iconst_0
    //   774: aload_1
    //   775: invokevirtual 333	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   778: aastore
    //   779: invokestatic 150	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   782: getstatic 276	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   785: ldc2_w 277
    //   788: ldc2_w 334
    //   791: lconst_1
    //   792: invokevirtual 284	com/tencent/mm/plugin/report/service/h:h	(JJJ)V
    //   795: ldc 71
    //   797: ldc_w 286
    //   800: invokestatic 289	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   803: getstatic 39	com/tencent/mm/bw/a:uar	Ljava/lang/String;
    //   806: iconst_1
    //   807: invokestatic 293	com/tencent/mm/vfs/e:K	(Ljava/lang/String;Z)Z
    //   810: pop
    //   811: iconst_0
    //   812: putstatic 49	com/tencent/mm/bw/a:uau	Z
    //   815: getstatic 276	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   818: sipush 15861
    //   821: iconst_2
    //   822: anewarray 4	java/lang/Object
    //   825: dup
    //   826: iconst_0
    //   827: iconst_2
    //   828: invokestatic 197	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   831: aastore
    //   832: dup
    //   833: iconst_1
    //   834: iconst_0
    //   835: invokestatic 197	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   838: aastore
    //   839: invokevirtual 297	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
    //   842: goto -514 -> 328
    //   845: iload 5
    //   847: ifne +52 -> 899
    //   850: ldc 71
    //   852: ldc_w 286
    //   855: invokestatic 289	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   858: getstatic 39	com/tencent/mm/bw/a:uar	Ljava/lang/String;
    //   861: iconst_1
    //   862: invokestatic 293	com/tencent/mm/vfs/e:K	(Ljava/lang/String;Z)Z
    //   865: pop
    //   866: iconst_0
    //   867: putstatic 49	com/tencent/mm/bw/a:uau	Z
    //   870: getstatic 276	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   873: sipush 15861
    //   876: iconst_2
    //   877: anewarray 4	java/lang/Object
    //   880: dup
    //   881: iconst_0
    //   882: iconst_2
    //   883: invokestatic 197	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   886: aastore
    //   887: dup
    //   888: iconst_1
    //   889: iconst_0
    //   890: invokestatic 197	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   893: aastore
    //   894: invokevirtual 297	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
    //   897: aload_1
    //   898: athrow
    //   899: ldc 71
    //   901: ldc_w 314
    //   904: invokestatic 289	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   907: getstatic 276	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   910: ldc2_w 277
    //   913: ldc2_w 315
    //   916: lconst_1
    //   917: invokevirtual 284	com/tencent/mm/plugin/report/service/h:h	(JJJ)V
    //   920: getstatic 276	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   923: sipush 15861
    //   926: iconst_2
    //   927: anewarray 4	java/lang/Object
    //   930: dup
    //   931: iconst_0
    //   932: iconst_1
    //   933: invokestatic 197	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   936: aastore
    //   937: dup
    //   938: iconst_1
    //   939: iconst_0
    //   940: invokestatic 197	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   943: aastore
    //   944: invokevirtual 297	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
    //   947: invokestatic 322	com/tencent/mm/pluginsdk/g/a/a/b$c:clv	()Lcom/tencent/mm/pluginsdk/g/a/a/b;
    //   950: iload_2
    //   951: iload_3
    //   952: iload 4
    //   954: invokevirtual 328	com/tencent/mm/pluginsdk/g/a/a/b:af	(III)V
    //   957: goto -60 -> 897
    //   960: astore_1
    //   961: goto -116 -> 845
    //   964: astore_1
    //   965: iload 9
    //   967: istore 5
    //   969: goto -207 -> 762
    //   972: iconst_0
    //   973: istore 6
    //   975: goto -370 -> 605
    //   978: iconst_0
    //   979: istore 5
    //   981: goto -412 -> 569
    //   984: astore_1
    //   985: iload 8
    //   987: istore 5
    //   989: goto -144 -> 845
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	992	0	this	a
    //   0	992	1	paramString	String
    //   0	992	2	paramInt1	int
    //   0	992	3	paramInt2	int
    //   0	992	4	paramInt3	int
    //   567	421	5	i	int
    //   603	371	6	j	int
    //   71	572	7	k	int
    //   7	979	8	m	int
    //   4	962	9	n	int
    //   10	605	10	i1	int
    //   1	631	11	i2	int
    //   43	22	12	bool	boolean
    //   148	266	13	localObject	Object
    //   198	327	14	str1	String
    //   190	219	15	str2	String
    // Exception table:
    //   from	to	target	type
    //   14	64	482	finally
    //   281	328	482	finally
    //   432	479	482	finally
    //   647	694	482	finally
    //   697	755	482	finally
    //   795	842	482	finally
    //   850	897	482	finally
    //   897	899	482	finally
    //   899	957	482	finally
    //   73	167	758	java/lang/Exception
    //   184	246	758	java/lang/Exception
    //   246	281	758	java/lang/Exception
    //   331	397	758	java/lang/Exception
    //   397	432	758	java/lang/Exception
    //   487	513	758	java/lang/Exception
    //   513	533	758	java/lang/Exception
    //   533	566	758	java/lang/Exception
    //   569	602	758	java/lang/Exception
    //   623	631	758	java/lang/Exception
    //   635	639	960	finally
    //   762	782	960	finally
    //   635	639	964	java/lang/Exception
    //   73	167	984	finally
    //   184	246	984	finally
    //   246	281	984	finally
    //   331	397	984	finally
    //   397	432	984	finally
    //   487	513	984	finally
    //   513	533	984	finally
    //   533	566	984	finally
    //   569	602	984	finally
    //   623	631	984	finally
    //   782	795	984	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.bw.a
 * JD-Core Version:    0.7.0.1
 */