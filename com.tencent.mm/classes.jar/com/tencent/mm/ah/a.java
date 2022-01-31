package com.tencent.mm.ah;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.cache.f.a;
import com.tencent.mm.memory.a.c;

public final class a
{
  f<String, Bitmap> frn;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(77829);
    this.frn = new c(paramInt);
    AppMethodBeat.o(77829);
  }
  
  public final void d(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(77830);
    if (this.frn != null)
    {
      this.frn.f(paramString, paramBitmap);
      AppMethodBeat.o(77830);
      return;
    }
    f.a.a("avatar_cache", paramString, paramBitmap);
    AppMethodBeat.o(77830);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ah.a
 * JD-Core Version:    0.7.0.1
 */