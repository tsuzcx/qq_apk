package com.bumptech.glide.c.b.a;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

public final class k
  implements e
{
  private static final Bitmap.Config aFY = Bitmap.Config.ARGB_8888;
  private final l aFZ;
  private final Set<Bitmap.Config> aGa;
  private final long aGb;
  private final a aGc;
  private long aGd;
  private int aGe;
  private int aGf;
  private int aGg;
  private int aGh;
  private long maxSize;
  
  public k(long paramLong) {}
  
  private k(long paramLong, l paraml, Set<Bitmap.Config> paramSet)
  {
    AppMethodBeat.i(77113);
    this.aGb = paramLong;
    this.maxSize = paramLong;
    this.aFZ = paraml;
    this.aGa = paramSet;
    this.aGc = new b();
    AppMethodBeat.o(77113);
  }
  
  private static Bitmap createBitmap(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    AppMethodBeat.i(77118);
    if (paramConfig != null) {}
    for (;;)
    {
      paramConfig = Bitmap.createBitmap(paramInt1, paramInt2, paramConfig);
      AppMethodBeat.o(77118);
      return paramConfig;
      paramConfig = aFY;
    }
  }
  
  private void dump()
  {
    AppMethodBeat.i(77123);
    if (Log.isLoggable("LruBitmapPool", 2)) {
      ox();
    }
    AppMethodBeat.o(77123);
  }
  
  private Bitmap h(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    try
    {
      AppMethodBeat.i(77119);
      if ((Build.VERSION.SDK_INT >= 26) && (paramConfig == Bitmap.Config.HARDWARE))
      {
        paramConfig = new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + paramConfig + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
        AppMethodBeat.o(77119);
        throw paramConfig;
      }
    }
    finally {}
    l locall = this.aFZ;
    Object localObject;
    if (paramConfig != null)
    {
      localObject = paramConfig;
      localObject = locall.b(paramInt1, paramInt2, (Bitmap.Config)localObject);
      if (localObject != null) {
        break label194;
      }
      if (Log.isLoggable("LruBitmapPool", 3)) {
        new StringBuilder("Missing bitmap=").append(this.aFZ.c(paramInt1, paramInt2, paramConfig));
      }
      this.aGf += 1;
    }
    for (;;)
    {
      if (Log.isLoggable("LruBitmapPool", 2)) {
        new StringBuilder("Get bitmap=").append(this.aFZ.c(paramInt1, paramInt2, paramConfig));
      }
      dump();
      AppMethodBeat.o(77119);
      return localObject;
      localObject = aFY;
      break;
      label194:
      this.aGe += 1;
      this.aGd -= this.aFZ.i((Bitmap)localObject);
      ((Bitmap)localObject).setHasAlpha(true);
      if (Build.VERSION.SDK_INT >= 19) {
        ((Bitmap)localObject).setPremultiplied(true);
      }
    }
  }
  
  private void m(long paramLong)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(77122);
        if (this.aGd > paramLong)
        {
          Bitmap localBitmap = this.aFZ.ot();
          if (localBitmap == null)
          {
            if (Log.isLoggable("LruBitmapPool", 5)) {
              ox();
            }
            this.aGd = 0L;
            AppMethodBeat.o(77122);
            return;
          }
          this.aGd -= this.aFZ.i(localBitmap);
          this.aGh += 1;
          if (Log.isLoggable("LruBitmapPool", 3)) {
            new StringBuilder("Evicting bitmap=").append(this.aFZ.h(localBitmap));
          }
          dump();
          localBitmap.recycle();
        }
        else
        {
          AppMethodBeat.o(77122);
        }
      }
      finally {}
    }
  }
  
  private void ox()
  {
    AppMethodBeat.i(77124);
    new StringBuilder("Hits=").append(this.aGe).append(", misses=").append(this.aGf).append(", puts=").append(this.aGg).append(", evictions=").append(this.aGh).append(", currentSize=").append(this.aGd).append(", maxSize=").append(this.maxSize).append("\nStrategy=").append(this.aFZ);
    AppMethodBeat.o(77124);
  }
  
  public final Bitmap b(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    AppMethodBeat.i(77116);
    Bitmap localBitmap = h(paramInt1, paramInt2, paramConfig);
    if (localBitmap != null) {
      localBitmap.eraseColor(0);
    }
    for (paramConfig = localBitmap;; paramConfig = createBitmap(paramInt1, paramInt2, paramConfig))
    {
      AppMethodBeat.o(77116);
      return paramConfig;
    }
  }
  
  public final Bitmap g(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    AppMethodBeat.i(77117);
    Bitmap localBitmap2 = h(paramInt1, paramInt2, paramConfig);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null) {
      localBitmap1 = createBitmap(paramInt1, paramInt2, paramConfig);
    }
    AppMethodBeat.o(77117);
    return localBitmap1;
  }
  
  public final void g(Bitmap paramBitmap)
  {
    try
    {
      AppMethodBeat.i(77115);
      if (paramBitmap == null)
      {
        paramBitmap = new NullPointerException("Bitmap must not be null");
        AppMethodBeat.o(77115);
        throw paramBitmap;
      }
    }
    finally {}
    if (paramBitmap.isRecycled())
    {
      paramBitmap = new IllegalStateException("Cannot pool recycled bitmap");
      AppMethodBeat.o(77115);
      throw paramBitmap;
    }
    if ((!paramBitmap.isMutable()) || (this.aFZ.i(paramBitmap) > this.maxSize) || (!this.aGa.contains(paramBitmap.getConfig())))
    {
      if (Log.isLoggable("LruBitmapPool", 2)) {
        new StringBuilder("Reject bitmap from pool, bitmap: ").append(this.aFZ.h(paramBitmap)).append(", is mutable: ").append(paramBitmap.isMutable()).append(", is allowed config: ").append(this.aGa.contains(paramBitmap.getConfig()));
      }
      paramBitmap.recycle();
      AppMethodBeat.o(77115);
    }
    for (;;)
    {
      return;
      int i = this.aFZ.i(paramBitmap);
      this.aFZ.g(paramBitmap);
      this.aGg += 1;
      long l = this.aGd;
      this.aGd = (i + l);
      if (Log.isLoggable("LruBitmapPool", 2)) {
        new StringBuilder("Put bitmap in pool=").append(this.aFZ.h(paramBitmap));
      }
      dump();
      m(this.maxSize);
      AppMethodBeat.o(77115);
    }
  }
  
  public final void os()
  {
    AppMethodBeat.i(77120);
    Log.isLoggable("LruBitmapPool", 3);
    m(0L);
    AppMethodBeat.o(77120);
  }
  
  @SuppressLint({"InlinedApi"})
  public final void trimMemory(int paramInt)
  {
    AppMethodBeat.i(77121);
    Log.isLoggable("LruBitmapPool", 3);
    if (paramInt >= 40)
    {
      os();
      AppMethodBeat.o(77121);
      return;
    }
    if ((paramInt >= 20) || (paramInt == 15)) {
      m(this.maxSize / 2L);
    }
    AppMethodBeat.o(77121);
  }
  
  static abstract interface a {}
  
  static final class b
    implements k.a
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.c.b.a.k
 * JD-Core Version:    0.7.0.1
 */