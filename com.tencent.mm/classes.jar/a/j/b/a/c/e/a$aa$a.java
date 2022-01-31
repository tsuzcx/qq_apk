package a.j.b.a.c.e;

import a.j.b.a.c.g.d;
import a.j.b.a.c.g.f;
import a.j.b.a.c.g.i;
import a.j.b.a.c.g.i.a;
import a.j.b.a.c.g.s;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a$aa$a
  extends i
  implements a.aa.b
{
  public static s<a> Ckq;
  private static final a Cna;
  private final d Ckp;
  private int Ckr;
  private byte Cku = -1;
  private int Ckv = -1;
  public a.aa.a.b Cnb;
  public a.aa Cnc;
  public int Cnd;
  
  static
  {
    AppMethodBeat.i(120851);
    Ckq = new a.aa.a.1();
    a locala = new a();
    Cna = locala;
    locala.egZ();
    AppMethodBeat.o(120851);
  }
  
  private a$aa$a()
  {
    this.Ckp = d.Cre;
  }
  
  /* Error */
  private a$aa$a(a.j.b.a.c.g.e parame, a.j.b.a.c.g.g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 57	a/j/b/a/c/g/i:<init>	()V
    //   4: ldc 74
    //   6: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 59	a/j/b/a/c/e/a$aa$a:Cku	B
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 61	a/j/b/a/c/e/a$aa$a:Ckv	I
    //   19: aload_0
    //   20: invokespecial 52	a/j/b/a/c/e/a$aa$a:egZ	()V
    //   23: invokestatic 78	a/j/b/a/c/g/d:emp	()La/j/b/a/c/g/d$b;
    //   26: astore 7
    //   28: aload 7
    //   30: iconst_1
    //   31: invokestatic 84	a/j/b/a/c/g/f:e	(Ljava/io/OutputStream;I)La/j/b/a/c/g/f;
    //   34: astore 8
    //   36: iconst_0
    //   37: istore_3
    //   38: iload_3
    //   39: ifne +281 -> 320
    //   42: aload_1
    //   43: invokevirtual 90	a/j/b/a/c/g/e:sk	()I
    //   46: istore 4
    //   48: iload 4
    //   50: lookupswitch	default:+360->410, 0:+363->413, 8:+60->110, 18:+178->228, 24:+249->299
    //   93: aload_1
    //   94: aload 8
    //   96: aload_2
    //   97: iload 4
    //   99: invokevirtual 93	a/j/b/a/c/e/a$aa$a:a	(La/j/b/a/c/g/e;La/j/b/a/c/g/f;La/j/b/a/c/g/g;I)Z
    //   102: ifne -64 -> 38
    //   105: iconst_1
    //   106: istore_3
    //   107: goto -69 -> 38
    //   110: aload_1
    //   111: invokevirtual 96	a/j/b/a/c/g/e:sl	()I
    //   114: istore 5
    //   116: iload 5
    //   118: invokestatic 100	a/j/b/a/c/e/a$aa$a$b:UL	(I)La/j/b/a/c/e/a$aa$a$b;
    //   121: astore 6
    //   123: aload 6
    //   125: ifnonnull +59 -> 184
    //   128: aload 8
    //   130: iload 4
    //   132: invokevirtual 103	a/j/b/a/c/g/f:eX	(I)V
    //   135: aload 8
    //   137: iload 5
    //   139: invokevirtual 103	a/j/b/a/c/g/f:eX	(I)V
    //   142: goto -104 -> 38
    //   145: astore_1
    //   146: aload_1
    //   147: aload_0
    //   148: putfield 107	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   151: ldc 74
    //   153: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: aload_1
    //   157: athrow
    //   158: astore_1
    //   159: aload 8
    //   161: invokevirtual 110	a/j/b/a/c/g/f:flush	()V
    //   164: aload_0
    //   165: aload 7
    //   167: invokevirtual 116	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   170: putfield 68	a/j/b/a/c/e/a$aa$a:Ckp	La/j/b/a/c/g/d;
    //   173: aload_0
    //   174: invokevirtual 119	a/j/b/a/c/e/a$aa$a:emL	()V
    //   177: ldc 74
    //   179: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   182: aload_1
    //   183: athrow
    //   184: aload_0
    //   185: aload_0
    //   186: getfield 121	a/j/b/a/c/e/a$aa$a:Ckr	I
    //   189: iconst_1
    //   190: ior
    //   191: putfield 121	a/j/b/a/c/e/a$aa$a:Ckr	I
    //   194: aload_0
    //   195: aload 6
    //   197: putfield 123	a/j/b/a/c/e/a$aa$a:Cnb	La/j/b/a/c/e/a$aa$a$b;
    //   200: goto -162 -> 38
    //   203: astore_1
    //   204: new 71	a/j/b/a/c/g/k
    //   207: dup
    //   208: aload_1
    //   209: invokevirtual 127	java/io/IOException:getMessage	()Ljava/lang/String;
    //   212: invokespecial 130	a/j/b/a/c/g/k:<init>	(Ljava/lang/String;)V
    //   215: astore_1
    //   216: aload_1
    //   217: aload_0
    //   218: putfield 107	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   221: ldc 74
    //   223: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   226: aload_1
    //   227: athrow
    //   228: aload_0
    //   229: getfield 121	a/j/b/a/c/e/a$aa$a:Ckr	I
    //   232: iconst_2
    //   233: iand
    //   234: iconst_2
    //   235: if_icmpne +169 -> 404
    //   238: aload_0
    //   239: getfield 132	a/j/b/a/c/e/a$aa$a:Cnc	La/j/b/a/c/e/a$aa;
    //   242: invokevirtual 136	a/j/b/a/c/e/a$aa:ejJ	()La/j/b/a/c/e/a$aa$c;
    //   245: astore 6
    //   247: aload_0
    //   248: aload_1
    //   249: getstatic 137	a/j/b/a/c/e/a$aa:Ckq	La/j/b/a/c/g/s;
    //   252: aload_2
    //   253: invokevirtual 140	a/j/b/a/c/g/e:a	(La/j/b/a/c/g/s;La/j/b/a/c/g/g;)La/j/b/a/c/g/q;
    //   256: checkcast 8	a/j/b/a/c/e/a$aa
    //   259: putfield 132	a/j/b/a/c/e/a$aa$a:Cnc	La/j/b/a/c/e/a$aa;
    //   262: aload 6
    //   264: ifnull +22 -> 286
    //   267: aload 6
    //   269: aload_0
    //   270: getfield 132	a/j/b/a/c/e/a$aa$a:Cnc	La/j/b/a/c/e/a$aa;
    //   273: invokevirtual 146	a/j/b/a/c/e/a$aa$c:j	(La/j/b/a/c/e/a$aa;)La/j/b/a/c/e/a$aa$c;
    //   276: pop
    //   277: aload_0
    //   278: aload 6
    //   280: invokevirtual 150	a/j/b/a/c/e/a$aa$c:ejS	()La/j/b/a/c/e/a$aa;
    //   283: putfield 132	a/j/b/a/c/e/a$aa$a:Cnc	La/j/b/a/c/e/a$aa;
    //   286: aload_0
    //   287: aload_0
    //   288: getfield 121	a/j/b/a/c/e/a$aa$a:Ckr	I
    //   291: iconst_2
    //   292: ior
    //   293: putfield 121	a/j/b/a/c/e/a$aa$a:Ckr	I
    //   296: goto -258 -> 38
    //   299: aload_0
    //   300: aload_0
    //   301: getfield 121	a/j/b/a/c/e/a$aa$a:Ckr	I
    //   304: iconst_4
    //   305: ior
    //   306: putfield 121	a/j/b/a/c/e/a$aa$a:Ckr	I
    //   309: aload_0
    //   310: aload_1
    //   311: invokevirtual 96	a/j/b/a/c/g/e:sl	()I
    //   314: putfield 152	a/j/b/a/c/e/a$aa$a:Cnd	I
    //   317: goto -279 -> 38
    //   320: aload 8
    //   322: invokevirtual 110	a/j/b/a/c/g/f:flush	()V
    //   325: aload_0
    //   326: aload 7
    //   328: invokevirtual 116	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   331: putfield 68	a/j/b/a/c/e/a$aa$a:Ckp	La/j/b/a/c/g/d;
    //   334: aload_0
    //   335: invokevirtual 119	a/j/b/a/c/e/a$aa$a:emL	()V
    //   338: ldc 74
    //   340: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   343: return
    //   344: astore_1
    //   345: aload_0
    //   346: aload 7
    //   348: invokevirtual 116	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   351: putfield 68	a/j/b/a/c/e/a$aa$a:Ckp	La/j/b/a/c/g/d;
    //   354: goto -20 -> 334
    //   357: astore_1
    //   358: aload_0
    //   359: aload 7
    //   361: invokevirtual 116	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   364: putfield 68	a/j/b/a/c/e/a$aa$a:Ckp	La/j/b/a/c/g/d;
    //   367: ldc 74
    //   369: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   372: aload_1
    //   373: athrow
    //   374: astore_2
    //   375: aload_0
    //   376: aload 7
    //   378: invokevirtual 116	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   381: putfield 68	a/j/b/a/c/e/a$aa$a:Ckp	La/j/b/a/c/g/d;
    //   384: goto -211 -> 173
    //   387: astore_1
    //   388: aload_0
    //   389: aload 7
    //   391: invokevirtual 116	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   394: putfield 68	a/j/b/a/c/e/a$aa$a:Ckp	La/j/b/a/c/g/d;
    //   397: ldc 74
    //   399: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   402: aload_1
    //   403: athrow
    //   404: aconst_null
    //   405: astore 6
    //   407: goto -160 -> 247
    //   410: goto -318 -> 92
    //   413: iconst_1
    //   414: istore_3
    //   415: goto -377 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	418	0	this	a
    //   0	418	1	parame	a.j.b.a.c.g.e
    //   0	418	2	paramg	a.j.b.a.c.g.g
    //   37	378	3	i	int
    //   46	85	4	j	int
    //   114	24	5	k	int
    //   121	285	6	localObject	java.lang.Object
    //   26	364	7	localb	a.j.b.a.c.g.d.b
    //   34	287	8	localf	f
    // Exception table:
    //   from	to	target	type
    //   42	48	145	a/j/b/a/c/g/k
    //   92	105	145	a/j/b/a/c/g/k
    //   110	123	145	a/j/b/a/c/g/k
    //   128	142	145	a/j/b/a/c/g/k
    //   184	200	145	a/j/b/a/c/g/k
    //   228	247	145	a/j/b/a/c/g/k
    //   247	262	145	a/j/b/a/c/g/k
    //   267	286	145	a/j/b/a/c/g/k
    //   286	296	145	a/j/b/a/c/g/k
    //   299	317	145	a/j/b/a/c/g/k
    //   42	48	158	finally
    //   92	105	158	finally
    //   110	123	158	finally
    //   128	142	158	finally
    //   146	158	158	finally
    //   184	200	158	finally
    //   204	228	158	finally
    //   228	247	158	finally
    //   247	262	158	finally
    //   267	286	158	finally
    //   286	296	158	finally
    //   299	317	158	finally
    //   42	48	203	java/io/IOException
    //   92	105	203	java/io/IOException
    //   110	123	203	java/io/IOException
    //   128	142	203	java/io/IOException
    //   184	200	203	java/io/IOException
    //   228	247	203	java/io/IOException
    //   247	262	203	java/io/IOException
    //   267	286	203	java/io/IOException
    //   286	296	203	java/io/IOException
    //   299	317	203	java/io/IOException
    //   320	325	344	java/io/IOException
    //   320	325	357	finally
    //   159	164	374	java/io/IOException
    //   159	164	387	finally
  }
  
  private a$aa$a(i.a parama)
  {
    super((byte)0);
    this.Ckp = parama.Ckp;
  }
  
  private void egZ()
  {
    AppMethodBeat.i(120845);
    this.Cnb = a.aa.a.b.Cng;
    this.Cnc = a.aa.ejw();
    this.Cnd = 0;
    AppMethodBeat.o(120845);
  }
  
  public static a ejK()
  {
    return Cna;
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(120847);
    sy();
    if ((this.Ckr & 0x1) == 1) {
      paramf.iG(1, this.Cnb.value);
    }
    if ((this.Ckr & 0x2) == 2) {
      paramf.a(2, this.Cnc);
    }
    if ((this.Ckr & 0x4) == 4) {
      paramf.bj(3, this.Cnd);
    }
    paramf.d(this.Ckp);
    AppMethodBeat.o(120847);
  }
  
  public final s<a> egX()
  {
    return Ckq;
  }
  
  public final boolean eho()
  {
    return (this.Ckr & 0x2) == 2;
  }
  
  public final boolean ejL()
  {
    return (this.Ckr & 0x1) == 1;
  }
  
  public final boolean ejM()
  {
    return (this.Ckr & 0x4) == 4;
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(120846);
    int i = this.Cku;
    if (i == 1)
    {
      AppMethodBeat.o(120846);
      return true;
    }
    if (i == 0)
    {
      AppMethodBeat.o(120846);
      return false;
    }
    if ((eho()) && (!this.Cnc.isInitialized()))
    {
      this.Cku = 0;
      AppMethodBeat.o(120846);
      return false;
    }
    this.Cku = 1;
    AppMethodBeat.o(120846);
    return true;
  }
  
  public final int sy()
  {
    AppMethodBeat.i(120848);
    int i = this.Ckv;
    if (i != -1)
    {
      AppMethodBeat.o(120848);
      return i;
    }
    int j = 0;
    if ((this.Ckr & 0x1) == 1) {
      j = f.iH(1, this.Cnb.value) + 0;
    }
    i = j;
    if ((this.Ckr & 0x2) == 2) {
      i = j + f.c(2, this.Cnc);
    }
    j = i;
    if ((this.Ckr & 0x4) == 4) {
      j = i + f.bl(3, this.Cnd);
    }
    i = j + this.Ckp.size();
    this.Ckv = i;
    AppMethodBeat.o(120848);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.j.b.a.c.e.a.aa.a
 * JD-Core Version:    0.7.0.1
 */