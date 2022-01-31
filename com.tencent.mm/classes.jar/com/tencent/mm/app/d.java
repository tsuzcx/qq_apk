package com.tencent.mm.app;

import com.tencent.mm.storage.ac;
import java.io.File;

public final class d
{
  private static final String bwc = ac.dOP + "channel_history.cfg";
  
  /* Error */
  public static void aA(android.content.Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 42	com/tencent/mm/sdk/platformtools/e:fp	(Landroid/content/Context;)V
    //   4: aload_0
    //   5: invokevirtual 48	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   8: astore_1
    //   9: aload_1
    //   10: aload_0
    //   11: invokevirtual 51	android/content/Context:getPackageName	()Ljava/lang/String;
    //   14: iconst_0
    //   15: invokevirtual 57	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   18: getfield 63	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   21: getfield 68	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   24: invokestatic 74	com/tencent/mm/c/a:cc	(Ljava/lang/String;)Lcom/tencent/mm/c/a;
    //   27: astore_1
    //   28: aload_1
    //   29: ifnull +44 -> 73
    //   32: aload_1
    //   33: getfield 78	com/tencent/mm/c/a:bvg	Lcom/tencent/mm/c/b;
    //   36: ifnull +37 -> 73
    //   39: ldc 80
    //   41: ldc 82
    //   43: invokestatic 88	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: aload_1
    //   47: getfield 78	com/tencent/mm/c/a:bvg	Lcom/tencent/mm/c/b;
    //   50: getfield 94	com/tencent/mm/c/b:bvj	I
    //   53: ifeq +20 -> 73
    //   56: aload_1
    //   57: getfield 78	com/tencent/mm/c/a:bvg	Lcom/tencent/mm/c/b;
    //   60: getfield 94	com/tencent/mm/c/b:bvj	I
    //   63: putstatic 95	com/tencent/mm/sdk/platformtools/e:bvj	I
    //   66: ldc 80
    //   68: ldc 97
    //   70: invokestatic 88	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: ldc 80
    //   75: ldc 99
    //   77: iconst_2
    //   78: anewarray 4	java/lang/Object
    //   81: dup
    //   82: iconst_0
    //   83: getstatic 95	com/tencent/mm/sdk/platformtools/e:bvj	I
    //   86: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   89: aastore
    //   90: dup
    //   91: iconst_1
    //   92: invokestatic 110	com/tencent/mm/sdk/platformtools/ae:getProcessName	()Ljava/lang/String;
    //   95: aastore
    //   96: invokestatic 113	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   99: invokestatic 117	com/tencent/mm/app/d:sI	()Z
    //   102: ifne +47 -> 149
    //   105: new 119	java/io/RandomAccessFile
    //   108: dup
    //   109: getstatic 30	com/tencent/mm/app/d:bwc	Ljava/lang/String;
    //   112: ldc 121
    //   114: invokespecial 123	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   117: astore_2
    //   118: aload_2
    //   119: astore_1
    //   120: aload_2
    //   121: ldc 125
    //   123: iconst_1
    //   124: anewarray 4	java/lang/Object
    //   127: dup
    //   128: iconst_0
    //   129: getstatic 95	com/tencent/mm/sdk/platformtools/e:bvj	I
    //   132: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   135: aastore
    //   136: invokestatic 131	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   139: invokevirtual 135	java/lang/String:getBytes	()[B
    //   142: invokevirtual 139	java/io/RandomAccessFile:write	([B)V
    //   145: aload_2
    //   146: invokevirtual 142	java/io/RandomAccessFile:close	()V
    //   149: aload_0
    //   150: invokestatic 148	com/tencent/mm/booter/c:aS	(Landroid/content/Context;)Lcom/tencent/mm/booter/c;
    //   153: astore_0
    //   154: aload_0
    //   155: ifnull +18 -> 173
    //   158: aload_0
    //   159: getfield 151	com/tencent/mm/booter/c:dhC	I
    //   162: iconst_m1
    //   163: if_icmpeq +10 -> 173
    //   166: aload_0
    //   167: getfield 151	com/tencent/mm/booter/c:dhC	I
    //   170: putstatic 95	com/tencent/mm/sdk/platformtools/e:bvj	I
    //   173: return
    //   174: astore_1
    //   175: ldc 80
    //   177: ldc 153
    //   179: invokestatic 156	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   182: goto -109 -> 73
    //   185: astore_1
    //   186: ldc 80
    //   188: ldc 158
    //   190: iconst_1
    //   191: anewarray 4	java/lang/Object
    //   194: dup
    //   195: iconst_0
    //   196: aload_1
    //   197: invokevirtual 161	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   200: aastore
    //   201: invokestatic 163	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   204: goto -131 -> 73
    //   207: astore_1
    //   208: ldc 80
    //   210: aload_1
    //   211: ldc 165
    //   213: iconst_1
    //   214: anewarray 4	java/lang/Object
    //   217: dup
    //   218: iconst_0
    //   219: ldc 167
    //   221: aastore
    //   222: invokestatic 171	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   225: goto -76 -> 149
    //   228: astore_3
    //   229: aconst_null
    //   230: astore_2
    //   231: aload_2
    //   232: astore_1
    //   233: ldc 80
    //   235: aload_3
    //   236: ldc 173
    //   238: iconst_1
    //   239: anewarray 4	java/lang/Object
    //   242: dup
    //   243: iconst_0
    //   244: ldc 167
    //   246: aastore
    //   247: invokestatic 171	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   250: aload_2
    //   251: ifnull -102 -> 149
    //   254: aload_2
    //   255: invokevirtual 142	java/io/RandomAccessFile:close	()V
    //   258: goto -109 -> 149
    //   261: astore_1
    //   262: ldc 80
    //   264: aload_1
    //   265: ldc 165
    //   267: iconst_1
    //   268: anewarray 4	java/lang/Object
    //   271: dup
    //   272: iconst_0
    //   273: ldc 167
    //   275: aastore
    //   276: invokestatic 171	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   279: goto -130 -> 149
    //   282: astore_0
    //   283: aconst_null
    //   284: astore_1
    //   285: aload_1
    //   286: ifnull +7 -> 293
    //   289: aload_1
    //   290: invokevirtual 142	java/io/RandomAccessFile:close	()V
    //   293: aload_0
    //   294: athrow
    //   295: astore_1
    //   296: ldc 80
    //   298: aload_1
    //   299: ldc 165
    //   301: iconst_1
    //   302: anewarray 4	java/lang/Object
    //   305: dup
    //   306: iconst_0
    //   307: ldc 167
    //   309: aastore
    //   310: invokestatic 171	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   313: goto -20 -> 293
    //   316: astore_0
    //   317: goto -32 -> 285
    //   320: astore_3
    //   321: goto -90 -> 231
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	324	0	paramContext	android.content.Context
    //   8	112	1	localObject1	Object
    //   174	1	1	localNameNotFoundException	android.content.pm.PackageManager.NameNotFoundException
    //   185	12	1	localException1	java.lang.Exception
    //   207	4	1	localException2	java.lang.Exception
    //   232	1	1	localObject2	Object
    //   261	4	1	localException3	java.lang.Exception
    //   284	6	1	localObject3	Object
    //   295	4	1	localException4	java.lang.Exception
    //   117	138	2	localRandomAccessFile	java.io.RandomAccessFile
    //   228	8	3	localException5	java.lang.Exception
    //   320	1	3	localException6	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   9	28	174	android/content/pm/PackageManager$NameNotFoundException
    //   32	73	174	android/content/pm/PackageManager$NameNotFoundException
    //   9	28	185	java/lang/Exception
    //   32	73	185	java/lang/Exception
    //   145	149	207	java/lang/Exception
    //   105	118	228	java/lang/Exception
    //   254	258	261	java/lang/Exception
    //   105	118	282	finally
    //   289	293	295	java/lang/Exception
    //   120	145	316	finally
    //   233	250	316	finally
    //   120	145	320	java/lang/Exception
  }
  
