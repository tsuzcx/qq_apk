package com.tencent.mm.az;

import com.tencent.mm.cf.h.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.sdk.b.c;
import java.util.HashMap;
import java.util.Map;

public class r
  implements ar
{
  private static HashMap<Integer, h.d> dgp;
  private n ewU;
  private b ewV;
  private o ewW = new o();
  private p ewX = new p();
  private q ewY = new q();
  private l ewZ = null;
  c exa = new r.3(this);
  
  static
  {
    HashMap localHashMap = new HashMap();
    dgp = localHashMap;
    localHashMap.put(Integer.valueOf("PACKAGE_INFO_TABLE".hashCode()), new r.1());
    dgp.put(Integer.valueOf("CHATTINGBGINFO_TABLE".hashCode()), new r.2());
  }
  
  private static r PJ()
  {
    return (r)com.tencent.mm.model.p.B(r.class);
  }
  
  public static n PK()
  {
    g.DN().CX();
    if (PJ().ewU == null) {
      PJ().ewU = new n(g.DP().dKu);
    }
    return PJ().ewU;
  }
  
  public static b PL()
  {
    g.DN().CX();
    if (PJ().ewV == null) {
      PJ().ewV = new b(g.DP().dKu);
    }
    return PJ().ewV;
  }
  
  /* Error */
  private boolean mJ(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 143	com/tencent/mm/vfs/b
    //   6: dup
    //   7: aload_1
    //   8: invokespecial 146	com/tencent/mm/vfs/b:<init>	(Ljava/lang/String;)V
    //   11: astore 8
    //   13: aload 8
    //   15: invokevirtual 150	com/tencent/mm/vfs/b:exists	()Z
    //   18: ifne +26 -> 44
    //   21: ldc 152
    //   23: new 154	java/lang/StringBuilder
    //   26: dup
    //   27: ldc 156
    //   29: invokespecial 157	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   32: aload_1
    //   33: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 171	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   42: iconst_0
    //   43: ireturn
    //   44: new 27	java/util/HashMap
    //   47: dup
    //   48: invokespecial 30	java/util/HashMap:<init>	()V
    //   51: astore 7
    //   53: aload 8
    //   55: invokestatic 177	com/tencent/mm/vfs/e:o	(Lcom/tencent/mm/vfs/b;)Ljava/io/InputStream;
    //   58: astore_1
    //   59: new 179	java/io/InputStreamReader
    //   62: dup
    //   63: aload_1
    //   64: ldc 181
    //   66: invokespecial 184	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   69: astore 9
    //   71: new 186	java/io/BufferedReader
    //   74: dup
    //   75: aload 9
    //   77: invokespecial 189	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   80: astore 10
    //   82: aload 10
    //   84: invokevirtual 192	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   87: astore 5
    //   89: aload 5
    //   91: ifnull +396 -> 487
    //   94: aload 5
    //   96: invokevirtual 195	java/lang/String:trim	()Ljava/lang/String;
    //   99: ldc 197
    //   101: invokevirtual 201	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   104: astore 11
    //   106: aload 11
    //   108: arraylength
    //   109: iconst_2
    //   110: if_icmplt +23 -> 133
    //   113: aload 11
    //   115: iconst_0
    //   116: aaload
    //   117: invokestatic 206	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   120: ifne +13 -> 133
    //   123: aload 11
    //   125: iconst_1
    //   126: aaload
    //   127: invokestatic 206	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   130: ifeq +112 -> 242
    //   133: ldc 152
    //   135: new 154	java/lang/StringBuilder
    //   138: dup
    //   139: ldc 208
    //   141: invokespecial 157	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   144: aload 5
    //   146: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokestatic 171	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   155: goto -73 -> 82
    //   158: astore 4
    //   160: ldc 152
    //   162: aload 4
    //   164: ldc 210
    //   166: iconst_0
    //   167: anewarray 4	java/lang/Object
    //   170: invokestatic 214	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   173: aload_1
    //   174: ifnull +7 -> 181
    //   177: aload_1
    //   178: invokevirtual 219	java/io/InputStream:close	()V
    //   181: aload 7
    //   183: invokeinterface 225 1 0
    //   188: invokeinterface 231 1 0
    //   193: astore_1
    //   194: aload_1
    //   195: invokeinterface 236 1 0
    //   200: ifeq +40 -> 240
    //   203: aload_1
    //   204: invokeinterface 240 1 0
    //   209: checkcast 242	java/io/BufferedWriter
    //   212: astore 4
    //   214: aload 4
    //   216: ifnull -22 -> 194
    //   219: aload 4
    //   221: invokevirtual 243	java/io/BufferedWriter:close	()V
    //   224: goto -30 -> 194
    //   227: astore_1
    //   228: ldc 152
    //   230: aload_1
    //   231: ldc 210
    //   233: iconst_0
    //   234: anewarray 4	java/lang/Object
    //   237: invokestatic 214	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   240: iconst_0
    //   241: ireturn
    //   242: aload 7
    //   244: aload 11
    //   246: iconst_0
    //   247: aaload
    //   248: invokeinterface 247 2 0
    //   253: checkcast 242	java/io/BufferedWriter
    //   256: astore 6
    //   258: aload 6
    //   260: astore 5
    //   262: aload 6
    //   264: ifnonnull +93 -> 357
    //   267: invokestatic 253	com/tencent/mm/storage/RegionCodeDecoder:cvV	()Lcom/tencent/mm/storage/RegionCodeDecoder;
    //   270: pop
    //   271: aload 11
    //   273: iconst_0
    //   274: aaload
    //   275: invokestatic 257	com/tencent/mm/storage/RegionCodeDecoder:ack	(Ljava/lang/String;)Ljava/lang/String;
    //   278: astore 5
    //   280: aload 5
    //   282: astore 4
    //   284: aload 5
    //   286: invokestatic 206	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   289: ifne -207 -> 82
    //   292: new 143	com/tencent/mm/vfs/b
    //   295: dup
    //   296: aload 5
    //   298: invokespecial 146	com/tencent/mm/vfs/b:<init>	(Ljava/lang/String;)V
    //   301: astore 4
    //   303: aload 4
    //   305: invokevirtual 150	com/tencent/mm/vfs/b:exists	()Z
    //   308: ifne +9 -> 317
    //   311: aload 4
    //   313: invokevirtual 260	com/tencent/mm/vfs/b:createNewFile	()Z
    //   316: pop
    //   317: new 242	java/io/BufferedWriter
    //   320: dup
    //   321: new 262	com/tencent/mm/vfs/h
    //   324: dup
    //   325: aload 4
    //   327: invokespecial 265	com/tencent/mm/vfs/h:<init>	(Lcom/tencent/mm/vfs/b;)V
    //   330: invokespecial 268	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   333: astore 6
    //   335: aload 7
    //   337: aload 11
    //   339: iconst_0
    //   340: aaload
    //   341: aload 6
    //   343: invokeinterface 269 3 0
    //   348: pop
    //   349: aload 5
    //   351: astore 4
    //   353: aload 6
    //   355: astore 5
    //   357: new 271	java/lang/StringBuffer
    //   360: dup
    //   361: invokespecial 272	java/lang/StringBuffer:<init>	()V
    //   364: astore 6
    //   366: aload 6
    //   368: aload 11
    //   370: iconst_1
    //   371: aaload
    //   372: invokevirtual 275	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   375: pop
    //   376: aload 6
    //   378: bipush 124
    //   380: invokevirtual 278	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   383: pop
    //   384: aload 6
    //   386: aload 11
    //   388: iconst_2
    //   389: aaload
    //   390: invokevirtual 275	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   393: pop
    //   394: aload 6
    //   396: bipush 10
    //   398: invokevirtual 278	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   401: pop
    //   402: aload 5
    //   404: aload 6
    //   406: invokevirtual 279	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   409: invokevirtual 282	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   412: goto -330 -> 82
    //   415: astore 4
    //   417: aload_1
    //   418: ifnull +7 -> 425
    //   421: aload_1
    //   422: invokevirtual 219	java/io/InputStream:close	()V
    //   425: aload 7
    //   427: invokeinterface 225 1 0
    //   432: invokeinterface 231 1 0
    //   437: astore_1
    //   438: aload_1
    //   439: invokeinterface 236 1 0
    //   444: ifeq +40 -> 484
    //   447: aload_1
    //   448: invokeinterface 240 1 0
    //   453: checkcast 242	java/io/BufferedWriter
    //   456: astore 5
    //   458: aload 5
    //   460: ifnull -22 -> 438
    //   463: aload 5
    //   465: invokevirtual 243	java/io/BufferedWriter:close	()V
    //   468: goto -30 -> 438
    //   471: astore_1
    //   472: ldc 152
    //   474: aload_1
    //   475: ldc 210
    //   477: iconst_0
    //   478: anewarray 4	java/lang/Object
    //   481: invokestatic 214	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   484: aload 4
    //   486: athrow
    //   487: aload 7
    //   489: invokeinterface 225 1 0
    //   494: invokeinterface 231 1 0
    //   499: astore 5
    //   501: aload 5
    //   503: invokeinterface 236 1 0
    //   508: ifeq +28 -> 536
    //   511: aload 5
    //   513: invokeinterface 240 1 0
    //   518: checkcast 242	java/io/BufferedWriter
    //   521: astore 6
    //   523: aload 6
    //   525: ifnull -24 -> 501
    //   528: aload 6
    //   530: invokevirtual 285	java/io/BufferedWriter:flush	()V
    //   533: goto -32 -> 501
    //   536: aload 4
    //   538: invokestatic 206	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   541: ifne +72 -> 613
    //   544: new 143	com/tencent/mm/vfs/b
    //   547: dup
    //   548: aload 4
    //   550: invokespecial 146	com/tencent/mm/vfs/b:<init>	(Ljava/lang/String;)V
    //   553: invokevirtual 289	com/tencent/mm/vfs/b:cLq	()Lcom/tencent/mm/vfs/b;
    //   556: new 291	com/tencent/mm/az/r$4
    //   559: dup
    //   560: aload_0
    //   561: invokespecial 292	com/tencent/mm/az/r$4:<init>	(Lcom/tencent/mm/az/r;)V
    //   564: invokevirtual 295	com/tencent/mm/vfs/b:a	(Lcom/tencent/mm/vfs/c;)[Lcom/tencent/mm/vfs/b;
    //   567: astore 4
    //   569: aload 4
    //   571: arraylength
    //   572: istore_3
    //   573: iconst_0
    //   574: istore_2
    //   575: iload_2
    //   576: iload_3
    //   577: if_icmpge +30 -> 607
    //   580: aload 4
    //   582: iload_2
    //   583: aaload
    //   584: astore 5
    //   586: invokestatic 253	com/tencent/mm/storage/RegionCodeDecoder:cvV	()Lcom/tencent/mm/storage/RegionCodeDecoder;
    //   589: pop
    //   590: aload 5
    //   592: aload 5
    //   594: invokevirtual 289	com/tencent/mm/vfs/b:cLq	()Lcom/tencent/mm/vfs/b;
    //   597: invokestatic 298	com/tencent/mm/storage/RegionCodeDecoder:a	(Lcom/tencent/mm/vfs/b;Lcom/tencent/mm/vfs/b;)V
    //   600: iload_2
    //   601: iconst_1
    //   602: iadd
    //   603: istore_2
    //   604: goto -29 -> 575
    //   607: invokestatic 253	com/tencent/mm/storage/RegionCodeDecoder:cvV	()Lcom/tencent/mm/storage/RegionCodeDecoder;
    //   610: invokevirtual 301	com/tencent/mm/storage/RegionCodeDecoder:ctM	()V
    //   613: aload 10
    //   615: invokevirtual 302	java/io/BufferedReader:close	()V
    //   618: aload 9
    //   620: invokevirtual 303	java/io/InputStreamReader:close	()V
    //   623: aload 8
    //   625: invokevirtual 306	com/tencent/mm/vfs/b:delete	()Z
    //   628: pop
    //   629: aload_1
    //   630: ifnull +7 -> 637
    //   633: aload_1
    //   634: invokevirtual 219	java/io/InputStream:close	()V
    //   637: aload 7
    //   639: invokeinterface 225 1 0
    //   644: invokeinterface 231 1 0
    //   649: astore_1
    //   650: aload_1
    //   651: invokeinterface 236 1 0
    //   656: ifeq +40 -> 696
    //   659: aload_1
    //   660: invokeinterface 240 1 0
    //   665: checkcast 242	java/io/BufferedWriter
    //   668: astore 4
    //   670: aload 4
    //   672: ifnull -22 -> 650
    //   675: aload 4
    //   677: invokevirtual 243	java/io/BufferedWriter:close	()V
    //   680: goto -30 -> 650
    //   683: astore_1
    //   684: ldc 152
    //   686: aload_1
    //   687: ldc 210
    //   689: iconst_0
    //   690: anewarray 4	java/lang/Object
    //   693: invokestatic 214	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   696: iconst_1
    //   697: ireturn
    //   698: astore 4
    //   700: aconst_null
    //   701: astore_1
    //   702: goto -285 -> 417
    //   705: astore 4
    //   707: goto -290 -> 417
    //   710: astore 4
    //   712: aconst_null
    //   713: astore_1
    //   714: goto -554 -> 160
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	717	0	this	r
    //   0	717	1	paramString	String
    //   574	30	2	i	int
    //   572	6	3	j	int
    //   1	1	4	localObject1	Object
    //   158	5	4	localException1	java.lang.Exception
    //   212	140	4	localObject2	Object
    //   415	134	4	str	String
    //   567	109	4	localObject3	Object
    //   698	1	4	localObject4	Object
    //   705	1	4	localObject5	Object
    //   710	1	4	localException2	java.lang.Exception
    //   87	506	5	localObject6	Object
    //   256	273	6	localObject7	Object
    //   51	587	7	localHashMap	HashMap
    //   11	613	8	localb	com.tencent.mm.vfs.b
    //   69	550	9	localInputStreamReader	java.io.InputStreamReader
    //   80	534	10	localBufferedReader	java.io.BufferedReader
    //   104	283	11	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   59	82	158	java/lang/Exception
    //   82	89	158	java/lang/Exception
    //   94	133	158	java/lang/Exception
    //   133	155	158	java/lang/Exception
    //   242	258	158	java/lang/Exception
    //   267	280	158	java/lang/Exception
    //   284	317	158	java/lang/Exception
    //   317	349	158	java/lang/Exception
    //   357	412	158	java/lang/Exception
    //   487	501	158	java/lang/Exception
    //   501	523	158	java/lang/Exception
    //   528	533	158	java/lang/Exception
    //   536	573	158	java/lang/Exception
    //   586	600	158	java/lang/Exception
    //   607	613	158	java/lang/Exception
    //   613	629	158	java/lang/Exception
    //   177	181	227	java/io/IOException
    //   181	194	227	java/io/IOException
    //   194	214	227	java/io/IOException
    //   219	224	227	java/io/IOException
    //   59	82	415	finally
    //   82	89	415	finally
    //   94	133	415	finally
    //   133	155	415	finally
    //   242	258	415	finally
    //   267	280	415	finally
    //   284	317	415	finally
    //   317	349	415	finally
    //   357	412	415	finally
    //   487	501	415	finally
    //   501	523	415	finally
    //   528	533	415	finally
    //   536	573	415	finally
    //   586	600	415	finally
    //   607	613	415	finally
    //   613	629	415	finally
    //   421	425	471	java/io/IOException
    //   425	438	471	java/io/IOException
    //   438	458	471	java/io/IOException
    //   463	468	471	java/io/IOException
    //   633	637	683	java/io/IOException
    //   637	650	683	java/io/IOException
    //   650	670	683	java/io/IOException
    //   675	680	683	java/io/IOException
    //   53	59	698	finally
    //   160	173	705	finally
    //   53	59	710	java/lang/Exception
  }
  
  public final void bh(boolean paramBoolean)
  {
    com.tencent.mm.sdk.b.a.udP.c(this.ewW);
    com.tencent.mm.sdk.b.a.udP.c(this.ewX);
    com.tencent.mm.sdk.b.a.udP.c(this.ewY);
    com.tencent.mm.sdk.b.a.udP.c(this.exa);
    if (this.ewZ != null) {
      this.ewZ.ewP.clear();
    }
    for (;;)
    {
      com.tencent.mm.sdk.b.a.udP.c(this.ewZ.ewQ);
      com.tencent.mm.sdk.b.a.udP.c(this.ewZ.ewR);
      return;
      this.ewZ = new l();
    }
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    com.tencent.mm.sdk.b.a.udP.d(this.ewW);
    com.tencent.mm.sdk.b.a.udP.d(this.ewX);
    com.tencent.mm.sdk.b.a.udP.d(this.ewY);
    com.tencent.mm.sdk.b.a.udP.d(this.ewZ.ewQ);
    com.tencent.mm.sdk.b.a.udP.d(this.ewZ.ewR);
    com.tencent.mm.sdk.b.a.udP.d(this.exa);
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return dgp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.az.r
 * JD-Core Version:    0.7.0.1
 */