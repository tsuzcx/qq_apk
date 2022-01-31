package a.j.b.a.c.e;

import a.j.b.a.c.g.d;
import a.j.b.a.c.g.f;
import a.j.b.a.c.g.i;
import a.j.b.a.c.g.i.a;
import a.j.b.a.c.g.n;
import a.j.b.a.c.g.o;
import a.j.b.a.c.g.s;
import a.j.b.a.c.g.t;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a$y
  extends i
  implements a.z
{
  public static s<y> Ckq;
  private static final y CmL;
  private final d Ckp;
  private byte Cku = -1;
  private int Ckv = -1;
  private o CmM;
  
  static
  {
    AppMethodBeat.i(120819);
    Ckq = new a.y.1();
    y localy = new y();
    CmL = localy;
    localy.CmM = n.CrT;
    AppMethodBeat.o(120819);
  }
  
  private a$y()
  {
    this.Ckp = d.Cre;
  }
  
  /* Error */
  private a$y(a.j.b.a.c.g.e parame, a.j.b.a.c.g.g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 55	a/j/b/a/c/g/i:<init>	()V
    //   4: ldc 72
    //   6: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 57	a/j/b/a/c/e/a$y:Cku	B
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 59	a/j/b/a/c/e/a$y:Ckv	I
    //   19: aload_0
    //   20: getstatic 48	a/j/b/a/c/g/n:CrT	La/j/b/a/c/g/o;
    //   23: putfield 50	a/j/b/a/c/e/a$y:CmM	La/j/b/a/c/g/o;
    //   26: invokestatic 76	a/j/b/a/c/g/d:emp	()La/j/b/a/c/g/d$b;
    //   29: astore 9
    //   31: aload 9
    //   33: iconst_1
    //   34: invokestatic 82	a/j/b/a/c/g/f:e	(Ljava/io/OutputStream;I)La/j/b/a/c/g/f;
    //   37: astore 10
    //   39: iconst_0
    //   40: istore 6
    //   42: iconst_0
    //   43: istore_3
    //   44: iload 6
    //   46: ifne +225 -> 271
    //   49: iload_3
    //   50: istore 7
    //   52: iload_3
    //   53: istore 5
    //   55: iload_3
    //   56: istore 8
    //   58: aload_1
    //   59: invokevirtual 88	a/j/b/a/c/g/e:sk	()I
    //   62: istore 4
    //   64: iload 4
    //   66: lookupswitch	default:+350->416, 0:+353->419, 10:+54->120
    //   93: istore 7
    //   95: iload_3
    //   96: istore 5
    //   98: iload_3
    //   99: istore 8
    //   101: aload_0
    //   102: aload_1
    //   103: aload 10
    //   105: aload_2
    //   106: iload 4
    //   108: invokevirtual 92	a/j/b/a/c/e/a$y:a	(La/j/b/a/c/g/e;La/j/b/a/c/g/f;La/j/b/a/c/g/g;I)Z
    //   111: ifne -67 -> 44
    //   114: iconst_1
    //   115: istore 6
    //   117: goto -73 -> 44
    //   120: iload_3
    //   121: istore 7
    //   123: iload_3
    //   124: istore 5
    //   126: iload_3
    //   127: istore 8
    //   129: aload_1
    //   130: invokevirtual 96	a/j/b/a/c/g/e:emv	()La/j/b/a/c/g/d;
    //   133: astore 11
    //   135: iload_3
    //   136: istore 4
    //   138: iload_3
    //   139: iconst_1
    //   140: iand
    //   141: iconst_1
    //   142: if_icmpeq +28 -> 170
    //   145: iload_3
    //   146: istore 7
    //   148: iload_3
    //   149: istore 5
    //   151: iload_3
    //   152: istore 8
    //   154: aload_0
    //   155: new 45	a/j/b/a/c/g/n
    //   158: dup
    //   159: invokespecial 97	a/j/b/a/c/g/n:<init>	()V
    //   162: putfield 50	a/j/b/a/c/e/a$y:CmM	La/j/b/a/c/g/o;
    //   165: iload_3
    //   166: iconst_1
    //   167: ior
    //   168: istore 4
    //   170: iload 4
    //   172: istore 7
    //   174: iload 4
    //   176: istore 5
    //   178: iload 4
    //   180: istore 8
    //   182: aload_0
    //   183: getfield 50	a/j/b/a/c/e/a$y:CmM	La/j/b/a/c/g/o;
    //   186: aload 11
    //   188: invokeinterface 102 2 0
    //   193: iload 4
    //   195: istore_3
    //   196: goto -152 -> 44
    //   199: astore_1
    //   200: iload 7
    //   202: istore 5
    //   204: aload_1
    //   205: aload_0
    //   206: putfield 106	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   209: iload 7
    //   211: istore 5
    //   213: ldc 72
    //   215: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   218: iload 7
    //   220: istore 5
    //   222: aload_1
    //   223: athrow
    //   224: astore_1
    //   225: iload 5
    //   227: iconst_1
    //   228: iand
    //   229: iconst_1
    //   230: if_icmpne +16 -> 246
    //   233: aload_0
    //   234: aload_0
    //   235: getfield 50	a/j/b/a/c/e/a$y:CmM	La/j/b/a/c/g/o;
    //   238: invokeinterface 110 1 0
    //   243: putfield 50	a/j/b/a/c/e/a$y:CmM	La/j/b/a/c/g/o;
    //   246: aload 10
    //   248: invokevirtual 113	a/j/b/a/c/g/f:flush	()V
    //   251: aload_0
    //   252: aload 9
    //   254: invokevirtual 118	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   257: putfield 66	a/j/b/a/c/e/a$y:Ckp	La/j/b/a/c/g/d;
    //   260: aload_0
    //   261: invokevirtual 121	a/j/b/a/c/e/a$y:emL	()V
    //   264: ldc 72
    //   266: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   269: aload_1
    //   270: athrow
    //   271: iload_3
    //   272: iconst_1
    //   273: iand
    //   274: iconst_1
    //   275: if_icmpne +16 -> 291
    //   278: aload_0
    //   279: aload_0
    //   280: getfield 50	a/j/b/a/c/e/a$y:CmM	La/j/b/a/c/g/o;
    //   283: invokeinterface 110 1 0
    //   288: putfield 50	a/j/b/a/c/e/a$y:CmM	La/j/b/a/c/g/o;
    //   291: aload 10
    //   293: invokevirtual 113	a/j/b/a/c/g/f:flush	()V
    //   296: aload_0
    //   297: aload 9
    //   299: invokevirtual 118	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   302: putfield 66	a/j/b/a/c/e/a$y:Ckp	La/j/b/a/c/g/d;
    //   305: aload_0
    //   306: invokevirtual 121	a/j/b/a/c/e/a$y:emL	()V
    //   309: ldc 72
    //   311: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   314: return
    //   315: astore_1
    //   316: aload_0
    //   317: aload 9
    //   319: invokevirtual 118	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   322: putfield 66	a/j/b/a/c/e/a$y:Ckp	La/j/b/a/c/g/d;
    //   325: goto -20 -> 305
    //   328: astore_1
    //   329: aload_0
    //   330: aload 9
    //   332: invokevirtual 118	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   335: putfield 66	a/j/b/a/c/e/a$y:Ckp	La/j/b/a/c/g/d;
    //   338: ldc 72
    //   340: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   343: aload_1
    //   344: athrow
    //   345: astore_1
    //   346: iload 8
    //   348: istore 5
    //   350: new 69	a/j/b/a/c/g/k
    //   353: dup
    //   354: aload_1
    //   355: invokevirtual 125	java/io/IOException:getMessage	()Ljava/lang/String;
    //   358: invokespecial 128	a/j/b/a/c/g/k:<init>	(Ljava/lang/String;)V
    //   361: astore_1
    //   362: iload 8
    //   364: istore 5
    //   366: aload_1
    //   367: aload_0
    //   368: putfield 106	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   371: iload 8
    //   373: istore 5
    //   375: ldc 72
    //   377: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   380: iload 8
    //   382: istore 5
    //   384: aload_1
    //   385: athrow
    //   386: astore_2
    //   387: aload_0
    //   388: aload 9
    //   390: invokevirtual 118	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   393: putfield 66	a/j/b/a/c/e/a$y:Ckp	La/j/b/a/c/g/d;
    //   396: goto -136 -> 260
    //   399: astore_1
    //   400: aload_0
    //   401: aload 9
    //   403: invokevirtual 118	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   406: putfield 66	a/j/b/a/c/e/a$y:Ckp	La/j/b/a/c/g/d;
    //   409: ldc 72
    //   411: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   414: aload_1
    //   415: athrow
    //   416: goto -324 -> 92
    //   419: iconst_1
    //   420: istore 6
    //   422: goto -378 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	425	0	this	y
    //   0	425	1	parame	a.j.b.a.c.g.e
    //   0	425	2	paramg	a.j.b.a.c.g.g
    //   43	231	3	i	int
    //   62	132	4	j	int
    //   53	330	5	k	int
    //   40	381	6	m	int
    //   50	169	7	n	int
    //   56	325	8	i1	int
    //   29	373	9	localb	a.j.b.a.c.g.d.b
    //   37	255	10	localf	f
    //   133	54	11	locald	d
    // Exception table:
    //   from	to	target	type
    //   58	64	199	a/j/b/a/c/g/k
    //   101	114	199	a/j/b/a/c/g/k
    //   129	135	199	a/j/b/a/c/g/k
    //   154	165	199	a/j/b/a/c/g/k
    //   182	193	199	a/j/b/a/c/g/k
    //   58	64	224	finally
    //   101	114	224	finally
    //   129	135	224	finally
    //   154	165	224	finally
    //   182	193	224	finally
    //   204	209	224	finally
    //   213	218	224	finally
    //   222	224	224	finally
    //   350	362	224	finally
    //   366	371	224	finally
    //   375	380	224	finally
    //   384	386	224	finally
    //   291	296	315	java/io/IOException
    //   291	296	328	finally
    //   58	64	345	java/io/IOException
    //   101	114	345	java/io/IOException
    //   129	135	345	java/io/IOException
    //   154	165	345	java/io/IOException
    //   182	193	345	java/io/IOException
    //   246	251	386	java/io/IOException
    //   246	251	399	finally
  }
  
  private a$y(i.a parama)
  {
    super((byte)0);
    this.Ckp = parama.Ckp;
  }
  
  public static a.y.a a(y paramy)
  {
    AppMethodBeat.i(120815);
    paramy = a.y.a.ejv().d(paramy);
    AppMethodBeat.o(120815);
    return paramy;
  }
  
  public static y ejq()
  {
    return CmL;
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(120813);
    sy();
    int i = 0;
    while (i < this.CmM.size())
    {
      paramf.a(1, this.CmM.VK(i));
      i += 1;
    }
    paramf.d(this.Ckp);
    AppMethodBeat.o(120813);
  }
  
  public final s<y> egX()
  {
    return Ckq;
  }
  
  public final a.y.a ejr()
  {
    AppMethodBeat.i(120816);
    a.y.a locala = a.y.a.ejv().d(this);
    AppMethodBeat.o(120816);
    return locala;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(120812);
    String str = (String)this.CmM.get(paramInt);
    AppMethodBeat.o(120812);
    return str;
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
    AppMethodBeat.i(120814);
    int i = this.Ckv;
    if (i != -1)
    {
      AppMethodBeat.o(120814);
      return i;
    }
    int j = 0;
    int k;
    for (i = 0; j < this.CmM.size(); i = k + i)
    {
      k = f.c(this.CmM.VK(j));
      j += 1;
    }
    i = i + 0 + this.CmM.size() * 1 + this.Ckp.size();
    this.Ckv = i;
    AppMethodBeat.o(120814);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.c.e.a.y
 * JD-Core Version:    0.7.0.1
 */