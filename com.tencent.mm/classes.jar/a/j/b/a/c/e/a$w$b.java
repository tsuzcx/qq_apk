package a.j.b.a.c.e;

import a.j.b.a.c.g.d;
import a.j.b.a.c.g.f;
import a.j.b.a.c.g.i;
import a.j.b.a.c.g.i.a;
import a.j.b.a.c.g.s;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a$w$b
  extends i
  implements a.w.c
{
  public static s<b> Ckq;
  private static final b CmD;
  private final d Ckp;
  private int Ckr;
  private byte Cku = -1;
  private int Ckv = -1;
  public int CmE;
  public int CmF;
  public a.w.b.b CmG;
  
  static
  {
    AppMethodBeat.i(120784);
    Ckq = new a.w.b.1();
    b localb = new b();
    CmD = localb;
    localb.egZ();
    AppMethodBeat.o(120784);
  }
  
  private a$w$b()
  {
    this.Ckp = d.Cre;
  }
  
  /* Error */
  private a$w$b(a.j.b.a.c.g.e parame, a.j.b.a.c.g.g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 56	a/j/b/a/c/g/i:<init>	()V
    //   4: ldc 73
    //   6: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 58	a/j/b/a/c/e/a$w$b:Cku	B
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 60	a/j/b/a/c/e/a$w$b:Ckv	I
    //   19: aload_0
    //   20: invokespecial 51	a/j/b/a/c/e/a$w$b:egZ	()V
    //   23: invokestatic 77	a/j/b/a/c/g/d:emp	()La/j/b/a/c/g/d$b;
    //   26: astore 6
    //   28: aload 6
    //   30: iconst_1
    //   31: invokestatic 83	a/j/b/a/c/g/f:e	(Ljava/io/OutputStream;I)La/j/b/a/c/g/f;
    //   34: astore 7
    //   36: iconst_0
    //   37: istore_3
    //   38: iload_3
    //   39: ifne +231 -> 270
    //   42: aload_1
    //   43: invokevirtual 89	a/j/b/a/c/g/e:sk	()I
    //   46: istore 4
    //   48: iload 4
    //   50: lookupswitch	default:+304->354, 0:+307->357, 8:+60->110, 16:+120->170, 24:+166->216
    //   93: aload_1
    //   94: aload 7
    //   96: aload_2
    //   97: iload 4
    //   99: invokevirtual 93	a/j/b/a/c/e/a$w$b:a	(La/j/b/a/c/g/e;La/j/b/a/c/g/f;La/j/b/a/c/g/g;I)Z
    //   102: ifne -64 -> 38
    //   105: iconst_1
    //   106: istore_3
    //   107: goto -69 -> 38
    //   110: aload_0
    //   111: aload_0
    //   112: getfield 95	a/j/b/a/c/e/a$w$b:Ckr	I
    //   115: iconst_1
    //   116: ior
    //   117: putfield 95	a/j/b/a/c/e/a$w$b:Ckr	I
    //   120: aload_0
    //   121: aload_1
    //   122: invokevirtual 98	a/j/b/a/c/g/e:sl	()I
    //   125: putfield 100	a/j/b/a/c/e/a$w$b:CmE	I
    //   128: goto -90 -> 38
    //   131: astore_1
    //   132: aload_1
    //   133: aload_0
    //   134: putfield 104	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   137: ldc 73
    //   139: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   142: aload_1
    //   143: athrow
    //   144: astore_1
    //   145: aload 7
    //   147: invokevirtual 107	a/j/b/a/c/g/f:flush	()V
    //   150: aload_0
    //   151: aload 6
    //   153: invokevirtual 113	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   156: putfield 67	a/j/b/a/c/e/a$w$b:Ckp	La/j/b/a/c/g/d;
    //   159: aload_0
    //   160: invokevirtual 116	a/j/b/a/c/e/a$w$b:emL	()V
    //   163: ldc 73
    //   165: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   168: aload_1
    //   169: athrow
    //   170: aload_0
    //   171: aload_0
    //   172: getfield 95	a/j/b/a/c/e/a$w$b:Ckr	I
    //   175: iconst_2
    //   176: ior
    //   177: putfield 95	a/j/b/a/c/e/a$w$b:Ckr	I
    //   180: aload_0
    //   181: aload_1
    //   182: invokevirtual 98	a/j/b/a/c/g/e:sl	()I
    //   185: putfield 118	a/j/b/a/c/e/a$w$b:CmF	I
    //   188: goto -150 -> 38
    //   191: astore_1
    //   192: new 70	a/j/b/a/c/g/k
    //   195: dup
    //   196: aload_1
    //   197: invokevirtual 122	java/io/IOException:getMessage	()Ljava/lang/String;
    //   200: invokespecial 125	a/j/b/a/c/g/k:<init>	(Ljava/lang/String;)V
    //   203: astore_1
    //   204: aload_1
    //   205: aload_0
    //   206: putfield 104	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   209: ldc 73
    //   211: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   214: aload_1
    //   215: athrow
    //   216: aload_1
    //   217: invokevirtual 98	a/j/b/a/c/g/e:sl	()I
    //   220: istore 5
    //   222: iload 5
    //   224: invokestatic 129	a/j/b/a/c/e/a$w$b$b:UJ	(I)La/j/b/a/c/e/a$w$b$b;
    //   227: astore 8
    //   229: aload 8
    //   231: ifnonnull +20 -> 251
    //   234: aload 7
    //   236: iload 4
    //   238: invokevirtual 132	a/j/b/a/c/g/f:eX	(I)V
    //   241: aload 7
    //   243: iload 5
    //   245: invokevirtual 132	a/j/b/a/c/g/f:eX	(I)V
    //   248: goto -210 -> 38
    //   251: aload_0
    //   252: aload_0
    //   253: getfield 95	a/j/b/a/c/e/a$w$b:Ckr	I
    //   256: iconst_4
    //   257: ior
    //   258: putfield 95	a/j/b/a/c/e/a$w$b:Ckr	I
    //   261: aload_0
    //   262: aload 8
    //   264: putfield 134	a/j/b/a/c/e/a$w$b:CmG	La/j/b/a/c/e/a$w$b$b;
    //   267: goto -229 -> 38
    //   270: aload 7
    //   272: invokevirtual 107	a/j/b/a/c/g/f:flush	()V
    //   275: aload_0
    //   276: aload 6
    //   278: invokevirtual 113	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   281: putfield 67	a/j/b/a/c/e/a$w$b:Ckp	La/j/b/a/c/g/d;
    //   284: aload_0
    //   285: invokevirtual 116	a/j/b/a/c/e/a$w$b:emL	()V
    //   288: ldc 73
    //   290: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   293: return
    //   294: astore_1
    //   295: aload_0
    //   296: aload 6
    //   298: invokevirtual 113	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   301: putfield 67	a/j/b/a/c/e/a$w$b:Ckp	La/j/b/a/c/g/d;
    //   304: goto -20 -> 284
    //   307: astore_1
    //   308: aload_0
    //   309: aload 6
    //   311: invokevirtual 113	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   314: putfield 67	a/j/b/a/c/e/a$w$b:Ckp	La/j/b/a/c/g/d;
    //   317: ldc 73
    //   319: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   322: aload_1
    //   323: athrow
    //   324: astore_2
    //   325: aload_0
    //   326: aload 6
    //   328: invokevirtual 113	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   331: putfield 67	a/j/b/a/c/e/a$w$b:Ckp	La/j/b/a/c/g/d;
    //   334: goto -175 -> 159
    //   337: astore_1
    //   338: aload_0
    //   339: aload 6
    //   341: invokevirtual 113	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   344: putfield 67	a/j/b/a/c/e/a$w$b:Ckp	La/j/b/a/c/g/d;
    //   347: ldc 73
    //   349: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   352: aload_1
    //   353: athrow
    //   354: goto -262 -> 92
    //   357: iconst_1
    //   358: istore_3
    //   359: goto -321 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	362	0	this	b
    //   0	362	1	parame	a.j.b.a.c.g.e
    //   0	362	2	paramg	a.j.b.a.c.g.g
    //   37	322	3	i	int
    //   46	191	4	j	int
    //   220	24	5	k	int
    //   26	314	6	localb	a.j.b.a.c.g.d.b
    //   34	237	7	localf	f
    //   227	36	8	localb1	a.w.b.b
    // Exception table:
    //   from	to	target	type
    //   42	48	131	a/j/b/a/c/g/k
    //   92	105	131	a/j/b/a/c/g/k
    //   110	128	131	a/j/b/a/c/g/k
    //   170	188	131	a/j/b/a/c/g/k
    //   216	229	131	a/j/b/a/c/g/k
    //   234	248	131	a/j/b/a/c/g/k
    //   251	267	131	a/j/b/a/c/g/k
    //   42	48	144	finally
    //   92	105	144	finally
    //   110	128	144	finally
    //   132	144	144	finally
    //   170	188	144	finally
    //   192	216	144	finally
    //   216	229	144	finally
    //   234	248	144	finally
    //   251	267	144	finally
    //   42	48	191	java/io/IOException
    //   92	105	191	java/io/IOException
    //   110	128	191	java/io/IOException
    //   170	188	191	java/io/IOException
    //   216	229	191	java/io/IOException
    //   234	248	191	java/io/IOException
    //   251	267	191	java/io/IOException
    //   270	275	294	java/io/IOException
    //   270	275	307	finally
    //   145	150	324	java/io/IOException
    //   145	150	337	finally
  }
  
  private a$w$b(i.a parama)
  {
    super((byte)0);
    this.Ckp = parama.Ckp;
  }
  
  private void egZ()
  {
    this.CmE = -1;
    this.CmF = 0;
    this.CmG = a.w.b.b.CmI;
  }
  
  public static b ejk()
  {
    return CmD;
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(120780);
    sy();
    if ((this.Ckr & 0x1) == 1) {
      paramf.bj(1, this.CmE);
    }
    if ((this.Ckr & 0x2) == 2) {
      paramf.bj(2, this.CmF);
    }
    if ((this.Ckr & 0x4) == 4) {
      paramf.iG(3, this.CmG.value);
    }
    paramf.d(this.Ckp);
    AppMethodBeat.o(120780);
  }
  
  public final s<b> egX()
  {
    return Ckq;
  }
  
  public final boolean eip()
  {
    return (this.Ckr & 0x4) == 4;
  }
  
  public final boolean ejl()
  {
    return (this.Ckr & 0x1) == 1;
  }
  
  public final boolean ejm()
  {
    return (this.Ckr & 0x2) == 2;
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(120779);
    int i = this.Cku;
    if (i == 1)
    {
      AppMethodBeat.o(120779);
      return true;
    }
    if (i == 0)
    {
      AppMethodBeat.o(120779);
      return false;
    }
    if (!ejm())
    {
      this.Cku = 0;
      AppMethodBeat.o(120779);
      return false;
    }
    this.Cku = 1;
    AppMethodBeat.o(120779);
    return true;
  }
  
  public final int sy()
  {
    AppMethodBeat.i(120781);
    int i = this.Ckv;
    if (i != -1)
    {
      AppMethodBeat.o(120781);
      return i;
    }
    int j = 0;
    if ((this.Ckr & 0x1) == 1) {
      j = f.bl(1, this.CmE) + 0;
    }
    i = j;
    if ((this.Ckr & 0x2) == 2) {
      i = j + f.bl(2, this.CmF);
    }
    j = i;
    if ((this.Ckr & 0x4) == 4) {
      j = i + f.iH(3, this.CmG.value);
    }
    i = j + this.Ckp.size();
    this.Ckv = i;
    AppMethodBeat.o(120781);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     a.j.b.a.c.e.a.w.b
 * JD-Core Version:    0.7.0.1
 */