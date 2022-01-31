package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.ac;
import java.io.File;

public final class d
{
  private static final String bXH;
  
  static
  {
    AppMethodBeat.i(15376);
    bXH = ac.eQv + "channel_history.cfg";
    AppMethodBeat.o(15376);
  }
  
  /* Error */
  public static void AZ()
  {
    // Byte code:
    //   0: sipush 15374
    //   3: invokestatic 14	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 47	com/tencent/mm/app/d:Ba	()Z
    //   9: ifne +17 -> 26
    //   12: ldc 49
    //   14: ldc 51
    //   16: invokestatic 57	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: sipush 15374
    //   22: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   25: return
    //   26: new 59	java/io/RandomAccessFile
    //   29: dup
    //   30: getstatic 36	com/tencent/mm/app/d:bXH	Ljava/lang/String;
    //   33: ldc 61
    //   35: invokespecial 63	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   38: astore 7
    //   40: aload 7
    //   42: astore 5
    //   44: aload 7
    //   46: invokevirtual 67	java/io/RandomAccessFile:length	()J
    //   49: lstore_3
    //   50: aload 7
    //   52: astore 5
    //   54: ldc 49
    //   56: ldc 69
    //   58: iconst_2
    //   59: anewarray 4	java/lang/Object
    //   62: dup
    //   63: iconst_0
    //   64: lload_3
    //   65: invokestatic 75	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   68: aastore
    //   69: dup
    //   70: iconst_1
    //   71: getstatic 81	com/tencent/mm/sdk/platformtools/g:bWu	I
    //   74: invokestatic 86	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   77: aastore
    //   78: invokestatic 89	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   81: lload_3
    //   82: lconst_0
    //   83: lcmp
    //   84: ifgt +53 -> 137
    //   87: aload 7
    //   89: astore 5
    //   91: ldc 49
    //   93: ldc 91
    //   95: invokestatic 57	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: aload 7
    //   100: invokevirtual 94	java/io/RandomAccessFile:close	()V
    //   103: sipush 15374
    //   106: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: return
    //   110: astore 5
    //   112: ldc 49
    //   114: aload 5
    //   116: ldc 96
    //   118: iconst_1
    //   119: anewarray 4	java/lang/Object
    //   122: dup
    //   123: iconst_0
    //   124: ldc 98
    //   126: aastore
    //   127: invokestatic 102	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   130: sipush 15374
    //   133: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   136: return
    //   137: aload 7
    //   139: astore 5
    //   141: aload 7
    //   143: invokevirtual 105	java/io/RandomAccessFile:readLine	()Ljava/lang/String;
    //   146: astore 9
    //   148: aload 7
    //   150: astore 5
    //   152: getstatic 81	com/tencent/mm/sdk/platformtools/g:bWu	I
    //   155: istore_2
    //   156: aload 7
    //   158: astore 5
    //   160: getstatic 81	com/tencent/mm/sdk/platformtools/g:bWu	I
    //   163: istore_0
    //   164: aload 7
    //   166: astore 5
    //   168: getstatic 81	com/tencent/mm/sdk/platformtools/g:bWu	I
    //   171: putstatic 108	com/tencent/mm/sdk/platformtools/g:ymI	I
    //   174: ldc 98
    //   176: astore 6
    //   178: aload 7
    //   180: astore 5
    //   182: aload 9
    //   184: invokestatic 114	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   187: ifne +103 -> 290
    //   190: aload 7
    //   192: astore 5
    //   194: new 16	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   201: ldc 98
    //   203: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: aload 9
    //   208: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: ldc 116
    //   213: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: astore 8
    //   221: aload 7
    //   223: astore 5
    //   225: aload 9
    //   227: iconst_0
    //   228: invokestatic 120	com/tencent/mm/sdk/platformtools/bo:getInt	(Ljava/lang/String;I)I
    //   231: istore_1
    //   232: aload 8
    //   234: astore 6
    //   236: iload_1
    //   237: istore_0
    //   238: aload 7
    //   240: astore 5
    //   242: iload_1
    //   243: getstatic 81	com/tencent/mm/sdk/platformtools/g:bWu	I
    //   246: if_icmpeq +44 -> 290
    //   249: aload 7
    //   251: astore 5
    //   253: iload_1
    //   254: putstatic 108	com/tencent/mm/sdk/platformtools/g:ymI	I
    //   257: aload 7
    //   259: astore 5
    //   261: ldc 49
    //   263: new 16	java/lang/StringBuilder
    //   266: dup
    //   267: ldc 122
    //   269: invokespecial 125	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   272: getstatic 81	com/tencent/mm/sdk/platformtools/g:bWu	I
    //   275: invokevirtual 128	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   278: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: invokestatic 130	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   284: iload_1
    //   285: istore_0
    //   286: aload 8
    //   288: astore 6
    //   290: aload 7
    //   292: astore 5
    //   294: getstatic 136	com/tencent/mm/sdk/platformtools/ah:ynK	Z
    //   297: ifeq +163 -> 460
    //   300: aload 7
    //   302: astore 5
    //   304: aload 7
    //   306: invokevirtual 105	java/io/RandomAccessFile:readLine	()Ljava/lang/String;
    //   309: astore 8
    //   311: aload 7
    //   313: astore 5
    //   315: aload 8
    //   317: invokestatic 114	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   320: ifne +48 -> 368
    //   323: aload 7
    //   325: astore 5
    //   327: new 16	java/lang/StringBuilder
    //   330: dup
    //   331: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   334: aload 6
    //   336: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: aload 8
    //   341: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: ldc 116
    //   346: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   352: astore 6
    //   354: aload 7
    //   356: astore 5
    //   358: aload 8
    //   360: iconst_0
    //   361: invokestatic 120	com/tencent/mm/sdk/platformtools/bo:getInt	(Ljava/lang/String;I)I
    //   364: istore_0
    //   365: goto -65 -> 300
    //   368: aload 7
    //   370: astore 5
    //   372: ldc 49
    //   374: ldc 138
    //   376: iconst_1
    //   377: anewarray 4	java/lang/Object
    //   380: dup
    //   381: iconst_0
    //   382: aload 6
    //   384: aastore
    //   385: invokestatic 89	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   388: iload_0
    //   389: iload_2
    //   390: if_icmpeq +70 -> 460
    //   393: aload 7
    //   395: astore 5
    //   397: aload 7
    //   399: lload_3
    //   400: invokevirtual 142	java/io/RandomAccessFile:seek	(J)V
    //   403: aload 7
    //   405: astore 5
    //   407: aload 7
    //   409: ldc 144
    //   411: iconst_1
    //   412: anewarray 4	java/lang/Object
    //   415: dup
    //   416: iconst_0
    //   417: iload_2
    //   418: invokestatic 86	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   421: aastore
    //   422: invokestatic 150	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   425: invokevirtual 154	java/lang/String:getBytes	()[B
    //   428: invokevirtual 158	java/io/RandomAccessFile:write	([B)V
    //   431: aload 7
    //   433: astore 5
    //   435: ldc 49
    //   437: ldc 160
    //   439: iconst_2
    //   440: anewarray 4	java/lang/Object
    //   443: dup
    //   444: iconst_0
    //   445: iload_0
    //   446: invokestatic 86	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   449: aastore
    //   450: dup
    //   451: iconst_1
    //   452: iload_2
    //   453: invokestatic 86	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   456: aastore
    //   457: invokestatic 89	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   460: aload 7
    //   462: invokevirtual 94	java/io/RandomAccessFile:close	()V
    //   465: sipush 15374
    //   468: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   471: return
    //   472: astore 5
    //   474: ldc 49
    //   476: aload 5
    //   478: ldc 96
    //   480: iconst_1
    //   481: anewarray 4	java/lang/Object
    //   484: dup
    //   485: iconst_0
    //   486: ldc 98
    //   488: aastore
    //   489: invokestatic 102	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   492: sipush 15374
    //   495: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   498: return
    //   499: astore 8
    //   501: aconst_null
    //   502: astore 6
    //   504: aload 6
    //   506: astore 5
    //   508: ldc 49
    //   510: aload 8
    //   512: ldc 162
    //   514: iconst_1
    //   515: anewarray 4	java/lang/Object
    //   518: dup
    //   519: iconst_0
    //   520: ldc 98
    //   522: aastore
    //   523: invokestatic 102	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   526: aload 6
    //   528: ifnull +8 -> 536
    //   531: aload 6
    //   533: invokevirtual 94	java/io/RandomAccessFile:close	()V
    //   536: sipush 15374
    //   539: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   542: return
    //   543: astore 5
    //   545: ldc 49
    //   547: aload 5
    //   549: ldc 96
    //   551: iconst_1
    //   552: anewarray 4	java/lang/Object
    //   555: dup
    //   556: iconst_0
    //   557: ldc 98
    //   559: aastore
    //   560: invokestatic 102	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   563: sipush 15374
    //   566: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   569: return
    //   570: astore 6
    //   572: aconst_null
    //   573: astore 5
    //   575: aload 5
    //   577: ifnull +8 -> 585
    //   580: aload 5
    //   582: invokevirtual 94	java/io/RandomAccessFile:close	()V
    //   585: sipush 15374
    //   588: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   591: aload 6
    //   593: athrow
    //   594: astore 5
    //   596: ldc 49
    //   598: aload 5
    //   600: ldc 96
    //   602: iconst_1
    //   603: anewarray 4	java/lang/Object
    //   606: dup
    //   607: iconst_0
    //   608: ldc 98
    //   610: aastore
    //   611: invokestatic 102	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   614: goto -29 -> 585
    //   617: astore 6
    //   619: goto -44 -> 575
    //   622: astore 8
    //   624: aload 7
    //   626: astore 6
    //   628: goto -124 -> 504
    // Local variable table:
    //   start	length	slot	name	signature
    //   163	283	0	i	int
    //   231	54	1	j	int
    //   155	298	2	k	int
    //   49	351	3	l	long
    //   42	48	5	localRandomAccessFile1	java.io.RandomAccessFile
    //   110	5	5	localException1	java.lang.Exception
    //   139	295	5	localRandomAccessFile2	java.io.RandomAccessFile
    //   472	5	5	localException2	java.lang.Exception
    //   506	1	5	localObject1	Object
    //   543	5	5	localException3	java.lang.Exception
    //   573	8	5	localObject2	Object
    //   594	5	5	localException4	java.lang.Exception
    //   176	356	6	localObject3	Object
    //   570	22	6	localObject4	Object
    //   617	1	6	localObject5	Object
    //   626	1	6	localRandomAccessFile3	java.io.RandomAccessFile
    //   38	587	7	localRandomAccessFile4	java.io.RandomAccessFile
    //   219	140	8	str1	String
    //   499	12	8	localException5	java.lang.Exception
    //   622	1	8	localException6	java.lang.Exception
    //   146	80	9	str2	String
    // Exception table:
    //   from	to	target	type
    //   98	103	110	java/lang/Exception
    //   460	465	472	java/lang/Exception
    //   26	40	499	java/lang/Exception
    //   531	536	543	java/lang/Exception
    //   26	40	570	finally
    //   580	585	594	java/lang/Exception
    //   44	50	617	finally
    //   54	81	617	finally
    //   91	98	617	finally
    //   141	148	617	finally
    //   152	156	617	finally
    //   160	164	617	finally
    //   168	174	617	finally
    //   182	190	617	finally
    //   194	221	617	finally
    //   225	232	617	finally
    //   242	249	617	finally
    //   253	257	617	finally
    //   261	284	617	finally
    //   294	300	617	finally
    //   304	311	617	finally
    //   315	323	617	finally
    //   327	354	617	finally
    //   358	365	617	finally
    //   372	388	617	finally
    //   397	403	617	finally
    //   407	431	617	finally
    //   435	460	617	finally
    //   508	526	617	finally
    //   44	50	622	java/lang/Exception
    //   54	81	622	java/lang/Exception
    //   91	98	622	java/lang/Exception
    //   141	148	622	java/lang/Exception
    //   152	156	622	java/lang/Exception
    //   160	164	622	java/lang/Exception
    //   168	174	622	java/lang/Exception
    //   182	190	622	java/lang/Exception
    //   194	221	622	java/lang/Exception
    //   225	232	622	java/lang/Exception
    //   242	249	622	java/lang/Exception
    //   253	257	622	java/lang/Exception
    //   261	284	622	java/lang/Exception
    //   294	300	622	java/lang/Exception
    //   304	311	622	java/lang/Exception
    //   315	323	622	java/lang/Exception
    //   327	354	622	java/lang/Exception
    //   358	365	622	java/lang/Exception
    //   372	388	622	java/lang/Exception
    //   397	403	622	java/lang/Exception
    //   407	431	622	java/lang/Exception
    //   435	460	622	java/lang/Exception
  }
  
