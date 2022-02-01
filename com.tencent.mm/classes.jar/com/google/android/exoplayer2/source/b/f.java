package com.google.android.exoplayer2.source.b;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.h.g;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.u;
import com.google.android.exoplayer2.metadata.id3.a;
import com.google.android.exoplayer2.source.b.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

final class f
  extends com.google.android.exoplayer2.source.a.l
{
  private static final AtomicInteger bpa;
  private final u bcf;
  private final boolean bds;
  private volatile boolean bll;
  private e blp;
  private int bmR;
  volatile boolean bmS;
  private final List<Format> boN;
  public final int bpb;
  public final a.a bpc;
  private final g bpd;
  private final com.google.android.exoplayer2.h.j bpe;
  private final boolean bpf;
  private final String bpg;
  private final e bph;
  private final boolean bpi;
  private final boolean bpj;
  private final boolean bpk;
  private final a bpl;
  private final m bpm;
  private int bpn;
  private boolean bpo;
  private j bpp;
  public final int uid;
  
  static
  {
    AppMethodBeat.i(62833);
    bpa = new AtomicInteger();
    AppMethodBeat.o(62833);
  }
  
  public f(g paramg, com.google.android.exoplayer2.h.j paramj1, com.google.android.exoplayer2.h.j paramj2, a.a parama, List<Format> paramList, int paramInt1, Object paramObject, long paramLong1, long paramLong2, int paramInt2, int paramInt3, boolean paramBoolean, u paramu, f paramf, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2) {}
  
  public final void a(j paramj)
  {
    int j = 0;
    this.bpp = paramj;
    int k = this.uid;
    boolean bool = this.bpi;
    paramj.bpE = k;
    com.google.android.exoplayer2.source.l[] arrayOfl = paramj.bkV;
    int m = arrayOfl.length;
    int i = 0;
    while (i < m)
    {
      arrayOfl[i].blN.blL = k;
      i += 1;
    }
    if (bool)
    {
      paramj = paramj.bkV;
      k = paramj.length;
      i = j;
      while (i < k)
      {
        paramj[i].blW = true;
        i += 1;
      }
    }
  }
  
  public final void tN()
  {
    this.bll = true;
  }
  
  public final boolean tO()
  {
    return this.bll;
  }
  
  /* Error */
  public final void tP()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: ldc 188
    //   5: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 128	com/google/android/exoplayer2/source/b/f:blp	Lcom/google/android/exoplayer2/c/e;
    //   12: ifnonnull +95 -> 107
    //   15: aload_0
    //   16: getfield 122	com/google/android/exoplayer2/source/b/f:bpk	Z
    //   19: ifne +88 -> 107
    //   22: ldc 190
    //   24: aload_0
    //   25: getfield 79	com/google/android/exoplayer2/source/b/f:bpc	Lcom/google/android/exoplayer2/source/b/a/a$a;
    //   28: getfield 69	com/google/android/exoplayer2/source/b/a/a$a:aSv	Lcom/google/android/exoplayer2/Format;
    //   31: getfield 195	com/google/android/exoplayer2/Format:aSd	Ljava/lang/String;
    //   34: invokevirtual 199	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   37: ifne +27 -> 64
    //   40: aload_0
    //   41: getfield 106	com/google/android/exoplayer2/source/b/f:bpg	Ljava/lang/String;
    //   44: ldc 201
    //   46: invokevirtual 114	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   49: ifne +15 -> 64
    //   52: aload_0
    //   53: getfield 106	com/google/android/exoplayer2/source/b/f:bpg	Ljava/lang/String;
    //   56: ldc 203
    //   58: invokevirtual 114	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   61: ifeq +505 -> 566
    //   64: new 205	com/google/android/exoplayer2/source/b/l
    //   67: dup
    //   68: aload_0
    //   69: getfield 208	com/google/android/exoplayer2/source/b/f:bmm	Lcom/google/android/exoplayer2/Format;
    //   72: getfield 211	com/google/android/exoplayer2/Format:aSt	Ljava/lang/String;
    //   75: aload_0
    //   76: getfield 85	com/google/android/exoplayer2/source/b/f:bcf	Lcom/google/android/exoplayer2/i/u;
    //   79: invokespecial 214	com/google/android/exoplayer2/source/b/l:<init>	(Ljava/lang/String;Lcom/google/android/exoplayer2/i/u;)V
    //   82: astore 7
    //   84: iconst_1
    //   85: istore_1
    //   86: iload_1
    //   87: ifeq +14 -> 101
    //   90: aload 7
    //   92: aload_0
    //   93: getfield 158	com/google/android/exoplayer2/source/b/f:bpp	Lcom/google/android/exoplayer2/source/b/j;
    //   96: invokeinterface 219 2 0
    //   101: aload_0
    //   102: aload 7
    //   104: putfield 128	com/google/android/exoplayer2/source/b/f:blp	Lcom/google/android/exoplayer2/c/e;
    //   107: aload_0
    //   108: getfield 130	com/google/android/exoplayer2/source/b/f:bph	Lcom/google/android/exoplayer2/c/e;
    //   111: aload_0
    //   112: getfield 128	com/google/android/exoplayer2/source/b/f:blp	Lcom/google/android/exoplayer2/c/e;
    //   115: if_acmpeq +17 -> 132
    //   118: aload_0
    //   119: getfield 221	com/google/android/exoplayer2/source/b/f:bpo	Z
    //   122: ifne +10 -> 132
    //   125: aload_0
    //   126: getfield 77	com/google/android/exoplayer2/source/b/f:bpe	Lcom/google/android/exoplayer2/h/j;
    //   129: ifnonnull +622 -> 751
    //   132: aload_0
    //   133: getfield 184	com/google/android/exoplayer2/source/b/f:bll	Z
    //   136: ifne +996 -> 1132
    //   139: aload_0
    //   140: getfield 92	com/google/android/exoplayer2/source/b/f:bds	Z
    //   143: ifeq +767 -> 910
    //   146: aload_0
    //   147: getfield 224	com/google/android/exoplayer2/source/b/f:bml	Lcom/google/android/exoplayer2/h/j;
    //   150: astore 7
    //   152: aload_0
    //   153: getfield 226	com/google/android/exoplayer2/source/b/f:bmR	I
    //   156: ifeq +749 -> 905
    //   159: iconst_1
    //   160: istore_1
    //   161: aload_0
    //   162: getfield 83	com/google/android/exoplayer2/source/b/f:bpf	Z
    //   165: ifne +764 -> 929
    //   168: aload_0
    //   169: getfield 85	com/google/android/exoplayer2/source/b/f:bcf	Lcom/google/android/exoplayer2/i/u;
    //   172: invokevirtual 231	com/google/android/exoplayer2/i/u:vZ	()V
    //   175: new 233	com/google/android/exoplayer2/c/b
    //   178: dup
    //   179: aload_0
    //   180: getfield 88	com/google/android/exoplayer2/source/b/f:aWG	Lcom/google/android/exoplayer2/h/g;
    //   183: aload 7
    //   185: getfield 237	com/google/android/exoplayer2/h/j:bwz	J
    //   188: aload_0
    //   189: getfield 88	com/google/android/exoplayer2/source/b/f:aWG	Lcom/google/android/exoplayer2/h/g;
    //   192: aload 7
    //   194: invokeinterface 242 2 0
    //   199: invokespecial 245	com/google/android/exoplayer2/c/b:<init>	(Lcom/google/android/exoplayer2/h/g;JJ)V
    //   202: astore 8
    //   204: aload_0
    //   205: getfield 128	com/google/android/exoplayer2/source/b/f:blp	Lcom/google/android/exoplayer2/c/e;
    //   208: ifnonnull +310 -> 518
    //   211: aload 8
    //   213: invokeinterface 250 1 0
    //   218: aload 8
    //   220: aload_0
    //   221: getfield 126	com/google/android/exoplayer2/source/b/f:bpm	Lcom/google/android/exoplayer2/i/m;
    //   224: getfield 254	com/google/android/exoplayer2/i/m:data	[B
    //   227: iconst_0
    //   228: bipush 10
    //   230: iconst_1
    //   231: invokeinterface 258 5 0
    //   236: ifeq +728 -> 964
    //   239: aload_0
    //   240: getfield 126	com/google/android/exoplayer2/source/b/f:bpm	Lcom/google/android/exoplayer2/i/m;
    //   243: bipush 10
    //   245: invokevirtual 261	com/google/android/exoplayer2/i/m:reset	(I)V
    //   248: aload_0
    //   249: getfield 126	com/google/android/exoplayer2/source/b/f:bpm	Lcom/google/android/exoplayer2/i/m;
    //   252: invokevirtual 264	com/google/android/exoplayer2/i/m:vL	()I
    //   255: getstatic 267	com/google/android/exoplayer2/metadata/id3/a:bfm	I
    //   258: if_icmpne +706 -> 964
    //   261: aload_0
    //   262: getfield 126	com/google/android/exoplayer2/source/b/f:bpm	Lcom/google/android/exoplayer2/i/m;
    //   265: iconst_3
    //   266: invokevirtual 270	com/google/android/exoplayer2/i/m:fl	(I)V
    //   269: aload_0
    //   270: getfield 126	com/google/android/exoplayer2/source/b/f:bpm	Lcom/google/android/exoplayer2/i/m;
    //   273: invokevirtual 273	com/google/android/exoplayer2/i/m:vP	()I
    //   276: istore_2
    //   277: iload_2
    //   278: bipush 10
    //   280: iadd
    //   281: istore_3
    //   282: iload_3
    //   283: aload_0
    //   284: getfield 126	com/google/android/exoplayer2/source/b/f:bpm	Lcom/google/android/exoplayer2/i/m;
    //   287: invokevirtual 276	com/google/android/exoplayer2/i/m:capacity	()I
    //   290: if_icmple +36 -> 326
    //   293: aload_0
    //   294: getfield 126	com/google/android/exoplayer2/source/b/f:bpm	Lcom/google/android/exoplayer2/i/m;
    //   297: getfield 254	com/google/android/exoplayer2/i/m:data	[B
    //   300: astore 7
    //   302: aload_0
    //   303: getfield 126	com/google/android/exoplayer2/source/b/f:bpm	Lcom/google/android/exoplayer2/i/m;
    //   306: iload_3
    //   307: invokevirtual 261	com/google/android/exoplayer2/i/m:reset	(I)V
    //   310: aload 7
    //   312: iconst_0
    //   313: aload_0
    //   314: getfield 126	com/google/android/exoplayer2/source/b/f:bpm	Lcom/google/android/exoplayer2/i/m;
    //   317: getfield 254	com/google/android/exoplayer2/i/m:data	[B
    //   320: iconst_0
    //   321: bipush 10
    //   323: invokestatic 282	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   326: aload 8
    //   328: aload_0
    //   329: getfield 126	com/google/android/exoplayer2/source/b/f:bpm	Lcom/google/android/exoplayer2/i/m;
    //   332: getfield 254	com/google/android/exoplayer2/i/m:data	[B
    //   335: bipush 10
    //   337: iload_2
    //   338: iconst_1
    //   339: invokeinterface 258 5 0
    //   344: ifeq +620 -> 964
    //   347: aload_0
    //   348: getfield 124	com/google/android/exoplayer2/source/b/f:bpl	Lcom/google/android/exoplayer2/metadata/id3/a;
    //   351: aload_0
    //   352: getfield 126	com/google/android/exoplayer2/source/b/f:bpm	Lcom/google/android/exoplayer2/i/m;
    //   355: getfield 254	com/google/android/exoplayer2/i/m:data	[B
    //   358: iload_2
    //   359: invokevirtual 286	com/google/android/exoplayer2/metadata/id3/a:d	([BI)Lcom/google/android/exoplayer2/metadata/Metadata;
    //   362: astore 7
    //   364: aload 7
    //   366: ifnull +598 -> 964
    //   369: aload 7
    //   371: getfield 292	com/google/android/exoplayer2/metadata/Metadata:bjd	[Lcom/google/android/exoplayer2/metadata/Metadata$Entry;
    //   374: arraylength
    //   375: istore_3
    //   376: iconst_0
    //   377: istore_2
    //   378: iload_2
    //   379: iload_3
    //   380: if_icmpge +584 -> 964
    //   383: aload 7
    //   385: getfield 292	com/google/android/exoplayer2/metadata/Metadata:bjd	[Lcom/google/android/exoplayer2/metadata/Metadata$Entry;
    //   388: iload_2
    //   389: aaload
    //   390: astore 9
    //   392: aload 9
    //   394: instanceof 294
    //   397: ifeq +560 -> 957
    //   400: aload 9
    //   402: checkcast 294	com/google/android/exoplayer2/metadata/id3/PrivFrame
    //   405: astore 9
    //   407: ldc_w 296
    //   410: aload 9
    //   412: getfield 299	com/google/android/exoplayer2/metadata/id3/PrivFrame:bjG	Ljava/lang/String;
    //   415: invokevirtual 199	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   418: ifeq +539 -> 957
    //   421: aload 9
    //   423: getfield 302	com/google/android/exoplayer2/metadata/id3/PrivFrame:bjH	[B
    //   426: iconst_0
    //   427: aload_0
    //   428: getfield 126	com/google/android/exoplayer2/source/b/f:bpm	Lcom/google/android/exoplayer2/i/m;
    //   431: getfield 254	com/google/android/exoplayer2/i/m:data	[B
    //   434: iconst_0
    //   435: bipush 8
    //   437: invokestatic 282	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   440: aload_0
    //   441: getfield 126	com/google/android/exoplayer2/source/b/f:bpm	Lcom/google/android/exoplayer2/i/m;
    //   444: bipush 8
    //   446: invokevirtual 261	com/google/android/exoplayer2/i/m:reset	(I)V
    //   449: aload_0
    //   450: getfield 126	com/google/android/exoplayer2/source/b/f:bpm	Lcom/google/android/exoplayer2/i/m;
    //   453: invokevirtual 306	com/google/android/exoplayer2/i/m:readLong	()J
    //   456: lstore 5
    //   458: lload 5
    //   460: ldc2_w 307
    //   463: lcmp
    //   464: ifeq +508 -> 972
    //   467: aload_0
    //   468: getfield 85	com/google/android/exoplayer2/source/b/f:bcf	Lcom/google/android/exoplayer2/i/u;
    //   471: lload 5
    //   473: invokevirtual 312	com/google/android/exoplayer2/i/u:as	(J)J
    //   476: lstore 5
    //   478: aload_0
    //   479: getfield 106	com/google/android/exoplayer2/source/b/f:bpg	Ljava/lang/String;
    //   482: ldc 108
    //   484: invokevirtual 114	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   487: ifeq +494 -> 981
    //   490: new 314	com/google/android/exoplayer2/c/g/c
    //   493: dup
    //   494: lload 5
    //   496: invokespecial 317	com/google/android/exoplayer2/c/g/c:<init>	(J)V
    //   499: astore 7
    //   501: aload 7
    //   503: aload_0
    //   504: getfield 158	com/google/android/exoplayer2/source/b/f:bpp	Lcom/google/android/exoplayer2/source/b/j;
    //   507: invokeinterface 219 2 0
    //   512: aload_0
    //   513: aload 7
    //   515: putfield 128	com/google/android/exoplayer2/source/b/f:blp	Lcom/google/android/exoplayer2/c/e;
    //   518: iload 4
    //   520: istore_2
    //   521: iload_1
    //   522: ifeq +17 -> 539
    //   525: aload 8
    //   527: aload_0
    //   528: getfield 226	com/google/android/exoplayer2/source/b/f:bmR	I
    //   531: invokeinterface 320 2 0
    //   536: iload 4
    //   538: istore_2
    //   539: iload_2
    //   540: ifne +560 -> 1100
    //   543: aload_0
    //   544: getfield 184	com/google/android/exoplayer2/source/b/f:bll	Z
    //   547: ifne +553 -> 1100
    //   550: aload_0
    //   551: getfield 128	com/google/android/exoplayer2/source/b/f:blp	Lcom/google/android/exoplayer2/c/e;
    //   554: aload 8
    //   556: aconst_null
    //   557: invokeinterface 323 3 0
    //   562: istore_2
    //   563: goto -24 -> 539
    //   566: aload_0
    //   567: getfield 134	com/google/android/exoplayer2/source/b/f:bpj	Z
    //   570: ifne +14 -> 584
    //   573: aload_0
    //   574: getfield 130	com/google/android/exoplayer2/source/b/f:bph	Lcom/google/android/exoplayer2/c/e;
    //   577: astore 7
    //   579: iconst_0
    //   580: istore_1
    //   581: goto -495 -> 86
    //   584: aload_0
    //   585: getfield 106	com/google/android/exoplayer2/source/b/f:bpg	Ljava/lang/String;
    //   588: ldc_w 325
    //   591: invokevirtual 114	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   594: ifne +25 -> 619
    //   597: aload_0
    //   598: getfield 106	com/google/android/exoplayer2/source/b/f:bpg	Ljava/lang/String;
    //   601: ldc_w 327
    //   604: aload_0
    //   605: getfield 106	com/google/android/exoplayer2/source/b/f:bpg	Ljava/lang/String;
    //   608: invokevirtual 330	java/lang/String:length	()I
    //   611: iconst_4
    //   612: isub
    //   613: invokevirtual 334	java/lang/String:startsWith	(Ljava/lang/String;I)Z
    //   616: ifeq +22 -> 638
    //   619: new 336	com/google/android/exoplayer2/c/d/e
    //   622: dup
    //   623: iconst_0
    //   624: aload_0
    //   625: getfield 85	com/google/android/exoplayer2/source/b/f:bcf	Lcom/google/android/exoplayer2/i/u;
    //   628: invokespecial 339	com/google/android/exoplayer2/c/d/e:<init>	(ILcom/google/android/exoplayer2/i/u;)V
    //   631: astore 7
    //   633: iconst_1
    //   634: istore_1
    //   635: goto -549 -> 86
    //   638: bipush 16
    //   640: istore_1
    //   641: aload_0
    //   642: getfield 81	com/google/android/exoplayer2/source/b/f:boN	Ljava/util/List;
    //   645: astore 7
    //   647: aload 7
    //   649: ifnull +94 -> 743
    //   652: bipush 48
    //   654: istore_1
    //   655: aload_0
    //   656: getfield 208	com/google/android/exoplayer2/source/b/f:bmm	Lcom/google/android/exoplayer2/Format;
    //   659: getfield 342	com/google/android/exoplayer2/Format:aSa	Ljava/lang/String;
    //   662: astore 8
    //   664: iload_1
    //   665: istore_3
    //   666: aload 8
    //   668: invokestatic 348	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   671: ifne +43 -> 714
    //   674: iload_1
    //   675: istore_2
    //   676: ldc_w 350
    //   679: aload 8
    //   681: invokestatic 356	com/google/android/exoplayer2/i/j:aN	(Ljava/lang/String;)Ljava/lang/String;
    //   684: invokevirtual 199	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   687: ifne +7 -> 694
    //   690: iload_1
    //   691: iconst_2
    //   692: ior
    //   693: istore_2
    //   694: iload_2
    //   695: istore_3
    //   696: ldc_w 358
    //   699: aload 8
    //   701: invokestatic 361	com/google/android/exoplayer2/i/j:aM	(Ljava/lang/String;)Ljava/lang/String;
    //   704: invokevirtual 199	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   707: ifne +7 -> 714
    //   710: iload_2
    //   711: iconst_4
    //   712: ior
    //   713: istore_3
    //   714: new 363	com/google/android/exoplayer2/c/g/u
    //   717: dup
    //   718: iconst_2
    //   719: aload_0
    //   720: getfield 85	com/google/android/exoplayer2/source/b/f:bcf	Lcom/google/android/exoplayer2/i/u;
    //   723: new 365	com/google/android/exoplayer2/c/g/e
    //   726: dup
    //   727: iload_3
    //   728: aload 7
    //   730: invokespecial 368	com/google/android/exoplayer2/c/g/e:<init>	(ILjava/util/List;)V
    //   733: invokespecial 371	com/google/android/exoplayer2/c/g/u:<init>	(ILcom/google/android/exoplayer2/i/u;Lcom/google/android/exoplayer2/c/g/v$c;)V
    //   736: astore 7
    //   738: iconst_1
    //   739: istore_1
    //   740: goto -654 -> 86
    //   743: invokestatic 377	java/util/Collections:emptyList	()Ljava/util/List;
    //   746: astore 7
    //   748: goto -93 -> 655
    //   751: aload_0
    //   752: getfield 77	com/google/android/exoplayer2/source/b/f:bpe	Lcom/google/android/exoplayer2/h/j;
    //   755: aload_0
    //   756: getfield 379	com/google/android/exoplayer2/source/b/f:bpn	I
    //   759: i2l
    //   760: invokevirtual 383	com/google/android/exoplayer2/h/j:ap	(J)Lcom/google/android/exoplayer2/h/j;
    //   763: astore 7
    //   765: new 233	com/google/android/exoplayer2/c/b
    //   768: dup
    //   769: aload_0
    //   770: getfield 136	com/google/android/exoplayer2/source/b/f:bpd	Lcom/google/android/exoplayer2/h/g;
    //   773: aload 7
    //   775: getfield 237	com/google/android/exoplayer2/h/j:bwz	J
    //   778: aload_0
    //   779: getfield 136	com/google/android/exoplayer2/source/b/f:bpd	Lcom/google/android/exoplayer2/h/g;
    //   782: aload 7
    //   784: invokeinterface 242 2 0
    //   789: invokespecial 245	com/google/android/exoplayer2/c/b:<init>	(Lcom/google/android/exoplayer2/h/g;JJ)V
    //   792: astore 7
    //   794: iconst_0
    //   795: istore_1
    //   796: iload_1
    //   797: ifne +26 -> 823
    //   800: aload_0
    //   801: getfield 184	com/google/android/exoplayer2/source/b/f:bll	Z
    //   804: ifne +19 -> 823
    //   807: aload_0
    //   808: getfield 128	com/google/android/exoplayer2/source/b/f:blp	Lcom/google/android/exoplayer2/c/e;
    //   811: aload 7
    //   813: aconst_null
    //   814: invokeinterface 323 3 0
    //   819: istore_1
    //   820: goto -24 -> 796
    //   823: aload_0
    //   824: aload 7
    //   826: invokeinterface 386 1 0
    //   831: aload_0
    //   832: getfield 77	com/google/android/exoplayer2/source/b/f:bpe	Lcom/google/android/exoplayer2/h/j;
    //   835: getfield 237	com/google/android/exoplayer2/h/j:bwz	J
    //   838: lsub
    //   839: l2i
    //   840: putfield 379	com/google/android/exoplayer2/source/b/f:bpn	I
    //   843: aload_0
    //   844: getfield 88	com/google/android/exoplayer2/source/b/f:aWG	Lcom/google/android/exoplayer2/h/g;
    //   847: invokestatic 391	com/google/android/exoplayer2/i/x:a	(Lcom/google/android/exoplayer2/h/g;)V
    //   850: aload_0
    //   851: iconst_1
    //   852: putfield 221	com/google/android/exoplayer2/source/b/f:bpo	Z
    //   855: goto -723 -> 132
    //   858: astore 8
    //   860: aload_0
    //   861: aload 7
    //   863: invokeinterface 386 1 0
    //   868: aload_0
    //   869: getfield 77	com/google/android/exoplayer2/source/b/f:bpe	Lcom/google/android/exoplayer2/h/j;
    //   872: getfield 237	com/google/android/exoplayer2/h/j:bwz	J
    //   875: lsub
    //   876: l2i
    //   877: putfield 379	com/google/android/exoplayer2/source/b/f:bpn	I
    //   880: ldc 188
    //   882: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   885: aload 8
    //   887: athrow
    //   888: astore 7
    //   890: aload_0
    //   891: getfield 88	com/google/android/exoplayer2/source/b/f:aWG	Lcom/google/android/exoplayer2/h/g;
    //   894: invokestatic 391	com/google/android/exoplayer2/i/x:a	(Lcom/google/android/exoplayer2/h/g;)V
    //   897: ldc 188
    //   899: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   902: aload 7
    //   904: athrow
    //   905: iconst_0
    //   906: istore_1
    //   907: goto -746 -> 161
    //   910: aload_0
    //   911: getfield 224	com/google/android/exoplayer2/source/b/f:bml	Lcom/google/android/exoplayer2/h/j;
    //   914: aload_0
    //   915: getfield 226	com/google/android/exoplayer2/source/b/f:bmR	I
    //   918: i2l
    //   919: invokevirtual 383	com/google/android/exoplayer2/h/j:ap	(J)Lcom/google/android/exoplayer2/h/j;
    //   922: astore 7
    //   924: iconst_0
    //   925: istore_1
    //   926: goto -765 -> 161
    //   929: aload_0
    //   930: getfield 85	com/google/android/exoplayer2/source/b/f:bcf	Lcom/google/android/exoplayer2/i/u;
    //   933: getfield 394	com/google/android/exoplayer2/i/u:bfn	J
    //   936: ldc2_w 395
    //   939: lcmp
    //   940: ifne -765 -> 175
    //   943: aload_0
    //   944: getfield 85	com/google/android/exoplayer2/source/b/f:bcf	Lcom/google/android/exoplayer2/i/u;
    //   947: aload_0
    //   948: getfield 399	com/google/android/exoplayer2/source/b/f:bmp	J
    //   951: invokevirtual 402	com/google/android/exoplayer2/i/u:ar	(J)V
    //   954: goto -779 -> 175
    //   957: iload_2
    //   958: iconst_1
    //   959: iadd
    //   960: istore_2
    //   961: goto -583 -> 378
    //   964: ldc2_w 307
    //   967: lstore 5
    //   969: goto -511 -> 458
    //   972: aload_0
    //   973: getfield 399	com/google/android/exoplayer2/source/b/f:bmp	J
    //   976: lstore 5
    //   978: goto -500 -> 478
    //   981: aload_0
    //   982: getfield 106	com/google/android/exoplayer2/source/b/f:bpg	Ljava/lang/String;
    //   985: ldc 116
    //   987: invokevirtual 114	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   990: ifne +15 -> 1005
    //   993: aload_0
    //   994: getfield 106	com/google/android/exoplayer2/source/b/f:bpg	Ljava/lang/String;
    //   997: ldc 118
    //   999: invokevirtual 114	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1002: ifeq +34 -> 1036
    //   1005: new 404	com/google/android/exoplayer2/c/g/a
    //   1008: dup
    //   1009: lload 5
    //   1011: invokespecial 405	com/google/android/exoplayer2/c/g/a:<init>	(J)V
    //   1014: astore 7
    //   1016: goto -515 -> 501
    //   1019: astore 7
    //   1021: aload_0
    //   1022: getfield 88	com/google/android/exoplayer2/source/b/f:aWG	Lcom/google/android/exoplayer2/h/g;
    //   1025: invokestatic 391	com/google/android/exoplayer2/i/x:a	(Lcom/google/android/exoplayer2/h/g;)V
    //   1028: ldc 188
    //   1030: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1033: aload 7
    //   1035: athrow
    //   1036: aload_0
    //   1037: getfield 106	com/google/android/exoplayer2/source/b/f:bpg	Ljava/lang/String;
    //   1040: ldc 120
    //   1042: invokevirtual 114	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1045: ifeq +18 -> 1063
    //   1048: new 407	com/google/android/exoplayer2/c/c/b
    //   1051: dup
    //   1052: iconst_0
    //   1053: lload 5
    //   1055: invokespecial 410	com/google/android/exoplayer2/c/c/b:<init>	(IJ)V
    //   1058: astore 7
    //   1060: goto -559 -> 501
    //   1063: new 412	java/lang/IllegalArgumentException
    //   1066: dup
    //   1067: new 414	java/lang/StringBuilder
    //   1070: dup
    //   1071: ldc_w 416
    //   1074: invokespecial 419	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1077: aload_0
    //   1078: getfield 106	com/google/android/exoplayer2/source/b/f:bpg	Ljava/lang/String;
    //   1081: invokevirtual 423	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1084: invokevirtual 426	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1087: invokespecial 427	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   1090: astore 7
    //   1092: ldc 188
    //   1094: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1097: aload 7
    //   1099: athrow
    //   1100: aload_0
    //   1101: aload 8
    //   1103: invokeinterface 386 1 0
    //   1108: aload_0
    //   1109: getfield 224	com/google/android/exoplayer2/source/b/f:bml	Lcom/google/android/exoplayer2/h/j;
    //   1112: getfield 237	com/google/android/exoplayer2/h/j:bwz	J
    //   1115: lsub
    //   1116: l2i
    //   1117: putfield 226	com/google/android/exoplayer2/source/b/f:bmR	I
    //   1120: aload_0
    //   1121: getfield 88	com/google/android/exoplayer2/source/b/f:aWG	Lcom/google/android/exoplayer2/h/g;
    //   1124: invokestatic 391	com/google/android/exoplayer2/i/x:a	(Lcom/google/android/exoplayer2/h/g;)V
    //   1127: aload_0
    //   1128: iconst_1
    //   1129: putfield 429	com/google/android/exoplayer2/source/b/f:bmS	Z
    //   1132: ldc 188
    //   1134: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1137: return
    //   1138: astore 7
    //   1140: aload_0
    //   1141: aload 8
    //   1143: invokeinterface 386 1 0
    //   1148: aload_0
    //   1149: getfield 224	com/google/android/exoplayer2/source/b/f:bml	Lcom/google/android/exoplayer2/h/j;
    //   1152: getfield 237	com/google/android/exoplayer2/h/j:bwz	J
    //   1155: lsub
    //   1156: l2i
    //   1157: putfield 226	com/google/android/exoplayer2/source/b/f:bmR	I
    //   1160: ldc 188
    //   1162: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1165: aload 7
    //   1167: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1168	0	this	f
    //   85	841	1	i	int
    //   276	685	2	j	int
    //   281	447	3	k	int
    //   1	536	4	m	int
    //   456	598	5	l	long
    //   82	780	7	localObject1	Object
    //   888	15	7	localObject2	Object
    //   922	93	7	localObject3	Object
    //   1019	15	7	localObject4	Object
    //   1058	40	7	localObject5	Object
    //   1138	28	7	localObject6	Object
    //   202	498	8	localObject7	Object
    //   858	284	8	localObject8	Object
    //   390	32	9	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   800	820	858	finally
    //   765	794	888	finally
    //   823	843	888	finally
    //   860	888	888	finally
    //   175	277	1019	finally
    //   282	326	1019	finally
    //   326	364	1019	finally
    //   369	376	1019	finally
    //   383	458	1019	finally
    //   467	478	1019	finally
    //   478	501	1019	finally
    //   501	518	1019	finally
    //   525	536	1019	finally
    //   972	978	1019	finally
    //   981	1005	1019	finally
    //   1005	1016	1019	finally
    //   1036	1060	1019	finally
    //   1063	1100	1019	finally
    //   1100	1120	1019	finally
    //   1140	1168	1019	finally
    //   543	563	1138	finally
  }
  
  public final long ub()
  {
    return this.bmR;
  }
  
  public final boolean ud()
  {
    return this.bmS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.f
 * JD-Core Version:    0.7.0.1
 */