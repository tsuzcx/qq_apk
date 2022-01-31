package a.j.b.a.c.e.b;

import a.j.b.a.c.g.d;
import a.j.b.a.c.g.f;
import a.j.b.a.c.g.g;
import a.j.b.a.c.g.i;
import a.j.b.a.c.g.i.a;
import a.j.b.a.c.g.q;
import a.j.b.a.c.g.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public final class b$g
  extends i
  implements b.h
{
  public static s<g> Ckq;
  private static final g CpI;
  private final d Ckp;
  private byte Cku = -1;
  private int Ckv = -1;
  public List<b.g.b> CpJ;
  public List<Integer> CpK;
  private int CpL = -1;
  
  static
  {
    AppMethodBeat.i(121295);
    Ckq = new b.g.1();
    g localg = new g();
    CpI = localg;
    localg.egZ();
    AppMethodBeat.o(121295);
  }
  
  private b$g()
  {
    this.Ckp = d.Cre;
  }
  
  /* Error */
  private b$g(a.j.b.a.c.g.e parame, g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 59	a/j/b/a/c/g/i:<init>	()V
    //   4: ldc 78
    //   6: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 61	a/j/b/a/c/e/b/b$g:CpL	I
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 63	a/j/b/a/c/e/b/b$g:Cku	B
    //   19: aload_0
    //   20: iconst_m1
    //   21: putfield 65	a/j/b/a/c/e/b/b$g:Ckv	I
    //   24: aload_0
    //   25: invokespecial 54	a/j/b/a/c/e/b/b$g:egZ	()V
    //   28: invokestatic 82	a/j/b/a/c/g/d:emp	()La/j/b/a/c/g/d$b;
    //   31: astore 10
    //   33: aload 10
    //   35: iconst_1
    //   36: invokestatic 88	a/j/b/a/c/g/f:e	(Ljava/io/OutputStream;I)La/j/b/a/c/g/f;
    //   39: astore 11
    //   41: iconst_0
    //   42: istore 5
    //   44: iconst_0
    //   45: istore_3
    //   46: iload 5
    //   48: ifne +499 -> 547
    //   51: iload_3
    //   52: istore 6
    //   54: iload_3
    //   55: istore 7
    //   57: iload_3
    //   58: istore 8
    //   60: aload_1
    //   61: invokevirtual 94	a/j/b/a/c/g/e:sk	()I
    //   64: istore 4
    //   66: iload 4
    //   68: lookupswitch	default:+621->689, 0:+624->692, 10:+72->140, 40:+133->201, 42:+193->261
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
    //   128: invokevirtual 98	a/j/b/a/c/e/b/b$g:a	(La/j/b/a/c/g/e;La/j/b/a/c/g/f;La/j/b/a/c/g/g;I)Z
    //   131: ifne -85 -> 46
    //   134: iconst_1
    //   135: istore 5
    //   137: goto -91 -> 46
    //   140: iload_3
    //   141: iconst_1
    //   142: iand
    //   143: iconst_1
    //   144: if_icmpeq +542 -> 686
    //   147: iload_3
    //   148: istore 6
    //   150: iload_3
    //   151: istore 7
    //   153: iload_3
    //   154: istore 8
    //   156: aload_0
    //   157: new 100	java/util/ArrayList
    //   160: dup
    //   161: invokespecial 101	java/util/ArrayList:<init>	()V
    //   164: putfield 103	a/j/b/a/c/e/b/b$g:CpJ	Ljava/util/List;
    //   167: iload_3
    //   168: iconst_1
    //   169: ior
    //   170: istore_3
    //   171: iload_3
    //   172: istore 4
    //   174: iload_3
    //   175: istore 6
    //   177: iload_3
    //   178: istore 7
    //   180: aload_0
    //   181: getfield 103	a/j/b/a/c/e/b/b$g:CpJ	Ljava/util/List;
    //   184: aload_1
    //   185: getstatic 104	a/j/b/a/c/e/b/b$g$b:Ckq	La/j/b/a/c/g/s;
    //   188: aload_2
    //   189: invokevirtual 107	a/j/b/a/c/g/e:a	(La/j/b/a/c/g/s;La/j/b/a/c/g/g;)La/j/b/a/c/g/q;
    //   192: invokeinterface 113 2 0
    //   197: pop
    //   198: goto -152 -> 46
    //   201: iload_3
    //   202: iconst_2
    //   203: iand
    //   204: iconst_2
    //   205: if_icmpeq +478 -> 683
    //   208: iload_3
    //   209: istore 6
    //   211: iload_3
    //   212: istore 7
    //   214: iload_3
    //   215: istore 8
    //   217: aload_0
    //   218: new 100	java/util/ArrayList
    //   221: dup
    //   222: invokespecial 101	java/util/ArrayList:<init>	()V
    //   225: putfield 115	a/j/b/a/c/e/b/b$g:CpK	Ljava/util/List;
    //   228: iload_3
    //   229: iconst_2
    //   230: ior
    //   231: istore_3
    //   232: iload_3
    //   233: istore 4
    //   235: iload_3
    //   236: istore 6
    //   238: iload_3
    //   239: istore 7
    //   241: aload_0
    //   242: getfield 115	a/j/b/a/c/e/b/b$g:CpK	Ljava/util/List;
    //   245: aload_1
    //   246: invokevirtual 118	a/j/b/a/c/g/e:sl	()I
    //   249: invokestatic 124	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   252: invokeinterface 113 2 0
    //   257: pop
    //   258: goto -212 -> 46
    //   261: iload_3
    //   262: istore 6
    //   264: iload_3
    //   265: istore 7
    //   267: iload_3
    //   268: istore 8
    //   270: aload_1
    //   271: aload_1
    //   272: invokevirtual 118	a/j/b/a/c/g/e:sl	()I
    //   275: invokevirtual 128	a/j/b/a/c/g/e:eP	(I)I
    //   278: istore 9
    //   280: iload_3
    //   281: istore 4
    //   283: iload_3
    //   284: iconst_2
    //   285: iand
    //   286: iconst_2
    //   287: if_icmpeq +47 -> 334
    //   290: iload_3
    //   291: istore 4
    //   293: iload_3
    //   294: istore 6
    //   296: iload_3
    //   297: istore 7
    //   299: iload_3
    //   300: istore 8
    //   302: aload_1
    //   303: invokevirtual 131	a/j/b/a/c/g/e:so	()I
    //   306: ifle +28 -> 334
    //   309: iload_3
    //   310: istore 6
    //   312: iload_3
    //   313: istore 7
    //   315: iload_3
    //   316: istore 8
    //   318: aload_0
    //   319: new 100	java/util/ArrayList
    //   322: dup
    //   323: invokespecial 101	java/util/ArrayList:<init>	()V
    //   326: putfield 115	a/j/b/a/c/e/b/b$g:CpK	Ljava/util/List;
    //   329: iload_3
    //   330: iconst_2
    //   331: ior
    //   332: istore 4
    //   334: iload 4
    //   336: istore 6
    //   338: iload 4
    //   340: istore 7
    //   342: iload 4
    //   344: istore 8
    //   346: aload_1
    //   347: invokevirtual 131	a/j/b/a/c/g/e:so	()I
    //   350: ifle +128 -> 478
    //   353: iload 4
    //   355: istore 6
    //   357: iload 4
    //   359: istore 7
    //   361: iload 4
    //   363: istore 8
    //   365: aload_0
    //   366: getfield 115	a/j/b/a/c/e/b/b$g:CpK	Ljava/util/List;
    //   369: aload_1
    //   370: invokevirtual 118	a/j/b/a/c/g/e:sl	()I
    //   373: invokestatic 124	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   376: invokeinterface 113 2 0
    //   381: pop
    //   382: goto -48 -> 334
    //   385: astore_1
    //   386: iload 6
    //   388: istore 7
    //   390: iload 7
    //   392: istore 4
    //   394: aload_1
    //   395: aload_0
    //   396: putfield 135	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   399: iload 7
    //   401: istore 4
    //   403: ldc 78
    //   405: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   408: iload 7
    //   410: istore 4
    //   412: aload_1
    //   413: athrow
    //   414: astore_1
    //   415: iload 4
    //   417: iconst_1
    //   418: iand
    //   419: iconst_1
    //   420: if_icmpne +14 -> 434
    //   423: aload_0
    //   424: aload_0
    //   425: getfield 103	a/j/b/a/c/e/b/b$g:CpJ	Ljava/util/List;
    //   428: invokestatic 141	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   431: putfield 103	a/j/b/a/c/e/b/b$g:CpJ	Ljava/util/List;
    //   434: iload 4
    //   436: iconst_2
    //   437: iand
    //   438: iconst_2
    //   439: if_icmpne +14 -> 453
    //   442: aload_0
    //   443: aload_0
    //   444: getfield 115	a/j/b/a/c/e/b/b$g:CpK	Ljava/util/List;
    //   447: invokestatic 141	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   450: putfield 115	a/j/b/a/c/e/b/b$g:CpK	Ljava/util/List;
    //   453: aload 11
    //   455: invokevirtual 144	a/j/b/a/c/g/f:flush	()V
    //   458: aload_0
    //   459: aload 10
    //   461: invokevirtual 150	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   464: putfield 72	a/j/b/a/c/e/b/b$g:Ckp	La/j/b/a/c/g/d;
    //   467: aload_0
    //   468: invokevirtual 153	a/j/b/a/c/e/b/b$g:emL	()V
    //   471: ldc 78
    //   473: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   476: aload_1
    //   477: athrow
    //   478: iload 4
    //   480: istore 6
    //   482: iload 4
    //   484: istore 7
    //   486: iload 4
    //   488: istore 8
    //   490: aload_1
    //   491: iload 9
    //   493: invokevirtual 156	a/j/b/a/c/g/e:eQ	(I)V
    //   496: iload 4
    //   498: istore_3
    //   499: goto -453 -> 46
    //   502: astore_1
    //   503: iload 7
    //   505: istore 6
    //   507: iload 6
    //   509: istore 4
    //   511: new 75	a/j/b/a/c/g/k
    //   514: dup
    //   515: aload_1
    //   516: invokevirtual 160	java/io/IOException:getMessage	()Ljava/lang/String;
    //   519: invokespecial 163	a/j/b/a/c/g/k:<init>	(Ljava/lang/String;)V
    //   522: astore_1
    //   523: iload 6
    //   525: istore 4
    //   527: aload_1
    //   528: aload_0
    //   529: putfield 135	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   532: iload 6
    //   534: istore 4
    //   536: ldc 78
    //   538: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   541: iload 6
    //   543: istore 4
    //   545: aload_1
    //   546: athrow
    //   547: iload_3
    //   548: iconst_1
    //   549: iand
    //   550: iconst_1
    //   551: if_icmpne +14 -> 565
    //   554: aload_0
    //   555: aload_0
    //   556: getfield 103	a/j/b/a/c/e/b/b$g:CpJ	Ljava/util/List;
    //   559: invokestatic 141	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   562: putfield 103	a/j/b/a/c/e/b/b$g:CpJ	Ljava/util/List;
    //   565: iload_3
    //   566: iconst_2
    //   567: iand
    //   568: iconst_2
    //   569: if_icmpne +14 -> 583
    //   572: aload_0
    //   573: aload_0
    //   574: getfield 115	a/j/b/a/c/e/b/b$g:CpK	Ljava/util/List;
    //   577: invokestatic 141	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   580: putfield 115	a/j/b/a/c/e/b/b$g:CpK	Ljava/util/List;
    //   583: aload 11
    //   585: invokevirtual 144	a/j/b/a/c/g/f:flush	()V
    //   588: aload_0
    //   589: aload 10
    //   591: invokevirtual 150	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   594: putfield 72	a/j/b/a/c/e/b/b$g:Ckp	La/j/b/a/c/g/d;
    //   597: aload_0
    //   598: invokevirtual 153	a/j/b/a/c/e/b/b$g:emL	()V
    //   601: ldc 78
    //   603: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   606: return
    //   607: astore_1
    //   608: aload_0
    //   609: aload 10
    //   611: invokevirtual 150	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   614: putfield 72	a/j/b/a/c/e/b/b$g:Ckp	La/j/b/a/c/g/d;
    //   617: goto -20 -> 597
    //   620: astore_1
    //   621: aload_0
    //   622: aload 10
    //   624: invokevirtual 150	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   627: putfield 72	a/j/b/a/c/e/b/b$g:Ckp	La/j/b/a/c/g/d;
    //   630: ldc 78
    //   632: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   635: aload_1
    //   636: athrow
    //   637: astore_2
    //   638: aload_0
    //   639: aload 10
    //   641: invokevirtual 150	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   644: putfield 72	a/j/b/a/c/e/b/b$g:Ckp	La/j/b/a/c/g/d;
    //   647: goto -180 -> 467
    //   650: astore_1
    //   651: aload_0
    //   652: aload 10
    //   654: invokevirtual 150	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   657: putfield 72	a/j/b/a/c/e/b/b$g:Ckp	La/j/b/a/c/g/d;
    //   660: ldc 78
    //   662: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   665: aload_1
    //   666: athrow
    //   667: astore_1
    //   668: iload 8
    //   670: istore 4
    //   672: goto -257 -> 415
    //   675: astore_1
    //   676: goto -169 -> 507
    //   679: astore_1
    //   680: goto -290 -> 390
    //   683: goto -451 -> 232
    //   686: goto -515 -> 171
    //   689: goto -577 -> 112
    //   692: iconst_1
    //   693: istore 5
    //   695: goto -649 -> 46
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	698	0	this	g
    //   0	698	1	parame	a.j.b.a.c.g.e
    //   0	698	2	paramg	g
    //   45	523	3	i	int
    //   64	607	4	j	int
    //   42	652	5	k	int
    //   52	490	6	m	int
    //   55	449	7	n	int
    //   58	611	8	i1	int
    //   278	214	9	i2	int
    //   31	622	10	localb	a.j.b.a.c.g.d.b
    //   39	545	11	localf	f
    // Exception table:
    //   from	to	target	type
    //   60	66	385	a/j/b/a/c/g/k
    //   121	134	385	a/j/b/a/c/g/k
    //   156	167	385	a/j/b/a/c/g/k
    //   217	228	385	a/j/b/a/c/g/k
    //   270	280	385	a/j/b/a/c/g/k
    //   302	309	385	a/j/b/a/c/g/k
    //   318	329	385	a/j/b/a/c/g/k
    //   346	353	385	a/j/b/a/c/g/k
    //   365	382	385	a/j/b/a/c/g/k
    //   490	496	385	a/j/b/a/c/g/k
    //   180	198	414	finally
    //   241	258	414	finally
    //   394	399	414	finally
    //   403	408	414	finally
    //   412	414	414	finally
    //   511	523	414	finally
    //   527	532	414	finally
    //   536	541	414	finally
    //   545	547	414	finally
    //   60	66	502	java/io/IOException
    //   121	134	502	java/io/IOException
    //   156	167	502	java/io/IOException
    //   217	228	502	java/io/IOException
    //   270	280	502	java/io/IOException
    //   302	309	502	java/io/IOException
    //   318	329	502	java/io/IOException
    //   346	353	502	java/io/IOException
    //   365	382	502	java/io/IOException
    //   490	496	502	java/io/IOException
    //   583	588	607	java/io/IOException
    //   583	588	620	finally
    //   453	458	637	java/io/IOException
    //   453	458	650	finally
    //   60	66	667	finally
    //   121	134	667	finally
    //   156	167	667	finally
    //   217	228	667	finally
    //   270	280	667	finally
    //   302	309	667	finally
    //   318	329	667	finally
    //   346	353	667	finally
    //   365	382	667	finally
    //   490	496	667	finally
    //   180	198	675	java/io/IOException
    //   241	258	675	java/io/IOException
    //   180	198	679	a/j/b/a/c/g/k
    //   241	258	679	a/j/b/a/c/g/k
  }
  
  private b$g(i.a parama)
  {
    super((byte)0);
    this.Ckp = parama.Ckp;
  }
  
  public static g e(InputStream paramInputStream, g paramg)
  {
    AppMethodBeat.i(121292);
    paramInputStream = (g)Ckq.i(paramInputStream, paramg);
    AppMethodBeat.o(121292);
    return paramInputStream;
  }
  
  private void egZ()
  {
    AppMethodBeat.i(121289);
    this.CpJ = Collections.emptyList();
    this.CpK = Collections.emptyList();
    AppMethodBeat.o(121289);
  }
  
  public static g elC()
  {
    return CpI;
  }
  
  public final void a(f paramf)
  {
    int j = 0;
    AppMethodBeat.i(121290);
    sy();
    int i = 0;
    while (i < this.CpJ.size())
    {
      paramf.a(1, (q)this.CpJ.get(i));
      i += 1;
    }
    i = j;
    if (this.CpK.size() > 0)
    {
      paramf.eX(42);
      paramf.eX(this.CpL);
      i = j;
    }
    while (i < this.CpK.size())
    {
      paramf.VG(((Integer)this.CpK.get(i)).intValue());
      i += 1;
    }
    paramf.d(this.Ckp);
    AppMethodBeat.o(121290);
  }
  
  public final s<g> egX()
  {
    return Ckq;
  }
  
  public final boolean isInitialized()
  {
    int i = this.Cku;
    if (i == 1) {
      return true;
    }
    if (i == 0) {
      return false;
    }
    this.Cku = 1;
    return true;
  }
  
  public final int sy()
  {
    AppMethodBeat.i(121291);
    int i = this.Ckv;
    if (i != -1)
    {
      AppMethodBeat.o(121291);
      return i;
    }
    int j = 0;
    i = 0;
    while (j < this.CpJ.size())
    {
      i += f.c(1, (q)this.CpJ.get(j));
      j += 1;
    }
    int k = 0;
    int m;
    for (j = 0; k < this.CpK.size(); j = m + j)
    {
      m = f.eU(((Integer)this.CpK.get(k)).intValue());
      k += 1;
    }
    k = i + j;
    i = k;
    if (!this.CpK.isEmpty()) {
      i = k + 1 + f.eU(j);
    }
    this.CpL = j;
    i += this.Ckp.size();
    this.Ckv = i;
    AppMethodBeat.o(121291);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.c.e.b.b.g
 * JD-Core Version:    0.7.0.1
 */