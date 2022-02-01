package com.tencent.mm.aw.a.b;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.c.o;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class f
  implements o
{
  private com.tencent.mm.b.f<String, Bitmap> giL;
  private com.tencent.mm.b.f<String, Bitmap> giM;
  
  public f()
  {
    AppMethodBeat.i(130419);
    this.giL = new b(50, getClass());
    this.giM = new b(10, getClass());
    AppMethodBeat.o(130419);
  }
  
  public final void c(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(130421);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "[cpan] put failed. key is null.");
      AppMethodBeat.o(130421);
      return;
    }
    if (paramBitmap == null)
    {
      ad.w("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "[cpan] put failed.value is null.");
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
      ad.d("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "[cpan] put key:%s,bitmap size:%d B newsize:%s", new Object[] { paramString, Long.valueOf(l), bt.mK(l) });
      if (l <= 524288L) {
        break;
      }
      this.giM.put(paramString, paramBitmap);
      AppMethodBeat.o(130421);
      return;
      int i = localBitmap.getRowBytes();
      l = localBitmap.getHeight() * i;
      continue;
      l = 0L;
    }
    this.giL.put(paramString, paramBitmap);
    AppMethodBeat.o(130421);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(130422);
    Bitmap localBitmap;
    try
    {
      if (this.giL != null)
      {
        Object localObject1 = this.giL.snapshot();
        if ((!((Map)localObject1).isEmpty()) && (((Map)localObject1).size() > 0))
        {
          localObject1 = ((Map)localObject1).entrySet().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localBitmap = (Bitmap)((Map.Entry)((Iterator)localObject1).next()).getValue();
            if ((localBitmap != null) && (!localBitmap.isRecycled())) {
              ad.i("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "recycle bitmap:%s, not need", new Object[] { localBitmap.toString() });
            }
          }
        }
        this.giL.clear();
      }
    }
    finally
    {
      AppMethodBeat.o(130422);
    }
    if (this.giM != null)
    {
      Object localObject3 = this.giM.snapshot();
      if ((!((Map)localObject3).isEmpty()) && (((Map)localObject3).size() > 0))
      {
        localObject3 = ((Map)localObject3).entrySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localBitmap = (Bitmap)((Map.Entry)((Iterator)localObject3).next()).getValue();
          if ((localBitmap != null) && (!localBitmap.isRecycled())) {
            ad.i("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "recycle bitmap:%s. not need", new Object[] { localBitmap.toString() });
          }
        }
      }
      this.giM.clear();
    }
    AppMethodBeat.o(130422);
  }
  
  public final Bitmap pT(String paramString)
  {
    AppMethodBeat.i(130420);
    if (!bt.isNullOrNil(paramString))
    {
      if (this.giL.get(paramString) == null)
      {
        paramString = (Bitmap)this.giM.get(paramString);
        AppMethodBeat.o(130420);
        return paramString;
      }
      paramString = (Bitmap)this.giL.get(paramString);
      AppMethodBeat.o(130420);
      return paramString;
    }
    AppMethodBeat.o(130420);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aw.a.b.f
 * JD-Core Version:    0.7.0.1
 */