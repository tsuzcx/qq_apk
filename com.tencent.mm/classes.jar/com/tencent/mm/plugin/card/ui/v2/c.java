package com.tencent.mm.plugin.card.ui.v2;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"radius_4dp", "", "getRadius_4dp", "()I", "plugin-card_release"})
public final class c
{
  private static final int nGd;
  
  static
  {
    AppMethodBeat.i(112554);
    Context localContext = aj.getContext();
    k.g(localContext, "MMApplicationContext.getContext()");
    nGd = localContext.getResources().getDimensionPixelOffset(2131165970);
    AppMethodBeat.o(112554);
  }
  
  public static final int bMn()
  {
    return nGd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.c
 * JD-Core Version:    0.7.0.1
 */