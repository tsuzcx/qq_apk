package com.tencent.mm.av.a.f;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.c.a;
import com.tencent.mm.av.a.c.e;
import com.tencent.mm.av.a.c.f;
import com.tencent.mm.av.a.c.g;
import com.tencent.mm.av.a.c.h;
import com.tencent.mm.av.a.c.i;
import com.tencent.mm.av.a.c.k;
import com.tencent.mm.av.a.c.l;
import com.tencent.mm.av.a.c.m;
import com.tencent.mm.av.a.c.n;
import com.tencent.mm.av.a.c.o;
import com.tencent.mm.av.a.c.p;
import com.tencent.mm.av.a.c.q;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;

public final class b
  implements Runnable
{
  private final com.tencent.mm.av.a.a.b ifO;
  public final com.tencent.mm.av.a.a.c ifW;
  private final o ifX;
  private final com.tencent.mm.av.a.c.b ifY;
  private final com.tencent.mm.av.a.c.c ifZ;
  private final q igG;
  private final a igH;
  private final i igI;
  private final com.tencent.mm.av.a.b igP;
  public final com.tencent.mm.av.a.c igR;
  private final aq igS;
  private final k igT;
  private final h igU;
  private final g igV;
  private final m igW;
  private final e igX;
  private final n igY;
  private final l igb;
  private final f igd;
  private final p igg;
  public final String url;
  
  public b(String paramString, com.tencent.mm.av.a.c paramc, aq paramaq, com.tencent.mm.av.a.a.c paramc1, k paramk, com.tencent.mm.av.a.b paramb, h paramh)
  {
    AppMethodBeat.i(130435);
    this.url = paramString;
    this.igR = paramc;
    this.igS = paramaq;
    this.igP = paramb;
    this.igU = paramh;
    this.ifO = this.igP.ifO;
    if (paramc1 == null)
    {
      this.ifW = this.ifO.ifW;
      this.igT = paramk;
      this.igb = this.ifO.igb;
      if (this.ifW.ifZ == null) {
        break label225;
      }
    }
    label225:
    for (this.ifZ = this.ifW.ifZ;; this.ifZ = this.ifO.ifZ)
    {
      this.igG = this.ifW.igG;
      this.igH = this.ifW.igH;
      this.igI = this.ifW.igI;
      this.ifX = this.ifO.ifX;
      this.ifY = this.ifO.ifY;
      this.igV = this.ifO.iga;
      this.igW = this.ifO.igc;
      this.igd = this.ifO.igd;
      this.igX = null;
      this.igY = null;
      this.igg = this.ifO.igg;
      AppMethodBeat.o(130435);
      return;
      this.ifW = paramc1;
      break;
    }
  }
  
  private Bitmap a(com.tencent.mm.av.a.d.b paramb, Bitmap paramBitmap)
  {
    AppMethodBeat.i(130438);
    if ((this.igU != null) && (paramb != null))
    {
      paramb.bitmap = paramBitmap;
      paramb = this.igU.a(this.url, this.igR.getImageView(), paramb);
      if ((paramb != null) && (!paramb.isRecycled()))
      {
        AppMethodBeat.o(130438);
        return paramb;
      }
    }
    AppMethodBeat.o(130438);
    return paramBitmap;
  }
  
  private void i(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(130437);
    if (this.ifW.igi)
    {
      ae.d("MicroMsg.imageloader.ImageLoadTask", "[cpan] run. put key %s to memory cache.", new Object[] { this.url });
      this.ifX.put(paramString, paramBitmap);
    }
    AppMethodBeat.o(130437);
  }
  
  public final String Gq(String paramString)
  {
    AppMethodBeat.i(130439);
    if ((bu.isNullOrNil(paramString)) || (this.ifW == null))
    {
      AppMethodBeat.o(130439);
      return null;
    }
    String str = paramString;
    if (this.ifW.hhW) {
      str = paramString + "round" + this.ifW.igC;
    }
    paramString = str;
    if (!bu.isNullOrNil(this.ifW.igA)) {
      paramString = str + this.ifW.igA;
    }
    paramString = paramString + "size" + this.ifW.hgF + this.ifW.hgG;
    AppMethodBeat.o(130439);
    return paramString;
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: ldc 230
    //   2: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 99	com/tencent/mm/av/a/f/b:igI	Lcom/tencent/mm/av/a/c/i;
    //   9: ifnull +16 -> 25
    //   12: aload_0
    //   13: getfield 99	com/tencent/mm/av/a/f/b:igI	Lcom/tencent/mm/av/a/c/i;
    //   16: aload_0
    //   17: getfield 62	com/tencent/mm/av/a/f/b:url	Ljava/lang/String;
    //   20: invokeinterface 236 2 0
    //   25: aconst_null
    //   26: astore 8
    //   28: new 135	com/tencent/mm/av/a/d/b
    //   31: dup
    //   32: invokespecial 237	com/tencent/mm/av/a/d/b:<init>	()V
    //   35: astore 10
    //   37: aload 10
    //   39: iconst_1
    //   40: putfield 240	com/tencent/mm/av/a/d/b:from	I
    //   43: aload_0
    //   44: aload_0
    //   45: getfield 62	com/tencent/mm/av/a/f/b:url	Ljava/lang/String;
    //   48: invokevirtual 242	com/tencent/mm/av/a/f/b:Gq	(Ljava/lang/String;)Ljava/lang/String;
    //   51: astore 13
    //   53: ldc 164
    //   55: ldc 244
    //   57: iconst_1
    //   58: anewarray 4	java/lang/Object
    //   61: dup
    //   62: iconst_0
    //   63: aload_0
    //   64: getfield 62	com/tencent/mm/av/a/f/b:url	Ljava/lang/String;
    //   67: aastore
    //   68: invokestatic 172	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   71: invokestatic 250	java/lang/System:currentTimeMillis	()J
    //   74: lstore_3
    //   75: aload_0
    //   76: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   79: getfield 253	com/tencent/mm/av/a/a/c:ign	I
    //   82: istore_2
    //   83: aload_0
    //   84: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   87: getfield 256	com/tencent/mm/av/a/a/c:igo	Z
    //   90: istore 7
    //   92: aload_0
    //   93: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   96: getfield 259	com/tencent/mm/av/a/a/c:md5	Ljava/lang/String;
    //   99: astore 14
    //   101: ldc 164
    //   103: ldc_w 261
    //   106: iload 7
    //   108: invokestatic 267	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   111: invokevirtual 270	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   114: invokestatic 273	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   117: ldc 164
    //   119: ldc_w 275
    //   122: iconst_1
    //   123: anewarray 4	java/lang/Object
    //   126: dup
    //   127: iconst_0
    //   128: iload_2
    //   129: invokestatic 280	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   132: aastore
    //   133: invokestatic 172	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   136: ldc 164
    //   138: ldc_w 282
    //   141: iconst_2
    //   142: anewarray 4	java/lang/Object
    //   145: dup
    //   146: iconst_0
    //   147: aload_0
    //   148: getfield 64	com/tencent/mm/av/a/f/b:igR	Lcom/tencent/mm/av/a/c;
    //   151: getfield 285	com/tencent/mm/av/a/c:width	I
    //   154: invokestatic 280	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   157: aastore
    //   158: dup
    //   159: iconst_1
    //   160: aload_0
    //   161: getfield 64	com/tencent/mm/av/a/f/b:igR	Lcom/tencent/mm/av/a/c;
    //   164: getfield 288	com/tencent/mm/av/a/c:height	I
    //   167: invokestatic 280	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   170: aastore
    //   171: invokestatic 172	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   174: iload_2
    //   175: tableswitch	default:+2651 -> 2826, 1:+301->476, 2:+1413->1588, 3:+1443->1618, 4:+1495->1670, 5:+1041->1216
    //   209: if_icmple +4865 -> 5074
    //   212: fload_0
    //   213: iconst_1
    //   214: anewarray 4	java/lang/Object
    //   217: dup
    //   218: iconst_0
    //   219: iload_2
    //   220: invokestatic 280	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   223: aastore
    //   224: invokestatic 293	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   227: aconst_null
    //   228: astore 8
    //   230: invokestatic 250	java/lang/System:currentTimeMillis	()J
    //   233: lstore 5
    //   235: aload 8
    //   237: ifnull +2592 -> 2829
    //   240: aload 8
    //   242: invokevirtual 156	android/graphics/Bitmap:isRecycled	()Z
    //   245: ifeq +2184 -> 2429
    //   248: goto +2581 -> 2829
    //   251: ldc 164
    //   253: ldc_w 295
    //   256: invokestatic 298	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   259: aload 8
    //   261: ifnull +2424 -> 2685
    //   264: aload 8
    //   266: invokevirtual 156	android/graphics/Bitmap:isRecycled	()Z
    //   269: ifne +2416 -> 2685
    //   272: ldc 164
    //   274: ldc_w 300
    //   277: invokestatic 273	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   280: aload 8
    //   282: astore 9
    //   284: aload_0
    //   285: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   288: getfield 303	com/tencent/mm/av/a/a/c:igq	Z
    //   291: ifeq +17 -> 308
    //   294: aload 8
    //   296: aload_0
    //   297: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   300: getfield 306	com/tencent/mm/av/a/a/c:igr	I
    //   303: invokestatic 312	com/tencent/mm/sdk/platformtools/h:l	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   306: astore 9
    //   308: aload 10
    //   310: getfield 315	com/tencent/mm/av/a/d/b:igO	Z
    //   313: ifeq +2321 -> 2634
    //   316: aload_0
    //   317: getfield 68	com/tencent/mm/av/a/f/b:igP	Lcom/tencent/mm/av/a/b;
    //   320: aload_0
    //   321: getfield 64	com/tencent/mm/av/a/f/b:igR	Lcom/tencent/mm/av/a/c;
    //   324: invokevirtual 318	com/tencent/mm/av/a/b:a	(Lcom/tencent/mm/av/a/c;)V
    //   327: aload 10
    //   329: aload 9
    //   331: putfield 139	com/tencent/mm/av/a/d/b:bitmap	Landroid/graphics/Bitmap;
    //   334: aload 10
    //   336: iconst_0
    //   337: putfield 321	com/tencent/mm/av/a/d/b:status	I
    //   340: aload 9
    //   342: astore 8
    //   344: aload_0
    //   345: getfield 99	com/tencent/mm/av/a/f/b:igI	Lcom/tencent/mm/av/a/c/i;
    //   348: ifnull +12 -> 360
    //   351: aload_0
    //   352: getfield 99	com/tencent/mm/av/a/f/b:igI	Lcom/tencent/mm/av/a/c/i;
    //   355: invokeinterface 324 1 0
    //   360: aload_0
    //   361: getfield 70	com/tencent/mm/av/a/f/b:igU	Lcom/tencent/mm/av/a/c/h;
    //   364: ifnull +37 -> 401
    //   367: aload 10
    //   369: ifnull +32 -> 401
    //   372: aload 10
    //   374: aload 8
    //   376: putfield 139	com/tencent/mm/av/a/d/b:bitmap	Landroid/graphics/Bitmap;
    //   379: aload_0
    //   380: getfield 70	com/tencent/mm/av/a/f/b:igU	Lcom/tencent/mm/av/a/c/h;
    //   383: aload_0
    //   384: getfield 62	com/tencent/mm/av/a/f/b:url	Ljava/lang/String;
    //   387: aload_0
    //   388: getfield 64	com/tencent/mm/av/a/f/b:igR	Lcom/tencent/mm/av/a/c;
    //   391: invokevirtual 145	com/tencent/mm/av/a/c:getImageView	()Landroid/widget/ImageView;
    //   394: aload 10
    //   396: invokeinterface 328 4 0
    //   401: aload_0
    //   402: getfield 82	com/tencent/mm/av/a/f/b:igT	Lcom/tencent/mm/av/a/c/k;
    //   405: aload_0
    //   406: getfield 62	com/tencent/mm/av/a/f/b:url	Ljava/lang/String;
    //   409: aload_0
    //   410: getfield 64	com/tencent/mm/av/a/f/b:igR	Lcom/tencent/mm/av/a/c;
    //   413: invokevirtual 145	com/tencent/mm/av/a/c:getImageView	()Landroid/widget/ImageView;
    //   416: aload 8
    //   418: aload_0
    //   419: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   422: getfield 332	com/tencent/mm/av/a/a/c:igJ	[Ljava/lang/Object;
    //   425: invokeinterface 337 5 0
    //   430: aload_0
    //   431: getfield 68	com/tencent/mm/av/a/f/b:igP	Lcom/tencent/mm/av/a/b;
    //   434: astore 8
    //   436: aload 8
    //   438: getfield 341	com/tencent/mm/av/a/b:ifS	Ljava/util/HashMap;
    //   441: ifnull +29 -> 470
    //   444: aload_0
    //   445: getfield 64	com/tencent/mm/av/a/f/b:igR	Lcom/tencent/mm/av/a/c;
    //   448: ifnull +22 -> 470
    //   451: aload 8
    //   453: getfield 341	com/tencent/mm/av/a/b:ifS	Ljava/util/HashMap;
    //   456: aload_0
    //   457: getfield 64	com/tencent/mm/av/a/f/b:igR	Lcom/tencent/mm/av/a/c;
    //   460: getfield 344	com/tencent/mm/av/a/c:hhK	I
    //   463: invokestatic 280	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   466: invokevirtual 350	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   469: pop
    //   470: ldc 230
    //   472: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   475: return
    //   476: aload_0
    //   477: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   480: getfield 353	com/tencent/mm/av/a/a/c:thumbPath	Ljava/lang/String;
    //   483: astore 8
    //   485: aload_0
    //   486: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   489: getfield 356	com/tencent/mm/av/a/a/c:igs	Z
    //   492: ifeq +123 -> 615
    //   495: aload 8
    //   497: invokestatic 186	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   500: ifne +115 -> 615
    //   503: aload 8
    //   505: invokestatic 361	com/tencent/mm/vfs/o:fB	(Ljava/lang/String;)Z
    //   508: ifeq +107 -> 615
    //   511: aload_0
    //   512: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   515: getfield 364	com/tencent/mm/av/a/a/c:igD	Z
    //   518: ifeq +69 -> 587
    //   521: aload_0
    //   522: getfield 64	com/tencent/mm/av/a/f/b:igR	Lcom/tencent/mm/av/a/c;
    //   525: aload 8
    //   527: aload_0
    //   528: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   531: getfield 218	com/tencent/mm/av/a/a/c:hgF	I
    //   534: aload_0
    //   535: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   538: getfield 224	com/tencent/mm/av/a/a/c:hgG	I
    //   541: invokestatic 369	com/tencent/mm/av/a/g/a:b	(Lcom/tencent/mm/av/a/c;Ljava/lang/String;II)Landroid/graphics/Bitmap;
    //   544: astore 9
    //   546: aload 9
    //   548: astore 8
    //   550: aload 9
    //   552: astore 11
    //   554: aload_0
    //   555: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   558: getfield 372	com/tencent/mm/av/a/a/c:density	I
    //   561: ifle +2249 -> 2810
    //   564: aload 9
    //   566: astore 8
    //   568: aload 9
    //   570: aload_0
    //   571: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   574: getfield 372	com/tencent/mm/av/a/a/c:density	I
    //   577: invokevirtual 375	android/graphics/Bitmap:setDensity	(I)V
    //   580: aload 9
    //   582: astore 8
    //   584: goto -354 -> 230
    //   587: aload_0
    //   588: getfield 64	com/tencent/mm/av/a/f/b:igR	Lcom/tencent/mm/av/a/c;
    //   591: aload 8
    //   593: aload_0
    //   594: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   597: getfield 218	com/tencent/mm/av/a/a/c:hgF	I
    //   600: aload_0
    //   601: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   604: getfield 224	com/tencent/mm/av/a/a/c:hgG	I
    //   607: invokestatic 377	com/tencent/mm/av/a/g/a:a	(Lcom/tencent/mm/av/a/c;Ljava/lang/String;II)Landroid/graphics/Bitmap;
    //   610: astore 9
    //   612: goto -66 -> 546
    //   615: aload_0
    //   616: getfield 62	com/tencent/mm/av/a/f/b:url	Ljava/lang/String;
    //   619: invokestatic 186	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   622: ifne +580 -> 1202
    //   625: aload_0
    //   626: getfield 62	com/tencent/mm/av/a/f/b:url	Ljava/lang/String;
    //   629: invokestatic 361	com/tencent/mm/vfs/o:fB	(Ljava/lang/String;)Z
    //   632: ifeq +545 -> 1177
    //   635: iload 7
    //   637: ifeq +21 -> 658
    //   640: aload_0
    //   641: getfield 115	com/tencent/mm/av/a/f/b:igW	Lcom/tencent/mm/av/a/c/m;
    //   644: aload 14
    //   646: aload_0
    //   647: getfield 62	com/tencent/mm/av/a/f/b:url	Ljava/lang/String;
    //   650: invokeinterface 383 3 0
    //   655: ifeq +497 -> 1152
    //   658: aload_0
    //   659: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   662: getfield 364	com/tencent/mm/av/a/a/c:igD	Z
    //   665: ifeq +168 -> 833
    //   668: aload_0
    //   669: getfield 64	com/tencent/mm/av/a/f/b:igR	Lcom/tencent/mm/av/a/c;
    //   672: aload_0
    //   673: getfield 62	com/tencent/mm/av/a/f/b:url	Ljava/lang/String;
    //   676: aload_0
    //   677: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   680: getfield 218	com/tencent/mm/av/a/a/c:hgF	I
    //   683: aload_0
    //   684: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   687: getfield 224	com/tencent/mm/av/a/a/c:hgG	I
    //   690: invokestatic 369	com/tencent/mm/av/a/g/a:b	(Lcom/tencent/mm/av/a/c;Ljava/lang/String;II)Landroid/graphics/Bitmap;
    //   693: astore 9
    //   695: aload 9
    //   697: astore 11
    //   699: aload 9
    //   701: astore 8
    //   703: aload_0
    //   704: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   707: getfield 386	com/tencent/mm/av/a/a/c:igF	Z
    //   710: ifeq +69 -> 779
    //   713: aload 9
    //   715: astore 11
    //   717: aload 9
    //   719: ifnonnull +60 -> 779
    //   722: aload 9
    //   724: astore 11
    //   726: aload 9
    //   728: astore 8
    //   730: aload_0
    //   731: getfield 122	com/tencent/mm/av/a/f/b:igY	Lcom/tencent/mm/av/a/c/n;
    //   734: ifnull +45 -> 779
    //   737: aload 9
    //   739: astore 8
    //   741: aload_0
    //   742: getfield 120	com/tencent/mm/av/a/f/b:igX	Lcom/tencent/mm/av/a/c/e;
    //   745: ifnull +385 -> 1130
    //   748: aload 9
    //   750: astore 8
    //   752: aload_0
    //   753: getfield 122	com/tencent/mm/av/a/f/b:igY	Lcom/tencent/mm/av/a/c/n;
    //   756: aload_0
    //   757: getfield 120	com/tencent/mm/av/a/f/b:igX	Lcom/tencent/mm/av/a/c/e;
    //   760: aload_0
    //   761: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   764: getfield 332	com/tencent/mm/av/a/a/c:igJ	[Ljava/lang/Object;
    //   767: invokeinterface 391 2 0
    //   772: invokeinterface 397 2 0
    //   777: astore 11
    //   779: aload 11
    //   781: ifnull +33 -> 814
    //   784: aload 11
    //   786: astore 8
    //   788: aload_0
    //   789: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   792: getfield 372	com/tencent/mm/av/a/a/c:density	I
    //   795: ifle +19 -> 814
    //   798: aload 11
    //   800: astore 8
    //   802: aload 11
    //   804: aload_0
    //   805: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   808: getfield 372	com/tencent/mm/av/a/a/c:density	I
    //   811: invokevirtual 375	android/graphics/Bitmap:setDensity	(I)V
    //   814: aload 11
    //   816: astore 8
    //   818: ldc 164
    //   820: ldc_w 399
    //   823: invokestatic 273	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   826: aload 11
    //   828: astore 8
    //   830: goto -600 -> 230
    //   833: aload_0
    //   834: getfield 93	com/tencent/mm/av/a/f/b:igG	Lcom/tencent/mm/av/a/c/q;
    //   837: astore 8
    //   839: aload 8
    //   841: ifnull +189 -> 1030
    //   844: aconst_null
    //   845: astore 9
    //   847: aload 9
    //   849: astore 8
    //   851: aload_0
    //   852: getfield 93	com/tencent/mm/av/a/f/b:igG	Lcom/tencent/mm/av/a/c/q;
    //   855: astore 11
    //   857: aload 9
    //   859: astore 8
    //   861: aload_0
    //   862: getfield 62	com/tencent/mm/av/a/f/b:url	Ljava/lang/String;
    //   865: invokestatic 403	com/tencent/mm/vfs/o:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   868: pop
    //   869: aload 9
    //   871: astore 8
    //   873: aload 11
    //   875: invokeinterface 409 1 0
    //   880: astore 12
    //   882: aload 12
    //   884: astore 8
    //   886: aload_0
    //   887: getfield 64	com/tencent/mm/av/a/f/b:igR	Lcom/tencent/mm/av/a/c;
    //   890: aload 12
    //   892: aload_0
    //   893: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   896: getfield 218	com/tencent/mm/av/a/a/c:hgF	I
    //   899: aload_0
    //   900: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   903: getfield 224	com/tencent/mm/av/a/a/c:hgG	I
    //   906: aload_0
    //   907: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   910: getfield 412	com/tencent/mm/av/a/a/c:igu	Z
    //   913: aload_0
    //   914: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   917: getfield 415	com/tencent/mm/av/a/a/c:alpha	F
    //   920: aload_0
    //   921: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   924: getfield 418	com/tencent/mm/av/a/a/c:igp	Z
    //   927: invokestatic 421	com/tencent/mm/av/a/g/a:a	(Lcom/tencent/mm/av/a/c;Ljava/io/InputStream;IIZFZ)Landroid/graphics/Bitmap;
    //   930: astore 11
    //   932: aload 11
    //   934: astore 9
    //   936: aload 12
    //   938: ifnull -243 -> 695
    //   941: aload 11
    //   943: astore 8
    //   945: aload 12
    //   947: invokevirtual 426	java/io/InputStream:close	()V
    //   950: aload 11
    //   952: astore 9
    //   954: goto -259 -> 695
    //   957: astore 8
    //   959: aload 11
    //   961: astore 9
    //   963: goto -268 -> 695
    //   966: astore 9
    //   968: aload 8
    //   970: ifnull +8 -> 978
    //   973: aload 8
    //   975: invokevirtual 426	java/io/InputStream:close	()V
    //   978: ldc 230
    //   980: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   983: aload 9
    //   985: athrow
    //   986: astore 11
    //   988: aload 10
    //   990: astore 8
    //   992: aconst_null
    //   993: astore 9
    //   995: aload 11
    //   997: astore 10
    //   999: ldc 164
    //   1001: ldc_w 428
    //   1004: iconst_1
    //   1005: anewarray 4	java/lang/Object
    //   1008: dup
    //   1009: iconst_0
    //   1010: aload 10
    //   1012: invokevirtual 429	java/lang/Exception:toString	()Ljava/lang/String;
    //   1015: aastore
    //   1016: invokestatic 293	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1019: aload 8
    //   1021: astore 10
    //   1023: aload 9
    //   1025: astore 8
    //   1027: goto -768 -> 259
    //   1030: aload_0
    //   1031: getfield 120	com/tencent/mm/av/a/f/b:igX	Lcom/tencent/mm/av/a/c/e;
    //   1034: ifnull +66 -> 1100
    //   1037: aload_0
    //   1038: getfield 64	com/tencent/mm/av/a/f/b:igR	Lcom/tencent/mm/av/a/c;
    //   1041: aload_0
    //   1042: getfield 120	com/tencent/mm/av/a/f/b:igX	Lcom/tencent/mm/av/a/c/e;
    //   1045: aload_0
    //   1046: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   1049: getfield 332	com/tencent/mm/av/a/a/c:igJ	[Ljava/lang/Object;
    //   1052: invokeinterface 391 2 0
    //   1057: aload_0
    //   1058: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   1061: getfield 218	com/tencent/mm/av/a/a/c:hgF	I
    //   1064: aload_0
    //   1065: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   1068: getfield 224	com/tencent/mm/av/a/a/c:hgG	I
    //   1071: aload_0
    //   1072: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   1075: getfield 412	com/tencent/mm/av/a/a/c:igu	Z
    //   1078: aload_0
    //   1079: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   1082: getfield 415	com/tencent/mm/av/a/a/c:alpha	F
    //   1085: aload_0
    //   1086: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   1089: getfield 418	com/tencent/mm/av/a/a/c:igp	Z
    //   1092: invokestatic 432	com/tencent/mm/av/a/g/a:a	(Lcom/tencent/mm/av/a/c;[BIIZFZ)Landroid/graphics/Bitmap;
    //   1095: astore 9
    //   1097: goto -402 -> 695
    //   1100: aload_0
    //   1101: getfield 64	com/tencent/mm/av/a/f/b:igR	Lcom/tencent/mm/av/a/c;
    //   1104: aload_0
    //   1105: getfield 62	com/tencent/mm/av/a/f/b:url	Ljava/lang/String;
    //   1108: aload_0
    //   1109: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   1112: getfield 218	com/tencent/mm/av/a/a/c:hgF	I
    //   1115: aload_0
    //   1116: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   1119: getfield 224	com/tencent/mm/av/a/a/c:hgG	I
    //   1122: invokestatic 377	com/tencent/mm/av/a/g/a:a	(Lcom/tencent/mm/av/a/c;Ljava/lang/String;II)Landroid/graphics/Bitmap;
    //   1125: astore 9
    //   1127: goto -432 -> 695
    //   1130: aload 9
    //   1132: astore 8
    //   1134: aload_0
    //   1135: getfield 122	com/tencent/mm/av/a/f/b:igY	Lcom/tencent/mm/av/a/c/n;
    //   1138: aload_0
    //   1139: getfield 62	com/tencent/mm/av/a/f/b:url	Ljava/lang/String;
    //   1142: invokeinterface 436 2 0
    //   1147: astore 11
    //   1149: goto -370 -> 779
    //   1152: ldc 164
    //   1154: ldc_w 438
    //   1157: iconst_1
    //   1158: anewarray 4	java/lang/Object
    //   1161: dup
    //   1162: iconst_0
    //   1163: aload_0
    //   1164: getfield 62	com/tencent/mm/av/a/f/b:url	Ljava/lang/String;
    //   1167: aastore
    //   1168: invokestatic 440	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1171: aconst_null
    //   1172: astore 8
    //   1174: goto -944 -> 230
    //   1177: ldc 164
    //   1179: ldc_w 442
    //   1182: iconst_1
    //   1183: anewarray 4	java/lang/Object
    //   1186: dup
    //   1187: iconst_0
    //   1188: aload_0
    //   1189: getfield 62	com/tencent/mm/av/a/f/b:url	Ljava/lang/String;
    //   1192: aastore
    //   1193: invokestatic 440	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1196: aconst_null
    //   1197: astore 8
    //   1199: goto -969 -> 230
    //   1202: ldc 164
    //   1204: ldc_w 444
    //   1207: invokestatic 298	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1210: aconst_null
    //   1211: astore 8
    //   1213: goto -983 -> 230
    //   1216: aconst_null
    //   1217: astore 11
    //   1219: iconst_0
    //   1220: istore_1
    //   1221: aload 11
    //   1223: astore 9
    //   1225: aload_0
    //   1226: getfield 96	com/tencent/mm/av/a/f/b:igH	Lcom/tencent/mm/av/a/c/a;
    //   1229: ifnull +20 -> 1249
    //   1232: aload 11
    //   1234: astore 9
    //   1236: aload_0
    //   1237: getfield 96	com/tencent/mm/av/a/f/b:igH	Lcom/tencent/mm/av/a/c/a;
    //   1240: aload_0
    //   1241: getfield 62	com/tencent/mm/av/a/f/b:url	Ljava/lang/String;
    //   1244: invokeinterface 449 2 0
    //   1249: aload 11
    //   1251: astore 9
    //   1253: aload_0
    //   1254: getfield 105	com/tencent/mm/av/a/f/b:ifY	Lcom/tencent/mm/av/a/c/b;
    //   1257: aload_0
    //   1258: getfield 62	com/tencent/mm/av/a/f/b:url	Ljava/lang/String;
    //   1261: aload_0
    //   1262: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   1265: invokeinterface 454 3 0
    //   1270: astore 11
    //   1272: aload 11
    //   1274: astore 9
    //   1276: aload_0
    //   1277: getfield 96	com/tencent/mm/av/a/f/b:igH	Lcom/tencent/mm/av/a/c/a;
    //   1280: ifnull +16 -> 1296
    //   1283: aload 11
    //   1285: astore 9
    //   1287: aload_0
    //   1288: getfield 96	com/tencent/mm/av/a/f/b:igH	Lcom/tencent/mm/av/a/c/a;
    //   1291: invokeinterface 457 1 0
    //   1296: aload 11
    //   1298: astore 12
    //   1300: aload 8
    //   1302: astore 9
    //   1304: aload 11
    //   1306: ifnull +166 -> 1472
    //   1309: iload 7
    //   1311: ifeq +23 -> 1334
    //   1314: aload 11
    //   1316: astore 9
    //   1318: aload_0
    //   1319: getfield 115	com/tencent/mm/av/a/f/b:igW	Lcom/tencent/mm/av/a/c/m;
    //   1322: aload 14
    //   1324: aload 11
    //   1326: invokeinterface 460 3 0
    //   1331: ifeq +201 -> 1532
    //   1334: aload 11
    //   1336: astore 8
    //   1338: aload 11
    //   1340: astore 9
    //   1342: aload_0
    //   1343: getfield 93	com/tencent/mm/av/a/f/b:igG	Lcom/tencent/mm/av/a/c/q;
    //   1346: ifnull +18 -> 1364
    //   1349: aload 11
    //   1351: astore 9
    //   1353: aload_0
    //   1354: getfield 93	com/tencent/mm/av/a/f/b:igG	Lcom/tencent/mm/av/a/c/q;
    //   1357: invokeinterface 409 1 0
    //   1362: astore 8
    //   1364: aload 8
    //   1366: astore 9
    //   1368: aload_0
    //   1369: getfield 96	com/tencent/mm/av/a/f/b:igH	Lcom/tencent/mm/av/a/c/a;
    //   1372: ifnull +22 -> 1394
    //   1375: aload 8
    //   1377: astore 9
    //   1379: aload_0
    //   1380: getfield 96	com/tencent/mm/av/a/f/b:igH	Lcom/tencent/mm/av/a/c/a;
    //   1383: aload_0
    //   1384: getfield 62	com/tencent/mm/av/a/f/b:url	Ljava/lang/String;
    //   1387: aload 10
    //   1389: invokeinterface 463 3 0
    //   1394: aload 8
    //   1396: astore 9
    //   1398: aload_0
    //   1399: getfield 64	com/tencent/mm/av/a/f/b:igR	Lcom/tencent/mm/av/a/c;
    //   1402: aload 8
    //   1404: aload_0
    //   1405: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   1408: getfield 218	com/tencent/mm/av/a/a/c:hgF	I
    //   1411: aload_0
    //   1412: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   1415: getfield 224	com/tencent/mm/av/a/a/c:hgG	I
    //   1418: aload_0
    //   1419: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   1422: getfield 412	com/tencent/mm/av/a/a/c:igu	Z
    //   1425: aload_0
    //   1426: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   1429: getfield 415	com/tencent/mm/av/a/a/c:alpha	F
    //   1432: aload_0
    //   1433: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   1436: getfield 418	com/tencent/mm/av/a/a/c:igp	Z
    //   1439: invokestatic 421	com/tencent/mm/av/a/g/a:a	(Lcom/tencent/mm/av/a/c;Ljava/io/InputStream;IIZFZ)Landroid/graphics/Bitmap;
    //   1442: astore 11
    //   1444: aload 11
    //   1446: astore 9
    //   1448: aload_0
    //   1449: getfield 96	com/tencent/mm/av/a/f/b:igH	Lcom/tencent/mm/av/a/c/a;
    //   1452: ifnull +1365 -> 2817
    //   1455: aload_0
    //   1456: getfield 96	com/tencent/mm/av/a/f/b:igH	Lcom/tencent/mm/av/a/c/a;
    //   1459: aload 9
    //   1461: invokeinterface 467 2 0
    //   1466: iconst_1
    //   1467: istore_1
    //   1468: aload 8
    //   1470: astore 12
    //   1472: aload 12
    //   1474: ifnull +12 -> 1486
    //   1477: aload 9
    //   1479: astore 8
    //   1481: aload 12
    //   1483: invokevirtual 426	java/io/InputStream:close	()V
    //   1486: aload 9
    //   1488: astore 11
    //   1490: iload_1
    //   1491: ifeq +1319 -> 2810
    //   1494: aload 9
    //   1496: astore 11
    //   1498: aload 9
    //   1500: ifnonnull +1310 -> 2810
    //   1503: aload 9
    //   1505: astore 8
    //   1507: aload_0
    //   1508: getfield 105	com/tencent/mm/av/a/f/b:ifY	Lcom/tencent/mm/av/a/c/b;
    //   1511: aload_0
    //   1512: getfield 62	com/tencent/mm/av/a/f/b:url	Ljava/lang/String;
    //   1515: aload_0
    //   1516: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   1519: invokeinterface 471 3 0
    //   1524: pop
    //   1525: aload 9
    //   1527: astore 8
    //   1529: goto -1299 -> 230
    //   1532: iconst_1
    //   1533: istore_1
    //   1534: aconst_null
    //   1535: astore 9
    //   1537: aload 11
    //   1539: astore 12
    //   1541: goto -69 -> 1472
    //   1544: astore 12
    //   1546: aconst_null
    //   1547: astore 11
    //   1549: aload 9
    //   1551: astore 8
    //   1553: aload 8
    //   1555: ifnull +8 -> 1563
    //   1558: aload 8
    //   1560: invokevirtual 426	java/io/InputStream:close	()V
    //   1563: ldc 230
    //   1565: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1568: aload 12
    //   1570: athrow
    //   1571: astore 9
    //   1573: aload 10
    //   1575: astore 8
    //   1577: aload 9
    //   1579: astore 10
    //   1581: aload 11
    //   1583: astore 9
    //   1585: goto -586 -> 999
    //   1588: aload_0
    //   1589: getfield 64	com/tencent/mm/av/a/f/b:igR	Lcom/tencent/mm/av/a/c;
    //   1592: aload_0
    //   1593: getfield 62	com/tencent/mm/av/a/f/b:url	Ljava/lang/String;
    //   1596: aload_0
    //   1597: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   1600: getfield 218	com/tencent/mm/av/a/a/c:hgF	I
    //   1603: aload_0
    //   1604: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   1607: getfield 224	com/tencent/mm/av/a/a/c:hgG	I
    //   1610: invokestatic 473	com/tencent/mm/av/a/g/a:c	(Lcom/tencent/mm/av/a/c;Ljava/lang/String;II)Landroid/graphics/Bitmap;
    //   1613: astore 8
    //   1615: goto -1385 -> 230
    //   1618: aload_0
    //   1619: getfield 75	com/tencent/mm/av/a/f/b:ifO	Lcom/tencent/mm/av/a/a/b;
    //   1622: getfield 477	com/tencent/mm/av/a/a/b:aKG	Landroid/content/res/Resources;
    //   1625: aload_0
    //   1626: getfield 62	com/tencent/mm/av/a/f/b:url	Ljava/lang/String;
    //   1629: ldc_w 479
    //   1632: aload_0
    //   1633: getfield 75	com/tencent/mm/av/a/f/b:ifO	Lcom/tencent/mm/av/a/a/b;
    //   1636: getfield 482	com/tencent/mm/av/a/a/b:packageName	Ljava/lang/String;
    //   1639: invokevirtual 488	android/content/res/Resources:getIdentifier	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   1642: istore_1
    //   1643: aload_0
    //   1644: getfield 64	com/tencent/mm/av/a/f/b:igR	Lcom/tencent/mm/av/a/c;
    //   1647: iload_1
    //   1648: aload_0
    //   1649: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   1652: getfield 218	com/tencent/mm/av/a/a/c:hgF	I
    //   1655: aload_0
    //   1656: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   1659: getfield 224	com/tencent/mm/av/a/a/c:hgG	I
    //   1662: invokestatic 491	com/tencent/mm/av/a/g/a:a	(Lcom/tencent/mm/av/a/c;III)Landroid/graphics/Bitmap;
    //   1665: astore 8
    //   1667: goto -1437 -> 230
    //   1670: aload_0
    //   1671: getfield 62	com/tencent/mm/av/a/f/b:url	Ljava/lang/String;
    //   1674: invokestatic 494	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1677: invokevirtual 498	java/lang/Integer:intValue	()I
    //   1680: istore_1
    //   1681: aload_0
    //   1682: getfield 64	com/tencent/mm/av/a/f/b:igR	Lcom/tencent/mm/av/a/c;
    //   1685: iload_1
    //   1686: aload_0
    //   1687: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   1690: getfield 218	com/tencent/mm/av/a/a/c:hgF	I
    //   1693: aload_0
    //   1694: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   1697: getfield 224	com/tencent/mm/av/a/a/c:hgG	I
    //   1700: invokestatic 491	com/tencent/mm/av/a/g/a:a	(Lcom/tencent/mm/av/a/c;III)Landroid/graphics/Bitmap;
    //   1703: astore 8
    //   1705: goto -1475 -> 230
    //   1708: invokestatic 250	java/lang/System:currentTimeMillis	()J
    //   1711: lstore_3
    //   1712: ldc 164
    //   1714: ldc_w 500
    //   1717: invokestatic 273	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1720: aload_0
    //   1721: getfield 70	com/tencent/mm/av/a/f/b:igU	Lcom/tencent/mm/av/a/c/h;
    //   1724: ifnull +23 -> 1747
    //   1727: aload_0
    //   1728: getfield 70	com/tencent/mm/av/a/f/b:igU	Lcom/tencent/mm/av/a/c/h;
    //   1731: aload_0
    //   1732: getfield 62	com/tencent/mm/av/a/f/b:url	Ljava/lang/String;
    //   1735: aload_0
    //   1736: getfield 64	com/tencent/mm/av/a/f/b:igR	Lcom/tencent/mm/av/a/c;
    //   1739: invokevirtual 145	com/tencent/mm/av/a/c:getImageView	()Landroid/widget/ImageView;
    //   1742: invokeinterface 503 3 0
    //   1747: aload_0
    //   1748: getfield 125	com/tencent/mm/av/a/f/b:igg	Lcom/tencent/mm/av/a/c/p;
    //   1751: aload_0
    //   1752: getfield 62	com/tencent/mm/av/a/f/b:url	Ljava/lang/String;
    //   1755: invokeinterface 508 2 0
    //   1760: ifeq +65 -> 1825
    //   1763: aload_0
    //   1764: getfield 90	com/tencent/mm/av/a/f/b:ifZ	Lcom/tencent/mm/av/a/c/c;
    //   1767: aload_0
    //   1768: getfield 62	com/tencent/mm/av/a/f/b:url	Ljava/lang/String;
    //   1771: invokeinterface 514 2 0
    //   1776: astore 9
    //   1778: aload 9
    //   1780: ifnonnull +1027 -> 2807
    //   1783: new 135	com/tencent/mm/av/a/d/b
    //   1786: dup
    //   1787: aconst_null
    //   1788: aconst_null
    //   1789: invokespecial 517	com/tencent/mm/av/a/d/b:<init>	([BLjava/lang/String;)V
    //   1792: astore 10
    //   1794: aload 10
    //   1796: astore 9
    //   1798: aload 9
    //   1800: iconst_2
    //   1801: putfield 240	com/tencent/mm/av/a/d/b:from	I
    //   1804: aload 9
    //   1806: getfield 521	com/tencent/mm/av/a/d/b:data	[B
    //   1809: ifnonnull +31 -> 1840
    //   1812: aload 9
    //   1814: iconst_1
    //   1815: putfield 321	com/tencent/mm/av/a/d/b:status	I
    //   1818: aload 9
    //   1820: astore 10
    //   1822: goto -1563 -> 259
    //   1825: ldc 164
    //   1827: ldc_w 523
    //   1830: invokestatic 525	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1833: aload 10
    //   1835: astore 9
    //   1837: goto -59 -> 1778
    //   1840: iload 7
    //   1842: ifeq +22 -> 1864
    //   1845: aload_0
    //   1846: getfield 115	com/tencent/mm/av/a/f/b:igW	Lcom/tencent/mm/av/a/c/m;
    //   1849: aload 14
    //   1851: aload 9
    //   1853: getfield 521	com/tencent/mm/av/a/d/b:data	[B
    //   1856: invokeinterface 529 3 0
    //   1861: ifeq +533 -> 2394
    //   1864: ldc 164
    //   1866: ldc_w 531
    //   1869: invokestatic 273	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1872: invokestatic 250	java/lang/System:currentTimeMillis	()J
    //   1875: lstore 5
    //   1877: aload 9
    //   1879: getfield 521	com/tencent/mm/av/a/d/b:data	[B
    //   1882: astore 11
    //   1884: aload 11
    //   1886: astore 10
    //   1888: aload_0
    //   1889: getfield 93	com/tencent/mm/av/a/f/b:igG	Lcom/tencent/mm/av/a/c/q;
    //   1892: ifnull +78 -> 1970
    //   1895: aload_0
    //   1896: getfield 93	com/tencent/mm/av/a/f/b:igG	Lcom/tencent/mm/av/a/c/q;
    //   1899: astore 10
    //   1901: new 533	java/io/ByteArrayInputStream
    //   1904: dup
    //   1905: aload 11
    //   1907: invokespecial 536	java/io/ByteArrayInputStream:<init>	([B)V
    //   1910: pop
    //   1911: aload 10
    //   1913: invokeinterface 409 1 0
    //   1918: astore 10
    //   1920: new 538	java/io/ByteArrayOutputStream
    //   1923: dup
    //   1924: aload 11
    //   1926: arraylength
    //   1927: invokespecial 540	java/io/ByteArrayOutputStream:<init>	(I)V
    //   1930: astore 11
    //   1932: sipush 1024
    //   1935: newarray byte
    //   1937: astore 12
    //   1939: aload 10
    //   1941: aload 12
    //   1943: invokevirtual 544	java/io/InputStream:read	([B)I
    //   1946: istore_1
    //   1947: iload_1
    //   1948: iflt +15 -> 1963
    //   1951: aload 11
    //   1953: aload 12
    //   1955: iconst_0
    //   1956: iload_1
    //   1957: invokevirtual 548	java/io/ByteArrayOutputStream:write	([BII)V
    //   1960: goto -21 -> 1939
    //   1963: aload 11
    //   1965: invokevirtual 552	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   1968: astore 10
    //   1970: aload_0
    //   1971: getfield 96	com/tencent/mm/av/a/f/b:igH	Lcom/tencent/mm/av/a/c/a;
    //   1974: ifnull +18 -> 1992
    //   1977: aload_0
    //   1978: getfield 96	com/tencent/mm/av/a/f/b:igH	Lcom/tencent/mm/av/a/c/a;
    //   1981: aload_0
    //   1982: getfield 62	com/tencent/mm/av/a/f/b:url	Ljava/lang/String;
    //   1985: aload 9
    //   1987: invokeinterface 463 3 0
    //   1992: aload_0
    //   1993: getfield 64	com/tencent/mm/av/a/f/b:igR	Lcom/tencent/mm/av/a/c;
    //   1996: aload 10
    //   1998: aload_0
    //   1999: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   2002: getfield 218	com/tencent/mm/av/a/a/c:hgF	I
    //   2005: aload_0
    //   2006: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   2009: getfield 224	com/tencent/mm/av/a/a/c:hgG	I
    //   2012: aload_0
    //   2013: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   2016: getfield 412	com/tencent/mm/av/a/a/c:igu	Z
    //   2019: aload_0
    //   2020: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   2023: getfield 415	com/tencent/mm/av/a/a/c:alpha	F
    //   2026: aload_0
    //   2027: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   2030: getfield 418	com/tencent/mm/av/a/a/c:igp	Z
    //   2033: invokestatic 432	com/tencent/mm/av/a/g/a:a	(Lcom/tencent/mm/av/a/c;[BIIZFZ)Landroid/graphics/Bitmap;
    //   2036: astore 10
    //   2038: aload 10
    //   2040: astore 11
    //   2042: aload_0
    //   2043: getfield 96	com/tencent/mm/av/a/f/b:igH	Lcom/tencent/mm/av/a/c/a;
    //   2046: ifnull +18 -> 2064
    //   2049: aload 10
    //   2051: astore 11
    //   2053: aload_0
    //   2054: getfield 96	com/tencent/mm/av/a/f/b:igH	Lcom/tencent/mm/av/a/c/a;
    //   2057: aload 10
    //   2059: invokeinterface 467 2 0
    //   2064: aload 10
    //   2066: ifnonnull +24 -> 2090
    //   2069: aload 10
    //   2071: astore 11
    //   2073: aload 9
    //   2075: iconst_3
    //   2076: putfield 321	com/tencent/mm/av/a/d/b:status	I
    //   2079: aload 10
    //   2081: astore 8
    //   2083: aload 9
    //   2085: astore 10
    //   2087: goto -1828 -> 259
    //   2090: aload 10
    //   2092: astore 11
    //   2094: aload 9
    //   2096: getfield 521	com/tencent/mm/av/a/d/b:data	[B
    //   2099: astore 8
    //   2101: aload 10
    //   2103: astore 11
    //   2105: aload_0
    //   2106: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   2109: getfield 555	com/tencent/mm/av/a/a/c:igk	Z
    //   2112: ifeq +27 -> 2139
    //   2115: aload 10
    //   2117: astore 11
    //   2119: aload_0
    //   2120: getfield 105	com/tencent/mm/av/a/f/b:ifY	Lcom/tencent/mm/av/a/c/b;
    //   2123: aload_0
    //   2124: getfield 62	com/tencent/mm/av/a/f/b:url	Ljava/lang/String;
    //   2127: aload 8
    //   2129: aload_0
    //   2130: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   2133: invokeinterface 558 4 0
    //   2138: pop
    //   2139: aload 10
    //   2141: astore 11
    //   2143: aload_0
    //   2144: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   2147: getfield 561	com/tencent/mm/av/a/a/c:igj	Z
    //   2150: ifeq +27 -> 2177
    //   2153: aload 10
    //   2155: astore 11
    //   2157: aload_0
    //   2158: getfield 105	com/tencent/mm/av/a/f/b:ifY	Lcom/tencent/mm/av/a/c/b;
    //   2161: aload_0
    //   2162: getfield 62	com/tencent/mm/av/a/f/b:url	Ljava/lang/String;
    //   2165: aload 8
    //   2167: aload_0
    //   2168: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   2171: invokeinterface 558 4 0
    //   2176: pop
    //   2177: aload 10
    //   2179: astore 8
    //   2181: aload 10
    //   2183: astore 11
    //   2185: aload_0
    //   2186: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   2189: getfield 189	com/tencent/mm/av/a/a/c:hhW	Z
    //   2192: ifeq +56 -> 2248
    //   2195: aload 10
    //   2197: astore 11
    //   2199: aload_0
    //   2200: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   2203: getfield 202	com/tencent/mm/av/a/a/c:igC	F
    //   2206: fconst_0
    //   2207: fcmpl
    //   2208: ifne +164 -> 2372
    //   2211: aload 10
    //   2213: astore 11
    //   2215: aload 10
    //   2217: invokevirtual 564	android/graphics/Bitmap:getWidth	()I
    //   2220: aload 10
    //   2222: invokevirtual 567	android/graphics/Bitmap:getHeight	()I
    //   2225: if_icmpne +68 -> 2293
    //   2228: aload 10
    //   2230: astore 11
    //   2232: aload 10
    //   2234: iconst_0
    //   2235: aload 10
    //   2237: invokevirtual 564	android/graphics/Bitmap:getWidth	()I
    //   2240: iconst_2
    //   2241: idiv
    //   2242: i2f
    //   2243: invokestatic 570	com/tencent/mm/sdk/platformtools/h:a	(Landroid/graphics/Bitmap;ZF)Landroid/graphics/Bitmap;
    //   2246: astore 8
    //   2248: aload 8
    //   2250: astore 11
    //   2252: aload_0
    //   2253: aload 9
    //   2255: aload 8
    //   2257: invokespecial 572	com/tencent/mm/av/a/f/b:a	(Lcom/tencent/mm/av/a/d/b;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   2260: astore 8
    //   2262: aload 8
    //   2264: astore 11
    //   2266: aload_0
    //   2267: aload 13
    //   2269: aload 8
    //   2271: invokespecial 574	com/tencent/mm/av/a/f/b:i	(Ljava/lang/String;Landroid/graphics/Bitmap;)V
    //   2274: aload 8
    //   2276: astore 11
    //   2278: aload_0
    //   2279: lload 5
    //   2281: lload_3
    //   2282: lsub
    //   2283: invokevirtual 578	com/tencent/mm/av/a/f/b:sw	(J)V
    //   2286: aload 9
    //   2288: astore 10
    //   2290: goto -2031 -> 259
    //   2293: aload 10
    //   2295: astore 11
    //   2297: aload 10
    //   2299: invokevirtual 564	android/graphics/Bitmap:getWidth	()I
    //   2302: aload 10
    //   2304: invokevirtual 567	android/graphics/Bitmap:getHeight	()I
    //   2307: invokestatic 584	java/lang/Math:min	(II)I
    //   2310: istore_2
    //   2311: iload_2
    //   2312: istore_1
    //   2313: iload_2
    //   2314: ifgt +21 -> 2335
    //   2317: aload 10
    //   2319: astore 11
    //   2321: aload 10
    //   2323: invokevirtual 564	android/graphics/Bitmap:getWidth	()I
    //   2326: aload 10
    //   2328: invokevirtual 567	android/graphics/Bitmap:getHeight	()I
    //   2331: invokestatic 587	java/lang/Math:max	(II)I
    //   2334: istore_1
    //   2335: aload 10
    //   2337: astore 11
    //   2339: aload 10
    //   2341: iload_1
    //   2342: iload_1
    //   2343: iconst_1
    //   2344: invokestatic 590	com/tencent/mm/sdk/platformtools/h:b	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   2347: astore 8
    //   2349: aload 8
    //   2351: astore 11
    //   2353: aload 8
    //   2355: iconst_0
    //   2356: aload 8
    //   2358: invokevirtual 564	android/graphics/Bitmap:getWidth	()I
    //   2361: iconst_2
    //   2362: idiv
    //   2363: i2f
    //   2364: invokestatic 570	com/tencent/mm/sdk/platformtools/h:a	(Landroid/graphics/Bitmap;ZF)Landroid/graphics/Bitmap;
    //   2367: astore 8
    //   2369: goto -121 -> 2248
    //   2372: aload 10
    //   2374: astore 11
    //   2376: aload 10
    //   2378: iconst_0
    //   2379: aload_0
    //   2380: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   2383: getfield 202	com/tencent/mm/av/a/a/c:igC	F
    //   2386: invokestatic 570	com/tencent/mm/sdk/platformtools/h:a	(Landroid/graphics/Bitmap;ZF)Landroid/graphics/Bitmap;
    //   2389: astore 8
    //   2391: goto -143 -> 2248
    //   2394: aload 9
    //   2396: iconst_2
    //   2397: putfield 321	com/tencent/mm/av/a/d/b:status	I
    //   2400: ldc 164
    //   2402: ldc_w 592
    //   2405: invokestatic 298	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   2408: aconst_null
    //   2409: astore 8
    //   2411: aload 9
    //   2413: astore 10
    //   2415: goto -2156 -> 259
    //   2418: ldc 164
    //   2420: ldc_w 594
    //   2423: invokestatic 298	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   2426: goto -2167 -> 259
    //   2429: aload_0
    //   2430: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   2433: getfield 189	com/tencent/mm/av/a/a/c:hhW	Z
    //   2436: ifeq +364 -> 2800
    //   2439: aload_0
    //   2440: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   2443: getfield 202	com/tencent/mm/av/a/a/c:igC	F
    //   2446: fconst_0
    //   2447: fcmpl
    //   2448: ifne +168 -> 2616
    //   2451: aload 8
    //   2453: invokevirtual 564	android/graphics/Bitmap:getWidth	()I
    //   2456: aload 8
    //   2458: invokevirtual 567	android/graphics/Bitmap:getHeight	()I
    //   2461: if_icmpne +88 -> 2549
    //   2464: aload 8
    //   2466: iconst_0
    //   2467: aload 8
    //   2469: invokevirtual 564	android/graphics/Bitmap:getWidth	()I
    //   2472: iconst_2
    //   2473: idiv
    //   2474: i2f
    //   2475: invokestatic 570	com/tencent/mm/sdk/platformtools/h:a	(Landroid/graphics/Bitmap;ZF)Landroid/graphics/Bitmap;
    //   2478: astore 9
    //   2480: aload 9
    //   2482: astore 8
    //   2484: aload_0
    //   2485: aload 10
    //   2487: aload 9
    //   2489: invokespecial 572	com/tencent/mm/av/a/f/b:a	(Lcom/tencent/mm/av/a/d/b;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   2492: astore 9
    //   2494: aload 9
    //   2496: astore 8
    //   2498: aload 10
    //   2500: getfield 597	com/tencent/mm/av/a/d/b:igN	Z
    //   2503: ifne +15 -> 2518
    //   2506: aload 9
    //   2508: astore 8
    //   2510: aload_0
    //   2511: aload 13
    //   2513: aload 9
    //   2515: invokespecial 574	com/tencent/mm/av/a/f/b:i	(Ljava/lang/String;Landroid/graphics/Bitmap;)V
    //   2518: aload 9
    //   2520: astore 8
    //   2522: aload_0
    //   2523: lload 5
    //   2525: lload_3
    //   2526: lsub
    //   2527: invokevirtual 578	com/tencent/mm/av/a/f/b:sw	(J)V
    //   2530: aload 9
    //   2532: astore 8
    //   2534: ldc 164
    //   2536: ldc_w 599
    //   2539: invokestatic 273	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   2542: aload 9
    //   2544: astore 8
    //   2546: goto -2287 -> 259
    //   2549: aload 8
    //   2551: invokevirtual 564	android/graphics/Bitmap:getWidth	()I
    //   2554: aload 8
    //   2556: invokevirtual 567	android/graphics/Bitmap:getHeight	()I
    //   2559: invokestatic 584	java/lang/Math:min	(II)I
    //   2562: istore_2
    //   2563: iload_2
    //   2564: istore_1
    //   2565: iload_2
    //   2566: ifgt +17 -> 2583
    //   2569: aload 8
    //   2571: invokevirtual 564	android/graphics/Bitmap:getWidth	()I
    //   2574: aload 8
    //   2576: invokevirtual 567	android/graphics/Bitmap:getHeight	()I
    //   2579: invokestatic 587	java/lang/Math:max	(II)I
    //   2582: istore_1
    //   2583: aload 8
    //   2585: iload_1
    //   2586: iload_1
    //   2587: iconst_1
    //   2588: invokestatic 590	com/tencent/mm/sdk/platformtools/h:b	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   2591: astore 9
    //   2593: aload 9
    //   2595: astore 8
    //   2597: aload 9
    //   2599: iconst_0
    //   2600: aload 9
    //   2602: invokevirtual 564	android/graphics/Bitmap:getWidth	()I
    //   2605: iconst_2
    //   2606: idiv
    //   2607: i2f
    //   2608: invokestatic 570	com/tencent/mm/sdk/platformtools/h:a	(Landroid/graphics/Bitmap;ZF)Landroid/graphics/Bitmap;
    //   2611: astore 9
    //   2613: goto -133 -> 2480
    //   2616: aload 8
    //   2618: iconst_0
    //   2619: aload_0
    //   2620: getfield 80	com/tencent/mm/av/a/f/b:ifW	Lcom/tencent/mm/av/a/a/c;
    //   2623: getfield 202	com/tencent/mm/av/a/a/c:igC	F
    //   2626: invokestatic 570	com/tencent/mm/sdk/platformtools/h:a	(Landroid/graphics/Bitmap;ZF)Landroid/graphics/Bitmap;
    //   2629: astore 9
    //   2631: goto -151 -> 2480
    //   2634: new 601	com/tencent/mm/av/a/f/c
    //   2637: dup
    //   2638: aload_0
    //   2639: getfield 62	com/tencent/mm/av/a/f/b:url	Ljava/lang/String;
    //   2642: aload_0
    //   2643: getfield 64	com/tencent/mm/av/a/f/b:igR	Lcom/tencent/mm/av/a/c;
    //   2646: aload 9
    //   2648: aload_0
    //   2649: getfield 68	com/tencent/mm/av/a/f/b:igP	Lcom/tencent/mm/av/a/b;
    //   2652: aload_0
    //   2653: aload_0
    //   2654: getfield 62	com/tencent/mm/av/a/f/b:url	Ljava/lang/String;
    //   2657: invokevirtual 242	com/tencent/mm/av/a/f/b:Gq	(Ljava/lang/String;)Ljava/lang/String;
    //   2660: invokespecial 604	com/tencent/mm/av/a/f/c:<init>	(Ljava/lang/String;Lcom/tencent/mm/av/a/c;Landroid/graphics/Bitmap;Lcom/tencent/mm/av/a/b;Ljava/lang/String;)V
    //   2663: astore 8
    //   2665: aload_0
    //   2666: getfield 66	com/tencent/mm/av/a/f/b:igS	Lcom/tencent/mm/sdk/platformtools/aq;
    //   2669: ifnull -2342 -> 327
    //   2672: aload_0
    //   2673: getfield 66	com/tencent/mm/av/a/f/b:igS	Lcom/tencent/mm/sdk/platformtools/aq;
    //   2676: aload 8
    //   2678: invokevirtual 610	com/tencent/mm/sdk/platformtools/aq:post	(Ljava/lang/Runnable;)Z
    //   2681: pop
    //   2682: goto -2355 -> 327
    //   2685: ldc 164
    //   2687: ldc_w 612
    //   2690: invokestatic 298	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   2693: goto -2349 -> 344
    //   2696: astore 8
    //   2698: goto -1720 -> 978
    //   2701: astore 8
    //   2703: goto -1217 -> 1486
    //   2706: astore 8
    //   2708: goto -1145 -> 1563
    //   2711: astore 12
    //   2713: aload 10
    //   2715: astore 9
    //   2717: aload 8
    //   2719: astore 11
    //   2721: aload 12
    //   2723: astore 10
    //   2725: aload 9
    //   2727: astore 8
    //   2729: aload 11
    //   2731: astore 9
    //   2733: goto -1734 -> 999
    //   2736: astore 12
    //   2738: aload 10
    //   2740: astore 9
    //   2742: aload 8
    //   2744: astore 11
    //   2746: aload 12
    //   2748: astore 10
    //   2750: aload 9
    //   2752: astore 8
    //   2754: aload 11
    //   2756: astore 9
    //   2758: goto -1759 -> 999
    //   2761: astore 10
    //   2763: aload 8
    //   2765: astore 11
    //   2767: aload 9
    //   2769: astore 8
    //   2771: aload 11
    //   2773: astore 9
    //   2775: goto -1776 -> 999
    //   2778: astore 10
    //   2780: aload 9
    //   2782: astore 8
    //   2784: aload 11
    //   2786: astore 9
    //   2788: goto -1789 -> 999
    //   2791: astore 12
    //   2793: aload 9
    //   2795: astore 11
    //   2797: goto -1244 -> 1553
    //   2800: aload 8
    //   2802: astore 9
    //   2804: goto -324 -> 2480
    //   2807: goto -1009 -> 1798
    //   2810: aload 11
    //   2812: astore 8
    //   2814: goto -2584 -> 230
    //   2817: iconst_1
    //   2818: istore_1
    //   2819: aload 8
    //   2821: astore 12
    //   2823: goto -1351 -> 1472
    //   2826: goto -2618 -> 208
    //   2829: iload_2
    //   2830: tableswitch	default:+34 -> 2864, 1:+-412->2418, 2:+-412->2418, 3:+-412->2418, 4:+-412->2418, 5:+-1122->1708
    //   2865: <illegal opcode>
    //   2866: <illegal opcode>
    //   2867: astore 10
    //   2869: aload 8
    //   2871: astore 11
    //   2873: aload 9
    //   2875: astore 8
    //   2877: aload 11
    //   2879: astore 9
    //   2881: goto -1882 -> 999
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2884	0	this	b
    //   1220	1599	1	i	int
    //   82	2748	2	j	int
    //   74	2452	3	l1	long
    //   233	2291	5	l2	long
    //   90	1751	7	bool	boolean
    //   26	918	8	localObject1	Object
    //   957	17	8	localIOException1	java.io.IOException
    //   990	1687	8	localObject2	Object
    //   2696	1	8	localIOException2	java.io.IOException
    //   2701	1	8	localIOException3	java.io.IOException
    //   2706	12	8	localIOException4	java.io.IOException
    //   2727	149	8	localObject3	Object
    //   282	680	9	localObject4	Object
    //   966	18	9	localObject5	Object
    //   993	557	9	localObject6	Object
    //   1571	7	9	localException1	java.lang.Exception
    //   1583	1297	9	localObject7	Object
    //   35	2714	10	localObject8	Object
    //   2761	1	10	localException2	java.lang.Exception
    //   2778	1	10	localException3	java.lang.Exception
    //   2867	1	10	localException4	java.lang.Exception
    //   552	408	11	localObject9	Object
    //   986	10	11	localException5	java.lang.Exception
    //   1147	1731	11	localObject10	Object
    //   880	660	12	localObject11	Object
    //   1544	25	12	localObject12	Object
    //   1937	17	12	arrayOfByte	byte[]
    //   2711	11	12	localException6	java.lang.Exception
    //   2736	11	12	localException7	java.lang.Exception
    //   2791	1	12	localObject13	Object
    //   2821	1	12	localObject14	Object
    //   51	2461	13	str1	String
    //   99	1751	14	str2	String
    // Exception table:
    //   from	to	target	type
    //   945	950	957	java/io/IOException
    //   851	857	966	finally
    //   861	869	966	finally
    //   873	882	966	finally
    //   886	932	966	finally
    //   43	174	986	java/lang/Exception
    //   208	227	986	java/lang/Exception
    //   476	546	986	java/lang/Exception
    //   587	612	986	java/lang/Exception
    //   615	635	986	java/lang/Exception
    //   640	658	986	java/lang/Exception
    //   658	695	986	java/lang/Exception
    //   833	839	986	java/lang/Exception
    //   973	978	986	java/lang/Exception
    //   978	986	986	java/lang/Exception
    //   1030	1097	986	java/lang/Exception
    //   1100	1127	986	java/lang/Exception
    //   1152	1171	986	java/lang/Exception
    //   1177	1196	986	java/lang/Exception
    //   1202	1210	986	java/lang/Exception
    //   1588	1615	986	java/lang/Exception
    //   1618	1667	986	java/lang/Exception
    //   1670	1705	986	java/lang/Exception
    //   1225	1232	1544	finally
    //   1236	1249	1544	finally
    //   1253	1272	1544	finally
    //   1276	1283	1544	finally
    //   1287	1296	1544	finally
    //   1318	1334	1544	finally
    //   1342	1349	1544	finally
    //   1353	1364	1544	finally
    //   1368	1375	1544	finally
    //   1379	1394	1544	finally
    //   1398	1444	1544	finally
    //   1558	1563	1571	java/lang/Exception
    //   1563	1571	1571	java/lang/Exception
    //   973	978	2696	java/io/IOException
    //   1481	1486	2701	java/io/IOException
    //   1558	1563	2706	java/io/IOException
    //   554	564	2711	java/lang/Exception
    //   568	580	2711	java/lang/Exception
    //   703	713	2711	java/lang/Exception
    //   730	737	2711	java/lang/Exception
    //   741	748	2711	java/lang/Exception
    //   752	779	2711	java/lang/Exception
    //   788	798	2711	java/lang/Exception
    //   802	814	2711	java/lang/Exception
    //   818	826	2711	java/lang/Exception
    //   945	950	2711	java/lang/Exception
    //   1134	1149	2711	java/lang/Exception
    //   1481	1486	2711	java/lang/Exception
    //   1507	1525	2711	java/lang/Exception
    //   2484	2494	2711	java/lang/Exception
    //   2498	2506	2711	java/lang/Exception
    //   2510	2518	2711	java/lang/Exception
    //   2522	2530	2711	java/lang/Exception
    //   2534	2542	2711	java/lang/Exception
    //   2597	2613	2711	java/lang/Exception
    //   230	235	2736	java/lang/Exception
    //   240	248	2736	java/lang/Exception
    //   251	259	2736	java/lang/Exception
    //   1708	1747	2736	java/lang/Exception
    //   1747	1778	2736	java/lang/Exception
    //   1825	1833	2736	java/lang/Exception
    //   2418	2426	2736	java/lang/Exception
    //   2429	2480	2736	java/lang/Exception
    //   2549	2563	2736	java/lang/Exception
    //   2569	2583	2736	java/lang/Exception
    //   2583	2593	2736	java/lang/Exception
    //   2616	2631	2736	java/lang/Exception
    //   1783	1794	2761	java/lang/Exception
    //   2042	2049	2778	java/lang/Exception
    //   2053	2064	2778	java/lang/Exception
    //   2073	2079	2778	java/lang/Exception
    //   2094	2101	2778	java/lang/Exception
    //   2105	2115	2778	java/lang/Exception
    //   2119	2139	2778	java/lang/Exception
    //   2143	2153	2778	java/lang/Exception
    //   2157	2177	2778	java/lang/Exception
    //   2185	2195	2778	java/lang/Exception
    //   2199	2211	2778	java/lang/Exception
    //   2215	2228	2778	java/lang/Exception
    //   2232	2248	2778	java/lang/Exception
    //   2252	2262	2778	java/lang/Exception
    //   2266	2274	2778	java/lang/Exception
    //   2278	2286	2778	java/lang/Exception
    //   2297	2311	2778	java/lang/Exception
    //   2321	2335	2778	java/lang/Exception
    //   2339	2349	2778	java/lang/Exception
    //   2353	2369	2778	java/lang/Exception
    //   2376	2391	2778	java/lang/Exception
    //   1448	1466	2791	finally
    //   1798	1818	2867	java/lang/Exception
    //   1845	1864	2867	java/lang/Exception
    //   1864	1884	2867	java/lang/Exception
    //   1888	1939	2867	java/lang/Exception
    //   1939	1947	2867	java/lang/Exception
    //   1951	1960	2867	java/lang/Exception
    //   1963	1970	2867	java/lang/Exception
    //   1970	1992	2867	java/lang/Exception
    //   1992	2038	2867	java/lang/Exception
    //   2394	2408	2867	java/lang/Exception
  }
  
  public final void sw(long paramLong)
  {
    AppMethodBeat.i(130440);
    if (this.igb != null) {
      this.igb.sw(paramLong);
    }
    AppMethodBeat.o(130440);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.av.a.f.b
 * JD-Core Version:    0.7.0.1
 */