package com.tencent.mm.modelavatar;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.cache.g.a;
import com.tencent.mm.memory.a.c;

public final class a
{
  f<String, Bitmap> orD;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(150193);
    this.orD = new c(paramInt);
    AppMethodBeat.o(150193);
  }
  
  public final void c(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(150194);
    if (this.orD != null)
    {
      this.orD.B(paramString, paramBitmap);
      AppMethodBeat.o(150194);
      return;
    }
    g.a.c("avatar_cache", paramString, paramBitmap);
    AppMethodBeat.o(150194);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelavatar.a
 * JD-Core Version:    0.7.0.1
 */