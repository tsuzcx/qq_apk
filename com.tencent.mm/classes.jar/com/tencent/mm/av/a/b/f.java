package com.tencent.mm.av.a.b;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.c.o;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class f
  implements o
{
  private com.tencent.mm.b.f<String, Bitmap> gJw;
  private com.tencent.mm.b.f<String, Bitmap> gJx;
  
  public f()
  {
    AppMethodBeat.i(130419);
    this.gJw = new b(50, getClass());
    this.gJx = new b(10, getClass());
    AppMethodBeat.o(130419);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(130422);
    Bitmap localBitmap;
    try
    {
      if (this.gJw != null)
      {
        Object localObject1 = this.gJw.snapshot();
        if ((!((Map)localObject1).isEmpty()) && (((Map)localObject1).size() > 0))
        {
          localObject1 = ((Map)localObject1).entrySet().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localBitmap = (Bitmap)((Map.Entry)((Iterator)localObject1).next()).getValue();
            if ((localBitmap != null) && (!localBitmap.isRecycled())) {
              ac.i("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "recycle bitmap:%s, not need", new Object[] { localBitmap.toString() });
            }
          }
        }
        this.gJw.clear();
      }
    }
    finally
    {
      AppMethodBeat.o(130422);
    }
    if (this.gJx != null)
    {
      Object localObject3 = this.gJx.snapshot();
      if ((!((Map)localObject3).isEmpty()) && (((Map)localObject3).size() > 0))
      {
        localObject3 = ((Map)localObject3).entrySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localBitmap = (Bitmap)((Map.Entry)((Iterator)localObject3).next()).getValue();
          if ((localBitmap != null) && (!localBitmap.isRecycled())) {
            ac.i("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "recycle bitmap:%s. not need", new Object[] { localBitmap.toString() });
          }
        }
      }
      this.gJx.clear();
    }
    AppMethodBeat.o(130422);
  }
  
  public final void put(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(130421);
    if (bs.isNullOrNil(paramString))
    {
      ac.w("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "[cpan] put failed. key is null.");
      AppMethodBeat.o(130421);
      return;
    }
    if (paramBitmap == null)
    {
      ac.w("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "[cpan] put failed.value is null.");
      AppMethodBeat.o(130421);
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
      ac.d("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "[cpan] put key:%s,bitmap size:%d B newsize:%s", new Object[] { paramString, Long.valueOf(l), bs.qz(l) });
      if (l <= 524288L) {
        break;
      }
      this.gJx.put(paramString, paramBitmap);
      AppMethodBeat.o(130421);
      return;
      int i = localBitmap.getRowBytes();
      l = localBitmap.getHeight() * i;
      continue;
      l = 0L;
    }
    this.gJw.put(paramString, paramBitmap);
    AppMethodBeat.o(130421);
  }
  
  public final Bitmap te(String paramString)
  {
    AppMethodBeat.i(130420);
    if (!bs.isNullOrNil(paramString))
    {
      if (this.gJw.get(paramString) == null)
      {
        paramString = (Bitmap)this.gJx.get(paramString);
        AppMethodBeat.o(130420);
        return paramString;
      }
      paramString = (Bitmap)this.gJw.get(paramString);
      AppMethodBeat.o(130420);
      return paramString;
    }
    AppMethodBeat.o(130420);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.av.a.b.f
 * JD-Core Version:    0.7.0.1
 */