  private static boolean Ba()
  {
    AppMethodBeat.i(15375);
    boolean bool = new File(bXH).exists();
    AppMethodBeat.o(15375);
    return bool;
  }
  
  /* Error */
  public static void aY(android.content.Context paramContext)
  {
    // Byte code:
    //   0: sipush 15373
    //   3: invokestatic 14	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 175	com/tencent/mm/sdk/platformtools/g:gC	(Landroid/content/Context;)V
    //   10: aload_0
    //   11: invokevirtual 181	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   14: astore_1
    //   15: aload_1
    //   16: aload_0
    //   17: invokevirtual 184	android/content/Context:getPackageName	()Ljava/lang/String;
    //   20: iconst_0
    //   21: invokevirtual 190	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   24: getfield 196	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   27: getfield 201	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   30: invokestatic 207	com/tencent/mm/c/a:dn	(Ljava/lang/String;)Lcom/tencent/mm/c/a;
    //   33: astore_1
    //   34: aload_1
    //   35: ifnull +44 -> 79
    //   38: aload_1
    //   39: getfield 211	com/tencent/mm/c/a:bWr	Lcom/tencent/mm/c/b;
    //   42: ifnull +37 -> 79
    //   45: ldc 49
    //   47: ldc 213
    //   49: invokestatic 130	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: aload_1
    //   53: getfield 211	com/tencent/mm/c/a:bWr	Lcom/tencent/mm/c/b;
    //   56: getfield 216	com/tencent/mm/c/b:bWu	I
    //   59: ifeq +20 -> 79
    //   62: aload_1
    //   63: getfield 211	com/tencent/mm/c/a:bWr	Lcom/tencent/mm/c/b;
    //   66: getfield 216	com/tencent/mm/c/b:bWu	I
    //   69: putstatic 81	com/tencent/mm/sdk/platformtools/g:bWu	I
    //   72: ldc 49
    //   74: ldc 218
    //   76: invokestatic 130	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: ldc 49
    //   81: ldc 220
    //   83: iconst_2
    //   84: anewarray 4	java/lang/Object
    //   87: dup
    //   88: iconst_0
    //   89: getstatic 81	com/tencent/mm/sdk/platformtools/g:bWu	I
    //   92: invokestatic 86	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   95: aastore
    //   96: dup
    //   97: iconst_1
    //   98: invokestatic 223	com/tencent/mm/sdk/platformtools/ah:getProcessName	()Ljava/lang/String;
    //   101: aastore
    //   102: invokestatic 89	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   105: invokestatic 47	com/tencent/mm/app/d:Ba	()Z
    //   108: ifne +47 -> 155
    //   111: new 59	java/io/RandomAccessFile
    //   114: dup
    //   115: getstatic 36	com/tencent/mm/app/d:bXH	Ljava/lang/String;
    //   118: ldc 61
    //   120: invokespecial 63	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   123: astore_2
    //   124: aload_2
    //   125: astore_1
    //   126: aload_2
    //   127: ldc 144
    //   129: iconst_1
    //   130: anewarray 4	java/lang/Object
    //   133: dup
    //   134: iconst_0
    //   135: getstatic 81	com/tencent/mm/sdk/platformtools/g:bWu	I
    //   138: invokestatic 86	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   141: aastore
    //   142: invokestatic 150	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   145: invokevirtual 154	java/lang/String:getBytes	()[B
    //   148: invokevirtual 158	java/io/RandomAccessFile:write	([B)V
    //   151: aload_2
    //   152: invokevirtual 94	java/io/RandomAccessFile:close	()V
    //   155: aload_0
    //   156: invokestatic 229	com/tencent/mm/booter/d:bt	(Landroid/content/Context;)Lcom/tencent/mm/booter/d;
    //   159: astore_0
    //   160: aload_0
    //   161: ifnull +18 -> 179
    //   164: aload_0
    //   165: getfield 232	com/tencent/mm/booter/d:dYP	I
    //   168: iconst_m1
    //   169: if_icmpeq +10 -> 179
    //   172: aload_0
    //   173: getfield 232	com/tencent/mm/booter/d:dYP	I
    //   176: putstatic 81	com/tencent/mm/sdk/platformtools/g:bWu	I
    //   179: sipush 15373
    //   182: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   185: return
    //   186: astore_1
    //   187: ldc 49
    //   189: ldc 234
    //   191: invokestatic 237	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   194: goto -115 -> 79
    //   197: astore_1
    //   198: ldc 49
    //   200: ldc 239
    //   202: iconst_1
    //   203: anewarray 4	java/lang/Object
    //   206: dup
    //   207: iconst_0
    //   208: aload_1
    //   209: invokevirtual 242	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   212: aastore
    //   213: invokestatic 244	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   216: goto -137 -> 79
    //   219: astore_1
    //   220: ldc 49
    //   222: aload_1
    //   223: ldc 96
    //   225: iconst_1
    //   226: anewarray 4	java/lang/Object
    //   229: dup
    //   230: iconst_0
    //   231: ldc 98
    //   233: aastore
    //   234: invokestatic 102	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   237: goto -82 -> 155
    //   240: astore_3
    //   241: aconst_null
    //   242: astore_2
    //   243: aload_2
    //   244: astore_1
    //   245: ldc 49
    //   247: aload_3
    //   248: ldc 162
    //   250: iconst_1
    //   251: anewarray 4	java/lang/Object
    //   254: dup
    //   255: iconst_0
    //   256: ldc 98
    //   258: aastore
    //   259: invokestatic 102	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   262: aload_2
    //   263: ifnull -108 -> 155
    //   266: aload_2
    //   267: invokevirtual 94	java/io/RandomAccessFile:close	()V
    //   270: goto -115 -> 155
    //   273: astore_1
    //   274: ldc 49
    //   276: aload_1
    //   277: ldc 96
    //   279: iconst_1
    //   280: anewarray 4	java/lang/Object
    //   283: dup
    //   284: iconst_0
    //   285: ldc 98
    //   287: aastore
    //   288: invokestatic 102	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   291: goto -136 -> 155
    //   294: astore_0
    //   295: aconst_null
    //   296: astore_1
    //   297: aload_1
    //   298: ifnull +7 -> 305
    //   301: aload_1
    //   302: invokevirtual 94	java/io/RandomAccessFile:close	()V
    //   305: sipush 15373
    //   308: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   311: aload_0
    //   312: athrow
    //   313: astore_1
    //   314: ldc 49
    //   316: aload_1
    //   317: ldc 96
    //   319: iconst_1
    //   320: anewarray 4	java/lang/Object
    //   323: dup
    //   324: iconst_0
    //   325: ldc 98
    //   327: aastore
    //   328: invokestatic 102	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   331: goto -26 -> 305
    //   334: astore_0
    //   335: goto -38 -> 297
    //   338: astore_3
    //   339: goto -96 -> 243
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	342	0	paramContext	android.content.Context
    //   14	112	1	localObject1	Object
    //   186	1	1	localNameNotFoundException	android.content.pm.PackageManager.NameNotFoundException
    //   197	12	1	localException1	java.lang.Exception
    //   219	4	1	localException2	java.lang.Exception
    //   244	1	1	localObject2	Object
    //   273	4	1	localException3	java.lang.Exception
    //   296	6	1	localObject3	Object
    //   313	4	1	localException4	java.lang.Exception
    //   123	144	2	localRandomAccessFile	java.io.RandomAccessFile
    //   240	8	3	localException5	java.lang.Exception
    //   338	1	3	localException6	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   15	34	186	android/content/pm/PackageManager$NameNotFoundException
    //   38	79	186	android/content/pm/PackageManager$NameNotFoundException
    //   15	34	197	java/lang/Exception
    //   38	79	197	java/lang/Exception
    //   151	155	219	java/lang/Exception
    //   111	124	240	java/lang/Exception
    //   266	270	273	java/lang/Exception
    //   111	124	294	finally
    //   301	305	313	java/lang/Exception
    //   126	151	334	finally
    //   245	262	334	finally
    //   126	151	338	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.d
 * JD-Core Version:    0.7.0.1
 */