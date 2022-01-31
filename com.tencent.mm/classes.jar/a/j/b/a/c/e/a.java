package a.j.b.a.c.e;

import a.j.b.a.c.g.b;
import a.j.b.a.c.g.d;
import a.j.b.a.c.g.f;
import a.j.b.a.c.g.g;
import a.j.b.a.c.g.h;
import a.j.b.a.c.g.i;
import a.j.b.a.c.g.i.a;
import a.j.b.a.c.g.i.b;
import a.j.b.a.c.g.i.c;
import a.j.b.a.c.g.i.c.a;
import a.j.b.a.c.g.i.d;
import a.j.b.a.c.g.j.b;
import a.j.b.a.c.g.n;
import a.j.b.a.c.g.o;
import a.j.b.a.c.g.q;
import a.j.b.a.c.g.r;
import a.j.b.a.c.g.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class a
{
  public static final class ae
    extends i.c<ae>
    implements a.af
  {
    public static s<ae> Ckq;
    private static final ae Cnp;
    private final d Ckp;
    private int Ckr;
    public int Cks;
    private byte Cku = -1;
    private int Ckv = -1;
    public int ClT;
    public boolean Cnq;
    public a.ae.b Cnr;
    public List<a.aa> Cns;
    public List<Integer> Cnt;
    private int Cnu = -1;
    
    static
    {
      AppMethodBeat.i(120949);
      Ckq = new a.ae.1();
      ae localae = new ae();
      Cnp = localae;
      localae.egZ();
      AppMethodBeat.o(120949);
    }
    
    private ae()
    {
      this.Ckp = d.Cre;
    }
    
    /* Error */
    private ae(a.j.b.a.c.g.e parame, g paramg)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 67	a/j/b/a/c/g/i$c:<init>	()V
      //   4: ldc 86
      //   6: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   9: aload_0
      //   10: iconst_m1
      //   11: putfield 69	a/j/b/a/c/e/a$ae:Cnu	I
      //   14: aload_0
      //   15: iconst_m1
      //   16: putfield 71	a/j/b/a/c/e/a$ae:Cku	B
      //   19: aload_0
      //   20: iconst_m1
      //   21: putfield 73	a/j/b/a/c/e/a$ae:Ckv	I
      //   24: aload_0
      //   25: invokespecial 62	a/j/b/a/c/e/a$ae:egZ	()V
      //   28: iconst_0
      //   29: istore_3
      //   30: invokestatic 90	a/j/b/a/c/g/d:emp	()La/j/b/a/c/g/d$b;
      //   33: astore 10
      //   35: aload 10
      //   37: iconst_1
      //   38: invokestatic 96	a/j/b/a/c/g/f:e	(Ljava/io/OutputStream;I)La/j/b/a/c/g/f;
      //   41: astore 11
      //   43: iconst_0
      //   44: istore 5
      //   46: iload 5
      //   48: ifne +773 -> 821
      //   51: iload_3
      //   52: istore 6
      //   54: iload_3
      //   55: istore 7
      //   57: iload_3
      //   58: istore 8
      //   60: aload_1
      //   61: invokevirtual 102	a/j/b/a/c/g/e:sk	()I
      //   64: istore 4
      //   66: iload 4
      //   68: lookupswitch	default:+894->962, 0:+897->965, 8:+104->172, 16:+243->311, 24:+327->395, 32:+366->434, 42:+475->543, 48:+539->607, 50:+602->670
      //   145: istore 6
      //   147: iload_3
      //   148: istore 7
      //   150: iload_3
      //   151: istore 8
      //   153: aload_0
      //   154: aload_1
      //   155: aload 11
      //   157: aload_2
      //   158: iload 4
      //   160: invokevirtual 106	a/j/b/a/c/e/a$ae:a	(La/j/b/a/c/g/e;La/j/b/a/c/g/f;La/j/b/a/c/g/g;I)Z
      //   163: ifne -117 -> 46
      //   166: iconst_1
      //   167: istore 5
      //   169: goto -123 -> 46
      //   172: iload_3
      //   173: istore 6
      //   175: iload_3
      //   176: istore 7
      //   178: iload_3
      //   179: istore 8
      //   181: aload_0
      //   182: aload_0
      //   183: getfield 108	a/j/b/a/c/e/a$ae:Ckr	I
      //   186: iconst_1
      //   187: ior
      //   188: putfield 108	a/j/b/a/c/e/a$ae:Ckr	I
      //   191: iload_3
      //   192: istore 6
      //   194: iload_3
      //   195: istore 7
      //   197: iload_3
      //   198: istore 8
      //   200: aload_0
      //   201: aload_1
      //   202: invokevirtual 111	a/j/b/a/c/g/e:sl	()I
      //   205: putfield 113	a/j/b/a/c/e/a$ae:Cks	I
      //   208: goto -162 -> 46
      //   211: astore_1
      //   212: iload 6
      //   214: istore 7
      //   216: iload 7
      //   218: istore 4
      //   220: aload_1
      //   221: aload_0
      //   222: putfield 117	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
      //   225: iload 7
      //   227: istore 4
      //   229: ldc 86
      //   231: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   234: iload 7
      //   236: istore 4
      //   238: aload_1
      //   239: athrow
      //   240: astore_1
      //   241: iload 4
      //   243: bipush 16
      //   245: iand
      //   246: bipush 16
      //   248: if_icmpne +14 -> 262
      //   251: aload_0
      //   252: aload_0
      //   253: getfield 119	a/j/b/a/c/e/a$ae:Cns	Ljava/util/List;
      //   256: invokestatic 125	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   259: putfield 119	a/j/b/a/c/e/a$ae:Cns	Ljava/util/List;
      //   262: iload 4
      //   264: bipush 32
      //   266: iand
      //   267: bipush 32
      //   269: if_icmpne +14 -> 283
      //   272: aload_0
      //   273: aload_0
      //   274: getfield 127	a/j/b/a/c/e/a$ae:Cnt	Ljava/util/List;
      //   277: invokestatic 125	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   280: putfield 127	a/j/b/a/c/e/a$ae:Cnt	Ljava/util/List;
      //   283: aload 11
      //   285: invokevirtual 130	a/j/b/a/c/g/f:flush	()V
      //   288: aload_0
      //   289: aload 10
      //   291: invokevirtual 136	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
      //   294: putfield 80	a/j/b/a/c/e/a$ae:Ckp	La/j/b/a/c/g/d;
      //   297: aload_0
      //   298: getfield 140	a/j/b/a/c/g/i$c:Crw	La/j/b/a/c/g/h;
      //   301: invokevirtual 145	a/j/b/a/c/g/h:emF	()V
      //   304: ldc 86
      //   306: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   309: aload_1
      //   310: athrow
      //   311: iload_3
      //   312: istore 6
      //   314: iload_3
      //   315: istore 7
      //   317: iload_3
      //   318: istore 8
      //   320: aload_0
      //   321: aload_0
      //   322: getfield 108	a/j/b/a/c/e/a$ae:Ckr	I
      //   325: iconst_2
      //   326: ior
      //   327: putfield 108	a/j/b/a/c/e/a$ae:Ckr	I
      //   330: iload_3
      //   331: istore 6
      //   333: iload_3
      //   334: istore 7
      //   336: iload_3
      //   337: istore 8
      //   339: aload_0
      //   340: aload_1
      //   341: invokevirtual 111	a/j/b/a/c/g/e:sl	()I
      //   344: putfield 147	a/j/b/a/c/e/a$ae:ClT	I
      //   347: goto -301 -> 46
      //   350: astore_1
      //   351: iload 7
      //   353: istore 6
      //   355: iload 6
      //   357: istore 4
      //   359: new 83	a/j/b/a/c/g/k
      //   362: dup
      //   363: aload_1
      //   364: invokevirtual 151	java/io/IOException:getMessage	()Ljava/lang/String;
      //   367: invokespecial 154	a/j/b/a/c/g/k:<init>	(Ljava/lang/String;)V
      //   370: astore_1
      //   371: iload 6
      //   373: istore 4
      //   375: aload_1
      //   376: aload_0
      //   377: putfield 117	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
      //   380: iload 6
      //   382: istore 4
      //   384: ldc 86
      //   386: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   389: iload 6
      //   391: istore 4
      //   393: aload_1
      //   394: athrow
      //   395: iload_3
      //   396: istore 6
      //   398: iload_3
      //   399: istore 7
      //   401: iload_3
      //   402: istore 8
      //   404: aload_0
      //   405: aload_0
      //   406: getfield 108	a/j/b/a/c/e/a$ae:Ckr	I
      //   409: iconst_4
      //   410: ior
      //   411: putfield 108	a/j/b/a/c/e/a$ae:Ckr	I
      //   414: iload_3
      //   415: istore 6
      //   417: iload_3
      //   418: istore 7
      //   420: iload_3
      //   421: istore 8
      //   423: aload_0
      //   424: aload_1
      //   425: invokevirtual 158	a/j/b/a/c/g/e:emu	()Z
      //   428: putfield 160	a/j/b/a/c/e/a$ae:Cnq	Z
      //   431: goto -385 -> 46
      //   434: iload_3
      //   435: istore 6
      //   437: iload_3
      //   438: istore 7
      //   440: iload_3
      //   441: istore 8
      //   443: aload_1
      //   444: invokevirtual 111	a/j/b/a/c/g/e:sl	()I
      //   447: istore 9
      //   449: iload_3
      //   450: istore 6
      //   452: iload_3
      //   453: istore 7
      //   455: iload_3
      //   456: istore 8
      //   458: iload 9
      //   460: invokestatic 164	a/j/b/a/c/e/a$ae$b:Vb	(I)La/j/b/a/c/e/a$ae$b;
      //   463: astore 12
      //   465: aload 12
      //   467: ifnonnull +38 -> 505
      //   470: iload_3
      //   471: istore 6
      //   473: iload_3
      //   474: istore 7
      //   476: iload_3
      //   477: istore 8
      //   479: aload 11
      //   481: iload 4
      //   483: invokevirtual 167	a/j/b/a/c/g/f:eX	(I)V
      //   486: iload_3
      //   487: istore 6
      //   489: iload_3
      //   490: istore 7
      //   492: iload_3
      //   493: istore 8
      //   495: aload 11
      //   497: iload 9
      //   499: invokevirtual 167	a/j/b/a/c/g/f:eX	(I)V
      //   502: goto -456 -> 46
      //   505: iload_3
      //   506: istore 6
      //   508: iload_3
      //   509: istore 7
      //   511: iload_3
      //   512: istore 8
      //   514: aload_0
      //   515: aload_0
      //   516: getfield 108	a/j/b/a/c/e/a$ae:Ckr	I
      //   519: bipush 8
      //   521: ior
      //   522: putfield 108	a/j/b/a/c/e/a$ae:Ckr	I
      //   525: iload_3
      //   526: istore 6
      //   528: iload_3
      //   529: istore 7
      //   531: iload_3
      //   532: istore 8
      //   534: aload_0
      //   535: aload 12
      //   537: putfield 169	a/j/b/a/c/e/a$ae:Cnr	La/j/b/a/c/e/a$ae$b;
      //   540: goto -494 -> 46
      //   543: iload_3
      //   544: bipush 16
      //   546: iand
      //   547: bipush 16
      //   549: if_icmpeq +410 -> 959
      //   552: iload_3
      //   553: istore 6
      //   555: iload_3
      //   556: istore 7
      //   558: iload_3
      //   559: istore 8
      //   561: aload_0
      //   562: new 171	java/util/ArrayList
      //   565: dup
      //   566: invokespecial 172	java/util/ArrayList:<init>	()V
      //   569: putfield 119	a/j/b/a/c/e/a$ae:Cns	Ljava/util/List;
      //   572: iload_3
      //   573: bipush 16
      //   575: ior
      //   576: istore_3
      //   577: iload_3
      //   578: istore 4
      //   580: iload_3
      //   581: istore 6
      //   583: iload_3
      //   584: istore 7
      //   586: aload_0
      //   587: getfield 119	a/j/b/a/c/e/a$ae:Cns	Ljava/util/List;
      //   590: aload_1
      //   591: getstatic 175	a/j/b/a/c/e/a$aa:Ckq	La/j/b/a/c/g/s;
      //   594: aload_2
      //   595: invokevirtual 178	a/j/b/a/c/g/e:a	(La/j/b/a/c/g/s;La/j/b/a/c/g/g;)La/j/b/a/c/g/q;
      //   598: invokeinterface 184 2 0
      //   603: pop
      //   604: goto -558 -> 46
      //   607: iload_3
      //   608: bipush 32
      //   610: iand
      //   611: bipush 32
      //   613: if_icmpeq +343 -> 956
      //   616: iload_3
      //   617: istore 6
      //   619: iload_3
      //   620: istore 7
      //   622: iload_3
      //   623: istore 8
      //   625: aload_0
      //   626: new 171	java/util/ArrayList
      //   629: dup
      //   630: invokespecial 172	java/util/ArrayList:<init>	()V
      //   633: putfield 127	a/j/b/a/c/e/a$ae:Cnt	Ljava/util/List;
      //   636: iload_3
      //   637: bipush 32
      //   639: ior
      //   640: istore_3
      //   641: iload_3
      //   642: istore 4
      //   644: iload_3
      //   645: istore 6
      //   647: iload_3
      //   648: istore 7
      //   650: aload_0
      //   651: getfield 127	a/j/b/a/c/e/a$ae:Cnt	Ljava/util/List;
      //   654: aload_1
      //   655: invokevirtual 111	a/j/b/a/c/g/e:sl	()I
      //   658: invokestatic 190	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   661: invokeinterface 184 2 0
      //   666: pop
      //   667: goto -621 -> 46
      //   670: iload_3
      //   671: istore 6
      //   673: iload_3
      //   674: istore 7
      //   676: iload_3
      //   677: istore 8
      //   679: aload_1
      //   680: aload_1
      //   681: invokevirtual 111	a/j/b/a/c/g/e:sl	()I
      //   684: invokevirtual 194	a/j/b/a/c/g/e:eP	(I)I
      //   687: istore 9
      //   689: iload_3
      //   690: istore 4
      //   692: iload_3
      //   693: bipush 32
      //   695: iand
      //   696: bipush 32
      //   698: if_icmpeq +48 -> 746
      //   701: iload_3
      //   702: istore 6
      //   704: iload_3
      //   705: istore 7
      //   707: iload_3
      //   708: istore 4
      //   710: iload_3
      //   711: istore 8
      //   713: aload_1
      //   714: invokevirtual 197	a/j/b/a/c/g/e:so	()I
      //   717: ifle +29 -> 746
      //   720: iload_3
      //   721: istore 6
      //   723: iload_3
      //   724: istore 7
      //   726: iload_3
      //   727: istore 8
      //   729: aload_0
      //   730: new 171	java/util/ArrayList
      //   733: dup
      //   734: invokespecial 172	java/util/ArrayList:<init>	()V
      //   737: putfield 127	a/j/b/a/c/e/a$ae:Cnt	Ljava/util/List;
      //   740: iload_3
      //   741: bipush 32
      //   743: ior
      //   744: istore 4
      //   746: iload 4
      //   748: istore 6
      //   750: iload 4
      //   752: istore 7
      //   754: iload 4
      //   756: istore 8
      //   758: aload_1
      //   759: invokevirtual 197	a/j/b/a/c/g/e:so	()I
      //   762: ifle +35 -> 797
      //   765: iload 4
      //   767: istore 6
      //   769: iload 4
      //   771: istore 7
      //   773: iload 4
      //   775: istore 8
      //   777: aload_0
      //   778: getfield 127	a/j/b/a/c/e/a$ae:Cnt	Ljava/util/List;
      //   781: aload_1
      //   782: invokevirtual 111	a/j/b/a/c/g/e:sl	()I
      //   785: invokestatic 190	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   788: invokeinterface 184 2 0
      //   793: pop
      //   794: goto -48 -> 746
      //   797: iload 4
      //   799: istore 6
      //   801: iload 4
      //   803: istore 7
      //   805: iload 4
      //   807: istore 8
      //   809: aload_1
      //   810: iload 9
      //   812: invokevirtual 200	a/j/b/a/c/g/e:eQ	(I)V
      //   815: iload 4
      //   817: istore_3
      //   818: goto -772 -> 46
      //   821: iload_3
      //   822: bipush 16
      //   824: iand
      //   825: bipush 16
      //   827: if_icmpne +14 -> 841
      //   830: aload_0
      //   831: aload_0
      //   832: getfield 119	a/j/b/a/c/e/a$ae:Cns	Ljava/util/List;
      //   835: invokestatic 125	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   838: putfield 119	a/j/b/a/c/e/a$ae:Cns	Ljava/util/List;
      //   841: iload_3
      //   842: bipush 32
      //   844: iand
      //   845: bipush 32
      //   847: if_icmpne +14 -> 861
      //   850: aload_0
      //   851: aload_0
      //   852: getfield 127	a/j/b/a/c/e/a$ae:Cnt	Ljava/util/List;
      //   855: invokestatic 125	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   858: putfield 127	a/j/b/a/c/e/a$ae:Cnt	Ljava/util/List;
      //   861: aload 11
      //   863: invokevirtual 130	a/j/b/a/c/g/f:flush	()V
      //   866: aload_0
      //   867: aload 10
      //   869: invokevirtual 136	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
      //   872: putfield 80	a/j/b/a/c/e/a$ae:Ckp	La/j/b/a/c/g/d;
      //   875: aload_0
      //   876: getfield 140	a/j/b/a/c/g/i$c:Crw	La/j/b/a/c/g/h;
      //   879: invokevirtual 145	a/j/b/a/c/g/h:emF	()V
      //   882: ldc 86
      //   884: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   887: return
      //   888: astore_1
      //   889: aload_0
      //   890: aload 10
      //   892: invokevirtual 136	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
      //   895: putfield 80	a/j/b/a/c/e/a$ae:Ckp	La/j/b/a/c/g/d;
      //   898: goto -23 -> 875
      //   901: astore_1
      //   902: aload_0
      //   903: aload 10
      //   905: invokevirtual 136	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
      //   908: putfield 80	a/j/b/a/c/e/a$ae:Ckp	La/j/b/a/c/g/d;
      //   911: ldc 86
      //   913: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   916: aload_1
      //   917: athrow
      //   918: astore_2
      //   919: aload_0
      //   920: aload 10
      //   922: invokevirtual 136	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
      //   925: putfield 80	a/j/b/a/c/e/a$ae:Ckp	La/j/b/a/c/g/d;
      //   928: goto -631 -> 297
      //   931: astore_1
      //   932: aload_0
      //   933: aload 10
      //   935: invokevirtual 136	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
      //   938: putfield 80	a/j/b/a/c/e/a$ae:Ckp	La/j/b/a/c/g/d;
      //   941: ldc 86
      //   943: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   946: aload_1
      //   947: athrow
      //   948: astore_1
      //   949: goto -594 -> 355
      //   952: astore_1
      //   953: goto -737 -> 216
      //   956: goto -315 -> 641
      //   959: goto -382 -> 577
      //   962: goto -818 -> 144
      //   965: iconst_1
      //   966: istore 5
      //   968: goto -922 -> 46
      //   971: astore_1
      //   972: iload 8
      //   974: istore 4
      //   976: goto -735 -> 241
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	979	0	this	ae
      //   0	979	1	parame	a.j.b.a.c.g.e
      //   0	979	2	paramg	g
      //   29	816	3	i	int
      //   64	911	4	j	int
      //   44	923	5	k	int
      //   52	748	6	m	int
      //   55	749	7	n	int
      //   58	915	8	i1	int
      //   447	364	9	i2	int
      //   33	901	10	localb	a.j.b.a.c.g.d.b
      //   41	821	11	localf	f
      //   463	73	12	localb1	a.ae.b
      // Exception table:
      //   from	to	target	type
      //   60	66	211	a/j/b/a/c/g/k
      //   153	166	211	a/j/b/a/c/g/k
      //   181	191	211	a/j/b/a/c/g/k
      //   200	208	211	a/j/b/a/c/g/k
      //   320	330	211	a/j/b/a/c/g/k
      //   339	347	211	a/j/b/a/c/g/k
      //   404	414	211	a/j/b/a/c/g/k
      //   423	431	211	a/j/b/a/c/g/k
      //   443	449	211	a/j/b/a/c/g/k
      //   458	465	211	a/j/b/a/c/g/k
      //   479	486	211	a/j/b/a/c/g/k
      //   495	502	211	a/j/b/a/c/g/k
      //   514	525	211	a/j/b/a/c/g/k
      //   534	540	211	a/j/b/a/c/g/k
      //   561	572	211	a/j/b/a/c/g/k
      //   625	636	211	a/j/b/a/c/g/k
      //   679	689	211	a/j/b/a/c/g/k
      //   713	720	211	a/j/b/a/c/g/k
      //   729	740	211	a/j/b/a/c/g/k
      //   758	765	211	a/j/b/a/c/g/k
      //   777	794	211	a/j/b/a/c/g/k
      //   809	815	211	a/j/b/a/c/g/k
      //   220	225	240	finally
      //   229	234	240	finally
      //   238	240	240	finally
      //   359	371	240	finally
      //   375	380	240	finally
      //   384	389	240	finally
      //   393	395	240	finally
      //   586	604	240	finally
      //   650	667	240	finally
      //   60	66	350	java/io/IOException
      //   153	166	350	java/io/IOException
      //   181	191	350	java/io/IOException
      //   200	208	350	java/io/IOException
      //   320	330	350	java/io/IOException
      //   339	347	350	java/io/IOException
      //   404	414	350	java/io/IOException
      //   423	431	350	java/io/IOException
      //   443	449	350	java/io/IOException
      //   458	465	350	java/io/IOException
      //   479	486	350	java/io/IOException
      //   495	502	350	java/io/IOException
      //   514	525	350	java/io/IOException
      //   534	540	350	java/io/IOException
      //   561	572	350	java/io/IOException
      //   625	636	350	java/io/IOException
      //   679	689	350	java/io/IOException
      //   713	720	350	java/io/IOException
      //   729	740	350	java/io/IOException
      //   758	765	350	java/io/IOException
      //   777	794	350	java/io/IOException
      //   809	815	350	java/io/IOException
      //   861	866	888	java/io/IOException
      //   861	866	901	finally
      //   283	288	918	java/io/IOException
      //   283	288	931	finally
      //   586	604	948	java/io/IOException
      //   650	667	948	java/io/IOException
      //   586	604	952	a/j/b/a/c/g/k
      //   650	667	952	a/j/b/a/c/g/k
      //   60	66	971	finally
      //   153	166	971	finally
      //   181	191	971	finally
      //   200	208	971	finally
      //   320	330	971	finally
      //   339	347	971	finally
      //   404	414	971	finally
      //   423	431	971	finally
      //   443	449	971	finally
      //   458	465	971	finally
      //   479	486	971	finally
      //   495	502	971	finally
      //   514	525	971	finally
      //   534	540	971	finally
      //   561	572	971	finally
      //   625	636	971	finally
      //   679	689	971	finally
      //   713	720	971	finally
      //   729	740	971	finally
      //   758	765	971	finally
      //   777	794	971	finally
      //   809	815	971	finally
    }
    
    private ae(i.b<ae, ?> paramb)
    {
      super();
      this.Ckp = paramb.Ckp;
    }
    
    private void egZ()
    {
      AppMethodBeat.i(120943);
      this.Cks = 0;
      this.ClT = 0;
      this.Cnq = false;
      this.Cnr = a.ae.b.Cnx;
      this.Cns = Collections.emptyList();
      this.Cnt = Collections.emptyList();
      AppMethodBeat.o(120943);
    }
    
    public static ae ekd()
    {
      return Cnp;
    }
    
    public final void a(f paramf)
    {
      int j = 0;
      AppMethodBeat.i(120945);
      sy();
      i.c.a locala = emM();
      if ((this.Ckr & 0x1) == 1) {
        paramf.bj(1, this.Cks);
      }
      if ((this.Ckr & 0x2) == 2) {
        paramf.bj(2, this.ClT);
      }
      if ((this.Ckr & 0x4) == 4) {
        paramf.sw(this.Cnq);
      }
      if ((this.Ckr & 0x8) == 8) {
        paramf.iG(4, this.Cnr.value);
      }
      int i = 0;
      while (i < this.Cns.size())
      {
        paramf.a(5, (q)this.Cns.get(i));
        i += 1;
      }
      i = j;
      if (this.Cnt.size() > 0)
      {
        paramf.eX(50);
        paramf.eX(this.Cnu);
        i = j;
      }
      while (i < this.Cnt.size())
      {
        paramf.VG(((Integer)this.Cnt.get(i)).intValue());
        i += 1;
      }
      locala.b(1000, paramf);
      paramf.d(this.Ckp);
      AppMethodBeat.o(120945);
    }
    
    public final s<ae> egX()
    {
      return Ckq;
    }
    
    public final boolean egY()
    {
      return (this.Ckr & 0x1) == 1;
    }
    
    public final boolean eiv()
    {
      return (this.Ckr & 0x2) == 2;
    }
    
    public final boolean eke()
    {
      return (this.Ckr & 0x4) == 4;
    }
    
    public final boolean ekf()
    {
      return (this.Ckr & 0x8) == 8;
    }
    
    public final boolean isInitialized()
    {
      AppMethodBeat.i(120944);
      int i = this.Cku;
      if (i == 1)
      {
        AppMethodBeat.o(120944);
        return true;
      }
      if (i == 0)
      {
        AppMethodBeat.o(120944);
        return false;
      }
      if (!egY())
      {
        this.Cku = 0;
        AppMethodBeat.o(120944);
        return false;
      }
      if (!eiv())
      {
        this.Cku = 0;
        AppMethodBeat.o(120944);
        return false;
      }
      i = 0;
      while (i < this.Cns.size())
      {
        if (!((a.aa)this.Cns.get(i)).isInitialized())
        {
          this.Cku = 0;
          AppMethodBeat.o(120944);
          return false;
        }
        i += 1;
      }
      if (!this.Crw.isInitialized())
      {
        this.Cku = 0;
        AppMethodBeat.o(120944);
        return false;
      }
      this.Cku = 1;
      AppMethodBeat.o(120944);
      return true;
    }
    
    public final int sy()
    {
      AppMethodBeat.i(120946);
      int i = this.Ckv;
      if (i != -1)
      {
        AppMethodBeat.o(120946);
        return i;
      }
      if ((this.Ckr & 0x1) == 1) {}
      for (int j = f.bl(1, this.Cks) + 0;; j = 0)
      {
        i = j;
        if ((this.Ckr & 0x2) == 2) {
          i = j + f.bl(2, this.ClT);
        }
        j = i;
        if ((this.Ckr & 0x4) == 4) {
          j = i + (f.eW(3) + 1);
        }
        i = j;
        if ((this.Ckr & 0x8) == 8) {
          i = j + f.iH(4, this.Cnr.value);
        }
        j = 0;
        while (j < this.Cns.size())
        {
          i += f.c(5, (q)this.Cns.get(j));
          j += 1;
        }
        int k = 0;
        int m;
        for (j = 0; k < this.Cnt.size(); j = m + j)
        {
          m = f.eU(((Integer)this.Cnt.get(k)).intValue());
          k += 1;
        }
        k = i + j;
        i = k;
        if (!this.Cnt.isEmpty()) {
          i = k + 1 + f.eU(j);
        }
        this.Cnu = j;
        i = i + this.Crw.sy() + this.Ckp.size();
        this.Ckv = i;
        AppMethodBeat.o(120946);
        return i;
      }
    }
  }
  
  public static abstract interface an
    extends r
  {}
  
  public static abstract interface j
    extends r
  {}
  
  public static final class k
    extends i.c<k>
    implements a.l
  {
    public static s<k> Ckq;
    private static final k ClS;
    private final d Ckp;
    private int Ckr;
    private byte Cku = -1;
    private int Ckv = -1;
    public int ClT;
    
    static
    {
      AppMethodBeat.i(120600);
      Ckq = new a.k.1();
      k localk = new k();
      ClS = localk;
      localk.ClT = 0;
      AppMethodBeat.o(120600);
    }
    
    private k()
    {
      this.Ckp = d.Cre;
    }
    
    /* Error */
    private k(a.j.b.a.c.g.e parame, g paramg)
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_3
      //   2: aload_0
      //   3: invokespecial 51	a/j/b/a/c/g/i$c:<init>	()V
      //   6: ldc 68
      //   8: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   11: aload_0
      //   12: iconst_m1
      //   13: putfield 53	a/j/b/a/c/e/a$k:Cku	B
      //   16: aload_0
      //   17: iconst_m1
      //   18: putfield 55	a/j/b/a/c/e/a$k:Ckv	I
      //   21: aload_0
      //   22: iconst_0
      //   23: putfield 46	a/j/b/a/c/e/a$k:ClT	I
      //   26: invokestatic 72	a/j/b/a/c/g/d:emp	()La/j/b/a/c/g/d$b;
      //   29: astore 5
      //   31: aload 5
      //   33: iconst_1
      //   34: invokestatic 78	a/j/b/a/c/g/f:e	(Ljava/io/OutputStream;I)La/j/b/a/c/g/f;
      //   37: astore 6
      //   39: iload_3
      //   40: ifne +117 -> 157
      //   43: aload_1
      //   44: invokevirtual 84	a/j/b/a/c/g/e:sk	()I
      //   47: istore 4
      //   49: iload 4
      //   51: lookupswitch	default:+218->269, 0:+221->272, 8:+43->94
      //   77: aload_1
      //   78: aload 6
      //   80: aload_2
      //   81: iload 4
      //   83: invokevirtual 88	a/j/b/a/c/e/a$k:a	(La/j/b/a/c/g/e;La/j/b/a/c/g/f;La/j/b/a/c/g/g;I)Z
      //   86: ifne -47 -> 39
      //   89: iconst_1
      //   90: istore_3
      //   91: goto -52 -> 39
      //   94: aload_0
      //   95: aload_0
      //   96: getfield 90	a/j/b/a/c/e/a$k:Ckr	I
      //   99: iconst_1
      //   100: ior
      //   101: putfield 90	a/j/b/a/c/e/a$k:Ckr	I
      //   104: aload_0
      //   105: aload_1
      //   106: invokevirtual 93	a/j/b/a/c/g/e:sl	()I
      //   109: putfield 46	a/j/b/a/c/e/a$k:ClT	I
      //   112: goto -73 -> 39
      //   115: astore_1
      //   116: aload_1
      //   117: aload_0
      //   118: putfield 97	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
      //   121: ldc 68
      //   123: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   126: aload_1
      //   127: athrow
      //   128: astore_1
      //   129: aload 6
      //   131: invokevirtual 100	a/j/b/a/c/g/f:flush	()V
      //   134: aload_0
      //   135: aload 5
      //   137: invokevirtual 106	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
      //   140: putfield 62	a/j/b/a/c/e/a$k:Ckp	La/j/b/a/c/g/d;
      //   143: aload_0
      //   144: getfield 110	a/j/b/a/c/g/i$c:Crw	La/j/b/a/c/g/h;
      //   147: invokevirtual 115	a/j/b/a/c/g/h:emF	()V
      //   150: ldc 68
      //   152: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   155: aload_1
      //   156: athrow
      //   157: aload 6
      //   159: invokevirtual 100	a/j/b/a/c/g/f:flush	()V
      //   162: aload_0
      //   163: aload 5
      //   165: invokevirtual 106	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
      //   168: putfield 62	a/j/b/a/c/e/a$k:Ckp	La/j/b/a/c/g/d;
      //   171: aload_0
      //   172: getfield 110	a/j/b/a/c/g/i$c:Crw	La/j/b/a/c/g/h;
      //   175: invokevirtual 115	a/j/b/a/c/g/h:emF	()V
      //   178: ldc 68
      //   180: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   183: return
      //   184: astore_1
      //   185: aload_0
      //   186: aload 5
      //   188: invokevirtual 106	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
      //   191: putfield 62	a/j/b/a/c/e/a$k:Ckp	La/j/b/a/c/g/d;
      //   194: goto -23 -> 171
      //   197: astore_1
      //   198: aload_0
      //   199: aload 5
      //   201: invokevirtual 106	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
      //   204: putfield 62	a/j/b/a/c/e/a$k:Ckp	La/j/b/a/c/g/d;
      //   207: ldc 68
      //   209: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   212: aload_1
      //   213: athrow
      //   214: astore_1
      //   215: new 65	a/j/b/a/c/g/k
      //   218: dup
      //   219: aload_1
      //   220: invokevirtual 119	java/io/IOException:getMessage	()Ljava/lang/String;
      //   223: invokespecial 122	a/j/b/a/c/g/k:<init>	(Ljava/lang/String;)V
      //   226: astore_1
      //   227: aload_1
      //   228: aload_0
      //   229: putfield 97	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
      //   232: ldc 68
      //   234: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   237: aload_1
      //   238: athrow
      //   239: astore_2
      //   240: aload_0
      //   241: aload 5
      //   243: invokevirtual 106	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
      //   246: putfield 62	a/j/b/a/c/e/a$k:Ckp	La/j/b/a/c/g/d;
      //   249: goto -106 -> 143
      //   252: astore_1
      //   253: aload_0
      //   254: aload 5
      //   256: invokevirtual 106	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
      //   259: putfield 62	a/j/b/a/c/e/a$k:Ckp	La/j/b/a/c/g/d;
      //   262: ldc 68
      //   264: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   267: aload_1
      //   268: athrow
      //   269: goto -193 -> 76
      //   272: iconst_1
      //   273: istore_3
      //   274: goto -235 -> 39
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	277	0	this	k
      //   0	277	1	parame	a.j.b.a.c.g.e
      //   0	277	2	paramg	g
      //   1	273	3	i	int
      //   47	35	4	j	int
      //   29	226	5	localb	a.j.b.a.c.g.d.b
      //   37	121	6	localf	f
      // Exception table:
      //   from	to	target	type
      //   43	49	115	a/j/b/a/c/g/k
      //   76	89	115	a/j/b/a/c/g/k
      //   94	112	115	a/j/b/a/c/g/k
      //   43	49	128	finally
      //   76	89	128	finally
      //   94	112	128	finally
      //   116	128	128	finally
      //   215	239	128	finally
      //   157	162	184	java/io/IOException
      //   157	162	197	finally
      //   43	49	214	java/io/IOException
      //   76	89	214	java/io/IOException
      //   94	112	214	java/io/IOException
      //   129	134	239	java/io/IOException
      //   129	134	252	finally
    }
    
    private k(i.b<k, ?> paramb)
    {
      super();
      this.Ckp = paramb.Ckp;
    }
    
    public static k eiu()
    {
      return ClS;
    }
    
    public final void a(f paramf)
    {
      AppMethodBeat.i(120596);
      sy();
      i.c.a locala = emM();
      if ((this.Ckr & 0x1) == 1) {
        paramf.bj(1, this.ClT);
      }
      locala.b(200, paramf);
      paramf.d(this.Ckp);
      AppMethodBeat.o(120596);
    }
    
    public final s<k> egX()
    {
      return Ckq;
    }
    
    public final boolean eiv()
    {
      return (this.Ckr & 0x1) == 1;
    }
    
    public final boolean isInitialized()
    {
      AppMethodBeat.i(120595);
      int i = this.Cku;
      if (i == 1)
      {
        AppMethodBeat.o(120595);
        return true;
      }
      if (i == 0)
      {
        AppMethodBeat.o(120595);
        return false;
      }
      if (!this.Crw.isInitialized())
      {
        this.Cku = 0;
        AppMethodBeat.o(120595);
        return false;
      }
      this.Cku = 1;
      AppMethodBeat.o(120595);
      return true;
    }
    
    public final int sy()
    {
      AppMethodBeat.i(120597);
      int i = this.Ckv;
      if (i != -1)
      {
        AppMethodBeat.o(120597);
        return i;
      }
      i = 0;
      if ((this.Ckr & 0x1) == 1) {
        i = f.bl(1, this.ClT) + 0;
      }
      i = i + this.Crw.sy() + this.Ckp.size();
      this.Ckv = i;
      AppMethodBeat.o(120597);
      return i;
    }
  }
  
  public static abstract interface l
    extends i.d
  {}
  
  public static final class m
    extends i
    implements a.n
  {
    public static s<m> Ckq;
    private static final m ClU;
    int CkK;
    private final d Ckp;
    private int Ckr;
    private byte Cku = -1;
    private int Ckv = -1;
    int ClV;
    a.m.b ClW;
    a.aa ClX;
    int ClY;
    private List<m> ClZ;
    private List<m> Cma;
    
    static
    {
      AppMethodBeat.i(120634);
      Ckq = new a.m.1();
      m localm = new m();
      ClU = localm;
      localm.egZ();
      AppMethodBeat.o(120634);
    }
    
    private m()
    {
      this.Ckp = d.Cre;
    }
    
    /* Error */
    private m(a.j.b.a.c.g.e parame, g paramg)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 63	a/j/b/a/c/g/i:<init>	()V
      //   4: ldc 80
      //   6: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   9: aload_0
      //   10: iconst_m1
      //   11: putfield 65	a/j/b/a/c/e/a$m:Cku	B
      //   14: aload_0
      //   15: iconst_m1
      //   16: putfield 67	a/j/b/a/c/e/a$m:Ckv	I
      //   19: aload_0
      //   20: invokespecial 58	a/j/b/a/c/e/a$m:egZ	()V
      //   23: iconst_0
      //   24: istore_3
      //   25: invokestatic 84	a/j/b/a/c/g/d:emp	()La/j/b/a/c/g/d$b;
      //   28: astore 11
      //   30: aload 11
      //   32: iconst_1
      //   33: invokestatic 90	a/j/b/a/c/g/f:e	(Ljava/io/OutputStream;I)La/j/b/a/c/g/f;
      //   36: astore 12
      //   38: iconst_0
      //   39: istore 5
      //   41: iload 5
      //   43: ifne +737 -> 780
      //   46: iload_3
      //   47: istore 6
      //   49: iload_3
      //   50: istore 7
      //   52: iload_3
      //   53: istore 8
      //   55: aload_1
      //   56: invokevirtual 96	a/j/b/a/c/g/e:sk	()I
      //   59: istore 4
      //   61: iload 4
      //   63: lookupswitch	default:+871->934, 0:+874->937, 8:+101->164, 16:+232->295, 24:+312->375, 34:+420->483, 40:+548->611, 50:+588->651, 58:+662->725
      //   137: istore 6
      //   139: iload_3
      //   140: istore 7
      //   142: iload_3
      //   143: istore 8
      //   145: aload_0
      //   146: aload_1
      //   147: aload 12
      //   149: aload_2
      //   150: iload 4
      //   152: invokevirtual 100	a/j/b/a/c/e/a$m:a	(La/j/b/a/c/g/e;La/j/b/a/c/g/f;La/j/b/a/c/g/g;I)Z
      //   155: ifne +776 -> 931
      //   158: iconst_1
      //   159: istore 5
      //   161: goto -120 -> 41
      //   164: iload_3
      //   165: istore 6
      //   167: iload_3
      //   168: istore 7
      //   170: iload_3
      //   171: istore 8
      //   173: aload_0
      //   174: aload_0
      //   175: getfield 102	a/j/b/a/c/e/a$m:Ckr	I
      //   178: iconst_1
      //   179: ior
      //   180: putfield 102	a/j/b/a/c/e/a$m:Ckr	I
      //   183: iload_3
      //   184: istore 6
      //   186: iload_3
      //   187: istore 7
      //   189: iload_3
      //   190: istore 8
      //   192: aload_0
      //   193: aload_1
      //   194: invokevirtual 105	a/j/b/a/c/g/e:sl	()I
      //   197: putfield 107	a/j/b/a/c/e/a$m:CkK	I
      //   200: goto -159 -> 41
      //   203: astore_1
      //   204: iload 6
      //   206: istore 4
      //   208: iload 4
      //   210: istore_3
      //   211: aload_1
      //   212: aload_0
      //   213: putfield 111	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
      //   216: iload 4
      //   218: istore_3
      //   219: ldc 80
      //   221: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   224: iload 4
      //   226: istore_3
      //   227: aload_1
      //   228: athrow
      //   229: astore_1
      //   230: iload_3
      //   231: bipush 32
      //   233: iand
      //   234: bipush 32
      //   236: if_icmpne +14 -> 250
      //   239: aload_0
      //   240: aload_0
      //   241: getfield 113	a/j/b/a/c/e/a$m:ClZ	Ljava/util/List;
      //   244: invokestatic 119	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   247: putfield 113	a/j/b/a/c/e/a$m:ClZ	Ljava/util/List;
      //   250: iload_3
      //   251: bipush 64
      //   253: iand
      //   254: bipush 64
      //   256: if_icmpne +14 -> 270
      //   259: aload_0
      //   260: aload_0
      //   261: getfield 121	a/j/b/a/c/e/a$m:Cma	Ljava/util/List;
      //   264: invokestatic 119	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   267: putfield 121	a/j/b/a/c/e/a$m:Cma	Ljava/util/List;
      //   270: aload 12
      //   272: invokevirtual 124	a/j/b/a/c/g/f:flush	()V
      //   275: aload_0
      //   276: aload 11
      //   278: invokevirtual 130	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
      //   281: putfield 74	a/j/b/a/c/e/a$m:Ckp	La/j/b/a/c/g/d;
      //   284: aload_0
      //   285: invokevirtual 133	a/j/b/a/c/e/a$m:emL	()V
      //   288: ldc 80
      //   290: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   293: aload_1
      //   294: athrow
      //   295: iload_3
      //   296: istore 6
      //   298: iload_3
      //   299: istore 7
      //   301: iload_3
      //   302: istore 8
      //   304: aload_0
      //   305: aload_0
      //   306: getfield 102	a/j/b/a/c/e/a$m:Ckr	I
      //   309: iconst_2
      //   310: ior
      //   311: putfield 102	a/j/b/a/c/e/a$m:Ckr	I
      //   314: iload_3
      //   315: istore 6
      //   317: iload_3
      //   318: istore 7
      //   320: iload_3
      //   321: istore 8
      //   323: aload_0
      //   324: aload_1
      //   325: invokevirtual 105	a/j/b/a/c/g/e:sl	()I
      //   328: putfield 135	a/j/b/a/c/e/a$m:ClV	I
      //   331: goto -290 -> 41
      //   334: astore_1
      //   335: iload 7
      //   337: istore 4
      //   339: iload 4
      //   341: istore_3
      //   342: new 77	a/j/b/a/c/g/k
      //   345: dup
      //   346: aload_1
      //   347: invokevirtual 139	java/io/IOException:getMessage	()Ljava/lang/String;
      //   350: invokespecial 142	a/j/b/a/c/g/k:<init>	(Ljava/lang/String;)V
      //   353: astore_1
      //   354: iload 4
      //   356: istore_3
      //   357: aload_1
      //   358: aload_0
      //   359: putfield 111	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
      //   362: iload 4
      //   364: istore_3
      //   365: ldc 80
      //   367: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   370: iload 4
      //   372: istore_3
      //   373: aload_1
      //   374: athrow
      //   375: iload_3
      //   376: istore 6
      //   378: iload_3
      //   379: istore 7
      //   381: iload_3
      //   382: istore 8
      //   384: aload_1
      //   385: invokevirtual 105	a/j/b/a/c/g/e:sl	()I
      //   388: istore 9
      //   390: iload_3
      //   391: istore 6
      //   393: iload_3
      //   394: istore 7
      //   396: iload_3
      //   397: istore 8
      //   399: iload 9
      //   401: invokestatic 146	a/j/b/a/c/e/a$m$b:Ur	(I)La/j/b/a/c/e/a$m$b;
      //   404: astore 10
      //   406: aload 10
      //   408: ifnonnull +38 -> 446
      //   411: iload_3
      //   412: istore 6
      //   414: iload_3
      //   415: istore 7
      //   417: iload_3
      //   418: istore 8
      //   420: aload 12
      //   422: iload 4
      //   424: invokevirtual 149	a/j/b/a/c/g/f:eX	(I)V
      //   427: iload_3
      //   428: istore 6
      //   430: iload_3
      //   431: istore 7
      //   433: iload_3
      //   434: istore 8
      //   436: aload 12
      //   438: iload 9
      //   440: invokevirtual 149	a/j/b/a/c/g/f:eX	(I)V
      //   443: goto -402 -> 41
      //   446: iload_3
      //   447: istore 6
      //   449: iload_3
      //   450: istore 7
      //   452: iload_3
      //   453: istore 8
      //   455: aload_0
      //   456: aload_0
      //   457: getfield 102	a/j/b/a/c/e/a$m:Ckr	I
      //   460: iconst_4
      //   461: ior
      //   462: putfield 102	a/j/b/a/c/e/a$m:Ckr	I
      //   465: iload_3
      //   466: istore 6
      //   468: iload_3
      //   469: istore 7
      //   471: iload_3
      //   472: istore 8
      //   474: aload_0
      //   475: aload 10
      //   477: putfield 151	a/j/b/a/c/e/a$m:ClW	La/j/b/a/c/e/a$m$b;
      //   480: goto -439 -> 41
      //   483: iload_3
      //   484: istore 6
      //   486: iload_3
      //   487: istore 7
      //   489: iload_3
      //   490: istore 8
      //   492: aload_0
      //   493: getfield 102	a/j/b/a/c/e/a$m:Ckr	I
      //   496: bipush 8
      //   498: iand
      //   499: bipush 8
      //   501: if_icmpne +424 -> 925
      //   504: iload_3
      //   505: istore 6
      //   507: iload_3
      //   508: istore 7
      //   510: iload_3
      //   511: istore 8
      //   513: aload_0
      //   514: getfield 153	a/j/b/a/c/e/a$m:ClX	La/j/b/a/c/e/a$aa;
      //   517: invokestatic 159	a/j/b/a/c/e/a$aa:f	(La/j/b/a/c/e/a$aa;)La/j/b/a/c/e/a$aa$c;
      //   520: astore 10
      //   522: iload_3
      //   523: istore 6
      //   525: iload_3
      //   526: istore 7
      //   528: iload_3
      //   529: istore 8
      //   531: aload_0
      //   532: aload_1
      //   533: getstatic 160	a/j/b/a/c/e/a$aa:Ckq	La/j/b/a/c/g/s;
      //   536: aload_2
      //   537: invokevirtual 163	a/j/b/a/c/g/e:a	(La/j/b/a/c/g/s;La/j/b/a/c/g/g;)La/j/b/a/c/g/q;
      //   540: checkcast 155	a/j/b/a/c/e/a$aa
      //   543: putfield 153	a/j/b/a/c/e/a$m:ClX	La/j/b/a/c/e/a$aa;
      //   546: aload 10
      //   548: ifnull +40 -> 588
      //   551: iload_3
      //   552: istore 6
      //   554: iload_3
      //   555: istore 7
      //   557: iload_3
      //   558: istore 8
      //   560: aload 10
      //   562: aload_0
      //   563: getfield 153	a/j/b/a/c/e/a$m:ClX	La/j/b/a/c/e/a$aa;
      //   566: invokevirtual 168	a/j/b/a/c/e/a$aa$c:j	(La/j/b/a/c/e/a$aa;)La/j/b/a/c/e/a$aa$c;
      //   569: pop
      //   570: iload_3
      //   571: istore 6
      //   573: iload_3
      //   574: istore 7
      //   576: iload_3
      //   577: istore 8
      //   579: aload_0
      //   580: aload 10
      //   582: invokevirtual 172	a/j/b/a/c/e/a$aa$c:ejS	()La/j/b/a/c/e/a$aa;
      //   585: putfield 153	a/j/b/a/c/e/a$m:ClX	La/j/b/a/c/e/a$aa;
      //   588: iload_3
      //   589: istore 6
      //   591: iload_3
      //   592: istore 7
      //   594: iload_3
      //   595: istore 8
      //   597: aload_0
      //   598: aload_0
      //   599: getfield 102	a/j/b/a/c/e/a$m:Ckr	I
      //   602: bipush 8
      //   604: ior
      //   605: putfield 102	a/j/b/a/c/e/a$m:Ckr	I
      //   608: goto -567 -> 41
      //   611: iload_3
      //   612: istore 6
      //   614: iload_3
      //   615: istore 7
      //   617: iload_3
      //   618: istore 8
      //   620: aload_0
      //   621: aload_0
      //   622: getfield 102	a/j/b/a/c/e/a$m:Ckr	I
      //   625: bipush 16
      //   627: ior
      //   628: putfield 102	a/j/b/a/c/e/a$m:Ckr	I
      //   631: iload_3
      //   632: istore 6
      //   634: iload_3
      //   635: istore 7
      //   637: iload_3
      //   638: istore 8
      //   640: aload_0
      //   641: aload_1
      //   642: invokevirtual 105	a/j/b/a/c/g/e:sl	()I
      //   645: putfield 174	a/j/b/a/c/e/a$m:ClY	I
      //   648: goto -607 -> 41
      //   651: iload_3
      //   652: istore 4
      //   654: iload_3
      //   655: bipush 32
      //   657: iand
      //   658: bipush 32
      //   660: if_icmpeq +29 -> 689
      //   663: iload_3
      //   664: istore 6
      //   666: iload_3
      //   667: istore 7
      //   669: iload_3
      //   670: istore 8
      //   672: aload_0
      //   673: new 176	java/util/ArrayList
      //   676: dup
      //   677: invokespecial 177	java/util/ArrayList:<init>	()V
      //   680: putfield 113	a/j/b/a/c/e/a$m:ClZ	Ljava/util/List;
      //   683: iload_3
      //   684: bipush 32
      //   686: ior
      //   687: istore 4
      //   689: iload 4
      //   691: istore 6
      //   693: iload 4
      //   695: istore 7
      //   697: iload 4
      //   699: istore 8
      //   701: aload_0
      //   702: getfield 113	a/j/b/a/c/e/a$m:ClZ	Ljava/util/List;
      //   705: aload_1
      //   706: getstatic 52	a/j/b/a/c/e/a$m:Ckq	La/j/b/a/c/g/s;
      //   709: aload_2
      //   710: invokevirtual 163	a/j/b/a/c/g/e:a	(La/j/b/a/c/g/s;La/j/b/a/c/g/g;)La/j/b/a/c/g/q;
      //   713: invokeinterface 183 2 0
      //   718: pop
      //   719: iload 4
      //   721: istore_3
      //   722: goto -681 -> 41
      //   725: iload_3
      //   726: bipush 64
      //   728: iand
      //   729: bipush 64
      //   731: if_icmpeq +191 -> 922
      //   734: iload_3
      //   735: istore 6
      //   737: iload_3
      //   738: istore 7
      //   740: iload_3
      //   741: istore 8
      //   743: aload_0
      //   744: new 176	java/util/ArrayList
      //   747: dup
      //   748: invokespecial 177	java/util/ArrayList:<init>	()V
      //   751: putfield 121	a/j/b/a/c/e/a$m:Cma	Ljava/util/List;
      //   754: iload_3
      //   755: bipush 64
      //   757: ior
      //   758: istore_3
      //   759: aload_0
      //   760: getfield 121	a/j/b/a/c/e/a$m:Cma	Ljava/util/List;
      //   763: aload_1
      //   764: getstatic 52	a/j/b/a/c/e/a$m:Ckq	La/j/b/a/c/g/s;
      //   767: aload_2
      //   768: invokevirtual 163	a/j/b/a/c/g/e:a	(La/j/b/a/c/g/s;La/j/b/a/c/g/g;)La/j/b/a/c/g/q;
      //   771: invokeinterface 183 2 0
      //   776: pop
      //   777: goto -736 -> 41
      //   780: iload_3
      //   781: bipush 32
      //   783: iand
      //   784: bipush 32
      //   786: if_icmpne +14 -> 800
      //   789: aload_0
      //   790: aload_0
      //   791: getfield 113	a/j/b/a/c/e/a$m:ClZ	Ljava/util/List;
      //   794: invokestatic 119	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   797: putfield 113	a/j/b/a/c/e/a$m:ClZ	Ljava/util/List;
      //   800: iload_3
      //   801: bipush 64
      //   803: iand
      //   804: bipush 64
      //   806: if_icmpne +14 -> 820
      //   809: aload_0
      //   810: aload_0
      //   811: getfield 121	a/j/b/a/c/e/a$m:Cma	Ljava/util/List;
      //   814: invokestatic 119	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   817: putfield 121	a/j/b/a/c/e/a$m:Cma	Ljava/util/List;
      //   820: aload 12
      //   822: invokevirtual 124	a/j/b/a/c/g/f:flush	()V
      //   825: aload_0
      //   826: aload 11
      //   828: invokevirtual 130	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
      //   831: putfield 74	a/j/b/a/c/e/a$m:Ckp	La/j/b/a/c/g/d;
      //   834: aload_0
      //   835: invokevirtual 133	a/j/b/a/c/e/a$m:emL	()V
      //   838: ldc 80
      //   840: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   843: return
      //   844: astore_1
      //   845: aload_0
      //   846: aload 11
      //   848: invokevirtual 130	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
      //   851: putfield 74	a/j/b/a/c/e/a$m:Ckp	La/j/b/a/c/g/d;
      //   854: goto -20 -> 834
      //   857: astore_1
      //   858: aload_0
      //   859: aload 11
      //   861: invokevirtual 130	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
      //   864: putfield 74	a/j/b/a/c/e/a$m:Ckp	La/j/b/a/c/g/d;
      //   867: ldc 80
      //   869: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   872: aload_1
      //   873: athrow
      //   874: astore_2
      //   875: aload_0
      //   876: aload 11
      //   878: invokevirtual 130	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
      //   881: putfield 74	a/j/b/a/c/e/a$m:Ckp	La/j/b/a/c/g/d;
      //   884: goto -600 -> 284
      //   887: astore_1
      //   888: aload_0
      //   889: aload 11
      //   891: invokevirtual 130	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
      //   894: putfield 74	a/j/b/a/c/e/a$m:Ckp	La/j/b/a/c/g/d;
      //   897: ldc 80
      //   899: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   902: aload_1
      //   903: athrow
      //   904: astore_1
      //   905: goto -675 -> 230
      //   908: astore_1
      //   909: iload_3
      //   910: istore 4
      //   912: goto -573 -> 339
      //   915: astore_1
      //   916: iload_3
      //   917: istore 4
      //   919: goto -711 -> 208
      //   922: goto -163 -> 759
      //   925: aconst_null
      //   926: astore 10
      //   928: goto -406 -> 522
      //   931: goto -154 -> 777
      //   934: goto -798 -> 136
      //   937: iconst_1
      //   938: istore 5
      //   940: goto -899 -> 41
      //   943: astore_1
      //   944: iload 8
      //   946: istore_3
      //   947: goto -717 -> 230
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	950	0	this	m
      //   0	950	1	parame	a.j.b.a.c.g.e
      //   0	950	2	paramg	g
      //   24	923	3	i	int
      //   59	859	4	j	int
      //   39	900	5	k	int
      //   47	689	6	m	int
      //   50	689	7	n	int
      //   53	892	8	i1	int
      //   388	51	9	i2	int
      //   404	523	10	localObject	Object
      //   28	862	11	localb	a.j.b.a.c.g.d.b
      //   36	785	12	localf	f
      // Exception table:
      //   from	to	target	type
      //   55	61	203	a/j/b/a/c/g/k
      //   145	158	203	a/j/b/a/c/g/k
      //   173	183	203	a/j/b/a/c/g/k
      //   192	200	203	a/j/b/a/c/g/k
      //   304	314	203	a/j/b/a/c/g/k
      //   323	331	203	a/j/b/a/c/g/k
      //   384	390	203	a/j/b/a/c/g/k
      //   399	406	203	a/j/b/a/c/g/k
      //   420	427	203	a/j/b/a/c/g/k
      //   436	443	203	a/j/b/a/c/g/k
      //   455	465	203	a/j/b/a/c/g/k
      //   474	480	203	a/j/b/a/c/g/k
      //   492	504	203	a/j/b/a/c/g/k
      //   513	522	203	a/j/b/a/c/g/k
      //   531	546	203	a/j/b/a/c/g/k
      //   560	570	203	a/j/b/a/c/g/k
      //   579	588	203	a/j/b/a/c/g/k
      //   597	608	203	a/j/b/a/c/g/k
      //   620	631	203	a/j/b/a/c/g/k
      //   640	648	203	a/j/b/a/c/g/k
      //   672	683	203	a/j/b/a/c/g/k
      //   701	719	203	a/j/b/a/c/g/k
      //   743	754	203	a/j/b/a/c/g/k
      //   211	216	229	finally
      //   219	224	229	finally
      //   227	229	229	finally
      //   342	354	229	finally
      //   357	362	229	finally
      //   365	370	229	finally
      //   373	375	229	finally
      //   55	61	334	java/io/IOException
      //   145	158	334	java/io/IOException
      //   173	183	334	java/io/IOException
      //   192	200	334	java/io/IOException
      //   304	314	334	java/io/IOException
      //   323	331	334	java/io/IOException
      //   384	390	334	java/io/IOException
      //   399	406	334	java/io/IOException
      //   420	427	334	java/io/IOException
      //   436	443	334	java/io/IOException
      //   455	465	334	java/io/IOException
      //   474	480	334	java/io/IOException
      //   492	504	334	java/io/IOException
      //   513	522	334	java/io/IOException
      //   531	546	334	java/io/IOException
      //   560	570	334	java/io/IOException
      //   579	588	334	java/io/IOException
      //   597	608	334	java/io/IOException
      //   620	631	334	java/io/IOException
      //   640	648	334	java/io/IOException
      //   672	683	334	java/io/IOException
      //   701	719	334	java/io/IOException
      //   743	754	334	java/io/IOException
      //   820	825	844	java/io/IOException
      //   820	825	857	finally
      //   270	275	874	java/io/IOException
      //   270	275	887	finally
      //   759	777	904	finally
      //   759	777	908	java/io/IOException
      //   759	777	915	a/j/b/a/c/g/k
      //   55	61	943	finally
      //   145	158	943	finally
      //   173	183	943	finally
      //   192	200	943	finally
      //   304	314	943	finally
      //   323	331	943	finally
      //   384	390	943	finally
      //   399	406	943	finally
      //   420	427	943	finally
      //   436	443	943	finally
      //   455	465	943	finally
      //   474	480	943	finally
      //   492	504	943	finally
      //   513	522	943	finally
      //   531	546	943	finally
      //   560	570	943	finally
      //   579	588	943	finally
      //   597	608	943	finally
      //   620	631	943	finally
      //   640	648	943	finally
      //   672	683	943	finally
      //   701	719	943	finally
      //   743	754	943	finally
    }
    
    private m(i.a parama)
    {
      super();
      this.Ckp = parama.Ckp;
    }
    
    public static a.m.a b(m paramm)
    {
      AppMethodBeat.i(120631);
      paramm = a.m.a.eiI().f(paramm);
      AppMethodBeat.o(120631);
      return paramm;
    }
    
    private void egZ()
    {
      AppMethodBeat.i(120627);
      this.CkK = 0;
      this.ClV = 0;
      this.ClW = a.m.b.Cmb;
      this.ClX = a.aa.ejw();
      this.ClY = 0;
      this.ClZ = Collections.emptyList();
      this.Cma = Collections.emptyList();
      AppMethodBeat.o(120627);
    }
    
    public static m eiz()
    {
      return ClU;
    }
    
    public final void a(f paramf)
    {
      int k = 0;
      AppMethodBeat.i(120629);
      sy();
      if ((this.Ckr & 0x1) == 1) {
        paramf.bj(1, this.CkK);
      }
      if ((this.Ckr & 0x2) == 2) {
        paramf.bj(2, this.ClV);
      }
      if ((this.Ckr & 0x4) == 4) {
        paramf.iG(3, this.ClW.value);
      }
      if ((this.Ckr & 0x8) == 8) {
        paramf.a(4, this.ClX);
      }
      if ((this.Ckr & 0x10) == 16) {
        paramf.bj(5, this.ClY);
      }
      int i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= this.ClZ.size()) {
          break;
        }
        paramf.a(6, (q)this.ClZ.get(i));
        i += 1;
      }
      while (j < this.Cma.size())
      {
        paramf.a(7, (q)this.Cma.get(j));
        j += 1;
      }
      paramf.d(this.Ckp);
      AppMethodBeat.o(120629);
    }
    
    public final s<m> egX()
    {
      return Ckq;
    }
    
    public final boolean ehx()
    {
      return (this.Ckr & 0x1) == 1;
    }
    
    public final boolean eiA()
    {
      return (this.Ckr & 0x2) == 2;
    }
    
    public final boolean eiB()
    {
      return (this.Ckr & 0x4) == 4;
    }
    
    public final boolean eiC()
    {
      return (this.Ckr & 0x8) == 8;
    }
    
    public final boolean eiD()
    {
      return (this.Ckr & 0x10) == 16;
    }
    
    public final boolean isInitialized()
    {
      AppMethodBeat.i(120628);
      int i = this.Cku;
      if (i == 1)
      {
        AppMethodBeat.o(120628);
        return true;
      }
      if (i == 0)
      {
        AppMethodBeat.o(120628);
        return false;
      }
      if ((eiC()) && (!this.ClX.isInitialized()))
      {
        this.Cku = 0;
        AppMethodBeat.o(120628);
        return false;
      }
      i = 0;
      while (i < this.ClZ.size())
      {
        if (!((m)this.ClZ.get(i)).isInitialized())
        {
          this.Cku = 0;
          AppMethodBeat.o(120628);
          return false;
        }
        i += 1;
      }
      i = 0;
      while (i < this.Cma.size())
      {
        if (!((m)this.Cma.get(i)).isInitialized())
        {
          this.Cku = 0;
          AppMethodBeat.o(120628);
          return false;
        }
        i += 1;
      }
      this.Cku = 1;
      AppMethodBeat.o(120628);
      return true;
    }
    
    public final int sy()
    {
      int n = 0;
      AppMethodBeat.i(120630);
      int i = this.Ckv;
      if (i != -1)
      {
        AppMethodBeat.o(120630);
        return i;
      }
      if ((this.Ckr & 0x1) == 1) {}
      for (int j = f.bl(1, this.CkK) + 0;; j = 0)
      {
        i = j;
        if ((this.Ckr & 0x2) == 2) {
          i = j + f.bl(2, this.ClV);
        }
        j = i;
        if ((this.Ckr & 0x4) == 4) {
          j = i + f.iH(3, this.ClW.value);
        }
        i = j;
        if ((this.Ckr & 0x8) == 8) {
          i = j + f.c(4, this.ClX);
        }
        j = i;
        if ((this.Ckr & 0x10) == 16) {
          j = i + f.bl(5, this.ClY);
        }
        int k = 0;
        i = j;
        j = k;
        int m;
        for (;;)
        {
          k = n;
          m = i;
          if (j >= this.ClZ.size()) {
            break;
          }
          i += f.c(6, (q)this.ClZ.get(j));
          j += 1;
        }
        while (k < this.Cma.size())
        {
          m += f.c(7, (q)this.Cma.get(k));
          k += 1;
        }
        i = this.Ckp.size() + m;
        this.Ckv = i;
        AppMethodBeat.o(120630);
        return i;
      }
    }
  }
  
  public static abstract interface n
    extends r
  {}
  
  public static final class s
    extends i.c<s>
    implements a.t
  {
    public static s<s> Ckq;
    private static final s Cmw;
    private final d Ckp;
    private int Ckr;
    private byte Cku = -1;
    private int Ckv = -1;
    public List<a.o> Clk;
    public List<a.u> Cll;
    public List<a.ab> Clm;
    public a.ag Clq;
    public a.am Cls;
    
    static
    {
      AppMethodBeat.i(120708);
      Ckq = new b() {};
      s locals = new s();
      Cmw = locals;
      locals.egZ();
      AppMethodBeat.o(120708);
    }
    
    private s()
    {
      this.Ckp = d.Cre;
    }
    
    /* Error */
    private s(a.j.b.a.c.g.e parame, g paramg)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 63	a/j/b/a/c/g/i$c:<init>	()V
      //   4: ldc 80
      //   6: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   9: aload_0
      //   10: iconst_m1
      //   11: putfield 65	a/j/b/a/c/e/a$s:Cku	B
      //   14: aload_0
      //   15: iconst_m1
      //   16: putfield 67	a/j/b/a/c/e/a$s:Ckv	I
      //   19: aload_0
      //   20: invokespecial 58	a/j/b/a/c/e/a$s:egZ	()V
      //   23: iconst_0
      //   24: istore_3
      //   25: invokestatic 84	a/j/b/a/c/g/d:emp	()La/j/b/a/c/g/d$b;
      //   28: astore 10
      //   30: aload 10
      //   32: iconst_1
      //   33: invokestatic 90	a/j/b/a/c/g/f:e	(Ljava/io/OutputStream;I)La/j/b/a/c/g/f;
      //   36: astore 11
      //   38: iconst_0
      //   39: istore 8
      //   41: iload 8
      //   43: ifne +720 -> 763
      //   46: iload_3
      //   47: istore 5
      //   49: iload_3
      //   50: istore 4
      //   52: iload_3
      //   53: istore 6
      //   55: aload_1
      //   56: invokevirtual 96	a/j/b/a/c/g/e:sk	()I
      //   59: istore 7
      //   61: iload 7
      //   63: lookupswitch	default:+853->916, 0:+856->919, 26:+85->148, 34:+267->330, 42:+379->442, 242:+450->513, 258:+575->638
      //   121: istore 5
      //   123: iload_3
      //   124: istore 4
      //   126: iload_3
      //   127: istore 6
      //   129: aload_0
      //   130: aload_1
      //   131: aload 11
      //   133: aload_2
      //   134: iload 7
      //   136: invokevirtual 99	a/j/b/a/c/e/a$s:a	(La/j/b/a/c/g/e;La/j/b/a/c/g/f;La/j/b/a/c/g/g;I)Z
      //   139: ifne -98 -> 41
      //   142: iconst_1
      //   143: istore 8
      //   145: goto -104 -> 41
      //   148: iload_3
      //   149: istore 7
      //   151: iload_3
      //   152: iconst_1
      //   153: iand
      //   154: iconst_1
      //   155: if_icmpeq +28 -> 183
      //   158: iload_3
      //   159: istore 5
      //   161: iload_3
      //   162: istore 4
      //   164: iload_3
      //   165: istore 6
      //   167: aload_0
      //   168: new 101	java/util/ArrayList
      //   171: dup
      //   172: invokespecial 102	java/util/ArrayList:<init>	()V
      //   175: putfield 104	a/j/b/a/c/e/a$s:Clk	Ljava/util/List;
      //   178: iload_3
      //   179: iconst_1
      //   180: ior
      //   181: istore 7
      //   183: iload 7
      //   185: istore 5
      //   187: iload 7
      //   189: istore 4
      //   191: iload 7
      //   193: istore 6
      //   195: aload_0
      //   196: getfield 104	a/j/b/a/c/e/a$s:Clk	Ljava/util/List;
      //   199: aload_1
      //   200: getstatic 107	a/j/b/a/c/e/a$o:Ckq	La/j/b/a/c/g/s;
      //   203: aload_2
      //   204: invokevirtual 110	a/j/b/a/c/g/e:a	(La/j/b/a/c/g/s;La/j/b/a/c/g/g;)La/j/b/a/c/g/q;
      //   207: invokeinterface 116 2 0
      //   212: pop
      //   213: iload 7
      //   215: istore_3
      //   216: goto -175 -> 41
      //   219: astore_1
      //   220: iload 5
      //   222: istore 4
      //   224: aload_1
      //   225: aload_0
      //   226: putfield 120	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
      //   229: iload 5
      //   231: istore 4
      //   233: ldc 80
      //   235: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   238: iload 5
      //   240: istore 4
      //   242: aload_1
      //   243: athrow
      //   244: astore_1
      //   245: iload 4
      //   247: iconst_1
      //   248: iand
      //   249: iconst_1
      //   250: if_icmpne +14 -> 264
      //   253: aload_0
      //   254: aload_0
      //   255: getfield 104	a/j/b/a/c/e/a$s:Clk	Ljava/util/List;
      //   258: invokestatic 126	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   261: putfield 104	a/j/b/a/c/e/a$s:Clk	Ljava/util/List;
      //   264: iload 4
      //   266: iconst_2
      //   267: iand
      //   268: iconst_2
      //   269: if_icmpne +14 -> 283
      //   272: aload_0
      //   273: aload_0
      //   274: getfield 128	a/j/b/a/c/e/a$s:Cll	Ljava/util/List;
      //   277: invokestatic 126	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   280: putfield 128	a/j/b/a/c/e/a$s:Cll	Ljava/util/List;
      //   283: iload 4
      //   285: iconst_4
      //   286: iand
      //   287: iconst_4
      //   288: if_icmpne +14 -> 302
      //   291: aload_0
      //   292: aload_0
      //   293: getfield 130	a/j/b/a/c/e/a$s:Clm	Ljava/util/List;
      //   296: invokestatic 126	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   299: putfield 130	a/j/b/a/c/e/a$s:Clm	Ljava/util/List;
      //   302: aload 11
      //   304: invokevirtual 133	a/j/b/a/c/g/f:flush	()V
      //   307: aload_0
      //   308: aload 10
      //   310: invokevirtual 139	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
      //   313: putfield 74	a/j/b/a/c/e/a$s:Ckp	La/j/b/a/c/g/d;
      //   316: aload_0
      //   317: getfield 143	a/j/b/a/c/g/i$c:Crw	La/j/b/a/c/g/h;
      //   320: invokevirtual 148	a/j/b/a/c/g/h:emF	()V
      //   323: ldc 80
      //   325: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   328: aload_1
      //   329: athrow
      //   330: iload_3
      //   331: istore 7
      //   333: iload_3
      //   334: iconst_2
      //   335: iand
      //   336: iconst_2
      //   337: if_icmpeq +28 -> 365
      //   340: iload_3
      //   341: istore 5
      //   343: iload_3
      //   344: istore 4
      //   346: iload_3
      //   347: istore 6
      //   349: aload_0
      //   350: new 101	java/util/ArrayList
      //   353: dup
      //   354: invokespecial 102	java/util/ArrayList:<init>	()V
      //   357: putfield 128	a/j/b/a/c/e/a$s:Cll	Ljava/util/List;
      //   360: iload_3
      //   361: iconst_2
      //   362: ior
      //   363: istore 7
      //   365: iload 7
      //   367: istore 5
      //   369: iload 7
      //   371: istore 4
      //   373: iload 7
      //   375: istore 6
      //   377: aload_0
      //   378: getfield 128	a/j/b/a/c/e/a$s:Cll	Ljava/util/List;
      //   381: aload_1
      //   382: getstatic 151	a/j/b/a/c/e/a$u:Ckq	La/j/b/a/c/g/s;
      //   385: aload_2
      //   386: invokevirtual 110	a/j/b/a/c/g/e:a	(La/j/b/a/c/g/s;La/j/b/a/c/g/g;)La/j/b/a/c/g/q;
      //   389: invokeinterface 116 2 0
      //   394: pop
      //   395: iload 7
      //   397: istore_3
      //   398: goto -357 -> 41
      //   401: astore_1
      //   402: iload 6
      //   404: istore 4
      //   406: new 77	a/j/b/a/c/g/k
      //   409: dup
      //   410: aload_1
      //   411: invokevirtual 155	java/io/IOException:getMessage	()Ljava/lang/String;
      //   414: invokespecial 158	a/j/b/a/c/g/k:<init>	(Ljava/lang/String;)V
      //   417: astore_1
      //   418: iload 6
      //   420: istore 4
      //   422: aload_1
      //   423: aload_0
      //   424: putfield 120	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
      //   427: iload 6
      //   429: istore 4
      //   431: ldc 80
      //   433: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   436: iload 6
      //   438: istore 4
      //   440: aload_1
      //   441: athrow
      //   442: iload_3
      //   443: istore 7
      //   445: iload_3
      //   446: iconst_4
      //   447: iand
      //   448: iconst_4
      //   449: if_icmpeq +28 -> 477
      //   452: iload_3
      //   453: istore 5
      //   455: iload_3
      //   456: istore 4
      //   458: iload_3
      //   459: istore 6
      //   461: aload_0
      //   462: new 101	java/util/ArrayList
      //   465: dup
      //   466: invokespecial 102	java/util/ArrayList:<init>	()V
      //   469: putfield 130	a/j/b/a/c/e/a$s:Clm	Ljava/util/List;
      //   472: iload_3
      //   473: iconst_4
      //   474: ior
      //   475: istore 7
      //   477: iload 7
      //   479: istore 5
      //   481: iload 7
      //   483: istore 4
      //   485: iload 7
      //   487: istore 6
      //   489: aload_0
      //   490: getfield 130	a/j/b/a/c/e/a$s:Clm	Ljava/util/List;
      //   493: aload_1
      //   494: getstatic 161	a/j/b/a/c/e/a$ab:Ckq	La/j/b/a/c/g/s;
      //   497: aload_2
      //   498: invokevirtual 110	a/j/b/a/c/g/e:a	(La/j/b/a/c/g/s;La/j/b/a/c/g/g;)La/j/b/a/c/g/q;
      //   501: invokeinterface 116 2 0
      //   506: pop
      //   507: iload 7
      //   509: istore_3
      //   510: goto -469 -> 41
      //   513: iload_3
      //   514: istore 5
      //   516: iload_3
      //   517: istore 4
      //   519: iload_3
      //   520: istore 6
      //   522: aload_0
      //   523: getfield 163	a/j/b/a/c/e/a$s:Ckr	I
      //   526: iconst_1
      //   527: iand
      //   528: iconst_1
      //   529: if_icmpne +381 -> 910
      //   532: iload_3
      //   533: istore 5
      //   535: iload_3
      //   536: istore 4
      //   538: iload_3
      //   539: istore 6
      //   541: aload_0
      //   542: getfield 165	a/j/b/a/c/e/a$s:Clq	La/j/b/a/c/e/a$ag;
      //   545: invokestatic 171	a/j/b/a/c/e/a$ag:d	(La/j/b/a/c/e/a$ag;)La/j/b/a/c/e/a$ag$a;
      //   548: astore 9
      //   550: iload_3
      //   551: istore 5
      //   553: iload_3
      //   554: istore 4
      //   556: iload_3
      //   557: istore 6
      //   559: aload_0
      //   560: aload_1
      //   561: getstatic 172	a/j/b/a/c/e/a$ag:Ckq	La/j/b/a/c/g/s;
      //   564: aload_2
      //   565: invokevirtual 110	a/j/b/a/c/g/e:a	(La/j/b/a/c/g/s;La/j/b/a/c/g/g;)La/j/b/a/c/g/q;
      //   568: checkcast 167	a/j/b/a/c/e/a$ag
      //   571: putfield 165	a/j/b/a/c/e/a$s:Clq	La/j/b/a/c/e/a$ag;
      //   574: aload 9
      //   576: ifnull +40 -> 616
      //   579: iload_3
      //   580: istore 5
      //   582: iload_3
      //   583: istore 4
      //   585: iload_3
      //   586: istore 6
      //   588: aload 9
      //   590: aload_0
      //   591: getfield 165	a/j/b/a/c/e/a$s:Clq	La/j/b/a/c/e/a$ag;
      //   594: invokevirtual 177	a/j/b/a/c/e/a$ag$a:g	(La/j/b/a/c/e/a$ag;)La/j/b/a/c/e/a$ag$a;
      //   597: pop
      //   598: iload_3
      //   599: istore 5
      //   601: iload_3
      //   602: istore 4
      //   604: iload_3
      //   605: istore 6
      //   607: aload_0
      //   608: aload 9
      //   610: invokevirtual 181	a/j/b/a/c/e/a$ag$a:eko	()La/j/b/a/c/e/a$ag;
      //   613: putfield 165	a/j/b/a/c/e/a$s:Clq	La/j/b/a/c/e/a$ag;
      //   616: iload_3
      //   617: istore 5
      //   619: iload_3
      //   620: istore 4
      //   622: iload_3
      //   623: istore 6
      //   625: aload_0
      //   626: aload_0
      //   627: getfield 163	a/j/b/a/c/e/a$s:Ckr	I
      //   630: iconst_1
      //   631: ior
      //   632: putfield 163	a/j/b/a/c/e/a$s:Ckr	I
      //   635: goto -594 -> 41
      //   638: iload_3
      //   639: istore 5
      //   641: iload_3
      //   642: istore 4
      //   644: iload_3
      //   645: istore 6
      //   647: aload_0
      //   648: getfield 163	a/j/b/a/c/e/a$s:Ckr	I
      //   651: iconst_2
      //   652: iand
      //   653: iconst_2
      //   654: if_icmpne +250 -> 904
      //   657: iload_3
      //   658: istore 5
      //   660: iload_3
      //   661: istore 4
      //   663: iload_3
      //   664: istore 6
      //   666: aload_0
      //   667: getfield 183	a/j/b/a/c/e/a$s:Cls	La/j/b/a/c/e/a$am;
      //   670: invokestatic 189	a/j/b/a/c/e/a$am:c	(La/j/b/a/c/e/a$am;)La/j/b/a/c/e/a$am$a;
      //   673: astore 9
      //   675: iload_3
      //   676: istore 5
      //   678: iload_3
      //   679: istore 4
      //   681: iload_3
      //   682: istore 6
      //   684: aload_0
      //   685: aload_1
      //   686: getstatic 190	a/j/b/a/c/e/a$am:Ckq	La/j/b/a/c/g/s;
      //   689: aload_2
      //   690: invokevirtual 110	a/j/b/a/c/g/e:a	(La/j/b/a/c/g/s;La/j/b/a/c/g/g;)La/j/b/a/c/g/q;
      //   693: checkcast 185	a/j/b/a/c/e/a$am
      //   696: putfield 183	a/j/b/a/c/e/a$s:Cls	La/j/b/a/c/e/a$am;
      //   699: aload 9
      //   701: ifnull +40 -> 741
      //   704: iload_3
      //   705: istore 5
      //   707: iload_3
      //   708: istore 4
      //   710: iload_3
      //   711: istore 6
      //   713: aload 9
      //   715: aload_0
      //   716: getfield 183	a/j/b/a/c/e/a$s:Cls	La/j/b/a/c/e/a$am;
      //   719: invokevirtual 195	a/j/b/a/c/e/a$am$a:f	(La/j/b/a/c/e/a$am;)La/j/b/a/c/e/a$am$a;
      //   722: pop
      //   723: iload_3
      //   724: istore 5
      //   726: iload_3
      //   727: istore 4
      //   729: iload_3
      //   730: istore 6
      //   732: aload_0
      //   733: aload 9
      //   735: invokevirtual 199	a/j/b/a/c/e/a$am$a:ekJ	()La/j/b/a/c/e/a$am;
      //   738: putfield 183	a/j/b/a/c/e/a$s:Cls	La/j/b/a/c/e/a$am;
      //   741: iload_3
      //   742: istore 5
      //   744: iload_3
      //   745: istore 4
      //   747: iload_3
      //   748: istore 6
      //   750: aload_0
      //   751: aload_0
      //   752: getfield 163	a/j/b/a/c/e/a$s:Ckr	I
      //   755: iconst_2
      //   756: ior
      //   757: putfield 163	a/j/b/a/c/e/a$s:Ckr	I
      //   760: goto -719 -> 41
      //   763: iload_3
      //   764: iconst_1
      //   765: iand
      //   766: iconst_1
      //   767: if_icmpne +14 -> 781
      //   770: aload_0
      //   771: aload_0
      //   772: getfield 104	a/j/b/a/c/e/a$s:Clk	Ljava/util/List;
      //   775: invokestatic 126	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   778: putfield 104	a/j/b/a/c/e/a$s:Clk	Ljava/util/List;
      //   781: iload_3
      //   782: iconst_2
      //   783: iand
      //   784: iconst_2
      //   785: if_icmpne +14 -> 799
      //   788: aload_0
      //   789: aload_0
      //   790: getfield 128	a/j/b/a/c/e/a$s:Cll	Ljava/util/List;
      //   793: invokestatic 126	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   796: putfield 128	a/j/b/a/c/e/a$s:Cll	Ljava/util/List;
      //   799: iload_3
      //   800: iconst_4
      //   801: iand
      //   802: iconst_4
      //   803: if_icmpne +14 -> 817
      //   806: aload_0
      //   807: aload_0
      //   808: getfield 130	a/j/b/a/c/e/a$s:Clm	Ljava/util/List;
      //   811: invokestatic 126	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   814: putfield 130	a/j/b/a/c/e/a$s:Clm	Ljava/util/List;
      //   817: aload 11
      //   819: invokevirtual 133	a/j/b/a/c/g/f:flush	()V
      //   822: aload_0
      //   823: aload 10
      //   825: invokevirtual 139	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
      //   828: putfield 74	a/j/b/a/c/e/a$s:Ckp	La/j/b/a/c/g/d;
      //   831: aload_0
      //   832: getfield 143	a/j/b/a/c/g/i$c:Crw	La/j/b/a/c/g/h;
      //   835: invokevirtual 148	a/j/b/a/c/g/h:emF	()V
      //   838: ldc 80
      //   840: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   843: return
      //   844: astore_1
      //   845: aload_0
      //   846: aload 10
      //   848: invokevirtual 139	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
      //   851: putfield 74	a/j/b/a/c/e/a$s:Ckp	La/j/b/a/c/g/d;
      //   854: goto -23 -> 831
      //   857: astore_1
      //   858: aload_0
      //   859: aload 10
      //   861: invokevirtual 139	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
      //   864: putfield 74	a/j/b/a/c/e/a$s:Ckp	La/j/b/a/c/g/d;
      //   867: ldc 80
      //   869: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   872: aload_1
      //   873: athrow
      //   874: astore_2
      //   875: aload_0
      //   876: aload 10
      //   878: invokevirtual 139	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
      //   881: putfield 74	a/j/b/a/c/e/a$s:Ckp	La/j/b/a/c/g/d;
      //   884: goto -568 -> 316
      //   887: astore_1
      //   888: aload_0
      //   889: aload 10
      //   891: invokevirtual 139	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
      //   894: putfield 74	a/j/b/a/c/e/a$s:Ckp	La/j/b/a/c/g/d;
      //   897: ldc 80
      //   899: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   902: aload_1
      //   903: athrow
      //   904: aconst_null
      //   905: astore 9
      //   907: goto -232 -> 675
      //   910: aconst_null
      //   911: astore 9
      //   913: goto -363 -> 550
      //   916: goto -796 -> 120
      //   919: iconst_1
      //   920: istore 8
      //   922: goto -881 -> 41
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	925	0	this	s
      //   0	925	1	parame	a.j.b.a.c.g.e
      //   0	925	2	paramg	g
      //   24	778	3	i	int
      //   50	696	4	j	int
      //   47	696	5	k	int
      //   53	696	6	m	int
      //   59	449	7	n	int
      //   39	882	8	i1	int
      //   548	364	9	localObject	Object
      //   28	862	10	localb	a.j.b.a.c.g.d.b
      //   36	782	11	localf	f
      // Exception table:
      //   from	to	target	type
      //   55	61	219	a/j/b/a/c/g/k
      //   129	142	219	a/j/b/a/c/g/k
      //   167	178	219	a/j/b/a/c/g/k
      //   195	213	219	a/j/b/a/c/g/k
      //   349	360	219	a/j/b/a/c/g/k
      //   377	395	219	a/j/b/a/c/g/k
      //   461	472	219	a/j/b/a/c/g/k
      //   489	507	219	a/j/b/a/c/g/k
      //   522	532	219	a/j/b/a/c/g/k
      //   541	550	219	a/j/b/a/c/g/k
      //   559	574	219	a/j/b/a/c/g/k
      //   588	598	219	a/j/b/a/c/g/k
      //   607	616	219	a/j/b/a/c/g/k
      //   625	635	219	a/j/b/a/c/g/k
      //   647	657	219	a/j/b/a/c/g/k
      //   666	675	219	a/j/b/a/c/g/k
      //   684	699	219	a/j/b/a/c/g/k
      //   713	723	219	a/j/b/a/c/g/k
      //   732	741	219	a/j/b/a/c/g/k
      //   750	760	219	a/j/b/a/c/g/k
      //   55	61	244	finally
      //   129	142	244	finally
      //   167	178	244	finally
      //   195	213	244	finally
      //   224	229	244	finally
      //   233	238	244	finally
      //   242	244	244	finally
      //   349	360	244	finally
      //   377	395	244	finally
      //   406	418	244	finally
      //   422	427	244	finally
      //   431	436	244	finally
      //   440	442	244	finally
      //   461	472	244	finally
      //   489	507	244	finally
      //   522	532	244	finally
      //   541	550	244	finally
      //   559	574	244	finally
      //   588	598	244	finally
      //   607	616	244	finally
      //   625	635	244	finally
      //   647	657	244	finally
      //   666	675	244	finally
      //   684	699	244	finally
      //   713	723	244	finally
      //   732	741	244	finally
      //   750	760	244	finally
      //   55	61	401	java/io/IOException
      //   129	142	401	java/io/IOException
      //   167	178	401	java/io/IOException
      //   195	213	401	java/io/IOException
      //   349	360	401	java/io/IOException
      //   377	395	401	java/io/IOException
      //   461	472	401	java/io/IOException
      //   489	507	401	java/io/IOException
      //   522	532	401	java/io/IOException
      //   541	550	401	java/io/IOException
      //   559	574	401	java/io/IOException
      //   588	598	401	java/io/IOException
      //   607	616	401	java/io/IOException
      //   625	635	401	java/io/IOException
      //   647	657	401	java/io/IOException
      //   666	675	401	java/io/IOException
      //   684	699	401	java/io/IOException
      //   713	723	401	java/io/IOException
      //   732	741	401	java/io/IOException
      //   750	760	401	java/io/IOException
      //   817	822	844	java/io/IOException
      //   817	822	857	finally
      //   302	307	874	java/io/IOException
      //   302	307	887	finally
    }
    
    private s(i.b<s, ?> paramb)
    {
      super();
      this.Ckp = paramb.Ckp;
    }
    
    public static s c(InputStream paramInputStream, g paramg)
    {
      AppMethodBeat.i(120705);
      paramInputStream = (s)Ckq.j(paramInputStream, paramg);
      AppMethodBeat.o(120705);
      return paramInputStream;
    }
    
    private void egZ()
    {
      AppMethodBeat.i(120701);
      this.Clk = Collections.emptyList();
      this.Cll = Collections.emptyList();
      this.Clm = Collections.emptyList();
      this.Clq = a.ag.ekl();
      this.Cls = a.am.ekH();
      AppMethodBeat.o(120701);
    }
    
    public static s eiT()
    {
      return Cmw;
    }
    
    public final void a(f paramf)
    {
      int k = 0;
      AppMethodBeat.i(120703);
      sy();
      i.c.a locala = emM();
      int i = 0;
      while (i < this.Clk.size())
      {
        paramf.a(3, (q)this.Clk.get(i));
        i += 1;
      }
      i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= this.Cll.size()) {
          break;
        }
        paramf.a(4, (q)this.Cll.get(i));
        i += 1;
      }
      while (j < this.Clm.size())
      {
        paramf.a(5, (q)this.Clm.get(j));
        j += 1;
      }
      if ((this.Ckr & 0x1) == 1) {
        paramf.a(30, this.Clq);
      }
      if ((this.Ckr & 0x2) == 2) {
        paramf.a(32, this.Cls);
      }
      locala.b(200, paramf);
      paramf.d(this.Ckp);
      AppMethodBeat.o(120703);
    }
    
    public final s<s> egX()
    {
      return Ckq;
    }
    
    public final boolean ehK()
    {
      return (this.Ckr & 0x1) == 1;
    }
    
    public final boolean ehL()
    {
      return (this.Ckr & 0x2) == 2;
    }
    
    public final boolean isInitialized()
    {
      AppMethodBeat.i(120702);
      int i = this.Cku;
      if (i == 1)
      {
        AppMethodBeat.o(120702);
        return true;
      }
      if (i == 0)
      {
        AppMethodBeat.o(120702);
        return false;
      }
      i = 0;
      while (i < this.Clk.size())
      {
        if (!((a.o)this.Clk.get(i)).isInitialized())
        {
          this.Cku = 0;
          AppMethodBeat.o(120702);
          return false;
        }
        i += 1;
      }
      i = 0;
      while (i < this.Cll.size())
      {
        if (!((a.u)this.Cll.get(i)).isInitialized())
        {
          this.Cku = 0;
          AppMethodBeat.o(120702);
          return false;
        }
        i += 1;
      }
      i = 0;
      while (i < this.Clm.size())
      {
        if (!((a.ab)this.Clm.get(i)).isInitialized())
        {
          this.Cku = 0;
          AppMethodBeat.o(120702);
          return false;
        }
        i += 1;
      }
      if ((ehK()) && (!this.Clq.isInitialized()))
      {
        this.Cku = 0;
        AppMethodBeat.o(120702);
        return false;
      }
      if (!this.Crw.isInitialized())
      {
        this.Cku = 0;
        AppMethodBeat.o(120702);
        return false;
      }
      this.Cku = 1;
      AppMethodBeat.o(120702);
      return true;
    }
    
    public final int sy()
    {
      int n = 0;
      AppMethodBeat.i(120704);
      int i = this.Ckv;
      if (i != -1)
      {
        AppMethodBeat.o(120704);
        return i;
      }
      int j = 0;
      i = 0;
      while (j < this.Clk.size())
      {
        i += f.c(3, (q)this.Clk.get(j));
        j += 1;
      }
      int k = 0;
      int m;
      for (;;)
      {
        m = n;
        j = i;
        if (k >= this.Cll.size()) {
          break;
        }
        i += f.c(4, (q)this.Cll.get(k));
        k += 1;
      }
      while (m < this.Clm.size())
      {
        j += f.c(5, (q)this.Clm.get(m));
        m += 1;
      }
      i = j;
      if ((this.Ckr & 0x1) == 1) {
        i = j + f.c(30, this.Clq);
      }
      j = i;
      if ((this.Ckr & 0x2) == 2) {
        j = i + f.c(32, this.Cls);
      }
      i = this.Crw.sy() + j + this.Ckp.size();
      this.Ckv = i;
      AppMethodBeat.o(120704);
      return i;
    }
    
    public static final class a
      extends i.b<a.s, a>
      implements a.t
    {
      private int Ckr;
      private List<a.o> Clk;
      private List<a.u> Cll;
      private List<a.ab> Clm;
      private a.ag Clq;
      private a.am Cls;
      
      private a()
      {
        AppMethodBeat.i(120678);
        this.Clk = Collections.emptyList();
        this.Cll = Collections.emptyList();
        this.Clm = Collections.emptyList();
        this.Clq = a.ag.ekl();
        this.Cls = a.am.ekH();
        AppMethodBeat.o(120678);
      }
      
      private a b(a.am paramam)
      {
        AppMethodBeat.i(120688);
        if (((this.Ckr & 0x10) == 16) && (this.Cls != a.am.ekH())) {}
        for (this.Cls = a.am.c(this.Cls).f(paramam).ekJ();; this.Cls = paramam)
        {
          this.Ckr |= 0x10;
          AppMethodBeat.o(120688);
          return this;
        }
      }
      
      private a c(a.ag paramag)
      {
        AppMethodBeat.i(120687);
        if (((this.Ckr & 0x8) == 8) && (this.Clq != a.ag.ekl())) {}
        for (this.Clq = a.ag.d(this.Clq).g(paramag).eko();; this.Clq = paramag)
        {
          this.Ckr |= 0x8;
          AppMethodBeat.o(120687);
          return this;
        }
      }
      
      private void ehT()
      {
        AppMethodBeat.i(120684);
        if ((this.Ckr & 0x1) != 1)
        {
          this.Clk = new ArrayList(this.Clk);
          this.Ckr |= 0x1;
        }
        AppMethodBeat.o(120684);
      }
      
      private void ehU()
      {
        AppMethodBeat.i(120685);
        if ((this.Ckr & 0x2) != 2)
        {
          this.Cll = new ArrayList(this.Cll);
          this.Ckr |= 0x2;
        }
        AppMethodBeat.o(120685);
      }
      
      private void ehV()
      {
        AppMethodBeat.i(120686);
        if ((this.Ckr & 0x4) != 4)
        {
          this.Clm = new ArrayList(this.Clm);
          this.Ckr |= 0x4;
        }
        AppMethodBeat.o(120686);
      }
      
      private a eiU()
      {
        AppMethodBeat.i(120679);
        a locala = new a().e(eiV());
        AppMethodBeat.o(120679);
        return locala;
      }
      
      private a.s eiV()
      {
        int i = 1;
        AppMethodBeat.i(120680);
        a.s locals = new a.s(this, (byte)0);
        int k = this.Ckr;
        if ((this.Ckr & 0x1) == 1)
        {
          this.Clk = Collections.unmodifiableList(this.Clk);
          this.Ckr &= 0xFFFFFFFE;
        }
        a.s.a(locals, this.Clk);
        if ((this.Ckr & 0x2) == 2)
        {
          this.Cll = Collections.unmodifiableList(this.Cll);
          this.Ckr &= 0xFFFFFFFD;
        }
        a.s.b(locals, this.Cll);
        if ((this.Ckr & 0x4) == 4)
        {
          this.Clm = Collections.unmodifiableList(this.Clm);
          this.Ckr &= 0xFFFFFFFB;
        }
        a.s.c(locals, this.Clm);
        if ((k & 0x8) == 8) {}
        for (;;)
        {
          a.s.a(locals, this.Clq);
          int j = i;
          if ((k & 0x10) == 16) {
            j = i | 0x2;
          }
          a.s.a(locals, this.Cls);
          a.s.a(locals, j);
          AppMethodBeat.o(120680);
          return locals;
          i = 0;
        }
      }
      
      /* Error */
      private a n(a.j.b.a.c.g.e parame, g paramg)
      {
        // Byte code:
        //   0: ldc 154
        //   2: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aconst_null
        //   6: astore_3
        //   7: getstatic 158	a/j/b/a/c/e/a$s:Ckq	La/j/b/a/c/g/s;
        //   10: aload_1
        //   11: aload_2
        //   12: invokeinterface 163 3 0
        //   17: checkcast 9	a/j/b/a/c/e/a$s
        //   20: astore_1
        //   21: aload_0
        //   22: aload_1
        //   23: invokevirtual 123	a/j/b/a/c/e/a$s$a:e	(La/j/b/a/c/e/a$s;)La/j/b/a/c/e/a$s$a;
        //   26: pop
        //   27: ldc 154
        //   29: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   32: aload_0
        //   33: areturn
        //   34: astore_1
        //   35: aload_1
        //   36: getfield 167	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
        //   39: checkcast 9	a/j/b/a/c/e/a$s
        //   42: astore_2
        //   43: ldc 154
        //   45: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   48: aload_1
        //   49: athrow
        //   50: astore_1
        //   51: aload_2
        //   52: ifnull +9 -> 61
        //   55: aload_0
        //   56: aload_2
        //   57: invokevirtual 123	a/j/b/a/c/e/a$s$a:e	(La/j/b/a/c/e/a$s;)La/j/b/a/c/e/a$s$a;
        //   60: pop
        //   61: ldc 154
        //   63: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   66: aload_1
        //   67: athrow
        //   68: astore_1
        //   69: aload_3
        //   70: astore_2
        //   71: goto -20 -> 51
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	74	0	this	a
        //   0	74	1	parame	a.j.b.a.c.g.e
        //   0	74	2	paramg	g
        //   6	64	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   7	21	34	a/j/b/a/c/g/k
        //   43	50	50	finally
        //   7	21	68	finally
        //   35	43	68	finally
      }
      
      public final a e(a.s params)
      {
        AppMethodBeat.i(120681);
        if (params == a.s.eiT())
        {
          AppMethodBeat.o(120681);
          return this;
        }
        if (!a.s.a(params).isEmpty())
        {
          if (this.Clk.isEmpty())
          {
            this.Clk = a.s.a(params);
            this.Ckr &= 0xFFFFFFFE;
          }
        }
        else
        {
          if (!a.s.b(params).isEmpty())
          {
            if (!this.Cll.isEmpty()) {
              break label228;
            }
            this.Cll = a.s.b(params);
            this.Ckr &= 0xFFFFFFFD;
          }
          label105:
          if (!a.s.c(params).isEmpty())
          {
            if (!this.Clm.isEmpty()) {
              break label249;
            }
            this.Clm = a.s.c(params);
            this.Ckr &= 0xFFFFFFFB;
          }
        }
        for (;;)
        {
          if (params.ehK()) {
            c(params.Clq);
          }
          if (params.ehL()) {
            b(params.Cls);
          }
          a(params);
          this.Ckp = this.Ckp.a(a.s.d(params));
          AppMethodBeat.o(120681);
          return this;
          ehT();
          this.Clk.addAll(a.s.a(params));
          break;
          label228:
          ehU();
          this.Cll.addAll(a.s.b(params));
          break label105;
          label249:
          ehV();
          this.Clm.addAll(a.s.c(params));
        }
      }
      
      public final boolean isInitialized()
      {
        AppMethodBeat.i(120682);
        int i = 0;
        while (i < this.Clk.size())
        {
          if (!((a.o)this.Clk.get(i)).isInitialized())
          {
            AppMethodBeat.o(120682);
            return false;
          }
          i += 1;
        }
        i = 0;
        while (i < this.Cll.size())
        {
          if (!((a.u)this.Cll.get(i)).isInitialized())
          {
            AppMethodBeat.o(120682);
            return false;
          }
          i += 1;
        }
        i = 0;
        while (i < this.Clm.size())
        {
          if (!((a.ab)this.Clm.get(i)).isInitialized())
          {
            AppMethodBeat.o(120682);
            return false;
          }
          i += 1;
        }
        if ((this.Ckr & 0x8) == 8) {}
        for (i = 1; (i != 0) && (!this.Clq.isInitialized()); i = 0)
        {
          AppMethodBeat.o(120682);
          return false;
        }
        if (!this.Crw.isInitialized())
        {
          AppMethodBeat.o(120682);
          return false;
        }
        AppMethodBeat.o(120682);
        return true;
      }
    }
  }
  
  public static final class u
    extends i.c<u>
    implements a.v
  {
    public static s<u> Ckq;
    private static final u Cmx;
    public int CkK;
    private final d Ckp;
    private int Ckr;
    private byte Cku = -1;
    private int Ckv = -1;
    public int ClT;
    public List<a.ae> Cld;
    public List<Integer> Clr;
    public int CmA;
    public int Cmg;
    public a.aa Cmh;
    public int Cmi;
    public a.aa Cmj;
    public int Cmk;
    public a.ai Cmy;
    public int Cmz;
    
    static
    {
      AppMethodBeat.i(120739);
      Ckq = new a.u.1();
      u localu = new u();
      Cmx = localu;
      localu.egZ();
      AppMethodBeat.o(120739);
    }
    
    private u()
    {
      this.Ckp = d.Cre;
    }
    
    /* Error */
    private u(a.j.b.a.c.g.e parame, g paramg)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 69	a/j/b/a/c/g/i$c:<init>	()V
      //   4: ldc 86
      //   6: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   9: aload_0
      //   10: iconst_m1
      //   11: putfield 71	a/j/b/a/c/e/a$u:Cku	B
      //   14: aload_0
      //   15: iconst_m1
      //   16: putfield 73	a/j/b/a/c/e/a$u:Ckv	I
      //   19: aload_0
      //   20: invokespecial 64	a/j/b/a/c/e/a$u:egZ	()V
      //   23: iconst_0
      //   24: istore_3
      //   25: invokestatic 90	a/j/b/a/c/g/d:emp	()La/j/b/a/c/g/d$b;
      //   28: astore 10
      //   30: aload 10
      //   32: iconst_1
      //   33: invokestatic 96	a/j/b/a/c/g/f:e	(Ljava/io/OutputStream;I)La/j/b/a/c/g/f;
      //   36: astore 11
      //   38: iconst_0
      //   39: istore 8
      //   41: iload 8
      //   43: ifne +1231 -> 1274
      //   46: iload_3
      //   47: istore 5
      //   49: iload_3
      //   50: istore 6
      //   52: iload_3
      //   53: istore 7
      //   55: aload_1
      //   56: invokevirtual 102	a/j/b/a/c/g/e:sk	()I
      //   59: istore 4
      //   61: iload 4
      //   63: lookupswitch	default:+1375->1438, 0:+1378->1441, 8:+149->212, 16:+285->348, 26:+365->428, 34:+493->556, 42:+567->630, 50:+695->758, 56:+826->889, 64:+867->930, 72:+908->971, 80:+948->1011, 88:+988->1051, 248:+1027->1090, 250:+1103->1166
      //   185: istore 5
      //   187: iload_3
      //   188: istore 6
      //   190: iload_3
      //   191: istore 7
      //   193: aload_0
      //   194: aload_1
      //   195: aload 11
      //   197: aload_2
      //   198: iload 4
      //   200: invokevirtual 105	a/j/b/a/c/e/a$u:a	(La/j/b/a/c/g/e;La/j/b/a/c/g/f;La/j/b/a/c/g/g;I)Z
      //   203: ifne +1232 -> 1435
      //   206: iconst_1
      //   207: istore 8
      //   209: goto -168 -> 41
      //   212: iload_3
      //   213: istore 5
      //   215: iload_3
      //   216: istore 6
      //   218: iload_3
      //   219: istore 7
      //   221: aload_0
      //   222: aload_0
      //   223: getfield 107	a/j/b/a/c/e/a$u:Ckr	I
      //   226: iconst_2
      //   227: ior
      //   228: putfield 107	a/j/b/a/c/e/a$u:Ckr	I
      //   231: iload_3
      //   232: istore 5
      //   234: iload_3
      //   235: istore 6
      //   237: iload_3
      //   238: istore 7
      //   240: aload_0
      //   241: aload_1
      //   242: invokevirtual 110	a/j/b/a/c/g/e:sl	()I
      //   245: putfield 112	a/j/b/a/c/e/a$u:Cmg	I
      //   248: goto -207 -> 41
      //   251: astore_1
      //   252: iload 5
      //   254: istore 4
      //   256: iload 4
      //   258: istore_3
      //   259: aload_1
      //   260: aload_0
      //   261: putfield 116	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
      //   264: iload 4
      //   266: istore_3
      //   267: ldc 86
      //   269: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   272: iload 4
      //   274: istore_3
      //   275: aload_1
      //   276: athrow
      //   277: astore_1
      //   278: iload_3
      //   279: bipush 32
      //   281: iand
      //   282: bipush 32
      //   284: if_icmpne +14 -> 298
      //   287: aload_0
      //   288: aload_0
      //   289: getfield 118	a/j/b/a/c/e/a$u:Cld	Ljava/util/List;
      //   292: invokestatic 124	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   295: putfield 118	a/j/b/a/c/e/a$u:Cld	Ljava/util/List;
      //   298: iload_3
      //   299: sipush 2048
      //   302: iand
      //   303: sipush 2048
      //   306: if_icmpne +14 -> 320
      //   309: aload_0
      //   310: aload_0
      //   311: getfield 126	a/j/b/a/c/e/a$u:Clr	Ljava/util/List;
      //   314: invokestatic 124	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   317: putfield 126	a/j/b/a/c/e/a$u:Clr	Ljava/util/List;
      //   320: aload 11
      //   322: invokevirtual 129	a/j/b/a/c/g/f:flush	()V
      //   325: aload_0
      //   326: aload 10
      //   328: invokevirtual 135	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
      //   331: putfield 80	a/j/b/a/c/e/a$u:Ckp	La/j/b/a/c/g/d;
      //   334: aload_0
      //   335: getfield 139	a/j/b/a/c/g/i$c:Crw	La/j/b/a/c/g/h;
      //   338: invokevirtual 144	a/j/b/a/c/g/h:emF	()V
      //   341: ldc 86
      //   343: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   346: aload_1
      //   347: athrow
      //   348: iload_3
      //   349: istore 5
      //   351: iload_3
      //   352: istore 6
      //   354: iload_3
      //   355: istore 7
      //   357: aload_0
      //   358: aload_0
      //   359: getfield 107	a/j/b/a/c/e/a$u:Ckr	I
      //   362: iconst_4
      //   363: ior
      //   364: putfield 107	a/j/b/a/c/e/a$u:Ckr	I
      //   367: iload_3
      //   368: istore 5
      //   370: iload_3
      //   371: istore 6
      //   373: iload_3
      //   374: istore 7
      //   376: aload_0
      //   377: aload_1
      //   378: invokevirtual 110	a/j/b/a/c/g/e:sl	()I
      //   381: putfield 146	a/j/b/a/c/e/a$u:ClT	I
      //   384: goto -343 -> 41
      //   387: astore_1
      //   388: iload 6
      //   390: istore 4
      //   392: iload 4
      //   394: istore_3
      //   395: new 83	a/j/b/a/c/g/k
      //   398: dup
      //   399: aload_1
      //   400: invokevirtual 150	java/io/IOException:getMessage	()Ljava/lang/String;
      //   403: invokespecial 153	a/j/b/a/c/g/k:<init>	(Ljava/lang/String;)V
      //   406: astore_1
      //   407: iload 4
      //   409: istore_3
      //   410: aload_1
      //   411: aload_0
      //   412: putfield 116	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
      //   415: iload 4
      //   417: istore_3
      //   418: ldc 86
      //   420: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   423: iload 4
      //   425: istore_3
      //   426: aload_1
      //   427: athrow
      //   428: iload_3
      //   429: istore 5
      //   431: iload_3
      //   432: istore 6
      //   434: iload_3
      //   435: istore 7
      //   437: aload_0
      //   438: getfield 107	a/j/b/a/c/e/a$u:Ckr	I
      //   441: bipush 8
      //   443: iand
      //   444: bipush 8
      //   446: if_icmpne +983 -> 1429
      //   449: iload_3
      //   450: istore 5
      //   452: iload_3
      //   453: istore 6
      //   455: iload_3
      //   456: istore 7
      //   458: aload_0
      //   459: getfield 155	a/j/b/a/c/e/a$u:Cmh	La/j/b/a/c/e/a$aa;
      //   462: invokestatic 161	a/j/b/a/c/e/a$aa:f	(La/j/b/a/c/e/a$aa;)La/j/b/a/c/e/a$aa$c;
      //   465: astore 9
      //   467: iload_3
      //   468: istore 5
      //   470: iload_3
      //   471: istore 6
      //   473: iload_3
      //   474: istore 7
      //   476: aload_0
      //   477: aload_1
      //   478: getstatic 162	a/j/b/a/c/e/a$aa:Ckq	La/j/b/a/c/g/s;
      //   481: aload_2
      //   482: invokevirtual 165	a/j/b/a/c/g/e:a	(La/j/b/a/c/g/s;La/j/b/a/c/g/g;)La/j/b/a/c/g/q;
      //   485: checkcast 157	a/j/b/a/c/e/a$aa
      //   488: putfield 155	a/j/b/a/c/e/a$u:Cmh	La/j/b/a/c/e/a$aa;
      //   491: aload 9
      //   493: ifnull +40 -> 533
      //   496: iload_3
      //   497: istore 5
      //   499: iload_3
      //   500: istore 6
      //   502: iload_3
      //   503: istore 7
      //   505: aload 9
      //   507: aload_0
      //   508: getfield 155	a/j/b/a/c/e/a$u:Cmh	La/j/b/a/c/e/a$aa;
      //   511: invokevirtual 170	a/j/b/a/c/e/a$aa$c:j	(La/j/b/a/c/e/a$aa;)La/j/b/a/c/e/a$aa$c;
      //   514: pop
      //   515: iload_3
      //   516: istore 5
      //   518: iload_3
      //   519: istore 6
      //   521: iload_3
      //   522: istore 7
      //   524: aload_0
      //   525: aload 9
      //   527: invokevirtual 174	a/j/b/a/c/e/a$aa$c:ejS	()La/j/b/a/c/e/a$aa;
      //   530: putfield 155	a/j/b/a/c/e/a$u:Cmh	La/j/b/a/c/e/a$aa;
      //   533: iload_3
      //   534: istore 5
      //   536: iload_3
      //   537: istore 6
      //   539: iload_3
      //   540: istore 7
      //   542: aload_0
      //   543: aload_0
      //   544: getfield 107	a/j/b/a/c/e/a$u:Ckr	I
      //   547: bipush 8
      //   549: ior
      //   550: putfield 107	a/j/b/a/c/e/a$u:Ckr	I
      //   553: goto -512 -> 41
      //   556: iload_3
      //   557: istore 4
      //   559: iload_3
      //   560: bipush 32
      //   562: iand
      //   563: bipush 32
      //   565: if_icmpeq +29 -> 594
      //   568: iload_3
      //   569: istore 5
      //   571: iload_3
      //   572: istore 6
      //   574: iload_3
      //   575: istore 7
      //   577: aload_0
      //   578: new 176	java/util/ArrayList
      //   581: dup
      //   582: invokespecial 177	java/util/ArrayList:<init>	()V
      //   585: putfield 118	a/j/b/a/c/e/a$u:Cld	Ljava/util/List;
      //   588: iload_3
      //   589: bipush 32
      //   591: ior
      //   592: istore 4
      //   594: iload 4
      //   596: istore 5
      //   598: iload 4
      //   600: istore 6
      //   602: iload 4
      //   604: istore 7
      //   606: aload_0
      //   607: getfield 118	a/j/b/a/c/e/a$u:Cld	Ljava/util/List;
      //   610: aload_1
      //   611: getstatic 180	a/j/b/a/c/e/a$ae:Ckq	La/j/b/a/c/g/s;
      //   614: aload_2
      //   615: invokevirtual 165	a/j/b/a/c/g/e:a	(La/j/b/a/c/g/s;La/j/b/a/c/g/g;)La/j/b/a/c/g/q;
      //   618: invokeinterface 186 2 0
      //   623: pop
      //   624: iload 4
      //   626: istore_3
      //   627: goto -586 -> 41
      //   630: iload_3
      //   631: istore 5
      //   633: iload_3
      //   634: istore 6
      //   636: iload_3
      //   637: istore 7
      //   639: aload_0
      //   640: getfield 107	a/j/b/a/c/e/a$u:Ckr	I
      //   643: bipush 32
      //   645: iand
      //   646: bipush 32
      //   648: if_icmpne +775 -> 1423
      //   651: iload_3
      //   652: istore 5
      //   654: iload_3
      //   655: istore 6
      //   657: iload_3
      //   658: istore 7
      //   660: aload_0
      //   661: getfield 188	a/j/b/a/c/e/a$u:Cmj	La/j/b/a/c/e/a$aa;
      //   664: invokestatic 161	a/j/b/a/c/e/a$aa:f	(La/j/b/a/c/e/a$aa;)La/j/b/a/c/e/a$aa$c;
      //   667: astore 9
      //   669: iload_3
      //   670: istore 5
      //   672: iload_3
      //   673: istore 6
      //   675: iload_3
      //   676: istore 7
      //   678: aload_0
      //   679: aload_1
      //   680: getstatic 162	a/j/b/a/c/e/a$aa:Ckq	La/j/b/a/c/g/s;
      //   683: aload_2
      //   684: invokevirtual 165	a/j/b/a/c/g/e:a	(La/j/b/a/c/g/s;La/j/b/a/c/g/g;)La/j/b/a/c/g/q;
      //   687: checkcast 157	a/j/b/a/c/e/a$aa
      //   690: putfield 188	a/j/b/a/c/e/a$u:Cmj	La/j/b/a/c/e/a$aa;
      //   693: aload 9
      //   695: ifnull +40 -> 735
      //   698: iload_3
      //   699: istore 5
      //   701: iload_3
      //   702: istore 6
      //   704: iload_3
      //   705: istore 7
      //   707: aload 9
      //   709: aload_0
      //   710: getfield 188	a/j/b/a/c/e/a$u:Cmj	La/j/b/a/c/e/a$aa;
      //   713: invokevirtual 170	a/j/b/a/c/e/a$aa$c:j	(La/j/b/a/c/e/a$aa;)La/j/b/a/c/e/a$aa$c;
      //   716: pop
      //   717: iload_3
      //   718: istore 5
      //   720: iload_3
      //   721: istore 6
      //   723: iload_3
      //   724: istore 7
      //   726: aload_0
      //   727: aload 9
      //   729: invokevirtual 174	a/j/b/a/c/e/a$aa$c:ejS	()La/j/b/a/c/e/a$aa;
      //   732: putfield 188	a/j/b/a/c/e/a$u:Cmj	La/j/b/a/c/e/a$aa;
      //   735: iload_3
      //   736: istore 5
      //   738: iload_3
      //   739: istore 6
      //   741: iload_3
      //   742: istore 7
      //   744: aload_0
      //   745: aload_0
      //   746: getfield 107	a/j/b/a/c/e/a$u:Ckr	I
      //   749: bipush 32
      //   751: ior
      //   752: putfield 107	a/j/b/a/c/e/a$u:Ckr	I
      //   755: goto -714 -> 41
      //   758: iload_3
      //   759: istore 5
      //   761: iload_3
      //   762: istore 6
      //   764: iload_3
      //   765: istore 7
      //   767: aload_0
      //   768: getfield 107	a/j/b/a/c/e/a$u:Ckr	I
      //   771: sipush 128
      //   774: iand
      //   775: sipush 128
      //   778: if_icmpne +639 -> 1417
      //   781: iload_3
      //   782: istore 5
      //   784: iload_3
      //   785: istore 6
      //   787: iload_3
      //   788: istore 7
      //   790: aload_0
      //   791: getfield 190	a/j/b/a/c/e/a$u:Cmy	La/j/b/a/c/e/a$ai;
      //   794: invokestatic 196	a/j/b/a/c/e/a$ai:b	(La/j/b/a/c/e/a$ai;)La/j/b/a/c/e/a$ai$a;
      //   797: astore 9
      //   799: iload_3
      //   800: istore 5
      //   802: iload_3
      //   803: istore 6
      //   805: iload_3
      //   806: istore 7
      //   808: aload_0
      //   809: aload_1
      //   810: getstatic 197	a/j/b/a/c/e/a$ai:Ckq	La/j/b/a/c/g/s;
      //   813: aload_2
      //   814: invokevirtual 165	a/j/b/a/c/g/e:a	(La/j/b/a/c/g/s;La/j/b/a/c/g/g;)La/j/b/a/c/g/q;
      //   817: checkcast 192	a/j/b/a/c/e/a$ai
      //   820: putfield 190	a/j/b/a/c/e/a$u:Cmy	La/j/b/a/c/e/a$ai;
      //   823: aload 9
      //   825: ifnull +40 -> 865
      //   828: iload_3
      //   829: istore 5
      //   831: iload_3
      //   832: istore 6
      //   834: iload_3
      //   835: istore 7
      //   837: aload 9
      //   839: aload_0
      //   840: getfield 190	a/j/b/a/c/e/a$u:Cmy	La/j/b/a/c/e/a$ai;
      //   843: invokevirtual 202	a/j/b/a/c/e/a$ai$a:d	(La/j/b/a/c/e/a$ai;)La/j/b/a/c/e/a$ai$a;
      //   846: pop
      //   847: iload_3
      //   848: istore 5
      //   850: iload_3
      //   851: istore 6
      //   853: iload_3
      //   854: istore 7
      //   856: aload_0
      //   857: aload 9
      //   859: invokevirtual 206	a/j/b/a/c/e/a$ai$a:ekv	()La/j/b/a/c/e/a$ai;
      //   862: putfield 190	a/j/b/a/c/e/a$u:Cmy	La/j/b/a/c/e/a$ai;
      //   865: iload_3
      //   866: istore 5
      //   868: iload_3
      //   869: istore 6
      //   871: iload_3
      //   872: istore 7
      //   874: aload_0
      //   875: aload_0
      //   876: getfield 107	a/j/b/a/c/e/a$u:Ckr	I
      //   879: sipush 128
      //   882: ior
      //   883: putfield 107	a/j/b/a/c/e/a$u:Ckr	I
      //   886: goto -845 -> 41
      //   889: iload_3
      //   890: istore 5
      //   892: iload_3
      //   893: istore 6
      //   895: iload_3
      //   896: istore 7
      //   898: aload_0
      //   899: aload_0
      //   900: getfield 107	a/j/b/a/c/e/a$u:Ckr	I
      //   903: sipush 256
      //   906: ior
      //   907: putfield 107	a/j/b/a/c/e/a$u:Ckr	I
      //   910: iload_3
      //   911: istore 5
      //   913: iload_3
      //   914: istore 6
      //   916: iload_3
      //   917: istore 7
      //   919: aload_0
      //   920: aload_1
      //   921: invokevirtual 110	a/j/b/a/c/g/e:sl	()I
      //   924: putfield 208	a/j/b/a/c/e/a$u:Cmz	I
      //   927: goto -886 -> 41
      //   930: iload_3
      //   931: istore 5
      //   933: iload_3
      //   934: istore 6
      //   936: iload_3
      //   937: istore 7
      //   939: aload_0
      //   940: aload_0
      //   941: getfield 107	a/j/b/a/c/e/a$u:Ckr	I
      //   944: sipush 512
      //   947: ior
      //   948: putfield 107	a/j/b/a/c/e/a$u:Ckr	I
      //   951: iload_3
      //   952: istore 5
      //   954: iload_3
      //   955: istore 6
      //   957: iload_3
      //   958: istore 7
      //   960: aload_0
      //   961: aload_1
      //   962: invokevirtual 110	a/j/b/a/c/g/e:sl	()I
      //   965: putfield 210	a/j/b/a/c/e/a$u:CmA	I
      //   968: goto -927 -> 41
      //   971: iload_3
      //   972: istore 5
      //   974: iload_3
      //   975: istore 6
      //   977: iload_3
      //   978: istore 7
      //   980: aload_0
      //   981: aload_0
      //   982: getfield 107	a/j/b/a/c/e/a$u:Ckr	I
      //   985: bipush 16
      //   987: ior
      //   988: putfield 107	a/j/b/a/c/e/a$u:Ckr	I
      //   991: iload_3
      //   992: istore 5
      //   994: iload_3
      //   995: istore 6
      //   997: iload_3
      //   998: istore 7
      //   1000: aload_0
      //   1001: aload_1
      //   1002: invokevirtual 110	a/j/b/a/c/g/e:sl	()I
      //   1005: putfield 212	a/j/b/a/c/e/a$u:Cmi	I
      //   1008: goto -967 -> 41
      //   1011: iload_3
      //   1012: istore 5
      //   1014: iload_3
      //   1015: istore 6
      //   1017: iload_3
      //   1018: istore 7
      //   1020: aload_0
      //   1021: aload_0
      //   1022: getfield 107	a/j/b/a/c/e/a$u:Ckr	I
      //   1025: bipush 64
      //   1027: ior
      //   1028: putfield 107	a/j/b/a/c/e/a$u:Ckr	I
      //   1031: iload_3
      //   1032: istore 5
      //   1034: iload_3
      //   1035: istore 6
      //   1037: iload_3
      //   1038: istore 7
      //   1040: aload_0
      //   1041: aload_1
      //   1042: invokevirtual 110	a/j/b/a/c/g/e:sl	()I
      //   1045: putfield 214	a/j/b/a/c/e/a$u:Cmk	I
      //   1048: goto -1007 -> 41
      //   1051: iload_3
      //   1052: istore 5
      //   1054: iload_3
      //   1055: istore 6
      //   1057: iload_3
      //   1058: istore 7
      //   1060: aload_0
      //   1061: aload_0
      //   1062: getfield 107	a/j/b/a/c/e/a$u:Ckr	I
      //   1065: iconst_1
      //   1066: ior
      //   1067: putfield 107	a/j/b/a/c/e/a$u:Ckr	I
      //   1070: iload_3
      //   1071: istore 5
      //   1073: iload_3
      //   1074: istore 6
      //   1076: iload_3
      //   1077: istore 7
      //   1079: aload_0
      //   1080: aload_1
      //   1081: invokevirtual 110	a/j/b/a/c/g/e:sl	()I
      //   1084: putfield 216	a/j/b/a/c/e/a$u:CkK	I
      //   1087: goto -1046 -> 41
      //   1090: iload_3
      //   1091: istore 4
      //   1093: iload_3
      //   1094: sipush 2048
      //   1097: iand
      //   1098: sipush 2048
      //   1101: if_icmpeq +30 -> 1131
      //   1104: iload_3
      //   1105: istore 5
      //   1107: iload_3
      //   1108: istore 6
      //   1110: iload_3
      //   1111: istore 7
      //   1113: aload_0
      //   1114: new 176	java/util/ArrayList
      //   1117: dup
      //   1118: invokespecial 177	java/util/ArrayList:<init>	()V
      //   1121: putfield 126	a/j/b/a/c/e/a$u:Clr	Ljava/util/List;
      //   1124: iload_3
      //   1125: sipush 2048
      //   1128: ior
      //   1129: istore 4
      //   1131: iload 4
      //   1133: istore 5
      //   1135: iload 4
      //   1137: istore 6
      //   1139: iload 4
      //   1141: istore 7
      //   1143: aload_0
      //   1144: getfield 126	a/j/b/a/c/e/a$u:Clr	Ljava/util/List;
      //   1147: aload_1
      //   1148: invokevirtual 110	a/j/b/a/c/g/e:sl	()I
      //   1151: invokestatic 222	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1154: invokeinterface 186 2 0
      //   1159: pop
      //   1160: iload 4
      //   1162: istore_3
      //   1163: goto -1122 -> 41
      //   1166: iload_3
      //   1167: istore 5
      //   1169: iload_3
      //   1170: istore 6
      //   1172: iload_3
      //   1173: istore 7
      //   1175: aload_1
      //   1176: aload_1
      //   1177: invokevirtual 110	a/j/b/a/c/g/e:sl	()I
      //   1180: invokevirtual 226	a/j/b/a/c/g/e:eP	(I)I
      //   1183: istore 4
      //   1185: iload_3
      //   1186: sipush 2048
      //   1189: iand
      //   1190: sipush 2048
      //   1193: if_icmpeq +221 -> 1414
      //   1196: iload_3
      //   1197: istore 5
      //   1199: iload_3
      //   1200: istore 6
      //   1202: iload_3
      //   1203: istore 7
      //   1205: aload_1
      //   1206: invokevirtual 229	a/j/b/a/c/g/e:so	()I
      //   1209: ifle +205 -> 1414
      //   1212: iload_3
      //   1213: istore 5
      //   1215: iload_3
      //   1216: istore 6
      //   1218: iload_3
      //   1219: istore 7
      //   1221: aload_0
      //   1222: new 176	java/util/ArrayList
      //   1225: dup
      //   1226: invokespecial 177	java/util/ArrayList:<init>	()V
      //   1229: putfield 126	a/j/b/a/c/e/a$u:Clr	Ljava/util/List;
      //   1232: iload_3
      //   1233: sipush 2048
      //   1236: ior
      //   1237: istore_3
      //   1238: aload_1
      //   1239: invokevirtual 229	a/j/b/a/c/g/e:so	()I
      //   1242: ifle +23 -> 1265
      //   1245: aload_0
      //   1246: getfield 126	a/j/b/a/c/e/a$u:Clr	Ljava/util/List;
      //   1249: aload_1
      //   1250: invokevirtual 110	a/j/b/a/c/g/e:sl	()I
      //   1253: invokestatic 222	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1256: invokeinterface 186 2 0
      //   1261: pop
      //   1262: goto -24 -> 1238
      //   1265: aload_1
      //   1266: iload 4
      //   1268: invokevirtual 232	a/j/b/a/c/g/e:eQ	(I)V
      //   1271: goto -1230 -> 41
      //   1274: iload_3
      //   1275: bipush 32
      //   1277: iand
      //   1278: bipush 32
      //   1280: if_icmpne +14 -> 1294
      //   1283: aload_0
      //   1284: aload_0
      //   1285: getfield 118	a/j/b/a/c/e/a$u:Cld	Ljava/util/List;
      //   1288: invokestatic 124	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   1291: putfield 118	a/j/b/a/c/e/a$u:Cld	Ljava/util/List;
      //   1294: iload_3
      //   1295: sipush 2048
      //   1298: iand
      //   1299: sipush 2048
      //   1302: if_icmpne +14 -> 1316
      //   1305: aload_0
      //   1306: aload_0
      //   1307: getfield 126	a/j/b/a/c/e/a$u:Clr	Ljava/util/List;
      //   1310: invokestatic 124	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   1313: putfield 126	a/j/b/a/c/e/a$u:Clr	Ljava/util/List;
      //   1316: aload 11
      //   1318: invokevirtual 129	a/j/b/a/c/g/f:flush	()V
      //   1321: aload_0
      //   1322: aload 10
      //   1324: invokevirtual 135	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
      //   1327: putfield 80	a/j/b/a/c/e/a$u:Ckp	La/j/b/a/c/g/d;
      //   1330: aload_0
      //   1331: getfield 139	a/j/b/a/c/g/i$c:Crw	La/j/b/a/c/g/h;
      //   1334: invokevirtual 144	a/j/b/a/c/g/h:emF	()V
      //   1337: ldc 86
      //   1339: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1342: return
      //   1343: astore_1
      //   1344: aload_0
      //   1345: aload 10
      //   1347: invokevirtual 135	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
      //   1350: putfield 80	a/j/b/a/c/e/a$u:Ckp	La/j/b/a/c/g/d;
      //   1353: goto -23 -> 1330
      //   1356: astore_1
      //   1357: aload_0
      //   1358: aload 10
      //   1360: invokevirtual 135	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
      //   1363: putfield 80	a/j/b/a/c/e/a$u:Ckp	La/j/b/a/c/g/d;
      //   1366: ldc 86
      //   1368: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1371: aload_1
      //   1372: athrow
      //   1373: astore_2
      //   1374: aload_0
      //   1375: aload 10
      //   1377: invokevirtual 135	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
      //   1380: putfield 80	a/j/b/a/c/e/a$u:Ckp	La/j/b/a/c/g/d;
      //   1383: goto -1049 -> 334
      //   1386: astore_1
      //   1387: aload_0
      //   1388: aload 10
      //   1390: invokevirtual 135	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
      //   1393: putfield 80	a/j/b/a/c/e/a$u:Ckp	La/j/b/a/c/g/d;
      //   1396: ldc 86
      //   1398: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1401: aload_1
      //   1402: athrow
      //   1403: astore_1
      //   1404: goto -1126 -> 278
      //   1407: astore_1
      //   1408: iload_3
      //   1409: istore 4
      //   1411: goto -1019 -> 392
      //   1414: goto -176 -> 1238
      //   1417: aconst_null
      //   1418: astore 9
      //   1420: goto -621 -> 799
      //   1423: aconst_null
      //   1424: astore 9
      //   1426: goto -757 -> 669
      //   1429: aconst_null
      //   1430: astore 9
      //   1432: goto -965 -> 467
      //   1435: goto -164 -> 1271
      //   1438: goto -1254 -> 184
      //   1441: iconst_1
      //   1442: istore 8
      //   1444: goto -1403 -> 41
      //   1447: astore_1
      //   1448: iload 7
      //   1450: istore_3
      //   1451: goto -1173 -> 278
      //   1454: astore_1
      //   1455: iload_3
      //   1456: istore 4
      //   1458: goto -1202 -> 256
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1461	0	this	u
      //   0	1461	1	parame	a.j.b.a.c.g.e
      //   0	1461	2	paramg	g
      //   24	1432	3	i	int
      //   59	1398	4	j	int
      //   47	1167	5	k	int
      //   50	1167	6	m	int
      //   53	1396	7	n	int
      //   39	1404	8	i1	int
      //   465	966	9	localObject	Object
      //   28	1361	10	localb	a.j.b.a.c.g.d.b
      //   36	1281	11	localf	f
      // Exception table:
      //   from	to	target	type
      //   55	61	251	a/j/b/a/c/g/k
      //   193	206	251	a/j/b/a/c/g/k
      //   221	231	251	a/j/b/a/c/g/k
      //   240	248	251	a/j/b/a/c/g/k
      //   357	367	251	a/j/b/a/c/g/k
      //   376	384	251	a/j/b/a/c/g/k
      //   437	449	251	a/j/b/a/c/g/k
      //   458	467	251	a/j/b/a/c/g/k
      //   476	491	251	a/j/b/a/c/g/k
      //   505	515	251	a/j/b/a/c/g/k
      //   524	533	251	a/j/b/a/c/g/k
      //   542	553	251	a/j/b/a/c/g/k
      //   577	588	251	a/j/b/a/c/g/k
      //   606	624	251	a/j/b/a/c/g/k
      //   639	651	251	a/j/b/a/c/g/k
      //   660	669	251	a/j/b/a/c/g/k
      //   678	693	251	a/j/b/a/c/g/k
      //   707	717	251	a/j/b/a/c/g/k
      //   726	735	251	a/j/b/a/c/g/k
      //   744	755	251	a/j/b/a/c/g/k
      //   767	781	251	a/j/b/a/c/g/k
      //   790	799	251	a/j/b/a/c/g/k
      //   808	823	251	a/j/b/a/c/g/k
      //   837	847	251	a/j/b/a/c/g/k
      //   856	865	251	a/j/b/a/c/g/k
      //   874	886	251	a/j/b/a/c/g/k
      //   898	910	251	a/j/b/a/c/g/k
      //   919	927	251	a/j/b/a/c/g/k
      //   939	951	251	a/j/b/a/c/g/k
      //   960	968	251	a/j/b/a/c/g/k
      //   980	991	251	a/j/b/a/c/g/k
      //   1000	1008	251	a/j/b/a/c/g/k
      //   1020	1031	251	a/j/b/a/c/g/k
      //   1040	1048	251	a/j/b/a/c/g/k
      //   1060	1070	251	a/j/b/a/c/g/k
      //   1079	1087	251	a/j/b/a/c/g/k
      //   1113	1124	251	a/j/b/a/c/g/k
      //   1143	1160	251	a/j/b/a/c/g/k
      //   1175	1185	251	a/j/b/a/c/g/k
      //   1205	1212	251	a/j/b/a/c/g/k
      //   1221	1232	251	a/j/b/a/c/g/k
      //   259	264	277	finally
      //   267	272	277	finally
      //   275	277	277	finally
      //   395	407	277	finally
      //   410	415	277	finally
      //   418	423	277	finally
      //   426	428	277	finally
      //   55	61	387	java/io/IOException
      //   193	206	387	java/io/IOException
      //   221	231	387	java/io/IOException
      //   240	248	387	java/io/IOException
      //   357	367	387	java/io/IOException
      //   376	384	387	java/io/IOException
      //   437	449	387	java/io/IOException
      //   458	467	387	java/io/IOException
      //   476	491	387	java/io/IOException
      //   505	515	387	java/io/IOException
      //   524	533	387	java/io/IOException
      //   542	553	387	java/io/IOException
      //   577	588	387	java/io/IOException
      //   606	624	387	java/io/IOException
      //   639	651	387	java/io/IOException
      //   660	669	387	java/io/IOException
      //   678	693	387	java/io/IOException
      //   707	717	387	java/io/IOException
      //   726	735	387	java/io/IOException
      //   744	755	387	java/io/IOException
      //   767	781	387	java/io/IOException
      //   790	799	387	java/io/IOException
      //   808	823	387	java/io/IOException
      //   837	847	387	java/io/IOException
      //   856	865	387	java/io/IOException
      //   874	886	387	java/io/IOException
      //   898	910	387	java/io/IOException
      //   919	927	387	java/io/IOException
      //   939	951	387	java/io/IOException
      //   960	968	387	java/io/IOException
      //   980	991	387	java/io/IOException
      //   1000	1008	387	java/io/IOException
      //   1020	1031	387	java/io/IOException
      //   1040	1048	387	java/io/IOException
      //   1060	1070	387	java/io/IOException
      //   1079	1087	387	java/io/IOException
      //   1113	1124	387	java/io/IOException
      //   1143	1160	387	java/io/IOException
      //   1175	1185	387	java/io/IOException
      //   1205	1212	387	java/io/IOException
      //   1221	1232	387	java/io/IOException
      //   1316	1321	1343	java/io/IOException
      //   1316	1321	1356	finally
      //   320	325	1373	java/io/IOException
      //   320	325	1386	finally
      //   1238	1262	1403	finally
      //   1265	1271	1403	finally
      //   1238	1262	1407	java/io/IOException
      //   1265	1271	1407	java/io/IOException
      //   55	61	1447	finally
      //   193	206	1447	finally
      //   221	231	1447	finally
      //   240	248	1447	finally
      //   357	367	1447	finally
      //   376	384	1447	finally
      //   437	449	1447	finally
      //   458	467	1447	finally
      //   476	491	1447	finally
      //   505	515	1447	finally
      //   524	533	1447	finally
      //   542	553	1447	finally
      //   577	588	1447	finally
      //   606	624	1447	finally
      //   639	651	1447	finally
      //   660	669	1447	finally
      //   678	693	1447	finally
      //   707	717	1447	finally
      //   726	735	1447	finally
      //   744	755	1447	finally
      //   767	781	1447	finally
      //   790	799	1447	finally
      //   808	823	1447	finally
      //   837	847	1447	finally
      //   856	865	1447	finally
      //   874	886	1447	finally
      //   898	910	1447	finally
      //   919	927	1447	finally
      //   939	951	1447	finally
      //   960	968	1447	finally
      //   980	991	1447	finally
      //   1000	1008	1447	finally
      //   1020	1031	1447	finally
      //   1040	1048	1447	finally
      //   1060	1070	1447	finally
      //   1079	1087	1447	finally
      //   1113	1124	1447	finally
      //   1143	1160	1447	finally
      //   1175	1185	1447	finally
      //   1205	1212	1447	finally
      //   1221	1232	1447	finally
      //   1238	1262	1454	a/j/b/a/c/g/k
      //   1265	1271	1454	a/j/b/a/c/g/k
    }
    
    private u(i.b<u, ?> paramb)
    {
      super();
      this.Ckp = paramb.Ckp;
    }
    
    private void egZ()
    {
      AppMethodBeat.i(120733);
      this.CkK = 518;
      this.Cmg = 2054;
      this.ClT = 0;
      this.Cmh = a.aa.ejw();
      this.Cmi = 0;
      this.Cld = Collections.emptyList();
      this.Cmj = a.aa.ejw();
      this.Cmk = 0;
      this.Cmy = a.ai.ekr();
      this.Cmz = 0;
      this.CmA = 0;
      this.Clr = Collections.emptyList();
      AppMethodBeat.o(120733);
    }
    
    public static u eiX()
    {
      return Cmx;
    }
    
    public final void a(f paramf)
    {
      int j = 0;
      AppMethodBeat.i(120735);
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
      if ((this.Ckr & 0x80) == 128) {
        paramf.a(6, this.Cmy);
      }
      if ((this.Ckr & 0x100) == 256) {
        paramf.bj(7, this.Cmz);
      }
      if ((this.Ckr & 0x200) == 512) {
        paramf.bj(8, this.CmA);
      }
      if ((this.Ckr & 0x10) == 16) {
        paramf.bj(9, this.Cmi);
      }
      if ((this.Ckr & 0x40) == 64) {
        paramf.bj(10, this.Cmk);
      }
      i = j;
      if ((this.Ckr & 0x1) == 1)
      {
        paramf.bj(11, this.CkK);
        i = j;
      }
      while (i < this.Clr.size())
      {
        paramf.bj(31, ((Integer)this.Clr.get(i)).intValue());
        i += 1;
      }
      locala.b(19000, paramf);
      paramf.d(this.Ckp);
      AppMethodBeat.o(120735);
    }
    
    public final s<u> egX()
    {
      return Ckq;
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
    
    public final boolean eiY()
    {
      return (this.Ckr & 0x80) == 128;
    }
    
    public final boolean eiZ()
    {
      return (this.Ckr & 0x100) == 256;
    }
    
    public final boolean eiv()
    {
      return (this.Ckr & 0x4) == 4;
    }
    
    public final boolean eja()
    {
      return (this.Ckr & 0x200) == 512;
    }
    
    public final boolean isInitialized()
    {
      AppMethodBeat.i(120734);
      int i = this.Cku;
      if (i == 1)
      {
        AppMethodBeat.o(120734);
        return true;
      }
      if (i == 0)
      {
        AppMethodBeat.o(120734);
        return false;
      }
      if (!eiv())
      {
        this.Cku = 0;
        AppMethodBeat.o(120734);
        return false;
      }
      if ((eiL()) && (!this.Cmh.isInitialized()))
      {
        this.Cku = 0;
        AppMethodBeat.o(120734);
        return false;
      }
      i = 0;
      while (i < this.Cld.size())
      {
        if (!((a.ae)this.Cld.get(i)).isInitialized())
        {
          this.Cku = 0;
          AppMethodBeat.o(120734);
          return false;
        }
        i += 1;
      }
      if ((eiN()) && (!this.Cmj.isInitialized()))
      {
        this.Cku = 0;
        AppMethodBeat.o(120734);
        return false;
      }
      if ((eiY()) && (!this.Cmy.isInitialized()))
      {
        this.Cku = 0;
        AppMethodBeat.o(120734);
        return false;
      }
      if (!this.Crw.isInitialized())
      {
        this.Cku = 0;
        AppMethodBeat.o(120734);
        return false;
      }
      this.Cku = 1;
      AppMethodBeat.o(120734);
      return true;
    }
    
    public final int sy()
    {
      AppMethodBeat.i(120736);
      int i = this.Ckv;
      if (i != -1)
      {
        AppMethodBeat.o(120736);
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
        i = j;
        if ((this.Ckr & 0x80) == 128) {
          i = j + f.c(6, this.Cmy);
        }
        j = i;
        if ((this.Ckr & 0x100) == 256) {
          j = i + f.bl(7, this.Cmz);
        }
        i = j;
        if ((this.Ckr & 0x200) == 512) {
          i = j + f.bl(8, this.CmA);
        }
        j = i;
        if ((this.Ckr & 0x10) == 16) {
          j = i + f.bl(9, this.Cmi);
        }
        i = j;
        if ((this.Ckr & 0x40) == 64) {
          i = j + f.bl(10, this.Cmk);
        }
        j = i;
        if ((this.Ckr & 0x1) == 1) {
          j = i + f.bl(11, this.CkK);
        }
        k = 0;
        int m;
        for (i = 0; k < this.Clr.size(); i = m + i)
        {
          m = f.eU(((Integer)this.Clr.get(k)).intValue());
          k += 1;
        }
        i = j + i + this.Clr.size() * 2 + this.Crw.sy() + this.Ckp.size();
        this.Ckv = i;
        AppMethodBeat.o(120736);
        return i;
      }
    }
    
    public static final class a
      extends i.b<a.u, a>
      implements a.v
    {
      private int CkK;
      private int Ckr;
      private int ClT;
      private List<a.ae> Cld;
      private List<Integer> Clr;
      private int CmA;
      private int Cmg;
      private a.aa Cmh;
      private int Cmi;
      private a.aa Cmj;
      private int Cmk;
      private a.ai Cmy;
      private int Cmz;
      
      private a()
      {
        AppMethodBeat.i(120710);
        this.CkK = 518;
        this.Cmg = 2054;
        this.Cmh = a.aa.ejw();
        this.Cld = Collections.emptyList();
        this.Cmj = a.aa.ejw();
        this.Cmy = a.ai.ekr();
        this.Clr = Collections.emptyList();
        AppMethodBeat.o(120710);
      }
      
      private a UA(int paramInt)
      {
        this.Ckr |= 0x2;
        this.Cmg = paramInt;
        return this;
      }
      
      private a UB(int paramInt)
      {
        this.Ckr |= 0x4;
        this.ClT = paramInt;
        return this;
      }
      
      private a UC(int paramInt)
      {
        this.Ckr |= 0x10;
        this.Cmi = paramInt;
        return this;
      }
      
      private a UD(int paramInt)
      {
        this.Ckr |= 0x80;
        this.Cmk = paramInt;
        return this;
      }
      
      private a UE(int paramInt)
      {
        this.Ckr |= 0x200;
        this.Cmz = paramInt;
        return this;
      }
      
      private a UF(int paramInt)
      {
        this.Ckr |= 0x400;
        this.CmA = paramInt;
        return this;
      }
      
      private a Uz(int paramInt)
      {
        this.Ckr |= 0x1;
        this.CkK = paramInt;
        return this;
      }
      
      private a a(a.ai paramai)
      {
        AppMethodBeat.i(120719);
        if (((this.Ckr & 0x100) == 256) && (this.Cmy != a.ai.ekr())) {}
        for (this.Cmy = a.ai.b(this.Cmy).d(paramai).ekv();; this.Cmy = paramai)
        {
          this.Ckr |= 0x100;
          AppMethodBeat.o(120719);
          return this;
        }
      }
      
      private a d(a.aa paramaa)
      {
        AppMethodBeat.i(120716);
        if (((this.Ckr & 0x8) == 8) && (this.Cmh != a.aa.ejw())) {}
        for (this.Cmh = a.aa.f(this.Cmh).j(paramaa).ejS();; this.Cmh = paramaa)
        {
          this.Ckr |= 0x8;
          AppMethodBeat.o(120716);
          return this;
        }
      }
      
      private a e(a.aa paramaa)
      {
        AppMethodBeat.i(120718);
        if (((this.Ckr & 0x40) == 64) && (this.Cmj != a.aa.ejw())) {}
        for (this.Cmj = a.aa.f(this.Cmj).j(paramaa).ejS();; this.Cmj = paramaa)
        {
          this.Ckr |= 0x40;
          AppMethodBeat.o(120718);
          return this;
        }
      }
      
      private void ehO()
      {
        AppMethodBeat.i(120717);
        if ((this.Ckr & 0x20) != 32)
        {
          this.Cld = new ArrayList(this.Cld);
          this.Ckr |= 0x20;
        }
        AppMethodBeat.o(120717);
      }
      
      private void ehY()
      {
        AppMethodBeat.i(120720);
        if ((this.Ckr & 0x800) != 2048)
        {
          this.Clr = new ArrayList(this.Clr);
          this.Ckr |= 0x800;
        }
        AppMethodBeat.o(120720);
      }
      
      private a ejb()
      {
        AppMethodBeat.i(120711);
        a locala = new a().d(ejc());
        AppMethodBeat.o(120711);
        return locala;
      }
      
      private a.u ejc()
      {
        int j = 1;
        AppMethodBeat.i(120712);
        a.u localu = new a.u(this, (byte)0);
        int k = this.Ckr;
        if ((k & 0x1) == 1) {}
        for (;;)
        {
          a.u.a(localu, this.CkK);
          int i = j;
          if ((k & 0x2) == 2) {
            i = j | 0x2;
          }
          a.u.b(localu, this.Cmg);
          j = i;
          if ((k & 0x4) == 4) {
            j = i | 0x4;
          }
          a.u.c(localu, this.ClT);
          i = j;
          if ((k & 0x8) == 8) {
            i = j | 0x8;
          }
          a.u.a(localu, this.Cmh);
          j = i;
          if ((k & 0x10) == 16) {
            j = i | 0x10;
          }
          a.u.d(localu, this.Cmi);
          if ((this.Ckr & 0x20) == 32)
          {
            this.Cld = Collections.unmodifiableList(this.Cld);
            this.Ckr &= 0xFFFFFFDF;
          }
          a.u.a(localu, this.Cld);
          i = j;
          if ((k & 0x40) == 64) {
            i = j | 0x20;
          }
          a.u.b(localu, this.Cmj);
          j = i;
          if ((k & 0x80) == 128) {
            j = i | 0x40;
          }
          a.u.e(localu, this.Cmk);
          i = j;
          if ((k & 0x100) == 256) {
            i = j | 0x80;
          }
          a.u.a(localu, this.Cmy);
          j = i;
          if ((k & 0x200) == 512) {
            j = i | 0x100;
          }
          a.u.f(localu, this.Cmz);
          i = j;
          if ((k & 0x400) == 1024) {
            i = j | 0x200;
          }
          a.u.g(localu, this.CmA);
          if ((this.Ckr & 0x800) == 2048)
          {
            this.Clr = Collections.unmodifiableList(this.Clr);
            this.Ckr &= 0xFFFFF7FF;
          }
          a.u.b(localu, this.Clr);
          a.u.h(localu, i);
          AppMethodBeat.o(120712);
          return localu;
          j = 0;
        }
      }
      
      /* Error */
      private a o(a.j.b.a.c.g.e parame, g paramg)
      {
        // Byte code:
        //   0: ldc 196
        //   2: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aconst_null
        //   6: astore_3
        //   7: getstatic 200	a/j/b/a/c/e/a$u:Ckq	La/j/b/a/c/g/s;
        //   10: aload_1
        //   11: aload_2
        //   12: invokeinterface 205 3 0
        //   17: checkcast 9	a/j/b/a/c/e/a$u
        //   20: astore_1
        //   21: aload_0
        //   22: aload_1
        //   23: invokevirtual 149	a/j/b/a/c/e/a$u$a:d	(La/j/b/a/c/e/a$u;)La/j/b/a/c/e/a$u$a;
        //   26: pop
        //   27: ldc 196
        //   29: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   32: aload_0
        //   33: areturn
        //   34: astore_1
        //   35: aload_1
        //   36: getfield 209	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
        //   39: checkcast 9	a/j/b/a/c/e/a$u
        //   42: astore_2
        //   43: ldc 196
        //   45: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   48: aload_1
        //   49: athrow
        //   50: astore_1
        //   51: aload_2
        //   52: ifnull +9 -> 61
        //   55: aload_0
        //   56: aload_2
        //   57: invokevirtual 149	a/j/b/a/c/e/a$u$a:d	(La/j/b/a/c/e/a$u;)La/j/b/a/c/e/a$u$a;
        //   60: pop
        //   61: ldc 196
        //   63: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   66: aload_1
        //   67: athrow
        //   68: astore_1
        //   69: aload_3
        //   70: astore_2
        //   71: goto -20 -> 51
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	74	0	this	a
        //   0	74	1	parame	a.j.b.a.c.g.e
        //   0	74	2	paramg	g
        //   6	64	3	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   7	21	34	a/j/b/a/c/g/k
        //   43	50	50	finally
        //   7	21	68	finally
        //   35	43	68	finally
      }
      
      public final a d(a.u paramu)
      {
        AppMethodBeat.i(120713);
        if (paramu == a.u.eiX())
        {
          AppMethodBeat.o(120713);
          return this;
        }
        if (paramu.ehx()) {
          Uz(paramu.CkK);
        }
        if (paramu.eiK()) {
          UA(paramu.Cmg);
        }
        if (paramu.eiv()) {
          UB(paramu.ClT);
        }
        if (paramu.eiL()) {
          d(paramu.Cmh);
        }
        if (paramu.eiM()) {
          UC(paramu.Cmi);
        }
        if (!a.u.a(paramu).isEmpty())
        {
          if (this.Cld.isEmpty())
          {
            this.Cld = a.u.a(paramu);
            this.Ckr &= 0xFFFFFFDF;
          }
        }
        else
        {
          if (paramu.eiN()) {
            e(paramu.Cmj);
          }
          if (paramu.eiO()) {
            UD(paramu.Cmk);
          }
          if (paramu.eiY()) {
            a(paramu.Cmy);
          }
          if (paramu.eiZ()) {
            UE(paramu.Cmz);
          }
          if (paramu.eja()) {
            UF(paramu.CmA);
          }
          if (!a.u.b(paramu).isEmpty())
          {
            if (!this.Clr.isEmpty()) {
              break label314;
            }
            this.Clr = a.u.b(paramu);
            this.Ckr &= 0xFFFFF7FF;
          }
        }
        for (;;)
        {
          a(paramu);
          this.Ckp = this.Ckp.a(a.u.c(paramu));
          AppMethodBeat.o(120713);
          return this;
          ehO();
          this.Cld.addAll(a.u.a(paramu));
          break;
          label314:
          ehY();
          this.Clr.addAll(a.u.b(paramu));
        }
      }
      
      public final boolean isInitialized()
      {
        AppMethodBeat.i(120714);
        if ((this.Ckr & 0x4) == 4) {}
        for (int i = 1; i == 0; i = 0)
        {
          AppMethodBeat.o(120714);
          return false;
        }
        if ((this.Ckr & 0x8) == 8) {}
        for (i = 1; (i != 0) && (!this.Cmh.isInitialized()); i = 0)
        {
          AppMethodBeat.o(120714);
          return false;
        }
        i = 0;
        while (i < this.Cld.size())
        {
          if (!((a.ae)this.Cld.get(i)).isInitialized())
          {
            AppMethodBeat.o(120714);
            return false;
          }
          i += 1;
        }
        if ((this.Ckr & 0x40) == 64) {}
        for (i = 1; (i != 0) && (!this.Cmj.isInitialized()); i = 0)
        {
          AppMethodBeat.o(120714);
          return false;
        }
        if ((this.Ckr & 0x100) == 256) {}
        for (i = 1; (i != 0) && (!this.Cmy.isInitialized()); i = 0)
        {
          AppMethodBeat.o(120714);
          return false;
        }
        if (!this.Crw.isInitialized())
        {
          AppMethodBeat.o(120714);
          return false;
        }
        AppMethodBeat.o(120714);
        return true;
      }
    }
  }
  
  public static final class y$a
    extends i.a<a.y, a>
    implements a.z
  {
    private int Ckr;
    private o CmM = n.CrT;
    
    private a ejs()
    {
      AppMethodBeat.i(120796);
      a locala = new a().d(ejt());
      AppMethodBeat.o(120796);
      return locala;
    }
    
    private void eju()
    {
      AppMethodBeat.i(120800);
      if ((this.Ckr & 0x1) != 1)
      {
        this.CmM = new n(this.CmM);
        this.Ckr |= 0x1;
      }
      AppMethodBeat.o(120800);
    }
    
    /* Error */
    private a r(a.j.b.a.c.g.e parame, g paramg)
    {
      // Byte code:
      //   0: ldc 61
      //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: getstatic 65	a/j/b/a/c/e/a$y:Ckq	La/j/b/a/c/g/s;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 70 3 0
      //   17: checkcast 9	a/j/b/a/c/e/a$y
      //   20: astore_1
      //   21: aload_0
      //   22: aload_1
      //   23: invokevirtual 44	a/j/b/a/c/e/a$y$a:d	(La/j/b/a/c/e/a$y;)La/j/b/a/c/e/a$y$a;
      //   26: pop
      //   27: ldc 61
      //   29: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   32: aload_0
      //   33: areturn
      //   34: astore_1
      //   35: aload_1
      //   36: getfield 74	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
      //   39: checkcast 9	a/j/b/a/c/e/a$y
      //   42: astore_2
      //   43: ldc 61
      //   45: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   48: aload_1
      //   49: athrow
      //   50: astore_1
      //   51: aload_2
      //   52: ifnull +9 -> 61
      //   55: aload_0
      //   56: aload_2
      //   57: invokevirtual 44	a/j/b/a/c/e/a$y$a:d	(La/j/b/a/c/e/a$y;)La/j/b/a/c/e/a$y$a;
      //   60: pop
      //   61: ldc 61
      //   63: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   66: aload_1
      //   67: athrow
      //   68: astore_1
      //   69: aload_3
      //   70: astore_2
      //   71: goto -20 -> 51
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	74	0	this	a
      //   0	74	1	parame	a.j.b.a.c.g.e
      //   0	74	2	paramg	g
      //   6	64	3	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   7	21	34	a/j/b/a/c/g/k
      //   43	50	50	finally
      //   7	21	68	finally
      //   35	43	68	finally
    }
    
    public final a d(a.y paramy)
    {
      AppMethodBeat.i(120798);
      if (paramy == a.y.ejq())
      {
        AppMethodBeat.o(120798);
        return this;
      }
      if (!a.y.b(paramy).isEmpty())
      {
        if (!this.CmM.isEmpty()) {
          break label84;
        }
        this.CmM = a.y.b(paramy);
        this.Ckr &= 0xFFFFFFFE;
      }
      for (;;)
      {
        this.Ckp = this.Ckp.a(a.y.c(paramy));
        AppMethodBeat.o(120798);
        return this;
        label84:
        eju();
        this.CmM.addAll(a.y.b(paramy));
      }
    }
    
    public final a.y ejt()
    {
      AppMethodBeat.i(120797);
      a.y localy = new a.y(this, (byte)0);
      if ((this.Ckr & 0x1) == 1)
      {
        this.CmM = this.CmM.emX();
        this.Ckr &= 0xFFFFFFFE;
      }
      a.y.a(localy, this.CmM);
      AppMethodBeat.o(120797);
      return localy;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.c.e.a
 * JD-Core Version:    0.7.0.1
 */