package a.j.b.a.c.e;

import a.j.b.a.c.g.d;
import a.j.b.a.c.g.f;
import a.j.b.a.c.g.i;
import a.j.b.a.c.g.i.a;
import a.j.b.a.c.g.j.b;
import a.j.b.a.c.g.q;
import a.j.b.a.c.g.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

public final class a$a$a$b
  extends i
  implements a.a.a.c
{
  public static s<b> Ckq;
  private static final b Ckz;
  public a.a.a.b.b CkA;
  public long CkB;
  public float CkC;
  public double CkD;
  public int CkE;
  public int CkF;
  public int CkG;
  public a.a CkH;
  public List<b> CkI;
  public int CkJ;
  public int CkK;
  private final d Ckp;
  private int Ckr;
  private byte Cku = -1;
  private int Ckv = -1;
  
  static
  {
    AppMethodBeat.i(120404);
    Ckq = new a.a.a.b.1();
    b localb = new b();
    Ckz = localb;
    localb.egZ();
    AppMethodBeat.o(120404);
  }
  
  private a$a$a$b()
  {
    this.Ckp = d.Cre;
  }
  
  /* Error */
  private a$a$a$b(a.j.b.a.c.g.e parame, a.j.b.a.c.g.g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 72	a/j/b/a/c/g/i:<init>	()V
    //   4: ldc 89
    //   6: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 74	a/j/b/a/c/e/a$a$a$b:Cku	B
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 76	a/j/b/a/c/e/a$a$a$b:Ckv	I
    //   19: aload_0
    //   20: invokespecial 67	a/j/b/a/c/e/a$a$a$b:egZ	()V
    //   23: invokestatic 93	a/j/b/a/c/g/d:emp	()La/j/b/a/c/g/d$b;
    //   26: astore 11
    //   28: aload 11
    //   30: iconst_1
    //   31: invokestatic 99	a/j/b/a/c/g/f:e	(Ljava/io/OutputStream;I)La/j/b/a/c/g/f;
    //   34: astore 12
    //   36: iconst_0
    //   37: istore 6
    //   39: iconst_0
    //   40: istore_3
    //   41: iload 6
    //   43: ifne +913 -> 956
    //   46: iload_3
    //   47: istore 7
    //   49: iload_3
    //   50: istore 5
    //   52: iload_3
    //   53: istore 8
    //   55: aload_1
    //   56: invokevirtual 105	a/j/b/a/c/g/e:sk	()I
    //   59: istore 4
    //   61: iload 4
    //   63: lookupswitch	default:+1005->1068, 0:+1008->1071, 8:+133->196, 16:+356->419, 29:+398->461, 33:+440->503, 40:+483->546, 48:+523->586, 56:+563->626, 66:+603->666, 74:+734->797, 80:+811->874, 88:+852->915
    //   169: istore 7
    //   171: iload_3
    //   172: istore 5
    //   174: iload_3
    //   175: istore 8
    //   177: aload_0
    //   178: aload_1
    //   179: aload 12
    //   181: aload_2
    //   182: iload 4
    //   184: invokevirtual 109	a/j/b/a/c/e/a$a$a$b:a	(La/j/b/a/c/g/e;La/j/b/a/c/g/f;La/j/b/a/c/g/g;I)Z
    //   187: ifne -146 -> 41
    //   190: iconst_1
    //   191: istore 6
    //   193: goto -152 -> 41
    //   196: iload_3
    //   197: istore 7
    //   199: iload_3
    //   200: istore 5
    //   202: iload_3
    //   203: istore 8
    //   205: aload_1
    //   206: invokevirtual 112	a/j/b/a/c/g/e:sl	()I
    //   209: istore 9
    //   211: iload_3
    //   212: istore 7
    //   214: iload_3
    //   215: istore 5
    //   217: iload_3
    //   218: istore 8
    //   220: iload 9
    //   222: invokestatic 116	a/j/b/a/c/e/a$a$a$b$b:Ud	(I)La/j/b/a/c/e/a$a$a$b$b;
    //   225: astore 10
    //   227: aload 10
    //   229: ifnonnull +112 -> 341
    //   232: iload_3
    //   233: istore 7
    //   235: iload_3
    //   236: istore 5
    //   238: iload_3
    //   239: istore 8
    //   241: aload 12
    //   243: iload 4
    //   245: invokevirtual 119	a/j/b/a/c/g/f:eX	(I)V
    //   248: iload_3
    //   249: istore 7
    //   251: iload_3
    //   252: istore 5
    //   254: iload_3
    //   255: istore 8
    //   257: aload 12
    //   259: iload 9
    //   261: invokevirtual 119	a/j/b/a/c/g/f:eX	(I)V
    //   264: goto -223 -> 41
    //   267: astore_1
    //   268: iload 7
    //   270: istore 5
    //   272: aload_1
    //   273: aload_0
    //   274: putfield 123	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   277: iload 7
    //   279: istore 5
    //   281: ldc 89
    //   283: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   286: iload 7
    //   288: istore 5
    //   290: aload_1
    //   291: athrow
    //   292: astore_1
    //   293: iload 5
    //   295: sipush 256
    //   298: iand
    //   299: sipush 256
    //   302: if_icmpne +14 -> 316
    //   305: aload_0
    //   306: aload_0
    //   307: getfield 125	a/j/b/a/c/e/a$a$a$b:CkI	Ljava/util/List;
    //   310: invokestatic 131	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   313: putfield 125	a/j/b/a/c/e/a$a$a$b:CkI	Ljava/util/List;
    //   316: aload 12
    //   318: invokevirtual 134	a/j/b/a/c/g/f:flush	()V
    //   321: aload_0
    //   322: aload 11
    //   324: invokevirtual 140	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   327: putfield 83	a/j/b/a/c/e/a$a$a$b:Ckp	La/j/b/a/c/g/d;
    //   330: aload_0
    //   331: invokevirtual 143	a/j/b/a/c/e/a$a$a$b:emL	()V
    //   334: ldc 89
    //   336: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   339: aload_1
    //   340: athrow
    //   341: iload_3
    //   342: istore 7
    //   344: iload_3
    //   345: istore 5
    //   347: iload_3
    //   348: istore 8
    //   350: aload_0
    //   351: aload_0
    //   352: getfield 145	a/j/b/a/c/e/a$a$a$b:Ckr	I
    //   355: iconst_1
    //   356: ior
    //   357: putfield 145	a/j/b/a/c/e/a$a$a$b:Ckr	I
    //   360: iload_3
    //   361: istore 7
    //   363: iload_3
    //   364: istore 5
    //   366: iload_3
    //   367: istore 8
    //   369: aload_0
    //   370: aload 10
    //   372: putfield 147	a/j/b/a/c/e/a$a$a$b:CkA	La/j/b/a/c/e/a$a$a$b$b;
    //   375: goto -334 -> 41
    //   378: astore_1
    //   379: iload 8
    //   381: istore 5
    //   383: new 86	a/j/b/a/c/g/k
    //   386: dup
    //   387: aload_1
    //   388: invokevirtual 151	java/io/IOException:getMessage	()Ljava/lang/String;
    //   391: invokespecial 154	a/j/b/a/c/g/k:<init>	(Ljava/lang/String;)V
    //   394: astore_1
    //   395: iload 8
    //   397: istore 5
    //   399: aload_1
    //   400: aload_0
    //   401: putfield 123	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   404: iload 8
    //   406: istore 5
    //   408: ldc 89
    //   410: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   413: iload 8
    //   415: istore 5
    //   417: aload_1
    //   418: athrow
    //   419: iload_3
    //   420: istore 7
    //   422: iload_3
    //   423: istore 5
    //   425: iload_3
    //   426: istore 8
    //   428: aload_0
    //   429: aload_0
    //   430: getfield 145	a/j/b/a/c/e/a$a$a$b:Ckr	I
    //   433: iconst_2
    //   434: ior
    //   435: putfield 145	a/j/b/a/c/e/a$a$a$b:Ckr	I
    //   438: iload_3
    //   439: istore 7
    //   441: iload_3
    //   442: istore 5
    //   444: iload_3
    //   445: istore 8
    //   447: aload_0
    //   448: aload_1
    //   449: invokevirtual 158	a/j/b/a/c/g/e:sm	()J
    //   452: invokestatic 162	a/j/b/a/c/g/e:pp	(J)J
    //   455: putfield 164	a/j/b/a/c/e/a$a$a$b:CkB	J
    //   458: goto -417 -> 41
    //   461: iload_3
    //   462: istore 7
    //   464: iload_3
    //   465: istore 5
    //   467: iload_3
    //   468: istore 8
    //   470: aload_0
    //   471: aload_0
    //   472: getfield 145	a/j/b/a/c/e/a$a$a$b:Ckr	I
    //   475: iconst_4
    //   476: ior
    //   477: putfield 145	a/j/b/a/c/e/a$a$a$b:Ckr	I
    //   480: iload_3
    //   481: istore 7
    //   483: iload_3
    //   484: istore 5
    //   486: iload_3
    //   487: istore 8
    //   489: aload_0
    //   490: aload_1
    //   491: invokevirtual 167	a/j/b/a/c/g/e:emx	()I
    //   494: invokestatic 173	java/lang/Float:intBitsToFloat	(I)F
    //   497: putfield 175	a/j/b/a/c/e/a$a$a$b:CkC	F
    //   500: goto -459 -> 41
    //   503: iload_3
    //   504: istore 7
    //   506: iload_3
    //   507: istore 5
    //   509: iload_3
    //   510: istore 8
    //   512: aload_0
    //   513: aload_0
    //   514: getfield 145	a/j/b/a/c/e/a$a$a$b:Ckr	I
    //   517: bipush 8
    //   519: ior
    //   520: putfield 145	a/j/b/a/c/e/a$a$a$b:Ckr	I
    //   523: iload_3
    //   524: istore 7
    //   526: iload_3
    //   527: istore 5
    //   529: iload_3
    //   530: istore 8
    //   532: aload_0
    //   533: aload_1
    //   534: invokevirtual 178	a/j/b/a/c/g/e:emy	()J
    //   537: invokestatic 184	java/lang/Double:longBitsToDouble	(J)D
    //   540: putfield 186	a/j/b/a/c/e/a$a$a$b:CkD	D
    //   543: goto -502 -> 41
    //   546: iload_3
    //   547: istore 7
    //   549: iload_3
    //   550: istore 5
    //   552: iload_3
    //   553: istore 8
    //   555: aload_0
    //   556: aload_0
    //   557: getfield 145	a/j/b/a/c/e/a$a$a$b:Ckr	I
    //   560: bipush 16
    //   562: ior
    //   563: putfield 145	a/j/b/a/c/e/a$a$a$b:Ckr	I
    //   566: iload_3
    //   567: istore 7
    //   569: iload_3
    //   570: istore 5
    //   572: iload_3
    //   573: istore 8
    //   575: aload_0
    //   576: aload_1
    //   577: invokevirtual 112	a/j/b/a/c/g/e:sl	()I
    //   580: putfield 188	a/j/b/a/c/e/a$a$a$b:CkE	I
    //   583: goto -542 -> 41
    //   586: iload_3
    //   587: istore 7
    //   589: iload_3
    //   590: istore 5
    //   592: iload_3
    //   593: istore 8
    //   595: aload_0
    //   596: aload_0
    //   597: getfield 145	a/j/b/a/c/e/a$a$a$b:Ckr	I
    //   600: bipush 32
    //   602: ior
    //   603: putfield 145	a/j/b/a/c/e/a$a$a$b:Ckr	I
    //   606: iload_3
    //   607: istore 7
    //   609: iload_3
    //   610: istore 5
    //   612: iload_3
    //   613: istore 8
    //   615: aload_0
    //   616: aload_1
    //   617: invokevirtual 112	a/j/b/a/c/g/e:sl	()I
    //   620: putfield 190	a/j/b/a/c/e/a$a$a$b:CkF	I
    //   623: goto -582 -> 41
    //   626: iload_3
    //   627: istore 7
    //   629: iload_3
    //   630: istore 5
    //   632: iload_3
    //   633: istore 8
    //   635: aload_0
    //   636: aload_0
    //   637: getfield 145	a/j/b/a/c/e/a$a$a$b:Ckr	I
    //   640: bipush 64
    //   642: ior
    //   643: putfield 145	a/j/b/a/c/e/a$a$a$b:Ckr	I
    //   646: iload_3
    //   647: istore 7
    //   649: iload_3
    //   650: istore 5
    //   652: iload_3
    //   653: istore 8
    //   655: aload_0
    //   656: aload_1
    //   657: invokevirtual 112	a/j/b/a/c/g/e:sl	()I
    //   660: putfield 192	a/j/b/a/c/e/a$a$a$b:CkG	I
    //   663: goto -622 -> 41
    //   666: iload_3
    //   667: istore 7
    //   669: iload_3
    //   670: istore 5
    //   672: iload_3
    //   673: istore 8
    //   675: aload_0
    //   676: getfield 145	a/j/b/a/c/e/a$a$a$b:Ckr	I
    //   679: sipush 128
    //   682: iand
    //   683: sipush 128
    //   686: if_icmpne +376 -> 1062
    //   689: iload_3
    //   690: istore 7
    //   692: iload_3
    //   693: istore 5
    //   695: iload_3
    //   696: istore 8
    //   698: aload_0
    //   699: getfield 194	a/j/b/a/c/e/a$a$a$b:CkH	La/j/b/a/c/e/a$a;
    //   702: invokevirtual 200	a/j/b/a/c/e/a$a:eha	()La/j/b/a/c/e/a$a$c;
    //   705: astore 10
    //   707: iload_3
    //   708: istore 7
    //   710: iload_3
    //   711: istore 5
    //   713: iload_3
    //   714: istore 8
    //   716: aload_0
    //   717: aload_1
    //   718: getstatic 201	a/j/b/a/c/e/a$a:Ckq	La/j/b/a/c/g/s;
    //   721: aload_2
    //   722: invokevirtual 204	a/j/b/a/c/g/e:a	(La/j/b/a/c/g/s;La/j/b/a/c/g/g;)La/j/b/a/c/g/q;
    //   725: checkcast 196	a/j/b/a/c/e/a$a
    //   728: putfield 194	a/j/b/a/c/e/a$a$a$b:CkH	La/j/b/a/c/e/a$a;
    //   731: aload 10
    //   733: ifnull +40 -> 773
    //   736: iload_3
    //   737: istore 7
    //   739: iload_3
    //   740: istore 5
    //   742: iload_3
    //   743: istore 8
    //   745: aload 10
    //   747: aload_0
    //   748: getfield 194	a/j/b/a/c/e/a$a$a$b:CkH	La/j/b/a/c/e/a$a;
    //   751: invokevirtual 209	a/j/b/a/c/e/a$a$c:e	(La/j/b/a/c/e/a$a;)La/j/b/a/c/e/a$a$c;
    //   754: pop
    //   755: iload_3
    //   756: istore 7
    //   758: iload_3
    //   759: istore 5
    //   761: iload_3
    //   762: istore 8
    //   764: aload_0
    //   765: aload 10
    //   767: invokevirtual 213	a/j/b/a/c/e/a$a$c:ehE	()La/j/b/a/c/e/a$a;
    //   770: putfield 194	a/j/b/a/c/e/a$a$a$b:CkH	La/j/b/a/c/e/a$a;
    //   773: iload_3
    //   774: istore 7
    //   776: iload_3
    //   777: istore 5
    //   779: iload_3
    //   780: istore 8
    //   782: aload_0
    //   783: aload_0
    //   784: getfield 145	a/j/b/a/c/e/a$a$a$b:Ckr	I
    //   787: sipush 128
    //   790: ior
    //   791: putfield 145	a/j/b/a/c/e/a$a$a$b:Ckr	I
    //   794: goto -753 -> 41
    //   797: iload_3
    //   798: istore 4
    //   800: iload_3
    //   801: sipush 256
    //   804: iand
    //   805: sipush 256
    //   808: if_icmpeq +30 -> 838
    //   811: iload_3
    //   812: istore 7
    //   814: iload_3
    //   815: istore 5
    //   817: iload_3
    //   818: istore 8
    //   820: aload_0
    //   821: new 215	java/util/ArrayList
    //   824: dup
    //   825: invokespecial 216	java/util/ArrayList:<init>	()V
    //   828: putfield 125	a/j/b/a/c/e/a$a$a$b:CkI	Ljava/util/List;
    //   831: iload_3
    //   832: sipush 256
    //   835: ior
    //   836: istore 4
    //   838: iload 4
    //   840: istore 7
    //   842: iload 4
    //   844: istore 5
    //   846: iload 4
    //   848: istore 8
    //   850: aload_0
    //   851: getfield 125	a/j/b/a/c/e/a$a$a$b:CkI	Ljava/util/List;
    //   854: aload_1
    //   855: getstatic 61	a/j/b/a/c/e/a$a$a$b:Ckq	La/j/b/a/c/g/s;
    //   858: aload_2
    //   859: invokevirtual 204	a/j/b/a/c/g/e:a	(La/j/b/a/c/g/s;La/j/b/a/c/g/g;)La/j/b/a/c/g/q;
    //   862: invokeinterface 222 2 0
    //   867: pop
    //   868: iload 4
    //   870: istore_3
    //   871: goto -830 -> 41
    //   874: iload_3
    //   875: istore 7
    //   877: iload_3
    //   878: istore 5
    //   880: iload_3
    //   881: istore 8
    //   883: aload_0
    //   884: aload_0
    //   885: getfield 145	a/j/b/a/c/e/a$a$a$b:Ckr	I
    //   888: sipush 512
    //   891: ior
    //   892: putfield 145	a/j/b/a/c/e/a$a$a$b:Ckr	I
    //   895: iload_3
    //   896: istore 7
    //   898: iload_3
    //   899: istore 5
    //   901: iload_3
    //   902: istore 8
    //   904: aload_0
    //   905: aload_1
    //   906: invokevirtual 112	a/j/b/a/c/g/e:sl	()I
    //   909: putfield 224	a/j/b/a/c/e/a$a$a$b:CkK	I
    //   912: goto -871 -> 41
    //   915: iload_3
    //   916: istore 7
    //   918: iload_3
    //   919: istore 5
    //   921: iload_3
    //   922: istore 8
    //   924: aload_0
    //   925: aload_0
    //   926: getfield 145	a/j/b/a/c/e/a$a$a$b:Ckr	I
    //   929: sipush 256
    //   932: ior
    //   933: putfield 145	a/j/b/a/c/e/a$a$a$b:Ckr	I
    //   936: iload_3
    //   937: istore 7
    //   939: iload_3
    //   940: istore 5
    //   942: iload_3
    //   943: istore 8
    //   945: aload_0
    //   946: aload_1
    //   947: invokevirtual 112	a/j/b/a/c/g/e:sl	()I
    //   950: putfield 226	a/j/b/a/c/e/a$a$a$b:CkJ	I
    //   953: goto -912 -> 41
    //   956: iload_3
    //   957: sipush 256
    //   960: iand
    //   961: sipush 256
    //   964: if_icmpne +14 -> 978
    //   967: aload_0
    //   968: aload_0
    //   969: getfield 125	a/j/b/a/c/e/a$a$a$b:CkI	Ljava/util/List;
    //   972: invokestatic 131	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   975: putfield 125	a/j/b/a/c/e/a$a$a$b:CkI	Ljava/util/List;
    //   978: aload 12
    //   980: invokevirtual 134	a/j/b/a/c/g/f:flush	()V
    //   983: aload_0
    //   984: aload 11
    //   986: invokevirtual 140	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   989: putfield 83	a/j/b/a/c/e/a$a$a$b:Ckp	La/j/b/a/c/g/d;
    //   992: aload_0
    //   993: invokevirtual 143	a/j/b/a/c/e/a$a$a$b:emL	()V
    //   996: ldc 89
    //   998: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1001: return
    //   1002: astore_1
    //   1003: aload_0
    //   1004: aload 11
    //   1006: invokevirtual 140	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   1009: putfield 83	a/j/b/a/c/e/a$a$a$b:Ckp	La/j/b/a/c/g/d;
    //   1012: goto -20 -> 992
    //   1015: astore_1
    //   1016: aload_0
    //   1017: aload 11
    //   1019: invokevirtual 140	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   1022: putfield 83	a/j/b/a/c/e/a$a$a$b:Ckp	La/j/b/a/c/g/d;
    //   1025: ldc 89
    //   1027: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1030: aload_1
    //   1031: athrow
    //   1032: astore_2
    //   1033: aload_0
    //   1034: aload 11
    //   1036: invokevirtual 140	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   1039: putfield 83	a/j/b/a/c/e/a$a$a$b:Ckp	La/j/b/a/c/g/d;
    //   1042: goto -712 -> 330
    //   1045: astore_1
    //   1046: aload_0
    //   1047: aload 11
    //   1049: invokevirtual 140	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   1052: putfield 83	a/j/b/a/c/e/a$a$a$b:Ckp	La/j/b/a/c/g/d;
    //   1055: ldc 89
    //   1057: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1060: aload_1
    //   1061: athrow
    //   1062: aconst_null
    //   1063: astore 10
    //   1065: goto -358 -> 707
    //   1068: goto -900 -> 168
    //   1071: iconst_1
    //   1072: istore 6
    //   1074: goto -1033 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1077	0	this	b
    //   0	1077	1	parame	a.j.b.a.c.g.e
    //   0	1077	2	paramg	a.j.b.a.c.g.g
    //   40	921	3	i	int
    //   59	810	4	j	int
    //   50	891	5	k	int
    //   37	1036	6	m	int
    //   47	891	7	n	int
    //   53	891	8	i1	int
    //   209	51	9	i2	int
    //   225	839	10	localObject	Object
    //   26	1022	11	localb	a.j.b.a.c.g.d.b
    //   34	945	12	localf	f
    // Exception table:
    //   from	to	target	type
    //   55	61	267	a/j/b/a/c/g/k
    //   177	190	267	a/j/b/a/c/g/k
    //   205	211	267	a/j/b/a/c/g/k
    //   220	227	267	a/j/b/a/c/g/k
    //   241	248	267	a/j/b/a/c/g/k
    //   257	264	267	a/j/b/a/c/g/k
    //   350	360	267	a/j/b/a/c/g/k
    //   369	375	267	a/j/b/a/c/g/k
    //   428	438	267	a/j/b/a/c/g/k
    //   447	458	267	a/j/b/a/c/g/k
    //   470	480	267	a/j/b/a/c/g/k
    //   489	500	267	a/j/b/a/c/g/k
    //   512	523	267	a/j/b/a/c/g/k
    //   532	543	267	a/j/b/a/c/g/k
    //   555	566	267	a/j/b/a/c/g/k
    //   575	583	267	a/j/b/a/c/g/k
    //   595	606	267	a/j/b/a/c/g/k
    //   615	623	267	a/j/b/a/c/g/k
    //   635	646	267	a/j/b/a/c/g/k
    //   655	663	267	a/j/b/a/c/g/k
    //   675	689	267	a/j/b/a/c/g/k
    //   698	707	267	a/j/b/a/c/g/k
    //   716	731	267	a/j/b/a/c/g/k
    //   745	755	267	a/j/b/a/c/g/k
    //   764	773	267	a/j/b/a/c/g/k
    //   782	794	267	a/j/b/a/c/g/k
    //   820	831	267	a/j/b/a/c/g/k
    //   850	868	267	a/j/b/a/c/g/k
    //   883	895	267	a/j/b/a/c/g/k
    //   904	912	267	a/j/b/a/c/g/k
    //   924	936	267	a/j/b/a/c/g/k
    //   945	953	267	a/j/b/a/c/g/k
    //   55	61	292	finally
    //   177	190	292	finally
    //   205	211	292	finally
    //   220	227	292	finally
    //   241	248	292	finally
    //   257	264	292	finally
    //   272	277	292	finally
    //   281	286	292	finally
    //   290	292	292	finally
    //   350	360	292	finally
    //   369	375	292	finally
    //   383	395	292	finally
    //   399	404	292	finally
    //   408	413	292	finally
    //   417	419	292	finally
    //   428	438	292	finally
    //   447	458	292	finally
    //   470	480	292	finally
    //   489	500	292	finally
    //   512	523	292	finally
    //   532	543	292	finally
    //   555	566	292	finally
    //   575	583	292	finally
    //   595	606	292	finally
    //   615	623	292	finally
    //   635	646	292	finally
    //   655	663	292	finally
    //   675	689	292	finally
    //   698	707	292	finally
    //   716	731	292	finally
    //   745	755	292	finally
    //   764	773	292	finally
    //   782	794	292	finally
    //   820	831	292	finally
    //   850	868	292	finally
    //   883	895	292	finally
    //   904	912	292	finally
    //   924	936	292	finally
    //   945	953	292	finally
    //   55	61	378	java/io/IOException
    //   177	190	378	java/io/IOException
    //   205	211	378	java/io/IOException
    //   220	227	378	java/io/IOException
    //   241	248	378	java/io/IOException
    //   257	264	378	java/io/IOException
    //   350	360	378	java/io/IOException
    //   369	375	378	java/io/IOException
    //   428	438	378	java/io/IOException
    //   447	458	378	java/io/IOException
    //   470	480	378	java/io/IOException
    //   489	500	378	java/io/IOException
    //   512	523	378	java/io/IOException
    //   532	543	378	java/io/IOException
    //   555	566	378	java/io/IOException
    //   575	583	378	java/io/IOException
    //   595	606	378	java/io/IOException
    //   615	623	378	java/io/IOException
    //   635	646	378	java/io/IOException
    //   655	663	378	java/io/IOException
    //   675	689	378	java/io/IOException
    //   698	707	378	java/io/IOException
    //   716	731	378	java/io/IOException
    //   745	755	378	java/io/IOException
    //   764	773	378	java/io/IOException
    //   782	794	378	java/io/IOException
    //   820	831	378	java/io/IOException
    //   850	868	378	java/io/IOException
    //   883	895	378	java/io/IOException
    //   904	912	378	java/io/IOException
    //   924	936	378	java/io/IOException
    //   945	953	378	java/io/IOException
    //   978	983	1002	java/io/IOException
    //   978	983	1015	finally
    //   316	321	1032	java/io/IOException
    //   316	321	1045	finally
  }
  
  private a$a$a$b(i.a parama)
  {
    super((byte)0);
    this.Ckp = parama.Ckp;
  }
  
  public static a.a.a.b.a b(b paramb)
  {
    AppMethodBeat.i(120401);
    paramb = a.a.a.b.a.ehB().e(paramb);
    AppMethodBeat.o(120401);
    return paramb;
  }
  
  private void egZ()
  {
    AppMethodBeat.i(120397);
    this.CkA = a.a.a.b.b.CkL;
    this.CkB = 0L;
    this.CkC = 0.0F;
    this.CkD = 0.0D;
    this.CkE = 0;
    this.CkF = 0;
    this.CkG = 0;
    this.CkH = a.a.egW();
    this.CkI = Collections.emptyList();
    this.CkJ = 0;
    this.CkK = 0;
    AppMethodBeat.o(120397);
  }
  
  public static b ehn()
  {
    return Ckz;
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(120399);
    sy();
    if ((this.Ckr & 0x1) == 1) {
      paramf.iG(1, this.CkA.value);
    }
    if ((this.Ckr & 0x2) == 2)
    {
      long l = this.CkB;
      paramf.bn(2, 0);
      paramf.pq(l);
    }
    if ((this.Ckr & 0x4) == 4)
    {
      float f = this.CkC;
      paramf.bn(3, 5);
      paramf.bH(f);
    }
    if ((this.Ckr & 0x8) == 8)
    {
      double d = this.CkD;
      paramf.bn(4, 1);
      paramf.J(d);
    }
    if ((this.Ckr & 0x10) == 16) {
      paramf.bj(5, this.CkE);
    }
    if ((this.Ckr & 0x20) == 32) {
      paramf.bj(6, this.CkF);
    }
    if ((this.Ckr & 0x40) == 64) {
      paramf.bj(7, this.CkG);
    }
    if ((this.Ckr & 0x80) == 128) {
      paramf.a(8, this.CkH);
    }
    int i = 0;
    while (i < this.CkI.size())
    {
      paramf.a(9, (q)this.CkI.get(i));
      i += 1;
    }
    if ((this.Ckr & 0x200) == 512) {
      paramf.bj(10, this.CkK);
    }
    if ((this.Ckr & 0x100) == 256) {
      paramf.bj(11, this.CkJ);
    }
    paramf.d(this.Ckp);
    AppMethodBeat.o(120399);
  }
  
  public final s<b> egX()
  {
    return Ckq;
  }
  
  public final boolean eho()
  {
    return (this.Ckr & 0x1) == 1;
  }
  
  public final boolean ehp()
  {
    return (this.Ckr & 0x2) == 2;
  }
  
  public final boolean ehq()
  {
    return (this.Ckr & 0x4) == 4;
  }
  
  public final boolean ehr()
  {
    return (this.Ckr & 0x8) == 8;
  }
  
  public final boolean ehs()
  {
    return (this.Ckr & 0x10) == 16;
  }
  
  public final boolean eht()
  {
    return (this.Ckr & 0x20) == 32;
  }
  
  public final boolean ehu()
  {
    return (this.Ckr & 0x40) == 64;
  }
  
  public final boolean ehv()
  {
    return (this.Ckr & 0x80) == 128;
  }
  
  public final boolean ehw()
  {
    return (this.Ckr & 0x100) == 256;
  }
  
  public final boolean ehx()
  {
    return (this.Ckr & 0x200) == 512;
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(120398);
    int i = this.Cku;
    if (i == 1)
    {
      AppMethodBeat.o(120398);
      return true;
    }
    if (i == 0)
    {
      AppMethodBeat.o(120398);
      return false;
    }
    if ((ehv()) && (!this.CkH.isInitialized()))
    {
      this.Cku = 0;
      AppMethodBeat.o(120398);
      return false;
    }
    i = 0;
    while (i < this.CkI.size())
    {
      if (!((b)this.CkI.get(i)).isInitialized())
      {
        this.Cku = 0;
        AppMethodBeat.o(120398);
        return false;
      }
      i += 1;
    }
    this.Cku = 1;
    AppMethodBeat.o(120398);
    return true;
  }
  
  public final int sy()
  {
    int k = 0;
    AppMethodBeat.i(120400);
    int i = this.Ckv;
    if (i != -1)
    {
      AppMethodBeat.o(120400);
      return i;
    }
    if ((this.Ckr & 0x1) == 1) {}
    for (int j = f.iH(1, this.CkA.value) + 0;; j = 0)
    {
      i = j;
      if ((this.Ckr & 0x2) == 2) {
        i = j + f.pr(this.CkB);
      }
      j = i;
      if ((this.Ckr & 0x4) == 4) {
        j = i + (f.eW(3) + 4);
      }
      i = j;
      if ((this.Ckr & 0x8) == 8) {
        i = j + (f.eW(4) + 8);
      }
      j = i;
      if ((this.Ckr & 0x10) == 16) {
        j = i + f.bl(5, this.CkE);
      }
      i = j;
      if ((this.Ckr & 0x20) == 32) {
        i = j + f.bl(6, this.CkF);
      }
      j = i;
      if ((this.Ckr & 0x40) == 64) {
        j = i + f.bl(7, this.CkG);
      }
      i = j;
      if ((this.Ckr & 0x80) == 128) {
        i = j + f.c(8, this.CkH);
      }
      j = k;
      while (j < this.CkI.size())
      {
        k = f.c(9, (q)this.CkI.get(j));
        j += 1;
        i = k + i;
      }
      j = i;
      if ((this.Ckr & 0x200) == 512) {
        j = i + f.bl(10, this.CkK);
      }
      i = j;
      if ((this.Ckr & 0x100) == 256) {
        i = j + f.bl(11, this.CkJ);
      }
      i = this.Ckp.size() + i;
      this.Ckv = i;
      AppMethodBeat.o(120400);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.c.e.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */