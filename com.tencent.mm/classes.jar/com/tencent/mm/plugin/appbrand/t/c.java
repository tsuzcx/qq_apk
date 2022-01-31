package com.tencent.mm.plugin.appbrand.t;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.luggage.e.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.b;
import com.tencent.mm.memory.l;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.d;
import java.io.IOException;
import java.io.OutputStream;

public enum c
{
  private static boolean a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Bitmap.CompressFormat paramCompressFormat, int paramInt5, String paramString2)
  {
    AppMethodBeat.i(73194);
    localObject4 = null;
    localObject3 = localObject4;
    try
    {
      ab.i("MicroMsg.AppBrandImgUtil", "createThumbNailUnScale, srcWidth: %s, srcHeight: %s, width: %s, height: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt4), Integer.valueOf(paramInt3) });
      localObject3 = localObject4;
      localObject2 = new BitmapFactory.Options();
      localObject3 = localObject4;
      d2 = paramInt2 * 1.0D / paramInt3;
      localObject3 = localObject4;
      d3 = paramInt1 * 1.0D / paramInt4;
      if ((paramInt1 != paramInt4) || (paramInt2 != paramInt3)) {
        break label147;
      }
      localObject3 = localObject4;
      localObject2 = b(paramString1, (BitmapFactory.Options)localObject2);
    }
    catch (IOException paramString1)
    {
      for (;;)
      {
        Object localObject2;
        double d2;
        double d3;
        label147:
        label171:
        Object localObject1;
        ab.printErrStackTrace("MicroMsg.AppBrandImgUtil", paramString1, "create thumbnail from orig failed: %s", new Object[] { paramString2 });
        if (localObject3 != null) {}
        do
        {
          try
          {
            ((OutputStream)localObject3).close();
            AppMethodBeat.o(73194);
            return false;
            d1 = d2;
            break label171;
            localObject3 = localObject4;
            ab.i("MicroMsg.AppBrandImgUtil", "createThumbNailUnScale, sampleSize: %s", new Object[] { Integer.valueOf(((BitmapFactory.Options)localObject2).inSampleSize) });
            localObject3 = localObject4;
            localObject2 = b(paramString1, (BitmapFactory.Options)localObject2);
            break;
            localObject3 = localObject4;
            ab.i("MicroMsg.AppBrandImgUtil", "createThumbNailUnScale, bm.width: %s, bm.height: %s", new Object[] { Integer.valueOf(((Bitmap)localObject2).getWidth()), Integer.valueOf(((Bitmap)localObject2).getHeight()) });
            if (d2 < d3)
            {
              localObject3 = localObject4;
              paramInt2 = (int)Math.ceil(paramInt4 * 1.0D * paramInt2 / paramInt1);
              paramInt1 = paramInt4;
            }
            for (;;)
            {
              localObject3 = localObject4;
              paramInt4 = BackwardSupportUtil.ExifHelper.bY(paramString1);
              if ((paramInt4 != 90) && (paramInt4 != 270)) {
                break label617;
              }
              localObject3 = localObject4;
              paramString1 = d.b((Bitmap)localObject2, paramInt4);
              localObject3 = localObject4;
              Bitmap localBitmap = Bitmap.createScaledBitmap(paramString1, paramInt2, paramInt1, true);
              if (localBitmap == null) {
                break;
              }
              localObject2 = localBitmap;
              if (paramString1 != localBitmap)
              {
                localObject3 = localObject4;
                l.XQ().u(paramString1);
                localObject2 = localBitmap;
              }
              localObject3 = localObject4;
              ab.i("MicroMsg.AppBrandImgUtil", "createThumbNailUnScalebyUpload, degree %d, bm.width: %s, bm.height: %s", new Object[] { Integer.valueOf(paramInt4), Integer.valueOf(((Bitmap)localObject2).getWidth()), Integer.valueOf(((Bitmap)localObject2).getHeight()) });
              localObject3 = localObject4;
              paramString1 = FileOp.qC(paramString2);
              localObject3 = paramString1;
              d.a((Bitmap)localObject2, paramInt5, paramCompressFormat, paramString1, false);
              localObject3 = paramString1;
              l.XQ().u((Bitmap)localObject2);
              localObject3 = paramString1;
              paramString1.close();
              AppMethodBeat.o(73194);
              return true;
              d1 = paramInt3 * 1.0D * paramInt1 / paramInt2;
              localObject3 = localObject4;
              d1 = Math.ceil(d1);
              paramInt1 = (int)d1;
              paramInt2 = paramInt3;
            }
          }
          catch (IOException paramString1)
          {
            for (;;)
            {
              continue;
              localObject2 = paramString1;
              continue;
              paramInt3 = paramInt2;
              paramInt2 = paramInt1;
              paramString1 = (String)localObject2;
              paramInt1 = paramInt3;
            }
          }
        } while (d2 >= d3);
        double d1 = d3;
      }
    }
    localObject3 = localObject4;
    ab.i("MicroMsg.AppBrandImgUtil", "createThumbNailUnScale, result bm: %s", new Object[] { localObject2 });
    if (localObject2 == null)
    {
      AppMethodBeat.o(73194);
      return false;
      localObject3 = localObject4;
      ((BitmapFactory.Options)localObject2).inSampleSize = 1;
      if (paramInt2 > paramInt3) {
        break label629;
      }
      if (paramInt1 > paramInt4)
      {
        break label629;
        localObject3 = localObject4;
        ((BitmapFactory.Options)localObject2).inSampleSize = ((int)localObject1);
        localObject3 = localObject4;
        if (((BitmapFactory.Options)localObject2).inSampleSize <= 1) {
          localObject3 = localObject4;
        }
      }
      for (((BitmapFactory.Options)localObject2).inSampleSize = 1;; ((BitmapFactory.Options)localObject2).inSampleSize += 1)
      {
        localObject3 = localObject4;
        if (paramInt2 * paramInt1 / ((BitmapFactory.Options)localObject2).inSampleSize / ((BitmapFactory.Options)localObject2).inSampleSize <= 2764800) {
          break;
        }
        localObject3 = localObject4;
      }
    }
  }
  
  private static boolean a(String paramString1, int paramInt1, int paramInt2, Bitmap.CompressFormat paramCompressFormat, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(73192);
    BitmapFactory.Options localOptions = d.aoT(paramString1);
    if ((localOptions == null) || (localOptions.outWidth <= 0) || (localOptions.outHeight <= 0))
    {
      AppMethodBeat.o(73192);
      return false;
    }
    boolean bool = a(paramString1, localOptions.outWidth, localOptions.outHeight, paramInt1, paramInt2, paramCompressFormat, paramInt3, paramString2);
    AppMethodBeat.o(73192);
    return bool;
  }
  
  private static Bitmap b(String paramString, BitmapFactory.Options paramOptions)
  {
    AppMethodBeat.i(73193);
    long l = System.currentTimeMillis();
    try
    {
      paramString = l.XQ().a(paramString, paramOptions);
      ab.d("MicroMsg.AppBrandImgUtil", "decodeWithRotateByExif used %dms bitmap: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), paramString });
      AppMethodBeat.o(73193);
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      b.dAs();
      ab.e("MicroMsg.AppBrandImgUtil", "OutOfMemoryError e " + paramString.getMessage());
      AppMethodBeat.o(73193);
    }
    return null;
  }
  
  @Deprecated
  public static boolean b(BitmapFactory.Options paramOptions)
  {
    AppMethodBeat.i(73191);
    boolean bool = a.b(paramOptions);
    AppMethodBeat.o(73191);
    return bool;
  }
  
  public static boolean cW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(73195);
    boolean bool = g(paramString1, paramString2, -1, -1);
    AppMethodBeat.o(73195);
    return bool;
  }
  
  /* Error */
  public static boolean g(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: ldc 205
    //   2: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: bipush 70
    //   7: istore 7
    //   9: aload_1
    //   10: invokestatic 209	com/tencent/mm/modelsfs/FileOp:ub	(Ljava/lang/String;)J
    //   13: l2i
    //   14: istore 10
    //   16: iload_2
    //   17: ifle +40 -> 57
    //   20: iload_3
    //   21: ifle +43 -> 64
    //   24: aload_1
    //   25: invokestatic 131	com/tencent/mm/sdk/platformtools/d:aoT	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   28: astore 15
    //   30: aload 15
    //   32: ifnonnull +39 -> 71
    //   35: ldc 25
    //   37: ldc 211
    //   39: iconst_1
    //   40: anewarray 29	java/lang/Object
    //   43: dup
    //   44: iconst_0
    //   45: aload_1
    //   46: aastore
    //   47: invokestatic 40	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   50: ldc 205
    //   52: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: iconst_0
    //   56: ireturn
    //   57: sipush 960
    //   60: istore_2
    //   61: goto -41 -> 20
    //   64: sipush 640
    //   67: istore_3
    //   68: goto -44 -> 24
    //   71: aload 15
    //   73: ifnull +410 -> 483
    //   76: aload 15
    //   78: getfield 215	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   81: astore 16
    //   83: ldc 25
    //   85: ldc 217
    //   87: aload 16
    //   89: invokestatic 222	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   92: invokevirtual 226	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   95: invokestatic 228	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: aload 16
    //   100: ifnull +383 -> 483
    //   103: aload 16
    //   105: invokevirtual 231	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   108: astore 16
    //   110: aload 16
    //   112: ldc 233
    //   114: invokevirtual 236	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   117: iflt +332 -> 449
    //   120: iconst_1
    //   121: istore 11
    //   123: aload 15
    //   125: invokestatic 194	com/tencent/luggage/e/a/a:b	(Landroid/graphics/BitmapFactory$Options;)Z
    //   128: istore 12
    //   130: iconst_m1
    //   131: istore 6
    //   133: iload 12
    //   135: ifeq +1630 -> 1765
    //   138: aload_1
    //   139: invokestatic 241	com/tencent/mm/sdk/platformtools/MMNativeJpeg:queryQuality	(Ljava/lang/String;)I
    //   142: istore 5
    //   144: iload 5
    //   146: istore 6
    //   148: iload 5
    //   150: bipush 70
    //   152: if_icmpge +1613 -> 1765
    //   155: iload 5
    //   157: istore 6
    //   159: iload 5
    //   161: bipush 25
    //   163: if_icmple +1602 -> 1765
    //   166: iload 5
    //   168: istore 8
    //   170: iload 5
    //   172: istore 6
    //   174: iconst_0
    //   175: istore 7
    //   177: iconst_0
    //   178: istore 5
    //   180: iconst_0
    //   181: istore 9
    //   183: iload 12
    //   185: ifeq +332 -> 517
    //   188: iload 7
    //   190: istore 5
    //   192: aload_1
    //   193: invokestatic 247	com/tencent/mm/compatible/util/Exif:fromFile	(Ljava/lang/String;)Lcom/tencent/mm/compatible/util/Exif;
    //   196: astore 16
    //   198: iload 9
    //   200: istore 5
    //   202: aload 16
    //   204: ifnull +48 -> 252
    //   207: iload 7
    //   209: istore 5
    //   211: aload 16
    //   213: invokevirtual 250	com/tencent/mm/compatible/util/Exif:getOrientationInDegree	()I
    //   216: sipush 360
    //   219: irem
    //   220: istore 7
    //   222: iload 7
    //   224: istore 5
    //   226: ldc 25
    //   228: ldc 252
    //   230: iconst_1
    //   231: anewarray 29	java/lang/Object
    //   234: dup
    //   235: iconst_0
    //   236: aload 16
    //   238: invokevirtual 250	com/tencent/mm/compatible/util/Exif:getOrientationInDegree	()I
    //   241: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   244: aastore
    //   245: invokestatic 40	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   248: iload 7
    //   250: istore 5
    //   252: iload 5
    //   254: istore 7
    //   256: ldc 25
    //   258: new 167	java/lang/StringBuilder
    //   261: dup
    //   262: ldc 254
    //   264: invokespecial 172	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   267: aload 15
    //   269: getfield 134	android/graphics/BitmapFactory$Options:outWidth	I
    //   272: invokevirtual 257	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   275: ldc_w 259
    //   278: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: aload 15
    //   283: getfield 137	android/graphics/BitmapFactory$Options:outHeight	I
    //   286: invokevirtual 257	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   289: ldc_w 259
    //   292: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: iload 11
    //   297: invokevirtual 262	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   300: ldc_w 264
    //   303: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: iload 8
    //   308: invokevirtual 257	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   311: ldc_w 266
    //   314: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: iload 7
    //   319: invokevirtual 257	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   322: ldc_w 268
    //   325: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: iload 10
    //   330: invokevirtual 257	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   333: ldc_w 270
    //   336: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: iload_2
    //   340: invokevirtual 257	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   343: ldc_w 259
    //   346: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: iload_3
    //   350: invokevirtual 257	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   353: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   356: invokestatic 272	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   359: aload 15
    //   361: getfield 134	android/graphics/BitmapFactory$Options:outWidth	I
    //   364: aload 15
    //   366: getfield 137	android/graphics/BitmapFactory$Options:outHeight	I
    //   369: iconst_2
    //   370: imul
    //   371: if_icmpge +18 -> 389
    //   374: aload 15
    //   376: getfield 137	android/graphics/BitmapFactory$Options:outHeight	I
    //   379: aload 15
    //   381: getfield 134	android/graphics/BitmapFactory$Options:outWidth	I
    //   384: iconst_2
    //   385: imul
    //   386: if_icmplt +574 -> 960
    //   389: aload 15
    //   391: getfield 134	android/graphics/BitmapFactory$Options:outWidth	I
    //   394: aload 15
    //   396: getfield 137	android/graphics/BitmapFactory$Options:outHeight	I
    //   399: imul
    //   400: ldc_w 273
    //   403: if_icmpgt +557 -> 960
    //   406: iload 10
    //   408: ldc_w 274
    //   411: if_icmpge +120 -> 531
    //   414: iload 11
    //   416: ifeq +115 -> 531
    //   419: iload 7
    //   421: ifne +110 -> 531
    //   424: ldc 25
    //   426: ldc_w 276
    //   429: invokestatic 272	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   432: aload_1
    //   433: aload_0
    //   434: invokestatic 280	com/tencent/mm/modelsfs/FileOp:C	(Ljava/lang/String;Ljava/lang/String;)J
    //   437: lconst_0
    //   438: lcmp
    //   439: iflt +85 -> 524
    //   442: ldc 205
    //   444: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   447: iconst_1
    //   448: ireturn
    //   449: aload 16
    //   451: ldc_w 282
    //   454: invokevirtual 236	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   457: iflt +9 -> 466
    //   460: iconst_1
    //   461: istore 11
    //   463: goto -340 -> 123
    //   466: aload 16
    //   468: ldc_w 284
    //   471: invokevirtual 236	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   474: iflt +9 -> 483
    //   477: iconst_1
    //   478: istore 11
    //   480: goto -357 -> 123
    //   483: iconst_0
    //   484: istore 11
    //   486: goto -363 -> 123
    //   489: astore 16
    //   491: ldc 25
    //   493: new 167	java/lang/StringBuilder
    //   496: dup
    //   497: ldc_w 286
    //   500: invokespecial 172	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   503: aload 16
    //   505: invokevirtual 287	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   508: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   514: invokestatic 187	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   517: iload 5
    //   519: istore 7
    //   521: goto -265 -> 256
    //   524: ldc 205
    //   526: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   529: iconst_0
    //   530: ireturn
    //   531: new 42	android/graphics/BitmapFactory$Options
    //   534: dup
    //   535: invokespecial 45	android/graphics/BitmapFactory$Options:<init>	()V
    //   538: astore 19
    //   540: invokestatic 290	com/tencent/mm/sdk/platformtools/d:dsm	()V
    //   543: aconst_null
    //   544: astore 16
    //   546: aconst_null
    //   547: astore 15
    //   549: aload_1
    //   550: invokestatic 294	com/tencent/mm/modelsfs/FileOp:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   553: astore 18
    //   555: aload 18
    //   557: astore 17
    //   559: aload 18
    //   561: astore 15
    //   563: aload 18
    //   565: astore 16
    //   567: aload 18
    //   569: invokevirtual 300	java/io/InputStream:markSupported	()Z
    //   572: ifne +45 -> 617
    //   575: aload 18
    //   577: astore 17
    //   579: aload 18
    //   581: astore 15
    //   583: aload 18
    //   585: astore 16
    //   587: aload 18
    //   589: instanceof 302
    //   592: ifeq +25 -> 617
    //   595: aload 18
    //   597: astore 15
    //   599: aload 18
    //   601: astore 16
    //   603: new 304	com/tencent/mm/sdk/platformtools/l
    //   606: dup
    //   607: aload 18
    //   609: checkcast 302	java/io/FileInputStream
    //   612: invokespecial 307	com/tencent/mm/sdk/platformtools/l:<init>	(Ljava/io/FileInputStream;)V
    //   615: astore 17
    //   617: aload 17
    //   619: astore 15
    //   621: aload 17
    //   623: astore 16
    //   625: aload 17
    //   627: ldc_w 308
    //   630: invokevirtual 311	java/io/InputStream:mark	(I)V
    //   633: aload 17
    //   635: astore 15
    //   637: aload 17
    //   639: astore 16
    //   641: aload 17
    //   643: aconst_null
    //   644: aload 19
    //   646: invokestatic 317	com/tencent/mm/graphics/MMBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   649: astore 18
    //   651: aload 17
    //   653: astore 15
    //   655: aload 17
    //   657: astore 16
    //   659: aload 17
    //   661: invokevirtual 320	java/io/InputStream:reset	()V
    //   664: aload 18
    //   666: ifnonnull +20 -> 686
    //   669: aload 17
    //   671: ifnull +8 -> 679
    //   674: aload 17
    //   676: invokevirtual 321	java/io/InputStream:close	()V
    //   679: ldc 205
    //   681: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   684: iconst_0
    //   685: ireturn
    //   686: iload 7
    //   688: i2f
    //   689: fstore 4
    //   691: aload 17
    //   693: astore 15
    //   695: aload 17
    //   697: astore 16
    //   699: aload 18
    //   701: fload 4
    //   703: invokestatic 100	com/tencent/mm/sdk/platformtools/d:b	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   706: iload 6
    //   708: getstatic 327	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   711: aload_0
    //   712: iconst_1
    //   713: invokestatic 330	com/tencent/mm/sdk/platformtools/d:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)V
    //   716: iload 11
    //   718: ifeq +165 -> 883
    //   721: iload 7
    //   723: ifne +160 -> 883
    //   726: aload 17
    //   728: astore 15
    //   730: aload 17
    //   732: astore 16
    //   734: aload_0
    //   735: invokestatic 209	com/tencent/mm/modelsfs/FileOp:ub	(Ljava/lang/String;)J
    //   738: lstore 13
    //   740: aload 17
    //   742: astore 15
    //   744: aload 17
    //   746: astore 16
    //   748: ldc 25
    //   750: ldc_w 332
    //   753: iconst_3
    //   754: anewarray 29	java/lang/Object
    //   757: dup
    //   758: iconst_0
    //   759: iload 10
    //   761: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   764: aastore
    //   765: dup
    //   766: iconst_1
    //   767: lload 13
    //   769: invokestatic 157	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   772: aastore
    //   773: dup
    //   774: iconst_2
    //   775: bipush 10
    //   777: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   780: aastore
    //   781: invokestatic 40	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   784: iload 10
    //   786: i2l
    //   787: lload 13
    //   789: lsub
    //   790: ldc2_w 333
    //   793: lmul
    //   794: iload 10
    //   796: bipush 10
    //   798: imul
    //   799: i2l
    //   800: lcmp
    //   801: ifge +65 -> 866
    //   804: aload 17
    //   806: astore 15
    //   808: aload 17
    //   810: astore 16
    //   812: aload_0
    //   813: invokestatic 338	com/tencent/mm/modelsfs/FileOp:deleteFile	(Ljava/lang/String;)Z
    //   816: pop
    //   817: aload 17
    //   819: astore 15
    //   821: aload 17
    //   823: astore 16
    //   825: aload_1
    //   826: aload_0
    //   827: invokestatic 280	com/tencent/mm/modelsfs/FileOp:C	(Ljava/lang/String;Ljava/lang/String;)J
    //   830: lstore 13
    //   832: lload 13
    //   834: lconst_0
    //   835: lcmp
    //   836: iflt +24 -> 860
    //   839: iconst_1
    //   840: istore 11
    //   842: aload 17
    //   844: ifnull +8 -> 852
    //   847: aload 17
    //   849: invokevirtual 321	java/io/InputStream:close	()V
    //   852: ldc 205
    //   854: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   857: iload 11
    //   859: ireturn
    //   860: iconst_0
    //   861: istore 11
    //   863: goto -21 -> 842
    //   866: aload 17
    //   868: ifnull +8 -> 876
    //   871: aload 17
    //   873: invokevirtual 321	java/io/InputStream:close	()V
    //   876: ldc 205
    //   878: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   881: iconst_1
    //   882: ireturn
    //   883: aload 17
    //   885: ifnull +8 -> 893
    //   888: aload 17
    //   890: invokevirtual 321	java/io/InputStream:close	()V
    //   893: ldc 205
    //   895: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   898: iconst_1
    //   899: ireturn
    //   900: astore_0
    //   901: aload 15
    //   903: astore 16
    //   905: ldc 25
    //   907: aload_0
    //   908: ldc_w 340
    //   911: aload_1
    //   912: invokestatic 222	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   915: invokevirtual 226	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   918: iconst_0
    //   919: anewarray 29	java/lang/Object
    //   922: invokestatic 65	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   925: aload 15
    //   927: ifnull +8 -> 935
    //   930: aload 15
    //   932: invokevirtual 321	java/io/InputStream:close	()V
    //   935: ldc 205
    //   937: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   940: iconst_0
    //   941: ireturn
    //   942: astore_0
    //   943: aload 16
    //   945: ifnull +8 -> 953
    //   948: aload 16
    //   950: invokevirtual 321	java/io/InputStream:close	()V
    //   953: ldc 205
    //   955: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   958: aload_0
    //   959: athrow
    //   960: iload 10
    //   962: ldc_w 341
    //   965: if_icmpge +45 -> 1010
    //   968: iload 11
    //   970: ifeq +40 -> 1010
    //   973: iload 7
    //   975: ifne +35 -> 1010
    //   978: ldc 25
    //   980: ldc_w 343
    //   983: invokestatic 272	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   986: aload_1
    //   987: aload_0
    //   988: invokestatic 280	com/tencent/mm/modelsfs/FileOp:C	(Ljava/lang/String;Ljava/lang/String;)J
    //   991: lconst_0
    //   992: lcmp
    //   993: iflt +10 -> 1003
    //   996: ldc 205
    //   998: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1001: iconst_1
    //   1002: ireturn
    //   1003: ldc 205
    //   1005: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1008: iconst_0
    //   1009: ireturn
    //   1010: aload 15
    //   1012: getfield 134	android/graphics/BitmapFactory$Options:outWidth	I
    //   1015: iload_2
    //   1016: if_icmpgt +12 -> 1028
    //   1019: aload 15
    //   1021: getfield 137	android/graphics/BitmapFactory$Options:outHeight	I
    //   1024: iload_3
    //   1025: if_icmple +21 -> 1046
    //   1028: aload 15
    //   1030: getfield 137	android/graphics/BitmapFactory$Options:outHeight	I
    //   1033: iload_2
    //   1034: if_icmpgt +301 -> 1335
    //   1037: aload 15
    //   1039: getfield 134	android/graphics/BitmapFactory$Options:outWidth	I
    //   1042: iload_3
    //   1043: if_icmpgt +292 -> 1335
    //   1046: ldc 25
    //   1048: ldc_w 345
    //   1051: iconst_3
    //   1052: anewarray 29	java/lang/Object
    //   1055: dup
    //   1056: iconst_0
    //   1057: iload 10
    //   1059: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1062: aastore
    //   1063: dup
    //   1064: iconst_1
    //   1065: aload 15
    //   1067: getfield 134	android/graphics/BitmapFactory$Options:outWidth	I
    //   1070: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1073: aastore
    //   1074: dup
    //   1075: iconst_2
    //   1076: aload 15
    //   1078: getfield 137	android/graphics/BitmapFactory$Options:outHeight	I
    //   1081: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1084: aastore
    //   1085: invokestatic 40	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1088: aload_1
    //   1089: invokestatic 209	com/tencent/mm/modelsfs/FileOp:ub	(Ljava/lang/String;)J
    //   1092: ldc2_w 346
    //   1095: lcmp
    //   1096: ifge +100 -> 1196
    //   1099: iload 11
    //   1101: ifeq +43 -> 1144
    //   1104: ldc 25
    //   1106: ldc_w 349
    //   1109: iconst_1
    //   1110: anewarray 29	java/lang/Object
    //   1113: dup
    //   1114: iconst_0
    //   1115: aload_1
    //   1116: aastore
    //   1117: invokestatic 40	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1120: aload_1
    //   1121: aload_0
    //   1122: invokestatic 280	com/tencent/mm/modelsfs/FileOp:C	(Ljava/lang/String;Ljava/lang/String;)J
    //   1125: lconst_0
    //   1126: lcmp
    //   1127: iflt +10 -> 1137
    //   1130: ldc 205
    //   1132: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1135: iconst_1
    //   1136: ireturn
    //   1137: ldc 205
    //   1139: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1142: iconst_0
    //   1143: ireturn
    //   1144: aload 15
    //   1146: getfield 134	android/graphics/BitmapFactory$Options:outWidth	I
    //   1149: sipush 150
    //   1152: if_icmpge +44 -> 1196
    //   1155: aload 15
    //   1157: getfield 137	android/graphics/BitmapFactory$Options:outHeight	I
    //   1160: sipush 150
    //   1163: if_icmpge +33 -> 1196
    //   1166: aload_1
    //   1167: aload 15
    //   1169: getfield 137	android/graphics/BitmapFactory$Options:outHeight	I
    //   1172: aload 15
    //   1174: getfield 134	android/graphics/BitmapFactory$Options:outWidth	I
    //   1177: getstatic 352	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   1180: iload 6
    //   1182: aload_0
    //   1183: invokestatic 354	com/tencent/mm/plugin/appbrand/t/c:a	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;)Z
    //   1186: istore 11
    //   1188: ldc 205
    //   1190: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1193: iload 11
    //   1195: ireturn
    //   1196: aload_1
    //   1197: aload 15
    //   1199: getfield 137	android/graphics/BitmapFactory$Options:outHeight	I
    //   1202: aload 15
    //   1204: getfield 134	android/graphics/BitmapFactory$Options:outWidth	I
    //   1207: getstatic 327	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   1210: iload 6
    //   1212: aload_0
    //   1213: invokestatic 354	com/tencent/mm/plugin/appbrand/t/c:a	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;)Z
    //   1216: istore 12
    //   1218: iload 11
    //   1220: ifeq +107 -> 1327
    //   1223: iload 7
    //   1225: ifne +102 -> 1327
    //   1228: aload_0
    //   1229: invokestatic 209	com/tencent/mm/modelsfs/FileOp:ub	(Ljava/lang/String;)J
    //   1232: lstore 13
    //   1234: ldc 25
    //   1236: ldc_w 332
    //   1239: iconst_3
    //   1240: anewarray 29	java/lang/Object
    //   1243: dup
    //   1244: iconst_0
    //   1245: iload 10
    //   1247: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1250: aastore
    //   1251: dup
    //   1252: iconst_1
    //   1253: lload 13
    //   1255: invokestatic 157	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1258: aastore
    //   1259: dup
    //   1260: iconst_2
    //   1261: bipush 10
    //   1263: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1266: aastore
    //   1267: invokestatic 40	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1270: iload 10
    //   1272: i2l
    //   1273: lload 13
    //   1275: lsub
    //   1276: ldc2_w 333
    //   1279: lmul
    //   1280: iload 10
    //   1282: bipush 10
    //   1284: imul
    //   1285: i2l
    //   1286: lcmp
    //   1287: ifge +32 -> 1319
    //   1290: aload_0
    //   1291: invokestatic 338	com/tencent/mm/modelsfs/FileOp:deleteFile	(Ljava/lang/String;)Z
    //   1294: pop
    //   1295: aload_1
    //   1296: aload_0
    //   1297: invokestatic 280	com/tencent/mm/modelsfs/FileOp:C	(Ljava/lang/String;Ljava/lang/String;)J
    //   1300: lconst_0
    //   1301: lcmp
    //   1302: iflt +10 -> 1312
    //   1305: ldc 205
    //   1307: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1310: iconst_1
    //   1311: ireturn
    //   1312: ldc 205
    //   1314: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1317: iconst_0
    //   1318: ireturn
    //   1319: ldc 205
    //   1321: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1324: iload 12
    //   1326: ireturn
    //   1327: ldc 205
    //   1329: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1332: iload 12
    //   1334: ireturn
    //   1335: aload 15
    //   1337: getfield 134	android/graphics/BitmapFactory$Options:outWidth	I
    //   1340: aload 15
    //   1342: getfield 137	android/graphics/BitmapFactory$Options:outHeight	I
    //   1345: if_icmplt +333 -> 1678
    //   1348: iload_2
    //   1349: istore 5
    //   1351: aload 15
    //   1353: getfield 134	android/graphics/BitmapFactory$Options:outWidth	I
    //   1356: aload 15
    //   1358: getfield 137	android/graphics/BitmapFactory$Options:outHeight	I
    //   1361: if_icmplt +323 -> 1684
    //   1364: aload 15
    //   1366: getfield 134	android/graphics/BitmapFactory$Options:outWidth	I
    //   1369: aload 15
    //   1371: getfield 137	android/graphics/BitmapFactory$Options:outHeight	I
    //   1374: iconst_2
    //   1375: imul
    //   1376: if_icmpge +18 -> 1394
    //   1379: aload 15
    //   1381: getfield 137	android/graphics/BitmapFactory$Options:outHeight	I
    //   1384: aload 15
    //   1386: getfield 134	android/graphics/BitmapFactory$Options:outWidth	I
    //   1389: iconst_2
    //   1390: imul
    //   1391: if_icmplt +366 -> 1757
    //   1394: ldc 25
    //   1396: new 167	java/lang/StringBuilder
    //   1399: dup
    //   1400: ldc_w 356
    //   1403: invokespecial 172	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1406: aload 15
    //   1408: getfield 134	android/graphics/BitmapFactory$Options:outWidth	I
    //   1411: invokevirtual 257	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1414: ldc_w 259
    //   1417: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1420: aload 15
    //   1422: getfield 137	android/graphics/BitmapFactory$Options:outHeight	I
    //   1425: invokevirtual 257	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1428: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1431: invokestatic 272	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1434: aload 15
    //   1436: getfield 137	android/graphics/BitmapFactory$Options:outHeight	I
    //   1439: ifgt +9 -> 1448
    //   1442: aload 15
    //   1444: iconst_1
    //   1445: putfield 137	android/graphics/BitmapFactory$Options:outHeight	I
    //   1448: aload 15
    //   1450: getfield 134	android/graphics/BitmapFactory$Options:outWidth	I
    //   1453: ifgt +9 -> 1462
    //   1456: aload 15
    //   1458: iconst_1
    //   1459: putfield 134	android/graphics/BitmapFactory$Options:outWidth	I
    //   1462: aload 15
    //   1464: getfield 134	android/graphics/BitmapFactory$Options:outWidth	I
    //   1467: aload 15
    //   1469: getfield 137	android/graphics/BitmapFactory$Options:outHeight	I
    //   1472: if_icmple +217 -> 1689
    //   1475: aload 15
    //   1477: getfield 134	android/graphics/BitmapFactory$Options:outWidth	I
    //   1480: aload 15
    //   1482: getfield 137	android/graphics/BitmapFactory$Options:outHeight	I
    //   1485: idiv
    //   1486: istore_2
    //   1487: iload_2
    //   1488: istore 5
    //   1490: iload_2
    //   1491: ifne +6 -> 1497
    //   1494: iconst_1
    //   1495: istore 5
    //   1497: ldc_w 273
    //   1500: iload 5
    //   1502: idiv
    //   1503: i2d
    //   1504: invokestatic 359	java/lang/Math:sqrt	(D)D
    //   1507: d2i
    //   1508: istore_2
    //   1509: aload 15
    //   1511: getfield 134	android/graphics/BitmapFactory$Options:outWidth	I
    //   1514: aload 15
    //   1516: getfield 137	android/graphics/BitmapFactory$Options:outHeight	I
    //   1519: if_icmple +185 -> 1704
    //   1522: iload_2
    //   1523: iload 5
    //   1525: imul
    //   1526: istore_3
    //   1527: ldc 25
    //   1529: new 167	java/lang/StringBuilder
    //   1532: dup
    //   1533: ldc_w 361
    //   1536: invokespecial 172	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1539: iload_3
    //   1540: invokevirtual 257	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1543: ldc_w 259
    //   1546: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1549: iload_2
    //   1550: invokevirtual 257	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1553: ldc_w 259
    //   1556: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1559: iload 5
    //   1561: invokevirtual 257	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1564: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1567: invokestatic 272	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1570: aload_1
    //   1571: iload_2
    //   1572: iload_3
    //   1573: getstatic 327	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   1576: iload 6
    //   1578: aload_0
    //   1579: invokestatic 354	com/tencent/mm/plugin/appbrand/t/c:a	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;)Z
    //   1582: istore 12
    //   1584: iload 11
    //   1586: ifeq +139 -> 1725
    //   1589: iload 7
    //   1591: ifne +134 -> 1725
    //   1594: aload_0
    //   1595: invokestatic 209	com/tencent/mm/modelsfs/FileOp:ub	(Ljava/lang/String;)J
    //   1598: lstore 13
    //   1600: ldc 25
    //   1602: ldc_w 332
    //   1605: iconst_3
    //   1606: anewarray 29	java/lang/Object
    //   1609: dup
    //   1610: iconst_0
    //   1611: iload 10
    //   1613: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1616: aastore
    //   1617: dup
    //   1618: iconst_1
    //   1619: lload 13
    //   1621: invokestatic 157	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1624: aastore
    //   1625: dup
    //   1626: iconst_2
    //   1627: bipush 10
    //   1629: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1632: aastore
    //   1633: invokestatic 40	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1636: iload 10
    //   1638: i2l
    //   1639: lload 13
    //   1641: lsub
    //   1642: ldc2_w 333
    //   1645: lmul
    //   1646: iload 10
    //   1648: bipush 10
    //   1650: imul
    //   1651: i2l
    //   1652: lcmp
    //   1653: ifge +72 -> 1725
    //   1656: aload_0
    //   1657: invokestatic 338	com/tencent/mm/modelsfs/FileOp:deleteFile	(Ljava/lang/String;)Z
    //   1660: pop
    //   1661: aload_1
    //   1662: aload_0
    //   1663: invokestatic 280	com/tencent/mm/modelsfs/FileOp:C	(Ljava/lang/String;Ljava/lang/String;)J
    //   1666: lconst_0
    //   1667: lcmp
    //   1668: iflt +50 -> 1718
    //   1671: ldc 205
    //   1673: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1676: iconst_1
    //   1677: ireturn
    //   1678: iload_3
    //   1679: istore 5
    //   1681: goto -330 -> 1351
    //   1684: iload_2
    //   1685: istore_3
    //   1686: goto -322 -> 1364
    //   1689: aload 15
    //   1691: getfield 137	android/graphics/BitmapFactory$Options:outHeight	I
    //   1694: aload 15
    //   1696: getfield 134	android/graphics/BitmapFactory$Options:outWidth	I
    //   1699: idiv
    //   1700: istore_2
    //   1701: goto -214 -> 1487
    //   1704: iload_2
    //   1705: iload 5
    //   1707: imul
    //   1708: istore 8
    //   1710: iload_2
    //   1711: istore_3
    //   1712: iload 8
    //   1714: istore_2
    //   1715: goto -188 -> 1527
    //   1718: ldc 205
    //   1720: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1723: iconst_0
    //   1724: ireturn
    //   1725: ldc 205
    //   1727: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1730: iload 12
    //   1732: ireturn
    //   1733: astore_0
    //   1734: goto -1055 -> 679
    //   1737: astore_0
    //   1738: goto -886 -> 852
    //   1741: astore_0
    //   1742: goto -866 -> 876
    //   1745: astore_0
    //   1746: goto -853 -> 893
    //   1749: astore_0
    //   1750: goto -815 -> 935
    //   1753: astore_1
    //   1754: goto -801 -> 953
    //   1757: iload_3
    //   1758: istore_2
    //   1759: iload 5
    //   1761: istore_3
    //   1762: goto -192 -> 1570
    //   1765: iload 6
    //   1767: istore 8
    //   1769: iload 7
    //   1771: istore 6
    //   1773: goto -1599 -> 174
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1776	0	paramString1	String
    //   0	1776	1	paramString2	String
    //   0	1776	2	paramInt1	int
    //   0	1776	3	paramInt2	int
    //   689	13	4	f	float
    //   142	1618	5	i	int
    //   131	1641	6	j	int
    //   7	1763	7	k	int
    //   168	1600	8	m	int
    //   181	18	9	n	int
    //   14	1637	10	i1	int
    //   121	1464	11	bool1	boolean
    //   128	1603	12	bool2	boolean
    //   738	902	13	l	long
    //   28	1667	15	localObject1	Object
    //   81	386	16	localObject2	Object
    //   489	15	16	localException	java.lang.Exception
    //   544	405	16	localObject3	Object
    //   557	332	17	localObject4	Object
    //   553	147	18	localObject5	Object
    //   538	107	19	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   192	198	489	java/lang/Exception
    //   211	222	489	java/lang/Exception
    //   226	248	489	java/lang/Exception
    //   549	555	900	java/io/IOException
    //   567	575	900	java/io/IOException
    //   587	595	900	java/io/IOException
    //   603	617	900	java/io/IOException
    //   625	633	900	java/io/IOException
    //   641	651	900	java/io/IOException
    //   659	664	900	java/io/IOException
    //   699	716	900	java/io/IOException
    //   734	740	900	java/io/IOException
    //   748	784	900	java/io/IOException
    //   812	817	900	java/io/IOException
    //   825	832	900	java/io/IOException
    //   549	555	942	finally
    //   567	575	942	finally
    //   587	595	942	finally
    //   603	617	942	finally
    //   625	633	942	finally
    //   641	651	942	finally
    //   659	664	942	finally
    //   699	716	942	finally
    //   734	740	942	finally
    //   748	784	942	finally
    //   812	817	942	finally
    //   825	832	942	finally
    //   905	925	942	finally
    //   674	679	1733	java/io/IOException
    //   847	852	1737	java/io/IOException
    //   871	876	1741	java/io/IOException
    //   888	893	1745	java/io/IOException
    //   930	935	1749	java/io/IOException
    //   948	953	1753	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t.c
 * JD-Core Version:    0.7.0.1
 */