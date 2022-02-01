package com.bumptech.glide.c.d.a;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.c.b.u;
import com.bumptech.glide.c.f;
import com.bumptech.glide.c.f.a;
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
  public static final com.bumptech.glide.c.i<com.bumptech.glide.c.b> aLk;
  @Deprecated
  public static final com.bumptech.glide.c.i<g> aLl;
  public static final com.bumptech.glide.c.i<Boolean> aLm;
  public static final com.bumptech.glide.c.i<Boolean> aLn;
  private static final Set<String> aLo;
  static final a aLp;
  private static final Set<f.a> aLq;
  private static final Queue<BitmapFactory.Options> aLr;
  private final com.bumptech.glide.c.b.a.e aCk;
  private final List<f> aFH;
  private final com.bumptech.glide.c.b.a.b aFy;
  private final DisplayMetrics aJt;
  private final k aLs;
  
  static
  {
    AppMethodBeat.i(77400);
    aLk = com.bumptech.glide.c.i.b("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", com.bumptech.glide.c.b.aEP);
    aLl = g.aLg;
    aLm = com.bumptech.glide.c.i.b("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", Boolean.FALSE);
    aLn = com.bumptech.glide.c.i.P("com.bumtpech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode");
    aLo = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[] { "image/vnd.wap.wbmp", "image/x-ico" })));
    aLp = new a()
    {
      public final void a(com.bumptech.glide.c.b.a.e paramAnonymouse, Bitmap paramAnonymousBitmap) {}
      
      public final void py() {}
    };
    aLq = Collections.unmodifiableSet(EnumSet.of(f.a.aEW, f.a.aEY, f.a.aEZ));
    aLr = com.bumptech.glide.h.j.dx(0);
    AppMethodBeat.o(77400);
  }
  
  public h(List<f> paramList, DisplayMetrics paramDisplayMetrics, com.bumptech.glide.c.b.a.e parame, com.bumptech.glide.c.b.a.b paramb)
  {
    AppMethodBeat.i(77392);
    this.aLs = k.pz();
    this.aFH = paramList;
    this.aJt = ((DisplayMetrics)com.bumptech.glide.h.i.checkNotNull(paramDisplayMetrics, "Argument must not be null"));
    this.aCk = ((com.bumptech.glide.c.b.a.e)com.bumptech.glide.h.i.checkNotNull(parame, "Argument must not be null"));
    this.aFy = ((com.bumptech.glide.c.b.a.b)com.bumptech.glide.h.i.checkNotNull(paramb, "Argument must not be null"));
    AppMethodBeat.o(77392);
  }
  
  private static boolean a(BitmapFactory.Options paramOptions)
  {
    return (paramOptions.inTargetDensity > 0) && (paramOptions.inDensity > 0) && (paramOptions.inTargetDensity != paramOptions.inDensity);
  }
  
  private static int[] a(InputStream paramInputStream, BitmapFactory.Options paramOptions, a parama, com.bumptech.glide.c.b.a.e parame)
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
  
  private static Bitmap b(InputStream paramInputStream, BitmapFactory.Options paramOptions, a parama, com.bumptech.glide.c.b.a.e parame)
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
      p.pD().lock();
      try
      {
        Bitmap localBitmap1 = BitmapFactory.decodeStream(paramInputStream, null, paramOptions);
        p.pD().unlock();
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
          break label243;
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
        p.pD().unlock();
        AppMethodBeat.o(77396);
      }
      parama.py();
    }
    label243:
    AppMethodBeat.o(77396);
    throw ((Throwable)localObject);
  }
  
  private static void b(BitmapFactory.Options paramOptions)
  {
    AppMethodBeat.i(77399);
    c(paramOptions);
    synchronized (aLr)
    {
      aLr.offer(paramOptions);
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
  private static BitmapFactory.Options px()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 384
    //   6: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 147	com/bumptech/glide/c/d/a/h:aLr	Ljava/util/Queue;
    //   12: astore_0
    //   13: aload_0
    //   14: monitorenter
    //   15: getstatic 147	com/bumptech/glide/c/d/a/h:aLr	Ljava/util/Queue;
    //   18: invokeinterface 388 1 0
    //   23: checkcast 189	android/graphics/BitmapFactory$Options
    //   26: astore_1
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_1
    //   30: astore_0
    //   31: aload_1
    //   32: ifnonnull +15 -> 47
    //   35: new 189	android/graphics/BitmapFactory$Options
    //   38: dup
    //   39: invokespecial 389	android/graphics/BitmapFactory$Options:<init>	()V
    //   42: astore_0
    //   43: aload_0
    //   44: invokestatic 304	com/bumptech/glide/c/d/a/h:c	(Landroid/graphics/BitmapFactory$Options;)V
    //   47: ldc_w 384
    //   50: invokestatic 150	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: ldc 2
    //   55: monitorexit
    //   56: aload_0
    //   57: areturn
    //   58: astore_1
    //   59: aload_0
    //   60: monitorexit
    //   61: ldc_w 384
    //   64: invokestatic 150	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public final u<Bitmap> a(InputStream paramInputStream, int paramInt1, int paramInt2, com.bumptech.glide.c.j paramj, a parama)
  {
    AppMethodBeat.i(77393);
    com.bumptech.glide.h.i.checkArgument(paramInputStream.markSupported(), "You must provide an InputStream that supports mark()");
    byte[] arrayOfByte = (byte[])this.aFy.a(65536, [B.class);
    BitmapFactory.Options localOptions = px();
    localOptions.inTempStorage = arrayOfByte;
    Object localObject2 = (com.bumptech.glide.c.b)paramj.a(aLk);
    g localg = (g)paramj.a(g.aLg);
    boolean bool2 = ((Boolean)paramj.a(aLm)).booleanValue();
    if ((paramj.a(aLn) != null) && (((Boolean)paramj.a(aLn)).booleanValue()))
    {
      i = 1;
      if (localObject2 == com.bumptech.glide.c.b.aEN) {
        i = 0;
      }
    }
    int i2;
    int i3;
    try
    {
      l = com.bumptech.glide.h.e.qq();
      paramj = a(paramInputStream, localOptions, parama, this.aCk);
      i2 = paramj[0];
      i3 = paramj[1];
      str = localOptions.outMimeType;
      if (i2 == -1) {
        break label2046;
      }
      if (i3 != -1) {
        break label2039;
      }
    }
    finally
    {
      long l;
      String str;
      int i6;
      b(localOptions);
      this.aFy.put(arrayOfByte);
      AppMethodBeat.o(77393);
    }
    i6 = com.bumptech.glide.c.g.b(this.aFH, paramInputStream, this.aFy);
    int i = p.ds(i6);
    boolean bool1 = p.dt(i6);
    int k;
    label227:
    Object localObject1;
    int m;
    label311:
    int i1;
    label346:
    int j;
    if (paramInt1 == -2147483648)
    {
      k = i2;
      break label2052;
      localObject1 = com.bumptech.glide.c.g.a(this.aFH, paramInputStream, this.aFy);
      paramj = this.aCk;
      if ((i2 > 0) && (i3 > 0)) {
        break label808;
      }
      if (Log.isLoggable("Downsampler", 3)) {
        new StringBuilder("Unable to determine dimensions for: ").append(localObject1).append(" with target [").append(k).append("x").append(m).append("]");
      }
      paramj = this.aLs;
      if ((i1 == 0) || (Build.VERSION.SDK_INT < 26) || (localObject2 == com.bumptech.glide.c.b.aEN)) {
        break label2066;
      }
      if (!bool1) {
        break label1667;
      }
      break label2066;
      if (j == 0)
      {
        if ((localObject2 != com.bumptech.glide.c.b.aEM) && (localObject2 != com.bumptech.glide.c.b.aEN) && (Build.VERSION.SDK_INT != 16)) {
          break label1730;
        }
        localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
      }
      label383:
      if (Build.VERSION.SDK_INT < 19) {
        break label2129;
      }
    }
    label422:
    label808:
    label1073:
    label1100:
    label2129:
    for (i = 1;; i = 0)
    {
      if ((localOptions.inSampleSize == 1) || (i != 0))
      {
        if (Build.VERSION.SDK_INT < 19) {
          break label1823;
        }
        bool1 = true;
        break label2072;
        if ((k > 0) && (i > 0))
        {
          localObject2 = this.aCk;
          paramj = null;
          if (Build.VERSION.SDK_INT >= 26)
          {
            if (localOptions.inPreferredConfig != Bitmap.Config.HARDWARE) {
              paramj = localOptions.outConfig;
            }
          }
          else
          {
            localObject1 = paramj;
            if (paramj == null) {
              localObject1 = localOptions.inPreferredConfig;
            }
            localOptions.inBitmap = ((com.bumptech.glide.c.b.a.e)localObject2).g(k, i, (Bitmap.Config)localObject1);
          }
        }
      }
      label501:
      localObject1 = b(paramInputStream, localOptions, parama, this.aCk);
      parama.a(this.aCk, (Bitmap)localObject1);
      if (Log.isLoggable("Downsampler", 2)) {
        new StringBuilder("Decoded ").append(j((Bitmap)localObject1)).append(" from [").append(i2).append("x").append(i3).append("] ").append(str).append(" with inBitmap ").append(j(localOptions.inBitmap)).append(" for [").append(paramInt1).append("x").append(paramInt2).append("], sample size: ").append(localOptions.inSampleSize).append(", density: ").append(localOptions.inDensity).append(", target density: ").append(localOptions.inTargetDensity).append(", thread: ").append(Thread.currentThread().getName()).append(", duration: ").append(com.bumptech.glide.h.e.p(l));
      }
      paramInputStream = null;
      if (localObject1 != null)
      {
        ((Bitmap)localObject1).setDensity(this.aJt.densityDpi);
        paramj = p.a(this.aCk, (Bitmap)localObject1, i6);
        paramInputStream = paramj;
        if (!localObject1.equals(paramj))
        {
          this.aCk.g((Bitmap)localObject1);
          paramInputStream = paramj;
        }
      }
      paramInputStream = d.a(paramInputStream, this.aCk);
      b(localOptions);
      this.aFy.put(arrayOfByte);
      AppMethodBeat.o(77393);
      return paramInputStream;
      i = 0;
      break;
      k = paramInt1;
      break label2052;
      m = paramInt2;
      break label227;
      if ((i == 90) || (i == 270)) {}
      for (float f = localg.l(i3, i2, k, m); f <= 0.0F; f = localg.l(i2, i3, k, m))
      {
        paramInputStream = new IllegalArgumentException("Cannot scale with factor: " + f + " from: " + localg + ", source: [" + i2 + "x" + i3 + "], target: [" + k + "x" + m + "]");
        AppMethodBeat.o(77393);
        throw paramInputStream;
      }
      g.g localg1 = localg.pw();
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
      if (localg1 == g.g.aLh)
      {
        i = Math.max(j, i);
        if ((Build.VERSION.SDK_INT > 23) || (!aLo.contains(localOptions.outMimeType))) {
          break label1440;
        }
        n = 1;
        localOptions.inSampleSize = n;
        if (localObject1 != f.a.aEW) {
          break label1479;
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
          break label1652;
        }
        localOptions.inScaled = true;
      }
      for (;;)
      {
        if (!Log.isLoggable("Downsampler", 2)) {
          break label1665;
        }
        new StringBuilder("Calculate scaling, source: [").append(i2).append("x").append(i3).append("], target: [").append(k).append("x").append(m).append("], power of two scaled: [").append(j).append("x").append(i).append("], exact scale factor: ").append(f).append(", power of 2 sample size: ").append(n).append(", adjusted scale factor: ").append(d1).append(", target density: ").append(localOptions.inTargetDensity).append(", density: ").append(localOptions.inDensity);
        break;
        i = Math.min(j, i);
        break label1073;
        n = Math.max(1, Integer.highestOneBit(i));
        if ((localg1 != g.g.aLh) || (n >= 1.0F / f)) {
          break label2036;
        }
        n <<= 1;
        break label1100;
        if ((localObject1 == f.a.aEZ) || (localObject1 == f.a.aEY))
        {
          j = (int)Math.floor(i2 / n);
          i = (int)Math.floor(i3 / n);
          break label1186;
        }
        if ((localObject1 != f.a.aFb) && (localObject1 != f.a.aFa)) {
          break label2104;
        }
        if (Build.VERSION.SDK_INT >= 24)
        {
          j = Math.round(i2 / n);
          i = Math.round(i3 / n);
          break label1186;
        }
        j = (int)Math.floor(i2 / n);
        i = (int)Math.floor(i3 / n);
        break label1186;
        paramj = a(paramInputStream, localOptions, parama, paramj);
        j = paramj[0];
        i = paramj[1];
        break label1186;
        label1635:
        j = i2 / n;
        i = i3 / n;
        break label1186;
        label1652:
        localOptions.inTargetDensity = 0;
        localOptions.inDensity = 0;
      }
      break label311;
      if ((k >= 128) && (m >= 128) && (paramj.pA())) {}
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
          bool1 = com.bumptech.glide.c.g.a(this.aFH, paramInputStream, this.aFy).aFd;
          if (!bool1) {
            break label1815;
          }
          paramj = Bitmap.Config.ARGB_8888;
          localOptions.inPreferredConfig = paramj;
          if (localOptions.inPreferredConfig != Bitmap.Config.RGB_565) {
            break label383;
          }
          localOptions.inDither = true;
        }
        catch (IOException paramj)
        {
          if (!Log.isLoggable("Downsampler", 3)) {
            break label2123;
          }
        }
        new StringBuilder("Cannot determine whether the image has alpha or not from header, format ").append(localObject2);
        break label2123;
        paramj = Bitmap.Config.RGB_565;
        continue;
        bool1 = aLq.contains(localObject1);
        label2036:
        label2039:
        label2046:
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
          break label1100;
          i1 = i;
          break;
          i1 = 0;
          break;
          if (paramInt2 != -2147483648) {
            break label802;
          }
          m = i3;
          break label227;
          j = 0;
          break label346;
          if (!bool1) {
            break label501;
          }
        } while ((i2 < 0) || (i3 < 0) || (!bool2) || (i == 0));
        i = m;
        break label422;
        if (i2 % n != 0) {
          break label1608;
        }
        if (i3 % n == 0) {
          break label1635;
        }
        break label1608;
        bool1 = false;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(com.bumptech.glide.c.b.a.e parame, Bitmap paramBitmap);
    
    public abstract void py();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.d.a.h
 * JD-Core Version:    0.7.0.1
 */