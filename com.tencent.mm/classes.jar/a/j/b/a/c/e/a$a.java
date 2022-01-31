package a.j.b.a.c.e;

import a.j.b.a.c.g.d;
import a.j.b.a.c.g.f;
import a.j.b.a.c.g.i;
import a.j.b.a.c.g.i.a;
import a.j.b.a.c.g.q;
import a.j.b.a.c.g.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

public final class a$a
  extends i
  implements a.b
{
  private static final a Cko;
  public static s<a> Ckq;
  private final d Ckp;
  private int Ckr;
  public int Cks;
  public List<a.a.a> Ckt;
  private byte Cku = -1;
  private int Ckv = -1;
  
  static
  {
    AppMethodBeat.i(120440);
    Ckq = new a.a.1();
    a locala = new a();
    Cko = locala;
    locala.egZ();
    AppMethodBeat.o(120440);
  }
  
  private a$a()
  {
    this.Ckp = d.Cre;
  }
  
  /* Error */
  private a$a(a.j.b.a.c.g.e parame, a.j.b.a.c.g.g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 60	a/j/b/a/c/g/i:<init>	()V
    //   4: ldc 77
    //   6: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 62	a/j/b/a/c/e/a$a:Cku	B
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 64	a/j/b/a/c/e/a$a:Ckv	I
    //   19: aload_0
    //   20: invokespecial 55	a/j/b/a/c/e/a$a:egZ	()V
    //   23: invokestatic 81	a/j/b/a/c/g/d:emp	()La/j/b/a/c/g/d$b;
    //   26: astore 9
    //   28: aload 9
    //   30: iconst_1
    //   31: invokestatic 87	a/j/b/a/c/g/f:e	(Ljava/io/OutputStream;I)La/j/b/a/c/g/f;
    //   34: astore 10
    //   36: iconst_0
    //   37: istore 6
    //   39: iconst_0
    //   40: istore_3
    //   41: iload 6
    //   43: ifne +302 -> 345
    //   46: iload_3
    //   47: istore 7
    //   49: iload_3
    //   50: istore 5
    //   52: iload_3
    //   53: istore 8
    //   55: aload_1
    //   56: invokevirtual 93	a/j/b/a/c/g/e:sk	()I
    //   59: istore 4
    //   61: iload 4
    //   63: lookupswitch	default:+384->447, 0:+387->450, 8:+61->124, 18:+170->233
    //   97: istore 7
    //   99: iload_3
    //   100: istore 5
    //   102: iload_3
    //   103: istore 8
    //   105: aload_0
    //   106: aload_1
    //   107: aload 10
    //   109: aload_2
    //   110: iload 4
    //   112: invokevirtual 96	a/j/b/a/c/e/a$a:a	(La/j/b/a/c/g/e;La/j/b/a/c/g/f;La/j/b/a/c/g/g;I)Z
    //   115: ifne -74 -> 41
    //   118: iconst_1
    //   119: istore 6
    //   121: goto -80 -> 41
    //   124: iload_3
    //   125: istore 7
    //   127: iload_3
    //   128: istore 5
    //   130: iload_3
    //   131: istore 8
    //   133: aload_0
    //   134: aload_0
    //   135: getfield 98	a/j/b/a/c/e/a$a:Ckr	I
    //   138: iconst_1
    //   139: ior
    //   140: putfield 98	a/j/b/a/c/e/a$a:Ckr	I
    //   143: iload_3
    //   144: istore 7
    //   146: iload_3
    //   147: istore 5
    //   149: iload_3
    //   150: istore 8
    //   152: aload_0
    //   153: aload_1
    //   154: invokevirtual 101	a/j/b/a/c/g/e:sl	()I
    //   157: putfield 103	a/j/b/a/c/e/a$a:Cks	I
    //   160: goto -119 -> 41
    //   163: astore_1
    //   164: iload 7
    //   166: istore 5
    //   168: aload_1
    //   169: aload_0
    //   170: putfield 107	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   173: iload 7
    //   175: istore 5
    //   177: ldc 77
    //   179: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   182: iload 7
    //   184: istore 5
    //   186: aload_1
    //   187: athrow
    //   188: astore_1
    //   189: iload 5
    //   191: iconst_2
    //   192: iand
    //   193: iconst_2
    //   194: if_icmpne +14 -> 208
    //   197: aload_0
    //   198: aload_0
    //   199: getfield 109	a/j/b/a/c/e/a$a:Ckt	Ljava/util/List;
    //   202: invokestatic 115	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   205: putfield 109	a/j/b/a/c/e/a$a:Ckt	Ljava/util/List;
    //   208: aload 10
    //   210: invokevirtual 118	a/j/b/a/c/g/f:flush	()V
    //   213: aload_0
    //   214: aload 9
    //   216: invokevirtual 124	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   219: putfield 71	a/j/b/a/c/e/a$a:Ckp	La/j/b/a/c/g/d;
    //   222: aload_0
    //   223: invokevirtual 127	a/j/b/a/c/e/a$a:emL	()V
    //   226: ldc 77
    //   228: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   231: aload_1
    //   232: athrow
    //   233: iload_3
    //   234: istore 4
    //   236: iload_3
    //   237: iconst_2
    //   238: iand
    //   239: iconst_2
    //   240: if_icmpeq +28 -> 268
    //   243: iload_3
    //   244: istore 7
    //   246: iload_3
    //   247: istore 5
    //   249: iload_3
    //   250: istore 8
    //   252: aload_0
    //   253: new 129	java/util/ArrayList
    //   256: dup
    //   257: invokespecial 130	java/util/ArrayList:<init>	()V
    //   260: putfield 109	a/j/b/a/c/e/a$a:Ckt	Ljava/util/List;
    //   263: iload_3
    //   264: iconst_2
    //   265: ior
    //   266: istore 4
    //   268: iload 4
    //   270: istore 7
    //   272: iload 4
    //   274: istore 5
    //   276: iload 4
    //   278: istore 8
    //   280: aload_0
    //   281: getfield 109	a/j/b/a/c/e/a$a:Ckt	Ljava/util/List;
    //   284: aload_1
    //   285: getstatic 131	a/j/b/a/c/e/a$a$a:Ckq	La/j/b/a/c/g/s;
    //   288: aload_2
    //   289: invokevirtual 134	a/j/b/a/c/g/e:a	(La/j/b/a/c/g/s;La/j/b/a/c/g/g;)La/j/b/a/c/g/q;
    //   292: invokeinterface 140 2 0
    //   297: pop
    //   298: iload 4
    //   300: istore_3
    //   301: goto -260 -> 41
    //   304: astore_1
    //   305: iload 8
    //   307: istore 5
    //   309: new 74	a/j/b/a/c/g/k
    //   312: dup
    //   313: aload_1
    //   314: invokevirtual 144	java/io/IOException:getMessage	()Ljava/lang/String;
    //   317: invokespecial 147	a/j/b/a/c/g/k:<init>	(Ljava/lang/String;)V
    //   320: astore_1
    //   321: iload 8
    //   323: istore 5
    //   325: aload_1
    //   326: aload_0
    //   327: putfield 107	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   330: iload 8
    //   332: istore 5
    //   334: ldc 77
    //   336: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   339: iload 8
    //   341: istore 5
    //   343: aload_1
    //   344: athrow
    //   345: iload_3
    //   346: iconst_2
    //   347: iand
    //   348: iconst_2
    //   349: if_icmpne +14 -> 363
    //   352: aload_0
    //   353: aload_0
    //   354: getfield 109	a/j/b/a/c/e/a$a:Ckt	Ljava/util/List;
    //   357: invokestatic 115	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   360: putfield 109	a/j/b/a/c/e/a$a:Ckt	Ljava/util/List;
    //   363: aload 10
    //   365: invokevirtual 118	a/j/b/a/c/g/f:flush	()V
    //   368: aload_0
    //   369: aload 9
    //   371: invokevirtual 124	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   374: putfield 71	a/j/b/a/c/e/a$a:Ckp	La/j/b/a/c/g/d;
    //   377: aload_0
    //   378: invokevirtual 127	a/j/b/a/c/e/a$a:emL	()V
    //   381: ldc 77
    //   383: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   386: return
    //   387: astore_1
    //   388: aload_0
    //   389: aload 9
    //   391: invokevirtual 124	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   394: putfield 71	a/j/b/a/c/e/a$a:Ckp	La/j/b/a/c/g/d;
    //   397: goto -20 -> 377
    //   400: astore_1
    //   401: aload_0
    //   402: aload 9
    //   404: invokevirtual 124	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   407: putfield 71	a/j/b/a/c/e/a$a:Ckp	La/j/b/a/c/g/d;
    //   410: ldc 77
    //   412: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   415: aload_1
    //   416: athrow
    //   417: astore_2
    //   418: aload_0
    //   419: aload 9
    //   421: invokevirtual 124	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   424: putfield 71	a/j/b/a/c/e/a$a:Ckp	La/j/b/a/c/g/d;
    //   427: goto -205 -> 222
    //   430: astore_1
    //   431: aload_0
    //   432: aload 9
    //   434: invokevirtual 124	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   437: putfield 71	a/j/b/a/c/e/a$a:Ckp	La/j/b/a/c/g/d;
    //   440: ldc 77
    //   442: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   445: aload_1
    //   446: athrow
    //   447: goto -351 -> 96
    //   450: iconst_1
    //   451: istore 6
    //   453: goto -412 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	456	0	this	a
    //   0	456	1	parame	a.j.b.a.c.g.e
    //   0	456	2	paramg	a.j.b.a.c.g.g
    //   40	308	3	i	int
    //   59	240	4	j	int
    //   50	292	5	k	int
    //   37	415	6	m	int
    //   47	224	7	n	int
    //   53	287	8	i1	int
    //   26	407	9	localb	a.j.b.a.c.g.d.b
    //   34	330	10	localf	f
    // Exception table:
    //   from	to	target	type
    //   55	61	163	a/j/b/a/c/g/k
    //   105	118	163	a/j/b/a/c/g/k
    //   133	143	163	a/j/b/a/c/g/k
    //   152	160	163	a/j/b/a/c/g/k
    //   252	263	163	a/j/b/a/c/g/k
    //   280	298	163	a/j/b/a/c/g/k
    //   55	61	188	finally
    //   105	118	188	finally
    //   133	143	188	finally
    //   152	160	188	finally
    //   168	173	188	finally
    //   177	182	188	finally
    //   186	188	188	finally
    //   252	263	188	finally
    //   280	298	188	finally
    //   309	321	188	finally
    //   325	330	188	finally
    //   334	339	188	finally
    //   343	345	188	finally
    //   55	61	304	java/io/IOException
    //   105	118	304	java/io/IOException
    //   133	143	304	java/io/IOException
    //   152	160	304	java/io/IOException
    //   252	263	304	java/io/IOException
    //   280	298	304	java/io/IOException
    //   363	368	387	java/io/IOException
    //   363	368	400	finally
    //   208	213	417	java/io/IOException
    //   208	213	430	finally
  }
  
  private a$a(i.a parama)
  {
    super((byte)0);
    this.Ckp = parama.Ckp;
  }
  
  public static a.a.c a(a parama)
  {
    AppMethodBeat.i(120436);
    parama = a.a.c.ehG().e(parama);
    AppMethodBeat.o(120436);
    return parama;
  }
  
  public static a egW()
  {
    return Cko;
  }
  
  private void egZ()
  {
    AppMethodBeat.i(120432);
    this.Cks = 0;
    this.Ckt = Collections.emptyList();
    AppMethodBeat.o(120432);
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(120434);
    sy();
    if ((this.Ckr & 0x1) == 1) {
      paramf.bj(1, this.Cks);
    }
    int i = 0;
    while (i < this.Ckt.size())
    {
      paramf.a(2, (q)this.Ckt.get(i));
      i += 1;
    }
    paramf.d(this.Ckp);
    AppMethodBeat.o(120434);
  }
  
  public final s<a> egX()
  {
    return Ckq;
  }
  
  public final boolean egY()
  {
    return (this.Ckr & 0x1) == 1;
  }
  
  public final a.a.c eha()
  {
    AppMethodBeat.i(120437);
    a.a.c localc = a.a.c.ehG().e(this);
    AppMethodBeat.o(120437);
    return localc;
  }
  
  public final int getArgumentCount()
  {
    AppMethodBeat.i(120431);
    int i = this.Ckt.size();
    AppMethodBeat.o(120431);
    return i;
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(120433);
    int i = this.Cku;
    if (i == 1)
    {
      AppMethodBeat.o(120433);
      return true;
    }
    if (i == 0)
    {
      AppMethodBeat.o(120433);
      return false;
    }
    if (!egY())
    {
      this.Cku = 0;
      AppMethodBeat.o(120433);
      return false;
    }
    i = 0;
    while (i < getArgumentCount())
    {
      if (!((a.a.a)this.Ckt.get(i)).isInitialized())
      {
        this.Cku = 0;
        AppMethodBeat.o(120433);
        return false;
      }
      i += 1;
    }
    this.Cku = 1;
    AppMethodBeat.o(120433);
    return true;
  }
  
  public final int sy()
  {
    int j = 0;
    AppMethodBeat.i(120435);
    int i = this.Ckv;
    if (i != -1)
    {
      AppMethodBeat.o(120435);
      return i;
    }
    if ((this.Ckr & 0x1) == 1) {
      i = f.bl(1, this.Cks) + 0;
    }
    for (;;)
    {
      if (j < this.Ckt.size())
      {
        int k = f.c(2, (q)this.Ckt.get(j));
        j += 1;
        i = k + i;
      }
      else
      {
        i = this.Ckp.size() + i;
        this.Ckv = i;
        AppMethodBeat.o(120435);
        return i;
        i = 0;
      }
    }
  }
  
  public static final class a$a
    extends i.a<a.a.a, a>
    implements a.a.b
  {
    private int Ckr;
    private int Ckx;
    private a.a.a.b Cky;
    
    private a$a()
    {
      AppMethodBeat.i(120355);
      this.Cky = a.a.a.b.ehn();
      AppMethodBeat.o(120355);
    }
    
    private a TX(int paramInt)
    {
      this.Ckr |= 0x1;
      this.Ckx = paramInt;
      return this;
    }
    
    private a a(a.a.a.b paramb)
    {
      AppMethodBeat.i(120361);
      if (((this.Ckr & 0x2) == 2) && (this.Cky != a.a.a.b.ehn())) {}
      for (this.Cky = a.a.a.b.b(this.Cky).e(paramb).ehz();; this.Cky = paramb)
      {
        this.Ckr |= 0x2;
        AppMethodBeat.o(120361);
        return this;
      }
    }
    
    /* Error */
    private a b(a.j.b.a.c.g.e parame, a.j.b.a.c.g.g paramg)
    {
      // Byte code:
      //   0: ldc 66
      //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: getstatic 70	a/j/b/a/c/e/a$a$a:Ckq	La/j/b/a/c/g/s;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 75 3 0
      //   17: checkcast 14	a/j/b/a/c/e/a$a$a
      //   20: astore_1
      //   21: aload_0
      //   22: aload_1
      //   23: invokevirtual 78	a/j/b/a/c/e/a$a$a$a:b	(La/j/b/a/c/e/a$a$a;)La/j/b/a/c/e/a$a$a$a;
      //   26: pop
      //   27: ldc 66
      //   29: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   32: aload_0
      //   33: areturn
      //   34: astore_1
      //   35: aload_1
      //   36: getfield 82	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
      //   39: checkcast 14	a/j/b/a/c/e/a$a$a
      //   42: astore_2
      //   43: ldc 66
      //   45: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   48: aload_1
      //   49: athrow
      //   50: astore_1
      //   51: aload_2
      //   52: ifnull +9 -> 61
      //   55: aload_0
      //   56: aload_2
      //   57: invokevirtual 78	a/j/b/a/c/e/a$a$a$a:b	(La/j/b/a/c/e/a$a$a;)La/j/b/a/c/e/a$a$a$a;
      //   60: pop
      //   61: ldc 66
      //   63: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
      //   0	74	2	paramg	a.j.b.a.c.g.g
      //   6	64	3	localObject	java.lang.Object
      // Exception table:
      //   from	to	target	type
      //   7	21	34	a/j/b/a/c/g/k
      //   43	50	50	finally
      //   7	21	68	finally
      //   35	43	68	finally
    }
    
    private a ehg()
    {
      AppMethodBeat.i(120356);
      a locala = new a().b(ehh());
      AppMethodBeat.o(120356);
      return locala;
    }
    
    private a.a.a ehh()
    {
      int i = 1;
      AppMethodBeat.i(120357);
      a.a.a locala = new a.a.a(this, (byte)0);
      int k = this.Ckr;
      if ((k & 0x1) == 1) {}
      for (;;)
      {
        a.a.a.a(locala, this.Ckx);
        int j = i;
        if ((k & 0x2) == 2) {
          j = i | 0x2;
        }
        a.a.a.a(locala, this.Cky);
        a.a.a.b(locala, j);
        AppMethodBeat.o(120357);
        return locala;
        i = 0;
      }
    }
    
    public final a b(a.a.a parama)
    {
      AppMethodBeat.i(120358);
      if (parama == a.a.a.ehe())
      {
        AppMethodBeat.o(120358);
        return this;
      }
      if (parama.ehf()) {
        TX(parama.Ckx);
      }
      if (parama.hasValue()) {
        a(parama.Cky);
      }
      this.Ckp = this.Ckp.a(a.a.a.a(parama));
      AppMethodBeat.o(120358);
      return this;
    }
    
    public final boolean isInitialized()
    {
      AppMethodBeat.i(120359);
      if ((this.Ckr & 0x1) == 1) {}
      for (int i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(120359);
        return false;
      }
      if ((this.Ckr & 0x2) == 2) {}
      for (i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(120359);
        return false;
      }
      if (!this.Cky.isInitialized())
      {
        AppMethodBeat.o(120359);
        return false;
      }
      AppMethodBeat.o(120359);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.j.b.a.c.e.a.a
 * JD-Core Version:    0.7.0.1
 */