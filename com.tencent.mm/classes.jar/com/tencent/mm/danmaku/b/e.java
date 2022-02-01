package com.tencent.mm.danmaku.b;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.danmaku.c.a;
import com.tencent.mm.danmaku.d.h;
import com.tencent.mm.danmaku.render.h.a;

public class e
  extends d
{
  public h.a gPk;
  public boolean gPl = false;
  
  public e(a parama)
  {
    super(parama);
  }
  
  public com.tencent.mm.danmaku.d.b b(h paramh)
  {
    AppMethodBeat.i(241680);
    if (this.gPk != null)
    {
      final View localView = this.gPk.c(paramh);
      if (localView != null) {
        com.tencent.mm.danmaku.f.b.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(241678);
            localView.performClick();
            AppMethodBeat.o(241678);
          }
        });
      }
    }
    paramh = super.b(paramh);
    AppMethodBeat.o(241680);
    return paramh;
  }
  
  public final int getType()
  {
    return -2147483647;
  }
  
  public final void reset()
  {
    AppMethodBeat.i(241679);
    super.reset();
    this.gPl = false;
    AppMethodBeat.o(241679);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.danmaku.b.e
 * JD-Core Version:    0.7.0.1
 */