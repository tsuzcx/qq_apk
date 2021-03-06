package com.tencent.mm.modelpackage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.be;
import com.tencent.mm.model.y;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.w;
import java.util.HashMap;
import java.util.Map;

public class u
  implements be
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private t oRe;
  private b oRf;
  private PostTaskChatBgStatListener oRg;
  private PostTaskReportEggListener oRh;
  private PostTaskUpdateConfigListListener oRi;
  private r oRj;
  IListener oRk;
  
  static
  {
    AppMethodBeat.i(150869);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("PACKAGE_INFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return t.SQL_CREATE;
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
  
  public u()
  {
    AppMethodBeat.i(150861);
    this.oRg = new PostTaskChatBgStatListener();
    this.oRh = new PostTaskReportEggListener();
    this.oRi = new PostTaskUpdateConfigListListener();
    this.oRj = null;
    this.oRk = new SubCorePackage.3(this, com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(150861);
  }
  
  /* Error */
  private boolean ON(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc 110
    //   5: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 112	com/tencent/mm/vfs/u
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 115	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   16: astore 8
    //   18: aload 8
    //   20: invokevirtual 119	com/tencent/mm/vfs/u:jKS	()Z
    //   23: ifne +24 -> 47
    //   26: ldc 121
    //   28: ldc 123
    //   30: aload_1
    //   31: invokestatic 126	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   34: invokevirtual 130	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   37: invokestatic 136	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: ldc 110
    //   42: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: iconst_0
    //   46: ireturn
    //   47: new 42	java/util/HashMap
    //   50: dup
    //   51: invokespecial 45	java/util/HashMap:<init>	()V
    //   54: astore 7
    //   56: aload 8
    //   58: invokestatic 142	com/tencent/mm/vfs/y:ao	(Lcom/tencent/mm/vfs/u;)Ljava/io/InputStream;
    //   61: astore_1
    //   62: new 144	java/io/InputStreamReader
    //   65: dup
    //   66: aload_1
    //   67: ldc 146
    //   69: invokespecial 149	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   72: astore 9
    //   74: new 151	java/io/BufferedReader
    //   77: dup
    //   78: aload 9
    //   80: invokespecial 154	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   83: astore 10
    //   85: aload 10
    //   87: invokevirtual 158	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   90: astore 5
    //   92: aload 5
    //   94: ifnull +399 -> 493
    //   97: aload 5
    //   99: invokevirtual 161	java/lang/String:trim	()Ljava/lang/String;
    //   102: ldc 163
    //   104: invokevirtual 167	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   107: astore 11
    //   109: aload 11
    //   111: arraylength
    //   112: iconst_2
    //   113: if_icmplt +23 -> 136
    //   116: aload 11
    //   118: iconst_0
    //   119: aaload
    //   120: invokestatic 172	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   123: ifne +13 -> 136
    //   126: aload 11
    //   128: iconst_1
    //   129: aaload
    //   130: invokestatic 172	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   133: ifeq +110 -> 243
    //   136: ldc 121
    //   138: ldc 174
    //   140: aload 5
    //   142: invokestatic 126	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   145: invokevirtual 130	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   148: invokestatic 136	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: goto -66 -> 85
    //   154: astore 4
    //   156: ldc 121
    //   158: aload 4
    //   160: ldc 176
    //   162: iconst_0
    //   163: anewarray 4	java/lang/Object
    //   166: invokestatic 180	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   169: aload_1
    //   170: ifnull +7 -> 177
    //   173: aload_1
    //   174: invokevirtual 185	java/io/InputStream:close	()V
    //   177: aload 7
    //   179: invokeinterface 191 1 0
    //   184: invokeinterface 197 1 0
    //   189: astore_1
    //   190: aload_1
    //   191: invokeinterface 202 1 0
    //   196: ifeq +40 -> 236
    //   199: aload_1
    //   200: invokeinterface 206 1 0
    //   205: checkcast 208	java/io/BufferedWriter
    //   208: astore 4
    //   210: aload 4
    //   212: ifnull -22 -> 190
    //   215: aload 4
    //   217: invokevirtual 209	java/io/BufferedWriter:close	()V
    //   220: goto -30 -> 190
    //   223: astore_1
    //   224: ldc 121
    //   226: aload_1
    //   227: ldc 176
    //   229: iconst_0
    //   230: anewarray 4	java/lang/Object
    //   233: invokestatic 180	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   236: ldc 110
    //   238: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   241: iconst_0
    //   242: ireturn
    //   243: aload 7
    //   245: aload 11
    //   247: iconst_0
    //   248: aaload
    //   249: invokeinterface 213 2 0
    //   254: checkcast 208	java/io/BufferedWriter
    //   257: astore 6
    //   259: aload 6
    //   261: astore 5
    //   263: aload 6
    //   265: ifnonnull +93 -> 358
    //   268: invokestatic 219	com/tencent/mm/storage/RegionCodeDecoder:jcF	()Lcom/tencent/mm/storage/RegionCodeDecoder;
    //   271: pop
    //   272: aload 11
    //   274: iconst_0
    //   275: aaload
    //   276: invokestatic 222	com/tencent/mm/storage/RegionCodeDecoder:byF	(Ljava/lang/String;)Ljava/lang/String;
    //   279: astore 5
    //   281: aload 5
    //   283: astore 4
    //   285: aload 5
    //   287: invokestatic 172	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   290: ifne -205 -> 85
    //   293: new 112	com/tencent/mm/vfs/u
    //   296: dup
    //   297: aload 5
    //   299: invokespecial 115	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   302: astore 4
    //   304: aload 4
    //   306: invokevirtual 119	com/tencent/mm/vfs/u:jKS	()Z
    //   309: ifne +9 -> 318
    //   312: aload 4
    //   314: invokevirtual 225	com/tencent/mm/vfs/u:jKZ	()Z
    //   317: pop
    //   318: new 208	java/io/BufferedWriter
    //   321: dup
    //   322: new 227	com/tencent/mm/vfs/ac
    //   325: dup
    //   326: aload 4
    //   328: invokespecial 230	com/tencent/mm/vfs/ac:<init>	(Lcom/tencent/mm/vfs/u;)V
    //   331: invokespecial 233	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   334: astore 6
    //   336: aload 7
    //   338: aload 11
    //   340: iconst_0
    //   341: aaload
    //   342: aload 6
    //   344: invokeinterface 234 3 0
    //   349: pop
    //   350: aload 5
    //   352: astore 4
    //   354: aload 6
    //   356: astore 5
    //   358: new 236	java/lang/StringBuffer
    //   361: dup
    //   362: invokespecial 237	java/lang/StringBuffer:<init>	()V
    //   365: astore 6
    //   367: aload 6
    //   369: aload 11
    //   371: iconst_1
    //   372: aaload
    //   373: invokevirtual 241	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   376: pop
    //   377: aload 6
    //   379: bipush 124
    //   381: invokevirtual 244	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   384: pop
    //   385: aload 6
    //   387: aload 11
    //   389: iconst_2
    //   390: aaload
    //   391: invokevirtual 241	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   394: pop
    //   395: aload 6
    //   397: bipush 10
    //   399: invokevirtual 244	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   402: pop
    //   403: aload 5
    //   405: aload 6
    //   407: invokevirtual 247	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   410: invokevirtual 250	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   413: goto -328 -> 85
    //   416: astore 4
    //   418: aload_1
    //   419: ifnull +7 -> 426
    //   422: aload_1
    //   423: invokevirtual 185	java/io/InputStream:close	()V
    //   426: aload 7
    //   428: invokeinterface 191 1 0
    //   433: invokeinterface 197 1 0
    //   438: astore_1
    //   439: aload_1
    //   440: invokeinterface 202 1 0
    //   445: ifeq +40 -> 485
    //   448: aload_1
    //   449: invokeinterface 206 1 0
    //   454: checkcast 208	java/io/BufferedWriter
    //   457: astore 5
    //   459: aload 5
    //   461: ifnull -22 -> 439
    //   464: aload 5
    //   466: invokevirtual 209	java/io/BufferedWriter:close	()V
    //   469: goto -30 -> 439
    //   472: astore_1
    //   473: ldc 121
    //   475: aload_1
    //   476: ldc 176
    //   478: iconst_0
    //   479: anewarray 4	java/lang/Object
    //   482: invokestatic 180	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   485: ldc 110
    //   487: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   490: aload 4
    //   492: athrow
    //   493: aload 7
    //   495: invokeinterface 191 1 0
    //   500: invokeinterface 197 1 0
    //   505: astore 5
    //   507: aload 5
    //   509: invokeinterface 202 1 0
    //   514: ifeq +28 -> 542
    //   517: aload 5
    //   519: invokeinterface 206 1 0
    //   524: checkcast 208	java/io/BufferedWriter
    //   527: astore 6
    //   529: aload 6
    //   531: ifnull -24 -> 507
    //   534: aload 6
    //   536: invokevirtual 253	java/io/BufferedWriter:flush	()V
    //   539: goto -32 -> 507
    //   542: aload 4
    //   544: invokestatic 172	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   547: ifne +72 -> 619
    //   550: new 112	com/tencent/mm/vfs/u
    //   553: dup
    //   554: aload 4
    //   556: invokespecial 115	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   559: invokevirtual 257	com/tencent/mm/vfs/u:jKP	()Lcom/tencent/mm/vfs/u;
    //   562: new 14	com/tencent/mm/modelpackage/u$3
    //   565: dup
    //   566: aload_0
    //   567: invokespecial 260	com/tencent/mm/modelpackage/u$3:<init>	(Lcom/tencent/mm/modelpackage/u;)V
    //   570: invokevirtual 264	com/tencent/mm/vfs/u:a	(Lcom/tencent/mm/vfs/w;)[Lcom/tencent/mm/vfs/u;
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
    //   592: invokestatic 219	com/tencent/mm/storage/RegionCodeDecoder:jcF	()Lcom/tencent/mm/storage/RegionCodeDecoder;
    //   595: pop
    //   596: aload 5
    //   598: aload 5
    //   600: invokevirtual 257	com/tencent/mm/vfs/u:jKP	()Lcom/tencent/mm/vfs/u;
    //   603: invokestatic 268	com/tencent/mm/storage/RegionCodeDecoder:h	(Lcom/tencent/mm/vfs/u;Lcom/tencent/mm/vfs/u;)V
    //   606: iload_2
    //   607: iconst_1
    //   608: iadd
    //   609: istore_2
    //   610: goto -29 -> 581
    //   613: invokestatic 219	com/tencent/mm/storage/RegionCodeDecoder:jcF	()Lcom/tencent/mm/storage/RegionCodeDecoder;
    //   616: invokevirtual 271	com/tencent/mm/storage/RegionCodeDecoder:iZh	()V
    //   619: aload 10
    //   621: invokevirtual 272	java/io/BufferedReader:close	()V
    //   624: aload 9
    //   626: invokevirtual 273	java/io/InputStreamReader:close	()V
    //   629: aload 8
    //   631: invokevirtual 276	com/tencent/mm/vfs/u:diJ	()Z
    //   634: pop
    //   635: aload_1
    //   636: ifnull +7 -> 643
    //   639: aload_1
    //   640: invokevirtual 185	java/io/InputStream:close	()V
    //   643: aload 7
    //   645: invokeinterface 191 1 0
    //   650: invokeinterface 197 1 0
    //   655: astore_1
    //   656: aload_1
    //   657: invokeinterface 202 1 0
    //   662: ifeq +40 -> 702
    //   665: aload_1
    //   666: invokeinterface 206 1 0
    //   671: checkcast 208	java/io/BufferedWriter
    //   674: astore 4
    //   676: aload 4
    //   678: ifnull -22 -> 656
    //   681: aload 4
    //   683: invokevirtual 209	java/io/BufferedWriter:close	()V
    //   686: goto -30 -> 656
    //   689: astore_1
    //   690: ldc 121
    //   692: aload_1
    //   693: ldc 176
    //   695: iconst_0
    //   696: anewarray 4	java/lang/Object
    //   699: invokestatic 180	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   702: ldc 110
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
    //   0	728	0	this	u
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
    //   16	614	8	localu	com.tencent.mm.vfs.u
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
  
  private static u bLG()
  {
    AppMethodBeat.i(150862);
    u localu = (u)y.aL(u.class);
    AppMethodBeat.o(150862);
    return localu;
  }
  
  public static t bLH()
  {
    AppMethodBeat.i(150863);
    h.baC().aZJ();
    if (bLG().oRe == null) {
      bLG().oRe = new t(h.baE().mCN);
    }
    t localt = bLG().oRe;
    AppMethodBeat.o(150863);
    return localt;
  }
  
  public static b bLI()
  {
    AppMethodBeat.i(150864);
    h.baC().aZJ();
    if (bLG().oRf == null) {
      bLG().oRf = new b(h.baE().mCN);
    }
    b localb = bLG().oRf;
    AppMethodBeat.o(150864);
    return localb;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(150866);
    this.oRg.alive();
    this.oRh.alive();
    this.oRi.alive();
    this.oRk.alive();
    if (this.oRj != null) {
      this.oRj.oQZ.clear();
    }
    for (;;)
    {
      this.oRj.oRa.alive();
      this.oRj.oRb.alive();
      AppMethodBeat.o(150866);
      return;
      this.oRj = new r();
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(150865);
    this.oRg.dead();
    this.oRh.dead();
    this.oRi.dead();
    this.oRj.oRa.dead();
    this.oRj.oRb.dead();
    this.oRk.dead();
    AppMethodBeat.o(150865);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelpackage.u
 * JD-Core Version:    0.7.0.1
 */