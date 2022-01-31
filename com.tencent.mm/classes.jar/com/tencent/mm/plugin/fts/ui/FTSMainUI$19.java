package com.tencent.mm.plugin.fts.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.ui.widget.FTSLocalPageRelevantView;
import com.tencent.mm.plugin.websearch.api.e;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;

final class FTSMainUI$19
  implements j.b
{
  FTSMainUI$19(FTSMainUI paramFTSMainUI) {}
  
  public final void bCM()
  {
    AppMethodBeat.i(61892);
    String str = FTSMainUI.f(this.mYi).getQuery();
    if ((FTSMainUI.f(this.mYi).getVisibility() == 0) && (!bo.isNullOrNil(str)) && (!FTSMainUI.g(this.mYi).containsKey(str)))
    {
      FTSMainUI.g(this.mYi).put(str, Integer.valueOf(1));
      ((e)g.E(e.class)).at(str, FTSMainUI.f(this.mYi).getSearchId(), FTSMainUI.f(this.mYi).getWordList());
    }
    FTSMainUI.d(this.mYi).mXp.naw = 1;
    AppMethodBeat.o(61892);
  }
  
  public final void bCN()
  {
    AppMethodBeat.i(61893);
    if (FTSMainUI.h(this.mYi).getVisibility() == 0) {
      FTSMainUI.i(this.mYi).onResume();
    }
    AppMethodBeat.o(61893);
  }
  
  public final void bCO()
  {
    AppMethodBeat.i(61894);
    if (FTSMainUI.h(this.mYi).getVisibility() == 0) {
      FTSMainUI.i(this.mYi).onPause();
    }
    AppMethodBeat.o(61894);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSMainUI.19
 * JD-Core Version:    0.7.0.1
 */