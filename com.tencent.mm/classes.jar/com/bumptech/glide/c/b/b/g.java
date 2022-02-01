package com.bumptech.glide.c.b.b;

import android.annotation.SuppressLint;
import com.bumptech.glide.c.b.u;
import com.bumptech.glide.h.f;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  extends f<com.bumptech.glide.c.h, u<?>>
  implements h
{
  private h.a aJh;
  
  public g(long paramLong)
  {
    super(paramLong);
  }
  
  public final void a(h.a parama)
  {
    this.aJh = parama;
  }
  
  @SuppressLint({"InlinedApi"})
  public final void trimMemory(int paramInt)
  {
    AppMethodBeat.i(77156);
    if (paramInt >= 40)
    {
      oU();
      AppMethodBeat.o(77156);
      return;
    }
    if ((paramInt >= 20) || (paramInt == 15)) {
      o(qr() / 2L);
    }
    AppMethodBeat.o(77156);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.b.b.g
 * JD-Core Version:    0.7.0.1
 */