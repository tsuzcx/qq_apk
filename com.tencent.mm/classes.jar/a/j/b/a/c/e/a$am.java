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

public final class a$am
  extends i
  implements a.an
{
  public static s<am> Ckq;
  private static final am CnU;
  private final d Ckp;
  private byte Cku = -1;
  private int Ckv = -1;
  public List<a.ak> CnV;
  
  static
  {
    AppMethodBeat.i(121060);
    Ckq = new a.am.1();
    am localam = new am();
    CnU = localam;
    localam.CnV = Collections.emptyList();
    AppMethodBeat.o(121060);
  }
  
  private a$am()
  {
    this.Ckp = d.Cre;
  }
  
  /* Error */
  private a$am(a.j.b.a.c.g.e parame, a.j.b.a.c.g.g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 57	a/j/b/a/c/g/i:<init>	()V
    //   4: ldc 74
    //   6: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 59	a/j/b/a/c/e/a$am:Cku	B
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 61	a/j/b/a/c/e/a$am:Ckv	I
    //   19: aload_0
    //   20: invokestatic 50	java/util/Collections:emptyList	()Ljava/util/List;
    //   23: putfield 52	a/j/b/a/c/e/a$am:CnV	Ljava/util/List;
    //   26: invokestatic 78	a/j/b/a/c/g/d:emp	()La/j/b/a/c/g/d$b;
    //   29: astore 9
    //   31: aload 9
    //   33: iconst_1
    //   34: invokestatic 84	a/j/b/a/c/g/f:e	(Ljava/io/OutputStream;I)La/j/b/a/c/g/f;
    //   37: astore 10
    //   39: iconst_0
    //   40: istore 6
    //   42: iconst_0
    //   43: istore_3
    //   44: iload 6
    //   46: ifne +215 -> 261
    //   49: iload_3
    //   50: istore 7
    //   52: iload_3
    //   53: istore 5
    //   55: iload_3
    //   56: istore 8
    //   58: aload_1
    //   59: invokevirtual 90	a/j/b/a/c/g/e:sk	()I
    //   62: istore 4
    //   64: iload 4
    //   66: lookupswitch	default:+338->404, 0:+341->407, 10:+54->120
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
    //   108: invokevirtual 94	a/j/b/a/c/e/a$am:a	(La/j/b/a/c/g/e;La/j/b/a/c/g/f;La/j/b/a/c/g/g;I)Z
    //   111: ifne -67 -> 44
    //   114: iconst_1
    //   115: istore 6
    //   117: goto -73 -> 44
    //   120: iload_3
    //   121: istore 4
    //   123: iload_3
    //   124: iconst_1
    //   125: iand
    //   126: iconst_1
    //   127: if_icmpeq +28 -> 155
    //   130: iload_3
    //   131: istore 7
    //   133: iload_3
    //   134: istore 5
    //   136: iload_3
    //   137: istore 8
    //   139: aload_0
    //   140: new 96	java/util/ArrayList
    //   143: dup
    //   144: invokespecial 97	java/util/ArrayList:<init>	()V
    //   147: putfield 52	a/j/b/a/c/e/a$am:CnV	Ljava/util/List;
    //   150: iload_3
    //   151: iconst_1
    //   152: ior
    //   153: istore 4
    //   155: iload 4
    //   157: istore 7
    //   159: iload 4
    //   161: istore 5
    //   163: iload 4
    //   165: istore 8
    //   167: aload_0
    //   168: getfield 52	a/j/b/a/c/e/a$am:CnV	Ljava/util/List;
    //   171: aload_1
    //   172: getstatic 100	a/j/b/a/c/e/a$ak:Ckq	La/j/b/a/c/g/s;
    //   175: aload_2
    //   176: invokevirtual 103	a/j/b/a/c/g/e:a	(La/j/b/a/c/g/s;La/j/b/a/c/g/g;)La/j/b/a/c/g/q;
    //   179: invokeinterface 109 2 0
    //   184: pop
    //   185: iload 4
    //   187: istore_3
    //   188: goto -144 -> 44
    //   191: astore_1
    //   192: iload 7
    //   194: istore 5
    //   196: aload_1
    //   197: aload_0
    //   198: putfield 113	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   201: iload 7
    //   203: istore 5
    //   205: ldc 74
    //   207: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   210: iload 7
    //   212: istore 5
    //   214: aload_1
    //   215: athrow
    //   216: astore_1
    //   217: iload 5
    //   219: iconst_1
    //   220: iand
    //   221: iconst_1
    //   222: if_icmpne +14 -> 236
    //   225: aload_0
    //   226: aload_0
    //   227: getfield 52	a/j/b/a/c/e/a$am:CnV	Ljava/util/List;
    //   230: invokestatic 117	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   233: putfield 52	a/j/b/a/c/e/a$am:CnV	Ljava/util/List;
    //   236: aload 10
    //   238: invokevirtual 120	a/j/b/a/c/g/f:flush	()V
    //   241: aload_0
    //   242: aload 9
    //   244: invokevirtual 126	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   247: putfield 68	a/j/b/a/c/e/a$am:Ckp	La/j/b/a/c/g/d;
    //   250: aload_0
    //   251: invokevirtual 129	a/j/b/a/c/e/a$am:emL	()V
    //   254: ldc 74
    //   256: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   259: aload_1
    //   260: athrow
    //   261: iload_3
    //   262: iconst_1
    //   263: iand
    //   264: iconst_1
    //   265: if_icmpne +14 -> 279
    //   268: aload_0
    //   269: aload_0
    //   270: getfield 52	a/j/b/a/c/e/a$am:CnV	Ljava/util/List;
    //   273: invokestatic 117	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   276: putfield 52	a/j/b/a/c/e/a$am:CnV	Ljava/util/List;
    //   279: aload 10
    //   281: invokevirtual 120	a/j/b/a/c/g/f:flush	()V
    //   284: aload_0
    //   285: aload 9
    //   287: invokevirtual 126	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   290: putfield 68	a/j/b/a/c/e/a$am:Ckp	La/j/b/a/c/g/d;
    //   293: aload_0
    //   294: invokevirtual 129	a/j/b/a/c/e/a$am:emL	()V
    //   297: ldc 74
    //   299: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   302: return
    //   303: astore_1
    //   304: aload_0
    //   305: aload 9
    //   307: invokevirtual 126	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   310: putfield 68	a/j/b/a/c/e/a$am:Ckp	La/j/b/a/c/g/d;
    //   313: goto -20 -> 293
    //   316: astore_1
    //   317: aload_0
    //   318: aload 9
    //   320: invokevirtual 126	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   323: putfield 68	a/j/b/a/c/e/a$am:Ckp	La/j/b/a/c/g/d;
    //   326: ldc 74
    //   328: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   331: aload_1
    //   332: athrow
    //   333: astore_1
    //   334: iload 8
    //   336: istore 5
    //   338: new 71	a/j/b/a/c/g/k
    //   341: dup
    //   342: aload_1
    //   343: invokevirtual 133	java/io/IOException:getMessage	()Ljava/lang/String;
    //   346: invokespecial 136	a/j/b/a/c/g/k:<init>	(Ljava/lang/String;)V
    //   349: astore_1
    //   350: iload 8
    //   352: istore 5
    //   354: aload_1
    //   355: aload_0
    //   356: putfield 113	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   359: iload 8
    //   361: istore 5
    //   363: ldc 74
    //   365: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   368: iload 8
    //   370: istore 5
    //   372: aload_1
    //   373: athrow
    //   374: astore_2
    //   375: aload_0
    //   376: aload 9
    //   378: invokevirtual 126	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   381: putfield 68	a/j/b/a/c/e/a$am:Ckp	La/j/b/a/c/g/d;
    //   384: goto -134 -> 250
    //   387: astore_1
    //   388: aload_0
    //   389: aload 9
    //   391: invokevirtual 126	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   394: putfield 68	a/j/b/a/c/e/a$am:Ckp	La/j/b/a/c/g/d;
    //   397: ldc 74
    //   399: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   402: aload_1
    //   403: athrow
    //   404: goto -312 -> 92
    //   407: iconst_1
    //   408: istore 6
    //   410: goto -366 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	413	0	this	am
    //   0	413	1	parame	a.j.b.a.c.g.e
    //   0	413	2	paramg	a.j.b.a.c.g.g
    //   43	221	3	i	int
    //   62	124	4	j	int
    //   53	318	5	k	int
    //   40	369	6	m	int
    //   50	161	7	n	int
    //   56	313	8	i1	int
    //   29	361	9	localb	a.j.b.a.c.g.d.b
    //   37	243	10	localf	f
    // Exception table:
    //   from	to	target	type
    //   58	64	191	a/j/b/a/c/g/k
    //   101	114	191	a/j/b/a/c/g/k
    //   139	150	191	a/j/b/a/c/g/k
    //   167	185	191	a/j/b/a/c/g/k
    //   58	64	216	finally
    //   101	114	216	finally
    //   139	150	216	finally
    //   167	185	216	finally
    //   196	201	216	finally
    //   205	210	216	finally
    //   214	216	216	finally
    //   338	350	216	finally
    //   354	359	216	finally
    //   363	368	216	finally
    //   372	374	216	finally
    //   279	284	303	java/io/IOException
    //   279	284	316	finally
    //   58	64	333	java/io/IOException
    //   101	114	333	java/io/IOException
    //   139	150	333	java/io/IOException
    //   167	185	333	java/io/IOException
    //   236	241	374	java/io/IOException
    //   236	241	387	finally
  }
  
  private a$am(i.a parama)
  {
    super((byte)0);
    this.Ckp = parama.Ckp;
  }
  
  public static a.am.a c(am paramam)
  {
    AppMethodBeat.i(121057);
    paramam = a.am.a.ekL().f(paramam);
    AppMethodBeat.o(121057);
    return paramam;
  }
  
  public static am ekH()
  {
    return CnU;
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(121055);
    sy();
    int i = 0;
    while (i < this.CnV.size())
    {
      paramf.a(1, (q)this.CnV.get(i));
      i += 1;
    }
    paramf.d(this.Ckp);
    AppMethodBeat.o(121055);
  }
  
  public final s<am> egX()
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
    AppMethodBeat.i(121056);
    int i = this.Ckv;
    if (i != -1)
    {
      AppMethodBeat.o(121056);
      return i;
    }
    i = 0;
    int j = 0;
    while (i < this.CnV.size())
    {
      j += f.c(1, (q)this.CnV.get(i));
      i += 1;
    }
    i = this.Ckp.size() + j;
    this.Ckv = i;
    AppMethodBeat.o(121056);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.j.b.a.c.e.a.am
 * JD-Core Version:    0.7.0.1
 */