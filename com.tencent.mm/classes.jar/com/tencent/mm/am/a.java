package com.tencent.mm.am;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.cache.g.a;
import com.tencent.mm.memory.a.c;

public final class a
{
  f<String, Bitmap> lAc;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(150193);
    this.lAc = new c(paramInt);
    AppMethodBeat.o(150193);
  }
  
  public final void c(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(150194);
    if (this.lAc != null)
    {
      this.lAc.q(paramString, paramBitmap);
      AppMethodBeat.o(150194);
      return;
    }
    g.a.a("avatar_cache", paramString, paramBitmap);
    AppMethodBeat.o(150194);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.am.a
 * JD-Core Version:    0.7.0.1
 */