package com.tencent.mm.plugin.fts.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.ui.c.b;
import com.tencent.mm.plugin.websearch.api.g;
import com.tencent.mm.sdk.platformtools.x;

final class FTSMainUI$10
  implements g
{
  FTSMainUI$10(FTSMainUI paramFTSMainUI) {}
  
  public final void bCU()
  {
    AppMethodBeat.i(61876);
    FTSMainUI.d(this.mYi).mXp.nav = 1;
    AppMethodBeat.o(61876);
  }
  
  public final void onClick()
  {
    AppMethodBeat.i(61875);
    b localb = FTSMainUI.k(this.mYi);
    k.a(this.mYi.query, FTSMainUI.d(this.mYi).getCount(), FTSMainUI.n(this.mYi), localb, 24);
    AppMethodBeat.o(61875);
  }
  
  public final boolean w(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(61877);
    int k = FTSMainUI.s(this.mYi);
    int j = FTSMainUI.t(this.mYi);
    int i = j;
    if (this.mYi.keyboardState() == -3) {
      i = j - x.gI(this.mYi);
    }
    if ((paramArrayOfInt[0] >= 0) && (paramArrayOfInt[0] < k) && (paramArrayOfInt[1] >= 0) && (paramArrayOfInt[1] < i))
    {
      AppMethodBeat.o(61877);
      return true;
    }
    AppMethodBeat.o(61877);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSMainUI.10
 * JD-Core Version:    0.7.0.1
 */