package com.bumptech.glide.load.b.b;

import android.annotation.SuppressLint;
import com.bumptech.glide.load.b.v;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  extends com.bumptech.glide.g.g<com.bumptech.glide.load.g, v<?>>
  implements h
{
  private h.a aJa;
  
  public g(long paramLong)
  {
    super(paramLong);
  }
  
  public final void a(h.a parama)
  {
    this.aJa = parama;
  }
  
  @SuppressLint({"InlinedApi"})
  public final void trimMemory(int paramInt)
  {
    AppMethodBeat.i(77156);
    if (paramInt >= 40)
    {
      oZ();
      AppMethodBeat.o(77156);
      return;
    }
    if ((paramInt >= 20) || (paramInt == 15)) {
      o(qu() / 2L);
    }
    AppMethodBeat.o(77156);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.b.b.g
 * JD-Core Version:    0.7.0.1
 */