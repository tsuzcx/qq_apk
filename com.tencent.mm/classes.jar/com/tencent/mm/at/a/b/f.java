package com.tencent.mm.at.a.b;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.c.m;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class f
  implements m
{
  private com.tencent.mm.a.f<String, Bitmap> eNs;
  private com.tencent.mm.a.f<String, Bitmap> eNt;
  
  public f()
  {
    AppMethodBeat.i(116089);
    this.eNs = new b(50, getClass());
    this.eNt = new b(10, getClass());
    AppMethodBeat.o(116089);
  }
  
  public final void c(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(116091);
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "[cpan] put failed. key is null.");
      AppMethodBeat.o(116091);
      return;
    }
    if (paramBitmap == null)
    {
      ab.w("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "[cpan] put failed.value is null.");
      AppMethodBeat.o(116091);
      return;
    }
    Bitmap localBitmap;
    long l;
    if ((paramBitmap != null) && ((paramBitmap instanceof Bitmap)))
    {
      localBitmap = (Bitmap)paramBitmap;
      if (Build.VERSION.SDK_INT >= 12) {
        l = localBitmap.getByteCount();
      }
    }
    for (;;)
    {
      ab.d("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "[cpan] put key:%s,bitmap size:%d B newsize:%s", new Object[] { paramString, Long.valueOf(l), bo.hk(l) });
      if (l <= 524288L) {
        break;
      }
      this.eNt.put(paramString, paramBitmap);
      AppMethodBeat.o(116091);
      return;
      int i = localBitmap.getRowBytes();
      l = localBitmap.getHeight() * i;
      continue;
      l = 0L;
    }
    this.eNs.put(paramString, paramBitmap);
    AppMethodBeat.o(116091);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(116092);
    Bitmap localBitmap;
    try
    {
      if (this.eNs != null)
      {
        Object localObject1 = this.eNs.snapshot();
        if ((!((Map)localObject1).isEmpty()) && (((Map)localObject1).size() > 0))
        {
          localObject1 = ((Map)localObject1).entrySet().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localBitmap = (Bitmap)((Map.Entry)((Iterator)localObject1).next()).getValue();
            if ((localBitmap != null) && (!localBitmap.isRecycled())) {
              ab.i("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "recycle bitmap:%s, not need", new Object[] { localBitmap.toString() });
            }
          }
        }
        this.eNs.clear();
      }
    }
    finally
    {
      AppMethodBeat.o(116092);
    }
    if (this.eNt != null)
    {
      Object localObject3 = this.eNt.snapshot();
      if ((!((Map)localObject3).isEmpty()) && (((Map)localObject3).size() > 0))
      {
        localObject3 = ((Map)localObject3).entrySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localBitmap = (Bitmap)((Map.Entry)((Iterator)localObject3).next()).getValue();
          if ((localBitmap != null) && (!localBitmap.isRecycled())) {
            ab.i("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "recycle bitmap:%s. not need", new Object[] { localBitmap.toString() });
          }
        }
      }
      this.eNt.clear();
    }
    AppMethodBeat.o(116092);
  }
  
  public final Bitmap lK(String paramString)
  {
    AppMethodBeat.i(116090);
    if (!bo.isNullOrNil(paramString))
    {
      if (this.eNs.get(paramString) == null)
      {
        paramString = (Bitmap)this.eNt.get(paramString);
        AppMethodBeat.o(116090);
        return paramString;
      }
      paramString = (Bitmap)this.eNs.get(paramString);
      AppMethodBeat.o(116090);
      return paramString;
    }
    AppMethodBeat.o(116090);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.at.a.b.f
 * JD-Core Version:    0.7.0.1
 */