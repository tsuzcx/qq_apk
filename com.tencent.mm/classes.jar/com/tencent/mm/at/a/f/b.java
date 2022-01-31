package com.tencent.mm.at.a.f;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.c.a;
import com.tencent.mm.at.a.c.d;
import com.tencent.mm.at.a.c.e;
import com.tencent.mm.at.a.c.f;
import com.tencent.mm.at.a.c.g;
import com.tencent.mm.at.a.c.i;
import com.tencent.mm.at.a.c.j;
import com.tencent.mm.at.a.c.k;
import com.tencent.mm.at.a.c.l;
import com.tencent.mm.at.a.c.m;
import com.tencent.mm.at.a.c.n;
import com.tencent.mm.at.a.c.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;

public final class b
  implements Runnable
{
  private final com.tencent.mm.at.a.a.b fGZ;
  private final com.tencent.mm.at.a.b fHE;
  public final com.tencent.mm.at.a.c fHG;
  private final ak fHH;
  private final i fHI;
  private final g fHJ;
  private final f fHK;
  private final k fHL;
  private final d fHM;
  private final l fHN;
  public final com.tencent.mm.at.a.a.c fHh;
  private final m fHi;
  private final a fHj;
  private final com.tencent.mm.at.a.c.b fHk;
  private final j fHm;
  private final e fHo;
  private final n fHr;
  private final o fHz;
  public final String url;
  
  public b(String paramString, com.tencent.mm.at.a.c paramc, ak paramak, com.tencent.mm.at.a.a.c paramc1, i parami, com.tencent.mm.at.a.b paramb, g paramg)
  {
    AppMethodBeat.i(116106);
    this.url = paramString;
    this.fHG = paramc;
    this.fHH = paramak;
    this.fHE = paramb;
    this.fHJ = paramg;
    this.fGZ = this.fHE.fGZ;
    if (paramc1 == null)
    {
      this.fHh = this.fGZ.fHh;
      this.fHI = parami;
      this.fHm = this.fGZ.fHm;
      if (this.fHh.fHk == null) {
        break label203;
      }
    }
    label203:
    for (this.fHk = this.fHh.fHk;; this.fHk = this.fGZ.fHk)
    {
      this.fHz = this.fHh.fHz;
      this.fHi = this.fGZ.fHi;
      this.fHj = this.fGZ.fHj;
      this.fHK = this.fGZ.fHl;
      this.fHL = this.fGZ.fHn;
      this.fHo = this.fGZ.fHo;
      this.fHM = null;
      this.fHN = null;
      this.fHr = this.fGZ.fHr;
      AppMethodBeat.o(116106);
      return;
      this.fHh = paramc1;
      break;
    }
  }
  
  private Bitmap a(com.tencent.mm.at.a.d.b paramb, Bitmap paramBitmap)
  {
    AppMethodBeat.i(116109);
    if ((this.fHJ != null) && (paramb != null))
    {
      paramb.bitmap = paramBitmap;
      paramb = this.fHJ.a(this.url, this.fHG.getImageView(), paramb);
      if ((paramb != null) && (!paramb.isRecycled()))
      {
        AppMethodBeat.o(116109);
        return paramb;
      }
    }
    AppMethodBeat.o(116109);
    return paramBitmap;
  }
  
  private void k(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(116108);
    if (this.fHh.eNK)
    {
      ab.d("MicroMsg.imageloader.ImageLoadTask", "[cpan] run. put key %s to memory cache.", new Object[] { this.url });
      this.fHi.c(paramString, paramBitmap);
    }
    AppMethodBeat.o(116108);
  }
  
  public final void gX(long paramLong)
  {
    AppMethodBeat.i(116111);
    if (this.fHm != null) {
      this.fHm.gX(paramLong);
    }
    AppMethodBeat.o(116111);
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: ldc 181
    //   2: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore 8
    //   8: new 125	com/tencent/mm/at/a/d/b
    //   11: dup
    //   12: invokespecial 182	com/tencent/mm/at/a/d/b:<init>	()V
    //   15: astore 10
    //   17: aload 10
    //   19: iconst_1
    //   20: putfield 186	com/tencent/mm/at/a/d/b:from	I
    //   23: aload_0
    //   24: aload_0
    //   25: getfield 58	com/tencent/mm/at/a/f/b:url	Ljava/lang/String;
    //   28: invokevirtual 190	com/tencent/mm/at/a/f/b:tH	(Ljava/lang/String;)Ljava/lang/String;
    //   31: astore 13
    //   33: ldc 155
    //   35: ldc 192
    //   37: iconst_1
    //   38: anewarray 4	java/lang/Object
    //   41: dup
    //   42: iconst_0
    //   43: aload_0
    //   44: getfield 58	com/tencent/mm/at/a/f/b:url	Ljava/lang/String;
    //   47: aastore
    //   48: invokestatic 163	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   51: invokestatic 198	java/lang/System:currentTimeMillis	()J
    //   54: lstore_3
    //   55: aload_0
    //   56: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   59: getfield 201	com/tencent/mm/at/a/a/c:fHt	I
    //   62: istore_2
    //   63: aload_0
    //   64: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   67: getfield 204	com/tencent/mm/at/a/a/c:eNU	Z
    //   70: istore 7
    //   72: aload_0
    //   73: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   76: getfield 207	com/tencent/mm/at/a/a/c:cqq	Ljava/lang/String;
    //   79: astore 14
    //   81: ldc 155
    //   83: ldc 209
    //   85: iload 7
    //   87: invokestatic 215	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   90: invokevirtual 218	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   93: invokestatic 221	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: ldc 155
    //   98: ldc 223
    //   100: iconst_1
    //   101: anewarray 4	java/lang/Object
    //   104: dup
    //   105: iconst_0
    //   106: iload_2
    //   107: invokestatic 228	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   110: aastore
    //   111: invokestatic 163	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   114: ldc 155
    //   116: ldc 230
    //   118: iconst_2
    //   119: anewarray 4	java/lang/Object
    //   122: dup
    //   123: iconst_0
    //   124: aload_0
    //   125: getfield 60	com/tencent/mm/at/a/f/b:fHG	Lcom/tencent/mm/at/a/c;
    //   128: getfield 233	com/tencent/mm/at/a/c:width	I
    //   131: invokestatic 228	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   134: aastore
    //   135: dup
    //   136: iconst_1
    //   137: aload_0
    //   138: getfield 60	com/tencent/mm/at/a/f/b:fHG	Lcom/tencent/mm/at/a/c;
    //   141: getfield 236	com/tencent/mm/at/a/c:height	I
    //   144: invokestatic 228	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   147: aastore
    //   148: invokestatic 163	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   151: iload_2
    //   152: tableswitch	default:+2365 -> 2517, 1:+286->438, 2:+1226->1378, 3:+1256->1408, 4:+1308->1460, 5:+994->1146
    //   189: iflt +4846 -> 5035
    //   192: iconst_1
    //   193: anewarray 4	java/lang/Object
    //   196: dup
    //   197: iconst_0
    //   198: iload_2
    //   199: invokestatic 228	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   202: aastore
    //   203: invokestatic 241	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   206: invokestatic 198	java/lang/System:currentTimeMillis	()J
    //   209: lstore 5
    //   211: aload 8
    //   213: ifnull +2307 -> 2520
    //   216: aload 8
    //   218: invokevirtual 146	android/graphics/Bitmap:isRecycled	()Z
    //   221: ifeq +1951 -> 2172
    //   224: goto +2296 -> 2520
    //   227: ldc 155
    //   229: ldc 243
    //   231: invokestatic 246	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   234: aload 10
    //   236: astore 9
    //   238: aload 8
    //   240: ifnull +2192 -> 2432
    //   243: aload 8
    //   245: invokevirtual 146	android/graphics/Bitmap:isRecycled	()Z
    //   248: ifne +2184 -> 2432
    //   251: ldc 155
    //   253: ldc 248
    //   255: invokestatic 221	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   258: aload 8
    //   260: astore 10
    //   262: aload_0
    //   263: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   266: getfield 251	com/tencent/mm/at/a/a/c:fHu	Z
    //   269: ifeq +17 -> 286
    //   272: aload 8
    //   274: aload_0
    //   275: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   278: getfield 254	com/tencent/mm/at/a/a/c:fHv	I
    //   281: invokestatic 260	com/tencent/mm/sdk/platformtools/d:g	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   284: astore 10
    //   286: aload 9
    //   288: getfield 263	com/tencent/mm/at/a/d/b:fHD	Z
    //   291: ifeq +2090 -> 2381
    //   294: aload_0
    //   295: getfield 64	com/tencent/mm/at/a/f/b:fHE	Lcom/tencent/mm/at/a/b;
    //   298: aload_0
    //   299: getfield 60	com/tencent/mm/at/a/f/b:fHG	Lcom/tencent/mm/at/a/c;
    //   302: invokevirtual 266	com/tencent/mm/at/a/b:a	(Lcom/tencent/mm/at/a/c;)V
    //   305: aload 9
    //   307: aload 10
    //   309: putfield 129	com/tencent/mm/at/a/d/b:bitmap	Landroid/graphics/Bitmap;
    //   312: aload 9
    //   314: iconst_0
    //   315: putfield 269	com/tencent/mm/at/a/d/b:status	I
    //   318: aload 10
    //   320: astore 8
    //   322: aload_0
    //   323: getfield 66	com/tencent/mm/at/a/f/b:fHJ	Lcom/tencent/mm/at/a/c/g;
    //   326: ifnull +37 -> 363
    //   329: aload 9
    //   331: ifnull +32 -> 363
    //   334: aload 9
    //   336: aload 8
    //   338: putfield 129	com/tencent/mm/at/a/d/b:bitmap	Landroid/graphics/Bitmap;
    //   341: aload_0
    //   342: getfield 66	com/tencent/mm/at/a/f/b:fHJ	Lcom/tencent/mm/at/a/c/g;
    //   345: aload_0
    //   346: getfield 58	com/tencent/mm/at/a/f/b:url	Ljava/lang/String;
    //   349: aload_0
    //   350: getfield 60	com/tencent/mm/at/a/f/b:fHG	Lcom/tencent/mm/at/a/c;
    //   353: invokevirtual 135	com/tencent/mm/at/a/c:getImageView	()Landroid/widget/ImageView;
    //   356: aload 9
    //   358: invokeinterface 273 4 0
    //   363: aload_0
    //   364: getfield 78	com/tencent/mm/at/a/f/b:fHI	Lcom/tencent/mm/at/a/c/i;
    //   367: aload_0
    //   368: getfield 58	com/tencent/mm/at/a/f/b:url	Ljava/lang/String;
    //   371: aload_0
    //   372: getfield 60	com/tencent/mm/at/a/f/b:fHG	Lcom/tencent/mm/at/a/c;
    //   375: invokevirtual 135	com/tencent/mm/at/a/c:getImageView	()Landroid/widget/ImageView;
    //   378: aload 8
    //   380: aload_0
    //   381: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   384: getfield 277	com/tencent/mm/at/a/a/c:eOi	[Ljava/lang/Object;
    //   387: invokeinterface 282 5 0
    //   392: aload_0
    //   393: getfield 64	com/tencent/mm/at/a/f/b:fHE	Lcom/tencent/mm/at/a/b;
    //   396: astore 8
    //   398: aload 8
    //   400: getfield 286	com/tencent/mm/at/a/b:fHd	Ljava/util/HashMap;
    //   403: ifnull +29 -> 432
    //   406: aload_0
    //   407: getfield 60	com/tencent/mm/at/a/f/b:fHG	Lcom/tencent/mm/at/a/c;
    //   410: ifnull +22 -> 432
    //   413: aload 8
    //   415: getfield 286	com/tencent/mm/at/a/b:fHd	Ljava/util/HashMap;
    //   418: aload_0
    //   419: getfield 60	com/tencent/mm/at/a/f/b:fHG	Lcom/tencent/mm/at/a/c;
    //   422: getfield 289	com/tencent/mm/at/a/c:eOR	I
    //   425: invokestatic 228	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   428: invokevirtual 295	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   431: pop
    //   432: ldc 181
    //   434: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   437: return
    //   438: aload_0
    //   439: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   442: getfield 298	com/tencent/mm/at/a/a/c:thumbPath	Ljava/lang/String;
    //   445: astore 9
    //   447: aload_0
    //   448: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   451: getfield 301	com/tencent/mm/at/a/a/c:fHw	Z
    //   454: ifeq +123 -> 577
    //   457: aload 9
    //   459: invokestatic 307	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   462: ifne +115 -> 577
    //   465: aload 9
    //   467: invokestatic 312	com/tencent/mm/vfs/e:cN	(Ljava/lang/String;)Z
    //   470: ifeq +107 -> 577
    //   473: aload_0
    //   474: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   477: getfield 315	com/tencent/mm/at/a/a/c:eOf	Z
    //   480: ifeq +69 -> 549
    //   483: aload_0
    //   484: getfield 60	com/tencent/mm/at/a/f/b:fHG	Lcom/tencent/mm/at/a/c;
    //   487: aload 9
    //   489: aload_0
    //   490: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   493: getfield 318	com/tencent/mm/at/a/a/c:eNS	I
    //   496: aload_0
    //   497: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   500: getfield 321	com/tencent/mm/at/a/a/c:eNT	I
    //   503: invokestatic 326	com/tencent/mm/at/a/g/a:b	(Lcom/tencent/mm/at/a/c;Ljava/lang/String;II)Landroid/graphics/Bitmap;
    //   506: astore 9
    //   508: aload 9
    //   510: astore 8
    //   512: aload 9
    //   514: astore 11
    //   516: aload_0
    //   517: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   520: getfield 329	com/tencent/mm/at/a/a/c:density	I
    //   523: ifle +1981 -> 2504
    //   526: aload 9
    //   528: astore 8
    //   530: aload 9
    //   532: aload_0
    //   533: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   536: getfield 329	com/tencent/mm/at/a/a/c:density	I
    //   539: invokevirtual 332	android/graphics/Bitmap:setDensity	(I)V
    //   542: aload 9
    //   544: astore 8
    //   546: goto -340 -> 206
    //   549: aload_0
    //   550: getfield 60	com/tencent/mm/at/a/f/b:fHG	Lcom/tencent/mm/at/a/c;
    //   553: aload 9
    //   555: aload_0
    //   556: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   559: getfield 318	com/tencent/mm/at/a/a/c:eNS	I
    //   562: aload_0
    //   563: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   566: getfield 321	com/tencent/mm/at/a/a/c:eNT	I
    //   569: invokestatic 334	com/tencent/mm/at/a/g/a:a	(Lcom/tencent/mm/at/a/c;Ljava/lang/String;II)Landroid/graphics/Bitmap;
    //   572: astore 9
    //   574: goto -66 -> 508
    //   577: aload_0
    //   578: getfield 58	com/tencent/mm/at/a/f/b:url	Ljava/lang/String;
    //   581: invokestatic 307	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   584: ifne +551 -> 1135
    //   587: aload_0
    //   588: getfield 58	com/tencent/mm/at/a/f/b:url	Ljava/lang/String;
    //   591: invokestatic 312	com/tencent/mm/vfs/e:cN	(Ljava/lang/String;)Z
    //   594: ifeq +530 -> 1124
    //   597: iload 7
    //   599: ifeq +21 -> 620
    //   602: aload_0
    //   603: getfield 105	com/tencent/mm/at/a/f/b:fHL	Lcom/tencent/mm/at/a/c/k;
    //   606: aload 14
    //   608: aload_0
    //   609: getfield 58	com/tencent/mm/at/a/f/b:url	Ljava/lang/String;
    //   612: invokeinterface 340 3 0
    //   617: ifeq +493 -> 1110
    //   620: aload_0
    //   621: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   624: getfield 315	com/tencent/mm/at/a/a/c:eOf	Z
    //   627: ifeq +168 -> 795
    //   630: aload_0
    //   631: getfield 60	com/tencent/mm/at/a/f/b:fHG	Lcom/tencent/mm/at/a/c;
    //   634: aload_0
    //   635: getfield 58	com/tencent/mm/at/a/f/b:url	Ljava/lang/String;
    //   638: aload_0
    //   639: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   642: getfield 318	com/tencent/mm/at/a/a/c:eNS	I
    //   645: aload_0
    //   646: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   649: getfield 321	com/tencent/mm/at/a/a/c:eNT	I
    //   652: invokestatic 326	com/tencent/mm/at/a/g/a:b	(Lcom/tencent/mm/at/a/c;Ljava/lang/String;II)Landroid/graphics/Bitmap;
    //   655: astore 9
    //   657: aload 9
    //   659: astore 11
    //   661: aload 9
    //   663: astore 8
    //   665: aload_0
    //   666: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   669: getfield 343	com/tencent/mm/at/a/a/c:eOm	Z
    //   672: ifeq +69 -> 741
    //   675: aload 9
    //   677: astore 11
    //   679: aload 9
    //   681: ifnonnull +60 -> 741
    //   684: aload 9
    //   686: astore 11
    //   688: aload 9
    //   690: astore 8
    //   692: aload_0
    //   693: getfield 112	com/tencent/mm/at/a/f/b:fHN	Lcom/tencent/mm/at/a/c/l;
    //   696: ifnull +45 -> 741
    //   699: aload 9
    //   701: astore 8
    //   703: aload_0
    //   704: getfield 110	com/tencent/mm/at/a/f/b:fHM	Lcom/tencent/mm/at/a/c/d;
    //   707: ifnull +381 -> 1088
    //   710: aload 9
    //   712: astore 8
    //   714: aload_0
    //   715: getfield 112	com/tencent/mm/at/a/f/b:fHN	Lcom/tencent/mm/at/a/c/l;
    //   718: aload_0
    //   719: getfield 110	com/tencent/mm/at/a/f/b:fHM	Lcom/tencent/mm/at/a/c/d;
    //   722: aload_0
    //   723: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   726: getfield 277	com/tencent/mm/at/a/a/c:eOi	[Ljava/lang/Object;
    //   729: invokeinterface 348 2 0
    //   734: invokeinterface 354 2 0
    //   739: astore 11
    //   741: aload 11
    //   743: ifnull +33 -> 776
    //   746: aload 11
    //   748: astore 8
    //   750: aload_0
    //   751: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   754: getfield 329	com/tencent/mm/at/a/a/c:density	I
    //   757: ifle +19 -> 776
    //   760: aload 11
    //   762: astore 8
    //   764: aload 11
    //   766: aload_0
    //   767: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   770: getfield 329	com/tencent/mm/at/a/a/c:density	I
    //   773: invokevirtual 332	android/graphics/Bitmap:setDensity	(I)V
    //   776: aload 11
    //   778: astore 8
    //   780: ldc 155
    //   782: ldc_w 356
    //   785: invokestatic 221	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   788: aload 11
    //   790: astore 8
    //   792: goto -586 -> 206
    //   795: aload_0
    //   796: getfield 89	com/tencent/mm/at/a/f/b:fHz	Lcom/tencent/mm/at/a/c/o;
    //   799: astore 8
    //   801: aload 8
    //   803: ifnull +185 -> 988
    //   806: aconst_null
    //   807: astore 9
    //   809: aload 9
    //   811: astore 8
    //   813: aload_0
    //   814: getfield 89	com/tencent/mm/at/a/f/b:fHz	Lcom/tencent/mm/at/a/c/o;
    //   817: astore 11
    //   819: aload 9
    //   821: astore 8
    //   823: new 358	com/tencent/mm/vfs/d
    //   826: dup
    //   827: aload_0
    //   828: getfield 58	com/tencent/mm/at/a/f/b:url	Ljava/lang/String;
    //   831: invokespecial 361	com/tencent/mm/vfs/d:<init>	(Ljava/lang/String;)V
    //   834: pop
    //   835: aload 9
    //   837: astore 8
    //   839: aload 11
    //   841: invokeinterface 367 1 0
    //   846: astore 12
    //   848: aload 12
    //   850: astore 8
    //   852: aload_0
    //   853: getfield 60	com/tencent/mm/at/a/f/b:fHG	Lcom/tencent/mm/at/a/c;
    //   856: aload 12
    //   858: aload_0
    //   859: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   862: getfield 318	com/tencent/mm/at/a/a/c:eNS	I
    //   865: aload_0
    //   866: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   869: getfield 321	com/tencent/mm/at/a/a/c:eNT	I
    //   872: aload_0
    //   873: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   876: getfield 370	com/tencent/mm/at/a/a/c:eNX	Z
    //   879: aload_0
    //   880: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   883: getfield 374	com/tencent/mm/at/a/a/c:alpha	F
    //   886: aload_0
    //   887: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   890: getfield 377	com/tencent/mm/at/a/a/c:eNV	Z
    //   893: invokestatic 380	com/tencent/mm/at/a/g/a:a	(Lcom/tencent/mm/at/a/c;Ljava/io/InputStream;IIZFZ)Landroid/graphics/Bitmap;
    //   896: astore 11
    //   898: aload 11
    //   900: astore 9
    //   902: aload 12
    //   904: ifnull -247 -> 657
    //   907: aload 11
    //   909: astore 8
    //   911: aload 12
    //   913: invokevirtual 385	java/io/InputStream:close	()V
    //   916: aload 11
    //   918: astore 9
    //   920: goto -263 -> 657
    //   923: astore 8
    //   925: aload 11
    //   927: astore 9
    //   929: goto -272 -> 657
    //   932: astore 9
    //   934: aload 8
    //   936: ifnull +8 -> 944
    //   939: aload 8
    //   941: invokevirtual 385	java/io/InputStream:close	()V
    //   944: ldc 181
    //   946: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   949: aload 9
    //   951: athrow
    //   952: astore 11
    //   954: aload 10
    //   956: astore 9
    //   958: aconst_null
    //   959: astore 8
    //   961: aload 11
    //   963: astore 10
    //   965: ldc 155
    //   967: ldc_w 387
    //   970: iconst_1
    //   971: anewarray 4	java/lang/Object
    //   974: dup
    //   975: iconst_0
    //   976: aload 10
    //   978: invokevirtual 391	java/lang/Exception:toString	()Ljava/lang/String;
    //   981: aastore
    //   982: invokestatic 241	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   985: goto -747 -> 238
    //   988: aload_0
    //   989: getfield 110	com/tencent/mm/at/a/f/b:fHM	Lcom/tencent/mm/at/a/c/d;
    //   992: ifnull +66 -> 1058
    //   995: aload_0
    //   996: getfield 60	com/tencent/mm/at/a/f/b:fHG	Lcom/tencent/mm/at/a/c;
    //   999: aload_0
    //   1000: getfield 110	com/tencent/mm/at/a/f/b:fHM	Lcom/tencent/mm/at/a/c/d;
    //   1003: aload_0
    //   1004: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   1007: getfield 277	com/tencent/mm/at/a/a/c:eOi	[Ljava/lang/Object;
    //   1010: invokeinterface 348 2 0
    //   1015: aload_0
    //   1016: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   1019: getfield 318	com/tencent/mm/at/a/a/c:eNS	I
    //   1022: aload_0
    //   1023: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   1026: getfield 321	com/tencent/mm/at/a/a/c:eNT	I
    //   1029: aload_0
    //   1030: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   1033: getfield 370	com/tencent/mm/at/a/a/c:eNX	Z
    //   1036: aload_0
    //   1037: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   1040: getfield 374	com/tencent/mm/at/a/a/c:alpha	F
    //   1043: aload_0
    //   1044: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   1047: getfield 377	com/tencent/mm/at/a/a/c:eNV	Z
    //   1050: invokestatic 394	com/tencent/mm/at/a/g/a:a	(Lcom/tencent/mm/at/a/c;[BIIZFZ)Landroid/graphics/Bitmap;
    //   1053: astore 9
    //   1055: goto -398 -> 657
    //   1058: aload_0
    //   1059: getfield 60	com/tencent/mm/at/a/f/b:fHG	Lcom/tencent/mm/at/a/c;
    //   1062: aload_0
    //   1063: getfield 58	com/tencent/mm/at/a/f/b:url	Ljava/lang/String;
    //   1066: aload_0
    //   1067: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   1070: getfield 318	com/tencent/mm/at/a/a/c:eNS	I
    //   1073: aload_0
    //   1074: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   1077: getfield 321	com/tencent/mm/at/a/a/c:eNT	I
    //   1080: invokestatic 334	com/tencent/mm/at/a/g/a:a	(Lcom/tencent/mm/at/a/c;Ljava/lang/String;II)Landroid/graphics/Bitmap;
    //   1083: astore 9
    //   1085: goto -428 -> 657
    //   1088: aload 9
    //   1090: astore 8
    //   1092: aload_0
    //   1093: getfield 112	com/tencent/mm/at/a/f/b:fHN	Lcom/tencent/mm/at/a/c/l;
    //   1096: aload_0
    //   1097: getfield 58	com/tencent/mm/at/a/f/b:url	Ljava/lang/String;
    //   1100: invokeinterface 398 2 0
    //   1105: astore 11
    //   1107: goto -366 -> 741
    //   1110: ldc 155
    //   1112: ldc_w 400
    //   1115: invokestatic 246	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1118: aconst_null
    //   1119: astore 8
    //   1121: goto -915 -> 206
    //   1124: ldc 155
    //   1126: ldc_w 402
    //   1129: invokestatic 246	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1132: goto -926 -> 206
    //   1135: ldc 155
    //   1137: ldc_w 404
    //   1140: invokestatic 246	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1143: goto -937 -> 206
    //   1146: aconst_null
    //   1147: astore 9
    //   1149: iconst_0
    //   1150: istore_1
    //   1151: aload_0
    //   1152: getfield 95	com/tencent/mm/at/a/f/b:fHj	Lcom/tencent/mm/at/a/c/a;
    //   1155: aload_0
    //   1156: getfield 58	com/tencent/mm/at/a/f/b:url	Ljava/lang/String;
    //   1159: aload_0
    //   1160: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   1163: invokeinterface 409 3 0
    //   1168: astore 11
    //   1170: aload 11
    //   1172: ifnull +1339 -> 2511
    //   1175: iload 7
    //   1177: ifeq +23 -> 1200
    //   1180: aload 11
    //   1182: astore 9
    //   1184: aload_0
    //   1185: getfield 105	com/tencent/mm/at/a/f/b:fHL	Lcom/tencent/mm/at/a/c/k;
    //   1188: aload 14
    //   1190: aload 11
    //   1192: invokeinterface 412 3 0
    //   1197: ifeq +153 -> 1350
    //   1200: aload 11
    //   1202: astore 8
    //   1204: aload 11
    //   1206: astore 9
    //   1208: aload_0
    //   1209: getfield 89	com/tencent/mm/at/a/f/b:fHz	Lcom/tencent/mm/at/a/c/o;
    //   1212: ifnull +18 -> 1230
    //   1215: aload 11
    //   1217: astore 9
    //   1219: aload_0
    //   1220: getfield 89	com/tencent/mm/at/a/f/b:fHz	Lcom/tencent/mm/at/a/c/o;
    //   1223: invokeinterface 367 1 0
    //   1228: astore 8
    //   1230: aload 8
    //   1232: astore 9
    //   1234: aload_0
    //   1235: getfield 60	com/tencent/mm/at/a/f/b:fHG	Lcom/tencent/mm/at/a/c;
    //   1238: aload 8
    //   1240: aload_0
    //   1241: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   1244: getfield 318	com/tencent/mm/at/a/a/c:eNS	I
    //   1247: aload_0
    //   1248: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   1251: getfield 321	com/tencent/mm/at/a/a/c:eNT	I
    //   1254: aload_0
    //   1255: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   1258: getfield 370	com/tencent/mm/at/a/a/c:eNX	Z
    //   1261: aload_0
    //   1262: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   1265: getfield 374	com/tencent/mm/at/a/a/c:alpha	F
    //   1268: aload_0
    //   1269: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   1272: getfield 377	com/tencent/mm/at/a/a/c:eNV	Z
    //   1275: invokestatic 380	com/tencent/mm/at/a/g/a:a	(Lcom/tencent/mm/at/a/c;Ljava/io/InputStream;IIZFZ)Landroid/graphics/Bitmap;
    //   1278: astore 11
    //   1280: aload 11
    //   1282: astore 9
    //   1284: iconst_1
    //   1285: istore_1
    //   1286: aload 8
    //   1288: astore 11
    //   1290: aload 11
    //   1292: ifnull +12 -> 1304
    //   1295: aload 9
    //   1297: astore 8
    //   1299: aload 11
    //   1301: invokevirtual 385	java/io/InputStream:close	()V
    //   1304: aload 9
    //   1306: astore 11
    //   1308: iload_1
    //   1309: ifeq +1195 -> 2504
    //   1312: aload 9
    //   1314: astore 11
    //   1316: aload 9
    //   1318: ifnonnull +1186 -> 2504
    //   1321: aload 9
    //   1323: astore 8
    //   1325: aload_0
    //   1326: getfield 95	com/tencent/mm/at/a/f/b:fHj	Lcom/tencent/mm/at/a/c/a;
    //   1329: aload_0
    //   1330: getfield 58	com/tencent/mm/at/a/f/b:url	Ljava/lang/String;
    //   1333: aload_0
    //   1334: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   1337: invokeinterface 415 3 0
    //   1342: pop
    //   1343: aload 9
    //   1345: astore 8
    //   1347: goto -1141 -> 206
    //   1350: iconst_1
    //   1351: istore_1
    //   1352: aconst_null
    //   1353: astore 9
    //   1355: goto -65 -> 1290
    //   1358: astore 8
    //   1360: aload 9
    //   1362: ifnull +8 -> 1370
    //   1365: aload 9
    //   1367: invokevirtual 385	java/io/InputStream:close	()V
    //   1370: ldc 181
    //   1372: invokestatic 118	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1375: aload 8
    //   1377: athrow
    //   1378: aload_0
    //   1379: getfield 60	com/tencent/mm/at/a/f/b:fHG	Lcom/tencent/mm/at/a/c;
    //   1382: aload_0
    //   1383: getfield 58	com/tencent/mm/at/a/f/b:url	Ljava/lang/String;
    //   1386: aload_0
    //   1387: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   1390: getfield 318	com/tencent/mm/at/a/a/c:eNS	I
    //   1393: aload_0
    //   1394: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   1397: getfield 321	com/tencent/mm/at/a/a/c:eNT	I
    //   1400: invokestatic 417	com/tencent/mm/at/a/g/a:c	(Lcom/tencent/mm/at/a/c;Ljava/lang/String;II)Landroid/graphics/Bitmap;
    //   1403: astore 8
    //   1405: goto -1199 -> 206
    //   1408: aload_0
    //   1409: getfield 71	com/tencent/mm/at/a/f/b:fGZ	Lcom/tencent/mm/at/a/a/b;
    //   1412: getfield 421	com/tencent/mm/at/a/a/b:eTW	Landroid/content/res/Resources;
    //   1415: aload_0
    //   1416: getfield 58	com/tencent/mm/at/a/f/b:url	Ljava/lang/String;
    //   1419: ldc_w 423
    //   1422: aload_0
    //   1423: getfield 71	com/tencent/mm/at/a/f/b:fGZ	Lcom/tencent/mm/at/a/a/b;
    //   1426: getfield 426	com/tencent/mm/at/a/a/b:packageName	Ljava/lang/String;
    //   1429: invokevirtual 432	android/content/res/Resources:getIdentifier	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   1432: istore_1
    //   1433: aload_0
    //   1434: getfield 60	com/tencent/mm/at/a/f/b:fHG	Lcom/tencent/mm/at/a/c;
    //   1437: iload_1
    //   1438: aload_0
    //   1439: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   1442: getfield 318	com/tencent/mm/at/a/a/c:eNS	I
    //   1445: aload_0
    //   1446: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   1449: getfield 321	com/tencent/mm/at/a/a/c:eNT	I
    //   1452: invokestatic 435	com/tencent/mm/at/a/g/a:a	(Lcom/tencent/mm/at/a/c;III)Landroid/graphics/Bitmap;
    //   1455: astore 8
    //   1457: goto -1251 -> 206
    //   1460: aload_0
    //   1461: getfield 58	com/tencent/mm/at/a/f/b:url	Ljava/lang/String;
    //   1464: invokestatic 438	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1467: invokevirtual 442	java/lang/Integer:intValue	()I
    //   1470: istore_1
    //   1471: aload_0
    //   1472: getfield 60	com/tencent/mm/at/a/f/b:fHG	Lcom/tencent/mm/at/a/c;
    //   1475: iload_1
    //   1476: aload_0
    //   1477: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   1480: getfield 318	com/tencent/mm/at/a/a/c:eNS	I
    //   1483: aload_0
    //   1484: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   1487: getfield 321	com/tencent/mm/at/a/a/c:eNT	I
    //   1490: invokestatic 435	com/tencent/mm/at/a/g/a:a	(Lcom/tencent/mm/at/a/c;III)Landroid/graphics/Bitmap;
    //   1493: astore 8
    //   1495: goto -1289 -> 206
    //   1498: invokestatic 198	java/lang/System:currentTimeMillis	()J
    //   1501: lstore_3
    //   1502: ldc 155
    //   1504: ldc_w 444
    //   1507: invokestatic 221	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1510: aload_0
    //   1511: getfield 66	com/tencent/mm/at/a/f/b:fHJ	Lcom/tencent/mm/at/a/c/g;
    //   1514: ifnull +32 -> 1546
    //   1517: aload_0
    //   1518: getfield 66	com/tencent/mm/at/a/f/b:fHJ	Lcom/tencent/mm/at/a/c/g;
    //   1521: astore 9
    //   1523: aload_0
    //   1524: getfield 58	com/tencent/mm/at/a/f/b:url	Ljava/lang/String;
    //   1527: astore 11
    //   1529: aload_0
    //   1530: getfield 60	com/tencent/mm/at/a/f/b:fHG	Lcom/tencent/mm/at/a/c;
    //   1533: invokevirtual 135	com/tencent/mm/at/a/c:getImageView	()Landroid/widget/ImageView;
    //   1536: pop
    //   1537: aload 9
    //   1539: aload 11
    //   1541: invokeinterface 447 2 0
    //   1546: aload_0
    //   1547: getfield 115	com/tencent/mm/at/a/f/b:fHr	Lcom/tencent/mm/at/a/c/n;
    //   1550: aload_0
    //   1551: getfield 58	com/tencent/mm/at/a/f/b:url	Ljava/lang/String;
    //   1554: invokeinterface 452 2 0
    //   1559: ifeq +61 -> 1620
    //   1562: aload_0
    //   1563: getfield 86	com/tencent/mm/at/a/f/b:fHk	Lcom/tencent/mm/at/a/c/b;
    //   1566: aload_0
    //   1567: getfield 58	com/tencent/mm/at/a/f/b:url	Ljava/lang/String;
    //   1570: invokeinterface 458 2 0
    //   1575: astore 9
    //   1577: aload 9
    //   1579: ifnonnull +922 -> 2501
    //   1582: new 125	com/tencent/mm/at/a/d/b
    //   1585: dup
    //   1586: aconst_null
    //   1587: aconst_null
    //   1588: invokespecial 461	com/tencent/mm/at/a/d/b:<init>	([BLjava/lang/String;)V
    //   1591: astore 10
    //   1593: aload 10
    //   1595: astore 9
    //   1597: aload 9
    //   1599: iconst_2
    //   1600: putfield 186	com/tencent/mm/at/a/d/b:from	I
    //   1603: aload 9
    //   1605: getfield 465	com/tencent/mm/at/a/d/b:data	[B
    //   1608: ifnonnull +27 -> 1635
    //   1611: aload 9
    //   1613: iconst_1
    //   1614: putfield 269	com/tencent/mm/at/a/d/b:status	I
    //   1617: goto -1379 -> 238
    //   1620: ldc 155
    //   1622: ldc_w 467
    //   1625: invokestatic 469	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1628: aload 10
    //   1630: astore 9
    //   1632: goto -55 -> 1577
    //   1635: iload 7
    //   1637: ifeq +22 -> 1659
    //   1640: aload_0
    //   1641: getfield 105	com/tencent/mm/at/a/f/b:fHL	Lcom/tencent/mm/at/a/c/k;
    //   1644: aload 14
    //   1646: aload 9
    //   1648: getfield 465	com/tencent/mm/at/a/d/b:data	[B
    //   1651: invokeinterface 473 3 0
    //   1656: ifeq +481 -> 2137
    //   1659: ldc 155
    //   1661: ldc_w 475
    //   1664: invokestatic 221	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1667: invokestatic 198	java/lang/System:currentTimeMillis	()J
    //   1670: lstore 5
    //   1672: aload 9
    //   1674: getfield 465	com/tencent/mm/at/a/d/b:data	[B
    //   1677: astore 11
    //   1679: aload 11
    //   1681: astore 10
    //   1683: aload_0
    //   1684: getfield 89	com/tencent/mm/at/a/f/b:fHz	Lcom/tencent/mm/at/a/c/o;
    //   1687: ifnull +78 -> 1765
    //   1690: aload_0
    //   1691: getfield 89	com/tencent/mm/at/a/f/b:fHz	Lcom/tencent/mm/at/a/c/o;
    //   1694: astore 10
    //   1696: new 477	java/io/ByteArrayInputStream
    //   1699: dup
    //   1700: aload 11
    //   1702: invokespecial 480	java/io/ByteArrayInputStream:<init>	([B)V
    //   1705: pop
    //   1706: aload 10
    //   1708: invokeinterface 367 1 0
    //   1713: astore 10
    //   1715: new 482	java/io/ByteArrayOutputStream
    //   1718: dup
    //   1719: aload 11
    //   1721: arraylength
    //   1722: invokespecial 484	java/io/ByteArrayOutputStream:<init>	(I)V
    //   1725: astore 11
    //   1727: sipush 1024
    //   1730: newarray byte
    //   1732: astore 12
    //   1734: aload 10
    //   1736: aload 12
    //   1738: invokevirtual 488	java/io/InputStream:read	([B)I
    //   1741: istore_1
    //   1742: iload_1
    //   1743: iflt +15 -> 1758
    //   1746: aload 11
    //   1748: aload 12
    //   1750: iconst_0
    //   1751: iload_1
    //   1752: invokevirtual 492	java/io/ByteArrayOutputStream:write	([BII)V
    //   1755: goto -21 -> 1734
    //   1758: aload 11
    //   1760: invokevirtual 496	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   1763: astore 10
    //   1765: aload_0
    //   1766: getfield 60	com/tencent/mm/at/a/f/b:fHG	Lcom/tencent/mm/at/a/c;
    //   1769: aload 10
    //   1771: aload_0
    //   1772: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   1775: getfield 318	com/tencent/mm/at/a/a/c:eNS	I
    //   1778: aload_0
    //   1779: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   1782: getfield 321	com/tencent/mm/at/a/a/c:eNT	I
    //   1785: aload_0
    //   1786: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   1789: getfield 370	com/tencent/mm/at/a/a/c:eNX	Z
    //   1792: aload_0
    //   1793: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   1796: getfield 374	com/tencent/mm/at/a/a/c:alpha	F
    //   1799: aload_0
    //   1800: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   1803: getfield 377	com/tencent/mm/at/a/a/c:eNV	Z
    //   1806: invokestatic 394	com/tencent/mm/at/a/g/a:a	(Lcom/tencent/mm/at/a/c;[BIIZFZ)Landroid/graphics/Bitmap;
    //   1809: astore 11
    //   1811: aload 11
    //   1813: ifnonnull +20 -> 1833
    //   1816: aload 11
    //   1818: astore 8
    //   1820: aload 9
    //   1822: iconst_3
    //   1823: putfield 269	com/tencent/mm/at/a/d/b:status	I
    //   1826: aload 11
    //   1828: astore 8
    //   1830: goto -1592 -> 238
    //   1833: aload 11
    //   1835: astore 8
    //   1837: aload 9
    //   1839: getfield 465	com/tencent/mm/at/a/d/b:data	[B
    //   1842: astore 10
    //   1844: aload 11
    //   1846: astore 8
    //   1848: aload_0
    //   1849: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   1852: getfield 499	com/tencent/mm/at/a/a/c:eNM	Z
    //   1855: ifeq +27 -> 1882
    //   1858: aload 11
    //   1860: astore 8
    //   1862: aload_0
    //   1863: getfield 95	com/tencent/mm/at/a/f/b:fHj	Lcom/tencent/mm/at/a/c/a;
    //   1866: aload_0
    //   1867: getfield 58	com/tencent/mm/at/a/f/b:url	Ljava/lang/String;
    //   1870: aload 10
    //   1872: aload_0
    //   1873: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   1876: invokeinterface 502 4 0
    //   1881: pop
    //   1882: aload 11
    //   1884: astore 8
    //   1886: aload_0
    //   1887: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   1890: getfield 505	com/tencent/mm/at/a/a/c:eNL	Z
    //   1893: ifeq +27 -> 1920
    //   1896: aload 11
    //   1898: astore 8
    //   1900: aload_0
    //   1901: getfield 95	com/tencent/mm/at/a/f/b:fHj	Lcom/tencent/mm/at/a/c/a;
    //   1904: aload_0
    //   1905: getfield 58	com/tencent/mm/at/a/f/b:url	Ljava/lang/String;
    //   1908: aload 10
    //   1910: aload_0
    //   1911: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   1914: invokeinterface 502 4 0
    //   1919: pop
    //   1920: aload 11
    //   1922: astore 10
    //   1924: aload 11
    //   1926: astore 8
    //   1928: aload_0
    //   1929: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   1932: getfield 508	com/tencent/mm/at/a/a/c:eOk	Z
    //   1935: ifeq +56 -> 1991
    //   1938: aload 11
    //   1940: astore 8
    //   1942: aload_0
    //   1943: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   1946: getfield 511	com/tencent/mm/at/a/a/c:eOl	F
    //   1949: fconst_0
    //   1950: fcmpl
    //   1951: ifne +164 -> 2115
    //   1954: aload 11
    //   1956: astore 8
    //   1958: aload 11
    //   1960: invokevirtual 514	android/graphics/Bitmap:getWidth	()I
    //   1963: aload 11
    //   1965: invokevirtual 517	android/graphics/Bitmap:getHeight	()I
    //   1968: if_icmpne +68 -> 2036
    //   1971: aload 11
    //   1973: astore 8
    //   1975: aload 11
    //   1977: iconst_0
    //   1978: aload 11
    //   1980: invokevirtual 514	android/graphics/Bitmap:getWidth	()I
    //   1983: iconst_2
    //   1984: idiv
    //   1985: i2f
    //   1986: invokestatic 520	com/tencent/mm/sdk/platformtools/d:a	(Landroid/graphics/Bitmap;ZF)Landroid/graphics/Bitmap;
    //   1989: astore 10
    //   1991: aload 10
    //   1993: astore 8
    //   1995: aload_0
    //   1996: aload 9
    //   1998: aload 10
    //   2000: invokespecial 522	com/tencent/mm/at/a/f/b:a	(Lcom/tencent/mm/at/a/d/b;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   2003: astore 10
    //   2005: aload 10
    //   2007: astore 8
    //   2009: aload_0
    //   2010: aload 13
    //   2012: aload 10
    //   2014: invokespecial 524	com/tencent/mm/at/a/f/b:k	(Ljava/lang/String;Landroid/graphics/Bitmap;)V
    //   2017: aload 10
    //   2019: astore 8
    //   2021: aload_0
    //   2022: lload 5
    //   2024: lload_3
    //   2025: lsub
    //   2026: invokevirtual 525	com/tencent/mm/at/a/f/b:gX	(J)V
    //   2029: aload 10
    //   2031: astore 8
    //   2033: goto -1795 -> 238
    //   2036: aload 11
    //   2038: astore 8
    //   2040: aload 11
    //   2042: invokevirtual 514	android/graphics/Bitmap:getWidth	()I
    //   2045: aload 11
    //   2047: invokevirtual 517	android/graphics/Bitmap:getHeight	()I
    //   2050: invokestatic 531	java/lang/Math:min	(II)I
    //   2053: istore_2
    //   2054: iload_2
    //   2055: istore_1
    //   2056: iload_2
    //   2057: ifgt +21 -> 2078
    //   2060: aload 11
    //   2062: astore 8
    //   2064: aload 11
    //   2066: invokevirtual 514	android/graphics/Bitmap:getWidth	()I
    //   2069: aload 11
    //   2071: invokevirtual 517	android/graphics/Bitmap:getHeight	()I
    //   2074: invokestatic 534	java/lang/Math:max	(II)I
    //   2077: istore_1
    //   2078: aload 11
    //   2080: astore 8
    //   2082: aload 11
    //   2084: iload_1
    //   2085: iload_1
    //   2086: iconst_1
    //   2087: invokestatic 537	com/tencent/mm/sdk/platformtools/d:b	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   2090: astore 10
    //   2092: aload 10
    //   2094: astore 8
    //   2096: aload 10
    //   2098: iconst_0
    //   2099: aload 10
    //   2101: invokevirtual 514	android/graphics/Bitmap:getWidth	()I
    //   2104: iconst_2
    //   2105: idiv
    //   2106: i2f
    //   2107: invokestatic 520	com/tencent/mm/sdk/platformtools/d:a	(Landroid/graphics/Bitmap;ZF)Landroid/graphics/Bitmap;
    //   2110: astore 10
    //   2112: goto -121 -> 1991
    //   2115: aload 11
    //   2117: astore 8
    //   2119: aload 11
    //   2121: iconst_0
    //   2122: aload_0
    //   2123: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   2126: getfield 511	com/tencent/mm/at/a/a/c:eOl	F
    //   2129: invokestatic 520	com/tencent/mm/sdk/platformtools/d:a	(Landroid/graphics/Bitmap;ZF)Landroid/graphics/Bitmap;
    //   2132: astore 10
    //   2134: goto -143 -> 1991
    //   2137: aload 9
    //   2139: iconst_2
    //   2140: putfield 269	com/tencent/mm/at/a/d/b:status	I
    //   2143: ldc 155
    //   2145: ldc_w 539
    //   2148: invokestatic 246	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   2151: aconst_null
    //   2152: astore 8
    //   2154: goto -1916 -> 238
    //   2157: ldc 155
    //   2159: ldc_w 541
    //   2162: invokestatic 246	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   2165: aload 10
    //   2167: astore 9
    //   2169: goto -1931 -> 238
    //   2172: aload_0
    //   2173: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   2176: getfield 508	com/tencent/mm/at/a/a/c:eOk	Z
    //   2179: ifeq +315 -> 2494
    //   2182: aload_0
    //   2183: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   2186: getfield 511	com/tencent/mm/at/a/a/c:eOl	F
    //   2189: fconst_0
    //   2190: fcmpl
    //   2191: ifne +172 -> 2363
    //   2194: aload 8
    //   2196: invokevirtual 514	android/graphics/Bitmap:getWidth	()I
    //   2199: aload 8
    //   2201: invokevirtual 517	android/graphics/Bitmap:getHeight	()I
    //   2204: if_icmpne +92 -> 2296
    //   2207: aload 8
    //   2209: iconst_0
    //   2210: aload 8
    //   2212: invokevirtual 514	android/graphics/Bitmap:getWidth	()I
    //   2215: iconst_2
    //   2216: idiv
    //   2217: i2f
    //   2218: invokestatic 520	com/tencent/mm/sdk/platformtools/d:a	(Landroid/graphics/Bitmap;ZF)Landroid/graphics/Bitmap;
    //   2221: astore 9
    //   2223: aload 9
    //   2225: astore 8
    //   2227: aload_0
    //   2228: aload 10
    //   2230: aload 9
    //   2232: invokespecial 522	com/tencent/mm/at/a/f/b:a	(Lcom/tencent/mm/at/a/d/b;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   2235: astore 9
    //   2237: aload 9
    //   2239: astore 8
    //   2241: aload 10
    //   2243: getfield 544	com/tencent/mm/at/a/d/b:fHC	Z
    //   2246: ifne +15 -> 2261
    //   2249: aload 9
    //   2251: astore 8
    //   2253: aload_0
    //   2254: aload 13
    //   2256: aload 9
    //   2258: invokespecial 524	com/tencent/mm/at/a/f/b:k	(Ljava/lang/String;Landroid/graphics/Bitmap;)V
    //   2261: aload 9
    //   2263: astore 8
    //   2265: aload_0
    //   2266: lload 5
    //   2268: lload_3
    //   2269: lsub
    //   2270: invokevirtual 525	com/tencent/mm/at/a/f/b:gX	(J)V
    //   2273: aload 9
    //   2275: astore 8
    //   2277: ldc 155
    //   2279: ldc_w 546
    //   2282: invokestatic 221	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   2285: aload 9
    //   2287: astore 8
    //   2289: aload 10
    //   2291: astore 9
    //   2293: goto -2055 -> 238
    //   2296: aload 8
    //   2298: invokevirtual 514	android/graphics/Bitmap:getWidth	()I
    //   2301: aload 8
    //   2303: invokevirtual 517	android/graphics/Bitmap:getHeight	()I
    //   2306: invokestatic 531	java/lang/Math:min	(II)I
    //   2309: istore_2
    //   2310: iload_2
    //   2311: istore_1
    //   2312: iload_2
    //   2313: ifgt +17 -> 2330
    //   2316: aload 8
    //   2318: invokevirtual 514	android/graphics/Bitmap:getWidth	()I
    //   2321: aload 8
    //   2323: invokevirtual 517	android/graphics/Bitmap:getHeight	()I
    //   2326: invokestatic 534	java/lang/Math:max	(II)I
    //   2329: istore_1
    //   2330: aload 8
    //   2332: iload_1
    //   2333: iload_1
    //   2334: iconst_1
    //   2335: invokestatic 537	com/tencent/mm/sdk/platformtools/d:b	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   2338: astore 9
    //   2340: aload 9
    //   2342: astore 8
    //   2344: aload 9
    //   2346: iconst_0
    //   2347: aload 9
    //   2349: invokevirtual 514	android/graphics/Bitmap:getWidth	()I
    //   2352: iconst_2
    //   2353: idiv
    //   2354: i2f
    //   2355: invokestatic 520	com/tencent/mm/sdk/platformtools/d:a	(Landroid/graphics/Bitmap;ZF)Landroid/graphics/Bitmap;
    //   2358: astore 9
    //   2360: goto -137 -> 2223
    //   2363: aload 8
    //   2365: iconst_0
    //   2366: aload_0
    //   2367: getfield 76	com/tencent/mm/at/a/f/b:fHh	Lcom/tencent/mm/at/a/a/c;
    //   2370: getfield 511	com/tencent/mm/at/a/a/c:eOl	F
    //   2373: invokestatic 520	com/tencent/mm/sdk/platformtools/d:a	(Landroid/graphics/Bitmap;ZF)Landroid/graphics/Bitmap;
    //   2376: astore 9
    //   2378: goto -155 -> 2223
    //   2381: new 548	com/tencent/mm/at/a/f/c
    //   2384: dup
    //   2385: aload_0
    //   2386: getfield 58	com/tencent/mm/at/a/f/b:url	Ljava/lang/String;
    //   2389: aload_0
    //   2390: getfield 60	com/tencent/mm/at/a/f/b:fHG	Lcom/tencent/mm/at/a/c;
    //   2393: aload 10
    //   2395: aload_0
    //   2396: getfield 64	com/tencent/mm/at/a/f/b:fHE	Lcom/tencent/mm/at/a/b;
    //   2399: aload_0
    //   2400: aload_0
    //   2401: getfield 58	com/tencent/mm/at/a/f/b:url	Ljava/lang/String;
    //   2404: invokevirtual 190	com/tencent/mm/at/a/f/b:tH	(Ljava/lang/String;)Ljava/lang/String;
    //   2407: invokespecial 551	com/tencent/mm/at/a/f/c:<init>	(Ljava/lang/String;Lcom/tencent/mm/at/a/c;Landroid/graphics/Bitmap;Lcom/tencent/mm/at/a/b;Ljava/lang/String;)V
    //   2410: astore 8
    //   2412: aload_0
    //   2413: getfield 62	com/tencent/mm/at/a/f/b:fHH	Lcom/tencent/mm/sdk/platformtools/ak;
    //   2416: ifnull -2111 -> 305
    //   2419: aload_0
    //   2420: getfield 62	com/tencent/mm/at/a/f/b:fHH	Lcom/tencent/mm/sdk/platformtools/ak;
    //   2423: aload 8
    //   2425: invokevirtual 557	com/tencent/mm/sdk/platformtools/ak:post	(Ljava/lang/Runnable;)Z
    //   2428: pop
    //   2429: goto -2124 -> 305
    //   2432: ldc 155
    //   2434: ldc_w 559
    //   2437: invokestatic 246	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   2440: goto -2118 -> 322
    //   2443: astore 8
    //   2445: goto -1501 -> 944
    //   2448: astore 8
    //   2450: goto -1146 -> 1304
    //   2453: astore 9
    //   2455: goto -1085 -> 1370
    //   2458: astore 11
    //   2460: aload 10
    //   2462: astore 9
    //   2464: aload 11
    //   2466: astore 10
    //   2468: goto -1503 -> 965
    //   2471: astore 11
    //   2473: aload 10
    //   2475: astore 9
    //   2477: aload 11
    //   2479: astore 10
    //   2481: goto -1516 -> 965
    //   2484: astore 10
    //   2486: goto -1521 -> 965
    //   2489: astore 10
    //   2491: goto -1526 -> 965
    //   2494: aload 8
    //   2496: astore 9
    //   2498: goto -275 -> 2223
    //   2501: goto -904 -> 1597
    //   2504: aload 11
    //   2506: astore 8
    //   2508: goto -2302 -> 206
    //   2511: aconst_null
    //   2512: astore 9
    //   2514: goto -1224 -> 1290
    //   2517: goto -2329 -> 188
    //   2520: iload_2
    //   2521: tableswitch	default:+35 -> 2556, 1:+-364->2157, 2:+-364->2157, 3:+-364->2157, 4:+-364->2157, 5:+-1023->1498
    //   2557: <illegal opcode>
    //   2558: <illegal opcode>
    //   2559: astore 10
    //   2561: goto -1596 -> 965
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2564	0	this	b
    //   1150	1184	1	i	int
    //   62	2459	2	j	int
    //   54	2215	3	l1	long
    //   209	2058	5	l2	long
    //   70	1566	7	bool	boolean
    //   6	904	8	localObject1	Object
    //   923	17	8	localIOException1	java.io.IOException
    //   959	387	8	localObject2	Object
    //   1358	18	8	localObject3	Object
    //   1403	1021	8	localObject4	Object
    //   2443	1	8	localIOException2	java.io.IOException
    //   2448	47	8	localIOException3	java.io.IOException
    //   2506	1	8	localObject5	Object
    //   236	692	9	localObject6	Object
    //   932	18	9	localObject7	Object
    //   956	1421	9	localObject8	Object
    //   2453	1	9	localIOException4	java.io.IOException
    //   2462	51	9	localObject9	Object
    //   15	2465	10	localObject10	Object
    //   2484	1	10	localException1	java.lang.Exception
    //   2489	1	10	localException2	java.lang.Exception
    //   2559	1	10	localException3	java.lang.Exception
    //   514	412	11	localObject11	Object
    //   952	10	11	localException4	java.lang.Exception
    //   1105	1015	11	localObject12	Object
    //   2458	7	11	localException5	java.lang.Exception
    //   2471	34	11	localException6	java.lang.Exception
    //   846	903	12	localObject13	Object
    //   31	2224	13	str1	String
    //   79	1566	14	str2	String
    // Exception table:
    //   from	to	target	type
    //   911	916	923	java/io/IOException
    //   813	819	932	finally
    //   823	835	932	finally
    //   839	848	932	finally
    //   852	898	932	finally
    //   23	151	952	java/lang/Exception
    //   188	206	952	java/lang/Exception
    //   438	508	952	java/lang/Exception
    //   549	574	952	java/lang/Exception
    //   577	597	952	java/lang/Exception
    //   602	620	952	java/lang/Exception
    //   620	657	952	java/lang/Exception
    //   795	801	952	java/lang/Exception
    //   939	944	952	java/lang/Exception
    //   944	952	952	java/lang/Exception
    //   988	1055	952	java/lang/Exception
    //   1058	1085	952	java/lang/Exception
    //   1110	1118	952	java/lang/Exception
    //   1124	1132	952	java/lang/Exception
    //   1135	1143	952	java/lang/Exception
    //   1365	1370	952	java/lang/Exception
    //   1370	1378	952	java/lang/Exception
    //   1378	1405	952	java/lang/Exception
    //   1408	1457	952	java/lang/Exception
    //   1460	1495	952	java/lang/Exception
    //   1151	1170	1358	finally
    //   1184	1200	1358	finally
    //   1208	1215	1358	finally
    //   1219	1230	1358	finally
    //   1234	1280	1358	finally
    //   939	944	2443	java/io/IOException
    //   1299	1304	2448	java/io/IOException
    //   1365	1370	2453	java/io/IOException
    //   516	526	2458	java/lang/Exception
    //   530	542	2458	java/lang/Exception
    //   665	675	2458	java/lang/Exception
    //   692	699	2458	java/lang/Exception
    //   703	710	2458	java/lang/Exception
    //   714	741	2458	java/lang/Exception
    //   750	760	2458	java/lang/Exception
    //   764	776	2458	java/lang/Exception
    //   780	788	2458	java/lang/Exception
    //   911	916	2458	java/lang/Exception
    //   1092	1107	2458	java/lang/Exception
    //   1299	1304	2458	java/lang/Exception
    //   1325	1343	2458	java/lang/Exception
    //   2227	2237	2458	java/lang/Exception
    //   2241	2249	2458	java/lang/Exception
    //   2253	2261	2458	java/lang/Exception
    //   2265	2273	2458	java/lang/Exception
    //   2277	2285	2458	java/lang/Exception
    //   2344	2360	2458	java/lang/Exception
    //   206	211	2471	java/lang/Exception
    //   216	224	2471	java/lang/Exception
    //   227	234	2471	java/lang/Exception
    //   1498	1546	2471	java/lang/Exception
    //   1546	1577	2471	java/lang/Exception
    //   1620	1628	2471	java/lang/Exception
    //   2157	2165	2471	java/lang/Exception
    //   2172	2223	2471	java/lang/Exception
    //   2296	2310	2471	java/lang/Exception
    //   2316	2330	2471	java/lang/Exception
    //   2330	2340	2471	java/lang/Exception
    //   2363	2378	2471	java/lang/Exception
    //   1582	1593	2484	java/lang/Exception
    //   1820	1826	2489	java/lang/Exception
    //   1837	1844	2489	java/lang/Exception
    //   1848	1858	2489	java/lang/Exception
    //   1862	1882	2489	java/lang/Exception
    //   1886	1896	2489	java/lang/Exception
    //   1900	1920	2489	java/lang/Exception
    //   1928	1938	2489	java/lang/Exception
    //   1942	1954	2489	java/lang/Exception
    //   1958	1971	2489	java/lang/Exception
    //   1975	1991	2489	java/lang/Exception
    //   1995	2005	2489	java/lang/Exception
    //   2009	2017	2489	java/lang/Exception
    //   2021	2029	2489	java/lang/Exception
    //   2040	2054	2489	java/lang/Exception
    //   2064	2078	2489	java/lang/Exception
    //   2082	2092	2489	java/lang/Exception
    //   2096	2112	2489	java/lang/Exception
    //   2119	2134	2489	java/lang/Exception
    //   1597	1617	2559	java/lang/Exception
    //   1640	1659	2559	java/lang/Exception
    //   1659	1679	2559	java/lang/Exception
    //   1683	1734	2559	java/lang/Exception
    //   1734	1742	2559	java/lang/Exception
    //   1746	1755	2559	java/lang/Exception
    //   1758	1765	2559	java/lang/Exception
    //   1765	1811	2559	java/lang/Exception
    //   2137	2151	2559	java/lang/Exception
  }
  
  public final String tH(String paramString)
  {
    AppMethodBeat.i(116110);
    if ((bo.isNullOrNil(paramString)) || (this.fHh == null))
    {
      AppMethodBeat.o(116110);
      return null;
    }
    String str = paramString;
    if (this.fHh.eOk) {
      str = paramString + "round" + this.fHh.eOl;
    }
    paramString = str;
    if (!bo.isNullOrNil(this.fHh.eOc)) {
      paramString = str + this.fHh.eOc;
    }
    paramString = paramString + "size" + this.fHh.eNS + this.fHh.eNT;
    AppMethodBeat.o(116110);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.at.a.f.b
 * JD-Core Version:    0.7.0.1
 */