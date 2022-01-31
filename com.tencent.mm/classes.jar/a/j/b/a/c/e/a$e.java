package a.j.b.a.c.e;

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

public final class a$e
  extends i.c<e>
  implements a.f
{
  public static s<e> Ckq;
  private static final e ClB;
  public int CkK;
  private final d Ckp;
  private int Ckr;
  private byte Cku = -1;
  private int Ckv = -1;
  public List<a.ai> ClC;
  public List<Integer> Clr;
  
  static
  {
    AppMethodBeat.i(120512);
    Ckq = new a.e.1();
    e locale = new e();
    ClB = locale;
    locale.egZ();
    AppMethodBeat.o(120512);
  }
  
  private a$e()
  {
    this.Ckp = d.Cre;
  }
  
  /* Error */
  private a$e(a.j.b.a.c.g.e parame, a.j.b.a.c.g.g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 57	a/j/b/a/c/g/i$c:<init>	()V
    //   4: ldc 74
    //   6: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 59	a/j/b/a/c/e/a$e:Cku	B
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 61	a/j/b/a/c/e/a$e:Ckv	I
    //   19: aload_0
    //   20: invokespecial 52	a/j/b/a/c/e/a$e:egZ	()V
    //   23: iconst_0
    //   24: istore_3
    //   25: invokestatic 78	a/j/b/a/c/g/d:emp	()La/j/b/a/c/g/d$b;
    //   28: astore 10
    //   30: aload 10
    //   32: iconst_1
    //   33: invokestatic 83	a/j/b/a/c/g/f:e	(Ljava/io/OutputStream;I)La/j/b/a/c/g/f;
    //   36: astore 11
    //   38: iconst_0
    //   39: istore 5
    //   41: iload 5
    //   43: ifne +554 -> 597
    //   46: iload_3
    //   47: istore 6
    //   49: iload_3
    //   50: istore 7
    //   52: iload_3
    //   53: istore 8
    //   55: aload_1
    //   56: invokevirtual 89	a/j/b/a/c/g/e:sk	()I
    //   59: istore 4
    //   61: iload 4
    //   63: lookupswitch	default:+671->734, 0:+674->737, 8:+77->140, 18:+212->275, 248:+273->336, 250:+333->396
    //   113: istore 6
    //   115: iload_3
    //   116: istore 7
    //   118: iload_3
    //   119: istore 8
    //   121: aload_0
    //   122: aload_1
    //   123: aload 11
    //   125: aload_2
    //   126: iload 4
    //   128: invokevirtual 93	a/j/b/a/c/e/a$e:a	(La/j/b/a/c/g/e;La/j/b/a/c/g/f;La/j/b/a/c/g/g;I)Z
    //   131: ifne -90 -> 41
    //   134: iconst_1
    //   135: istore 5
    //   137: goto -96 -> 41
    //   140: iload_3
    //   141: istore 6
    //   143: iload_3
    //   144: istore 7
    //   146: iload_3
    //   147: istore 8
    //   149: aload_0
    //   150: aload_0
    //   151: getfield 95	a/j/b/a/c/e/a$e:Ckr	I
    //   154: iconst_1
    //   155: ior
    //   156: putfield 95	a/j/b/a/c/e/a$e:Ckr	I
    //   159: iload_3
    //   160: istore 6
    //   162: iload_3
    //   163: istore 7
    //   165: iload_3
    //   166: istore 8
    //   168: aload_0
    //   169: aload_1
    //   170: invokevirtual 98	a/j/b/a/c/g/e:sl	()I
    //   173: putfield 100	a/j/b/a/c/e/a$e:CkK	I
    //   176: goto -135 -> 41
    //   179: astore_1
    //   180: iload 6
    //   182: istore 7
    //   184: iload 7
    //   186: istore 4
    //   188: aload_1
    //   189: aload_0
    //   190: putfield 104	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   193: iload 7
    //   195: istore 4
    //   197: ldc 74
    //   199: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   202: iload 7
    //   204: istore 4
    //   206: aload_1
    //   207: athrow
    //   208: astore_1
    //   209: iload 4
    //   211: iconst_2
    //   212: iand
    //   213: iconst_2
    //   214: if_icmpne +14 -> 228
    //   217: aload_0
    //   218: aload_0
    //   219: getfield 106	a/j/b/a/c/e/a$e:ClC	Ljava/util/List;
    //   222: invokestatic 112	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   225: putfield 106	a/j/b/a/c/e/a$e:ClC	Ljava/util/List;
    //   228: iload 4
    //   230: iconst_4
    //   231: iand
    //   232: iconst_4
    //   233: if_icmpne +14 -> 247
    //   236: aload_0
    //   237: aload_0
    //   238: getfield 114	a/j/b/a/c/e/a$e:Clr	Ljava/util/List;
    //   241: invokestatic 112	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   244: putfield 114	a/j/b/a/c/e/a$e:Clr	Ljava/util/List;
    //   247: aload 11
    //   249: invokevirtual 117	a/j/b/a/c/g/f:flush	()V
    //   252: aload_0
    //   253: aload 10
    //   255: invokevirtual 123	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   258: putfield 68	a/j/b/a/c/e/a$e:Ckp	La/j/b/a/c/g/d;
    //   261: aload_0
    //   262: getfield 127	a/j/b/a/c/g/i$c:Crw	La/j/b/a/c/g/h;
    //   265: invokevirtual 132	a/j/b/a/c/g/h:emF	()V
    //   268: ldc 74
    //   270: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   273: aload_1
    //   274: athrow
    //   275: iload_3
    //   276: iconst_2
    //   277: iand
    //   278: iconst_2
    //   279: if_icmpeq +452 -> 731
    //   282: iload_3
    //   283: istore 6
    //   285: iload_3
    //   286: istore 7
    //   288: iload_3
    //   289: istore 8
    //   291: aload_0
    //   292: new 134	java/util/ArrayList
    //   295: dup
    //   296: invokespecial 135	java/util/ArrayList:<init>	()V
    //   299: putfield 106	a/j/b/a/c/e/a$e:ClC	Ljava/util/List;
    //   302: iload_3
    //   303: iconst_2
    //   304: ior
    //   305: istore_3
    //   306: iload_3
    //   307: istore 4
    //   309: iload_3
    //   310: istore 6
    //   312: iload_3
    //   313: istore 7
    //   315: aload_0
    //   316: getfield 106	a/j/b/a/c/e/a$e:ClC	Ljava/util/List;
    //   319: aload_1
    //   320: getstatic 138	a/j/b/a/c/e/a$ai:Ckq	La/j/b/a/c/g/s;
    //   323: aload_2
    //   324: invokevirtual 141	a/j/b/a/c/g/e:a	(La/j/b/a/c/g/s;La/j/b/a/c/g/g;)La/j/b/a/c/g/q;
    //   327: invokeinterface 147 2 0
    //   332: pop
    //   333: goto -292 -> 41
    //   336: iload_3
    //   337: iconst_4
    //   338: iand
    //   339: iconst_4
    //   340: if_icmpeq +388 -> 728
    //   343: iload_3
    //   344: istore 6
    //   346: iload_3
    //   347: istore 7
    //   349: iload_3
    //   350: istore 8
    //   352: aload_0
    //   353: new 134	java/util/ArrayList
    //   356: dup
    //   357: invokespecial 135	java/util/ArrayList:<init>	()V
    //   360: putfield 114	a/j/b/a/c/e/a$e:Clr	Ljava/util/List;
    //   363: iload_3
    //   364: iconst_4
    //   365: ior
    //   366: istore_3
    //   367: iload_3
    //   368: istore 4
    //   370: iload_3
    //   371: istore 6
    //   373: iload_3
    //   374: istore 7
    //   376: aload_0
    //   377: getfield 114	a/j/b/a/c/e/a$e:Clr	Ljava/util/List;
    //   380: aload_1
    //   381: invokevirtual 98	a/j/b/a/c/g/e:sl	()I
    //   384: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   387: invokeinterface 147 2 0
    //   392: pop
    //   393: goto -352 -> 41
    //   396: iload_3
    //   397: istore 6
    //   399: iload_3
    //   400: istore 7
    //   402: iload_3
    //   403: istore 8
    //   405: aload_1
    //   406: aload_1
    //   407: invokevirtual 98	a/j/b/a/c/g/e:sl	()I
    //   410: invokevirtual 157	a/j/b/a/c/g/e:eP	(I)I
    //   413: istore 9
    //   415: iload_3
    //   416: istore 4
    //   418: iload_3
    //   419: iconst_4
    //   420: iand
    //   421: iconst_4
    //   422: if_icmpeq +47 -> 469
    //   425: iload_3
    //   426: istore 6
    //   428: iload_3
    //   429: istore 4
    //   431: iload_3
    //   432: istore 7
    //   434: iload_3
    //   435: istore 8
    //   437: aload_1
    //   438: invokevirtual 160	a/j/b/a/c/g/e:so	()I
    //   441: ifle +28 -> 469
    //   444: iload_3
    //   445: istore 6
    //   447: iload_3
    //   448: istore 7
    //   450: iload_3
    //   451: istore 8
    //   453: aload_0
    //   454: new 134	java/util/ArrayList
    //   457: dup
    //   458: invokespecial 135	java/util/ArrayList:<init>	()V
    //   461: putfield 114	a/j/b/a/c/e/a$e:Clr	Ljava/util/List;
    //   464: iload_3
    //   465: iconst_4
    //   466: ior
    //   467: istore 4
    //   469: iload 4
    //   471: istore 6
    //   473: iload 4
    //   475: istore 7
    //   477: iload 4
    //   479: istore 8
    //   481: aload_1
    //   482: invokevirtual 160	a/j/b/a/c/g/e:so	()I
    //   485: ifle +80 -> 565
    //   488: iload 4
    //   490: istore 6
    //   492: iload 4
    //   494: istore 7
    //   496: iload 4
    //   498: istore 8
    //   500: aload_0
    //   501: getfield 114	a/j/b/a/c/e/a$e:Clr	Ljava/util/List;
    //   504: aload_1
    //   505: invokevirtual 98	a/j/b/a/c/g/e:sl	()I
    //   508: invokestatic 153	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   511: invokeinterface 147 2 0
    //   516: pop
    //   517: goto -48 -> 469
    //   520: astore_1
    //   521: iload 7
    //   523: istore 6
    //   525: iload 6
    //   527: istore 4
    //   529: new 71	a/j/b/a/c/g/k
    //   532: dup
    //   533: aload_1
    //   534: invokevirtual 164	java/io/IOException:getMessage	()Ljava/lang/String;
    //   537: invokespecial 167	a/j/b/a/c/g/k:<init>	(Ljava/lang/String;)V
    //   540: astore_1
    //   541: iload 6
    //   543: istore 4
    //   545: aload_1
    //   546: aload_0
    //   547: putfield 104	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   550: iload 6
    //   552: istore 4
    //   554: ldc 74
    //   556: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   559: iload 6
    //   561: istore 4
    //   563: aload_1
    //   564: athrow
    //   565: iload 4
    //   567: istore 6
    //   569: iload 4
    //   571: istore 7
    //   573: iload 4
    //   575: istore 8
    //   577: aload_1
    //   578: iload 9
    //   580: invokevirtual 170	a/j/b/a/c/g/e:eQ	(I)V
    //   583: iload 4
    //   585: istore_3
    //   586: goto -545 -> 41
    //   589: astore_1
    //   590: iload 8
    //   592: istore 4
    //   594: goto -385 -> 209
    //   597: iload_3
    //   598: iconst_2
    //   599: iand
    //   600: iconst_2
    //   601: if_icmpne +14 -> 615
    //   604: aload_0
    //   605: aload_0
    //   606: getfield 106	a/j/b/a/c/e/a$e:ClC	Ljava/util/List;
    //   609: invokestatic 112	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   612: putfield 106	a/j/b/a/c/e/a$e:ClC	Ljava/util/List;
    //   615: iload_3
    //   616: iconst_4
    //   617: iand
    //   618: iconst_4
    //   619: if_icmpne +14 -> 633
    //   622: aload_0
    //   623: aload_0
    //   624: getfield 114	a/j/b/a/c/e/a$e:Clr	Ljava/util/List;
    //   627: invokestatic 112	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   630: putfield 114	a/j/b/a/c/e/a$e:Clr	Ljava/util/List;
    //   633: aload 11
    //   635: invokevirtual 117	a/j/b/a/c/g/f:flush	()V
    //   638: aload_0
    //   639: aload 10
    //   641: invokevirtual 123	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   644: putfield 68	a/j/b/a/c/e/a$e:Ckp	La/j/b/a/c/g/d;
    //   647: aload_0
    //   648: getfield 127	a/j/b/a/c/g/i$c:Crw	La/j/b/a/c/g/h;
    //   651: invokevirtual 132	a/j/b/a/c/g/h:emF	()V
    //   654: ldc 74
    //   656: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   659: return
    //   660: astore_1
    //   661: aload_0
    //   662: aload 10
    //   664: invokevirtual 123	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   667: putfield 68	a/j/b/a/c/e/a$e:Ckp	La/j/b/a/c/g/d;
    //   670: goto -23 -> 647
    //   673: astore_1
    //   674: aload_0
    //   675: aload 10
    //   677: invokevirtual 123	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   680: putfield 68	a/j/b/a/c/e/a$e:Ckp	La/j/b/a/c/g/d;
    //   683: ldc 74
    //   685: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   688: aload_1
    //   689: athrow
    //   690: astore_2
    //   691: aload_0
    //   692: aload 10
    //   694: invokevirtual 123	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   697: putfield 68	a/j/b/a/c/e/a$e:Ckp	La/j/b/a/c/g/d;
    //   700: goto -439 -> 261
    //   703: astore_1
    //   704: aload_0
    //   705: aload 10
    //   707: invokevirtual 123	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   710: putfield 68	a/j/b/a/c/e/a$e:Ckp	La/j/b/a/c/g/d;
    //   713: ldc 74
    //   715: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   718: aload_1
    //   719: athrow
    //   720: astore_1
    //   721: goto -196 -> 525
    //   724: astore_1
    //   725: goto -541 -> 184
    //   728: goto -361 -> 367
    //   731: goto -425 -> 306
    //   734: goto -622 -> 112
    //   737: iconst_1
    //   738: istore 5
    //   740: goto -699 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	743	0	this	e
    //   0	743	1	parame	a.j.b.a.c.g.e
    //   0	743	2	paramg	a.j.b.a.c.g.g
    //   24	594	3	i	int
    //   59	534	4	j	int
    //   39	700	5	k	int
    //   47	521	6	m	int
    //   50	522	7	n	int
    //   53	538	8	i1	int
    //   413	166	9	i2	int
    //   28	678	10	localb	a.j.b.a.c.g.d.b
    //   36	598	11	localf	f
    // Exception table:
    //   from	to	target	type
    //   55	61	179	a/j/b/a/c/g/k
    //   121	134	179	a/j/b/a/c/g/k
    //   149	159	179	a/j/b/a/c/g/k
    //   168	176	179	a/j/b/a/c/g/k
    //   291	302	179	a/j/b/a/c/g/k
    //   352	363	179	a/j/b/a/c/g/k
    //   405	415	179	a/j/b/a/c/g/k
    //   437	444	179	a/j/b/a/c/g/k
    //   453	464	179	a/j/b/a/c/g/k
    //   481	488	179	a/j/b/a/c/g/k
    //   500	517	179	a/j/b/a/c/g/k
    //   577	583	179	a/j/b/a/c/g/k
    //   188	193	208	finally
    //   197	202	208	finally
    //   206	208	208	finally
    //   315	333	208	finally
    //   376	393	208	finally
    //   529	541	208	finally
    //   545	550	208	finally
    //   554	559	208	finally
    //   563	565	208	finally
    //   55	61	520	java/io/IOException
    //   121	134	520	java/io/IOException
    //   149	159	520	java/io/IOException
    //   168	176	520	java/io/IOException
    //   291	302	520	java/io/IOException
    //   352	363	520	java/io/IOException
    //   405	415	520	java/io/IOException
    //   437	444	520	java/io/IOException
    //   453	464	520	java/io/IOException
    //   481	488	520	java/io/IOException
    //   500	517	520	java/io/IOException
    //   577	583	520	java/io/IOException
    //   55	61	589	finally
    //   121	134	589	finally
    //   149	159	589	finally
    //   168	176	589	finally
    //   291	302	589	finally
    //   352	363	589	finally
    //   405	415	589	finally
    //   437	444	589	finally
    //   453	464	589	finally
    //   481	488	589	finally
    //   500	517	589	finally
    //   577	583	589	finally
    //   633	638	660	java/io/IOException
    //   633	638	673	finally
    //   247	252	690	java/io/IOException
    //   247	252	703	finally
    //   315	333	720	java/io/IOException
    //   376	393	720	java/io/IOException
    //   315	333	724	a/j/b/a/c/g/k
    //   376	393	724	a/j/b/a/c/g/k
  }
  
  private a$e(i.b<e, ?> paramb)
  {
    super(paramb);
    this.Ckp = paramb.Ckp;
  }
  
  private void egZ()
  {
    AppMethodBeat.i(120506);
    this.CkK = 6;
    this.ClC = Collections.emptyList();
    this.Clr = Collections.emptyList();
    AppMethodBeat.o(120506);
  }
  
  public static e eib()
  {
    return ClB;
  }
  
  public final void a(f paramf)
  {
    int k = 0;
    AppMethodBeat.i(120508);
    sy();
    i.c.a locala = emM();
    if ((this.Ckr & 0x1) == 1) {
      paramf.bj(1, this.CkK);
    }
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.ClC.size()) {
        break;
      }
      paramf.a(2, (q)this.ClC.get(i));
      i += 1;
    }
    while (j < this.Clr.size())
    {
      paramf.bj(31, ((Integer)this.Clr.get(j)).intValue());
      j += 1;
    }
    locala.b(19000, paramf);
    paramf.d(this.Ckp);
    AppMethodBeat.o(120508);
  }
  
  public final s<e> egX()
  {
    return Ckq;
  }
  
  public final boolean ehx()
  {
    return (this.Ckr & 0x1) == 1;
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(120507);
    int i = this.Cku;
    if (i == 1)
    {
      AppMethodBeat.o(120507);
      return true;
    }
    if (i == 0)
    {
      AppMethodBeat.o(120507);
      return false;
    }
    i = 0;
    while (i < this.ClC.size())
    {
      if (!((a.ai)this.ClC.get(i)).isInitialized())
      {
        this.Cku = 0;
        AppMethodBeat.o(120507);
        return false;
      }
      i += 1;
    }
    if (!this.Crw.isInitialized())
    {
      this.Cku = 0;
      AppMethodBeat.o(120507);
      return false;
    }
    this.Cku = 1;
    AppMethodBeat.o(120507);
    return true;
  }
  
  public final int sy()
  {
    AppMethodBeat.i(120509);
    int i = this.Ckv;
    if (i != -1)
    {
      AppMethodBeat.o(120509);
      return i;
    }
    if ((this.Ckr & 0x1) == 1) {}
    for (i = f.bl(1, this.CkK) + 0;; i = 0)
    {
      int j = 0;
      while (j < this.ClC.size())
      {
        i += f.c(2, (q)this.ClC.get(j));
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
      AppMethodBeat.o(120509);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.j.b.a.c.e.a.e
 * JD-Core Version:    0.7.0.1
 */