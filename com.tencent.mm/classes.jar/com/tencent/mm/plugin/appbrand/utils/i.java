package com.tencent.mm.plugin.appbrand.utils;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.luggage.e.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.k;
import com.tencent.mm.plugin.performance.watchdogs.d;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import java.io.OutputStream;

public enum i
{
  @Deprecated
  public static boolean a(BitmapFactory.Options paramOptions)
  {
    AppMethodBeat.i(107812);
    boolean bool = a.a(paramOptions);
    AppMethodBeat.o(107812);
    return bool;
  }
  
  private static boolean a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Bitmap.CompressFormat paramCompressFormat, int paramInt5, String paramString2)
  {
    AppMethodBeat.i(107815);
    localObject4 = null;
    localObject3 = localObject4;
    try
    {
      Log.i("MicroMsg.AppBrandImgUtil", "createThumbNailUnScale, srcWidth: %s, srcHeight: %s, width: %s, height: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt4), Integer.valueOf(paramInt3) });
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
        Log.printErrStackTrace("MicroMsg.AppBrandImgUtil", paramString1, "create thumbnail from orig failed: %s", new Object[] { paramString2 });
        if (localObject3 != null) {}
        do
        {
          try
          {
            ((OutputStream)localObject3).close();
            AppMethodBeat.o(107815);
            return false;
            d1 = d2;
            break label171;
            localObject3 = localObject4;
            Log.i("MicroMsg.AppBrandImgUtil", "createThumbNailUnScale, sampleSize: %s", new Object[] { Integer.valueOf(((BitmapFactory.Options)localObject2).inSampleSize) });
            localObject3 = localObject4;
            localObject2 = b(paramString1, (BitmapFactory.Options)localObject2);
            break;
            localObject3 = localObject4;
            Log.i("MicroMsg.AppBrandImgUtil", "createThumbNailUnScale, bm.width: %s, bm.height: %s", new Object[] { Integer.valueOf(((Bitmap)localObject2).getWidth()), Integer.valueOf(((Bitmap)localObject2).getHeight()) });
            if (d2 < d3)
            {
              localObject3 = localObject4;
              paramInt2 = (int)Math.ceil(paramInt4 * 1.0D * paramInt2 / paramInt1);
              paramInt1 = paramInt4;
            }
            for (;;)
            {
              localObject3 = localObject4;
              paramInt4 = BackwardSupportUtil.ExifHelper.getExifOrientation(paramString1);
              if ((paramInt4 != 90) && (paramInt4 != 270)) {
                break label644;
              }
              localObject3 = localObject4;
              localObject2 = BitmapUtil.rotate((Bitmap)localObject2, paramInt4);
              paramString1 = (String)localObject2;
              if (paramInt4 == 180)
              {
                localObject3 = localObject4;
                paramString1 = BitmapUtil.rotate((Bitmap)localObject2, paramInt4);
              }
              localObject3 = localObject4;
              Bitmap localBitmap = Bitmap.createScaledBitmap(paramString1, paramInt2, paramInt1, true);
              if (localBitmap == null) {
                break;
              }
              localObject2 = localBitmap;
              if (paramString1 != localBitmap)
              {
                localObject3 = localObject4;
                k.bvO().N(paramString1);
                localObject2 = localBitmap;
              }
              localObject3 = localObject4;
              Log.i("MicroMsg.AppBrandImgUtil", "createThumbNailUnScalebyUpload, degree %d, bm.width: %s, bm.height: %s", new Object[] { Integer.valueOf(paramInt4), Integer.valueOf(((Bitmap)localObject2).getWidth()), Integer.valueOf(((Bitmap)localObject2).getHeight()) });
              localObject3 = localObject4;
              paramString1 = y.ev(paramString2, false);
              localObject3 = paramString1;
              BitmapUtil.saveBitmapToStream((Bitmap)localObject2, paramInt5, paramCompressFormat, paramString1, false);
              localObject3 = paramString1;
              k.bvO().N((Bitmap)localObject2);
              localObject3 = paramString1;
              paramString1.close();
              AppMethodBeat.o(107815);
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
              paramInt1 = paramInt3;
            }
          }
        } while (d2 >= d3);
        double d1 = d3;
      }
    }
    localObject3 = localObject4;
    Log.i("MicroMsg.AppBrandImgUtil", "createThumbNailUnScale, result bm: %s", new Object[] { localObject2 });
    if (localObject2 == null)
    {
      AppMethodBeat.o(107815);
      return false;
      localObject3 = localObject4;
      ((BitmapFactory.Options)localObject2).inSampleSize = 1;
      if (paramInt2 > paramInt3) {
        break label653;
      }
      if (paramInt1 > paramInt4)
      {
        break label653;
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
  
  private static Bitmap b(String paramString, BitmapFactory.Options paramOptions)
  {
    AppMethodBeat.i(107814);
    long l = System.currentTimeMillis();
    try
    {
      paramString = k.bvO().a(paramString, paramOptions);
      Log.d("MicroMsg.AppBrandImgUtil", "decodeWithRotateByExif used %dms bitmap: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), paramString });
      AppMethodBeat.o(107814);
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      Log.e("MicroMsg.AppBrandImgUtil", "%s", new Object[] { d.gzs().af(true, 0) });
      Log.e("MicroMsg.AppBrandImgUtil", "OutOfMemoryError e " + paramString.getMessage());
      AppMethodBeat.o(107814);
    }
    return null;
  }
  
  private static boolean createThumbNail(String paramString1, int paramInt1, int paramInt2, Bitmap.CompressFormat paramCompressFormat, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(107813);
    BitmapFactory.Options localOptions = BitmapUtil.getImageOptions(paramString1);
    if ((localOptions == null) || (localOptions.outWidth <= 0) || (localOptions.outHeight <= 0))
    {
      AppMethodBeat.o(107813);
      return false;
    }
    boolean bool = a(paramString1, localOptions.outWidth, localOptions.outHeight, paramInt1, paramInt2, paramCompressFormat, paramInt3, paramString2);
    AppMethodBeat.o(107813);
    return bool;
  }
  
  public static boolean fs(String paramString1, String paramString2)
  {
    AppMethodBeat.i(107816);
    boolean bool = g(paramString1, paramString2, -1, -1);
    AppMethodBeat.o(107816);
    return bool;
  }
  
  /* Error */
  public static boolean g(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: ldc 217
    //   2: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: bipush 70
    //   7: istore 7
    //   9: aload_1
    //   10: invokestatic 221	com/tencent/mm/vfs/y:bEl	(Ljava/lang/String;)J
    //   13: l2i
    //   14: istore 10
    //   16: iload_2
    //   17: ifle +40 -> 57
    //   20: iload_3
    //   21: ifle +43 -> 64
    //   24: aload_1
    //   25: invokestatic 199	com/tencent/mm/sdk/platformtools/BitmapUtil:getImageOptions	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   28: astore 15
    //   30: aload 15
    //   32: ifnonnull +39 -> 71
    //   35: ldc 36
    //   37: ldc 223
    //   39: iconst_1
    //   40: anewarray 40	java/lang/Object
    //   43: dup
    //   44: iconst_0
    //   45: aload_1
    //   46: aastore
    //   47: invokestatic 51	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   50: ldc 217
    //   52: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: iconst_0
    //   56: ireturn
    //   57: sipush 960
    //   60: istore_2
    //   61: goto -41 -> 20
    //   64: sipush 640
    //   67: istore_3
    //   68: goto -44 -> 24
    //   71: aload 15
    //   73: ifnull +413 -> 486
    //   76: aload 15
    //   78: getfield 227	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   81: astore 16
    //   83: ldc 36
    //   85: ldc 229
    //   87: aload 16
    //   89: invokestatic 234	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   92: invokevirtual 238	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   95: invokestatic 240	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: aload 16
    //   100: ifnull +386 -> 486
    //   103: aload 16
    //   105: invokevirtual 243	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   108: astore 16
    //   110: aload 16
    //   112: ldc 245
    //   114: invokevirtual 248	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   117: iflt +335 -> 452
    //   120: iconst_1
    //   121: istore 11
    //   123: aload 15
    //   125: invokestatic 26	com/tencent/luggage/e/a/a:a	(Landroid/graphics/BitmapFactory$Options;)Z
    //   128: istore 12
    //   130: iconst_m1
    //   131: istore 6
    //   133: iload 12
    //   135: ifeq +1579 -> 1714
    //   138: aload_1
    //   139: invokestatic 253	com/tencent/mm/sdk/platformtools/MMNativeJpeg:queryQuality	(Ljava/lang/String;)I
    //   142: istore 5
    //   144: iload 5
    //   146: istore 6
    //   148: iload 5
    //   150: bipush 70
    //   152: if_icmpge +1562 -> 1714
    //   155: iload 5
    //   157: istore 6
    //   159: iload 5
    //   161: bipush 25
    //   163: if_icmple +1551 -> 1714
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
    //   185: ifeq +335 -> 520
    //   188: iload 7
    //   190: istore 5
    //   192: aload_1
    //   193: invokestatic 259	com/tencent/mm/compatible/util/Exif:fromFile	(Ljava/lang/String;)Lcom/tencent/mm/compatible/util/Exif;
    //   196: astore 16
    //   198: iload 9
    //   200: istore 5
    //   202: aload 16
    //   204: ifnull +49 -> 253
    //   207: iload 7
    //   209: istore 5
    //   211: aload 16
    //   213: invokevirtual 262	com/tencent/mm/compatible/util/Exif:getOrientationInDegree	()I
    //   216: sipush 360
    //   219: irem
    //   220: istore 7
    //   222: iload 7
    //   224: istore 5
    //   226: ldc 36
    //   228: ldc_w 264
    //   231: iconst_1
    //   232: anewarray 40	java/lang/Object
    //   235: dup
    //   236: iconst_0
    //   237: aload 16
    //   239: invokevirtual 262	com/tencent/mm/compatible/util/Exif:getOrientationInDegree	()I
    //   242: invokestatic 46	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   245: aastore
    //   246: invokestatic 51	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   249: iload 7
    //   251: istore 5
    //   253: iload 5
    //   255: istore 7
    //   257: ldc 36
    //   259: new 173	java/lang/StringBuilder
    //   262: dup
    //   263: ldc_w 266
    //   266: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   269: aload 15
    //   271: getfield 202	android/graphics/BitmapFactory$Options:outWidth	I
    //   274: invokevirtual 269	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   277: ldc_w 271
    //   280: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: aload 15
    //   285: getfield 205	android/graphics/BitmapFactory$Options:outHeight	I
    //   288: invokevirtual 269	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   291: ldc_w 271
    //   294: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: iload 11
    //   299: invokevirtual 274	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   302: ldc_w 276
    //   305: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: iload 8
    //   310: invokevirtual 269	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   313: ldc_w 278
    //   316: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: iload 7
    //   321: invokevirtual 269	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   324: ldc_w 280
    //   327: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: iload 10
    //   332: invokevirtual 269	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   335: ldc_w 282
    //   338: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: iload_2
    //   342: invokevirtual 269	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   345: ldc_w 271
    //   348: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: iload_3
    //   352: invokevirtual 269	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   355: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: invokestatic 284	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   361: aload 15
    //   363: getfield 202	android/graphics/BitmapFactory$Options:outWidth	I
    //   366: aload 15
    //   368: getfield 205	android/graphics/BitmapFactory$Options:outHeight	I
    //   371: iconst_2
    //   372: imul
    //   373: if_icmpge +18 -> 391
    //   376: aload 15
    //   378: getfield 205	android/graphics/BitmapFactory$Options:outHeight	I
    //   381: aload 15
    //   383: getfield 202	android/graphics/BitmapFactory$Options:outWidth	I
    //   386: iconst_2
    //   387: imul
    //   388: if_icmplt +517 -> 905
    //   391: aload 15
    //   393: getfield 202	android/graphics/BitmapFactory$Options:outWidth	I
    //   396: aload 15
    //   398: getfield 205	android/graphics/BitmapFactory$Options:outHeight	I
    //   401: imul
    //   402: ldc_w 285
    //   405: if_icmpgt +500 -> 905
    //   408: iload 10
    //   410: ldc_w 286
    //   413: if_icmpge +121 -> 534
    //   416: iload 11
    //   418: ifeq +116 -> 534
    //   421: iload 7
    //   423: ifne +111 -> 534
    //   426: ldc 36
    //   428: ldc_w 288
    //   431: invokestatic 284	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   434: aload_1
    //   435: aload_0
    //   436: iconst_0
    //   437: invokestatic 292	com/tencent/mm/vfs/y:O	(Ljava/lang/String;Ljava/lang/String;Z)J
    //   440: lconst_0
    //   441: lcmp
    //   442: iflt +85 -> 527
    //   445: ldc 217
    //   447: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   450: iconst_1
    //   451: ireturn
    //   452: aload 16
    //   454: ldc_w 294
    //   457: invokevirtual 248	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   460: iflt +9 -> 469
    //   463: iconst_1
    //   464: istore 11
    //   466: goto -343 -> 123
    //   469: aload 16
    //   471: ldc_w 296
    //   474: invokevirtual 248	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   477: iflt +9 -> 486
    //   480: iconst_1
    //   481: istore 11
    //   483: goto -360 -> 123
    //   486: iconst_0
    //   487: istore 11
    //   489: goto -366 -> 123
    //   492: astore 16
    //   494: ldc 36
    //   496: new 173	java/lang/StringBuilder
    //   499: dup
    //   500: ldc_w 298
    //   503: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   506: aload 16
    //   508: invokevirtual 299	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   511: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   517: invokestatic 192	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   520: iload 5
    //   522: istore 7
    //   524: goto -267 -> 257
    //   527: ldc 217
    //   529: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   532: iconst_0
    //   533: ireturn
    //   534: new 53	android/graphics/BitmapFactory$Options
    //   537: dup
    //   538: invokespecial 56	android/graphics/BitmapFactory$Options:<init>	()V
    //   541: astore 18
    //   543: aload 18
    //   545: invokestatic 303	com/tencent/mm/sdk/platformtools/BitmapUtil:bindlowMemeryOption	(Landroid/graphics/BitmapFactory$Options;)V
    //   548: aconst_null
    //   549: astore 16
    //   551: aconst_null
    //   552: astore 15
    //   554: aload_1
    //   555: invokestatic 307	com/tencent/mm/vfs/y:Lh	(Ljava/lang/String;)Ljava/io/InputStream;
    //   558: astore 17
    //   560: aload 17
    //   562: astore 15
    //   564: aload 17
    //   566: astore 16
    //   568: aload 17
    //   570: ldc_w 308
    //   573: invokevirtual 313	java/io/InputStream:mark	(I)V
    //   576: aload 17
    //   578: astore 15
    //   580: aload 17
    //   582: astore 16
    //   584: aload 17
    //   586: aconst_null
    //   587: aload 18
    //   589: invokestatic 319	com/tencent/mm/graphics/MMBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   592: astore 18
    //   594: aload 17
    //   596: astore 15
    //   598: aload 17
    //   600: astore 16
    //   602: aload 17
    //   604: invokevirtual 322	java/io/InputStream:reset	()V
    //   607: aload 18
    //   609: ifnonnull +20 -> 629
    //   612: aload 17
    //   614: ifnull +8 -> 622
    //   617: aload 17
    //   619: invokevirtual 323	java/io/InputStream:close	()V
    //   622: ldc 217
    //   624: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   627: iconst_0
    //   628: ireturn
    //   629: iload 7
    //   631: i2f
    //   632: fstore 4
    //   634: aload 17
    //   636: astore 15
    //   638: aload 17
    //   640: astore 16
    //   642: aload 18
    //   644: fload 4
    //   646: invokestatic 109	com/tencent/mm/sdk/platformtools/BitmapUtil:rotate	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   649: iload 6
    //   651: getstatic 329	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   654: aload_0
    //   655: iconst_1
    //   656: invokestatic 333	com/tencent/mm/sdk/platformtools/BitmapUtil:saveBitmapToImage	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   659: pop
    //   660: iload 11
    //   662: ifeq +166 -> 828
    //   665: iload 7
    //   667: ifne +161 -> 828
    //   670: aload 17
    //   672: astore 15
    //   674: aload 17
    //   676: astore 16
    //   678: aload_0
    //   679: invokestatic 221	com/tencent/mm/vfs/y:bEl	(Ljava/lang/String;)J
    //   682: lstore 13
    //   684: aload 17
    //   686: astore 15
    //   688: aload 17
    //   690: astore 16
    //   692: ldc 36
    //   694: ldc_w 335
    //   697: iconst_3
    //   698: anewarray 40	java/lang/Object
    //   701: dup
    //   702: iconst_0
    //   703: iload 10
    //   705: invokestatic 46	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   708: aastore
    //   709: dup
    //   710: iconst_1
    //   711: lload 13
    //   713: invokestatic 153	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   716: aastore
    //   717: dup
    //   718: iconst_2
    //   719: bipush 10
    //   721: invokestatic 46	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   724: aastore
    //   725: invokestatic 51	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   728: iload 10
    //   730: i2l
    //   731: lload 13
    //   733: lsub
    //   734: ldc2_w 336
    //   737: lmul
    //   738: iload 10
    //   740: bipush 10
    //   742: imul
    //   743: i2l
    //   744: lcmp
    //   745: ifge +66 -> 811
    //   748: aload 17
    //   750: astore 15
    //   752: aload 17
    //   754: astore 16
    //   756: aload_0
    //   757: invokestatic 341	com/tencent/mm/vfs/y:deleteFile	(Ljava/lang/String;)Z
    //   760: pop
    //   761: aload 17
    //   763: astore 15
    //   765: aload 17
    //   767: astore 16
    //   769: aload_1
    //   770: aload_0
    //   771: iconst_0
    //   772: invokestatic 292	com/tencent/mm/vfs/y:O	(Ljava/lang/String;Ljava/lang/String;Z)J
    //   775: lstore 13
    //   777: lload 13
    //   779: lconst_0
    //   780: lcmp
    //   781: iflt +24 -> 805
    //   784: iconst_1
    //   785: istore 11
    //   787: aload 17
    //   789: ifnull +8 -> 797
    //   792: aload 17
    //   794: invokevirtual 323	java/io/InputStream:close	()V
    //   797: ldc 217
    //   799: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   802: iload 11
    //   804: ireturn
    //   805: iconst_0
    //   806: istore 11
    //   808: goto -21 -> 787
    //   811: aload 17
    //   813: ifnull +8 -> 821
    //   816: aload 17
    //   818: invokevirtual 323	java/io/InputStream:close	()V
    //   821: ldc 217
    //   823: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   826: iconst_1
    //   827: ireturn
    //   828: aload 17
    //   830: ifnull +8 -> 838
    //   833: aload 17
    //   835: invokevirtual 323	java/io/InputStream:close	()V
    //   838: ldc 217
    //   840: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   843: iconst_1
    //   844: ireturn
    //   845: astore_0
    //   846: aload 15
    //   848: astore 16
    //   850: ldc 36
    //   852: aload_0
    //   853: ldc_w 343
    //   856: aload_1
    //   857: invokestatic 234	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   860: invokevirtual 238	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   863: iconst_0
    //   864: anewarray 40	java/lang/Object
    //   867: invokestatic 73	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   870: aload 15
    //   872: ifnull +8 -> 880
    //   875: aload 15
    //   877: invokevirtual 323	java/io/InputStream:close	()V
    //   880: ldc 217
    //   882: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   885: iconst_0
    //   886: ireturn
    //   887: astore_0
    //   888: aload 16
    //   890: ifnull +8 -> 898
    //   893: aload 16
    //   895: invokevirtual 323	java/io/InputStream:close	()V
    //   898: ldc 217
    //   900: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   903: aload_0
    //   904: athrow
    //   905: iload 10
    //   907: ldc_w 344
    //   910: if_icmpge +46 -> 956
    //   913: iload 11
    //   915: ifeq +41 -> 956
    //   918: iload 7
    //   920: ifne +36 -> 956
    //   923: ldc 36
    //   925: ldc_w 346
    //   928: invokestatic 284	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   931: aload_1
    //   932: aload_0
    //   933: iconst_0
    //   934: invokestatic 292	com/tencent/mm/vfs/y:O	(Ljava/lang/String;Ljava/lang/String;Z)J
    //   937: lconst_0
    //   938: lcmp
    //   939: iflt +10 -> 949
    //   942: ldc 217
    //   944: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   947: iconst_1
    //   948: ireturn
    //   949: ldc 217
    //   951: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   954: iconst_0
    //   955: ireturn
    //   956: aload 15
    //   958: getfield 202	android/graphics/BitmapFactory$Options:outWidth	I
    //   961: iload_2
    //   962: if_icmpgt +12 -> 974
    //   965: aload 15
    //   967: getfield 205	android/graphics/BitmapFactory$Options:outHeight	I
    //   970: iload_3
    //   971: if_icmple +21 -> 992
    //   974: aload 15
    //   976: getfield 205	android/graphics/BitmapFactory$Options:outHeight	I
    //   979: iload_2
    //   980: if_icmpgt +303 -> 1283
    //   983: aload 15
    //   985: getfield 202	android/graphics/BitmapFactory$Options:outWidth	I
    //   988: iload_3
    //   989: if_icmpgt +294 -> 1283
    //   992: ldc 36
    //   994: ldc_w 348
    //   997: iconst_3
    //   998: anewarray 40	java/lang/Object
    //   1001: dup
    //   1002: iconst_0
    //   1003: iload 10
    //   1005: invokestatic 46	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1008: aastore
    //   1009: dup
    //   1010: iconst_1
    //   1011: aload 15
    //   1013: getfield 202	android/graphics/BitmapFactory$Options:outWidth	I
    //   1016: invokestatic 46	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1019: aastore
    //   1020: dup
    //   1021: iconst_2
    //   1022: aload 15
    //   1024: getfield 205	android/graphics/BitmapFactory$Options:outHeight	I
    //   1027: invokestatic 46	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1030: aastore
    //   1031: invokestatic 51	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1034: aload_1
    //   1035: invokestatic 221	com/tencent/mm/vfs/y:bEl	(Ljava/lang/String;)J
    //   1038: ldc2_w 349
    //   1041: lcmp
    //   1042: ifge +101 -> 1143
    //   1045: iload 11
    //   1047: ifeq +44 -> 1091
    //   1050: ldc 36
    //   1052: ldc_w 352
    //   1055: iconst_1
    //   1056: anewarray 40	java/lang/Object
    //   1059: dup
    //   1060: iconst_0
    //   1061: aload_1
    //   1062: aastore
    //   1063: invokestatic 51	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1066: aload_1
    //   1067: aload_0
    //   1068: iconst_0
    //   1069: invokestatic 292	com/tencent/mm/vfs/y:O	(Ljava/lang/String;Ljava/lang/String;Z)J
    //   1072: lconst_0
    //   1073: lcmp
    //   1074: iflt +10 -> 1084
    //   1077: ldc 217
    //   1079: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1082: iconst_1
    //   1083: ireturn
    //   1084: ldc 217
    //   1086: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1089: iconst_0
    //   1090: ireturn
    //   1091: aload 15
    //   1093: getfield 202	android/graphics/BitmapFactory$Options:outWidth	I
    //   1096: sipush 150
    //   1099: if_icmpge +44 -> 1143
    //   1102: aload 15
    //   1104: getfield 205	android/graphics/BitmapFactory$Options:outHeight	I
    //   1107: sipush 150
    //   1110: if_icmpge +33 -> 1143
    //   1113: aload_1
    //   1114: aload 15
    //   1116: getfield 205	android/graphics/BitmapFactory$Options:outHeight	I
    //   1119: aload 15
    //   1121: getfield 202	android/graphics/BitmapFactory$Options:outWidth	I
    //   1124: getstatic 355	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   1127: iload 6
    //   1129: aload_0
    //   1130: invokestatic 357	com/tencent/mm/plugin/appbrand/utils/i:createThumbNail	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;)Z
    //   1133: istore 11
    //   1135: ldc 217
    //   1137: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1140: iload 11
    //   1142: ireturn
    //   1143: aload_1
    //   1144: aload 15
    //   1146: getfield 205	android/graphics/BitmapFactory$Options:outHeight	I
    //   1149: aload 15
    //   1151: getfield 202	android/graphics/BitmapFactory$Options:outWidth	I
    //   1154: getstatic 329	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   1157: iload 6
    //   1159: aload_0
    //   1160: invokestatic 357	com/tencent/mm/plugin/appbrand/utils/i:createThumbNail	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;)Z
    //   1163: istore 12
    //   1165: iload 11
    //   1167: ifeq +108 -> 1275
    //   1170: iload 7
    //   1172: ifne +103 -> 1275
    //   1175: aload_0
    //   1176: invokestatic 221	com/tencent/mm/vfs/y:bEl	(Ljava/lang/String;)J
    //   1179: lstore 13
    //   1181: ldc 36
    //   1183: ldc_w 335
    //   1186: iconst_3
    //   1187: anewarray 40	java/lang/Object
    //   1190: dup
    //   1191: iconst_0
    //   1192: iload 10
    //   1194: invokestatic 46	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1197: aastore
    //   1198: dup
    //   1199: iconst_1
    //   1200: lload 13
    //   1202: invokestatic 153	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1205: aastore
    //   1206: dup
    //   1207: iconst_2
    //   1208: bipush 10
    //   1210: invokestatic 46	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1213: aastore
    //   1214: invokestatic 51	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1217: iload 10
    //   1219: i2l
    //   1220: lload 13
    //   1222: lsub
    //   1223: ldc2_w 336
    //   1226: lmul
    //   1227: iload 10
    //   1229: bipush 10
    //   1231: imul
    //   1232: i2l
    //   1233: lcmp
    //   1234: ifge +33 -> 1267
    //   1237: aload_0
    //   1238: invokestatic 341	com/tencent/mm/vfs/y:deleteFile	(Ljava/lang/String;)Z
    //   1241: pop
    //   1242: aload_1
    //   1243: aload_0
    //   1244: iconst_0
    //   1245: invokestatic 292	com/tencent/mm/vfs/y:O	(Ljava/lang/String;Ljava/lang/String;Z)J
    //   1248: lconst_0
    //   1249: lcmp
    //   1250: iflt +10 -> 1260
    //   1253: ldc 217
    //   1255: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1258: iconst_1
    //   1259: ireturn
    //   1260: ldc 217
    //   1262: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1265: iconst_0
    //   1266: ireturn
    //   1267: ldc 217
    //   1269: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1272: iload 12
    //   1274: ireturn
    //   1275: ldc 217
    //   1277: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1280: iload 12
    //   1282: ireturn
    //   1283: aload 15
    //   1285: getfield 202	android/graphics/BitmapFactory$Options:outWidth	I
    //   1288: aload 15
    //   1290: getfield 205	android/graphics/BitmapFactory$Options:outHeight	I
    //   1293: if_icmplt +334 -> 1627
    //   1296: iload_2
    //   1297: istore 5
    //   1299: aload 15
    //   1301: getfield 202	android/graphics/BitmapFactory$Options:outWidth	I
    //   1304: aload 15
    //   1306: getfield 205	android/graphics/BitmapFactory$Options:outHeight	I
    //   1309: if_icmplt +324 -> 1633
    //   1312: aload 15
    //   1314: getfield 202	android/graphics/BitmapFactory$Options:outWidth	I
    //   1317: aload 15
    //   1319: getfield 205	android/graphics/BitmapFactory$Options:outHeight	I
    //   1322: iconst_2
    //   1323: imul
    //   1324: if_icmpge +18 -> 1342
    //   1327: aload 15
    //   1329: getfield 205	android/graphics/BitmapFactory$Options:outHeight	I
    //   1332: aload 15
    //   1334: getfield 202	android/graphics/BitmapFactory$Options:outWidth	I
    //   1337: iconst_2
    //   1338: imul
    //   1339: if_icmplt +367 -> 1706
    //   1342: ldc 36
    //   1344: new 173	java/lang/StringBuilder
    //   1347: dup
    //   1348: ldc_w 359
    //   1351: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1354: aload 15
    //   1356: getfield 202	android/graphics/BitmapFactory$Options:outWidth	I
    //   1359: invokevirtual 269	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1362: ldc_w 271
    //   1365: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1368: aload 15
    //   1370: getfield 205	android/graphics/BitmapFactory$Options:outHeight	I
    //   1373: invokevirtual 269	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1376: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1379: invokestatic 284	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1382: aload 15
    //   1384: getfield 205	android/graphics/BitmapFactory$Options:outHeight	I
    //   1387: ifgt +9 -> 1396
    //   1390: aload 15
    //   1392: iconst_1
    //   1393: putfield 205	android/graphics/BitmapFactory$Options:outHeight	I
    //   1396: aload 15
    //   1398: getfield 202	android/graphics/BitmapFactory$Options:outWidth	I
    //   1401: ifgt +9 -> 1410
    //   1404: aload 15
    //   1406: iconst_1
    //   1407: putfield 202	android/graphics/BitmapFactory$Options:outWidth	I
    //   1410: aload 15
    //   1412: getfield 202	android/graphics/BitmapFactory$Options:outWidth	I
    //   1415: aload 15
    //   1417: getfield 205	android/graphics/BitmapFactory$Options:outHeight	I
    //   1420: if_icmple +218 -> 1638
    //   1423: aload 15
    //   1425: getfield 202	android/graphics/BitmapFactory$Options:outWidth	I
    //   1428: aload 15
    //   1430: getfield 205	android/graphics/BitmapFactory$Options:outHeight	I
    //   1433: idiv
    //   1434: istore_2
    //   1435: iload_2
    //   1436: istore 5
    //   1438: iload_2
    //   1439: ifne +6 -> 1445
    //   1442: iconst_1
    //   1443: istore 5
    //   1445: ldc_w 285
    //   1448: iload 5
    //   1450: idiv
    //   1451: i2d
    //   1452: invokestatic 362	java/lang/Math:sqrt	(D)D
    //   1455: d2i
    //   1456: istore_2
    //   1457: aload 15
    //   1459: getfield 202	android/graphics/BitmapFactory$Options:outWidth	I
    //   1462: aload 15
    //   1464: getfield 205	android/graphics/BitmapFactory$Options:outHeight	I
    //   1467: if_icmple +186 -> 1653
    //   1470: iload_2
    //   1471: iload 5
    //   1473: imul
    //   1474: istore_3
    //   1475: ldc 36
    //   1477: new 173	java/lang/StringBuilder
    //   1480: dup
    //   1481: ldc_w 364
    //   1484: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1487: iload_3
    //   1488: invokevirtual 269	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1491: ldc_w 271
    //   1494: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1497: iload_2
    //   1498: invokevirtual 269	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1501: ldc_w 271
    //   1504: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1507: iload 5
    //   1509: invokevirtual 269	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1512: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1515: invokestatic 284	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1518: aload_1
    //   1519: iload_2
    //   1520: iload_3
    //   1521: getstatic 329	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   1524: iload 6
    //   1526: aload_0
    //   1527: invokestatic 357	com/tencent/mm/plugin/appbrand/utils/i:createThumbNail	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;)Z
    //   1530: istore 12
    //   1532: iload 11
    //   1534: ifeq +140 -> 1674
    //   1537: iload 7
    //   1539: ifne +135 -> 1674
    //   1542: aload_0
    //   1543: invokestatic 221	com/tencent/mm/vfs/y:bEl	(Ljava/lang/String;)J
    //   1546: lstore 13
    //   1548: ldc 36
    //   1550: ldc_w 335
    //   1553: iconst_3
    //   1554: anewarray 40	java/lang/Object
    //   1557: dup
    //   1558: iconst_0
    //   1559: iload 10
    //   1561: invokestatic 46	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1564: aastore
    //   1565: dup
    //   1566: iconst_1
    //   1567: lload 13
    //   1569: invokestatic 153	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1572: aastore
    //   1573: dup
    //   1574: iconst_2
    //   1575: bipush 10
    //   1577: invokestatic 46	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1580: aastore
    //   1581: invokestatic 51	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1584: iload 10
    //   1586: i2l
    //   1587: lload 13
    //   1589: lsub
    //   1590: ldc2_w 336
    //   1593: lmul
    //   1594: iload 10
    //   1596: bipush 10
    //   1598: imul
    //   1599: i2l
    //   1600: lcmp
    //   1601: ifge +73 -> 1674
    //   1604: aload_0
    //   1605: invokestatic 341	com/tencent/mm/vfs/y:deleteFile	(Ljava/lang/String;)Z
    //   1608: pop
    //   1609: aload_1
    //   1610: aload_0
    //   1611: iconst_0
    //   1612: invokestatic 292	com/tencent/mm/vfs/y:O	(Ljava/lang/String;Ljava/lang/String;Z)J
    //   1615: lconst_0
    //   1616: lcmp
    //   1617: iflt +50 -> 1667
    //   1620: ldc 217
    //   1622: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1625: iconst_1
    //   1626: ireturn
    //   1627: iload_3
    //   1628: istore 5
    //   1630: goto -331 -> 1299
    //   1633: iload_2
    //   1634: istore_3
    //   1635: goto -323 -> 1312
    //   1638: aload 15
    //   1640: getfield 205	android/graphics/BitmapFactory$Options:outHeight	I
    //   1643: aload 15
    //   1645: getfield 202	android/graphics/BitmapFactory$Options:outWidth	I
    //   1648: idiv
    //   1649: istore_2
    //   1650: goto -215 -> 1435
    //   1653: iload_2
    //   1654: iload 5
    //   1656: imul
    //   1657: istore 8
    //   1659: iload_2
    //   1660: istore_3
    //   1661: iload 8
    //   1663: istore_2
    //   1664: goto -189 -> 1475
    //   1667: ldc 217
    //   1669: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1672: iconst_0
    //   1673: ireturn
    //   1674: ldc 217
    //   1676: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1679: iload 12
    //   1681: ireturn
    //   1682: astore_0
    //   1683: goto -1061 -> 622
    //   1686: astore_0
    //   1687: goto -890 -> 797
    //   1690: astore_0
    //   1691: goto -870 -> 821
    //   1694: astore_0
    //   1695: goto -857 -> 838
    //   1698: astore_0
    //   1699: goto -819 -> 880
    //   1702: astore_1
    //   1703: goto -805 -> 898
    //   1706: iload_3
    //   1707: istore_2
    //   1708: iload 5
    //   1710: istore_3
    //   1711: goto -193 -> 1518
    //   1714: iload 6
    //   1716: istore 8
    //   1718: iload 7
    //   1720: istore 6
    //   1722: goto -1548 -> 174
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1725	0	paramString1	String
    //   0	1725	1	paramString2	String
    //   0	1725	2	paramInt1	int
    //   0	1725	3	paramInt2	int
    //   632	13	4	f	float
    //   142	1567	5	i	int
    //   131	1590	6	j	int
    //   7	1712	7	k	int
    //   168	1549	8	m	int
    //   181	18	9	n	int
    //   14	1585	10	i1	int
    //   121	1412	11	bool1	boolean
    //   128	1552	12	bool2	boolean
    //   682	906	13	l	long
    //   28	1616	15	localObject1	Object
    //   81	389	16	localObject2	Object
    //   492	15	16	localException	java.lang.Exception
    //   549	345	16	localObject3	Object
    //   558	276	17	localInputStream	java.io.InputStream
    //   541	102	18	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   192	198	492	java/lang/Exception
    //   211	222	492	java/lang/Exception
    //   226	249	492	java/lang/Exception
    //   554	560	845	java/io/IOException
    //   568	576	845	java/io/IOException
    //   584	594	845	java/io/IOException
    //   602	607	845	java/io/IOException
    //   642	660	845	java/io/IOException
    //   678	684	845	java/io/IOException
    //   692	728	845	java/io/IOException
    //   756	761	845	java/io/IOException
    //   769	777	845	java/io/IOException
    //   554	560	887	finally
    //   568	576	887	finally
    //   584	594	887	finally
    //   602	607	887	finally
    //   642	660	887	finally
    //   678	684	887	finally
    //   692	728	887	finally
    //   756	761	887	finally
    //   769	777	887	finally
    //   850	870	887	finally
    //   617	622	1682	java/io/IOException
    //   792	797	1686	java/io/IOException
    //   816	821	1690	java/io/IOException
    //   833	838	1694	java/io/IOException
    //   875	880	1698	java/io/IOException
    //   893	898	1702	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.i
 * JD-Core Version:    0.7.0.1
 */