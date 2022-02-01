package com.tencent.mm.bc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bk;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Map;

public class t
  implements aw
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private p hpG;
  private b hpH;
  private q hpI;
  private r hpJ;
  private s hpK;
  private n hpL;
  c hpM;
  
  static
  {
    AppMethodBeat.i(150869);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("PACKAGE_INFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return p.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("CHATTINGBGINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return b.SQL_CREATE;
      }
    });
    AppMethodBeat.o(150869);
  }
  
  public t()
  {
    AppMethodBeat.i(150861);
    this.hpI = new q();
    this.hpJ = new r();
    this.hpK = new s();
    this.hpL = null;
    this.hpM = new c() {};
    AppMethodBeat.o(150861);
  }
  
  private static t azX()
  {
    AppMethodBeat.i(150862);
    t localt = (t)com.tencent.mm.model.t.ap(t.class);
    AppMethodBeat.o(150862);
    return localt;
  }
  
  public static p azY()
  {
    AppMethodBeat.i(150863);
    com.tencent.mm.kernel.g.afz().aeD();
    if (azX().hpG == null) {
      azX().hpG = new p(com.tencent.mm.kernel.g.afB().gda);
    }
    p localp = azX().hpG;
    AppMethodBeat.o(150863);
    return localp;
  }
  
  public static b azZ()
  {
    AppMethodBeat.i(150864);
    com.tencent.mm.kernel.g.afz().aeD();
    if (azX().hpH == null) {
      azX().hpH = new b(com.tencent.mm.kernel.g.afB().gda);
    }
    b localb = azX().hpH;
    AppMethodBeat.o(150864);
    return localb;
  }
  
  /* Error */
  private boolean yS(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc 159
    //   5: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 161	com/tencent/mm/vfs/e
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 164	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   16: astore 8
    //   18: aload 8
    //   20: invokevirtual 168	com/tencent/mm/vfs/e:exists	()Z
    //   23: ifne +24 -> 47
    //   26: ldc 170
    //   28: ldc 172
    //   30: aload_1
    //   31: invokestatic 175	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   34: invokevirtual 179	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   37: invokestatic 185	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: ldc 159
    //   42: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: iconst_0
    //   46: ireturn
    //   47: new 42	java/util/HashMap
    //   50: dup
    //   51: invokespecial 45	java/util/HashMap:<init>	()V
    //   54: astore 7
    //   56: aload 8
    //   58: invokestatic 191	com/tencent/mm/vfs/i:ah	(Lcom/tencent/mm/vfs/e;)Ljava/io/InputStream;
    //   61: astore_1
    //   62: new 193	java/io/InputStreamReader
    //   65: dup
    //   66: aload_1
    //   67: ldc 195
    //   69: invokespecial 198	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   72: astore 9
    //   74: new 200	java/io/BufferedReader
    //   77: dup
    //   78: aload 9
    //   80: invokespecial 203	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   83: astore 10
    //   85: aload 10
    //   87: invokevirtual 207	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   90: astore 5
    //   92: aload 5
    //   94: ifnull +399 -> 493
    //   97: aload 5
    //   99: invokevirtual 210	java/lang/String:trim	()Ljava/lang/String;
    //   102: ldc 212
    //   104: invokevirtual 216	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   107: astore 11
    //   109: aload 11
    //   111: arraylength
    //   112: iconst_2
    //   113: if_icmplt +23 -> 136
    //   116: aload 11
    //   118: iconst_0
    //   119: aaload
    //   120: invokestatic 221	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   123: ifne +13 -> 136
    //   126: aload 11
    //   128: iconst_1
    //   129: aaload
    //   130: invokestatic 221	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   133: ifeq +110 -> 243
    //   136: ldc 170
    //   138: ldc 223
    //   140: aload 5
    //   142: invokestatic 175	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   145: invokevirtual 179	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   148: invokestatic 185	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: goto -66 -> 85
    //   154: astore 4
    //   156: ldc 170
    //   158: aload 4
    //   160: ldc 225
    //   162: iconst_0
    //   163: anewarray 4	java/lang/Object
    //   166: invokestatic 229	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   169: aload_1
    //   170: ifnull +7 -> 177
    //   173: aload_1
    //   174: invokevirtual 234	java/io/InputStream:close	()V
    //   177: aload 7
    //   179: invokeinterface 240 1 0
    //   184: invokeinterface 246 1 0
    //   189: astore_1
    //   190: aload_1
    //   191: invokeinterface 251 1 0
    //   196: ifeq +40 -> 236
    //   199: aload_1
    //   200: invokeinterface 255 1 0
    //   205: checkcast 257	java/io/BufferedWriter
    //   208: astore 4
    //   210: aload 4
    //   212: ifnull -22 -> 190
    //   215: aload 4
    //   217: invokevirtual 258	java/io/BufferedWriter:close	()V
    //   220: goto -30 -> 190
    //   223: astore_1
    //   224: ldc 170
    //   226: aload_1
    //   227: ldc 225
    //   229: iconst_0
    //   230: anewarray 4	java/lang/Object
    //   233: invokestatic 229	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   236: ldc 159
    //   238: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   241: iconst_0
    //   242: ireturn
    //   243: aload 7
    //   245: aload 11
    //   247: iconst_0
    //   248: aaload
    //   249: invokeinterface 262 2 0
    //   254: checkcast 257	java/io/BufferedWriter
    //   257: astore 6
    //   259: aload 6
    //   261: astore 5
    //   263: aload 6
    //   265: ifnonnull +93 -> 358
    //   268: invokestatic 268	com/tencent/mm/storage/RegionCodeDecoder:eMO	()Lcom/tencent/mm/storage/RegionCodeDecoder;
    //   271: pop
    //   272: aload 11
    //   274: iconst_0
    //   275: aaload
    //   276: invokestatic 271	com/tencent/mm/storage/RegionCodeDecoder:aJb	(Ljava/lang/String;)Ljava/lang/String;
    //   279: astore 5
    //   281: aload 5
    //   283: astore 4
    //   285: aload 5
    //   287: invokestatic 221	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   290: ifne -205 -> 85
    //   293: new 161	com/tencent/mm/vfs/e
    //   296: dup
    //   297: aload 5
    //   299: invokespecial 164	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   302: astore 4
    //   304: aload 4
    //   306: invokevirtual 168	com/tencent/mm/vfs/e:exists	()Z
    //   309: ifne +9 -> 318
    //   312: aload 4
    //   314: invokevirtual 274	com/tencent/mm/vfs/e:createNewFile	()Z
    //   317: pop
    //   318: new 257	java/io/BufferedWriter
    //   321: dup
    //   322: new 276	com/tencent/mm/vfs/l
    //   325: dup
    //   326: aload 4
    //   328: invokespecial 279	com/tencent/mm/vfs/l:<init>	(Lcom/tencent/mm/vfs/e;)V
    //   331: invokespecial 282	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   334: astore 6
    //   336: aload 7
    //   338: aload 11
    //   340: iconst_0
    //   341: aaload
    //   342: aload 6
    //   344: invokeinterface 283 3 0
    //   349: pop
    //   350: aload 5
    //   352: astore 4
    //   354: aload 6
    //   356: astore 5
    //   358: new 285	java/lang/StringBuffer
    //   361: dup
    //   362: invokespecial 286	java/lang/StringBuffer:<init>	()V
    //   365: astore 6
    //   367: aload 6
    //   369: aload 11
    //   371: iconst_1
    //   372: aaload
    //   373: invokevirtual 290	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   376: pop
    //   377: aload 6
    //   379: bipush 124
    //   381: invokevirtual 293	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   384: pop
    //   385: aload 6
    //   387: aload 11
    //   389: iconst_2
    //   390: aaload
    //   391: invokevirtual 290	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   394: pop
    //   395: aload 6
    //   397: bipush 10
    //   399: invokevirtual 293	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   402: pop
    //   403: aload 5
    //   405: aload 6
    //   407: invokevirtual 296	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   410: invokevirtual 299	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   413: goto -328 -> 85
    //   416: astore 4
    //   418: aload_1
    //   419: ifnull +7 -> 426
    //   422: aload_1
    //   423: invokevirtual 234	java/io/InputStream:close	()V
    //   426: aload 7
    //   428: invokeinterface 240 1 0
    //   433: invokeinterface 246 1 0
    //   438: astore_1
    //   439: aload_1
    //   440: invokeinterface 251 1 0
    //   445: ifeq +40 -> 485
    //   448: aload_1
    //   449: invokeinterface 255 1 0
    //   454: checkcast 257	java/io/BufferedWriter
    //   457: astore 5
    //   459: aload 5
    //   461: ifnull -22 -> 439
    //   464: aload 5
    //   466: invokevirtual 258	java/io/BufferedWriter:close	()V
    //   469: goto -30 -> 439
    //   472: astore_1
    //   473: ldc 170
    //   475: aload_1
    //   476: ldc 225
    //   478: iconst_0
    //   479: anewarray 4	java/lang/Object
    //   482: invokestatic 229	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   485: ldc 159
    //   487: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   490: aload 4
    //   492: athrow
    //   493: aload 7
    //   495: invokeinterface 240 1 0
    //   500: invokeinterface 246 1 0
    //   505: astore 5
    //   507: aload 5
    //   509: invokeinterface 251 1 0
    //   514: ifeq +28 -> 542
    //   517: aload 5
    //   519: invokeinterface 255 1 0
    //   524: checkcast 257	java/io/BufferedWriter
    //   527: astore 6
    //   529: aload 6
    //   531: ifnull -24 -> 507
    //   534: aload 6
    //   536: invokevirtual 302	java/io/BufferedWriter:flush	()V
    //   539: goto -32 -> 507
    //   542: aload 4
    //   544: invokestatic 221	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   547: ifne +72 -> 619
    //   550: new 161	com/tencent/mm/vfs/e
    //   553: dup
    //   554: aload 4
    //   556: invokespecial 164	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   559: invokevirtual 306	com/tencent/mm/vfs/e:fhT	()Lcom/tencent/mm/vfs/e;
    //   562: new 14	com/tencent/mm/bc/t$4
    //   565: dup
    //   566: aload_0
    //   567: invokespecial 307	com/tencent/mm/bc/t$4:<init>	(Lcom/tencent/mm/bc/t;)V
    //   570: invokevirtual 310	com/tencent/mm/vfs/e:a	(Lcom/tencent/mm/vfs/g;)[Lcom/tencent/mm/vfs/e;
    //   573: astore 4
    //   575: aload 4
    //   577: arraylength
    //   578: istore_3
    //   579: iconst_0
    //   580: istore_2
    //   581: iload_2
    //   582: iload_3
    //   583: if_icmpge +30 -> 613
    //   586: aload 4
    //   588: iload_2
    //   589: aaload
    //   590: astore 5
    //   592: invokestatic 268	com/tencent/mm/storage/RegionCodeDecoder:eMO	()Lcom/tencent/mm/storage/RegionCodeDecoder;
    //   595: pop
    //   596: aload 5
    //   598: aload 5
    //   600: invokevirtual 306	com/tencent/mm/vfs/e:fhT	()Lcom/tencent/mm/vfs/e;
    //   603: invokestatic 314	com/tencent/mm/storage/RegionCodeDecoder:d	(Lcom/tencent/mm/vfs/e;Lcom/tencent/mm/vfs/e;)V
    //   606: iload_2
    //   607: iconst_1
    //   608: iadd
    //   609: istore_2
    //   610: goto -29 -> 581
    //   613: invokestatic 268	com/tencent/mm/storage/RegionCodeDecoder:eMO	()Lcom/tencent/mm/storage/RegionCodeDecoder;
    //   616: invokevirtual 317	com/tencent/mm/storage/RegionCodeDecoder:eKn	()V
    //   619: aload 10
    //   621: invokevirtual 318	java/io/BufferedReader:close	()V
    //   624: aload 9
    //   626: invokevirtual 319	java/io/InputStreamReader:close	()V
    //   629: aload 8
    //   631: invokevirtual 322	com/tencent/mm/vfs/e:delete	()Z
    //   634: pop
    //   635: aload_1
    //   636: ifnull +7 -> 643
    //   639: aload_1
    //   640: invokevirtual 234	java/io/InputStream:close	()V
    //   643: aload 7
    //   645: invokeinterface 240 1 0
    //   650: invokeinterface 246 1 0
    //   655: astore_1
    //   656: aload_1
    //   657: invokeinterface 251 1 0
    //   662: ifeq +40 -> 702
    //   665: aload_1
    //   666: invokeinterface 255 1 0
    //   671: checkcast 257	java/io/BufferedWriter
    //   674: astore 4
    //   676: aload 4
    //   678: ifnull -22 -> 656
    //   681: aload 4
    //   683: invokevirtual 258	java/io/BufferedWriter:close	()V
    //   686: goto -30 -> 656
    //   689: astore_1
    //   690: ldc 170
    //   692: aload_1
    //   693: ldc 225
    //   695: iconst_0
    //   696: anewarray 4	java/lang/Object
    //   699: invokestatic 229	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   702: ldc 159
    //   704: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   707: iconst_1
    //   708: ireturn
    //   709: astore 4
    //   711: aconst_null
    //   712: astore_1
    //   713: goto -295 -> 418
    //   716: astore 4
    //   718: goto -300 -> 418
    //   721: astore 4
    //   723: aconst_null
    //   724: astore_1
    //   725: goto -569 -> 156
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	728	0	this	t
    //   0	728	1	paramString	String
    //   580	30	2	i	int
    //   578	6	3	j	int
    //   1	1	4	localObject1	Object
    //   154	5	4	localException1	java.lang.Exception
    //   208	145	4	localObject2	Object
    //   416	139	4	str	String
    //   573	109	4	localObject3	Object
    //   709	1	4	localObject4	Object
    //   716	1	4	localObject5	Object
    //   721	1	4	localException2	java.lang.Exception
    //   90	509	5	localObject6	Object
    //   257	278	6	localObject7	Object
    //   54	590	7	localHashMap	HashMap
    //   16	614	8	locale	com.tencent.mm.vfs.e
    //   72	553	9	localInputStreamReader	java.io.InputStreamReader
    //   83	537	10	localBufferedReader	java.io.BufferedReader
    //   107	281	11	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   62	85	154	java/lang/Exception
    //   85	92	154	java/lang/Exception
    //   97	136	154	java/lang/Exception
    //   136	151	154	java/lang/Exception
    //   243	259	154	java/lang/Exception
    //   268	281	154	java/lang/Exception
    //   285	318	154	java/lang/Exception
    //   318	350	154	java/lang/Exception
    //   358	413	154	java/lang/Exception
    //   493	507	154	java/lang/Exception
    //   507	529	154	java/lang/Exception
    //   534	539	154	java/lang/Exception
    //   542	579	154	java/lang/Exception
    //   592	606	154	java/lang/Exception
    //   613	619	154	java/lang/Exception
    //   619	635	154	java/lang/Exception
    //   173	177	223	java/io/IOException
    //   177	190	223	java/io/IOException
    //   190	210	223	java/io/IOException
    //   215	220	223	java/io/IOException
    //   62	85	416	finally
    //   85	92	416	finally
    //   97	136	416	finally
    //   136	151	416	finally
    //   243	259	416	finally
    //   268	281	416	finally
    //   285	318	416	finally
    //   318	350	416	finally
    //   358	413	416	finally
    //   493	507	416	finally
    //   507	529	416	finally
    //   534	539	416	finally
    //   542	579	416	finally
    //   592	606	416	finally
    //   613	619	416	finally
    //   619	635	416	finally
    //   422	426	472	java/io/IOException
    //   426	439	472	java/io/IOException
    //   439	459	472	java/io/IOException
    //   464	469	472	java/io/IOException
    //   639	643	689	java/io/IOException
    //   643	656	689	java/io/IOException
    //   656	676	689	java/io/IOException
    //   681	686	689	java/io/IOException
    //   56	62	709	finally
    //   156	169	716	finally
    //   56	62	721	java/lang/Exception
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(150866);
    com.tencent.mm.sdk.b.a.ESL.c(this.hpI);
    com.tencent.mm.sdk.b.a.ESL.c(this.hpJ);
    com.tencent.mm.sdk.b.a.ESL.c(this.hpK);
    com.tencent.mm.sdk.b.a.ESL.c(this.hpM);
    if (this.hpL != null) {
      this.hpL.hpB.clear();
    }
    for (;;)
    {
      com.tencent.mm.sdk.b.a.ESL.c(this.hpL.hpC);
      com.tencent.mm.sdk.b.a.ESL.c(this.hpL.hpD);
      AppMethodBeat.o(150866);
      return;
      this.hpL = new n();
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(150865);
    com.tencent.mm.sdk.b.a.ESL.d(this.hpI);
    com.tencent.mm.sdk.b.a.ESL.d(this.hpJ);
    com.tencent.mm.sdk.b.a.ESL.d(this.hpK);
    com.tencent.mm.sdk.b.a.ESL.d(this.hpL.hpC);
    com.tencent.mm.sdk.b.a.ESL.d(this.hpL.hpD);
    com.tencent.mm.sdk.b.a.ESL.d(this.hpM);
    AppMethodBeat.o(150865);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bc.t
 * JD-Core Version:    0.7.0.1
 */