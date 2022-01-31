package com.tencent.mm.plugin.fts.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.plugin.websearch.api.o;
import java.util.List;

final class FTSMainUI$8
  implements o
{
  FTSMainUI$8(FTSMainUI paramFTSMainUI) {}
  
  public final void n(String paramString, List<WidgetData> paramList)
  {
    AppMethodBeat.i(61873);
    if (FTSMainUI.a(this.mYi)) {
      FTSMainUI.b(this.mYi).setVisibility(0);
    }
    if (!this.mYi.query.equals(paramString))
    {
      AppMethodBeat.o(61873);
      return;
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(61873);
      return;
    }
    if ((FTSMainUI.a(this.mYi)) && (FTSMainUI.i(this.mYi) != null))
    {
      FTSMainUI.i(this.mYi).d(paramList, String.valueOf(e.mRk), this.mYi.query);
      FTSMainUI.i(this.mYi).show();
      FTSMainUI.h(this.mYi).setVisibility(0);
    }
    FTSMainUI.r(this.mYi);
    AppMethodBeat.o(61873);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSMainUI.8
 * JD-Core Version:    0.7.0.1
 */