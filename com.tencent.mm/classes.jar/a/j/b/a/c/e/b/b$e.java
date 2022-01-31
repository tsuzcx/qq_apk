package a.j.b.a.c.e.b;

import a.j.b.a.c.g.d;
import a.j.b.a.c.g.f;
import a.j.b.a.c.g.i;
import a.j.b.a.c.g.i.a;
import a.j.b.a.c.g.s;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b$e
  extends i
  implements b.f
{
  public static s<e> Ckq;
  private static final e CpD;
  private final d Ckp;
  private int Ckr;
  private byte Cku = -1;
  private int Ckv = -1;
  public b.a CpE;
  public b.c CpF;
  public b.c CpG;
  public b.c CpH;
  
  static
  {
    AppMethodBeat.i(121235);
    Ckq = new b.e.1();
    e locale = new e();
    CpD = locale;
    locale.egZ();
    AppMethodBeat.o(121235);
  }
  
  private b$e()
  {
    this.Ckp = d.Cre;
  }
  
  /* Error */
  private b$e(a.j.b.a.c.g.e parame, a.j.b.a.c.g.g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 56	a/j/b/a/c/g/i:<init>	()V
    //   4: ldc 73
    //   6: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 58	a/j/b/a/c/e/b/b$e:Cku	B
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 60	a/j/b/a/c/e/b/b$e:Ckv	I
    //   19: aload_0
    //   20: invokespecial 51	a/j/b/a/c/e/b/b$e:egZ	()V
    //   23: invokestatic 77	a/j/b/a/c/g/d:emp	()La/j/b/a/c/g/d$b;
    //   26: astore 6
    //   28: aload 6
    //   30: iconst_1
    //   31: invokestatic 82	a/j/b/a/c/g/f:e	(Ljava/io/OutputStream;I)La/j/b/a/c/g/f;
    //   34: astore 7
    //   36: iconst_0
    //   37: istore_3
    //   38: iload_3
    //   39: ifne +430 -> 469
    //   42: aload_1
    //   43: invokevirtual 88	a/j/b/a/c/g/e:sk	()I
    //   46: istore 4
    //   48: iload 4
    //   50: lookupswitch	default:+527->577, 0:+530->580, 10:+68->118, 18:+178->228, 26:+274->324, 34:+345->395
    //   101: aload_1
    //   102: aload 7
    //   104: aload_2
    //   105: iload 4
    //   107: invokevirtual 92	a/j/b/a/c/e/b/b$e:a	(La/j/b/a/c/g/e;La/j/b/a/c/g/f;La/j/b/a/c/g/g;I)Z
    //   110: ifne -72 -> 38
    //   113: iconst_1
    //   114: istore_3
    //   115: goto -77 -> 38
    //   118: aload_0
    //   119: getfield 94	a/j/b/a/c/e/b/b$e:Ckr	I
    //   122: iconst_1
    //   123: iand
    //   124: iconst_1
    //   125: if_icmpne +446 -> 571
    //   128: aload_0
    //   129: getfield 96	a/j/b/a/c/e/b/b$e:CpE	La/j/b/a/c/e/b/b$a;
    //   132: invokevirtual 102	a/j/b/a/c/e/b/b$a:ell	()La/j/b/a/c/e/b/b$a$a;
    //   135: astore 5
    //   137: aload_0
    //   138: aload_1
    //   139: getstatic 103	a/j/b/a/c/e/b/b$a:Ckq	La/j/b/a/c/g/s;
    //   142: aload_2
    //   143: invokevirtual 106	a/j/b/a/c/g/e:a	(La/j/b/a/c/g/s;La/j/b/a/c/g/g;)La/j/b/a/c/g/q;
    //   146: checkcast 98	a/j/b/a/c/e/b/b$a
    //   149: putfield 96	a/j/b/a/c/e/b/b$e:CpE	La/j/b/a/c/e/b/b$a;
    //   152: aload 5
    //   154: ifnull +22 -> 176
    //   157: aload 5
    //   159: aload_0
    //   160: getfield 96	a/j/b/a/c/e/b/b$e:CpE	La/j/b/a/c/e/b/b$a;
    //   163: invokevirtual 112	a/j/b/a/c/e/b/b$a$a:c	(La/j/b/a/c/e/b/b$a;)La/j/b/a/c/e/b/b$a$a;
    //   166: pop
    //   167: aload_0
    //   168: aload 5
    //   170: invokevirtual 116	a/j/b/a/c/e/b/b$a$a:eln	()La/j/b/a/c/e/b/b$a;
    //   173: putfield 96	a/j/b/a/c/e/b/b$e:CpE	La/j/b/a/c/e/b/b$a;
    //   176: aload_0
    //   177: aload_0
    //   178: getfield 94	a/j/b/a/c/e/b/b$e:Ckr	I
    //   181: iconst_1
    //   182: ior
    //   183: putfield 94	a/j/b/a/c/e/b/b$e:Ckr	I
    //   186: goto -148 -> 38
    //   189: astore_1
    //   190: aload_1
    //   191: aload_0
    //   192: putfield 120	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   195: ldc 73
    //   197: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   200: aload_1
    //   201: athrow
    //   202: astore_1
    //   203: aload 7
    //   205: invokevirtual 123	a/j/b/a/c/g/f:flush	()V
    //   208: aload_0
    //   209: aload 6
    //   211: invokevirtual 129	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   214: putfield 67	a/j/b/a/c/e/b/b$e:Ckp	La/j/b/a/c/g/d;
    //   217: aload_0
    //   218: invokevirtual 132	a/j/b/a/c/e/b/b$e:emL	()V
    //   221: ldc 73
    //   223: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   226: aload_1
    //   227: athrow
    //   228: aload_0
    //   229: getfield 94	a/j/b/a/c/e/b/b$e:Ckr	I
    //   232: iconst_2
    //   233: iand
    //   234: iconst_2
    //   235: if_icmpne +330 -> 565
    //   238: aload_0
    //   239: getfield 134	a/j/b/a/c/e/b/b$e:CpF	La/j/b/a/c/e/b/b$c;
    //   242: invokevirtual 140	a/j/b/a/c/e/b/b$c:elq	()La/j/b/a/c/e/b/b$c$a;
    //   245: astore 5
    //   247: aload_0
    //   248: aload_1
    //   249: getstatic 141	a/j/b/a/c/e/b/b$c:Ckq	La/j/b/a/c/g/s;
    //   252: aload_2
    //   253: invokevirtual 106	a/j/b/a/c/g/e:a	(La/j/b/a/c/g/s;La/j/b/a/c/g/g;)La/j/b/a/c/g/q;
    //   256: checkcast 136	a/j/b/a/c/e/b/b$c
    //   259: putfield 134	a/j/b/a/c/e/b/b$e:CpF	La/j/b/a/c/e/b/b$c;
    //   262: aload 5
    //   264: ifnull +22 -> 286
    //   267: aload 5
    //   269: aload_0
    //   270: getfield 134	a/j/b/a/c/e/b/b$e:CpF	La/j/b/a/c/e/b/b$c;
    //   273: invokevirtual 146	a/j/b/a/c/e/b/b$c$a:c	(La/j/b/a/c/e/b/b$c;)La/j/b/a/c/e/b/b$c$a;
    //   276: pop
    //   277: aload_0
    //   278: aload 5
    //   280: invokevirtual 150	a/j/b/a/c/e/b/b$c$a:els	()La/j/b/a/c/e/b/b$c;
    //   283: putfield 134	a/j/b/a/c/e/b/b$e:CpF	La/j/b/a/c/e/b/b$c;
    //   286: aload_0
    //   287: aload_0
    //   288: getfield 94	a/j/b/a/c/e/b/b$e:Ckr	I
    //   291: iconst_2
    //   292: ior
    //   293: putfield 94	a/j/b/a/c/e/b/b$e:Ckr	I
    //   296: goto -258 -> 38
    //   299: astore_1
    //   300: new 70	a/j/b/a/c/g/k
    //   303: dup
    //   304: aload_1
    //   305: invokevirtual 154	java/io/IOException:getMessage	()Ljava/lang/String;
    //   308: invokespecial 157	a/j/b/a/c/g/k:<init>	(Ljava/lang/String;)V
    //   311: astore_1
    //   312: aload_1
    //   313: aload_0
    //   314: putfield 120	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   317: ldc 73
    //   319: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   322: aload_1
    //   323: athrow
    //   324: aload_0
    //   325: getfield 94	a/j/b/a/c/e/b/b$e:Ckr	I
    //   328: iconst_4
    //   329: iand
    //   330: iconst_4
    //   331: if_icmpne +228 -> 559
    //   334: aload_0
    //   335: getfield 159	a/j/b/a/c/e/b/b$e:CpG	La/j/b/a/c/e/b/b$c;
    //   338: invokevirtual 140	a/j/b/a/c/e/b/b$c:elq	()La/j/b/a/c/e/b/b$c$a;
    //   341: astore 5
    //   343: aload_0
    //   344: aload_1
    //   345: getstatic 141	a/j/b/a/c/e/b/b$c:Ckq	La/j/b/a/c/g/s;
    //   348: aload_2
    //   349: invokevirtual 106	a/j/b/a/c/g/e:a	(La/j/b/a/c/g/s;La/j/b/a/c/g/g;)La/j/b/a/c/g/q;
    //   352: checkcast 136	a/j/b/a/c/e/b/b$c
    //   355: putfield 159	a/j/b/a/c/e/b/b$e:CpG	La/j/b/a/c/e/b/b$c;
    //   358: aload 5
    //   360: ifnull +22 -> 382
    //   363: aload 5
    //   365: aload_0
    //   366: getfield 159	a/j/b/a/c/e/b/b$e:CpG	La/j/b/a/c/e/b/b$c;
    //   369: invokevirtual 146	a/j/b/a/c/e/b/b$c$a:c	(La/j/b/a/c/e/b/b$c;)La/j/b/a/c/e/b/b$c$a;
    //   372: pop
    //   373: aload_0
    //   374: aload 5
    //   376: invokevirtual 150	a/j/b/a/c/e/b/b$c$a:els	()La/j/b/a/c/e/b/b$c;
    //   379: putfield 159	a/j/b/a/c/e/b/b$e:CpG	La/j/b/a/c/e/b/b$c;
    //   382: aload_0
    //   383: aload_0
    //   384: getfield 94	a/j/b/a/c/e/b/b$e:Ckr	I
    //   387: iconst_4
    //   388: ior
    //   389: putfield 94	a/j/b/a/c/e/b/b$e:Ckr	I
    //   392: goto -354 -> 38
    //   395: aload_0
    //   396: getfield 94	a/j/b/a/c/e/b/b$e:Ckr	I
    //   399: bipush 8
    //   401: iand
    //   402: bipush 8
    //   404: if_icmpne +149 -> 553
    //   407: aload_0
    //   408: getfield 161	a/j/b/a/c/e/b/b$e:CpH	La/j/b/a/c/e/b/b$c;
    //   411: invokevirtual 140	a/j/b/a/c/e/b/b$c:elq	()La/j/b/a/c/e/b/b$c$a;
    //   414: astore 5
    //   416: aload_0
    //   417: aload_1
    //   418: getstatic 141	a/j/b/a/c/e/b/b$c:Ckq	La/j/b/a/c/g/s;
    //   421: aload_2
    //   422: invokevirtual 106	a/j/b/a/c/g/e:a	(La/j/b/a/c/g/s;La/j/b/a/c/g/g;)La/j/b/a/c/g/q;
    //   425: checkcast 136	a/j/b/a/c/e/b/b$c
    //   428: putfield 161	a/j/b/a/c/e/b/b$e:CpH	La/j/b/a/c/e/b/b$c;
    //   431: aload 5
    //   433: ifnull +22 -> 455
    //   436: aload 5
    //   438: aload_0
    //   439: getfield 161	a/j/b/a/c/e/b/b$e:CpH	La/j/b/a/c/e/b/b$c;
    //   442: invokevirtual 146	a/j/b/a/c/e/b/b$c$a:c	(La/j/b/a/c/e/b/b$c;)La/j/b/a/c/e/b/b$c$a;
    //   445: pop
    //   446: aload_0
    //   447: aload 5
    //   449: invokevirtual 150	a/j/b/a/c/e/b/b$c$a:els	()La/j/b/a/c/e/b/b$c;
    //   452: putfield 161	a/j/b/a/c/e/b/b$e:CpH	La/j/b/a/c/e/b/b$c;
    //   455: aload_0
    //   456: aload_0
    //   457: getfield 94	a/j/b/a/c/e/b/b$e:Ckr	I
    //   460: bipush 8
    //   462: ior
    //   463: putfield 94	a/j/b/a/c/e/b/b$e:Ckr	I
    //   466: goto -428 -> 38
    //   469: aload 7
    //   471: invokevirtual 123	a/j/b/a/c/g/f:flush	()V
    //   474: aload_0
    //   475: aload 6
    //   477: invokevirtual 129	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   480: putfield 67	a/j/b/a/c/e/b/b$e:Ckp	La/j/b/a/c/g/d;
    //   483: aload_0
    //   484: invokevirtual 132	a/j/b/a/c/e/b/b$e:emL	()V
    //   487: ldc 73
    //   489: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   492: return
    //   493: astore_1
    //   494: aload_0
    //   495: aload 6
    //   497: invokevirtual 129	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   500: putfield 67	a/j/b/a/c/e/b/b$e:Ckp	La/j/b/a/c/g/d;
    //   503: goto -20 -> 483
    //   506: astore_1
    //   507: aload_0
    //   508: aload 6
    //   510: invokevirtual 129	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   513: putfield 67	a/j/b/a/c/e/b/b$e:Ckp	La/j/b/a/c/g/d;
    //   516: ldc 73
    //   518: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   521: aload_1
    //   522: athrow
    //   523: astore_2
    //   524: aload_0
    //   525: aload 6
    //   527: invokevirtual 129	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   530: putfield 67	a/j/b/a/c/e/b/b$e:Ckp	La/j/b/a/c/g/d;
    //   533: goto -316 -> 217
    //   536: astore_1
    //   537: aload_0
    //   538: aload 6
    //   540: invokevirtual 129	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   543: putfield 67	a/j/b/a/c/e/b/b$e:Ckp	La/j/b/a/c/g/d;
    //   546: ldc 73
    //   548: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   551: aload_1
    //   552: athrow
    //   553: aconst_null
    //   554: astore 5
    //   556: goto -140 -> 416
    //   559: aconst_null
    //   560: astore 5
    //   562: goto -219 -> 343
    //   565: aconst_null
    //   566: astore 5
    //   568: goto -321 -> 247
    //   571: aconst_null
    //   572: astore 5
    //   574: goto -437 -> 137
    //   577: goto -477 -> 100
    //   580: iconst_1
    //   581: istore_3
    //   582: goto -544 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	585	0	this	e
    //   0	585	1	parame	a.j.b.a.c.g.e
    //   0	585	2	paramg	a.j.b.a.c.g.g
    //   37	545	3	i	int
    //   46	60	4	j	int
    //   135	438	5	localObject	java.lang.Object
    //   26	513	6	localb	a.j.b.a.c.g.d.b
    //   34	436	7	localf	f
    // Exception table:
    //   from	to	target	type
    //   42	48	189	a/j/b/a/c/g/k
    //   100	113	189	a/j/b/a/c/g/k
    //   118	137	189	a/j/b/a/c/g/k
    //   137	152	189	a/j/b/a/c/g/k
    //   157	176	189	a/j/b/a/c/g/k
    //   176	186	189	a/j/b/a/c/g/k
    //   228	247	189	a/j/b/a/c/g/k
    //   247	262	189	a/j/b/a/c/g/k
    //   267	286	189	a/j/b/a/c/g/k
    //   286	296	189	a/j/b/a/c/g/k
    //   324	343	189	a/j/b/a/c/g/k
    //   343	358	189	a/j/b/a/c/g/k
    //   363	382	189	a/j/b/a/c/g/k
    //   382	392	189	a/j/b/a/c/g/k
    //   395	416	189	a/j/b/a/c/g/k
    //   416	431	189	a/j/b/a/c/g/k
    //   436	455	189	a/j/b/a/c/g/k
    //   455	466	189	a/j/b/a/c/g/k
    //   42	48	202	finally
    //   100	113	202	finally
    //   118	137	202	finally
    //   137	152	202	finally
    //   157	176	202	finally
    //   176	186	202	finally
    //   190	202	202	finally
    //   228	247	202	finally
    //   247	262	202	finally
    //   267	286	202	finally
    //   286	296	202	finally
    //   300	324	202	finally
    //   324	343	202	finally
    //   343	358	202	finally
    //   363	382	202	finally
    //   382	392	202	finally
    //   395	416	202	finally
    //   416	431	202	finally
    //   436	455	202	finally
    //   455	466	202	finally
    //   42	48	299	java/io/IOException
    //   100	113	299	java/io/IOException
    //   118	137	299	java/io/IOException
    //   137	152	299	java/io/IOException
    //   157	176	299	java/io/IOException
    //   176	186	299	java/io/IOException
    //   228	247	299	java/io/IOException
    //   247	262	299	java/io/IOException
    //   267	286	299	java/io/IOException
    //   286	296	299	java/io/IOException
    //   324	343	299	java/io/IOException
    //   343	358	299	java/io/IOException
    //   363	382	299	java/io/IOException
    //   382	392	299	java/io/IOException
    //   395	416	299	java/io/IOException
    //   416	431	299	java/io/IOException
    //   436	455	299	java/io/IOException
    //   455	466	299	java/io/IOException
    //   469	474	493	java/io/IOException
    //   469	474	506	finally
    //   203	208	523	java/io/IOException
    //   203	208	536	finally
  }
  
  private b$e(i.a parama)
  {
    super((byte)0);
    this.Ckp = parama.Ckp;
  }
  
  private void egZ()
  {
    AppMethodBeat.i(121230);
    this.CpE = b.a.elj();
    this.CpF = b.c.elp();
    this.CpG = b.c.elp();
    this.CpH = b.c.elp();
    AppMethodBeat.o(121230);
  }
  
  public static e elu()
  {
    return CpD;
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(121231);
    sy();
    if ((this.Ckr & 0x1) == 1) {
      paramf.a(1, this.CpE);
    }
    if ((this.Ckr & 0x2) == 2) {
      paramf.a(2, this.CpF);
    }
    if ((this.Ckr & 0x4) == 4) {
      paramf.a(3, this.CpG);
    }
    if ((this.Ckr & 0x8) == 8) {
      paramf.a(4, this.CpH);
    }
    paramf.d(this.Ckp);
    AppMethodBeat.o(121231);
  }
  
  public final s<e> egX()
  {
    return Ckq;
  }
  
  public final boolean elv()
  {
    return (this.Ckr & 0x1) == 1;
  }
  
  public final boolean elw()
  {
    return (this.Ckr & 0x2) == 2;
  }
  
  public final boolean elx()
  {
    return (this.Ckr & 0x4) == 4;
  }
  
  public final boolean ely()
  {
    return (this.Ckr & 0x8) == 8;
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
    AppMethodBeat.i(121232);
    int i = this.Ckv;
    if (i != -1)
    {
      AppMethodBeat.o(121232);
      return i;
    }
    int j = 0;
    if ((this.Ckr & 0x1) == 1) {
      j = f.c(1, this.CpE) + 0;
    }
    i = j;
    if ((this.Ckr & 0x2) == 2) {
      i = j + f.c(2, this.CpF);
    }
    j = i;
    if ((this.Ckr & 0x4) == 4) {
      j = i + f.c(3, this.CpG);
    }
    i = j;
    if ((this.Ckr & 0x8) == 8) {
      i = j + f.c(4, this.CpH);
    }
    i += this.Ckp.size();
    this.Ckv = i;
    AppMethodBeat.o(121232);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.j.b.a.c.e.b.b.e
 * JD-Core Version:    0.7.0.1
 */