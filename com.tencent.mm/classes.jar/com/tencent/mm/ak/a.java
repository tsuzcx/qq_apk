package com.tencent.mm.ak;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.cache.g.a;
import com.tencent.mm.memory.a.c;

public final class a
{
  f<String, Bitmap> gTg;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(150193);
    this.gTg = new c(paramInt);
    AppMethodBeat.o(150193);
  }
  
  public final void d(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(150194);
    if (this.gTg != null)
    {
      this.gTg.o(paramString, paramBitmap);
      AppMethodBeat.o(150194);
      return;
    }
    g.a.b("avatar_cache", paramString, paramBitmap);
    AppMethodBeat.o(150194);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ak.a
 * JD-Core Version:    0.7.0.1
 */