package com.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

final class u$f
{
  private ArrayList<u.b> brH;
  private u.f.a[] brI;
  private int brJ;
  private float[][] brK;
  private float[][] brL;
  private float[][] brM;
  private int[] brN;
  private int brO;
  private int brP;
  private int brQ;
  
  private u$f(u paramu)
  {
    AppMethodBeat.i(55634);
    this.brH = new ArrayList();
    this.brI = new u.f.a[5];
    this.brJ = 0;
    this.brK = new float[][] { { (1.0F / -1.0F), (1.0F / 1.0F), 0.0F }, { (1.0F / -1.0F), (1.0F / 1.0F), 0.0F }, { (1.0F / -1.0F), (1.0F / 1.0F), 0.0F } };
    this.brL = new float[][] { { (1.0F / -1.0F), (1.0F / 1.0F), 0.0F }, { (1.0F / -1.0F), (1.0F / 1.0F), 0.0F }, { (1.0F / -1.0F), (1.0F / 1.0F), 0.0F } };
    this.brM = ((float[][])Array.newInstance(Float.TYPE, new int[] { 3, 3 }));
    this.brN = new int[6];
    this.brO = 5;
    this.brP = -1;
    this.brQ = 0;
    AppMethodBeat.o(55634);
  }
  
  /* Error */
  private void a(u.f.a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 91
    //   4: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 48	com/b/a/a/u$f:brI	[Lcom/b/a/a/u$f$a;
    //   11: iconst_1
    //   12: aload_0
    //   13: getfield 48	com/b/a/a/u$f:brI	[Lcom/b/a/a/u$f$a;
    //   16: iconst_0
    //   17: iconst_4
    //   18: invokestatic 97	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   21: aload_0
    //   22: getfield 48	com/b/a/a/u$f:brI	[Lcom/b/a/a/u$f$a;
    //   25: iconst_4
    //   26: aaload
    //   27: ifnull +143 -> 170
    //   30: invokestatic 103	android/os/SystemClock:elapsedRealtime	()J
    //   33: aload_1
    //   34: getfield 107	com/b/a/a/u$f$a:brV	J
    //   37: lsub
    //   38: ldc2_w 108
    //   41: lcmp
    //   42: ifle +128 -> 170
    //   45: aload_0
    //   46: getfield 48	com/b/a/a/u$f:brI	[Lcom/b/a/a/u$f$a;
    //   49: iconst_4
    //   50: aaload
    //   51: astore_2
    //   52: aload_2
    //   53: aload_2
    //   54: getfield 113	com/b/a/a/u$f$a:x	F
    //   57: aload_1
    //   58: getfield 113	com/b/a/a/u$f$a:x	F
    //   61: fadd
    //   62: fconst_2
    //   63: fdiv
    //   64: putfield 113	com/b/a/a/u$f$a:x	F
    //   67: aload_2
    //   68: aload_2
    //   69: getfield 116	com/b/a/a/u$f$a:y	F
    //   72: aload_1
    //   73: getfield 116	com/b/a/a/u$f$a:y	F
    //   76: fadd
    //   77: fconst_2
    //   78: fdiv
    //   79: putfield 116	com/b/a/a/u$f$a:y	F
    //   82: aload_2
    //   83: aload_2
    //   84: getfield 119	com/b/a/a/u$f$a:z	F
    //   87: aload_1
    //   88: getfield 119	com/b/a/a/u$f$a:z	F
    //   91: fadd
    //   92: fconst_2
    //   93: fdiv
    //   94: putfield 119	com/b/a/a/u$f$a:z	F
    //   97: aload_2
    //   98: aload_2
    //   99: getfield 122	com/b/a/a/u$f$a:brR	I
    //   102: aload_1
    //   103: getfield 122	com/b/a/a/u$f$a:brR	I
    //   106: iadd
    //   107: i2f
    //   108: fconst_2
    //   109: fdiv
    //   110: invokestatic 128	java/lang/Math:round	(F)I
    //   113: putfield 122	com/b/a/a/u$f$a:brR	I
    //   116: aload_2
    //   117: aload_2
    //   118: getfield 131	com/b/a/a/u$f$a:brS	F
    //   121: aload_1
    //   122: getfield 131	com/b/a/a/u$f$a:brS	F
    //   125: fadd
    //   126: fconst_2
    //   127: fdiv
    //   128: putfield 131	com/b/a/a/u$f$a:brS	F
    //   131: aload_2
    //   132: aload_2
    //   133: getfield 134	com/b/a/a/u$f$a:brT	F
    //   136: aload_1
    //   137: getfield 134	com/b/a/a/u$f$a:brT	F
    //   140: fadd
    //   141: fconst_2
    //   142: fdiv
    //   143: putfield 134	com/b/a/a/u$f$a:brT	F
    //   146: aload_2
    //   147: aload_1
    //   148: getfield 107	com/b/a/a/u$f$a:brV	J
    //   151: putfield 107	com/b/a/a/u$f$a:brV	J
    //   154: aload_2
    //   155: aload_1
    //   156: getfield 137	com/b/a/a/u$f$a:brU	F
    //   159: putfield 137	com/b/a/a/u$f$a:brU	F
    //   162: ldc 91
    //   164: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   167: aload_0
    //   168: monitorexit
    //   169: return
    //   170: aload_0
    //   171: getfield 48	com/b/a/a/u$f:brI	[Lcom/b/a/a/u$f$a;
    //   174: iconst_4
    //   175: aload_1
    //   176: aastore
    //   177: ldc 91
    //   179: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   182: goto -15 -> 167
    //   185: astore_1
    //   186: aload_0
    //   187: monitorexit
    //   188: aload_1
    //   189: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	this	f
    //   0	190	1	parama	u.f.a
    //   51	104	2	locala	u.f.a
    // Exception table:
    //   from	to	target	type
    //   2	167	185	finally
    //   170	182	185	finally
  }
  
