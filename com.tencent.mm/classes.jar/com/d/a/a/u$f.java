package com.d.a.a;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

final class u$f
{
  private ArrayList<u.b> bbb = new ArrayList();
  private u.f.a[] bbc = new u.f.a[5];
  private int bbd = 0;
  private float[][] bbe;
  private float[][] bbf;
  private float[][] bbg;
  private int[] bbh;
  private int bbi;
  private int bbj;
  private int bbk;
  
  private u$f(u paramu)
  {
    paramu = new float[] { (1.0F / -1.0F), (1.0F / 1.0F), 0.0F };
    float[] arrayOfFloat = { (1.0F / -1.0F), (1.0F / 1.0F), 0.0F };
    this.bbe = new float[][] { paramu, { (1.0F / -1.0F), (1.0F / 1.0F), 0.0F }, arrayOfFloat };
    paramu = new float[] { (1.0F / -1.0F), (1.0F / 1.0F), 0.0F };
    this.bbf = new float[][] { { (1.0F / -1.0F), (1.0F / 1.0F), 0.0F }, { (1.0F / -1.0F), (1.0F / 1.0F), 0.0F }, paramu };
    this.bbg = ((float[][])Array.newInstance(Float.TYPE, new int[] { 3, 3 }));
    this.bbh = new int[6];
    this.bbi = 5;
    this.bbj = -1;
    this.bbk = 0;
  }
  
