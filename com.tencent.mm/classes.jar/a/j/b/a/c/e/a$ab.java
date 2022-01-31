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

public final class a$ab
  extends i.c<ab>
  implements a.ac
{
  public static s<ab> Ckq;
  private static final ab Cnj;
  public int CkK;
  private final d Ckp;
  private int Ckr;
  private byte Cku = -1;
  private int Ckv = -1;
  public int ClT;
  public List<a.ae> Cld;
  public List<Integer> Clr;
  public a.aa Cnk;
  public int Cnl;
  public a.aa Cnm;
  public int Cnn;
  public List<a.a> Cno;
  
  static
  {
    AppMethodBeat.i(120916);
    Ckq = new a.ab.1();
    ab localab = new ab();
    Cnj = localab;
    localab.egZ();
    AppMethodBeat.o(120916);
  }
  
  private a$ab()
  {
    this.Ckp = d.Cre;
  }
  
  /* Error */
  private a$ab(a.j.b.a.c.g.e parame, g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 65	a/j/b/a/c/g/i$c:<init>	()V
    //   4: ldc 82
    //   6: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 67	a/j/b/a/c/e/a$ab:Cku	B
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 69	a/j/b/a/c/e/a$ab:Ckv	I
    //   19: aload_0
    //   20: invokespecial 60	a/j/b/a/c/e/a$ab:egZ	()V
    //   23: iconst_0
    //   24: istore_3
    //   25: invokestatic 86	a/j/b/a/c/g/d:emp	()La/j/b/a/c/g/d$b;
    //   28: astore 10
    //   30: aload 10
    //   32: iconst_1
    //   33: invokestatic 92	a/j/b/a/c/g/f:e	(Ljava/io/OutputStream;I)La/j/b/a/c/g/f;
    //   36: astore 11
    //   38: iconst_0
    //   39: istore 8
    //   41: iload 8
    //   43: ifne +1042 -> 1085
    //   46: iload_3
    //   47: istore 4
    //   49: iload_3
    //   50: istore 5
    //   52: iload_3
    //   53: istore 6
    //   55: aload_1
    //   56: invokevirtual 98	a/j/b/a/c/g/e:sk	()I
    //   59: istore 7
    //   61: iload 7
    //   63: lookupswitch	default:+1200->1263, 0:+1203->1266, 8:+125->188, 16:+277->340, 26:+357->420, 34:+428->491, 40:+553->616, 50:+593->656, 56:+721->784, 66:+761->824, 248:+838->901, 250:+914->977
    //   161: istore 4
    //   163: iload_3
    //   164: istore 5
    //   166: iload_3
    //   167: istore 6
    //   169: aload_0
    //   170: aload_1
    //   171: aload 11
    //   173: aload_2
    //   174: iload 7
    //   176: invokevirtual 102	a/j/b/a/c/e/a$ab:a	(La/j/b/a/c/g/e;La/j/b/a/c/g/f;La/j/b/a/c/g/g;I)Z
    //   179: ifne +1081 -> 1260
    //   182: iconst_1
    //   183: istore 8
    //   185: goto -144 -> 41
    //   188: iload_3
    //   189: istore 4
    //   191: iload_3
    //   192: istore 5
    //   194: iload_3
    //   195: istore 6
    //   197: aload_0
    //   198: aload_0
    //   199: getfield 104	a/j/b/a/c/e/a$ab:Ckr	I
    //   202: iconst_1
    //   203: ior
    //   204: putfield 104	a/j/b/a/c/e/a$ab:Ckr	I
    //   207: iload_3
    //   208: istore 4
    //   210: iload_3
    //   211: istore 5
    //   213: iload_3
    //   214: istore 6
    //   216: aload_0
    //   217: aload_1
    //   218: invokevirtual 107	a/j/b/a/c/g/e:sl	()I
    //   221: putfield 109	a/j/b/a/c/e/a$ab:CkK	I
    //   224: goto -183 -> 41
    //   227: astore_1
    //   228: iload 4
    //   230: istore_3
    //   231: aload_1
    //   232: aload_0
    //   233: putfield 113	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   236: iload 4
    //   238: istore_3
    //   239: ldc 82
    //   241: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   244: iload 4
    //   246: istore_3
    //   247: aload_1
    //   248: athrow
    //   249: astore_1
    //   250: iload_3
    //   251: iconst_4
    //   252: iand
    //   253: iconst_4
    //   254: if_icmpne +14 -> 268
    //   257: aload_0
    //   258: aload_0
    //   259: getfield 115	a/j/b/a/c/e/a$ab:Cld	Ljava/util/List;
    //   262: invokestatic 121	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   265: putfield 115	a/j/b/a/c/e/a$ab:Cld	Ljava/util/List;
    //   268: iload_3
    //   269: sipush 128
    //   272: iand
    //   273: sipush 128
    //   276: if_icmpne +14 -> 290
    //   279: aload_0
    //   280: aload_0
    //   281: getfield 123	a/j/b/a/c/e/a$ab:Cno	Ljava/util/List;
    //   284: invokestatic 121	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   287: putfield 123	a/j/b/a/c/e/a$ab:Cno	Ljava/util/List;
    //   290: iload_3
    //   291: sipush 256
    //   294: iand
    //   295: sipush 256
    //   298: if_icmpne +14 -> 312
    //   301: aload_0
    //   302: aload_0
    //   303: getfield 125	a/j/b/a/c/e/a$ab:Clr	Ljava/util/List;
    //   306: invokestatic 121	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   309: putfield 125	a/j/b/a/c/e/a$ab:Clr	Ljava/util/List;
    //   312: aload 11
    //   314: invokevirtual 128	a/j/b/a/c/g/f:flush	()V
    //   317: aload_0
    //   318: aload 10
    //   320: invokevirtual 134	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   323: putfield 76	a/j/b/a/c/e/a$ab:Ckp	La/j/b/a/c/g/d;
    //   326: aload_0
    //   327: getfield 138	a/j/b/a/c/g/i$c:Crw	La/j/b/a/c/g/h;
    //   330: invokevirtual 143	a/j/b/a/c/g/h:emF	()V
    //   333: ldc 82
    //   335: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   338: aload_1
    //   339: athrow
    //   340: iload_3
    //   341: istore 4
    //   343: iload_3
    //   344: istore 5
    //   346: iload_3
    //   347: istore 6
    //   349: aload_0
    //   350: aload_0
    //   351: getfield 104	a/j/b/a/c/e/a$ab:Ckr	I
    //   354: iconst_2
    //   355: ior
    //   356: putfield 104	a/j/b/a/c/e/a$ab:Ckr	I
    //   359: iload_3
    //   360: istore 4
    //   362: iload_3
    //   363: istore 5
    //   365: iload_3
    //   366: istore 6
    //   368: aload_0
    //   369: aload_1
    //   370: invokevirtual 107	a/j/b/a/c/g/e:sl	()I
    //   373: putfield 145	a/j/b/a/c/e/a$ab:ClT	I
    //   376: goto -335 -> 41
    //   379: astore_1
    //   380: iload 5
    //   382: istore 4
    //   384: iload 4
    //   386: istore_3
    //   387: new 79	a/j/b/a/c/g/k
    //   390: dup
    //   391: aload_1
    //   392: invokevirtual 149	java/io/IOException:getMessage	()Ljava/lang/String;
    //   395: invokespecial 152	a/j/b/a/c/g/k:<init>	(Ljava/lang/String;)V
    //   398: astore_1
    //   399: iload 4
    //   401: istore_3
    //   402: aload_1
    //   403: aload_0
    //   404: putfield 113	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   407: iload 4
    //   409: istore_3
    //   410: ldc 82
    //   412: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   415: iload 4
    //   417: istore_3
    //   418: aload_1
    //   419: athrow
    //   420: iload_3
    //   421: istore 7
    //   423: iload_3
    //   424: iconst_4
    //   425: iand
    //   426: iconst_4
    //   427: if_icmpeq +28 -> 455
    //   430: iload_3
    //   431: istore 4
    //   433: iload_3
    //   434: istore 5
    //   436: iload_3
    //   437: istore 6
    //   439: aload_0
    //   440: new 154	java/util/ArrayList
    //   443: dup
    //   444: invokespecial 155	java/util/ArrayList:<init>	()V
    //   447: putfield 115	a/j/b/a/c/e/a$ab:Cld	Ljava/util/List;
    //   450: iload_3
    //   451: iconst_4
    //   452: ior
    //   453: istore 7
    //   455: iload 7
    //   457: istore 4
    //   459: iload 7
    //   461: istore 5
    //   463: iload 7
    //   465: istore 6
    //   467: aload_0
    //   468: getfield 115	a/j/b/a/c/e/a$ab:Cld	Ljava/util/List;
    //   471: aload_1
    //   472: getstatic 158	a/j/b/a/c/e/a$ae:Ckq	La/j/b/a/c/g/s;
    //   475: aload_2
    //   476: invokevirtual 161	a/j/b/a/c/g/e:a	(La/j/b/a/c/g/s;La/j/b/a/c/g/g;)La/j/b/a/c/g/q;
    //   479: invokeinterface 167 2 0
    //   484: pop
    //   485: iload 7
    //   487: istore_3
    //   488: goto -447 -> 41
    //   491: iload_3
    //   492: istore 4
    //   494: iload_3
    //   495: istore 5
    //   497: iload_3
    //   498: istore 6
    //   500: aload_0
    //   501: getfield 104	a/j/b/a/c/e/a$ab:Ckr	I
    //   504: iconst_4
    //   505: iand
    //   506: iconst_4
    //   507: if_icmpne +747 -> 1254
    //   510: iload_3
    //   511: istore 4
    //   513: iload_3
    //   514: istore 5
    //   516: iload_3
    //   517: istore 6
    //   519: aload_0
    //   520: getfield 169	a/j/b/a/c/e/a$ab:Cnk	La/j/b/a/c/e/a$aa;
    //   523: invokevirtual 175	a/j/b/a/c/e/a$aa:ejJ	()La/j/b/a/c/e/a$aa$c;
    //   526: astore 9
    //   528: iload_3
    //   529: istore 4
    //   531: iload_3
    //   532: istore 5
    //   534: iload_3
    //   535: istore 6
    //   537: aload_0
    //   538: aload_1
    //   539: getstatic 176	a/j/b/a/c/e/a$aa:Ckq	La/j/b/a/c/g/s;
    //   542: aload_2
    //   543: invokevirtual 161	a/j/b/a/c/g/e:a	(La/j/b/a/c/g/s;La/j/b/a/c/g/g;)La/j/b/a/c/g/q;
    //   546: checkcast 171	a/j/b/a/c/e/a$aa
    //   549: putfield 169	a/j/b/a/c/e/a$ab:Cnk	La/j/b/a/c/e/a$aa;
    //   552: aload 9
    //   554: ifnull +40 -> 594
    //   557: iload_3
    //   558: istore 4
    //   560: iload_3
    //   561: istore 5
    //   563: iload_3
    //   564: istore 6
    //   566: aload 9
    //   568: aload_0
    //   569: getfield 169	a/j/b/a/c/e/a$ab:Cnk	La/j/b/a/c/e/a$aa;
    //   572: invokevirtual 182	a/j/b/a/c/e/a$aa$c:j	(La/j/b/a/c/e/a$aa;)La/j/b/a/c/e/a$aa$c;
    //   575: pop
    //   576: iload_3
    //   577: istore 4
    //   579: iload_3
    //   580: istore 5
    //   582: iload_3
    //   583: istore 6
    //   585: aload_0
    //   586: aload 9
    //   588: invokevirtual 186	a/j/b/a/c/e/a$aa$c:ejS	()La/j/b/a/c/e/a$aa;
    //   591: putfield 169	a/j/b/a/c/e/a$ab:Cnk	La/j/b/a/c/e/a$aa;
    //   594: iload_3
    //   595: istore 4
    //   597: iload_3
    //   598: istore 5
    //   600: iload_3
    //   601: istore 6
    //   603: aload_0
    //   604: aload_0
    //   605: getfield 104	a/j/b/a/c/e/a$ab:Ckr	I
    //   608: iconst_4
    //   609: ior
    //   610: putfield 104	a/j/b/a/c/e/a$ab:Ckr	I
    //   613: goto -572 -> 41
    //   616: iload_3
    //   617: istore 4
    //   619: iload_3
    //   620: istore 5
    //   622: iload_3
    //   623: istore 6
    //   625: aload_0
    //   626: aload_0
    //   627: getfield 104	a/j/b/a/c/e/a$ab:Ckr	I
    //   630: bipush 8
    //   632: ior
    //   633: putfield 104	a/j/b/a/c/e/a$ab:Ckr	I
    //   636: iload_3
    //   637: istore 4
    //   639: iload_3
    //   640: istore 5
    //   642: iload_3
    //   643: istore 6
    //   645: aload_0
    //   646: aload_1
    //   647: invokevirtual 107	a/j/b/a/c/g/e:sl	()I
    //   650: putfield 188	a/j/b/a/c/e/a$ab:Cnl	I
    //   653: goto -612 -> 41
    //   656: iload_3
    //   657: istore 4
    //   659: iload_3
    //   660: istore 5
    //   662: iload_3
    //   663: istore 6
    //   665: aload_0
    //   666: getfield 104	a/j/b/a/c/e/a$ab:Ckr	I
    //   669: bipush 16
    //   671: iand
    //   672: bipush 16
    //   674: if_icmpne +574 -> 1248
    //   677: iload_3
    //   678: istore 4
    //   680: iload_3
    //   681: istore 5
    //   683: iload_3
    //   684: istore 6
    //   686: aload_0
    //   687: getfield 190	a/j/b/a/c/e/a$ab:Cnm	La/j/b/a/c/e/a$aa;
    //   690: invokevirtual 175	a/j/b/a/c/e/a$aa:ejJ	()La/j/b/a/c/e/a$aa$c;
    //   693: astore 9
    //   695: iload_3
    //   696: istore 4
    //   698: iload_3
    //   699: istore 5
    //   701: iload_3
    //   702: istore 6
    //   704: aload_0
    //   705: aload_1
    //   706: getstatic 176	a/j/b/a/c/e/a$aa:Ckq	La/j/b/a/c/g/s;
    //   709: aload_2
    //   710: invokevirtual 161	a/j/b/a/c/g/e:a	(La/j/b/a/c/g/s;La/j/b/a/c/g/g;)La/j/b/a/c/g/q;
    //   713: checkcast 171	a/j/b/a/c/e/a$aa
    //   716: putfield 190	a/j/b/a/c/e/a$ab:Cnm	La/j/b/a/c/e/a$aa;
    //   719: aload 9
    //   721: ifnull +40 -> 761
    //   724: iload_3
    //   725: istore 4
    //   727: iload_3
    //   728: istore 5
    //   730: iload_3
    //   731: istore 6
    //   733: aload 9
    //   735: aload_0
    //   736: getfield 190	a/j/b/a/c/e/a$ab:Cnm	La/j/b/a/c/e/a$aa;
    //   739: invokevirtual 182	a/j/b/a/c/e/a$aa$c:j	(La/j/b/a/c/e/a$aa;)La/j/b/a/c/e/a$aa$c;
    //   742: pop
    //   743: iload_3
    //   744: istore 4
    //   746: iload_3
    //   747: istore 5
    //   749: iload_3
    //   750: istore 6
    //   752: aload_0
    //   753: aload 9
    //   755: invokevirtual 186	a/j/b/a/c/e/a$aa$c:ejS	()La/j/b/a/c/e/a$aa;
    //   758: putfield 190	a/j/b/a/c/e/a$ab:Cnm	La/j/b/a/c/e/a$aa;
    //   761: iload_3
    //   762: istore 4
    //   764: iload_3
    //   765: istore 5
    //   767: iload_3
    //   768: istore 6
    //   770: aload_0
    //   771: aload_0
    //   772: getfield 104	a/j/b/a/c/e/a$ab:Ckr	I
    //   775: bipush 16
    //   777: ior
    //   778: putfield 104	a/j/b/a/c/e/a$ab:Ckr	I
    //   781: goto -740 -> 41
    //   784: iload_3
    //   785: istore 4
    //   787: iload_3
    //   788: istore 5
    //   790: iload_3
    //   791: istore 6
    //   793: aload_0
    //   794: aload_0
    //   795: getfield 104	a/j/b/a/c/e/a$ab:Ckr	I
    //   798: bipush 32
    //   800: ior
    //   801: putfield 104	a/j/b/a/c/e/a$ab:Ckr	I
    //   804: iload_3
    //   805: istore 4
    //   807: iload_3
    //   808: istore 5
    //   810: iload_3
    //   811: istore 6
    //   813: aload_0
    //   814: aload_1
    //   815: invokevirtual 107	a/j/b/a/c/g/e:sl	()I
    //   818: putfield 192	a/j/b/a/c/e/a$ab:Cnn	I
    //   821: goto -780 -> 41
    //   824: iload_3
    //   825: istore 7
    //   827: iload_3
    //   828: sipush 128
    //   831: iand
    //   832: sipush 128
    //   835: if_icmpeq +30 -> 865
    //   838: iload_3
    //   839: istore 4
    //   841: iload_3
    //   842: istore 5
    //   844: iload_3
    //   845: istore 6
    //   847: aload_0
    //   848: new 154	java/util/ArrayList
    //   851: dup
    //   852: invokespecial 155	java/util/ArrayList:<init>	()V
    //   855: putfield 123	a/j/b/a/c/e/a$ab:Cno	Ljava/util/List;
    //   858: iload_3
    //   859: sipush 128
    //   862: ior
    //   863: istore 7
    //   865: iload 7
    //   867: istore 4
    //   869: iload 7
    //   871: istore 5
    //   873: iload 7
    //   875: istore 6
    //   877: aload_0
    //   878: getfield 123	a/j/b/a/c/e/a$ab:Cno	Ljava/util/List;
    //   881: aload_1
    //   882: getstatic 195	a/j/b/a/c/e/a$a:Ckq	La/j/b/a/c/g/s;
    //   885: aload_2
    //   886: invokevirtual 161	a/j/b/a/c/g/e:a	(La/j/b/a/c/g/s;La/j/b/a/c/g/g;)La/j/b/a/c/g/q;
    //   889: invokeinterface 167 2 0
    //   894: pop
    //   895: iload 7
    //   897: istore_3
    //   898: goto -857 -> 41
    //   901: iload_3
    //   902: istore 7
    //   904: iload_3
    //   905: sipush 256
    //   908: iand
    //   909: sipush 256
    //   912: if_icmpeq +30 -> 942
    //   915: iload_3
    //   916: istore 4
    //   918: iload_3
    //   919: istore 5
    //   921: iload_3
    //   922: istore 6
    //   924: aload_0
    //   925: new 154	java/util/ArrayList
    //   928: dup
    //   929: invokespecial 155	java/util/ArrayList:<init>	()V
    //   932: putfield 125	a/j/b/a/c/e/a$ab:Clr	Ljava/util/List;
    //   935: iload_3
    //   936: sipush 256
    //   939: ior
    //   940: istore 7
    //   942: iload 7
    //   944: istore 4
    //   946: iload 7
    //   948: istore 5
    //   950: iload 7
    //   952: istore 6
    //   954: aload_0
    //   955: getfield 125	a/j/b/a/c/e/a$ab:Clr	Ljava/util/List;
    //   958: aload_1
    //   959: invokevirtual 107	a/j/b/a/c/g/e:sl	()I
    //   962: invokestatic 201	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   965: invokeinterface 167 2 0
    //   970: pop
    //   971: iload 7
    //   973: istore_3
    //   974: goto -933 -> 41
    //   977: iload_3
    //   978: istore 4
    //   980: iload_3
    //   981: istore 5
    //   983: iload_3
    //   984: istore 6
    //   986: aload_1
    //   987: aload_1
    //   988: invokevirtual 107	a/j/b/a/c/g/e:sl	()I
    //   991: invokevirtual 205	a/j/b/a/c/g/e:eP	(I)I
    //   994: istore 7
    //   996: iload_3
    //   997: sipush 256
    //   1000: iand
    //   1001: sipush 256
    //   1004: if_icmpeq +241 -> 1245
    //   1007: iload_3
    //   1008: istore 4
    //   1010: iload_3
    //   1011: istore 5
    //   1013: iload_3
    //   1014: istore 6
    //   1016: aload_1
    //   1017: invokevirtual 208	a/j/b/a/c/g/e:so	()I
    //   1020: ifle +225 -> 1245
    //   1023: iload_3
    //   1024: istore 4
    //   1026: iload_3
    //   1027: istore 5
    //   1029: iload_3
    //   1030: istore 6
    //   1032: aload_0
    //   1033: new 154	java/util/ArrayList
    //   1036: dup
    //   1037: invokespecial 155	java/util/ArrayList:<init>	()V
    //   1040: putfield 125	a/j/b/a/c/e/a$ab:Clr	Ljava/util/List;
    //   1043: iload_3
    //   1044: sipush 256
    //   1047: ior
    //   1048: istore_3
    //   1049: aload_1
    //   1050: invokevirtual 208	a/j/b/a/c/g/e:so	()I
    //   1053: ifle +23 -> 1076
    //   1056: aload_0
    //   1057: getfield 125	a/j/b/a/c/e/a$ab:Clr	Ljava/util/List;
    //   1060: aload_1
    //   1061: invokevirtual 107	a/j/b/a/c/g/e:sl	()I
    //   1064: invokestatic 201	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1067: invokeinterface 167 2 0
    //   1072: pop
    //   1073: goto -24 -> 1049
    //   1076: aload_1
    //   1077: iload 7
    //   1079: invokevirtual 211	a/j/b/a/c/g/e:eQ	(I)V
    //   1082: goto -1041 -> 41
    //   1085: iload_3
    //   1086: iconst_4
    //   1087: iand
    //   1088: iconst_4
    //   1089: if_icmpne +14 -> 1103
    //   1092: aload_0
    //   1093: aload_0
    //   1094: getfield 115	a/j/b/a/c/e/a$ab:Cld	Ljava/util/List;
    //   1097: invokestatic 121	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1100: putfield 115	a/j/b/a/c/e/a$ab:Cld	Ljava/util/List;
    //   1103: iload_3
    //   1104: sipush 128
    //   1107: iand
    //   1108: sipush 128
    //   1111: if_icmpne +14 -> 1125
    //   1114: aload_0
    //   1115: aload_0
    //   1116: getfield 123	a/j/b/a/c/e/a$ab:Cno	Ljava/util/List;
    //   1119: invokestatic 121	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1122: putfield 123	a/j/b/a/c/e/a$ab:Cno	Ljava/util/List;
    //   1125: iload_3
    //   1126: sipush 256
    //   1129: iand
    //   1130: sipush 256
    //   1133: if_icmpne +14 -> 1147
    //   1136: aload_0
    //   1137: aload_0
    //   1138: getfield 125	a/j/b/a/c/e/a$ab:Clr	Ljava/util/List;
    //   1141: invokestatic 121	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1144: putfield 125	a/j/b/a/c/e/a$ab:Clr	Ljava/util/List;
    //   1147: aload 11
    //   1149: invokevirtual 128	a/j/b/a/c/g/f:flush	()V
    //   1152: aload_0
    //   1153: aload 10
    //   1155: invokevirtual 134	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   1158: putfield 76	a/j/b/a/c/e/a$ab:Ckp	La/j/b/a/c/g/d;
    //   1161: aload_0
    //   1162: getfield 138	a/j/b/a/c/g/i$c:Crw	La/j/b/a/c/g/h;
    //   1165: invokevirtual 143	a/j/b/a/c/g/h:emF	()V
    //   1168: ldc 82
    //   1170: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1173: return
    //   1174: astore_1
    //   1175: aload_0
    //   1176: aload 10
    //   1178: invokevirtual 134	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   1181: putfield 76	a/j/b/a/c/e/a$ab:Ckp	La/j/b/a/c/g/d;
    //   1184: goto -23 -> 1161
    //   1187: astore_1
    //   1188: aload_0
    //   1189: aload 10
    //   1191: invokevirtual 134	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   1194: putfield 76	a/j/b/a/c/e/a$ab:Ckp	La/j/b/a/c/g/d;
    //   1197: ldc 82
    //   1199: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1202: aload_1
    //   1203: athrow
    //   1204: astore_2
    //   1205: aload_0
    //   1206: aload 10
    //   1208: invokevirtual 134	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   1211: putfield 76	a/j/b/a/c/e/a$ab:Ckp	La/j/b/a/c/g/d;
    //   1214: goto -888 -> 326
    //   1217: astore_1
    //   1218: aload_0
    //   1219: aload 10
    //   1221: invokevirtual 134	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   1224: putfield 76	a/j/b/a/c/e/a$ab:Ckp	La/j/b/a/c/g/d;
    //   1227: ldc 82
    //   1229: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1232: aload_1
    //   1233: athrow
    //   1234: astore_1
    //   1235: goto -985 -> 250
    //   1238: astore_1
    //   1239: iload_3
    //   1240: istore 4
    //   1242: goto -858 -> 384
    //   1245: goto -196 -> 1049
    //   1248: aconst_null
    //   1249: astore 9
    //   1251: goto -556 -> 695
    //   1254: aconst_null
    //   1255: astore 9
    //   1257: goto -729 -> 528
    //   1260: goto -178 -> 1082
    //   1263: goto -1103 -> 160
    //   1266: iconst_1
    //   1267: istore 8
    //   1269: goto -1228 -> 41
    //   1272: astore_1
    //   1273: iload 6
    //   1275: istore_3
    //   1276: goto -1026 -> 250
    //   1279: astore_1
    //   1280: iload_3
    //   1281: istore 4
    //   1283: goto -1055 -> 228
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1286	0	this	ab
    //   0	1286	1	parame	a.j.b.a.c.g.e
    //   0	1286	2	paramg	g
    //   24	1257	3	i	int
    //   47	1235	4	j	int
    //   50	978	5	k	int
    //   53	1221	6	m	int
    //   59	1019	7	n	int
    //   39	1229	8	i1	int
    //   526	730	9	localc	a.aa.c
    //   28	1192	10	localb	a.j.b.a.c.g.d.b
    //   36	1112	11	localf	f
    // Exception table:
    //   from	to	target	type
    //   55	61	227	a/j/b/a/c/g/k
    //   169	182	227	a/j/b/a/c/g/k
    //   197	207	227	a/j/b/a/c/g/k
    //   216	224	227	a/j/b/a/c/g/k
    //   349	359	227	a/j/b/a/c/g/k
    //   368	376	227	a/j/b/a/c/g/k
    //   439	450	227	a/j/b/a/c/g/k
    //   467	485	227	a/j/b/a/c/g/k
    //   500	510	227	a/j/b/a/c/g/k
    //   519	528	227	a/j/b/a/c/g/k
    //   537	552	227	a/j/b/a/c/g/k
    //   566	576	227	a/j/b/a/c/g/k
    //   585	594	227	a/j/b/a/c/g/k
    //   603	613	227	a/j/b/a/c/g/k
    //   625	636	227	a/j/b/a/c/g/k
    //   645	653	227	a/j/b/a/c/g/k
    //   665	677	227	a/j/b/a/c/g/k
    //   686	695	227	a/j/b/a/c/g/k
    //   704	719	227	a/j/b/a/c/g/k
    //   733	743	227	a/j/b/a/c/g/k
    //   752	761	227	a/j/b/a/c/g/k
    //   770	781	227	a/j/b/a/c/g/k
    //   793	804	227	a/j/b/a/c/g/k
    //   813	821	227	a/j/b/a/c/g/k
    //   847	858	227	a/j/b/a/c/g/k
    //   877	895	227	a/j/b/a/c/g/k
    //   924	935	227	a/j/b/a/c/g/k
    //   954	971	227	a/j/b/a/c/g/k
    //   986	996	227	a/j/b/a/c/g/k
    //   1016	1023	227	a/j/b/a/c/g/k
    //   1032	1043	227	a/j/b/a/c/g/k
    //   231	236	249	finally
    //   239	244	249	finally
    //   247	249	249	finally
    //   387	399	249	finally
    //   402	407	249	finally
    //   410	415	249	finally
    //   418	420	249	finally
    //   55	61	379	java/io/IOException
    //   169	182	379	java/io/IOException
    //   197	207	379	java/io/IOException
    //   216	224	379	java/io/IOException
    //   349	359	379	java/io/IOException
    //   368	376	379	java/io/IOException
    //   439	450	379	java/io/IOException
    //   467	485	379	java/io/IOException
    //   500	510	379	java/io/IOException
    //   519	528	379	java/io/IOException
    //   537	552	379	java/io/IOException
    //   566	576	379	java/io/IOException
    //   585	594	379	java/io/IOException
    //   603	613	379	java/io/IOException
    //   625	636	379	java/io/IOException
    //   645	653	379	java/io/IOException
    //   665	677	379	java/io/IOException
    //   686	695	379	java/io/IOException
    //   704	719	379	java/io/IOException
    //   733	743	379	java/io/IOException
    //   752	761	379	java/io/IOException
    //   770	781	379	java/io/IOException
    //   793	804	379	java/io/IOException
    //   813	821	379	java/io/IOException
    //   847	858	379	java/io/IOException
    //   877	895	379	java/io/IOException
    //   924	935	379	java/io/IOException
    //   954	971	379	java/io/IOException
    //   986	996	379	java/io/IOException
    //   1016	1023	379	java/io/IOException
    //   1032	1043	379	java/io/IOException
    //   1147	1152	1174	java/io/IOException
    //   1147	1152	1187	finally
    //   312	317	1204	java/io/IOException
    //   312	317	1217	finally
    //   1049	1073	1234	finally
    //   1076	1082	1234	finally
    //   1049	1073	1238	java/io/IOException
    //   1076	1082	1238	java/io/IOException
    //   55	61	1272	finally
    //   169	182	1272	finally
    //   197	207	1272	finally
    //   216	224	1272	finally
    //   349	359	1272	finally
    //   368	376	1272	finally
    //   439	450	1272	finally
    //   467	485	1272	finally
    //   500	510	1272	finally
    //   519	528	1272	finally
    //   537	552	1272	finally
    //   566	576	1272	finally
    //   585	594	1272	finally
    //   603	613	1272	finally
    //   625	636	1272	finally
    //   645	653	1272	finally
    //   665	677	1272	finally
    //   686	695	1272	finally
    //   704	719	1272	finally
    //   733	743	1272	finally
    //   752	761	1272	finally
    //   770	781	1272	finally
    //   793	804	1272	finally
    //   813	821	1272	finally
    //   847	858	1272	finally
    //   877	895	1272	finally
    //   924	935	1272	finally
    //   954	971	1272	finally
    //   986	996	1272	finally
    //   1016	1023	1272	finally
    //   1032	1043	1272	finally
    //   1049	1073	1279	a/j/b/a/c/g/k
    //   1076	1082	1279	a/j/b/a/c/g/k
  }
  
  private a$ab(i.b<ab, ?> paramb)
  {
    super(paramb);
    this.Ckp = paramb.Ckp;
  }
  
  public static ab d(InputStream paramInputStream, g paramg)
  {
    AppMethodBeat.i(120913);
    paramInputStream = (ab)Ckq.i(paramInputStream, paramg);
    AppMethodBeat.o(120913);
    return paramInputStream;
  }
  
  private void egZ()
  {
    AppMethodBeat.i(120909);
    this.CkK = 6;
    this.ClT = 0;
    this.Cld = Collections.emptyList();
    this.Cnk = a.aa.ejw();
    this.Cnl = 0;
    this.Cnm = a.aa.ejw();
    this.Cnn = 0;
    this.Cno = Collections.emptyList();
    this.Clr = Collections.emptyList();
    AppMethodBeat.o(120909);
  }
  
  public static ab ejU()
  {
    return Cnj;
  }
  
  public final void a(f paramf)
  {
    int k = 0;
    AppMethodBeat.i(120911);
    sy();
    i.c.a locala = emM();
    if ((this.Ckr & 0x1) == 1) {
      paramf.bj(1, this.CkK);
    }
    if ((this.Ckr & 0x2) == 2) {
      paramf.bj(2, this.ClT);
    }
    int i = 0;
    while (i < this.Cld.size())
    {
      paramf.a(3, (q)this.Cld.get(i));
      i += 1;
    }
    if ((this.Ckr & 0x4) == 4) {
      paramf.a(4, this.Cnk);
    }
    if ((this.Ckr & 0x8) == 8) {
      paramf.bj(5, this.Cnl);
    }
    if ((this.Ckr & 0x10) == 16) {
      paramf.a(6, this.Cnm);
    }
    if ((this.Ckr & 0x20) == 32) {
      paramf.bj(7, this.Cnn);
    }
    i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.Cno.size()) {
        break;
      }
      paramf.a(8, (q)this.Cno.get(i));
      i += 1;
    }
    while (j < this.Clr.size())
    {
      paramf.bj(31, ((Integer)this.Clr.get(j)).intValue());
      j += 1;
    }
    locala.b(200, paramf);
    paramf.d(this.Ckp);
    AppMethodBeat.o(120911);
  }
  
  public final s<ab> egX()
  {
    return Ckq;
  }
  
  public final boolean ehx()
  {
    return (this.Ckr & 0x1) == 1;
  }
  
  public final boolean eiv()
  {
    return (this.Ckr & 0x2) == 2;
  }
  
  public final boolean ejV()
  {
    return (this.Ckr & 0x4) == 4;
  }
  
  public final boolean ejW()
  {
    return (this.Ckr & 0x8) == 8;
  }
  
  public final boolean ejX()
  {
    return (this.Ckr & 0x10) == 16;
  }
  
  public final boolean ejY()
  {
    return (this.Ckr & 0x20) == 32;
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(120910);
    int i = this.Cku;
    if (i == 1)
    {
      AppMethodBeat.o(120910);
      return true;
    }
    if (i == 0)
    {
      AppMethodBeat.o(120910);
      return false;
    }
    if (!eiv())
    {
      this.Cku = 0;
      AppMethodBeat.o(120910);
      return false;
    }
    i = 0;
    while (i < this.Cld.size())
    {
      if (!((a.ae)this.Cld.get(i)).isInitialized())
      {
        this.Cku = 0;
        AppMethodBeat.o(120910);
        return false;
      }
      i += 1;
    }
    if ((ejV()) && (!this.Cnk.isInitialized()))
    {
      this.Cku = 0;
      AppMethodBeat.o(120910);
      return false;
    }
    if ((ejX()) && (!this.Cnm.isInitialized()))
    {
      this.Cku = 0;
      AppMethodBeat.o(120910);
      return false;
    }
    i = 0;
    while (i < this.Cno.size())
    {
      if (!((a.a)this.Cno.get(i)).isInitialized())
      {
        this.Cku = 0;
        AppMethodBeat.o(120910);
        return false;
      }
      i += 1;
    }
    if (!this.Crw.isInitialized())
    {
      this.Cku = 0;
      AppMethodBeat.o(120910);
      return false;
    }
    this.Cku = 1;
    AppMethodBeat.o(120910);
    return true;
  }
  
  public final int sy()
  {
    AppMethodBeat.i(120912);
    int i = this.Ckv;
    if (i != -1)
    {
      AppMethodBeat.o(120912);
      return i;
    }
    if ((this.Ckr & 0x1) == 1) {}
    for (int j = f.bl(1, this.CkK) + 0;; j = 0)
    {
      i = j;
      if ((this.Ckr & 0x2) == 2) {
        i = j + f.bl(2, this.ClT);
      }
      j = 0;
      while (j < this.Cld.size())
      {
        i += f.c(3, (q)this.Cld.get(j));
        j += 1;
      }
      j = i;
      if ((this.Ckr & 0x4) == 4) {
        j = i + f.c(4, this.Cnk);
      }
      i = j;
      if ((this.Ckr & 0x8) == 8) {
        i = j + f.bl(5, this.Cnl);
      }
      j = i;
      if ((this.Ckr & 0x10) == 16) {
        j = i + f.c(6, this.Cnm);
      }
      i = j;
      if ((this.Ckr & 0x20) == 32) {
        i = j + f.bl(7, this.Cnn);
      }
      j = 0;
      while (j < this.Cno.size())
      {
        i += f.c(8, (q)this.Cno.get(j));
        j += 1;
      }
      int k = 0;
      int m;
      for (j = 0; k < this.Clr.size(); j = m + j)
      {
        m = f.eU(((Integer)this.Clr.get(k)).intValue());
        k += 1;
      }
      i = i + j + this.Clr.size() * 2 + this.Crw.sy() + this.Ckp.size();
      this.Ckv = i;
      AppMethodBeat.o(120912);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.j.b.a.c.e.a.ab
 * JD-Core Version:    0.7.0.1
 */