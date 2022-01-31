package a.j.b.a.c.e;

import a.j.b.a.c.g.d;
import a.j.b.a.c.g.f;
import a.j.b.a.c.g.i;
import a.j.b.a.c.g.i.a;
import a.j.b.a.c.g.s;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a$ak
  extends i
  implements a.al
{
  public static s<ak> Ckq;
  private static final ak CnF;
  private final d Ckp;
  private int Ckr;
  private byte Cku = -1;
  private int Ckv = -1;
  public int CnG;
  public int CnH;
  public a.ak.b CnI;
  public int CnJ;
  public int CnK;
  public a.ak.c CnL;
  
  static
  {
    AppMethodBeat.i(121036);
    Ckq = new a.ak.1();
    ak localak = new ak();
    CnF = localak;
    localak.egZ();
    AppMethodBeat.o(121036);
  }
  
  private a$ak()
  {
    this.Ckp = d.Cre;
  }
  
  /* Error */
  private a$ak(a.j.b.a.c.g.e parame, a.j.b.a.c.g.g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 62	a/j/b/a/c/g/i:<init>	()V
    //   4: ldc 79
    //   6: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 64	a/j/b/a/c/e/a$ak:Cku	B
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 66	a/j/b/a/c/e/a$ak:Ckv	I
    //   19: aload_0
    //   20: invokespecial 57	a/j/b/a/c/e/a$ak:egZ	()V
    //   23: invokestatic 83	a/j/b/a/c/g/d:emp	()La/j/b/a/c/g/d$b;
    //   26: astore 6
    //   28: aload 6
    //   30: iconst_1
    //   31: invokestatic 89	a/j/b/a/c/g/f:e	(Ljava/io/OutputStream;I)La/j/b/a/c/g/f;
    //   34: astore 7
    //   36: iconst_0
    //   37: istore_3
    //   38: iload_3
    //   39: ifne +354 -> 393
    //   42: aload_1
    //   43: invokevirtual 95	a/j/b/a/c/g/e:sk	()I
    //   46: istore 4
    //   48: iload 4
    //   50: lookupswitch	default:+427->477, 0:+430->480, 8:+84->134, 16:+144->194, 24:+190->240, 32:+244->294, 40:+266->316, 48:+288->338
    //   117: aload_1
    //   118: aload 7
    //   120: aload_2
    //   121: iload 4
    //   123: invokevirtual 99	a/j/b/a/c/e/a$ak:a	(La/j/b/a/c/g/e;La/j/b/a/c/g/f;La/j/b/a/c/g/g;I)Z
    //   126: ifne -88 -> 38
    //   129: iconst_1
    //   130: istore_3
    //   131: goto -93 -> 38
    //   134: aload_0
    //   135: aload_0
    //   136: getfield 101	a/j/b/a/c/e/a$ak:Ckr	I
    //   139: iconst_1
    //   140: ior
    //   141: putfield 101	a/j/b/a/c/e/a$ak:Ckr	I
    //   144: aload_0
    //   145: aload_1
    //   146: invokevirtual 104	a/j/b/a/c/g/e:sl	()I
    //   149: putfield 106	a/j/b/a/c/e/a$ak:CnG	I
    //   152: goto -114 -> 38
    //   155: astore_1
    //   156: aload_1
    //   157: aload_0
    //   158: putfield 110	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   161: ldc 79
    //   163: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   166: aload_1
    //   167: athrow
    //   168: astore_1
    //   169: aload 7
    //   171: invokevirtual 113	a/j/b/a/c/g/f:flush	()V
    //   174: aload_0
    //   175: aload 6
    //   177: invokevirtual 119	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   180: putfield 73	a/j/b/a/c/e/a$ak:Ckp	La/j/b/a/c/g/d;
    //   183: aload_0
    //   184: invokevirtual 122	a/j/b/a/c/e/a$ak:emL	()V
    //   187: ldc 79
    //   189: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   192: aload_1
    //   193: athrow
    //   194: aload_0
    //   195: aload_0
    //   196: getfield 101	a/j/b/a/c/e/a$ak:Ckr	I
    //   199: iconst_2
    //   200: ior
    //   201: putfield 101	a/j/b/a/c/e/a$ak:Ckr	I
    //   204: aload_0
    //   205: aload_1
    //   206: invokevirtual 104	a/j/b/a/c/g/e:sl	()I
    //   209: putfield 124	a/j/b/a/c/e/a$ak:CnH	I
    //   212: goto -174 -> 38
    //   215: astore_1
    //   216: new 76	a/j/b/a/c/g/k
    //   219: dup
    //   220: aload_1
    //   221: invokevirtual 128	java/io/IOException:getMessage	()Ljava/lang/String;
    //   224: invokespecial 131	a/j/b/a/c/g/k:<init>	(Ljava/lang/String;)V
    //   227: astore_1
    //   228: aload_1
    //   229: aload_0
    //   230: putfield 110	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   233: ldc 79
    //   235: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   238: aload_1
    //   239: athrow
    //   240: aload_1
    //   241: invokevirtual 104	a/j/b/a/c/g/e:sl	()I
    //   244: istore 5
    //   246: iload 5
    //   248: invokestatic 135	a/j/b/a/c/e/a$ak$b:Vl	(I)La/j/b/a/c/e/a$ak$b;
    //   251: astore 8
    //   253: aload 8
    //   255: ifnonnull +20 -> 275
    //   258: aload 7
    //   260: iload 4
    //   262: invokevirtual 138	a/j/b/a/c/g/f:eX	(I)V
    //   265: aload 7
    //   267: iload 5
    //   269: invokevirtual 138	a/j/b/a/c/g/f:eX	(I)V
    //   272: goto -234 -> 38
    //   275: aload_0
    //   276: aload_0
    //   277: getfield 101	a/j/b/a/c/e/a$ak:Ckr	I
    //   280: iconst_4
    //   281: ior
    //   282: putfield 101	a/j/b/a/c/e/a$ak:Ckr	I
    //   285: aload_0
    //   286: aload 8
    //   288: putfield 140	a/j/b/a/c/e/a$ak:CnI	La/j/b/a/c/e/a$ak$b;
    //   291: goto -253 -> 38
    //   294: aload_0
    //   295: aload_0
    //   296: getfield 101	a/j/b/a/c/e/a$ak:Ckr	I
    //   299: bipush 8
    //   301: ior
    //   302: putfield 101	a/j/b/a/c/e/a$ak:Ckr	I
    //   305: aload_0
    //   306: aload_1
    //   307: invokevirtual 104	a/j/b/a/c/g/e:sl	()I
    //   310: putfield 142	a/j/b/a/c/e/a$ak:CnJ	I
    //   313: goto -275 -> 38
    //   316: aload_0
    //   317: aload_0
    //   318: getfield 101	a/j/b/a/c/e/a$ak:Ckr	I
    //   321: bipush 16
    //   323: ior
    //   324: putfield 101	a/j/b/a/c/e/a$ak:Ckr	I
    //   327: aload_0
    //   328: aload_1
    //   329: invokevirtual 104	a/j/b/a/c/g/e:sl	()I
    //   332: putfield 144	a/j/b/a/c/e/a$ak:CnK	I
    //   335: goto -297 -> 38
    //   338: aload_1
    //   339: invokevirtual 104	a/j/b/a/c/g/e:sl	()I
    //   342: istore 5
    //   344: iload 5
    //   346: invokestatic 148	a/j/b/a/c/e/a$ak$c:Vm	(I)La/j/b/a/c/e/a$ak$c;
    //   349: astore 8
    //   351: aload 8
    //   353: ifnonnull +20 -> 373
    //   356: aload 7
    //   358: iload 4
    //   360: invokevirtual 138	a/j/b/a/c/g/f:eX	(I)V
    //   363: aload 7
    //   365: iload 5
    //   367: invokevirtual 138	a/j/b/a/c/g/f:eX	(I)V
    //   370: goto -332 -> 38
    //   373: aload_0
    //   374: aload_0
    //   375: getfield 101	a/j/b/a/c/e/a$ak:Ckr	I
    //   378: bipush 32
    //   380: ior
    //   381: putfield 101	a/j/b/a/c/e/a$ak:Ckr	I
    //   384: aload_0
    //   385: aload 8
    //   387: putfield 150	a/j/b/a/c/e/a$ak:CnL	La/j/b/a/c/e/a$ak$c;
    //   390: goto -352 -> 38
    //   393: aload 7
    //   395: invokevirtual 113	a/j/b/a/c/g/f:flush	()V
    //   398: aload_0
    //   399: aload 6
    //   401: invokevirtual 119	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   404: putfield 73	a/j/b/a/c/e/a$ak:Ckp	La/j/b/a/c/g/d;
    //   407: aload_0
    //   408: invokevirtual 122	a/j/b/a/c/e/a$ak:emL	()V
    //   411: ldc 79
    //   413: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   416: return
    //   417: astore_1
    //   418: aload_0
    //   419: aload 6
    //   421: invokevirtual 119	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   424: putfield 73	a/j/b/a/c/e/a$ak:Ckp	La/j/b/a/c/g/d;
    //   427: goto -20 -> 407
    //   430: astore_1
    //   431: aload_0
    //   432: aload 6
    //   434: invokevirtual 119	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   437: putfield 73	a/j/b/a/c/e/a$ak:Ckp	La/j/b/a/c/g/d;
    //   440: ldc 79
    //   442: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   445: aload_1
    //   446: athrow
    //   447: astore_2
    //   448: aload_0
    //   449: aload 6
    //   451: invokevirtual 119	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   454: putfield 73	a/j/b/a/c/e/a$ak:Ckp	La/j/b/a/c/g/d;
    //   457: goto -274 -> 183
    //   460: astore_1
    //   461: aload_0
    //   462: aload 6
    //   464: invokevirtual 119	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   467: putfield 73	a/j/b/a/c/e/a$ak:Ckp	La/j/b/a/c/g/d;
    //   470: ldc 79
    //   472: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   475: aload_1
    //   476: athrow
    //   477: goto -361 -> 116
    //   480: iconst_1
    //   481: istore_3
    //   482: goto -444 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	485	0	this	ak
    //   0	485	1	parame	a.j.b.a.c.g.e
    //   0	485	2	paramg	a.j.b.a.c.g.g
    //   37	445	3	i	int
    //   46	313	4	j	int
    //   244	122	5	k	int
    //   26	437	6	localb	a.j.b.a.c.g.d.b
    //   34	360	7	localf	f
    //   251	135	8	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   42	48	155	a/j/b/a/c/g/k
    //   116	129	155	a/j/b/a/c/g/k
    //   134	152	155	a/j/b/a/c/g/k
    //   194	212	155	a/j/b/a/c/g/k
    //   240	253	155	a/j/b/a/c/g/k
    //   258	272	155	a/j/b/a/c/g/k
    //   275	291	155	a/j/b/a/c/g/k
    //   294	313	155	a/j/b/a/c/g/k
    //   316	335	155	a/j/b/a/c/g/k
    //   338	351	155	a/j/b/a/c/g/k
    //   356	370	155	a/j/b/a/c/g/k
    //   373	390	155	a/j/b/a/c/g/k
    //   42	48	168	finally
    //   116	129	168	finally
    //   134	152	168	finally
    //   156	168	168	finally
    //   194	212	168	finally
    //   216	240	168	finally
    //   240	253	168	finally
    //   258	272	168	finally
    //   275	291	168	finally
    //   294	313	168	finally
    //   316	335	168	finally
    //   338	351	168	finally
    //   356	370	168	finally
    //   373	390	168	finally
    //   42	48	215	java/io/IOException
    //   116	129	215	java/io/IOException
    //   134	152	215	java/io/IOException
    //   194	212	215	java/io/IOException
    //   240	253	215	java/io/IOException
    //   258	272	215	java/io/IOException
    //   275	291	215	java/io/IOException
    //   294	313	215	java/io/IOException
    //   316	335	215	java/io/IOException
    //   338	351	215	java/io/IOException
    //   356	370	215	java/io/IOException
    //   373	390	215	java/io/IOException
    //   393	398	417	java/io/IOException
    //   393	398	430	finally
    //   169	174	447	java/io/IOException
    //   169	174	460	finally
  }
  
  private a$ak(i.a parama)
  {
    super((byte)0);
    this.Ckp = parama.Ckp;
  }
  
  private void egZ()
  {
    this.CnG = 0;
    this.CnH = 0;
    this.CnI = a.ak.b.CnN;
    this.CnJ = 0;
    this.CnK = 0;
    this.CnL = a.ak.c.CnQ;
  }
  
  public static ak ekx()
  {
    return CnF;
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(121032);
    sy();
    if ((this.Ckr & 0x1) == 1) {
      paramf.bj(1, this.CnG);
    }
    if ((this.Ckr & 0x2) == 2) {
      paramf.bj(2, this.CnH);
    }
    if ((this.Ckr & 0x4) == 4) {
      paramf.iG(3, this.CnI.value);
    }
    if ((this.Ckr & 0x8) == 8) {
      paramf.bj(4, this.CnJ);
    }
    if ((this.Ckr & 0x10) == 16) {
      paramf.bj(5, this.CnK);
    }
    if ((this.Ckr & 0x20) == 32) {
      paramf.iG(6, this.CnL.value);
    }
    paramf.d(this.Ckp);
    AppMethodBeat.o(121032);
  }
  
  public final s<ak> egX()
  {
    return Ckq;
  }
  
  public final boolean ekA()
  {
    return (this.Ckr & 0x4) == 4;
  }
  
  public final boolean ekB()
  {
    return (this.Ckr & 0x8) == 8;
  }
  
  public final boolean ekC()
  {
    return (this.Ckr & 0x10) == 16;
  }
  
  public final boolean ekD()
  {
    return (this.Ckr & 0x20) == 32;
  }
  
  public final boolean eky()
  {
    return (this.Ckr & 0x1) == 1;
  }
  
  public final boolean ekz()
  {
    return (this.Ckr & 0x2) == 2;
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
    AppMethodBeat.i(121033);
    int i = this.Ckv;
    if (i != -1)
    {
      AppMethodBeat.o(121033);
      return i;
    }
    int j = 0;
    if ((this.Ckr & 0x1) == 1) {
      j = f.bl(1, this.CnG) + 0;
    }
    i = j;
    if ((this.Ckr & 0x2) == 2) {
      i = j + f.bl(2, this.CnH);
    }
    j = i;
    if ((this.Ckr & 0x4) == 4) {
      j = i + f.iH(3, this.CnI.value);
    }
    i = j;
    if ((this.Ckr & 0x8) == 8) {
      i = j + f.bl(4, this.CnJ);
    }
    j = i;
    if ((this.Ckr & 0x10) == 16) {
      j = i + f.bl(5, this.CnK);
    }
    i = j;
    if ((this.Ckr & 0x20) == 32) {
      i = j + f.iH(6, this.CnL.value);
    }
    i += this.Ckp.size();
    this.Ckv = i;
    AppMethodBeat.o(121033);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.c.e.a.ak
 * JD-Core Version:    0.7.0.1
 */