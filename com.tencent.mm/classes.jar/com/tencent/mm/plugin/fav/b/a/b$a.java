package com.tencent.mm.plugin.fav.b.a;

import com.tencent.mm.plugin.fts.a.a.a;
import java.util.HashSet;

final class b$a
  extends a
{
  private HashSet<Long> kaq = null;
  private int kar = 0;
  private int kas = 0;
  private int kat = 0;
  private int mFailedCount = 0;
  
  private b$a(b paramb) {}
  
  public final String afJ()
  {
    return String.format("{new: %d exist: %d removed: %d failed: %d}", new Object[] { Integer.valueOf(this.kas), Integer.valueOf(this.kar), Integer.valueOf(this.kat), Integer.valueOf(this.mFailedCount) });
  }
  
  /* Error */
  public final boolean execute()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 21	com/tencent/mm/plugin/fav/b/a/b$a:kap	Lcom/tencent/mm/plugin/fav/b/a/b;
    //   4: getfield 64	com/tencent/mm/plugin/fav/b/a/b:kan	Lcom/tencent/mm/sdk/e/e;
    //   7: ifnonnull +12 -> 19
    //   10: ldc 66
    //   12: ldc 68
    //   14: invokestatic 74	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: iconst_1
    //   18: ireturn
    //   19: ldc 66
    //   21: ldc 76
    //   23: invokestatic 79	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: aload_0
    //   27: getfield 26	com/tencent/mm/plugin/fav/b/a/b$a:kaq	Ljava/util/HashSet;
    //   30: ifnonnull +141 -> 171
    //   33: aload_0
    //   34: new 81	java/util/HashSet
    //   37: dup
    //   38: invokespecial 82	java/util/HashSet:<init>	()V
    //   41: putfield 26	com/tencent/mm/plugin/fav/b/a/b$a:kaq	Ljava/util/HashSet;
    //   44: aload_0
    //   45: getfield 21	com/tencent/mm/plugin/fav/b/a/b$a:kap	Lcom/tencent/mm/plugin/fav/b/a/b;
    //   48: getfield 86	com/tencent/mm/plugin/fav/b/a/b:kam	Lcom/tencent/mm/plugin/fav/b/a/a;
    //   51: getstatic 92	com/tencent/mm/plugin/fts/a/c:kuO	[I
    //   54: iconst_0
    //   55: iconst_1
    //   56: iconst_0
    //   57: iconst_0
    //   58: iconst_0
    //   59: invokevirtual 97	com/tencent/mm/plugin/fav/b/a/a:a	([IZZZZZ)Landroid/database/Cursor;
    //   62: astore 6
    //   64: aload 6
    //   66: astore 5
    //   68: aload 6
    //   70: invokeinterface 102 1 0
    //   75: ifeq +73 -> 148
    //   78: aload 6
    //   80: astore 5
    //   82: aload 6
    //   84: iconst_0
    //   85: invokeinterface 106 2 0
    //   90: lstore_3
    //   91: aload 6
    //   93: astore 5
    //   95: aload_0
    //   96: getfield 26	com/tencent/mm/plugin/fav/b/a/b$a:kaq	Ljava/util/HashSet;
    //   99: lload_3
    //   100: invokestatic 111	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   103: invokevirtual 115	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   106: pop
    //   107: goto -43 -> 64
    //   110: astore 7
    //   112: aload 6
    //   114: astore 5
    //   116: aload 7
    //   118: astore 6
    //   120: aload 6
    //   122: athrow
    //   123: astore 7
    //   125: aload 5
    //   127: astore 6
    //   129: aload 7
    //   131: astore 5
    //   133: aload 6
    //   135: ifnull +10 -> 145
    //   138: aload 6
    //   140: invokeinterface 118 1 0
    //   145: aload 5
    //   147: athrow
    //   148: aload 6
    //   150: ifnull +10 -> 160
    //   153: aload 6
    //   155: invokeinterface 118 1 0
    //   160: aload_0
    //   161: aload_0
    //   162: getfield 26	com/tencent/mm/plugin/fav/b/a/b$a:kaq	Ljava/util/HashSet;
    //   165: invokevirtual 122	java/util/HashSet:size	()I
    //   168: putfield 28	com/tencent/mm/plugin/fav/b/a/b$a:kar	I
    //   171: invokestatic 127	java/lang/Thread:interrupted	()Z
    //   174: ifeq +11 -> 185
    //   177: new 129	java/lang/InterruptedException
    //   180: dup
    //   181: invokespecial 130	java/lang/InterruptedException:<init>	()V
    //   184: athrow
    //   185: aload_0
    //   186: getfield 21	com/tencent/mm/plugin/fav/b/a/b$a:kap	Lcom/tencent/mm/plugin/fav/b/a/b;
    //   189: getfield 64	com/tencent/mm/plugin/fav/b/a/b:kan	Lcom/tencent/mm/sdk/e/e;
    //   192: ldc 132
    //   194: aconst_null
    //   195: invokeinterface 138 3 0
    //   200: astore 5
    //   202: bipush 50
    //   204: istore_1
    //   205: aload 5
    //   207: invokeinterface 102 1 0
    //   212: ifeq +175 -> 387
    //   215: invokestatic 127	java/lang/Thread:interrupted	()Z
    //   218: ifeq +43 -> 261
    //   221: aload_0
    //   222: getfield 21	com/tencent/mm/plugin/fav/b/a/b$a:kap	Lcom/tencent/mm/plugin/fav/b/a/b;
    //   225: getfield 86	com/tencent/mm/plugin/fav/b/a/b:kam	Lcom/tencent/mm/plugin/fav/b/a/a;
    //   228: invokevirtual 141	com/tencent/mm/plugin/fav/b/a/a:commit	()V
    //   231: new 129	java/lang/InterruptedException
    //   234: dup
    //   235: invokespecial 130	java/lang/InterruptedException:<init>	()V
    //   238: athrow
    //   239: astore 6
    //   241: aload 6
    //   243: athrow
    //   244: astore 6
    //   246: aload 5
    //   248: ifnull +10 -> 258
    //   251: aload 5
    //   253: invokeinterface 118 1 0
    //   258: aload 6
    //   260: athrow
    //   261: new 143	com/tencent/mm/plugin/fav/b/a/b$c
    //   264: dup
    //   265: aload_0
    //   266: getfield 21	com/tencent/mm/plugin/fav/b/a/b$a:kap	Lcom/tencent/mm/plugin/fav/b/a/b;
    //   269: iconst_0
    //   270: invokespecial 145	com/tencent/mm/plugin/fav/b/a/b$c:<init>	(Lcom/tencent/mm/plugin/fav/b/a/b;B)V
    //   273: astore 6
    //   275: aload 6
    //   277: aload 5
    //   279: invokevirtual 149	com/tencent/mm/plugin/fav/b/a/b$c:d	(Landroid/database/Cursor;)V
    //   282: aload_0
    //   283: getfield 26	com/tencent/mm/plugin/fav/b/a/b$a:kaq	Ljava/util/HashSet;
    //   286: aload 6
    //   288: getfield 153	com/tencent/mm/plugin/fav/b/a/b$c:enp	J
    //   291: invokestatic 111	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   294: invokevirtual 156	java/util/HashSet:remove	(Ljava/lang/Object;)Z
    //   297: ifne -92 -> 205
    //   300: iload_1
    //   301: bipush 50
    //   303: if_icmplt +260 -> 563
    //   306: aload_0
    //   307: getfield 21	com/tencent/mm/plugin/fav/b/a/b$a:kap	Lcom/tencent/mm/plugin/fav/b/a/b;
    //   310: getfield 86	com/tencent/mm/plugin/fav/b/a/b:kam	Lcom/tencent/mm/plugin/fav/b/a/a;
    //   313: invokevirtual 141	com/tencent/mm/plugin/fav/b/a/a:commit	()V
    //   316: aload_0
    //   317: getfield 21	com/tencent/mm/plugin/fav/b/a/b$a:kap	Lcom/tencent/mm/plugin/fav/b/a/b;
    //   320: getfield 86	com/tencent/mm/plugin/fav/b/a/b:kam	Lcom/tencent/mm/plugin/fav/b/a/a;
    //   323: invokevirtual 159	com/tencent/mm/plugin/fav/b/a/a:beginTransaction	()V
    //   326: iconst_0
    //   327: istore_2
    //   328: iload_2
    //   329: istore_1
    //   330: iload_2
    //   331: aload_0
    //   332: getfield 21	com/tencent/mm/plugin/fav/b/a/b$a:kap	Lcom/tencent/mm/plugin/fav/b/a/b;
    //   335: aload 6
    //   337: invokestatic 162	com/tencent/mm/plugin/fav/b/a/b:a	(Lcom/tencent/mm/plugin/fav/b/a/b;Lcom/tencent/mm/plugin/fav/b/a/b$c;)I
    //   340: iadd
    //   341: istore_2
    //   342: iload_2
    //   343: istore_1
    //   344: aload_0
    //   345: aload_0
    //   346: getfield 30	com/tencent/mm/plugin/fav/b/a/b$a:kas	I
    //   349: iconst_1
    //   350: iadd
    //   351: putfield 30	com/tencent/mm/plugin/fav/b/a/b$a:kas	I
    //   354: iload_2
    //   355: istore_1
    //   356: goto -151 -> 205
    //   359: astore 6
    //   361: ldc 66
    //   363: aload 6
    //   365: ldc 164
    //   367: iconst_0
    //   368: anewarray 44	java/lang/Object
    //   371: invokestatic 168	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   374: aload_0
    //   375: aload_0
    //   376: getfield 34	com/tencent/mm/plugin/fav/b/a/b$a:mFailedCount	I
    //   379: iconst_1
    //   380: iadd
    //   381: putfield 34	com/tencent/mm/plugin/fav/b/a/b$a:mFailedCount	I
    //   384: goto -179 -> 205
    //   387: aload 5
    //   389: ifnull +10 -> 399
    //   392: aload 5
    //   394: invokeinterface 118 1 0
    //   399: aload_0
    //   400: getfield 21	com/tencent/mm/plugin/fav/b/a/b$a:kap	Lcom/tencent/mm/plugin/fav/b/a/b;
    //   403: getfield 86	com/tencent/mm/plugin/fav/b/a/b:kam	Lcom/tencent/mm/plugin/fav/b/a/a;
    //   406: invokevirtual 141	com/tencent/mm/plugin/fav/b/a/a:commit	()V
    //   409: aload_0
    //   410: getfield 26	com/tencent/mm/plugin/fav/b/a/b$a:kaq	Ljava/util/HashSet;
    //   413: invokevirtual 172	java/util/HashSet:iterator	()Ljava/util/Iterator;
    //   416: astore 5
    //   418: aload 5
    //   420: invokeinterface 177 1 0
    //   425: ifeq +107 -> 532
    //   428: invokestatic 127	java/lang/Thread:interrupted	()Z
    //   431: ifeq +21 -> 452
    //   434: aload_0
    //   435: getfield 21	com/tencent/mm/plugin/fav/b/a/b$a:kap	Lcom/tencent/mm/plugin/fav/b/a/b;
    //   438: getfield 86	com/tencent/mm/plugin/fav/b/a/b:kam	Lcom/tencent/mm/plugin/fav/b/a/a;
    //   441: invokevirtual 141	com/tencent/mm/plugin/fav/b/a/a:commit	()V
    //   444: new 129	java/lang/InterruptedException
    //   447: dup
    //   448: invokespecial 130	java/lang/InterruptedException:<init>	()V
    //   451: athrow
    //   452: iload_1
    //   453: bipush 50
    //   455: if_icmplt +105 -> 560
    //   458: aload_0
    //   459: getfield 21	com/tencent/mm/plugin/fav/b/a/b$a:kap	Lcom/tencent/mm/plugin/fav/b/a/b;
    //   462: getfield 86	com/tencent/mm/plugin/fav/b/a/b:kam	Lcom/tencent/mm/plugin/fav/b/a/a;
    //   465: invokevirtual 141	com/tencent/mm/plugin/fav/b/a/a:commit	()V
    //   468: aload_0
    //   469: getfield 21	com/tencent/mm/plugin/fav/b/a/b$a:kap	Lcom/tencent/mm/plugin/fav/b/a/b;
    //   472: getfield 86	com/tencent/mm/plugin/fav/b/a/b:kam	Lcom/tencent/mm/plugin/fav/b/a/a;
    //   475: invokevirtual 159	com/tencent/mm/plugin/fav/b/a/a:beginTransaction	()V
    //   478: iconst_0
    //   479: istore_1
    //   480: aload 5
    //   482: invokeinterface 181 1 0
    //   487: checkcast 108	java/lang/Long
    //   490: invokevirtual 185	java/lang/Long:longValue	()J
    //   493: lstore_3
    //   494: aload_0
    //   495: getfield 21	com/tencent/mm/plugin/fav/b/a/b$a:kap	Lcom/tencent/mm/plugin/fav/b/a/b;
    //   498: getfield 86	com/tencent/mm/plugin/fav/b/a/b:kam	Lcom/tencent/mm/plugin/fav/b/a/a;
    //   501: getstatic 92	com/tencent/mm/plugin/fts/a/c:kuO	[I
    //   504: lload_3
    //   505: invokevirtual 189	com/tencent/mm/plugin/fav/b/a/a:c	([IJ)V
    //   508: iload_1
    //   509: iconst_1
    //   510: iadd
    //   511: istore_1
    //   512: aload_0
    //   513: aload_0
    //   514: getfield 32	com/tencent/mm/plugin/fav/b/a/b$a:kat	I
    //   517: iconst_1
    //   518: iadd
    //   519: putfield 32	com/tencent/mm/plugin/fav/b/a/b$a:kat	I
    //   522: aload 5
    //   524: invokeinterface 191 1 0
    //   529: goto -111 -> 418
    //   532: aload_0
    //   533: getfield 21	com/tencent/mm/plugin/fav/b/a/b$a:kap	Lcom/tencent/mm/plugin/fav/b/a/b;
    //   536: getfield 86	com/tencent/mm/plugin/fav/b/a/b:kam	Lcom/tencent/mm/plugin/fav/b/a/a;
    //   539: invokevirtual 141	com/tencent/mm/plugin/fav/b/a/a:commit	()V
    //   542: iconst_1
    //   543: ireturn
    //   544: astore 5
    //   546: aconst_null
    //   547: astore 6
    //   549: goto -416 -> 133
    //   552: astore 6
    //   554: aconst_null
    //   555: astore 5
    //   557: goto -437 -> 120
    //   560: goto -80 -> 480
    //   563: iload_1
    //   564: istore_2
    //   565: goto -237 -> 328
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	568	0	this	a
    //   204	360	1	i	int
    //   327	238	2	j	int
    //   90	415	3	l	long
    //   66	457	5	localObject1	Object
    //   544	1	5	localObject2	Object
    //   555	1	5	localObject3	Object
    //   62	92	6	localObject4	Object
    //   239	3	6	localException1	java.lang.Exception
    //   244	15	6	localObject5	Object
    //   273	63	6	localc	b.c
    //   359	5	6	localException2	java.lang.Exception
    //   547	1	6	localObject6	Object
    //   552	1	6	localException3	java.lang.Exception
    //   110	7	7	localException4	java.lang.Exception
    //   123	7	7	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   68	78	110	java/lang/Exception
    //   82	91	110	java/lang/Exception
    //   95	107	110	java/lang/Exception
    //   68	78	123	finally
    //   82	91	123	finally
    //   95	107	123	finally
    //   120	123	123	finally
    //   205	239	239	java/lang/Exception
    //   261	300	239	java/lang/Exception
    //   306	326	239	java/lang/Exception
    //   361	384	239	java/lang/Exception
    //   205	239	244	finally
    //   241	244	244	finally
    //   261	300	244	finally
    //   306	326	244	finally
    //   330	342	244	finally
    //   344	354	244	finally
    //   361	384	244	finally
    //   330	342	359	java/lang/Exception
    //   344	354	359	java/lang/Exception
    //   44	64	544	finally
    //   44	64	552	java/lang/Exception
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.a.b.a
 * JD-Core Version:    0.7.0.1
 */