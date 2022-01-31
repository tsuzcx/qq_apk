package com.google.android.exoplayer2;

import android.content.Context;
import com.google.android.exoplayer2.drm.b;

public final class d
  implements u
{
  private final b<com.google.android.exoplayer2.drm.d> asY;
  private final int asZ;
  private final long ata;
  private final Context context;
  
  public d(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private d(Context paramContext, byte paramByte)
  {
    this(paramContext, '\000');
  }
  
  private d(Context paramContext, char paramChar)
  {
    this(paramContext, (short)0);
  }
  
  private d(Context paramContext, short paramShort)
  {
    this.context = paramContext;
    this.asY = null;
    this.asZ = 0;
    this.ata = 5000L;
  }
  
  /* Error */
  public final r[] a(android.os.Handler paramHandler, com.google.android.exoplayer2.video.e parame, com.google.android.exoplayer2.a.e parame1, com.google.android.exoplayer2.f.j.a parama, com.google.android.exoplayer2.metadata.e.a parama1)
  {
    // Byte code:
    //   0: new 49	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 50	java/util/ArrayList:<init>	()V
    //   7: astore 11
    //   9: aload_0
    //   10: getfield 33	com/google/android/exoplayer2/d:context	Landroid/content/Context;
    //   13: astore 12
    //   15: aload_0
    //   16: getfield 35	com/google/android/exoplayer2/d:asY	Lcom/google/android/exoplayer2/drm/b;
    //   19: astore 13
    //   21: aload_0
    //   22: getfield 41	com/google/android/exoplayer2/d:ata	J
    //   25: lstore 9
    //   27: aload_0
    //   28: getfield 37	com/google/android/exoplayer2/d:asZ	I
    //   31: istore 7
    //   33: aload 11
    //   35: new 52	com/google/android/exoplayer2/video/c
    //   38: dup
    //   39: aload 12
    //   41: getstatic 58	com/google/android/exoplayer2/e/c:aGy	Lcom/google/android/exoplayer2/e/c;
    //   44: lload 9
    //   46: aload 13
    //   48: aload_1
    //   49: aload_2
    //   50: invokespecial 61	com/google/android/exoplayer2/video/c:<init>	(Landroid/content/Context;Lcom/google/android/exoplayer2/e/c;JLcom/google/android/exoplayer2/drm/b;Landroid/os/Handler;Lcom/google/android/exoplayer2/video/e;)V
    //   53: invokevirtual 65	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   56: pop
    //   57: iload 7
    //   59: ifeq +110 -> 169
    //   62: aload 11
    //   64: invokevirtual 69	java/util/ArrayList:size	()I
    //   67: istore 6
    //   69: iload 7
    //   71: iconst_2
    //   72: if_icmpne +501 -> 573
    //   75: iload 6
    //   77: iconst_1
    //   78: isub
    //   79: istore 6
    //   81: aload 11
    //   83: iload 6
    //   85: ldc 71
    //   87: invokestatic 77	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   90: iconst_5
    //   91: anewarray 73	java/lang/Class
    //   94: dup
    //   95: iconst_0
    //   96: getstatic 83	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   99: aastore
    //   100: dup
    //   101: iconst_1
    //   102: getstatic 86	java/lang/Long:TYPE	Ljava/lang/Class;
    //   105: aastore
    //   106: dup
    //   107: iconst_2
    //   108: ldc 88
    //   110: aastore
    //   111: dup
    //   112: iconst_3
    //   113: ldc 90
    //   115: aastore
    //   116: dup
    //   117: iconst_4
    //   118: getstatic 93	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   121: aastore
    //   122: invokevirtual 97	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   125: iconst_5
    //   126: anewarray 4	java/lang/Object
    //   129: dup
    //   130: iconst_0
    //   131: iconst_1
    //   132: invokestatic 101	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   135: aastore
    //   136: dup
    //   137: iconst_1
    //   138: lload 9
    //   140: invokestatic 104	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   143: aastore
    //   144: dup
    //   145: iconst_2
    //   146: aload_1
    //   147: aastore
    //   148: dup
    //   149: iconst_3
    //   150: aload_2
    //   151: aastore
    //   152: dup
    //   153: iconst_4
    //   154: bipush 50
    //   156: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   159: aastore
    //   160: invokevirtual 113	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   163: checkcast 115	com/google/android/exoplayer2/r
    //   166: invokevirtual 118	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   169: aload_0
    //   170: getfield 33	com/google/android/exoplayer2/d:context	Landroid/content/Context;
    //   173: astore 12
    //   175: aload_0
    //   176: getfield 35	com/google/android/exoplayer2/d:asY	Lcom/google/android/exoplayer2/drm/b;
    //   179: astore 13
    //   181: iconst_0
    //   182: anewarray 120	com/google/android/exoplayer2/a/d
    //   185: astore_2
    //   186: aload_0
    //   187: getfield 37	com/google/android/exoplayer2/d:asZ	I
    //   190: istore 8
    //   192: aload 11
    //   194: new 122	com/google/android/exoplayer2/a/i
    //   197: dup
    //   198: getstatic 58	com/google/android/exoplayer2/e/c:aGy	Lcom/google/android/exoplayer2/e/c;
    //   201: aload 13
    //   203: aload_1
    //   204: aload_3
    //   205: aload 12
    //   207: invokestatic 128	com/google/android/exoplayer2/a/c:Y	(Landroid/content/Context;)Lcom/google/android/exoplayer2/a/c;
    //   210: aload_2
    //   211: invokespecial 131	com/google/android/exoplayer2/a/i:<init>	(Lcom/google/android/exoplayer2/e/c;Lcom/google/android/exoplayer2/drm/b;Landroid/os/Handler;Lcom/google/android/exoplayer2/a/e;Lcom/google/android/exoplayer2/a/c;[Lcom/google/android/exoplayer2/a/d;)V
    //   214: invokevirtual 65	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   217: pop
    //   218: iload 8
    //   220: ifeq +218 -> 438
    //   223: aload 11
    //   225: invokevirtual 69	java/util/ArrayList:size	()I
    //   228: istore 7
    //   230: iload 7
    //   232: istore 6
    //   234: iload 8
    //   236: iconst_2
    //   237: if_icmpne +9 -> 246
    //   240: iload 7
    //   242: iconst_1
    //   243: isub
    //   244: istore 6
    //   246: ldc 133
    //   248: invokestatic 77	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   251: iconst_3
    //   252: anewarray 73	java/lang/Class
    //   255: dup
    //   256: iconst_0
    //   257: ldc 88
    //   259: aastore
    //   260: dup
    //   261: iconst_1
    //   262: ldc 135
    //   264: aastore
    //   265: dup
    //   266: iconst_2
    //   267: ldc 137
    //   269: aastore
    //   270: invokevirtual 97	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   273: iconst_3
    //   274: anewarray 4	java/lang/Object
    //   277: dup
    //   278: iconst_0
    //   279: aload_1
    //   280: aastore
    //   281: dup
    //   282: iconst_1
    //   283: aload_3
    //   284: aastore
    //   285: dup
    //   286: iconst_2
    //   287: aload_2
    //   288: aastore
    //   289: invokevirtual 113	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   292: checkcast 115	com/google/android/exoplayer2/r
    //   295: astore 12
    //   297: iload 6
    //   299: iconst_1
    //   300: iadd
    //   301: istore 7
    //   303: aload 11
    //   305: iload 6
    //   307: aload 12
    //   309: invokevirtual 118	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   312: iload 7
    //   314: istore 6
    //   316: ldc 139
    //   318: invokestatic 77	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   321: iconst_3
    //   322: anewarray 73	java/lang/Class
    //   325: dup
    //   326: iconst_0
    //   327: ldc 88
    //   329: aastore
    //   330: dup
    //   331: iconst_1
    //   332: ldc 135
    //   334: aastore
    //   335: dup
    //   336: iconst_2
    //   337: ldc 137
    //   339: aastore
    //   340: invokevirtual 97	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   343: iconst_3
    //   344: anewarray 4	java/lang/Object
    //   347: dup
    //   348: iconst_0
    //   349: aload_1
    //   350: aastore
    //   351: dup
    //   352: iconst_1
    //   353: aload_3
    //   354: aastore
    //   355: dup
    //   356: iconst_2
    //   357: aload_2
    //   358: aastore
    //   359: invokevirtual 113	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   362: checkcast 115	com/google/android/exoplayer2/r
    //   365: astore 12
    //   367: iload 6
    //   369: iconst_1
    //   370: iadd
    //   371: istore 7
    //   373: aload 11
    //   375: iload 6
    //   377: aload 12
    //   379: invokevirtual 118	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   382: aload 11
    //   384: iload 7
    //   386: ldc 141
    //   388: invokestatic 77	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   391: iconst_3
    //   392: anewarray 73	java/lang/Class
    //   395: dup
    //   396: iconst_0
    //   397: ldc 88
    //   399: aastore
    //   400: dup
    //   401: iconst_1
    //   402: ldc 135
    //   404: aastore
    //   405: dup
    //   406: iconst_2
    //   407: ldc 137
    //   409: aastore
    //   410: invokevirtual 97	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   413: iconst_3
    //   414: anewarray 4	java/lang/Object
    //   417: dup
    //   418: iconst_0
    //   419: aload_1
    //   420: aastore
    //   421: dup
    //   422: iconst_1
    //   423: aload_3
    //   424: aastore
    //   425: dup
    //   426: iconst_2
    //   427: aload_2
    //   428: aastore
    //   429: invokevirtual 113	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   432: checkcast 115	com/google/android/exoplayer2/r
    //   435: invokevirtual 118	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   438: aload 11
    //   440: new 143	com/google/android/exoplayer2/f/j
    //   443: dup
    //   444: aload 4
    //   446: aload_1
    //   447: invokevirtual 147	android/os/Handler:getLooper	()Landroid/os/Looper;
    //   450: invokespecial 150	com/google/android/exoplayer2/f/j:<init>	(Lcom/google/android/exoplayer2/f/j$a;Landroid/os/Looper;)V
    //   453: invokevirtual 65	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   456: pop
    //   457: aload 11
    //   459: new 152	com/google/android/exoplayer2/metadata/e
    //   462: dup
    //   463: aload 5
    //   465: aload_1
    //   466: invokevirtual 147	android/os/Handler:getLooper	()Landroid/os/Looper;
    //   469: invokespecial 155	com/google/android/exoplayer2/metadata/e:<init>	(Lcom/google/android/exoplayer2/metadata/e$a;Landroid/os/Looper;)V
    //   472: invokevirtual 65	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   475: pop
    //   476: aload 11
    //   478: aload 11
    //   480: invokevirtual 69	java/util/ArrayList:size	()I
    //   483: anewarray 115	com/google/android/exoplayer2/r
    //   486: invokevirtual 159	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   489: checkcast 161	[Lcom/google/android/exoplayer2/r;
    //   492: areturn
    //   493: astore_1
    //   494: new 163	java/lang/RuntimeException
    //   497: dup
    //   498: aload_1
    //   499: invokespecial 166	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   502: athrow
    //   503: astore 12
    //   505: goto -189 -> 316
    //   508: astore_1
    //   509: new 163	java/lang/RuntimeException
    //   512: dup
    //   513: aload_1
    //   514: invokespecial 166	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   517: athrow
    //   518: astore 12
    //   520: iload 6
    //   522: istore 7
    //   524: goto -142 -> 382
    //   527: astore_1
    //   528: new 163	java/lang/RuntimeException
    //   531: dup
    //   532: aload_1
    //   533: invokespecial 166	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   536: athrow
    //   537: astore_1
    //   538: new 163	java/lang/RuntimeException
    //   541: dup
    //   542: aload_1
    //   543: invokespecial 166	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   546: athrow
    //   547: astore_2
    //   548: goto -110 -> 438
    //   551: astore 12
    //   553: iload 7
    //   555: istore 6
    //   557: goto -37 -> 520
    //   560: astore 12
    //   562: iload 7
    //   564: istore 6
    //   566: goto -61 -> 505
    //   569: astore_2
    //   570: goto -401 -> 169
    //   573: goto -492 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	576	0	this	d
    //   0	576	1	paramHandler	android.os.Handler
    //   0	576	2	parame	com.google.android.exoplayer2.video.e
    //   0	576	3	parame1	com.google.android.exoplayer2.a.e
    //   0	576	4	parama	com.google.android.exoplayer2.f.j.a
    //   0	576	5	parama1	com.google.android.exoplayer2.metadata.e.a
    //   67	498	6	i	int
    //   31	532	7	j	int
    //   190	48	8	k	int
    //   25	114	9	l	long
    //   7	472	11	localArrayList	java.util.ArrayList
    //   13	365	12	localObject	Object
    //   503	1	12	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   518	1	12	localClassNotFoundException2	java.lang.ClassNotFoundException
    //   551	1	12	localClassNotFoundException3	java.lang.ClassNotFoundException
    //   560	1	12	localClassNotFoundException4	java.lang.ClassNotFoundException
    //   19	183	13	localb	b
    // Exception table:
    //   from	to	target	type
    //   81	169	493	java/lang/Exception
    //   246	297	503	java/lang/ClassNotFoundException
    //   246	297	508	java/lang/Exception
    //   303	312	508	java/lang/Exception
    //   316	367	518	java/lang/ClassNotFoundException
    //   316	367	527	java/lang/Exception
    //   373	382	527	java/lang/Exception
    //   382	438	537	java/lang/Exception
    //   382	438	547	java/lang/ClassNotFoundException
    //   373	382	551	java/lang/ClassNotFoundException
    //   303	312	560	java/lang/ClassNotFoundException
    //   81	169	569	java/lang/ClassNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.exoplayer2.d
 * JD-Core Version:    0.7.0.1
 */