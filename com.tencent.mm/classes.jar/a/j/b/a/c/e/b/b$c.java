package a.j.b.a.c.e.b;

import a.j.b.a.c.g.d;
import a.j.b.a.c.g.f;
import a.j.b.a.c.g.i;
import a.j.b.a.c.g.i.a;
import a.j.b.a.c.g.s;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b$c
  extends i
  implements b.d
{
  public static s<c> Ckq;
  private static final c CpC;
  private final d Ckp;
  private int Ckr;
  private byte Cku = -1;
  private int Ckv = -1;
  public int ClT;
  public int CpB;
  
  static
  {
    AppMethodBeat.i(121208);
    Ckq = new b.c.1();
    c localc = new c();
    CpC = localc;
    localc.egZ();
    AppMethodBeat.o(121208);
  }
  
  private b$c()
  {
    this.Ckp = d.Cre;
  }
  
  /* Error */
  private b$c(a.j.b.a.c.g.e parame, a.j.b.a.c.g.g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 52	a/j/b/a/c/g/i:<init>	()V
    //   4: ldc 69
    //   6: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 54	a/j/b/a/c/e/b/b$c:Cku	B
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 56	a/j/b/a/c/e/b/b$c:Ckv	I
    //   19: aload_0
    //   20: invokespecial 47	a/j/b/a/c/e/b/b$c:egZ	()V
    //   23: invokestatic 73	a/j/b/a/c/g/d:emp	()La/j/b/a/c/g/d$b;
    //   26: astore 5
    //   28: aload 5
    //   30: iconst_1
    //   31: invokestatic 79	a/j/b/a/c/g/f:e	(Ljava/io/OutputStream;I)La/j/b/a/c/g/f;
    //   34: astore 6
    //   36: iconst_0
    //   37: istore_3
    //   38: iload_3
    //   39: ifne +169 -> 208
    //   42: aload_1
    //   43: invokevirtual 85	a/j/b/a/c/g/e:sk	()I
    //   46: istore 4
    //   48: iload 4
    //   50: lookupswitch	default:+242->292, 0:+245->295, 8:+52->102, 16:+112->162
    //   85: aload_1
    //   86: aload 6
    //   88: aload_2
    //   89: iload 4
    //   91: invokevirtual 89	a/j/b/a/c/e/b/b$c:a	(La/j/b/a/c/g/e;La/j/b/a/c/g/f;La/j/b/a/c/g/g;I)Z
    //   94: ifne -56 -> 38
    //   97: iconst_1
    //   98: istore_3
    //   99: goto -61 -> 38
    //   102: aload_0
    //   103: aload_0
    //   104: getfield 91	a/j/b/a/c/e/b/b$c:Ckr	I
    //   107: iconst_1
    //   108: ior
    //   109: putfield 91	a/j/b/a/c/e/b/b$c:Ckr	I
    //   112: aload_0
    //   113: aload_1
    //   114: invokevirtual 94	a/j/b/a/c/g/e:sl	()I
    //   117: putfield 96	a/j/b/a/c/e/b/b$c:ClT	I
    //   120: goto -82 -> 38
    //   123: astore_1
    //   124: aload_1
    //   125: aload_0
    //   126: putfield 100	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   129: ldc 69
    //   131: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   134: aload_1
    //   135: athrow
    //   136: astore_1
    //   137: aload 6
    //   139: invokevirtual 103	a/j/b/a/c/g/f:flush	()V
    //   142: aload_0
    //   143: aload 5
    //   145: invokevirtual 109	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   148: putfield 63	a/j/b/a/c/e/b/b$c:Ckp	La/j/b/a/c/g/d;
    //   151: aload_0
    //   152: invokevirtual 112	a/j/b/a/c/e/b/b$c:emL	()V
    //   155: ldc 69
    //   157: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   160: aload_1
    //   161: athrow
    //   162: aload_0
    //   163: aload_0
    //   164: getfield 91	a/j/b/a/c/e/b/b$c:Ckr	I
    //   167: iconst_2
    //   168: ior
    //   169: putfield 91	a/j/b/a/c/e/b/b$c:Ckr	I
    //   172: aload_0
    //   173: aload_1
    //   174: invokevirtual 94	a/j/b/a/c/g/e:sl	()I
    //   177: putfield 114	a/j/b/a/c/e/b/b$c:CpB	I
    //   180: goto -142 -> 38
    //   183: astore_1
    //   184: new 66	a/j/b/a/c/g/k
    //   187: dup
    //   188: aload_1
    //   189: invokevirtual 118	java/io/IOException:getMessage	()Ljava/lang/String;
    //   192: invokespecial 121	a/j/b/a/c/g/k:<init>	(Ljava/lang/String;)V
    //   195: astore_1
    //   196: aload_1
    //   197: aload_0
    //   198: putfield 100	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   201: ldc 69
    //   203: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   206: aload_1
    //   207: athrow
    //   208: aload 6
    //   210: invokevirtual 103	a/j/b/a/c/g/f:flush	()V
    //   213: aload_0
    //   214: aload 5
    //   216: invokevirtual 109	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   219: putfield 63	a/j/b/a/c/e/b/b$c:Ckp	La/j/b/a/c/g/d;
    //   222: aload_0
    //   223: invokevirtual 112	a/j/b/a/c/e/b/b$c:emL	()V
    //   226: ldc 69
    //   228: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   231: return
    //   232: astore_1
    //   233: aload_0
    //   234: aload 5
    //   236: invokevirtual 109	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   239: putfield 63	a/j/b/a/c/e/b/b$c:Ckp	La/j/b/a/c/g/d;
    //   242: goto -20 -> 222
    //   245: astore_1
    //   246: aload_0
    //   247: aload 5
    //   249: invokevirtual 109	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   252: putfield 63	a/j/b/a/c/e/b/b$c:Ckp	La/j/b/a/c/g/d;
    //   255: ldc 69
    //   257: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   260: aload_1
    //   261: athrow
    //   262: astore_2
    //   263: aload_0
    //   264: aload 5
    //   266: invokevirtual 109	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   269: putfield 63	a/j/b/a/c/e/b/b$c:Ckp	La/j/b/a/c/g/d;
    //   272: goto -121 -> 151
    //   275: astore_1
    //   276: aload_0
    //   277: aload 5
    //   279: invokevirtual 109	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   282: putfield 63	a/j/b/a/c/e/b/b$c:Ckp	La/j/b/a/c/g/d;
    //   285: ldc 69
    //   287: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   290: aload_1
    //   291: athrow
    //   292: goto -208 -> 84
    //   295: iconst_1
    //   296: istore_3
    //   297: goto -259 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	300	0	this	c
    //   0	300	1	parame	a.j.b.a.c.g.e
    //   0	300	2	paramg	a.j.b.a.c.g.g
    //   37	260	3	i	int
    //   46	44	4	j	int
    //   26	252	5	localb	a.j.b.a.c.g.d.b
    //   34	175	6	localf	f
    // Exception table:
    //   from	to	target	type
    //   42	48	123	a/j/b/a/c/g/k
    //   84	97	123	a/j/b/a/c/g/k
    //   102	120	123	a/j/b/a/c/g/k
    //   162	180	123	a/j/b/a/c/g/k
    //   42	48	136	finally
    //   84	97	136	finally
    //   102	120	136	finally
    //   124	136	136	finally
    //   162	180	136	finally
    //   184	208	136	finally
    //   42	48	183	java/io/IOException
    //   84	97	183	java/io/IOException
    //   102	120	183	java/io/IOException
    //   162	180	183	java/io/IOException
    //   208	213	232	java/io/IOException
    //   208	213	245	finally
    //   137	142	262	java/io/IOException
    //   137	142	275	finally
  }
  
  private b$c(i.a parama)
  {
    super((byte)0);
    this.Ckp = parama.Ckp;
  }
  
  public static b.c.a a(c paramc)
  {
    AppMethodBeat.i(121204);
    paramc = b.c.a.elt().c(paramc);
    AppMethodBeat.o(121204);
    return paramc;
  }
  
  private void egZ()
  {
    this.ClT = 0;
    this.CpB = 0;
  }
  
  public static c elp()
  {
    return CpC;
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(121202);
    sy();
    if ((this.Ckr & 0x1) == 1) {
      paramf.bj(1, this.ClT);
    }
    if ((this.Ckr & 0x2) == 2) {
      paramf.bj(2, this.CpB);
    }
    paramf.d(this.Ckp);
    AppMethodBeat.o(121202);
  }
  
  public final s<c> egX()
  {
    return Ckq;
  }
  
  public final boolean eiv()
  {
    return (this.Ckr & 0x1) == 1;
  }
  
  public final boolean elk()
  {
    return (this.Ckr & 0x2) == 2;
  }
  
  public final b.c.a elq()
  {
    AppMethodBeat.i(121205);
    b.c.a locala = b.c.a.elt().c(this);
    AppMethodBeat.o(121205);
    return locala;
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
    AppMethodBeat.i(121203);
    int i = this.Ckv;
    if (i != -1)
    {
      AppMethodBeat.o(121203);
      return i;
    }
    i = 0;
    if ((this.Ckr & 0x1) == 1) {
      i = f.bl(1, this.ClT) + 0;
    }
    int j = i;
    if ((this.Ckr & 0x2) == 2) {
      j = i + f.bl(2, this.CpB);
    }
    i = j + this.Ckp.size();
    this.Ckv = i;
    AppMethodBeat.o(121203);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.c.e.b.b.c
 * JD-Core Version:    0.7.0.1
 */