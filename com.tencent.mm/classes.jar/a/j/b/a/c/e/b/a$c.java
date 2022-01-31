package a.j.b.a.c.e.b;

import a.j.b.a.c.g.d;
import a.j.b.a.c.g.f;
import a.j.b.a.c.g.i;
import a.j.b.a.c.g.i.a;
import a.j.b.a.c.g.n;
import a.j.b.a.c.g.o;
import a.j.b.a.c.g.s;
import a.j.b.a.c.g.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

public final class a$c
  extends i
  implements a.d
{
  public static s<c> Ckq;
  private static final c Cpe;
  private final d Ckp;
  private int Ckr;
  private byte Cku = -1;
  private int Ckv = -1;
  private Object Cpf;
  public o Cpg;
  public List<Integer> Cph;
  private int Cpi = -1;
  public o Cpj;
  public o Cpk;
  public List<Integer> Cpl;
  private int Cpm = -1;
  
  static
  {
    AppMethodBeat.i(121162);
    Ckq = new a.c.1();
    c localc = new c();
    Cpe = localc;
    localc.egZ();
    AppMethodBeat.o(121162);
  }
  
  private a$c()
  {
    this.Ckp = d.Cre;
  }
  
  /* Error */
  private a$c(a.j.b.a.c.g.e parame, a.j.b.a.c.g.g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 62	a/j/b/a/c/g/i:<init>	()V
    //   4: ldc 83
    //   6: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 64	a/j/b/a/c/e/b/a$c:Cpi	I
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 66	a/j/b/a/c/e/b/a$c:Cpm	I
    //   19: aload_0
    //   20: iconst_m1
    //   21: putfield 68	a/j/b/a/c/e/b/a$c:Cku	B
    //   24: aload_0
    //   25: iconst_m1
    //   26: putfield 70	a/j/b/a/c/e/b/a$c:Ckv	I
    //   29: aload_0
    //   30: invokespecial 57	a/j/b/a/c/e/b/a$c:egZ	()V
    //   33: invokestatic 87	a/j/b/a/c/g/d:emp	()La/j/b/a/c/g/d$b;
    //   36: astore 10
    //   38: aload 10
    //   40: iconst_1
    //   41: invokestatic 93	a/j/b/a/c/g/f:e	(Ljava/io/OutputStream;I)La/j/b/a/c/g/f;
    //   44: astore 11
    //   46: iconst_0
    //   47: istore 7
    //   49: iconst_0
    //   50: istore_3
    //   51: iload 7
    //   53: ifne +1037 -> 1090
    //   56: iload_3
    //   57: istore 5
    //   59: iload_3
    //   60: istore 6
    //   62: iload_3
    //   63: istore 8
    //   65: aload_1
    //   66: invokevirtual 99	a/j/b/a/c/g/e:sk	()I
    //   69: istore 4
    //   71: iload 4
    //   73: lookupswitch	default:+1243->1316, 0:+1246->1319, 10:+111->184, 18:+313->386, 24:+388->461, 26:+454->527, 34:+593->666, 42:+671->744, 48:+749->822, 50:+818->891
    //   157: istore 5
    //   159: iload_3
    //   160: istore 6
    //   162: iload_3
    //   163: istore 8
    //   165: aload_0
    //   166: aload_1
    //   167: aload 11
    //   169: aload_2
    //   170: iload 4
    //   172: invokevirtual 103	a/j/b/a/c/e/b/a$c:a	(La/j/b/a/c/g/e;La/j/b/a/c/g/f;La/j/b/a/c/g/g;I)Z
    //   175: ifne -124 -> 51
    //   178: iconst_1
    //   179: istore 7
    //   181: goto -130 -> 51
    //   184: iload_3
    //   185: istore 5
    //   187: iload_3
    //   188: istore 6
    //   190: iload_3
    //   191: istore 8
    //   193: aload_1
    //   194: invokevirtual 107	a/j/b/a/c/g/e:emv	()La/j/b/a/c/g/d;
    //   197: astore 12
    //   199: iload_3
    //   200: istore 5
    //   202: iload_3
    //   203: istore 6
    //   205: iload_3
    //   206: istore 8
    //   208: aload_0
    //   209: aload_0
    //   210: getfield 109	a/j/b/a/c/e/b/a$c:Ckr	I
    //   213: iconst_1
    //   214: ior
    //   215: putfield 109	a/j/b/a/c/e/b/a$c:Ckr	I
    //   218: iload_3
    //   219: istore 5
    //   221: iload_3
    //   222: istore 6
    //   224: iload_3
    //   225: istore 8
    //   227: aload_0
    //   228: aload 12
    //   230: putfield 111	a/j/b/a/c/e/b/a$c:Cpf	Ljava/lang/Object;
    //   233: goto -182 -> 51
    //   236: astore_1
    //   237: iload 5
    //   239: istore_3
    //   240: aload_1
    //   241: aload_0
    //   242: putfield 115	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   245: iload 5
    //   247: istore_3
    //   248: ldc 83
    //   250: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   253: iload 5
    //   255: istore_3
    //   256: aload_1
    //   257: athrow
    //   258: astore_1
    //   259: iload_3
    //   260: iconst_2
    //   261: iand
    //   262: iconst_2
    //   263: if_icmpne +16 -> 279
    //   266: aload_0
    //   267: aload_0
    //   268: getfield 117	a/j/b/a/c/e/b/a$c:Cpg	La/j/b/a/c/g/o;
    //   271: invokeinterface 123 1 0
    //   276: putfield 117	a/j/b/a/c/e/b/a$c:Cpg	La/j/b/a/c/g/o;
    //   279: iload_3
    //   280: iconst_4
    //   281: iand
    //   282: iconst_4
    //   283: if_icmpne +14 -> 297
    //   286: aload_0
    //   287: aload_0
    //   288: getfield 125	a/j/b/a/c/e/b/a$c:Cph	Ljava/util/List;
    //   291: invokestatic 131	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   294: putfield 125	a/j/b/a/c/e/b/a$c:Cph	Ljava/util/List;
    //   297: iload_3
    //   298: bipush 8
    //   300: iand
    //   301: bipush 8
    //   303: if_icmpne +16 -> 319
    //   306: aload_0
    //   307: aload_0
    //   308: getfield 133	a/j/b/a/c/e/b/a$c:Cpj	La/j/b/a/c/g/o;
    //   311: invokeinterface 123 1 0
    //   316: putfield 133	a/j/b/a/c/e/b/a$c:Cpj	La/j/b/a/c/g/o;
    //   319: iload_3
    //   320: bipush 16
    //   322: iand
    //   323: bipush 16
    //   325: if_icmpne +16 -> 341
    //   328: aload_0
    //   329: aload_0
    //   330: getfield 135	a/j/b/a/c/e/b/a$c:Cpk	La/j/b/a/c/g/o;
    //   333: invokeinterface 123 1 0
    //   338: putfield 135	a/j/b/a/c/e/b/a$c:Cpk	La/j/b/a/c/g/o;
    //   341: iload_3
    //   342: bipush 32
    //   344: iand
    //   345: bipush 32
    //   347: if_icmpne +14 -> 361
    //   350: aload_0
    //   351: aload_0
    //   352: getfield 137	a/j/b/a/c/e/b/a$c:Cpl	Ljava/util/List;
    //   355: invokestatic 131	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   358: putfield 137	a/j/b/a/c/e/b/a$c:Cpl	Ljava/util/List;
    //   361: aload 11
    //   363: invokevirtual 140	a/j/b/a/c/g/f:flush	()V
    //   366: aload_0
    //   367: aload 10
    //   369: invokevirtual 145	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   372: putfield 77	a/j/b/a/c/e/b/a$c:Ckp	La/j/b/a/c/g/d;
    //   375: aload_0
    //   376: invokevirtual 148	a/j/b/a/c/e/b/a$c:emL	()V
    //   379: ldc 83
    //   381: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   384: aload_1
    //   385: athrow
    //   386: iload_3
    //   387: istore 5
    //   389: iload_3
    //   390: istore 6
    //   392: iload_3
    //   393: istore 8
    //   395: aload_1
    //   396: invokevirtual 107	a/j/b/a/c/g/e:emv	()La/j/b/a/c/g/d;
    //   399: astore 12
    //   401: iload_3
    //   402: iconst_2
    //   403: iand
    //   404: iconst_2
    //   405: if_icmpeq +905 -> 1310
    //   408: iload_3
    //   409: istore 5
    //   411: iload_3
    //   412: istore 6
    //   414: iload_3
    //   415: istore 8
    //   417: aload_0
    //   418: new 150	a/j/b/a/c/g/n
    //   421: dup
    //   422: invokespecial 151	a/j/b/a/c/g/n:<init>	()V
    //   425: putfield 117	a/j/b/a/c/e/b/a$c:Cpg	La/j/b/a/c/g/o;
    //   428: iload_3
    //   429: iconst_2
    //   430: ior
    //   431: istore 6
    //   433: iload 6
    //   435: istore_3
    //   436: iload 6
    //   438: istore 4
    //   440: iload 6
    //   442: istore 5
    //   444: aload_0
    //   445: getfield 117	a/j/b/a/c/e/b/a$c:Cpg	La/j/b/a/c/g/o;
    //   448: aload 12
    //   450: invokeinterface 154 2 0
    //   455: iload 6
    //   457: istore_3
    //   458: goto -407 -> 51
    //   461: iload_3
    //   462: iconst_4
    //   463: iand
    //   464: iconst_4
    //   465: if_icmpeq +839 -> 1304
    //   468: iload_3
    //   469: istore 5
    //   471: iload_3
    //   472: istore 6
    //   474: iload_3
    //   475: istore 8
    //   477: aload_0
    //   478: new 156	java/util/ArrayList
    //   481: dup
    //   482: invokespecial 157	java/util/ArrayList:<init>	()V
    //   485: putfield 125	a/j/b/a/c/e/b/a$c:Cph	Ljava/util/List;
    //   488: iload_3
    //   489: iconst_4
    //   490: ior
    //   491: istore 6
    //   493: iload 6
    //   495: istore_3
    //   496: iload 6
    //   498: istore 4
    //   500: iload 6
    //   502: istore 5
    //   504: aload_0
    //   505: getfield 125	a/j/b/a/c/e/b/a$c:Cph	Ljava/util/List;
    //   508: aload_1
    //   509: invokevirtual 160	a/j/b/a/c/g/e:sl	()I
    //   512: invokestatic 166	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   515: invokeinterface 172 2 0
    //   520: pop
    //   521: iload 6
    //   523: istore_3
    //   524: goto -473 -> 51
    //   527: iload_3
    //   528: istore 5
    //   530: iload_3
    //   531: istore 6
    //   533: iload_3
    //   534: istore 8
    //   536: aload_1
    //   537: aload_1
    //   538: invokevirtual 160	a/j/b/a/c/g/e:sl	()I
    //   541: invokevirtual 176	a/j/b/a/c/g/e:eP	(I)I
    //   544: istore 9
    //   546: iload_3
    //   547: iconst_4
    //   548: iand
    //   549: iconst_4
    //   550: if_icmpeq +748 -> 1298
    //   553: iload_3
    //   554: istore 5
    //   556: iload_3
    //   557: istore 6
    //   559: iload_3
    //   560: istore 8
    //   562: aload_1
    //   563: invokevirtual 179	a/j/b/a/c/g/e:so	()I
    //   566: ifle +732 -> 1298
    //   569: iload_3
    //   570: istore 5
    //   572: iload_3
    //   573: istore 6
    //   575: iload_3
    //   576: istore 8
    //   578: aload_0
    //   579: new 156	java/util/ArrayList
    //   582: dup
    //   583: invokespecial 157	java/util/ArrayList:<init>	()V
    //   586: putfield 125	a/j/b/a/c/e/b/a$c:Cph	Ljava/util/List;
    //   589: iload_3
    //   590: iconst_4
    //   591: ior
    //   592: istore 6
    //   594: iload 6
    //   596: istore_3
    //   597: iload 6
    //   599: istore 4
    //   601: iload 6
    //   603: istore 5
    //   605: aload_1
    //   606: invokevirtual 179	a/j/b/a/c/g/e:so	()I
    //   609: ifle +34 -> 643
    //   612: iload 6
    //   614: istore_3
    //   615: iload 6
    //   617: istore 4
    //   619: iload 6
    //   621: istore 5
    //   623: aload_0
    //   624: getfield 125	a/j/b/a/c/e/b/a$c:Cph	Ljava/util/List;
    //   627: aload_1
    //   628: invokevirtual 160	a/j/b/a/c/g/e:sl	()I
    //   631: invokestatic 166	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   634: invokeinterface 172 2 0
    //   639: pop
    //   640: goto -46 -> 594
    //   643: iload 6
    //   645: istore_3
    //   646: iload 6
    //   648: istore 4
    //   650: iload 6
    //   652: istore 5
    //   654: aload_1
    //   655: iload 9
    //   657: invokevirtual 182	a/j/b/a/c/g/e:eQ	(I)V
    //   660: iload 6
    //   662: istore_3
    //   663: goto -612 -> 51
    //   666: iload_3
    //   667: istore 5
    //   669: iload_3
    //   670: istore 6
    //   672: iload_3
    //   673: istore 8
    //   675: aload_1
    //   676: invokevirtual 107	a/j/b/a/c/g/e:emv	()La/j/b/a/c/g/d;
    //   679: astore 12
    //   681: iload_3
    //   682: bipush 8
    //   684: iand
    //   685: bipush 8
    //   687: if_icmpeq +605 -> 1292
    //   690: iload_3
    //   691: istore 5
    //   693: iload_3
    //   694: istore 6
    //   696: iload_3
    //   697: istore 8
    //   699: aload_0
    //   700: new 150	a/j/b/a/c/g/n
    //   703: dup
    //   704: invokespecial 151	a/j/b/a/c/g/n:<init>	()V
    //   707: putfield 133	a/j/b/a/c/e/b/a$c:Cpj	La/j/b/a/c/g/o;
    //   710: iload_3
    //   711: bipush 8
    //   713: ior
    //   714: istore 6
    //   716: iload 6
    //   718: istore_3
    //   719: iload 6
    //   721: istore 4
    //   723: iload 6
    //   725: istore 5
    //   727: aload_0
    //   728: getfield 133	a/j/b/a/c/e/b/a$c:Cpj	La/j/b/a/c/g/o;
    //   731: aload 12
    //   733: invokeinterface 154 2 0
    //   738: iload 6
    //   740: istore_3
    //   741: goto -690 -> 51
    //   744: iload_3
    //   745: istore 5
    //   747: iload_3
    //   748: istore 6
    //   750: iload_3
    //   751: istore 8
    //   753: aload_1
    //   754: invokevirtual 107	a/j/b/a/c/g/e:emv	()La/j/b/a/c/g/d;
    //   757: astore 12
    //   759: iload_3
    //   760: bipush 16
    //   762: iand
    //   763: bipush 16
    //   765: if_icmpeq +521 -> 1286
    //   768: iload_3
    //   769: istore 5
    //   771: iload_3
    //   772: istore 6
    //   774: iload_3
    //   775: istore 8
    //   777: aload_0
    //   778: new 150	a/j/b/a/c/g/n
    //   781: dup
    //   782: invokespecial 151	a/j/b/a/c/g/n:<init>	()V
    //   785: putfield 135	a/j/b/a/c/e/b/a$c:Cpk	La/j/b/a/c/g/o;
    //   788: iload_3
    //   789: bipush 16
    //   791: ior
    //   792: istore 6
    //   794: iload 6
    //   796: istore_3
    //   797: iload 6
    //   799: istore 4
    //   801: iload 6
    //   803: istore 5
    //   805: aload_0
    //   806: getfield 135	a/j/b/a/c/e/b/a$c:Cpk	La/j/b/a/c/g/o;
    //   809: aload 12
    //   811: invokeinterface 154 2 0
    //   816: iload 6
    //   818: istore_3
    //   819: goto -768 -> 51
    //   822: iload_3
    //   823: bipush 32
    //   825: iand
    //   826: bipush 32
    //   828: if_icmpeq +452 -> 1280
    //   831: iload_3
    //   832: istore 5
    //   834: iload_3
    //   835: istore 6
    //   837: iload_3
    //   838: istore 8
    //   840: aload_0
    //   841: new 156	java/util/ArrayList
    //   844: dup
    //   845: invokespecial 157	java/util/ArrayList:<init>	()V
    //   848: putfield 137	a/j/b/a/c/e/b/a$c:Cpl	Ljava/util/List;
    //   851: iload_3
    //   852: bipush 32
    //   854: ior
    //   855: istore 6
    //   857: iload 6
    //   859: istore_3
    //   860: iload 6
    //   862: istore 4
    //   864: iload 6
    //   866: istore 5
    //   868: aload_0
    //   869: getfield 137	a/j/b/a/c/e/b/a$c:Cpl	Ljava/util/List;
    //   872: aload_1
    //   873: invokevirtual 160	a/j/b/a/c/g/e:sl	()I
    //   876: invokestatic 166	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   879: invokeinterface 172 2 0
    //   884: pop
    //   885: iload 6
    //   887: istore_3
    //   888: goto -837 -> 51
    //   891: iload_3
    //   892: istore 5
    //   894: iload_3
    //   895: istore 6
    //   897: iload_3
    //   898: istore 8
    //   900: aload_1
    //   901: aload_1
    //   902: invokevirtual 160	a/j/b/a/c/g/e:sl	()I
    //   905: invokevirtual 176	a/j/b/a/c/g/e:eP	(I)I
    //   908: istore 9
    //   910: iload_3
    //   911: istore 4
    //   913: iload_3
    //   914: bipush 32
    //   916: iand
    //   917: bipush 32
    //   919: if_icmpeq +48 -> 967
    //   922: iload_3
    //   923: istore 5
    //   925: iload_3
    //   926: istore 4
    //   928: iload_3
    //   929: istore 6
    //   931: iload_3
    //   932: istore 8
    //   934: aload_1
    //   935: invokevirtual 179	a/j/b/a/c/g/e:so	()I
    //   938: ifle +29 -> 967
    //   941: iload_3
    //   942: istore 5
    //   944: iload_3
    //   945: istore 6
    //   947: iload_3
    //   948: istore 8
    //   950: aload_0
    //   951: new 156	java/util/ArrayList
    //   954: dup
    //   955: invokespecial 157	java/util/ArrayList:<init>	()V
    //   958: putfield 137	a/j/b/a/c/e/b/a$c:Cpl	Ljava/util/List;
    //   961: iload_3
    //   962: bipush 32
    //   964: ior
    //   965: istore 4
    //   967: iload 4
    //   969: istore 5
    //   971: iload 4
    //   973: istore 6
    //   975: iload 4
    //   977: istore 8
    //   979: aload_1
    //   980: invokevirtual 179	a/j/b/a/c/g/e:so	()I
    //   983: ifle +76 -> 1059
    //   986: iload 4
    //   988: istore 5
    //   990: iload 4
    //   992: istore 6
    //   994: iload 4
    //   996: istore 8
    //   998: aload_0
    //   999: getfield 137	a/j/b/a/c/e/b/a$c:Cpl	Ljava/util/List;
    //   1002: aload_1
    //   1003: invokevirtual 160	a/j/b/a/c/g/e:sl	()I
    //   1006: invokestatic 166	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1009: invokeinterface 172 2 0
    //   1014: pop
    //   1015: goto -48 -> 967
    //   1018: astore_1
    //   1019: iload 6
    //   1021: istore 4
    //   1023: iload 4
    //   1025: istore_3
    //   1026: new 80	a/j/b/a/c/g/k
    //   1029: dup
    //   1030: aload_1
    //   1031: invokevirtual 186	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1034: invokespecial 189	a/j/b/a/c/g/k:<init>	(Ljava/lang/String;)V
    //   1037: astore_1
    //   1038: iload 4
    //   1040: istore_3
    //   1041: aload_1
    //   1042: aload_0
    //   1043: putfield 115	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   1046: iload 4
    //   1048: istore_3
    //   1049: ldc 83
    //   1051: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1054: iload 4
    //   1056: istore_3
    //   1057: aload_1
    //   1058: athrow
    //   1059: iload 4
    //   1061: istore 5
    //   1063: iload 4
    //   1065: istore 6
    //   1067: iload 4
    //   1069: istore 8
    //   1071: aload_1
    //   1072: iload 9
    //   1074: invokevirtual 182	a/j/b/a/c/g/e:eQ	(I)V
    //   1077: iload 4
    //   1079: istore_3
    //   1080: goto -1029 -> 51
    //   1083: astore_1
    //   1084: iload 8
    //   1086: istore_3
    //   1087: goto -828 -> 259
    //   1090: iload_3
    //   1091: iconst_2
    //   1092: iand
    //   1093: iconst_2
    //   1094: if_icmpne +16 -> 1110
    //   1097: aload_0
    //   1098: aload_0
    //   1099: getfield 117	a/j/b/a/c/e/b/a$c:Cpg	La/j/b/a/c/g/o;
    //   1102: invokeinterface 123 1 0
    //   1107: putfield 117	a/j/b/a/c/e/b/a$c:Cpg	La/j/b/a/c/g/o;
    //   1110: iload_3
    //   1111: iconst_4
    //   1112: iand
    //   1113: iconst_4
    //   1114: if_icmpne +14 -> 1128
    //   1117: aload_0
    //   1118: aload_0
    //   1119: getfield 125	a/j/b/a/c/e/b/a$c:Cph	Ljava/util/List;
    //   1122: invokestatic 131	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1125: putfield 125	a/j/b/a/c/e/b/a$c:Cph	Ljava/util/List;
    //   1128: iload_3
    //   1129: bipush 8
    //   1131: iand
    //   1132: bipush 8
    //   1134: if_icmpne +16 -> 1150
    //   1137: aload_0
    //   1138: aload_0
    //   1139: getfield 133	a/j/b/a/c/e/b/a$c:Cpj	La/j/b/a/c/g/o;
    //   1142: invokeinterface 123 1 0
    //   1147: putfield 133	a/j/b/a/c/e/b/a$c:Cpj	La/j/b/a/c/g/o;
    //   1150: iload_3
    //   1151: bipush 16
    //   1153: iand
    //   1154: bipush 16
    //   1156: if_icmpne +16 -> 1172
    //   1159: aload_0
    //   1160: aload_0
    //   1161: getfield 135	a/j/b/a/c/e/b/a$c:Cpk	La/j/b/a/c/g/o;
    //   1164: invokeinterface 123 1 0
    //   1169: putfield 135	a/j/b/a/c/e/b/a$c:Cpk	La/j/b/a/c/g/o;
    //   1172: iload_3
    //   1173: bipush 32
    //   1175: iand
    //   1176: bipush 32
    //   1178: if_icmpne +14 -> 1192
    //   1181: aload_0
    //   1182: aload_0
    //   1183: getfield 137	a/j/b/a/c/e/b/a$c:Cpl	Ljava/util/List;
    //   1186: invokestatic 131	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1189: putfield 137	a/j/b/a/c/e/b/a$c:Cpl	Ljava/util/List;
    //   1192: aload 11
    //   1194: invokevirtual 140	a/j/b/a/c/g/f:flush	()V
    //   1197: aload_0
    //   1198: aload 10
    //   1200: invokevirtual 145	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   1203: putfield 77	a/j/b/a/c/e/b/a$c:Ckp	La/j/b/a/c/g/d;
    //   1206: aload_0
    //   1207: invokevirtual 148	a/j/b/a/c/e/b/a$c:emL	()V
    //   1210: ldc 83
    //   1212: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1215: return
    //   1216: astore_1
    //   1217: aload_0
    //   1218: aload 10
    //   1220: invokevirtual 145	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   1223: putfield 77	a/j/b/a/c/e/b/a$c:Ckp	La/j/b/a/c/g/d;
    //   1226: goto -20 -> 1206
    //   1229: astore_1
    //   1230: aload_0
    //   1231: aload 10
    //   1233: invokevirtual 145	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   1236: putfield 77	a/j/b/a/c/e/b/a$c:Ckp	La/j/b/a/c/g/d;
    //   1239: ldc 83
    //   1241: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1244: aload_1
    //   1245: athrow
    //   1246: astore_2
    //   1247: aload_0
    //   1248: aload 10
    //   1250: invokevirtual 145	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   1253: putfield 77	a/j/b/a/c/e/b/a$c:Ckp	La/j/b/a/c/g/d;
    //   1256: goto -881 -> 375
    //   1259: astore_1
    //   1260: aload_0
    //   1261: aload 10
    //   1263: invokevirtual 145	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   1266: putfield 77	a/j/b/a/c/e/b/a$c:Ckp	La/j/b/a/c/g/d;
    //   1269: ldc 83
    //   1271: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1274: aload_1
    //   1275: athrow
    //   1276: astore_1
    //   1277: goto -254 -> 1023
    //   1280: iload_3
    //   1281: istore 6
    //   1283: goto -426 -> 857
    //   1286: iload_3
    //   1287: istore 6
    //   1289: goto -495 -> 794
    //   1292: iload_3
    //   1293: istore 6
    //   1295: goto -579 -> 716
    //   1298: iload_3
    //   1299: istore 6
    //   1301: goto -707 -> 594
    //   1304: iload_3
    //   1305: istore 6
    //   1307: goto -814 -> 493
    //   1310: iload_3
    //   1311: istore 6
    //   1313: goto -880 -> 433
    //   1316: goto -1160 -> 156
    //   1319: iconst_1
    //   1320: istore 7
    //   1322: goto -1271 -> 51
    //   1325: astore_1
    //   1326: goto -1089 -> 237
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1329	0	this	c
    //   0	1329	1	parame	a.j.b.a.c.g.e
    //   0	1329	2	paramg	a.j.b.a.c.g.g
    //   50	1261	3	i	int
    //   69	1009	4	j	int
    //   57	1005	5	k	int
    //   60	1252	6	m	int
    //   47	1274	7	n	int
    //   63	1022	8	i1	int
    //   544	529	9	i2	int
    //   36	1226	10	localb	a.j.b.a.c.g.d.b
    //   44	1149	11	localf	f
    //   197	613	12	locald	d
    // Exception table:
    //   from	to	target	type
    //   65	71	236	a/j/b/a/c/g/k
    //   165	178	236	a/j/b/a/c/g/k
    //   193	199	236	a/j/b/a/c/g/k
    //   208	218	236	a/j/b/a/c/g/k
    //   227	233	236	a/j/b/a/c/g/k
    //   395	401	236	a/j/b/a/c/g/k
    //   417	428	236	a/j/b/a/c/g/k
    //   477	488	236	a/j/b/a/c/g/k
    //   536	546	236	a/j/b/a/c/g/k
    //   562	569	236	a/j/b/a/c/g/k
    //   578	589	236	a/j/b/a/c/g/k
    //   675	681	236	a/j/b/a/c/g/k
    //   699	710	236	a/j/b/a/c/g/k
    //   753	759	236	a/j/b/a/c/g/k
    //   777	788	236	a/j/b/a/c/g/k
    //   840	851	236	a/j/b/a/c/g/k
    //   900	910	236	a/j/b/a/c/g/k
    //   934	941	236	a/j/b/a/c/g/k
    //   950	961	236	a/j/b/a/c/g/k
    //   979	986	236	a/j/b/a/c/g/k
    //   998	1015	236	a/j/b/a/c/g/k
    //   1071	1077	236	a/j/b/a/c/g/k
    //   240	245	258	finally
    //   248	253	258	finally
    //   256	258	258	finally
    //   444	455	258	finally
    //   504	521	258	finally
    //   605	612	258	finally
    //   623	640	258	finally
    //   654	660	258	finally
    //   727	738	258	finally
    //   805	816	258	finally
    //   868	885	258	finally
    //   1026	1038	258	finally
    //   1041	1046	258	finally
    //   1049	1054	258	finally
    //   1057	1059	258	finally
    //   65	71	1018	java/io/IOException
    //   165	178	1018	java/io/IOException
    //   193	199	1018	java/io/IOException
    //   208	218	1018	java/io/IOException
    //   227	233	1018	java/io/IOException
    //   395	401	1018	java/io/IOException
    //   417	428	1018	java/io/IOException
    //   477	488	1018	java/io/IOException
    //   536	546	1018	java/io/IOException
    //   562	569	1018	java/io/IOException
    //   578	589	1018	java/io/IOException
    //   675	681	1018	java/io/IOException
    //   699	710	1018	java/io/IOException
    //   753	759	1018	java/io/IOException
    //   777	788	1018	java/io/IOException
    //   840	851	1018	java/io/IOException
    //   900	910	1018	java/io/IOException
    //   934	941	1018	java/io/IOException
    //   950	961	1018	java/io/IOException
    //   979	986	1018	java/io/IOException
    //   998	1015	1018	java/io/IOException
    //   1071	1077	1018	java/io/IOException
    //   65	71	1083	finally
    //   165	178	1083	finally
    //   193	199	1083	finally
    //   208	218	1083	finally
    //   227	233	1083	finally
    //   395	401	1083	finally
    //   417	428	1083	finally
    //   477	488	1083	finally
    //   536	546	1083	finally
    //   562	569	1083	finally
    //   578	589	1083	finally
    //   675	681	1083	finally
    //   699	710	1083	finally
    //   753	759	1083	finally
    //   777	788	1083	finally
    //   840	851	1083	finally
    //   900	910	1083	finally
    //   934	941	1083	finally
    //   950	961	1083	finally
    //   979	986	1083	finally
    //   998	1015	1083	finally
    //   1071	1077	1083	finally
    //   1192	1197	1216	java/io/IOException
    //   1192	1197	1229	finally
    //   361	366	1246	java/io/IOException
    //   361	366	1259	finally
    //   444	455	1276	java/io/IOException
    //   504	521	1276	java/io/IOException
    //   605	612	1276	java/io/IOException
    //   623	640	1276	java/io/IOException
    //   654	660	1276	java/io/IOException
    //   727	738	1276	java/io/IOException
    //   805	816	1276	java/io/IOException
    //   868	885	1276	java/io/IOException
    //   444	455	1325	a/j/b/a/c/g/k
    //   504	521	1325	a/j/b/a/c/g/k
    //   605	612	1325	a/j/b/a/c/g/k
    //   623	640	1325	a/j/b/a/c/g/k
    //   654	660	1325	a/j/b/a/c/g/k
    //   727	738	1325	a/j/b/a/c/g/k
    //   805	816	1325	a/j/b/a/c/g/k
    //   868	885	1325	a/j/b/a/c/g/k
  }
  
  private a$c(i.a parama)
  {
    super((byte)0);
    this.Ckp = parama.Ckp;
  }
  
  private void egZ()
  {
    AppMethodBeat.i(121156);
    this.Cpf = "";
    this.Cpg = n.CrT;
    this.Cph = Collections.emptyList();
    this.Cpj = n.CrT;
    this.Cpk = n.CrT;
    this.Cpl = Collections.emptyList();
    AppMethodBeat.o(121156);
  }
  
  public static c ekX()
  {
    return Cpe;
  }
  
  private d ela()
  {
    AppMethodBeat.i(121155);
    Object localObject = this.Cpf;
    if ((localObject instanceof String))
    {
      localObject = d.ayY((String)localObject);
      this.Cpf = localObject;
      AppMethodBeat.o(121155);
      return localObject;
    }
    localObject = (d)localObject;
    AppMethodBeat.o(121155);
    return localObject;
  }
  
  public final void a(f paramf)
  {
    int j = 0;
    AppMethodBeat.i(121158);
    sy();
    if ((this.Ckr & 0x1) == 1) {
      paramf.a(1, ela());
    }
    int i = 0;
    while (i < this.Cpg.size())
    {
      paramf.a(2, this.Cpg.VK(i));
      i += 1;
    }
    if (this.Cph.size() > 0)
    {
      paramf.eX(26);
      paramf.eX(this.Cpi);
    }
    i = 0;
    while (i < this.Cph.size())
    {
      paramf.VG(((Integer)this.Cph.get(i)).intValue());
      i += 1;
    }
    i = 0;
    while (i < this.Cpj.size())
    {
      paramf.a(4, this.Cpj.VK(i));
      i += 1;
    }
    i = 0;
    while (i < this.Cpk.size())
    {
      paramf.a(5, this.Cpk.VK(i));
      i += 1;
    }
    i = j;
    if (this.Cpl.size() > 0)
    {
      paramf.eX(50);
      paramf.eX(this.Cpm);
      i = j;
    }
    while (i < this.Cpl.size())
    {
      paramf.VG(((Integer)this.Cpl.get(i)).intValue());
      i += 1;
    }
    paramf.d(this.Ckp);
    AppMethodBeat.o(121158);
  }
  
  public final s<c> egX()
  {
    return Ckq;
  }
  
  public final boolean ekY()
  {
    return (this.Ckr & 0x1) == 1;
  }
  
  public final String ekZ()
  {
    AppMethodBeat.i(121154);
    Object localObject = this.Cpf;
    if ((localObject instanceof String))
    {
      localObject = (String)localObject;
      AppMethodBeat.o(121154);
      return localObject;
    }
    localObject = (d)localObject;
    String str = ((d)localObject).dqj();
    if (((d)localObject).emn()) {
      this.Cpf = str;
    }
    AppMethodBeat.o(121154);
    return str;
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(121157);
    int i = this.Cku;
    if (i == 1)
    {
      AppMethodBeat.o(121157);
      return true;
    }
    if (i == 0)
    {
      AppMethodBeat.o(121157);
      return false;
    }
    if (!ekY())
    {
      this.Cku = 0;
      AppMethodBeat.o(121157);
      return false;
    }
    this.Cku = 1;
    AppMethodBeat.o(121157);
    return true;
  }
  
  public final int sy()
  {
    AppMethodBeat.i(121159);
    int i = this.Ckv;
    if (i != -1)
    {
      AppMethodBeat.o(121159);
      return i;
    }
    if ((this.Ckr & 0x1) == 1) {}
    for (i = f.b(1, ela()) + 0;; i = 0)
    {
      int k = 0;
      int j = 0;
      while (k < this.Cpg.size())
      {
        j += f.c(this.Cpg.VK(k));
        k += 1;
      }
      int n = this.Cpg.size();
      int m = 0;
      k = 0;
      while (m < this.Cph.size())
      {
        k += f.eU(((Integer)this.Cph.get(m)).intValue());
        m += 1;
      }
      j = i + j + n * 1 + k;
      i = j;
      if (!this.Cph.isEmpty()) {
        i = j + 1 + f.eU(k);
      }
      this.Cpi = k;
      k = 0;
      j = 0;
      while (k < this.Cpj.size())
      {
        j += f.c(this.Cpj.VK(k));
        k += 1;
      }
      int i1 = this.Cpj.size();
      m = 0;
      k = 0;
      while (m < this.Cpk.size())
      {
        k += f.c(this.Cpk.VK(m));
        m += 1;
      }
      int i2 = this.Cpk.size();
      n = 0;
      int i3;
      for (m = 0; n < this.Cpl.size(); m = i3 + m)
      {
        i3 = f.eU(((Integer)this.Cpl.get(n)).intValue());
        n += 1;
      }
      j = i + j + i1 * 1 + k + i2 * 1 + m;
      i = j;
      if (!this.Cpl.isEmpty()) {
        i = j + 1 + f.eU(m);
      }
      this.Cpm = m;
      i += this.Ckp.size();
      this.Ckv = i;
      AppMethodBeat.o(121159);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.c.e.b.a.c
 * JD-Core Version:    0.7.0.1
 */