  /* Error */
  public static void sH()
  {
    // Byte code:
    //   0: invokestatic 117	com/tencent/mm/app/d:sI	()Z
    //   3: ifne +11 -> 14
    //   6: ldc 80
    //   8: ldc 176
    //   10: invokestatic 179	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   13: return
    //   14: new 119	java/io/RandomAccessFile
    //   17: dup
    //   18: getstatic 30	com/tencent/mm/app/d:bwc	Ljava/lang/String;
    //   21: ldc 121
    //   23: invokespecial 123	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: astore 7
    //   28: aload 7
    //   30: astore 5
    //   32: aload 7
    //   34: invokevirtual 183	java/io/RandomAccessFile:length	()J
    //   37: lstore_3
    //   38: aload 7
    //   40: astore 5
    //   42: ldc 80
    //   44: ldc 185
    //   46: iconst_2
    //   47: anewarray 4	java/lang/Object
    //   50: dup
    //   51: iconst_0
    //   52: lload_3
    //   53: invokestatic 190	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   56: aastore
    //   57: dup
    //   58: iconst_1
    //   59: getstatic 95	com/tencent/mm/sdk/platformtools/e:bvj	I
    //   62: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   65: aastore
    //   66: invokestatic 113	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   69: lload_3
    //   70: lconst_0
    //   71: lcmp
    //   72: ifgt +41 -> 113
    //   75: aload 7
    //   77: astore 5
    //   79: ldc 80
    //   81: ldc 192
    //   83: invokestatic 179	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   86: aload 7
    //   88: invokevirtual 142	java/io/RandomAccessFile:close	()V
    //   91: return
    //   92: astore 5
    //   94: ldc 80
    //   96: aload 5
    //   98: ldc 165
    //   100: iconst_1
    //   101: anewarray 4	java/lang/Object
    //   104: dup
    //   105: iconst_0
    //   106: ldc 167
    //   108: aastore
    //   109: invokestatic 171	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   112: return
    //   113: aload 7
    //   115: astore 5
    //   117: aload 7
    //   119: invokevirtual 195	java/io/RandomAccessFile:readLine	()Ljava/lang/String;
    //   122: astore 9
    //   124: aload 7
    //   126: astore 5
    //   128: getstatic 95	com/tencent/mm/sdk/platformtools/e:bvj	I
    //   131: istore_2
    //   132: aload 7
    //   134: astore 5
    //   136: getstatic 95	com/tencent/mm/sdk/platformtools/e:bvj	I
    //   139: istore_0
    //   140: aload 7
    //   142: astore 5
    //   144: getstatic 95	com/tencent/mm/sdk/platformtools/e:bvj	I
    //   147: putstatic 198	com/tencent/mm/sdk/platformtools/e:ueh	I
    //   150: ldc 167
    //   152: astore 6
    //   154: aload 7
    //   156: astore 5
    //   158: aload 9
    //   160: invokestatic 204	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   163: ifne +103 -> 266
    //   166: aload 7
    //   168: astore 5
    //   170: new 10	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   177: ldc 167
    //   179: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: aload 9
    //   184: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: ldc 206
    //   189: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 28	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: astore 8
    //   197: aload 7
    //   199: astore 5
    //   201: aload 9
    //   203: iconst_0
    //   204: invokestatic 210	com/tencent/mm/sdk/platformtools/bk:getInt	(Ljava/lang/String;I)I
    //   207: istore_1
    //   208: aload 8
    //   210: astore 6
    //   212: iload_1
    //   213: istore_0
    //   214: aload 7
    //   216: astore 5
    //   218: iload_1
    //   219: getstatic 95	com/tencent/mm/sdk/platformtools/e:bvj	I
    //   222: if_icmpeq +44 -> 266
    //   225: aload 7
    //   227: astore 5
    //   229: iload_1
    //   230: putstatic 198	com/tencent/mm/sdk/platformtools/e:ueh	I
    //   233: aload 7
    //   235: astore 5
    //   237: ldc 80
    //   239: new 10	java/lang/StringBuilder
    //   242: dup
    //   243: ldc 212
    //   245: invokespecial 215	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   248: getstatic 95	com/tencent/mm/sdk/platformtools/e:bvj	I
    //   251: invokevirtual 218	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   254: invokevirtual 28	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: invokestatic 88	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   260: iload_1
    //   261: istore_0
    //   262: aload 8
    //   264: astore 6
    //   266: aload 7
    //   268: astore 5
    //   270: getstatic 222	com/tencent/mm/sdk/platformtools/ae:ufk	Z
    //   273: ifeq +163 -> 436
    //   276: aload 7
    //   278: astore 5
    //   280: aload 7
    //   282: invokevirtual 195	java/io/RandomAccessFile:readLine	()Ljava/lang/String;
    //   285: astore 8
    //   287: aload 7
    //   289: astore 5
    //   291: aload 8
    //   293: invokestatic 204	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   296: ifne +48 -> 344
    //   299: aload 7
    //   301: astore 5
    //   303: new 10	java/lang/StringBuilder
    //   306: dup
    //   307: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   310: aload 6
    //   312: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: aload 8
    //   317: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: ldc 206
    //   322: invokevirtual 22	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: invokevirtual 28	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: astore 6
    //   330: aload 7
    //   332: astore 5
    //   334: aload 8
    //   336: iconst_0
    //   337: invokestatic 210	com/tencent/mm/sdk/platformtools/bk:getInt	(Ljava/lang/String;I)I
    //   340: istore_0
    //   341: goto -65 -> 276
    //   344: aload 7
    //   346: astore 5
    //   348: ldc 80
    //   350: ldc 224
    //   352: iconst_1
    //   353: anewarray 4	java/lang/Object
    //   356: dup
    //   357: iconst_0
    //   358: aload 6
    //   360: aastore
    //   361: invokestatic 113	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   364: iload_0
    //   365: iload_2
    //   366: if_icmpeq +70 -> 436
    //   369: aload 7
    //   371: astore 5
    //   373: aload 7
    //   375: lload_3
    //   376: invokevirtual 228	java/io/RandomAccessFile:seek	(J)V
    //   379: aload 7
    //   381: astore 5
    //   383: aload 7
    //   385: ldc 125
    //   387: iconst_1
    //   388: anewarray 4	java/lang/Object
    //   391: dup
    //   392: iconst_0
    //   393: iload_2
    //   394: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   397: aastore
    //   398: invokestatic 131	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   401: invokevirtual 135	java/lang/String:getBytes	()[B
    //   404: invokevirtual 139	java/io/RandomAccessFile:write	([B)V
    //   407: aload 7
    //   409: astore 5
    //   411: ldc 80
    //   413: ldc 230
    //   415: iconst_2
    //   416: anewarray 4	java/lang/Object
    //   419: dup
    //   420: iconst_0
    //   421: iload_0
    //   422: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   425: aastore
    //   426: dup
    //   427: iconst_1
    //   428: iload_2
    //   429: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   432: aastore
    //   433: invokestatic 113	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   436: aload 7
    //   438: invokevirtual 142	java/io/RandomAccessFile:close	()V
    //   441: return
    //   442: astore 5
    //   444: ldc 80
    //   446: aload 5
    //   448: ldc 165
    //   450: iconst_1
    //   451: anewarray 4	java/lang/Object
    //   454: dup
    //   455: iconst_0
    //   456: ldc 167
    //   458: aastore
    //   459: invokestatic 171	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   462: return
    //   463: astore 8
    //   465: aconst_null
    //   466: astore 6
    //   468: aload 6
    //   470: astore 5
    //   472: ldc 80
    //   474: aload 8
    //   476: ldc 173
    //   478: iconst_1
    //   479: anewarray 4	java/lang/Object
    //   482: dup
    //   483: iconst_0
    //   484: ldc 167
    //   486: aastore
    //   487: invokestatic 171	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   490: aload 6
    //   492: ifnull -479 -> 13
    //   495: aload 6
    //   497: invokevirtual 142	java/io/RandomAccessFile:close	()V
    //   500: return
    //   501: astore 5
    //   503: ldc 80
    //   505: aload 5
    //   507: ldc 165
    //   509: iconst_1
    //   510: anewarray 4	java/lang/Object
    //   513: dup
    //   514: iconst_0
    //   515: ldc 167
    //   517: aastore
    //   518: invokestatic 171	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   521: return
    //   522: astore 6
    //   524: aconst_null
    //   525: astore 5
    //   527: aload 5
    //   529: ifnull +8 -> 537
    //   532: aload 5
    //   534: invokevirtual 142	java/io/RandomAccessFile:close	()V
    //   537: aload 6
    //   539: athrow
    //   540: astore 5
    //   542: ldc 80
    //   544: aload 5
    //   546: ldc 165
    //   548: iconst_1
    //   549: anewarray 4	java/lang/Object
    //   552: dup
    //   553: iconst_0
    //   554: ldc 167
    //   556: aastore
    //   557: invokestatic 171	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   560: goto -23 -> 537
    //   563: astore 6
    //   565: goto -38 -> 527
    //   568: astore 8
    //   570: aload 7
    //   572: astore 6
    //   574: goto -106 -> 468
    // Local variable table:
    //   start	length	slot	name	signature
    //   139	283	0	i	int
    //   207	54	1	j	int
    //   131	298	2	k	int
    //   37	339	3	l	long
    //   30	48	5	localRandomAccessFile1	java.io.RandomAccessFile
    //   92	5	5	localException1	java.lang.Exception
    //   115	295	5	localRandomAccessFile2	java.io.RandomAccessFile
    //   442	5	5	localException2	java.lang.Exception
    //   470	1	5	localObject1	Object
    //   501	5	5	localException3	java.lang.Exception
    //   525	8	5	localObject2	Object
    //   540	5	5	localException4	java.lang.Exception
    //   152	344	6	localObject3	Object
    //   522	16	6	localObject4	Object
    //   563	1	6	localObject5	Object
    //   572	1	6	localRandomAccessFile3	java.io.RandomAccessFile
    //   26	545	7	localRandomAccessFile4	java.io.RandomAccessFile
    //   195	140	8	str1	String
    //   463	12	8	localException5	java.lang.Exception
    //   568	1	8	localException6	java.lang.Exception
    //   122	80	9	str2	String
    // Exception table:
    //   from	to	target	type
    //   86	91	92	java/lang/Exception
    //   436	441	442	java/lang/Exception
    //   14	28	463	java/lang/Exception
    //   495	500	501	java/lang/Exception
    //   14	28	522	finally
    //   532	537	540	java/lang/Exception
    //   32	38	563	finally
    //   42	69	563	finally
    //   79	86	563	finally
    //   117	124	563	finally
    //   128	132	563	finally
    //   136	140	563	finally
    //   144	150	563	finally
    //   158	166	563	finally
    //   170	197	563	finally
    //   201	208	563	finally
    //   218	225	563	finally
    //   229	233	563	finally
    //   237	260	563	finally
    //   270	276	563	finally
    //   280	287	563	finally
    //   291	299	563	finally
    //   303	330	563	finally
    //   334	341	563	finally
    //   348	364	563	finally
    //   373	379	563	finally
    //   383	407	563	finally
    //   411	436	563	finally
    //   472	490	563	finally
    //   32	38	568	java/lang/Exception
    //   42	69	568	java/lang/Exception
    //   79	86	568	java/lang/Exception
    //   117	124	568	java/lang/Exception
    //   128	132	568	java/lang/Exception
    //   136	140	568	java/lang/Exception
    //   144	150	568	java/lang/Exception
    //   158	166	568	java/lang/Exception
    //   170	197	568	java/lang/Exception
    //   201	208	568	java/lang/Exception
    //   218	225	568	java/lang/Exception
    //   229	233	568	java/lang/Exception
    //   237	260	568	java/lang/Exception
    //   270	276	568	java/lang/Exception
    //   280	287	568	java/lang/Exception
    //   291	299	568	java/lang/Exception
    //   303	330	568	java/lang/Exception
    //   334	341	568	java/lang/Exception
    //   348	364	568	java/lang/Exception
    //   373	379	568	java/lang/Exception
    //   383	407	568	java/lang/Exception
    //   411	436	568	java/lang/Exception
  }
  
  private static boolean sI()
  {
    return new File(bwc).exists();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.d
 * JD-Core Version:    0.7.0.1
 */