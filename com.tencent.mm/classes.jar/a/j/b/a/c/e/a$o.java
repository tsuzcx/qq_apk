package a.j.b.a.c.e;

import a.j.b.a.c.g.d;
import a.j.b.a.c.g.f;
import a.j.b.a.c.g.g;
import a.j.b.a.c.g.h;
import a.j.b.a.c.g.i.a;
import a.j.b.a.c.g.i.b;
import a.j.b.a.c.g.i.c;
import a.j.b.a.c.g.i.c.a;
import a.j.b.a.c.g.q;
import a.j.b.a.c.g.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public final class a$o
  extends i.c<o>
  implements a.p
{
  public static s<o> Ckq;
  private static final o Cmf;
  public int CkK;
  private final d Ckp;
  private int Ckr;
  private byte Cku = -1;
  private int Ckv = -1;
  public List<a.ai> ClC;
  public int ClT;
  public List<a.ae> Cld;
  public a.ag Clq;
  public List<Integer> Clr;
  public int Cmg;
  public a.aa Cmh;
  public int Cmi;
  public a.aa Cmj;
  public int Cmk;
  a.g Cml;
  
  static
  {
    AppMethodBeat.i(120668);
    Ckq = new a.o.1();
    o localo = new o();
    Cmf = localo;
    localo.egZ();
    AppMethodBeat.o(120668);
  }
  
  private a$o()
  {
    this.Ckp = d.Cre;
  }
  
  /* Error */
  private a$o(a.j.b.a.c.g.e parame, g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 69	a/j/b/a/c/g/i$c:<init>	()V
    //   4: ldc 86
    //   6: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 71	a/j/b/a/c/e/a$o:Cku	B
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 73	a/j/b/a/c/e/a$o:Ckv	I
    //   19: aload_0
    //   20: invokespecial 65	a/j/b/a/c/e/a$o:egZ	()V
    //   23: iconst_0
    //   24: istore_3
    //   25: invokestatic 90	a/j/b/a/c/g/d:emp	()La/j/b/a/c/g/d$b;
    //   28: astore 11
    //   30: aload 11
    //   32: iconst_1
    //   33: invokestatic 96	a/j/b/a/c/g/f:e	(Ljava/io/OutputStream;I)La/j/b/a/c/g/f;
    //   36: astore 12
    //   38: iconst_0
    //   39: istore 8
    //   41: iload 8
    //   43: ifne +1427 -> 1470
    //   46: iload_3
    //   47: istore 5
    //   49: iload_3
    //   50: istore 4
    //   52: iload_3
    //   53: istore 6
    //   55: aload_1
    //   56: invokevirtual 102	a/j/b/a/c/g/e:sk	()I
    //   59: istore 7
    //   61: iload 7
    //   63: lookupswitch	default:+1582->1645, 0:+1585->1648, 8:+149->212, 16:+309->372, 26:+389->452, 34:+517->580, 42:+591->654, 50:+719->782, 56:+796->859, 64:+836->899, 72:+876->939, 242:+915->978, 248:+1046->1109, 250:+1122->1185, 258:+1276->1339
    //   185: istore 5
    //   187: iload_3
    //   188: istore 4
    //   190: iload_3
    //   191: istore 6
    //   193: aload_0
    //   194: aload_1
    //   195: aload 12
    //   197: aload_2
    //   198: iload 7
    //   200: invokevirtual 106	a/j/b/a/c/e/a$o:a	(La/j/b/a/c/g/e;La/j/b/a/c/g/f;La/j/b/a/c/g/g;I)Z
    //   203: ifne -162 -> 41
    //   206: iconst_1
    //   207: istore 8
    //   209: goto -168 -> 41
    //   212: iload_3
    //   213: istore 5
    //   215: iload_3
    //   216: istore 4
    //   218: iload_3
    //   219: istore 6
    //   221: aload_0
    //   222: aload_0
    //   223: getfield 108	a/j/b/a/c/e/a$o:Ckr	I
    //   226: iconst_2
    //   227: ior
    //   228: putfield 108	a/j/b/a/c/e/a$o:Ckr	I
    //   231: iload_3
    //   232: istore 5
    //   234: iload_3
    //   235: istore 4
    //   237: iload_3
    //   238: istore 6
    //   240: aload_0
    //   241: aload_1
    //   242: invokevirtual 111	a/j/b/a/c/g/e:sl	()I
    //   245: putfield 113	a/j/b/a/c/e/a$o:Cmg	I
    //   248: goto -207 -> 41
    //   251: astore_1
    //   252: iload 5
    //   254: istore 4
    //   256: aload_1
    //   257: aload_0
    //   258: putfield 117	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   261: iload 5
    //   263: istore 4
    //   265: ldc 86
    //   267: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   270: iload 5
    //   272: istore 4
    //   274: aload_1
    //   275: athrow
    //   276: astore_1
    //   277: iload 4
    //   279: bipush 32
    //   281: iand
    //   282: bipush 32
    //   284: if_icmpne +14 -> 298
    //   287: aload_0
    //   288: aload_0
    //   289: getfield 119	a/j/b/a/c/e/a$o:Cld	Ljava/util/List;
    //   292: invokestatic 125	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   295: putfield 119	a/j/b/a/c/e/a$o:Cld	Ljava/util/List;
    //   298: iload 4
    //   300: sipush 256
    //   303: iand
    //   304: sipush 256
    //   307: if_icmpne +14 -> 321
    //   310: aload_0
    //   311: aload_0
    //   312: getfield 127	a/j/b/a/c/e/a$o:ClC	Ljava/util/List;
    //   315: invokestatic 125	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   318: putfield 127	a/j/b/a/c/e/a$o:ClC	Ljava/util/List;
    //   321: iload 4
    //   323: sipush 1024
    //   326: iand
    //   327: sipush 1024
    //   330: if_icmpne +14 -> 344
    //   333: aload_0
    //   334: aload_0
    //   335: getfield 129	a/j/b/a/c/e/a$o:Clr	Ljava/util/List;
    //   338: invokestatic 125	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   341: putfield 129	a/j/b/a/c/e/a$o:Clr	Ljava/util/List;
    //   344: aload 12
    //   346: invokevirtual 132	a/j/b/a/c/g/f:flush	()V
    //   349: aload_0
    //   350: aload 11
    //   352: invokevirtual 138	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   355: putfield 80	a/j/b/a/c/e/a$o:Ckp	La/j/b/a/c/g/d;
    //   358: aload_0
    //   359: getfield 142	a/j/b/a/c/g/i$c:Crw	La/j/b/a/c/g/h;
    //   362: invokevirtual 147	a/j/b/a/c/g/h:emF	()V
    //   365: ldc 86
    //   367: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   370: aload_1
    //   371: athrow
    //   372: iload_3
    //   373: istore 5
    //   375: iload_3
    //   376: istore 4
    //   378: iload_3
    //   379: istore 6
    //   381: aload_0
    //   382: aload_0
    //   383: getfield 108	a/j/b/a/c/e/a$o:Ckr	I
    //   386: iconst_4
    //   387: ior
    //   388: putfield 108	a/j/b/a/c/e/a$o:Ckr	I
    //   391: iload_3
    //   392: istore 5
    //   394: iload_3
    //   395: istore 4
    //   397: iload_3
    //   398: istore 6
    //   400: aload_0
    //   401: aload_1
    //   402: invokevirtual 111	a/j/b/a/c/g/e:sl	()I
    //   405: putfield 149	a/j/b/a/c/e/a$o:ClT	I
    //   408: goto -367 -> 41
    //   411: astore_1
    //   412: iload 6
    //   414: istore 4
    //   416: new 83	a/j/b/a/c/g/k
    //   419: dup
    //   420: aload_1
    //   421: invokevirtual 153	java/io/IOException:getMessage	()Ljava/lang/String;
    //   424: invokespecial 156	a/j/b/a/c/g/k:<init>	(Ljava/lang/String;)V
    //   427: astore_1
    //   428: iload 6
    //   430: istore 4
    //   432: aload_1
    //   433: aload_0
    //   434: putfield 117	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   437: iload 6
    //   439: istore 4
    //   441: ldc 86
    //   443: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   446: iload 6
    //   448: istore 4
    //   450: aload_1
    //   451: athrow
    //   452: iload_3
    //   453: istore 5
    //   455: iload_3
    //   456: istore 4
    //   458: iload_3
    //   459: istore 6
    //   461: aload_0
    //   462: getfield 108	a/j/b/a/c/e/a$o:Ckr	I
    //   465: bipush 8
    //   467: iand
    //   468: bipush 8
    //   470: if_icmpne +1169 -> 1639
    //   473: iload_3
    //   474: istore 5
    //   476: iload_3
    //   477: istore 4
    //   479: iload_3
    //   480: istore 6
    //   482: aload_0
    //   483: getfield 158	a/j/b/a/c/e/a$o:Cmh	La/j/b/a/c/e/a$aa;
    //   486: invokestatic 164	a/j/b/a/c/e/a$aa:f	(La/j/b/a/c/e/a$aa;)La/j/b/a/c/e/a$aa$c;
    //   489: astore 10
    //   491: iload_3
    //   492: istore 5
    //   494: iload_3
    //   495: istore 4
    //   497: iload_3
    //   498: istore 6
    //   500: aload_0
    //   501: aload_1
    //   502: getstatic 165	a/j/b/a/c/e/a$aa:Ckq	La/j/b/a/c/g/s;
    //   505: aload_2
    //   506: invokevirtual 168	a/j/b/a/c/g/e:a	(La/j/b/a/c/g/s;La/j/b/a/c/g/g;)La/j/b/a/c/g/q;
    //   509: checkcast 160	a/j/b/a/c/e/a$aa
    //   512: putfield 158	a/j/b/a/c/e/a$o:Cmh	La/j/b/a/c/e/a$aa;
    //   515: aload 10
    //   517: ifnull +40 -> 557
    //   520: iload_3
    //   521: istore 5
    //   523: iload_3
    //   524: istore 4
    //   526: iload_3
    //   527: istore 6
    //   529: aload 10
    //   531: aload_0
    //   532: getfield 158	a/j/b/a/c/e/a$o:Cmh	La/j/b/a/c/e/a$aa;
    //   535: invokevirtual 173	a/j/b/a/c/e/a$aa$c:j	(La/j/b/a/c/e/a$aa;)La/j/b/a/c/e/a$aa$c;
    //   538: pop
    //   539: iload_3
    //   540: istore 5
    //   542: iload_3
    //   543: istore 4
    //   545: iload_3
    //   546: istore 6
    //   548: aload_0
    //   549: aload 10
    //   551: invokevirtual 177	a/j/b/a/c/e/a$aa$c:ejS	()La/j/b/a/c/e/a$aa;
    //   554: putfield 158	a/j/b/a/c/e/a$o:Cmh	La/j/b/a/c/e/a$aa;
    //   557: iload_3
    //   558: istore 5
    //   560: iload_3
    //   561: istore 4
    //   563: iload_3
    //   564: istore 6
    //   566: aload_0
    //   567: aload_0
    //   568: getfield 108	a/j/b/a/c/e/a$o:Ckr	I
    //   571: bipush 8
    //   573: ior
    //   574: putfield 108	a/j/b/a/c/e/a$o:Ckr	I
    //   577: goto -536 -> 41
    //   580: iload_3
    //   581: istore 7
    //   583: iload_3
    //   584: bipush 32
    //   586: iand
    //   587: bipush 32
    //   589: if_icmpeq +29 -> 618
    //   592: iload_3
    //   593: istore 5
    //   595: iload_3
    //   596: istore 4
    //   598: iload_3
    //   599: istore 6
    //   601: aload_0
    //   602: new 179	java/util/ArrayList
    //   605: dup
    //   606: invokespecial 180	java/util/ArrayList:<init>	()V
    //   609: putfield 119	a/j/b/a/c/e/a$o:Cld	Ljava/util/List;
    //   612: iload_3
    //   613: bipush 32
    //   615: ior
    //   616: istore 7
    //   618: iload 7
    //   620: istore 5
    //   622: iload 7
    //   624: istore 4
    //   626: iload 7
    //   628: istore 6
    //   630: aload_0
    //   631: getfield 119	a/j/b/a/c/e/a$o:Cld	Ljava/util/List;
    //   634: aload_1
    //   635: getstatic 183	a/j/b/a/c/e/a$ae:Ckq	La/j/b/a/c/g/s;
    //   638: aload_2
    //   639: invokevirtual 168	a/j/b/a/c/g/e:a	(La/j/b/a/c/g/s;La/j/b/a/c/g/g;)La/j/b/a/c/g/q;
    //   642: invokeinterface 189 2 0
    //   647: pop
    //   648: iload 7
    //   650: istore_3
    //   651: goto -610 -> 41
    //   654: iload_3
    //   655: istore 5
    //   657: iload_3
    //   658: istore 4
    //   660: iload_3
    //   661: istore 6
    //   663: aload_0
    //   664: getfield 108	a/j/b/a/c/e/a$o:Ckr	I
    //   667: bipush 32
    //   669: iand
    //   670: bipush 32
    //   672: if_icmpne +961 -> 1633
    //   675: iload_3
    //   676: istore 5
    //   678: iload_3
    //   679: istore 4
    //   681: iload_3
    //   682: istore 6
    //   684: aload_0
    //   685: getfield 191	a/j/b/a/c/e/a$o:Cmj	La/j/b/a/c/e/a$aa;
    //   688: invokestatic 164	a/j/b/a/c/e/a$aa:f	(La/j/b/a/c/e/a$aa;)La/j/b/a/c/e/a$aa$c;
    //   691: astore 10
    //   693: iload_3
    //   694: istore 5
    //   696: iload_3
    //   697: istore 4
    //   699: iload_3
    //   700: istore 6
    //   702: aload_0
    //   703: aload_1
    //   704: getstatic 165	a/j/b/a/c/e/a$aa:Ckq	La/j/b/a/c/g/s;
    //   707: aload_2
    //   708: invokevirtual 168	a/j/b/a/c/g/e:a	(La/j/b/a/c/g/s;La/j/b/a/c/g/g;)La/j/b/a/c/g/q;
    //   711: checkcast 160	a/j/b/a/c/e/a$aa
    //   714: putfield 191	a/j/b/a/c/e/a$o:Cmj	La/j/b/a/c/e/a$aa;
    //   717: aload 10
    //   719: ifnull +40 -> 759
    //   722: iload_3
    //   723: istore 5
    //   725: iload_3
    //   726: istore 4
    //   728: iload_3
    //   729: istore 6
    //   731: aload 10
    //   733: aload_0
    //   734: getfield 191	a/j/b/a/c/e/a$o:Cmj	La/j/b/a/c/e/a$aa;
    //   737: invokevirtual 173	a/j/b/a/c/e/a$aa$c:j	(La/j/b/a/c/e/a$aa;)La/j/b/a/c/e/a$aa$c;
    //   740: pop
    //   741: iload_3
    //   742: istore 5
    //   744: iload_3
    //   745: istore 4
    //   747: iload_3
    //   748: istore 6
    //   750: aload_0
    //   751: aload 10
    //   753: invokevirtual 177	a/j/b/a/c/e/a$aa$c:ejS	()La/j/b/a/c/e/a$aa;
    //   756: putfield 191	a/j/b/a/c/e/a$o:Cmj	La/j/b/a/c/e/a$aa;
    //   759: iload_3
    //   760: istore 5
    //   762: iload_3
    //   763: istore 4
    //   765: iload_3
    //   766: istore 6
    //   768: aload_0
    //   769: aload_0
    //   770: getfield 108	a/j/b/a/c/e/a$o:Ckr	I
    //   773: bipush 32
    //   775: ior
    //   776: putfield 108	a/j/b/a/c/e/a$o:Ckr	I
    //   779: goto -738 -> 41
    //   782: iload_3
    //   783: istore 7
    //   785: iload_3
    //   786: sipush 256
    //   789: iand
    //   790: sipush 256
    //   793: if_icmpeq +30 -> 823
    //   796: iload_3
    //   797: istore 5
    //   799: iload_3
    //   800: istore 4
    //   802: iload_3
    //   803: istore 6
    //   805: aload_0
    //   806: new 179	java/util/ArrayList
    //   809: dup
    //   810: invokespecial 180	java/util/ArrayList:<init>	()V
    //   813: putfield 127	a/j/b/a/c/e/a$o:ClC	Ljava/util/List;
    //   816: iload_3
    //   817: sipush 256
    //   820: ior
    //   821: istore 7
    //   823: iload 7
    //   825: istore 5
    //   827: iload 7
    //   829: istore 4
    //   831: iload 7
    //   833: istore 6
    //   835: aload_0
    //   836: getfield 127	a/j/b/a/c/e/a$o:ClC	Ljava/util/List;
    //   839: aload_1
    //   840: getstatic 194	a/j/b/a/c/e/a$ai:Ckq	La/j/b/a/c/g/s;
    //   843: aload_2
    //   844: invokevirtual 168	a/j/b/a/c/g/e:a	(La/j/b/a/c/g/s;La/j/b/a/c/g/g;)La/j/b/a/c/g/q;
    //   847: invokeinterface 189 2 0
    //   852: pop
    //   853: iload 7
    //   855: istore_3
    //   856: goto -815 -> 41
    //   859: iload_3
    //   860: istore 5
    //   862: iload_3
    //   863: istore 4
    //   865: iload_3
    //   866: istore 6
    //   868: aload_0
    //   869: aload_0
    //   870: getfield 108	a/j/b/a/c/e/a$o:Ckr	I
    //   873: bipush 16
    //   875: ior
    //   876: putfield 108	a/j/b/a/c/e/a$o:Ckr	I
    //   879: iload_3
    //   880: istore 5
    //   882: iload_3
    //   883: istore 4
    //   885: iload_3
    //   886: istore 6
    //   888: aload_0
    //   889: aload_1
    //   890: invokevirtual 111	a/j/b/a/c/g/e:sl	()I
    //   893: putfield 196	a/j/b/a/c/e/a$o:Cmi	I
    //   896: goto -855 -> 41
    //   899: iload_3
    //   900: istore 5
    //   902: iload_3
    //   903: istore 4
    //   905: iload_3
    //   906: istore 6
    //   908: aload_0
    //   909: aload_0
    //   910: getfield 108	a/j/b/a/c/e/a$o:Ckr	I
    //   913: bipush 64
    //   915: ior
    //   916: putfield 108	a/j/b/a/c/e/a$o:Ckr	I
    //   919: iload_3
    //   920: istore 5
    //   922: iload_3
    //   923: istore 4
    //   925: iload_3
    //   926: istore 6
    //   928: aload_0
    //   929: aload_1
    //   930: invokevirtual 111	a/j/b/a/c/g/e:sl	()I
    //   933: putfield 198	a/j/b/a/c/e/a$o:Cmk	I
    //   936: goto -895 -> 41
    //   939: iload_3
    //   940: istore 5
    //   942: iload_3
    //   943: istore 4
    //   945: iload_3
    //   946: istore 6
    //   948: aload_0
    //   949: aload_0
    //   950: getfield 108	a/j/b/a/c/e/a$o:Ckr	I
    //   953: iconst_1
    //   954: ior
    //   955: putfield 108	a/j/b/a/c/e/a$o:Ckr	I
    //   958: iload_3
    //   959: istore 5
    //   961: iload_3
    //   962: istore 4
    //   964: iload_3
    //   965: istore 6
    //   967: aload_0
    //   968: aload_1
    //   969: invokevirtual 111	a/j/b/a/c/g/e:sl	()I
    //   972: putfield 200	a/j/b/a/c/e/a$o:CkK	I
    //   975: goto -934 -> 41
    //   978: iload_3
    //   979: istore 5
    //   981: iload_3
    //   982: istore 4
    //   984: iload_3
    //   985: istore 6
    //   987: aload_0
    //   988: getfield 108	a/j/b/a/c/e/a$o:Ckr	I
    //   991: sipush 128
    //   994: iand
    //   995: sipush 128
    //   998: if_icmpne +629 -> 1627
    //   1001: iload_3
    //   1002: istore 5
    //   1004: iload_3
    //   1005: istore 4
    //   1007: iload_3
    //   1008: istore 6
    //   1010: aload_0
    //   1011: getfield 202	a/j/b/a/c/e/a$o:Clq	La/j/b/a/c/e/a$ag;
    //   1014: invokestatic 208	a/j/b/a/c/e/a$ag:d	(La/j/b/a/c/e/a$ag;)La/j/b/a/c/e/a$ag$a;
    //   1017: astore 10
    //   1019: iload_3
    //   1020: istore 5
    //   1022: iload_3
    //   1023: istore 4
    //   1025: iload_3
    //   1026: istore 6
    //   1028: aload_0
    //   1029: aload_1
    //   1030: getstatic 209	a/j/b/a/c/e/a$ag:Ckq	La/j/b/a/c/g/s;
    //   1033: aload_2
    //   1034: invokevirtual 168	a/j/b/a/c/g/e:a	(La/j/b/a/c/g/s;La/j/b/a/c/g/g;)La/j/b/a/c/g/q;
    //   1037: checkcast 204	a/j/b/a/c/e/a$ag
    //   1040: putfield 202	a/j/b/a/c/e/a$o:Clq	La/j/b/a/c/e/a$ag;
    //   1043: aload 10
    //   1045: ifnull +40 -> 1085
    //   1048: iload_3
    //   1049: istore 5
    //   1051: iload_3
    //   1052: istore 4
    //   1054: iload_3
    //   1055: istore 6
    //   1057: aload 10
    //   1059: aload_0
    //   1060: getfield 202	a/j/b/a/c/e/a$o:Clq	La/j/b/a/c/e/a$ag;
    //   1063: invokevirtual 214	a/j/b/a/c/e/a$ag$a:g	(La/j/b/a/c/e/a$ag;)La/j/b/a/c/e/a$ag$a;
    //   1066: pop
    //   1067: iload_3
    //   1068: istore 5
    //   1070: iload_3
    //   1071: istore 4
    //   1073: iload_3
    //   1074: istore 6
    //   1076: aload_0
    //   1077: aload 10
    //   1079: invokevirtual 218	a/j/b/a/c/e/a$ag$a:eko	()La/j/b/a/c/e/a$ag;
    //   1082: putfield 202	a/j/b/a/c/e/a$o:Clq	La/j/b/a/c/e/a$ag;
    //   1085: iload_3
    //   1086: istore 5
    //   1088: iload_3
    //   1089: istore 4
    //   1091: iload_3
    //   1092: istore 6
    //   1094: aload_0
    //   1095: aload_0
    //   1096: getfield 108	a/j/b/a/c/e/a$o:Ckr	I
    //   1099: sipush 128
    //   1102: ior
    //   1103: putfield 108	a/j/b/a/c/e/a$o:Ckr	I
    //   1106: goto -1065 -> 41
    //   1109: iload_3
    //   1110: istore 7
    //   1112: iload_3
    //   1113: sipush 1024
    //   1116: iand
    //   1117: sipush 1024
    //   1120: if_icmpeq +30 -> 1150
    //   1123: iload_3
    //   1124: istore 5
    //   1126: iload_3
    //   1127: istore 4
    //   1129: iload_3
    //   1130: istore 6
    //   1132: aload_0
    //   1133: new 179	java/util/ArrayList
    //   1136: dup
    //   1137: invokespecial 180	java/util/ArrayList:<init>	()V
    //   1140: putfield 129	a/j/b/a/c/e/a$o:Clr	Ljava/util/List;
    //   1143: iload_3
    //   1144: sipush 1024
    //   1147: ior
    //   1148: istore 7
    //   1150: iload 7
    //   1152: istore 5
    //   1154: iload 7
    //   1156: istore 4
    //   1158: iload 7
    //   1160: istore 6
    //   1162: aload_0
    //   1163: getfield 129	a/j/b/a/c/e/a$o:Clr	Ljava/util/List;
    //   1166: aload_1
    //   1167: invokevirtual 111	a/j/b/a/c/g/e:sl	()I
    //   1170: invokestatic 224	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1173: invokeinterface 189 2 0
    //   1178: pop
    //   1179: iload 7
    //   1181: istore_3
    //   1182: goto -1141 -> 41
    //   1185: iload_3
    //   1186: istore 5
    //   1188: iload_3
    //   1189: istore 4
    //   1191: iload_3
    //   1192: istore 6
    //   1194: aload_1
    //   1195: aload_1
    //   1196: invokevirtual 111	a/j/b/a/c/g/e:sl	()I
    //   1199: invokevirtual 228	a/j/b/a/c/g/e:eP	(I)I
    //   1202: istore 9
    //   1204: iload_3
    //   1205: istore 7
    //   1207: iload_3
    //   1208: sipush 1024
    //   1211: iand
    //   1212: sipush 1024
    //   1215: if_icmpeq +49 -> 1264
    //   1218: iload_3
    //   1219: istore 5
    //   1221: iload_3
    //   1222: istore 4
    //   1224: iload_3
    //   1225: istore 6
    //   1227: iload_3
    //   1228: istore 7
    //   1230: aload_1
    //   1231: invokevirtual 231	a/j/b/a/c/g/e:so	()I
    //   1234: ifle +30 -> 1264
    //   1237: iload_3
    //   1238: istore 5
    //   1240: iload_3
    //   1241: istore 4
    //   1243: iload_3
    //   1244: istore 6
    //   1246: aload_0
    //   1247: new 179	java/util/ArrayList
    //   1250: dup
    //   1251: invokespecial 180	java/util/ArrayList:<init>	()V
    //   1254: putfield 129	a/j/b/a/c/e/a$o:Clr	Ljava/util/List;
    //   1257: iload_3
    //   1258: sipush 1024
    //   1261: ior
    //   1262: istore 7
    //   1264: iload 7
    //   1266: istore 5
    //   1268: iload 7
    //   1270: istore 4
    //   1272: iload 7
    //   1274: istore 6
    //   1276: aload_1
    //   1277: invokevirtual 231	a/j/b/a/c/g/e:so	()I
    //   1280: ifle +35 -> 1315
    //   1283: iload 7
    //   1285: istore 5
    //   1287: iload 7
    //   1289: istore 4
    //   1291: iload 7
    //   1293: istore 6
    //   1295: aload_0
    //   1296: getfield 129	a/j/b/a/c/e/a$o:Clr	Ljava/util/List;
    //   1299: aload_1
    //   1300: invokevirtual 111	a/j/b/a/c/g/e:sl	()I
    //   1303: invokestatic 224	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1306: invokeinterface 189 2 0
    //   1311: pop
    //   1312: goto -48 -> 1264
    //   1315: iload 7
    //   1317: istore 5
    //   1319: iload 7
    //   1321: istore 4
    //   1323: iload 7
    //   1325: istore 6
    //   1327: aload_1
    //   1328: iload 9
    //   1330: invokevirtual 234	a/j/b/a/c/g/e:eQ	(I)V
    //   1333: iload 7
    //   1335: istore_3
    //   1336: goto -1295 -> 41
    //   1339: iload_3
    //   1340: istore 5
    //   1342: iload_3
    //   1343: istore 4
    //   1345: iload_3
    //   1346: istore 6
    //   1348: aload_0
    //   1349: getfield 108	a/j/b/a/c/e/a$o:Ckr	I
    //   1352: sipush 256
    //   1355: iand
    //   1356: sipush 256
    //   1359: if_icmpne +262 -> 1621
    //   1362: iload_3
    //   1363: istore 5
    //   1365: iload_3
    //   1366: istore 4
    //   1368: iload_3
    //   1369: istore 6
    //   1371: aload_0
    //   1372: getfield 236	a/j/b/a/c/e/a$o:Cml	La/j/b/a/c/e/a$g;
    //   1375: invokevirtual 242	a/j/b/a/c/e/a$g:eih	()La/j/b/a/c/e/a$g$a;
    //   1378: astore 10
    //   1380: iload_3
    //   1381: istore 5
    //   1383: iload_3
    //   1384: istore 4
    //   1386: iload_3
    //   1387: istore 6
    //   1389: aload_0
    //   1390: aload_1
    //   1391: getstatic 243	a/j/b/a/c/e/a$g:Ckq	La/j/b/a/c/g/s;
    //   1394: aload_2
    //   1395: invokevirtual 168	a/j/b/a/c/g/e:a	(La/j/b/a/c/g/s;La/j/b/a/c/g/g;)La/j/b/a/c/g/q;
    //   1398: checkcast 238	a/j/b/a/c/e/a$g
    //   1401: putfield 236	a/j/b/a/c/e/a$o:Cml	La/j/b/a/c/e/a$g;
    //   1404: aload 10
    //   1406: ifnull +40 -> 1446
    //   1409: iload_3
    //   1410: istore 5
    //   1412: iload_3
    //   1413: istore 4
    //   1415: iload_3
    //   1416: istore 6
    //   1418: aload 10
    //   1420: aload_0
    //   1421: getfield 236	a/j/b/a/c/e/a$o:Cml	La/j/b/a/c/e/a$g;
    //   1424: invokevirtual 248	a/j/b/a/c/e/a$g$a:d	(La/j/b/a/c/e/a$g;)La/j/b/a/c/e/a$g$a;
    //   1427: pop
    //   1428: iload_3
    //   1429: istore 5
    //   1431: iload_3
    //   1432: istore 4
    //   1434: iload_3
    //   1435: istore 6
    //   1437: aload_0
    //   1438: aload 10
    //   1440: invokevirtual 252	a/j/b/a/c/e/a$g$a:eij	()La/j/b/a/c/e/a$g;
    //   1443: putfield 236	a/j/b/a/c/e/a$o:Cml	La/j/b/a/c/e/a$g;
    //   1446: iload_3
    //   1447: istore 5
    //   1449: iload_3
    //   1450: istore 4
    //   1452: iload_3
    //   1453: istore 6
    //   1455: aload_0
    //   1456: aload_0
    //   1457: getfield 108	a/j/b/a/c/e/a$o:Ckr	I
    //   1460: sipush 256
    //   1463: ior
    //   1464: putfield 108	a/j/b/a/c/e/a$o:Ckr	I
    //   1467: goto -1426 -> 41
    //   1470: iload_3
    //   1471: bipush 32
    //   1473: iand
    //   1474: bipush 32
    //   1476: if_icmpne +14 -> 1490
    //   1479: aload_0
    //   1480: aload_0
    //   1481: getfield 119	a/j/b/a/c/e/a$o:Cld	Ljava/util/List;
    //   1484: invokestatic 125	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1487: putfield 119	a/j/b/a/c/e/a$o:Cld	Ljava/util/List;
    //   1490: iload_3
    //   1491: sipush 256
    //   1494: iand
    //   1495: sipush 256
    //   1498: if_icmpne +14 -> 1512
    //   1501: aload_0
    //   1502: aload_0
    //   1503: getfield 127	a/j/b/a/c/e/a$o:ClC	Ljava/util/List;
    //   1506: invokestatic 125	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1509: putfield 127	a/j/b/a/c/e/a$o:ClC	Ljava/util/List;
    //   1512: iload_3
    //   1513: sipush 1024
    //   1516: iand
    //   1517: sipush 1024
    //   1520: if_icmpne +14 -> 1534
    //   1523: aload_0
    //   1524: aload_0
    //   1525: getfield 129	a/j/b/a/c/e/a$o:Clr	Ljava/util/List;
    //   1528: invokestatic 125	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1531: putfield 129	a/j/b/a/c/e/a$o:Clr	Ljava/util/List;
    //   1534: aload 12
    //   1536: invokevirtual 132	a/j/b/a/c/g/f:flush	()V
    //   1539: aload_0
    //   1540: aload 11
    //   1542: invokevirtual 138	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   1545: putfield 80	a/j/b/a/c/e/a$o:Ckp	La/j/b/a/c/g/d;
    //   1548: aload_0
    //   1549: getfield 142	a/j/b/a/c/g/i$c:Crw	La/j/b/a/c/g/h;
    //   1552: invokevirtual 147	a/j/b/a/c/g/h:emF	()V
    //   1555: ldc 86
    //   1557: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1560: return
    //   1561: astore_1
    //   1562: aload_0
    //   1563: aload 11
    //   1565: invokevirtual 138	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   1568: putfield 80	a/j/b/a/c/e/a$o:Ckp	La/j/b/a/c/g/d;
    //   1571: goto -23 -> 1548
    //   1574: astore_1
    //   1575: aload_0
    //   1576: aload 11
    //   1578: invokevirtual 138	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   1581: putfield 80	a/j/b/a/c/e/a$o:Ckp	La/j/b/a/c/g/d;
    //   1584: ldc 86
    //   1586: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1589: aload_1
    //   1590: athrow
    //   1591: astore_2
    //   1592: aload_0
    //   1593: aload 11
    //   1595: invokevirtual 138	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   1598: putfield 80	a/j/b/a/c/e/a$o:Ckp	La/j/b/a/c/g/d;
    //   1601: goto -1243 -> 358
    //   1604: astore_1
    //   1605: aload_0
    //   1606: aload 11
    //   1608: invokevirtual 138	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   1611: putfield 80	a/j/b/a/c/e/a$o:Ckp	La/j/b/a/c/g/d;
    //   1614: ldc 86
    //   1616: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1619: aload_1
    //   1620: athrow
    //   1621: aconst_null
    //   1622: astore 10
    //   1624: goto -244 -> 1380
    //   1627: aconst_null
    //   1628: astore 10
    //   1630: goto -611 -> 1019
    //   1633: aconst_null
    //   1634: astore 10
    //   1636: goto -943 -> 693
    //   1639: aconst_null
    //   1640: astore 10
    //   1642: goto -1151 -> 491
    //   1645: goto -1461 -> 184
    //   1648: iconst_1
    //   1649: istore 8
    //   1651: goto -1610 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1654	0	this	o
    //   0	1654	1	parame	a.j.b.a.c.g.e
    //   0	1654	2	paramg	g
    //   24	1493	3	i	int
    //   50	1401	4	j	int
    //   47	1401	5	k	int
    //   53	1401	6	m	int
    //   59	1275	7	n	int
    //   39	1611	8	i1	int
    //   1202	127	9	i2	int
    //   489	1152	10	localObject	java.lang.Object
    //   28	1579	11	localb	a.j.b.a.c.g.d.b
    //   36	1499	12	localf	f
    // Exception table:
    //   from	to	target	type
    //   55	61	251	a/j/b/a/c/g/k
    //   193	206	251	a/j/b/a/c/g/k
    //   221	231	251	a/j/b/a/c/g/k
    //   240	248	251	a/j/b/a/c/g/k
    //   381	391	251	a/j/b/a/c/g/k
    //   400	408	251	a/j/b/a/c/g/k
    //   461	473	251	a/j/b/a/c/g/k
    //   482	491	251	a/j/b/a/c/g/k
    //   500	515	251	a/j/b/a/c/g/k
    //   529	539	251	a/j/b/a/c/g/k
    //   548	557	251	a/j/b/a/c/g/k
    //   566	577	251	a/j/b/a/c/g/k
    //   601	612	251	a/j/b/a/c/g/k
    //   630	648	251	a/j/b/a/c/g/k
    //   663	675	251	a/j/b/a/c/g/k
    //   684	693	251	a/j/b/a/c/g/k
    //   702	717	251	a/j/b/a/c/g/k
    //   731	741	251	a/j/b/a/c/g/k
    //   750	759	251	a/j/b/a/c/g/k
    //   768	779	251	a/j/b/a/c/g/k
    //   805	816	251	a/j/b/a/c/g/k
    //   835	853	251	a/j/b/a/c/g/k
    //   868	879	251	a/j/b/a/c/g/k
    //   888	896	251	a/j/b/a/c/g/k
    //   908	919	251	a/j/b/a/c/g/k
    //   928	936	251	a/j/b/a/c/g/k
    //   948	958	251	a/j/b/a/c/g/k
    //   967	975	251	a/j/b/a/c/g/k
    //   987	1001	251	a/j/b/a/c/g/k
    //   1010	1019	251	a/j/b/a/c/g/k
    //   1028	1043	251	a/j/b/a/c/g/k
    //   1057	1067	251	a/j/b/a/c/g/k
    //   1076	1085	251	a/j/b/a/c/g/k
    //   1094	1106	251	a/j/b/a/c/g/k
    //   1132	1143	251	a/j/b/a/c/g/k
    //   1162	1179	251	a/j/b/a/c/g/k
    //   1194	1204	251	a/j/b/a/c/g/k
    //   1230	1237	251	a/j/b/a/c/g/k
    //   1246	1257	251	a/j/b/a/c/g/k
    //   1276	1283	251	a/j/b/a/c/g/k
    //   1295	1312	251	a/j/b/a/c/g/k
    //   1327	1333	251	a/j/b/a/c/g/k
    //   1348	1362	251	a/j/b/a/c/g/k
    //   1371	1380	251	a/j/b/a/c/g/k
    //   1389	1404	251	a/j/b/a/c/g/k
    //   1418	1428	251	a/j/b/a/c/g/k
    //   1437	1446	251	a/j/b/a/c/g/k
    //   1455	1467	251	a/j/b/a/c/g/k
    //   55	61	276	finally
    //   193	206	276	finally
    //   221	231	276	finally
    //   240	248	276	finally
    //   256	261	276	finally
    //   265	270	276	finally
    //   274	276	276	finally
    //   381	391	276	finally
    //   400	408	276	finally
    //   416	428	276	finally
    //   432	437	276	finally
    //   441	446	276	finally
    //   450	452	276	finally
    //   461	473	276	finally
    //   482	491	276	finally
    //   500	515	276	finally
    //   529	539	276	finally
    //   548	557	276	finally
    //   566	577	276	finally
    //   601	612	276	finally
    //   630	648	276	finally
    //   663	675	276	finally
    //   684	693	276	finally
    //   702	717	276	finally
    //   731	741	276	finally
    //   750	759	276	finally
    //   768	779	276	finally
    //   805	816	276	finally
    //   835	853	276	finally
    //   868	879	276	finally
    //   888	896	276	finally
    //   908	919	276	finally
    //   928	936	276	finally
    //   948	958	276	finally
    //   967	975	276	finally
    //   987	1001	276	finally
    //   1010	1019	276	finally
    //   1028	1043	276	finally
    //   1057	1067	276	finally
    //   1076	1085	276	finally
    //   1094	1106	276	finally
    //   1132	1143	276	finally
    //   1162	1179	276	finally
    //   1194	1204	276	finally
    //   1230	1237	276	finally
    //   1246	1257	276	finally
    //   1276	1283	276	finally
    //   1295	1312	276	finally
    //   1327	1333	276	finally
    //   1348	1362	276	finally
    //   1371	1380	276	finally
    //   1389	1404	276	finally
    //   1418	1428	276	finally
    //   1437	1446	276	finally
    //   1455	1467	276	finally
    //   55	61	411	java/io/IOException
    //   193	206	411	java/io/IOException
    //   221	231	411	java/io/IOException
    //   240	248	411	java/io/IOException
    //   381	391	411	java/io/IOException
    //   400	408	411	java/io/IOException
    //   461	473	411	java/io/IOException
    //   482	491	411	java/io/IOException
    //   500	515	411	java/io/IOException
    //   529	539	411	java/io/IOException
    //   548	557	411	java/io/IOException
    //   566	577	411	java/io/IOException
    //   601	612	411	java/io/IOException
    //   630	648	411	java/io/IOException
    //   663	675	411	java/io/IOException
    //   684	693	411	java/io/IOException
    //   702	717	411	java/io/IOException
    //   731	741	411	java/io/IOException
    //   750	759	411	java/io/IOException
    //   768	779	411	java/io/IOException
    //   805	816	411	java/io/IOException
    //   835	853	411	java/io/IOException
    //   868	879	411	java/io/IOException
    //   888	896	411	java/io/IOException
    //   908	919	411	java/io/IOException
    //   928	936	411	java/io/IOException
    //   948	958	411	java/io/IOException
    //   967	975	411	java/io/IOException
    //   987	1001	411	java/io/IOException
    //   1010	1019	411	java/io/IOException
    //   1028	1043	411	java/io/IOException
    //   1057	1067	411	java/io/IOException
    //   1076	1085	411	java/io/IOException
    //   1094	1106	411	java/io/IOException
    //   1132	1143	411	java/io/IOException
    //   1162	1179	411	java/io/IOException
    //   1194	1204	411	java/io/IOException
    //   1230	1237	411	java/io/IOException
    //   1246	1257	411	java/io/IOException
    //   1276	1283	411	java/io/IOException
    //   1295	1312	411	java/io/IOException
    //   1327	1333	411	java/io/IOException
    //   1348	1362	411	java/io/IOException
    //   1371	1380	411	java/io/IOException
    //   1389	1404	411	java/io/IOException
    //   1418	1428	411	java/io/IOException
    //   1437	1446	411	java/io/IOException
    //   1455	1467	411	java/io/IOException
    //   1534	1539	1561	java/io/IOException
    //   1534	1539	1574	finally
    //   344	349	1591	java/io/IOException
    //   344	349	1604	finally
  }
  
  private a$o(i.b<o, ?> paramb)
  {
    super(paramb);
    this.Ckp = paramb.Ckp;
  }
  
  public static o b(InputStream paramInputStream, g paramg)
  {
    AppMethodBeat.i(120665);
    paramInputStream = (o)Ckq.j(paramInputStream, paramg);
    AppMethodBeat.o(120665);
    return paramInputStream;
  }
  
  private void egZ()
  {
    AppMethodBeat.i(120661);
    this.CkK = 6;
    this.Cmg = 6;
    this.ClT = 0;
    this.Cmh = a.aa.ejw();
    this.Cmi = 0;
    this.Cld = Collections.emptyList();
    this.Cmj = a.aa.ejw();
    this.Cmk = 0;
    this.ClC = Collections.emptyList();
    this.Clq = a.ag.ekl();
    this.Clr = Collections.emptyList();
    this.Cml = a.g.eig();
    AppMethodBeat.o(120661);
  }
  
  public static o eiJ()
  {
    return Cmf;
  }
  
  public final void a(f paramf)
  {
    int j = 0;
    AppMethodBeat.i(120663);
    sy();
    i.c.a locala = emM();
    if ((this.Ckr & 0x2) == 2) {
      paramf.bj(1, this.Cmg);
    }
    if ((this.Ckr & 0x4) == 4) {
      paramf.bj(2, this.ClT);
    }
    if ((this.Ckr & 0x8) == 8) {
      paramf.a(3, this.Cmh);
    }
    int i = 0;
    while (i < this.Cld.size())
    {
      paramf.a(4, (q)this.Cld.get(i));
      i += 1;
    }
    if ((this.Ckr & 0x20) == 32) {
      paramf.a(5, this.Cmj);
    }
    i = 0;
    while (i < this.ClC.size())
    {
      paramf.a(6, (q)this.ClC.get(i));
      i += 1;
    }
    if ((this.Ckr & 0x10) == 16) {
      paramf.bj(7, this.Cmi);
    }
    if ((this.Ckr & 0x40) == 64) {
      paramf.bj(8, this.Cmk);
    }
    if ((this.Ckr & 0x1) == 1) {
      paramf.bj(9, this.CkK);
    }
    i = j;
    if ((this.Ckr & 0x80) == 128)
    {
      paramf.a(30, this.Clq);
      i = j;
    }
    while (i < this.Clr.size())
    {
      paramf.bj(31, ((Integer)this.Clr.get(i)).intValue());
      i += 1;
    }
    if ((this.Ckr & 0x100) == 256) {
      paramf.a(32, this.Cml);
    }
    locala.b(19000, paramf);
    paramf.d(this.Ckp);
    AppMethodBeat.o(120663);
  }
  
  public final s<o> egX()
  {
    return Ckq;
  }
  
  public final boolean ehK()
  {
    return (this.Ckr & 0x80) == 128;
  }
  
  public final boolean ehx()
  {
    return (this.Ckr & 0x1) == 1;
  }
  
  public final boolean eiK()
  {
    return (this.Ckr & 0x2) == 2;
  }
  
  public final boolean eiL()
  {
    return (this.Ckr & 0x8) == 8;
  }
  
  public final boolean eiM()
  {
    return (this.Ckr & 0x10) == 16;
  }
  
  public final boolean eiN()
  {
    return (this.Ckr & 0x20) == 32;
  }
  
  public final boolean eiO()
  {
    return (this.Ckr & 0x40) == 64;
  }
  
  public final boolean eiP()
  {
    return (this.Ckr & 0x100) == 256;
  }
  
  public final boolean eiv()
  {
    return (this.Ckr & 0x4) == 4;
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(120662);
    int i = this.Cku;
    if (i == 1)
    {
      AppMethodBeat.o(120662);
      return true;
    }
    if (i == 0)
    {
      AppMethodBeat.o(120662);
      return false;
    }
    if (!eiv())
    {
      this.Cku = 0;
      AppMethodBeat.o(120662);
      return false;
    }
    if ((eiL()) && (!this.Cmh.isInitialized()))
    {
      this.Cku = 0;
      AppMethodBeat.o(120662);
      return false;
    }
    i = 0;
    while (i < this.Cld.size())
    {
      if (!((a.ae)this.Cld.get(i)).isInitialized())
      {
        this.Cku = 0;
        AppMethodBeat.o(120662);
        return false;
      }
      i += 1;
    }
    if ((eiN()) && (!this.Cmj.isInitialized()))
    {
      this.Cku = 0;
      AppMethodBeat.o(120662);
      return false;
    }
    i = 0;
    while (i < this.ClC.size())
    {
      if (!((a.ai)this.ClC.get(i)).isInitialized())
      {
        this.Cku = 0;
        AppMethodBeat.o(120662);
        return false;
      }
      i += 1;
    }
    if ((ehK()) && (!this.Clq.isInitialized()))
    {
      this.Cku = 0;
      AppMethodBeat.o(120662);
      return false;
    }
    if ((eiP()) && (!this.Cml.isInitialized()))
    {
      this.Cku = 0;
      AppMethodBeat.o(120662);
      return false;
    }
    if (!this.Crw.isInitialized())
    {
      this.Cku = 0;
      AppMethodBeat.o(120662);
      return false;
    }
    this.Cku = 1;
    AppMethodBeat.o(120662);
    return true;
  }
  
  public final int sy()
  {
    AppMethodBeat.i(120664);
    int i = this.Ckv;
    if (i != -1)
    {
      AppMethodBeat.o(120664);
      return i;
    }
    if ((this.Ckr & 0x2) == 2) {}
    for (int j = f.bl(1, this.Cmg) + 0;; j = 0)
    {
      i = j;
      if ((this.Ckr & 0x4) == 4) {
        i = j + f.bl(2, this.ClT);
      }
      j = i;
      if ((this.Ckr & 0x8) == 8) {
        j = i + f.c(3, this.Cmh);
      }
      int k = 0;
      i = j;
      j = k;
      while (j < this.Cld.size())
      {
        i += f.c(4, (q)this.Cld.get(j));
        j += 1;
      }
      j = i;
      if ((this.Ckr & 0x20) == 32) {
        j = i + f.c(5, this.Cmj);
      }
      k = 0;
      i = j;
      j = k;
      while (j < this.ClC.size())
      {
        i += f.c(6, (q)this.ClC.get(j));
        j += 1;
      }
      j = i;
      if ((this.Ckr & 0x10) == 16) {
        j = i + f.bl(7, this.Cmi);
      }
      i = j;
      if ((this.Ckr & 0x40) == 64) {
        i = j + f.bl(8, this.Cmk);
      }
      j = i;
      if ((this.Ckr & 0x1) == 1) {
        j = i + f.bl(9, this.CkK);
      }
      i = j;
      if ((this.Ckr & 0x80) == 128) {
        i = j + f.c(30, this.Clq);
      }
      k = 0;
      int m;
      for (j = 0; k < this.Clr.size(); j = m + j)
      {
        m = f.eU(((Integer)this.Clr.get(k)).intValue());
        k += 1;
      }
      j = i + j + this.Clr.size() * 2;
      i = j;
      if ((this.Ckr & 0x100) == 256) {
        i = j + f.c(32, this.Cml);
      }
      i = i + this.Crw.sy() + this.Ckp.size();
      this.Ckv = i;
      AppMethodBeat.o(120664);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.j.b.a.c.e.a.o
 * JD-Core Version:    0.7.0.1
 */