package a.j.b.a.c.e;

import a.j.b.a.c.g.d;
import a.j.b.a.c.g.f;
import a.j.b.a.c.g.i;
import a.j.b.a.c.g.i.a;
import a.j.b.a.c.g.q;
import a.j.b.a.c.g.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class a$ag
  extends i
  implements a.ah
{
  public static s<ag> Ckq;
  private static final ag Cnz;
  private final d Ckp;
  private int Ckr;
  private byte Cku = -1;
  private int Ckv = -1;
  public List<a.aa> CnA;
  public int CnB;
  
  static
  {
    AppMethodBeat.i(120976);
    Ckq = new a.ag.1();
    ag localag = new ag();
    Cnz = localag;
    localag.egZ();
    AppMethodBeat.o(120976);
  }
  
  private a$ag()
  {
    this.Ckp = d.Cre;
  }
  
  /* Error */
  private a$ag(a.j.b.a.c.g.e parame, a.j.b.a.c.g.g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 55	a/j/b/a/c/g/i:<init>	()V
    //   4: ldc 72
    //   6: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 57	a/j/b/a/c/e/a$ag:Cku	B
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 59	a/j/b/a/c/e/a$ag:Ckv	I
    //   19: aload_0
    //   20: invokespecial 50	a/j/b/a/c/e/a$ag:egZ	()V
    //   23: invokestatic 76	a/j/b/a/c/g/d:emp	()La/j/b/a/c/g/d$b;
    //   26: astore 9
    //   28: aload 9
    //   30: iconst_1
    //   31: invokestatic 82	a/j/b/a/c/g/f:e	(Ljava/io/OutputStream;I)La/j/b/a/c/g/f;
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
    //   56: invokevirtual 88	a/j/b/a/c/g/e:sk	()I
    //   59: istore 4
    //   61: iload 4
    //   63: lookupswitch	default:+384->447, 0:+387->450, 10:+61->124, 16:+202->265
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
    //   112: invokevirtual 91	a/j/b/a/c/e/a$ag:a	(La/j/b/a/c/g/e;La/j/b/a/c/g/f;La/j/b/a/c/g/g;I)Z
    //   115: ifne -74 -> 41
    //   118: iconst_1
    //   119: istore 6
    //   121: goto -80 -> 41
    //   124: iload_3
    //   125: istore 4
    //   127: iload_3
    //   128: iconst_1
    //   129: iand
    //   130: iconst_1
    //   131: if_icmpeq +28 -> 159
    //   134: iload_3
    //   135: istore 7
    //   137: iload_3
    //   138: istore 5
    //   140: iload_3
    //   141: istore 8
    //   143: aload_0
    //   144: new 93	java/util/ArrayList
    //   147: dup
    //   148: invokespecial 94	java/util/ArrayList:<init>	()V
    //   151: putfield 96	a/j/b/a/c/e/a$ag:CnA	Ljava/util/List;
    //   154: iload_3
    //   155: iconst_1
    //   156: ior
    //   157: istore 4
    //   159: iload 4
    //   161: istore 7
    //   163: iload 4
    //   165: istore 5
    //   167: iload 4
    //   169: istore 8
    //   171: aload_0
    //   172: getfield 96	a/j/b/a/c/e/a$ag:CnA	Ljava/util/List;
    //   175: aload_1
    //   176: getstatic 99	a/j/b/a/c/e/a$aa:Ckq	La/j/b/a/c/g/s;
    //   179: aload_2
    //   180: invokevirtual 102	a/j/b/a/c/g/e:a	(La/j/b/a/c/g/s;La/j/b/a/c/g/g;)La/j/b/a/c/g/q;
    //   183: invokeinterface 108 2 0
    //   188: pop
    //   189: iload 4
    //   191: istore_3
    //   192: goto -151 -> 41
    //   195: astore_1
    //   196: iload 7
    //   198: istore 5
    //   200: aload_1
    //   201: aload_0
    //   202: putfield 112	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   205: iload 7
    //   207: istore 5
    //   209: ldc 72
    //   211: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   214: iload 7
    //   216: istore 5
    //   218: aload_1
    //   219: athrow
    //   220: astore_1
    //   221: iload 5
    //   223: iconst_1
    //   224: iand
    //   225: iconst_1
    //   226: if_icmpne +14 -> 240
    //   229: aload_0
    //   230: aload_0
    //   231: getfield 96	a/j/b/a/c/e/a$ag:CnA	Ljava/util/List;
    //   234: invokestatic 118	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   237: putfield 96	a/j/b/a/c/e/a$ag:CnA	Ljava/util/List;
    //   240: aload 10
    //   242: invokevirtual 121	a/j/b/a/c/g/f:flush	()V
    //   245: aload_0
    //   246: aload 9
    //   248: invokevirtual 127	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   251: putfield 66	a/j/b/a/c/e/a$ag:Ckp	La/j/b/a/c/g/d;
    //   254: aload_0
    //   255: invokevirtual 130	a/j/b/a/c/e/a$ag:emL	()V
    //   258: ldc 72
    //   260: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   263: aload_1
    //   264: athrow
    //   265: iload_3
    //   266: istore 7
    //   268: iload_3
    //   269: istore 5
    //   271: iload_3
    //   272: istore 8
    //   274: aload_0
    //   275: aload_0
    //   276: getfield 132	a/j/b/a/c/e/a$ag:Ckr	I
    //   279: iconst_1
    //   280: ior
    //   281: putfield 132	a/j/b/a/c/e/a$ag:Ckr	I
    //   284: iload_3
    //   285: istore 7
    //   287: iload_3
    //   288: istore 5
    //   290: iload_3
    //   291: istore 8
    //   293: aload_0
    //   294: aload_1
    //   295: invokevirtual 135	a/j/b/a/c/g/e:sl	()I
    //   298: putfield 137	a/j/b/a/c/e/a$ag:CnB	I
    //   301: goto -260 -> 41
    //   304: astore_1
    //   305: iload 8
    //   307: istore 5
    //   309: new 69	a/j/b/a/c/g/k
    //   312: dup
    //   313: aload_1
    //   314: invokevirtual 141	java/io/IOException:getMessage	()Ljava/lang/String;
    //   317: invokespecial 144	a/j/b/a/c/g/k:<init>	(Ljava/lang/String;)V
    //   320: astore_1
    //   321: iload 8
    //   323: istore 5
    //   325: aload_1
    //   326: aload_0
    //   327: putfield 112	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   330: iload 8
    //   332: istore 5
    //   334: ldc 72
    //   336: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   339: iload 8
    //   341: istore 5
    //   343: aload_1
    //   344: athrow
    //   345: iload_3
    //   346: iconst_1
    //   347: iand
    //   348: iconst_1
    //   349: if_icmpne +14 -> 363
    //   352: aload_0
    //   353: aload_0
    //   354: getfield 96	a/j/b/a/c/e/a$ag:CnA	Ljava/util/List;
    //   357: invokestatic 118	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   360: putfield 96	a/j/b/a/c/e/a$ag:CnA	Ljava/util/List;
    //   363: aload 10
    //   365: invokevirtual 121	a/j/b/a/c/g/f:flush	()V
    //   368: aload_0
    //   369: aload 9
    //   371: invokevirtual 127	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   374: putfield 66	a/j/b/a/c/e/a$ag:Ckp	La/j/b/a/c/g/d;
    //   377: aload_0
    //   378: invokevirtual 130	a/j/b/a/c/e/a$ag:emL	()V
    //   381: ldc 72
    //   383: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   386: return
    //   387: astore_1
    //   388: aload_0
    //   389: aload 9
    //   391: invokevirtual 127	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   394: putfield 66	a/j/b/a/c/e/a$ag:Ckp	La/j/b/a/c/g/d;
    //   397: goto -20 -> 377
    //   400: astore_1
    //   401: aload_0
    //   402: aload 9
    //   404: invokevirtual 127	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   407: putfield 66	a/j/b/a/c/e/a$ag:Ckp	La/j/b/a/c/g/d;
    //   410: ldc 72
    //   412: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   415: aload_1
    //   416: athrow
    //   417: astore_2
    //   418: aload_0
    //   419: aload 9
    //   421: invokevirtual 127	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   424: putfield 66	a/j/b/a/c/e/a$ag:Ckp	La/j/b/a/c/g/d;
    //   427: goto -173 -> 254
    //   430: astore_1
    //   431: aload_0
    //   432: aload 9
    //   434: invokevirtual 127	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   437: putfield 66	a/j/b/a/c/e/a$ag:Ckp	La/j/b/a/c/g/d;
    //   440: ldc 72
    //   442: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   445: aload_1
    //   446: athrow
    //   447: goto -351 -> 96
    //   450: iconst_1
    //   451: istore 6
    //   453: goto -412 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	456	0	this	ag
    //   0	456	1	parame	a.j.b.a.c.g.e
    //   0	456	2	paramg	a.j.b.a.c.g.g
    //   40	308	3	i	int
    //   59	131	4	j	int
    //   50	292	5	k	int
    //   37	415	6	m	int
    //   47	239	7	n	int
    //   53	287	8	i1	int
    //   26	407	9	localb	a.j.b.a.c.g.d.b
    //   34	330	10	localf	f
    // Exception table:
    //   from	to	target	type
    //   55	61	195	a/j/b/a/c/g/k
    //   105	118	195	a/j/b/a/c/g/k
    //   143	154	195	a/j/b/a/c/g/k
    //   171	189	195	a/j/b/a/c/g/k
    //   274	284	195	a/j/b/a/c/g/k
    //   293	301	195	a/j/b/a/c/g/k
    //   55	61	220	finally
    //   105	118	220	finally
    //   143	154	220	finally
    //   171	189	220	finally
    //   200	205	220	finally
    //   209	214	220	finally
    //   218	220	220	finally
    //   274	284	220	finally
    //   293	301	220	finally
    //   309	321	220	finally
    //   325	330	220	finally
    //   334	339	220	finally
    //   343	345	220	finally
    //   55	61	304	java/io/IOException
    //   105	118	304	java/io/IOException
    //   143	154	304	java/io/IOException
    //   171	189	304	java/io/IOException
    //   274	284	304	java/io/IOException
    //   293	301	304	java/io/IOException
    //   363	368	387	java/io/IOException
    //   363	368	400	finally
    //   240	245	417	java/io/IOException
    //   240	245	430	finally
  }
  
  private a$ag(i.a parama)
  {
    super((byte)0);
    this.Ckp = parama.Ckp;
  }
  
  public static a d(ag paramag)
  {
    AppMethodBeat.i(120973);
    paramag = a.ekq().g(paramag);
    AppMethodBeat.o(120973);
    return paramag;
  }
  
  private void egZ()
  {
    AppMethodBeat.i(120969);
    this.CnA = Collections.emptyList();
    this.CnB = -1;
    AppMethodBeat.o(120969);
  }
  
  public static ag ekl()
  {
    return Cnz;
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(120971);
    sy();
    int i = 0;
    while (i < this.CnA.size())
    {
      paramf.a(1, (q)this.CnA.get(i));
      i += 1;
    }
    if ((this.Ckr & 0x1) == 1) {
      paramf.bj(2, this.CnB);
    }
    paramf.d(this.Ckp);
    AppMethodBeat.o(120971);
  }
  
  public final s<ag> egX()
  {
    return Ckq;
  }
  
  public final boolean ekm()
  {
    return (this.Ckr & 0x1) == 1;
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(120970);
    int i = this.Cku;
    if (i == 1)
    {
      AppMethodBeat.o(120970);
      return true;
    }
    if (i == 0)
    {
      AppMethodBeat.o(120970);
      return false;
    }
    i = 0;
    while (i < this.CnA.size())
    {
      if (!((a.aa)this.CnA.get(i)).isInitialized())
      {
        this.Cku = 0;
        AppMethodBeat.o(120970);
        return false;
      }
      i += 1;
    }
    this.Cku = 1;
    AppMethodBeat.o(120970);
    return true;
  }
  
  public final int sy()
  {
    AppMethodBeat.i(120972);
    int i = this.Ckv;
    if (i != -1)
    {
      AppMethodBeat.o(120972);
      return i;
    }
    int j = 0;
    i = 0;
    while (j < this.CnA.size())
    {
      i += f.c(1, (q)this.CnA.get(j));
      j += 1;
    }
    j = i;
    if ((this.Ckr & 0x1) == 1) {
      j = i + f.bl(2, this.CnB);
    }
    i = this.Ckp.size() + j;
    this.Ckv = i;
    AppMethodBeat.o(120972);
    return i;
  }
  
  public static final class a
    extends i.a<a.ag, a>
    implements a.ah
  {
    private int Ckr;
    private List<a.aa> CnA;
    private int CnB;
    
    private a()
    {
      AppMethodBeat.i(120951);
      this.CnA = Collections.emptyList();
      this.CnB = -1;
      AppMethodBeat.o(120951);
    }
    
    private a Vc(int paramInt)
    {
      this.Ckr |= 0x2;
      this.CnB = paramInt;
      return this;
    }
    
    private a ekn()
    {
      AppMethodBeat.i(120952);
      a locala = new a().g(eko());
      AppMethodBeat.o(120952);
      return locala;
    }
    
    private void ekp()
    {
      AppMethodBeat.i(120957);
      if ((this.Ckr & 0x1) != 1)
      {
        this.CnA = new ArrayList(this.CnA);
        this.Ckr |= 0x1;
      }
      AppMethodBeat.o(120957);
    }
    
    /* Error */
    private a w(a.j.b.a.c.g.e parame, a.j.b.a.c.g.g paramg)
    {
      // Byte code:
      //   0: ldc 74
      //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aconst_null
      //   6: astore_3
      //   7: getstatic 78	a/j/b/a/c/e/a$ag:Ckq	La/j/b/a/c/g/s;
      //   10: aload_1
      //   11: aload_2
      //   12: invokeinterface 83 3 0
      //   17: checkcast 9	a/j/b/a/c/e/a$ag
      //   20: astore_1
      //   21: aload_0
      //   22: aload_1
      //   23: invokevirtual 60	a/j/b/a/c/e/a$ag$a:g	(La/j/b/a/c/e/a$ag;)La/j/b/a/c/e/a$ag$a;
      //   26: pop
      //   27: ldc 74
      //   29: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   32: aload_0
      //   33: areturn
      //   34: astore_1
      //   35: aload_1
      //   36: getfield 87	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
      //   39: checkcast 9	a/j/b/a/c/e/a$ag
      //   42: astore_2
      //   43: ldc 74
      //   45: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   48: aload_1
      //   49: athrow
      //   50: astore_1
      //   51: aload_2
      //   52: ifnull +9 -> 61
      //   55: aload_0
      //   56: aload_2
      //   57: invokevirtual 60	a/j/b/a/c/e/a$ag$a:g	(La/j/b/a/c/e/a$ag;)La/j/b/a/c/e/a$ag$a;
      //   60: pop
      //   61: ldc 74
      //   63: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    
    public final a.ag eko()
    {
      int i = 1;
      AppMethodBeat.i(120953);
      a.ag localag = new a.ag(this, (byte)0);
      int j = this.Ckr;
      if ((this.Ckr & 0x1) == 1)
      {
        this.CnA = Collections.unmodifiableList(this.CnA);
        this.Ckr &= 0xFFFFFFFE;
      }
      a.ag.a(localag, this.CnA);
      if ((j & 0x2) == 2) {}
      for (;;)
      {
        a.ag.a(localag, this.CnB);
        a.ag.b(localag, i);
        AppMethodBeat.o(120953);
        return localag;
        i = 0;
      }
    }
    
    public final a g(a.ag paramag)
    {
      AppMethodBeat.i(120954);
      if (paramag == a.ag.ekl())
      {
        AppMethodBeat.o(120954);
        return this;
      }
      if (!a.ag.e(paramag).isEmpty())
      {
        if (!this.CnA.isEmpty()) {
          break label100;
        }
        this.CnA = a.ag.e(paramag);
        this.Ckr &= 0xFFFFFFFE;
      }
      for (;;)
      {
        if (paramag.ekm()) {
          Vc(paramag.CnB);
        }
        this.Ckp = this.Ckp.a(a.ag.f(paramag));
        AppMethodBeat.o(120954);
        return this;
        label100:
        ekp();
        this.CnA.addAll(a.ag.e(paramag));
      }
    }
    
    public final boolean isInitialized()
    {
      AppMethodBeat.i(120955);
      int i = 0;
      while (i < this.CnA.size())
      {
        if (!((a.aa)this.CnA.get(i)).isInitialized())
        {
          AppMethodBeat.o(120955);
          return false;
        }
        i += 1;
      }
      AppMethodBeat.o(120955);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.j.b.a.c.e.a.ag
 * JD-Core Version:    0.7.0.1
 */