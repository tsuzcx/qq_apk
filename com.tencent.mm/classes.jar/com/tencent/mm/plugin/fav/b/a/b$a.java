package com.tencent.mm.plugin.fav.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.a;
import java.util.HashSet;

final class b$a
  extends a
{
  private int mFailedCount = 0;
  private HashSet<Long> muM = null;
  private int muN = 0;
  private int muO = 0;
  private int muP = 0;
  
  private b$a(b paramb) {}
  
  public final String aAn()
  {
    AppMethodBeat.i(5303);
    String str = String.format("{new: %d exist: %d removed: %d failed: %d}", new Object[] { Integer.valueOf(this.muO), Integer.valueOf(this.muN), Integer.valueOf(this.muP), Integer.valueOf(this.mFailedCount) });
    AppMethodBeat.o(5303);
    return str;
  }
  
  /* Error */
  public final boolean execute()
  {
    // Byte code:
    //   0: sipush 5302
    //   3: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 21	com/tencent/mm/plugin/fav/b/a/b$a:muL	Lcom/tencent/mm/plugin/fav/b/a/b;
    //   10: getfield 73	com/tencent/mm/plugin/fav/b/a/b:muJ	Lcom/tencent/mm/sdk/e/e;
    //   13: ifnonnull +18 -> 31
    //   16: ldc 75
    //   18: ldc 77
    //   20: invokestatic 83	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: sipush 5302
    //   26: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: iconst_1
    //   30: ireturn
    //   31: ldc 75
    //   33: ldc 85
    //   35: invokestatic 87	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   38: aload_0
    //   39: getfield 26	com/tencent/mm/plugin/fav/b/a/b$a:muM	Ljava/util/HashSet;
    //   42: ifnonnull +153 -> 195
    //   45: aload_0
    //   46: new 89	java/util/HashSet
    //   49: dup
    //   50: invokespecial 90	java/util/HashSet:<init>	()V
    //   53: putfield 26	com/tencent/mm/plugin/fav/b/a/b$a:muM	Ljava/util/HashSet;
    //   56: aload_0
    //   57: getfield 21	com/tencent/mm/plugin/fav/b/a/b$a:muL	Lcom/tencent/mm/plugin/fav/b/a/b;
    //   60: getfield 94	com/tencent/mm/plugin/fav/b/a/b:muI	Lcom/tencent/mm/plugin/fav/b/a/a;
    //   63: getstatic 100	com/tencent/mm/plugin/fts/a/c:mQB	[I
    //   66: iconst_0
    //   67: iconst_1
    //   68: iconst_0
    //   69: iconst_0
    //   70: iconst_0
    //   71: invokevirtual 105	com/tencent/mm/plugin/fav/b/a/a:a	([IZZZZZ)Landroid/database/Cursor;
    //   74: astore 6
    //   76: aload 6
    //   78: astore 5
    //   80: aload 6
    //   82: invokeinterface 110 1 0
    //   87: ifeq +85 -> 172
    //   90: aload 6
    //   92: astore 5
    //   94: aload 6
    //   96: iconst_0
    //   97: invokeinterface 114 2 0
    //   102: lstore_3
    //   103: aload 6
    //   105: astore 5
    //   107: aload_0
    //   108: getfield 26	com/tencent/mm/plugin/fav/b/a/b$a:muM	Ljava/util/HashSet;
    //   111: lload_3
    //   112: invokestatic 119	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   115: invokevirtual 123	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   118: pop
    //   119: goto -43 -> 76
    //   122: astore 7
    //   124: aload 6
    //   126: astore 5
    //   128: sipush 5302
    //   131: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   134: aload 6
    //   136: astore 5
    //   138: aload 7
    //   140: athrow
    //   141: astore 7
    //   143: aload 5
    //   145: astore 6
    //   147: aload 7
    //   149: astore 5
    //   151: aload 6
    //   153: ifnull +10 -> 163
    //   156: aload 6
    //   158: invokeinterface 126 1 0
    //   163: sipush 5302
    //   166: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   169: aload 5
    //   171: athrow
    //   172: aload 6
    //   174: ifnull +10 -> 184
    //   177: aload 6
    //   179: invokeinterface 126 1 0
    //   184: aload_0
    //   185: aload_0
    //   186: getfield 26	com/tencent/mm/plugin/fav/b/a/b$a:muM	Ljava/util/HashSet;
    //   189: invokevirtual 130	java/util/HashSet:size	()I
    //   192: putfield 28	com/tencent/mm/plugin/fav/b/a/b$a:muN	I
    //   195: invokestatic 135	java/lang/Thread:interrupted	()Z
    //   198: ifeq +21 -> 219
    //   201: new 137	java/lang/InterruptedException
    //   204: dup
    //   205: invokespecial 138	java/lang/InterruptedException:<init>	()V
    //   208: astore 5
    //   210: sipush 5302
    //   213: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   216: aload 5
    //   218: athrow
    //   219: aload_0
    //   220: getfield 21	com/tencent/mm/plugin/fav/b/a/b$a:muL	Lcom/tencent/mm/plugin/fav/b/a/b;
    //   223: getfield 73	com/tencent/mm/plugin/fav/b/a/b:muJ	Lcom/tencent/mm/sdk/e/e;
    //   226: ldc 140
    //   228: aconst_null
    //   229: invokeinterface 146 3 0
    //   234: astore 5
    //   236: bipush 50
    //   238: istore_1
    //   239: aload 5
    //   241: invokeinterface 110 1 0
    //   246: ifeq +197 -> 443
    //   249: invokestatic 135	java/lang/Thread:interrupted	()Z
    //   252: ifeq +65 -> 317
    //   255: aload_0
    //   256: getfield 21	com/tencent/mm/plugin/fav/b/a/b$a:muL	Lcom/tencent/mm/plugin/fav/b/a/b;
    //   259: getfield 94	com/tencent/mm/plugin/fav/b/a/b:muI	Lcom/tencent/mm/plugin/fav/b/a/a;
    //   262: invokevirtual 149	com/tencent/mm/plugin/fav/b/a/a:commit	()V
    //   265: new 137	java/lang/InterruptedException
    //   268: dup
    //   269: invokespecial 138	java/lang/InterruptedException:<init>	()V
    //   272: astore 6
    //   274: sipush 5302
    //   277: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   280: aload 6
    //   282: athrow
    //   283: astore 6
    //   285: sipush 5302
    //   288: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   291: aload 6
    //   293: athrow
    //   294: astore 6
    //   296: aload 5
    //   298: ifnull +10 -> 308
    //   301: aload 5
    //   303: invokeinterface 126 1 0
    //   308: sipush 5302
    //   311: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   314: aload 6
    //   316: athrow
    //   317: new 151	com/tencent/mm/plugin/fav/b/a/b$c
    //   320: dup
    //   321: aload_0
    //   322: getfield 21	com/tencent/mm/plugin/fav/b/a/b$a:muL	Lcom/tencent/mm/plugin/fav/b/a/b;
    //   325: iconst_0
    //   326: invokespecial 153	com/tencent/mm/plugin/fav/b/a/b$c:<init>	(Lcom/tencent/mm/plugin/fav/b/a/b;B)V
    //   329: astore 6
    //   331: aload 6
    //   333: aload 5
    //   335: invokevirtual 157	com/tencent/mm/plugin/fav/b/a/b$c:convertFrom	(Landroid/database/Cursor;)V
    //   338: aload_0
    //   339: getfield 26	com/tencent/mm/plugin/fav/b/a/b$a:muM	Ljava/util/HashSet;
    //   342: aload 6
    //   344: getfield 161	com/tencent/mm/plugin/fav/b/a/b$c:fDL	J
    //   347: invokestatic 119	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   350: invokevirtual 164	java/util/HashSet:remove	(Ljava/lang/Object;)Z
    //   353: ifne -114 -> 239
    //   356: iload_1
    //   357: bipush 50
    //   359: if_icmplt +276 -> 635
    //   362: aload_0
    //   363: getfield 21	com/tencent/mm/plugin/fav/b/a/b$a:muL	Lcom/tencent/mm/plugin/fav/b/a/b;
    //   366: getfield 94	com/tencent/mm/plugin/fav/b/a/b:muI	Lcom/tencent/mm/plugin/fav/b/a/a;
    //   369: invokevirtual 149	com/tencent/mm/plugin/fav/b/a/a:commit	()V
    //   372: aload_0
    //   373: getfield 21	com/tencent/mm/plugin/fav/b/a/b$a:muL	Lcom/tencent/mm/plugin/fav/b/a/b;
    //   376: getfield 94	com/tencent/mm/plugin/fav/b/a/b:muI	Lcom/tencent/mm/plugin/fav/b/a/a;
    //   379: invokevirtual 167	com/tencent/mm/plugin/fav/b/a/a:beginTransaction	()V
    //   382: iconst_0
    //   383: istore_2
    //   384: iload_2
    //   385: istore_1
    //   386: iload_2
    //   387: aload_0
    //   388: getfield 21	com/tencent/mm/plugin/fav/b/a/b$a:muL	Lcom/tencent/mm/plugin/fav/b/a/b;
    //   391: aload 6
    //   393: invokestatic 170	com/tencent/mm/plugin/fav/b/a/b:a	(Lcom/tencent/mm/plugin/fav/b/a/b;Lcom/tencent/mm/plugin/fav/b/a/b$c;)I
    //   396: iadd
    //   397: istore_2
    //   398: iload_2
    //   399: istore_1
    //   400: aload_0
    //   401: aload_0
    //   402: getfield 30	com/tencent/mm/plugin/fav/b/a/b$a:muO	I
    //   405: iconst_1
    //   406: iadd
    //   407: putfield 30	com/tencent/mm/plugin/fav/b/a/b$a:muO	I
    //   410: iload_2
    //   411: istore_1
    //   412: goto -173 -> 239
    //   415: astore 6
    //   417: ldc 75
    //   419: aload 6
    //   421: ldc 172
    //   423: iconst_0
    //   424: anewarray 50	java/lang/Object
    //   427: invokestatic 176	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   430: aload_0
    //   431: aload_0
    //   432: getfield 34	com/tencent/mm/plugin/fav/b/a/b$a:mFailedCount	I
    //   435: iconst_1
    //   436: iadd
    //   437: putfield 34	com/tencent/mm/plugin/fav/b/a/b$a:mFailedCount	I
    //   440: goto -201 -> 239
    //   443: aload 5
    //   445: ifnull +10 -> 455
    //   448: aload 5
    //   450: invokeinterface 126 1 0
    //   455: aload_0
    //   456: getfield 21	com/tencent/mm/plugin/fav/b/a/b$a:muL	Lcom/tencent/mm/plugin/fav/b/a/b;
    //   459: getfield 94	com/tencent/mm/plugin/fav/b/a/b:muI	Lcom/tencent/mm/plugin/fav/b/a/a;
    //   462: invokevirtual 149	com/tencent/mm/plugin/fav/b/a/a:commit	()V
    //   465: aload_0
    //   466: getfield 26	com/tencent/mm/plugin/fav/b/a/b$a:muM	Ljava/util/HashSet;
    //   469: invokevirtual 180	java/util/HashSet:iterator	()Ljava/util/Iterator;
    //   472: astore 5
    //   474: aload 5
    //   476: invokeinterface 185 1 0
    //   481: ifeq +117 -> 598
    //   484: invokestatic 135	java/lang/Thread:interrupted	()Z
    //   487: ifeq +31 -> 518
    //   490: aload_0
    //   491: getfield 21	com/tencent/mm/plugin/fav/b/a/b$a:muL	Lcom/tencent/mm/plugin/fav/b/a/b;
    //   494: getfield 94	com/tencent/mm/plugin/fav/b/a/b:muI	Lcom/tencent/mm/plugin/fav/b/a/a;
    //   497: invokevirtual 149	com/tencent/mm/plugin/fav/b/a/a:commit	()V
    //   500: new 137	java/lang/InterruptedException
    //   503: dup
    //   504: invokespecial 138	java/lang/InterruptedException:<init>	()V
    //   507: astore 5
    //   509: sipush 5302
    //   512: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   515: aload 5
    //   517: athrow
    //   518: iload_1
    //   519: bipush 50
    //   521: if_icmplt +111 -> 632
    //   524: aload_0
    //   525: getfield 21	com/tencent/mm/plugin/fav/b/a/b$a:muL	Lcom/tencent/mm/plugin/fav/b/a/b;
    //   528: getfield 94	com/tencent/mm/plugin/fav/b/a/b:muI	Lcom/tencent/mm/plugin/fav/b/a/a;
    //   531: invokevirtual 149	com/tencent/mm/plugin/fav/b/a/a:commit	()V
    //   534: aload_0
    //   535: getfield 21	com/tencent/mm/plugin/fav/b/a/b$a:muL	Lcom/tencent/mm/plugin/fav/b/a/b;
    //   538: getfield 94	com/tencent/mm/plugin/fav/b/a/b:muI	Lcom/tencent/mm/plugin/fav/b/a/a;
    //   541: invokevirtual 167	com/tencent/mm/plugin/fav/b/a/a:beginTransaction	()V
    //   544: iconst_0
    //   545: istore_1
    //   546: aload 5
    //   548: invokeinterface 189 1 0
    //   553: checkcast 116	java/lang/Long
    //   556: invokevirtual 193	java/lang/Long:longValue	()J
    //   559: lstore_3
    //   560: aload_0
    //   561: getfield 21	com/tencent/mm/plugin/fav/b/a/b$a:muL	Lcom/tencent/mm/plugin/fav/b/a/b;
    //   564: getfield 94	com/tencent/mm/plugin/fav/b/a/b:muI	Lcom/tencent/mm/plugin/fav/b/a/a;
    //   567: getstatic 100	com/tencent/mm/plugin/fts/a/c:mQB	[I
    //   570: lload_3
    //   571: invokevirtual 197	com/tencent/mm/plugin/fav/b/a/a:c	([IJ)V
    //   574: iload_1
    //   575: iconst_1
    //   576: iadd
    //   577: istore_1
    //   578: aload_0
    //   579: aload_0
    //   580: getfield 32	com/tencent/mm/plugin/fav/b/a/b$a:muP	I
    //   583: iconst_1
    //   584: iadd
    //   585: putfield 32	com/tencent/mm/plugin/fav/b/a/b$a:muP	I
    //   588: aload 5
    //   590: invokeinterface 199 1 0
    //   595: goto -121 -> 474
    //   598: aload_0
    //   599: getfield 21	com/tencent/mm/plugin/fav/b/a/b$a:muL	Lcom/tencent/mm/plugin/fav/b/a/b;
    //   602: getfield 94	com/tencent/mm/plugin/fav/b/a/b:muI	Lcom/tencent/mm/plugin/fav/b/a/a;
    //   605: invokevirtual 149	com/tencent/mm/plugin/fav/b/a/a:commit	()V
    //   608: sipush 5302
    //   611: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   614: iconst_1
    //   615: ireturn
    //   616: astore 5
    //   618: aconst_null
    //   619: astore 6
    //   621: goto -470 -> 151
    //   624: astore 7
    //   626: aconst_null
    //   627: astore 6
    //   629: goto -505 -> 124
    //   632: goto -86 -> 546
    //   635: iload_1
    //   636: istore_2
    //   637: goto -253 -> 384
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	640	0	this	a
    //   238	398	1	i	int
    //   383	254	2	j	int
    //   102	469	3	l	long
    //   78	511	5	localObject1	Object
    //   616	1	5	localObject2	Object
    //   74	207	6	localObject3	Object
    //   283	9	6	localException1	java.lang.Exception
    //   294	21	6	localObject4	Object
    //   329	63	6	localc	b.c
    //   415	5	6	localException2	java.lang.Exception
    //   619	9	6	localObject5	Object
    //   122	17	7	localException3	java.lang.Exception
    //   141	7	7	localObject6	Object
    //   624	1	7	localException4	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   80	90	122	java/lang/Exception
    //   94	103	122	java/lang/Exception
    //   107	119	122	java/lang/Exception
    //   80	90	141	finally
    //   94	103	141	finally
    //   107	119	141	finally
    //   128	134	141	finally
    //   138	141	141	finally
    //   239	283	283	java/lang/Exception
    //   317	356	283	java/lang/Exception
    //   362	382	283	java/lang/Exception
    //   417	440	283	java/lang/Exception
    //   239	283	294	finally
    //   285	294	294	finally
    //   317	356	294	finally
    //   362	382	294	finally
    //   386	398	294	finally
    //   400	410	294	finally
    //   417	440	294	finally
    //   386	398	415	java/lang/Exception
    //   400	410	415	java/lang/Exception
    //   56	76	616	finally
    //   56	76	624	java/lang/Exception
  }
  
  public final int getId()
  {
    return 6;
  }
  
  public final String getName()
  {
    return "BuildFavoriteIndexTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.a.b.a
 * JD-Core Version:    0.7.0.1
 */