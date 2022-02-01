package com.tencent.mm.ay.a.b;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.c.o;
import com.tencent.mm.f.a.mv;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class f
  implements o
{
  private static a lSf = null;
  private final com.tencent.mm.b.f<String, Bitmap> kNw;
  private final com.tencent.mm.b.f<String, Bitmap> kNx;
  
  public f()
  {
    AppMethodBeat.i(130419);
    this.kNw = new b(50, getClass());
    this.kNx = new b(10, getClass());
    if (lSf != null) {
      lSf.dead();
    }
    a locala = new a(this);
    lSf = locala;
    locala.alive();
    AppMethodBeat.o(130419);
  }
  
  public final Bitmap LI(String paramString)
  {
    AppMethodBeat.i(130420);
    if (!Util.isNullOrNil(paramString))
    {
      if (this.kNw.get(paramString) == null)
      {
        paramString = (Bitmap)this.kNx.get(paramString);
        AppMethodBeat.o(130420);
        return paramString;
      }
      paramString = (Bitmap)this.kNw.get(paramString);
      AppMethodBeat.o(130420);
      return paramString;
    }
    AppMethodBeat.o(130420);
    return null;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(130422);
    Bitmap localBitmap;
    try
    {
      if (this.kNw != null)
      {
        Object localObject1 = this.kNw.snapshot();
        if ((!((Map)localObject1).isEmpty()) && (((Map)localObject1).size() > 0))
        {
          localObject1 = ((Map)localObject1).entrySet().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localBitmap = (Bitmap)((Map.Entry)((Iterator)localObject1).next()).getValue();
            if ((localBitmap != null) && (!localBitmap.isRecycled())) {
              Log.i("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "recycle bitmap:%s, not need", new Object[] { localBitmap.toString() });
            }
          }
        }
        this.kNw.clear();
      }
    }
    finally
    {
      AppMethodBeat.o(130422);
    }
    if (this.kNx != null)
    {
      Object localObject3 = this.kNx.snapshot();
      if ((!((Map)localObject3).isEmpty()) && (((Map)localObject3).size() > 0))
      {
        localObject3 = ((Map)localObject3).entrySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localBitmap = (Bitmap)((Map.Entry)((Iterator)localObject3).next()).getValue();
          if ((localBitmap != null) && (!localBitmap.isRecycled())) {
            Log.i("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "recycle bitmap:%s. not need", new Object[] { localBitmap.toString() });
          }
        }
      }
      this.kNx.clear();
    }
    AppMethodBeat.o(130422);
  }
  
  public final void put(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(130421);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "[cpan] put failed. key is null.");
      AppMethodBeat.o(130421);
      return;
    }
    if (paramBitmap == null)
    {
      Log.w("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "[cpan] put failed.value is null.");
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
      Log.d("MicroMsg.imageloader.DefaultImageMemoryCacheListener", "[cpan] put key:%s,bitmap size:%d B newsize:%s", new Object[] { paramString, Long.valueOf(l), Util.getSizeKB(l) });
      if (l <= 524288L) {
        break;
      }
      this.kNx.put(paramString, paramBitmap);
      AppMethodBeat.o(130421);
      return;
      int i = localBitmap.getRowBytes();
      l = localBitmap.getHeight() * i;
      continue;
      l = 0L;
    }
    this.kNw.put(paramString, paramBitmap);
    AppMethodBeat.o(130421);
  }
  
  public final void remove(String paramString)
  {
    AppMethodBeat.i(246207);
    this.kNw.remove(paramString);
    this.kNx.remove(paramString);
    AppMethodBeat.o(246207);
  }
  
  static final class a
    extends IListener<mv>
  {
    private final WeakReference<f> kNt;
    
    public a(f paramf)
    {
      AppMethodBeat.i(246251);
      this.kNt = new WeakReference(paramf);
      this.__eventId = mv.class.getName().hashCode();
      AppMethodBeat.o(246251);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ay.a.b.f
 * JD-Core Version:    0.7.0.1
 */