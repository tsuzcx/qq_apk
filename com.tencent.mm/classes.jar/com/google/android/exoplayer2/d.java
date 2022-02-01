package com.google.android.exoplayer2;

import android.content.Context;
import com.google.android.exoplayer2.drm.b;

public final class d
  implements u
{
  private final b<com.google.android.exoplayer2.drm.d> aLu;
  private final int aLv;
  private final long aLw;
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
    this(paramContext, null);
  }
  
  private d(Context paramContext, b<com.google.android.exoplayer2.drm.d> paramb)
  {
    this.context = paramContext;
    this.aLu = null;
    this.aLv = 0;
    this.aLw = 5000L;
  }
  
  /* Error */
  public final r[] a(android.os.Handler paramHandler, com.google.android.exoplayer2.video.e parame, com.google.android.exoplayer2.a.e parame1, com.google.android.exoplayer2.f.j.a parama, com.google.android.exoplayer2.metadata.e.a parama1)
  {
    // Byte code:
    //   0: ldc 49
    //   2: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 57	java/util/ArrayList
    //   8: dup
    //   9: invokespecial 58	java/util/ArrayList:<init>	()V
    //   12: astore 11
    //   14: aload_0
    //   15: getfield 33	com/google/android/exoplayer2/d:context	Landroid/content/Context;
    //   18: astore 12
    //   20: aload_0
    //   21: getfield 35	com/google/android/exoplayer2/d:aLu	Lcom/google/android/exoplayer2/drm/b;
    //   24: astore 13
    //   26: aload_0
    //   27: getfield 41	com/google/android/exoplayer2/d:aLw	J
    //   30: lstore 9
    //   32: aload_0
    //   33: getfield 37	com/google/android/exoplayer2/d:aLv	I
    //   36: istore 7
    //   38: aload 11
    //   40: new 60	com/google/android/exoplayer2/video/c
    //   43: dup
    //   44: aload 12
    //   46: getstatic 66	com/google/android/exoplayer2/e/c:bdq	Lcom/google/android/exoplayer2/e/c;
    //   49: lload 9
    //   51: aload 13
    //   53: aload_1
    //   54: aload_2
    //   55: bipush 50
    //   57: invokespecial 69	com/google/android/exoplayer2/video/c:<init>	(Landroid/content/Context;Lcom/google/android/exoplayer2/e/c;JLcom/google/android/exoplayer2/drm/b;Landroid/os/Handler;Lcom/google/android/exoplayer2/video/e;I)V
    //   60: invokevirtual 73	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   63: pop
    //   64: iload 7
    //   66: ifeq +109 -> 175
    //   69: aload 11
    //   71: invokevirtual 77	java/util/ArrayList:size	()I
    //   74: istore 6
    //   76: iload 7
    //   78: iconst_2
    //   79: if_icmpne +535 -> 614
    //   82: iload 6
    //   84: iconst_1
    //   85: isub
    //   86: istore 6
    //   88: aload 11
    //   90: iload 6
    //   92: ldc 79
    //   94: invokestatic 85	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   97: iconst_5
    //   98: anewarray 81	java/lang/Class
    //   101: dup
    //   102: iconst_0
    //   103: getstatic 91	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   106: aastore
    //   107: dup
    //   108: iconst_1
    //   109: getstatic 94	java/lang/Long:TYPE	Ljava/lang/Class;
    //   112: aastore
    //   113: dup
    //   114: iconst_2
    //   115: ldc 96
    //   117: aastore
    //   118: dup
    //   119: iconst_3
    //   120: ldc 98
    //   122: aastore
    //   123: dup
    //   124: iconst_4
    //   125: getstatic 101	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   128: aastore
    //   129: invokevirtual 105	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   132: iconst_5
    //   133: anewarray 4	java/lang/Object
    //   136: dup
    //   137: iconst_0
    //   138: getstatic 109	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   141: aastore
    //   142: dup
    //   143: iconst_1
    //   144: lload 9
    //   146: invokestatic 113	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   149: aastore
    //   150: dup
    //   151: iconst_2
    //   152: aload_1
    //   153: aastore
    //   154: dup
    //   155: iconst_3
    //   156: aload_2
    //   157: aastore
    //   158: dup
    //   159: iconst_4
    //   160: bipush 50
    //   162: invokestatic 116	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   165: aastore
    //   166: invokevirtual 122	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   169: checkcast 124	com/google/android/exoplayer2/r
    //   172: invokevirtual 127	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   175: aload_0
    //   176: getfield 33	com/google/android/exoplayer2/d:context	Landroid/content/Context;
    //   179: astore 12
    //   181: aload_0
    //   182: getfield 35	com/google/android/exoplayer2/d:aLu	Lcom/google/android/exoplayer2/drm/b;
    //   185: astore 13
    //   187: iconst_0
    //   188: anewarray 129	com/google/android/exoplayer2/a/d
    //   191: astore_2
    //   192: aload_0
    //   193: getfield 37	com/google/android/exoplayer2/d:aLv	I
    //   196: istore 8
    //   198: aload 11
    //   200: new 131	com/google/android/exoplayer2/a/i
    //   203: dup
    //   204: getstatic 66	com/google/android/exoplayer2/e/c:bdq	Lcom/google/android/exoplayer2/e/c;
    //   207: aload 13
    //   209: aload_1
    //   210: aload_3
    //   211: aload 12
    //   213: invokestatic 137	com/google/android/exoplayer2/a/c:ab	(Landroid/content/Context;)Lcom/google/android/exoplayer2/a/c;
    //   216: aload_2
    //   217: invokespecial 140	com/google/android/exoplayer2/a/i:<init>	(Lcom/google/android/exoplayer2/e/c;Lcom/google/android/exoplayer2/drm/b;Landroid/os/Handler;Lcom/google/android/exoplayer2/a/e;Lcom/google/android/exoplayer2/a/c;[Lcom/google/android/exoplayer2/a/d;)V
    //   220: invokevirtual 73	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   223: pop
    //   224: iload 8
    //   226: ifeq +218 -> 444
    //   229: aload 11
    //   231: invokevirtual 77	java/util/ArrayList:size	()I
    //   234: istore 7
    //   236: iload 7
    //   238: istore 6
    //   240: iload 8
    //   242: iconst_2
    //   243: if_icmpne +9 -> 252
    //   246: iload 7
    //   248: iconst_1
    //   249: isub
    //   250: istore 6
    //   252: ldc 142
    //   254: invokestatic 85	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   257: iconst_3
    //   258: anewarray 81	java/lang/Class
    //   261: dup
    //   262: iconst_0
    //   263: ldc 96
    //   265: aastore
    //   266: dup
    //   267: iconst_1
    //   268: ldc 144
    //   270: aastore
    //   271: dup
    //   272: iconst_2
    //   273: ldc 146
    //   275: aastore
    //   276: invokevirtual 105	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   279: iconst_3
    //   280: anewarray 4	java/lang/Object
    //   283: dup
    //   284: iconst_0
    //   285: aload_1
    //   286: aastore
    //   287: dup
    //   288: iconst_1
    //   289: aload_3
    //   290: aastore
    //   291: dup
    //   292: iconst_2
    //   293: aload_2
    //   294: aastore
    //   295: invokevirtual 122	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   298: checkcast 124	com/google/android/exoplayer2/r
    //   301: astore 12
    //   303: iload 6
    //   305: iconst_1
    //   306: iadd
    //   307: istore 7
    //   309: aload 11
    //   311: iload 6
    //   313: aload 12
    //   315: invokevirtual 127	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   318: iload 7
    //   320: istore 6
    //   322: ldc 148
    //   324: invokestatic 85	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   327: iconst_3
    //   328: anewarray 81	java/lang/Class
    //   331: dup
    //   332: iconst_0
    //   333: ldc 96
    //   335: aastore
    //   336: dup
    //   337: iconst_1
    //   338: ldc 144
    //   340: aastore
    //   341: dup
    //   342: iconst_2
    //   343: ldc 146
    //   345: aastore
    //   346: invokevirtual 105	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   349: iconst_3
    //   350: anewarray 4	java/lang/Object
    //   353: dup
    //   354: iconst_0
    //   355: aload_1
    //   356: aastore
    //   357: dup
    //   358: iconst_1
    //   359: aload_3
    //   360: aastore
    //   361: dup
    //   362: iconst_2
    //   363: aload_2
    //   364: aastore
    //   365: invokevirtual 122	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   368: checkcast 124	com/google/android/exoplayer2/r
    //   371: astore 12
    //   373: iload 6
    //   375: iconst_1
    //   376: iadd
    //   377: istore 7
    //   379: aload 11
    //   381: iload 6
    //   383: aload 12
    //   385: invokevirtual 127	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   388: aload 11
    //   390: iload 7
    //   392: ldc 150
    //   394: invokestatic 85	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   397: iconst_3
    //   398: anewarray 81	java/lang/Class
    //   401: dup
    //   402: iconst_0
    //   403: ldc 96
    //   405: aastore
    //   406: dup
    //   407: iconst_1
    //   408: ldc 144
    //   410: aastore
    //   411: dup
    //   412: iconst_2
    //   413: ldc 146
    //   415: aastore
    //   416: invokevirtual 105	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   419: iconst_3
    //   420: anewarray 4	java/lang/Object
    //   423: dup
    //   424: iconst_0
    //   425: aload_1
    //   426: aastore
    //   427: dup
    //   428: iconst_1
    //   429: aload_3
    //   430: aastore
    //   431: dup
    //   432: iconst_2
    //   433: aload_2
    //   434: aastore
    //   435: invokevirtual 122	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   438: checkcast 124	com/google/android/exoplayer2/r
    //   441: invokevirtual 127	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   444: aload 11
    //   446: new 152	com/google/android/exoplayer2/f/j
    //   449: dup
    //   450: aload 4
    //   452: aload_1
    //   453: invokevirtual 156	android/os/Handler:getLooper	()Landroid/os/Looper;
    //   456: invokespecial 159	com/google/android/exoplayer2/f/j:<init>	(Lcom/google/android/exoplayer2/f/j$a;Landroid/os/Looper;)V
    //   459: invokevirtual 73	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   462: pop
    //   463: aload 11
    //   465: new 161	com/google/android/exoplayer2/metadata/e
    //   468: dup
    //   469: aload 5
    //   471: aload_1
    //   472: invokevirtual 156	android/os/Handler:getLooper	()Landroid/os/Looper;
    //   475: invokespecial 164	com/google/android/exoplayer2/metadata/e:<init>	(Lcom/google/android/exoplayer2/metadata/e$a;Landroid/os/Looper;)V
    //   478: invokevirtual 73	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   481: pop
    //   482: aload 11
    //   484: aload 11
    //   486: invokevirtual 77	java/util/ArrayList:size	()I
    //   489: anewarray 124	com/google/android/exoplayer2/r
    //   492: invokevirtual 168	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   495: checkcast 170	[Lcom/google/android/exoplayer2/r;
    //   498: astore_1
    //   499: ldc 49
    //   501: invokestatic 173	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   504: aload_1
    //   505: areturn
    //   506: astore_1
    //   507: new 175	java/lang/RuntimeException
    //   510: dup
    //   511: aload_1
    //   512: invokespecial 178	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   515: astore_1
    //   516: ldc 49
    //   518: invokestatic 173	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   521: aload_1
    //   522: athrow
    //   523: astore 12
    //   525: goto -203 -> 322
    //   528: astore_1
    //   529: new 175	java/lang/RuntimeException
    //   532: dup
    //   533: aload_1
    //   534: invokespecial 178	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   537: astore_1
    //   538: ldc 49
    //   540: invokestatic 173	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   543: aload_1
    //   544: athrow
    //   545: astore 12
    //   547: iload 6
    //   549: istore 7
    //   551: goto -163 -> 388
    //   554: astore_1
    //   555: new 175	java/lang/RuntimeException
    //   558: dup
    //   559: aload_1
    //   560: invokespecial 178	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   563: astore_1
    //   564: ldc 49
    //   566: invokestatic 173	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   569: aload_1
    //   570: athrow
    //   571: astore_1
    //   572: new 175	java/lang/RuntimeException
    //   575: dup
    //   576: aload_1
    //   577: invokespecial 178	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   580: astore_1
    //   581: ldc 49
    //   583: invokestatic 173	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   586: aload_1
    //   587: athrow
    //   588: astore_2
    //   589: goto -145 -> 444
    //   592: astore 12
    //   594: iload 7
    //   596: istore 6
    //   598: goto -51 -> 547
    //   601: astore 12
    //   603: iload 7
    //   605: istore 6
    //   607: goto -82 -> 525
    //   610: astore_2
    //   611: goto -436 -> 175
    //   614: goto -526 -> 88
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	617	0	this	d
    //   0	617	1	paramHandler	android.os.Handler
    //   0	617	2	parame	com.google.android.exoplayer2.video.e
    //   0	617	3	parame1	com.google.android.exoplayer2.a.e
    //   0	617	4	parama	com.google.android.exoplayer2.f.j.a
    //   0	617	5	parama1	com.google.android.exoplayer2.metadata.e.a
    //   74	532	6	i	int
    //   36	568	7	j	int
    //   196	48	8	k	int
    //   30	115	9	l	long
    //   12	473	11	localArrayList	java.util.ArrayList
    //   18	366	12	localObject	Object
    //   523	1	12	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   545	1	12	localClassNotFoundException2	java.lang.ClassNotFoundException
    //   592	1	12	localClassNotFoundException3	java.lang.ClassNotFoundException
    //   601	1	12	localClassNotFoundException4	java.lang.ClassNotFoundException
    //   24	184	13	localb	b
    // Exception table:
    //   from	to	target	type
    //   88	175	506	java/lang/Exception
    //   252	303	523	java/lang/ClassNotFoundException
    //   252	303	528	java/lang/Exception
    //   309	318	528	java/lang/Exception
    //   322	373	545	java/lang/ClassNotFoundException
    //   322	373	554	java/lang/Exception
    //   379	388	554	java/lang/Exception
    //   388	444	571	java/lang/Exception
    //   388	444	588	java/lang/ClassNotFoundException
    //   379	388	592	java/lang/ClassNotFoundException
    //   309	318	601	java/lang/ClassNotFoundException
    //   88	175	610	java/lang/ClassNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.d
 * JD-Core Version:    0.7.0.1
 */