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
  private static final Bitmap.Config aIF = Bitmap.Config.ARGB_8888;
  private final l aIG;
  private final Set<Bitmap.Config> aIH;
  private final long aII;
  private final a aIJ;
  private long aIK;
  private int aIL;
  private int aIM;
  private int aIN;
  private int aIO;
  private long maxSize;
  
  public k(long paramLong) {}
  
  private k(long paramLong, l paraml, Set<Bitmap.Config> paramSet)
  {
    AppMethodBeat.i(77113);
    this.aII = paramLong;
    this.maxSize = paramLong;
    this.aIG = paraml;
    this.aIH = paramSet;
    this.aIJ = new b();
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
      paramConfig = aIF;
    }
  }
  
  private void dump()
  {
    AppMethodBeat.i(77123);
    if (Log.isLoggable("LruBitmapPool", 2)) {
      oZ();
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
    l locall = this.aIG;
    Object localObject;
    if (paramConfig != null)
    {
      localObject = paramConfig;
      localObject = locall.b(paramInt1, paramInt2, (Bitmap.Config)localObject);
      if (localObject != null) {
        break label194;
      }
      if (Log.isLoggable("LruBitmapPool", 3)) {
        new StringBuilder("Missing bitmap=").append(this.aIG.c(paramInt1, paramInt2, paramConfig));
      }
      this.aIM += 1;
    }
    for (;;)
    {
      if (Log.isLoggable("LruBitmapPool", 2)) {
        new StringBuilder("Get bitmap=").append(this.aIG.c(paramInt1, paramInt2, paramConfig));
      }
      dump();
      AppMethodBeat.o(77119);
      return localObject;
      localObject = aIF;
      break;
      label194:
      this.aIL += 1;
      this.aIK -= this.aIG.i((Bitmap)localObject);
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
        if (this.aIK > paramLong)
        {
          Bitmap localBitmap = this.aIG.oV();
          if (localBitmap == null)
          {
            if (Log.isLoggable("LruBitmapPool", 5)) {
              oZ();
            }
            this.aIK = 0L;
            AppMethodBeat.o(77122);
            return;
          }
          this.aIK -= this.aIG.i(localBitmap);
          this.aIO += 1;
          if (Log.isLoggable("LruBitmapPool", 3)) {
            new StringBuilder("Evicting bitmap=").append(this.aIG.h(localBitmap));
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
  
  private void oZ()
  {
    AppMethodBeat.i(77124);
    new StringBuilder("Hits=").append(this.aIL).append(", misses=").append(this.aIM).append(", puts=").append(this.aIN).append(", evictions=").append(this.aIO).append(", currentSize=").append(this.aIK).append(", maxSize=").append(this.maxSize).append("\nStrategy=").append(this.aIG);
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
    if ((!paramBitmap.isMutable()) || (this.aIG.i(paramBitmap) > this.maxSize) || (!this.aIH.contains(paramBitmap.getConfig())))
    {
      if (Log.isLoggable("LruBitmapPool", 2)) {
        new StringBuilder("Reject bitmap from pool, bitmap: ").append(this.aIG.h(paramBitmap)).append(", is mutable: ").append(paramBitmap.isMutable()).append(", is allowed config: ").append(this.aIH.contains(paramBitmap.getConfig()));
      }
      paramBitmap.recycle();
      AppMethodBeat.o(77115);
    }
    for (;;)
    {
      return;
      int i = this.aIG.i(paramBitmap);
      this.aIG.g(paramBitmap);
      this.aIN += 1;
      long l = this.aIK;
      this.aIK = (i + l);
      if (Log.isLoggable("LruBitmapPool", 2)) {
        new StringBuilder("Put bitmap in pool=").append(this.aIG.h(paramBitmap));
      }
      dump();
      o(this.maxSize);
      AppMethodBeat.o(77115);
    }
  }
  
  public final void oU()
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
      oU();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.b.a.k
 * JD-Core Version:    0.7.0.1
 */