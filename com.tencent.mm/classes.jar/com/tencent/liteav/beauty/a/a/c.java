package com.tencent.liteav.beauty.a.a;

import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class c
  extends b
{
  private Surface b;
  private boolean c;
  
  public c(a parama, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(parama);
    AppMethodBeat.i(66844);
    a(paramInt1, paramInt2);
    this.c = paramBoolean;
    AppMethodBeat.o(66844);
  }
  
  public void c()
  {
    AppMethodBeat.i(66845);
    a();
    if (this.b != null)
    {
      if (this.c) {
        this.b.release();
      }
      this.b = null;
    }
    AppMethodBeat.o(66845);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.liteav.beauty.a.a.c
 * JD-Core Version:    0.7.0.1
 */