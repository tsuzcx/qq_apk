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

public final class a$i
  extends i
  implements a.j
{
  public static s<i> Ckq;
  private static final i ClF;
  private final d Ckp;
  private int Ckr;
  private byte Cku = -1;
  private int Ckv = -1;
  a.i.b ClG;
  private List<a.m> ClH;
  a.m ClI;
  a.i.c ClJ;
  
  static
  {
    AppMethodBeat.i(120576);
    Ckq = new a.i.1();
    i locali = new i();
    ClF = locali;
    locali.egZ();
    AppMethodBeat.o(120576);
  }
  
  private a$i()
  {
    this.Ckp = d.Cre;
  }
  
  /* Error */
  private a$i(a.j.b.a.c.g.e parame, a.j.b.a.c.g.g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 62	a/j/b/a/c/g/i:<init>	()V
    //   4: ldc 79
    //   6: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 64	a/j/b/a/c/e/a$i:Cku	B
    //   14: aload_0
    //   15: iconst_m1
    //   16: putfield 66	a/j/b/a/c/e/a$i:Ckv	I
    //   19: aload_0
    //   20: invokespecial 57	a/j/b/a/c/e/a$i:egZ	()V
    //   23: invokestatic 83	a/j/b/a/c/g/d:emp	()La/j/b/a/c/g/d$b;
    //   26: astore 11
    //   28: aload 11
    //   30: iconst_1
    //   31: invokestatic 89	a/j/b/a/c/g/f:e	(Ljava/io/OutputStream;I)La/j/b/a/c/g/f;
    //   34: astore 12
    //   36: iconst_0
    //   37: istore 6
    //   39: iconst_0
    //   40: istore_3
    //   41: iload 6
    //   43: ifne +620 -> 663
    //   46: iload_3
    //   47: istore 7
    //   49: iload_3
    //   50: istore 5
    //   52: iload_3
    //   53: istore 8
    //   55: aload_1
    //   56: invokevirtual 95	a/j/b/a/c/g/e:sk	()I
    //   59: istore 4
    //   61: iload 4
    //   63: lookupswitch	default:+708->771, 0:+711->774, 8:+77->140, 18:+296->359, 26:+367->430, 32:+492->555
    //   113: istore 7
    //   115: iload_3
    //   116: istore 5
    //   118: iload_3
    //   119: istore 8
    //   121: aload_0
    //   122: aload_1
    //   123: aload 12
    //   125: aload_2
    //   126: iload 4
    //   128: invokevirtual 99	a/j/b/a/c/e/a$i:a	(La/j/b/a/c/g/e;La/j/b/a/c/g/f;La/j/b/a/c/g/g;I)Z
    //   131: ifne -90 -> 41
    //   134: iconst_1
    //   135: istore 6
    //   137: goto -96 -> 41
    //   140: iload_3
    //   141: istore 7
    //   143: iload_3
    //   144: istore 5
    //   146: iload_3
    //   147: istore 8
    //   149: aload_1
    //   150: invokevirtual 102	a/j/b/a/c/g/e:sl	()I
    //   153: istore 9
    //   155: iload_3
    //   156: istore 7
    //   158: iload_3
    //   159: istore 5
    //   161: iload_3
    //   162: istore 8
    //   164: iload 9
    //   166: invokestatic 106	a/j/b/a/c/e/a$i$b:Ul	(I)La/j/b/a/c/e/a$i$b;
    //   169: astore 10
    //   171: aload 10
    //   173: ifnonnull +108 -> 281
    //   176: iload_3
    //   177: istore 7
    //   179: iload_3
    //   180: istore 5
    //   182: iload_3
    //   183: istore 8
    //   185: aload 12
    //   187: iload 4
    //   189: invokevirtual 109	a/j/b/a/c/g/f:eX	(I)V
    //   192: iload_3
    //   193: istore 7
    //   195: iload_3
    //   196: istore 5
    //   198: iload_3
    //   199: istore 8
    //   201: aload 12
    //   203: iload 9
    //   205: invokevirtual 109	a/j/b/a/c/g/f:eX	(I)V
    //   208: goto -167 -> 41
    //   211: astore_1
    //   212: iload 7
    //   214: istore 5
    //   216: aload_1
    //   217: aload_0
    //   218: putfield 113	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   221: iload 7
    //   223: istore 5
    //   225: ldc 79
    //   227: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   230: iload 7
    //   232: istore 5
    //   234: aload_1
    //   235: athrow
    //   236: astore_1
    //   237: iload 5
    //   239: iconst_2
    //   240: iand
    //   241: iconst_2
    //   242: if_icmpne +14 -> 256
    //   245: aload_0
    //   246: aload_0
    //   247: getfield 115	a/j/b/a/c/e/a$i:ClH	Ljava/util/List;
    //   250: invokestatic 121	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   253: putfield 115	a/j/b/a/c/e/a$i:ClH	Ljava/util/List;
    //   256: aload 12
    //   258: invokevirtual 124	a/j/b/a/c/g/f:flush	()V
    //   261: aload_0
    //   262: aload 11
    //   264: invokevirtual 130	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   267: putfield 73	a/j/b/a/c/e/a$i:Ckp	La/j/b/a/c/g/d;
    //   270: aload_0
    //   271: invokevirtual 133	a/j/b/a/c/e/a$i:emL	()V
    //   274: ldc 79
    //   276: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   279: aload_1
    //   280: athrow
    //   281: iload_3
    //   282: istore 7
    //   284: iload_3
    //   285: istore 5
    //   287: iload_3
    //   288: istore 8
    //   290: aload_0
    //   291: aload_0
    //   292: getfield 135	a/j/b/a/c/e/a$i:Ckr	I
    //   295: iconst_1
    //   296: ior
    //   297: putfield 135	a/j/b/a/c/e/a$i:Ckr	I
    //   300: iload_3
    //   301: istore 7
    //   303: iload_3
    //   304: istore 5
    //   306: iload_3
    //   307: istore 8
    //   309: aload_0
    //   310: aload 10
    //   312: putfield 137	a/j/b/a/c/e/a$i:ClG	La/j/b/a/c/e/a$i$b;
    //   315: goto -274 -> 41
    //   318: astore_1
    //   319: iload 8
    //   321: istore 5
    //   323: new 76	a/j/b/a/c/g/k
    //   326: dup
    //   327: aload_1
    //   328: invokevirtual 141	java/io/IOException:getMessage	()Ljava/lang/String;
    //   331: invokespecial 144	a/j/b/a/c/g/k:<init>	(Ljava/lang/String;)V
    //   334: astore_1
    //   335: iload 8
    //   337: istore 5
    //   339: aload_1
    //   340: aload_0
    //   341: putfield 113	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   344: iload 8
    //   346: istore 5
    //   348: ldc 79
    //   350: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   353: iload 8
    //   355: istore 5
    //   357: aload_1
    //   358: athrow
    //   359: iload_3
    //   360: istore 4
    //   362: iload_3
    //   363: iconst_2
    //   364: iand
    //   365: iconst_2
    //   366: if_icmpeq +28 -> 394
    //   369: iload_3
    //   370: istore 7
    //   372: iload_3
    //   373: istore 5
    //   375: iload_3
    //   376: istore 8
    //   378: aload_0
    //   379: new 146	java/util/ArrayList
    //   382: dup
    //   383: invokespecial 147	java/util/ArrayList:<init>	()V
    //   386: putfield 115	a/j/b/a/c/e/a$i:ClH	Ljava/util/List;
    //   389: iload_3
    //   390: iconst_2
    //   391: ior
    //   392: istore 4
    //   394: iload 4
    //   396: istore 7
    //   398: iload 4
    //   400: istore 5
    //   402: iload 4
    //   404: istore 8
    //   406: aload_0
    //   407: getfield 115	a/j/b/a/c/e/a$i:ClH	Ljava/util/List;
    //   410: aload_1
    //   411: getstatic 150	a/j/b/a/c/e/a$m:Ckq	La/j/b/a/c/g/s;
    //   414: aload_2
    //   415: invokevirtual 153	a/j/b/a/c/g/e:a	(La/j/b/a/c/g/s;La/j/b/a/c/g/g;)La/j/b/a/c/g/q;
    //   418: invokeinterface 159 2 0
    //   423: pop
    //   424: iload 4
    //   426: istore_3
    //   427: goto -386 -> 41
    //   430: iload_3
    //   431: istore 7
    //   433: iload_3
    //   434: istore 5
    //   436: iload_3
    //   437: istore 8
    //   439: aload_0
    //   440: getfield 135	a/j/b/a/c/e/a$i:Ckr	I
    //   443: iconst_2
    //   444: iand
    //   445: iconst_2
    //   446: if_icmpne +319 -> 765
    //   449: iload_3
    //   450: istore 7
    //   452: iload_3
    //   453: istore 5
    //   455: iload_3
    //   456: istore 8
    //   458: aload_0
    //   459: getfield 161	a/j/b/a/c/e/a$i:ClI	La/j/b/a/c/e/a$m;
    //   462: invokestatic 165	a/j/b/a/c/e/a$m:b	(La/j/b/a/c/e/a$m;)La/j/b/a/c/e/a$m$a;
    //   465: astore 10
    //   467: iload_3
    //   468: istore 7
    //   470: iload_3
    //   471: istore 5
    //   473: iload_3
    //   474: istore 8
    //   476: aload_0
    //   477: aload_1
    //   478: getstatic 150	a/j/b/a/c/e/a$m:Ckq	La/j/b/a/c/g/s;
    //   481: aload_2
    //   482: invokevirtual 153	a/j/b/a/c/g/e:a	(La/j/b/a/c/g/s;La/j/b/a/c/g/g;)La/j/b/a/c/g/q;
    //   485: checkcast 149	a/j/b/a/c/e/a$m
    //   488: putfield 161	a/j/b/a/c/e/a$i:ClI	La/j/b/a/c/e/a$m;
    //   491: aload 10
    //   493: ifnull +40 -> 533
    //   496: iload_3
    //   497: istore 7
    //   499: iload_3
    //   500: istore 5
    //   502: iload_3
    //   503: istore 8
    //   505: aload 10
    //   507: aload_0
    //   508: getfield 161	a/j/b/a/c/e/a$i:ClI	La/j/b/a/c/e/a$m;
    //   511: invokevirtual 170	a/j/b/a/c/e/a$m$a:f	(La/j/b/a/c/e/a$m;)La/j/b/a/c/e/a$m$a;
    //   514: pop
    //   515: iload_3
    //   516: istore 7
    //   518: iload_3
    //   519: istore 5
    //   521: iload_3
    //   522: istore 8
    //   524: aload_0
    //   525: aload 10
    //   527: invokevirtual 174	a/j/b/a/c/e/a$m$a:eiF	()La/j/b/a/c/e/a$m;
    //   530: putfield 161	a/j/b/a/c/e/a$i:ClI	La/j/b/a/c/e/a$m;
    //   533: iload_3
    //   534: istore 7
    //   536: iload_3
    //   537: istore 5
    //   539: iload_3
    //   540: istore 8
    //   542: aload_0
    //   543: aload_0
    //   544: getfield 135	a/j/b/a/c/e/a$i:Ckr	I
    //   547: iconst_2
    //   548: ior
    //   549: putfield 135	a/j/b/a/c/e/a$i:Ckr	I
    //   552: goto -511 -> 41
    //   555: iload_3
    //   556: istore 7
    //   558: iload_3
    //   559: istore 5
    //   561: iload_3
    //   562: istore 8
    //   564: aload_1
    //   565: invokevirtual 102	a/j/b/a/c/g/e:sl	()I
    //   568: istore 9
    //   570: iload_3
    //   571: istore 7
    //   573: iload_3
    //   574: istore 5
    //   576: iload_3
    //   577: istore 8
    //   579: iload 9
    //   581: invokestatic 178	a/j/b/a/c/e/a$i$c:Um	(I)La/j/b/a/c/e/a$i$c;
    //   584: astore 10
    //   586: aload 10
    //   588: ifnonnull +38 -> 626
    //   591: iload_3
    //   592: istore 7
    //   594: iload_3
    //   595: istore 5
    //   597: iload_3
    //   598: istore 8
    //   600: aload 12
    //   602: iload 4
    //   604: invokevirtual 109	a/j/b/a/c/g/f:eX	(I)V
    //   607: iload_3
    //   608: istore 7
    //   610: iload_3
    //   611: istore 5
    //   613: iload_3
    //   614: istore 8
    //   616: aload 12
    //   618: iload 9
    //   620: invokevirtual 109	a/j/b/a/c/g/f:eX	(I)V
    //   623: goto -582 -> 41
    //   626: iload_3
    //   627: istore 7
    //   629: iload_3
    //   630: istore 5
    //   632: iload_3
    //   633: istore 8
    //   635: aload_0
    //   636: aload_0
    //   637: getfield 135	a/j/b/a/c/e/a$i:Ckr	I
    //   640: iconst_4
    //   641: ior
    //   642: putfield 135	a/j/b/a/c/e/a$i:Ckr	I
    //   645: iload_3
    //   646: istore 7
    //   648: iload_3
    //   649: istore 5
    //   651: iload_3
    //   652: istore 8
    //   654: aload_0
    //   655: aload 10
    //   657: putfield 180	a/j/b/a/c/e/a$i:ClJ	La/j/b/a/c/e/a$i$c;
    //   660: goto -619 -> 41
    //   663: iload_3
    //   664: iconst_2
    //   665: iand
    //   666: iconst_2
    //   667: if_icmpne +14 -> 681
    //   670: aload_0
    //   671: aload_0
    //   672: getfield 115	a/j/b/a/c/e/a$i:ClH	Ljava/util/List;
    //   675: invokestatic 121	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   678: putfield 115	a/j/b/a/c/e/a$i:ClH	Ljava/util/List;
    //   681: aload 12
    //   683: invokevirtual 124	a/j/b/a/c/g/f:flush	()V
    //   686: aload_0
    //   687: aload 11
    //   689: invokevirtual 130	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   692: putfield 73	a/j/b/a/c/e/a$i:Ckp	La/j/b/a/c/g/d;
    //   695: aload_0
    //   696: invokevirtual 133	a/j/b/a/c/e/a$i:emL	()V
    //   699: ldc 79
    //   701: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   704: return
    //   705: astore_1
    //   706: aload_0
    //   707: aload 11
    //   709: invokevirtual 130	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   712: putfield 73	a/j/b/a/c/e/a$i:Ckp	La/j/b/a/c/g/d;
    //   715: goto -20 -> 695
    //   718: astore_1
    //   719: aload_0
    //   720: aload 11
    //   722: invokevirtual 130	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   725: putfield 73	a/j/b/a/c/e/a$i:Ckp	La/j/b/a/c/g/d;
    //   728: ldc 79
    //   730: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   733: aload_1
    //   734: athrow
    //   735: astore_2
    //   736: aload_0
    //   737: aload 11
    //   739: invokevirtual 130	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   742: putfield 73	a/j/b/a/c/e/a$i:Ckp	La/j/b/a/c/g/d;
    //   745: goto -475 -> 270
    //   748: astore_1
    //   749: aload_0
    //   750: aload 11
    //   752: invokevirtual 130	a/j/b/a/c/g/d$b:emt	()La/j/b/a/c/g/d;
    //   755: putfield 73	a/j/b/a/c/e/a$i:Ckp	La/j/b/a/c/g/d;
    //   758: ldc 79
    //   760: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   763: aload_1
    //   764: athrow
    //   765: aconst_null
    //   766: astore 10
    //   768: goto -301 -> 467
    //   771: goto -659 -> 112
    //   774: iconst_1
    //   775: istore 6
    //   777: goto -736 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	780	0	this	i
    //   0	780	1	parame	a.j.b.a.c.g.e
    //   0	780	2	paramg	a.j.b.a.c.g.g
    //   40	626	3	i	int
    //   59	544	4	j	int
    //   50	600	5	k	int
    //   37	739	6	m	int
    //   47	600	7	n	int
    //   53	600	8	i1	int
    //   153	466	9	i2	int
    //   169	598	10	localObject	java.lang.Object
    //   26	725	11	localb	a.j.b.a.c.g.d.b
    //   34	648	12	localf	f
    // Exception table:
    //   from	to	target	type
    //   55	61	211	a/j/b/a/c/g/k
    //   121	134	211	a/j/b/a/c/g/k
    //   149	155	211	a/j/b/a/c/g/k
    //   164	171	211	a/j/b/a/c/g/k
    //   185	192	211	a/j/b/a/c/g/k
    //   201	208	211	a/j/b/a/c/g/k
    //   290	300	211	a/j/b/a/c/g/k
    //   309	315	211	a/j/b/a/c/g/k
    //   378	389	211	a/j/b/a/c/g/k
    //   406	424	211	a/j/b/a/c/g/k
    //   439	449	211	a/j/b/a/c/g/k
    //   458	467	211	a/j/b/a/c/g/k
    //   476	491	211	a/j/b/a/c/g/k
    //   505	515	211	a/j/b/a/c/g/k
    //   524	533	211	a/j/b/a/c/g/k
    //   542	552	211	a/j/b/a/c/g/k
    //   564	570	211	a/j/b/a/c/g/k
    //   579	586	211	a/j/b/a/c/g/k
    //   600	607	211	a/j/b/a/c/g/k
    //   616	623	211	a/j/b/a/c/g/k
    //   635	645	211	a/j/b/a/c/g/k
    //   654	660	211	a/j/b/a/c/g/k
    //   55	61	236	finally
    //   121	134	236	finally
    //   149	155	236	finally
    //   164	171	236	finally
    //   185	192	236	finally
    //   201	208	236	finally
    //   216	221	236	finally
    //   225	230	236	finally
    //   234	236	236	finally
    //   290	300	236	finally
    //   309	315	236	finally
    //   323	335	236	finally
    //   339	344	236	finally
    //   348	353	236	finally
    //   357	359	236	finally
    //   378	389	236	finally
    //   406	424	236	finally
    //   439	449	236	finally
    //   458	467	236	finally
    //   476	491	236	finally
    //   505	515	236	finally
    //   524	533	236	finally
    //   542	552	236	finally
    //   564	570	236	finally
    //   579	586	236	finally
    //   600	607	236	finally
    //   616	623	236	finally
    //   635	645	236	finally
    //   654	660	236	finally
    //   55	61	318	java/io/IOException
    //   121	134	318	java/io/IOException
    //   149	155	318	java/io/IOException
    //   164	171	318	java/io/IOException
    //   185	192	318	java/io/IOException
    //   201	208	318	java/io/IOException
    //   290	300	318	java/io/IOException
    //   309	315	318	java/io/IOException
    //   378	389	318	java/io/IOException
    //   406	424	318	java/io/IOException
    //   439	449	318	java/io/IOException
    //   458	467	318	java/io/IOException
    //   476	491	318	java/io/IOException
    //   505	515	318	java/io/IOException
    //   524	533	318	java/io/IOException
    //   542	552	318	java/io/IOException
    //   564	570	318	java/io/IOException
    //   579	586	318	java/io/IOException
    //   600	607	318	java/io/IOException
    //   616	623	318	java/io/IOException
    //   635	645	318	java/io/IOException
    //   654	660	318	java/io/IOException
    //   681	686	705	java/io/IOException
    //   681	686	718	finally
    //   256	261	735	java/io/IOException
    //   256	261	748	finally
  }
  
  private a$i(i.a parama)
  {
    super((byte)0);
    this.Ckp = parama.Ckp;
  }
  
  private void egZ()
  {
    AppMethodBeat.i(120570);
    this.ClG = a.i.b.ClK;
    this.ClH = Collections.emptyList();
    this.ClI = a.m.eiz();
    this.ClJ = a.i.c.ClO;
    AppMethodBeat.o(120570);
  }
  
  public static i eim()
  {
    return ClF;
  }
  
  public final void a(f paramf)
  {
    AppMethodBeat.i(120572);
    sy();
    if ((this.Ckr & 0x1) == 1) {
      paramf.iG(1, this.ClG.value);
    }
    int i = 0;
    while (i < this.ClH.size())
    {
      paramf.a(2, (q)this.ClH.get(i));
      i += 1;
    }
    if ((this.Ckr & 0x2) == 2) {
      paramf.a(3, this.ClI);
    }
    if ((this.Ckr & 0x4) == 4) {
      paramf.iG(4, this.ClJ.value);
    }
    paramf.d(this.Ckp);
    AppMethodBeat.o(120572);
  }
  
  public final s<i> egX()
  {
    return Ckq;
  }
  
  public final boolean ein()
  {
    return (this.Ckr & 0x1) == 1;
  }
  
  public final boolean eio()
  {
    return (this.Ckr & 0x2) == 2;
  }
  
  public final boolean eip()
  {
    return (this.Ckr & 0x4) == 4;
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(120571);
    int i = this.Cku;
    if (i == 1)
    {
      AppMethodBeat.o(120571);
      return true;
    }
    if (i == 0)
    {
      AppMethodBeat.o(120571);
      return false;
    }
    i = 0;
    while (i < this.ClH.size())
    {
      if (!((a.m)this.ClH.get(i)).isInitialized())
      {
        this.Cku = 0;
        AppMethodBeat.o(120571);
        return false;
      }
      i += 1;
    }
    if ((eio()) && (!this.ClI.isInitialized()))
    {
      this.Cku = 0;
      AppMethodBeat.o(120571);
      return false;
    }
    this.Cku = 1;
    AppMethodBeat.o(120571);
    return true;
  }
  
  public final int sy()
  {
    int j = 0;
    AppMethodBeat.i(120573);
    int i = this.Ckv;
    if (i != -1)
    {
      AppMethodBeat.o(120573);
      return i;
    }
    if ((this.Ckr & 0x1) == 1) {
      i = f.iH(1, this.ClG.value) + 0;
    }
    for (;;)
    {
      if (j < this.ClH.size())
      {
        int k = f.c(2, (q)this.ClH.get(j));
        j += 1;
        i = k + i;
      }
      else
      {
        j = i;
        if ((this.Ckr & 0x2) == 2) {
          j = i + f.c(3, this.ClI);
        }
        i = j;
        if ((this.Ckr & 0x4) == 4) {
          i = j + f.iH(4, this.ClJ.value);
        }
        i = this.Ckp.size() + i;
        this.Ckv = i;
        AppMethodBeat.o(120573);
        return i;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.c.e.a.i
 * JD-Core Version:    0.7.0.1
 */