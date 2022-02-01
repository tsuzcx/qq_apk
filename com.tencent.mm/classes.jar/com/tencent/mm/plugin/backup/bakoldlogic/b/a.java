package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public final class a
  extends com.tencent.mm.plugin.backup.b.a
{
  private static String END = "img";
  private static String nCT = "icon_";
  private static String nCU = "iphone";
  private static String nCV = "android";
  private static String nCW = "s60v3";
  private static String nCX = "s60v5";
  private static a nGf;
  private Map<String, a> nCZ;
  
  public a()
  {
    AppMethodBeat.i(21822);
    this.nCZ = null;
    bJf();
    AppMethodBeat.o(21822);
  }
  
  public static a WT(String paramString)
  {
    AppMethodBeat.i(21820);
    if (nGf == null) {
      nGf = new a();
    }
    Object localObject = nGf;
    if (((a)localObject).nCZ == null) {
      ((a)localObject).bJf();
    }
    localObject = ((a)localObject).nCZ.values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      if ((locala.nDb != null) && (locala.nDb.equals(paramString)))
      {
        AppMethodBeat.o(21820);
        return locala;
      }
    }
    AppMethodBeat.o(21820);
    return null;
  }
  
  public static a WU(String paramString)
  {
    AppMethodBeat.i(21821);
    if (nGf == null)
    {
      locala = new a();
      nGf = locala;
      a(locala);
    }
    a locala = nGf;
    if (locala.nCZ == null) {
      locala.bJf();
    }
    paramString = (a)locala.nCZ.get(paramString);
    AppMethodBeat.o(21821);
    return paramString;
  }
  
  /* Error */
  private void bJf()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iconst_0
    //   3: istore_1
    //   4: sipush 21823
    //   7: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: new 113	java/util/HashMap
    //   14: dup
    //   15: invokespecial 114	java/util/HashMap:<init>	()V
    //   18: putfield 57	com/tencent/mm/plugin/backup/bakoldlogic/b/a:nCZ	Ljava/util/Map;
    //   21: invokestatic 120	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   24: invokevirtual 126	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   27: astore_3
    //   28: aload_3
    //   29: ldc 128
    //   31: invokevirtual 134	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   34: astore_3
    //   35: new 136	java/io/BufferedReader
    //   38: dup
    //   39: new 138	java/io/InputStreamReader
    //   42: dup
    //   43: aload_3
    //   44: ldc 140
    //   46: invokespecial 143	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   49: invokespecial 146	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   52: astore 4
    //   54: aload 4
    //   56: astore 5
    //   58: aload_3
    //   59: astore 6
    //   61: aload 4
    //   63: invokevirtual 150	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   66: astore 7
    //   68: aload 7
    //   70: ifnull +418 -> 488
    //   73: aload 4
    //   75: astore 5
    //   77: aload_3
    //   78: astore 6
    //   80: aload 7
    //   82: getstatic 25	com/tencent/mm/plugin/backup/bakoldlogic/b/a:nCT	Ljava/lang/String;
    //   85: invokevirtual 154	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   88: ifeq -34 -> 54
    //   91: aload 4
    //   93: astore 5
    //   95: aload_3
    //   96: astore 6
    //   98: new 6	com/tencent/mm/plugin/backup/bakoldlogic/b/a$a
    //   101: dup
    //   102: invokespecial 155	com/tencent/mm/plugin/backup/bakoldlogic/b/a$a:<init>	()V
    //   105: astore 7
    //   107: aload 4
    //   109: astore 5
    //   111: aload_3
    //   112: astore 6
    //   114: aload 4
    //   116: invokevirtual 150	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   119: astore 8
    //   121: aload 8
    //   123: ifnull +332 -> 455
    //   126: aload 4
    //   128: astore 5
    //   130: aload_3
    //   131: astore 6
    //   133: aload 8
    //   135: getstatic 29	com/tencent/mm/plugin/backup/bakoldlogic/b/a:END	Ljava/lang/String;
    //   138: invokevirtual 154	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   141: ifne +314 -> 455
    //   144: aload 4
    //   146: astore 5
    //   148: aload_3
    //   149: astore 6
    //   151: aload 8
    //   153: ldc 157
    //   155: invokevirtual 161	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   158: istore_2
    //   159: aload 4
    //   161: astore 5
    //   163: aload_3
    //   164: astore 6
    //   166: iload_2
    //   167: iconst_1
    //   168: iadd
    //   169: aload 8
    //   171: invokevirtual 165	java/lang/String:length	()I
    //   174: if_icmpge +281 -> 455
    //   177: aload 4
    //   179: astore 5
    //   181: aload_3
    //   182: astore 6
    //   184: aload 8
    //   186: iload_2
    //   187: iconst_1
    //   188: iadd
    //   189: invokevirtual 169	java/lang/String:substring	(I)Ljava/lang/String;
    //   192: astore 9
    //   194: aload 4
    //   196: astore 5
    //   198: aload_3
    //   199: astore 6
    //   201: aload 8
    //   203: getstatic 33	com/tencent/mm/plugin/backup/bakoldlogic/b/a:nCU	Ljava/lang/String;
    //   206: invokevirtual 173	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   209: ifeq +109 -> 318
    //   212: aload 4
    //   214: astore 5
    //   216: aload_3
    //   217: astore 6
    //   219: aload 7
    //   221: aload 9
    //   223: putfield 93	com/tencent/mm/plugin/backup/bakoldlogic/b/a$a:nDb	Ljava/lang/String;
    //   226: aload 4
    //   228: astore 5
    //   230: aload_3
    //   231: astore 6
    //   233: aload_0
    //   234: getfield 57	com/tencent/mm/plugin/backup/bakoldlogic/b/a:nCZ	Ljava/util/Map;
    //   237: aload 7
    //   239: getfield 176	com/tencent/mm/plugin/backup/bakoldlogic/b/a$a:nDa	Ljava/lang/String;
    //   242: aload 7
    //   244: invokeinterface 180 3 0
    //   249: pop
    //   250: goto -143 -> 107
    //   253: astore 7
    //   255: aload 4
    //   257: astore 5
    //   259: aload_3
    //   260: astore 6
    //   262: ldc 182
    //   264: aload 7
    //   266: ldc 184
    //   268: iconst_0
    //   269: anewarray 186	java/lang/Object
    //   272: invokestatic 192	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   275: aload 4
    //   277: ifnull +8 -> 285
    //   280: aload 4
    //   282: invokevirtual 195	java/io/BufferedReader:close	()V
    //   285: iload_1
    //   286: istore_2
    //   287: aload_3
    //   288: ifnull +9 -> 297
    //   291: aload_3
    //   292: invokevirtual 198	java/io/InputStream:close	()V
    //   295: iload_1
    //   296: istore_2
    //   297: ldc 182
    //   299: ldc 200
    //   301: iload_2
    //   302: invokestatic 203	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   305: invokevirtual 207	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   308: invokestatic 211	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   311: sipush 21823
    //   314: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   317: return
    //   318: aload 4
    //   320: astore 5
    //   322: aload_3
    //   323: astore 6
    //   325: aload 8
    //   327: getstatic 37	com/tencent/mm/plugin/backup/bakoldlogic/b/a:nCV	Ljava/lang/String;
    //   330: invokevirtual 173	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   333: ifeq +52 -> 385
    //   336: aload 4
    //   338: astore 5
    //   340: aload_3
    //   341: astore 6
    //   343: aload 7
    //   345: aload 9
    //   347: putfield 176	com/tencent/mm/plugin/backup/bakoldlogic/b/a$a:nDa	Ljava/lang/String;
    //   350: goto -124 -> 226
    //   353: astore 4
    //   355: aload 6
    //   357: astore_3
    //   358: aload 5
    //   360: ifnull +8 -> 368
    //   363: aload 5
    //   365: invokevirtual 195	java/io/BufferedReader:close	()V
    //   368: aload_3
    //   369: ifnull +7 -> 376
    //   372: aload_3
    //   373: invokevirtual 198	java/io/InputStream:close	()V
    //   376: sipush 21823
    //   379: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   382: aload 4
    //   384: athrow
    //   385: aload 4
    //   387: astore 5
    //   389: aload_3
    //   390: astore 6
    //   392: aload 8
    //   394: getstatic 41	com/tencent/mm/plugin/backup/bakoldlogic/b/a:nCW	Ljava/lang/String;
    //   397: invokevirtual 173	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   400: ifeq +20 -> 420
    //   403: aload 4
    //   405: astore 5
    //   407: aload_3
    //   408: astore 6
    //   410: aload 7
    //   412: aload 9
    //   414: putfield 214	com/tencent/mm/plugin/backup/bakoldlogic/b/a$a:nDc	Ljava/lang/String;
    //   417: goto -191 -> 226
    //   420: aload 4
    //   422: astore 5
    //   424: aload_3
    //   425: astore 6
    //   427: aload 8
    //   429: getstatic 45	com/tencent/mm/plugin/backup/bakoldlogic/b/a:nCX	Ljava/lang/String;
    //   432: invokevirtual 173	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   435: ifeq -209 -> 226
    //   438: aload 4
    //   440: astore 5
    //   442: aload_3
    //   443: astore 6
    //   445: aload 7
    //   447: aload 9
    //   449: putfield 217	com/tencent/mm/plugin/backup/bakoldlogic/b/a$a:nDd	Ljava/lang/String;
    //   452: goto -226 -> 226
    //   455: aload 4
    //   457: astore 5
    //   459: aload_3
    //   460: astore 6
    //   462: ldc 182
    //   464: ldc 219
    //   466: iconst_1
    //   467: anewarray 186	java/lang/Object
    //   470: dup
    //   471: iconst_0
    //   472: aload 7
    //   474: invokevirtual 222	com/tencent/mm/plugin/backup/bakoldlogic/b/a$a:toString	()Ljava/lang/String;
    //   477: aastore
    //   478: invokestatic 225	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   481: iload_1
    //   482: iconst_1
    //   483: iadd
    //   484: istore_1
    //   485: goto -431 -> 54
    //   488: aload 4
    //   490: invokevirtual 195	java/io/BufferedReader:close	()V
    //   493: iload_1
    //   494: istore_2
    //   495: aload_3
    //   496: ifnull -199 -> 297
    //   499: aload_3
    //   500: invokevirtual 198	java/io/InputStream:close	()V
    //   503: iload_1
    //   504: istore_2
    //   505: goto -208 -> 297
    //   508: astore_3
    //   509: iload_1
    //   510: istore_2
    //   511: goto -214 -> 297
    //   514: astore_3
    //   515: goto -139 -> 376
    //   518: astore 4
    //   520: aconst_null
    //   521: astore 5
    //   523: aconst_null
    //   524: astore_3
    //   525: goto -167 -> 358
    //   528: astore 4
    //   530: aconst_null
    //   531: astore 5
    //   533: goto -175 -> 358
    //   536: astore_3
    //   537: iload_1
    //   538: istore_2
    //   539: goto -242 -> 297
    //   542: astore 7
    //   544: aconst_null
    //   545: astore 4
    //   547: aconst_null
    //   548: astore_3
    //   549: iload_2
    //   550: istore_1
    //   551: goto -296 -> 255
    //   554: astore 7
    //   556: aconst_null
    //   557: astore 4
    //   559: iload_2
    //   560: istore_1
    //   561: goto -306 -> 255
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	564	0	this	a
    //   3	558	1	i	int
    //   1	559	2	j	int
    //   27	473	3	localObject1	Object
    //   508	1	3	localException1	java.lang.Exception
    //   514	1	3	localException2	java.lang.Exception
    //   524	1	3	localObject2	Object
    //   536	1	3	localException3	java.lang.Exception
    //   548	1	3	localObject3	Object
    //   52	285	4	localBufferedReader	java.io.BufferedReader
    //   353	136	4	localObject4	Object
    //   518	1	4	localObject5	Object
    //   528	1	4	localObject6	Object
    //   545	13	4	localObject7	Object
    //   56	476	5	localObject8	Object
    //   59	402	6	localObject9	Object
    //   66	177	7	localObject10	Object
    //   253	220	7	localIOException1	java.io.IOException
    //   542	1	7	localIOException2	java.io.IOException
    //   554	1	7	localIOException3	java.io.IOException
    //   119	309	8	str1	String
    //   192	256	9	str2	String
    // Exception table:
    //   from	to	target	type
    //   61	68	253	java/io/IOException
    //   80	91	253	java/io/IOException
    //   98	107	253	java/io/IOException
    //   114	121	253	java/io/IOException
    //   133	144	253	java/io/IOException
    //   151	159	253	java/io/IOException
    //   166	177	253	java/io/IOException
    //   184	194	253	java/io/IOException
    //   201	212	253	java/io/IOException
    //   219	226	253	java/io/IOException
    //   233	250	253	java/io/IOException
    //   325	336	253	java/io/IOException
    //   343	350	253	java/io/IOException
    //   392	403	253	java/io/IOException
    //   410	417	253	java/io/IOException
    //   427	438	253	java/io/IOException
    //   445	452	253	java/io/IOException
    //   462	481	253	java/io/IOException
    //   61	68	353	finally
    //   80	91	353	finally
    //   98	107	353	finally
    //   114	121	353	finally
    //   133	144	353	finally
    //   151	159	353	finally
    //   166	177	353	finally
    //   184	194	353	finally
    //   201	212	353	finally
    //   219	226	353	finally
    //   233	250	353	finally
    //   262	275	353	finally
    //   325	336	353	finally
    //   343	350	353	finally
    //   392	403	353	finally
    //   410	417	353	finally
    //   427	438	353	finally
    //   445	452	353	finally
    //   462	481	353	finally
    //   488	493	508	java/lang/Exception
    //   499	503	508	java/lang/Exception
    //   363	368	514	java/lang/Exception
    //   372	376	514	java/lang/Exception
    //   28	35	518	finally
    //   35	54	528	finally
    //   280	285	536	java/lang/Exception
    //   291	295	536	java/lang/Exception
    //   28	35	542	java/io/IOException
    //   35	54	554	java/io/IOException
  }
  
  public final void bHQ()
  {
    nGf = null;
  }
  
  public static final class a
  {
    public String nDa = "";
    public String nDb = "";
    public String nDc = "";
    public String nDd = "";
    
    public a() {}
    
    public a(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      this.nDa = paramString1;
      this.nDb = paramString2;
      this.nDc = paramString3;
      this.nDd = paramString4;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(21819);
      String str = this.nDa + " " + this.nDb + " " + this.nDc + " " + this.nDd;
      AppMethodBeat.o(21819);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.a
 * JD-Core Version:    0.7.0.1
 */