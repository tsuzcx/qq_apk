package com.google.android.exoplayer2.source.b;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.h.g;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.u;
import com.google.android.exoplayer2.metadata.id3.a;
import com.google.android.exoplayer2.source.a.d;
import com.google.android.exoplayer2.source.b.a.a.a;
import com.google.android.exoplayer2.source.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

final class f
  extends d
{
  private static final AtomicInteger aRq;
  private final u aGN;
  private final boolean aIa;
  private volatile boolean aPM;
  private e aPQ;
  private final boolean aRA;
  private final a aRB;
  private final m aRC;
  private int aRD;
  private int aRE;
  private boolean aRF;
  private j aRG;
  volatile boolean aRH;
  private final List<Format> aRa;
  public final int aRr;
  public final a.a aRs;
  private final g aRt;
  private final com.google.android.exoplayer2.h.j aRu;
  private final boolean aRv;
  private final String aRw;
  private final e aRx;
  private final boolean aRy;
  private final boolean aRz;
  public final int uid;
  
  static
  {
    AppMethodBeat.i(125909);
    aRq = new AtomicInteger();
    AppMethodBeat.o(125909);
  }
  
  public f(g paramg, com.google.android.exoplayer2.h.j paramj1, com.google.android.exoplayer2.h.j paramj2, a.a parama, List<Format> paramList, int paramInt1, Object paramObject, long paramLong1, long paramLong2, int paramInt2, int paramInt3, boolean paramBoolean, u paramu, f paramf, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2) {}
  
  public final void a(j paramj)
  {
    int j = 0;
    this.aRG = paramj;
    int k = this.uid;
    boolean bool = this.aRy;
    paramj.aSa = k;
    k[] arrayOfk = paramj.aPv;
    int m = arrayOfk.length;
    int i = 0;
    while (i < m)
    {
      arrayOfk[i].aQn.aQl = k;
      i += 1;
    }
    if (bool)
    {
      paramj = paramj.aPv;
      k = paramj.length;
      i = j;
      while (i < k)
      {
        paramj[i].aQw = true;
        i += 1;
      }
    }
  }
  
  public final void pf()
  {
    this.aPM = true;
  }
  
  public final boolean pg()
  {
    return this.aPM;
  }
  
  /* Error */
  public final void ph()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: iconst_0
    //   4: istore 4
    //   6: ldc 188
    //   8: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: aload_0
    //   12: getfield 128	com/google/android/exoplayer2/source/b/f:aPQ	Lcom/google/android/exoplayer2/c/e;
    //   15: ifnonnull +95 -> 110
    //   18: aload_0
    //   19: getfield 122	com/google/android/exoplayer2/source/b/f:aRA	Z
    //   22: ifne +88 -> 110
    //   25: ldc 190
    //   27: aload_0
    //   28: getfield 79	com/google/android/exoplayer2/source/b/f:aRs	Lcom/google/android/exoplayer2/source/b/a/a$a;
    //   31: getfield 69	com/google/android/exoplayer2/source/b/a/a$a:axd	Lcom/google/android/exoplayer2/Format;
    //   34: getfield 195	com/google/android/exoplayer2/Format:awK	Ljava/lang/String;
    //   37: invokevirtual 199	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   40: ifne +27 -> 67
    //   43: aload_0
    //   44: getfield 106	com/google/android/exoplayer2/source/b/f:aRw	Ljava/lang/String;
    //   47: ldc 201
    //   49: invokevirtual 114	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   52: ifne +15 -> 67
    //   55: aload_0
    //   56: getfield 106	com/google/android/exoplayer2/source/b/f:aRw	Ljava/lang/String;
    //   59: ldc 203
    //   61: invokevirtual 114	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   64: ifeq +505 -> 569
    //   67: new 205	com/google/android/exoplayer2/source/b/l
    //   70: dup
    //   71: aload_0
    //   72: getfield 208	com/google/android/exoplayer2/source/b/f:aQJ	Lcom/google/android/exoplayer2/Format;
    //   75: getfield 211	com/google/android/exoplayer2/Format:axa	Ljava/lang/String;
    //   78: aload_0
    //   79: getfield 85	com/google/android/exoplayer2/source/b/f:aGN	Lcom/google/android/exoplayer2/i/u;
    //   82: invokespecial 214	com/google/android/exoplayer2/source/b/l:<init>	(Ljava/lang/String;Lcom/google/android/exoplayer2/i/u;)V
    //   85: astore 7
    //   87: iconst_1
    //   88: istore_1
    //   89: iload_1
    //   90: ifeq +14 -> 104
    //   93: aload 7
    //   95: aload_0
    //   96: getfield 158	com/google/android/exoplayer2/source/b/f:aRG	Lcom/google/android/exoplayer2/source/b/j;
    //   99: invokeinterface 219 2 0
    //   104: aload_0
    //   105: aload 7
    //   107: putfield 128	com/google/android/exoplayer2/source/b/f:aPQ	Lcom/google/android/exoplayer2/c/e;
    //   110: aload_0
    //   111: getfield 130	com/google/android/exoplayer2/source/b/f:aRx	Lcom/google/android/exoplayer2/c/e;
    //   114: aload_0
    //   115: getfield 128	com/google/android/exoplayer2/source/b/f:aPQ	Lcom/google/android/exoplayer2/c/e;
    //   118: if_acmpeq +17 -> 135
    //   121: aload_0
    //   122: getfield 221	com/google/android/exoplayer2/source/b/f:aRF	Z
    //   125: ifne +10 -> 135
    //   128: aload_0
    //   129: getfield 77	com/google/android/exoplayer2/source/b/f:aRu	Lcom/google/android/exoplayer2/h/j;
    //   132: ifnonnull +740 -> 872
    //   135: aload_0
    //   136: getfield 184	com/google/android/exoplayer2/source/b/f:aPM	Z
    //   139: ifne +1114 -> 1253
    //   142: aload_0
    //   143: getfield 92	com/google/android/exoplayer2/source/b/f:aIa	Z
    //   146: ifeq +885 -> 1031
    //   149: aload_0
    //   150: getfield 224	com/google/android/exoplayer2/source/b/f:aQI	Lcom/google/android/exoplayer2/h/j;
    //   153: astore 7
    //   155: aload_0
    //   156: getfield 226	com/google/android/exoplayer2/source/b/f:aRE	I
    //   159: ifeq +867 -> 1026
    //   162: iconst_1
    //   163: istore_1
    //   164: aload_0
    //   165: getfield 83	com/google/android/exoplayer2/source/b/f:aRv	Z
    //   168: ifne +882 -> 1050
    //   171: aload_0
    //   172: getfield 85	com/google/android/exoplayer2/source/b/f:aGN	Lcom/google/android/exoplayer2/i/u;
    //   175: invokevirtual 231	com/google/android/exoplayer2/i/u:rc	()V
    //   178: new 233	com/google/android/exoplayer2/c/b
    //   181: dup
    //   182: aload_0
    //   183: getfield 88	com/google/android/exoplayer2/source/b/f:aBo	Lcom/google/android/exoplayer2/h/g;
    //   186: aload 7
    //   188: getfield 237	com/google/android/exoplayer2/h/j:aYy	J
    //   191: aload_0
    //   192: getfield 88	com/google/android/exoplayer2/source/b/f:aBo	Lcom/google/android/exoplayer2/h/g;
    //   195: aload 7
    //   197: invokeinterface 242 2 0
    //   202: invokespecial 245	com/google/android/exoplayer2/c/b:<init>	(Lcom/google/android/exoplayer2/h/g;JJ)V
    //   205: astore 8
    //   207: aload_0
    //   208: getfield 128	com/google/android/exoplayer2/source/b/f:aPQ	Lcom/google/android/exoplayer2/c/e;
    //   211: ifnonnull +310 -> 521
    //   214: aload 8
    //   216: invokeinterface 250 1 0
    //   221: aload 8
    //   223: aload_0
    //   224: getfield 126	com/google/android/exoplayer2/source/b/f:aRC	Lcom/google/android/exoplayer2/i/m;
    //   227: getfield 254	com/google/android/exoplayer2/i/m:data	[B
    //   230: iconst_0
    //   231: bipush 10
    //   233: iconst_1
    //   234: invokeinterface 258 5 0
    //   239: ifeq +846 -> 1085
    //   242: aload_0
    //   243: getfield 126	com/google/android/exoplayer2/source/b/f:aRC	Lcom/google/android/exoplayer2/i/m;
    //   246: bipush 10
    //   248: invokevirtual 261	com/google/android/exoplayer2/i/m:reset	(I)V
    //   251: aload_0
    //   252: getfield 126	com/google/android/exoplayer2/source/b/f:aRC	Lcom/google/android/exoplayer2/i/m;
    //   255: invokevirtual 264	com/google/android/exoplayer2/i/m:qO	()I
    //   258: getstatic 267	com/google/android/exoplayer2/metadata/id3/a:aJO	I
    //   261: if_icmpne +824 -> 1085
    //   264: aload_0
    //   265: getfield 126	com/google/android/exoplayer2/source/b/f:aRC	Lcom/google/android/exoplayer2/i/m;
    //   268: iconst_3
    //   269: invokevirtual 270	com/google/android/exoplayer2/i/m:en	(I)V
    //   272: aload_0
    //   273: getfield 126	com/google/android/exoplayer2/source/b/f:aRC	Lcom/google/android/exoplayer2/i/m;
    //   276: invokevirtual 273	com/google/android/exoplayer2/i/m:qS	()I
    //   279: istore_2
    //   280: iload_2
    //   281: bipush 10
    //   283: iadd
    //   284: istore_3
    //   285: iload_3
    //   286: aload_0
    //   287: getfield 126	com/google/android/exoplayer2/source/b/f:aRC	Lcom/google/android/exoplayer2/i/m;
    //   290: invokevirtual 276	com/google/android/exoplayer2/i/m:capacity	()I
    //   293: if_icmple +36 -> 329
    //   296: aload_0
    //   297: getfield 126	com/google/android/exoplayer2/source/b/f:aRC	Lcom/google/android/exoplayer2/i/m;
    //   300: getfield 254	com/google/android/exoplayer2/i/m:data	[B
    //   303: astore 7
    //   305: aload_0
    //   306: getfield 126	com/google/android/exoplayer2/source/b/f:aRC	Lcom/google/android/exoplayer2/i/m;
    //   309: iload_3
    //   310: invokevirtual 261	com/google/android/exoplayer2/i/m:reset	(I)V
    //   313: aload 7
    //   315: iconst_0
    //   316: aload_0
    //   317: getfield 126	com/google/android/exoplayer2/source/b/f:aRC	Lcom/google/android/exoplayer2/i/m;
    //   320: getfield 254	com/google/android/exoplayer2/i/m:data	[B
    //   323: iconst_0
    //   324: bipush 10
    //   326: invokestatic 282	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   329: aload 8
    //   331: aload_0
    //   332: getfield 126	com/google/android/exoplayer2/source/b/f:aRC	Lcom/google/android/exoplayer2/i/m;
    //   335: getfield 254	com/google/android/exoplayer2/i/m:data	[B
    //   338: bipush 10
    //   340: iload_2
    //   341: iconst_1
    //   342: invokeinterface 258 5 0
    //   347: ifeq +738 -> 1085
    //   350: aload_0
    //   351: getfield 124	com/google/android/exoplayer2/source/b/f:aRB	Lcom/google/android/exoplayer2/metadata/id3/a;
    //   354: aload_0
    //   355: getfield 126	com/google/android/exoplayer2/source/b/f:aRC	Lcom/google/android/exoplayer2/i/m;
    //   358: getfield 254	com/google/android/exoplayer2/i/m:data	[B
    //   361: iload_2
    //   362: invokevirtual 285	com/google/android/exoplayer2/metadata/id3/a:b	([BI)Lcom/google/android/exoplayer2/metadata/Metadata;
    //   365: astore 7
    //   367: aload 7
    //   369: ifnull +716 -> 1085
    //   372: aload 7
    //   374: getfield 291	com/google/android/exoplayer2/metadata/Metadata:aND	[Lcom/google/android/exoplayer2/metadata/Metadata$Entry;
    //   377: arraylength
    //   378: istore_3
    //   379: iconst_0
    //   380: istore_2
    //   381: iload_2
    //   382: iload_3
    //   383: if_icmpge +702 -> 1085
    //   386: aload 7
    //   388: getfield 291	com/google/android/exoplayer2/metadata/Metadata:aND	[Lcom/google/android/exoplayer2/metadata/Metadata$Entry;
    //   391: iload_2
    //   392: aaload
    //   393: astore 9
    //   395: aload 9
    //   397: instanceof 293
    //   400: ifeq +678 -> 1078
    //   403: aload 9
    //   405: checkcast 293	com/google/android/exoplayer2/metadata/id3/PrivFrame
    //   408: astore 9
    //   410: ldc_w 295
    //   413: aload 9
    //   415: getfield 298	com/google/android/exoplayer2/metadata/id3/PrivFrame:aOg	Ljava/lang/String;
    //   418: invokevirtual 199	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   421: ifeq +657 -> 1078
    //   424: aload 9
    //   426: getfield 301	com/google/android/exoplayer2/metadata/id3/PrivFrame:aOh	[B
    //   429: iconst_0
    //   430: aload_0
    //   431: getfield 126	com/google/android/exoplayer2/source/b/f:aRC	Lcom/google/android/exoplayer2/i/m;
    //   434: getfield 254	com/google/android/exoplayer2/i/m:data	[B
    //   437: iconst_0
    //   438: bipush 8
    //   440: invokestatic 282	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   443: aload_0
    //   444: getfield 126	com/google/android/exoplayer2/source/b/f:aRC	Lcom/google/android/exoplayer2/i/m;
    //   447: bipush 8
    //   449: invokevirtual 261	com/google/android/exoplayer2/i/m:reset	(I)V
    //   452: aload_0
    //   453: getfield 126	com/google/android/exoplayer2/source/b/f:aRC	Lcom/google/android/exoplayer2/i/m;
    //   456: invokevirtual 305	com/google/android/exoplayer2/i/m:readLong	()J
    //   459: lstore 5
    //   461: lload 5
    //   463: ldc2_w 306
    //   466: lcmp
    //   467: ifeq +626 -> 1093
    //   470: aload_0
    //   471: getfield 85	com/google/android/exoplayer2/source/b/f:aGN	Lcom/google/android/exoplayer2/i/u;
    //   474: lload 5
    //   476: invokevirtual 311	com/google/android/exoplayer2/i/u:ah	(J)J
    //   479: lstore 5
    //   481: aload_0
    //   482: getfield 106	com/google/android/exoplayer2/source/b/f:aRw	Ljava/lang/String;
    //   485: ldc 108
    //   487: invokevirtual 114	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   490: ifeq +612 -> 1102
    //   493: new 313	com/google/android/exoplayer2/c/f/c
    //   496: dup
    //   497: lload 5
    //   499: invokespecial 316	com/google/android/exoplayer2/c/f/c:<init>	(J)V
    //   502: astore 7
    //   504: aload 7
    //   506: aload_0
    //   507: getfield 158	com/google/android/exoplayer2/source/b/f:aRG	Lcom/google/android/exoplayer2/source/b/j;
    //   510: invokeinterface 219 2 0
    //   515: aload_0
    //   516: aload 7
    //   518: putfield 128	com/google/android/exoplayer2/source/b/f:aPQ	Lcom/google/android/exoplayer2/c/e;
    //   521: iload 4
    //   523: istore_2
    //   524: iload_1
    //   525: ifeq +17 -> 542
    //   528: aload 8
    //   530: aload_0
    //   531: getfield 226	com/google/android/exoplayer2/source/b/f:aRE	I
    //   534: invokeinterface 319 2 0
    //   539: iload 4
    //   541: istore_2
    //   542: iload_2
    //   543: ifne +678 -> 1221
    //   546: aload_0
    //   547: getfield 184	com/google/android/exoplayer2/source/b/f:aPM	Z
    //   550: ifne +671 -> 1221
    //   553: aload_0
    //   554: getfield 128	com/google/android/exoplayer2/source/b/f:aPQ	Lcom/google/android/exoplayer2/c/e;
    //   557: aload 8
    //   559: aconst_null
    //   560: invokeinterface 322 3 0
    //   565: istore_2
    //   566: goto -24 -> 542
    //   569: aload_0
    //   570: getfield 134	com/google/android/exoplayer2/source/b/f:aRz	Z
    //   573: ifne +14 -> 587
    //   576: aload_0
    //   577: getfield 130	com/google/android/exoplayer2/source/b/f:aRx	Lcom/google/android/exoplayer2/c/e;
    //   580: astore 7
    //   582: iconst_0
    //   583: istore_1
    //   584: goto -495 -> 89
    //   587: aload_0
    //   588: getfield 106	com/google/android/exoplayer2/source/b/f:aRw	Ljava/lang/String;
    //   591: ldc_w 324
    //   594: invokevirtual 114	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   597: ifne +25 -> 622
    //   600: aload_0
    //   601: getfield 106	com/google/android/exoplayer2/source/b/f:aRw	Ljava/lang/String;
    //   604: ldc_w 326
    //   607: aload_0
    //   608: getfield 106	com/google/android/exoplayer2/source/b/f:aRw	Ljava/lang/String;
    //   611: invokevirtual 329	java/lang/String:length	()I
    //   614: iconst_4
    //   615: isub
    //   616: invokevirtual 333	java/lang/String:startsWith	(Ljava/lang/String;I)Z
    //   619: ifeq +22 -> 641
    //   622: new 335	com/google/android/exoplayer2/c/d/e
    //   625: dup
    //   626: iconst_0
    //   627: aload_0
    //   628: getfield 85	com/google/android/exoplayer2/source/b/f:aGN	Lcom/google/android/exoplayer2/i/u;
    //   631: invokespecial 338	com/google/android/exoplayer2/c/d/e:<init>	(ILcom/google/android/exoplayer2/i/u;)V
    //   634: astore 7
    //   636: iconst_1
    //   637: istore_1
    //   638: goto -549 -> 89
    //   641: bipush 16
    //   643: istore_1
    //   644: aload_0
    //   645: getfield 81	com/google/android/exoplayer2/source/b/f:aRa	Ljava/util/List;
    //   648: astore 7
    //   650: aload 7
    //   652: ifnull +192 -> 844
    //   655: bipush 48
    //   657: istore_1
    //   658: aload_0
    //   659: getfield 208	com/google/android/exoplayer2/source/b/f:aQJ	Lcom/google/android/exoplayer2/Format;
    //   662: getfield 341	com/google/android/exoplayer2/Format:awH	Ljava/lang/String;
    //   665: astore 10
    //   667: iload_1
    //   668: istore_3
    //   669: aload 10
    //   671: invokestatic 347	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   674: ifne +141 -> 815
    //   677: aload 10
    //   679: ifnull +180 -> 859
    //   682: aload 10
    //   684: ldc_w 349
    //   687: invokevirtual 353	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   690: astore 11
    //   692: aload 11
    //   694: arraylength
    //   695: istore_3
    //   696: iconst_0
    //   697: istore_2
    //   698: iload_2
    //   699: iload_3
    //   700: if_icmpge +159 -> 859
    //   703: aload 11
    //   705: iload_2
    //   706: aaload
    //   707: invokestatic 359	com/google/android/exoplayer2/i/j:aJ	(Ljava/lang/String;)Ljava/lang/String;
    //   710: astore 8
    //   712: aload 8
    //   714: ifnull +138 -> 852
    //   717: aload 8
    //   719: invokestatic 362	com/google/android/exoplayer2/i/j:aG	(Ljava/lang/String;)Z
    //   722: ifeq +130 -> 852
    //   725: iload_1
    //   726: istore_2
    //   727: ldc_w 364
    //   730: aload 8
    //   732: invokevirtual 199	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   735: ifne +7 -> 742
    //   738: iload_1
    //   739: iconst_2
    //   740: ior
    //   741: istore_2
    //   742: aload 9
    //   744: astore 8
    //   746: aload 10
    //   748: ifnull +50 -> 798
    //   751: aload 10
    //   753: ldc_w 349
    //   756: invokevirtual 353	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   759: astore 10
    //   761: aload 10
    //   763: arraylength
    //   764: istore_3
    //   765: iconst_0
    //   766: istore_1
    //   767: aload 9
    //   769: astore 8
    //   771: iload_1
    //   772: iload_3
    //   773: if_icmpge +25 -> 798
    //   776: aload 10
    //   778: iload_1
    //   779: aaload
    //   780: invokestatic 359	com/google/android/exoplayer2/i/j:aJ	(Ljava/lang/String;)Ljava/lang/String;
    //   783: astore 8
    //   785: aload 8
    //   787: ifnull +78 -> 865
    //   790: aload 8
    //   792: invokestatic 367	com/google/android/exoplayer2/i/j:aH	(Ljava/lang/String;)Z
    //   795: ifeq +70 -> 865
    //   798: iload_2
    //   799: istore_3
    //   800: ldc_w 369
    //   803: aload 8
    //   805: invokevirtual 199	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   808: ifne +7 -> 815
    //   811: iload_2
    //   812: iconst_4
    //   813: ior
    //   814: istore_3
    //   815: new 371	com/google/android/exoplayer2/c/f/u
    //   818: dup
    //   819: iconst_2
    //   820: aload_0
    //   821: getfield 85	com/google/android/exoplayer2/source/b/f:aGN	Lcom/google/android/exoplayer2/i/u;
    //   824: new 373	com/google/android/exoplayer2/c/f/e
    //   827: dup
    //   828: iload_3
    //   829: aload 7
    //   831: invokespecial 376	com/google/android/exoplayer2/c/f/e:<init>	(ILjava/util/List;)V
    //   834: invokespecial 379	com/google/android/exoplayer2/c/f/u:<init>	(ILcom/google/android/exoplayer2/i/u;Lcom/google/android/exoplayer2/c/f/v$c;)V
    //   837: astore 7
    //   839: iconst_1
    //   840: istore_1
    //   841: goto -752 -> 89
    //   844: invokestatic 385	java/util/Collections:emptyList	()Ljava/util/List;
    //   847: astore 7
    //   849: goto -191 -> 658
    //   852: iload_2
    //   853: iconst_1
    //   854: iadd
    //   855: istore_2
    //   856: goto -158 -> 698
    //   859: aconst_null
    //   860: astore 8
    //   862: goto -137 -> 725
    //   865: iload_1
    //   866: iconst_1
    //   867: iadd
    //   868: istore_1
    //   869: goto -102 -> 767
    //   872: aload_0
    //   873: getfield 77	com/google/android/exoplayer2/source/b/f:aRu	Lcom/google/android/exoplayer2/h/j;
    //   876: aload_0
    //   877: getfield 387	com/google/android/exoplayer2/source/b/f:aRD	I
    //   880: i2l
    //   881: invokevirtual 391	com/google/android/exoplayer2/h/j:ae	(J)Lcom/google/android/exoplayer2/h/j;
    //   884: astore 7
    //   886: new 233	com/google/android/exoplayer2/c/b
    //   889: dup
    //   890: aload_0
    //   891: getfield 136	com/google/android/exoplayer2/source/b/f:aRt	Lcom/google/android/exoplayer2/h/g;
    //   894: aload 7
    //   896: getfield 237	com/google/android/exoplayer2/h/j:aYy	J
    //   899: aload_0
    //   900: getfield 136	com/google/android/exoplayer2/source/b/f:aRt	Lcom/google/android/exoplayer2/h/g;
    //   903: aload 7
    //   905: invokeinterface 242 2 0
    //   910: invokespecial 245	com/google/android/exoplayer2/c/b:<init>	(Lcom/google/android/exoplayer2/h/g;JJ)V
    //   913: astore 7
    //   915: iconst_0
    //   916: istore_1
    //   917: iload_1
    //   918: ifne +26 -> 944
    //   921: aload_0
    //   922: getfield 184	com/google/android/exoplayer2/source/b/f:aPM	Z
    //   925: ifne +19 -> 944
    //   928: aload_0
    //   929: getfield 128	com/google/android/exoplayer2/source/b/f:aPQ	Lcom/google/android/exoplayer2/c/e;
    //   932: aload 7
    //   934: aconst_null
    //   935: invokeinterface 322 3 0
    //   940: istore_1
    //   941: goto -24 -> 917
    //   944: aload_0
    //   945: aload 7
    //   947: invokeinterface 394 1 0
    //   952: aload_0
    //   953: getfield 77	com/google/android/exoplayer2/source/b/f:aRu	Lcom/google/android/exoplayer2/h/j;
    //   956: getfield 237	com/google/android/exoplayer2/h/j:aYy	J
    //   959: lsub
    //   960: l2i
    //   961: putfield 387	com/google/android/exoplayer2/source/b/f:aRD	I
    //   964: aload_0
    //   965: getfield 88	com/google/android/exoplayer2/source/b/f:aBo	Lcom/google/android/exoplayer2/h/g;
    //   968: invokestatic 399	com/google/android/exoplayer2/i/x:a	(Lcom/google/android/exoplayer2/h/g;)V
    //   971: aload_0
    //   972: iconst_1
    //   973: putfield 221	com/google/android/exoplayer2/source/b/f:aRF	Z
    //   976: goto -841 -> 135
    //   979: astore 8
    //   981: aload_0
    //   982: aload 7
    //   984: invokeinterface 394 1 0
    //   989: aload_0
    //   990: getfield 77	com/google/android/exoplayer2/source/b/f:aRu	Lcom/google/android/exoplayer2/h/j;
    //   993: getfield 237	com/google/android/exoplayer2/h/j:aYy	J
    //   996: lsub
    //   997: l2i
    //   998: putfield 387	com/google/android/exoplayer2/source/b/f:aRD	I
    //   1001: ldc 188
    //   1003: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1006: aload 8
    //   1008: athrow
    //   1009: astore 7
    //   1011: aload_0
    //   1012: getfield 88	com/google/android/exoplayer2/source/b/f:aBo	Lcom/google/android/exoplayer2/h/g;
    //   1015: invokestatic 399	com/google/android/exoplayer2/i/x:a	(Lcom/google/android/exoplayer2/h/g;)V
    //   1018: ldc 188
    //   1020: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1023: aload 7
    //   1025: athrow
    //   1026: iconst_0
    //   1027: istore_1
    //   1028: goto -864 -> 164
    //   1031: aload_0
    //   1032: getfield 224	com/google/android/exoplayer2/source/b/f:aQI	Lcom/google/android/exoplayer2/h/j;
    //   1035: aload_0
    //   1036: getfield 226	com/google/android/exoplayer2/source/b/f:aRE	I
    //   1039: i2l
    //   1040: invokevirtual 391	com/google/android/exoplayer2/h/j:ae	(J)Lcom/google/android/exoplayer2/h/j;
    //   1043: astore 7
    //   1045: iconst_0
    //   1046: istore_1
    //   1047: goto -883 -> 164
    //   1050: aload_0
    //   1051: getfield 85	com/google/android/exoplayer2/source/b/f:aGN	Lcom/google/android/exoplayer2/i/u;
    //   1054: getfield 402	com/google/android/exoplayer2/i/u:aJP	J
    //   1057: ldc2_w 403
    //   1060: lcmp
    //   1061: ifne -883 -> 178
    //   1064: aload_0
    //   1065: getfield 85	com/google/android/exoplayer2/source/b/f:aGN	Lcom/google/android/exoplayer2/i/u;
    //   1068: aload_0
    //   1069: getfield 407	com/google/android/exoplayer2/source/b/f:aQM	J
    //   1072: invokevirtual 410	com/google/android/exoplayer2/i/u:ag	(J)V
    //   1075: goto -897 -> 178
    //   1078: iload_2
    //   1079: iconst_1
    //   1080: iadd
    //   1081: istore_2
    //   1082: goto -701 -> 381
    //   1085: ldc2_w 306
    //   1088: lstore 5
    //   1090: goto -629 -> 461
    //   1093: aload_0
    //   1094: getfield 407	com/google/android/exoplayer2/source/b/f:aQM	J
    //   1097: lstore 5
    //   1099: goto -618 -> 481
    //   1102: aload_0
    //   1103: getfield 106	com/google/android/exoplayer2/source/b/f:aRw	Ljava/lang/String;
    //   1106: ldc 116
    //   1108: invokevirtual 114	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1111: ifne +15 -> 1126
    //   1114: aload_0
    //   1115: getfield 106	com/google/android/exoplayer2/source/b/f:aRw	Ljava/lang/String;
    //   1118: ldc 118
    //   1120: invokevirtual 114	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1123: ifeq +34 -> 1157
    //   1126: new 412	com/google/android/exoplayer2/c/f/a
    //   1129: dup
    //   1130: lload 5
    //   1132: invokespecial 413	com/google/android/exoplayer2/c/f/a:<init>	(J)V
    //   1135: astore 7
    //   1137: goto -633 -> 504
    //   1140: astore 7
    //   1142: aload_0
    //   1143: getfield 88	com/google/android/exoplayer2/source/b/f:aBo	Lcom/google/android/exoplayer2/h/g;
    //   1146: invokestatic 399	com/google/android/exoplayer2/i/x:a	(Lcom/google/android/exoplayer2/h/g;)V
    //   1149: ldc 188
    //   1151: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1154: aload 7
    //   1156: athrow
    //   1157: aload_0
    //   1158: getfield 106	com/google/android/exoplayer2/source/b/f:aRw	Ljava/lang/String;
    //   1161: ldc 120
    //   1163: invokevirtual 114	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1166: ifeq +18 -> 1184
    //   1169: new 415	com/google/android/exoplayer2/c/c/b
    //   1172: dup
    //   1173: iconst_0
    //   1174: lload 5
    //   1176: invokespecial 418	com/google/android/exoplayer2/c/c/b:<init>	(IJ)V
    //   1179: astore 7
    //   1181: goto -677 -> 504
    //   1184: new 420	java/lang/IllegalArgumentException
    //   1187: dup
    //   1188: new 422	java/lang/StringBuilder
    //   1191: dup
    //   1192: ldc_w 424
    //   1195: invokespecial 427	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1198: aload_0
    //   1199: getfield 106	com/google/android/exoplayer2/source/b/f:aRw	Ljava/lang/String;
    //   1202: invokevirtual 431	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1205: invokevirtual 434	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1208: invokespecial 435	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   1211: astore 7
    //   1213: ldc 188
    //   1215: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1218: aload 7
    //   1220: athrow
    //   1221: aload_0
    //   1222: aload 8
    //   1224: invokeinterface 394 1 0
    //   1229: aload_0
    //   1230: getfield 224	com/google/android/exoplayer2/source/b/f:aQI	Lcom/google/android/exoplayer2/h/j;
    //   1233: getfield 237	com/google/android/exoplayer2/h/j:aYy	J
    //   1236: lsub
    //   1237: l2i
    //   1238: putfield 226	com/google/android/exoplayer2/source/b/f:aRE	I
    //   1241: aload_0
    //   1242: getfield 88	com/google/android/exoplayer2/source/b/f:aBo	Lcom/google/android/exoplayer2/h/g;
    //   1245: invokestatic 399	com/google/android/exoplayer2/i/x:a	(Lcom/google/android/exoplayer2/h/g;)V
    //   1248: aload_0
    //   1249: iconst_1
    //   1250: putfield 437	com/google/android/exoplayer2/source/b/f:aRH	Z
    //   1253: ldc 188
    //   1255: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1258: return
    //   1259: astore 7
    //   1261: aload_0
    //   1262: aload 8
    //   1264: invokeinterface 394 1 0
    //   1269: aload_0
    //   1270: getfield 224	com/google/android/exoplayer2/source/b/f:aQI	Lcom/google/android/exoplayer2/h/j;
    //   1273: getfield 237	com/google/android/exoplayer2/h/j:aYy	J
    //   1276: lsub
    //   1277: l2i
    //   1278: putfield 226	com/google/android/exoplayer2/source/b/f:aRE	I
    //   1281: ldc 188
    //   1283: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1286: aload 7
    //   1288: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1289	0	this	f
    //   88	959	1	i	int
    //   279	803	2	j	int
    //   284	545	3	k	int
    //   4	536	4	m	int
    //   459	716	5	l	long
    //   85	898	7	localObject1	Object
    //   1009	15	7	localObject2	Object
    //   1043	93	7	localObject3	Object
    //   1140	15	7	localObject4	Object
    //   1179	40	7	localObject5	Object
    //   1259	28	7	localObject6	Object
    //   205	656	8	localObject7	Object
    //   979	284	8	localObject8	Object
    //   1	767	9	localObject9	Object
    //   665	112	10	localObject10	Object
    //   690	14	11	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   921	941	979	finally
    //   886	915	1009	finally
    //   944	964	1009	finally
    //   981	1009	1009	finally
    //   178	280	1140	finally
    //   285	329	1140	finally
    //   329	367	1140	finally
    //   372	379	1140	finally
    //   386	461	1140	finally
    //   470	481	1140	finally
    //   481	504	1140	finally
    //   504	521	1140	finally
    //   528	539	1140	finally
    //   1093	1099	1140	finally
    //   1102	1126	1140	finally
    //   1126	1137	1140	finally
    //   1157	1181	1140	finally
    //   1184	1221	1140	finally
    //   1221	1241	1140	finally
    //   1261	1289	1140	finally
    //   546	566	1259	finally
  }
  
  public final long pt()
  {
    return this.aRE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.f
 * JD-Core Version:    0.7.0.1
 */