package com.tencent.mm.plugin.fts.ui;

import android.view.View;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.plugin.websearch.api.o;
import java.util.List;

final class FTSMainUI$9
  implements o
{
  FTSMainUI$9(FTSMainUI paramFTSMainUI) {}
  
  public final void m(String paramString, List<WidgetData> paramList)
  {
    if (FTSMainUI.a(this.kCm)) {
      FTSMainUI.b(this.kCm).setVisibility(0);
    }
    if (!this.kCm.bVk.equals(paramString)) {}
    while ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    if ((FTSMainUI.a(this.kCm)) && (FTSMainUI.j(this.kCm) != null))
    {
      FTSMainUI.j(this.kCm).c(paramList, e.kvx, this.kCm.bVk);
      FTSMainUI.j(this.kCm).show();
      FTSMainUI.i(this.kCm).setVisibility(0);
    }
    FTSMainUI.s(this.kCm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSMainUI.9
 * JD-Core Version:    0.7.0.1
 */