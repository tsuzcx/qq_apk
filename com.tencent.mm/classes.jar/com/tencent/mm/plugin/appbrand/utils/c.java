package com.tencent.mm.plugin.appbrand.utils;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.luggage.e.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cj.b;
import com.tencent.mm.memory.l;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.vfs.i;
import java.io.IOException;
import java.io.OutputStream;

public enum c
{
  private static boolean a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Bitmap.CompressFormat paramCompressFormat, int paramInt5, String paramString2)
  {
    AppMethodBeat.i(107815);
    localObject4 = null;
    localObject3 = localObject4;
    try
    {
      ac.i("MicroMsg.AppBrandImgUtil", "createThumbNailUnScale, srcWidth: %s, srcHeight: %s, width: %s, height: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt4), Integer.valueOf(paramInt3) });
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
        ac.printErrStackTrace("MicroMsg.AppBrandImgUtil", paramString1, "create thumbnail from orig failed: %s", new Object[] { paramString2 });
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
            ac.i("MicroMsg.AppBrandImgUtil", "createThumbNailUnScale, sampleSize: %s", new Object[] { Integer.valueOf(((BitmapFactory.Options)localObject2).inSampleSize) });
            localObject3 = localObject4;
            localObject2 = b(paramString1, (BitmapFactory.Options)localObject2);
            break;
            localObject3 = localObject4;
            ac.i("MicroMsg.AppBrandImgUtil", "createThumbNailUnScale, bm.width: %s, bm.height: %s", new Object[] { Integer.valueOf(((Bitmap)localObject2).getWidth()), Integer.valueOf(((Bitmap)localObject2).getHeight()) });
            if (d2 < d3)
            {
              localObject3 = localObject4;
              paramInt2 = (int)Math.ceil(paramInt4 * 1.0D * paramInt2 / paramInt1);
              paramInt1 = paramInt4;
            }
            for (;;)
            {
              localObject3 = localObject4;
              paramInt4 = BackwardSupportUtil.ExifHelper.ce(paramString1);
              if ((paramInt4 != 90) && (paramInt4 != 270)) {
                break label619;
              }
              localObject3 = localObject4;
              paramString1 = f.a((Bitmap)localObject2, paramInt4);
              localObject3 = localObject4;
              Bitmap localBitmap = Bitmap.createScaledBitmap(paramString1, paramInt2, paramInt1, true);
              if (localBitmap == null) {
                break;
              }
              localObject2 = localBitmap;
              if (paramString1 != localBitmap)
              {
                localObject3 = localObject4;
                l.avQ().C(paramString1);
                localObject2 = localBitmap;
              }
              localObject3 = localObject4;
              ac.i("MicroMsg.AppBrandImgUtil", "createThumbNailUnScalebyUpload, degree %d, bm.width: %s, bm.height: %s", new Object[] { Integer.valueOf(paramInt4), Integer.valueOf(((Bitmap)localObject2).getWidth()), Integer.valueOf(((Bitmap)localObject2).getHeight()) });
              localObject3 = localObject4;
              paramString1 = i.cS(paramString2, false);
              localObject3 = paramString1;
              f.a((Bitmap)localObject2, paramInt5, paramCompressFormat, paramString1, false);
              localObject3 = paramString1;
              l.avQ().C((Bitmap)localObject2);
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
              paramString1 = (String)localObject2;
              paramInt1 = paramInt3;
            }
          }
        } while (d2 >= d3);
        double d1 = d3;
      }
    }
    localObject3 = localObject4;
    ac.i("MicroMsg.AppBrandImgUtil", "createThumbNailUnScale, result bm: %s", new Object[] { localObject2 });
    if (localObject2 == null)
    {
      AppMethodBeat.o(107815);
      return false;
      localObject3 = localObject4;
      ((BitmapFactory.Options)localObject2).inSampleSize = 1;
      if (paramInt2 > paramInt3) {
        break label631;
      }
      if (paramInt1 > paramInt4)
      {
        break label631;
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
    BitmapFactory.Options localOptions = f.aKw(paramString1);
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
      paramString = l.avQ().a(paramString, paramOptions);
      ac.d("MicroMsg.AppBrandImgUtil", "decodeWithRotateByExif used %dms bitmap: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), paramString });
      AppMethodBeat.o(107814);
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      b.fep();
      ac.e("MicroMsg.AppBrandImgUtil", "OutOfMemoryError e " + paramString.getMessage());
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
  
  public static boolean ej(String paramString1, String paramString2)
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
    //   0: ldc 205
    //   2: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: bipush 70
    //   7: istore 7
    //   9: aload_1
    //   10: invokestatic 209	com/tencent/mm/vfs/i:aSp	(Ljava/lang/String;)J
    //   13: l2i
    //   14: istore 10
    //   16: iload_2
    //   17: ifle +40 -> 57
    //   20: iload_3
    //   21: ifle +43 -> 64
    //   24: aload_1
    //   25: invokestatic 131	com/tencent/mm/sdk/platformtools/f:aKw	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
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
    //   47: invokestatic 40	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   95: invokestatic 228	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   125: invokestatic 194	com/tencent/luggage/e/a/a:d	(Landroid/graphics/BitmapFactory$Options;)Z
    //   128: istore 12
    //   130: iconst_m1
    //   131: istore 6
    //   133: iload 12
    //   135: ifeq +1569 -> 1704
    //   138: aload_1
    //   139: invokestatic 241	com/tencent/mm/sdk/platformtools/MMNativeJpeg:queryQuality	(Ljava/lang/String;)I
    //   142: istore 5
    //   144: iload 5
    //   146: istore 6
    //   148: iload 5
    //   150: bipush 70
    //   152: if_icmpge +1552 -> 1704
    //   155: iload 5
    //   157: istore 6
    //   159: iload 5
    //   161: bipush 25
    //   163: if_icmple +1541 -> 1704
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
    //   245: invokestatic 40	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   356: invokestatic 272	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   386: if_icmplt +513 -> 899
    //   389: aload 15
    //   391: getfield 134	android/graphics/BitmapFactory$Options:outWidth	I
    //   394: aload 15
    //   396: getfield 137	android/graphics/BitmapFactory$Options:outHeight	I
    //   399: imul
    //   400: ldc_w 273
    //   403: if_icmpgt +496 -> 899
    //   406: iload 10
    //   408: ldc_w 274
    //   411: if_icmpge +120 -> 531
    //   414: iload 11
    //   416: ifeq +115 -> 531
    //   419: iload 7
    //   421: ifne +110 -> 531
    //   424: ldc 25
    //   426: ldc_w 276
    //   429: invokestatic 272	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   432: aload_1
    //   433: aload_0
    //   434: invokestatic 280	com/tencent/mm/vfs/i:lZ	(Ljava/lang/String;Ljava/lang/String;)J
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
    //   514: invokestatic 187	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   538: astore 18
    //   540: invokestatic 290	com/tencent/mm/sdk/platformtools/f:eUu	()V
    //   543: aconst_null
    //   544: astore 16
    //   546: aconst_null
    //   547: astore 15
    //   549: aload_1
    //   550: invokestatic 294	com/tencent/mm/vfs/i:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   553: astore 17
    //   555: aload 17
    //   557: astore 15
    //   559: aload 17
    //   561: astore 16
    //   563: aload 17
    //   565: ldc_w 295
    //   568: invokevirtual 300	java/io/InputStream:mark	(I)V
    //   571: aload 17
    //   573: astore 15
    //   575: aload 17
    //   577: astore 16
    //   579: aload 17
    //   581: aconst_null
    //   582: aload 18
    //   584: invokestatic 306	com/tencent/mm/graphics/MMBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   587: astore 18
    //   589: aload 17
    //   591: astore 15
    //   593: aload 17
    //   595: astore 16
    //   597: aload 17
    //   599: invokevirtual 309	java/io/InputStream:reset	()V
    //   602: aload 18
    //   604: ifnonnull +20 -> 624
    //   607: aload 17
    //   609: ifnull +8 -> 617
    //   612: aload 17
    //   614: invokevirtual 310	java/io/InputStream:close	()V
    //   617: ldc 205
    //   619: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   622: iconst_0
    //   623: ireturn
    //   624: iload 7
    //   626: i2f
    //   627: fstore 4
    //   629: aload 17
    //   631: astore 15
    //   633: aload 17
    //   635: astore 16
    //   637: aload 18
    //   639: fload 4
    //   641: invokestatic 100	com/tencent/mm/sdk/platformtools/f:a	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   644: iload 6
    //   646: getstatic 316	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   649: aload_0
    //   650: iconst_1
    //   651: invokestatic 319	com/tencent/mm/sdk/platformtools/f:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   654: pop
    //   655: iload 11
    //   657: ifeq +165 -> 822
    //   660: iload 7
    //   662: ifne +160 -> 822
    //   665: aload 17
    //   667: astore 15
    //   669: aload 17
    //   671: astore 16
    //   673: aload_0
    //   674: invokestatic 209	com/tencent/mm/vfs/i:aSp	(Ljava/lang/String;)J
    //   677: lstore 13
    //   679: aload 17
    //   681: astore 15
    //   683: aload 17
    //   685: astore 16
    //   687: ldc 25
    //   689: ldc_w 321
    //   692: iconst_3
    //   693: anewarray 29	java/lang/Object
    //   696: dup
    //   697: iconst_0
    //   698: iload 10
    //   700: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   703: aastore
    //   704: dup
    //   705: iconst_1
    //   706: lload 13
    //   708: invokestatic 157	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   711: aastore
    //   712: dup
    //   713: iconst_2
    //   714: bipush 10
    //   716: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   719: aastore
    //   720: invokestatic 40	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   723: iload 10
    //   725: i2l
    //   726: lload 13
    //   728: lsub
    //   729: ldc2_w 322
    //   732: lmul
    //   733: iload 10
    //   735: bipush 10
    //   737: imul
    //   738: i2l
    //   739: lcmp
    //   740: ifge +65 -> 805
    //   743: aload 17
    //   745: astore 15
    //   747: aload 17
    //   749: astore 16
    //   751: aload_0
    //   752: invokestatic 327	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   755: pop
    //   756: aload 17
    //   758: astore 15
    //   760: aload 17
    //   762: astore 16
    //   764: aload_1
    //   765: aload_0
    //   766: invokestatic 280	com/tencent/mm/vfs/i:lZ	(Ljava/lang/String;Ljava/lang/String;)J
    //   769: lstore 13
    //   771: lload 13
    //   773: lconst_0
    //   774: lcmp
    //   775: iflt +24 -> 799
    //   778: iconst_1
    //   779: istore 11
    //   781: aload 17
    //   783: ifnull +8 -> 791
    //   786: aload 17
    //   788: invokevirtual 310	java/io/InputStream:close	()V
    //   791: ldc 205
    //   793: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   796: iload 11
    //   798: ireturn
    //   799: iconst_0
    //   800: istore 11
    //   802: goto -21 -> 781
    //   805: aload 17
    //   807: ifnull +8 -> 815
    //   810: aload 17
    //   812: invokevirtual 310	java/io/InputStream:close	()V
    //   815: ldc 205
    //   817: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   820: iconst_1
    //   821: ireturn
    //   822: aload 17
    //   824: ifnull +8 -> 832
    //   827: aload 17
    //   829: invokevirtual 310	java/io/InputStream:close	()V
    //   832: ldc 205
    //   834: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   837: iconst_1
    //   838: ireturn
    //   839: astore_0
    //   840: aload 15
    //   842: astore 16
    //   844: ldc 25
    //   846: aload_0
    //   847: ldc_w 329
    //   850: aload_1
    //   851: invokestatic 222	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   854: invokevirtual 226	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   857: iconst_0
    //   858: anewarray 29	java/lang/Object
    //   861: invokestatic 65	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   864: aload 15
    //   866: ifnull +8 -> 874
    //   869: aload 15
    //   871: invokevirtual 310	java/io/InputStream:close	()V
    //   874: ldc 205
    //   876: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   879: iconst_0
    //   880: ireturn
    //   881: astore_0
    //   882: aload 16
    //   884: ifnull +8 -> 892
    //   887: aload 16
    //   889: invokevirtual 310	java/io/InputStream:close	()V
    //   892: ldc 205
    //   894: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   897: aload_0
    //   898: athrow
    //   899: iload 10
    //   901: ldc_w 330
    //   904: if_icmpge +45 -> 949
    //   907: iload 11
    //   909: ifeq +40 -> 949
    //   912: iload 7
    //   914: ifne +35 -> 949
    //   917: ldc 25
    //   919: ldc_w 332
    //   922: invokestatic 272	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   925: aload_1
    //   926: aload_0
    //   927: invokestatic 280	com/tencent/mm/vfs/i:lZ	(Ljava/lang/String;Ljava/lang/String;)J
    //   930: lconst_0
    //   931: lcmp
    //   932: iflt +10 -> 942
    //   935: ldc 205
    //   937: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   940: iconst_1
    //   941: ireturn
    //   942: ldc 205
    //   944: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   947: iconst_0
    //   948: ireturn
    //   949: aload 15
    //   951: getfield 134	android/graphics/BitmapFactory$Options:outWidth	I
    //   954: iload_2
    //   955: if_icmpgt +12 -> 967
    //   958: aload 15
    //   960: getfield 137	android/graphics/BitmapFactory$Options:outHeight	I
    //   963: iload_3
    //   964: if_icmple +21 -> 985
    //   967: aload 15
    //   969: getfield 137	android/graphics/BitmapFactory$Options:outHeight	I
    //   972: iload_2
    //   973: if_icmpgt +301 -> 1274
    //   976: aload 15
    //   978: getfield 134	android/graphics/BitmapFactory$Options:outWidth	I
    //   981: iload_3
    //   982: if_icmpgt +292 -> 1274
    //   985: ldc 25
    //   987: ldc_w 334
    //   990: iconst_3
    //   991: anewarray 29	java/lang/Object
    //   994: dup
    //   995: iconst_0
    //   996: iload 10
    //   998: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1001: aastore
    //   1002: dup
    //   1003: iconst_1
    //   1004: aload 15
    //   1006: getfield 134	android/graphics/BitmapFactory$Options:outWidth	I
    //   1009: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1012: aastore
    //   1013: dup
    //   1014: iconst_2
    //   1015: aload 15
    //   1017: getfield 137	android/graphics/BitmapFactory$Options:outHeight	I
    //   1020: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1023: aastore
    //   1024: invokestatic 40	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1027: aload_1
    //   1028: invokestatic 209	com/tencent/mm/vfs/i:aSp	(Ljava/lang/String;)J
    //   1031: ldc2_w 335
    //   1034: lcmp
    //   1035: ifge +100 -> 1135
    //   1038: iload 11
    //   1040: ifeq +43 -> 1083
    //   1043: ldc 25
    //   1045: ldc_w 338
    //   1048: iconst_1
    //   1049: anewarray 29	java/lang/Object
    //   1052: dup
    //   1053: iconst_0
    //   1054: aload_1
    //   1055: aastore
    //   1056: invokestatic 40	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1059: aload_1
    //   1060: aload_0
    //   1061: invokestatic 280	com/tencent/mm/vfs/i:lZ	(Ljava/lang/String;Ljava/lang/String;)J
    //   1064: lconst_0
    //   1065: lcmp
    //   1066: iflt +10 -> 1076
    //   1069: ldc 205
    //   1071: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1074: iconst_1
    //   1075: ireturn
    //   1076: ldc 205
    //   1078: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1081: iconst_0
    //   1082: ireturn
    //   1083: aload 15
    //   1085: getfield 134	android/graphics/BitmapFactory$Options:outWidth	I
    //   1088: sipush 150
    //   1091: if_icmpge +44 -> 1135
    //   1094: aload 15
    //   1096: getfield 137	android/graphics/BitmapFactory$Options:outHeight	I
    //   1099: sipush 150
    //   1102: if_icmpge +33 -> 1135
    //   1105: aload_1
    //   1106: aload 15
    //   1108: getfield 137	android/graphics/BitmapFactory$Options:outHeight	I
    //   1111: aload 15
    //   1113: getfield 134	android/graphics/BitmapFactory$Options:outWidth	I
    //   1116: getstatic 341	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   1119: iload 6
    //   1121: aload_0
    //   1122: invokestatic 343	com/tencent/mm/plugin/appbrand/utils/c:a	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;)Z
    //   1125: istore 11
    //   1127: ldc 205
    //   1129: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1132: iload 11
    //   1134: ireturn
    //   1135: aload_1
    //   1136: aload 15
    //   1138: getfield 137	android/graphics/BitmapFactory$Options:outHeight	I
    //   1141: aload 15
    //   1143: getfield 134	android/graphics/BitmapFactory$Options:outWidth	I
    //   1146: getstatic 316	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   1149: iload 6
    //   1151: aload_0
    //   1152: invokestatic 343	com/tencent/mm/plugin/appbrand/utils/c:a	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;)Z
    //   1155: istore 12
    //   1157: iload 11
    //   1159: ifeq +107 -> 1266
    //   1162: iload 7
    //   1164: ifne +102 -> 1266
    //   1167: aload_0
    //   1168: invokestatic 209	com/tencent/mm/vfs/i:aSp	(Ljava/lang/String;)J
    //   1171: lstore 13
    //   1173: ldc 25
    //   1175: ldc_w 321
    //   1178: iconst_3
    //   1179: anewarray 29	java/lang/Object
    //   1182: dup
    //   1183: iconst_0
    //   1184: iload 10
    //   1186: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1189: aastore
    //   1190: dup
    //   1191: iconst_1
    //   1192: lload 13
    //   1194: invokestatic 157	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1197: aastore
    //   1198: dup
    //   1199: iconst_2
    //   1200: bipush 10
    //   1202: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1205: aastore
    //   1206: invokestatic 40	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1209: iload 10
    //   1211: i2l
    //   1212: lload 13
    //   1214: lsub
    //   1215: ldc2_w 322
    //   1218: lmul
    //   1219: iload 10
    //   1221: bipush 10
    //   1223: imul
    //   1224: i2l
    //   1225: lcmp
    //   1226: ifge +32 -> 1258
    //   1229: aload_0
    //   1230: invokestatic 327	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   1233: pop
    //   1234: aload_1
    //   1235: aload_0
    //   1236: invokestatic 280	com/tencent/mm/vfs/i:lZ	(Ljava/lang/String;Ljava/lang/String;)J
    //   1239: lconst_0
    //   1240: lcmp
    //   1241: iflt +10 -> 1251
    //   1244: ldc 205
    //   1246: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1249: iconst_1
    //   1250: ireturn
    //   1251: ldc 205
    //   1253: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1256: iconst_0
    //   1257: ireturn
    //   1258: ldc 205
    //   1260: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1263: iload 12
    //   1265: ireturn
    //   1266: ldc 205
    //   1268: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1271: iload 12
    //   1273: ireturn
    //   1274: aload 15
    //   1276: getfield 134	android/graphics/BitmapFactory$Options:outWidth	I
    //   1279: aload 15
    //   1281: getfield 137	android/graphics/BitmapFactory$Options:outHeight	I
    //   1284: if_icmplt +333 -> 1617
    //   1287: iload_2
    //   1288: istore 5
    //   1290: aload 15
    //   1292: getfield 134	android/graphics/BitmapFactory$Options:outWidth	I
    //   1295: aload 15
    //   1297: getfield 137	android/graphics/BitmapFactory$Options:outHeight	I
    //   1300: if_icmplt +323 -> 1623
    //   1303: aload 15
    //   1305: getfield 134	android/graphics/BitmapFactory$Options:outWidth	I
    //   1308: aload 15
    //   1310: getfield 137	android/graphics/BitmapFactory$Options:outHeight	I
    //   1313: iconst_2
    //   1314: imul
    //   1315: if_icmpge +18 -> 1333
    //   1318: aload 15
    //   1320: getfield 137	android/graphics/BitmapFactory$Options:outHeight	I
    //   1323: aload 15
    //   1325: getfield 134	android/graphics/BitmapFactory$Options:outWidth	I
    //   1328: iconst_2
    //   1329: imul
    //   1330: if_icmplt +366 -> 1696
    //   1333: ldc 25
    //   1335: new 167	java/lang/StringBuilder
    //   1338: dup
    //   1339: ldc_w 345
    //   1342: invokespecial 172	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1345: aload 15
    //   1347: getfield 134	android/graphics/BitmapFactory$Options:outWidth	I
    //   1350: invokevirtual 257	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1353: ldc_w 259
    //   1356: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1359: aload 15
    //   1361: getfield 137	android/graphics/BitmapFactory$Options:outHeight	I
    //   1364: invokevirtual 257	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1367: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1370: invokestatic 272	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1373: aload 15
    //   1375: getfield 137	android/graphics/BitmapFactory$Options:outHeight	I
    //   1378: ifgt +9 -> 1387
    //   1381: aload 15
    //   1383: iconst_1
    //   1384: putfield 137	android/graphics/BitmapFactory$Options:outHeight	I
    //   1387: aload 15
    //   1389: getfield 134	android/graphics/BitmapFactory$Options:outWidth	I
    //   1392: ifgt +9 -> 1401
    //   1395: aload 15
    //   1397: iconst_1
    //   1398: putfield 134	android/graphics/BitmapFactory$Options:outWidth	I
    //   1401: aload 15
    //   1403: getfield 134	android/graphics/BitmapFactory$Options:outWidth	I
    //   1406: aload 15
    //   1408: getfield 137	android/graphics/BitmapFactory$Options:outHeight	I
    //   1411: if_icmple +217 -> 1628
    //   1414: aload 15
    //   1416: getfield 134	android/graphics/BitmapFactory$Options:outWidth	I
    //   1419: aload 15
    //   1421: getfield 137	android/graphics/BitmapFactory$Options:outHeight	I
    //   1424: idiv
    //   1425: istore_2
    //   1426: iload_2
    //   1427: istore 5
    //   1429: iload_2
    //   1430: ifne +6 -> 1436
    //   1433: iconst_1
    //   1434: istore 5
    //   1436: ldc_w 273
    //   1439: iload 5
    //   1441: idiv
    //   1442: i2d
    //   1443: invokestatic 348	java/lang/Math:sqrt	(D)D
    //   1446: d2i
    //   1447: istore_2
    //   1448: aload 15
    //   1450: getfield 134	android/graphics/BitmapFactory$Options:outWidth	I
    //   1453: aload 15
    //   1455: getfield 137	android/graphics/BitmapFactory$Options:outHeight	I
    //   1458: if_icmple +185 -> 1643
    //   1461: iload_2
    //   1462: iload 5
    //   1464: imul
    //   1465: istore_3
    //   1466: ldc 25
    //   1468: new 167	java/lang/StringBuilder
    //   1471: dup
    //   1472: ldc_w 350
    //   1475: invokespecial 172	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1478: iload_3
    //   1479: invokevirtual 257	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1482: ldc_w 259
    //   1485: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1488: iload_2
    //   1489: invokevirtual 257	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1492: ldc_w 259
    //   1495: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1498: iload 5
    //   1500: invokevirtual 257	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1503: invokevirtual 183	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1506: invokestatic 272	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1509: aload_1
    //   1510: iload_2
    //   1511: iload_3
    //   1512: getstatic 316	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   1515: iload 6
    //   1517: aload_0
    //   1518: invokestatic 343	com/tencent/mm/plugin/appbrand/utils/c:a	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;)Z
    //   1521: istore 12
    //   1523: iload 11
    //   1525: ifeq +139 -> 1664
    //   1528: iload 7
    //   1530: ifne +134 -> 1664
    //   1533: aload_0
    //   1534: invokestatic 209	com/tencent/mm/vfs/i:aSp	(Ljava/lang/String;)J
    //   1537: lstore 13
    //   1539: ldc 25
    //   1541: ldc_w 321
    //   1544: iconst_3
    //   1545: anewarray 29	java/lang/Object
    //   1548: dup
    //   1549: iconst_0
    //   1550: iload 10
    //   1552: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1555: aastore
    //   1556: dup
    //   1557: iconst_1
    //   1558: lload 13
    //   1560: invokestatic 157	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1563: aastore
    //   1564: dup
    //   1565: iconst_2
    //   1566: bipush 10
    //   1568: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1571: aastore
    //   1572: invokestatic 40	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1575: iload 10
    //   1577: i2l
    //   1578: lload 13
    //   1580: lsub
    //   1581: ldc2_w 322
    //   1584: lmul
    //   1585: iload 10
    //   1587: bipush 10
    //   1589: imul
    //   1590: i2l
    //   1591: lcmp
    //   1592: ifge +72 -> 1664
    //   1595: aload_0
    //   1596: invokestatic 327	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   1599: pop
    //   1600: aload_1
    //   1601: aload_0
    //   1602: invokestatic 280	com/tencent/mm/vfs/i:lZ	(Ljava/lang/String;Ljava/lang/String;)J
    //   1605: lconst_0
    //   1606: lcmp
    //   1607: iflt +50 -> 1657
    //   1610: ldc 205
    //   1612: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1615: iconst_1
    //   1616: ireturn
    //   1617: iload_3
    //   1618: istore 5
    //   1620: goto -330 -> 1290
    //   1623: iload_2
    //   1624: istore_3
    //   1625: goto -322 -> 1303
    //   1628: aload 15
    //   1630: getfield 137	android/graphics/BitmapFactory$Options:outHeight	I
    //   1633: aload 15
    //   1635: getfield 134	android/graphics/BitmapFactory$Options:outWidth	I
    //   1638: idiv
    //   1639: istore_2
    //   1640: goto -214 -> 1426
    //   1643: iload_2
    //   1644: iload 5
    //   1646: imul
    //   1647: istore 8
    //   1649: iload_2
    //   1650: istore_3
    //   1651: iload 8
    //   1653: istore_2
    //   1654: goto -188 -> 1466
    //   1657: ldc 205
    //   1659: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1662: iconst_0
    //   1663: ireturn
    //   1664: ldc 205
    //   1666: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1669: iload 12
    //   1671: ireturn
    //   1672: astore_0
    //   1673: goto -1056 -> 617
    //   1676: astore_0
    //   1677: goto -886 -> 791
    //   1680: astore_0
    //   1681: goto -866 -> 815
    //   1684: astore_0
    //   1685: goto -853 -> 832
    //   1688: astore_0
    //   1689: goto -815 -> 874
    //   1692: astore_1
    //   1693: goto -801 -> 892
    //   1696: iload_3
    //   1697: istore_2
    //   1698: iload 5
    //   1700: istore_3
    //   1701: goto -192 -> 1509
    //   1704: iload 6
    //   1706: istore 8
    //   1708: iload 7
    //   1710: istore 6
    //   1712: goto -1538 -> 174
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1715	0	paramString1	String
    //   0	1715	1	paramString2	String
    //   0	1715	2	paramInt1	int
    //   0	1715	3	paramInt2	int
    //   627	13	4	f	float
    //   142	1557	5	i	int
    //   131	1580	6	j	int
    //   7	1702	7	k	int
    //   168	1539	8	m	int
    //   181	18	9	n	int
    //   14	1576	10	i1	int
    //   121	1403	11	bool1	boolean
    //   128	1542	12	bool2	boolean
    //   677	902	13	l	long
    //   28	1606	15	localObject1	Object
    //   81	386	16	localObject2	Object
    //   489	15	16	localException	java.lang.Exception
    //   544	344	16	localObject3	Object
    //   553	275	17	localInputStream	java.io.InputStream
    //   538	100	18	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   192	198	489	java/lang/Exception
    //   211	222	489	java/lang/Exception
    //   226	248	489	java/lang/Exception
    //   549	555	839	java/io/IOException
    //   563	571	839	java/io/IOException
    //   579	589	839	java/io/IOException
    //   597	602	839	java/io/IOException
    //   637	655	839	java/io/IOException
    //   673	679	839	java/io/IOException
    //   687	723	839	java/io/IOException
    //   751	756	839	java/io/IOException
    //   764	771	839	java/io/IOException
    //   549	555	881	finally
    //   563	571	881	finally
    //   579	589	881	finally
    //   597	602	881	finally
    //   637	655	881	finally
    //   673	679	881	finally
    //   687	723	881	finally
    //   751	756	881	finally
    //   764	771	881	finally
    //   844	864	881	finally
    //   612	617	1672	java/io/IOException
    //   786	791	1676	java/io/IOException
    //   810	815	1680	java/io/IOException
    //   827	832	1684	java/io/IOException
    //   869	874	1688	java/io/IOException
    //   887	892	1692	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.c
 * JD-Core Version:    0.7.0.1
 */