package a.j.b.a.c.e;

import a.j.b.a.c.g.d;
import a.j.b.a.c.g.f;
import a.j.b.a.c.g.h;
import a.j.b.a.c.g.i.a;
import a.j.b.a.c.g.i.b;
import a.j.b.a.c.g.i.c;
import a.j.b.a.c.g.i.c.a;
import a.j.b.a.c.g.s;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a$ai
  extends i.c<ai>
  implements a.aj
{
  public static s<ai> Ckq;
  private static final ai CnC;
  public int CkK;
  private final d Ckp;
  private int Ckr;
  private byte Cku = -1;
  private int Ckv = -1;
  public int ClT;
  public a.aa CnD;
  public int CnE;
  public a.aa Cnc;
  public int Cnd;
  
  static
  {
    AppMethodBeat.i(121005);
    Ckq = new a.ai.1();
    ai localai = new ai();
    CnC = localai;
    localai.egZ();
    AppMethodBeat.o(121005);
  }
  
  private a$ai()
  {
    this.Ckp = d.Cre;
  }
  
  /* Error */
  private a$ai(a.j.b.a.c.g.e parame, a.j.b.a.c.g.g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 58	a/j/b/a/c/g/i$c:<init>	()V
    //   4: ldc 75
    //   6: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 60	a/j/b/a/c/e/a$ai:Cku	B
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 62	a/j/b/a/c/e/a$ai:Ckv	I
    //   19: aload_0
    //   20: invokespecial 53	a/j/b/a/c/e/a$ai:egZ	()V
    //   23: invokestatic 79	a/j/b/a/c/g/d:emp	()La/j/b/a/c/g/d$b;
    //   26: astore 6
    //   28: aload 6
    //   30: iconst_1
    //   31: invokestatic 85	a/j/b/a/c/g/f:e	(Ljava/io/OutputStream;I)La/j/b/a/c/g/f;
    //   34: astore 7
    //   36: iconst_0
    //   37: istore_3
    //   38: iload_3
    //   39: ifne +393 -> 432
    //   42: aload_1
    //   43: invokevirtual 91	a/j/b/a/c/g/e:sk	()I
    //   46: istore 4
    //   48: iload 4
    //   50: lookupswitch	default:+481->531, 0:+484->534, 8:+84->134, 16:+147->197, 26:+193->243, 34:+264->314, 40:+338->388, 48:+360->410
    //   117: aload_1
    //   118: aload 7
    //   120: aload_2
    //   121: iload 4
    //   123: invokevirtual 95	a/j/b/a/c/e/a$ai:a	(La/j/b/a/c/g/e;La/j/b/a/c/g/f;La/j/b/a/c/g/g;I)Z
    //   126: ifne -88 -> 38
    //   129: iconst_1
    //   130: istore_3
    //   131: goto -93 -> 38
    //   134: aload_0
    //   135: aload_0
    //   136: getfield 97	a/j/b/a/c/e/a$ai:Ckr	I
    //   139: iconst_1
    //   140: ior
    //   141: putfield 97	a/j/b/a/c/e/a$ai:Ckr	I
    //   144: aload_0
    //   145: aload_1
    //   146: invokevirtual 100	a/j/b/a/c/g/e:sl	()I
    //   149: putfield 102	a/j/b/a/c/e/a$ai:CkK	I
    //   152: goto -114 -> 38
    //   155: astore_1
    //   156: aload_1
    //   157: aload_0
    //   158: putfield 106	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   161: ldc 75
    //   163: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   166: aload_1
    //   167: athrow
    //   168: astore_1
    //   169: aload 7
    //   171: invokevirtual 109	a/j/b/a/c/g/f:flush	()V
    //   174: aload_0
    //   175: aload 6
    //   177: invokevirtual 115	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   180: putfield 69	a/j/b/a/c/e/a$ai:Ckp	La/j/b/a/c/g/d;
    //   183: aload_0
    //   184: getfield 119	a/j/b/a/c/g/i$c:Crw	La/j/b/a/c/g/h;
    //   187: invokevirtual 124	a/j/b/a/c/g/h:emF	()V
    //   190: ldc 75
    //   192: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   195: aload_1
    //   196: athrow
    //   197: aload_0
    //   198: aload_0
    //   199: getfield 97	a/j/b/a/c/e/a$ai:Ckr	I
    //   202: iconst_2
    //   203: ior
    //   204: putfield 97	a/j/b/a/c/e/a$ai:Ckr	I
    //   207: aload_0
    //   208: aload_1
    //   209: invokevirtual 100	a/j/b/a/c/g/e:sl	()I
    //   212: putfield 126	a/j/b/a/c/e/a$ai:ClT	I
    //   215: goto -177 -> 38
    //   218: astore_1
    //   219: new 72	a/j/b/a/c/g/k
    //   222: dup
    //   223: aload_1
    //   224: invokevirtual 130	java/io/IOException:getMessage	()Ljava/lang/String;
    //   227: invokespecial 133	a/j/b/a/c/g/k:<init>	(Ljava/lang/String;)V
    //   230: astore_1
    //   231: aload_1
    //   232: aload_0
    //   233: putfield 106	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   236: ldc 75
    //   238: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   241: aload_1
    //   242: athrow
    //   243: aload_0
    //   244: getfield 97	a/j/b/a/c/e/a$ai:Ckr	I
    //   247: iconst_4
    //   248: iand
    //   249: iconst_4
    //   250: if_icmpne +275 -> 525
    //   253: aload_0
    //   254: getfield 135	a/j/b/a/c/e/a$ai:Cnc	La/j/b/a/c/e/a$aa;
    //   257: invokevirtual 141	a/j/b/a/c/e/a$aa:ejJ	()La/j/b/a/c/e/a$aa$c;
    //   260: astore 5
    //   262: aload_0
    //   263: aload_1
    //   264: getstatic 142	a/j/b/a/c/e/a$aa:Ckq	La/j/b/a/c/g/s;
    //   267: aload_2
    //   268: invokevirtual 145	a/j/b/a/c/g/e:a	(La/j/b/a/c/g/s;La/j/b/a/c/g/g;)La/j/b/a/c/g/q;
    //   271: checkcast 137	a/j/b/a/c/e/a$aa
    //   274: putfield 135	a/j/b/a/c/e/a$ai:Cnc	La/j/b/a/c/e/a$aa;
    //   277: aload 5
    //   279: ifnull +22 -> 301
    //   282: aload 5
    //   284: aload_0
    //   285: getfield 135	a/j/b/a/c/e/a$ai:Cnc	La/j/b/a/c/e/a$aa;
    //   288: invokevirtual 151	a/j/b/a/c/e/a$aa$c:j	(La/j/b/a/c/e/a$aa;)La/j/b/a/c/e/a$aa$c;
    //   291: pop
    //   292: aload_0
    //   293: aload 5
    //   295: invokevirtual 155	a/j/b/a/c/e/a$aa$c:ejS	()La/j/b/a/c/e/a$aa;
    //   298: putfield 135	a/j/b/a/c/e/a$ai:Cnc	La/j/b/a/c/e/a$aa;
    //   301: aload_0
    //   302: aload_0
    //   303: getfield 97	a/j/b/a/c/e/a$ai:Ckr	I
    //   306: iconst_4
    //   307: ior
    //   308: putfield 97	a/j/b/a/c/e/a$ai:Ckr	I
    //   311: goto -273 -> 38
    //   314: aload_0
    //   315: getfield 97	a/j/b/a/c/e/a$ai:Ckr	I
    //   318: bipush 16
    //   320: iand
    //   321: bipush 16
    //   323: if_icmpne +196 -> 519
    //   326: aload_0
    //   327: getfield 157	a/j/b/a/c/e/a$ai:CnD	La/j/b/a/c/e/a$aa;
    //   330: invokevirtual 141	a/j/b/a/c/e/a$aa:ejJ	()La/j/b/a/c/e/a$aa$c;
    //   333: astore 5
    //   335: aload_0
    //   336: aload_1
    //   337: getstatic 142	a/j/b/a/c/e/a$aa:Ckq	La/j/b/a/c/g/s;
    //   340: aload_2
    //   341: invokevirtual 145	a/j/b/a/c/g/e:a	(La/j/b/a/c/g/s;La/j/b/a/c/g/g;)La/j/b/a/c/g/q;
    //   344: checkcast 137	a/j/b/a/c/e/a$aa
    //   347: putfield 157	a/j/b/a/c/e/a$ai:CnD	La/j/b/a/c/e/a$aa;
    //   350: aload 5
    //   352: ifnull +22 -> 374
    //   355: aload 5
    //   357: aload_0
    //   358: getfield 157	a/j/b/a/c/e/a$ai:CnD	La/j/b/a/c/e/a$aa;
    //   361: invokevirtual 151	a/j/b/a/c/e/a$aa$c:j	(La/j/b/a/c/e/a$aa;)La/j/b/a/c/e/a$aa$c;
    //   364: pop
    //   365: aload_0
    //   366: aload 5
    //   368: invokevirtual 155	a/j/b/a/c/e/a$aa$c:ejS	()La/j/b/a/c/e/a$aa;
    //   371: putfield 157	a/j/b/a/c/e/a$ai:CnD	La/j/b/a/c/e/a$aa;
    //   374: aload_0
    //   375: aload_0
    //   376: getfield 97	a/j/b/a/c/e/a$ai:Ckr	I
    //   379: bipush 16
    //   381: ior
    //   382: putfield 97	a/j/b/a/c/e/a$ai:Ckr	I
    //   385: goto -347 -> 38
    //   388: aload_0
    //   389: aload_0
    //   390: getfield 97	a/j/b/a/c/e/a$ai:Ckr	I
    //   393: bipush 8
    //   395: ior
    //   396: putfield 97	a/j/b/a/c/e/a$ai:Ckr	I
    //   399: aload_0
    //   400: aload_1
    //   401: invokevirtual 100	a/j/b/a/c/g/e:sl	()I
    //   404: putfield 159	a/j/b/a/c/e/a$ai:Cnd	I
    //   407: goto -369 -> 38
    //   410: aload_0
    //   411: aload_0
    //   412: getfield 97	a/j/b/a/c/e/a$ai:Ckr	I
    //   415: bipush 32
    //   417: ior
    //   418: putfield 97	a/j/b/a/c/e/a$ai:Ckr	I
    //   421: aload_0
    //   422: aload_1
    //   423: invokevirtual 100	a/j/b/a/c/g/e:sl	()I
    //   426: putfield 161	a/j/b/a/c/e/a$ai:CnE	I
    //   429: goto -391 -> 38
    //   432: aload 7
    //   434: invokevirtual 109	a/j/b/a/c/g/f:flush	()V
    //   437: aload_0
    //   438: aload 6
    //   440: invokevirtual 115	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   443: putfield 69	a/j/b/a/c/e/a$ai:Ckp	La/j/b/a/c/g/d;
    //   446: aload_0
    //   447: getfield 119	a/j/b/a/c/g/i$c:Crw	La/j/b/a/c/g/h;
    //   450: invokevirtual 124	a/j/b/a/c/g/h:emF	()V
    //   453: ldc 75
    //   455: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   458: return
    //   459: astore_1
    //   460: aload_0
    //   461: aload 6
    //   463: invokevirtual 115	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   466: putfield 69	a/j/b/a/c/e/a$ai:Ckp	La/j/b/a/c/g/d;
    //   469: goto -23 -> 446
    //   472: astore_1
    //   473: aload_0
    //   474: aload 6
    //   476: invokevirtual 115	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   479: putfield 69	a/j/b/a/c/e/a$ai:Ckp	La/j/b/a/c/g/d;
    //   482: ldc 75
    //   484: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   487: aload_1
    //   488: athrow
    //   489: astore_2
    //   490: aload_0
    //   491: aload 6
    //   493: invokevirtual 115	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   496: putfield 69	a/j/b/a/c/e/a$ai:Ckp	La/j/b/a/c/g/d;
    //   499: goto -316 -> 183
    //   502: astore_1
    //   503: aload_0
    //   504: aload 6
    //   506: invokevirtual 115	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   509: putfield 69	a/j/b/a/c/e/a$ai:Ckp	La/j/b/a/c/g/d;
    //   512: ldc 75
    //   514: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   517: aload_1
    //   518: athrow
    //   519: aconst_null
    //   520: astore 5
    //   522: goto -187 -> 335
    //   525: aconst_null
    //   526: astore 5
    //   528: goto -266 -> 262
    //   531: goto -415 -> 116
    //   534: iconst_1
    //   535: istore_3
    //   536: goto -498 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	539	0	this	ai
    //   0	539	1	parame	a.j.b.a.c.g.e
    //   0	539	2	paramg	a.j.b.a.c.g.g
    //   37	499	3	i	int
    //   46	76	4	j	int
    //   260	267	5	localc	a.aa.c
    //   26	479	6	localb	a.j.b.a.c.g.d.b
    //   34	399	7	localf	f
    // Exception table:
    //   from	to	target	type
    //   42	48	155	a/j/b/a/c/g/k
    //   116	129	155	a/j/b/a/c/g/k
    //   134	152	155	a/j/b/a/c/g/k
    //   197	215	155	a/j/b/a/c/g/k
    //   243	262	155	a/j/b/a/c/g/k
    //   262	277	155	a/j/b/a/c/g/k
    //   282	301	155	a/j/b/a/c/g/k
    //   301	311	155	a/j/b/a/c/g/k
    //   314	335	155	a/j/b/a/c/g/k
    //   335	350	155	a/j/b/a/c/g/k
    //   355	374	155	a/j/b/a/c/g/k
    //   374	385	155	a/j/b/a/c/g/k
    //   388	407	155	a/j/b/a/c/g/k
    //   410	429	155	a/j/b/a/c/g/k
    //   42	48	168	finally
    //   116	129	168	finally
    //   134	152	168	finally
    //   156	168	168	finally
    //   197	215	168	finally
    //   219	243	168	finally
    //   243	262	168	finally
    //   262	277	168	finally
    //   282	301	168	finally
    //   301	311	168	finally
    //   314	335	168	finally
    //   335	350	168	finally
    //   355	374	168	finally
    //   374	385	168	finally
    //   388	407	168	finally
    //   410	429	168	finally
    //   42	48	218	java/io/IOException
    //   116	129	218	java/io/IOException
    //   134	152	218	java/io/IOException
    //   197	215	218	java/io/IOException
    //   243	262	218	java/io/IOException
    //   262	277	218	java/io/IOException
    //   282	301	218	java/io/IOException
    //   301	311	218	java/io/IOException
    //   314	335	218	java/io/IOException
    //   335	350	218	java/io/IOException
    //   355	374	218	java/io/IOException
    //   374	385	218	java/io/IOException
    //   388	407	218	java/io/IOException
    //   410	429	218	java/io/IOException
    //   432	437	459	java/io/IOException
    //   432	437	472	finally
    //   169	174	489	java/io/IOException
    //   169	174	502	finally
  }
  
  private a$ai(i.b<ai, ?> paramb)
  {
    super(paramb);
    this.Ckp = paramb.Ckp;
  }
  
  public static a.ai.a b(ai paramai)
  {
    AppMethodBeat.i(121002);
    paramai = a.ai.a.ekw().d(paramai);
    AppMethodBeat.o(121002);
    return paramai;
  }
  
  private void egZ()
  {
    AppMethodBeat.i(120998);
    this.CkK = 0;
    this.ClT = 0;
    this.Cnc = a.aa.ejw();
    this.Cnd = 0;
    this.CnD = a.aa.ejw();
    this.CnE = 0;
    AppMethodBeat.o(120998);
  }
  
  public static ai ekr()
  {
    return CnC;
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(121000);
    sy();
    i.c.a locala = emM();
    if ((this.Ckr & 0x1) == 1) {
      paramf.bj(1, this.CkK);
    }
    if ((this.Ckr & 0x2) == 2) {
      paramf.bj(2, this.ClT);
    }
    if ((this.Ckr & 0x4) == 4) {
      paramf.a(3, this.Cnc);
    }
    if ((this.Ckr & 0x10) == 16) {
      paramf.a(4, this.CnD);
    }
    if ((this.Ckr & 0x8) == 8) {
      paramf.bj(5, this.Cnd);
    }
    if ((this.Ckr & 0x20) == 32) {
      paramf.bj(6, this.CnE);
    }
    locala.b(200, paramf);
    paramf.d(this.Ckp);
    AppMethodBeat.o(121000);
  }
  
  public final s<ai> egX()
  {
    return Ckq;
  }
  
  public final boolean eho()
  {
    return (this.Ckr & 0x4) == 4;
  }
  
  public final boolean ehx()
  {
    return (this.Ckr & 0x1) == 1;
  }
  
  public final boolean eiv()
  {
    return (this.Ckr & 0x2) == 2;
  }
  
  public final boolean ejM()
  {
    return (this.Ckr & 0x8) == 8;
  }
  
  public final boolean eks()
  {
    return (this.Ckr & 0x10) == 16;
  }
  
  public final boolean ekt()
  {
    return (this.Ckr & 0x20) == 32;
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(120999);
    int i = this.Cku;
    if (i == 1)
    {
      AppMethodBeat.o(120999);
      return true;
    }
    if (i == 0)
    {
      AppMethodBeat.o(120999);
      return false;
    }
    if (!eiv())
    {
      this.Cku = 0;
      AppMethodBeat.o(120999);
      return false;
    }
    if ((eho()) && (!this.Cnc.isInitialized()))
    {
      this.Cku = 0;
      AppMethodBeat.o(120999);
      return false;
    }
    if ((eks()) && (!this.CnD.isInitialized()))
    {
      this.Cku = 0;
      AppMethodBeat.o(120999);
      return false;
    }
    if (!this.Crw.isInitialized())
    {
      this.Cku = 0;
      AppMethodBeat.o(120999);
      return false;
    }
    this.Cku = 1;
    AppMethodBeat.o(120999);
    return true;
  }
  
  public final int sy()
  {
    AppMethodBeat.i(121001);
    int i = this.Ckv;
    if (i != -1)
    {
      AppMethodBeat.o(121001);
      return i;
    }
    int j = 0;
    if ((this.Ckr & 0x1) == 1) {
      j = f.bl(1, this.CkK) + 0;
    }
    i = j;
    if ((this.Ckr & 0x2) == 2) {
      i = j + f.bl(2, this.ClT);
    }
    j = i;
    if ((this.Ckr & 0x4) == 4) {
      j = i + f.c(3, this.Cnc);
    }
    i = j;
    if ((this.Ckr & 0x10) == 16) {
      i = j + f.c(4, this.CnD);
    }
    j = i;
    if ((this.Ckr & 0x8) == 8) {
      j = i + f.bl(5, this.Cnd);
    }
    i = j;
    if ((this.Ckr & 0x20) == 32) {
      i = j + f.bl(6, this.CnE);
    }
    i = i + this.Crw.sy() + this.Ckp.size();
    this.Ckv = i;
    AppMethodBeat.o(121001);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.c.e.a.ai
 * JD-Core Version:    0.7.0.1
 */