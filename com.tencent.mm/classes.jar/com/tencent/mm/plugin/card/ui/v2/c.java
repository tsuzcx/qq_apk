package com.tencent.mm.plugin.card.ui.v2;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ai;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"radius_4dp", "", "getRadius_4dp", "()I", "plugin-card_release"})
public final class c
{
  private static final int oje;
  
  static
  {
    AppMethodBeat.i(112554);
    Context localContext = ai.getContext();
    k.g(localContext, "MMApplicationContext.getContext()");
    oje = localContext.getResources().getDimensionPixelOffset(2131165970);
    AppMethodBeat.o(112554);
  }
  
  public static final int bTA()
  {
    return oje;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.c
 * JD-Core Version:    0.7.0.1
 */