  /* Error */
  private void a(u.f.a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 41	com/d/a/a/u$f:bbc	[Lcom/d/a/a/u$f$a;
    //   6: iconst_1
    //   7: aload_0
    //   8: getfield 41	com/d/a/a/u$f:bbc	[Lcom/d/a/a/u$f$a;
    //   11: iconst_0
    //   12: iconst_4
    //   13: invokestatic 86	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   16: aload_0
    //   17: getfield 41	com/d/a/a/u$f:bbc	[Lcom/d/a/a/u$f$a;
    //   20: iconst_4
    //   21: aaload
    //   22: ifnull +138 -> 160
    //   25: invokestatic 92	android/os/SystemClock:elapsedRealtime	()J
    //   28: aload_1
    //   29: getfield 96	com/d/a/a/u$f$a:bbp	J
    //   32: lsub
    //   33: ldc2_w 97
    //   36: lcmp
    //   37: ifle +123 -> 160
    //   40: aload_0
    //   41: getfield 41	com/d/a/a/u$f:bbc	[Lcom/d/a/a/u$f$a;
    //   44: iconst_4
    //   45: aaload
    //   46: astore_2
    //   47: aload_2
    //   48: aload_2
    //   49: getfield 102	com/d/a/a/u$f$a:x	F
    //   52: aload_1
    //   53: getfield 102	com/d/a/a/u$f$a:x	F
    //   56: fadd
    //   57: fconst_2
    //   58: fdiv
    //   59: putfield 102	com/d/a/a/u$f$a:x	F
    //   62: aload_2
    //   63: aload_2
    //   64: getfield 105	com/d/a/a/u$f$a:y	F
    //   67: aload_1
    //   68: getfield 105	com/d/a/a/u$f$a:y	F
    //   71: fadd
    //   72: fconst_2
    //   73: fdiv
    //   74: putfield 105	com/d/a/a/u$f$a:y	F
    //   77: aload_2
    //   78: aload_2
    //   79: getfield 108	com/d/a/a/u$f$a:z	F
    //   82: aload_1
    //   83: getfield 108	com/d/a/a/u$f$a:z	F
    //   86: fadd
    //   87: fconst_2
    //   88: fdiv
    //   89: putfield 108	com/d/a/a/u$f$a:z	F
    //   92: aload_2
    //   93: aload_2
    //   94: getfield 111	com/d/a/a/u$f$a:bbl	I
    //   97: aload_1
    //   98: getfield 111	com/d/a/a/u$f$a:bbl	I
    //   101: iadd
    //   102: i2f
    //   103: fconst_2
    //   104: fdiv
    //   105: invokestatic 117	java/lang/Math:round	(F)I
    //   108: putfield 111	com/d/a/a/u$f$a:bbl	I
    //   111: aload_2
    //   112: aload_2
    //   113: getfield 120	com/d/a/a/u$f$a:bbm	F
    //   116: aload_1
    //   117: getfield 120	com/d/a/a/u$f$a:bbm	F
    //   120: fadd
    //   121: fconst_2
    //   122: fdiv
    //   123: putfield 120	com/d/a/a/u$f$a:bbm	F
    //   126: aload_2
    //   127: aload_2
    //   128: getfield 123	com/d/a/a/u$f$a:bbn	F
    //   131: aload_1
    //   132: getfield 123	com/d/a/a/u$f$a:bbn	F
    //   135: fadd
    //   136: fconst_2
    //   137: fdiv
    //   138: putfield 123	com/d/a/a/u$f$a:bbn	F
    //   141: aload_2
    //   142: aload_1
    //   143: getfield 96	com/d/a/a/u$f$a:bbp	J
    //   146: putfield 96	com/d/a/a/u$f$a:bbp	J
    //   149: aload_2
    //   150: aload_1
    //   151: getfield 126	com/d/a/a/u$f$a:bbo	F
    //   154: putfield 126	com/d/a/a/u$f$a:bbo	F
    //   157: aload_0
    //   158: monitorexit
    //   159: return
    //   160: aload_0
    //   161: getfield 41	com/d/a/a/u$f:bbc	[Lcom/d/a/a/u$f$a;
    //   164: iconst_4
    //   165: aload_1
    //   166: aastore
    //   167: goto -10 -> 157
    //   170: astore_1
    //   171: aload_0
    //   172: monitorexit
    //   173: aload_1
    //   174: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	this	f
    //   0	175	1	parama	u.f.a
    //   46	104	2	locala	u.f.a
    // Exception table:
    //   from	to	target	type
    //   2	157	170	finally
    //   160	167	170	finally
  }
  
  /* Error */
  private boolean pA()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 43	com/d/a/a/u$f:bbd	I
    //   6: bipush 20
    //   8: if_icmplt +703 -> 711
    //   11: aload_0
    //   12: getfield 49	com/d/a/a/u$f:bbe	[[F
    //   15: iconst_0
    //   16: aaload
    //   17: astore 17
    //   19: aload 17
    //   21: iconst_2
    //   22: aload 17
    //   24: iconst_2
    //   25: faload
    //   26: ldc 129
    //   28: fdiv
    //   29: fastore
    //   30: aload_0
    //   31: getfield 49	com/d/a/a/u$f:bbe	[[F
    //   34: iconst_1
    //   35: aaload
    //   36: astore 17
    //   38: aload 17
    //   40: iconst_2
    //   41: aload 17
    //   43: iconst_2
    //   44: faload
    //   45: ldc 129
    //   47: fdiv
    //   48: fastore
    //   49: aload_0
    //   50: getfield 49	com/d/a/a/u$f:bbe	[[F
    //   53: iconst_2
    //   54: aaload
    //   55: astore 17
    //   57: aload 17
    //   59: iconst_2
    //   60: aload 17
    //   62: iconst_2
    //   63: faload
    //   64: ldc 129
    //   66: fdiv
    //   67: fastore
    //   68: aload_0
    //   69: getfield 51	com/d/a/a/u$f:bbf	[[F
    //   72: iconst_0
    //   73: aaload
    //   74: astore 17
    //   76: aload 17
    //   78: iconst_2
    //   79: aload 17
    //   81: iconst_2
    //   82: faload
    //   83: ldc 129
    //   85: fdiv
    //   86: fastore
    //   87: aload_0
    //   88: getfield 51	com/d/a/a/u$f:bbf	[[F
    //   91: iconst_1
    //   92: aaload
    //   93: astore 17
    //   95: aload 17
    //   97: iconst_2
    //   98: aload 17
    //   100: iconst_2
    //   101: faload
    //   102: ldc 129
    //   104: fdiv
    //   105: fastore
    //   106: aload_0
    //   107: getfield 51	com/d/a/a/u$f:bbf	[[F
    //   110: iconst_2
    //   111: aaload
    //   112: astore 17
    //   114: aload 17
    //   116: iconst_2
    //   117: aload 17
    //   119: iconst_2
    //   120: faload
    //   121: ldc 129
    //   123: fdiv
    //   124: fastore
    //   125: aload_0
    //   126: getfield 51	com/d/a/a/u$f:bbf	[[F
    //   129: iconst_0
    //   130: aaload
    //   131: iconst_2
    //   132: faload
    //   133: fstore_1
    //   134: aload_0
    //   135: getfield 49	com/d/a/a/u$f:bbe	[[F
    //   138: iconst_0
    //   139: aaload
    //   140: iconst_0
    //   141: faload
    //   142: fstore_2
    //   143: aload_0
    //   144: getfield 49	com/d/a/a/u$f:bbe	[[F
    //   147: iconst_0
    //   148: aaload
    //   149: iconst_2
    //   150: faload
    //   151: fstore_3
    //   152: aload_0
    //   153: getfield 49	com/d/a/a/u$f:bbe	[[F
    //   156: iconst_0
    //   157: aaload
    //   158: iconst_2
    //   159: faload
    //   160: fstore 4
    //   162: aload_0
    //   163: getfield 49	com/d/a/a/u$f:bbe	[[F
    //   166: iconst_0
    //   167: aaload
    //   168: iconst_1
    //   169: faload
    //   170: fstore 5
    //   172: aload_0
    //   173: getfield 51	com/d/a/a/u$f:bbf	[[F
    //   176: iconst_1
    //   177: aaload
    //   178: iconst_2
    //   179: faload
    //   180: fstore 6
    //   182: aload_0
    //   183: getfield 49	com/d/a/a/u$f:bbe	[[F
    //   186: iconst_1
    //   187: aaload
    //   188: iconst_0
    //   189: faload
    //   190: fstore 7
    //   192: aload_0
    //   193: getfield 49	com/d/a/a/u$f:bbe	[[F
    //   196: iconst_1
    //   197: aaload
    //   198: iconst_2
    //   199: faload
    //   200: fstore 8
    //   202: aload_0
    //   203: getfield 49	com/d/a/a/u$f:bbe	[[F
    //   206: iconst_1
    //   207: aaload
    //   208: iconst_2
    //   209: faload
    //   210: fstore 9
    //   212: aload_0
    //   213: getfield 49	com/d/a/a/u$f:bbe	[[F
    //   216: iconst_1
    //   217: aaload
    //   218: iconst_1
    //   219: faload
    //   220: fstore 10
    //   222: aload_0
    //   223: getfield 51	com/d/a/a/u$f:bbf	[[F
    //   226: iconst_2
    //   227: aaload
    //   228: iconst_2
    //   229: faload
    //   230: fstore 11
    //   232: aload_0
    //   233: getfield 49	com/d/a/a/u$f:bbe	[[F
    //   236: iconst_2
    //   237: aaload
    //   238: iconst_0
    //   239: faload
    //   240: fstore 12
    //   242: aload_0
    //   243: getfield 49	com/d/a/a/u$f:bbe	[[F
    //   246: iconst_2
    //   247: aaload
    //   248: iconst_2
    //   249: faload
    //   250: fstore 13
    //   252: aload_0
    //   253: getfield 49	com/d/a/a/u$f:bbe	[[F
    //   256: iconst_2
    //   257: aaload
    //   258: iconst_2
    //   259: faload
    //   260: fstore 14
    //   262: aload_0
    //   263: getfield 49	com/d/a/a/u$f:bbe	[[F
    //   266: iconst_2
    //   267: aaload
    //   268: iconst_1
    //   269: faload
    //   270: fstore 15
    //   272: aload_0
    //   273: getfield 66	com/d/a/a/u$f:bbg	[[F
    //   276: iconst_0
    //   277: aaload
    //   278: iconst_0
    //   279: fload_1
    //   280: ldc 130
    //   282: fmul
    //   283: ldc 131
    //   285: aload_0
    //   286: getfield 66	com/d/a/a/u$f:bbg	[[F
    //   289: iconst_0
    //   290: aaload
    //   291: iconst_0
    //   292: faload
    //   293: fmul
    //   294: fadd
    //   295: fastore
    //   296: aload_0
    //   297: getfield 66	com/d/a/a/u$f:bbg	[[F
    //   300: iconst_0
    //   301: aaload
    //   302: iconst_1
    //   303: fload_2
    //   304: fload_3
    //   305: fsub
    //   306: ldc 130
    //   308: fmul
    //   309: ldc 131
    //   311: aload_0
    //   312: getfield 66	com/d/a/a/u$f:bbg	[[F
    //   315: iconst_0
    //   316: aaload
    //   317: iconst_1
    //   318: faload
    //   319: fmul
    //   320: fadd
    //   321: fastore
    //   322: aload_0
    //   323: getfield 66	com/d/a/a/u$f:bbg	[[F
    //   326: iconst_0
    //   327: aaload
    //   328: iconst_2
    //   329: fload 4
    //   331: fload 5
    //   333: fsub
    //   334: ldc 130
    //   336: fmul
    //   337: ldc 131
    //   339: aload_0
    //   340: getfield 66	com/d/a/a/u$f:bbg	[[F
    //   343: iconst_0
    //   344: aaload
    //   345: iconst_2
    //   346: faload
    //   347: fmul
    //   348: fadd
    //   349: fastore
    //   350: aload_0
    //   351: getfield 66	com/d/a/a/u$f:bbg	[[F
    //   354: iconst_1
    //   355: aaload
    //   356: iconst_0
    //   357: ldc 131
    //   359: aload_0
    //   360: getfield 66	com/d/a/a/u$f:bbg	[[F
    //   363: iconst_1
    //   364: aaload
    //   365: iconst_0
    //   366: faload
    //   367: fmul
    //   368: fload 6
    //   370: ldc 130
    //   372: fmul
    //   373: fadd
    //   374: fastore
    //   375: aload_0
    //   376: getfield 66	com/d/a/a/u$f:bbg	[[F
    //   379: iconst_1
    //   380: aaload
    //   381: iconst_1
    //   382: ldc 131
    //   384: aload_0
    //   385: getfield 66	com/d/a/a/u$f:bbg	[[F
    //   388: iconst_1
    //   389: aaload
    //   390: iconst_1
    //   391: faload
    //   392: fmul
    //   393: ldc 130
    //   395: fload 7
    //   397: fload 8
    //   399: fsub
    //   400: fmul
    //   401: fadd
    //   402: fastore
    //   403: aload_0
    //   404: getfield 66	com/d/a/a/u$f:bbg	[[F
    //   407: iconst_1
    //   408: aaload
    //   409: iconst_2
    //   410: ldc 131
    //   412: aload_0
    //   413: getfield 66	com/d/a/a/u$f:bbg	[[F
    //   416: iconst_1
    //   417: aaload
    //   418: iconst_2
    //   419: faload
    //   420: fmul
    //   421: ldc 130
    //   423: fload 9
    //   425: fload 10
    //   427: fsub
    //   428: fmul
    //   429: fadd
    //   430: fastore
    //   431: aload_0
    //   432: getfield 66	com/d/a/a/u$f:bbg	[[F
    //   435: iconst_2
    //   436: aaload
    //   437: iconst_0
    //   438: ldc 131
    //   440: aload_0
    //   441: getfield 66	com/d/a/a/u$f:bbg	[[F
    //   444: iconst_2
    //   445: aaload
    //   446: iconst_0
    //   447: faload
    //   448: fmul
    //   449: ldc 130
    //   451: fload 11
    //   453: fmul
    //   454: fadd
    //   455: fastore
    //   456: aload_0
    //   457: getfield 66	com/d/a/a/u$f:bbg	[[F
    //   460: iconst_2
    //   461: aaload
    //   462: iconst_1
    //   463: ldc 131
    //   465: aload_0
    //   466: getfield 66	com/d/a/a/u$f:bbg	[[F
    //   469: iconst_2
    //   470: aaload
    //   471: iconst_1
    //   472: faload
    //   473: fmul
    //   474: ldc 130
    //   476: fload 12
    //   478: fload 13
    //   480: fsub
    //   481: fmul
    //   482: fadd
    //   483: fastore
    //   484: aload_0
    //   485: getfield 66	com/d/a/a/u$f:bbg	[[F
    //   488: iconst_2
    //   489: aaload
    //   490: iconst_2
    //   491: ldc 131
    //   493: aload_0
    //   494: getfield 66	com/d/a/a/u$f:bbg	[[F
    //   497: iconst_2
    //   498: aaload
    //   499: iconst_2
    //   500: faload
    //   501: fmul
    //   502: ldc 130
    //   504: fload 14
    //   506: fload 15
    //   508: fsub
    //   509: fmul
    //   510: fadd
    //   511: fastore
    //   512: aload_0
    //   513: aload_0
    //   514: invokespecial 135	com/d/a/a/u$f:pB	()Lcom/d/a/a/u$f$a;
    //   517: invokespecial 137	com/d/a/a/u$f:a	(Lcom/d/a/a/u$f$a;)V
    //   520: aload_0
    //   521: iconst_0
    //   522: putfield 43	com/d/a/a/u$f:bbd	I
    //   525: iconst_3
    //   526: newarray float
    //   528: dup
    //   529: iconst_0
    //   530: ldc 44
    //   532: fastore
    //   533: dup
    //   534: iconst_1
    //   535: ldc 45
    //   537: fastore
    //   538: dup
    //   539: iconst_2
    //   540: fconst_0
    //   541: fastore
    //   542: astore 17
    //   544: aload_0
    //   545: iconst_3
    //   546: anewarray 47	[F
    //   549: dup
    //   550: iconst_0
    //   551: iconst_3
    //   552: newarray float
    //   554: dup
    //   555: iconst_0
    //   556: ldc 44
    //   558: fastore
    //   559: dup
    //   560: iconst_1
    //   561: ldc 45
    //   563: fastore
    //   564: dup
    //   565: iconst_2
    //   566: fconst_0
    //   567: fastore
    //   568: aastore
    //   569: dup
    //   570: iconst_1
    //   571: iconst_3
    //   572: newarray float
    //   574: dup
    //   575: iconst_0
    //   576: ldc 44
    //   578: fastore
    //   579: dup
    //   580: iconst_1
    //   581: ldc 45
    //   583: fastore
    //   584: dup
    //   585: iconst_2
    //   586: fconst_0
    //   587: fastore
    //   588: aastore
    //   589: dup
    //   590: iconst_2
    //   591: aload 17
    //   593: aastore
    //   594: putfield 49	com/d/a/a/u$f:bbe	[[F
    //   597: iconst_3
    //   598: newarray float
    //   600: dup
    //   601: iconst_0
    //   602: ldc 44
    //   604: fastore
    //   605: dup
    //   606: iconst_1
    //   607: ldc 45
    //   609: fastore
    //   610: dup
    //   611: iconst_2
    //   612: fconst_0
    //   613: fastore
    //   614: astore 17
    //   616: aload_0
    //   617: iconst_3
    //   618: anewarray 47	[F
    //   621: dup
    //   622: iconst_0
    //   623: iconst_3
    //   624: newarray float
    //   626: dup
    //   627: iconst_0
    //   628: ldc 44
    //   630: fastore
    //   631: dup
    //   632: iconst_1
    //   633: ldc 45
    //   635: fastore
    //   636: dup
    //   637: iconst_2
    //   638: fconst_0
    //   639: fastore
    //   640: aastore
    //   641: dup
    //   642: iconst_1
    //   643: iconst_3
    //   644: newarray float
    //   646: dup
    //   647: iconst_0
    //   648: ldc 44
    //   650: fastore
    //   651: dup
    //   652: iconst_1
    //   653: ldc 45
    //   655: fastore
    //   656: dup
    //   657: iconst_2
    //   658: fconst_0
    //   659: fastore
    //   660: aastore
    //   661: dup
    //   662: iconst_2
    //   663: aload 17
    //   665: aastore
    //   666: putfield 51	com/d/a/a/u$f:bbf	[[F
    //   669: aload_0
    //   670: getfield 39	com/d/a/a/u$f:bbb	Ljava/util/ArrayList;
    //   673: invokevirtual 141	java/util/ArrayList:size	()I
    //   676: bipush 100
    //   678: if_icmplt +25 -> 703
    //   681: aload_0
    //   682: getfield 39	com/d/a/a/u$f:bbb	Ljava/util/ArrayList;
    //   685: iconst_0
    //   686: bipush 20
    //   688: invokevirtual 145	java/util/ArrayList:subList	(II)Ljava/util/List;
    //   691: invokeinterface 150 1 0
    //   696: aload_0
    //   697: getfield 39	com/d/a/a/u$f:bbb	Ljava/util/ArrayList;
    //   700: invokevirtual 153	java/util/ArrayList:trimToSize	()V
    //   703: iconst_1
    //   704: istore 16
    //   706: aload_0
    //   707: monitorexit
    //   708: iload 16
    //   710: ireturn
    //   711: iconst_0
    //   712: istore 16
    //   714: goto -8 -> 706
    //   717: astore 17
    //   719: aload_0
    //   720: monitorexit
    //   721: aload 17
    //   723: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	724	0	this	f
    //   133	147	1	f1	float
    //   142	162	2	f2	float
    //   151	154	3	f3	float
    //   160	170	4	f4	float
    //   170	162	5	f5	float
    //   180	189	6	f6	float
    //   190	206	7	f7	float
    //   200	198	8	f8	float
    //   210	214	9	f9	float
    //   220	206	10	f10	float
    //   230	222	11	f11	float
    //   240	237	12	f12	float
    //   250	229	13	f13	float
    //   260	245	14	f14	float
    //   270	237	15	f15	float
    //   704	9	16	bool	boolean
    //   17	647	17	arrayOfFloat	float[]
    //   717	5	17	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	703	717	finally
  }
  
