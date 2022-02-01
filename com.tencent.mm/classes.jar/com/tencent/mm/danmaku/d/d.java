package com.tencent.mm.danmaku.d;

import android.graphics.Bitmap;
import android.util.LruCache;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.danmaku.f.a;

public final class d<T>
{
  private LruCache<String, T> jAQ;
  
  public d()
  {
    AppMethodBeat.i(256796);
    this.jAQ = new LruCache((int)Runtime.getRuntime().maxMemory() / 32) {};
    AppMethodBeat.o(256796);
  }
  
  static int u(Bitmap paramBitmap)
  {
    AppMethodBeat.i(256797);
    if (paramBitmap == null)
    {
      AppMethodBeat.o(256797);
      return 0;
    }
    int i = paramBitmap.getRowBytes();
    int j = paramBitmap.getHeight();
    AppMethodBeat.o(256797);
    return i * j;
  }
  
  public final void aAa()
  {
    AppMethodBeat.i(256798);
    if (a.aAf()) {
      try
      {
        this.jAQ.trimToSize(0);
        return;
      }
      finally
      {
        AppMethodBeat.o(256798);
      }
    }
    AppMethodBeat.o(256798);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.danmaku.d.d
 * JD-Core Version:    0.7.0.1
 */