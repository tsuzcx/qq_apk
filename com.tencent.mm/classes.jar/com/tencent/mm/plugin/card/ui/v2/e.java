package com.tencent.mm.plugin.card.ui.v2;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"radius_4dp", "", "getRadius_4dp", "()I", "plugin-card_release"})
public final class e
{
  private static final int kAJ;
  
  static
  {
    AppMethodBeat.i(89328);
    Context localContext = ah.getContext();
    j.p(localContext, "MMApplicationContext.getContext()");
    kAJ = localContext.getResources().getDimensionPixelOffset(2131428171);
    AppMethodBeat.o(89328);
  }
  
  public static final int bfp()
  {
    return kAJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.e
 * JD-Core Version:    0.7.0.1
 */