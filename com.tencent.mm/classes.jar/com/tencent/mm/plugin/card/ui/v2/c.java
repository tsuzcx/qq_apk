package com.tencent.mm.plugin.card.ui.v2;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"radius_4dp", "", "getRadius_4dp", "()I", "plugin-card_release"})
public final class c
{
  private static final int oMA;
  
  static
  {
    AppMethodBeat.i(112554);
    Context localContext = aj.getContext();
    p.g(localContext, "MMApplicationContext.getContext()");
    oMA = localContext.getResources().getDimensionPixelOffset(2131165970);
    AppMethodBeat.o(112554);
  }
  
  public static final int bYf()
  {
    return oMA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.c
 * JD-Core Version:    0.7.0.1
 */