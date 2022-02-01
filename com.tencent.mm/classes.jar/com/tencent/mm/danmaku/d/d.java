package com.tencent.mm.danmaku.d;

import android.graphics.Bitmap;
import android.util.LruCache;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.danmaku.f.a;

public final class d<T>
{
  private LruCache<String, T> gQx;
  
  public d()
  {
    AppMethodBeat.i(241747);
    this.gQx = new LruCache((int)Runtime.getRuntime().maxMemory() / 32) {};
    AppMethodBeat.o(241747);
  }
  
  static int z(Bitmap paramBitmap)
  {
    AppMethodBeat.i(241748);
    if (paramBitmap == null)
    {
      AppMethodBeat.o(241748);
      return 0;
    }
    int i = paramBitmap.getRowBytes();
    int j = paramBitmap.getHeight();
    AppMethodBeat.o(241748);
    return i * j;
  }
  
  public final void atl()
  {
    AppMethodBeat.i(241749);
    if (a.atp()) {
      try
      {
        this.gQx.trimToSize(0);
        return;
      }
      finally
      {
        AppMethodBeat.o(241749);
      }
    }
    AppMethodBeat.o(241749);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.danmaku.d.d
 * JD-Core Version:    0.7.0.1
 */