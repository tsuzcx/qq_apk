package com.tencent.mm.av.a.b;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.c.o;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class f
  implements o
{
  private com.tencent.mm.b.f<String, Bitmap> hfV;
  private com.tencent.mm.b.f<String, Bitmap> hfW;
  
  public f()
  {
    AppMethodBeat.i(130419);
    this.hfV = new b(50, getClass());
    this.hfW = new b(10, getClass());
    AppMethodBeat.o(130419);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(130422);
    Bitmap localBitmap;
    try
    {
      if (this.hfV != null)
      {
        Object localObject1 = this.hfV.snapshot();
        if ((!((Map)localObject1).isEmpty()) && (((Map)localObject1).size() > 0))
        {
          localObject1 = ((Map)localObject1).entrySet().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localBitmap = (Bitmap)((Map.Entry)((Iterator)localObject1).next()).getValue();
            if ((localBitmap != null) && (!localBitmap.isRecycled())) {
              ae.i("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "recycle bitmap:%s, not need", new Object[] { localBitmap.toString() });
            }
          }
        }
        this.hfV.clear();
      }
    }
    finally
    {
      AppMethodBeat.o(130422);
    }
    if (this.hfW != null)
    {
      Object localObject3 = this.hfW.snapshot();
      if ((!((Map)localObject3).isEmpty()) && (((Map)localObject3).size() > 0))
      {
        localObject3 = ((Map)localObject3).entrySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localBitmap = (Bitmap)((Map.Entry)((Iterator)localObject3).next()).getValue();
          if ((localBitmap != null) && (!localBitmap.isRecycled())) {
            ae.i("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "recycle bitmap:%s. not need", new Object[] { localBitmap.toString() });
          }
        }
      }
      this.hfW.clear();
    }
    AppMethodBeat.o(130422);
  }
  
  public final void put(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(130421);
    if (bu.isNullOrNil(paramString))
    {
      ae.w("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "[cpan] put failed. key is null.");
      AppMethodBeat.o(130421);
      return;
    }
    if (paramBitmap == null)
    {
      ae.w("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "[cpan] put failed.value is null.");
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
      ae.d("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "[cpan] put key:%s,bitmap size:%d B newsize:%s", new Object[] { paramString, Long.valueOf(l), bu.sL(l) });
      if (l <= 524288L) {
        break;
      }
      this.hfW.put(paramString, paramBitmap);
      AppMethodBeat.o(130421);
      return;
      int i = localBitmap.getRowBytes();
      l = localBitmap.getHeight() * i;
      continue;
      l = 0L;
    }
    this.hfV.put(paramString, paramBitmap);
    AppMethodBeat.o(130421);
  }
  
  public final Bitmap wA(String paramString)
  {
    AppMethodBeat.i(130420);
    if (!bu.isNullOrNil(paramString))
    {
      if (this.hfV.get(paramString) == null)
      {
        paramString = (Bitmap)this.hfW.get(paramString);
        AppMethodBeat.o(130420);
        return paramString;
      }
      paramString = (Bitmap)this.hfV.get(paramString);
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