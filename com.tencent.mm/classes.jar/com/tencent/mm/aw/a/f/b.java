package com.tencent.mm.aw.a.f;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.c.a;
import com.tencent.mm.aw.a.c.e;
import com.tencent.mm.aw.a.c.f;
import com.tencent.mm.aw.a.c.g;
import com.tencent.mm.aw.a.c.h;
import com.tencent.mm.aw.a.c.i;
import com.tencent.mm.aw.a.c.k;
import com.tencent.mm.aw.a.c.l;
import com.tencent.mm.aw.a.c.m;
import com.tencent.mm.aw.a.c.n;
import com.tencent.mm.aw.a.c.o;
import com.tencent.mm.aw.a.c.p;
import com.tencent.mm.aw.a.c.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;

public final class b
  implements Runnable
{
  public final com.tencent.mm.aw.a.a.c hjG;
  private final o hjH;
  private final com.tencent.mm.aw.a.c.b hjI;
  private final com.tencent.mm.aw.a.c.c hjJ;
  private final l hjL;
  private final f hjN;
  private final p hjQ;
  private final com.tencent.mm.aw.a.a.b hjy;
  public final com.tencent.mm.aw.a.c hkB;
  private final ap hkC;
  private final k hkD;
  private final h hkE;
  private final g hkF;
  private final m hkG;
  private final e hkH;
  private final n hkI;
  private final q hkq;
  private final a hkr;
  private final i hks;
  private final com.tencent.mm.aw.a.b hkz;
  public final String url;
  
  public b(String paramString, com.tencent.mm.aw.a.c paramc, ap paramap, com.tencent.mm.aw.a.a.c paramc1, k paramk, com.tencent.mm.aw.a.b paramb, h paramh)
  {
    AppMethodBeat.i(130435);
    this.url = paramString;
    this.hkB = paramc;
    this.hkC = paramap;
    this.hkz = paramb;
    this.hkE = paramh;
    this.hjy = this.hkz.hjy;
    if (paramc1 == null)
    {
      this.hjG = this.hjy.hjG;
      this.hkD = paramk;
      this.hjL = this.hjy.hjL;
      if (this.hjG.hjJ == null) {
        break label225;
      }
    }
    label225:
    for (this.hjJ = this.hjG.hjJ;; this.hjJ = this.hjy.hjJ)
    {
      this.hkq = this.hjG.hkq;
      this.hkr = this.hjG.hkr;
      this.hks = this.hjG.hks;
      this.hjH = this.hjy.hjH;
      this.hjI = this.hjy.hjI;
      this.hkF = this.hjy.hjK;
      this.hkG = this.hjy.hjM;
      this.hjN = this.hjy.hjN;
      this.hkH = null;
      this.hkI = null;
      this.hjQ = this.hjy.hjQ;
      AppMethodBeat.o(130435);
      return;
      this.hjG = paramc1;
      break;
    }
  }
  
  private Bitmap a(com.tencent.mm.aw.a.d.b paramb, Bitmap paramBitmap)
  {
    AppMethodBeat.i(130438);
    if ((this.hkE != null) && (paramb != null))
    {
      paramb.bitmap = paramBitmap;
      paramb = this.hkE.a(this.url, this.hkB.getImageView(), paramb);
      if ((paramb != null) && (!paramb.isRecycled()))
      {
        AppMethodBeat.o(130438);
        return paramb;
      }
    }
    AppMethodBeat.o(130438);
    return paramBitmap;
  }
  
  private void j(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(130437);
    if (this.hjG.hjS)
    {
      ad.d("MicroMsg.imageloader.ImageLoadTask", "[cpan] run. put key %s to memory cache.", new Object[] { this.url });
      this.hjH.c(paramString, paramBitmap);
    }
    AppMethodBeat.o(130437);
  }
  
  public final void mw(long paramLong)
  {
    AppMethodBeat.i(130440);
    if (this.hjL != null) {
      this.hjL.mw(paramLong);
    }
    AppMethodBeat.o(130440);
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: ldc 191
    //   2: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 99	com/tencent/mm/aw/a/f/b:hks	Lcom/tencent/mm/aw/a/c/i;
    //   9: ifnull +16 -> 25
    //   12: aload_0
    //   13: getfield 99	com/tencent/mm/aw/a/f/b:hks	Lcom/tencent/mm/aw/a/c/i;
    //   16: aload_0
    //   17: getfield 62	com/tencent/mm/aw/a/f/b:url	Ljava/lang/String;
    //   20: invokeinterface 197 2 0
    //   25: aconst_null
    //   26: astore 8
    //   28: new 135	com/tencent/mm/aw/a/d/b
    //   31: dup
    //   32: invokespecial 198	com/tencent/mm/aw/a/d/b:<init>	()V
    //   35: astore 10
    //   37: aload 10
    //   39: iconst_1
    //   40: putfield 202	com/tencent/mm/aw/a/d/b:from	I
    //   43: aload_0
    //   44: aload_0
    //   45: getfield 62	com/tencent/mm/aw/a/f/b:url	Ljava/lang/String;
    //   48: invokevirtual 206	com/tencent/mm/aw/a/f/b:yF	(Ljava/lang/String;)Ljava/lang/String;
    //   51: astore 13
    //   53: ldc 165
    //   55: ldc 208
    //   57: iconst_1
    //   58: anewarray 4	java/lang/Object
    //   61: dup
    //   62: iconst_0
    //   63: aload_0
    //   64: getfield 62	com/tencent/mm/aw/a/f/b:url	Ljava/lang/String;
    //   67: aastore
    //   68: invokestatic 173	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   71: invokestatic 214	java/lang/System:currentTimeMillis	()J
    //   74: lstore_3
    //   75: aload_0
    //   76: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   79: getfield 217	com/tencent/mm/aw/a/a/c:hjX	I
    //   82: istore_2
    //   83: aload_0
    //   84: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   87: getfield 220	com/tencent/mm/aw/a/a/c:hjY	Z
    //   90: istore 7
    //   92: aload_0
    //   93: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   96: getfield 223	com/tencent/mm/aw/a/a/c:md5	Ljava/lang/String;
    //   99: astore 14
    //   101: ldc 165
    //   103: ldc 225
    //   105: iload 7
    //   107: invokestatic 231	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   110: invokevirtual 234	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   113: invokestatic 237	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   116: ldc 165
    //   118: ldc 239
    //   120: iconst_1
    //   121: anewarray 4	java/lang/Object
    //   124: dup
    //   125: iconst_0
    //   126: iload_2
    //   127: invokestatic 244	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   130: aastore
    //   131: invokestatic 173	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   134: ldc 165
    //   136: ldc 246
    //   138: iconst_2
    //   139: anewarray 4	java/lang/Object
    //   142: dup
    //   143: iconst_0
    //   144: aload_0
    //   145: getfield 64	com/tencent/mm/aw/a/f/b:hkB	Lcom/tencent/mm/aw/a/c;
    //   148: getfield 249	com/tencent/mm/aw/a/c:width	I
    //   151: invokestatic 244	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   154: aastore
    //   155: dup
    //   156: iconst_1
    //   157: aload_0
    //   158: getfield 64	com/tencent/mm/aw/a/f/b:hkB	Lcom/tencent/mm/aw/a/c;
    //   161: getfield 252	com/tencent/mm/aw/a/c:height	I
    //   164: invokestatic 244	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   167: aastore
    //   168: invokestatic 173	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   171: iload_2
    //   172: tableswitch	default:+2653 -> 2825, 1:+303->475, 2:+1415->1587, 3:+1445->1617, 4:+1497->1669, 5:+1043->1215
    //   209: if_acmpeq +4862 -> 5071
    //   212: iconst_1
    //   213: anewarray 4	java/lang/Object
    //   216: dup
    //   217: iconst_0
    //   218: iload_2
    //   219: invokestatic 244	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   222: aastore
    //   223: invokestatic 257	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   226: aconst_null
    //   227: astore 8
    //   229: invokestatic 214	java/lang/System:currentTimeMillis	()J
    //   232: lstore 5
    //   234: aload 8
    //   236: ifnull +2592 -> 2828
    //   239: aload 8
    //   241: invokevirtual 156	android/graphics/Bitmap:isRecycled	()Z
    //   244: ifeq +2184 -> 2428
    //   247: goto +2581 -> 2828
    //   250: ldc 165
    //   252: ldc_w 259
    //   255: invokestatic 262	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   258: aload 8
    //   260: ifnull +2424 -> 2684
    //   263: aload 8
    //   265: invokevirtual 156	android/graphics/Bitmap:isRecycled	()Z
    //   268: ifne +2416 -> 2684
    //   271: ldc 165
    //   273: ldc_w 264
    //   276: invokestatic 237	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   279: aload 8
    //   281: astore 9
    //   283: aload_0
    //   284: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   287: getfield 267	com/tencent/mm/aw/a/a/c:hka	Z
    //   290: ifeq +17 -> 307
    //   293: aload 8
    //   295: aload_0
    //   296: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   299: getfield 270	com/tencent/mm/aw/a/a/c:hkb	I
    //   302: invokestatic 276	com/tencent/mm/sdk/platformtools/f:l	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   305: astore 9
    //   307: aload 10
    //   309: getfield 279	com/tencent/mm/aw/a/d/b:hky	Z
    //   312: ifeq +2321 -> 2633
    //   315: aload_0
    //   316: getfield 68	com/tencent/mm/aw/a/f/b:hkz	Lcom/tencent/mm/aw/a/b;
    //   319: aload_0
    //   320: getfield 64	com/tencent/mm/aw/a/f/b:hkB	Lcom/tencent/mm/aw/a/c;
    //   323: invokevirtual 282	com/tencent/mm/aw/a/b:a	(Lcom/tencent/mm/aw/a/c;)V
    //   326: aload 10
    //   328: aload 9
    //   330: putfield 139	com/tencent/mm/aw/a/d/b:bitmap	Landroid/graphics/Bitmap;
    //   333: aload 10
    //   335: iconst_0
    //   336: putfield 285	com/tencent/mm/aw/a/d/b:status	I
    //   339: aload 9
    //   341: astore 8
    //   343: aload_0
    //   344: getfield 99	com/tencent/mm/aw/a/f/b:hks	Lcom/tencent/mm/aw/a/c/i;
    //   347: ifnull +12 -> 359
    //   350: aload_0
    //   351: getfield 99	com/tencent/mm/aw/a/f/b:hks	Lcom/tencent/mm/aw/a/c/i;
    //   354: invokeinterface 288 1 0
    //   359: aload_0
    //   360: getfield 70	com/tencent/mm/aw/a/f/b:hkE	Lcom/tencent/mm/aw/a/c/h;
    //   363: ifnull +37 -> 400
    //   366: aload 10
    //   368: ifnull +32 -> 400
    //   371: aload 10
    //   373: aload 8
    //   375: putfield 139	com/tencent/mm/aw/a/d/b:bitmap	Landroid/graphics/Bitmap;
    //   378: aload_0
    //   379: getfield 70	com/tencent/mm/aw/a/f/b:hkE	Lcom/tencent/mm/aw/a/c/h;
    //   382: aload_0
    //   383: getfield 62	com/tencent/mm/aw/a/f/b:url	Ljava/lang/String;
    //   386: aload_0
    //   387: getfield 64	com/tencent/mm/aw/a/f/b:hkB	Lcom/tencent/mm/aw/a/c;
    //   390: invokevirtual 145	com/tencent/mm/aw/a/c:getImageView	()Landroid/widget/ImageView;
    //   393: aload 10
    //   395: invokeinterface 292 4 0
    //   400: aload_0
    //   401: getfield 82	com/tencent/mm/aw/a/f/b:hkD	Lcom/tencent/mm/aw/a/c/k;
    //   404: aload_0
    //   405: getfield 62	com/tencent/mm/aw/a/f/b:url	Ljava/lang/String;
    //   408: aload_0
    //   409: getfield 64	com/tencent/mm/aw/a/f/b:hkB	Lcom/tencent/mm/aw/a/c;
    //   412: invokevirtual 145	com/tencent/mm/aw/a/c:getImageView	()Landroid/widget/ImageView;
    //   415: aload 8
    //   417: aload_0
    //   418: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   421: getfield 296	com/tencent/mm/aw/a/a/c:hkt	[Ljava/lang/Object;
    //   424: invokeinterface 301 5 0
    //   429: aload_0
    //   430: getfield 68	com/tencent/mm/aw/a/f/b:hkz	Lcom/tencent/mm/aw/a/b;
    //   433: astore 8
    //   435: aload 8
    //   437: getfield 305	com/tencent/mm/aw/a/b:hjC	Ljava/util/HashMap;
    //   440: ifnull +29 -> 469
    //   443: aload_0
    //   444: getfield 64	com/tencent/mm/aw/a/f/b:hkB	Lcom/tencent/mm/aw/a/c;
    //   447: ifnull +22 -> 469
    //   450: aload 8
    //   452: getfield 305	com/tencent/mm/aw/a/b:hjC	Ljava/util/HashMap;
    //   455: aload_0
    //   456: getfield 64	com/tencent/mm/aw/a/f/b:hkB	Lcom/tencent/mm/aw/a/c;
    //   459: getfield 308	com/tencent/mm/aw/a/c:gku	I
    //   462: invokestatic 244	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   465: invokevirtual 314	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   468: pop
    //   469: ldc 191
    //   471: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   474: return
    //   475: aload_0
    //   476: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   479: getfield 317	com/tencent/mm/aw/a/a/c:thumbPath	Ljava/lang/String;
    //   482: astore 8
    //   484: aload_0
    //   485: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   488: getfield 320	com/tencent/mm/aw/a/a/c:hkc	Z
    //   491: ifeq +123 -> 614
    //   494: aload 8
    //   496: invokestatic 326	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   499: ifne +115 -> 614
    //   502: aload 8
    //   504: invokestatic 331	com/tencent/mm/vfs/i:eK	(Ljava/lang/String;)Z
    //   507: ifeq +107 -> 614
    //   510: aload_0
    //   511: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   514: getfield 334	com/tencent/mm/aw/a/a/c:hkn	Z
    //   517: ifeq +69 -> 586
    //   520: aload_0
    //   521: getfield 64	com/tencent/mm/aw/a/f/b:hkB	Lcom/tencent/mm/aw/a/c;
    //   524: aload 8
    //   526: aload_0
    //   527: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   530: getfield 337	com/tencent/mm/aw/a/a/c:gjv	I
    //   533: aload_0
    //   534: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   537: getfield 340	com/tencent/mm/aw/a/a/c:gjw	I
    //   540: invokestatic 345	com/tencent/mm/aw/a/g/a:b	(Lcom/tencent/mm/aw/a/c;Ljava/lang/String;II)Landroid/graphics/Bitmap;
    //   543: astore 9
    //   545: aload 9
    //   547: astore 8
    //   549: aload 9
    //   551: astore 11
    //   553: aload_0
    //   554: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   557: getfield 348	com/tencent/mm/aw/a/a/c:density	I
    //   560: ifle +2249 -> 2809
    //   563: aload 9
    //   565: astore 8
    //   567: aload 9
    //   569: aload_0
    //   570: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   573: getfield 348	com/tencent/mm/aw/a/a/c:density	I
    //   576: invokevirtual 351	android/graphics/Bitmap:setDensity	(I)V
    //   579: aload 9
    //   581: astore 8
    //   583: goto -354 -> 229
    //   586: aload_0
    //   587: getfield 64	com/tencent/mm/aw/a/f/b:hkB	Lcom/tencent/mm/aw/a/c;
    //   590: aload 8
    //   592: aload_0
    //   593: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   596: getfield 337	com/tencent/mm/aw/a/a/c:gjv	I
    //   599: aload_0
    //   600: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   603: getfield 340	com/tencent/mm/aw/a/a/c:gjw	I
    //   606: invokestatic 353	com/tencent/mm/aw/a/g/a:a	(Lcom/tencent/mm/aw/a/c;Ljava/lang/String;II)Landroid/graphics/Bitmap;
    //   609: astore 9
    //   611: goto -66 -> 545
    //   614: aload_0
    //   615: getfield 62	com/tencent/mm/aw/a/f/b:url	Ljava/lang/String;
    //   618: invokestatic 326	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   621: ifne +580 -> 1201
    //   624: aload_0
    //   625: getfield 62	com/tencent/mm/aw/a/f/b:url	Ljava/lang/String;
    //   628: invokestatic 331	com/tencent/mm/vfs/i:eK	(Ljava/lang/String;)Z
    //   631: ifeq +545 -> 1176
    //   634: iload 7
    //   636: ifeq +21 -> 657
    //   639: aload_0
    //   640: getfield 115	com/tencent/mm/aw/a/f/b:hkG	Lcom/tencent/mm/aw/a/c/m;
    //   643: aload 14
    //   645: aload_0
    //   646: getfield 62	com/tencent/mm/aw/a/f/b:url	Ljava/lang/String;
    //   649: invokeinterface 359 3 0
    //   654: ifeq +497 -> 1151
    //   657: aload_0
    //   658: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   661: getfield 334	com/tencent/mm/aw/a/a/c:hkn	Z
    //   664: ifeq +168 -> 832
    //   667: aload_0
    //   668: getfield 64	com/tencent/mm/aw/a/f/b:hkB	Lcom/tencent/mm/aw/a/c;
    //   671: aload_0
    //   672: getfield 62	com/tencent/mm/aw/a/f/b:url	Ljava/lang/String;
    //   675: aload_0
    //   676: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   679: getfield 337	com/tencent/mm/aw/a/a/c:gjv	I
    //   682: aload_0
    //   683: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   686: getfield 340	com/tencent/mm/aw/a/a/c:gjw	I
    //   689: invokestatic 345	com/tencent/mm/aw/a/g/a:b	(Lcom/tencent/mm/aw/a/c;Ljava/lang/String;II)Landroid/graphics/Bitmap;
    //   692: astore 9
    //   694: aload 9
    //   696: astore 11
    //   698: aload 9
    //   700: astore 8
    //   702: aload_0
    //   703: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   706: getfield 362	com/tencent/mm/aw/a/a/c:hkp	Z
    //   709: ifeq +69 -> 778
    //   712: aload 9
    //   714: astore 11
    //   716: aload 9
    //   718: ifnonnull +60 -> 778
    //   721: aload 9
    //   723: astore 11
    //   725: aload 9
    //   727: astore 8
    //   729: aload_0
    //   730: getfield 122	com/tencent/mm/aw/a/f/b:hkI	Lcom/tencent/mm/aw/a/c/n;
    //   733: ifnull +45 -> 778
    //   736: aload 9
    //   738: astore 8
    //   740: aload_0
    //   741: getfield 120	com/tencent/mm/aw/a/f/b:hkH	Lcom/tencent/mm/aw/a/c/e;
    //   744: ifnull +385 -> 1129
    //   747: aload 9
    //   749: astore 8
    //   751: aload_0
    //   752: getfield 122	com/tencent/mm/aw/a/f/b:hkI	Lcom/tencent/mm/aw/a/c/n;
    //   755: aload_0
    //   756: getfield 120	com/tencent/mm/aw/a/f/b:hkH	Lcom/tencent/mm/aw/a/c/e;
    //   759: aload_0
    //   760: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   763: getfield 296	com/tencent/mm/aw/a/a/c:hkt	[Ljava/lang/Object;
    //   766: invokeinterface 367 2 0
    //   771: invokeinterface 373 2 0
    //   776: astore 11
    //   778: aload 11
    //   780: ifnull +33 -> 813
    //   783: aload 11
    //   785: astore 8
    //   787: aload_0
    //   788: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   791: getfield 348	com/tencent/mm/aw/a/a/c:density	I
    //   794: ifle +19 -> 813
    //   797: aload 11
    //   799: astore 8
    //   801: aload 11
    //   803: aload_0
    //   804: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   807: getfield 348	com/tencent/mm/aw/a/a/c:density	I
    //   810: invokevirtual 351	android/graphics/Bitmap:setDensity	(I)V
    //   813: aload 11
    //   815: astore 8
    //   817: ldc 165
    //   819: ldc_w 375
    //   822: invokestatic 237	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   825: aload 11
    //   827: astore 8
    //   829: goto -600 -> 229
    //   832: aload_0
    //   833: getfield 93	com/tencent/mm/aw/a/f/b:hkq	Lcom/tencent/mm/aw/a/c/q;
    //   836: astore 8
    //   838: aload 8
    //   840: ifnull +189 -> 1029
    //   843: aconst_null
    //   844: astore 9
    //   846: aload 9
    //   848: astore 8
    //   850: aload_0
    //   851: getfield 93	com/tencent/mm/aw/a/f/b:hkq	Lcom/tencent/mm/aw/a/c/q;
    //   854: astore 11
    //   856: aload 9
    //   858: astore 8
    //   860: aload_0
    //   861: getfield 62	com/tencent/mm/aw/a/f/b:url	Ljava/lang/String;
    //   864: invokestatic 379	com/tencent/mm/vfs/i:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   867: pop
    //   868: aload 9
    //   870: astore 8
    //   872: aload 11
    //   874: invokeinterface 385 1 0
    //   879: astore 12
    //   881: aload 12
    //   883: astore 8
    //   885: aload_0
    //   886: getfield 64	com/tencent/mm/aw/a/f/b:hkB	Lcom/tencent/mm/aw/a/c;
    //   889: aload 12
    //   891: aload_0
    //   892: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   895: getfield 337	com/tencent/mm/aw/a/a/c:gjv	I
    //   898: aload_0
    //   899: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   902: getfield 340	com/tencent/mm/aw/a/a/c:gjw	I
    //   905: aload_0
    //   906: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   909: getfield 388	com/tencent/mm/aw/a/a/c:hke	Z
    //   912: aload_0
    //   913: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   916: getfield 392	com/tencent/mm/aw/a/a/c:alpha	F
    //   919: aload_0
    //   920: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   923: getfield 395	com/tencent/mm/aw/a/a/c:hjZ	Z
    //   926: invokestatic 398	com/tencent/mm/aw/a/g/a:a	(Lcom/tencent/mm/aw/a/c;Ljava/io/InputStream;IIZFZ)Landroid/graphics/Bitmap;
    //   929: astore 11
    //   931: aload 11
    //   933: astore 9
    //   935: aload 12
    //   937: ifnull -243 -> 694
    //   940: aload 11
    //   942: astore 8
    //   944: aload 12
    //   946: invokevirtual 403	java/io/InputStream:close	()V
    //   949: aload 11
    //   951: astore 9
    //   953: goto -259 -> 694
    //   956: astore 8
    //   958: aload 11
    //   960: astore 9
    //   962: goto -268 -> 694
    //   965: astore 9
    //   967: aload 8
    //   969: ifnull +8 -> 977
    //   972: aload 8
    //   974: invokevirtual 403	java/io/InputStream:close	()V
    //   977: ldc 191
    //   979: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   982: aload 9
    //   984: athrow
    //   985: astore 11
    //   987: aload 10
    //   989: astore 8
    //   991: aconst_null
    //   992: astore 9
    //   994: aload 11
    //   996: astore 10
    //   998: ldc 165
    //   1000: ldc_w 405
    //   1003: iconst_1
    //   1004: anewarray 4	java/lang/Object
    //   1007: dup
    //   1008: iconst_0
    //   1009: aload 10
    //   1011: invokevirtual 409	java/lang/Exception:toString	()Ljava/lang/String;
    //   1014: aastore
    //   1015: invokestatic 257	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1018: aload 8
    //   1020: astore 10
    //   1022: aload 9
    //   1024: astore 8
    //   1026: goto -768 -> 258
    //   1029: aload_0
    //   1030: getfield 120	com/tencent/mm/aw/a/f/b:hkH	Lcom/tencent/mm/aw/a/c/e;
    //   1033: ifnull +66 -> 1099
    //   1036: aload_0
    //   1037: getfield 64	com/tencent/mm/aw/a/f/b:hkB	Lcom/tencent/mm/aw/a/c;
    //   1040: aload_0
    //   1041: getfield 120	com/tencent/mm/aw/a/f/b:hkH	Lcom/tencent/mm/aw/a/c/e;
    //   1044: aload_0
    //   1045: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   1048: getfield 296	com/tencent/mm/aw/a/a/c:hkt	[Ljava/lang/Object;
    //   1051: invokeinterface 367 2 0
    //   1056: aload_0
    //   1057: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   1060: getfield 337	com/tencent/mm/aw/a/a/c:gjv	I
    //   1063: aload_0
    //   1064: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   1067: getfield 340	com/tencent/mm/aw/a/a/c:gjw	I
    //   1070: aload_0
    //   1071: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   1074: getfield 388	com/tencent/mm/aw/a/a/c:hke	Z
    //   1077: aload_0
    //   1078: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   1081: getfield 392	com/tencent/mm/aw/a/a/c:alpha	F
    //   1084: aload_0
    //   1085: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   1088: getfield 395	com/tencent/mm/aw/a/a/c:hjZ	Z
    //   1091: invokestatic 412	com/tencent/mm/aw/a/g/a:a	(Lcom/tencent/mm/aw/a/c;[BIIZFZ)Landroid/graphics/Bitmap;
    //   1094: astore 9
    //   1096: goto -402 -> 694
    //   1099: aload_0
    //   1100: getfield 64	com/tencent/mm/aw/a/f/b:hkB	Lcom/tencent/mm/aw/a/c;
    //   1103: aload_0
    //   1104: getfield 62	com/tencent/mm/aw/a/f/b:url	Ljava/lang/String;
    //   1107: aload_0
    //   1108: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   1111: getfield 337	com/tencent/mm/aw/a/a/c:gjv	I
    //   1114: aload_0
    //   1115: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   1118: getfield 340	com/tencent/mm/aw/a/a/c:gjw	I
    //   1121: invokestatic 353	com/tencent/mm/aw/a/g/a:a	(Lcom/tencent/mm/aw/a/c;Ljava/lang/String;II)Landroid/graphics/Bitmap;
    //   1124: astore 9
    //   1126: goto -432 -> 694
    //   1129: aload 9
    //   1131: astore 8
    //   1133: aload_0
    //   1134: getfield 122	com/tencent/mm/aw/a/f/b:hkI	Lcom/tencent/mm/aw/a/c/n;
    //   1137: aload_0
    //   1138: getfield 62	com/tencent/mm/aw/a/f/b:url	Ljava/lang/String;
    //   1141: invokeinterface 416 2 0
    //   1146: astore 11
    //   1148: goto -370 -> 778
    //   1151: ldc 165
    //   1153: ldc_w 418
    //   1156: iconst_1
    //   1157: anewarray 4	java/lang/Object
    //   1160: dup
    //   1161: iconst_0
    //   1162: aload_0
    //   1163: getfield 62	com/tencent/mm/aw/a/f/b:url	Ljava/lang/String;
    //   1166: aastore
    //   1167: invokestatic 420	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1170: aconst_null
    //   1171: astore 8
    //   1173: goto -944 -> 229
    //   1176: ldc 165
    //   1178: ldc_w 422
    //   1181: iconst_1
    //   1182: anewarray 4	java/lang/Object
    //   1185: dup
    //   1186: iconst_0
    //   1187: aload_0
    //   1188: getfield 62	com/tencent/mm/aw/a/f/b:url	Ljava/lang/String;
    //   1191: aastore
    //   1192: invokestatic 420	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1195: aconst_null
    //   1196: astore 8
    //   1198: goto -969 -> 229
    //   1201: ldc 165
    //   1203: ldc_w 424
    //   1206: invokestatic 262	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1209: aconst_null
    //   1210: astore 8
    //   1212: goto -983 -> 229
    //   1215: aconst_null
    //   1216: astore 11
    //   1218: iconst_0
    //   1219: istore_1
    //   1220: aload 11
    //   1222: astore 9
    //   1224: aload_0
    //   1225: getfield 96	com/tencent/mm/aw/a/f/b:hkr	Lcom/tencent/mm/aw/a/c/a;
    //   1228: ifnull +20 -> 1248
    //   1231: aload 11
    //   1233: astore 9
    //   1235: aload_0
    //   1236: getfield 96	com/tencent/mm/aw/a/f/b:hkr	Lcom/tencent/mm/aw/a/c/a;
    //   1239: aload_0
    //   1240: getfield 62	com/tencent/mm/aw/a/f/b:url	Ljava/lang/String;
    //   1243: invokeinterface 429 2 0
    //   1248: aload 11
    //   1250: astore 9
    //   1252: aload_0
    //   1253: getfield 105	com/tencent/mm/aw/a/f/b:hjI	Lcom/tencent/mm/aw/a/c/b;
    //   1256: aload_0
    //   1257: getfield 62	com/tencent/mm/aw/a/f/b:url	Ljava/lang/String;
    //   1260: aload_0
    //   1261: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   1264: invokeinterface 434 3 0
    //   1269: astore 11
    //   1271: aload 11
    //   1273: astore 9
    //   1275: aload_0
    //   1276: getfield 96	com/tencent/mm/aw/a/f/b:hkr	Lcom/tencent/mm/aw/a/c/a;
    //   1279: ifnull +16 -> 1295
    //   1282: aload 11
    //   1284: astore 9
    //   1286: aload_0
    //   1287: getfield 96	com/tencent/mm/aw/a/f/b:hkr	Lcom/tencent/mm/aw/a/c/a;
    //   1290: invokeinterface 437 1 0
    //   1295: aload 11
    //   1297: astore 12
    //   1299: aload 8
    //   1301: astore 9
    //   1303: aload 11
    //   1305: ifnull +166 -> 1471
    //   1308: iload 7
    //   1310: ifeq +23 -> 1333
    //   1313: aload 11
    //   1315: astore 9
    //   1317: aload_0
    //   1318: getfield 115	com/tencent/mm/aw/a/f/b:hkG	Lcom/tencent/mm/aw/a/c/m;
    //   1321: aload 14
    //   1323: aload 11
    //   1325: invokeinterface 440 3 0
    //   1330: ifeq +201 -> 1531
    //   1333: aload 11
    //   1335: astore 8
    //   1337: aload 11
    //   1339: astore 9
    //   1341: aload_0
    //   1342: getfield 93	com/tencent/mm/aw/a/f/b:hkq	Lcom/tencent/mm/aw/a/c/q;
    //   1345: ifnull +18 -> 1363
    //   1348: aload 11
    //   1350: astore 9
    //   1352: aload_0
    //   1353: getfield 93	com/tencent/mm/aw/a/f/b:hkq	Lcom/tencent/mm/aw/a/c/q;
    //   1356: invokeinterface 385 1 0
    //   1361: astore 8
    //   1363: aload 8
    //   1365: astore 9
    //   1367: aload_0
    //   1368: getfield 96	com/tencent/mm/aw/a/f/b:hkr	Lcom/tencent/mm/aw/a/c/a;
    //   1371: ifnull +22 -> 1393
    //   1374: aload 8
    //   1376: astore 9
    //   1378: aload_0
    //   1379: getfield 96	com/tencent/mm/aw/a/f/b:hkr	Lcom/tencent/mm/aw/a/c/a;
    //   1382: aload_0
    //   1383: getfield 62	com/tencent/mm/aw/a/f/b:url	Ljava/lang/String;
    //   1386: aload 10
    //   1388: invokeinterface 443 3 0
    //   1393: aload 8
    //   1395: astore 9
    //   1397: aload_0
    //   1398: getfield 64	com/tencent/mm/aw/a/f/b:hkB	Lcom/tencent/mm/aw/a/c;
    //   1401: aload 8
    //   1403: aload_0
    //   1404: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   1407: getfield 337	com/tencent/mm/aw/a/a/c:gjv	I
    //   1410: aload_0
    //   1411: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   1414: getfield 340	com/tencent/mm/aw/a/a/c:gjw	I
    //   1417: aload_0
    //   1418: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   1421: getfield 388	com/tencent/mm/aw/a/a/c:hke	Z
    //   1424: aload_0
    //   1425: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   1428: getfield 392	com/tencent/mm/aw/a/a/c:alpha	F
    //   1431: aload_0
    //   1432: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   1435: getfield 395	com/tencent/mm/aw/a/a/c:hjZ	Z
    //   1438: invokestatic 398	com/tencent/mm/aw/a/g/a:a	(Lcom/tencent/mm/aw/a/c;Ljava/io/InputStream;IIZFZ)Landroid/graphics/Bitmap;
    //   1441: astore 11
    //   1443: aload 11
    //   1445: astore 9
    //   1447: aload_0
    //   1448: getfield 96	com/tencent/mm/aw/a/f/b:hkr	Lcom/tencent/mm/aw/a/c/a;
    //   1451: ifnull +1365 -> 2816
    //   1454: aload_0
    //   1455: getfield 96	com/tencent/mm/aw/a/f/b:hkr	Lcom/tencent/mm/aw/a/c/a;
    //   1458: aload 9
    //   1460: invokeinterface 447 2 0
    //   1465: iconst_1
    //   1466: istore_1
    //   1467: aload 8
    //   1469: astore 12
    //   1471: aload 12
    //   1473: ifnull +12 -> 1485
    //   1476: aload 9
    //   1478: astore 8
    //   1480: aload 12
    //   1482: invokevirtual 403	java/io/InputStream:close	()V
    //   1485: aload 9
    //   1487: astore 11
    //   1489: iload_1
    //   1490: ifeq +1319 -> 2809
    //   1493: aload 9
    //   1495: astore 11
    //   1497: aload 9
    //   1499: ifnonnull +1310 -> 2809
    //   1502: aload 9
    //   1504: astore 8
    //   1506: aload_0
    //   1507: getfield 105	com/tencent/mm/aw/a/f/b:hjI	Lcom/tencent/mm/aw/a/c/b;
    //   1510: aload_0
    //   1511: getfield 62	com/tencent/mm/aw/a/f/b:url	Ljava/lang/String;
    //   1514: aload_0
    //   1515: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   1518: invokeinterface 450 3 0
    //   1523: pop
    //   1524: aload 9
    //   1526: astore 8
    //   1528: goto -1299 -> 229
    //   1531: iconst_1
    //   1532: istore_1
    //   1533: aconst_null
    //   1534: astore 9
    //   1536: aload 11
    //   1538: astore 12
    //   1540: goto -69 -> 1471
    //   1543: astore 12
    //   1545: aconst_null
    //   1546: astore 11
    //   1548: aload 9
    //   1550: astore 8
    //   1552: aload 8
    //   1554: ifnull +8 -> 1562
    //   1557: aload 8
    //   1559: invokevirtual 403	java/io/InputStream:close	()V
    //   1562: ldc 191
    //   1564: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1567: aload 12
    //   1569: athrow
    //   1570: astore 9
    //   1572: aload 10
    //   1574: astore 8
    //   1576: aload 9
    //   1578: astore 10
    //   1580: aload 11
    //   1582: astore 9
    //   1584: goto -586 -> 998
    //   1587: aload_0
    //   1588: getfield 64	com/tencent/mm/aw/a/f/b:hkB	Lcom/tencent/mm/aw/a/c;
    //   1591: aload_0
    //   1592: getfield 62	com/tencent/mm/aw/a/f/b:url	Ljava/lang/String;
    //   1595: aload_0
    //   1596: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   1599: getfield 337	com/tencent/mm/aw/a/a/c:gjv	I
    //   1602: aload_0
    //   1603: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   1606: getfield 340	com/tencent/mm/aw/a/a/c:gjw	I
    //   1609: invokestatic 452	com/tencent/mm/aw/a/g/a:c	(Lcom/tencent/mm/aw/a/c;Ljava/lang/String;II)Landroid/graphics/Bitmap;
    //   1612: astore 8
    //   1614: goto -1385 -> 229
    //   1617: aload_0
    //   1618: getfield 75	com/tencent/mm/aw/a/f/b:hjy	Lcom/tencent/mm/aw/a/a/b;
    //   1621: getfield 456	com/tencent/mm/aw/a/a/b:aHZ	Landroid/content/res/Resources;
    //   1624: aload_0
    //   1625: getfield 62	com/tencent/mm/aw/a/f/b:url	Ljava/lang/String;
    //   1628: ldc_w 458
    //   1631: aload_0
    //   1632: getfield 75	com/tencent/mm/aw/a/f/b:hjy	Lcom/tencent/mm/aw/a/a/b;
    //   1635: getfield 461	com/tencent/mm/aw/a/a/b:packageName	Ljava/lang/String;
    //   1638: invokevirtual 467	android/content/res/Resources:getIdentifier	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   1641: istore_1
    //   1642: aload_0
    //   1643: getfield 64	com/tencent/mm/aw/a/f/b:hkB	Lcom/tencent/mm/aw/a/c;
    //   1646: iload_1
    //   1647: aload_0
    //   1648: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   1651: getfield 337	com/tencent/mm/aw/a/a/c:gjv	I
    //   1654: aload_0
    //   1655: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   1658: getfield 340	com/tencent/mm/aw/a/a/c:gjw	I
    //   1661: invokestatic 470	com/tencent/mm/aw/a/g/a:a	(Lcom/tencent/mm/aw/a/c;III)Landroid/graphics/Bitmap;
    //   1664: astore 8
    //   1666: goto -1437 -> 229
    //   1669: aload_0
    //   1670: getfield 62	com/tencent/mm/aw/a/f/b:url	Ljava/lang/String;
    //   1673: invokestatic 473	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1676: invokevirtual 477	java/lang/Integer:intValue	()I
    //   1679: istore_1
    //   1680: aload_0
    //   1681: getfield 64	com/tencent/mm/aw/a/f/b:hkB	Lcom/tencent/mm/aw/a/c;
    //   1684: iload_1
    //   1685: aload_0
    //   1686: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   1689: getfield 337	com/tencent/mm/aw/a/a/c:gjv	I
    //   1692: aload_0
    //   1693: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   1696: getfield 340	com/tencent/mm/aw/a/a/c:gjw	I
    //   1699: invokestatic 470	com/tencent/mm/aw/a/g/a:a	(Lcom/tencent/mm/aw/a/c;III)Landroid/graphics/Bitmap;
    //   1702: astore 8
    //   1704: goto -1475 -> 229
    //   1707: invokestatic 214	java/lang/System:currentTimeMillis	()J
    //   1710: lstore_3
    //   1711: ldc 165
    //   1713: ldc_w 479
    //   1716: invokestatic 237	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1719: aload_0
    //   1720: getfield 70	com/tencent/mm/aw/a/f/b:hkE	Lcom/tencent/mm/aw/a/c/h;
    //   1723: ifnull +23 -> 1746
    //   1726: aload_0
    //   1727: getfield 70	com/tencent/mm/aw/a/f/b:hkE	Lcom/tencent/mm/aw/a/c/h;
    //   1730: aload_0
    //   1731: getfield 62	com/tencent/mm/aw/a/f/b:url	Ljava/lang/String;
    //   1734: aload_0
    //   1735: getfield 64	com/tencent/mm/aw/a/f/b:hkB	Lcom/tencent/mm/aw/a/c;
    //   1738: invokevirtual 145	com/tencent/mm/aw/a/c:getImageView	()Landroid/widget/ImageView;
    //   1741: invokeinterface 482 3 0
    //   1746: aload_0
    //   1747: getfield 125	com/tencent/mm/aw/a/f/b:hjQ	Lcom/tencent/mm/aw/a/c/p;
    //   1750: aload_0
    //   1751: getfield 62	com/tencent/mm/aw/a/f/b:url	Ljava/lang/String;
    //   1754: invokeinterface 487 2 0
    //   1759: ifeq +65 -> 1824
    //   1762: aload_0
    //   1763: getfield 90	com/tencent/mm/aw/a/f/b:hjJ	Lcom/tencent/mm/aw/a/c/c;
    //   1766: aload_0
    //   1767: getfield 62	com/tencent/mm/aw/a/f/b:url	Ljava/lang/String;
    //   1770: invokeinterface 493 2 0
    //   1775: astore 9
    //   1777: aload 9
    //   1779: ifnonnull +1027 -> 2806
    //   1782: new 135	com/tencent/mm/aw/a/d/b
    //   1785: dup
    //   1786: aconst_null
    //   1787: aconst_null
    //   1788: invokespecial 496	com/tencent/mm/aw/a/d/b:<init>	([BLjava/lang/String;)V
    //   1791: astore 10
    //   1793: aload 10
    //   1795: astore 9
    //   1797: aload 9
    //   1799: iconst_2
    //   1800: putfield 202	com/tencent/mm/aw/a/d/b:from	I
    //   1803: aload 9
    //   1805: getfield 500	com/tencent/mm/aw/a/d/b:data	[B
    //   1808: ifnonnull +31 -> 1839
    //   1811: aload 9
    //   1813: iconst_1
    //   1814: putfield 285	com/tencent/mm/aw/a/d/b:status	I
    //   1817: aload 9
    //   1819: astore 10
    //   1821: goto -1563 -> 258
    //   1824: ldc 165
    //   1826: ldc_w 502
    //   1829: invokestatic 504	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1832: aload 10
    //   1834: astore 9
    //   1836: goto -59 -> 1777
    //   1839: iload 7
    //   1841: ifeq +22 -> 1863
    //   1844: aload_0
    //   1845: getfield 115	com/tencent/mm/aw/a/f/b:hkG	Lcom/tencent/mm/aw/a/c/m;
    //   1848: aload 14
    //   1850: aload 9
    //   1852: getfield 500	com/tencent/mm/aw/a/d/b:data	[B
    //   1855: invokeinterface 507 3 0
    //   1860: ifeq +533 -> 2393
    //   1863: ldc 165
    //   1865: ldc_w 509
    //   1868: invokestatic 237	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1871: invokestatic 214	java/lang/System:currentTimeMillis	()J
    //   1874: lstore 5
    //   1876: aload 9
    //   1878: getfield 500	com/tencent/mm/aw/a/d/b:data	[B
    //   1881: astore 11
    //   1883: aload 11
    //   1885: astore 10
    //   1887: aload_0
    //   1888: getfield 93	com/tencent/mm/aw/a/f/b:hkq	Lcom/tencent/mm/aw/a/c/q;
    //   1891: ifnull +78 -> 1969
    //   1894: aload_0
    //   1895: getfield 93	com/tencent/mm/aw/a/f/b:hkq	Lcom/tencent/mm/aw/a/c/q;
    //   1898: astore 10
    //   1900: new 511	java/io/ByteArrayInputStream
    //   1903: dup
    //   1904: aload 11
    //   1906: invokespecial 514	java/io/ByteArrayInputStream:<init>	([B)V
    //   1909: pop
    //   1910: aload 10
    //   1912: invokeinterface 385 1 0
    //   1917: astore 10
    //   1919: new 516	java/io/ByteArrayOutputStream
    //   1922: dup
    //   1923: aload 11
    //   1925: arraylength
    //   1926: invokespecial 518	java/io/ByteArrayOutputStream:<init>	(I)V
    //   1929: astore 11
    //   1931: sipush 1024
    //   1934: newarray byte
    //   1936: astore 12
    //   1938: aload 10
    //   1940: aload 12
    //   1942: invokevirtual 522	java/io/InputStream:read	([B)I
    //   1945: istore_1
    //   1946: iload_1
    //   1947: iflt +15 -> 1962
    //   1950: aload 11
    //   1952: aload 12
    //   1954: iconst_0
    //   1955: iload_1
    //   1956: invokevirtual 526	java/io/ByteArrayOutputStream:write	([BII)V
    //   1959: goto -21 -> 1938
    //   1962: aload 11
    //   1964: invokevirtual 530	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   1967: astore 10
    //   1969: aload_0
    //   1970: getfield 96	com/tencent/mm/aw/a/f/b:hkr	Lcom/tencent/mm/aw/a/c/a;
    //   1973: ifnull +18 -> 1991
    //   1976: aload_0
    //   1977: getfield 96	com/tencent/mm/aw/a/f/b:hkr	Lcom/tencent/mm/aw/a/c/a;
    //   1980: aload_0
    //   1981: getfield 62	com/tencent/mm/aw/a/f/b:url	Ljava/lang/String;
    //   1984: aload 9
    //   1986: invokeinterface 443 3 0
    //   1991: aload_0
    //   1992: getfield 64	com/tencent/mm/aw/a/f/b:hkB	Lcom/tencent/mm/aw/a/c;
    //   1995: aload 10
    //   1997: aload_0
    //   1998: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   2001: getfield 337	com/tencent/mm/aw/a/a/c:gjv	I
    //   2004: aload_0
    //   2005: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   2008: getfield 340	com/tencent/mm/aw/a/a/c:gjw	I
    //   2011: aload_0
    //   2012: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   2015: getfield 388	com/tencent/mm/aw/a/a/c:hke	Z
    //   2018: aload_0
    //   2019: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   2022: getfield 392	com/tencent/mm/aw/a/a/c:alpha	F
    //   2025: aload_0
    //   2026: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   2029: getfield 395	com/tencent/mm/aw/a/a/c:hjZ	Z
    //   2032: invokestatic 412	com/tencent/mm/aw/a/g/a:a	(Lcom/tencent/mm/aw/a/c;[BIIZFZ)Landroid/graphics/Bitmap;
    //   2035: astore 10
    //   2037: aload 10
    //   2039: astore 11
    //   2041: aload_0
    //   2042: getfield 96	com/tencent/mm/aw/a/f/b:hkr	Lcom/tencent/mm/aw/a/c/a;
    //   2045: ifnull +18 -> 2063
    //   2048: aload 10
    //   2050: astore 11
    //   2052: aload_0
    //   2053: getfield 96	com/tencent/mm/aw/a/f/b:hkr	Lcom/tencent/mm/aw/a/c/a;
    //   2056: aload 10
    //   2058: invokeinterface 447 2 0
    //   2063: aload 10
    //   2065: ifnonnull +24 -> 2089
    //   2068: aload 10
    //   2070: astore 11
    //   2072: aload 9
    //   2074: iconst_3
    //   2075: putfield 285	com/tencent/mm/aw/a/d/b:status	I
    //   2078: aload 10
    //   2080: astore 8
    //   2082: aload 9
    //   2084: astore 10
    //   2086: goto -1828 -> 258
    //   2089: aload 10
    //   2091: astore 11
    //   2093: aload 9
    //   2095: getfield 500	com/tencent/mm/aw/a/d/b:data	[B
    //   2098: astore 8
    //   2100: aload 10
    //   2102: astore 11
    //   2104: aload_0
    //   2105: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   2108: getfield 533	com/tencent/mm/aw/a/a/c:hjU	Z
    //   2111: ifeq +27 -> 2138
    //   2114: aload 10
    //   2116: astore 11
    //   2118: aload_0
    //   2119: getfield 105	com/tencent/mm/aw/a/f/b:hjI	Lcom/tencent/mm/aw/a/c/b;
    //   2122: aload_0
    //   2123: getfield 62	com/tencent/mm/aw/a/f/b:url	Ljava/lang/String;
    //   2126: aload 8
    //   2128: aload_0
    //   2129: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   2132: invokeinterface 536 4 0
    //   2137: pop
    //   2138: aload 10
    //   2140: astore 11
    //   2142: aload_0
    //   2143: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   2146: getfield 539	com/tencent/mm/aw/a/a/c:hjT	Z
    //   2149: ifeq +27 -> 2176
    //   2152: aload 10
    //   2154: astore 11
    //   2156: aload_0
    //   2157: getfield 105	com/tencent/mm/aw/a/f/b:hjI	Lcom/tencent/mm/aw/a/c/b;
    //   2160: aload_0
    //   2161: getfield 62	com/tencent/mm/aw/a/f/b:url	Ljava/lang/String;
    //   2164: aload 8
    //   2166: aload_0
    //   2167: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   2170: invokeinterface 536 4 0
    //   2175: pop
    //   2176: aload 10
    //   2178: astore 8
    //   2180: aload 10
    //   2182: astore 11
    //   2184: aload_0
    //   2185: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   2188: getfield 542	com/tencent/mm/aw/a/a/c:gkG	Z
    //   2191: ifeq +56 -> 2247
    //   2194: aload 10
    //   2196: astore 11
    //   2198: aload_0
    //   2199: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   2202: getfield 545	com/tencent/mm/aw/a/a/c:hkm	F
    //   2205: fconst_0
    //   2206: fcmpl
    //   2207: ifne +164 -> 2371
    //   2210: aload 10
    //   2212: astore 11
    //   2214: aload 10
    //   2216: invokevirtual 548	android/graphics/Bitmap:getWidth	()I
    //   2219: aload 10
    //   2221: invokevirtual 551	android/graphics/Bitmap:getHeight	()I
    //   2224: if_icmpne +68 -> 2292
    //   2227: aload 10
    //   2229: astore 11
    //   2231: aload 10
    //   2233: iconst_0
    //   2234: aload 10
    //   2236: invokevirtual 548	android/graphics/Bitmap:getWidth	()I
    //   2239: iconst_2
    //   2240: idiv
    //   2241: i2f
    //   2242: invokestatic 554	com/tencent/mm/sdk/platformtools/f:a	(Landroid/graphics/Bitmap;ZF)Landroid/graphics/Bitmap;
    //   2245: astore 8
    //   2247: aload 8
    //   2249: astore 11
    //   2251: aload_0
    //   2252: aload 9
    //   2254: aload 8
    //   2256: invokespecial 556	com/tencent/mm/aw/a/f/b:a	(Lcom/tencent/mm/aw/a/d/b;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   2259: astore 8
    //   2261: aload 8
    //   2263: astore 11
    //   2265: aload_0
    //   2266: aload 13
    //   2268: aload 8
    //   2270: invokespecial 558	com/tencent/mm/aw/a/f/b:j	(Ljava/lang/String;Landroid/graphics/Bitmap;)V
    //   2273: aload 8
    //   2275: astore 11
    //   2277: aload_0
    //   2278: lload 5
    //   2280: lload_3
    //   2281: lsub
    //   2282: invokevirtual 559	com/tencent/mm/aw/a/f/b:mw	(J)V
    //   2285: aload 9
    //   2287: astore 10
    //   2289: goto -2031 -> 258
    //   2292: aload 10
    //   2294: astore 11
    //   2296: aload 10
    //   2298: invokevirtual 548	android/graphics/Bitmap:getWidth	()I
    //   2301: aload 10
    //   2303: invokevirtual 551	android/graphics/Bitmap:getHeight	()I
    //   2306: invokestatic 565	java/lang/Math:min	(II)I
    //   2309: istore_2
    //   2310: iload_2
    //   2311: istore_1
    //   2312: iload_2
    //   2313: ifgt +21 -> 2334
    //   2316: aload 10
    //   2318: astore 11
    //   2320: aload 10
    //   2322: invokevirtual 548	android/graphics/Bitmap:getWidth	()I
    //   2325: aload 10
    //   2327: invokevirtual 551	android/graphics/Bitmap:getHeight	()I
    //   2330: invokestatic 568	java/lang/Math:max	(II)I
    //   2333: istore_1
    //   2334: aload 10
    //   2336: astore 11
    //   2338: aload 10
    //   2340: iload_1
    //   2341: iload_1
    //   2342: iconst_1
    //   2343: invokestatic 571	com/tencent/mm/sdk/platformtools/f:b	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   2346: astore 8
    //   2348: aload 8
    //   2350: astore 11
    //   2352: aload 8
    //   2354: iconst_0
    //   2355: aload 8
    //   2357: invokevirtual 548	android/graphics/Bitmap:getWidth	()I
    //   2360: iconst_2
    //   2361: idiv
    //   2362: i2f
    //   2363: invokestatic 554	com/tencent/mm/sdk/platformtools/f:a	(Landroid/graphics/Bitmap;ZF)Landroid/graphics/Bitmap;
    //   2366: astore 8
    //   2368: goto -121 -> 2247
    //   2371: aload 10
    //   2373: astore 11
    //   2375: aload 10
    //   2377: iconst_0
    //   2378: aload_0
    //   2379: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   2382: getfield 545	com/tencent/mm/aw/a/a/c:hkm	F
    //   2385: invokestatic 554	com/tencent/mm/sdk/platformtools/f:a	(Landroid/graphics/Bitmap;ZF)Landroid/graphics/Bitmap;
    //   2388: astore 8
    //   2390: goto -143 -> 2247
    //   2393: aload 9
    //   2395: iconst_2
    //   2396: putfield 285	com/tencent/mm/aw/a/d/b:status	I
    //   2399: ldc 165
    //   2401: ldc_w 573
    //   2404: invokestatic 262	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   2407: aconst_null
    //   2408: astore 8
    //   2410: aload 9
    //   2412: astore 10
    //   2414: goto -2156 -> 258
    //   2417: ldc 165
    //   2419: ldc_w 575
    //   2422: invokestatic 262	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   2425: goto -2167 -> 258
    //   2428: aload_0
    //   2429: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   2432: getfield 542	com/tencent/mm/aw/a/a/c:gkG	Z
    //   2435: ifeq +364 -> 2799
    //   2438: aload_0
    //   2439: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   2442: getfield 545	com/tencent/mm/aw/a/a/c:hkm	F
    //   2445: fconst_0
    //   2446: fcmpl
    //   2447: ifne +168 -> 2615
    //   2450: aload 8
    //   2452: invokevirtual 548	android/graphics/Bitmap:getWidth	()I
    //   2455: aload 8
    //   2457: invokevirtual 551	android/graphics/Bitmap:getHeight	()I
    //   2460: if_icmpne +88 -> 2548
    //   2463: aload 8
    //   2465: iconst_0
    //   2466: aload 8
    //   2468: invokevirtual 548	android/graphics/Bitmap:getWidth	()I
    //   2471: iconst_2
    //   2472: idiv
    //   2473: i2f
    //   2474: invokestatic 554	com/tencent/mm/sdk/platformtools/f:a	(Landroid/graphics/Bitmap;ZF)Landroid/graphics/Bitmap;
    //   2477: astore 9
    //   2479: aload 9
    //   2481: astore 8
    //   2483: aload_0
    //   2484: aload 10
    //   2486: aload 9
    //   2488: invokespecial 556	com/tencent/mm/aw/a/f/b:a	(Lcom/tencent/mm/aw/a/d/b;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   2491: astore 9
    //   2493: aload 9
    //   2495: astore 8
    //   2497: aload 10
    //   2499: getfield 578	com/tencent/mm/aw/a/d/b:hkx	Z
    //   2502: ifne +15 -> 2517
    //   2505: aload 9
    //   2507: astore 8
    //   2509: aload_0
    //   2510: aload 13
    //   2512: aload 9
    //   2514: invokespecial 558	com/tencent/mm/aw/a/f/b:j	(Ljava/lang/String;Landroid/graphics/Bitmap;)V
    //   2517: aload 9
    //   2519: astore 8
    //   2521: aload_0
    //   2522: lload 5
    //   2524: lload_3
    //   2525: lsub
    //   2526: invokevirtual 559	com/tencent/mm/aw/a/f/b:mw	(J)V
    //   2529: aload 9
    //   2531: astore 8
    //   2533: ldc 165
    //   2535: ldc_w 580
    //   2538: invokestatic 237	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   2541: aload 9
    //   2543: astore 8
    //   2545: goto -2287 -> 258
    //   2548: aload 8
    //   2550: invokevirtual 548	android/graphics/Bitmap:getWidth	()I
    //   2553: aload 8
    //   2555: invokevirtual 551	android/graphics/Bitmap:getHeight	()I
    //   2558: invokestatic 565	java/lang/Math:min	(II)I
    //   2561: istore_2
    //   2562: iload_2
    //   2563: istore_1
    //   2564: iload_2
    //   2565: ifgt +17 -> 2582
    //   2568: aload 8
    //   2570: invokevirtual 548	android/graphics/Bitmap:getWidth	()I
    //   2573: aload 8
    //   2575: invokevirtual 551	android/graphics/Bitmap:getHeight	()I
    //   2578: invokestatic 568	java/lang/Math:max	(II)I
    //   2581: istore_1
    //   2582: aload 8
    //   2584: iload_1
    //   2585: iload_1
    //   2586: iconst_1
    //   2587: invokestatic 571	com/tencent/mm/sdk/platformtools/f:b	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   2590: astore 9
    //   2592: aload 9
    //   2594: astore 8
    //   2596: aload 9
    //   2598: iconst_0
    //   2599: aload 9
    //   2601: invokevirtual 548	android/graphics/Bitmap:getWidth	()I
    //   2604: iconst_2
    //   2605: idiv
    //   2606: i2f
    //   2607: invokestatic 554	com/tencent/mm/sdk/platformtools/f:a	(Landroid/graphics/Bitmap;ZF)Landroid/graphics/Bitmap;
    //   2610: astore 9
    //   2612: goto -133 -> 2479
    //   2615: aload 8
    //   2617: iconst_0
    //   2618: aload_0
    //   2619: getfield 80	com/tencent/mm/aw/a/f/b:hjG	Lcom/tencent/mm/aw/a/a/c;
    //   2622: getfield 545	com/tencent/mm/aw/a/a/c:hkm	F
    //   2625: invokestatic 554	com/tencent/mm/sdk/platformtools/f:a	(Landroid/graphics/Bitmap;ZF)Landroid/graphics/Bitmap;
    //   2628: astore 9
    //   2630: goto -151 -> 2479
    //   2633: new 582	com/tencent/mm/aw/a/f/c
    //   2636: dup
    //   2637: aload_0
    //   2638: getfield 62	com/tencent/mm/aw/a/f/b:url	Ljava/lang/String;
    //   2641: aload_0
    //   2642: getfield 64	com/tencent/mm/aw/a/f/b:hkB	Lcom/tencent/mm/aw/a/c;
    //   2645: aload 9
    //   2647: aload_0
    //   2648: getfield 68	com/tencent/mm/aw/a/f/b:hkz	Lcom/tencent/mm/aw/a/b;
    //   2651: aload_0
    //   2652: aload_0
    //   2653: getfield 62	com/tencent/mm/aw/a/f/b:url	Ljava/lang/String;
    //   2656: invokevirtual 206	com/tencent/mm/aw/a/f/b:yF	(Ljava/lang/String;)Ljava/lang/String;
    //   2659: invokespecial 585	com/tencent/mm/aw/a/f/c:<init>	(Ljava/lang/String;Lcom/tencent/mm/aw/a/c;Landroid/graphics/Bitmap;Lcom/tencent/mm/aw/a/b;Ljava/lang/String;)V
    //   2662: astore 8
    //   2664: aload_0
    //   2665: getfield 66	com/tencent/mm/aw/a/f/b:hkC	Lcom/tencent/mm/sdk/platformtools/ap;
    //   2668: ifnull -2342 -> 326
    //   2671: aload_0
    //   2672: getfield 66	com/tencent/mm/aw/a/f/b:hkC	Lcom/tencent/mm/sdk/platformtools/ap;
    //   2675: aload 8
    //   2677: invokevirtual 591	com/tencent/mm/sdk/platformtools/ap:post	(Ljava/lang/Runnable;)Z
    //   2680: pop
    //   2681: goto -2355 -> 326
    //   2684: ldc 165
    //   2686: ldc_w 593
    //   2689: invokestatic 262	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   2692: goto -2349 -> 343
    //   2695: astore 8
    //   2697: goto -1720 -> 977
    //   2700: astore 8
    //   2702: goto -1217 -> 1485
    //   2705: astore 8
    //   2707: goto -1145 -> 1562
    //   2710: astore 12
    //   2712: aload 10
    //   2714: astore 9
    //   2716: aload 8
    //   2718: astore 11
    //   2720: aload 12
    //   2722: astore 10
    //   2724: aload 9
    //   2726: astore 8
    //   2728: aload 11
    //   2730: astore 9
    //   2732: goto -1734 -> 998
    //   2735: astore 12
    //   2737: aload 10
    //   2739: astore 9
    //   2741: aload 8
    //   2743: astore 11
    //   2745: aload 12
    //   2747: astore 10
    //   2749: aload 9
    //   2751: astore 8
    //   2753: aload 11
    //   2755: astore 9
    //   2757: goto -1759 -> 998
    //   2760: astore 10
    //   2762: aload 8
    //   2764: astore 11
    //   2766: aload 9
    //   2768: astore 8
    //   2770: aload 11
    //   2772: astore 9
    //   2774: goto -1776 -> 998
    //   2777: astore 10
    //   2779: aload 9
    //   2781: astore 8
    //   2783: aload 11
    //   2785: astore 9
    //   2787: goto -1789 -> 998
    //   2790: astore 12
    //   2792: aload 9
    //   2794: astore 11
    //   2796: goto -1244 -> 1552
    //   2799: aload 8
    //   2801: astore 9
    //   2803: goto -324 -> 2479
    //   2806: goto -1009 -> 1797
    //   2809: aload 11
    //   2811: astore 8
    //   2813: goto -2584 -> 229
    //   2816: iconst_1
    //   2817: istore_1
    //   2818: aload 8
    //   2820: astore 12
    //   2822: goto -1351 -> 1471
    //   2825: goto -2617 -> 208
    //   2828: iload_2
    //   2829: tableswitch	default:+35 -> 2864, 1:+-412->2417, 2:+-412->2417, 3:+-412->2417, 4:+-412->2417, 5:+-1122->1707
    //   2865: <illegal opcode>
    //   2866: breakpoint
    //   2867: astore 10
    //   2869: aload 8
    //   2871: astore 11
    //   2873: aload 9
    //   2875: astore 8
    //   2877: aload 11
    //   2879: astore 9
    //   2881: goto -1883 -> 998
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2884	0	this	b
    //   1219	1599	1	i	int
    //   82	2747	2	j	int
    //   74	2451	3	l1	long
    //   232	2291	5	l2	long
    //   90	1750	7	bool	boolean
    //   26	917	8	localObject1	Object
    //   956	17	8	localIOException1	java.io.IOException
    //   989	1687	8	localObject2	Object
    //   2695	1	8	localIOException2	java.io.IOException
    //   2700	1	8	localIOException3	java.io.IOException
    //   2705	12	8	localIOException4	java.io.IOException
    //   2726	150	8	localObject3	Object
    //   281	680	9	localObject4	Object
    //   965	18	9	localObject5	Object
    //   992	557	9	localObject6	Object
    //   1570	7	9	localException1	java.lang.Exception
    //   1582	1298	9	localObject7	Object
    //   35	2713	10	localObject8	Object
    //   2760	1	10	localException2	java.lang.Exception
    //   2777	1	10	localException3	java.lang.Exception
    //   2867	1	10	localException4	java.lang.Exception
    //   551	408	11	localObject9	Object
    //   985	10	11	localException5	java.lang.Exception
    //   1146	1732	11	localObject10	Object
    //   879	660	12	localObject11	Object
    //   1543	25	12	localObject12	Object
    //   1936	17	12	arrayOfByte	byte[]
    //   2710	11	12	localException6	java.lang.Exception
    //   2735	11	12	localException7	java.lang.Exception
    //   2790	1	12	localObject13	Object
    //   2820	1	12	localObject14	Object
    //   51	2460	13	str1	String
    //   99	1750	14	str2	String
    // Exception table:
    //   from	to	target	type
    //   944	949	956	java/io/IOException
    //   850	856	965	finally
    //   860	868	965	finally
    //   872	881	965	finally
    //   885	931	965	finally
    //   43	171	985	java/lang/Exception
    //   208	226	985	java/lang/Exception
    //   475	545	985	java/lang/Exception
    //   586	611	985	java/lang/Exception
    //   614	634	985	java/lang/Exception
    //   639	657	985	java/lang/Exception
    //   657	694	985	java/lang/Exception
    //   832	838	985	java/lang/Exception
    //   972	977	985	java/lang/Exception
    //   977	985	985	java/lang/Exception
    //   1029	1096	985	java/lang/Exception
    //   1099	1126	985	java/lang/Exception
    //   1151	1170	985	java/lang/Exception
    //   1176	1195	985	java/lang/Exception
    //   1201	1209	985	java/lang/Exception
    //   1587	1614	985	java/lang/Exception
    //   1617	1666	985	java/lang/Exception
    //   1669	1704	985	java/lang/Exception
    //   1224	1231	1543	finally
    //   1235	1248	1543	finally
    //   1252	1271	1543	finally
    //   1275	1282	1543	finally
    //   1286	1295	1543	finally
    //   1317	1333	1543	finally
    //   1341	1348	1543	finally
    //   1352	1363	1543	finally
    //   1367	1374	1543	finally
    //   1378	1393	1543	finally
    //   1397	1443	1543	finally
    //   1557	1562	1570	java/lang/Exception
    //   1562	1570	1570	java/lang/Exception
    //   972	977	2695	java/io/IOException
    //   1480	1485	2700	java/io/IOException
    //   1557	1562	2705	java/io/IOException
    //   553	563	2710	java/lang/Exception
    //   567	579	2710	java/lang/Exception
    //   702	712	2710	java/lang/Exception
    //   729	736	2710	java/lang/Exception
    //   740	747	2710	java/lang/Exception
    //   751	778	2710	java/lang/Exception
    //   787	797	2710	java/lang/Exception
    //   801	813	2710	java/lang/Exception
    //   817	825	2710	java/lang/Exception
    //   944	949	2710	java/lang/Exception
    //   1133	1148	2710	java/lang/Exception
    //   1480	1485	2710	java/lang/Exception
    //   1506	1524	2710	java/lang/Exception
    //   2483	2493	2710	java/lang/Exception
    //   2497	2505	2710	java/lang/Exception
    //   2509	2517	2710	java/lang/Exception
    //   2521	2529	2710	java/lang/Exception
    //   2533	2541	2710	java/lang/Exception
    //   2596	2612	2710	java/lang/Exception
    //   229	234	2735	java/lang/Exception
    //   239	247	2735	java/lang/Exception
    //   250	258	2735	java/lang/Exception
    //   1707	1746	2735	java/lang/Exception
    //   1746	1777	2735	java/lang/Exception
    //   1824	1832	2735	java/lang/Exception
    //   2417	2425	2735	java/lang/Exception
    //   2428	2479	2735	java/lang/Exception
    //   2548	2562	2735	java/lang/Exception
    //   2568	2582	2735	java/lang/Exception
    //   2582	2592	2735	java/lang/Exception
    //   2615	2630	2735	java/lang/Exception
    //   1782	1793	2760	java/lang/Exception
    //   2041	2048	2777	java/lang/Exception
    //   2052	2063	2777	java/lang/Exception
    //   2072	2078	2777	java/lang/Exception
    //   2093	2100	2777	java/lang/Exception
    //   2104	2114	2777	java/lang/Exception
    //   2118	2138	2777	java/lang/Exception
    //   2142	2152	2777	java/lang/Exception
    //   2156	2176	2777	java/lang/Exception
    //   2184	2194	2777	java/lang/Exception
    //   2198	2210	2777	java/lang/Exception
    //   2214	2227	2777	java/lang/Exception
    //   2231	2247	2777	java/lang/Exception
    //   2251	2261	2777	java/lang/Exception
    //   2265	2273	2777	java/lang/Exception
    //   2277	2285	2777	java/lang/Exception
    //   2296	2310	2777	java/lang/Exception
    //   2320	2334	2777	java/lang/Exception
    //   2338	2348	2777	java/lang/Exception
    //   2352	2368	2777	java/lang/Exception
    //   2375	2390	2777	java/lang/Exception
    //   1447	1465	2790	finally
    //   1797	1817	2867	java/lang/Exception
    //   1844	1863	2867	java/lang/Exception
    //   1863	1883	2867	java/lang/Exception
    //   1887	1938	2867	java/lang/Exception
    //   1938	1946	2867	java/lang/Exception
    //   1950	1959	2867	java/lang/Exception
    //   1962	1969	2867	java/lang/Exception
    //   1969	1991	2867	java/lang/Exception
    //   1991	2037	2867	java/lang/Exception
    //   2393	2407	2867	java/lang/Exception
  }
  
  public final String yF(String paramString)
  {
    AppMethodBeat.i(130439);
    if ((bt.isNullOrNil(paramString)) || (this.hjG == null))
    {
      AppMethodBeat.o(130439);
      return null;
    }
    String str = paramString;
    if (this.hjG.gkG) {
      str = paramString + "round" + this.hjG.hkm;
    }
    paramString = str;
    if (!bt.isNullOrNil(this.hjG.hkk)) {
      paramString = str + this.hjG.hkk;
    }
    paramString = paramString + "size" + this.hjG.gjv + this.hjG.gjw;
    AppMethodBeat.o(130439);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.aw.a.f.b
 * JD-Core Version:    0.7.0.1
 */