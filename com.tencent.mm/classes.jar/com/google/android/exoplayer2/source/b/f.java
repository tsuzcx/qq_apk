package com.google.android.exoplayer2.source.b;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.i;
import com.google.android.exoplayer2.i.q;
import com.google.android.exoplayer2.metadata.id3.a;
import com.google.android.exoplayer2.source.b.a.a.a;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

final class f
  extends com.google.android.exoplayer2.source.a.d
{
  private static final AtomicInteger aJK = new AtomicInteger();
  private final q aBX;
  private final boolean aCF;
  public final int aJL;
  public final a.a aJM;
  private final com.google.android.exoplayer2.h.f aJN;
  private final i aJO;
  private final boolean aJP;
  private final String aJQ;
  private final com.google.android.exoplayer2.c.d aJR;
  final boolean aJS;
  private final boolean aJT;
  private final boolean aJU;
  private final a aJV;
  private final com.google.android.exoplayer2.i.j aJW;
  private com.google.android.exoplayer2.c.d aJX;
  private int aJY;
  private int aJZ;
  private volatile boolean aJg;
  private final List<Format> aJu;
  private boolean aKa;
  j aKb;
  volatile boolean aKc;
  public final int uid;
  
  public f(com.google.android.exoplayer2.h.f paramf, i parami1, i parami2, a.a parama, List<Format> paramList, int paramInt1, Object paramObject, long paramLong1, long paramLong2, int paramInt2, int paramInt3, boolean paramBoolean, q paramq, f paramf1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2) {}
  
  public final long mQ()
  {
    return this.aJZ;
  }
  
  public final void mR()
  {
    this.aJg = true;
  }
  
  public final boolean mS()
  {
    return this.aJg;
  }
  
  /* Error */
  public final void mT()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: iconst_0
    //   4: istore 4
    //   6: aload_0
    //   7: getfield 117	com/google/android/exoplayer2/source/b/f:aJX	Lcom/google/android/exoplayer2/c/d;
    //   10: ifnonnull +95 -> 105
    //   13: aload_0
    //   14: getfield 111	com/google/android/exoplayer2/source/b/f:aJU	Z
    //   17: ifne +88 -> 105
    //   20: ldc 156
    //   22: aload_0
    //   23: getfield 68	com/google/android/exoplayer2/source/b/f:aJM	Lcom/google/android/exoplayer2/source/b/a/a$a;
    //   26: getfield 59	com/google/android/exoplayer2/source/b/a/a$a:auL	Lcom/google/android/exoplayer2/Format;
    //   29: getfield 161	com/google/android/exoplayer2/Format:aus	Ljava/lang/String;
    //   32: invokevirtual 165	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   35: ifne +27 -> 62
    //   38: aload_0
    //   39: getfield 95	com/google/android/exoplayer2/source/b/f:aJQ	Ljava/lang/String;
    //   42: ldc 167
    //   44: invokevirtual 103	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   47: ifne +15 -> 62
    //   50: aload_0
    //   51: getfield 95	com/google/android/exoplayer2/source/b/f:aJQ	Ljava/lang/String;
    //   54: ldc 169
    //   56: invokevirtual 103	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   59: ifeq +504 -> 563
    //   62: new 171	com/google/android/exoplayer2/source/b/l
    //   65: dup
    //   66: aload_0
    //   67: getfield 174	com/google/android/exoplayer2/source/b/f:aJb	Lcom/google/android/exoplayer2/Format;
    //   70: getfield 177	com/google/android/exoplayer2/Format:auI	Ljava/lang/String;
    //   73: aload_0
    //   74: getfield 74	com/google/android/exoplayer2/source/b/f:aBX	Lcom/google/android/exoplayer2/i/q;
    //   77: invokespecial 180	com/google/android/exoplayer2/source/b/l:<init>	(Ljava/lang/String;Lcom/google/android/exoplayer2/i/q;)V
    //   80: astore 7
    //   82: iconst_1
    //   83: istore_1
    //   84: iload_1
    //   85: ifeq +14 -> 99
    //   88: aload 7
    //   90: aload_0
    //   91: getfield 182	com/google/android/exoplayer2/source/b/f:aKb	Lcom/google/android/exoplayer2/source/b/j;
    //   94: invokeinterface 188 2 0
    //   99: aload_0
    //   100: aload 7
    //   102: putfield 117	com/google/android/exoplayer2/source/b/f:aJX	Lcom/google/android/exoplayer2/c/d;
    //   105: aload_0
    //   106: getfield 119	com/google/android/exoplayer2/source/b/f:aJR	Lcom/google/android/exoplayer2/c/d;
    //   109: aload_0
    //   110: getfield 117	com/google/android/exoplayer2/source/b/f:aJX	Lcom/google/android/exoplayer2/c/d;
    //   113: if_acmpeq +17 -> 130
    //   116: aload_0
    //   117: getfield 190	com/google/android/exoplayer2/source/b/f:aKa	Z
    //   120: ifne +10 -> 130
    //   123: aload_0
    //   124: getfield 66	com/google/android/exoplayer2/source/b/f:aJO	Lcom/google/android/exoplayer2/h/i;
    //   127: ifnonnull +738 -> 865
    //   130: aload_0
    //   131: getfield 151	com/google/android/exoplayer2/source/b/f:aJg	Z
    //   134: ifne +1086 -> 1220
    //   137: aload_0
    //   138: getfield 81	com/google/android/exoplayer2/source/b/f:aCF	Z
    //   141: ifeq +872 -> 1013
    //   144: aload_0
    //   145: getfield 193	com/google/android/exoplayer2/source/b/f:aJa	Lcom/google/android/exoplayer2/h/i;
    //   148: astore 7
    //   150: aload_0
    //   151: getfield 148	com/google/android/exoplayer2/source/b/f:aJZ	I
    //   154: ifeq +854 -> 1008
    //   157: iconst_1
    //   158: istore_1
    //   159: aload_0
    //   160: getfield 72	com/google/android/exoplayer2/source/b/f:aJP	Z
    //   163: ifne +869 -> 1032
    //   166: aload_0
    //   167: getfield 74	com/google/android/exoplayer2/source/b/f:aBX	Lcom/google/android/exoplayer2/i/q;
    //   170: invokevirtual 198	com/google/android/exoplayer2/i/q:oq	()V
    //   173: new 200	com/google/android/exoplayer2/c/b
    //   176: dup
    //   177: aload_0
    //   178: getfield 77	com/google/android/exoplayer2/source/b/f:ayZ	Lcom/google/android/exoplayer2/h/f;
    //   181: aload 7
    //   183: getfield 204	com/google/android/exoplayer2/h/i:aQV	J
    //   186: aload_0
    //   187: getfield 77	com/google/android/exoplayer2/source/b/f:ayZ	Lcom/google/android/exoplayer2/h/f;
    //   190: aload 7
    //   192: invokeinterface 209 2 0
    //   197: invokespecial 212	com/google/android/exoplayer2/c/b:<init>	(Lcom/google/android/exoplayer2/h/f;JJ)V
    //   200: astore 8
    //   202: aload_0
    //   203: getfield 117	com/google/android/exoplayer2/source/b/f:aJX	Lcom/google/android/exoplayer2/c/d;
    //   206: ifnonnull +310 -> 516
    //   209: aload 8
    //   211: invokeinterface 217 1 0
    //   216: aload 8
    //   218: aload_0
    //   219: getfield 115	com/google/android/exoplayer2/source/b/f:aJW	Lcom/google/android/exoplayer2/i/j;
    //   222: getfield 221	com/google/android/exoplayer2/i/j:data	[B
    //   225: iconst_0
    //   226: bipush 10
    //   228: iconst_1
    //   229: invokeinterface 225 5 0
    //   234: ifeq +833 -> 1067
    //   237: aload_0
    //   238: getfield 115	com/google/android/exoplayer2/source/b/f:aJW	Lcom/google/android/exoplayer2/i/j;
    //   241: bipush 10
    //   243: invokevirtual 228	com/google/android/exoplayer2/i/j:reset	(I)V
    //   246: aload_0
    //   247: getfield 115	com/google/android/exoplayer2/source/b/f:aJW	Lcom/google/android/exoplayer2/i/j;
    //   250: invokevirtual 231	com/google/android/exoplayer2/i/j:of	()I
    //   253: getstatic 234	com/google/android/exoplayer2/metadata/id3/a:aDc	I
    //   256: if_icmpne +811 -> 1067
    //   259: aload_0
    //   260: getfield 115	com/google/android/exoplayer2/source/b/f:aJW	Lcom/google/android/exoplayer2/i/j;
    //   263: iconst_3
    //   264: invokevirtual 237	com/google/android/exoplayer2/i/j:dB	(I)V
    //   267: aload_0
    //   268: getfield 115	com/google/android/exoplayer2/source/b/f:aJW	Lcom/google/android/exoplayer2/i/j;
    //   271: invokevirtual 240	com/google/android/exoplayer2/i/j:og	()I
    //   274: istore_2
    //   275: iload_2
    //   276: bipush 10
    //   278: iadd
    //   279: istore_3
    //   280: iload_3
    //   281: aload_0
    //   282: getfield 115	com/google/android/exoplayer2/source/b/f:aJW	Lcom/google/android/exoplayer2/i/j;
    //   285: invokevirtual 243	com/google/android/exoplayer2/i/j:capacity	()I
    //   288: if_icmple +36 -> 324
    //   291: aload_0
    //   292: getfield 115	com/google/android/exoplayer2/source/b/f:aJW	Lcom/google/android/exoplayer2/i/j;
    //   295: getfield 221	com/google/android/exoplayer2/i/j:data	[B
    //   298: astore 7
    //   300: aload_0
    //   301: getfield 115	com/google/android/exoplayer2/source/b/f:aJW	Lcom/google/android/exoplayer2/i/j;
    //   304: iload_3
    //   305: invokevirtual 228	com/google/android/exoplayer2/i/j:reset	(I)V
    //   308: aload 7
    //   310: iconst_0
    //   311: aload_0
    //   312: getfield 115	com/google/android/exoplayer2/source/b/f:aJW	Lcom/google/android/exoplayer2/i/j;
    //   315: getfield 221	com/google/android/exoplayer2/i/j:data	[B
    //   318: iconst_0
    //   319: bipush 10
    //   321: invokestatic 249	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   324: aload 8
    //   326: aload_0
    //   327: getfield 115	com/google/android/exoplayer2/source/b/f:aJW	Lcom/google/android/exoplayer2/i/j;
    //   330: getfield 221	com/google/android/exoplayer2/i/j:data	[B
    //   333: bipush 10
    //   335: iload_2
    //   336: iconst_1
    //   337: invokeinterface 225 5 0
    //   342: ifeq +725 -> 1067
    //   345: aload_0
    //   346: getfield 113	com/google/android/exoplayer2/source/b/f:aJV	Lcom/google/android/exoplayer2/metadata/id3/a;
    //   349: aload_0
    //   350: getfield 115	com/google/android/exoplayer2/source/b/f:aJW	Lcom/google/android/exoplayer2/i/j;
    //   353: getfield 221	com/google/android/exoplayer2/i/j:data	[B
    //   356: iload_2
    //   357: invokevirtual 253	com/google/android/exoplayer2/metadata/id3/a:c	([BI)Lcom/google/android/exoplayer2/metadata/Metadata;
    //   360: astore 7
    //   362: aload 7
    //   364: ifnull +703 -> 1067
    //   367: aload 7
    //   369: getfield 259	com/google/android/exoplayer2/metadata/Metadata:aGI	[Lcom/google/android/exoplayer2/metadata/Metadata$Entry;
    //   372: arraylength
    //   373: istore_3
    //   374: iconst_0
    //   375: istore_2
    //   376: iload_2
    //   377: iload_3
    //   378: if_icmpge +689 -> 1067
    //   381: aload 7
    //   383: getfield 259	com/google/android/exoplayer2/metadata/Metadata:aGI	[Lcom/google/android/exoplayer2/metadata/Metadata$Entry;
    //   386: iload_2
    //   387: aaload
    //   388: astore 9
    //   390: aload 9
    //   392: instanceof 261
    //   395: ifeq +665 -> 1060
    //   398: aload 9
    //   400: checkcast 261	com/google/android/exoplayer2/metadata/id3/PrivFrame
    //   403: astore 9
    //   405: ldc_w 263
    //   408: aload 9
    //   410: getfield 266	com/google/android/exoplayer2/metadata/id3/PrivFrame:aHm	Ljava/lang/String;
    //   413: invokevirtual 165	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   416: ifeq +644 -> 1060
    //   419: aload 9
    //   421: getfield 269	com/google/android/exoplayer2/metadata/id3/PrivFrame:aHn	[B
    //   424: iconst_0
    //   425: aload_0
    //   426: getfield 115	com/google/android/exoplayer2/source/b/f:aJW	Lcom/google/android/exoplayer2/i/j;
    //   429: getfield 221	com/google/android/exoplayer2/i/j:data	[B
    //   432: iconst_0
    //   433: bipush 8
    //   435: invokestatic 249	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   438: aload_0
    //   439: getfield 115	com/google/android/exoplayer2/source/b/f:aJW	Lcom/google/android/exoplayer2/i/j;
    //   442: bipush 8
    //   444: invokevirtual 228	com/google/android/exoplayer2/i/j:reset	(I)V
    //   447: aload_0
    //   448: getfield 115	com/google/android/exoplayer2/source/b/f:aJW	Lcom/google/android/exoplayer2/i/j;
    //   451: invokevirtual 272	com/google/android/exoplayer2/i/j:readLong	()J
    //   454: lstore 5
    //   456: lload 5
    //   458: ldc2_w 273
    //   461: lcmp
    //   462: ifeq +613 -> 1075
    //   465: aload_0
    //   466: getfield 74	com/google/android/exoplayer2/source/b/f:aBX	Lcom/google/android/exoplayer2/i/q;
    //   469: lload 5
    //   471: invokevirtual 278	com/google/android/exoplayer2/i/q:W	(J)J
    //   474: lstore 5
    //   476: aload_0
    //   477: getfield 95	com/google/android/exoplayer2/source/b/f:aJQ	Ljava/lang/String;
    //   480: ldc 97
    //   482: invokevirtual 103	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   485: ifeq +599 -> 1084
    //   488: new 280	com/google/android/exoplayer2/c/c/c
    //   491: dup
    //   492: lload 5
    //   494: invokespecial 283	com/google/android/exoplayer2/c/c/c:<init>	(J)V
    //   497: astore 7
    //   499: aload 7
    //   501: aload_0
    //   502: getfield 182	com/google/android/exoplayer2/source/b/f:aKb	Lcom/google/android/exoplayer2/source/b/j;
    //   505: invokeinterface 188 2 0
    //   510: aload_0
    //   511: aload 7
    //   513: putfield 117	com/google/android/exoplayer2/source/b/f:aJX	Lcom/google/android/exoplayer2/c/d;
    //   516: iload 4
    //   518: istore_2
    //   519: iload_1
    //   520: ifeq +17 -> 537
    //   523: aload 8
    //   525: aload_0
    //   526: getfield 148	com/google/android/exoplayer2/source/b/f:aJZ	I
    //   529: invokeinterface 286 2 0
    //   534: iload 4
    //   536: istore_2
    //   537: iload_2
    //   538: ifne +650 -> 1188
    //   541: aload_0
    //   542: getfield 151	com/google/android/exoplayer2/source/b/f:aJg	Z
    //   545: ifne +643 -> 1188
    //   548: aload_0
    //   549: getfield 117	com/google/android/exoplayer2/source/b/f:aJX	Lcom/google/android/exoplayer2/c/d;
    //   552: aload 8
    //   554: invokeinterface 289 2 0
    //   559: istore_2
    //   560: goto -23 -> 537
    //   563: aload_0
    //   564: getfield 123	com/google/android/exoplayer2/source/b/f:aJT	Z
    //   567: ifne +14 -> 581
    //   570: aload_0
    //   571: getfield 119	com/google/android/exoplayer2/source/b/f:aJR	Lcom/google/android/exoplayer2/c/d;
    //   574: astore 7
    //   576: iconst_0
    //   577: istore_1
    //   578: goto -494 -> 84
    //   581: aload_0
    //   582: getfield 95	com/google/android/exoplayer2/source/b/f:aJQ	Ljava/lang/String;
    //   585: ldc_w 291
    //   588: invokevirtual 103	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   591: ifne +25 -> 616
    //   594: aload_0
    //   595: getfield 95	com/google/android/exoplayer2/source/b/f:aJQ	Ljava/lang/String;
    //   598: ldc_w 293
    //   601: aload_0
    //   602: getfield 95	com/google/android/exoplayer2/source/b/f:aJQ	Ljava/lang/String;
    //   605: invokevirtual 296	java/lang/String:length	()I
    //   608: iconst_4
    //   609: isub
    //   610: invokevirtual 300	java/lang/String:startsWith	(Ljava/lang/String;I)Z
    //   613: ifeq +21 -> 634
    //   616: new 302	com/google/android/exoplayer2/c/b/d
    //   619: dup
    //   620: aload_0
    //   621: getfield 74	com/google/android/exoplayer2/source/b/f:aBX	Lcom/google/android/exoplayer2/i/q;
    //   624: invokespecial 305	com/google/android/exoplayer2/c/b/d:<init>	(Lcom/google/android/exoplayer2/i/q;)V
    //   627: astore 7
    //   629: iconst_1
    //   630: istore_1
    //   631: goto -547 -> 84
    //   634: bipush 16
    //   636: istore_1
    //   637: aload_0
    //   638: getfield 70	com/google/android/exoplayer2/source/b/f:aJu	Ljava/util/List;
    //   641: astore 7
    //   643: aload 7
    //   645: ifnull +192 -> 837
    //   648: bipush 48
    //   650: istore_1
    //   651: aload_0
    //   652: getfield 174	com/google/android/exoplayer2/source/b/f:aJb	Lcom/google/android/exoplayer2/Format;
    //   655: getfield 308	com/google/android/exoplayer2/Format:aup	Ljava/lang/String;
    //   658: astore 10
    //   660: iload_1
    //   661: istore_3
    //   662: aload 10
    //   664: invokestatic 314	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   667: ifne +141 -> 808
    //   670: aload 10
    //   672: ifnull +180 -> 852
    //   675: aload 10
    //   677: ldc_w 316
    //   680: invokevirtual 320	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   683: astore 11
    //   685: aload 11
    //   687: arraylength
    //   688: istore_3
    //   689: iconst_0
    //   690: istore_2
    //   691: iload_2
    //   692: iload_3
    //   693: if_icmpge +159 -> 852
    //   696: aload 11
    //   698: iload_2
    //   699: aaload
    //   700: invokestatic 326	com/google/android/exoplayer2/i/g:ay	(Ljava/lang/String;)Ljava/lang/String;
    //   703: astore 8
    //   705: aload 8
    //   707: ifnull +138 -> 845
    //   710: aload 8
    //   712: invokestatic 329	com/google/android/exoplayer2/i/g:av	(Ljava/lang/String;)Z
    //   715: ifeq +130 -> 845
    //   718: iload_1
    //   719: istore_2
    //   720: ldc_w 331
    //   723: aload 8
    //   725: invokevirtual 165	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   728: ifne +7 -> 735
    //   731: iload_1
    //   732: iconst_2
    //   733: ior
    //   734: istore_2
    //   735: aload 9
    //   737: astore 8
    //   739: aload 10
    //   741: ifnull +50 -> 791
    //   744: aload 10
    //   746: ldc_w 316
    //   749: invokevirtual 320	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   752: astore 10
    //   754: aload 10
    //   756: arraylength
    //   757: istore_3
    //   758: iconst_0
    //   759: istore_1
    //   760: aload 9
    //   762: astore 8
    //   764: iload_1
    //   765: iload_3
    //   766: if_icmpge +25 -> 791
    //   769: aload 10
    //   771: iload_1
    //   772: aaload
    //   773: invokestatic 326	com/google/android/exoplayer2/i/g:ay	(Ljava/lang/String;)Ljava/lang/String;
    //   776: astore 8
    //   778: aload 8
    //   780: ifnull +78 -> 858
    //   783: aload 8
    //   785: invokestatic 334	com/google/android/exoplayer2/i/g:aw	(Ljava/lang/String;)Z
    //   788: ifeq +70 -> 858
    //   791: iload_2
    //   792: istore_3
    //   793: ldc_w 336
    //   796: aload 8
    //   798: invokevirtual 165	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   801: ifne +7 -> 808
    //   804: iload_2
    //   805: iconst_4
    //   806: ior
    //   807: istore_3
    //   808: new 338	com/google/android/exoplayer2/c/c/t
    //   811: dup
    //   812: iconst_2
    //   813: aload_0
    //   814: getfield 74	com/google/android/exoplayer2/source/b/f:aBX	Lcom/google/android/exoplayer2/i/q;
    //   817: new 340	com/google/android/exoplayer2/c/c/e
    //   820: dup
    //   821: iload_3
    //   822: aload 7
    //   824: invokespecial 343	com/google/android/exoplayer2/c/c/e:<init>	(ILjava/util/List;)V
    //   827: invokespecial 346	com/google/android/exoplayer2/c/c/t:<init>	(ILcom/google/android/exoplayer2/i/q;Lcom/google/android/exoplayer2/c/c/u$c;)V
    //   830: astore 7
    //   832: iconst_1
    //   833: istore_1
    //   834: goto -750 -> 84
    //   837: invokestatic 352	java/util/Collections:emptyList	()Ljava/util/List;
    //   840: astore 7
    //   842: goto -191 -> 651
    //   845: iload_2
    //   846: iconst_1
    //   847: iadd
    //   848: istore_2
    //   849: goto -158 -> 691
    //   852: aconst_null
    //   853: astore 8
    //   855: goto -137 -> 718
    //   858: iload_1
    //   859: iconst_1
    //   860: iadd
    //   861: istore_1
    //   862: goto -102 -> 760
    //   865: aload_0
    //   866: getfield 66	com/google/android/exoplayer2/source/b/f:aJO	Lcom/google/android/exoplayer2/h/i;
    //   869: aload_0
    //   870: getfield 354	com/google/android/exoplayer2/source/b/f:aJY	I
    //   873: i2l
    //   874: invokevirtual 358	com/google/android/exoplayer2/h/i:U	(J)Lcom/google/android/exoplayer2/h/i;
    //   877: astore 7
    //   879: new 200	com/google/android/exoplayer2/c/b
    //   882: dup
    //   883: aload_0
    //   884: getfield 125	com/google/android/exoplayer2/source/b/f:aJN	Lcom/google/android/exoplayer2/h/f;
    //   887: aload 7
    //   889: getfield 204	com/google/android/exoplayer2/h/i:aQV	J
    //   892: aload_0
    //   893: getfield 125	com/google/android/exoplayer2/source/b/f:aJN	Lcom/google/android/exoplayer2/h/f;
    //   896: aload 7
    //   898: invokeinterface 209 2 0
    //   903: invokespecial 212	com/google/android/exoplayer2/c/b:<init>	(Lcom/google/android/exoplayer2/h/f;JJ)V
    //   906: astore 7
    //   908: iconst_0
    //   909: istore_1
    //   910: iload_1
    //   911: ifne +25 -> 936
    //   914: aload_0
    //   915: getfield 151	com/google/android/exoplayer2/source/b/f:aJg	Z
    //   918: ifne +18 -> 936
    //   921: aload_0
    //   922: getfield 117	com/google/android/exoplayer2/source/b/f:aJX	Lcom/google/android/exoplayer2/c/d;
    //   925: aload 7
    //   927: invokeinterface 289 2 0
    //   932: istore_1
    //   933: goto -23 -> 910
    //   936: aload_0
    //   937: aload 7
    //   939: invokeinterface 361 1 0
    //   944: aload_0
    //   945: getfield 66	com/google/android/exoplayer2/source/b/f:aJO	Lcom/google/android/exoplayer2/h/i;
    //   948: getfield 204	com/google/android/exoplayer2/h/i:aQV	J
    //   951: lsub
    //   952: l2i
    //   953: putfield 354	com/google/android/exoplayer2/source/b/f:aJY	I
    //   956: aload_0
    //   957: getfield 77	com/google/android/exoplayer2/source/b/f:ayZ	Lcom/google/android/exoplayer2/h/f;
    //   960: invokestatic 366	com/google/android/exoplayer2/i/t:a	(Lcom/google/android/exoplayer2/h/f;)V
    //   963: aload_0
    //   964: iconst_1
    //   965: putfield 190	com/google/android/exoplayer2/source/b/f:aKa	Z
    //   968: goto -838 -> 130
    //   971: astore 8
    //   973: aload_0
    //   974: aload 7
    //   976: invokeinterface 361 1 0
    //   981: aload_0
    //   982: getfield 66	com/google/android/exoplayer2/source/b/f:aJO	Lcom/google/android/exoplayer2/h/i;
    //   985: getfield 204	com/google/android/exoplayer2/h/i:aQV	J
    //   988: lsub
    //   989: l2i
    //   990: putfield 354	com/google/android/exoplayer2/source/b/f:aJY	I
    //   993: aload 8
    //   995: athrow
    //   996: astore 7
    //   998: aload_0
    //   999: getfield 77	com/google/android/exoplayer2/source/b/f:ayZ	Lcom/google/android/exoplayer2/h/f;
    //   1002: invokestatic 366	com/google/android/exoplayer2/i/t:a	(Lcom/google/android/exoplayer2/h/f;)V
    //   1005: aload 7
    //   1007: athrow
    //   1008: iconst_0
    //   1009: istore_1
    //   1010: goto -851 -> 159
    //   1013: aload_0
    //   1014: getfield 193	com/google/android/exoplayer2/source/b/f:aJa	Lcom/google/android/exoplayer2/h/i;
    //   1017: aload_0
    //   1018: getfield 148	com/google/android/exoplayer2/source/b/f:aJZ	I
    //   1021: i2l
    //   1022: invokevirtual 358	com/google/android/exoplayer2/h/i:U	(J)Lcom/google/android/exoplayer2/h/i;
    //   1025: astore 7
    //   1027: iconst_0
    //   1028: istore_1
    //   1029: goto -870 -> 159
    //   1032: aload_0
    //   1033: getfield 74	com/google/android/exoplayer2/source/b/f:aBX	Lcom/google/android/exoplayer2/i/q;
    //   1036: getfield 369	com/google/android/exoplayer2/i/q:aDd	J
    //   1039: ldc2_w 370
    //   1042: lcmp
    //   1043: ifne -870 -> 173
    //   1046: aload_0
    //   1047: getfield 74	com/google/android/exoplayer2/source/b/f:aBX	Lcom/google/android/exoplayer2/i/q;
    //   1050: aload_0
    //   1051: getfield 374	com/google/android/exoplayer2/source/b/f:aJe	J
    //   1054: invokevirtual 377	com/google/android/exoplayer2/i/q:V	(J)V
    //   1057: goto -884 -> 173
    //   1060: iload_2
    //   1061: iconst_1
    //   1062: iadd
    //   1063: istore_2
    //   1064: goto -688 -> 376
    //   1067: ldc2_w 273
    //   1070: lstore 5
    //   1072: goto -616 -> 456
    //   1075: aload_0
    //   1076: getfield 374	com/google/android/exoplayer2/source/b/f:aJe	J
    //   1079: lstore 5
    //   1081: goto -605 -> 476
    //   1084: aload_0
    //   1085: getfield 95	com/google/android/exoplayer2/source/b/f:aJQ	Ljava/lang/String;
    //   1088: ldc 105
    //   1090: invokevirtual 103	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1093: ifne +15 -> 1108
    //   1096: aload_0
    //   1097: getfield 95	com/google/android/exoplayer2/source/b/f:aJQ	Ljava/lang/String;
    //   1100: ldc 107
    //   1102: invokevirtual 103	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1105: ifeq +29 -> 1134
    //   1108: new 379	com/google/android/exoplayer2/c/c/a
    //   1111: dup
    //   1112: lload 5
    //   1114: invokespecial 380	com/google/android/exoplayer2/c/c/a:<init>	(J)V
    //   1117: astore 7
    //   1119: goto -620 -> 499
    //   1122: astore 7
    //   1124: aload_0
    //   1125: getfield 77	com/google/android/exoplayer2/source/b/f:ayZ	Lcom/google/android/exoplayer2/h/f;
    //   1128: invokestatic 366	com/google/android/exoplayer2/i/t:a	(Lcom/google/android/exoplayer2/h/f;)V
    //   1131: aload 7
    //   1133: athrow
    //   1134: aload_0
    //   1135: getfield 95	com/google/android/exoplayer2/source/b/f:aJQ	Ljava/lang/String;
    //   1138: ldc 109
    //   1140: invokevirtual 103	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1143: ifeq +17 -> 1160
    //   1146: new 382	com/google/android/exoplayer2/c/a/b
    //   1149: dup
    //   1150: lload 5
    //   1152: invokespecial 383	com/google/android/exoplayer2/c/a/b:<init>	(J)V
    //   1155: astore 7
    //   1157: goto -658 -> 499
    //   1160: new 385	java/lang/IllegalArgumentException
    //   1163: dup
    //   1164: new 387	java/lang/StringBuilder
    //   1167: dup
    //   1168: ldc_w 389
    //   1171: invokespecial 392	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1174: aload_0
    //   1175: getfield 95	com/google/android/exoplayer2/source/b/f:aJQ	Ljava/lang/String;
    //   1178: invokevirtual 396	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1181: invokevirtual 399	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1184: invokespecial 400	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   1187: athrow
    //   1188: aload_0
    //   1189: aload 8
    //   1191: invokeinterface 361 1 0
    //   1196: aload_0
    //   1197: getfield 193	com/google/android/exoplayer2/source/b/f:aJa	Lcom/google/android/exoplayer2/h/i;
    //   1200: getfield 204	com/google/android/exoplayer2/h/i:aQV	J
    //   1203: lsub
    //   1204: l2i
    //   1205: putfield 148	com/google/android/exoplayer2/source/b/f:aJZ	I
    //   1208: aload_0
    //   1209: getfield 77	com/google/android/exoplayer2/source/b/f:ayZ	Lcom/google/android/exoplayer2/h/f;
    //   1212: invokestatic 366	com/google/android/exoplayer2/i/t:a	(Lcom/google/android/exoplayer2/h/f;)V
    //   1215: aload_0
    //   1216: iconst_1
    //   1217: putfield 402	com/google/android/exoplayer2/source/b/f:aKc	Z
    //   1220: return
    //   1221: astore 7
    //   1223: aload_0
    //   1224: aload 8
    //   1226: invokeinterface 361 1 0
    //   1231: aload_0
    //   1232: getfield 193	com/google/android/exoplayer2/source/b/f:aJa	Lcom/google/android/exoplayer2/h/i;
    //   1235: getfield 204	com/google/android/exoplayer2/h/i:aQV	J
    //   1238: lsub
    //   1239: l2i
    //   1240: putfield 148	com/google/android/exoplayer2/source/b/f:aJZ	I
    //   1243: aload 7
    //   1245: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1246	0	this	f
    //   83	946	1	i	int
    //   274	790	2	j	int
    //   279	543	3	k	int
    //   4	531	4	m	int
    //   454	697	5	l	long
    //   80	895	7	localObject1	Object
    //   996	10	7	localObject2	Object
    //   1025	93	7	localObject3	Object
    //   1122	10	7	localObject4	Object
    //   1155	1	7	localb	com.google.android.exoplayer2.c.a.b
    //   1221	23	7	localObject5	Object
    //   200	654	8	localObject6	Object
    //   971	254	8	localObject7	Object
    //   1	760	9	localObject8	Object
    //   658	112	10	localObject9	Object
    //   683	14	11	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   914	933	971	finally
    //   879	908	996	finally
    //   936	956	996	finally
    //   973	996	996	finally
    //   173	275	1122	finally
    //   280	324	1122	finally
    //   324	362	1122	finally
    //   367	374	1122	finally
    //   381	456	1122	finally
    //   465	476	1122	finally
    //   476	499	1122	finally
    //   499	516	1122	finally
    //   523	534	1122	finally
    //   1075	1081	1122	finally
    //   1084	1108	1122	finally
    //   1108	1119	1122	finally
    //   1134	1157	1122	finally
    //   1160	1188	1122	finally
    //   1188	1208	1122	finally
    //   1223	1246	1122	finally
    //   541	560	1221	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.f
 * JD-Core Version:    0.7.0.1
 */