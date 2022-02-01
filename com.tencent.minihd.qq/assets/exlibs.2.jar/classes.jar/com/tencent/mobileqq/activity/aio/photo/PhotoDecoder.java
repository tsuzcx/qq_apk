package com.tencent.mobileqq.activity.aio.photo;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.ExifInterface;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import com.tencent.image.DownloadParams;
import com.tencent.image.LocaleFileDownloader;
import com.tencent.image.SliceBitmap;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.pic.JpegDecompressor;
import com.tencent.mobileqq.pic.JpegOptions;
import com.tencent.mobileqq.pic.compress.Utils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class PhotoDecoder
  extends LocaleFileDownloader
{
  private static final float a = 1.5F;
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  private static final int d = 5242880;
  private float b;
  
  public PhotoDecoder(Resources paramResources)
  {
    this.b = paramResources.getDisplayMetrics().density;
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if ((paramInt6 == 2) || (paramInt3 == 2147483647) || (paramInt4 == 2147483647))
    {
      paramInt2 = 1;
      return paramInt2;
    }
    float f;
    if (paramInt6 == 1) {
      switch (paramInt5)
      {
      default: 
        paramInt5 = paramInt2;
        paramInt2 = paramInt1;
        paramInt1 = paramInt5;
        paramInt6 = paramInt1;
        paramInt5 = paramInt2;
        if (paramInt2 > paramInt3 * 2)
        {
          paramInt6 = paramInt1;
          paramInt5 = paramInt2;
          if (paramInt1 > paramInt4)
          {
            paramInt5 = (int)(paramInt2 * this.b + 0.5D);
            paramInt6 = (int)(paramInt1 * this.b + 0.5D);
          }
        }
        paramInt1 = paramInt6 * paramInt3 / paramInt5;
        if (paramInt5 >= paramInt3) {
          if (paramInt4 >= paramInt1) {
            f = paramInt3 / paramInt5;
          }
        }
        break;
      }
    }
    for (;;)
    {
      label151:
      if (this.b > 2.0F) {}
      for (paramInt1 = (int)(1.0F / f * 3.0F / 4.0F);; paramInt1 = (int)(1.0F / f))
      {
        if (paramInt1 > 1) {
          break label319;
        }
        return 1;
        break;
        if (paramInt4 * 1.5F >= paramInt1)
        {
          f = paramInt4 / paramInt6;
          break label151;
        }
        f = paramInt3 / paramInt5;
        break label151;
        if (paramInt6 < paramInt4)
        {
          if (paramInt4 >= paramInt1)
          {
            if (paramInt5 * 1.5F < paramInt3) {
              break label481;
            }
            f = paramInt3 / paramInt5;
            break label151;
          }
          if (paramInt6 * 1.5F < paramInt4) {
            break label481;
          }
          f = paramInt4 / paramInt6;
          break label151;
        }
        if ((paramInt6 <= paramInt4) || (paramInt6 >= paramInt4 * 1.5F)) {
          break label481;
        }
        f = paramInt4 / paramInt6;
        break label151;
      }
      label319:
      if (paramInt1 > 64)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PEAK", 2, "the pic it fxxking large.....");
        }
        return 64;
      }
      paramInt3 = 64;
      for (;;)
      {
        if (paramInt3 == 0) {
          break label369;
        }
        paramInt4 = paramInt1 & paramInt3;
        paramInt2 = paramInt4;
        if (paramInt4 != 0) {
          break;
        }
        paramInt3 >>= 1;
      }
      label369:
      return 1;
      if ((paramInt3 == 0) || (paramInt4 == 0) || (paramInt3 == -1) || (paramInt4 == -1)) {
        return 1;
      }
      int i = 1;
      paramInt5 = paramInt2;
      paramInt6 = paramInt1;
      paramInt1 = i;
      label405:
      if (paramInt5 <= paramInt4)
      {
        paramInt2 = paramInt1;
        if (paramInt6 <= paramInt3) {
          break;
        }
      }
      i = Math.round(paramInt5 / paramInt4);
      paramInt2 = Math.round(paramInt6 / paramInt3);
      if (i > paramInt2) {}
      for (;;)
      {
        paramInt2 = paramInt1;
        if (i < 2) {
          break;
        }
        paramInt6 /= 2;
        paramInt5 /= 2;
        paramInt1 *= 2;
        break label405;
        i = paramInt2;
      }
      label481:
      f = 1.0F;
    }
  }
  
  private Object a(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler, int paramInt)
  {
    localFileInputStream = new FileInputStream(paramFile);
    j = 0;
    try
    {
      l1 = SystemClock.uptimeMillis();
      localObject = new byte[2];
      localFileInputStream.read((byte[])localObject);
      int m = localObject[0];
      int n = localObject[1];
      paramURLDrawableHandler = Bitmap.Config.ARGB_8888;
      i = 0;
      k = 0;
      switch (m << 8 & 0xFF00 | n & 0xFF)
      {
      }
    }
    finally
    {
      for (;;)
      {
        long l1;
        Object localObject;
        int k;
        byte[] arrayOfByte;
        paramInt = j;
        continue;
        int i = k;
      }
    }
    arrayOfByte = new byte[(int)paramFile.length()];
    System.arraycopy(localObject, 0, arrayOfByte, 0, localObject.length);
    localFileInputStream.read(arrayOfByte, localObject.length, localFileInputStream.available());
    localFileInputStream.close();
    for (;;)
    {
      try
      {
        for (;;)
        {
          long l2;
          if (QLog.isColorLevel())
          {
            l2 = SystemClock.uptimeMillis();
            QLog.d("PEAK", 2, "read file to memory cost: " + (l2 - l1));
          }
          l1 = SystemClock.uptimeMillis();
          BitmapFactory.Options localOptions = new BitmapFactory.Options();
          localOptions.inJustDecodeBounds = true;
          localOptions.inPreferredConfig = paramURLDrawableHandler;
          localOptions.inDensity = 160;
          localOptions.inTargetDensity = 160;
          localOptions.inScreenDensity = 160;
          localOptions.inPurgeable = true;
          localOptions.inInputShareable = true;
          BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, localOptions);
          j = localOptions.outWidth;
          k = localOptions.outHeight;
          if (i != 0) {
            paramDownloadParams.outOrientation = new ExifInterface(paramFile.getAbsolutePath()).getAttributeInt("Orientation", 1);
          }
          if (QLog.isColorLevel())
          {
            l2 = SystemClock.uptimeMillis();
            QLog.d("PEAK", 2, "read size & exif cost: " + (l2 - l1));
          }
          localOptions.inJustDecodeBounds = false;
          paramInt = a(j, k, paramDownloadParams.reqWidth, paramDownloadParams.reqHeight, paramDownloadParams.outOrientation, paramInt);
          try
          {
            localOptions.inSampleSize = paramInt;
            paramURLDrawableHandler = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, localOptions);
            paramURLDrawableHandler.setDensity(160);
            if (Build.VERSION.SDK_INT < 11) {
              break label768;
            }
            boolean bool = SliceBitmap.needSlice(paramURLDrawableHandler);
            if (!bool) {
              break label768;
            }
            try
            {
              localObject = new SliceBitmap(paramURLDrawableHandler);
              paramURLDrawableHandler.recycle();
              paramURLDrawableHandler = (URLDrawableHandler)localObject;
              if (localOptions.inSampleSize > 1)
              {
                if (!paramDownloadParams.mAutoScaleByDensity) {
                  break label712;
                }
                paramDownloadParams.outWidth = ((int)Math.ceil(j * this.b));
                paramDownloadParams.outHeight = ((int)Math.ceil(k * this.b));
              }
              if (QLog.isColorLevel()) {
                QLog.d("PEAK", 2, "image file size:" + paramFile.length() + " , bound:" + j + "x" + k + " , sampleSize: " + localOptions.inSampleSize);
              }
              return paramURLDrawableHandler;
            }
            catch (Exception localException)
            {
              if (paramURLDrawableHandler == null) {
                break label602;
              }
              paramURLDrawableHandler.recycle();
              throw new OutOfMemoryError("slice failed.");
            }
            i = 1;
            paramURLDrawableHandler = Bitmap.Config.RGB_565;
          }
          catch (OutOfMemoryError paramURLDrawableHandler)
          {
            label602:
            if (!QLog.isColorLevel()) {
              break label681;
            }
            QLog.d("PEAK", 2, "DecodeFile ERROR,oom retryCount=" + 1 + ",options.inSampleSize=" + localOptions.inSampleSize + ",url=" + paramDownloadParams.urlStr + ",oom.msg:" + paramURLDrawableHandler.getMessage());
            label681:
            i = paramInt * 2;
            System.gc();
            Thread.yield();
            System.gc();
            paramInt = i;
          }
        }
        localFileInputStream.close();
        return null;
      }
      finally
      {
        label712:
        paramInt = 1;
        if (paramInt != 0) {
          continue;
        }
        localFileInputStream.close();
      }
      if (i <= 8)
      {
        paramURLDrawableHandler = null;
        continue;
        paramDownloadParams.outWidth = ((int)Math.ceil(j));
        paramDownloadParams.outHeight = ((int)Math.ceil(k));
      }
    }
  }
  
  private Object b(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler, int paramInt)
  {
    paramURLDrawableHandler = new FileInputStream(paramFile);
    try
    {
      localObject = new byte[2];
      paramURLDrawableHandler.read((byte[])localObject);
      k = localObject[0];
      m = localObject[1];
      paramURLDrawableHandler.close();
      localObject = new FileInputStream(paramFile);
    }
    finally
    {
      for (;;)
      {
        int k;
        int m;
        label132:
        BitmapFactory.Options localOptions;
        paramDownloadParams = paramURLDrawableHandler;
        paramInt = 0;
      }
    }
    try
    {
      paramURLDrawableHandler = Bitmap.Config.ARGB_8888;
      i = 0;
      j = 0;
      switch (k << 8 & 0xFF00 | m & 0xFF)
      {
      }
    }
    finally
    {
      paramInt = 0;
      paramDownloadParams = (DownloadParams)localObject;
      break label618;
      paramURLDrawableHandler = null;
      break label330;
      i = j;
      break label132;
      break label330;
    }
    localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    localOptions.inPreferredConfig = paramURLDrawableHandler;
    localOptions.inDensity = 160;
    localOptions.inTargetDensity = 160;
    localOptions.inScreenDensity = 160;
    BitmapFactory.decodeStream((InputStream)localObject, null, localOptions);
    j = localOptions.outWidth;
    k = localOptions.outHeight;
    ((InputStream)localObject).close();
    if (i != 0) {}
    for (;;)
    {
      try
      {
        for (;;)
        {
          paramDownloadParams.outOrientation = new ExifInterface(paramFile.getAbsolutePath()).getAttributeInt("Orientation", 1);
          localOptions.inJustDecodeBounds = false;
          paramInt = a(j, k, paramDownloadParams.reqWidth, paramDownloadParams.reqHeight, paramDownloadParams.outOrientation, paramInt);
          i = 1;
          if (i > 3) {
            break label648;
          }
          try
          {
            localOptions.inSampleSize = paramInt;
            paramURLDrawableHandler = BitmapFactory.decodeFile(paramFile.getAbsolutePath(), localOptions);
            paramURLDrawableHandler.setDensity(160);
            if (Build.VERSION.SDK_INT < 11) {
              break label660;
            }
            boolean bool = SliceBitmap.needSlice(paramURLDrawableHandler);
            if (!bool) {
              break label660;
            }
            try
            {
              SliceBitmap localSliceBitmap = new SliceBitmap(paramURLDrawableHandler);
              paramURLDrawableHandler.recycle();
              paramURLDrawableHandler = localSliceBitmap;
              label330:
              if (localOptions.inSampleSize > 1)
              {
                if (!paramDownloadParams.mAutoScaleByDensity) {
                  break label586;
                }
                paramDownloadParams.outWidth = ((int)Math.ceil(j * this.b));
                paramDownloadParams.outHeight = ((int)Math.ceil(k * this.b));
              }
              if (QLog.isColorLevel()) {
                QLog.d("PEAK", 2, "image file size:" + paramFile.length() + " , bound:" + localOptions.outWidth + "x" + localOptions.outHeight + " , sampleSize: " + localOptions.inSampleSize);
              }
              return paramURLDrawableHandler;
            }
            catch (Exception localException)
            {
              if (paramURLDrawableHandler == null) {
                break label482;
              }
              paramURLDrawableHandler.recycle();
              throw new OutOfMemoryError("slice failed.");
            }
            i = 1;
            paramURLDrawableHandler = Bitmap.Config.RGB_565;
          }
          catch (OutOfMemoryError paramURLDrawableHandler)
          {
            label482:
            if (!QLog.isColorLevel()) {
              break label562;
            }
            QLog.d("PEAK", 2, "DecodeFile ERROR,oom retryCount=" + i + ",options.inSampleSize=" + localOptions.inSampleSize + ",url=" + paramDownloadParams.urlStr + ",oom.msg:" + paramURLDrawableHandler.getMessage());
            label562:
            System.gc();
            Thread.yield();
            System.gc();
            i += 1;
            paramInt *= 2;
          }
        }
        ((InputStream)localObject).close();
        return null;
      }
      finally
      {
        label586:
        paramInt = 1;
        paramDownloadParams = (DownloadParams)localObject;
        if (paramInt != 0) {
          continue;
        }
        paramDownloadParams.close();
      }
      continue;
      paramDownloadParams.outWidth = ((int)Math.ceil(j));
      paramDownloadParams.outHeight = ((int)Math.ceil(k));
    }
  }
  
  /* Error */
  private Object c(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler, int paramInt)
  {
    // Byte code:
    //   0: new 66	java/io/FileInputStream
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 69	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore 18
    //   10: iconst_0
    //   11: istore 8
    //   13: iconst_0
    //   14: istore 7
    //   16: iload 8
    //   18: istore 5
    //   20: invokestatic 75	android/os/SystemClock:uptimeMillis	()J
    //   23: lstore 11
    //   25: iload 8
    //   27: istore 5
    //   29: iconst_2
    //   30: newarray byte
    //   32: astore 17
    //   34: iload 8
    //   36: istore 5
    //   38: aload 18
    //   40: aload 17
    //   42: invokevirtual 79	java/io/FileInputStream:read	([B)I
    //   45: pop
    //   46: aload 17
    //   48: iconst_0
    //   49: baload
    //   50: istore 9
    //   52: aload 17
    //   54: iconst_1
    //   55: baload
    //   56: istore 10
    //   58: iload 8
    //   60: istore 5
    //   62: getstatic 85	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   65: astore 16
    //   67: iconst_0
    //   68: istore 6
    //   70: iconst_0
    //   71: istore 5
    //   73: iload 9
    //   75: bipush 8
    //   77: ishl
    //   78: ldc 86
    //   80: iand
    //   81: iload 10
    //   83: sipush 255
    //   86: iand
    //   87: ior
    //   88: lookupswitch	default:+760->848, 8273:+501->589, 16973:+501->589, 18249:+513->601, 18761:+498->586, 19789:+498->586, 65496:+498->586
    //   149: iconst_5
    //   150: istore 5
    //   152: aload_1
    //   153: invokevirtual 91	java/io/File:length	()J
    //   156: l2i
    //   157: newarray byte
    //   159: astore 20
    //   161: iload 8
    //   163: istore 5
    //   165: aload 17
    //   167: iconst_0
    //   168: aload 20
    //   170: iconst_0
    //   171: aload 17
    //   173: arraylength
    //   174: invokestatic 97	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   177: iload 8
    //   179: istore 5
    //   181: aload 18
    //   183: aload 20
    //   185: aload 17
    //   187: arraylength
    //   188: aload 18
    //   190: invokevirtual 101	java/io/FileInputStream:available	()I
    //   193: invokevirtual 104	java/io/FileInputStream:read	([BII)I
    //   196: pop
    //   197: iload 8
    //   199: istore 5
    //   201: aload 18
    //   203: invokevirtual 107	java/io/FileInputStream:close	()V
    //   206: iconst_1
    //   207: istore 7
    //   209: invokestatic 46	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   212: ifeq +37 -> 249
    //   215: invokestatic 75	android/os/SystemClock:uptimeMillis	()J
    //   218: lstore 13
    //   220: ldc 48
    //   222: iconst_2
    //   223: new 109	java/lang/StringBuilder
    //   226: dup
    //   227: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   230: ldc 112
    //   232: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: lload 13
    //   237: lload 11
    //   239: lsub
    //   240: invokevirtual 119	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   243: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   246: invokestatic 53	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   249: invokestatic 75	android/os/SystemClock:uptimeMillis	()J
    //   252: lstore 11
    //   254: new 280	com/tencent/mobileqq/pic/JpegOptions
    //   257: dup
    //   258: invokespecial 281	com/tencent/mobileqq/pic/JpegOptions:<init>	()V
    //   261: astore 19
    //   263: aload 19
    //   265: iconst_1
    //   266: putfield 282	com/tencent/mobileqq/pic/JpegOptions:inJustDecodeBounds	Z
    //   269: aload 19
    //   271: aload 16
    //   273: putfield 283	com/tencent/mobileqq/pic/JpegOptions:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   276: aload 20
    //   278: aload 19
    //   280: invokestatic 288	com/tencent/mobileqq/pic/JpegDecompressor:decodeByteArray	([BLcom/tencent/mobileqq/pic/JpegOptions;)Landroid/graphics/Bitmap;
    //   283: pop
    //   284: aload 19
    //   286: getfield 289	com/tencent/mobileqq/pic/JpegOptions:outWidth	I
    //   289: istore 8
    //   291: aload 19
    //   293: getfield 290	com/tencent/mobileqq/pic/JpegOptions:outHeight	I
    //   296: istore 9
    //   298: iload 6
    //   300: ifeq +24 -> 324
    //   303: aload_2
    //   304: new 162	android/media/ExifInterface
    //   307: dup
    //   308: aload_1
    //   309: invokevirtual 165	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   312: invokespecial 168	android/media/ExifInterface:<init>	(Ljava/lang/String;)V
    //   315: ldc 170
    //   317: iconst_1
    //   318: invokevirtual 174	android/media/ExifInterface:getAttributeInt	(Ljava/lang/String;I)I
    //   321: putfield 179	com/tencent/image/DownloadParams:outOrientation	I
    //   324: invokestatic 46	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   327: ifeq +37 -> 364
    //   330: invokestatic 75	android/os/SystemClock:uptimeMillis	()J
    //   333: lstore 13
    //   335: ldc 48
    //   337: iconst_2
    //   338: new 109	java/lang/StringBuilder
    //   341: dup
    //   342: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   345: ldc 181
    //   347: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: lload 13
    //   352: lload 11
    //   354: lsub
    //   355: invokevirtual 119	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   358: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   361: invokestatic 53	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   364: aload 19
    //   366: iconst_0
    //   367: putfield 282	com/tencent/mobileqq/pic/JpegOptions:inJustDecodeBounds	Z
    //   370: aload_0
    //   371: iload 8
    //   373: iload 9
    //   375: aload_2
    //   376: getfield 184	com/tencent/image/DownloadParams:reqWidth	I
    //   379: aload_2
    //   380: getfield 187	com/tencent/image/DownloadParams:reqHeight	I
    //   383: aload_2
    //   384: getfield 179	com/tencent/image/DownloadParams:outOrientation	I
    //   387: iload 4
    //   389: invokespecial 189	com/tencent/mobileqq/activity/aio/photo/PhotoDecoder:a	(IIIIII)I
    //   392: istore 5
    //   394: aload 19
    //   396: iload 5
    //   398: putfield 291	com/tencent/mobileqq/pic/JpegOptions:inSampleSize	I
    //   401: aload 20
    //   403: aload 19
    //   405: invokestatic 288	com/tencent/mobileqq/pic/JpegDecompressor:decodeByteArray	([BLcom/tencent/mobileqq/pic/JpegOptions;)Landroid/graphics/Bitmap;
    //   408: astore 16
    //   410: aload 16
    //   412: sipush 160
    //   415: invokevirtual 198	android/graphics/Bitmap:setDensity	(I)V
    //   418: getstatic 203	android/os/Build$VERSION:SDK_INT	I
    //   421: bipush 11
    //   423: if_icmplt +432 -> 855
    //   426: aload 16
    //   428: invokestatic 209	com/tencent/image/SliceBitmap:needSlice	(Landroid/graphics/Bitmap;)Z
    //   431: istore 15
    //   433: iload 15
    //   435: ifeq +420 -> 855
    //   438: new 205	com/tencent/image/SliceBitmap
    //   441: dup
    //   442: aload 16
    //   444: invokespecial 212	com/tencent/image/SliceBitmap:<init>	(Landroid/graphics/Bitmap;)V
    //   447: astore 17
    //   449: aload 16
    //   451: invokevirtual 215	android/graphics/Bitmap:recycle	()V
    //   454: aload 17
    //   456: astore 16
    //   458: aload 19
    //   460: getfield 291	com/tencent/mobileqq/pic/JpegOptions:inSampleSize	I
    //   463: iconst_1
    //   464: if_icmple +44 -> 508
    //   467: aload_2
    //   468: getfield 218	com/tencent/image/DownloadParams:mAutoScaleByDensity	Z
    //   471: ifeq +262 -> 733
    //   474: aload_2
    //   475: iload 8
    //   477: i2f
    //   478: aload_0
    //   479: getfield 33	com/tencent/mobileqq/activity/aio/photo/PhotoDecoder:b	F
    //   482: fmul
    //   483: f2d
    //   484: invokestatic 222	java/lang/Math:ceil	(D)D
    //   487: d2i
    //   488: putfield 223	com/tencent/image/DownloadParams:outWidth	I
    //   491: aload_2
    //   492: iload 9
    //   494: i2f
    //   495: aload_0
    //   496: getfield 33	com/tencent/mobileqq/activity/aio/photo/PhotoDecoder:b	F
    //   499: fmul
    //   500: f2d
    //   501: invokestatic 222	java/lang/Math:ceil	(D)D
    //   504: d2i
    //   505: putfield 224	com/tencent/image/DownloadParams:outHeight	I
    //   508: aload 16
    //   510: astore 17
    //   512: invokestatic 46	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   515: ifeq +68 -> 583
    //   518: ldc 48
    //   520: iconst_2
    //   521: new 109	java/lang/StringBuilder
    //   524: dup
    //   525: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   528: ldc 226
    //   530: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   533: aload_1
    //   534: invokevirtual 91	java/io/File:length	()J
    //   537: invokevirtual 119	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   540: ldc 228
    //   542: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   545: iload 8
    //   547: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   550: ldc 233
    //   552: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: iload 9
    //   557: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   560: ldc 235
    //   562: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: aload 19
    //   567: getfield 291	com/tencent/mobileqq/pic/JpegOptions:inSampleSize	I
    //   570: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   573: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   576: invokestatic 53	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   579: aload 16
    //   581: astore 17
    //   583: aload 17
    //   585: areturn
    //   586: iconst_1
    //   587: istore 6
    //   589: iload 8
    //   591: istore 5
    //   593: getstatic 238	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   596: astore 16
    //   598: goto -450 -> 148
    //   601: aload 18
    //   603: invokevirtual 107	java/io/FileInputStream:close	()V
    //   606: aconst_null
    //   607: areturn
    //   608: astore 17
    //   610: aload 16
    //   612: ifnull +8 -> 620
    //   615: aload 16
    //   617: invokevirtual 215	android/graphics/Bitmap:recycle	()V
    //   620: new 62	java/lang/OutOfMemoryError
    //   623: dup
    //   624: ldc 240
    //   626: invokespecial 241	java/lang/OutOfMemoryError:<init>	(Ljava/lang/String;)V
    //   629: athrow
    //   630: astore 16
    //   632: invokestatic 46	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   635: ifeq +66 -> 701
    //   638: ldc 48
    //   640: iconst_2
    //   641: new 109	java/lang/StringBuilder
    //   644: dup
    //   645: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   648: ldc 243
    //   650: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   653: iconst_1
    //   654: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   657: ldc 245
    //   659: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   662: aload 19
    //   664: getfield 291	com/tencent/mobileqq/pic/JpegOptions:inSampleSize	I
    //   667: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   670: ldc 247
    //   672: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   675: aload_2
    //   676: getfield 251	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   679: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   682: ldc 253
    //   684: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   687: aload 16
    //   689: invokevirtual 256	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   692: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   695: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   698: invokestatic 53	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   701: iload 5
    //   703: iconst_2
    //   704: imul
    //   705: istore 6
    //   707: invokestatic 259	java/lang/System:gc	()V
    //   710: invokestatic 264	java/lang/Thread:yield	()V
    //   713: invokestatic 259	java/lang/System:gc	()V
    //   716: iload 6
    //   718: istore 5
    //   720: iload 6
    //   722: bipush 8
    //   724: if_icmpgt -330 -> 394
    //   727: aconst_null
    //   728: astore 16
    //   730: goto -272 -> 458
    //   733: aload_2
    //   734: iload 8
    //   736: i2d
    //   737: invokestatic 222	java/lang/Math:ceil	(D)D
    //   740: d2i
    //   741: putfield 223	com/tencent/image/DownloadParams:outWidth	I
    //   744: aload_2
    //   745: iload 9
    //   747: i2d
    //   748: invokestatic 222	java/lang/Math:ceil	(D)D
    //   751: d2i
    //   752: putfield 224	com/tencent/image/DownloadParams:outHeight	I
    //   755: goto -247 -> 508
    //   758: astore 16
    //   760: iconst_1
    //   761: istore 6
    //   763: iload 6
    //   765: istore 5
    //   767: invokestatic 46	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   770: ifeq +19 -> 789
    //   773: iload 6
    //   775: istore 5
    //   777: ldc_w 293
    //   780: iconst_2
    //   781: ldc_w 295
    //   784: aload 16
    //   786: invokestatic 299	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   789: iload 6
    //   791: istore 5
    //   793: aload_0
    //   794: aload_1
    //   795: aload_2
    //   796: aload_3
    //   797: iload 4
    //   799: invokespecial 301	com/tencent/mobileqq/activity/aio/photo/PhotoDecoder:a	(Ljava/io/File;Lcom/tencent/image/DownloadParams;Lcom/tencent/image/URLDrawableHandler;I)Ljava/lang/Object;
    //   802: astore_1
    //   803: aload_1
    //   804: astore 17
    //   806: iload 6
    //   808: ifne -225 -> 583
    //   811: aload 18
    //   813: invokevirtual 107	java/io/FileInputStream:close	()V
    //   816: aload_1
    //   817: areturn
    //   818: astore_1
    //   819: iload 5
    //   821: ifne +8 -> 829
    //   824: aload 18
    //   826: invokevirtual 107	java/io/FileInputStream:close	()V
    //   829: aload_1
    //   830: athrow
    //   831: astore_1
    //   832: iload 7
    //   834: istore 5
    //   836: goto -17 -> 819
    //   839: astore 16
    //   841: iload 7
    //   843: istore 6
    //   845: goto -82 -> 763
    //   848: iload 5
    //   850: istore 6
    //   852: goto -704 -> 148
    //   855: goto -397 -> 458
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	858	0	this	PhotoDecoder
    //   0	858	1	paramFile	File
    //   0	858	2	paramDownloadParams	DownloadParams
    //   0	858	3	paramURLDrawableHandler	URLDrawableHandler
    //   0	858	4	paramInt	int
    //   18	831	5	i	int
    //   68	783	6	j	int
    //   14	828	7	k	int
    //   11	724	8	m	int
    //   50	696	9	n	int
    //   56	31	10	i1	int
    //   23	330	11	l1	long
    //   218	133	13	l2	long
    //   431	3	15	bool	boolean
    //   65	551	16	localObject1	Object
    //   630	58	16	localOutOfMemoryError	OutOfMemoryError
    //   728	1	16	localObject2	Object
    //   758	27	16	localRuntimeException1	RuntimeException
    //   839	1	16	localRuntimeException2	RuntimeException
    //   32	552	17	localObject3	Object
    //   608	1	17	localException	Exception
    //   804	1	17	localFile	File
    //   8	817	18	localFileInputStream	FileInputStream
    //   261	402	19	localJpegOptions	JpegOptions
    //   159	243	20	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   438	454	608	java/lang/Exception
    //   394	433	630	java/lang/OutOfMemoryError
    //   438	454	630	java/lang/OutOfMemoryError
    //   615	620	630	java/lang/OutOfMemoryError
    //   620	630	630	java/lang/OutOfMemoryError
    //   209	249	758	java/lang/RuntimeException
    //   249	298	758	java/lang/RuntimeException
    //   303	324	758	java/lang/RuntimeException
    //   324	364	758	java/lang/RuntimeException
    //   364	394	758	java/lang/RuntimeException
    //   394	433	758	java/lang/RuntimeException
    //   438	454	758	java/lang/RuntimeException
    //   458	508	758	java/lang/RuntimeException
    //   512	579	758	java/lang/RuntimeException
    //   615	620	758	java/lang/RuntimeException
    //   620	630	758	java/lang/RuntimeException
    //   632	701	758	java/lang/RuntimeException
    //   707	716	758	java/lang/RuntimeException
    //   733	755	758	java/lang/RuntimeException
    //   20	25	818	finally
    //   29	34	818	finally
    //   38	46	818	finally
    //   62	67	818	finally
    //   152	161	818	finally
    //   165	177	818	finally
    //   181	197	818	finally
    //   201	206	818	finally
    //   593	598	818	finally
    //   767	773	818	finally
    //   777	789	818	finally
    //   793	803	818	finally
    //   209	249	831	finally
    //   249	298	831	finally
    //   303	324	831	finally
    //   324	364	831	finally
    //   364	394	831	finally
    //   394	433	831	finally
    //   438	454	831	finally
    //   458	508	831	finally
    //   512	579	831	finally
    //   615	620	831	finally
    //   620	630	831	finally
    //   632	701	831	finally
    //   707	716	831	finally
    //   733	755	831	finally
    //   20	25	839	java/lang/RuntimeException
    //   29	34	839	java/lang/RuntimeException
    //   38	46	839	java/lang/RuntimeException
    //   62	67	839	java/lang/RuntimeException
    //   152	161	839	java/lang/RuntimeException
    //   165	177	839	java/lang/RuntimeException
    //   181	197	839	java/lang/RuntimeException
    //   201	206	839	java/lang/RuntimeException
    //   593	598	839	java/lang/RuntimeException
  }
  
  private Object d(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler, int paramInt)
  {
    Object localObject1 = new FileInputStream(paramFile);
    label628:
    label637:
    for (;;)
    {
      int j;
      try
      {
        Object localObject3 = new byte[2];
        ((InputStream)localObject1).read((byte[])localObject3);
        k = localObject3[0];
        m = localObject3[1];
        ((InputStream)localObject1).close();
        localObject1 = Bitmap.Config.ARGB_8888;
        i = 0;
        j = 0;
        switch (k << 8 & 0xFF00 | m & 0xFF)
        {
        case 8273: 
          localJpegOptions = new JpegOptions();
          localJpegOptions.inJustDecodeBounds = true;
          localJpegOptions.inPreferredConfig = ((Bitmap.Config)localObject1);
          JpegDecompressor.decodeFile(paramFile.getAbsolutePath(), localJpegOptions);
          k = localJpegOptions.outWidth;
          m = localJpegOptions.outHeight;
          if (i != 0) {
            paramDownloadParams.outOrientation = new ExifInterface(paramFile.getAbsolutePath()).getAttributeInt("Orientation", 1);
          }
          localJpegOptions.inJustDecodeBounds = false;
          i = a(k, m, paramDownloadParams.reqWidth, paramDownloadParams.reqHeight, paramDownloadParams.outOrientation, paramInt);
          j = 1;
          if (j > 3) {
            break;
          }
        case 16973: 
        case 18249: 
          try
          {
            localJpegOptions.inSampleSize = i;
            localObject1 = JpegDecompressor.decodeFile(paramFile.getAbsolutePath(), localJpegOptions);
            ((Bitmap)localObject1).setDensity(160);
            if (Build.VERSION.SDK_INT < 11) {
              break label637;
            }
            boolean bool = SliceBitmap.needSlice((Bitmap)localObject1);
            if (!bool) {
              break label637;
            }
            try
            {
              localObject3 = new SliceBitmap((Bitmap)localObject1);
              ((Bitmap)localObject1).recycle();
              localObject1 = localObject3;
              if (localJpegOptions.inSampleSize > 1)
              {
                if (!paramDownloadParams.mAutoScaleByDensity) {
                  continue;
                }
                paramDownloadParams.outWidth = ((int)Math.ceil(k * this.b));
                paramDownloadParams.outHeight = ((int)Math.ceil(m * this.b));
              }
              if (!QLog.isColorLevel()) {
                break label628;
              }
              QLog.d("PEAK", 2, "image file size:" + paramFile.length() + " , bound:" + localJpegOptions.outWidth + "x" + localJpegOptions.outHeight + " , sampleSize: " + localJpegOptions.inSampleSize);
              return localObject1;
            }
            catch (Exception localException)
            {
              if (localObject1 == null) {
                continue;
              }
              ((Bitmap)localObject1).recycle();
              throw new OutOfMemoryError("slice failed.");
            }
            localObject1 = Bitmap.Config.RGB_565;
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("PEAK", 2, "DecodeFile ERROR,oom retryCount=" + j + ",options.inSampleSize=" + localJpegOptions.inSampleSize + ",url=" + paramDownloadParams.urlStr + ",oom.msg:" + localOutOfMemoryError.getMessage());
            System.gc();
            Thread.yield();
            System.gc();
            j += 1;
            i *= 2;
          }
          return null;
        }
      }
      catch (RuntimeException localRuntimeException)
      {
        int k;
        int m;
        JpegOptions localJpegOptions;
        localRuntimeException = localRuntimeException;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("peak_pgjpeg", 2, "PhotoDecoder.decodeFileNormalWithTrubo() error", localRuntimeException);
        paramFile = b(paramFile, paramDownloadParams, paramURLDrawableHandler, paramInt);
        return paramFile;
      }
      finally {}
      continue;
      paramDownloadParams.outWidth = ((int)Math.ceil(k));
      paramDownloadParams.outHeight = ((int)Math.ceil(m));
      continue;
      Object localObject2 = null;
      continue;
      int i = j;
      continue;
      return localObject2;
      i = 1;
    }
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    long l1 = SystemClock.uptimeMillis();
    try
    {
      l2 = paramFile.length();
      int i = 0;
      if (paramDownloadParams.tag != null) {
        i = ((Integer)paramDownloadParams.tag).intValue();
      }
      if ((Build.VERSION.SDK_INT < 26) && (Utils.b()) && (ImageUtil.b(paramFile.getAbsolutePath())))
      {
        if (l2 < 5242880L)
        {
          paramURLDrawableHandler = c(paramFile, paramDownloadParams, paramURLDrawableHandler, i);
          paramDownloadParams = paramURLDrawableHandler;
          if (QLog.isColorLevel())
          {
            l2 = SystemClock.uptimeMillis();
            QLog.d("PEAK", 2, "decode file:" + paramFile.getAbsolutePath() + " cost: " + (l2 - l1));
            paramDownloadParams = paramURLDrawableHandler;
          }
          return paramDownloadParams;
        }
        paramURLDrawableHandler = d(paramFile, paramDownloadParams, paramURLDrawableHandler, i);
        paramDownloadParams = paramURLDrawableHandler;
        return paramURLDrawableHandler;
      }
      if (l2 < 5242880L)
      {
        paramURLDrawableHandler = a(paramFile, paramDownloadParams, paramURLDrawableHandler, i);
        paramDownloadParams = paramURLDrawableHandler;
        return paramURLDrawableHandler;
      }
      paramURLDrawableHandler = b(paramFile, paramDownloadParams, paramURLDrawableHandler, i);
      paramDownloadParams = paramURLDrawableHandler;
      return paramURLDrawableHandler;
    }
    finally
    {
      long l2;
      if (QLog.isColorLevel())
      {
        l2 = SystemClock.uptimeMillis();
        QLog.d("PEAK", 2, "decode file:" + paramFile.getAbsolutePath() + " cost: " + (l2 - l1));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PhotoDecoder
 * JD-Core Version:    0.7.0.1
 */