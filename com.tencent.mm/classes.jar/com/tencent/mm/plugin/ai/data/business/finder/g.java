package com.tencent.mm.plugin.ai.data.business.finder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class g
{
  private static final String[] qme = { "lastfinderreddotshowtype", "lastsessionid", "starttime_to_weekday", "is_newmsgopenwechat", "is_friendstabreddot", "starttime_to_24h", "is_topstoryreddot", "is_snsreddot", "lastfinderreddotctrltype" };
  private String filePath;
  boolean plZ;
  HashMap<String, HashMap<Integer, Long>> qmf;
  
  public g(String paramString)
  {
    AppMethodBeat.i(267470);
    this.qmf = new HashMap();
    this.plZ = true;
    this.filePath = paramString;
    paramString = qme;
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramString[i];
      this.qmf.put(localObject, new HashMap());
      i += 1;
    }
    AppMethodBeat.o(267470);
  }
  
  /* Error */
  public final boolean Ux()
  {
    // Byte code:
    //   0: ldc 74
    //   2: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 51	java/util/HashMap
    //   8: dup
    //   9: invokespecial 52	java/util/HashMap:<init>	()V
    //   12: pop
    //   13: aconst_null
    //   14: astore 6
    //   16: aconst_null
    //   17: astore 8
    //   19: aconst_null
    //   20: astore 5
    //   22: aload_0
    //   23: getfield 58	com/tencent/mm/plugin/ai/data/business/finder/g:filePath	Ljava/lang/String;
    //   26: invokestatic 80	com/tencent/mm/vfs/y:Lh	(Ljava/lang/String;)Ljava/io/InputStream;
    //   29: astore 4
    //   31: aload 4
    //   33: astore 5
    //   35: aload 4
    //   37: astore 6
    //   39: aload 4
    //   41: astore 8
    //   43: new 82	java/io/BufferedReader
    //   46: dup
    //   47: new 84	java/io/InputStreamReader
    //   50: dup
    //   51: aload 4
    //   53: invokespecial 87	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   56: invokespecial 90	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   59: astore 7
    //   61: aload 7
    //   63: astore 6
    //   65: aload 4
    //   67: astore 5
    //   69: aload 7
    //   71: invokevirtual 94	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   74: astore 8
    //   76: aload 8
    //   78: ifnull +247 -> 325
    //   81: aload 7
    //   83: astore 6
    //   85: aload 4
    //   87: astore 5
    //   89: aload 8
    //   91: ldc 96
    //   93: invokevirtual 100	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   96: istore_1
    //   97: iload_1
    //   98: ifle +249 -> 347
    //   101: aload 7
    //   103: astore 6
    //   105: aload 4
    //   107: astore 5
    //   109: aload 8
    //   111: iconst_0
    //   112: iload_1
    //   113: invokevirtual 104	java/lang/String:substring	(II)Ljava/lang/String;
    //   116: astore 9
    //   118: aload 7
    //   120: astore 6
    //   122: aload 4
    //   124: astore 5
    //   126: aload_0
    //   127: getfield 54	com/tencent/mm/plugin/ai/data/business/finder/g:qmf	Ljava/util/HashMap;
    //   130: aload 9
    //   132: invokevirtual 108	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   135: ifeq +212 -> 347
    //   138: aload 7
    //   140: astore 6
    //   142: aload 4
    //   144: astore 5
    //   146: aload 8
    //   148: iload_1
    //   149: iconst_1
    //   150: iadd
    //   151: invokevirtual 111	java/lang/String:substring	(I)Ljava/lang/String;
    //   154: ldc 113
    //   156: invokevirtual 117	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   159: astore 10
    //   161: aload 7
    //   163: astore 6
    //   165: aload 4
    //   167: astore 5
    //   169: aload_0
    //   170: getfield 54	com/tencent/mm/plugin/ai/data/business/finder/g:qmf	Ljava/util/HashMap;
    //   173: aload 9
    //   175: invokevirtual 121	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   178: checkcast 51	java/util/HashMap
    //   181: astore 11
    //   183: aload 7
    //   185: astore 6
    //   187: aload 4
    //   189: astore 5
    //   191: aload 10
    //   193: iconst_0
    //   194: aaload
    //   195: sipush -10000
    //   198: invokestatic 127	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   201: istore_1
    //   202: aload 7
    //   204: astore 6
    //   206: aload 4
    //   208: astore 5
    //   210: aload 10
    //   212: iconst_1
    //   213: aaload
    //   214: ldc2_w 128
    //   217: invokestatic 133	com/tencent/mm/sdk/platformtools/Util:getLong	(Ljava/lang/String;J)J
    //   220: lstore_2
    //   221: iload_1
    //   222: sipush -10000
    //   225: if_icmpeq +33 -> 258
    //   228: lload_2
    //   229: ldc2_w 128
    //   232: lcmp
    //   233: ifeq +25 -> 258
    //   236: aload 7
    //   238: astore 6
    //   240: aload 4
    //   242: astore 5
    //   244: aload 11
    //   246: iload_1
    //   247: invokestatic 139	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   250: lload_2
    //   251: invokestatic 144	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   254: invokevirtual 62	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   257: pop
    //   258: aload 7
    //   260: astore 6
    //   262: aload 4
    //   264: astore 5
    //   266: ldc 146
    //   268: ldc 148
    //   270: iconst_5
    //   271: anewarray 4	java/lang/Object
    //   274: dup
    //   275: iconst_0
    //   276: aload 9
    //   278: aastore
    //   279: dup
    //   280: iconst_1
    //   281: aload 10
    //   283: iconst_0
    //   284: aaload
    //   285: aastore
    //   286: dup
    //   287: iconst_2
    //   288: aload 10
    //   290: iconst_1
    //   291: aaload
    //   292: aastore
    //   293: dup
    //   294: iconst_3
    //   295: aload 8
    //   297: aastore
    //   298: dup
    //   299: iconst_4
    //   300: aload 11
    //   302: aastore
    //   303: invokestatic 154	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   306: iconst_1
    //   307: istore_1
    //   308: iload_1
    //   309: ifne -248 -> 61
    //   312: aload 7
    //   314: astore 6
    //   316: aload 4
    //   318: astore 5
    //   320: aload_0
    //   321: iconst_0
    //   322: putfield 56	com/tencent/mm/plugin/ai/data/business/finder/g:plZ	Z
    //   325: aload 7
    //   327: invokevirtual 157	java/io/BufferedReader:close	()V
    //   330: aload 4
    //   332: ifnull +8 -> 340
    //   335: aload 4
    //   337: invokevirtual 160	java/io/InputStream:close	()V
    //   340: ldc 74
    //   342: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   345: iconst_1
    //   346: ireturn
    //   347: iconst_0
    //   348: istore_1
    //   349: goto -41 -> 308
    //   352: astore 8
    //   354: aconst_null
    //   355: astore 7
    //   357: aload 5
    //   359: astore 4
    //   361: aload 7
    //   363: astore 6
    //   365: aload 4
    //   367: astore 5
    //   369: aload_0
    //   370: iconst_0
    //   371: putfield 56	com/tencent/mm/plugin/ai/data/business/finder/g:plZ	Z
    //   374: aload 7
    //   376: astore 6
    //   378: aload 4
    //   380: astore 5
    //   382: ldc 146
    //   384: aload 8
    //   386: ldc 162
    //   388: iconst_0
    //   389: anewarray 4	java/lang/Object
    //   392: invokestatic 166	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   395: aload 7
    //   397: ifnull +8 -> 405
    //   400: aload 7
    //   402: invokevirtual 157	java/io/BufferedReader:close	()V
    //   405: aload 4
    //   407: ifnull -67 -> 340
    //   410: aload 4
    //   412: invokevirtual 160	java/io/InputStream:close	()V
    //   415: goto -75 -> 340
    //   418: astore 4
    //   420: goto -80 -> 340
    //   423: astore 8
    //   425: aconst_null
    //   426: astore 7
    //   428: aload 6
    //   430: astore 4
    //   432: aload 7
    //   434: astore 6
    //   436: aload 4
    //   438: astore 5
    //   440: ldc 146
    //   442: aload 8
    //   444: ldc 162
    //   446: iconst_0
    //   447: anewarray 4	java/lang/Object
    //   450: invokestatic 166	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   453: aload 7
    //   455: astore 6
    //   457: aload 4
    //   459: astore 5
    //   461: aload_0
    //   462: iconst_0
    //   463: putfield 56	com/tencent/mm/plugin/ai/data/business/finder/g:plZ	Z
    //   466: aload 7
    //   468: ifnull +8 -> 476
    //   471: aload 7
    //   473: invokevirtual 157	java/io/BufferedReader:close	()V
    //   476: aload 4
    //   478: ifnull -138 -> 340
    //   481: aload 4
    //   483: invokevirtual 160	java/io/InputStream:close	()V
    //   486: goto -146 -> 340
    //   489: astore 4
    //   491: goto -151 -> 340
    //   494: astore 4
    //   496: aconst_null
    //   497: astore 6
    //   499: aload 8
    //   501: astore 5
    //   503: aload 6
    //   505: ifnull +8 -> 513
    //   508: aload 6
    //   510: invokevirtual 157	java/io/BufferedReader:close	()V
    //   513: aload 5
    //   515: ifnull +8 -> 523
    //   518: aload 5
    //   520: invokevirtual 160	java/io/InputStream:close	()V
    //   523: ldc 74
    //   525: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   528: aload 4
    //   530: athrow
    //   531: astore 5
    //   533: goto -203 -> 330
    //   536: astore 4
    //   538: goto -198 -> 340
    //   541: astore 5
    //   543: goto -138 -> 405
    //   546: astore 5
    //   548: goto -72 -> 476
    //   551: astore 6
    //   553: goto -40 -> 513
    //   556: astore 5
    //   558: goto -35 -> 523
    //   561: astore 4
    //   563: goto -60 -> 503
    //   566: astore 8
    //   568: goto -136 -> 432
    //   571: astore 8
    //   573: goto -212 -> 361
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	576	0	this	g
    //   96	253	1	i	int
    //   220	31	2	l	long
    //   29	382	4	localObject1	Object
    //   418	1	4	localIOException1	java.io.IOException
    //   430	52	4	localObject2	Object
    //   489	1	4	localIOException2	java.io.IOException
    //   494	35	4	localObject3	Object
    //   536	1	4	localIOException3	java.io.IOException
    //   561	1	4	localObject4	Object
    //   20	499	5	localObject5	Object
    //   531	1	5	localIOException4	java.io.IOException
    //   541	1	5	localIOException5	java.io.IOException
    //   546	1	5	localIOException6	java.io.IOException
    //   556	1	5	localIOException7	java.io.IOException
    //   14	495	6	localObject6	Object
    //   551	1	6	localIOException8	java.io.IOException
    //   59	413	7	localBufferedReader	java.io.BufferedReader
    //   17	279	8	localObject7	Object
    //   352	33	8	localFileNotFoundException1	java.io.FileNotFoundException
    //   423	77	8	localException1	java.lang.Exception
    //   566	1	8	localException2	java.lang.Exception
    //   571	1	8	localFileNotFoundException2	java.io.FileNotFoundException
    //   116	161	9	str	String
    //   159	130	10	arrayOfString	String[]
    //   181	120	11	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   22	31	352	java/io/FileNotFoundException
    //   43	61	352	java/io/FileNotFoundException
    //   410	415	418	java/io/IOException
    //   22	31	423	java/lang/Exception
    //   43	61	423	java/lang/Exception
    //   481	486	489	java/io/IOException
    //   22	31	494	finally
    //   43	61	494	finally
    //   325	330	531	java/io/IOException
    //   335	340	536	java/io/IOException
    //   400	405	541	java/io/IOException
    //   471	476	546	java/io/IOException
    //   508	513	551	java/io/IOException
    //   518	523	556	java/io/IOException
    //   69	76	561	finally
    //   89	97	561	finally
    //   109	118	561	finally
    //   126	138	561	finally
    //   146	161	561	finally
    //   169	183	561	finally
    //   191	202	561	finally
    //   210	221	561	finally
    //   244	258	561	finally
    //   266	306	561	finally
    //   320	325	561	finally
    //   369	374	561	finally
    //   382	395	561	finally
    //   440	453	561	finally
    //   461	466	561	finally
    //   69	76	566	java/lang/Exception
    //   89	97	566	java/lang/Exception
    //   109	118	566	java/lang/Exception
    //   126	138	566	java/lang/Exception
    //   146	161	566	java/lang/Exception
    //   169	183	566	java/lang/Exception
    //   191	202	566	java/lang/Exception
    //   210	221	566	java/lang/Exception
    //   244	258	566	java/lang/Exception
    //   266	306	566	java/lang/Exception
    //   320	325	566	java/lang/Exception
    //   69	76	571	java/io/FileNotFoundException
    //   89	97	571	java/io/FileNotFoundException
    //   109	118	571	java/io/FileNotFoundException
    //   126	138	571	java/io/FileNotFoundException
    //   146	161	571	java/io/FileNotFoundException
    //   169	183	571	java/io/FileNotFoundException
    //   191	202	571	java/io/FileNotFoundException
    //   210	221	571	java/io/FileNotFoundException
    //   244	258	571	java/io/FileNotFoundException
    //   266	306	571	java/io/FileNotFoundException
    //   320	325	571	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.data.business.finder.g
 * JD-Core Version:    0.7.0.1
 */