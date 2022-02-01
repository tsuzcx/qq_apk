package com.bumptech.glide.load.b.a;

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
  private static final Bitmap.Config aIy = Bitmap.Config.ARGB_8888;
  private final Set<Bitmap.Config> aIA;
  private final long aIB;
  private final a aIC;
  private long aID;
  private int aIE;
  private int aIF;
  private int aIG;
  private int aIH;
  private final l aIz;
  private long maxSize;
  
  public k(long paramLong) {}
  
  private k(long paramLong, l paraml, Set<Bitmap.Config> paramSet)
  {
    AppMethodBeat.i(77113);
    this.aIB = paramLong;
    this.maxSize = paramLong;
    this.aIz = paraml;
    this.aIA = paramSet;
    this.aIC = new b();
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
      paramConfig = aIy;
    }
  }
  
  private void dump()
  {
    AppMethodBeat.i(77123);
    if (Log.isLoggable("LruBitmapPool", 2)) {
      pe();
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
    l locall = this.aIz;
    Object localObject;
    if (paramConfig != null)
    {
      localObject = paramConfig;
      localObject = locall.b(paramInt1, paramInt2, (Bitmap.Config)localObject);
      if (localObject != null) {
        break label194;
      }
      if (Log.isLoggable("LruBitmapPool", 3)) {
        new StringBuilder("Missing bitmap=").append(this.aIz.c(paramInt1, paramInt2, paramConfig));
      }
      this.aIF += 1;
    }
    for (;;)
    {
      if (Log.isLoggable("LruBitmapPool", 2)) {
        new StringBuilder("Get bitmap=").append(this.aIz.c(paramInt1, paramInt2, paramConfig));
      }
      dump();
      AppMethodBeat.o(77119);
      return localObject;
      localObject = aIy;
      break;
      label194:
      this.aIE += 1;
      this.aID -= this.aIz.i((Bitmap)localObject);
      ((Bitmap)localObject).setHasAlpha(true);
      if (Build.VERSION.SDK_INT >= 19) {
        ((Bitmap)localObject).setPremultiplied(true);
      }
    }
  }
  
  private void o(long paramLong)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(77122);
        if (this.aID > paramLong)
        {
          Bitmap localBitmap = this.aIz.pa();
          if (localBitmap == null)
          {
            if (Log.isLoggable("LruBitmapPool", 5)) {
              pe();
            }
            this.aID = 0L;
            AppMethodBeat.o(77122);
            return;
          }
          this.aID -= this.aIz.i(localBitmap);
          this.aIH += 1;
          if (Log.isLoggable("LruBitmapPool", 3)) {
            new StringBuilder("Evicting bitmap=").append(this.aIz.h(localBitmap));
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
  
  private void pe()
  {
    AppMethodBeat.i(77124);
    new StringBuilder("Hits=").append(this.aIE).append(", misses=").append(this.aIF).append(", puts=").append(this.aIG).append(", evictions=").append(this.aIH).append(", currentSize=").append(this.aID).append(", maxSize=").append(this.maxSize).append("\nStrategy=").append(this.aIz);
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
    if ((!paramBitmap.isMutable()) || (this.aIz.i(paramBitmap) > this.maxSize) || (!this.aIA.contains(paramBitmap.getConfig())))
    {
      if (Log.isLoggable("LruBitmapPool", 2)) {
        new StringBuilder("Reject bitmap from pool, bitmap: ").append(this.aIz.h(paramBitmap)).append(", is mutable: ").append(paramBitmap.isMutable()).append(", is allowed config: ").append(this.aIA.contains(paramBitmap.getConfig()));
      }
      paramBitmap.recycle();
      AppMethodBeat.o(77115);
    }
    for (;;)
    {
      return;
      int i = this.aIz.i(paramBitmap);
      this.aIz.g(paramBitmap);
      this.aIG += 1;
      long l = this.aID;
      this.aID = (i + l);
      if (Log.isLoggable("LruBitmapPool", 2)) {
        new StringBuilder("Put bitmap in pool=").append(this.aIz.h(paramBitmap));
      }
      dump();
      o(this.maxSize);
      AppMethodBeat.o(77115);
    }
  }
  
  public final void oZ()
  {
    AppMethodBeat.i(77120);
    Log.isLoggable("LruBitmapPool", 3);
    o(0L);
    AppMethodBeat.o(77120);
  }
  
  @SuppressLint({"InlinedApi"})
  public final void trimMemory(int paramInt)
  {
    AppMethodBeat.i(77121);
    Log.isLoggable("LruBitmapPool", 3);
    if (paramInt >= 40)
    {
      oZ();
      AppMethodBeat.o(77121);
      return;
    }
    if ((paramInt >= 20) || (paramInt == 15)) {
      o(this.maxSize / 2L);
    }
    AppMethodBeat.o(77121);
  }
  
  static abstract interface a {}
  
  static final class b
    implements k.a
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.b.a.k
 * JD-Core Version:    0.7.0.1
 */