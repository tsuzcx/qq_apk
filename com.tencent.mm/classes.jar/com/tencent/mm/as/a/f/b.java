package com.tencent.mm.as.a.f;

import android.graphics.Bitmap;
import com.tencent.mm.as.a.c.a;
import com.tencent.mm.as.a.c.d;
import com.tencent.mm.as.a.c.e;
import com.tencent.mm.as.a.c.f;
import com.tencent.mm.as.a.c.g;
import com.tencent.mm.as.a.c.i;
import com.tencent.mm.as.a.c.j;
import com.tencent.mm.as.a.c.k;
import com.tencent.mm.as.a.c.l;
import com.tencent.mm.as.a.c.m;
import com.tencent.mm.as.a.c.n;
import com.tencent.mm.as.a.c.o;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class b
  implements Runnable
{
  public final com.tencent.mm.as.a.a.c eqR;
  private final m eqS;
  private final a eqT;
  private final com.tencent.mm.as.a.c.b eqU;
  private final j eqW;
  private final e eqY;
  private final com.tencent.mm.as.a.a.b eqy;
  private final o erI;
  private final com.tencent.mm.as.a.b erP;
  public final com.tencent.mm.as.a.c erR;
  private final ah erS;
  private final i erT;
  private final g erU;
  private final f erV;
  private final k erW;
  private final d erX;
  private final l erY;
  private final n erb;
  public final String url;
  
  public b(String paramString, com.tencent.mm.as.a.c paramc, ah paramah, com.tencent.mm.as.a.a.c paramc1, i parami, com.tencent.mm.as.a.b paramb, g paramg, e parame, d paramd, l paraml)
  {
    this.url = paramString;
    this.erR = paramc;
    this.erS = paramah;
    this.erP = paramb;
    this.erU = paramg;
    this.eqy = this.erP.eqy;
    if (paramc1 == null)
    {
      this.eqR = this.eqy.eqR;
      this.erT = parami;
      this.eqW = this.eqy.eqW;
      if (this.eqR.eqU == null) {
        break label200;
      }
      this.eqU = this.eqR.eqU;
      label96:
      this.erI = this.eqR.erI;
      this.eqS = this.eqy.eqS;
      this.eqT = this.eqy.eqT;
      this.erV = this.eqy.eqV;
      this.erW = this.eqy.eqX;
      if (parame != null) {
        break label214;
      }
    }
    label200:
    label214:
    for (this.eqY = this.eqy.eqY;; this.eqY = parame)
    {
      this.erX = paramd;
      this.erY = paraml;
      this.erb = this.eqy.erb;
      return;
      this.eqR = paramc1;
      break;
      this.eqU = this.eqy.eqU;
      break label96;
    }
  }
  
  private Bitmap a(com.tencent.mm.as.a.d.b paramb, Bitmap paramBitmap)
  {
    Object localObject = paramBitmap;
    if (this.erU != null)
    {
      localObject = paramBitmap;
      if (paramb != null)
      {
        paramb.bitmap = paramBitmap;
        paramb = this.erU.a(this.url, this.erR.getImageView(), paramb);
        localObject = paramBitmap;
        if (paramb != null)
        {
          localObject = paramBitmap;
          if (!paramb.isRecycled()) {
            localObject = paramb;
          }
        }
      }
    }
    return localObject;
  }
  
  private void j(String paramString, Bitmap paramBitmap)
  {
    if (this.eqR.erd)
    {
      y.d("MicroMsg.imageloader.ImageLoadTask", "[cpan] run. put key %s to memory cache.", new Object[] { this.url });
      this.eqS.c(paramString, paramBitmap);
    }
  }
  
  public final void cc(long paramLong)
  {
    if (this.eqW != null) {
      this.eqW.cc(paramLong);
    }
  }
  
  public final String mx(String paramString)
  {
    if ((bk.bl(paramString)) || (this.eqR == null)) {
      return null;
    }
    String str = paramString;
    if (this.eqR.erD) {
      str = paramString + "round" + this.eqR.erE;
    }
    paramString = str;
    if (!bk.bl(this.eqR.erA)) {
      paramString = str + this.eqR.erA;
    }
    return paramString + "size" + this.eqR.erl + this.eqR.erm;
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: new 114	com/tencent/mm/as/a/d/b
    //   6: dup
    //   7: invokespecial 214	com/tencent/mm/as/a/d/b:<init>	()V
    //   10: astore 10
    //   12: aload 10
    //   14: iconst_1
    //   15: putfield 217	com/tencent/mm/as/a/d/b:from	I
    //   18: aload_0
    //   19: aload_0
    //   20: getfield 51	com/tencent/mm/as/a/f/b:url	Ljava/lang/String;
    //   23: invokevirtual 219	com/tencent/mm/as/a/f/b:mx	(Ljava/lang/String;)Ljava/lang/String;
    //   26: astore 13
    //   28: ldc 143
    //   30: ldc 221
    //   32: iconst_1
    //   33: anewarray 4	java/lang/Object
    //   36: dup
    //   37: iconst_0
    //   38: aload_0
    //   39: getfield 51	com/tencent/mm/as/a/f/b:url	Ljava/lang/String;
    //   42: aastore
    //   43: invokestatic 151	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   46: invokestatic 227	java/lang/System:currentTimeMillis	()J
    //   49: lstore_3
    //   50: aload_0
    //   51: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   54: getfield 230	com/tencent/mm/as/a/a/c:erk	I
    //   57: istore_2
    //   58: aload_0
    //   59: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   62: getfield 233	com/tencent/mm/as/a/a/c:ern	Z
    //   65: istore 7
    //   67: aload_0
    //   68: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   71: getfield 236	com/tencent/mm/as/a/a/c:bIW	Ljava/lang/String;
    //   74: astore 14
    //   76: ldc 143
    //   78: new 175	java/lang/StringBuilder
    //   81: dup
    //   82: ldc 238
    //   84: invokespecial 241	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   87: iload 7
    //   89: invokevirtual 244	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   92: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 247	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: ldc 143
    //   100: ldc 249
    //   102: iconst_1
    //   103: anewarray 4	java/lang/Object
    //   106: dup
    //   107: iconst_0
    //   108: iload_2
    //   109: invokestatic 255	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   112: aastore
    //   113: invokestatic 151	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   116: ldc 143
    //   118: ldc_w 257
    //   121: iconst_2
    //   122: anewarray 4	java/lang/Object
    //   125: dup
    //   126: iconst_0
    //   127: aload_0
    //   128: getfield 53	com/tencent/mm/as/a/f/b:erR	Lcom/tencent/mm/as/a/c;
    //   131: getfield 260	com/tencent/mm/as/a/c:width	I
    //   134: invokestatic 255	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   137: aastore
    //   138: dup
    //   139: iconst_1
    //   140: aload_0
    //   141: getfield 53	com/tencent/mm/as/a/f/b:erR	Lcom/tencent/mm/as/a/c;
    //   144: getfield 263	com/tencent/mm/as/a/c:height	I
    //   147: invokestatic 255	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   150: aastore
    //   151: invokestatic 151	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   154: iload_2
    //   155: tableswitch	default:+2340 -> 2495, 1:+308->463, 2:+1264->1419, 3:+1294->1449, 4:+1346->1501, 5:+1037->1192
    //   189: d2l
    //   190: ldc_w 265
    //   193: iconst_1
    //   194: anewarray 4	java/lang/Object
    //   197: dup
    //   198: iconst_0
    //   199: iload_2
    //   200: invokestatic 255	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   203: aastore
    //   204: invokestatic 268	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   207: invokestatic 227	java/lang/System:currentTimeMillis	()J
    //   210: lstore 5
    //   212: aload 8
    //   214: ifnull +2284 -> 2498
    //   217: aload 8
    //   219: invokevirtual 135	android/graphics/Bitmap:isRecycled	()Z
    //   222: ifeq +1991 -> 2213
    //   225: goto +2273 -> 2498
    //   228: ldc 143
    //   230: ldc_w 270
    //   233: invokestatic 273	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   236: aload 10
    //   238: astore 9
    //   240: aload 8
    //   242: ifnull +2168 -> 2410
    //   245: aload 8
    //   247: invokevirtual 135	android/graphics/Bitmap:isRecycled	()Z
    //   250: ifne +2160 -> 2410
    //   253: ldc 143
    //   255: ldc_w 275
    //   258: invokestatic 247	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   261: aload 8
    //   263: astore 10
    //   265: aload_0
    //   266: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   269: getfield 278	com/tencent/mm/as/a/a/c:erp	Z
    //   272: ifeq +17 -> 289
    //   275: aload 8
    //   277: aload_0
    //   278: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   281: getfield 281	com/tencent/mm/as/a/a/c:erq	I
    //   284: invokestatic 287	com/tencent/mm/sdk/platformtools/c:f	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   287: astore 10
    //   289: new 289	com/tencent/mm/as/a/f/c
    //   292: dup
    //   293: aload_0
    //   294: getfield 51	com/tencent/mm/as/a/f/b:url	Ljava/lang/String;
    //   297: aload_0
    //   298: getfield 53	com/tencent/mm/as/a/f/b:erR	Lcom/tencent/mm/as/a/c;
    //   301: aload 10
    //   303: aload_0
    //   304: getfield 57	com/tencent/mm/as/a/f/b:erP	Lcom/tencent/mm/as/a/b;
    //   307: aload_0
    //   308: aload_0
    //   309: getfield 51	com/tencent/mm/as/a/f/b:url	Ljava/lang/String;
    //   312: invokevirtual 219	com/tencent/mm/as/a/f/b:mx	(Ljava/lang/String;)Ljava/lang/String;
    //   315: invokespecial 292	com/tencent/mm/as/a/f/c:<init>	(Ljava/lang/String;Lcom/tencent/mm/as/a/c;Landroid/graphics/Bitmap;Lcom/tencent/mm/as/a/b;Ljava/lang/String;)V
    //   318: astore 8
    //   320: aload_0
    //   321: getfield 55	com/tencent/mm/as/a/f/b:erS	Lcom/tencent/mm/sdk/platformtools/ah;
    //   324: ifnull +13 -> 337
    //   327: aload_0
    //   328: getfield 55	com/tencent/mm/as/a/f/b:erS	Lcom/tencent/mm/sdk/platformtools/ah;
    //   331: aload 8
    //   333: invokevirtual 298	com/tencent/mm/sdk/platformtools/ah:post	(Ljava/lang/Runnable;)Z
    //   336: pop
    //   337: aload 9
    //   339: aload 10
    //   341: putfield 118	com/tencent/mm/as/a/d/b:bitmap	Landroid/graphics/Bitmap;
    //   344: aload 10
    //   346: astore 8
    //   348: aload_0
    //   349: getfield 59	com/tencent/mm/as/a/f/b:erU	Lcom/tencent/mm/as/a/c/g;
    //   352: ifnull +37 -> 389
    //   355: aload 9
    //   357: ifnull +32 -> 389
    //   360: aload 9
    //   362: aload 8
    //   364: putfield 118	com/tencent/mm/as/a/d/b:bitmap	Landroid/graphics/Bitmap;
    //   367: aload_0
    //   368: getfield 59	com/tencent/mm/as/a/f/b:erU	Lcom/tencent/mm/as/a/c/g;
    //   371: aload_0
    //   372: getfield 51	com/tencent/mm/as/a/f/b:url	Ljava/lang/String;
    //   375: aload_0
    //   376: getfield 53	com/tencent/mm/as/a/f/b:erR	Lcom/tencent/mm/as/a/c;
    //   379: invokevirtual 124	com/tencent/mm/as/a/c:getImageView	()Landroid/widget/ImageView;
    //   382: aload 9
    //   384: invokeinterface 302 4 0
    //   389: aload_0
    //   390: getfield 71	com/tencent/mm/as/a/f/b:erT	Lcom/tencent/mm/as/a/c/i;
    //   393: aload_0
    //   394: getfield 51	com/tencent/mm/as/a/f/b:url	Ljava/lang/String;
    //   397: aload_0
    //   398: getfield 53	com/tencent/mm/as/a/f/b:erR	Lcom/tencent/mm/as/a/c;
    //   401: invokevirtual 124	com/tencent/mm/as/a/c:getImageView	()Landroid/widget/ImageView;
    //   404: aload 8
    //   406: aload_0
    //   407: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   410: getfield 306	com/tencent/mm/as/a/a/c:erJ	[Ljava/lang/Object;
    //   413: invokeinterface 311 5 0
    //   418: aload_0
    //   419: getfield 57	com/tencent/mm/as/a/f/b:erP	Lcom/tencent/mm/as/a/b;
    //   422: astore 8
    //   424: aload 8
    //   426: getfield 315	com/tencent/mm/as/a/b:eqC	Ljava/util/HashMap;
    //   429: ifnull +33 -> 462
    //   432: aload_0
    //   433: ifnull +29 -> 462
    //   436: aload_0
    //   437: getfield 53	com/tencent/mm/as/a/f/b:erR	Lcom/tencent/mm/as/a/c;
    //   440: ifnull +22 -> 462
    //   443: aload 8
    //   445: getfield 315	com/tencent/mm/as/a/b:eqC	Ljava/util/HashMap;
    //   448: aload_0
    //   449: getfield 53	com/tencent/mm/as/a/f/b:erR	Lcom/tencent/mm/as/a/c;
    //   452: getfield 318	com/tencent/mm/as/a/c:eqE	I
    //   455: invokestatic 255	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   458: invokevirtual 324	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   461: pop
    //   462: return
    //   463: aload_0
    //   464: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   467: getfield 327	com/tencent/mm/as/a/a/c:thumbPath	Ljava/lang/String;
    //   470: astore 9
    //   472: aload_0
    //   473: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   476: getfield 330	com/tencent/mm/as/a/a/c:err	Z
    //   479: ifeq +123 -> 602
    //   482: aload 9
    //   484: invokestatic 170	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   487: ifne +115 -> 602
    //   490: aload 9
    //   492: invokestatic 335	com/tencent/mm/vfs/e:bK	(Ljava/lang/String;)Z
    //   495: ifeq +107 -> 602
    //   498: aload_0
    //   499: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   502: getfield 338	com/tencent/mm/as/a/a/c:erF	Z
    //   505: ifeq +69 -> 574
    //   508: aload_0
    //   509: getfield 53	com/tencent/mm/as/a/f/b:erR	Lcom/tencent/mm/as/a/c;
    //   512: aload 9
    //   514: aload_0
    //   515: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   518: getfield 202	com/tencent/mm/as/a/a/c:erl	I
    //   521: aload_0
    //   522: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   525: getfield 208	com/tencent/mm/as/a/a/c:erm	I
    //   528: invokestatic 343	com/tencent/mm/as/a/g/a:b	(Lcom/tencent/mm/as/a/c;Ljava/lang/String;II)Landroid/graphics/Bitmap;
    //   531: astore 9
    //   533: aload 9
    //   535: astore 8
    //   537: aload 9
    //   539: astore 11
    //   541: aload_0
    //   542: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   545: getfield 346	com/tencent/mm/as/a/a/c:density	I
    //   548: ifle +1934 -> 2482
    //   551: aload 9
    //   553: astore 8
    //   555: aload 9
    //   557: aload_0
    //   558: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   561: getfield 346	com/tencent/mm/as/a/a/c:density	I
    //   564: invokevirtual 350	android/graphics/Bitmap:setDensity	(I)V
    //   567: aload 9
    //   569: astore 8
    //   571: goto -364 -> 207
    //   574: aload_0
    //   575: getfield 53	com/tencent/mm/as/a/f/b:erR	Lcom/tencent/mm/as/a/c;
    //   578: aload 9
    //   580: aload_0
    //   581: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   584: getfield 202	com/tencent/mm/as/a/a/c:erl	I
    //   587: aload_0
    //   588: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   591: getfield 208	com/tencent/mm/as/a/a/c:erm	I
    //   594: invokestatic 352	com/tencent/mm/as/a/g/a:a	(Lcom/tencent/mm/as/a/c;Ljava/lang/String;II)Landroid/graphics/Bitmap;
    //   597: astore 9
    //   599: goto -66 -> 533
    //   602: aload_0
    //   603: getfield 51	com/tencent/mm/as/a/f/b:url	Ljava/lang/String;
    //   606: invokestatic 170	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   609: ifne +572 -> 1181
    //   612: aload_0
    //   613: getfield 51	com/tencent/mm/as/a/f/b:url	Ljava/lang/String;
    //   616: invokestatic 335	com/tencent/mm/vfs/e:bK	(Ljava/lang/String;)Z
    //   619: ifeq +525 -> 1144
    //   622: iload 7
    //   624: ifeq +21 -> 645
    //   627: aload_0
    //   628: getfield 98	com/tencent/mm/as/a/f/b:erW	Lcom/tencent/mm/as/a/c/k;
    //   631: aload 14
    //   633: aload_0
    //   634: getfield 51	com/tencent/mm/as/a/f/b:url	Ljava/lang/String;
    //   637: invokeinterface 358 3 0
    //   642: ifeq +488 -> 1130
    //   645: aload_0
    //   646: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   649: getfield 338	com/tencent/mm/as/a/a/c:erF	Z
    //   652: ifeq +168 -> 820
    //   655: aload_0
    //   656: getfield 53	com/tencent/mm/as/a/f/b:erR	Lcom/tencent/mm/as/a/c;
    //   659: aload_0
    //   660: getfield 51	com/tencent/mm/as/a/f/b:url	Ljava/lang/String;
    //   663: aload_0
    //   664: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   667: getfield 202	com/tencent/mm/as/a/a/c:erl	I
    //   670: aload_0
    //   671: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   674: getfield 208	com/tencent/mm/as/a/a/c:erm	I
    //   677: invokestatic 343	com/tencent/mm/as/a/g/a:b	(Lcom/tencent/mm/as/a/c;Ljava/lang/String;II)Landroid/graphics/Bitmap;
    //   680: astore 9
    //   682: aload 9
    //   684: astore 11
    //   686: aload 9
    //   688: astore 8
    //   690: aload_0
    //   691: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   694: getfield 361	com/tencent/mm/as/a/a/c:erH	Z
    //   697: ifeq +69 -> 766
    //   700: aload 9
    //   702: astore 11
    //   704: aload 9
    //   706: ifnonnull +60 -> 766
    //   709: aload 9
    //   711: astore 11
    //   713: aload 9
    //   715: astore 8
    //   717: aload_0
    //   718: getfield 105	com/tencent/mm/as/a/f/b:erY	Lcom/tencent/mm/as/a/c/l;
    //   721: ifnull +45 -> 766
    //   724: aload 9
    //   726: astore 8
    //   728: aload_0
    //   729: getfield 103	com/tencent/mm/as/a/f/b:erX	Lcom/tencent/mm/as/a/c/d;
    //   732: ifnull +376 -> 1108
    //   735: aload 9
    //   737: astore 8
    //   739: aload_0
    //   740: getfield 105	com/tencent/mm/as/a/f/b:erY	Lcom/tencent/mm/as/a/c/l;
    //   743: aload_0
    //   744: getfield 103	com/tencent/mm/as/a/f/b:erX	Lcom/tencent/mm/as/a/c/d;
    //   747: aload_0
    //   748: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   751: getfield 306	com/tencent/mm/as/a/a/c:erJ	[Ljava/lang/Object;
    //   754: invokeinterface 367 2 0
    //   759: invokeinterface 373 2 0
    //   764: astore 11
    //   766: aload 11
    //   768: ifnull +33 -> 801
    //   771: aload 11
    //   773: astore 8
    //   775: aload_0
    //   776: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   779: getfield 346	com/tencent/mm/as/a/a/c:density	I
    //   782: ifle +19 -> 801
    //   785: aload 11
    //   787: astore 8
    //   789: aload 11
    //   791: aload_0
    //   792: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   795: getfield 346	com/tencent/mm/as/a/a/c:density	I
    //   798: invokevirtual 350	android/graphics/Bitmap:setDensity	(I)V
    //   801: aload 11
    //   803: astore 8
    //   805: ldc 143
    //   807: ldc_w 375
    //   810: invokestatic 247	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   813: aload 11
    //   815: astore 8
    //   817: goto -610 -> 207
    //   820: aload_0
    //   821: getfield 82	com/tencent/mm/as/a/f/b:erI	Lcom/tencent/mm/as/a/c/o;
    //   824: astore 8
    //   826: aload 8
    //   828: ifnull +180 -> 1008
    //   831: aconst_null
    //   832: astore 9
    //   834: aload 9
    //   836: astore 8
    //   838: aload_0
    //   839: getfield 82	com/tencent/mm/as/a/f/b:erI	Lcom/tencent/mm/as/a/c/o;
    //   842: astore 11
    //   844: aload 9
    //   846: astore 8
    //   848: new 377	com/tencent/mm/vfs/d
    //   851: dup
    //   852: aload_0
    //   853: getfield 51	com/tencent/mm/as/a/f/b:url	Ljava/lang/String;
    //   856: invokespecial 378	com/tencent/mm/vfs/d:<init>	(Ljava/lang/String;)V
    //   859: pop
    //   860: aload 9
    //   862: astore 8
    //   864: aload 11
    //   866: invokeinterface 384 1 0
    //   871: astore 12
    //   873: aload 12
    //   875: astore 8
    //   877: aload_0
    //   878: getfield 53	com/tencent/mm/as/a/f/b:erR	Lcom/tencent/mm/as/a/c;
    //   881: aload 12
    //   883: aload_0
    //   884: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   887: getfield 202	com/tencent/mm/as/a/a/c:erl	I
    //   890: aload_0
    //   891: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   894: getfield 208	com/tencent/mm/as/a/a/c:erm	I
    //   897: aload_0
    //   898: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   901: getfield 387	com/tencent/mm/as/a/a/c:ert	Z
    //   904: aload_0
    //   905: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   908: getfield 390	com/tencent/mm/as/a/a/c:alpha	F
    //   911: aload_0
    //   912: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   915: getfield 393	com/tencent/mm/as/a/a/c:ero	Z
    //   918: invokestatic 396	com/tencent/mm/as/a/g/a:a	(Lcom/tencent/mm/as/a/c;Ljava/io/InputStream;IIZFZ)Landroid/graphics/Bitmap;
    //   921: astore 11
    //   923: aload 11
    //   925: astore 9
    //   927: aload 12
    //   929: ifnull -247 -> 682
    //   932: aload 11
    //   934: astore 8
    //   936: aload 12
    //   938: invokevirtual 401	java/io/InputStream:close	()V
    //   941: aload 11
    //   943: astore 9
    //   945: goto -263 -> 682
    //   948: astore 8
    //   950: aload 11
    //   952: astore 9
    //   954: goto -272 -> 682
    //   957: astore 9
    //   959: aload 8
    //   961: ifnull +8 -> 969
    //   964: aload 8
    //   966: invokevirtual 401	java/io/InputStream:close	()V
    //   969: aload 9
    //   971: athrow
    //   972: astore 11
    //   974: aload 10
    //   976: astore 9
    //   978: aconst_null
    //   979: astore 8
    //   981: aload 11
    //   983: astore 10
    //   985: ldc 143
    //   987: ldc_w 403
    //   990: iconst_1
    //   991: anewarray 4	java/lang/Object
    //   994: dup
    //   995: iconst_0
    //   996: aload 10
    //   998: invokevirtual 404	java/lang/Exception:toString	()Ljava/lang/String;
    //   1001: aastore
    //   1002: invokestatic 268	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1005: goto -765 -> 240
    //   1008: aload_0
    //   1009: getfield 103	com/tencent/mm/as/a/f/b:erX	Lcom/tencent/mm/as/a/c/d;
    //   1012: ifnull +66 -> 1078
    //   1015: aload_0
    //   1016: getfield 53	com/tencent/mm/as/a/f/b:erR	Lcom/tencent/mm/as/a/c;
    //   1019: aload_0
    //   1020: getfield 103	com/tencent/mm/as/a/f/b:erX	Lcom/tencent/mm/as/a/c/d;
    //   1023: aload_0
    //   1024: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   1027: getfield 306	com/tencent/mm/as/a/a/c:erJ	[Ljava/lang/Object;
    //   1030: invokeinterface 367 2 0
    //   1035: aload_0
    //   1036: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   1039: getfield 202	com/tencent/mm/as/a/a/c:erl	I
    //   1042: aload_0
    //   1043: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   1046: getfield 208	com/tencent/mm/as/a/a/c:erm	I
    //   1049: aload_0
    //   1050: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   1053: getfield 387	com/tencent/mm/as/a/a/c:ert	Z
    //   1056: aload_0
    //   1057: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   1060: getfield 390	com/tencent/mm/as/a/a/c:alpha	F
    //   1063: aload_0
    //   1064: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   1067: getfield 393	com/tencent/mm/as/a/a/c:ero	Z
    //   1070: invokestatic 407	com/tencent/mm/as/a/g/a:a	(Lcom/tencent/mm/as/a/c;[BIIZFZ)Landroid/graphics/Bitmap;
    //   1073: astore 9
    //   1075: goto -393 -> 682
    //   1078: aload_0
    //   1079: getfield 53	com/tencent/mm/as/a/f/b:erR	Lcom/tencent/mm/as/a/c;
    //   1082: aload_0
    //   1083: getfield 51	com/tencent/mm/as/a/f/b:url	Ljava/lang/String;
    //   1086: aload_0
    //   1087: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   1090: getfield 202	com/tencent/mm/as/a/a/c:erl	I
    //   1093: aload_0
    //   1094: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   1097: getfield 208	com/tencent/mm/as/a/a/c:erm	I
    //   1100: invokestatic 352	com/tencent/mm/as/a/g/a:a	(Lcom/tencent/mm/as/a/c;Ljava/lang/String;II)Landroid/graphics/Bitmap;
    //   1103: astore 9
    //   1105: goto -423 -> 682
    //   1108: aload 9
    //   1110: astore 8
    //   1112: aload_0
    //   1113: getfield 105	com/tencent/mm/as/a/f/b:erY	Lcom/tencent/mm/as/a/c/l;
    //   1116: aload_0
    //   1117: getfield 51	com/tencent/mm/as/a/f/b:url	Ljava/lang/String;
    //   1120: invokeinterface 411 2 0
    //   1125: astore 11
    //   1127: goto -361 -> 766
    //   1130: ldc 143
    //   1132: ldc_w 413
    //   1135: invokestatic 273	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1138: aconst_null
    //   1139: astore 8
    //   1141: goto -934 -> 207
    //   1144: aload_0
    //   1145: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   1148: getfield 416	com/tencent/mm/as/a/a/c:ers	Z
    //   1151: ifeq +19 -> 1170
    //   1154: aload_0
    //   1155: getfield 101	com/tencent/mm/as/a/f/b:eqY	Lcom/tencent/mm/as/a/c/e;
    //   1158: aload_0
    //   1159: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   1162: getfield 306	com/tencent/mm/as/a/a/c:erJ	[Ljava/lang/Object;
    //   1165: invokeinterface 422 2 0
    //   1170: ldc 143
    //   1172: ldc_w 424
    //   1175: invokestatic 273	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1178: goto -971 -> 207
    //   1181: ldc 143
    //   1183: ldc_w 426
    //   1186: invokestatic 273	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1189: goto -982 -> 207
    //   1192: aconst_null
    //   1193: astore 9
    //   1195: iconst_0
    //   1196: istore_1
    //   1197: aload_0
    //   1198: getfield 88	com/tencent/mm/as/a/f/b:eqT	Lcom/tencent/mm/as/a/c/a;
    //   1201: aload_0
    //   1202: getfield 51	com/tencent/mm/as/a/f/b:url	Ljava/lang/String;
    //   1205: aload_0
    //   1206: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   1209: invokeinterface 431 3 0
    //   1214: astore 11
    //   1216: aload 11
    //   1218: ifnull +1271 -> 2489
    //   1221: iload 7
    //   1223: ifeq +23 -> 1246
    //   1226: aload 11
    //   1228: astore 9
    //   1230: aload_0
    //   1231: getfield 98	com/tencent/mm/as/a/f/b:erW	Lcom/tencent/mm/as/a/c/k;
    //   1234: aload 14
    //   1236: aload 11
    //   1238: invokeinterface 434 3 0
    //   1243: ifeq +153 -> 1396
    //   1246: aload 11
    //   1248: astore 8
    //   1250: aload 11
    //   1252: astore 9
    //   1254: aload_0
    //   1255: getfield 82	com/tencent/mm/as/a/f/b:erI	Lcom/tencent/mm/as/a/c/o;
    //   1258: ifnull +18 -> 1276
    //   1261: aload 11
    //   1263: astore 9
    //   1265: aload_0
    //   1266: getfield 82	com/tencent/mm/as/a/f/b:erI	Lcom/tencent/mm/as/a/c/o;
    //   1269: invokeinterface 384 1 0
    //   1274: astore 8
    //   1276: aload 8
    //   1278: astore 9
    //   1280: aload_0
    //   1281: getfield 53	com/tencent/mm/as/a/f/b:erR	Lcom/tencent/mm/as/a/c;
    //   1284: aload 8
    //   1286: aload_0
    //   1287: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   1290: getfield 202	com/tencent/mm/as/a/a/c:erl	I
    //   1293: aload_0
    //   1294: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   1297: getfield 208	com/tencent/mm/as/a/a/c:erm	I
    //   1300: aload_0
    //   1301: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   1304: getfield 387	com/tencent/mm/as/a/a/c:ert	Z
    //   1307: aload_0
    //   1308: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   1311: getfield 390	com/tencent/mm/as/a/a/c:alpha	F
    //   1314: aload_0
    //   1315: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   1318: getfield 393	com/tencent/mm/as/a/a/c:ero	Z
    //   1321: invokestatic 396	com/tencent/mm/as/a/g/a:a	(Lcom/tencent/mm/as/a/c;Ljava/io/InputStream;IIZFZ)Landroid/graphics/Bitmap;
    //   1324: astore 11
    //   1326: aload 11
    //   1328: astore 9
    //   1330: iconst_1
    //   1331: istore_1
    //   1332: aload 8
    //   1334: astore 11
    //   1336: aload 11
    //   1338: ifnull +12 -> 1350
    //   1341: aload 9
    //   1343: astore 8
    //   1345: aload 11
    //   1347: invokevirtual 401	java/io/InputStream:close	()V
    //   1350: aload 9
    //   1352: astore 11
    //   1354: iload_1
    //   1355: ifeq +1127 -> 2482
    //   1358: aload 9
    //   1360: astore 11
    //   1362: aload 9
    //   1364: ifnonnull +1118 -> 2482
    //   1367: aload 9
    //   1369: astore 8
    //   1371: aload_0
    //   1372: getfield 88	com/tencent/mm/as/a/f/b:eqT	Lcom/tencent/mm/as/a/c/a;
    //   1375: aload_0
    //   1376: getfield 51	com/tencent/mm/as/a/f/b:url	Ljava/lang/String;
    //   1379: aload_0
    //   1380: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   1383: invokeinterface 437 3 0
    //   1388: pop
    //   1389: aload 9
    //   1391: astore 8
    //   1393: goto -1186 -> 207
    //   1396: iconst_1
    //   1397: istore_1
    //   1398: aconst_null
    //   1399: astore 9
    //   1401: goto -65 -> 1336
    //   1404: astore 8
    //   1406: aload 9
    //   1408: ifnull +8 -> 1416
    //   1411: aload 9
    //   1413: invokevirtual 401	java/io/InputStream:close	()V
    //   1416: aload 8
    //   1418: athrow
    //   1419: aload_0
    //   1420: getfield 53	com/tencent/mm/as/a/f/b:erR	Lcom/tencent/mm/as/a/c;
    //   1423: aload_0
    //   1424: getfield 51	com/tencent/mm/as/a/f/b:url	Ljava/lang/String;
    //   1427: aload_0
    //   1428: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   1431: getfield 202	com/tencent/mm/as/a/a/c:erl	I
    //   1434: aload_0
    //   1435: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   1438: getfield 208	com/tencent/mm/as/a/a/c:erm	I
    //   1441: invokestatic 439	com/tencent/mm/as/a/g/a:c	(Lcom/tencent/mm/as/a/c;Ljava/lang/String;II)Landroid/graphics/Bitmap;
    //   1444: astore 8
    //   1446: goto -1239 -> 207
    //   1449: aload_0
    //   1450: getfield 64	com/tencent/mm/as/a/f/b:eqy	Lcom/tencent/mm/as/a/a/b;
    //   1453: getfield 443	com/tencent/mm/as/a/a/b:eqO	Landroid/content/res/Resources;
    //   1456: aload_0
    //   1457: getfield 51	com/tencent/mm/as/a/f/b:url	Ljava/lang/String;
    //   1460: ldc_w 445
    //   1463: aload_0
    //   1464: getfield 64	com/tencent/mm/as/a/f/b:eqy	Lcom/tencent/mm/as/a/a/b;
    //   1467: getfield 448	com/tencent/mm/as/a/a/b:packageName	Ljava/lang/String;
    //   1470: invokevirtual 454	android/content/res/Resources:getIdentifier	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   1473: istore_1
    //   1474: aload_0
    //   1475: getfield 53	com/tencent/mm/as/a/f/b:erR	Lcom/tencent/mm/as/a/c;
    //   1478: iload_1
    //   1479: aload_0
    //   1480: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   1483: getfield 202	com/tencent/mm/as/a/a/c:erl	I
    //   1486: aload_0
    //   1487: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   1490: getfield 208	com/tencent/mm/as/a/a/c:erm	I
    //   1493: invokestatic 457	com/tencent/mm/as/a/g/a:a	(Lcom/tencent/mm/as/a/c;III)Landroid/graphics/Bitmap;
    //   1496: astore 8
    //   1498: goto -1291 -> 207
    //   1501: aload_0
    //   1502: getfield 51	com/tencent/mm/as/a/f/b:url	Ljava/lang/String;
    //   1505: invokestatic 460	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1508: invokevirtual 464	java/lang/Integer:intValue	()I
    //   1511: istore_1
    //   1512: aload_0
    //   1513: getfield 53	com/tencent/mm/as/a/f/b:erR	Lcom/tencent/mm/as/a/c;
    //   1516: iload_1
    //   1517: aload_0
    //   1518: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   1521: getfield 202	com/tencent/mm/as/a/a/c:erl	I
    //   1524: aload_0
    //   1525: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   1528: getfield 208	com/tencent/mm/as/a/a/c:erm	I
    //   1531: invokestatic 457	com/tencent/mm/as/a/g/a:a	(Lcom/tencent/mm/as/a/c;III)Landroid/graphics/Bitmap;
    //   1534: astore 8
    //   1536: goto -1329 -> 207
    //   1539: invokestatic 227	java/lang/System:currentTimeMillis	()J
    //   1542: lstore_3
    //   1543: ldc 143
    //   1545: ldc_w 466
    //   1548: invokestatic 247	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1551: aload_0
    //   1552: getfield 59	com/tencent/mm/as/a/f/b:erU	Lcom/tencent/mm/as/a/c/g;
    //   1555: ifnull +32 -> 1587
    //   1558: aload_0
    //   1559: getfield 59	com/tencent/mm/as/a/f/b:erU	Lcom/tencent/mm/as/a/c/g;
    //   1562: astore 9
    //   1564: aload_0
    //   1565: getfield 51	com/tencent/mm/as/a/f/b:url	Ljava/lang/String;
    //   1568: astore 11
    //   1570: aload_0
    //   1571: getfield 53	com/tencent/mm/as/a/f/b:erR	Lcom/tencent/mm/as/a/c;
    //   1574: invokevirtual 124	com/tencent/mm/as/a/c:getImageView	()Landroid/widget/ImageView;
    //   1577: pop
    //   1578: aload 9
    //   1580: aload 11
    //   1582: invokeinterface 469 2 0
    //   1587: aload_0
    //   1588: getfield 108	com/tencent/mm/as/a/f/b:erb	Lcom/tencent/mm/as/a/c/n;
    //   1591: aload_0
    //   1592: getfield 51	com/tencent/mm/as/a/f/b:url	Ljava/lang/String;
    //   1595: invokeinterface 474 2 0
    //   1600: ifeq +61 -> 1661
    //   1603: aload_0
    //   1604: getfield 79	com/tencent/mm/as/a/f/b:eqU	Lcom/tencent/mm/as/a/c/b;
    //   1607: aload_0
    //   1608: getfield 51	com/tencent/mm/as/a/f/b:url	Ljava/lang/String;
    //   1611: invokeinterface 480 2 0
    //   1616: astore 9
    //   1618: aload 9
    //   1620: ifnonnull +859 -> 2479
    //   1623: new 114	com/tencent/mm/as/a/d/b
    //   1626: dup
    //   1627: aconst_null
    //   1628: aconst_null
    //   1629: invokespecial 483	com/tencent/mm/as/a/d/b:<init>	([BLjava/lang/String;)V
    //   1632: astore 10
    //   1634: aload 10
    //   1636: astore 9
    //   1638: aload 9
    //   1640: iconst_2
    //   1641: putfield 217	com/tencent/mm/as/a/d/b:from	I
    //   1644: aload 9
    //   1646: getfield 487	com/tencent/mm/as/a/d/b:data	[B
    //   1649: ifnonnull +27 -> 1676
    //   1652: aload 9
    //   1654: iconst_1
    //   1655: putfield 490	com/tencent/mm/as/a/d/b:status	I
    //   1658: goto -1418 -> 240
    //   1661: ldc 143
    //   1663: ldc_w 492
    //   1666: invokestatic 495	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1669: aload 10
    //   1671: astore 9
    //   1673: goto -55 -> 1618
    //   1676: iload 7
    //   1678: ifeq +22 -> 1700
    //   1681: aload_0
    //   1682: getfield 98	com/tencent/mm/as/a/f/b:erW	Lcom/tencent/mm/as/a/c/k;
    //   1685: aload 14
    //   1687: aload 9
    //   1689: getfield 487	com/tencent/mm/as/a/d/b:data	[B
    //   1692: invokeinterface 498 3 0
    //   1697: ifeq +481 -> 2178
    //   1700: ldc 143
    //   1702: ldc_w 500
    //   1705: invokestatic 247	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1708: invokestatic 227	java/lang/System:currentTimeMillis	()J
    //   1711: lstore 5
    //   1713: aload 9
    //   1715: getfield 487	com/tencent/mm/as/a/d/b:data	[B
    //   1718: astore 11
    //   1720: aload 11
    //   1722: astore 10
    //   1724: aload_0
    //   1725: getfield 82	com/tencent/mm/as/a/f/b:erI	Lcom/tencent/mm/as/a/c/o;
    //   1728: ifnull +78 -> 1806
    //   1731: aload_0
    //   1732: getfield 82	com/tencent/mm/as/a/f/b:erI	Lcom/tencent/mm/as/a/c/o;
    //   1735: astore 10
    //   1737: new 502	java/io/ByteArrayInputStream
    //   1740: dup
    //   1741: aload 11
    //   1743: invokespecial 505	java/io/ByteArrayInputStream:<init>	([B)V
    //   1746: pop
    //   1747: aload 10
    //   1749: invokeinterface 384 1 0
    //   1754: astore 10
    //   1756: new 507	java/io/ByteArrayOutputStream
    //   1759: dup
    //   1760: aload 11
    //   1762: arraylength
    //   1763: invokespecial 509	java/io/ByteArrayOutputStream:<init>	(I)V
    //   1766: astore 11
    //   1768: sipush 1024
    //   1771: newarray byte
    //   1773: astore 12
    //   1775: aload 10
    //   1777: aload 12
    //   1779: invokevirtual 513	java/io/InputStream:read	([B)I
    //   1782: istore_1
    //   1783: iload_1
    //   1784: iflt +15 -> 1799
    //   1787: aload 11
    //   1789: aload 12
    //   1791: iconst_0
    //   1792: iload_1
    //   1793: invokevirtual 517	java/io/ByteArrayOutputStream:write	([BII)V
    //   1796: goto -21 -> 1775
    //   1799: aload 11
    //   1801: invokevirtual 521	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   1804: astore 10
    //   1806: aload_0
    //   1807: getfield 53	com/tencent/mm/as/a/f/b:erR	Lcom/tencent/mm/as/a/c;
    //   1810: aload 10
    //   1812: aload_0
    //   1813: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   1816: getfield 202	com/tencent/mm/as/a/a/c:erl	I
    //   1819: aload_0
    //   1820: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   1823: getfield 208	com/tencent/mm/as/a/a/c:erm	I
    //   1826: aload_0
    //   1827: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   1830: getfield 387	com/tencent/mm/as/a/a/c:ert	Z
    //   1833: aload_0
    //   1834: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   1837: getfield 390	com/tencent/mm/as/a/a/c:alpha	F
    //   1840: aload_0
    //   1841: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   1844: getfield 393	com/tencent/mm/as/a/a/c:ero	Z
    //   1847: invokestatic 407	com/tencent/mm/as/a/g/a:a	(Lcom/tencent/mm/as/a/c;[BIIZFZ)Landroid/graphics/Bitmap;
    //   1850: astore 11
    //   1852: aload 11
    //   1854: ifnonnull +20 -> 1874
    //   1857: aload 11
    //   1859: astore 8
    //   1861: aload 9
    //   1863: iconst_3
    //   1864: putfield 490	com/tencent/mm/as/a/d/b:status	I
    //   1867: aload 11
    //   1869: astore 8
    //   1871: goto -1631 -> 240
    //   1874: aload 11
    //   1876: astore 8
    //   1878: aload 9
    //   1880: getfield 487	com/tencent/mm/as/a/d/b:data	[B
    //   1883: astore 10
    //   1885: aload 11
    //   1887: astore 8
    //   1889: aload_0
    //   1890: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   1893: getfield 524	com/tencent/mm/as/a/a/c:erf	Z
    //   1896: ifeq +27 -> 1923
    //   1899: aload 11
    //   1901: astore 8
    //   1903: aload_0
    //   1904: getfield 88	com/tencent/mm/as/a/f/b:eqT	Lcom/tencent/mm/as/a/c/a;
    //   1907: aload_0
    //   1908: getfield 51	com/tencent/mm/as/a/f/b:url	Ljava/lang/String;
    //   1911: aload 10
    //   1913: aload_0
    //   1914: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   1917: invokeinterface 527 4 0
    //   1922: pop
    //   1923: aload 11
    //   1925: astore 8
    //   1927: aload_0
    //   1928: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   1931: getfield 530	com/tencent/mm/as/a/a/c:ere	Z
    //   1934: ifeq +27 -> 1961
    //   1937: aload 11
    //   1939: astore 8
    //   1941: aload_0
    //   1942: getfield 88	com/tencent/mm/as/a/f/b:eqT	Lcom/tencent/mm/as/a/c/a;
    //   1945: aload_0
    //   1946: getfield 51	com/tencent/mm/as/a/f/b:url	Ljava/lang/String;
    //   1949: aload 10
    //   1951: aload_0
    //   1952: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   1955: invokeinterface 527 4 0
    //   1960: pop
    //   1961: aload 11
    //   1963: astore 10
    //   1965: aload 11
    //   1967: astore 8
    //   1969: aload_0
    //   1970: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   1973: getfield 173	com/tencent/mm/as/a/a/c:erD	Z
    //   1976: ifeq +56 -> 2032
    //   1979: aload 11
    //   1981: astore 8
    //   1983: aload_0
    //   1984: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   1987: getfield 186	com/tencent/mm/as/a/a/c:erE	F
    //   1990: fconst_0
    //   1991: fcmpl
    //   1992: ifne +164 -> 2156
    //   1995: aload 11
    //   1997: astore 8
    //   1999: aload 11
    //   2001: invokevirtual 533	android/graphics/Bitmap:getWidth	()I
    //   2004: aload 11
    //   2006: invokevirtual 536	android/graphics/Bitmap:getHeight	()I
    //   2009: if_icmpne +68 -> 2077
    //   2012: aload 11
    //   2014: astore 8
    //   2016: aload 11
    //   2018: iconst_0
    //   2019: aload 11
    //   2021: invokevirtual 533	android/graphics/Bitmap:getWidth	()I
    //   2024: iconst_2
    //   2025: idiv
    //   2026: i2f
    //   2027: invokestatic 539	com/tencent/mm/sdk/platformtools/c:a	(Landroid/graphics/Bitmap;ZF)Landroid/graphics/Bitmap;
    //   2030: astore 10
    //   2032: aload 10
    //   2034: astore 8
    //   2036: aload_0
    //   2037: aload 9
    //   2039: aload 10
    //   2041: invokespecial 541	com/tencent/mm/as/a/f/b:a	(Lcom/tencent/mm/as/a/d/b;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   2044: astore 10
    //   2046: aload 10
    //   2048: astore 8
    //   2050: aload_0
    //   2051: aload 13
    //   2053: aload 10
    //   2055: invokespecial 543	com/tencent/mm/as/a/f/b:j	(Ljava/lang/String;Landroid/graphics/Bitmap;)V
    //   2058: aload 10
    //   2060: astore 8
    //   2062: aload_0
    //   2063: lload 5
    //   2065: lload_3
    //   2066: lsub
    //   2067: invokevirtual 544	com/tencent/mm/as/a/f/b:cc	(J)V
    //   2070: aload 10
    //   2072: astore 8
    //   2074: goto -1834 -> 240
    //   2077: aload 11
    //   2079: astore 8
    //   2081: aload 11
    //   2083: invokevirtual 533	android/graphics/Bitmap:getWidth	()I
    //   2086: aload 11
    //   2088: invokevirtual 536	android/graphics/Bitmap:getHeight	()I
    //   2091: invokestatic 550	java/lang/Math:min	(II)I
    //   2094: istore_2
    //   2095: iload_2
    //   2096: istore_1
    //   2097: iload_2
    //   2098: ifgt +21 -> 2119
    //   2101: aload 11
    //   2103: astore 8
    //   2105: aload 11
    //   2107: invokevirtual 533	android/graphics/Bitmap:getWidth	()I
    //   2110: aload 11
    //   2112: invokevirtual 536	android/graphics/Bitmap:getHeight	()I
    //   2115: invokestatic 553	java/lang/Math:max	(II)I
    //   2118: istore_1
    //   2119: aload 11
    //   2121: astore 8
    //   2123: aload 11
    //   2125: iload_1
    //   2126: iload_1
    //   2127: iconst_1
    //   2128: invokestatic 556	com/tencent/mm/sdk/platformtools/c:a	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   2131: astore 10
    //   2133: aload 10
    //   2135: astore 8
    //   2137: aload 10
    //   2139: iconst_0
    //   2140: aload 10
    //   2142: invokevirtual 533	android/graphics/Bitmap:getWidth	()I
    //   2145: iconst_2
    //   2146: idiv
    //   2147: i2f
    //   2148: invokestatic 539	com/tencent/mm/sdk/platformtools/c:a	(Landroid/graphics/Bitmap;ZF)Landroid/graphics/Bitmap;
    //   2151: astore 10
    //   2153: goto -121 -> 2032
    //   2156: aload 11
    //   2158: astore 8
    //   2160: aload 11
    //   2162: iconst_0
    //   2163: aload_0
    //   2164: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   2167: getfield 186	com/tencent/mm/as/a/a/c:erE	F
    //   2170: invokestatic 539	com/tencent/mm/sdk/platformtools/c:a	(Landroid/graphics/Bitmap;ZF)Landroid/graphics/Bitmap;
    //   2173: astore 10
    //   2175: goto -143 -> 2032
    //   2178: aload 9
    //   2180: iconst_2
    //   2181: putfield 490	com/tencent/mm/as/a/d/b:status	I
    //   2184: ldc 143
    //   2186: ldc_w 558
    //   2189: invokestatic 273	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   2192: aconst_null
    //   2193: astore 8
    //   2195: goto -1955 -> 240
    //   2198: ldc 143
    //   2200: ldc_w 560
    //   2203: invokestatic 273	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   2206: aload 10
    //   2208: astore 9
    //   2210: goto -1970 -> 240
    //   2213: aload_0
    //   2214: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   2217: getfield 173	com/tencent/mm/as/a/a/c:erD	Z
    //   2220: ifeq +252 -> 2472
    //   2223: aload_0
    //   2224: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   2227: getfield 186	com/tencent/mm/as/a/a/c:erE	F
    //   2230: fconst_0
    //   2231: fcmpl
    //   2232: ifne +160 -> 2392
    //   2235: aload 8
    //   2237: invokevirtual 533	android/graphics/Bitmap:getWidth	()I
    //   2240: aload 8
    //   2242: invokevirtual 536	android/graphics/Bitmap:getHeight	()I
    //   2245: if_icmpne +80 -> 2325
    //   2248: aload 8
    //   2250: iconst_0
    //   2251: aload 8
    //   2253: invokevirtual 533	android/graphics/Bitmap:getWidth	()I
    //   2256: iconst_2
    //   2257: idiv
    //   2258: i2f
    //   2259: invokestatic 539	com/tencent/mm/sdk/platformtools/c:a	(Landroid/graphics/Bitmap;ZF)Landroid/graphics/Bitmap;
    //   2262: astore 9
    //   2264: aload 9
    //   2266: astore 8
    //   2268: aload_0
    //   2269: aload 10
    //   2271: aload 9
    //   2273: invokespecial 541	com/tencent/mm/as/a/f/b:a	(Lcom/tencent/mm/as/a/d/b;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   2276: astore 9
    //   2278: aload 9
    //   2280: astore 8
    //   2282: aload_0
    //   2283: aload 13
    //   2285: aload 9
    //   2287: invokespecial 543	com/tencent/mm/as/a/f/b:j	(Ljava/lang/String;Landroid/graphics/Bitmap;)V
    //   2290: aload 9
    //   2292: astore 8
    //   2294: aload_0
    //   2295: lload 5
    //   2297: lload_3
    //   2298: lsub
    //   2299: invokevirtual 544	com/tencent/mm/as/a/f/b:cc	(J)V
    //   2302: aload 9
    //   2304: astore 8
    //   2306: ldc 143
    //   2308: ldc_w 562
    //   2311: invokestatic 247	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   2314: aload 9
    //   2316: astore 8
    //   2318: aload 10
    //   2320: astore 9
    //   2322: goto -2082 -> 240
    //   2325: aload 8
    //   2327: invokevirtual 533	android/graphics/Bitmap:getWidth	()I
    //   2330: aload 8
    //   2332: invokevirtual 536	android/graphics/Bitmap:getHeight	()I
    //   2335: invokestatic 550	java/lang/Math:min	(II)I
    //   2338: istore_2
    //   2339: iload_2
    //   2340: istore_1
    //   2341: iload_2
    //   2342: ifgt +17 -> 2359
    //   2345: aload 8
    //   2347: invokevirtual 533	android/graphics/Bitmap:getWidth	()I
    //   2350: aload 8
    //   2352: invokevirtual 536	android/graphics/Bitmap:getHeight	()I
    //   2355: invokestatic 553	java/lang/Math:max	(II)I
    //   2358: istore_1
    //   2359: aload 8
    //   2361: iload_1
    //   2362: iload_1
    //   2363: iconst_1
    //   2364: invokestatic 556	com/tencent/mm/sdk/platformtools/c:a	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   2367: astore 9
    //   2369: aload 9
    //   2371: astore 8
    //   2373: aload 9
    //   2375: iconst_0
    //   2376: aload 9
    //   2378: invokevirtual 533	android/graphics/Bitmap:getWidth	()I
    //   2381: iconst_2
    //   2382: idiv
    //   2383: i2f
    //   2384: invokestatic 539	com/tencent/mm/sdk/platformtools/c:a	(Landroid/graphics/Bitmap;ZF)Landroid/graphics/Bitmap;
    //   2387: astore 9
    //   2389: goto -125 -> 2264
    //   2392: aload 8
    //   2394: iconst_0
    //   2395: aload_0
    //   2396: getfield 69	com/tencent/mm/as/a/f/b:eqR	Lcom/tencent/mm/as/a/a/c;
    //   2399: getfield 186	com/tencent/mm/as/a/a/c:erE	F
    //   2402: invokestatic 539	com/tencent/mm/sdk/platformtools/c:a	(Landroid/graphics/Bitmap;ZF)Landroid/graphics/Bitmap;
    //   2405: astore 9
    //   2407: goto -143 -> 2264
    //   2410: ldc 143
    //   2412: ldc_w 564
    //   2415: invokestatic 273	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   2418: goto -2070 -> 348
    //   2421: astore 8
    //   2423: goto -1454 -> 969
    //   2426: astore 8
    //   2428: goto -1078 -> 1350
    //   2431: astore 9
    //   2433: goto -1017 -> 1416
    //   2436: astore 11
    //   2438: aload 10
    //   2440: astore 9
    //   2442: aload 11
    //   2444: astore 10
    //   2446: goto -1461 -> 985
    //   2449: astore 11
    //   2451: aload 10
    //   2453: astore 9
    //   2455: aload 11
    //   2457: astore 10
    //   2459: goto -1474 -> 985
    //   2462: astore 10
    //   2464: goto -1479 -> 985
    //   2467: astore 10
    //   2469: goto -1484 -> 985
    //   2472: aload 8
    //   2474: astore 9
    //   2476: goto -212 -> 2264
    //   2479: goto -841 -> 1638
    //   2482: aload 11
    //   2484: astore 8
    //   2486: goto -2279 -> 207
    //   2489: aconst_null
    //   2490: astore 9
    //   2492: goto -1156 -> 1336
    //   2495: goto -2307 -> 188
    //   2498: iload_2
    //   2499: tableswitch	default:+33 -> 2532, 1:+-301->2198, 2:+-301->2198, 3:+-301->2198, 4:+-301->2198, 5:+-960->1539
    //   2533: <illegal opcode>
    //   2534: nop
    //   2535: astore 10
    //   2537: goto -1552 -> 985
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2540	0	this	b
    //   1196	1167	1	i	int
    //   57	2442	2	j	int
    //   49	2249	3	l1	long
    //   210	2086	5	l2	long
    //   65	1612	7	bool	boolean
    //   1	934	8	localObject1	Object
    //   948	17	8	localIOException1	java.io.IOException
    //   979	413	8	localObject2	Object
    //   1404	13	8	localObject3	Object
    //   1444	949	8	localObject4	Object
    //   2421	1	8	localIOException2	java.io.IOException
    //   2426	47	8	localIOException3	java.io.IOException
    //   2484	1	8	localObject5	Object
    //   238	715	9	localObject6	Object
    //   957	13	9	localObject7	Object
    //   976	1430	9	localObject8	Object
    //   2431	1	9	localIOException4	java.io.IOException
    //   2440	51	9	localObject9	Object
    //   10	2448	10	localObject10	Object
    //   2462	1	10	localException1	java.lang.Exception
    //   2467	1	10	localException2	java.lang.Exception
    //   2535	1	10	localException3	java.lang.Exception
    //   539	412	11	localObject11	Object
    //   972	10	11	localException4	java.lang.Exception
    //   1125	1036	11	localObject12	Object
    //   2436	7	11	localException5	java.lang.Exception
    //   2449	34	11	localException6	java.lang.Exception
    //   871	919	12	localObject13	Object
    //   26	2258	13	str1	String
    //   74	1612	14	str2	String
    // Exception table:
    //   from	to	target	type
    //   936	941	948	java/io/IOException
    //   838	844	957	finally
    //   848	860	957	finally
    //   864	873	957	finally
    //   877	923	957	finally
    //   18	154	972	java/lang/Exception
    //   188	207	972	java/lang/Exception
    //   463	533	972	java/lang/Exception
    //   574	599	972	java/lang/Exception
    //   602	622	972	java/lang/Exception
    //   627	645	972	java/lang/Exception
    //   645	682	972	java/lang/Exception
    //   820	826	972	java/lang/Exception
    //   964	969	972	java/lang/Exception
    //   969	972	972	java/lang/Exception
    //   1008	1075	972	java/lang/Exception
    //   1078	1105	972	java/lang/Exception
    //   1130	1138	972	java/lang/Exception
    //   1144	1170	972	java/lang/Exception
    //   1170	1178	972	java/lang/Exception
    //   1181	1189	972	java/lang/Exception
    //   1411	1416	972	java/lang/Exception
    //   1416	1419	972	java/lang/Exception
    //   1419	1446	972	java/lang/Exception
    //   1449	1498	972	java/lang/Exception
    //   1501	1536	972	java/lang/Exception
    //   1197	1216	1404	finally
    //   1230	1246	1404	finally
    //   1254	1261	1404	finally
    //   1265	1276	1404	finally
    //   1280	1326	1404	finally
    //   964	969	2421	java/io/IOException
    //   1345	1350	2426	java/io/IOException
    //   1411	1416	2431	java/io/IOException
    //   541	551	2436	java/lang/Exception
    //   555	567	2436	java/lang/Exception
    //   690	700	2436	java/lang/Exception
    //   717	724	2436	java/lang/Exception
    //   728	735	2436	java/lang/Exception
    //   739	766	2436	java/lang/Exception
    //   775	785	2436	java/lang/Exception
    //   789	801	2436	java/lang/Exception
    //   805	813	2436	java/lang/Exception
    //   936	941	2436	java/lang/Exception
    //   1112	1127	2436	java/lang/Exception
    //   1345	1350	2436	java/lang/Exception
    //   1371	1389	2436	java/lang/Exception
    //   2268	2278	2436	java/lang/Exception
    //   2282	2290	2436	java/lang/Exception
    //   2294	2302	2436	java/lang/Exception
    //   2306	2314	2436	java/lang/Exception
    //   2373	2389	2436	java/lang/Exception
    //   207	212	2449	java/lang/Exception
    //   217	225	2449	java/lang/Exception
    //   228	236	2449	java/lang/Exception
    //   1539	1587	2449	java/lang/Exception
    //   1587	1618	2449	java/lang/Exception
    //   1661	1669	2449	java/lang/Exception
    //   2198	2206	2449	java/lang/Exception
    //   2213	2264	2449	java/lang/Exception
    //   2325	2339	2449	java/lang/Exception
    //   2345	2359	2449	java/lang/Exception
    //   2359	2369	2449	java/lang/Exception
    //   2392	2407	2449	java/lang/Exception
    //   1623	1634	2462	java/lang/Exception
    //   1861	1867	2467	java/lang/Exception
    //   1878	1885	2467	java/lang/Exception
    //   1889	1899	2467	java/lang/Exception
    //   1903	1923	2467	java/lang/Exception
    //   1927	1937	2467	java/lang/Exception
    //   1941	1961	2467	java/lang/Exception
    //   1969	1979	2467	java/lang/Exception
    //   1983	1995	2467	java/lang/Exception
    //   1999	2012	2467	java/lang/Exception
    //   2016	2032	2467	java/lang/Exception
    //   2036	2046	2467	java/lang/Exception
    //   2050	2058	2467	java/lang/Exception
    //   2062	2070	2467	java/lang/Exception
    //   2081	2095	2467	java/lang/Exception
    //   2105	2119	2467	java/lang/Exception
    //   2123	2133	2467	java/lang/Exception
    //   2137	2153	2467	java/lang/Exception
    //   2160	2175	2467	java/lang/Exception
    //   1638	1658	2535	java/lang/Exception
    //   1681	1700	2535	java/lang/Exception
    //   1700	1720	2535	java/lang/Exception
    //   1724	1775	2535	java/lang/Exception
    //   1775	1783	2535	java/lang/Exception
    //   1787	1796	2535	java/lang/Exception
    //   1799	1806	2535	java/lang/Exception
    //   1806	1852	2535	java/lang/Exception
    //   2178	2192	2535	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.as.a.f.b
 * JD-Core Version:    0.7.0.1
 */