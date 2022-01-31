package com.tencent.mm.modelvideo;

import android.os.AsyncTask;

final class c$1
  extends AsyncTask<String, Integer, String>
{
  int ret = 0;
  
  c$1(c paramc) {}
  
  /* Error */
  private String all()
  {
    // Byte code:
    //   0: ldc 26
    //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: iconst_0
    //   7: putfield 20	com/tencent/mm/modelvideo/c$1:ret	I
    //   10: invokestatic 38	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   13: invokestatic 44	com/tencent/mm/sdk/platformtools/at:is2G	(Landroid/content/Context;)Z
    //   16: istore_3
    //   17: aload_0
    //   18: getfield 15	com/tencent/mm/modelvideo/c$1:fVc	Lcom/tencent/mm/modelvideo/c;
    //   21: getfield 48	com/tencent/mm/modelvideo/c:context	Landroid/content/Context;
    //   24: aload_0
    //   25: getfield 15	com/tencent/mm/modelvideo/c$1:fVc	Lcom/tencent/mm/modelvideo/c;
    //   28: getfield 52	com/tencent/mm/modelvideo/c:intent	Landroid/content/Intent;
    //   31: invokestatic 58	com/tencent/mm/compatible/j/a:j	(Landroid/content/Context;Landroid/content/Intent;)Lcom/tencent/mm/compatible/j/a$a;
    //   34: astore 4
    //   36: aload 4
    //   38: ifnonnull +64 -> 102
    //   41: ldc 60
    //   43: ldc 62
    //   45: invokestatic 68	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   48: getstatic 74	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   51: ldc2_w 75
    //   54: ldc2_w 77
    //   57: lconst_1
    //   58: iconst_0
    //   59: invokevirtual 82	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   62: aload_0
    //   63: ldc 83
    //   65: putfield 20	com/tencent/mm/modelvideo/c$1:ret	I
    //   68: ldc 26
    //   70: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: aconst_null
    //   74: areturn
    //   75: astore 4
    //   77: ldc 60
    //   79: ldc 88
    //   81: iconst_1
    //   82: anewarray 90	java/lang/Object
    //   85: dup
    //   86: iconst_0
    //   87: aload 4
    //   89: invokestatic 96	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   92: aastore
    //   93: invokestatic 99	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   96: aconst_null
    //   97: astore 4
    //   99: goto -63 -> 36
    //   102: aload_0
    //   103: getfield 15	com/tencent/mm/modelvideo/c$1:fVc	Lcom/tencent/mm/modelvideo/c;
    //   106: aload 4
    //   108: getfield 105	com/tencent/mm/compatible/j/a$a:filename	Ljava/lang/String;
    //   111: putfield 108	com/tencent/mm/modelvideo/c:fVa	Ljava/lang/String;
    //   114: aload_0
    //   115: getfield 15	com/tencent/mm/modelvideo/c$1:fVc	Lcom/tencent/mm/modelvideo/c;
    //   118: getfield 108	com/tencent/mm/modelvideo/c:fVa	Ljava/lang/String;
    //   121: invokestatic 114	com/tencent/mm/vfs/e:avI	(Ljava/lang/String;)J
    //   124: l2i
    //   125: istore_2
    //   126: ldc 60
    //   128: ldc 116
    //   130: iconst_4
    //   131: anewarray 90	java/lang/Object
    //   134: dup
    //   135: iconst_0
    //   136: iload_3
    //   137: invokestatic 122	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   140: aastore
    //   141: dup
    //   142: iconst_1
    //   143: iload_2
    //   144: invokestatic 127	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   147: aastore
    //   148: dup
    //   149: iconst_2
    //   150: aload 4
    //   152: getfield 130	com/tencent/mm/compatible/j/a$a:duration	I
    //   155: invokestatic 127	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   158: aastore
    //   159: dup
    //   160: iconst_3
    //   161: aload_0
    //   162: getfield 15	com/tencent/mm/modelvideo/c$1:fVc	Lcom/tencent/mm/modelvideo/c;
    //   165: getfield 108	com/tencent/mm/modelvideo/c:fVa	Ljava/lang/String;
    //   168: aastore
    //   169: invokestatic 132	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   172: iload_2
    //   173: ifgt +30 -> 203
    //   176: getstatic 74	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   179: ldc2_w 75
    //   182: ldc2_w 77
    //   185: lconst_1
    //   186: iconst_0
    //   187: invokevirtual 82	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   190: aload_0
    //   191: ldc 133
    //   193: putfield 20	com/tencent/mm/modelvideo/c$1:ret	I
    //   196: ldc 26
    //   198: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   201: aconst_null
    //   202: areturn
    //   203: iload_3
    //   204: ifeq +38 -> 242
    //   207: ldc 134
    //   209: istore_1
    //   210: iload_2
    //   211: iload_1
    //   212: if_icmple +37 -> 249
    //   215: getstatic 74	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   218: ldc2_w 75
    //   221: ldc2_w 135
    //   224: lconst_1
    //   225: iconst_0
    //   226: invokevirtual 82	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   229: aload_0
    //   230: ldc 137
    //   232: putfield 20	com/tencent/mm/modelvideo/c$1:ret	I
    //   235: ldc 26
    //   237: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   240: aconst_null
    //   241: areturn
    //   242: getstatic 140	com/tencent/mm/modelvideo/c:fUY	I
    //   245: istore_1
    //   246: goto -36 -> 210
    //   249: aload_0
    //   250: getfield 15	com/tencent/mm/modelvideo/c$1:fVc	Lcom/tencent/mm/modelvideo/c;
    //   253: getfield 108	com/tencent/mm/modelvideo/c:fVa	Ljava/lang/String;
    //   256: aload_0
    //   257: getfield 15	com/tencent/mm/modelvideo/c$1:fVc	Lcom/tencent/mm/modelvideo/c;
    //   260: getfield 143	com/tencent/mm/modelvideo/c:videoPath	Ljava/lang/String;
    //   263: invokestatic 147	com/tencent/mm/vfs/e:C	(Ljava/lang/String;Ljava/lang/String;)J
    //   266: pop2
    //   267: aload_0
    //   268: getfield 15	com/tencent/mm/modelvideo/c$1:fVc	Lcom/tencent/mm/modelvideo/c;
    //   271: aload 4
    //   273: getfield 130	com/tencent/mm/compatible/j/a$a:duration	I
    //   276: sipush 1000
    //   279: idiv
    //   280: putfield 148	com/tencent/mm/modelvideo/c:duration	I
    //   283: iconst_1
    //   284: istore_2
    //   285: iconst_1
    //   286: istore_1
    //   287: aload 4
    //   289: getfield 152	com/tencent/mm/compatible/j/a$a:bitmap	Landroid/graphics/Bitmap;
    //   292: ifnull +40 -> 332
    //   295: aload 4
    //   297: getfield 152	com/tencent/mm/compatible/j/a$a:bitmap	Landroid/graphics/Bitmap;
    //   300: bipush 60
    //   302: getstatic 158	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   305: aload_0
    //   306: getfield 15	com/tencent/mm/modelvideo/c$1:fVc	Lcom/tencent/mm/modelvideo/c;
    //   309: getfield 161	com/tencent/mm/modelvideo/c:thumbPath	Ljava/lang/String;
    //   312: iconst_1
    //   313: invokestatic 167	com/tencent/mm/sdk/platformtools/d:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)V
    //   316: getstatic 74	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   319: ldc2_w 75
    //   322: ldc2_w 168
    //   325: lconst_1
    //   326: iconst_0
    //   327: invokevirtual 82	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   330: iconst_0
    //   331: istore_1
    //   332: iload_1
    //   333: ifeq +44 -> 377
    //   336: getstatic 74	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   339: ldc2_w 75
    //   342: ldc2_w 170
    //   345: lconst_1
    //   346: iconst_0
    //   347: invokevirtual 82	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   350: ldc 172
    //   352: sipush 320
    //   355: sipush 480
    //   358: invokestatic 176	com/tencent/mm/sdk/platformtools/d:au	(III)Landroid/graphics/Bitmap;
    //   361: bipush 60
    //   363: getstatic 158	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   366: aload_0
    //   367: getfield 15	com/tencent/mm/modelvideo/c$1:fVc	Lcom/tencent/mm/modelvideo/c;
    //   370: getfield 161	com/tencent/mm/modelvideo/c:thumbPath	Ljava/lang/String;
    //   373: iconst_1
    //   374: invokestatic 167	com/tencent/mm/sdk/platformtools/d:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)V
    //   377: aload_0
    //   378: getfield 15	com/tencent/mm/modelvideo/c$1:fVc	Lcom/tencent/mm/modelvideo/c;
    //   381: getfield 143	com/tencent/mm/modelvideo/c:videoPath	Ljava/lang/String;
    //   384: invokestatic 180	com/tencent/mm/vfs/e:cN	(Ljava/lang/String;)Z
    //   387: ifne +9 -> 396
    //   390: aload_0
    //   391: ldc 181
    //   393: putfield 20	com/tencent/mm/modelvideo/c$1:ret	I
    //   396: aload_0
    //   397: getfield 15	com/tencent/mm/modelvideo/c$1:fVc	Lcom/tencent/mm/modelvideo/c;
    //   400: getfield 161	com/tencent/mm/modelvideo/c:thumbPath	Ljava/lang/String;
    //   403: invokestatic 180	com/tencent/mm/vfs/e:cN	(Ljava/lang/String;)Z
    //   406: ifne +9 -> 415
    //   409: aload_0
    //   410: ldc 182
    //   412: putfield 20	com/tencent/mm/modelvideo/c$1:ret	I
    //   415: ldc 26
    //   417: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   420: aconst_null
    //   421: areturn
    //   422: astore 4
    //   424: iload_2
    //   425: istore_1
    //   426: ldc 60
    //   428: ldc 88
    //   430: iconst_1
    //   431: anewarray 90	java/lang/Object
    //   434: dup
    //   435: iconst_0
    //   436: aload 4
    //   438: invokestatic 96	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   441: aastore
    //   442: invokestatic 99	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   445: goto -113 -> 332
    //   448: astore 4
    //   450: ldc 60
    //   452: ldc 88
    //   454: iconst_1
    //   455: anewarray 90	java/lang/Object
    //   458: dup
    //   459: iconst_0
    //   460: aload 4
    //   462: invokestatic 96	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   465: aastore
    //   466: invokestatic 99	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   469: goto -92 -> 377
    //   472: astore 4
    //   474: iconst_0
    //   475: istore_1
    //   476: goto -50 -> 426
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	479	0	this	1
    //   209	267	1	i	int
    //   125	300	2	j	int
    //   16	188	3	bool	boolean
    //   34	3	4	locala	com.tencent.mm.compatible.j.a.a
    //   75	13	4	localException1	java.lang.Exception
    //   97	199	4	localObject	java.lang.Object
    //   422	15	4	localException2	java.lang.Exception
    //   448	13	4	localException3	java.lang.Exception
    //   472	1	4	localException4	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   17	36	75	java/lang/Exception
    //   295	316	422	java/lang/Exception
    //   336	377	448	java/lang/Exception
    //   316	330	472	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelvideo.c.1
 * JD-Core Version:    0.7.0.1
 */