  private u.f.a pB()
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
    label380:
    float f8;
    float f9;
    label402:
    label427:
    Object localObject1;
    label826:
    int n;
    label909:
    int m;
    label950:
    int i1;
    label991:
    float f12;
    for (;;)
    {
      try
      {
        if (this.bbk == 0)
        {
          i2 = 1;
          if (i2 == 0) {
            continue;
          }
          if (Math.abs(this.bbg[2][0]) < 9.300000000000001D)
          {
            i = 5;
            this.bbi = i;
            this.bbh = new int[6];
            j = 0;
            if ((this.bbj >= 0) && (this.bbj <= 5)) {
              this.bbi = this.bbj;
            }
            localObject3 = new u.f.a(this, (byte)0);
            locala = new u.f.a(this, (byte)0);
            if (this.bbc[0] != null)
            {
              ((u.f.a)localObject3).bbp = this.bbc[0].bbp;
              ((u.f.a)localObject3).bbm = this.bbc[0].bbm;
            }
            if (this.bbc[4] != null)
            {
              locala.bbp = this.bbc[4].bbp;
              locala.bbm = this.bbc[4].bbm;
            }
            if (!this.bbb.isEmpty())
            {
              k = this.bbb.size();
              localObject5 = new float[6];
              localObject6 = new float[6];
              localObject7 = this.bbb.iterator();
              f1 = 0.0F;
              f2 = 0.0F;
              if (((Iterator)localObject7).hasNext()) {
                continue;
              }
              f6 = f2 / k;
              f4 = f1 / k;
              if (j != 0) {
                break label1203;
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
                break label1210;
              }
              f10 = f6;
              break label1725;
              localObject5 = this.bbb.iterator();
              f2 = f4;
              f8 = 0.0F;
              f9 = 0.0F;
              i = 0;
              if (((Iterator)localObject5).hasNext()) {
                break;
              }
              if (((u.f.a)localObject3).bbl > 0)
              {
                if (j != 0) {
                  break label1706;
                }
                f1 = 0.0F;
                f2 = localObject1 / ((u.f.a)localObject3).bbl;
                f3 = ((u.f.a)localObject3).bbm;
                f2 = f1 + ((f2 - f11) / 15.0F + 0.537F);
                f1 = f2;
                if (f3 != 0.0F) {
                  f1 = f2 * 0.67F + 0.33F * f3;
                }
                ((u.f.a)localObject3).bbm = f1;
                ((u.f.a)localObject3).x *= ((u.f.a)localObject3).bbm;
                ((u.f.a)localObject3).y *= ((u.f.a)localObject3).bbm;
                ((u.f.a)localObject3).bbn = (((u.f.a)localObject3).bbl * ((u.f.a)localObject3).bbm);
              }
            }
            ((u.f.a)localObject3).bbo = (((u.f.a)localObject3).bbn / (this.bbb.size() / 20));
            if (this.bbc[0] != null)
            {
              ((u.f.a)localObject3).x += this.bbc[0].x;
              ((u.f.a)localObject3).y += this.bbc[0].y;
              ((u.f.a)localObject3).z += this.bbc[0].z;
              ((u.f.a)localObject3).bbl += this.bbc[0].bbl;
              ((u.f.a)localObject3).bbn += this.bbc[0].bbn;
            }
            if ((this.bbc[4] != null) && (locala.bbl > 0))
            {
              this.bbc[4].x = ((this.bbc[4].x + ((u.f.a)localObject3).x + locala.x * ((u.f.a)localObject3).bbm) / 2.0F);
              this.bbc[4].y = ((this.bbc[4].y + ((u.f.a)localObject3).y + locala.y * ((u.f.a)localObject3).bbm) / 2.0F);
            }
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
        if (Math.abs(this.bbg[0][0]) < 7.0F) {
          break label1754;
        }
        if (this.bbg[1][1] >= 2.3F) {
          break label1748;
        }
        if (this.bbg[1][2] < 2.3F) {
          break label1754;
        }
        break label1748;
        if (i != 0)
        {
          this.bbi = 2;
          this.bbh = new int[6];
          j = i;
          continue;
        }
        f1 = Math.abs(this.bbg[0][0]);
        f2 = Math.abs(this.bbg[1][0]);
        f3 = Math.abs(this.bbg[2][0]);
        if (f1 <= f2) {
          break label1793;
        }
        if (f1 <= f3) {
          break label1787;
        }
        j = 0;
        break label1760;
        if (k < 3) {
          break label1813;
        }
        j = n * 2 + m - 1;
        Object localObject3 = this.bbh;
        localObject3[j] += 1;
        j = 0;
        break label1774;
        f2 = f1;
        if (this.bbg[k][n] <= f1) {
          break label1875;
        }
        f2 = this.bbg[k][n];
        m = n;
        i1 = k;
        break label1875;
        if ((j == this.bbi) || (this.bbh[j] <= this.bbh[this.bbi])) {
          break label1887;
        }
        this.bbi = j;
        break label1887;
        u.b localb = (u.b)((Iterator)localObject7).next();
        if (j == 0)
        {
          f3 = localb.baA;
          f3 = f2 + f3;
          if (j == 0)
          {
            f2 = localb.baI;
            break label1896;
            label1074:
            f1 = f4;
            f2 = f3;
            if (i > 5) {
              continue;
            }
            localObject5[i] += localb.baM[i];
            localObject6[i] += localb.baN[i];
            i += 1;
            continue;
          }
        }
        else
        {
          f3 = localb.baD;
          continue;
        }
        f2 = (float)Math.sqrt(localb.baB * localb.baB + localb.baC * localb.baC + localb.baD * localb.baD);
        localb.baH = f2;
      }
      finally {}
      label1203:
      float f11 = f4;
      continue;
      label1210:
      f10 = f4;
      break label1725;
      label1217:
      f1 = 1.0F;
      break label1736;
      label1222:
      f12 = 0.261799F;
    }
    Object localObject6 = (u.b)((Iterator)localObject5).next();
    if (j == 0) {}
    label1268:
    Object localObject2;
    for (float f3 = ((u.b)localObject6).baA;; f3 = ((u.b)localObject6).baH)
    {
      if (j != 0) {
        break label1318;
      }
      f5 = ((u.b)localObject6).baI;
      break label1908;
      if (i > 0) {
        break label1328;
      }
      if (f3 > localObject2) {
        break label1927;
      }
      f9 = localObject6.baM[this.bbi];
      f8 = localObject6.baN[this.bbi];
      break;
    }
    label1318:
    float f5 = ((u.b)localObject6).baH;
    break label1908;
    label1328:
    if (f10 < f3) {
      if (i2 == 0)
      {
        f10 = f3 - localObject2;
        if (f10 > 2.0F * f1)
        {
          f1 = f10 / 2.0F;
          f10 = f3;
          break label1951;
          label1369:
          f3 = localObject1;
          if (i <= 10)
          {
            k = 1;
            i = k;
            if (localObject4.bbp == 0L) {
              break label1980;
            }
            i = k;
            if (((u.b)localObject6).time - localObject4.bbp >= 250L) {
              break label1980;
            }
            i = 0;
            break label1980;
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
        localObject4.bbl += 1;
        localObject1 += f10;
        f3 = localObject6.baM[this.bbi];
        f5 = localObject6.baN[this.bbi];
        f5 = (float)Math.atan2(f3 + f9, f5 + f8);
        f8 = Math.abs(f5 - localObject7[this.bbi]);
        f3 = f8;
        if (f8 <= 3.141593F) {
          break label2010;
        }
        f3 = 6.283186F - f8;
        break label2010;
      }
      for (;;)
      {
        f8 = (float)(Math.sin(f5) * f3);
        double d = Math.cos(f5);
        f5 = (float)(f3 * d);
        localObject4.x += f8;
        localObject4.y += f5;
        f3 = f7;
        if (((u.b)localObject6).time - locala.bbp > 250L)
        {
          locala.x -= f8;
          locala.y -= f5;
          locala.bbl += 1;
          f3 = f7;
        }
        localObject4.bbp = ((u.b)localObject6).time;
        f9 = localObject6.baM[this.bbi];
        f8 = localObject6.baN[this.bbi];
        i = 0;
        f7 = f3;
        break;
        label1694:
        f5 = localObject7[this.bbi];
      }
      label1706:
      f1 = 0.08F;
      break label427;
      label1725:
      label1736:
      label1748:
      label1754:
      label1760:
      label1774:
      label1787:
      float f13;
      for (;;)
      {
        break label1963;
        f10 = f3;
        break label1951;
        break label1951;
        f7 = 0.0F;
        if (j != 0) {
          break label1217;
        }
        f1 = 1.2F;
        if (i2 == 0) {
          break label1222;
        }
        f12 = 0.08726647F;
        break label380;
        i = 1;
        break label826;
        i = 0;
        break label826;
        f1 = 0.0F;
        n = 0;
        m = 0;
        k = 0;
        break label909;
        for (;;)
        {
          if (j <= 5) {
            break label1894;
          }
          j = i;
          break;
          j = 2;
          break label1760;
          label1793:
          if (f2 > f3)
          {
            j = 1;
            break label1760;
          }
          j = 2;
          break label1760;
          label1813:
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
              break label1885;
            }
            f2 = f1;
            i3 = m;
            k += 1;
            m = i3;
            n = i1;
            f1 = f2;
            break;
            label1875:
            n += 1;
            f1 = f2;
          }
          label1885:
          break label950;
          label1887:
          j += 1;
        }
        label1894:
        break label991;
        label1896:
        f4 = f1 + f2;
        i = 0;
        break label1074;
        label1908:
        if (j == 0)
        {
          f13 = f6;
          break label1268;
        }
        f13 = f4;
        break label1268;
        label1927:
        if (f3 - f13 < f1) {
          break label402;
        }
        f2 = f5;
        i = 1;
        f10 = f3;
        break label402;
        label1951:
        if (f2 < f5) {
          f2 = f5;
        }
      }
      label1963:
      if (f3 <= f13) {
        break label1369;
      }
      i += 1;
      break label402;
      label1980:
      k = i;
      if (i != 0)
      {
        k = i;
        if (f2 - f4 < 0.3F) {
          k = 0;
        }
      }
    }
    label2010:
    if (f3 >= f12) {}
    for (int i = 1;; i = 0)
    {
      f3 = 1.0F;
      if (i == 0) {
        break label1694;
      }
      f3 = 0.93F;
      break;
    }
  }
  
  final void a(u.b paramb)
  {
    try
    {
      if ((this.bbk > 0) && (this.bbk < 101)) {
        this.bbk -= 1;
      }
      this.bbb.add(paramb);
      this.bbd += 1;
      if (paramb.baB > this.bbe[0][0]) {
        this.bbe[0][0] = paramb.baB;
      }
      if (paramb.baB < this.bbe[0][1]) {
        this.bbe[0][1] = paramb.baB;
      }
      float[] arrayOfFloat = this.bbe[0];
      arrayOfFloat[2] += paramb.baB;
      if (paramb.baC > this.bbe[1][0]) {
        this.bbe[1][0] = paramb.baC;
      }
      if (paramb.baC < this.bbe[1][1]) {
        this.bbe[1][1] = paramb.baC;
      }
      arrayOfFloat = this.bbe[1];
      arrayOfFloat[2] += paramb.baC;
      if (paramb.baD > this.bbe[2][0]) {
        this.bbe[2][0] = paramb.baD;
      }
      if (paramb.baD < this.bbe[2][1]) {
        this.bbe[2][1] = paramb.baD;
      }
      arrayOfFloat = this.bbe[2];
      arrayOfFloat[2] += paramb.baD;
      if (paramb.baE > this.bbf[0][0]) {
        this.bbf[0][0] = paramb.baE;
      }
      if (paramb.baE < this.bbf[0][1]) {
        this.bbf[0][1] = paramb.baE;
      }
      arrayOfFloat = this.bbf[0];
      arrayOfFloat[2] += paramb.baE;
      if (paramb.baF > this.bbf[1][0]) {
        this.bbf[1][0] = paramb.baF;
      }
      if (paramb.baF < this.bbf[1][1]) {
        this.bbf[1][1] = paramb.baF;
      }
      arrayOfFloat = this.bbf[1];
      arrayOfFloat[2] += paramb.baF;
      if (paramb.baG > this.bbf[2][0]) {
        this.bbf[2][0] = paramb.baG;
      }
      if (paramb.baG < this.bbf[2][1]) {
        this.bbf[2][1] = paramb.baG;
      }
      arrayOfFloat = this.bbf[2];
      arrayOfFloat[2] += paramb.baG;
      if (pA()) {
        u.b(this.baO);
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  final u.f.a pC()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 41	com/d/a/a/u$f:bbc	[Lcom/d/a/a/u$f$a;
    //   6: iconst_4
    //   7: aaload
    //   8: ifnull +17 -> 25
    //   11: aload_0
    //   12: getfield 41	com/d/a/a/u$f:bbc	[Lcom/d/a/a/u$f$a;
    //   15: iconst_4
    //   16: aaload
    //   17: invokevirtual 259	com/d/a/a/u$f$a:pD	()Lcom/d/a/a/u$f$a;
    //   20: astore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_1
    //   24: areturn
    //   25: aconst_null
    //   26: astore_1
    //   27: goto -6 -> 21
    //   30: astore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_1
    //   34: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	35	0	this	f
    //   20	7	1	locala	u.f.a
    //   30	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	30	finally
  }
  
  final void reset()
  {
    try
    {
      this.bbb.clear();
      this.bbc = new u.f.a[5];
      this.bbd = 0;
      this.bbe = new float[][] { { (1.0F / -1.0F), (1.0F / 1.0F), 0.0F }, { (1.0F / -1.0F), (1.0F / 1.0F), 0.0F }, { (1.0F / -1.0F), (1.0F / 1.0F), 0.0F } };
      this.bbf = new float[][] { { (1.0F / -1.0F), (1.0F / 1.0F), 0.0F }, { (1.0F / -1.0F), (1.0F / 1.0F), 0.0F }, { (1.0F / -1.0F), (1.0F / 1.0F), 0.0F } };
      this.bbg = ((float[][])Array.newInstance(Float.TYPE, new int[] { 3, 3 }));
      this.bbh = new int[6];
      this.bbi = 5;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.d.a.a.u.f
 * JD-Core Version:    0.7.0.1
 */