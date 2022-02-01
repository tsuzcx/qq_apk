package com.tencent.mm.danmaku.b;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.danmaku.c.a;
import com.tencent.mm.danmaku.d.h;
import com.tencent.mm.danmaku.render.h.a;

public class e
  extends d
{
  public h.a jzD;
  public boolean jzE = false;
  
  public e(a parama)
  {
    super(parama);
  }
  
  public com.tencent.mm.danmaku.d.b b(h paramh)
  {
    AppMethodBeat.i(289823);
    if (this.jzD != null)
    {
      final View localView = this.jzD.c(paramh);
      if (localView != null) {
        com.tencent.mm.danmaku.f.b.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(267564);
            localView.performClick();
            AppMethodBeat.o(267564);
          }
        });
      }
    }
    paramh = super.b(paramh);
    AppMethodBeat.o(289823);
    return paramh;
  }
  
  public final int getType()
  {
    return -2147483647;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(289822);
    super.reset();
    this.jzE = false;
    AppMethodBeat.o(289822);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.danmaku.b.e
 * JD-Core Version:    0.7.0.1
 */