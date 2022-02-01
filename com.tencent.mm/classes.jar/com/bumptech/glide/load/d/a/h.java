package com.bumptech.glide.load.d.a;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.g.j;
import com.bumptech.glide.g.k;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParser.ImageType;
import com.bumptech.glide.load.b.a.e;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.locks.Lock;

public final class h
{
  public static final com.bumptech.glide.load.h<com.bumptech.glide.load.b> aLc;
  @Deprecated
  public static final com.bumptech.glide.load.h<g> aLd;
  public static final com.bumptech.glide.load.h<Boolean> aLe;
  public static final com.bumptech.glide.load.h<Boolean> aLf;
  private static final Set<String> aLg;
  static final a aLh;
  private static final Set<ImageHeaderParser.ImageType> aLi;
  private static final Queue<BitmapFactory.Options> aLj;
  private final e aCj;
  private final com.bumptech.glide.load.b.a.b aFo;
  private final List<ImageHeaderParser> aFx;
  private final DisplayMetrics aJm;
  private final l aLk;
  
  static
  {
    AppMethodBeat.i(77400);
    aLc = com.bumptech.glide.load.h.c("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", com.bumptech.glide.load.b.aEO);
    aLd = g.aKY;
    aLe = com.bumptech.glide.load.h.c("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", Boolean.FALSE);
    aLf = com.bumptech.glide.load.h.c("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", Boolean.FALSE);
    aLg = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[] { "image/vnd.wap.wbmp", "image/x-ico" })));
    aLh = new a()
    {
      public final void a(e paramAnonymouse, Bitmap paramAnonymousBitmap) {}
      
      public final void pD() {}
    };
    aLi = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
    aLj = k.ds(0);
    AppMethodBeat.o(77400);
  }
  
  public h(List<ImageHeaderParser> paramList, DisplayMetrics paramDisplayMetrics, e parame, com.bumptech.glide.load.b.a.b paramb)
  {
    AppMethodBeat.i(77392);
    this.aLk = l.pE();
    this.aFx = paramList;
    this.aJm = ((DisplayMetrics)j.checkNotNull(paramDisplayMetrics, "Argument must not be null"));
    this.aCj = ((e)j.checkNotNull(parame, "Argument must not be null"));
    this.aFo = ((com.bumptech.glide.load.b.a.b)j.checkNotNull(paramb, "Argument must not be null"));
    AppMethodBeat.o(77392);
  }
  
  private static boolean a(BitmapFactory.Options paramOptions)
  {
    return (paramOptions.inTargetDensity > 0) && (paramOptions.inDensity > 0) && (paramOptions.inTargetDensity != paramOptions.inDensity);
  }
  
  private static int[] a(InputStream paramInputStream, BitmapFactory.Options paramOptions, a parama, e parame)
  {
    AppMethodBeat.i(77395);
    paramOptions.inJustDecodeBounds = true;
    b(paramInputStream, paramOptions, parama, parame);
    paramOptions.inJustDecodeBounds = false;
    int i = paramOptions.outWidth;
    int j = paramOptions.outHeight;
    AppMethodBeat.o(77395);
    return new int[] { i, j };
  }
  
  private static Bitmap b(InputStream paramInputStream, BitmapFactory.Options paramOptions, a parama, e parame)
  {
    AppMethodBeat.i(77396);
    if (paramOptions.inJustDecodeBounds) {
      paramInputStream.mark(10485760);
    }
    int i;
    int j;
    Object localObject;
    for (;;)
    {
      i = paramOptions.outWidth;
      j = paramOptions.outHeight;
      localObject = paramOptions.outMimeType;
      q.pI().lock();
      try
      {
        Bitmap localBitmap1 = BitmapFactory.decodeStream(paramInputStream, null, paramOptions);
        q.pI().unlock();
        if (paramOptions.inJustDecodeBounds) {
          paramInputStream.reset();
        }
        AppMethodBeat.o(77396);
        return localBitmap1;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        localObject = new IOException("Exception decoding bitmap, outWidth: " + i + ", outHeight: " + j + ", outMimeType: " + (String)localObject + ", inBitmap: " + j(paramOptions.inBitmap), localIllegalArgumentException);
        Log.isLoggable("Downsampler", 3);
        Bitmap localBitmap2 = paramOptions.inBitmap;
        if (localBitmap2 == null) {
          break label242;
        }
        try
        {
          paramInputStream.reset();
          parame.g(paramOptions.inBitmap);
          paramOptions.inBitmap = null;
          paramInputStream = b(paramInputStream, paramOptions, parama, parame);
          return paramInputStream;
        }
        catch (IOException paramInputStream)
        {
          AppMethodBeat.o(77396);
          throw ((Throwable)localObject);
        }
      }
      finally
      {
        q.pI().unlock();
        AppMethodBeat.o(77396);
      }
      parama.pD();
    }
    label242:
    AppMethodBeat.o(77396);
    throw ((Throwable)localObject);
  }
  
  private static void b(BitmapFactory.Options paramOptions)
  {
    AppMethodBeat.i(77399);
    c(paramOptions);
    synchronized (aLj)
    {
      aLj.offer(paramOptions);
      AppMethodBeat.o(77399);
      return;
    }
  }
  
  private static int c(double paramDouble)
  {
    AppMethodBeat.i(77394);
    if (paramDouble <= 1.0D) {}
    for (;;)
    {
      int i = (int)Math.round(2147483647.0D * paramDouble);
      AppMethodBeat.o(77394);
      return i;
      paramDouble = 1.0D / paramDouble;
    }
  }
  
  private static void c(BitmapFactory.Options paramOptions)
  {
    paramOptions.inTempStorage = null;
    paramOptions.inDither = false;
    paramOptions.inScaled = false;
    paramOptions.inSampleSize = 1;
    paramOptions.inPreferredConfig = null;
    paramOptions.inJustDecodeBounds = false;
    paramOptions.inDensity = 0;
    paramOptions.inTargetDensity = 0;
    paramOptions.outWidth = 0;
    paramOptions.outHeight = 0;
    paramOptions.outMimeType = null;
    paramOptions.inBitmap = null;
    paramOptions.inMutable = true;
  }
  
  @TargetApi(19)
  private static String j(Bitmap paramBitmap)
  {
    AppMethodBeat.i(77397);
    if (paramBitmap == null)
    {
      AppMethodBeat.o(77397);
      return null;
    }
    if (Build.VERSION.SDK_INT >= 19) {}
    for (String str = " (" + paramBitmap.getAllocationByteCount() + ")";; str = "")
    {
      paramBitmap = "[" + paramBitmap.getWidth() + "x" + paramBitmap.getHeight() + "] " + paramBitmap.getConfig() + str;
      AppMethodBeat.o(77397);
      return paramBitmap;
    }
  }
  
  /* Error */
  private static BitmapFactory.Options pC()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 380
    //   6: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 143	com/bumptech/glide/load/d/a/h:aLj	Ljava/util/Queue;
    //   12: astore_0
    //   13: aload_0
    //   14: monitorenter
    //   15: getstatic 143	com/bumptech/glide/load/d/a/h:aLj	Ljava/util/Queue;
    //   18: invokeinterface 384 1 0
    //   23: checkcast 185	android/graphics/BitmapFactory$Options
    //   26: astore_1
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_1
    //   30: astore_0
    //   31: aload_1
    //   32: ifnonnull +15 -> 47
    //   35: new 185	android/graphics/BitmapFactory$Options
    //   38: dup
    //   39: invokespecial 385	android/graphics/BitmapFactory$Options:<init>	()V
    //   42: astore_0
    //   43: aload_0
    //   44: invokestatic 300	com/bumptech/glide/load/d/a/h:c	(Landroid/graphics/BitmapFactory$Options;)V
    //   47: ldc_w 380
    //   50: invokestatic 146	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: ldc 2
    //   55: monitorexit
    //   56: aload_0
    //   57: areturn
    //   58: astore_1
    //   59: aload_0
    //   60: monitorexit
    //   61: ldc_w 380
    //   64: invokestatic 146	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   67: aload_1
    //   68: athrow
    //   69: astore_0
    //   70: ldc 2
    //   72: monitorexit
    //   73: aload_0
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   69	5	0	localObject2	Object
    //   26	6	1	localOptions	BitmapFactory.Options
    //   58	10	1	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   15	29	58	finally
    //   59	61	58	finally
    //   3	15	69	finally
    //   35	47	69	finally
    //   47	53	69	finally
    //   61	69	69	finally
  }
  
  public final v<Bitmap> a(InputStream paramInputStream, int paramInt1, int paramInt2, i parami, a parama)
  {
    AppMethodBeat.i(77393);
    j.checkArgument(paramInputStream.markSupported(), "You must provide an InputStream that supports mark()");
    byte[] arrayOfByte = (byte[])this.aFo.a(65536, [B.class);
    BitmapFactory.Options localOptions = pC();
    localOptions.inTempStorage = arrayOfByte;
    Object localObject2 = (com.bumptech.glide.load.b)parami.a(aLc);
    g localg = (g)parami.a(g.aKY);
    boolean bool2 = ((Boolean)parami.a(aLe)).booleanValue();
    if ((parami.a(aLf) != null) && (((Boolean)parami.a(aLf)).booleanValue())) {
      i = 1;
    }
    int i2;
    int i3;
    try
    {
      l = com.bumptech.glide.g.f.qt();
      parami = a(paramInputStream, localOptions, parama, this.aCj);
      i2 = parami[0];
      i3 = parami[1];
      str = localOptions.outMimeType;
      if (i2 == -1) {
        break label2019;
      }
      if (i3 != -1) {
        break label2012;
      }
    }
    finally
    {
      long l;
      String str;
      int i6;
      b(localOptions);
      this.aFo.put(arrayOfByte);
      AppMethodBeat.o(77393);
    }
    i6 = com.bumptech.glide.load.f.b(this.aFx, paramInputStream, this.aFo);
    int i = q.dn(i6);
    boolean bool1 = q.jdMethod_do(i6);
    int k;
    label216:
    Object localObject1;
    int m;
    label300:
    int i1;
    label327:
    int j;
    if (paramInt1 == -2147483648)
    {
      k = i2;
      break label2025;
      localObject1 = com.bumptech.glide.load.f.a(this.aFx, paramInputStream, this.aFo);
      parami = this.aCj;
      if ((i2 > 0) && (i3 > 0)) {
        break label781;
      }
      if (Log.isLoggable("Downsampler", 3)) {
        new StringBuilder("Unable to determine dimensions for: ").append(localObject1).append(" with target [").append(k).append("x").append(m).append("]");
      }
      parami = this.aLk;
      if ((i1 == 0) || (Build.VERSION.SDK_INT < 26)) {
        break label2039;
      }
      if (!bool1) {
        break label1640;
      }
      break label2039;
      if (j == 0)
      {
        if ((localObject2 != com.bumptech.glide.load.b.aEM) && (Build.VERSION.SDK_INT != 16)) {
          break label1703;
        }
        localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
      }
      label356:
      if (Build.VERSION.SDK_INT < 19) {
        break label2102;
      }
    }
    label395:
    label781:
    label1046:
    label1073:
    label2102:
    for (i = 1;; i = 0)
    {
      if ((localOptions.inSampleSize == 1) || (i != 0))
      {
        if (Build.VERSION.SDK_INT < 19) {
          break label1796;
        }
        bool1 = true;
        break label2045;
        if ((k > 0) && (i > 0))
        {
          localObject2 = this.aCj;
          parami = null;
          if (Build.VERSION.SDK_INT >= 26)
          {
            if (localOptions.inPreferredConfig != Bitmap.Config.HARDWARE) {
              parami = localOptions.outConfig;
            }
          }
          else
          {
            localObject1 = parami;
            if (parami == null) {
              localObject1 = localOptions.inPreferredConfig;
            }
            localOptions.inBitmap = ((e)localObject2).g(k, i, (Bitmap.Config)localObject1);
          }
        }
      }
      label474:
      localObject1 = b(paramInputStream, localOptions, parama, this.aCj);
      parama.a(this.aCj, (Bitmap)localObject1);
      if (Log.isLoggable("Downsampler", 2)) {
        new StringBuilder("Decoded ").append(j((Bitmap)localObject1)).append(" from [").append(i2).append("x").append(i3).append("] ").append(str).append(" with inBitmap ").append(j(localOptions.inBitmap)).append(" for [").append(paramInt1).append("x").append(paramInt2).append("], sample size: ").append(localOptions.inSampleSize).append(", density: ").append(localOptions.inDensity).append(", target density: ").append(localOptions.inTargetDensity).append(", thread: ").append(Thread.currentThread().getName()).append(", duration: ").append(com.bumptech.glide.g.f.p(l));
      }
      paramInputStream = null;
      if (localObject1 != null)
      {
        ((Bitmap)localObject1).setDensity(this.aJm.densityDpi);
        parami = q.a(this.aCj, (Bitmap)localObject1, i6);
        paramInputStream = parami;
        if (!localObject1.equals(parami))
        {
          this.aCj.g((Bitmap)localObject1);
          paramInputStream = parami;
        }
      }
      paramInputStream = d.a(paramInputStream, this.aCj);
      b(localOptions);
      this.aFo.put(arrayOfByte);
      AppMethodBeat.o(77393);
      return paramInputStream;
      i = 0;
      break;
      k = paramInt1;
      break label2025;
      m = paramInt2;
      break label216;
      if ((i == 90) || (i == 270)) {}
      for (float f = localg.l(i3, i2, k, m); f <= 0.0F; f = localg.l(i2, i3, k, m))
      {
        paramInputStream = new IllegalArgumentException("Cannot scale with factor: " + f + " from: " + localg + ", source: [" + i2 + "x" + i3 + "], target: [" + k + "x" + m + "]");
        AppMethodBeat.o(77393);
        throw paramInputStream;
      }
      g.g localg1 = localg.pB();
      if (localg1 == null)
      {
        paramInputStream = new IllegalArgumentException("Cannot round with null rounding");
        AppMethodBeat.o(77393);
        throw paramInputStream;
      }
      j = (int)(i2 * f + 0.5D);
      i = (int)(i3 * f + 0.5D);
      j = i2 / j;
      i = i3 / i;
      int n;
      double d1;
      if (localg1 == g.g.aKZ)
      {
        i = Math.max(j, i);
        if ((Build.VERSION.SDK_INT > 23) || (!aLg.contains(localOptions.outMimeType))) {
          break label1413;
        }
        n = 1;
        localOptions.inSampleSize = n;
        if (localObject1 != ImageHeaderParser.ImageType.JPEG) {
          break label1452;
        }
        i = Math.min(n, 8);
        int i4 = (int)Math.ceil(i2 / i);
        int i5 = (int)Math.ceil(i3 / i);
        int i7 = n / 8;
        i = i5;
        j = i4;
        if (i7 > 0)
        {
          j = i4 / i7;
          i = i5 / i7;
        }
        d1 = localg.l(j, i, k, m);
        if (Build.VERSION.SDK_INT >= 19)
        {
          i4 = c(d1);
          i5 = (int)(i4 * d1 + 0.5D);
          double d2 = d1 / (i5 / i4);
          localOptions.inTargetDensity = ((int)(i5 * d2 + 0.5D));
          localOptions.inDensity = c(d1);
        }
        if (!a(localOptions)) {
          break label1625;
        }
        localOptions.inScaled = true;
      }
      for (;;)
      {
        if (!Log.isLoggable("Downsampler", 2)) {
          break label1638;
        }
        new StringBuilder("Calculate scaling, source: [").append(i2).append("x").append(i3).append("], target: [").append(k).append("x").append(m).append("], power of two scaled: [").append(j).append("x").append(i).append("], exact scale factor: ").append(f).append(", power of 2 sample size: ").append(n).append(", adjusted scale factor: ").append(d1).append(", target density: ").append(localOptions.inTargetDensity).append(", density: ").append(localOptions.inDensity);
        break;
        i = Math.min(j, i);
        break label1046;
        n = Math.max(1, Integer.highestOneBit(i));
        if ((localg1 != g.g.aKZ) || (n >= 1.0F / f)) {
          break label2009;
        }
        n <<= 1;
        break label1073;
        if ((localObject1 == ImageHeaderParser.ImageType.PNG) || (localObject1 == ImageHeaderParser.ImageType.PNG_A))
        {
          j = (int)Math.floor(i2 / n);
          i = (int)Math.floor(i3 / n);
          break label1159;
        }
        if ((localObject1 != ImageHeaderParser.ImageType.WEBP) && (localObject1 != ImageHeaderParser.ImageType.WEBP_A)) {
          break label2077;
        }
        if (Build.VERSION.SDK_INT >= 24)
        {
          j = Math.round(i2 / n);
          i = Math.round(i3 / n);
          break label1159;
        }
        j = (int)Math.floor(i2 / n);
        i = (int)Math.floor(i3 / n);
        break label1159;
        parami = a(paramInputStream, localOptions, parama, parami);
        j = parami[0];
        i = parami[1];
        break label1159;
        label1608:
        j = i2 / n;
        i = i3 / n;
        break label1159;
        label1625:
        localOptions.inTargetDensity = 0;
        localOptions.inDensity = 0;
      }
      label1638:
      break label300;
      label1640:
      if ((k >= 128) && (m >= 128) && (parami.pF())) {}
      for (i = 1;; i = 0)
      {
        j = i;
        if (i == 0) {
          break;
        }
        localOptions.inPreferredConfig = Bitmap.Config.HARDWARE;
        localOptions.inMutable = false;
        j = i;
        break;
      }
      for (;;)
      {
        try
        {
          bool1 = com.bumptech.glide.load.f.a(this.aFx, paramInputStream, this.aFo).hasAlpha();
          if (!bool1) {
            break label1788;
          }
          parami = Bitmap.Config.ARGB_8888;
          localOptions.inPreferredConfig = parami;
          if (localOptions.inPreferredConfig != Bitmap.Config.RGB_565) {
            break label356;
          }
          localOptions.inDither = true;
        }
        catch (IOException parami)
        {
          if (!Log.isLoggable("Downsampler", 3)) {
            break label2096;
          }
        }
        new StringBuilder("Cannot determine whether the image has alpha or not from header, format ").append(localObject2);
        break label2096;
        label1788:
        parami = Bitmap.Config.RGB_565;
        continue;
        bool1 = aLi.contains(localObject1);
        label2009:
        label2012:
        label2019:
        label2025:
        label2039:
        label2045:
        do
        {
          if (a(localOptions)) {}
          for (f = localOptions.inTargetDensity / localOptions.inDensity;; f = 1.0F)
          {
            j = localOptions.inSampleSize;
            k = (int)Math.ceil(i2 / j);
            i = (int)Math.ceil(i3 / j);
            k = Math.round(k * f);
            i = Math.round(i * f);
            if (Log.isLoggable("Downsampler", 2)) {
              new StringBuilder("Calculated target [").append(k).append("x").append(i).append("] for source [").append(i2).append("x").append(i3).append("], sampleSize: ").append(j).append(", targetDensity: ").append(localOptions.inTargetDensity).append(", density: ").append(localOptions.inDensity).append(", density multiplier: ").append(f);
            }
            break;
          }
          break label1073;
          i1 = i;
          break;
          i1 = 0;
          break;
          if (paramInt2 != -2147483648) {
            break label775;
          }
          m = i3;
          break label216;
          j = 0;
          break label327;
          if (!bool1) {
            break label474;
          }
        } while ((i2 < 0) || (i3 < 0) || (!bool2) || (i == 0));
        i = m;
        break label395;
        if (i2 % n != 0) {
          break label1581;
        }
        if (i3 % n == 0) {
          break label1608;
        }
        break label1581;
        bool1 = false;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(e parame, Bitmap paramBitmap);
    
    public abstract void pD();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.d.a.h
 * JD-Core Version:    0.7.0.1
 */