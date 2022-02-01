package com.tencent.mm.plugin.finder.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.h.d;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "whichButton", "", "<anonymous parameter 1>", "onClick"})
final class FinderSettingsUI$n$a
  implements h.d
{
  FinderSettingsUI$n$a(FinderSettingsUI.n paramn) {}
  
  public final void cv(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(199410);
    try
    {
      b localb = b.qJA;
      b.ahu(paramInt1);
      AppMethodBeat.o(199410);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace(this.KZJ.qPT.TAG, (Throwable)localException, "", new Object[0]);
      AppMethodBeat.o(199410);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSettingsUI.n.a
 * JD-Core Version:    0.7.0.1
 */