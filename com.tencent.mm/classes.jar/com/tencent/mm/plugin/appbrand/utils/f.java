package com.tencent.mm.plugin.appbrand.utils;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.luggage.e.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.l;
import com.tencent.mm.plugin.performance.watchdogs.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import java.io.IOException;
import java.io.OutputStream;

public enum f
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
                break label643;
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
                l.baT().s(paramString1);
                localObject2 = localBitmap;
              }
              localObject3 = localObject4;
              Log.i("MicroMsg.AppBrandImgUtil", "createThumbNailUnScalebyUpload, degree %d, bm.width: %s, bm.height: %s", new Object[] { Integer.valueOf(paramInt4), Integer.valueOf(((Bitmap)localObject2).getWidth()), Integer.valueOf(((Bitmap)localObject2).getHeight()) });
              localObject3 = localObject4;
              paramString1 = u.Te(paramString2);
              localObject3 = paramString1;
              BitmapUtil.saveBitmapToStream((Bitmap)localObject2, paramInt5, paramCompressFormat, paramString1, false);
              localObject3 = paramString1;
              l.baT().s((Bitmap)localObject2);
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
        break label652;
      }
      if (paramInt1 > paramInt4)
      {
        break label652;
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
      paramString = l.baT().a(paramString, paramOptions);
      Log.d("MicroMsg.AppBrandImgUtil", "decodeWithRotateByExif used %dms bitmap: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), paramString });
      AppMethodBeat.o(107814);
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      Log.e("MicroMsg.AppBrandImgUtil", "%s", new Object[] { c.fou().ad(true, 0) });
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
  
  /* Error */
  public static boolean f(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: ldc 212
    //   2: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: bipush 70
    //   7: istore 7
    //   9: aload_1
    //   10: invokestatic 216	com/tencent/mm/vfs/u:bBQ	(Ljava/lang/String;)J
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
    //   37: ldc 218
    //   39: iconst_1
    //   40: anewarray 40	java/lang/Object
    //   43: dup
    //   44: iconst_0
    //   45: aload_1
    //   46: aastore
    //   47: invokestatic 51	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   50: ldc 212
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
    //   73: ifnull +412 -> 485
    //   76: aload 15
    //   78: getfield 222	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   81: astore 16
    //   83: ldc 36
    //   85: ldc 224
    //   87: aload 16
    //   89: invokestatic 229	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   92: invokevirtual 233	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   95: invokestatic 235	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: aload 16
    //   100: ifnull +385 -> 485
    //   103: aload 16
    //   105: invokevirtual 238	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   108: astore 16
    //   110: aload 16
    //   112: ldc 240
    //   114: invokevirtual 243	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   117: iflt +334 -> 451
    //   120: iconst_1
    //   121: istore 11
    //   123: aload 15
    //   125: invokestatic 26	com/tencent/luggage/e/a/a:a	(Landroid/graphics/BitmapFactory$Options;)Z
    //   128: istore 12
    //   130: iconst_m1
    //   131: istore 6
    //   133: iload 12
    //   135: ifeq +1573 -> 1708
    //   138: aload_1
    //   139: invokestatic 248	com/tencent/mm/sdk/platformtools/MMNativeJpeg:queryQuality	(Ljava/lang/String;)I
    //   142: istore 5
    //   144: iload 5
    //   146: istore 6
    //   148: iload 5
    //   150: bipush 70
    //   152: if_icmpge +1556 -> 1708
    //   155: iload 5
    //   157: istore 6
    //   159: iload 5
    //   161: bipush 25
    //   163: if_icmple +1545 -> 1708
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
    //   185: ifeq +334 -> 519
    //   188: iload 7
    //   190: istore 5
    //   192: aload_1
    //   193: invokestatic 254	com/tencent/mm/compatible/util/Exif:fromFile	(Ljava/lang/String;)Lcom/tencent/mm/compatible/util/Exif;
    //   196: astore 16
    //   198: iload 9
    //   200: istore 5
    //   202: aload 16
    //   204: ifnull +49 -> 253
    //   207: iload 7
    //   209: istore 5
    //   211: aload 16
    //   213: invokevirtual 257	com/tencent/mm/compatible/util/Exif:getOrientationInDegree	()I
    //   216: sipush 360
    //   219: irem
    //   220: istore 7
    //   222: iload 7
    //   224: istore 5
    //   226: ldc 36
    //   228: ldc_w 259
    //   231: iconst_1
    //   232: anewarray 40	java/lang/Object
    //   235: dup
    //   236: iconst_0
    //   237: aload 16
    //   239: invokevirtual 257	com/tencent/mm/compatible/util/Exif:getOrientationInDegree	()I
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
    //   263: ldc_w 261
    //   266: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   269: aload 15
    //   271: getfield 202	android/graphics/BitmapFactory$Options:outWidth	I
    //   274: invokevirtual 264	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   277: ldc_w 266
    //   280: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: aload 15
    //   285: getfield 205	android/graphics/BitmapFactory$Options:outHeight	I
    //   288: invokevirtual 264	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   291: ldc_w 266
    //   294: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: iload 11
    //   299: invokevirtual 269	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   302: ldc_w 271
    //   305: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: iload 8
    //   310: invokevirtual 264	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   313: ldc_w 273
    //   316: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: iload 7
    //   321: invokevirtual 264	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   324: ldc_w 275
    //   327: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: iload 10
    //   332: invokevirtual 264	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   335: ldc_w 277
    //   338: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: iload_2
    //   342: invokevirtual 264	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   345: ldc_w 266
    //   348: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: iload_3
    //   352: invokevirtual 264	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   355: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: invokestatic 279	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   388: if_icmplt +515 -> 903
    //   391: aload 15
    //   393: getfield 202	android/graphics/BitmapFactory$Options:outWidth	I
    //   396: aload 15
    //   398: getfield 205	android/graphics/BitmapFactory$Options:outHeight	I
    //   401: imul
    //   402: ldc_w 280
    //   405: if_icmpgt +498 -> 903
    //   408: iload 10
    //   410: ldc_w 281
    //   413: if_icmpge +120 -> 533
    //   416: iload 11
    //   418: ifeq +115 -> 533
    //   421: iload 7
    //   423: ifne +110 -> 533
    //   426: ldc 36
    //   428: ldc_w 283
    //   431: invokestatic 279	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   434: aload_1
    //   435: aload_0
    //   436: invokestatic 287	com/tencent/mm/vfs/u:on	(Ljava/lang/String;Ljava/lang/String;)J
    //   439: lconst_0
    //   440: lcmp
    //   441: iflt +85 -> 526
    //   444: ldc 212
    //   446: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   449: iconst_1
    //   450: ireturn
    //   451: aload 16
    //   453: ldc_w 289
    //   456: invokevirtual 243	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   459: iflt +9 -> 468
    //   462: iconst_1
    //   463: istore 11
    //   465: goto -342 -> 123
    //   468: aload 16
    //   470: ldc_w 291
    //   473: invokevirtual 243	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   476: iflt +9 -> 485
    //   479: iconst_1
    //   480: istore 11
    //   482: goto -359 -> 123
    //   485: iconst_0
    //   486: istore 11
    //   488: goto -365 -> 123
    //   491: astore 16
    //   493: ldc 36
    //   495: new 173	java/lang/StringBuilder
    //   498: dup
    //   499: ldc_w 293
    //   502: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   505: aload 16
    //   507: invokevirtual 294	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   510: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   516: invokestatic 192	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   519: iload 5
    //   521: istore 7
    //   523: goto -266 -> 257
    //   526: ldc 212
    //   528: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   531: iconst_0
    //   532: ireturn
    //   533: new 53	android/graphics/BitmapFactory$Options
    //   536: dup
    //   537: invokespecial 56	android/graphics/BitmapFactory$Options:<init>	()V
    //   540: astore 18
    //   542: aload 18
    //   544: invokestatic 298	com/tencent/mm/sdk/platformtools/BitmapUtil:bindlowMemeryOption	(Landroid/graphics/BitmapFactory$Options;)V
    //   547: aconst_null
    //   548: astore 16
    //   550: aconst_null
    //   551: astore 15
    //   553: aload_1
    //   554: invokestatic 302	com/tencent/mm/vfs/u:Tf	(Ljava/lang/String;)Ljava/io/InputStream;
    //   557: astore 17
    //   559: aload 17
    //   561: astore 15
    //   563: aload 17
    //   565: astore 16
    //   567: aload 17
    //   569: ldc_w 303
    //   572: invokevirtual 308	java/io/InputStream:mark	(I)V
    //   575: aload 17
    //   577: astore 15
    //   579: aload 17
    //   581: astore 16
    //   583: aload 17
    //   585: aconst_null
    //   586: aload 18
    //   588: invokestatic 314	com/tencent/mm/graphics/MMBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   591: astore 18
    //   593: aload 17
    //   595: astore 15
    //   597: aload 17
    //   599: astore 16
    //   601: aload 17
    //   603: invokevirtual 317	java/io/InputStream:reset	()V
    //   606: aload 18
    //   608: ifnonnull +20 -> 628
    //   611: aload 17
    //   613: ifnull +8 -> 621
    //   616: aload 17
    //   618: invokevirtual 318	java/io/InputStream:close	()V
    //   621: ldc 212
    //   623: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   626: iconst_0
    //   627: ireturn
    //   628: iload 7
    //   630: i2f
    //   631: fstore 4
    //   633: aload 17
    //   635: astore 15
    //   637: aload 17
    //   639: astore 16
    //   641: aload 18
    //   643: fload 4
    //   645: invokestatic 109	com/tencent/mm/sdk/platformtools/BitmapUtil:rotate	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   648: iload 6
    //   650: getstatic 324	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   653: aload_0
    //   654: iconst_1
    //   655: invokestatic 328	com/tencent/mm/sdk/platformtools/BitmapUtil:saveBitmapToImage	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   658: pop
    //   659: iload 11
    //   661: ifeq +165 -> 826
    //   664: iload 7
    //   666: ifne +160 -> 826
    //   669: aload 17
    //   671: astore 15
    //   673: aload 17
    //   675: astore 16
    //   677: aload_0
    //   678: invokestatic 216	com/tencent/mm/vfs/u:bBQ	(Ljava/lang/String;)J
    //   681: lstore 13
    //   683: aload 17
    //   685: astore 15
    //   687: aload 17
    //   689: astore 16
    //   691: ldc 36
    //   693: ldc_w 330
    //   696: iconst_3
    //   697: anewarray 40	java/lang/Object
    //   700: dup
    //   701: iconst_0
    //   702: iload 10
    //   704: invokestatic 46	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   707: aastore
    //   708: dup
    //   709: iconst_1
    //   710: lload 13
    //   712: invokestatic 153	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   715: aastore
    //   716: dup
    //   717: iconst_2
    //   718: bipush 10
    //   720: invokestatic 46	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   723: aastore
    //   724: invokestatic 51	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   727: iload 10
    //   729: i2l
    //   730: lload 13
    //   732: lsub
    //   733: ldc2_w 331
    //   736: lmul
    //   737: iload 10
    //   739: bipush 10
    //   741: imul
    //   742: i2l
    //   743: lcmp
    //   744: ifge +65 -> 809
    //   747: aload 17
    //   749: astore 15
    //   751: aload 17
    //   753: astore 16
    //   755: aload_0
    //   756: invokestatic 336	com/tencent/mm/vfs/u:deleteFile	(Ljava/lang/String;)Z
    //   759: pop
    //   760: aload 17
    //   762: astore 15
    //   764: aload 17
    //   766: astore 16
    //   768: aload_1
    //   769: aload_0
    //   770: invokestatic 287	com/tencent/mm/vfs/u:on	(Ljava/lang/String;Ljava/lang/String;)J
    //   773: lstore 13
    //   775: lload 13
    //   777: lconst_0
    //   778: lcmp
    //   779: iflt +24 -> 803
    //   782: iconst_1
    //   783: istore 11
    //   785: aload 17
    //   787: ifnull +8 -> 795
    //   790: aload 17
    //   792: invokevirtual 318	java/io/InputStream:close	()V
    //   795: ldc 212
    //   797: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   800: iload 11
    //   802: ireturn
    //   803: iconst_0
    //   804: istore 11
    //   806: goto -21 -> 785
    //   809: aload 17
    //   811: ifnull +8 -> 819
    //   814: aload 17
    //   816: invokevirtual 318	java/io/InputStream:close	()V
    //   819: ldc 212
    //   821: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   824: iconst_1
    //   825: ireturn
    //   826: aload 17
    //   828: ifnull +8 -> 836
    //   831: aload 17
    //   833: invokevirtual 318	java/io/InputStream:close	()V
    //   836: ldc 212
    //   838: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   841: iconst_1
    //   842: ireturn
    //   843: astore_0
    //   844: aload 15
    //   846: astore 16
    //   848: ldc 36
    //   850: aload_0
    //   851: ldc_w 338
    //   854: aload_1
    //   855: invokestatic 229	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   858: invokevirtual 233	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   861: iconst_0
    //   862: anewarray 40	java/lang/Object
    //   865: invokestatic 73	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   868: aload 15
    //   870: ifnull +8 -> 878
    //   873: aload 15
    //   875: invokevirtual 318	java/io/InputStream:close	()V
    //   878: ldc 212
    //   880: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   883: iconst_0
    //   884: ireturn
    //   885: astore_0
    //   886: aload 16
    //   888: ifnull +8 -> 896
    //   891: aload 16
    //   893: invokevirtual 318	java/io/InputStream:close	()V
    //   896: ldc 212
    //   898: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   901: aload_0
    //   902: athrow
    //   903: iload 10
    //   905: ldc_w 339
    //   908: if_icmpge +45 -> 953
    //   911: iload 11
    //   913: ifeq +40 -> 953
    //   916: iload 7
    //   918: ifne +35 -> 953
    //   921: ldc 36
    //   923: ldc_w 341
    //   926: invokestatic 279	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   929: aload_1
    //   930: aload_0
    //   931: invokestatic 287	com/tencent/mm/vfs/u:on	(Ljava/lang/String;Ljava/lang/String;)J
    //   934: lconst_0
    //   935: lcmp
    //   936: iflt +10 -> 946
    //   939: ldc 212
    //   941: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   944: iconst_1
    //   945: ireturn
    //   946: ldc 212
    //   948: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   951: iconst_0
    //   952: ireturn
    //   953: aload 15
    //   955: getfield 202	android/graphics/BitmapFactory$Options:outWidth	I
    //   958: iload_2
    //   959: if_icmpgt +12 -> 971
    //   962: aload 15
    //   964: getfield 205	android/graphics/BitmapFactory$Options:outHeight	I
    //   967: iload_3
    //   968: if_icmple +21 -> 989
    //   971: aload 15
    //   973: getfield 205	android/graphics/BitmapFactory$Options:outHeight	I
    //   976: iload_2
    //   977: if_icmpgt +301 -> 1278
    //   980: aload 15
    //   982: getfield 202	android/graphics/BitmapFactory$Options:outWidth	I
    //   985: iload_3
    //   986: if_icmpgt +292 -> 1278
    //   989: ldc 36
    //   991: ldc_w 343
    //   994: iconst_3
    //   995: anewarray 40	java/lang/Object
    //   998: dup
    //   999: iconst_0
    //   1000: iload 10
    //   1002: invokestatic 46	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1005: aastore
    //   1006: dup
    //   1007: iconst_1
    //   1008: aload 15
    //   1010: getfield 202	android/graphics/BitmapFactory$Options:outWidth	I
    //   1013: invokestatic 46	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1016: aastore
    //   1017: dup
    //   1018: iconst_2
    //   1019: aload 15
    //   1021: getfield 205	android/graphics/BitmapFactory$Options:outHeight	I
    //   1024: invokestatic 46	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1027: aastore
    //   1028: invokestatic 51	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1031: aload_1
    //   1032: invokestatic 216	com/tencent/mm/vfs/u:bBQ	(Ljava/lang/String;)J
    //   1035: ldc2_w 344
    //   1038: lcmp
    //   1039: ifge +100 -> 1139
    //   1042: iload 11
    //   1044: ifeq +43 -> 1087
    //   1047: ldc 36
    //   1049: ldc_w 347
    //   1052: iconst_1
    //   1053: anewarray 40	java/lang/Object
    //   1056: dup
    //   1057: iconst_0
    //   1058: aload_1
    //   1059: aastore
    //   1060: invokestatic 51	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1063: aload_1
    //   1064: aload_0
    //   1065: invokestatic 287	com/tencent/mm/vfs/u:on	(Ljava/lang/String;Ljava/lang/String;)J
    //   1068: lconst_0
    //   1069: lcmp
    //   1070: iflt +10 -> 1080
    //   1073: ldc 212
    //   1075: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1078: iconst_1
    //   1079: ireturn
    //   1080: ldc 212
    //   1082: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1085: iconst_0
    //   1086: ireturn
    //   1087: aload 15
    //   1089: getfield 202	android/graphics/BitmapFactory$Options:outWidth	I
    //   1092: sipush 150
    //   1095: if_icmpge +44 -> 1139
    //   1098: aload 15
    //   1100: getfield 205	android/graphics/BitmapFactory$Options:outHeight	I
    //   1103: sipush 150
    //   1106: if_icmpge +33 -> 1139
    //   1109: aload_1
    //   1110: aload 15
    //   1112: getfield 205	android/graphics/BitmapFactory$Options:outHeight	I
    //   1115: aload 15
    //   1117: getfield 202	android/graphics/BitmapFactory$Options:outWidth	I
    //   1120: getstatic 350	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   1123: iload 6
    //   1125: aload_0
    //   1126: invokestatic 352	com/tencent/mm/plugin/appbrand/utils/f:createThumbNail	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;)Z
    //   1129: istore 11
    //   1131: ldc 212
    //   1133: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1136: iload 11
    //   1138: ireturn
    //   1139: aload_1
    //   1140: aload 15
    //   1142: getfield 205	android/graphics/BitmapFactory$Options:outHeight	I
    //   1145: aload 15
    //   1147: getfield 202	android/graphics/BitmapFactory$Options:outWidth	I
    //   1150: getstatic 324	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   1153: iload 6
    //   1155: aload_0
    //   1156: invokestatic 352	com/tencent/mm/plugin/appbrand/utils/f:createThumbNail	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;)Z
    //   1159: istore 12
    //   1161: iload 11
    //   1163: ifeq +107 -> 1270
    //   1166: iload 7
    //   1168: ifne +102 -> 1270
    //   1171: aload_0
    //   1172: invokestatic 216	com/tencent/mm/vfs/u:bBQ	(Ljava/lang/String;)J
    //   1175: lstore 13
    //   1177: ldc 36
    //   1179: ldc_w 330
    //   1182: iconst_3
    //   1183: anewarray 40	java/lang/Object
    //   1186: dup
    //   1187: iconst_0
    //   1188: iload 10
    //   1190: invokestatic 46	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1193: aastore
    //   1194: dup
    //   1195: iconst_1
    //   1196: lload 13
    //   1198: invokestatic 153	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1201: aastore
    //   1202: dup
    //   1203: iconst_2
    //   1204: bipush 10
    //   1206: invokestatic 46	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1209: aastore
    //   1210: invokestatic 51	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1213: iload 10
    //   1215: i2l
    //   1216: lload 13
    //   1218: lsub
    //   1219: ldc2_w 331
    //   1222: lmul
    //   1223: iload 10
    //   1225: bipush 10
    //   1227: imul
    //   1228: i2l
    //   1229: lcmp
    //   1230: ifge +32 -> 1262
    //   1233: aload_0
    //   1234: invokestatic 336	com/tencent/mm/vfs/u:deleteFile	(Ljava/lang/String;)Z
    //   1237: pop
    //   1238: aload_1
    //   1239: aload_0
    //   1240: invokestatic 287	com/tencent/mm/vfs/u:on	(Ljava/lang/String;Ljava/lang/String;)J
    //   1243: lconst_0
    //   1244: lcmp
    //   1245: iflt +10 -> 1255
    //   1248: ldc 212
    //   1250: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1253: iconst_1
    //   1254: ireturn
    //   1255: ldc 212
    //   1257: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1260: iconst_0
    //   1261: ireturn
    //   1262: ldc 212
    //   1264: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1267: iload 12
    //   1269: ireturn
    //   1270: ldc 212
    //   1272: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1275: iload 12
    //   1277: ireturn
    //   1278: aload 15
    //   1280: getfield 202	android/graphics/BitmapFactory$Options:outWidth	I
    //   1283: aload 15
    //   1285: getfield 205	android/graphics/BitmapFactory$Options:outHeight	I
    //   1288: if_icmplt +333 -> 1621
    //   1291: iload_2
    //   1292: istore 5
    //   1294: aload 15
    //   1296: getfield 202	android/graphics/BitmapFactory$Options:outWidth	I
    //   1299: aload 15
    //   1301: getfield 205	android/graphics/BitmapFactory$Options:outHeight	I
    //   1304: if_icmplt +323 -> 1627
    //   1307: aload 15
    //   1309: getfield 202	android/graphics/BitmapFactory$Options:outWidth	I
    //   1312: aload 15
    //   1314: getfield 205	android/graphics/BitmapFactory$Options:outHeight	I
    //   1317: iconst_2
    //   1318: imul
    //   1319: if_icmpge +18 -> 1337
    //   1322: aload 15
    //   1324: getfield 205	android/graphics/BitmapFactory$Options:outHeight	I
    //   1327: aload 15
    //   1329: getfield 202	android/graphics/BitmapFactory$Options:outWidth	I
    //   1332: iconst_2
    //   1333: imul
    //   1334: if_icmplt +366 -> 1700
    //   1337: ldc 36
    //   1339: new 173	java/lang/StringBuilder
    //   1342: dup
    //   1343: ldc_w 354
    //   1346: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1349: aload 15
    //   1351: getfield 202	android/graphics/BitmapFactory$Options:outWidth	I
    //   1354: invokevirtual 264	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1357: ldc_w 266
    //   1360: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1363: aload 15
    //   1365: getfield 205	android/graphics/BitmapFactory$Options:outHeight	I
    //   1368: invokevirtual 264	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1371: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1374: invokestatic 279	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1377: aload 15
    //   1379: getfield 205	android/graphics/BitmapFactory$Options:outHeight	I
    //   1382: ifgt +9 -> 1391
    //   1385: aload 15
    //   1387: iconst_1
    //   1388: putfield 205	android/graphics/BitmapFactory$Options:outHeight	I
    //   1391: aload 15
    //   1393: getfield 202	android/graphics/BitmapFactory$Options:outWidth	I
    //   1396: ifgt +9 -> 1405
    //   1399: aload 15
    //   1401: iconst_1
    //   1402: putfield 202	android/graphics/BitmapFactory$Options:outWidth	I
    //   1405: aload 15
    //   1407: getfield 202	android/graphics/BitmapFactory$Options:outWidth	I
    //   1410: aload 15
    //   1412: getfield 205	android/graphics/BitmapFactory$Options:outHeight	I
    //   1415: if_icmple +217 -> 1632
    //   1418: aload 15
    //   1420: getfield 202	android/graphics/BitmapFactory$Options:outWidth	I
    //   1423: aload 15
    //   1425: getfield 205	android/graphics/BitmapFactory$Options:outHeight	I
    //   1428: idiv
    //   1429: istore_2
    //   1430: iload_2
    //   1431: istore 5
    //   1433: iload_2
    //   1434: ifne +6 -> 1440
    //   1437: iconst_1
    //   1438: istore 5
    //   1440: ldc_w 280
    //   1443: iload 5
    //   1445: idiv
    //   1446: i2d
    //   1447: invokestatic 357	java/lang/Math:sqrt	(D)D
    //   1450: d2i
    //   1451: istore_2
    //   1452: aload 15
    //   1454: getfield 202	android/graphics/BitmapFactory$Options:outWidth	I
    //   1457: aload 15
    //   1459: getfield 205	android/graphics/BitmapFactory$Options:outHeight	I
    //   1462: if_icmple +185 -> 1647
    //   1465: iload_2
    //   1466: iload 5
    //   1468: imul
    //   1469: istore_3
    //   1470: ldc 36
    //   1472: new 173	java/lang/StringBuilder
    //   1475: dup
    //   1476: ldc_w 359
    //   1479: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1482: iload_3
    //   1483: invokevirtual 264	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1486: ldc_w 266
    //   1489: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1492: iload_2
    //   1493: invokevirtual 264	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1496: ldc_w 266
    //   1499: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1502: iload 5
    //   1504: invokevirtual 264	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1507: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1510: invokestatic 279	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1513: aload_1
    //   1514: iload_2
    //   1515: iload_3
    //   1516: getstatic 324	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   1519: iload 6
    //   1521: aload_0
    //   1522: invokestatic 352	com/tencent/mm/plugin/appbrand/utils/f:createThumbNail	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;)Z
    //   1525: istore 12
    //   1527: iload 11
    //   1529: ifeq +139 -> 1668
    //   1532: iload 7
    //   1534: ifne +134 -> 1668
    //   1537: aload_0
    //   1538: invokestatic 216	com/tencent/mm/vfs/u:bBQ	(Ljava/lang/String;)J
    //   1541: lstore 13
    //   1543: ldc 36
    //   1545: ldc_w 330
    //   1548: iconst_3
    //   1549: anewarray 40	java/lang/Object
    //   1552: dup
    //   1553: iconst_0
    //   1554: iload 10
    //   1556: invokestatic 46	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1559: aastore
    //   1560: dup
    //   1561: iconst_1
    //   1562: lload 13
    //   1564: invokestatic 153	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1567: aastore
    //   1568: dup
    //   1569: iconst_2
    //   1570: bipush 10
    //   1572: invokestatic 46	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1575: aastore
    //   1576: invokestatic 51	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1579: iload 10
    //   1581: i2l
    //   1582: lload 13
    //   1584: lsub
    //   1585: ldc2_w 331
    //   1588: lmul
    //   1589: iload 10
    //   1591: bipush 10
    //   1593: imul
    //   1594: i2l
    //   1595: lcmp
    //   1596: ifge +72 -> 1668
    //   1599: aload_0
    //   1600: invokestatic 336	com/tencent/mm/vfs/u:deleteFile	(Ljava/lang/String;)Z
    //   1603: pop
    //   1604: aload_1
    //   1605: aload_0
    //   1606: invokestatic 287	com/tencent/mm/vfs/u:on	(Ljava/lang/String;Ljava/lang/String;)J
    //   1609: lconst_0
    //   1610: lcmp
    //   1611: iflt +50 -> 1661
    //   1614: ldc 212
    //   1616: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1619: iconst_1
    //   1620: ireturn
    //   1621: iload_3
    //   1622: istore 5
    //   1624: goto -330 -> 1294
    //   1627: iload_2
    //   1628: istore_3
    //   1629: goto -322 -> 1307
    //   1632: aload 15
    //   1634: getfield 205	android/graphics/BitmapFactory$Options:outHeight	I
    //   1637: aload 15
    //   1639: getfield 202	android/graphics/BitmapFactory$Options:outWidth	I
    //   1642: idiv
    //   1643: istore_2
    //   1644: goto -214 -> 1430
    //   1647: iload_2
    //   1648: iload 5
    //   1650: imul
    //   1651: istore 8
    //   1653: iload_2
    //   1654: istore_3
    //   1655: iload 8
    //   1657: istore_2
    //   1658: goto -188 -> 1470
    //   1661: ldc 212
    //   1663: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1666: iconst_0
    //   1667: ireturn
    //   1668: ldc 212
    //   1670: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1673: iload 12
    //   1675: ireturn
    //   1676: astore_0
    //   1677: goto -1056 -> 621
    //   1680: astore_0
    //   1681: goto -886 -> 795
    //   1684: astore_0
    //   1685: goto -866 -> 819
    //   1688: astore_0
    //   1689: goto -853 -> 836
    //   1692: astore_0
    //   1693: goto -815 -> 878
    //   1696: astore_1
    //   1697: goto -801 -> 896
    //   1700: iload_3
    //   1701: istore_2
    //   1702: iload 5
    //   1704: istore_3
    //   1705: goto -192 -> 1513
    //   1708: iload 6
    //   1710: istore 8
    //   1712: iload 7
    //   1714: istore 6
    //   1716: goto -1542 -> 174
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1719	0	paramString1	String
    //   0	1719	1	paramString2	String
    //   0	1719	2	paramInt1	int
    //   0	1719	3	paramInt2	int
    //   631	13	4	f	float
    //   142	1561	5	i	int
    //   131	1584	6	j	int
    //   7	1706	7	k	int
    //   168	1543	8	m	int
    //   181	18	9	n	int
    //   14	1580	10	i1	int
    //   121	1407	11	bool1	boolean
    //   128	1546	12	bool2	boolean
    //   681	902	13	l	long
    //   28	1610	15	localObject1	Object
    //   81	388	16	localObject2	Object
    //   491	15	16	localException	java.lang.Exception
    //   548	344	16	localObject3	Object
    //   557	275	17	localInputStream	java.io.InputStream
    //   540	102	18	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   192	198	491	java/lang/Exception
    //   211	222	491	java/lang/Exception
    //   226	249	491	java/lang/Exception
    //   553	559	843	java/io/IOException
    //   567	575	843	java/io/IOException
    //   583	593	843	java/io/IOException
    //   601	606	843	java/io/IOException
    //   641	659	843	java/io/IOException
    //   677	683	843	java/io/IOException
    //   691	727	843	java/io/IOException
    //   755	760	843	java/io/IOException
    //   768	775	843	java/io/IOException
    //   553	559	885	finally
    //   567	575	885	finally
    //   583	593	885	finally
    //   601	606	885	finally
    //   641	659	885	finally
    //   677	683	885	finally
    //   691	727	885	finally
    //   755	760	885	finally
    //   768	775	885	finally
    //   848	868	885	finally
    //   616	621	1676	java/io/IOException
    //   790	795	1680	java/io/IOException
    //   814	819	1684	java/io/IOException
    //   831	836	1688	java/io/IOException
    //   873	878	1692	java/io/IOException
    //   891	896	1696	java/io/IOException
  }
  
  public static boolean fb(String paramString1, String paramString2)
  {
    AppMethodBeat.i(107816);
    boolean bool = f(paramString1, paramString2, -1, -1);
    AppMethodBeat.o(107816);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.f
 * JD-Core Version:    0.7.0.1
 */