  /* Error */
  private boolean tG()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 140
    //   4: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 50	com/b/a/a/u$f:brJ	I
    //   11: bipush 20
    //   13: if_icmplt +704 -> 717
    //   16: aload_0
    //   17: getfield 56	com/b/a/a/u$f:brK	[[F
    //   20: iconst_0
    //   21: aaload
    //   22: astore 17
    //   24: aload 17
    //   26: iconst_2
    //   27: aload 17
    //   29: iconst_2
    //   30: faload
    //   31: ldc 141
    //   33: fdiv
    //   34: fastore
    //   35: aload_0
    //   36: getfield 56	com/b/a/a/u$f:brK	[[F
    //   39: iconst_1
    //   40: aaload
    //   41: astore 17
    //   43: aload 17
    //   45: iconst_2
    //   46: aload 17
    //   48: iconst_2
    //   49: faload
    //   50: ldc 141
    //   52: fdiv
    //   53: fastore
    //   54: aload_0
    //   55: getfield 56	com/b/a/a/u$f:brK	[[F
    //   58: iconst_2
    //   59: aaload
    //   60: astore 17
    //   62: aload 17
    //   64: iconst_2
    //   65: aload 17
    //   67: iconst_2
    //   68: faload
    //   69: ldc 141
    //   71: fdiv
    //   72: fastore
    //   73: aload_0
    //   74: getfield 58	com/b/a/a/u$f:brL	[[F
    //   77: iconst_0
    //   78: aaload
    //   79: astore 17
    //   81: aload 17
    //   83: iconst_2
    //   84: aload 17
    //   86: iconst_2
    //   87: faload
    //   88: ldc 141
    //   90: fdiv
    //   91: fastore
    //   92: aload_0
    //   93: getfield 58	com/b/a/a/u$f:brL	[[F
    //   96: iconst_1
    //   97: aaload
    //   98: astore 17
    //   100: aload 17
    //   102: iconst_2
    //   103: aload 17
    //   105: iconst_2
    //   106: faload
    //   107: ldc 141
    //   109: fdiv
    //   110: fastore
    //   111: aload_0
    //   112: getfield 58	com/b/a/a/u$f:brL	[[F
    //   115: iconst_2
    //   116: aaload
    //   117: astore 17
    //   119: aload 17
    //   121: iconst_2
    //   122: aload 17
    //   124: iconst_2
    //   125: faload
    //   126: ldc 141
    //   128: fdiv
    //   129: fastore
    //   130: aload_0
    //   131: getfield 58	com/b/a/a/u$f:brL	[[F
    //   134: iconst_0
    //   135: aaload
    //   136: iconst_2
    //   137: faload
    //   138: fstore_1
    //   139: aload_0
    //   140: getfield 56	com/b/a/a/u$f:brK	[[F
    //   143: iconst_0
    //   144: aaload
    //   145: iconst_0
    //   146: faload
    //   147: fstore_2
    //   148: aload_0
    //   149: getfield 56	com/b/a/a/u$f:brK	[[F
    //   152: iconst_0
    //   153: aaload
    //   154: iconst_2
    //   155: faload
    //   156: fstore_3
    //   157: aload_0
    //   158: getfield 56	com/b/a/a/u$f:brK	[[F
    //   161: iconst_0
    //   162: aaload
    //   163: iconst_2
    //   164: faload
    //   165: fstore 4
    //   167: aload_0
    //   168: getfield 56	com/b/a/a/u$f:brK	[[F
    //   171: iconst_0
    //   172: aaload
    //   173: iconst_1
    //   174: faload
    //   175: fstore 5
    //   177: aload_0
    //   178: getfield 58	com/b/a/a/u$f:brL	[[F
    //   181: iconst_1
    //   182: aaload
    //   183: iconst_2
    //   184: faload
    //   185: fstore 6
    //   187: aload_0
    //   188: getfield 56	com/b/a/a/u$f:brK	[[F
    //   191: iconst_1
    //   192: aaload
    //   193: iconst_0
    //   194: faload
    //   195: fstore 7
    //   197: aload_0
    //   198: getfield 56	com/b/a/a/u$f:brK	[[F
    //   201: iconst_1
    //   202: aaload
    //   203: iconst_2
    //   204: faload
    //   205: fstore 8
    //   207: aload_0
    //   208: getfield 56	com/b/a/a/u$f:brK	[[F
    //   211: iconst_1
    //   212: aaload
    //   213: iconst_2
    //   214: faload
    //   215: fstore 9
    //   217: aload_0
    //   218: getfield 56	com/b/a/a/u$f:brK	[[F
    //   221: iconst_1
    //   222: aaload
    //   223: iconst_1
    //   224: faload
    //   225: fstore 10
    //   227: aload_0
    //   228: getfield 58	com/b/a/a/u$f:brL	[[F
    //   231: iconst_2
    //   232: aaload
    //   233: iconst_2
    //   234: faload
    //   235: fstore 11
    //   237: aload_0
    //   238: getfield 56	com/b/a/a/u$f:brK	[[F
    //   241: iconst_2
    //   242: aaload
    //   243: iconst_0
    //   244: faload
    //   245: fstore 12
    //   247: aload_0
    //   248: getfield 56	com/b/a/a/u$f:brK	[[F
    //   251: iconst_2
    //   252: aaload
    //   253: iconst_2
    //   254: faload
    //   255: fstore 13
    //   257: aload_0
    //   258: getfield 56	com/b/a/a/u$f:brK	[[F
    //   261: iconst_2
    //   262: aaload
    //   263: iconst_2
    //   264: faload
    //   265: fstore 14
    //   267: aload_0
    //   268: getfield 56	com/b/a/a/u$f:brK	[[F
    //   271: iconst_2
    //   272: aaload
    //   273: iconst_1
    //   274: faload
    //   275: fstore 15
    //   277: aload_0
    //   278: getfield 73	com/b/a/a/u$f:brM	[[F
    //   281: iconst_0
    //   282: aaload
    //   283: iconst_0
    //   284: fload_1
    //   285: ldc 142
    //   287: fmul
    //   288: ldc 143
    //   290: aload_0
    //   291: getfield 73	com/b/a/a/u$f:brM	[[F
    //   294: iconst_0
    //   295: aaload
    //   296: iconst_0
    //   297: faload
    //   298: fmul
    //   299: fadd
    //   300: fastore
    //   301: aload_0
    //   302: getfield 73	com/b/a/a/u$f:brM	[[F
    //   305: iconst_0
    //   306: aaload
    //   307: iconst_1
    //   308: fload_2
    //   309: fload_3
    //   310: fsub
    //   311: ldc 142
    //   313: fmul
    //   314: ldc 143
    //   316: aload_0
    //   317: getfield 73	com/b/a/a/u$f:brM	[[F
    //   320: iconst_0
    //   321: aaload
    //   322: iconst_1
    //   323: faload
    //   324: fmul
    //   325: fadd
    //   326: fastore
    //   327: aload_0
    //   328: getfield 73	com/b/a/a/u$f:brM	[[F
    //   331: iconst_0
    //   332: aaload
    //   333: iconst_2
    //   334: fload 4
    //   336: fload 5
    //   338: fsub
    //   339: ldc 142
    //   341: fmul
    //   342: ldc 143
    //   344: aload_0
    //   345: getfield 73	com/b/a/a/u$f:brM	[[F
    //   348: iconst_0
    //   349: aaload
    //   350: iconst_2
    //   351: faload
    //   352: fmul
    //   353: fadd
    //   354: fastore
    //   355: aload_0
    //   356: getfield 73	com/b/a/a/u$f:brM	[[F
    //   359: iconst_1
    //   360: aaload
    //   361: iconst_0
    //   362: ldc 143
    //   364: aload_0
    //   365: getfield 73	com/b/a/a/u$f:brM	[[F
    //   368: iconst_1
    //   369: aaload
    //   370: iconst_0
    //   371: faload
    //   372: fmul
    //   373: fload 6
    //   375: ldc 142
    //   377: fmul
    //   378: fadd
    //   379: fastore
    //   380: aload_0
    //   381: getfield 73	com/b/a/a/u$f:brM	[[F
    //   384: iconst_1
    //   385: aaload
    //   386: iconst_1
    //   387: ldc 143
    //   389: aload_0
    //   390: getfield 73	com/b/a/a/u$f:brM	[[F
    //   393: iconst_1
    //   394: aaload
    //   395: iconst_1
    //   396: faload
    //   397: fmul
    //   398: ldc 142
    //   400: fload 7
    //   402: fload 8
    //   404: fsub
    //   405: fmul
    //   406: fadd
    //   407: fastore
    //   408: aload_0
    //   409: getfield 73	com/b/a/a/u$f:brM	[[F
    //   412: iconst_1
    //   413: aaload
    //   414: iconst_2
    //   415: ldc 143
    //   417: aload_0
    //   418: getfield 73	com/b/a/a/u$f:brM	[[F
    //   421: iconst_1
    //   422: aaload
    //   423: iconst_2
    //   424: faload
    //   425: fmul
    //   426: ldc 142
    //   428: fload 9
    //   430: fload 10
    //   432: fsub
    //   433: fmul
    //   434: fadd
    //   435: fastore
    //   436: aload_0
    //   437: getfield 73	com/b/a/a/u$f:brM	[[F
    //   440: iconst_2
    //   441: aaload
    //   442: iconst_0
    //   443: ldc 143
    //   445: aload_0
    //   446: getfield 73	com/b/a/a/u$f:brM	[[F
    //   449: iconst_2
    //   450: aaload
    //   451: iconst_0
    //   452: faload
    //   453: fmul
    //   454: ldc 142
    //   456: fload 11
    //   458: fmul
    //   459: fadd
    //   460: fastore
    //   461: aload_0
    //   462: getfield 73	com/b/a/a/u$f:brM	[[F
    //   465: iconst_2
    //   466: aaload
    //   467: iconst_1
    //   468: ldc 143
    //   470: aload_0
    //   471: getfield 73	com/b/a/a/u$f:brM	[[F
    //   474: iconst_2
    //   475: aaload
    //   476: iconst_1
    //   477: faload
    //   478: fmul
    //   479: ldc 142
    //   481: fload 12
    //   483: fload 13
    //   485: fsub
    //   486: fmul
    //   487: fadd
    //   488: fastore
    //   489: aload_0
    //   490: getfield 73	com/b/a/a/u$f:brM	[[F
    //   493: iconst_2
    //   494: aaload
    //   495: iconst_2
    //   496: ldc 143
    //   498: aload_0
    //   499: getfield 73	com/b/a/a/u$f:brM	[[F
    //   502: iconst_2
    //   503: aaload
    //   504: iconst_2
    //   505: faload
    //   506: fmul
    //   507: ldc 142
    //   509: fload 14
    //   511: fload 15
    //   513: fsub
    //   514: fmul
    //   515: fadd
    //   516: fastore
    //   517: aload_0
    //   518: aload_0
    //   519: invokespecial 147	com/b/a/a/u$f:tH	()Lcom/b/a/a/u$f$a;
    //   522: invokespecial 149	com/b/a/a/u$f:a	(Lcom/b/a/a/u$f$a;)V
    //   525: aload_0
    //   526: iconst_0
    //   527: putfield 50	com/b/a/a/u$f:brJ	I
    //   530: iconst_3
    //   531: newarray float
    //   533: dup
    //   534: iconst_0
    //   535: ldc 53
    //   537: fastore
    //   538: dup
    //   539: iconst_1
    //   540: ldc 54
    //   542: fastore
    //   543: dup
    //   544: iconst_2
    //   545: fconst_0
    //   546: fastore
    //   547: astore 17
    //   549: aload_0
    //   550: iconst_3
    //   551: anewarray 52	[F
    //   554: dup
    //   555: iconst_0
    //   556: iconst_3
    //   557: newarray float
    //   559: dup
    //   560: iconst_0
    //   561: ldc 53
    //   563: fastore
    //   564: dup
    //   565: iconst_1
    //   566: ldc 54
    //   568: fastore
    //   569: dup
    //   570: iconst_2
    //   571: fconst_0
    //   572: fastore
    //   573: aastore
    //   574: dup
    //   575: iconst_1
    //   576: iconst_3
    //   577: newarray float
    //   579: dup
    //   580: iconst_0
    //   581: ldc 53
    //   583: fastore
    //   584: dup
    //   585: iconst_1
    //   586: ldc 54
    //   588: fastore
    //   589: dup
    //   590: iconst_2
    //   591: fconst_0
    //   592: fastore
    //   593: aastore
    //   594: dup
    //   595: iconst_2
    //   596: aload 17
    //   598: aastore
    //   599: putfield 56	com/b/a/a/u$f:brK	[[F
    //   602: aload_0
    //   603: iconst_3
    //   604: anewarray 52	[F
    //   607: dup
    //   608: iconst_0
    //   609: iconst_3
    //   610: newarray float
    //   612: dup
    //   613: iconst_0
    //   614: ldc 53
    //   616: fastore
    //   617: dup
    //   618: iconst_1
    //   619: ldc 54
    //   621: fastore
    //   622: dup
    //   623: iconst_2
    //   624: fconst_0
    //   625: fastore
    //   626: aastore
    //   627: dup
    //   628: iconst_1
    //   629: iconst_3
    //   630: newarray float
    //   632: dup
    //   633: iconst_0
    //   634: ldc 53
    //   636: fastore
    //   637: dup
    //   638: iconst_1
    //   639: ldc 54
    //   641: fastore
    //   642: dup
    //   643: iconst_2
    //   644: fconst_0
    //   645: fastore
    //   646: aastore
    //   647: dup
    //   648: iconst_2
    //   649: iconst_3
    //   650: newarray float
    //   652: dup
    //   653: iconst_0
    //   654: ldc 53
    //   656: fastore
    //   657: dup
    //   658: iconst_1
    //   659: ldc 54
    //   661: fastore
    //   662: dup
    //   663: iconst_2
    //   664: fconst_0
    //   665: fastore
    //   666: aastore
    //   667: putfield 58	com/b/a/a/u$f:brL	[[F
    //   670: aload_0
    //   671: getfield 46	com/b/a/a/u$f:brH	Ljava/util/ArrayList;
    //   674: invokevirtual 153	java/util/ArrayList:size	()I
    //   677: bipush 100
    //   679: if_icmplt +25 -> 704
    //   682: aload_0
    //   683: getfield 46	com/b/a/a/u$f:brH	Ljava/util/ArrayList;
    //   686: iconst_0
    //   687: bipush 20
    //   689: invokevirtual 157	java/util/ArrayList:subList	(II)Ljava/util/List;
    //   692: invokeinterface 162 1 0
    //   697: aload_0
    //   698: getfield 46	com/b/a/a/u$f:brH	Ljava/util/ArrayList;
    //   701: invokevirtual 165	java/util/ArrayList:trimToSize	()V
    //   704: iconst_1
    //   705: istore 16
    //   707: ldc 140
    //   709: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   712: aload_0
    //   713: monitorexit
    //   714: iload 16
    //   716: ireturn
    //   717: iconst_0
    //   718: istore 16
    //   720: ldc 140
    //   722: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   725: goto -13 -> 712
    //   728: astore 17
    //   730: aload_0
    //   731: monitorexit
    //   732: aload 17
    //   734: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	735	0	this	f
    //   138	147	1	f1	float
    //   147	162	2	f2	float
    //   156	154	3	f3	float
    //   165	170	4	f4	float
    //   175	162	5	f5	float
    //   185	189	6	f6	float
    //   195	206	7	f7	float
    //   205	198	8	f8	float
    //   215	214	9	f9	float
    //   225	206	10	f10	float
    //   235	222	11	f11	float
    //   245	237	12	f12	float
    //   255	229	13	f13	float
    //   265	245	14	f14	float
    //   275	237	15	f15	float
    //   705	14	16	bool	boolean
    //   22	575	17	arrayOfFloat	float[]
    //   728	5	17	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	704	728	finally
    //   707	712	728	finally
    //   720	725	728	finally
  }
  
  private u.f.a tH()
  {
    int i2;
    int j;
    u.f.a locala;
    int k;
    Object localObject5;
    Object localObject7;
    float f1;
    float f2;
    float f6;
    float f4;
    float f10;
    label385:
    float f8;
    float f9;
    label407:
    label432:
    Object localObject1;
    label836:
    int n;
    label919:
    int m;
    label960:
    int i1;
    label1001:
    float f12;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(55637);
        if (this.brQ == 0)
        {
          i2 = 1;
          if (i2 == 0) {
            continue;
          }
          if (Math.abs(this.brM[2][0]) < 9.300000000000001D)
          {
            i = 5;
            this.brO = i;
            this.brN = new int[6];
            j = 0;
            if ((this.brP >= 0) && (this.brP <= 5)) {
              this.brO = this.brP;
            }
            localObject3 = new u.f.a(this, (byte)0);
            locala = new u.f.a(this, (byte)0);
            if (this.brI[0] != null)
            {
              ((u.f.a)localObject3).brV = this.brI[0].brV;
              ((u.f.a)localObject3).brS = this.brI[0].brS;
            }
            if (this.brI[4] != null)
            {
              locala.brV = this.brI[4].brV;
              locala.brS = this.brI[4].brS;
            }
            if (!this.brH.isEmpty())
            {
              k = this.brH.size();
              localObject5 = new float[6];
              localObject6 = new float[6];
              localObject7 = this.brH.iterator();
              f1 = 0.0F;
              f2 = 0.0F;
              if (((Iterator)localObject7).hasNext()) {
                continue;
              }
              f6 = f2 / k;
              f4 = f1 / k;
              if (j != 0) {
                break label1213;
              }
              f11 = f6;
              localObject7 = new float[6];
              localObject7[0] = ((float)Math.atan2(localObject5[0], localObject6[0]));
              localObject7[1] = ((float)Math.atan2(localObject5[1], localObject6[1]));
              localObject7[2] = ((float)Math.atan2(localObject5[2], localObject6[2]));
              localObject7[3] = ((float)Math.atan2(localObject5[3], localObject6[3]));
              localObject7[4] = ((float)Math.atan2(localObject5[4], localObject6[4]));
              localObject7[5] = ((float)Math.atan2(localObject5[5], localObject6[5]));
              if (j != 0) {
                break label1220;
              }
              f10 = f6;
              break label1735;
              localObject5 = this.brH.iterator();
              f2 = f4;
              f8 = 0.0F;
              f9 = 0.0F;
              i = 0;
              if (((Iterator)localObject5).hasNext()) {
                break;
              }
              if (((u.f.a)localObject3).brR > 0)
              {
                if (j != 0) {
                  break label1716;
                }
                f1 = 0.0F;
                f2 = localObject1 / ((u.f.a)localObject3).brR;
                f3 = ((u.f.a)localObject3).brS;
                f2 = f1 + ((f2 - f11) / 15.0F + 0.537F);
                f1 = f2;
                if (f3 != 0.0F) {
                  f1 = f2 * 0.67F + 0.33F * f3;
                }
                ((u.f.a)localObject3).brS = f1;
                ((u.f.a)localObject3).x *= ((u.f.a)localObject3).brS;
                ((u.f.a)localObject3).y *= ((u.f.a)localObject3).brS;
                ((u.f.a)localObject3).brT = (((u.f.a)localObject3).brR * ((u.f.a)localObject3).brS);
              }
            }
            ((u.f.a)localObject3).brU = (((u.f.a)localObject3).brT / (this.brH.size() / 20));
            if (this.brI[0] != null)
            {
              ((u.f.a)localObject3).x += this.brI[0].x;
              ((u.f.a)localObject3).y += this.brI[0].y;
              ((u.f.a)localObject3).z += this.brI[0].z;
              ((u.f.a)localObject3).brR += this.brI[0].brR;
              ((u.f.a)localObject3).brT += this.brI[0].brT;
            }
            if ((this.brI[4] != null) && (locala.brR > 0))
            {
              this.brI[4].x = ((this.brI[4].x + ((u.f.a)localObject3).x + locala.x * ((u.f.a)localObject3).brS) / 2.0F);
              this.brI[4].y = ((this.brI[4].y + ((u.f.a)localObject3).y + locala.y * ((u.f.a)localObject3).brS) / 2.0F);
            }
            AppMethodBeat.o(55637);
            return localObject3;
          }
        }
        else
        {
          i2 = 0;
          continue;
        }
        i = 2;
        continue;
        if (Math.abs(this.brM[0][0]) < 7.0F) {
          break label1764;
        }
        if (this.brM[1][1] >= 2.3F) {
          break label1758;
        }
        if (this.brM[1][2] < 2.3F) {
          break label1764;
        }
        break label1758;
        if (i != 0)
        {
          this.brO = 2;
          this.brN = new int[6];
          j = i;
          continue;
        }
        f1 = Math.abs(this.brM[0][0]);
        f2 = Math.abs(this.brM[1][0]);
        f3 = Math.abs(this.brM[2][0]);
        if (f1 <= f2) {
          break label1803;
        }
        if (f1 <= f3) {
          break label1797;
        }
        j = 0;
        break label1770;
        if (k < 3) {
          break label1823;
        }
        j = n * 2 + m - 1;
        Object localObject3 = this.brN;
        localObject3[j] += 1;
        j = 0;
        break label1784;
        f2 = f1;
        if (this.brM[k][n] <= f1) {
          break label1885;
        }
        f2 = this.brM[k][n];
        m = n;
        i1 = k;
        break label1885;
        if ((j == this.brO) || (this.brN[j] <= this.brN[this.brO])) {
          break label1897;
        }
        this.brO = j;
        break label1897;
        u.b localb = (u.b)((Iterator)localObject7).next();
        if (j == 0)
        {
          f3 = localb.brg;
          f3 = f2 + f3;
          if (j == 0)
          {
            f2 = localb.bro;
            break label1906;
            label1084:
            f1 = f4;
            f2 = f3;
            if (i > 5) {
              continue;
            }
            localObject5[i] += localb.brs[i];
            localObject6[i] += localb.brt[i];
            i += 1;
            continue;
          }
        }
        else
        {
          f3 = localb.brj;
          continue;
        }
        f2 = (float)Math.sqrt(localb.brh * localb.brh + localb.bri * localb.bri + localb.brj * localb.brj);
        localb.brn = f2;
      }
      finally {}
      label1213:
      float f11 = f4;
      continue;
      label1220:
      f10 = f4;
      break label1735;
      label1227:
      f1 = 1.0F;
      break label1746;
      label1232:
      f12 = 0.261799F;
    }
    Object localObject6 = (u.b)((Iterator)localObject5).next();
    if (j == 0) {}
    label1278:
    Object localObject2;
    for (float f3 = ((u.b)localObject6).brg;; f3 = ((u.b)localObject6).brn)
    {
      if (j != 0) {
        break label1328;
      }
      f5 = ((u.b)localObject6).bro;
      break label1918;
      if (i > 0) {
        break label1338;
      }
      if (f3 > localObject2) {
        break label1937;
      }
      f9 = localObject6.brs[this.brO];
      f8 = localObject6.brt[this.brO];
      break;
    }
    label1328:
    float f5 = ((u.b)localObject6).brn;
    break label1918;
    label1338:
    if (f10 < f3) {
      if (i2 == 0)
      {
        f10 = f3 - localObject2;
        if (f10 > 2.0F * f1)
        {
          f1 = f10 / 2.0F;
          f10 = f3;
          break label1961;
          label1379:
          f3 = localObject1;
          if (i <= 10)
          {
            k = 1;
            i = k;
            if (localObject4.brV == 0L) {
              break label1990;
            }
            i = k;
            if (((u.b)localObject6).time - localObject4.brV >= 250L) {
              break label1990;
            }
            i = 0;
            break label1990;
          }
        }
      }
    }
    for (;;)
    {
      f3 = localObject1;
      float f7;
      if (k != 0)
      {
        localObject4.brR += 1;
        localObject1 += f10;
        f3 = localObject6.brs[this.brO];
        f5 = localObject6.brt[this.brO];
        f5 = (float)Math.atan2(f3 + f9, f5 + f8);
        f8 = Math.abs(f5 - localObject7[this.brO]);
        f3 = f8;
        if (f8 <= 3.141593F) {
          break label2020;
        }
        f3 = 6.283186F - f8;
        break label2020;
      }
      for (;;)
      {
        f8 = (float)(Math.sin(f5) * f3);
        double d = Math.cos(f5);
        f5 = (float)(f3 * d);
        localObject4.x += f8;
        localObject4.y += f5;
        f3 = f7;
        if (((u.b)localObject6).time - locala.brV > 250L)
        {
          locala.x -= f8;
          locala.y -= f5;
          locala.brR += 1;
          f3 = f7;
        }
        localObject4.brV = ((u.b)localObject6).time;
        f9 = localObject6.brs[this.brO];
        f8 = localObject6.brt[this.brO];
        i = 0;
        f7 = f3;
        break;
        label1704:
        f5 = localObject7[this.brO];
      }
      label1716:
      f1 = 0.08F;
      break label432;
      label1735:
      label1746:
      label1758:
      label1764:
      label1770:
      label1784:
      label1918:
      float f13;
      for (;;)
      {
        break label1973;
        f10 = f3;
        break label1961;
        break label1961;
        f7 = 0.0F;
        if (j != 0) {
          break label1227;
        }
        f1 = 1.2F;
        if (i2 == 0) {
          break label1232;
        }
        f12 = 0.08726647F;
        break label385;
        i = 1;
        break label836;
        i = 0;
        break label836;
        f1 = 0.0F;
        n = 0;
        m = 0;
        k = 0;
        break label919;
        for (;;)
        {
          if (j <= 5) {
            break label1904;
          }
          j = i;
          break;
          label1797:
          j = 2;
          break label1770;
          label1803:
          if (f2 > f3)
          {
            j = 1;
            break label1770;
          }
          j = 2;
          break label1770;
          label1823:
          int i3 = m;
          i1 = n;
          f2 = f1;
          if (k != j)
          {
            i3 = 1;
            i1 = n;
            n = i3;
          }
          for (;;)
          {
            if (n < 3) {
              break label1895;
            }
            f2 = f1;
            i3 = m;
            k += 1;
            m = i3;
            n = i1;
            f1 = f2;
            break;
            label1885:
            n += 1;
            f1 = f2;
          }
          label1895:
          break label960;
          label1897:
          j += 1;
        }
        label1904:
        break label1001;
        label1906:
        f4 = f1 + f2;
        i = 0;
        break label1084;
        if (j == 0)
        {
          f13 = f6;
          break label1278;
        }
        f13 = f4;
        break label1278;
        label1937:
        if (f3 - f13 < f1) {
          break label407;
        }
        f2 = f5;
        i = 1;
        f10 = f3;
        break label407;
        label1961:
        if (f2 < f5) {
          f2 = f5;
        }
      }
      label1973:
      if (f3 <= f13) {
        break label1379;
      }
      i += 1;
      break label407;
      label1990:
      k = i;
      if (i != 0)
      {
        k = i;
        if (f2 - f4 < 0.3F) {
          k = 0;
        }
      }
    }
    label2020:
    if (f3 >= f12) {}
    for (int i = 1;; i = 0)
    {
      f3 = 1.0F;
      if (i == 0) {
        break label1704;
      }
      f3 = 0.93F;
      break;
    }
  }
  
  final void a(u.b paramb)
  {
    try
    {
      AppMethodBeat.i(55639);
      if ((this.brQ > 0) && (this.brQ < 101)) {
        this.brQ -= 1;
      }
      this.brH.add(paramb);
      this.brJ += 1;
      if (paramb.brh > this.brK[0][0]) {
        this.brK[0][0] = paramb.brh;
      }
      if (paramb.brh < this.brK[0][1]) {
        this.brK[0][1] = paramb.brh;
      }
      float[] arrayOfFloat = this.brK[0];
      arrayOfFloat[2] += paramb.brh;
      if (paramb.bri > this.brK[1][0]) {
        this.brK[1][0] = paramb.bri;
      }
      if (paramb.bri < this.brK[1][1]) {
        this.brK[1][1] = paramb.bri;
      }
      arrayOfFloat = this.brK[1];
      arrayOfFloat[2] += paramb.bri;
      if (paramb.brj > this.brK[2][0]) {
        this.brK[2][0] = paramb.brj;
      }
      if (paramb.brj < this.brK[2][1]) {
        this.brK[2][1] = paramb.brj;
      }
      arrayOfFloat = this.brK[2];
      arrayOfFloat[2] += paramb.brj;
      if (paramb.brk > this.brL[0][0]) {
        this.brL[0][0] = paramb.brk;
      }
      if (paramb.brk < this.brL[0][1]) {
        this.brL[0][1] = paramb.brk;
      }
      arrayOfFloat = this.brL[0];
      arrayOfFloat[2] += paramb.brk;
      if (paramb.brl > this.brL[1][0]) {
        this.brL[1][0] = paramb.brl;
      }
      if (paramb.brl < this.brL[1][1]) {
        this.brL[1][1] = paramb.brl;
      }
      arrayOfFloat = this.brL[1];
      arrayOfFloat[2] += paramb.brl;
      if (paramb.brm > this.brL[2][0]) {
        this.brL[2][0] = paramb.brm;
      }
      if (paramb.brm < this.brL[2][1]) {
        this.brL[2][1] = paramb.brm;
      }
      arrayOfFloat = this.brL[2];
      arrayOfFloat[2] += paramb.brm;
      if (tG()) {
        u.b(this.bru);
      }
      AppMethodBeat.o(55639);
      return;
    }
    finally {}
  }
  
  final void reset()
  {
    try
    {
      AppMethodBeat.i(55635);
      this.brH.clear();
      this.brI = new u.f.a[5];
      this.brJ = 0;
      this.brK = new float[][] { { (1.0F / -1.0F), (1.0F / 1.0F), 0.0F }, { (1.0F / -1.0F), (1.0F / 1.0F), 0.0F }, { (1.0F / -1.0F), (1.0F / 1.0F), 0.0F } };
      this.brL = new float[][] { { (1.0F / -1.0F), (1.0F / 1.0F), 0.0F }, { (1.0F / -1.0F), (1.0F / 1.0F), 0.0F }, { (1.0F / -1.0F), (1.0F / 1.0F), 0.0F } };
      this.brM = ((float[][])Array.newInstance(Float.TYPE, new int[] { 3, 3 }));
      this.brN = new int[6];
      this.brO = 5;
      AppMethodBeat.o(55635);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  final u.f.a tI()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 274
    //   5: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 48	com/b/a/a/u$f:brI	[Lcom/b/a/a/u$f$a;
    //   12: iconst_4
    //   13: aaload
    //   14: ifnull +23 -> 37
    //   17: aload_0
    //   18: getfield 48	com/b/a/a/u$f:brI	[Lcom/b/a/a/u$f$a;
    //   21: iconst_4
    //   22: aaload
    //   23: invokevirtual 277	com/b/a/a/u$f$a:tJ	()Lcom/b/a/a/u$f$a;
    //   26: astore_1
    //   27: ldc_w 274
    //   30: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: areturn
    //   37: aconst_null
    //   38: astore_1
    //   39: ldc_w 274
    //   42: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: goto -12 -> 33
    //   48: astore_1
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_1
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	this	f
    //   26	13	1	locala	u.f.a
    //   48	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	33	48	finally
    //   39	45	48	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.b.a.a.u.f
 * JD-Core Version:    0.7.0.1
 */