package com.tencent.mm.as.a.b;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import com.tencent.mm.as.a.c.m;
import com.tencent.mm.as.a.d.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class f
  implements m
{
  private a<String, Bitmap> erL = new a(50);
  private a<String, Bitmap> erM = new a(10);
  
  public final void c(String paramString, Bitmap paramBitmap)
  {
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "[cpan] put failed. key is null.");
      return;
    }
    if (paramBitmap == null)
    {
      y.w("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "[cpan] put failed.value is null.");
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
      y.d("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "[cpan] put key:%s,bitmap size:%d B newsize:%s", new Object[] { paramString, Long.valueOf(l), bk.cm(l) });
      if (l <= 524288L) {
        break;
      }
      this.erM.put(paramString, paramBitmap);
      return;
      int i = localBitmap.getRowBytes();
      l = localBitmap.getHeight() * i;
      continue;
      l = 0L;
    }
    this.erL.put(paramString, paramBitmap);
  }
  
  public final void clear()
  {
    Bitmap localBitmap;
    try
    {
      if (this.erL != null)
      {
        Object localObject1 = this.erL.snapshot();
        if ((!((Map)localObject1).isEmpty()) && (((Map)localObject1).size() > 0))
        {
          localObject1 = ((Map)localObject1).entrySet().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localBitmap = (Bitmap)((Map.Entry)((Iterator)localObject1).next()).getValue();
            if ((localBitmap != null) && (!localBitmap.isRecycled())) {
              y.i("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "recycle bitmap:%s, not need", new Object[] { localBitmap.toString() });
            }
          }
        }
        this.erL.clear();
      }
    }
    finally {}
    if (this.erM != null)
    {
      Object localObject3 = this.erM.snapshot();
      if ((!((Map)localObject3).isEmpty()) && (((Map)localObject3).size() > 0))
      {
        localObject3 = ((Map)localObject3).entrySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localBitmap = (Bitmap)((Map.Entry)((Iterator)localObject3).next()).getValue();
          if ((localBitmap != null) && (!localBitmap.isRecycled())) {
            y.i("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "recycle bitmap:%s. not need", new Object[] { localBitmap.toString() });
          }
        }
      }
      this.erM.clear();
    }
  }
  
  public final Bitmap jK(String paramString)
  {
    if (!bk.bl(paramString))
    {
      if (this.erL.get(paramString) == null) {
        return (Bitmap)this.erM.get(paramString);
      }
      return (Bitmap)this.erL.get(paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.as.a.b.f
 * JD-Core Version:    0.7.0.1
 */