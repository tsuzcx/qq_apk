package com.tencent.mm.plugin.appbrand.utils;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.luggage.e.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.l;
import com.tencent.mm.plugin.performance.c.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.vfs.o;
import java.io.IOException;
import java.io.OutputStream;

public enum d
{
  private static boolean a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Bitmap.CompressFormat paramCompressFormat, int paramInt5, String paramString2)
  {
    AppMethodBeat.i(107815);
    localObject4 = null;
    localObject3 = localObject4;
    try
    {
      ae.i("MicroMsg.AppBrandImgUtil", "createThumbNailUnScale, srcWidth: %s, srcHeight: %s, width: %s, height: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt4), Integer.valueOf(paramInt3) });
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
        ae.printErrStackTrace("MicroMsg.AppBrandImgUtil", paramString1, "create thumbnail from orig failed: %s", new Object[] { paramString2 });
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
            ae.i("MicroMsg.AppBrandImgUtil", "createThumbNailUnScale, sampleSize: %s", new Object[] { Integer.valueOf(((BitmapFactory.Options)localObject2).inSampleSize) });
            localObject3 = localObject4;
            localObject2 = b(paramString1, (BitmapFactory.Options)localObject2);
            break;
            localObject3 = localObject4;
            ae.i("MicroMsg.AppBrandImgUtil", "createThumbNailUnScale, bm.width: %s, bm.height: %s", new Object[] { Integer.valueOf(((Bitmap)localObject2).getWidth()), Integer.valueOf(((Bitmap)localObject2).getHeight()) });
            if (d2 < d3)
            {
              localObject3 = localObject4;
              paramInt2 = (int)Math.ceil(paramInt4 * 1.0D * paramInt2 / paramInt1);
              paramInt1 = paramInt4;
            }
            for (;;)
            {
              localObject3 = localObject4;
              paramInt4 = BackwardSupportUtil.ExifHelper.df(paramString1);
              if ((paramInt4 != 90) && (paramInt4 != 270)) {
                break label644;
              }
              localObject3 = localObject4;
              localObject2 = h.a((Bitmap)localObject2, paramInt4);
              paramString1 = (String)localObject2;
              if (paramInt4 == 180)
              {
                localObject3 = localObject4;
                paramString1 = h.a((Bitmap)localObject2, paramInt4);
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
                l.ayS().D(paramString1);
                localObject2 = localBitmap;
              }
              localObject3 = localObject4;
              ae.i("MicroMsg.AppBrandImgUtil", "createThumbNailUnScalebyUpload, degree %d, bm.width: %s, bm.height: %s", new Object[] { Integer.valueOf(paramInt4), Integer.valueOf(((Bitmap)localObject2).getWidth()), Integer.valueOf(((Bitmap)localObject2).getHeight()) });
              localObject3 = localObject4;
              paramString1 = o.db(paramString2, false);
              localObject3 = paramString1;
              h.a((Bitmap)localObject2, paramInt5, paramCompressFormat, paramString1, false);
              localObject3 = paramString1;
              l.ayS().D((Bitmap)localObject2);
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
    ae.i("MicroMsg.AppBrandImgUtil", "createThumbNailUnScale, result bm: %s", new Object[] { localObject2 });
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
  
  private static boolean a(String paramString1, int paramInt1, int paramInt2, Bitmap.CompressFormat paramCompressFormat, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(107813);
    BitmapFactory.Options localOptions = h.aRz(paramString1);
    if ((localOptions == null) || (localOptions.outWidth <= 0) || (localOptions.outHeight <= 0))
    {
      AppMethodBeat.o(107813);
      return false;
    }
    boolean bool = a(paramString1, localOptions.outWidth, localOptions.outHeight, paramInt1, paramInt2, paramCompressFormat, paramInt3, paramString2);
    AppMethodBeat.o(107813);
    return bool;
  }
  
  private static Bitmap b(String paramString, BitmapFactory.Options paramOptions)
  {
    AppMethodBeat.i(107814);
    long l = System.currentTimeMillis();
    try
    {
      paramString = l.ayS().a(paramString, paramOptions);
      ae.d("MicroMsg.AppBrandImgUtil", "decodeWithRotateByExif used %dms bitmap: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), paramString });
      AppMethodBeat.o(107814);
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      ae.e("MicroMsg.AppBrandImgUtil", "%s", new Object[] { c.dCq().P(true, 0) });
      ae.e("MicroMsg.AppBrandImgUtil", "OutOfMemoryError e " + paramString.getMessage());
      AppMethodBeat.o(107814);
    }
    return null;
  }
  
  @Deprecated
  public static boolean d(BitmapFactory.Options paramOptions)
  {
    AppMethodBeat.i(107812);
    boolean bool = a.d(paramOptions);
    AppMethodBeat.o(107812);
    return bool;
  }
  
  public static boolean ev(String paramString1, String paramString2)
  {
    AppMethodBeat.i(107816);
    boolean bool = f(paramString1, paramString2, -1, -1);
    AppMethodBeat.o(107816);
    return bool;
  }
  
  /* Error */
  public static boolean f(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: ldc 214
    //   2: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: bipush 70
    //   7: istore 7
    //   9: aload_1
    //   10: invokestatic 218	com/tencent/mm/vfs/o:aZR	(Ljava/lang/String;)J
    //   13: l2i
    //   14: istore 10
    //   16: iload_2
    //   17: ifle +40 -> 57
    //   20: iload_3
    //   21: ifle +43 -> 64
    //   24: aload_1
    //   25: invokestatic 131	com/tencent/mm/sdk/platformtools/h:aRz	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   28: astore 15
    //   30: aload 15
    //   32: ifnonnull +39 -> 71
    //   35: ldc 25
    //   37: ldc 220
    //   39: iconst_1
    //   40: anewarray 29	java/lang/Object
    //   43: dup
    //   44: iconst_0
    //   45: aload_1
    //   46: aastore
    //   47: invokestatic 40	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   50: ldc 214
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
    //   73: ifnull +412 -> 485
    //   76: aload 15
    //   78: getfield 224	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   81: astore 16
    //   83: ldc 25
    //   85: ldc 226
    //   87: aload 16
    //   89: invokestatic 231	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   92: invokevirtual 235	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   95: invokestatic 237	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: aload 16
    //   100: ifnull +385 -> 485
    //   103: aload 16
    //   105: invokevirtual 240	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   108: astore 16
    //   110: aload 16
    //   112: ldc 242
    //   114: invokevirtual 245	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   117: iflt +334 -> 451
    //   120: iconst_1
    //   121: istore 11
    //   123: aload 15
    //   125: invokestatic 203	com/tencent/luggage/e/a/a:d	(Landroid/graphics/BitmapFactory$Options;)Z
    //   128: istore 12
    //   130: iconst_m1
    //   131: istore 6
    //   133: iload 12
    //   135: ifeq +1571 -> 1706
    //   138: aload_1
    //   139: invokestatic 250	com/tencent/mm/sdk/platformtools/MMNativeJpeg:queryQuality	(Ljava/lang/String;)I
    //   142: istore 5
    //   144: iload 5
    //   146: istore 6
    //   148: iload 5
    //   150: bipush 70
    //   152: if_icmpge +1554 -> 1706
    //   155: iload 5
    //   157: istore 6
    //   159: iload 5
    //   161: bipush 25
    //   163: if_icmple +1543 -> 1706
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
    //   193: invokestatic 256	com/tencent/mm/compatible/util/Exif:fromFile	(Ljava/lang/String;)Lcom/tencent/mm/compatible/util/Exif;
    //   196: astore 16
    //   198: iload 9
    //   200: istore 5
    //   202: aload 16
    //   204: ifnull +49 -> 253
    //   207: iload 7
    //   209: istore 5
    //   211: aload 16
    //   213: invokevirtual 259	com/tencent/mm/compatible/util/Exif:getOrientationInDegree	()I
    //   216: sipush 360
    //   219: irem
    //   220: istore 7
    //   222: iload 7
    //   224: istore 5
    //   226: ldc 25
    //   228: ldc_w 261
    //   231: iconst_1
    //   232: anewarray 29	java/lang/Object
    //   235: dup
    //   236: iconst_0
    //   237: aload 16
    //   239: invokevirtual 259	com/tencent/mm/compatible/util/Exif:getOrientationInDegree	()I
    //   242: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   245: aastore
    //   246: invokestatic 40	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   249: iload 7
    //   251: istore 5
    //   253: iload 5
    //   255: istore 7
    //   257: ldc 25
    //   259: new 177	java/lang/StringBuilder
    //   262: dup
    //   263: ldc_w 263
    //   266: invokespecial 182	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   269: aload 15
    //   271: getfield 134	android/graphics/BitmapFactory$Options:outWidth	I
    //   274: invokevirtual 266	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   277: ldc_w 268
    //   280: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: aload 15
    //   285: getfield 137	android/graphics/BitmapFactory$Options:outHeight	I
    //   288: invokevirtual 266	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   291: ldc_w 268
    //   294: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: iload 11
    //   299: invokevirtual 271	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   302: ldc_w 273
    //   305: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: iload 8
    //   310: invokevirtual 266	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   313: ldc_w 275
    //   316: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: iload 7
    //   321: invokevirtual 266	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   324: ldc_w 277
    //   327: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: iload 10
    //   332: invokevirtual 266	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   335: ldc_w 279
    //   338: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: iload_2
    //   342: invokevirtual 266	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   345: ldc_w 268
    //   348: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: iload_3
    //   352: invokevirtual 266	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   355: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: invokestatic 281	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   361: aload 15
    //   363: getfield 134	android/graphics/BitmapFactory$Options:outWidth	I
    //   366: aload 15
    //   368: getfield 137	android/graphics/BitmapFactory$Options:outHeight	I
    //   371: iconst_2
    //   372: imul
    //   373: if_icmpge +18 -> 391
    //   376: aload 15
    //   378: getfield 137	android/graphics/BitmapFactory$Options:outHeight	I
    //   381: aload 15
    //   383: getfield 134	android/graphics/BitmapFactory$Options:outWidth	I
    //   386: iconst_2
    //   387: imul
    //   388: if_icmplt +513 -> 901
    //   391: aload 15
    //   393: getfield 134	android/graphics/BitmapFactory$Options:outWidth	I
    //   396: aload 15
    //   398: getfield 137	android/graphics/BitmapFactory$Options:outHeight	I
    //   401: imul
    //   402: ldc_w 282
    //   405: if_icmpgt +496 -> 901
    //   408: iload 10
    //   410: ldc_w 283
    //   413: if_icmpge +120 -> 533
    //   416: iload 11
    //   418: ifeq +115 -> 533
    //   421: iload 7
    //   423: ifne +110 -> 533
    //   426: ldc 25
    //   428: ldc_w 285
    //   431: invokestatic 281	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   434: aload_1
    //   435: aload_0
    //   436: invokestatic 289	com/tencent/mm/vfs/o:mF	(Ljava/lang/String;Ljava/lang/String;)J
    //   439: lconst_0
    //   440: lcmp
    //   441: iflt +85 -> 526
    //   444: ldc 214
    //   446: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   449: iconst_1
    //   450: ireturn
    //   451: aload 16
    //   453: ldc_w 291
    //   456: invokevirtual 245	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   459: iflt +9 -> 468
    //   462: iconst_1
    //   463: istore 11
    //   465: goto -342 -> 123
    //   468: aload 16
    //   470: ldc_w 293
    //   473: invokevirtual 245	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   476: iflt +9 -> 485
    //   479: iconst_1
    //   480: istore 11
    //   482: goto -359 -> 123
    //   485: iconst_0
    //   486: istore 11
    //   488: goto -365 -> 123
    //   491: astore 16
    //   493: ldc 25
    //   495: new 177	java/lang/StringBuilder
    //   498: dup
    //   499: ldc_w 295
    //   502: invokespecial 182	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   505: aload 16
    //   507: invokevirtual 296	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   510: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   516: invokestatic 196	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   519: iload 5
    //   521: istore 7
    //   523: goto -266 -> 257
    //   526: ldc 214
    //   528: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   531: iconst_0
    //   532: ireturn
    //   533: new 42	android/graphics/BitmapFactory$Options
    //   536: dup
    //   537: invokespecial 45	android/graphics/BitmapFactory$Options:<init>	()V
    //   540: astore 18
    //   542: invokestatic 299	com/tencent/mm/sdk/platformtools/h:fnS	()V
    //   545: aconst_null
    //   546: astore 16
    //   548: aconst_null
    //   549: astore 15
    //   551: aload_1
    //   552: invokestatic 303	com/tencent/mm/vfs/o:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   555: astore 17
    //   557: aload 17
    //   559: astore 15
    //   561: aload 17
    //   563: astore 16
    //   565: aload 17
    //   567: ldc_w 304
    //   570: invokevirtual 309	java/io/InputStream:mark	(I)V
    //   573: aload 17
    //   575: astore 15
    //   577: aload 17
    //   579: astore 16
    //   581: aload 17
    //   583: aconst_null
    //   584: aload 18
    //   586: invokestatic 315	com/tencent/mm/graphics/MMBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   589: astore 18
    //   591: aload 17
    //   593: astore 15
    //   595: aload 17
    //   597: astore 16
    //   599: aload 17
    //   601: invokevirtual 318	java/io/InputStream:reset	()V
    //   604: aload 18
    //   606: ifnonnull +20 -> 626
    //   609: aload 17
    //   611: ifnull +8 -> 619
    //   614: aload 17
    //   616: invokevirtual 319	java/io/InputStream:close	()V
    //   619: ldc 214
    //   621: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   624: iconst_0
    //   625: ireturn
    //   626: iload 7
    //   628: i2f
    //   629: fstore 4
    //   631: aload 17
    //   633: astore 15
    //   635: aload 17
    //   637: astore 16
    //   639: aload 18
    //   641: fload 4
    //   643: invokestatic 100	com/tencent/mm/sdk/platformtools/h:a	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   646: iload 6
    //   648: getstatic 325	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   651: aload_0
    //   652: iconst_1
    //   653: invokestatic 328	com/tencent/mm/sdk/platformtools/h:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   656: pop
    //   657: iload 11
    //   659: ifeq +165 -> 824
    //   662: iload 7
    //   664: ifne +160 -> 824
    //   667: aload 17
    //   669: astore 15
    //   671: aload 17
    //   673: astore 16
    //   675: aload_0
    //   676: invokestatic 218	com/tencent/mm/vfs/o:aZR	(Ljava/lang/String;)J
    //   679: lstore 13
    //   681: aload 17
    //   683: astore 15
    //   685: aload 17
    //   687: astore 16
    //   689: ldc 25
    //   691: ldc_w 330
    //   694: iconst_3
    //   695: anewarray 29	java/lang/Object
    //   698: dup
    //   699: iconst_0
    //   700: iload 10
    //   702: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   705: aastore
    //   706: dup
    //   707: iconst_1
    //   708: lload 13
    //   710: invokestatic 157	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   713: aastore
    //   714: dup
    //   715: iconst_2
    //   716: bipush 10
    //   718: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   721: aastore
    //   722: invokestatic 40	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   725: iload 10
    //   727: i2l
    //   728: lload 13
    //   730: lsub
    //   731: ldc2_w 331
    //   734: lmul
    //   735: iload 10
    //   737: bipush 10
    //   739: imul
    //   740: i2l
    //   741: lcmp
    //   742: ifge +65 -> 807
    //   745: aload 17
    //   747: astore 15
    //   749: aload 17
    //   751: astore 16
    //   753: aload_0
    //   754: invokestatic 336	com/tencent/mm/vfs/o:deleteFile	(Ljava/lang/String;)Z
    //   757: pop
    //   758: aload 17
    //   760: astore 15
    //   762: aload 17
    //   764: astore 16
    //   766: aload_1
    //   767: aload_0
    //   768: invokestatic 289	com/tencent/mm/vfs/o:mF	(Ljava/lang/String;Ljava/lang/String;)J
    //   771: lstore 13
    //   773: lload 13
    //   775: lconst_0
    //   776: lcmp
    //   777: iflt +24 -> 801
    //   780: iconst_1
    //   781: istore 11
    //   783: aload 17
    //   785: ifnull +8 -> 793
    //   788: aload 17
    //   790: invokevirtual 319	java/io/InputStream:close	()V
    //   793: ldc 214
    //   795: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   798: iload 11
    //   800: ireturn
    //   801: iconst_0
    //   802: istore 11
    //   804: goto -21 -> 783
    //   807: aload 17
    //   809: ifnull +8 -> 817
    //   812: aload 17
    //   814: invokevirtual 319	java/io/InputStream:close	()V
    //   817: ldc 214
    //   819: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   822: iconst_1
    //   823: ireturn
    //   824: aload 17
    //   826: ifnull +8 -> 834
    //   829: aload 17
    //   831: invokevirtual 319	java/io/InputStream:close	()V
    //   834: ldc 214
    //   836: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   839: iconst_1
    //   840: ireturn
    //   841: astore_0
    //   842: aload 15
    //   844: astore 16
    //   846: ldc 25
    //   848: aload_0
    //   849: ldc_w 338
    //   852: aload_1
    //   853: invokestatic 231	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   856: invokevirtual 235	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   859: iconst_0
    //   860: anewarray 29	java/lang/Object
    //   863: invokestatic 65	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   866: aload 15
    //   868: ifnull +8 -> 876
    //   871: aload 15
    //   873: invokevirtual 319	java/io/InputStream:close	()V
    //   876: ldc 214
    //   878: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   881: iconst_0
    //   882: ireturn
    //   883: astore_0
    //   884: aload 16
    //   886: ifnull +8 -> 894
    //   889: aload 16
    //   891: invokevirtual 319	java/io/InputStream:close	()V
    //   894: ldc 214
    //   896: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   899: aload_0
    //   900: athrow
    //   901: iload 10
    //   903: ldc_w 339
    //   906: if_icmpge +45 -> 951
    //   909: iload 11
    //   911: ifeq +40 -> 951
    //   914: iload 7
    //   916: ifne +35 -> 951
    //   919: ldc 25
    //   921: ldc_w 341
    //   924: invokestatic 281	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   927: aload_1
    //   928: aload_0
    //   929: invokestatic 289	com/tencent/mm/vfs/o:mF	(Ljava/lang/String;Ljava/lang/String;)J
    //   932: lconst_0
    //   933: lcmp
    //   934: iflt +10 -> 944
    //   937: ldc 214
    //   939: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   942: iconst_1
    //   943: ireturn
    //   944: ldc 214
    //   946: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   949: iconst_0
    //   950: ireturn
    //   951: aload 15
    //   953: getfield 134	android/graphics/BitmapFactory$Options:outWidth	I
    //   956: iload_2
    //   957: if_icmpgt +12 -> 969
    //   960: aload 15
    //   962: getfield 137	android/graphics/BitmapFactory$Options:outHeight	I
    //   965: iload_3
    //   966: if_icmple +21 -> 987
    //   969: aload 15
    //   971: getfield 137	android/graphics/BitmapFactory$Options:outHeight	I
    //   974: iload_2
    //   975: if_icmpgt +301 -> 1276
    //   978: aload 15
    //   980: getfield 134	android/graphics/BitmapFactory$Options:outWidth	I
    //   983: iload_3
    //   984: if_icmpgt +292 -> 1276
    //   987: ldc 25
    //   989: ldc_w 343
    //   992: iconst_3
    //   993: anewarray 29	java/lang/Object
    //   996: dup
    //   997: iconst_0
    //   998: iload 10
    //   1000: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1003: aastore
    //   1004: dup
    //   1005: iconst_1
    //   1006: aload 15
    //   1008: getfield 134	android/graphics/BitmapFactory$Options:outWidth	I
    //   1011: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1014: aastore
    //   1015: dup
    //   1016: iconst_2
    //   1017: aload 15
    //   1019: getfield 137	android/graphics/BitmapFactory$Options:outHeight	I
    //   1022: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1025: aastore
    //   1026: invokestatic 40	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1029: aload_1
    //   1030: invokestatic 218	com/tencent/mm/vfs/o:aZR	(Ljava/lang/String;)J
    //   1033: ldc2_w 344
    //   1036: lcmp
    //   1037: ifge +100 -> 1137
    //   1040: iload 11
    //   1042: ifeq +43 -> 1085
    //   1045: ldc 25
    //   1047: ldc_w 347
    //   1050: iconst_1
    //   1051: anewarray 29	java/lang/Object
    //   1054: dup
    //   1055: iconst_0
    //   1056: aload_1
    //   1057: aastore
    //   1058: invokestatic 40	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1061: aload_1
    //   1062: aload_0
    //   1063: invokestatic 289	com/tencent/mm/vfs/o:mF	(Ljava/lang/String;Ljava/lang/String;)J
    //   1066: lconst_0
    //   1067: lcmp
    //   1068: iflt +10 -> 1078
    //   1071: ldc 214
    //   1073: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1076: iconst_1
    //   1077: ireturn
    //   1078: ldc 214
    //   1080: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1083: iconst_0
    //   1084: ireturn
    //   1085: aload 15
    //   1087: getfield 134	android/graphics/BitmapFactory$Options:outWidth	I
    //   1090: sipush 150
    //   1093: if_icmpge +44 -> 1137
    //   1096: aload 15
    //   1098: getfield 137	android/graphics/BitmapFactory$Options:outHeight	I
    //   1101: sipush 150
    //   1104: if_icmpge +33 -> 1137
    //   1107: aload_1
    //   1108: aload 15
    //   1110: getfield 137	android/graphics/BitmapFactory$Options:outHeight	I
    //   1113: aload 15
    //   1115: getfield 134	android/graphics/BitmapFactory$Options:outWidth	I
    //   1118: getstatic 350	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   1121: iload 6
    //   1123: aload_0
    //   1124: invokestatic 352	com/tencent/mm/plugin/appbrand/utils/d:a	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;)Z
    //   1127: istore 11
    //   1129: ldc 214
    //   1131: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1134: iload 11
    //   1136: ireturn
    //   1137: aload_1
    //   1138: aload 15
    //   1140: getfield 137	android/graphics/BitmapFactory$Options:outHeight	I
    //   1143: aload 15
    //   1145: getfield 134	android/graphics/BitmapFactory$Options:outWidth	I
    //   1148: getstatic 325	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   1151: iload 6
    //   1153: aload_0
    //   1154: invokestatic 352	com/tencent/mm/plugin/appbrand/utils/d:a	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;)Z
    //   1157: istore 12
    //   1159: iload 11
    //   1161: ifeq +107 -> 1268
    //   1164: iload 7
    //   1166: ifne +102 -> 1268
    //   1169: aload_0
    //   1170: invokestatic 218	com/tencent/mm/vfs/o:aZR	(Ljava/lang/String;)J
    //   1173: lstore 13
    //   1175: ldc 25
    //   1177: ldc_w 330
    //   1180: iconst_3
    //   1181: anewarray 29	java/lang/Object
    //   1184: dup
    //   1185: iconst_0
    //   1186: iload 10
    //   1188: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1191: aastore
    //   1192: dup
    //   1193: iconst_1
    //   1194: lload 13
    //   1196: invokestatic 157	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1199: aastore
    //   1200: dup
    //   1201: iconst_2
    //   1202: bipush 10
    //   1204: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1207: aastore
    //   1208: invokestatic 40	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1211: iload 10
    //   1213: i2l
    //   1214: lload 13
    //   1216: lsub
    //   1217: ldc2_w 331
    //   1220: lmul
    //   1221: iload 10
    //   1223: bipush 10
    //   1225: imul
    //   1226: i2l
    //   1227: lcmp
    //   1228: ifge +32 -> 1260
    //   1231: aload_0
    //   1232: invokestatic 336	com/tencent/mm/vfs/o:deleteFile	(Ljava/lang/String;)Z
    //   1235: pop
    //   1236: aload_1
    //   1237: aload_0
    //   1238: invokestatic 289	com/tencent/mm/vfs/o:mF	(Ljava/lang/String;Ljava/lang/String;)J
    //   1241: lconst_0
    //   1242: lcmp
    //   1243: iflt +10 -> 1253
    //   1246: ldc 214
    //   1248: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1251: iconst_1
    //   1252: ireturn
    //   1253: ldc 214
    //   1255: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1258: iconst_0
    //   1259: ireturn
    //   1260: ldc 214
    //   1262: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1265: iload 12
    //   1267: ireturn
    //   1268: ldc 214
    //   1270: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1273: iload 12
    //   1275: ireturn
    //   1276: aload 15
    //   1278: getfield 134	android/graphics/BitmapFactory$Options:outWidth	I
    //   1281: aload 15
    //   1283: getfield 137	android/graphics/BitmapFactory$Options:outHeight	I
    //   1286: if_icmplt +333 -> 1619
    //   1289: iload_2
    //   1290: istore 5
    //   1292: aload 15
    //   1294: getfield 134	android/graphics/BitmapFactory$Options:outWidth	I
    //   1297: aload 15
    //   1299: getfield 137	android/graphics/BitmapFactory$Options:outHeight	I
    //   1302: if_icmplt +323 -> 1625
    //   1305: aload 15
    //   1307: getfield 134	android/graphics/BitmapFactory$Options:outWidth	I
    //   1310: aload 15
    //   1312: getfield 137	android/graphics/BitmapFactory$Options:outHeight	I
    //   1315: iconst_2
    //   1316: imul
    //   1317: if_icmpge +18 -> 1335
    //   1320: aload 15
    //   1322: getfield 137	android/graphics/BitmapFactory$Options:outHeight	I
    //   1325: aload 15
    //   1327: getfield 134	android/graphics/BitmapFactory$Options:outWidth	I
    //   1330: iconst_2
    //   1331: imul
    //   1332: if_icmplt +366 -> 1698
    //   1335: ldc 25
    //   1337: new 177	java/lang/StringBuilder
    //   1340: dup
    //   1341: ldc_w 354
    //   1344: invokespecial 182	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1347: aload 15
    //   1349: getfield 134	android/graphics/BitmapFactory$Options:outWidth	I
    //   1352: invokevirtual 266	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1355: ldc_w 268
    //   1358: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1361: aload 15
    //   1363: getfield 137	android/graphics/BitmapFactory$Options:outHeight	I
    //   1366: invokevirtual 266	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1369: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1372: invokestatic 281	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1375: aload 15
    //   1377: getfield 137	android/graphics/BitmapFactory$Options:outHeight	I
    //   1380: ifgt +9 -> 1389
    //   1383: aload 15
    //   1385: iconst_1
    //   1386: putfield 137	android/graphics/BitmapFactory$Options:outHeight	I
    //   1389: aload 15
    //   1391: getfield 134	android/graphics/BitmapFactory$Options:outWidth	I
    //   1394: ifgt +9 -> 1403
    //   1397: aload 15
    //   1399: iconst_1
    //   1400: putfield 134	android/graphics/BitmapFactory$Options:outWidth	I
    //   1403: aload 15
    //   1405: getfield 134	android/graphics/BitmapFactory$Options:outWidth	I
    //   1408: aload 15
    //   1410: getfield 137	android/graphics/BitmapFactory$Options:outHeight	I
    //   1413: if_icmple +217 -> 1630
    //   1416: aload 15
    //   1418: getfield 134	android/graphics/BitmapFactory$Options:outWidth	I
    //   1421: aload 15
    //   1423: getfield 137	android/graphics/BitmapFactory$Options:outHeight	I
    //   1426: idiv
    //   1427: istore_2
    //   1428: iload_2
    //   1429: istore 5
    //   1431: iload_2
    //   1432: ifne +6 -> 1438
    //   1435: iconst_1
    //   1436: istore 5
    //   1438: ldc_w 282
    //   1441: iload 5
    //   1443: idiv
    //   1444: i2d
    //   1445: invokestatic 357	java/lang/Math:sqrt	(D)D
    //   1448: d2i
    //   1449: istore_2
    //   1450: aload 15
    //   1452: getfield 134	android/graphics/BitmapFactory$Options:outWidth	I
    //   1455: aload 15
    //   1457: getfield 137	android/graphics/BitmapFactory$Options:outHeight	I
    //   1460: if_icmple +185 -> 1645
    //   1463: iload_2
    //   1464: iload 5
    //   1466: imul
    //   1467: istore_3
    //   1468: ldc 25
    //   1470: new 177	java/lang/StringBuilder
    //   1473: dup
    //   1474: ldc_w 359
    //   1477: invokespecial 182	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1480: iload_3
    //   1481: invokevirtual 266	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1484: ldc_w 268
    //   1487: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1490: iload_2
    //   1491: invokevirtual 266	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1494: ldc_w 268
    //   1497: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1500: iload 5
    //   1502: invokevirtual 266	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1505: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1508: invokestatic 281	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1511: aload_1
    //   1512: iload_2
    //   1513: iload_3
    //   1514: getstatic 325	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   1517: iload 6
    //   1519: aload_0
    //   1520: invokestatic 352	com/tencent/mm/plugin/appbrand/utils/d:a	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;)Z
    //   1523: istore 12
    //   1525: iload 11
    //   1527: ifeq +139 -> 1666
    //   1530: iload 7
    //   1532: ifne +134 -> 1666
    //   1535: aload_0
    //   1536: invokestatic 218	com/tencent/mm/vfs/o:aZR	(Ljava/lang/String;)J
    //   1539: lstore 13
    //   1541: ldc 25
    //   1543: ldc_w 330
    //   1546: iconst_3
    //   1547: anewarray 29	java/lang/Object
    //   1550: dup
    //   1551: iconst_0
    //   1552: iload 10
    //   1554: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1557: aastore
    //   1558: dup
    //   1559: iconst_1
    //   1560: lload 13
    //   1562: invokestatic 157	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1565: aastore
    //   1566: dup
    //   1567: iconst_2
    //   1568: bipush 10
    //   1570: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1573: aastore
    //   1574: invokestatic 40	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1577: iload 10
    //   1579: i2l
    //   1580: lload 13
    //   1582: lsub
    //   1583: ldc2_w 331
    //   1586: lmul
    //   1587: iload 10
    //   1589: bipush 10
    //   1591: imul
    //   1592: i2l
    //   1593: lcmp
    //   1594: ifge +72 -> 1666
    //   1597: aload_0
    //   1598: invokestatic 336	com/tencent/mm/vfs/o:deleteFile	(Ljava/lang/String;)Z
    //   1601: pop
    //   1602: aload_1
    //   1603: aload_0
    //   1604: invokestatic 289	com/tencent/mm/vfs/o:mF	(Ljava/lang/String;Ljava/lang/String;)J
    //   1607: lconst_0
    //   1608: lcmp
    //   1609: iflt +50 -> 1659
    //   1612: ldc 214
    //   1614: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1617: iconst_1
    //   1618: ireturn
    //   1619: iload_3
    //   1620: istore 5
    //   1622: goto -330 -> 1292
    //   1625: iload_2
    //   1626: istore_3
    //   1627: goto -322 -> 1305
    //   1630: aload 15
    //   1632: getfield 137	android/graphics/BitmapFactory$Options:outHeight	I
    //   1635: aload 15
    //   1637: getfield 134	android/graphics/BitmapFactory$Options:outWidth	I
    //   1640: idiv
    //   1641: istore_2
    //   1642: goto -214 -> 1428
    //   1645: iload_2
    //   1646: iload 5
    //   1648: imul
    //   1649: istore 8
    //   1651: iload_2
    //   1652: istore_3
    //   1653: iload 8
    //   1655: istore_2
    //   1656: goto -188 -> 1468
    //   1659: ldc 214
    //   1661: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1664: iconst_0
    //   1665: ireturn
    //   1666: ldc 214
    //   1668: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1671: iload 12
    //   1673: ireturn
    //   1674: astore_0
    //   1675: goto -1056 -> 619
    //   1678: astore_0
    //   1679: goto -886 -> 793
    //   1682: astore_0
    //   1683: goto -866 -> 817
    //   1686: astore_0
    //   1687: goto -853 -> 834
    //   1690: astore_0
    //   1691: goto -815 -> 876
    //   1694: astore_1
    //   1695: goto -801 -> 894
    //   1698: iload_3
    //   1699: istore_2
    //   1700: iload 5
    //   1702: istore_3
    //   1703: goto -192 -> 1511
    //   1706: iload 6
    //   1708: istore 8
    //   1710: iload 7
    //   1712: istore 6
    //   1714: goto -1540 -> 174
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1717	0	paramString1	String
    //   0	1717	1	paramString2	String
    //   0	1717	2	paramInt1	int
    //   0	1717	3	paramInt2	int
    //   629	13	4	f	float
    //   142	1559	5	i	int
    //   131	1582	6	j	int
    //   7	1704	7	k	int
    //   168	1541	8	m	int
    //   181	18	9	n	int
    //   14	1578	10	i1	int
    //   121	1405	11	bool1	boolean
    //   128	1544	12	bool2	boolean
    //   679	902	13	l	long
    //   28	1608	15	localObject1	Object
    //   81	388	16	localObject2	Object
    //   491	15	16	localException	java.lang.Exception
    //   546	344	16	localObject3	Object
    //   555	275	17	localInputStream	java.io.InputStream
    //   540	100	18	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   192	198	491	java/lang/Exception
    //   211	222	491	java/lang/Exception
    //   226	249	491	java/lang/Exception
    //   551	557	841	java/io/IOException
    //   565	573	841	java/io/IOException
    //   581	591	841	java/io/IOException
    //   599	604	841	java/io/IOException
    //   639	657	841	java/io/IOException
    //   675	681	841	java/io/IOException
    //   689	725	841	java/io/IOException
    //   753	758	841	java/io/IOException
    //   766	773	841	java/io/IOException
    //   551	557	883	finally
    //   565	573	883	finally
    //   581	591	883	finally
    //   599	604	883	finally
    //   639	657	883	finally
    //   675	681	883	finally
    //   689	725	883	finally
    //   753	758	883	finally
    //   766	773	883	finally
    //   846	866	883	finally
    //   614	619	1674	java/io/IOException
    //   788	793	1678	java/io/IOException
    //   812	817	1682	java/io/IOException
    //   829	834	1686	java/io/IOException
    //   871	876	1690	java/io/IOException
    //   889	894	1694	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.d
 * JD-Core Version:    0.7.0.1
 */