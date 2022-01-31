package com.tencent.mm.plugin.appbrand.v;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.mm.a.e;
import com.tencent.mm.memory.l;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public enum a
{
  public static boolean a(BitmapFactory.Options paramOptions)
  {
    if (paramOptions == null) {}
    do
    {
      do
      {
        return false;
        paramOptions = paramOptions.outMimeType;
      } while (paramOptions == null);
      paramOptions = paramOptions.toLowerCase();
      if (paramOptions.indexOf("jpg") >= 0) {
        return true;
      }
    } while (paramOptions.indexOf("jpeg") < 0);
    return true;
  }
  
  private static boolean a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Bitmap.CompressFormat paramCompressFormat, int paramInt5, String paramString2)
  {
    localObject4 = null;
    localObject3 = localObject4;
    try
    {
      y.i("MicroMsg.AppBrandImgUtil", "createThumbNailUnScale, srcWidth: %s, srcHeight: %s, width: %s, height: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt4), Integer.valueOf(paramInt3) });
      localObject3 = localObject4;
      localObject2 = new BitmapFactory.Options();
      localObject3 = localObject4;
      localObject5 = new MMBitmapFactory.DecodeResultLogger();
      localObject3 = localObject4;
      d2 = paramInt2 * 1.0D / paramInt3;
      localObject3 = localObject4;
      d3 = paramInt1 * 1.0D / paramInt4;
      if ((paramInt1 != paramInt4) || (paramInt2 != paramInt3)) {
        break label152;
      }
      localObject3 = localObject4;
      localObject2 = b(paramString1, (BitmapFactory.Options)localObject2, (MMBitmapFactory.DecodeResultLogger)localObject5);
    }
    catch (IOException paramString1)
    {
      for (;;)
      {
        Object localObject2;
        Object localObject5;
        double d2;
        double d3;
        label152:
        label176:
        Object localObject1;
        y.printErrStackTrace("MicroMsg.AppBrandImgUtil", paramString1, "create thumbnail from orig failed: %s", new Object[] { paramString2 });
        if (localObject3 != null) {}
        do
        {
          try
          {
            ((OutputStream)localObject3).close();
            return false;
            d1 = d2;
            break label176;
            localObject3 = localObject4;
            y.i("MicroMsg.AppBrandImgUtil", "createThumbNailUnScale, sampleSize: %s", new Object[] { Integer.valueOf(((BitmapFactory.Options)localObject2).inSampleSize) });
            localObject3 = localObject4;
            localObject2 = b(paramString1, (BitmapFactory.Options)localObject2, (MMBitmapFactory.DecodeResultLogger)localObject5);
            break;
            localObject3 = localObject4;
            y.i("MicroMsg.AppBrandImgUtil", "createThumbNailUnScale, bm.width: %s, bm.height: %s", new Object[] { Integer.valueOf(((Bitmap)localObject2).getWidth()), Integer.valueOf(((Bitmap)localObject2).getHeight()) });
            if (d2 < d3)
            {
              localObject3 = localObject4;
              paramInt2 = (int)Math.ceil(paramInt4 * 1.0D * paramInt2 / paramInt1);
              paramInt1 = paramInt4;
            }
            for (;;)
            {
              localObject3 = localObject4;
              paramInt4 = BackwardSupportUtil.ExifHelper.YS(paramString1);
              if ((paramInt4 != 90) && (paramInt4 != 270)) {
                break label610;
              }
              localObject3 = localObject4;
              paramString1 = c.b((Bitmap)localObject2, paramInt4);
              localObject3 = localObject4;
              localObject5 = Bitmap.createScaledBitmap(paramString1, paramInt2, paramInt1, true);
              if (localObject5 == null) {
                break;
              }
              localObject2 = localObject5;
              if (paramString1 != localObject5)
              {
                localObject3 = localObject4;
                l.Fb().n(paramString1);
                localObject2 = localObject5;
              }
              localObject3 = localObject4;
              y.i("MicroMsg.AppBrandImgUtil", "createThumbNailUnScalebyUpload, degree %d, bm.width: %s, bm.height: %s", new Object[] { Integer.valueOf(paramInt4), Integer.valueOf(((Bitmap)localObject2).getWidth()), Integer.valueOf(((Bitmap)localObject2).getHeight()) });
              localObject3 = localObject4;
              paramString1 = FileOp.jI(paramString2);
              localObject3 = paramString1;
              c.a((Bitmap)localObject2, paramInt5, paramCompressFormat, paramString1, false);
              localObject3 = paramString1;
              l.Fb().n((Bitmap)localObject2);
              localObject3 = paramString1;
              paramString1.close();
              return true;
              localObject3 = localObject4;
              d1 = Math.ceil(paramInt3 * 1.0D * paramInt1 / paramInt2);
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
    y.i("MicroMsg.AppBrandImgUtil", "createThumbNailUnScale, result bm: %s", new Object[] { localObject2 });
    if (localObject2 == null)
    {
      return false;
      localObject3 = localObject4;
      ((BitmapFactory.Options)localObject2).inSampleSize = 1;
      if (paramInt2 > paramInt3) {
        break label622;
      }
      if (paramInt1 > paramInt4)
      {
        break label622;
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
    BitmapFactory.Options localOptions = c.YU(paramString1);
    if ((localOptions == null) || (localOptions.outWidth <= 0) || (localOptions.outHeight <= 0)) {
      return false;
    }
    return a(paramString1, localOptions.outWidth, localOptions.outHeight, paramInt1, paramInt2, paramCompressFormat, paramInt3, paramString2);
  }
  
  private static Bitmap b(String paramString, BitmapFactory.Options paramOptions, MMBitmapFactory.DecodeResultLogger paramDecodeResultLogger)
  {
    long l = System.currentTimeMillis();
    try
    {
      paramString = l.Fb().a(paramString, paramOptions, paramDecodeResultLogger);
      y.d("MicroMsg.AppBrandImgUtil", "decodeWithRotateByExif used %dms bitmap: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), paramString });
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      com.tencent.mm.ch.b.cxz();
      y.e("MicroMsg.AppBrandImgUtil", "OutOfMemoryError e " + paramString.getMessage());
    }
    return null;
  }
  
  public static String b(BitmapFactory.Options paramOptions)
  {
    paramOptions = paramOptions.outMimeType;
    y.d("MicroMsg.AppBrandImgUtil", "mimetype: " + paramOptions);
    if (paramOptions == null) {
      return "unknown";
    }
    paramOptions = paramOptions.toLowerCase();
    if (paramOptions.indexOf("jpg") >= 0) {
      return "jpeg";
    }
    if (paramOptions.indexOf("jpeg") >= 0) {
      return "jpeg";
    }
    if (paramOptions.indexOf("png") >= 0) {
      return "png";
    }
    if (paramOptions.indexOf("gif") >= 0) {
      return "gif";
    }
    return "unknown";
  }
  
  /* Error */
  public static boolean ch(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 215	com/tencent/mm/modelsfs/FileOp:mR	(Ljava/lang/String;)J
    //   4: l2i
    //   5: istore 9
    //   7: aload_1
    //   8: invokestatic 142	com/tencent/mm/sdk/platformtools/c:YU	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   11: astore 15
    //   13: aload 15
    //   15: ifnonnull +24 -> 39
    //   18: ldc 39
    //   20: ldc 217
    //   22: iconst_1
    //   23: anewarray 43	java/lang/Object
    //   26: dup
    //   27: iconst_0
    //   28: aload_1
    //   29: aastore
    //   30: invokestatic 55	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   33: iconst_0
    //   34: istore 10
    //   36: iload 10
    //   38: ireturn
    //   39: aload 15
    //   41: ifnull +376 -> 417
    //   44: aload 15
    //   46: getfield 20	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   49: astore 16
    //   51: ldc 39
    //   53: new 177	java/lang/StringBuilder
    //   56: dup
    //   57: ldc 199
    //   59: invokespecial 182	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   62: aload 16
    //   64: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokestatic 201	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: aload 16
    //   75: ifnull +342 -> 417
    //   78: aload 16
    //   80: invokevirtual 26	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   83: astore 16
    //   85: aload 16
    //   87: ldc 28
    //   89: invokevirtual 32	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   92: iflt +293 -> 385
    //   95: iconst_1
    //   96: istore 11
    //   98: aload 15
    //   100: invokestatic 219	com/tencent/mm/plugin/appbrand/v/a:a	(Landroid/graphics/BitmapFactory$Options;)Z
    //   103: istore 10
    //   105: iconst_m1
    //   106: istore 4
    //   108: iload 10
    //   110: ifeq +1499 -> 1609
    //   113: aload_1
    //   114: invokestatic 224	com/tencent/mm/sdk/platformtools/MMNativeJpeg:queryQuality	(Ljava/lang/String;)I
    //   117: istore_3
    //   118: iload_3
    //   119: istore 4
    //   121: iload_3
    //   122: bipush 70
    //   124: if_icmpge +1485 -> 1609
    //   127: iload_3
    //   128: istore 4
    //   130: iload_3
    //   131: bipush 25
    //   133: if_icmple +1476 -> 1609
    //   136: iload_3
    //   137: istore 4
    //   139: iload_3
    //   140: istore 5
    //   142: iconst_0
    //   143: istore 6
    //   145: iconst_0
    //   146: istore_3
    //   147: iconst_0
    //   148: istore 7
    //   150: iload 10
    //   152: ifeq +299 -> 451
    //   155: iload 6
    //   157: istore_3
    //   158: aload_1
    //   159: invokestatic 230	com/tencent/mm/compatible/util/Exif:fromFile	(Ljava/lang/String;)Lcom/tencent/mm/compatible/util/Exif;
    //   162: astore 16
    //   164: iload 7
    //   166: istore_3
    //   167: aload 16
    //   169: ifnull +45 -> 214
    //   172: iload 6
    //   174: istore_3
    //   175: aload 16
    //   177: invokevirtual 233	com/tencent/mm/compatible/util/Exif:getOrientationInDegree	()I
    //   180: sipush 360
    //   183: irem
    //   184: istore 6
    //   186: iload 6
    //   188: istore_3
    //   189: ldc 39
    //   191: ldc 235
    //   193: iconst_1
    //   194: anewarray 43	java/lang/Object
    //   197: dup
    //   198: iconst_0
    //   199: aload 16
    //   201: invokevirtual 233	com/tencent/mm/compatible/util/Exif:getOrientationInDegree	()I
    //   204: invokestatic 49	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   207: aastore
    //   208: invokestatic 55	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   211: iload 6
    //   213: istore_3
    //   214: iload_3
    //   215: istore 6
    //   217: ldc 39
    //   219: new 177	java/lang/StringBuilder
    //   222: dup
    //   223: ldc 237
    //   225: invokespecial 182	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   228: aload 15
    //   230: getfield 145	android/graphics/BitmapFactory$Options:outWidth	I
    //   233: invokevirtual 240	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   236: ldc 242
    //   238: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: aload 15
    //   243: getfield 148	android/graphics/BitmapFactory$Options:outHeight	I
    //   246: invokevirtual 240	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   249: ldc 242
    //   251: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: iload 11
    //   256: invokevirtual 245	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   259: ldc 247
    //   261: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: iload 4
    //   266: invokevirtual 240	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   269: ldc 249
    //   271: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: iload 6
    //   276: invokevirtual 240	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   279: ldc 251
    //   281: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: iload 9
    //   286: invokevirtual 240	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   289: ldc 253
    //   291: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   297: invokestatic 255	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   300: aload 15
    //   302: getfield 145	android/graphics/BitmapFactory$Options:outWidth	I
    //   305: aload 15
    //   307: getfield 148	android/graphics/BitmapFactory$Options:outHeight	I
    //   310: iconst_2
    //   311: imul
    //   312: if_icmpge +18 -> 330
    //   315: aload 15
    //   317: getfield 148	android/graphics/BitmapFactory$Options:outHeight	I
    //   320: aload 15
    //   322: getfield 145	android/graphics/BitmapFactory$Options:outWidth	I
    //   325: iconst_2
    //   326: imul
    //   327: if_icmplt +457 -> 784
    //   330: aload 15
    //   332: getfield 145	android/graphics/BitmapFactory$Options:outWidth	I
    //   335: aload 15
    //   337: getfield 148	android/graphics/BitmapFactory$Options:outHeight	I
    //   340: imul
    //   341: ldc_w 256
    //   344: if_icmpgt +440 -> 784
    //   347: iload 9
    //   349: ldc_w 257
    //   352: if_icmpge +107 -> 459
    //   355: iload 11
    //   357: ifeq +102 -> 459
    //   360: iload 6
    //   362: ifne +97 -> 459
    //   365: ldc 39
    //   367: ldc_w 259
    //   370: invokestatic 255	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   373: aload_1
    //   374: aload_0
    //   375: invokestatic 263	com/tencent/mm/modelsfs/FileOp:r	(Ljava/lang/String;Ljava/lang/String;)J
    //   378: lconst_0
    //   379: lcmp
    //   380: iflt +77 -> 457
    //   383: iconst_1
    //   384: ireturn
    //   385: aload 16
    //   387: ldc 34
    //   389: invokevirtual 32	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   392: iflt +9 -> 401
    //   395: iconst_1
    //   396: istore 11
    //   398: goto -300 -> 98
    //   401: aload 16
    //   403: ldc 205
    //   405: invokevirtual 32	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   408: iflt +9 -> 417
    //   411: iconst_1
    //   412: istore 11
    //   414: goto -316 -> 98
    //   417: iconst_0
    //   418: istore 11
    //   420: goto -322 -> 98
    //   423: astore 16
    //   425: ldc 39
    //   427: new 177	java/lang/StringBuilder
    //   430: dup
    //   431: ldc_w 265
    //   434: invokespecial 182	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   437: aload 16
    //   439: invokevirtual 266	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   442: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   448: invokestatic 196	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   451: iload_3
    //   452: istore 6
    //   454: goto -237 -> 217
    //   457: iconst_0
    //   458: ireturn
    //   459: new 16	android/graphics/BitmapFactory$Options
    //   462: dup
    //   463: invokespecial 58	android/graphics/BitmapFactory$Options:<init>	()V
    //   466: astore 17
    //   468: aload 17
    //   470: invokestatic 270	com/tencent/mm/sdk/platformtools/c:c	(Landroid/graphics/BitmapFactory$Options;)V
    //   473: aload_1
    //   474: invokestatic 274	com/tencent/mm/modelsfs/FileOp:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   477: astore 15
    //   479: aload 15
    //   481: invokevirtual 280	java/io/InputStream:markSupported	()Z
    //   484: ifne +1122 -> 1606
    //   487: aload 15
    //   489: instanceof 282
    //   492: ifeq +1114 -> 1606
    //   495: new 284	com/tencent/mm/sdk/platformtools/i
    //   498: dup
    //   499: aload 15
    //   501: checkcast 282	java/io/FileInputStream
    //   504: invokespecial 287	com/tencent/mm/sdk/platformtools/i:<init>	(Ljava/io/FileInputStream;)V
    //   507: astore 16
    //   509: aload 16
    //   511: astore 15
    //   513: aload 15
    //   515: ldc_w 288
    //   518: invokevirtual 292	java/io/InputStream:mark	(I)V
    //   521: aload 15
    //   523: aconst_null
    //   524: aload 17
    //   526: new 60	com/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger
    //   529: dup
    //   530: invokespecial 61	com/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger:<init>	()V
    //   533: iconst_0
    //   534: iconst_0
    //   535: newarray int
    //   537: invokestatic 298	com/tencent/mm/sdk/platformtools/MMBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;Lcom/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger;I[I)Landroid/graphics/Bitmap;
    //   540: astore 16
    //   542: aload 15
    //   544: invokevirtual 301	java/io/InputStream:reset	()V
    //   547: aload 16
    //   549: ifnonnull +15 -> 564
    //   552: aload 15
    //   554: ifnull +8 -> 562
    //   557: aload 15
    //   559: invokevirtual 302	java/io/InputStream:close	()V
    //   562: iconst_0
    //   563: ireturn
    //   564: iload 6
    //   566: i2f
    //   567: fstore_2
    //   568: aload 16
    //   570: fload_2
    //   571: invokestatic 112	com/tencent/mm/sdk/platformtools/c:b	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   574: iload 5
    //   576: getstatic 308	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   579: aload_0
    //   580: iconst_1
    //   581: invokestatic 311	com/tencent/mm/sdk/platformtools/c:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)V
    //   584: iload 11
    //   586: ifeq +131 -> 717
    //   589: iload 6
    //   591: ifne +126 -> 717
    //   594: aload_0
    //   595: invokestatic 215	com/tencent/mm/modelsfs/FileOp:mR	(Ljava/lang/String;)J
    //   598: lstore 13
    //   600: ldc 39
    //   602: ldc_w 313
    //   605: iconst_3
    //   606: anewarray 43	java/lang/Object
    //   609: dup
    //   610: iconst_0
    //   611: iload 9
    //   613: invokestatic 49	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   616: aastore
    //   617: dup
    //   618: iconst_1
    //   619: lload 13
    //   621: invokestatic 167	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   624: aastore
    //   625: dup
    //   626: iconst_2
    //   627: bipush 10
    //   629: invokestatic 49	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   632: aastore
    //   633: invokestatic 55	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   636: iload 9
    //   638: i2l
    //   639: lload 13
    //   641: lsub
    //   642: ldc2_w 314
    //   645: lmul
    //   646: iload 9
    //   648: bipush 10
    //   650: imul
    //   651: i2l
    //   652: lcmp
    //   653: ifge +52 -> 705
    //   656: aload_0
    //   657: invokestatic 319	com/tencent/mm/modelsfs/FileOp:deleteFile	(Ljava/lang/String;)Z
    //   660: pop
    //   661: aload_1
    //   662: aload_0
    //   663: invokestatic 263	com/tencent/mm/modelsfs/FileOp:r	(Ljava/lang/String;Ljava/lang/String;)J
    //   666: lstore 13
    //   668: lload 13
    //   670: lconst_0
    //   671: lcmp
    //   672: iflt +27 -> 699
    //   675: iconst_1
    //   676: istore 11
    //   678: iload 11
    //   680: istore 10
    //   682: aload 15
    //   684: ifnull -648 -> 36
    //   687: aload 15
    //   689: invokevirtual 302	java/io/InputStream:close	()V
    //   692: iload 11
    //   694: ireturn
    //   695: astore_0
    //   696: iload 11
    //   698: ireturn
    //   699: iconst_0
    //   700: istore 11
    //   702: goto -24 -> 678
    //   705: aload 15
    //   707: ifnull +8 -> 715
    //   710: aload 15
    //   712: invokevirtual 302	java/io/InputStream:close	()V
    //   715: iconst_1
    //   716: ireturn
    //   717: aload 15
    //   719: ifnull +8 -> 727
    //   722: aload 15
    //   724: invokevirtual 302	java/io/InputStream:close	()V
    //   727: iconst_1
    //   728: ireturn
    //   729: astore 15
    //   731: aconst_null
    //   732: astore_0
    //   733: ldc 39
    //   735: aload 15
    //   737: new 177	java/lang/StringBuilder
    //   740: dup
    //   741: ldc_w 321
    //   744: invokespecial 182	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   747: aload_1
    //   748: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   751: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   754: iconst_0
    //   755: anewarray 43	java/lang/Object
    //   758: invokestatic 78	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   761: aload_0
    //   762: ifnull +7 -> 769
    //   765: aload_0
    //   766: invokevirtual 302	java/io/InputStream:close	()V
    //   769: iconst_0
    //   770: ireturn
    //   771: astore_1
    //   772: aconst_null
    //   773: astore_0
    //   774: aload_0
    //   775: ifnull +7 -> 782
    //   778: aload_0
    //   779: invokevirtual 302	java/io/InputStream:close	()V
    //   782: aload_1
    //   783: athrow
    //   784: iload 9
    //   786: ldc_w 322
    //   789: if_icmpge +35 -> 824
    //   792: iload 11
    //   794: ifeq +30 -> 824
    //   797: iload 6
    //   799: ifne +25 -> 824
    //   802: ldc 39
    //   804: ldc_w 324
    //   807: invokestatic 255	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   810: aload_1
    //   811: aload_0
    //   812: invokestatic 263	com/tencent/mm/modelsfs/FileOp:r	(Ljava/lang/String;Ljava/lang/String;)J
    //   815: lconst_0
    //   816: lcmp
    //   817: iflt +5 -> 822
    //   820: iconst_1
    //   821: ireturn
    //   822: iconst_0
    //   823: ireturn
    //   824: aload 15
    //   826: getfield 145	android/graphics/BitmapFactory$Options:outWidth	I
    //   829: sipush 960
    //   832: if_icmpgt +14 -> 846
    //   835: aload 15
    //   837: getfield 148	android/graphics/BitmapFactory$Options:outHeight	I
    //   840: sipush 640
    //   843: if_icmple +25 -> 868
    //   846: aload 15
    //   848: getfield 148	android/graphics/BitmapFactory$Options:outHeight	I
    //   851: sipush 960
    //   854: if_icmpgt +270 -> 1124
    //   857: aload 15
    //   859: getfield 145	android/graphics/BitmapFactory$Options:outWidth	I
    //   862: sipush 640
    //   865: if_icmpgt +259 -> 1124
    //   868: ldc 39
    //   870: ldc_w 326
    //   873: iconst_3
    //   874: anewarray 43	java/lang/Object
    //   877: dup
    //   878: iconst_0
    //   879: iload 9
    //   881: invokestatic 49	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   884: aastore
    //   885: dup
    //   886: iconst_1
    //   887: aload 15
    //   889: getfield 145	android/graphics/BitmapFactory$Options:outWidth	I
    //   892: invokestatic 49	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   895: aastore
    //   896: dup
    //   897: iconst_2
    //   898: aload 15
    //   900: getfield 148	android/graphics/BitmapFactory$Options:outHeight	I
    //   903: invokestatic 49	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   906: aastore
    //   907: invokestatic 55	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   910: aload_1
    //   911: invokestatic 215	com/tencent/mm/modelsfs/FileOp:mR	(Ljava/lang/String;)J
    //   914: ldc2_w 327
    //   917: lcmp
    //   918: ifge +81 -> 999
    //   921: iload 11
    //   923: ifeq +33 -> 956
    //   926: ldc 39
    //   928: ldc_w 330
    //   931: iconst_1
    //   932: anewarray 43	java/lang/Object
    //   935: dup
    //   936: iconst_0
    //   937: aload_1
    //   938: aastore
    //   939: invokestatic 55	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   942: aload_1
    //   943: aload_0
    //   944: invokestatic 263	com/tencent/mm/modelsfs/FileOp:r	(Ljava/lang/String;Ljava/lang/String;)J
    //   947: lconst_0
    //   948: lcmp
    //   949: iflt +5 -> 954
    //   952: iconst_1
    //   953: ireturn
    //   954: iconst_0
    //   955: ireturn
    //   956: aload 15
    //   958: getfield 145	android/graphics/BitmapFactory$Options:outWidth	I
    //   961: sipush 150
    //   964: if_icmpge +35 -> 999
    //   967: aload 15
    //   969: getfield 148	android/graphics/BitmapFactory$Options:outHeight	I
    //   972: sipush 150
    //   975: if_icmpge +24 -> 999
    //   978: aload_1
    //   979: aload 15
    //   981: getfield 148	android/graphics/BitmapFactory$Options:outHeight	I
    //   984: aload 15
    //   986: getfield 145	android/graphics/BitmapFactory$Options:outWidth	I
    //   989: getstatic 333	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   992: iload 5
    //   994: aload_0
    //   995: invokestatic 335	com/tencent/mm/plugin/appbrand/v/a:a	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;)Z
    //   998: ireturn
    //   999: aload_1
    //   1000: aload 15
    //   1002: getfield 148	android/graphics/BitmapFactory$Options:outHeight	I
    //   1005: aload 15
    //   1007: getfield 145	android/graphics/BitmapFactory$Options:outWidth	I
    //   1010: getstatic 308	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   1013: iload 5
    //   1015: aload_0
    //   1016: invokestatic 335	com/tencent/mm/plugin/appbrand/v/a:a	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;)Z
    //   1019: istore 12
    //   1021: iload 12
    //   1023: istore 10
    //   1025: iload 11
    //   1027: ifeq -991 -> 36
    //   1030: iload 12
    //   1032: istore 10
    //   1034: iload 6
    //   1036: ifne -1000 -> 36
    //   1039: aload_0
    //   1040: invokestatic 215	com/tencent/mm/modelsfs/FileOp:mR	(Ljava/lang/String;)J
    //   1043: lstore 13
    //   1045: ldc 39
    //   1047: ldc_w 313
    //   1050: iconst_3
    //   1051: anewarray 43	java/lang/Object
    //   1054: dup
    //   1055: iconst_0
    //   1056: iload 9
    //   1058: invokestatic 49	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1061: aastore
    //   1062: dup
    //   1063: iconst_1
    //   1064: lload 13
    //   1066: invokestatic 167	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1069: aastore
    //   1070: dup
    //   1071: iconst_2
    //   1072: bipush 10
    //   1074: invokestatic 49	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1077: aastore
    //   1078: invokestatic 55	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1081: iload 12
    //   1083: istore 10
    //   1085: iload 9
    //   1087: i2l
    //   1088: lload 13
    //   1090: lsub
    //   1091: ldc2_w 314
    //   1094: lmul
    //   1095: iload 9
    //   1097: bipush 10
    //   1099: imul
    //   1100: i2l
    //   1101: lcmp
    //   1102: ifge -1066 -> 36
    //   1105: aload_0
    //   1106: invokestatic 319	com/tencent/mm/modelsfs/FileOp:deleteFile	(Ljava/lang/String;)Z
    //   1109: pop
    //   1110: aload_1
    //   1111: aload_0
    //   1112: invokestatic 263	com/tencent/mm/modelsfs/FileOp:r	(Ljava/lang/String;Ljava/lang/String;)J
    //   1115: lconst_0
    //   1116: lcmp
    //   1117: iflt +5 -> 1122
    //   1120: iconst_1
    //   1121: ireturn
    //   1122: iconst_0
    //   1123: ireturn
    //   1124: aload 15
    //   1126: getfield 145	android/graphics/BitmapFactory$Options:outWidth	I
    //   1129: aload 15
    //   1131: getfield 148	android/graphics/BitmapFactory$Options:outHeight	I
    //   1134: if_icmplt +346 -> 1480
    //   1137: sipush 960
    //   1140: istore_3
    //   1141: aload 15
    //   1143: getfield 145	android/graphics/BitmapFactory$Options:outWidth	I
    //   1146: aload 15
    //   1148: getfield 148	android/graphics/BitmapFactory$Options:outHeight	I
    //   1151: if_icmplt +336 -> 1487
    //   1154: sipush 640
    //   1157: istore 4
    //   1159: aload 15
    //   1161: getfield 145	android/graphics/BitmapFactory$Options:outWidth	I
    //   1164: aload 15
    //   1166: getfield 148	android/graphics/BitmapFactory$Options:outHeight	I
    //   1169: iconst_2
    //   1170: imul
    //   1171: if_icmpge +18 -> 1189
    //   1174: aload 15
    //   1176: getfield 148	android/graphics/BitmapFactory$Options:outHeight	I
    //   1179: aload 15
    //   1181: getfield 145	android/graphics/BitmapFactory$Options:outWidth	I
    //   1184: iconst_2
    //   1185: imul
    //   1186: if_icmplt +407 -> 1593
    //   1189: ldc 39
    //   1191: new 177	java/lang/StringBuilder
    //   1194: dup
    //   1195: ldc_w 337
    //   1198: invokespecial 182	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1201: aload 15
    //   1203: getfield 145	android/graphics/BitmapFactory$Options:outWidth	I
    //   1206: invokevirtual 240	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1209: ldc 242
    //   1211: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1214: aload 15
    //   1216: getfield 148	android/graphics/BitmapFactory$Options:outHeight	I
    //   1219: invokevirtual 240	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1222: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1225: invokestatic 255	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1228: aload 15
    //   1230: getfield 148	android/graphics/BitmapFactory$Options:outHeight	I
    //   1233: ifgt +9 -> 1242
    //   1236: aload 15
    //   1238: iconst_1
    //   1239: putfield 148	android/graphics/BitmapFactory$Options:outHeight	I
    //   1242: aload 15
    //   1244: getfield 145	android/graphics/BitmapFactory$Options:outWidth	I
    //   1247: ifgt +9 -> 1256
    //   1250: aload 15
    //   1252: iconst_1
    //   1253: putfield 145	android/graphics/BitmapFactory$Options:outWidth	I
    //   1256: aload 15
    //   1258: getfield 145	android/graphics/BitmapFactory$Options:outWidth	I
    //   1261: aload 15
    //   1263: getfield 148	android/graphics/BitmapFactory$Options:outHeight	I
    //   1266: if_icmple +229 -> 1495
    //   1269: aload 15
    //   1271: getfield 145	android/graphics/BitmapFactory$Options:outWidth	I
    //   1274: aload 15
    //   1276: getfield 148	android/graphics/BitmapFactory$Options:outHeight	I
    //   1279: idiv
    //   1280: istore_3
    //   1281: iload_3
    //   1282: istore 7
    //   1284: iload_3
    //   1285: ifne +6 -> 1291
    //   1288: iconst_1
    //   1289: istore 7
    //   1291: ldc_w 256
    //   1294: iload 7
    //   1296: idiv
    //   1297: i2d
    //   1298: invokestatic 340	java/lang/Math:sqrt	(D)D
    //   1301: d2i
    //   1302: istore_3
    //   1303: aload 15
    //   1305: getfield 145	android/graphics/BitmapFactory$Options:outWidth	I
    //   1308: aload 15
    //   1310: getfield 148	android/graphics/BitmapFactory$Options:outHeight	I
    //   1313: if_icmple +197 -> 1510
    //   1316: iload_3
    //   1317: iload 7
    //   1319: imul
    //   1320: istore 4
    //   1322: ldc 39
    //   1324: new 177	java/lang/StringBuilder
    //   1327: dup
    //   1328: ldc_w 342
    //   1331: invokespecial 182	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1334: iload 4
    //   1336: invokevirtual 240	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1339: ldc 242
    //   1341: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1344: iload_3
    //   1345: invokevirtual 240	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1348: ldc 242
    //   1350: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1353: iload 7
    //   1355: invokevirtual 240	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1358: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1361: invokestatic 255	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1364: aload_1
    //   1365: iload_3
    //   1366: iload 4
    //   1368: getstatic 308	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   1371: iload 5
    //   1373: aload_0
    //   1374: invokestatic 335	com/tencent/mm/plugin/appbrand/v/a:a	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;)Z
    //   1377: istore 12
    //   1379: iload 12
    //   1381: istore 10
    //   1383: iload 11
    //   1385: ifeq -1349 -> 36
    //   1388: iload 12
    //   1390: istore 10
    //   1392: iload 6
    //   1394: ifne -1358 -> 36
    //   1397: aload_0
    //   1398: invokestatic 215	com/tencent/mm/modelsfs/FileOp:mR	(Ljava/lang/String;)J
    //   1401: lstore 13
    //   1403: ldc 39
    //   1405: ldc_w 313
    //   1408: iconst_3
    //   1409: anewarray 43	java/lang/Object
    //   1412: dup
    //   1413: iconst_0
    //   1414: iload 9
    //   1416: invokestatic 49	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1419: aastore
    //   1420: dup
    //   1421: iconst_1
    //   1422: lload 13
    //   1424: invokestatic 167	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1427: aastore
    //   1428: dup
    //   1429: iconst_2
    //   1430: bipush 10
    //   1432: invokestatic 49	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1435: aastore
    //   1436: invokestatic 55	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1439: iload 12
    //   1441: istore 10
    //   1443: iload 9
    //   1445: i2l
    //   1446: lload 13
    //   1448: lsub
    //   1449: ldc2_w 314
    //   1452: lmul
    //   1453: iload 9
    //   1455: bipush 10
    //   1457: imul
    //   1458: i2l
    //   1459: lcmp
    //   1460: ifge -1424 -> 36
    //   1463: aload_0
    //   1464: invokestatic 319	com/tencent/mm/modelsfs/FileOp:deleteFile	(Ljava/lang/String;)Z
    //   1467: pop
    //   1468: aload_1
    //   1469: aload_0
    //   1470: invokestatic 263	com/tencent/mm/modelsfs/FileOp:r	(Ljava/lang/String;Ljava/lang/String;)J
    //   1473: lconst_0
    //   1474: lcmp
    //   1475: iflt +50 -> 1525
    //   1478: iconst_1
    //   1479: ireturn
    //   1480: sipush 640
    //   1483: istore_3
    //   1484: goto -343 -> 1141
    //   1487: sipush 960
    //   1490: istore 4
    //   1492: goto -333 -> 1159
    //   1495: aload 15
    //   1497: getfield 148	android/graphics/BitmapFactory$Options:outHeight	I
    //   1500: aload 15
    //   1502: getfield 145	android/graphics/BitmapFactory$Options:outWidth	I
    //   1505: idiv
    //   1506: istore_3
    //   1507: goto -226 -> 1281
    //   1510: iload_3
    //   1511: iload 7
    //   1513: imul
    //   1514: istore 8
    //   1516: iload_3
    //   1517: istore 4
    //   1519: iload 8
    //   1521: istore_3
    //   1522: goto -200 -> 1322
    //   1525: iconst_0
    //   1526: ireturn
    //   1527: astore_0
    //   1528: goto -966 -> 562
    //   1531: astore_0
    //   1532: goto -817 -> 715
    //   1535: astore_0
    //   1536: goto -809 -> 727
    //   1539: astore_0
    //   1540: goto -771 -> 769
    //   1543: astore_0
    //   1544: goto -762 -> 782
    //   1547: astore_1
    //   1548: aload 15
    //   1550: astore_0
    //   1551: goto -777 -> 774
    //   1554: astore_1
    //   1555: aload 15
    //   1557: astore_0
    //   1558: goto -784 -> 774
    //   1561: astore_1
    //   1562: goto -788 -> 774
    //   1565: astore_0
    //   1566: aload 15
    //   1568: astore 16
    //   1570: aload_0
    //   1571: astore 15
    //   1573: aload 16
    //   1575: astore_0
    //   1576: goto -843 -> 733
    //   1579: astore_0
    //   1580: aload 15
    //   1582: astore 16
    //   1584: aload_0
    //   1585: astore 15
    //   1587: aload 16
    //   1589: astore_0
    //   1590: goto -857 -> 733
    //   1593: iload_3
    //   1594: istore 7
    //   1596: iload 4
    //   1598: istore_3
    //   1599: iload 7
    //   1601: istore 4
    //   1603: goto -239 -> 1364
    //   1606: goto -1093 -> 513
    //   1609: bipush 70
    //   1611: istore 5
    //   1613: goto -1471 -> 142
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1616	0	paramString1	String
    //   0	1616	1	paramString2	String
    //   567	4	2	f	float
    //   117	1482	3	i	int
    //   106	1496	4	j	int
    //   140	1472	5	k	int
    //   143	1250	6	m	int
    //   148	1452	7	n	int
    //   1514	6	8	i1	int
    //   5	1453	9	i2	int
    //   34	1408	10	bool1	boolean
    //   96	1288	11	bool2	boolean
    //   1019	421	12	bool3	boolean
    //   598	849	13	l	long
    //   11	712	15	localObject1	Object
    //   729	838	15	localIOException	IOException
    //   1571	15	15	str	String
    //   49	353	16	localObject2	Object
    //   423	15	16	localException	Exception
    //   507	1081	16	localObject3	Object
    //   466	59	17	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   158	164	423	java/lang/Exception
    //   175	186	423	java/lang/Exception
    //   189	211	423	java/lang/Exception
    //   687	692	695	java/io/IOException
    //   473	479	729	java/io/IOException
    //   473	479	771	finally
    //   557	562	1527	java/io/IOException
    //   710	715	1531	java/io/IOException
    //   722	727	1535	java/io/IOException
    //   765	769	1539	java/io/IOException
    //   778	782	1543	java/io/IOException
    //   479	509	1547	finally
    //   513	547	1554	finally
    //   568	584	1554	finally
    //   594	636	1554	finally
    //   656	668	1554	finally
    //   733	761	1561	finally
    //   479	509	1565	java/io/IOException
    //   513	547	1579	java/io/IOException
    //   568	584	1579	java/io/IOException
    //   594	636	1579	java/io/IOException
    //   656	668	1579	java/io/IOException
  }
  
  public static String mz(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "up";
    case 1: 
      return "up";
    case 2: 
      return "up-mirrored";
    case 3: 
      return "down";
    case 4: 
      return "down-mirrored";
    case 5: 
      return "left-mirrored";
    case 6: 
      return "right";
    case 7: 
      return "right-mirrored";
    case 8: 
      return "left";
    }
    return "up";
  }
  
  public static int wF(String paramString)
  {
    if (!e.bK(paramString))
    {
      y.e("MicroMsg.AppBrandImgUtil", "getExifOriention err ");
      return 0;
    }
    try
    {
      int i = com.tencent.mm.plugin.appbrand.h.b.v(new FileInputStream(paramString));
      return i;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.AppBrandImgUtil", "getExifOrientation, path = %s, e = %s", new Object[] { paramString, localException });
    }
    return 0;
  }
  
  public static int x(InputStream paramInputStream)
  {
    try
    {
      int i = com.tencent.mm.plugin.appbrand.h.b.v(paramInputStream);
      return i;
    }
    catch (Exception paramInputStream)
    {
      y.e("MicroMsg.AppBrandImgUtil", "getExifOrientation with stream, e = %s", new Object[] { paramInputStream });
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.v.a
 * JD-Core Version:    0.7.0.1
 */