package a.j.b.a.c.e;

import a.j.b.a.c.g.b;
import a.j.b.a.c.g.d;
import a.j.b.a.c.g.f;
import a.j.b.a.c.g.i;
import a.j.b.a.c.g.i.a;
import a.j.b.a.c.g.s;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a$a$a
  extends i
  implements a.a.b
{
  public static s<a> Ckq;
  private static final a Ckw;
  private final d Ckp;
  private int Ckr;
  private byte Cku = -1;
  private int Ckv = -1;
  public int Ckx;
  public a.a.a.b Cky;
  
  static
  {
    AppMethodBeat.i(120412);
    Ckq = new a.a.a.1();
    a locala = new a();
    Ckw = locala;
    locala.egZ();
    AppMethodBeat.o(120412);
  }
  
  private a$a$a()
  {
    this.Ckp = d.Cre;
  }
  
  /* Error */
  private a$a$a(a.j.b.a.c.g.e parame, a.j.b.a.c.g.g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 59	a/j/b/a/c/g/i:<init>	()V
    //   4: ldc 76
    //   6: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 61	a/j/b/a/c/e/a$a$a:Cku	B
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 63	a/j/b/a/c/e/a$a$a:Ckv	I
    //   19: aload_0
    //   20: invokespecial 54	a/j/b/a/c/e/a$a$a:egZ	()V
    //   23: invokestatic 80	a/j/b/a/c/g/d:emp	()La/j/b/a/c/g/d$b;
    //   26: astore 6
    //   28: aload 6
    //   30: iconst_1
    //   31: invokestatic 86	a/j/b/a/c/g/f:e	(Ljava/io/OutputStream;I)La/j/b/a/c/g/f;
    //   34: astore 7
    //   36: iconst_0
    //   37: istore_3
    //   38: iload_3
    //   39: ifne +219 -> 258
    //   42: aload_1
    //   43: invokevirtual 92	a/j/b/a/c/g/e:sk	()I
    //   46: istore 4
    //   48: iload 4
    //   50: lookupswitch	default:+298->348, 0:+301->351, 8:+52->102, 18:+112->162
    //   85: aload_1
    //   86: aload 7
    //   88: aload_2
    //   89: iload 4
    //   91: invokevirtual 95	a/j/b/a/c/e/a$a$a:a	(La/j/b/a/c/g/e;La/j/b/a/c/g/f;La/j/b/a/c/g/g;I)Z
    //   94: ifne -56 -> 38
    //   97: iconst_1
    //   98: istore_3
    //   99: goto -61 -> 38
    //   102: aload_0
    //   103: aload_0
    //   104: getfield 97	a/j/b/a/c/e/a$a$a:Ckr	I
    //   107: iconst_1
    //   108: ior
    //   109: putfield 97	a/j/b/a/c/e/a$a$a:Ckr	I
    //   112: aload_0
    //   113: aload_1
    //   114: invokevirtual 100	a/j/b/a/c/g/e:sl	()I
    //   117: putfield 102	a/j/b/a/c/e/a$a$a:Ckx	I
    //   120: goto -82 -> 38
    //   123: astore_1
    //   124: aload_1
    //   125: aload_0
    //   126: putfield 106	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   129: ldc 76
    //   131: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   134: aload_1
    //   135: athrow
    //   136: astore_1
    //   137: aload 7
    //   139: invokevirtual 109	a/j/b/a/c/g/f:flush	()V
    //   142: aload_0
    //   143: aload 6
    //   145: invokevirtual 115	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   148: putfield 70	a/j/b/a/c/e/a$a$a:Ckp	La/j/b/a/c/g/d;
    //   151: aload_0
    //   152: invokevirtual 118	a/j/b/a/c/e/a$a$a:emL	()V
    //   155: ldc 76
    //   157: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   160: aload_1
    //   161: athrow
    //   162: aload_0
    //   163: getfield 97	a/j/b/a/c/e/a$a$a:Ckr	I
    //   166: iconst_2
    //   167: iand
    //   168: iconst_2
    //   169: if_icmpne +173 -> 342
    //   172: aload_0
    //   173: getfield 120	a/j/b/a/c/e/a$a$a:Cky	La/j/b/a/c/e/a$a$a$b;
    //   176: invokestatic 124	a/j/b/a/c/e/a$a$a$b:b	(La/j/b/a/c/e/a$a$a$b;)La/j/b/a/c/e/a$a$a$b$a;
    //   179: astore 5
    //   181: aload_0
    //   182: aload_1
    //   183: getstatic 125	a/j/b/a/c/e/a$a$a$b:Ckq	La/j/b/a/c/g/s;
    //   186: aload_2
    //   187: invokevirtual 128	a/j/b/a/c/g/e:a	(La/j/b/a/c/g/s;La/j/b/a/c/g/g;)La/j/b/a/c/g/q;
    //   190: checkcast 13	a/j/b/a/c/e/a$a$a$b
    //   193: putfield 120	a/j/b/a/c/e/a$a$a:Cky	La/j/b/a/c/e/a$a$a$b;
    //   196: aload 5
    //   198: ifnull +22 -> 220
    //   201: aload 5
    //   203: aload_0
    //   204: getfield 120	a/j/b/a/c/e/a$a$a:Cky	La/j/b/a/c/e/a$a$a$b;
    //   207: invokevirtual 132	a/j/b/a/c/e/a$a$a$b$a:e	(La/j/b/a/c/e/a$a$a$b;)La/j/b/a/c/e/a$a$a$b$a;
    //   210: pop
    //   211: aload_0
    //   212: aload 5
    //   214: invokevirtual 136	a/j/b/a/c/e/a$a$a$b$a:ehz	()La/j/b/a/c/e/a$a$a$b;
    //   217: putfield 120	a/j/b/a/c/e/a$a$a:Cky	La/j/b/a/c/e/a$a$a$b;
    //   220: aload_0
    //   221: aload_0
    //   222: getfield 97	a/j/b/a/c/e/a$a$a:Ckr	I
    //   225: iconst_2
    //   226: ior
    //   227: putfield 97	a/j/b/a/c/e/a$a$a:Ckr	I
    //   230: goto -192 -> 38
    //   233: astore_1
    //   234: new 73	a/j/b/a/c/g/k
    //   237: dup
    //   238: aload_1
    //   239: invokevirtual 140	java/io/IOException:getMessage	()Ljava/lang/String;
    //   242: invokespecial 143	a/j/b/a/c/g/k:<init>	(Ljava/lang/String;)V
    //   245: astore_1
    //   246: aload_1
    //   247: aload_0
    //   248: putfield 106	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   251: ldc 76
    //   253: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   256: aload_1
    //   257: athrow
    //   258: aload 7
    //   260: invokevirtual 109	a/j/b/a/c/g/f:flush	()V
    //   263: aload_0
    //   264: aload 6
    //   266: invokevirtual 115	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   269: putfield 70	a/j/b/a/c/e/a$a$a:Ckp	La/j/b/a/c/g/d;
    //   272: aload_0
    //   273: invokevirtual 118	a/j/b/a/c/e/a$a$a:emL	()V
    //   276: ldc 76
    //   278: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   281: return
    //   282: astore_1
    //   283: aload_0
    //   284: aload 6
    //   286: invokevirtual 115	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   289: putfield 70	a/j/b/a/c/e/a$a$a:Ckp	La/j/b/a/c/g/d;
    //   292: goto -20 -> 272
    //   295: astore_1
    //   296: aload_0
    //   297: aload 6
    //   299: invokevirtual 115	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   302: putfield 70	a/j/b/a/c/e/a$a$a:Ckp	La/j/b/a/c/g/d;
    //   305: ldc 76
    //   307: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   310: aload_1
    //   311: athrow
    //   312: astore_2
    //   313: aload_0
    //   314: aload 6
    //   316: invokevirtual 115	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   319: putfield 70	a/j/b/a/c/e/a$a$a:Ckp	La/j/b/a/c/g/d;
    //   322: goto -171 -> 151
    //   325: astore_1
    //   326: aload_0
    //   327: aload 6
    //   329: invokevirtual 115	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   332: putfield 70	a/j/b/a/c/e/a$a$a:Ckp	La/j/b/a/c/g/d;
    //   335: ldc 76
    //   337: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   340: aload_1
    //   341: athrow
    //   342: aconst_null
    //   343: astore 5
    //   345: goto -164 -> 181
    //   348: goto -264 -> 84
    //   351: iconst_1
    //   352: istore_3
    //   353: goto -315 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	356	0	this	a
    //   0	356	1	parame	a.j.b.a.c.g.e
    //   0	356	2	paramg	a.j.b.a.c.g.g
    //   37	316	3	i	int
    //   46	44	4	j	int
    //   179	165	5	locala	a.a.a.b.a
    //   26	302	6	localb	a.j.b.a.c.g.d.b
    //   34	225	7	localf	f
    // Exception table:
    //   from	to	target	type
    //   42	48	123	a/j/b/a/c/g/k
    //   84	97	123	a/j/b/a/c/g/k
    //   102	120	123	a/j/b/a/c/g/k
    //   162	181	123	a/j/b/a/c/g/k
    //   181	196	123	a/j/b/a/c/g/k
    //   201	220	123	a/j/b/a/c/g/k
    //   220	230	123	a/j/b/a/c/g/k
    //   42	48	136	finally
    //   84	97	136	finally
    //   102	120	136	finally
    //   124	136	136	finally
    //   162	181	136	finally
    //   181	196	136	finally
    //   201	220	136	finally
    //   220	230	136	finally
    //   234	258	136	finally
    //   42	48	233	java/io/IOException
    //   84	97	233	java/io/IOException
    //   102	120	233	java/io/IOException
    //   162	181	233	java/io/IOException
    //   181	196	233	java/io/IOException
    //   201	220	233	java/io/IOException
    //   220	230	233	java/io/IOException
    //   258	263	282	java/io/IOException
    //   258	263	295	finally
    //   137	142	312	java/io/IOException
    //   137	142	325	finally
  }
  
  private a$a$a(i.a parama)
  {
    super((byte)0);
    this.Ckp = parama.Ckp;
  }
  
  private void egZ()
  {
    AppMethodBeat.i(120406);
    this.Ckx = 0;
    this.Cky = a.a.a.b.ehn();
    AppMethodBeat.o(120406);
  }
  
  public static a ehe()
  {
    return Ckw;
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(120408);
    sy();
    if ((this.Ckr & 0x1) == 1) {
      paramf.bj(1, this.Ckx);
    }
    if ((this.Ckr & 0x2) == 2) {
      paramf.a(2, this.Cky);
    }
    paramf.d(this.Ckp);
    AppMethodBeat.o(120408);
  }
  
  public final s<a> egX()
  {
    return Ckq;
  }
  
  public final boolean ehf()
  {
    return (this.Ckr & 0x1) == 1;
  }
  
  public final boolean hasValue()
  {
    return (this.Ckr & 0x2) == 2;
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(120407);
    int i = this.Cku;
    if (i == 1)
    {
      AppMethodBeat.o(120407);
      return true;
    }
    if (i == 0)
    {
      AppMethodBeat.o(120407);
      return false;
    }
    if (!ehf())
    {
      this.Cku = 0;
      AppMethodBeat.o(120407);
      return false;
    }
    if (!hasValue())
    {
      this.Cku = 0;
      AppMethodBeat.o(120407);
      return false;
    }
    if (!this.Cky.isInitialized())
    {
      this.Cku = 0;
      AppMethodBeat.o(120407);
      return false;
    }
    this.Cku = 1;
    AppMethodBeat.o(120407);
    return true;
  }
  
  public final int sy()
  {
    AppMethodBeat.i(120409);
    int i = this.Ckv;
    if (i != -1)
    {
      AppMethodBeat.o(120409);
      return i;
    }
    i = 0;
    if ((this.Ckr & 0x1) == 1) {
      i = f.bl(1, this.Ckx) + 0;
    }
    int j = i;
    if ((this.Ckr & 0x2) == 2) {
      j = i + f.c(2, this.Cky);
    }
    i = j + this.Ckp.size();
    this.Ckv = i;
    AppMethodBeat.o(120409);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.j.b.a.c.e.a.a.a
 * JD-Core Version:    0.7.0.1
 */