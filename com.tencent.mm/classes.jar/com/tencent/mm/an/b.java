package com.tencent.mm.an;

import com.tencent.mm.c.g;
import com.tencent.mm.h.a.be;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.g.a.a.b.c;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public class b
{
  public static final String ekC = com.tencent.mm.compatible.util.e.dOQ + "fonts/";
  public static final String ekD = ekC + "temp/";
  public static final String ekE = ekC + "WXkatonglemiao.ttf";
  public static final String ekF = ekC + "WXxiari.ttf";
  private static b ekG;
  private String ekH = "emoji_font_meta.json";
  public boolean ekI = false;
  public c<be> ekJ = new b.1(this);
  
  public static b NC()
  {
    try
    {
      if (ekG == null) {
        ekG = new b();
      }
      return ekG;
    }
    finally {}
  }
  
  public static void NE()
  {
    b.c.clv();
    com.tencent.mm.pluginsdk.g.a.a.b.DL(57);
  }
  
  public static String[] NG()
  {
    return new String[] { ekF, ekE };
  }
  
  /* Error */
  private static boolean at(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 5
    //   9: aload 6
    //   11: astore 4
    //   13: aload 7
    //   15: astore_3
    //   16: new 102	java/io/File
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 105	java/io/File:<init>	(Ljava/lang/String;)V
    //   24: astore 8
    //   26: aload 6
    //   28: astore 4
    //   30: aload 7
    //   32: astore_3
    //   33: aload 8
    //   35: invokevirtual 109	java/io/File:mkdirs	()Z
    //   38: pop
    //   39: aload 6
    //   41: astore 4
    //   43: aload 7
    //   45: astore_3
    //   46: new 111	java/util/zip/ZipFile
    //   49: dup
    //   50: new 102	java/io/File
    //   53: dup
    //   54: aload_0
    //   55: invokespecial 105	java/io/File:<init>	(Ljava/lang/String;)V
    //   58: iconst_1
    //   59: invokespecial 114	java/util/zip/ZipFile:<init>	(Ljava/io/File;I)V
    //   62: astore 9
    //   64: aload 6
    //   66: astore 4
    //   68: aload 7
    //   70: astore_3
    //   71: aload 9
    //   73: invokevirtual 118	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   76: astore 7
    //   78: aload 5
    //   80: astore_0
    //   81: aload_0
    //   82: astore 4
    //   84: aload_0
    //   85: astore_3
    //   86: aload 7
    //   88: invokeinterface 123 1 0
    //   93: ifeq +437 -> 530
    //   96: aload_0
    //   97: astore 4
    //   99: aload_0
    //   100: astore_3
    //   101: aload 7
    //   103: invokeinterface 127 1 0
    //   108: checkcast 129	java/util/zip/ZipEntry
    //   111: astore 6
    //   113: aload_0
    //   114: astore 4
    //   116: aload_0
    //   117: astore_3
    //   118: ldc 131
    //   120: ldc 133
    //   122: iconst_1
    //   123: anewarray 4	java/lang/Object
    //   126: dup
    //   127: iconst_0
    //   128: aload 6
    //   130: invokevirtual 136	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   133: aastore
    //   134: invokestatic 142	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   137: aload_0
    //   138: astore 4
    //   140: aload_0
    //   141: astore_3
    //   142: aload 6
    //   144: invokevirtual 136	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   147: ldc 144
    //   149: invokevirtual 148	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   152: ifne +21 -> 173
    //   155: aload_0
    //   156: astore 4
    //   158: aload_0
    //   159: astore_3
    //   160: aload 6
    //   162: invokevirtual 136	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   165: ldc 150
    //   167: invokevirtual 148	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   170: ifeq +50 -> 220
    //   173: aload_0
    //   174: astore 4
    //   176: aload_0
    //   177: astore_3
    //   178: ldc 131
    //   180: ldc 152
    //   182: iconst_1
    //   183: anewarray 4	java/lang/Object
    //   186: dup
    //   187: iconst_0
    //   188: aload 6
    //   190: aastore
    //   191: invokestatic 142	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   194: goto -113 -> 81
    //   197: astore_0
    //   198: aload 4
    //   200: astore_3
    //   201: ldc 131
    //   203: aload_0
    //   204: ldc 154
    //   206: iconst_0
    //   207: anewarray 4	java/lang/Object
    //   210: invokestatic 158	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   213: aload 4
    //   215: invokestatic 164	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   218: iconst_0
    //   219: ireturn
    //   220: aload_0
    //   221: astore 4
    //   223: aload_0
    //   224: astore_3
    //   225: new 102	java/io/File
    //   228: dup
    //   229: aload 8
    //   231: aload 6
    //   233: invokevirtual 136	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   236: invokespecial 167	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   239: astore_1
    //   240: aload_0
    //   241: astore 4
    //   243: aload_0
    //   244: astore_3
    //   245: aload_1
    //   246: invokevirtual 171	java/io/File:getParentFile	()Ljava/io/File;
    //   249: invokevirtual 109	java/io/File:mkdirs	()Z
    //   252: pop
    //   253: aload_0
    //   254: astore 4
    //   256: aload_0
    //   257: astore_3
    //   258: aload 6
    //   260: invokevirtual 174	java/util/zip/ZipEntry:isDirectory	()Z
    //   263: ifne -182 -> 81
    //   266: aload_0
    //   267: astore 4
    //   269: aload_0
    //   270: astore_3
    //   271: new 176	java/io/BufferedInputStream
    //   274: dup
    //   275: aload 9
    //   277: aload 6
    //   279: invokevirtual 180	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   282: invokespecial 183	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   285: astore_0
    //   286: sipush 512
    //   289: newarray byte
    //   291: astore 10
    //   293: new 185	java/io/FileOutputStream
    //   296: dup
    //   297: aload_1
    //   298: invokespecial 188	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   301: astore_3
    //   302: new 190	java/io/BufferedOutputStream
    //   305: dup
    //   306: aload_3
    //   307: sipush 512
    //   310: invokespecial 193	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   313: astore_1
    //   314: aload_1
    //   315: astore 4
    //   317: aload_3
    //   318: astore 5
    //   320: ldc 131
    //   322: ldc 195
    //   324: iconst_2
    //   325: anewarray 4	java/lang/Object
    //   328: dup
    //   329: iconst_0
    //   330: aload 6
    //   332: invokevirtual 136	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   335: aastore
    //   336: dup
    //   337: iconst_1
    //   338: aload_0
    //   339: invokevirtual 199	java/io/BufferedInputStream:available	()I
    //   342: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   345: aastore
    //   346: invokestatic 142	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   349: aload_1
    //   350: astore 4
    //   352: aload_3
    //   353: astore 5
    //   355: aload_0
    //   356: invokevirtual 199	java/io/BufferedInputStream:available	()I
    //   359: sipush 512
    //   362: if_icmpgt +60 -> 422
    //   365: aload_1
    //   366: astore 4
    //   368: aload_3
    //   369: astore 5
    //   371: aload_0
    //   372: aload 10
    //   374: iconst_0
    //   375: sipush 512
    //   378: invokevirtual 209	java/io/BufferedInputStream:read	([BII)I
    //   381: istore_2
    //   382: iload_2
    //   383: iconst_m1
    //   384: if_icmpeq +27 -> 411
    //   387: aload_1
    //   388: astore 4
    //   390: aload_3
    //   391: astore 5
    //   393: aload_1
    //   394: aload 10
    //   396: iconst_0
    //   397: iload_2
    //   398: invokevirtual 213	java/io/BufferedOutputStream:write	([BII)V
    //   401: aload_1
    //   402: astore 4
    //   404: aload_3
    //   405: astore 5
    //   407: aload_1
    //   408: invokevirtual 216	java/io/BufferedOutputStream:flush	()V
    //   411: aload_3
    //   412: invokestatic 222	com/tencent/mm/a/e:closeOutputStream	(Ljava/io/OutputStream;)V
    //   415: aload_1
    //   416: invokestatic 222	com/tencent/mm/a/e:closeOutputStream	(Ljava/io/OutputStream;)V
    //   419: goto -338 -> 81
    //   422: aload_1
    //   423: astore 4
    //   425: aload_3
    //   426: astore 5
    //   428: aload_0
    //   429: aload 10
    //   431: iconst_0
    //   432: sipush 512
    //   435: invokevirtual 209	java/io/BufferedInputStream:read	([BII)I
    //   438: istore_2
    //   439: iload_2
    //   440: iconst_m1
    //   441: if_icmpeq +52 -> 493
    //   444: aload_1
    //   445: astore 4
    //   447: aload_3
    //   448: astore 5
    //   450: aload_1
    //   451: aload 10
    //   453: iconst_0
    //   454: iload_2
    //   455: invokevirtual 213	java/io/BufferedOutputStream:write	([BII)V
    //   458: goto -36 -> 422
    //   461: astore 6
    //   463: aload_1
    //   464: astore 4
    //   466: aload_3
    //   467: astore 5
    //   469: ldc 131
    //   471: aload 6
    //   473: ldc 154
    //   475: iconst_0
    //   476: anewarray 4	java/lang/Object
    //   479: invokestatic 158	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   482: aload_3
    //   483: invokestatic 222	com/tencent/mm/a/e:closeOutputStream	(Ljava/io/OutputStream;)V
    //   486: aload_1
    //   487: invokestatic 222	com/tencent/mm/a/e:closeOutputStream	(Ljava/io/OutputStream;)V
    //   490: goto -409 -> 81
    //   493: aload_1
    //   494: astore 4
    //   496: aload_3
    //   497: astore 5
    //   499: aload_1
    //   500: invokevirtual 216	java/io/BufferedOutputStream:flush	()V
    //   503: goto -92 -> 411
    //   506: astore_1
    //   507: aload 5
    //   509: astore_3
    //   510: aload_3
    //   511: invokestatic 222	com/tencent/mm/a/e:closeOutputStream	(Ljava/io/OutputStream;)V
    //   514: aload 4
    //   516: invokestatic 222	com/tencent/mm/a/e:closeOutputStream	(Ljava/io/OutputStream;)V
    //   519: aload_1
    //   520: athrow
    //   521: astore_1
    //   522: aload_0
    //   523: astore 4
    //   525: aload_1
    //   526: astore_0
    //   527: goto -329 -> 198
    //   530: aload_0
    //   531: invokestatic 164	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   534: iconst_1
    //   535: ireturn
    //   536: astore_0
    //   537: aload_3
    //   538: invokestatic 164	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   541: aload_0
    //   542: athrow
    //   543: astore_1
    //   544: aload_0
    //   545: astore_3
    //   546: aload_1
    //   547: astore_0
    //   548: goto -11 -> 537
    //   551: astore_1
    //   552: aconst_null
    //   553: astore 4
    //   555: aconst_null
    //   556: astore_3
    //   557: goto -47 -> 510
    //   560: astore_1
    //   561: aconst_null
    //   562: astore 4
    //   564: goto -54 -> 510
    //   567: astore 6
    //   569: aconst_null
    //   570: astore_1
    //   571: aconst_null
    //   572: astore_3
    //   573: goto -110 -> 463
    //   576: astore 6
    //   578: aconst_null
    //   579: astore_1
    //   580: goto -117 -> 463
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	583	0	paramString1	String
    //   0	583	1	paramString2	String
    //   381	74	2	i	int
    //   15	558	3	localObject1	Object
    //   11	552	4	localObject2	Object
    //   7	501	5	localObject3	Object
    //   1	330	6	localZipEntry	java.util.zip.ZipEntry
    //   461	11	6	localException1	Exception
    //   567	1	6	localException2	Exception
    //   576	1	6	localException3	Exception
    //   4	98	7	localEnumeration	java.util.Enumeration
    //   24	206	8	localFile	java.io.File
    //   62	214	9	localZipFile	java.util.zip.ZipFile
    //   291	161	10	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   16	26	197	java/lang/Exception
    //   33	39	197	java/lang/Exception
    //   46	64	197	java/lang/Exception
    //   71	78	197	java/lang/Exception
    //   86	96	197	java/lang/Exception
    //   101	113	197	java/lang/Exception
    //   118	137	197	java/lang/Exception
    //   142	155	197	java/lang/Exception
    //   160	173	197	java/lang/Exception
    //   178	194	197	java/lang/Exception
    //   225	240	197	java/lang/Exception
    //   245	253	197	java/lang/Exception
    //   258	266	197	java/lang/Exception
    //   271	286	197	java/lang/Exception
    //   320	349	461	java/lang/Exception
    //   355	365	461	java/lang/Exception
    //   371	382	461	java/lang/Exception
    //   393	401	461	java/lang/Exception
    //   407	411	461	java/lang/Exception
    //   428	439	461	java/lang/Exception
    //   450	458	461	java/lang/Exception
    //   499	503	461	java/lang/Exception
    //   320	349	506	finally
    //   355	365	506	finally
    //   371	382	506	finally
    //   393	401	506	finally
    //   407	411	506	finally
    //   428	439	506	finally
    //   450	458	506	finally
    //   469	482	506	finally
    //   499	503	506	finally
    //   286	293	521	java/lang/Exception
    //   411	419	521	java/lang/Exception
    //   482	490	521	java/lang/Exception
    //   510	521	521	java/lang/Exception
    //   16	26	536	finally
    //   33	39	536	finally
    //   46	64	536	finally
    //   71	78	536	finally
    //   86	96	536	finally
    //   101	113	536	finally
    //   118	137	536	finally
    //   142	155	536	finally
    //   160	173	536	finally
    //   178	194	536	finally
    //   201	213	536	finally
    //   225	240	536	finally
    //   245	253	536	finally
    //   258	266	536	finally
    //   271	286	536	finally
    //   286	293	543	finally
    //   411	419	543	finally
    //   482	490	543	finally
    //   510	521	543	finally
    //   293	302	551	finally
    //   302	314	560	finally
    //   293	302	567	java/lang/Exception
    //   302	314	576	java/lang/Exception
  }
  
  private static boolean d(JSONObject paramJSONObject, String paramString)
  {
    boolean bool = true;
    String str1 = paramJSONObject.optString("name");
    paramJSONObject = paramJSONObject.optString("md5");
    String str2 = ekD + str1;
    String str3 = g.bQ(str2);
    if ((bk.bl(str3)) || (!str3.equalsIgnoreCase(paramJSONObject)))
    {
      y.e("MicroMsg.FontResLogic", "download %s not match! %s %s", new Object[] { str1, str3, paramJSONObject });
      bool = false;
    }
    while (paramString.equalsIgnoreCase(str2)) {
      return bool;
    }
    com.tencent.mm.vfs.e.aA(str2, paramString);
    return true;
  }
  
  public final boolean ND()
  {
    return this.ekI;
  }
  
  public final boolean NF()
  {
    if ((com.tencent.mm.vfs.e.bK(ekE)) && (com.tencent.mm.vfs.e.bK(ekF))) {
      y.i("MicroMsg.FontResLogic", "font file exist");
    }
    for (this.ekI = true;; this.ekI = false) {
      return this.ekI;
    }
  }
  
  public final void d(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 1;
    for (;;)
    {
      JSONObject localJSONObject;
      try
      {
        y.i("MicroMsg.FontResLogic", "unzipRes: %s", new Object[] { paramString });
        if (com.tencent.mm.vfs.e.bK(paramString))
        {
          boolean bool = at(paramString, ekD);
          y.i("MicroMsg.FontResLogic", "unzip file ret: %s", new Object[] { Boolean.valueOf(bool) });
          if (!bool) {}
        }
      }
      finally {}
      try
      {
        if (!com.tencent.mm.vfs.e.bK(ekD + this.ekH)) {
          break label438;
        }
        paramString = com.tencent.mm.vfs.e.bP(ekD + this.ekH);
        y.i("MicroMsg.FontResLogic", "meta json: %s", new Object[] { paramString });
        localJSONObject = new JSONObject(paramString);
        paramString = localJSONObject.optJSONObject("WXkatonglemiao.ttf");
        localJSONObject = localJSONObject.optJSONObject("WXxiari.ttf");
        if ((paramString == null) || (localJSONObject == null)) {
          break label438;
        }
        if (d(paramString, ekE)) {
          continue;
        }
        h.nFQ.h(933L, 13L, 1L);
      }
      catch (Exception paramString)
      {
        y.printErrStackTrace("MicroMsg.FontResLogic", paramString, "unzipRes error: %s", new Object[] { paramString.getMessage() });
        h.nFQ.h(933L, 15L, 1L);
        y.i("MicroMsg.FontResLogic", "unzip failed");
        this.ekI = false;
        com.tencent.mm.vfs.e.K(ekD, true);
        continue;
      }
      finally
      {
        y.i("MicroMsg.FontResLogic", "unzip failed");
        this.ekI = false;
        com.tencent.mm.vfs.e.K(ekD, true);
      }
      return;
      if (d(localJSONObject, ekF)) {
        break;
      }
      h.nFQ.h(933L, 14L, 1L);
      y.i("MicroMsg.FontResLogic", "unzip failed");
      this.ekI = false;
      com.tencent.mm.vfs.e.K(ekD, true);
    }
    y.i("MicroMsg.FontResLogic", "unzip res success");
    if (NF()) {
      y.i("MicroMsg.FontResLogic", "unzipRes success");
    }
    for (;;)
    {
      if (i == 0)
      {
        y.i("MicroMsg.FontResLogic", "unzip failed");
        this.ekI = false;
      }
      for (;;)
      {
        com.tencent.mm.vfs.e.K(ekD, true);
        break;
        y.i("MicroMsg.FontResLogic", "unzip success");
        h.nFQ.h(933L, 16L, 1L);
        b.c.clv().af(paramInt1, paramInt2, paramInt3);
      }
      label438:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.an.b
 * JD-Core Version:    0.7.0.1
 */