package a.j.b.a.c.e;

import a.j.b.a.c.g.b;
import a.j.b.a.c.g.d;
import a.j.b.a.c.g.f;
import a.j.b.a.c.g.h;
import a.j.b.a.c.g.i.a;
import a.j.b.a.c.g.i.b;
import a.j.b.a.c.g.i.c;
import a.j.b.a.c.g.i.c.a;
import a.j.b.a.c.g.q;
import a.j.b.a.c.g.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

public final class a$aa
  extends i.c<aa>
  implements a.ad
{
  public static s<aa> Ckq;
  private static final aa CmN;
  public int CkK;
  private final d Ckp;
  private int Ckr;
  public List<a.aa.a> Ckt;
  private byte Cku = -1;
  private int Ckv = -1;
  public boolean CmO;
  public int CmP;
  public aa CmQ;
  public int CmR;
  public int CmS;
  public int CmT;
  public int CmU;
  public int CmV;
  public aa CmW;
  public int CmX;
  public aa CmY;
  public int CmZ;
  
  static
  {
    AppMethodBeat.i(120884);
    Ckq = new a.aa.1();
    aa localaa = new aa();
    CmN = localaa;
    localaa.egZ();
    AppMethodBeat.o(120884);
  }
  
  private a$aa()
  {
    this.Ckp = d.Cre;
  }
  
  /* Error */
  private a$aa(a.j.b.a.c.g.e parame, a.j.b.a.c.g.g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 74	a/j/b/a/c/g/i$c:<init>	()V
    //   4: ldc 91
    //   6: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 76	a/j/b/a/c/e/a$aa:Cku	B
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 78	a/j/b/a/c/e/a$aa:Ckv	I
    //   19: aload_0
    //   20: invokespecial 69	a/j/b/a/c/e/a$aa:egZ	()V
    //   23: invokestatic 95	a/j/b/a/c/g/d:emp	()La/j/b/a/c/g/d$b;
    //   26: astore 10
    //   28: aload 10
    //   30: iconst_1
    //   31: invokestatic 101	a/j/b/a/c/g/f:e	(Ljava/io/OutputStream;I)La/j/b/a/c/g/f;
    //   34: astore 11
    //   36: iconst_0
    //   37: istore 6
    //   39: iconst_0
    //   40: istore_3
    //   41: iload 6
    //   43: ifne +1199 -> 1242
    //   46: iload_3
    //   47: istore 7
    //   49: iload_3
    //   50: istore 5
    //   52: iload_3
    //   53: istore 8
    //   55: aload_1
    //   56: invokevirtual 107	a/j/b/a/c/g/e:sk	()I
    //   59: istore 4
    //   61: iload 4
    //   63: lookupswitch	default:+1302->1365, 0:+1305->1368, 8:+157->220, 18:+271->334, 24:+383->446, 32:+422->485, 42:+461->524, 48:+602->665, 56:+642->705, 64:+682->745, 72:+722->785, 82:+762->825, 88:+909->972, 96:+950->1013, 106:+991->1054, 112:+1138->1201
    //   193: istore 7
    //   195: iload_3
    //   196: istore 5
    //   198: iload_3
    //   199: istore 8
    //   201: aload_0
    //   202: aload_1
    //   203: aload 11
    //   205: aload_2
    //   206: iload 4
    //   208: invokevirtual 111	a/j/b/a/c/e/a$aa:a	(La/j/b/a/c/g/e;La/j/b/a/c/g/f;La/j/b/a/c/g/g;I)Z
    //   211: ifne -170 -> 41
    //   214: iconst_1
    //   215: istore 6
    //   217: goto -176 -> 41
    //   220: iload_3
    //   221: istore 7
    //   223: iload_3
    //   224: istore 5
    //   226: iload_3
    //   227: istore 8
    //   229: aload_0
    //   230: aload_0
    //   231: getfield 113	a/j/b/a/c/e/a$aa:Ckr	I
    //   234: sipush 4096
    //   237: ior
    //   238: putfield 113	a/j/b/a/c/e/a$aa:Ckr	I
    //   241: iload_3
    //   242: istore 7
    //   244: iload_3
    //   245: istore 5
    //   247: iload_3
    //   248: istore 8
    //   250: aload_0
    //   251: aload_1
    //   252: invokevirtual 116	a/j/b/a/c/g/e:sl	()I
    //   255: putfield 118	a/j/b/a/c/e/a$aa:CkK	I
    //   258: goto -217 -> 41
    //   261: astore_1
    //   262: iload 7
    //   264: istore 5
    //   266: aload_1
    //   267: aload_0
    //   268: putfield 122	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   271: iload 7
    //   273: istore 5
    //   275: ldc 91
    //   277: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   280: iload 7
    //   282: istore 5
    //   284: aload_1
    //   285: athrow
    //   286: astore_1
    //   287: iload 5
    //   289: iconst_1
    //   290: iand
    //   291: iconst_1
    //   292: if_icmpne +14 -> 306
    //   295: aload_0
    //   296: aload_0
    //   297: getfield 124	a/j/b/a/c/e/a$aa:Ckt	Ljava/util/List;
    //   300: invokestatic 130	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   303: putfield 124	a/j/b/a/c/e/a$aa:Ckt	Ljava/util/List;
    //   306: aload 11
    //   308: invokevirtual 133	a/j/b/a/c/g/f:flush	()V
    //   311: aload_0
    //   312: aload 10
    //   314: invokevirtual 139	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   317: putfield 85	a/j/b/a/c/e/a$aa:Ckp	La/j/b/a/c/g/d;
    //   320: aload_0
    //   321: getfield 143	a/j/b/a/c/g/i$c:Crw	La/j/b/a/c/g/h;
    //   324: invokevirtual 148	a/j/b/a/c/g/h:emF	()V
    //   327: ldc 91
    //   329: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   332: aload_1
    //   333: athrow
    //   334: iload_3
    //   335: istore 4
    //   337: iload_3
    //   338: iconst_1
    //   339: iand
    //   340: iconst_1
    //   341: if_icmpeq +28 -> 369
    //   344: iload_3
    //   345: istore 7
    //   347: iload_3
    //   348: istore 5
    //   350: iload_3
    //   351: istore 8
    //   353: aload_0
    //   354: new 150	java/util/ArrayList
    //   357: dup
    //   358: invokespecial 151	java/util/ArrayList:<init>	()V
    //   361: putfield 124	a/j/b/a/c/e/a$aa:Ckt	Ljava/util/List;
    //   364: iload_3
    //   365: iconst_1
    //   366: ior
    //   367: istore 4
    //   369: iload 4
    //   371: istore 7
    //   373: iload 4
    //   375: istore 5
    //   377: iload 4
    //   379: istore 8
    //   381: aload_0
    //   382: getfield 124	a/j/b/a/c/e/a$aa:Ckt	Ljava/util/List;
    //   385: aload_1
    //   386: getstatic 152	a/j/b/a/c/e/a$aa$a:Ckq	La/j/b/a/c/g/s;
    //   389: aload_2
    //   390: invokevirtual 155	a/j/b/a/c/g/e:a	(La/j/b/a/c/g/s;La/j/b/a/c/g/g;)La/j/b/a/c/g/q;
    //   393: invokeinterface 161 2 0
    //   398: pop
    //   399: iload 4
    //   401: istore_3
    //   402: goto -361 -> 41
    //   405: astore_1
    //   406: iload 8
    //   408: istore 5
    //   410: new 88	a/j/b/a/c/g/k
    //   413: dup
    //   414: aload_1
    //   415: invokevirtual 165	java/io/IOException:getMessage	()Ljava/lang/String;
    //   418: invokespecial 168	a/j/b/a/c/g/k:<init>	(Ljava/lang/String;)V
    //   421: astore_1
    //   422: iload 8
    //   424: istore 5
    //   426: aload_1
    //   427: aload_0
    //   428: putfield 122	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   431: iload 8
    //   433: istore 5
    //   435: ldc 91
    //   437: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   440: iload 8
    //   442: istore 5
    //   444: aload_1
    //   445: athrow
    //   446: iload_3
    //   447: istore 7
    //   449: iload_3
    //   450: istore 5
    //   452: iload_3
    //   453: istore 8
    //   455: aload_0
    //   456: aload_0
    //   457: getfield 113	a/j/b/a/c/e/a$aa:Ckr	I
    //   460: iconst_1
    //   461: ior
    //   462: putfield 113	a/j/b/a/c/e/a$aa:Ckr	I
    //   465: iload_3
    //   466: istore 7
    //   468: iload_3
    //   469: istore 5
    //   471: iload_3
    //   472: istore 8
    //   474: aload_0
    //   475: aload_1
    //   476: invokevirtual 172	a/j/b/a/c/g/e:emu	()Z
    //   479: putfield 174	a/j/b/a/c/e/a$aa:CmO	Z
    //   482: goto -441 -> 41
    //   485: iload_3
    //   486: istore 7
    //   488: iload_3
    //   489: istore 5
    //   491: iload_3
    //   492: istore 8
    //   494: aload_0
    //   495: aload_0
    //   496: getfield 113	a/j/b/a/c/e/a$aa:Ckr	I
    //   499: iconst_2
    //   500: ior
    //   501: putfield 113	a/j/b/a/c/e/a$aa:Ckr	I
    //   504: iload_3
    //   505: istore 7
    //   507: iload_3
    //   508: istore 5
    //   510: iload_3
    //   511: istore 8
    //   513: aload_0
    //   514: aload_1
    //   515: invokevirtual 116	a/j/b/a/c/g/e:sl	()I
    //   518: putfield 176	a/j/b/a/c/e/a$aa:CmP	I
    //   521: goto -480 -> 41
    //   524: iload_3
    //   525: istore 7
    //   527: iload_3
    //   528: istore 5
    //   530: iload_3
    //   531: istore 8
    //   533: aload_0
    //   534: getfield 113	a/j/b/a/c/e/a$aa:Ckr	I
    //   537: iconst_4
    //   538: iand
    //   539: iconst_4
    //   540: if_icmpne +819 -> 1359
    //   543: iload_3
    //   544: istore 7
    //   546: iload_3
    //   547: istore 5
    //   549: iload_3
    //   550: istore 8
    //   552: aload_0
    //   553: getfield 178	a/j/b/a/c/e/a$aa:CmQ	La/j/b/a/c/e/a$aa;
    //   556: astore 9
    //   558: iload_3
    //   559: istore 7
    //   561: iload_3
    //   562: istore 5
    //   564: iload_3
    //   565: istore 8
    //   567: invokestatic 182	a/j/b/a/c/e/a$aa$c:ejT	()La/j/b/a/c/e/a$aa$c;
    //   570: aload 9
    //   572: invokevirtual 186	a/j/b/a/c/e/a$aa$c:j	(La/j/b/a/c/e/a$aa;)La/j/b/a/c/e/a$aa$c;
    //   575: astore 9
    //   577: iload_3
    //   578: istore 7
    //   580: iload_3
    //   581: istore 5
    //   583: iload_3
    //   584: istore 8
    //   586: aload_0
    //   587: aload_1
    //   588: getstatic 63	a/j/b/a/c/e/a$aa:Ckq	La/j/b/a/c/g/s;
    //   591: aload_2
    //   592: invokevirtual 155	a/j/b/a/c/g/e:a	(La/j/b/a/c/g/s;La/j/b/a/c/g/g;)La/j/b/a/c/g/q;
    //   595: checkcast 2	a/j/b/a/c/e/a$aa
    //   598: putfield 178	a/j/b/a/c/e/a$aa:CmQ	La/j/b/a/c/e/a$aa;
    //   601: aload 9
    //   603: ifnull +40 -> 643
    //   606: iload_3
    //   607: istore 7
    //   609: iload_3
    //   610: istore 5
    //   612: iload_3
    //   613: istore 8
    //   615: aload 9
    //   617: aload_0
    //   618: getfield 178	a/j/b/a/c/e/a$aa:CmQ	La/j/b/a/c/e/a$aa;
    //   621: invokevirtual 186	a/j/b/a/c/e/a$aa$c:j	(La/j/b/a/c/e/a$aa;)La/j/b/a/c/e/a$aa$c;
    //   624: pop
    //   625: iload_3
    //   626: istore 7
    //   628: iload_3
    //   629: istore 5
    //   631: iload_3
    //   632: istore 8
    //   634: aload_0
    //   635: aload 9
    //   637: invokevirtual 190	a/j/b/a/c/e/a$aa$c:ejS	()La/j/b/a/c/e/a$aa;
    //   640: putfield 178	a/j/b/a/c/e/a$aa:CmQ	La/j/b/a/c/e/a$aa;
    //   643: iload_3
    //   644: istore 7
    //   646: iload_3
    //   647: istore 5
    //   649: iload_3
    //   650: istore 8
    //   652: aload_0
    //   653: aload_0
    //   654: getfield 113	a/j/b/a/c/e/a$aa:Ckr	I
    //   657: iconst_4
    //   658: ior
    //   659: putfield 113	a/j/b/a/c/e/a$aa:Ckr	I
    //   662: goto -621 -> 41
    //   665: iload_3
    //   666: istore 7
    //   668: iload_3
    //   669: istore 5
    //   671: iload_3
    //   672: istore 8
    //   674: aload_0
    //   675: aload_0
    //   676: getfield 113	a/j/b/a/c/e/a$aa:Ckr	I
    //   679: bipush 16
    //   681: ior
    //   682: putfield 113	a/j/b/a/c/e/a$aa:Ckr	I
    //   685: iload_3
    //   686: istore 7
    //   688: iload_3
    //   689: istore 5
    //   691: iload_3
    //   692: istore 8
    //   694: aload_0
    //   695: aload_1
    //   696: invokevirtual 116	a/j/b/a/c/g/e:sl	()I
    //   699: putfield 192	a/j/b/a/c/e/a$aa:CmS	I
    //   702: goto -661 -> 41
    //   705: iload_3
    //   706: istore 7
    //   708: iload_3
    //   709: istore 5
    //   711: iload_3
    //   712: istore 8
    //   714: aload_0
    //   715: aload_0
    //   716: getfield 113	a/j/b/a/c/e/a$aa:Ckr	I
    //   719: bipush 32
    //   721: ior
    //   722: putfield 113	a/j/b/a/c/e/a$aa:Ckr	I
    //   725: iload_3
    //   726: istore 7
    //   728: iload_3
    //   729: istore 5
    //   731: iload_3
    //   732: istore 8
    //   734: aload_0
    //   735: aload_1
    //   736: invokevirtual 116	a/j/b/a/c/g/e:sl	()I
    //   739: putfield 194	a/j/b/a/c/e/a$aa:CmT	I
    //   742: goto -701 -> 41
    //   745: iload_3
    //   746: istore 7
    //   748: iload_3
    //   749: istore 5
    //   751: iload_3
    //   752: istore 8
    //   754: aload_0
    //   755: aload_0
    //   756: getfield 113	a/j/b/a/c/e/a$aa:Ckr	I
    //   759: bipush 8
    //   761: ior
    //   762: putfield 113	a/j/b/a/c/e/a$aa:Ckr	I
    //   765: iload_3
    //   766: istore 7
    //   768: iload_3
    //   769: istore 5
    //   771: iload_3
    //   772: istore 8
    //   774: aload_0
    //   775: aload_1
    //   776: invokevirtual 116	a/j/b/a/c/g/e:sl	()I
    //   779: putfield 196	a/j/b/a/c/e/a$aa:CmR	I
    //   782: goto -741 -> 41
    //   785: iload_3
    //   786: istore 7
    //   788: iload_3
    //   789: istore 5
    //   791: iload_3
    //   792: istore 8
    //   794: aload_0
    //   795: aload_0
    //   796: getfield 113	a/j/b/a/c/e/a$aa:Ckr	I
    //   799: bipush 64
    //   801: ior
    //   802: putfield 113	a/j/b/a/c/e/a$aa:Ckr	I
    //   805: iload_3
    //   806: istore 7
    //   808: iload_3
    //   809: istore 5
    //   811: iload_3
    //   812: istore 8
    //   814: aload_0
    //   815: aload_1
    //   816: invokevirtual 116	a/j/b/a/c/g/e:sl	()I
    //   819: putfield 198	a/j/b/a/c/e/a$aa:CmU	I
    //   822: goto -781 -> 41
    //   825: iload_3
    //   826: istore 7
    //   828: iload_3
    //   829: istore 5
    //   831: iload_3
    //   832: istore 8
    //   834: aload_0
    //   835: getfield 113	a/j/b/a/c/e/a$aa:Ckr	I
    //   838: sipush 256
    //   841: iand
    //   842: sipush 256
    //   845: if_icmpne +508 -> 1353
    //   848: iload_3
    //   849: istore 7
    //   851: iload_3
    //   852: istore 5
    //   854: iload_3
    //   855: istore 8
    //   857: aload_0
    //   858: getfield 200	a/j/b/a/c/e/a$aa:CmW	La/j/b/a/c/e/a$aa;
    //   861: astore 9
    //   863: iload_3
    //   864: istore 7
    //   866: iload_3
    //   867: istore 5
    //   869: iload_3
    //   870: istore 8
    //   872: invokestatic 182	a/j/b/a/c/e/a$aa$c:ejT	()La/j/b/a/c/e/a$aa$c;
    //   875: aload 9
    //   877: invokevirtual 186	a/j/b/a/c/e/a$aa$c:j	(La/j/b/a/c/e/a$aa;)La/j/b/a/c/e/a$aa$c;
    //   880: astore 9
    //   882: iload_3
    //   883: istore 7
    //   885: iload_3
    //   886: istore 5
    //   888: iload_3
    //   889: istore 8
    //   891: aload_0
    //   892: aload_1
    //   893: getstatic 63	a/j/b/a/c/e/a$aa:Ckq	La/j/b/a/c/g/s;
    //   896: aload_2
    //   897: invokevirtual 155	a/j/b/a/c/g/e:a	(La/j/b/a/c/g/s;La/j/b/a/c/g/g;)La/j/b/a/c/g/q;
    //   900: checkcast 2	a/j/b/a/c/e/a$aa
    //   903: putfield 200	a/j/b/a/c/e/a$aa:CmW	La/j/b/a/c/e/a$aa;
    //   906: aload 9
    //   908: ifnull +40 -> 948
    //   911: iload_3
    //   912: istore 7
    //   914: iload_3
    //   915: istore 5
    //   917: iload_3
    //   918: istore 8
    //   920: aload 9
    //   922: aload_0
    //   923: getfield 200	a/j/b/a/c/e/a$aa:CmW	La/j/b/a/c/e/a$aa;
    //   926: invokevirtual 186	a/j/b/a/c/e/a$aa$c:j	(La/j/b/a/c/e/a$aa;)La/j/b/a/c/e/a$aa$c;
    //   929: pop
    //   930: iload_3
    //   931: istore 7
    //   933: iload_3
    //   934: istore 5
    //   936: iload_3
    //   937: istore 8
    //   939: aload_0
    //   940: aload 9
    //   942: invokevirtual 190	a/j/b/a/c/e/a$aa$c:ejS	()La/j/b/a/c/e/a$aa;
    //   945: putfield 200	a/j/b/a/c/e/a$aa:CmW	La/j/b/a/c/e/a$aa;
    //   948: iload_3
    //   949: istore 7
    //   951: iload_3
    //   952: istore 5
    //   954: iload_3
    //   955: istore 8
    //   957: aload_0
    //   958: aload_0
    //   959: getfield 113	a/j/b/a/c/e/a$aa:Ckr	I
    //   962: sipush 256
    //   965: ior
    //   966: putfield 113	a/j/b/a/c/e/a$aa:Ckr	I
    //   969: goto -928 -> 41
    //   972: iload_3
    //   973: istore 7
    //   975: iload_3
    //   976: istore 5
    //   978: iload_3
    //   979: istore 8
    //   981: aload_0
    //   982: aload_0
    //   983: getfield 113	a/j/b/a/c/e/a$aa:Ckr	I
    //   986: sipush 512
    //   989: ior
    //   990: putfield 113	a/j/b/a/c/e/a$aa:Ckr	I
    //   993: iload_3
    //   994: istore 7
    //   996: iload_3
    //   997: istore 5
    //   999: iload_3
    //   1000: istore 8
    //   1002: aload_0
    //   1003: aload_1
    //   1004: invokevirtual 116	a/j/b/a/c/g/e:sl	()I
    //   1007: putfield 202	a/j/b/a/c/e/a$aa:CmX	I
    //   1010: goto -969 -> 41
    //   1013: iload_3
    //   1014: istore 7
    //   1016: iload_3
    //   1017: istore 5
    //   1019: iload_3
    //   1020: istore 8
    //   1022: aload_0
    //   1023: aload_0
    //   1024: getfield 113	a/j/b/a/c/e/a$aa:Ckr	I
    //   1027: sipush 128
    //   1030: ior
    //   1031: putfield 113	a/j/b/a/c/e/a$aa:Ckr	I
    //   1034: iload_3
    //   1035: istore 7
    //   1037: iload_3
    //   1038: istore 5
    //   1040: iload_3
    //   1041: istore 8
    //   1043: aload_0
    //   1044: aload_1
    //   1045: invokevirtual 116	a/j/b/a/c/g/e:sl	()I
    //   1048: putfield 204	a/j/b/a/c/e/a$aa:CmV	I
    //   1051: goto -1010 -> 41
    //   1054: iload_3
    //   1055: istore 7
    //   1057: iload_3
    //   1058: istore 5
    //   1060: iload_3
    //   1061: istore 8
    //   1063: aload_0
    //   1064: getfield 113	a/j/b/a/c/e/a$aa:Ckr	I
    //   1067: sipush 1024
    //   1070: iand
    //   1071: sipush 1024
    //   1074: if_icmpne +273 -> 1347
    //   1077: iload_3
    //   1078: istore 7
    //   1080: iload_3
    //   1081: istore 5
    //   1083: iload_3
    //   1084: istore 8
    //   1086: aload_0
    //   1087: getfield 206	a/j/b/a/c/e/a$aa:CmY	La/j/b/a/c/e/a$aa;
    //   1090: astore 9
    //   1092: iload_3
    //   1093: istore 7
    //   1095: iload_3
    //   1096: istore 5
    //   1098: iload_3
    //   1099: istore 8
    //   1101: invokestatic 182	a/j/b/a/c/e/a$aa$c:ejT	()La/j/b/a/c/e/a$aa$c;
    //   1104: aload 9
    //   1106: invokevirtual 186	a/j/b/a/c/e/a$aa$c:j	(La/j/b/a/c/e/a$aa;)La/j/b/a/c/e/a$aa$c;
    //   1109: astore 9
    //   1111: iload_3
    //   1112: istore 7
    //   1114: iload_3
    //   1115: istore 5
    //   1117: iload_3
    //   1118: istore 8
    //   1120: aload_0
    //   1121: aload_1
    //   1122: getstatic 63	a/j/b/a/c/e/a$aa:Ckq	La/j/b/a/c/g/s;
    //   1125: aload_2
    //   1126: invokevirtual 155	a/j/b/a/c/g/e:a	(La/j/b/a/c/g/s;La/j/b/a/c/g/g;)La/j/b/a/c/g/q;
    //   1129: checkcast 2	a/j/b/a/c/e/a$aa
    //   1132: putfield 206	a/j/b/a/c/e/a$aa:CmY	La/j/b/a/c/e/a$aa;
    //   1135: aload 9
    //   1137: ifnull +40 -> 1177
    //   1140: iload_3
    //   1141: istore 7
    //   1143: iload_3
    //   1144: istore 5
    //   1146: iload_3
    //   1147: istore 8
    //   1149: aload 9
    //   1151: aload_0
    //   1152: getfield 206	a/j/b/a/c/e/a$aa:CmY	La/j/b/a/c/e/a$aa;
    //   1155: invokevirtual 186	a/j/b/a/c/e/a$aa$c:j	(La/j/b/a/c/e/a$aa;)La/j/b/a/c/e/a$aa$c;
    //   1158: pop
    //   1159: iload_3
    //   1160: istore 7
    //   1162: iload_3
    //   1163: istore 5
    //   1165: iload_3
    //   1166: istore 8
    //   1168: aload_0
    //   1169: aload 9
    //   1171: invokevirtual 190	a/j/b/a/c/e/a$aa$c:ejS	()La/j/b/a/c/e/a$aa;
    //   1174: putfield 206	a/j/b/a/c/e/a$aa:CmY	La/j/b/a/c/e/a$aa;
    //   1177: iload_3
    //   1178: istore 7
    //   1180: iload_3
    //   1181: istore 5
    //   1183: iload_3
    //   1184: istore 8
    //   1186: aload_0
    //   1187: aload_0
    //   1188: getfield 113	a/j/b/a/c/e/a$aa:Ckr	I
    //   1191: sipush 1024
    //   1194: ior
    //   1195: putfield 113	a/j/b/a/c/e/a$aa:Ckr	I
    //   1198: goto -1157 -> 41
    //   1201: iload_3
    //   1202: istore 7
    //   1204: iload_3
    //   1205: istore 5
    //   1207: iload_3
    //   1208: istore 8
    //   1210: aload_0
    //   1211: aload_0
    //   1212: getfield 113	a/j/b/a/c/e/a$aa:Ckr	I
    //   1215: sipush 2048
    //   1218: ior
    //   1219: putfield 113	a/j/b/a/c/e/a$aa:Ckr	I
    //   1222: iload_3
    //   1223: istore 7
    //   1225: iload_3
    //   1226: istore 5
    //   1228: iload_3
    //   1229: istore 8
    //   1231: aload_0
    //   1232: aload_1
    //   1233: invokevirtual 116	a/j/b/a/c/g/e:sl	()I
    //   1236: putfield 208	a/j/b/a/c/e/a$aa:CmZ	I
    //   1239: goto -1198 -> 41
    //   1242: iload_3
    //   1243: iconst_1
    //   1244: iand
    //   1245: iconst_1
    //   1246: if_icmpne +14 -> 1260
    //   1249: aload_0
    //   1250: aload_0
    //   1251: getfield 124	a/j/b/a/c/e/a$aa:Ckt	Ljava/util/List;
    //   1254: invokestatic 130	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1257: putfield 124	a/j/b/a/c/e/a$aa:Ckt	Ljava/util/List;
    //   1260: aload 11
    //   1262: invokevirtual 133	a/j/b/a/c/g/f:flush	()V
    //   1265: aload_0
    //   1266: aload 10
    //   1268: invokevirtual 139	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   1271: putfield 85	a/j/b/a/c/e/a$aa:Ckp	La/j/b/a/c/g/d;
    //   1274: aload_0
    //   1275: getfield 143	a/j/b/a/c/g/i$c:Crw	La/j/b/a/c/g/h;
    //   1278: invokevirtual 148	a/j/b/a/c/g/h:emF	()V
    //   1281: ldc 91
    //   1283: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1286: return
    //   1287: astore_1
    //   1288: aload_0
    //   1289: aload 10
    //   1291: invokevirtual 139	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   1294: putfield 85	a/j/b/a/c/e/a$aa:Ckp	La/j/b/a/c/g/d;
    //   1297: goto -23 -> 1274
    //   1300: astore_1
    //   1301: aload_0
    //   1302: aload 10
    //   1304: invokevirtual 139	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   1307: putfield 85	a/j/b/a/c/e/a$aa:Ckp	La/j/b/a/c/g/d;
    //   1310: ldc 91
    //   1312: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1315: aload_1
    //   1316: athrow
    //   1317: astore_2
    //   1318: aload_0
    //   1319: aload 10
    //   1321: invokevirtual 139	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   1324: putfield 85	a/j/b/a/c/e/a$aa:Ckp	La/j/b/a/c/g/d;
    //   1327: goto -1007 -> 320
    //   1330: astore_1
    //   1331: aload_0
    //   1332: aload 10
    //   1334: invokevirtual 139	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   1337: putfield 85	a/j/b/a/c/e/a$aa:Ckp	La/j/b/a/c/g/d;
    //   1340: ldc 91
    //   1342: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1345: aload_1
    //   1346: athrow
    //   1347: aconst_null
    //   1348: astore 9
    //   1350: goto -239 -> 1111
    //   1353: aconst_null
    //   1354: astore 9
    //   1356: goto -474 -> 882
    //   1359: aconst_null
    //   1360: astore 9
    //   1362: goto -785 -> 577
    //   1365: goto -1173 -> 192
    //   1368: iconst_1
    //   1369: istore 6
    //   1371: goto -1330 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1374	0	this	aa
    //   0	1374	1	parame	a.j.b.a.c.g.e
    //   0	1374	2	paramg	a.j.b.a.c.g.g
    //   40	1205	3	i	int
    //   59	341	4	j	int
    //   50	1177	5	k	int
    //   37	1333	6	m	int
    //   47	1177	7	n	int
    //   53	1177	8	i1	int
    //   556	805	9	localObject	java.lang.Object
    //   26	1307	10	localb	a.j.b.a.c.g.d.b
    //   34	1227	11	localf	f
    // Exception table:
    //   from	to	target	type
    //   55	61	261	a/j/b/a/c/g/k
    //   201	214	261	a/j/b/a/c/g/k
    //   229	241	261	a/j/b/a/c/g/k
    //   250	258	261	a/j/b/a/c/g/k
    //   353	364	261	a/j/b/a/c/g/k
    //   381	399	261	a/j/b/a/c/g/k
    //   455	465	261	a/j/b/a/c/g/k
    //   474	482	261	a/j/b/a/c/g/k
    //   494	504	261	a/j/b/a/c/g/k
    //   513	521	261	a/j/b/a/c/g/k
    //   533	543	261	a/j/b/a/c/g/k
    //   552	558	261	a/j/b/a/c/g/k
    //   567	577	261	a/j/b/a/c/g/k
    //   586	601	261	a/j/b/a/c/g/k
    //   615	625	261	a/j/b/a/c/g/k
    //   634	643	261	a/j/b/a/c/g/k
    //   652	662	261	a/j/b/a/c/g/k
    //   674	685	261	a/j/b/a/c/g/k
    //   694	702	261	a/j/b/a/c/g/k
    //   714	725	261	a/j/b/a/c/g/k
    //   734	742	261	a/j/b/a/c/g/k
    //   754	765	261	a/j/b/a/c/g/k
    //   774	782	261	a/j/b/a/c/g/k
    //   794	805	261	a/j/b/a/c/g/k
    //   814	822	261	a/j/b/a/c/g/k
    //   834	848	261	a/j/b/a/c/g/k
    //   857	863	261	a/j/b/a/c/g/k
    //   872	882	261	a/j/b/a/c/g/k
    //   891	906	261	a/j/b/a/c/g/k
    //   920	930	261	a/j/b/a/c/g/k
    //   939	948	261	a/j/b/a/c/g/k
    //   957	969	261	a/j/b/a/c/g/k
    //   981	993	261	a/j/b/a/c/g/k
    //   1002	1010	261	a/j/b/a/c/g/k
    //   1022	1034	261	a/j/b/a/c/g/k
    //   1043	1051	261	a/j/b/a/c/g/k
    //   1063	1077	261	a/j/b/a/c/g/k
    //   1086	1092	261	a/j/b/a/c/g/k
    //   1101	1111	261	a/j/b/a/c/g/k
    //   1120	1135	261	a/j/b/a/c/g/k
    //   1149	1159	261	a/j/b/a/c/g/k
    //   1168	1177	261	a/j/b/a/c/g/k
    //   1186	1198	261	a/j/b/a/c/g/k
    //   1210	1222	261	a/j/b/a/c/g/k
    //   1231	1239	261	a/j/b/a/c/g/k
    //   55	61	286	finally
    //   201	214	286	finally
    //   229	241	286	finally
    //   250	258	286	finally
    //   266	271	286	finally
    //   275	280	286	finally
    //   284	286	286	finally
    //   353	364	286	finally
    //   381	399	286	finally
    //   410	422	286	finally
    //   426	431	286	finally
    //   435	440	286	finally
    //   444	446	286	finally
    //   455	465	286	finally
    //   474	482	286	finally
    //   494	504	286	finally
    //   513	521	286	finally
    //   533	543	286	finally
    //   552	558	286	finally
    //   567	577	286	finally
    //   586	601	286	finally
    //   615	625	286	finally
    //   634	643	286	finally
    //   652	662	286	finally
    //   674	685	286	finally
    //   694	702	286	finally
    //   714	725	286	finally
    //   734	742	286	finally
    //   754	765	286	finally
    //   774	782	286	finally
    //   794	805	286	finally
    //   814	822	286	finally
    //   834	848	286	finally
    //   857	863	286	finally
    //   872	882	286	finally
    //   891	906	286	finally
    //   920	930	286	finally
    //   939	948	286	finally
    //   957	969	286	finally
    //   981	993	286	finally
    //   1002	1010	286	finally
    //   1022	1034	286	finally
    //   1043	1051	286	finally
    //   1063	1077	286	finally
    //   1086	1092	286	finally
    //   1101	1111	286	finally
    //   1120	1135	286	finally
    //   1149	1159	286	finally
    //   1168	1177	286	finally
    //   1186	1198	286	finally
    //   1210	1222	286	finally
    //   1231	1239	286	finally
    //   55	61	405	java/io/IOException
    //   201	214	405	java/io/IOException
    //   229	241	405	java/io/IOException
    //   250	258	405	java/io/IOException
    //   353	364	405	java/io/IOException
    //   381	399	405	java/io/IOException
    //   455	465	405	java/io/IOException
    //   474	482	405	java/io/IOException
    //   494	504	405	java/io/IOException
    //   513	521	405	java/io/IOException
    //   533	543	405	java/io/IOException
    //   552	558	405	java/io/IOException
    //   567	577	405	java/io/IOException
    //   586	601	405	java/io/IOException
    //   615	625	405	java/io/IOException
    //   634	643	405	java/io/IOException
    //   652	662	405	java/io/IOException
    //   674	685	405	java/io/IOException
    //   694	702	405	java/io/IOException
    //   714	725	405	java/io/IOException
    //   734	742	405	java/io/IOException
    //   754	765	405	java/io/IOException
    //   774	782	405	java/io/IOException
    //   794	805	405	java/io/IOException
    //   814	822	405	java/io/IOException
    //   834	848	405	java/io/IOException
    //   857	863	405	java/io/IOException
    //   872	882	405	java/io/IOException
    //   891	906	405	java/io/IOException
    //   920	930	405	java/io/IOException
    //   939	948	405	java/io/IOException
    //   957	969	405	java/io/IOException
    //   981	993	405	java/io/IOException
    //   1002	1010	405	java/io/IOException
    //   1022	1034	405	java/io/IOException
    //   1043	1051	405	java/io/IOException
    //   1063	1077	405	java/io/IOException
    //   1086	1092	405	java/io/IOException
    //   1101	1111	405	java/io/IOException
    //   1120	1135	405	java/io/IOException
    //   1149	1159	405	java/io/IOException
    //   1168	1177	405	java/io/IOException
    //   1186	1198	405	java/io/IOException
    //   1210	1222	405	java/io/IOException
    //   1231	1239	405	java/io/IOException
    //   1260	1265	1287	java/io/IOException
    //   1260	1265	1300	finally
    //   306	311	1317	java/io/IOException
    //   306	311	1330	finally
  }
  
  private a$aa(i.b<aa, ?> paramb)
  {
    super(paramb);
    this.Ckp = paramb.Ckp;
  }
  
  private void egZ()
  {
    AppMethodBeat.i(120876);
    this.Ckt = Collections.emptyList();
    this.CmO = false;
    this.CmP = 0;
    this.CmQ = CmN;
    this.CmR = 0;
    this.CmS = 0;
    this.CmT = 0;
    this.CmU = 0;
    this.CmV = 0;
    this.CmW = CmN;
    this.CmX = 0;
    this.CmY = CmN;
    this.CmZ = 0;
    this.CkK = 0;
    AppMethodBeat.o(120876);
  }
  
  public static aa ejw()
  {
    return CmN;
  }
  
  public static a.aa.c f(aa paramaa)
  {
    AppMethodBeat.i(156774);
    paramaa = a.aa.c.ejT().j(paramaa);
    AppMethodBeat.o(156774);
    return paramaa;
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(120878);
    sy();
    i.c.a locala = emM();
    if ((this.Ckr & 0x1000) == 4096) {
      paramf.bj(1, this.CkK);
    }
    int i = 0;
    while (i < this.Ckt.size())
    {
      paramf.a(2, (q)this.Ckt.get(i));
      i += 1;
    }
    if ((this.Ckr & 0x1) == 1) {
      paramf.sw(this.CmO);
    }
    if ((this.Ckr & 0x2) == 2) {
      paramf.bj(4, this.CmP);
    }
    if ((this.Ckr & 0x4) == 4) {
      paramf.a(5, this.CmQ);
    }
    if ((this.Ckr & 0x10) == 16) {
      paramf.bj(6, this.CmS);
    }
    if ((this.Ckr & 0x20) == 32) {
      paramf.bj(7, this.CmT);
    }
    if ((this.Ckr & 0x8) == 8) {
      paramf.bj(8, this.CmR);
    }
    if ((this.Ckr & 0x40) == 64) {
      paramf.bj(9, this.CmU);
    }
    if ((this.Ckr & 0x100) == 256) {
      paramf.a(10, this.CmW);
    }
    if ((this.Ckr & 0x200) == 512) {
      paramf.bj(11, this.CmX);
    }
    if ((this.Ckr & 0x80) == 128) {
      paramf.bj(12, this.CmV);
    }
    if ((this.Ckr & 0x400) == 1024) {
      paramf.a(13, this.CmY);
    }
    if ((this.Ckr & 0x800) == 2048) {
      paramf.bj(14, this.CmZ);
    }
    locala.b(200, paramf);
    paramf.d(this.Ckp);
    AppMethodBeat.o(120878);
  }
  
  public final s<aa> egX()
  {
    return Ckq;
  }
  
  public final boolean ehx()
  {
    return (this.Ckr & 0x1000) == 4096;
  }
  
  public final boolean ejA()
  {
    return (this.Ckr & 0x8) == 8;
  }
  
  public final boolean ejB()
  {
    return (this.Ckr & 0x10) == 16;
  }
  
  public final boolean ejC()
  {
    return (this.Ckr & 0x20) == 32;
  }
  
  public final boolean ejD()
  {
    return (this.Ckr & 0x40) == 64;
  }
  
  public final boolean ejE()
  {
    return (this.Ckr & 0x80) == 128;
  }
  
  public final boolean ejF()
  {
    return (this.Ckr & 0x100) == 256;
  }
  
  public final boolean ejG()
  {
    return (this.Ckr & 0x200) == 512;
  }
  
  public final boolean ejH()
  {
    return (this.Ckr & 0x400) == 1024;
  }
  
  public final boolean ejI()
  {
    return (this.Ckr & 0x800) == 2048;
  }
  
  public final a.aa.c ejJ()
  {
    AppMethodBeat.i(156775);
    a.aa.c localc = a.aa.c.ejT().j(this);
    AppMethodBeat.o(156775);
    return localc;
  }
  
  public final boolean ejx()
  {
    return (this.Ckr & 0x1) == 1;
  }
  
  public final boolean ejy()
  {
    return (this.Ckr & 0x2) == 2;
  }
  
  public final boolean ejz()
  {
    return (this.Ckr & 0x4) == 4;
  }
  
  public final int getArgumentCount()
  {
    AppMethodBeat.i(120875);
    int i = this.Ckt.size();
    AppMethodBeat.o(120875);
    return i;
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(120877);
    int i = this.Cku;
    if (i == 1)
    {
      AppMethodBeat.o(120877);
      return true;
    }
    if (i == 0)
    {
      AppMethodBeat.o(120877);
      return false;
    }
    i = 0;
    while (i < getArgumentCount())
    {
      if (!((a.aa.a)this.Ckt.get(i)).isInitialized())
      {
        this.Cku = 0;
        AppMethodBeat.o(120877);
        return false;
      }
      i += 1;
    }
    if ((ejz()) && (!this.CmQ.isInitialized()))
    {
      this.Cku = 0;
      AppMethodBeat.o(120877);
      return false;
    }
    if ((ejF()) && (!this.CmW.isInitialized()))
    {
      this.Cku = 0;
      AppMethodBeat.o(120877);
      return false;
    }
    if ((ejH()) && (!this.CmY.isInitialized()))
    {
      this.Cku = 0;
      AppMethodBeat.o(120877);
      return false;
    }
    if (!this.Crw.isInitialized())
    {
      this.Cku = 0;
      AppMethodBeat.o(120877);
      return false;
    }
    this.Cku = 1;
    AppMethodBeat.o(120877);
    return true;
  }
  
  public final int sy()
  {
    int j = 0;
    AppMethodBeat.i(120879);
    int i = this.Ckv;
    if (i != -1)
    {
      AppMethodBeat.o(120879);
      return i;
    }
    if ((this.Ckr & 0x1000) == 4096) {
      i = f.bl(1, this.CkK) + 0;
    }
    for (;;)
    {
      if (j < this.Ckt.size())
      {
        int k = f.c(2, (q)this.Ckt.get(j));
        j += 1;
        i = k + i;
      }
      else
      {
        j = i;
        if ((this.Ckr & 0x1) == 1) {
          j = i + (f.eW(3) + 1);
        }
        i = j;
        if ((this.Ckr & 0x2) == 2) {
          i = j + f.bl(4, this.CmP);
        }
        j = i;
        if ((this.Ckr & 0x4) == 4) {
          j = i + f.c(5, this.CmQ);
        }
        i = j;
        if ((this.Ckr & 0x10) == 16) {
          i = j + f.bl(6, this.CmS);
        }
        j = i;
        if ((this.Ckr & 0x20) == 32) {
          j = i + f.bl(7, this.CmT);
        }
        i = j;
        if ((this.Ckr & 0x8) == 8) {
          i = j + f.bl(8, this.CmR);
        }
        j = i;
        if ((this.Ckr & 0x40) == 64) {
          j = i + f.bl(9, this.CmU);
        }
        i = j;
        if ((this.Ckr & 0x100) == 256) {
          i = j + f.c(10, this.CmW);
        }
        j = i;
        if ((this.Ckr & 0x200) == 512) {
          j = i + f.bl(11, this.CmX);
        }
        i = j;
        if ((this.Ckr & 0x80) == 128) {
          i = j + f.bl(12, this.CmV);
        }
        j = i;
        if ((this.Ckr & 0x400) == 1024) {
          j = i + f.c(13, this.CmY);
        }
        i = j;
        if ((this.Ckr & 0x800) == 2048) {
          i = j + f.bl(14, this.CmZ);
        }
        i = this.Crw.sy() + i + this.Ckp.size();
        this.Ckv = i;
        AppMethodBeat.o(120879);
        return i;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.j.b.a.c.e.a.aa
 * JD-Core Version:    0.7.0.1
 */