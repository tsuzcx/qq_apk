package a.j.b.a.c.e.b;

import a.j.b.a.c.e.a.w;
import a.j.b.a.c.e.a.y;
import a.j.b.a.c.g.d;
import a.j.b.a.c.g.f;
import a.j.b.a.c.g.i;
import a.j.b.a.c.g.i.a;
import a.j.b.a.c.g.n;
import a.j.b.a.c.g.o;
import a.j.b.a.c.g.q;
import a.j.b.a.c.g.s;
import a.j.b.a.c.g.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public final class a$a
  extends i
  implements a.b
{
  public static s<a> Ckq;
  private static final a CoY;
  private final d Ckp;
  private int Ckr;
  private byte Cku = -1;
  private int Ckv = -1;
  public List<a.j.b.a.c.e.a.a> Cno;
  public List<a.c> CoZ;
  public List<a.c> Cpa;
  public o Cpb;
  public a.y Cpc;
  public a.w Cpd;
  
  static
  {
    AppMethodBeat.i(121131);
    Ckq = new a.a.1();
    a locala = new a();
    CoY = locala;
    locala.egZ();
    AppMethodBeat.o(121131);
  }
  
  private a$a()
  {
    this.Ckp = d.Cre;
  }
  
  /* Error */
  private a$a(a.j.b.a.c.g.e parame, a.j.b.a.c.g.g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 62	a/j/b/a/c/g/i:<init>	()V
    //   4: ldc 79
    //   6: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 64	a/j/b/a/c/e/b/a$a:Cku	B
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 66	a/j/b/a/c/e/b/a$a:Ckv	I
    //   19: aload_0
    //   20: invokespecial 57	a/j/b/a/c/e/b/a$a:egZ	()V
    //   23: iconst_0
    //   24: istore_3
    //   25: invokestatic 83	a/j/b/a/c/g/d:emp	()La/j/b/a/c/g/d$b;
    //   28: astore 10
    //   30: aload 10
    //   32: iconst_1
    //   33: invokestatic 89	a/j/b/a/c/g/f:e	(Ljava/io/OutputStream;I)La/j/b/a/c/g/f;
    //   36: astore 11
    //   38: iconst_0
    //   39: istore 8
    //   41: iload 8
    //   43: ifne +804 -> 847
    //   46: iload_3
    //   47: istore 4
    //   49: iload_3
    //   50: istore 5
    //   52: iload_3
    //   53: istore 6
    //   55: aload_1
    //   56: invokevirtual 95	a/j/b/a/c/g/e:sk	()I
    //   59: istore 7
    //   61: iload 7
    //   63: lookupswitch	default:+980->1043, 0:+983->1046, 10:+93->156, 18:+288->351, 26:+400->463, 34:+479->542, 42:+604->667, 50:+729->792
    //   129: istore 4
    //   131: iload_3
    //   132: istore 5
    //   134: iload_3
    //   135: istore 6
    //   137: aload_0
    //   138: aload_1
    //   139: aload 11
    //   141: aload_2
    //   142: iload 7
    //   144: invokevirtual 98	a/j/b/a/c/e/b/a$a:a	(La/j/b/a/c/g/e;La/j/b/a/c/g/f;La/j/b/a/c/g/g;I)Z
    //   147: ifne +893 -> 1040
    //   150: iconst_1
    //   151: istore 8
    //   153: goto -112 -> 41
    //   156: iload_3
    //   157: istore 7
    //   159: iload_3
    //   160: iconst_1
    //   161: iand
    //   162: iconst_1
    //   163: if_icmpeq +28 -> 191
    //   166: iload_3
    //   167: istore 4
    //   169: iload_3
    //   170: istore 5
    //   172: iload_3
    //   173: istore 6
    //   175: aload_0
    //   176: new 100	java/util/ArrayList
    //   179: dup
    //   180: invokespecial 101	java/util/ArrayList:<init>	()V
    //   183: putfield 103	a/j/b/a/c/e/b/a$a:CoZ	Ljava/util/List;
    //   186: iload_3
    //   187: iconst_1
    //   188: ior
    //   189: istore 7
    //   191: iload 7
    //   193: istore 4
    //   195: iload 7
    //   197: istore 5
    //   199: iload 7
    //   201: istore 6
    //   203: aload_0
    //   204: getfield 103	a/j/b/a/c/e/b/a$a:CoZ	Ljava/util/List;
    //   207: aload_1
    //   208: getstatic 106	a/j/b/a/c/e/b/a$c:Ckq	La/j/b/a/c/g/s;
    //   211: aload_2
    //   212: invokevirtual 109	a/j/b/a/c/g/e:a	(La/j/b/a/c/g/s;La/j/b/a/c/g/g;)La/j/b/a/c/g/q;
    //   215: invokeinterface 115 2 0
    //   220: pop
    //   221: iload 7
    //   223: istore_3
    //   224: goto -183 -> 41
    //   227: astore_1
    //   228: iload 4
    //   230: istore_3
    //   231: aload_1
    //   232: aload_0
    //   233: putfield 119	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   236: iload 4
    //   238: istore_3
    //   239: ldc 79
    //   241: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   244: iload 4
    //   246: istore_3
    //   247: aload_1
    //   248: athrow
    //   249: astore_1
    //   250: iload_3
    //   251: iconst_1
    //   252: iand
    //   253: iconst_1
    //   254: if_icmpne +14 -> 268
    //   257: aload_0
    //   258: aload_0
    //   259: getfield 103	a/j/b/a/c/e/b/a$a:CoZ	Ljava/util/List;
    //   262: invokestatic 125	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   265: putfield 103	a/j/b/a/c/e/b/a$a:CoZ	Ljava/util/List;
    //   268: iload_3
    //   269: iconst_2
    //   270: iand
    //   271: iconst_2
    //   272: if_icmpne +14 -> 286
    //   275: aload_0
    //   276: aload_0
    //   277: getfield 127	a/j/b/a/c/e/b/a$a:Cpa	Ljava/util/List;
    //   280: invokestatic 125	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   283: putfield 127	a/j/b/a/c/e/b/a$a:Cpa	Ljava/util/List;
    //   286: iload_3
    //   287: iconst_4
    //   288: iand
    //   289: iconst_4
    //   290: if_icmpne +16 -> 306
    //   293: aload_0
    //   294: aload_0
    //   295: getfield 129	a/j/b/a/c/e/b/a$a:Cpb	La/j/b/a/c/g/o;
    //   298: invokeinterface 135 1 0
    //   303: putfield 129	a/j/b/a/c/e/b/a$a:Cpb	La/j/b/a/c/g/o;
    //   306: iload_3
    //   307: bipush 32
    //   309: iand
    //   310: bipush 32
    //   312: if_icmpne +14 -> 326
    //   315: aload_0
    //   316: aload_0
    //   317: getfield 137	a/j/b/a/c/e/b/a$a:Cno	Ljava/util/List;
    //   320: invokestatic 125	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   323: putfield 137	a/j/b/a/c/e/b/a$a:Cno	Ljava/util/List;
    //   326: aload 11
    //   328: invokevirtual 140	a/j/b/a/c/g/f:flush	()V
    //   331: aload_0
    //   332: aload 10
    //   334: invokevirtual 146	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   337: putfield 73	a/j/b/a/c/e/b/a$a:Ckp	La/j/b/a/c/g/d;
    //   340: aload_0
    //   341: invokevirtual 149	a/j/b/a/c/e/b/a$a:emL	()V
    //   344: ldc 79
    //   346: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   349: aload_1
    //   350: athrow
    //   351: iload_3
    //   352: istore 7
    //   354: iload_3
    //   355: iconst_2
    //   356: iand
    //   357: iconst_2
    //   358: if_icmpeq +28 -> 386
    //   361: iload_3
    //   362: istore 4
    //   364: iload_3
    //   365: istore 5
    //   367: iload_3
    //   368: istore 6
    //   370: aload_0
    //   371: new 100	java/util/ArrayList
    //   374: dup
    //   375: invokespecial 101	java/util/ArrayList:<init>	()V
    //   378: putfield 127	a/j/b/a/c/e/b/a$a:Cpa	Ljava/util/List;
    //   381: iload_3
    //   382: iconst_2
    //   383: ior
    //   384: istore 7
    //   386: iload 7
    //   388: istore 4
    //   390: iload 7
    //   392: istore 5
    //   394: iload 7
    //   396: istore 6
    //   398: aload_0
    //   399: getfield 127	a/j/b/a/c/e/b/a$a:Cpa	Ljava/util/List;
    //   402: aload_1
    //   403: getstatic 106	a/j/b/a/c/e/b/a$c:Ckq	La/j/b/a/c/g/s;
    //   406: aload_2
    //   407: invokevirtual 109	a/j/b/a/c/g/e:a	(La/j/b/a/c/g/s;La/j/b/a/c/g/g;)La/j/b/a/c/g/q;
    //   410: invokeinterface 115 2 0
    //   415: pop
    //   416: iload 7
    //   418: istore_3
    //   419: goto -378 -> 41
    //   422: astore_1
    //   423: iload 5
    //   425: istore 4
    //   427: iload 4
    //   429: istore_3
    //   430: new 76	a/j/b/a/c/g/k
    //   433: dup
    //   434: aload_1
    //   435: invokevirtual 153	java/io/IOException:getMessage	()Ljava/lang/String;
    //   438: invokespecial 156	a/j/b/a/c/g/k:<init>	(Ljava/lang/String;)V
    //   441: astore_1
    //   442: iload 4
    //   444: istore_3
    //   445: aload_1
    //   446: aload_0
    //   447: putfield 119	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   450: iload 4
    //   452: istore_3
    //   453: ldc 79
    //   455: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   458: iload 4
    //   460: istore_3
    //   461: aload_1
    //   462: athrow
    //   463: iload_3
    //   464: istore 4
    //   466: iload_3
    //   467: istore 5
    //   469: iload_3
    //   470: istore 6
    //   472: aload_1
    //   473: invokevirtual 159	a/j/b/a/c/g/e:emv	()La/j/b/a/c/g/d;
    //   476: astore 9
    //   478: iload_3
    //   479: istore 7
    //   481: iload_3
    //   482: iconst_4
    //   483: iand
    //   484: iconst_4
    //   485: if_icmpeq +28 -> 513
    //   488: iload_3
    //   489: istore 4
    //   491: iload_3
    //   492: istore 5
    //   494: iload_3
    //   495: istore 6
    //   497: aload_0
    //   498: new 161	a/j/b/a/c/g/n
    //   501: dup
    //   502: invokespecial 162	a/j/b/a/c/g/n:<init>	()V
    //   505: putfield 129	a/j/b/a/c/e/b/a$a:Cpb	La/j/b/a/c/g/o;
    //   508: iload_3
    //   509: iconst_4
    //   510: ior
    //   511: istore 7
    //   513: iload 7
    //   515: istore 4
    //   517: iload 7
    //   519: istore 5
    //   521: iload 7
    //   523: istore 6
    //   525: aload_0
    //   526: getfield 129	a/j/b/a/c/e/b/a$a:Cpb	La/j/b/a/c/g/o;
    //   529: aload 9
    //   531: invokeinterface 165 2 0
    //   536: iload 7
    //   538: istore_3
    //   539: goto -498 -> 41
    //   542: iload_3
    //   543: istore 4
    //   545: iload_3
    //   546: istore 5
    //   548: iload_3
    //   549: istore 6
    //   551: aload_0
    //   552: getfield 167	a/j/b/a/c/e/b/a$a:Ckr	I
    //   555: iconst_1
    //   556: iand
    //   557: iconst_1
    //   558: if_icmpne +476 -> 1034
    //   561: iload_3
    //   562: istore 4
    //   564: iload_3
    //   565: istore 5
    //   567: iload_3
    //   568: istore 6
    //   570: aload_0
    //   571: getfield 169	a/j/b/a/c/e/b/a$a:Cpc	La/j/b/a/c/e/a$y;
    //   574: invokevirtual 175	a/j/b/a/c/e/a$y:ejr	()La/j/b/a/c/e/a$y$a;
    //   577: astore 9
    //   579: iload_3
    //   580: istore 4
    //   582: iload_3
    //   583: istore 5
    //   585: iload_3
    //   586: istore 6
    //   588: aload_0
    //   589: aload_1
    //   590: getstatic 176	a/j/b/a/c/e/a$y:Ckq	La/j/b/a/c/g/s;
    //   593: aload_2
    //   594: invokevirtual 109	a/j/b/a/c/g/e:a	(La/j/b/a/c/g/s;La/j/b/a/c/g/g;)La/j/b/a/c/g/q;
    //   597: checkcast 171	a/j/b/a/c/e/a$y
    //   600: putfield 169	a/j/b/a/c/e/b/a$a:Cpc	La/j/b/a/c/e/a$y;
    //   603: aload 9
    //   605: ifnull +40 -> 645
    //   608: iload_3
    //   609: istore 4
    //   611: iload_3
    //   612: istore 5
    //   614: iload_3
    //   615: istore 6
    //   617: aload 9
    //   619: aload_0
    //   620: getfield 169	a/j/b/a/c/e/b/a$a:Cpc	La/j/b/a/c/e/a$y;
    //   623: invokevirtual 182	a/j/b/a/c/e/a$y$a:d	(La/j/b/a/c/e/a$y;)La/j/b/a/c/e/a$y$a;
    //   626: pop
    //   627: iload_3
    //   628: istore 4
    //   630: iload_3
    //   631: istore 5
    //   633: iload_3
    //   634: istore 6
    //   636: aload_0
    //   637: aload 9
    //   639: invokevirtual 186	a/j/b/a/c/e/a$y$a:ejt	()La/j/b/a/c/e/a$y;
    //   642: putfield 169	a/j/b/a/c/e/b/a$a:Cpc	La/j/b/a/c/e/a$y;
    //   645: iload_3
    //   646: istore 4
    //   648: iload_3
    //   649: istore 5
    //   651: iload_3
    //   652: istore 6
    //   654: aload_0
    //   655: aload_0
    //   656: getfield 167	a/j/b/a/c/e/b/a$a:Ckr	I
    //   659: iconst_1
    //   660: ior
    //   661: putfield 167	a/j/b/a/c/e/b/a$a:Ckr	I
    //   664: goto -623 -> 41
    //   667: iload_3
    //   668: istore 4
    //   670: iload_3
    //   671: istore 5
    //   673: iload_3
    //   674: istore 6
    //   676: aload_0
    //   677: getfield 167	a/j/b/a/c/e/b/a$a:Ckr	I
    //   680: iconst_2
    //   681: iand
    //   682: iconst_2
    //   683: if_icmpne +345 -> 1028
    //   686: iload_3
    //   687: istore 4
    //   689: iload_3
    //   690: istore 5
    //   692: iload_3
    //   693: istore 6
    //   695: aload_0
    //   696: getfield 188	a/j/b/a/c/e/b/a$a:Cpd	La/j/b/a/c/e/a$w;
    //   699: invokevirtual 194	a/j/b/a/c/e/a$w:ejf	()La/j/b/a/c/e/a$w$a;
    //   702: astore 9
    //   704: iload_3
    //   705: istore 4
    //   707: iload_3
    //   708: istore 5
    //   710: iload_3
    //   711: istore 6
    //   713: aload_0
    //   714: aload_1
    //   715: getstatic 195	a/j/b/a/c/e/a$w:Ckq	La/j/b/a/c/g/s;
    //   718: aload_2
    //   719: invokevirtual 109	a/j/b/a/c/g/e:a	(La/j/b/a/c/g/s;La/j/b/a/c/g/g;)La/j/b/a/c/g/q;
    //   722: checkcast 190	a/j/b/a/c/e/a$w
    //   725: putfield 188	a/j/b/a/c/e/b/a$a:Cpd	La/j/b/a/c/e/a$w;
    //   728: aload 9
    //   730: ifnull +40 -> 770
    //   733: iload_3
    //   734: istore 4
    //   736: iload_3
    //   737: istore 5
    //   739: iload_3
    //   740: istore 6
    //   742: aload 9
    //   744: aload_0
    //   745: getfield 188	a/j/b/a/c/e/b/a$a:Cpd	La/j/b/a/c/e/a$w;
    //   748: invokevirtual 200	a/j/b/a/c/e/a$w$a:d	(La/j/b/a/c/e/a$w;)La/j/b/a/c/e/a$w$a;
    //   751: pop
    //   752: iload_3
    //   753: istore 4
    //   755: iload_3
    //   756: istore 5
    //   758: iload_3
    //   759: istore 6
    //   761: aload_0
    //   762: aload 9
    //   764: invokevirtual 204	a/j/b/a/c/e/a$w$a:ejh	()La/j/b/a/c/e/a$w;
    //   767: putfield 188	a/j/b/a/c/e/b/a$a:Cpd	La/j/b/a/c/e/a$w;
    //   770: iload_3
    //   771: istore 4
    //   773: iload_3
    //   774: istore 5
    //   776: iload_3
    //   777: istore 6
    //   779: aload_0
    //   780: aload_0
    //   781: getfield 167	a/j/b/a/c/e/b/a$a:Ckr	I
    //   784: iconst_2
    //   785: ior
    //   786: putfield 167	a/j/b/a/c/e/b/a$a:Ckr	I
    //   789: goto -748 -> 41
    //   792: iload_3
    //   793: bipush 32
    //   795: iand
    //   796: bipush 32
    //   798: if_icmpeq +227 -> 1025
    //   801: iload_3
    //   802: istore 4
    //   804: iload_3
    //   805: istore 5
    //   807: iload_3
    //   808: istore 6
    //   810: aload_0
    //   811: new 100	java/util/ArrayList
    //   814: dup
    //   815: invokespecial 101	java/util/ArrayList:<init>	()V
    //   818: putfield 137	a/j/b/a/c/e/b/a$a:Cno	Ljava/util/List;
    //   821: iload_3
    //   822: bipush 32
    //   824: ior
    //   825: istore_3
    //   826: aload_0
    //   827: getfield 137	a/j/b/a/c/e/b/a$a:Cno	Ljava/util/List;
    //   830: aload_1
    //   831: getstatic 207	a/j/b/a/c/e/a$a:Ckq	La/j/b/a/c/g/s;
    //   834: aload_2
    //   835: invokevirtual 109	a/j/b/a/c/g/e:a	(La/j/b/a/c/g/s;La/j/b/a/c/g/g;)La/j/b/a/c/g/q;
    //   838: invokeinterface 115 2 0
    //   843: pop
    //   844: goto -803 -> 41
    //   847: iload_3
    //   848: iconst_1
    //   849: iand
    //   850: iconst_1
    //   851: if_icmpne +14 -> 865
    //   854: aload_0
    //   855: aload_0
    //   856: getfield 103	a/j/b/a/c/e/b/a$a:CoZ	Ljava/util/List;
    //   859: invokestatic 125	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   862: putfield 103	a/j/b/a/c/e/b/a$a:CoZ	Ljava/util/List;
    //   865: iload_3
    //   866: iconst_2
    //   867: iand
    //   868: iconst_2
    //   869: if_icmpne +14 -> 883
    //   872: aload_0
    //   873: aload_0
    //   874: getfield 127	a/j/b/a/c/e/b/a$a:Cpa	Ljava/util/List;
    //   877: invokestatic 125	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   880: putfield 127	a/j/b/a/c/e/b/a$a:Cpa	Ljava/util/List;
    //   883: iload_3
    //   884: iconst_4
    //   885: iand
    //   886: iconst_4
    //   887: if_icmpne +16 -> 903
    //   890: aload_0
    //   891: aload_0
    //   892: getfield 129	a/j/b/a/c/e/b/a$a:Cpb	La/j/b/a/c/g/o;
    //   895: invokeinterface 135 1 0
    //   900: putfield 129	a/j/b/a/c/e/b/a$a:Cpb	La/j/b/a/c/g/o;
    //   903: iload_3
    //   904: bipush 32
    //   906: iand
    //   907: bipush 32
    //   909: if_icmpne +14 -> 923
    //   912: aload_0
    //   913: aload_0
    //   914: getfield 137	a/j/b/a/c/e/b/a$a:Cno	Ljava/util/List;
    //   917: invokestatic 125	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   920: putfield 137	a/j/b/a/c/e/b/a$a:Cno	Ljava/util/List;
    //   923: aload 11
    //   925: invokevirtual 140	a/j/b/a/c/g/f:flush	()V
    //   928: aload_0
    //   929: aload 10
    //   931: invokevirtual 146	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   934: putfield 73	a/j/b/a/c/e/b/a$a:Ckp	La/j/b/a/c/g/d;
    //   937: aload_0
    //   938: invokevirtual 149	a/j/b/a/c/e/b/a$a:emL	()V
    //   941: ldc 79
    //   943: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   946: return
    //   947: astore_1
    //   948: aload_0
    //   949: aload 10
    //   951: invokevirtual 146	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   954: putfield 73	a/j/b/a/c/e/b/a$a:Ckp	La/j/b/a/c/g/d;
    //   957: goto -20 -> 937
    //   960: astore_1
    //   961: aload_0
    //   962: aload 10
    //   964: invokevirtual 146	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   967: putfield 73	a/j/b/a/c/e/b/a$a:Ckp	La/j/b/a/c/g/d;
    //   970: ldc 79
    //   972: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   975: aload_1
    //   976: athrow
    //   977: astore_2
    //   978: aload_0
    //   979: aload 10
    //   981: invokevirtual 146	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   984: putfield 73	a/j/b/a/c/e/b/a$a:Ckp	La/j/b/a/c/g/d;
    //   987: goto -647 -> 340
    //   990: astore_1
    //   991: aload_0
    //   992: aload 10
    //   994: invokevirtual 146	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   997: putfield 73	a/j/b/a/c/e/b/a$a:Ckp	La/j/b/a/c/g/d;
    //   1000: ldc 79
    //   1002: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1005: aload_1
    //   1006: athrow
    //   1007: astore_1
    //   1008: goto -758 -> 250
    //   1011: astore_1
    //   1012: iload_3
    //   1013: istore 4
    //   1015: goto -588 -> 427
    //   1018: astore_1
    //   1019: iload_3
    //   1020: istore 4
    //   1022: goto -794 -> 228
    //   1025: goto -199 -> 826
    //   1028: aconst_null
    //   1029: astore 9
    //   1031: goto -327 -> 704
    //   1034: aconst_null
    //   1035: astore 9
    //   1037: goto -458 -> 579
    //   1040: goto -196 -> 844
    //   1043: goto -915 -> 128
    //   1046: iconst_1
    //   1047: istore 8
    //   1049: goto -1008 -> 41
    //   1052: astore_1
    //   1053: iload 6
    //   1055: istore_3
    //   1056: goto -806 -> 250
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1059	0	this	a
    //   0	1059	1	parame	a.j.b.a.c.g.e
    //   0	1059	2	paramg	a.j.b.a.c.g.g
    //   24	1032	3	i	int
    //   47	974	4	j	int
    //   50	756	5	k	int
    //   53	1001	6	m	int
    //   59	478	7	n	int
    //   39	1009	8	i1	int
    //   476	560	9	localObject	java.lang.Object
    //   28	965	10	localb	a.j.b.a.c.g.d.b
    //   36	888	11	localf	f
    // Exception table:
    //   from	to	target	type
    //   55	61	227	a/j/b/a/c/g/k
    //   137	150	227	a/j/b/a/c/g/k
    //   175	186	227	a/j/b/a/c/g/k
    //   203	221	227	a/j/b/a/c/g/k
    //   370	381	227	a/j/b/a/c/g/k
    //   398	416	227	a/j/b/a/c/g/k
    //   472	478	227	a/j/b/a/c/g/k
    //   497	508	227	a/j/b/a/c/g/k
    //   525	536	227	a/j/b/a/c/g/k
    //   551	561	227	a/j/b/a/c/g/k
    //   570	579	227	a/j/b/a/c/g/k
    //   588	603	227	a/j/b/a/c/g/k
    //   617	627	227	a/j/b/a/c/g/k
    //   636	645	227	a/j/b/a/c/g/k
    //   654	664	227	a/j/b/a/c/g/k
    //   676	686	227	a/j/b/a/c/g/k
    //   695	704	227	a/j/b/a/c/g/k
    //   713	728	227	a/j/b/a/c/g/k
    //   742	752	227	a/j/b/a/c/g/k
    //   761	770	227	a/j/b/a/c/g/k
    //   779	789	227	a/j/b/a/c/g/k
    //   810	821	227	a/j/b/a/c/g/k
    //   231	236	249	finally
    //   239	244	249	finally
    //   247	249	249	finally
    //   430	442	249	finally
    //   445	450	249	finally
    //   453	458	249	finally
    //   461	463	249	finally
    //   55	61	422	java/io/IOException
    //   137	150	422	java/io/IOException
    //   175	186	422	java/io/IOException
    //   203	221	422	java/io/IOException
    //   370	381	422	java/io/IOException
    //   398	416	422	java/io/IOException
    //   472	478	422	java/io/IOException
    //   497	508	422	java/io/IOException
    //   525	536	422	java/io/IOException
    //   551	561	422	java/io/IOException
    //   570	579	422	java/io/IOException
    //   588	603	422	java/io/IOException
    //   617	627	422	java/io/IOException
    //   636	645	422	java/io/IOException
    //   654	664	422	java/io/IOException
    //   676	686	422	java/io/IOException
    //   695	704	422	java/io/IOException
    //   713	728	422	java/io/IOException
    //   742	752	422	java/io/IOException
    //   761	770	422	java/io/IOException
    //   779	789	422	java/io/IOException
    //   810	821	422	java/io/IOException
    //   923	928	947	java/io/IOException
    //   923	928	960	finally
    //   326	331	977	java/io/IOException
    //   326	331	990	finally
    //   826	844	1007	finally
    //   826	844	1011	java/io/IOException
    //   826	844	1018	a/j/b/a/c/g/k
    //   55	61	1052	finally
    //   137	150	1052	finally
    //   175	186	1052	finally
    //   203	221	1052	finally
    //   370	381	1052	finally
    //   398	416	1052	finally
    //   472	478	1052	finally
    //   497	508	1052	finally
    //   525	536	1052	finally
    //   551	561	1052	finally
    //   570	579	1052	finally
    //   588	603	1052	finally
    //   617	627	1052	finally
    //   636	645	1052	finally
    //   654	664	1052	finally
    //   676	686	1052	finally
    //   695	704	1052	finally
    //   713	728	1052	finally
    //   742	752	1052	finally
    //   761	770	1052	finally
    //   779	789	1052	finally
    //   810	821	1052	finally
  }
  
  private a$a(i.a parama)
  {
    super((byte)0);
    this.Ckp = parama.Ckp;
  }
  
  public static a N(InputStream paramInputStream)
  {
    AppMethodBeat.i(121128);
    paramInputStream = (a)Ckq.O(paramInputStream);
    AppMethodBeat.o(121128);
    return paramInputStream;
  }
  
  private void egZ()
  {
    AppMethodBeat.i(121124);
    this.CoZ = Collections.emptyList();
    this.Cpa = Collections.emptyList();
    this.Cpb = n.CrT;
    this.Cpc = a.y.ejq();
    this.Cpd = a.w.eje();
    this.Cno = Collections.emptyList();
    AppMethodBeat.o(121124);
  }
  
  public static a ekO()
  {
    return CoY;
  }
  
  public final void a(f paramf)
  {
    int j = 0;
    AppMethodBeat.i(121126);
    sy();
    int i = 0;
    while (i < this.CoZ.size())
    {
      paramf.a(1, (q)this.CoZ.get(i));
      i += 1;
    }
    i = 0;
    while (i < this.Cpa.size())
    {
      paramf.a(2, (q)this.Cpa.get(i));
      i += 1;
    }
    i = 0;
    while (i < this.Cpb.size())
    {
      paramf.a(3, this.Cpb.VK(i));
      i += 1;
    }
    if ((this.Ckr & 0x1) == 1) {
      paramf.a(4, this.Cpc);
    }
    i = j;
    if ((this.Ckr & 0x2) == 2)
    {
      paramf.a(5, this.Cpd);
      i = j;
    }
    while (i < this.Cno.size())
    {
      paramf.a(6, (q)this.Cno.get(i));
      i += 1;
    }
    paramf.d(this.Ckp);
    AppMethodBeat.o(121126);
  }
  
  public final s<a> egX()
  {
    return Ckq;
  }
  
  public final boolean ekP()
  {
    return (this.Ckr & 0x1) == 1;
  }
  
  public final boolean ekQ()
  {
    return (this.Ckr & 0x2) == 2;
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(121125);
    int i = this.Cku;
    if (i == 1)
    {
      AppMethodBeat.o(121125);
      return true;
    }
    if (i == 0)
    {
      AppMethodBeat.o(121125);
      return false;
    }
    i = 0;
    while (i < this.CoZ.size())
    {
      if (!((a.c)this.CoZ.get(i)).isInitialized())
      {
        this.Cku = 0;
        AppMethodBeat.o(121125);
        return false;
      }
      i += 1;
    }
    i = 0;
    while (i < this.Cpa.size())
    {
      if (!((a.c)this.Cpa.get(i)).isInitialized())
      {
        this.Cku = 0;
        AppMethodBeat.o(121125);
        return false;
      }
      i += 1;
    }
    if ((ekQ()) && (!this.Cpd.isInitialized()))
    {
      this.Cku = 0;
      AppMethodBeat.o(121125);
      return false;
    }
    i = 0;
    while (i < this.Cno.size())
    {
      if (!((a.j.b.a.c.e.a.a)this.Cno.get(i)).isInitialized())
      {
        this.Cku = 0;
        AppMethodBeat.o(121125);
        return false;
      }
      i += 1;
    }
    this.Cku = 1;
    AppMethodBeat.o(121125);
    return true;
  }
  
  public final int sy()
  {
    int m = 0;
    AppMethodBeat.i(121127);
    int i = this.Ckv;
    if (i != -1)
    {
      AppMethodBeat.o(121127);
      return i;
    }
    int j = 0;
    i = 0;
    while (j < this.CoZ.size())
    {
      i += f.c(1, (q)this.CoZ.get(j));
      j += 1;
    }
    j = 0;
    while (j < this.Cpa.size())
    {
      i += f.c(2, (q)this.Cpa.get(j));
      j += 1;
    }
    j = 0;
    int k = 0;
    while (j < this.Cpb.size())
    {
      k += f.c(this.Cpb.VK(j));
      j += 1;
    }
    j = i + k + this.Cpb.size() * 1;
    i = j;
    if ((this.Ckr & 0x1) == 1) {
      i = j + f.c(4, this.Cpc);
    }
    j = i;
    if ((this.Ckr & 0x2) == 2) {
      j = i + f.c(5, this.Cpd);
    }
    i = j;
    j = m;
    while (j < this.Cno.size())
    {
      k = f.c(6, (q)this.Cno.get(j));
      j += 1;
      i = k + i;
    }
    i = this.Ckp.size() + i;
    this.Ckv = i;
    AppMethodBeat.o(121127);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.c.e.b.a.a
 * JD-Core Version:    0.7.0.1
 */