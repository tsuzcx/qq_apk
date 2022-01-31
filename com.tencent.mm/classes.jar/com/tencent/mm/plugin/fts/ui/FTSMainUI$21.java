package com.tencent.mm.plugin.fts.ui;

import android.view.View;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.ui.widget.FTSLocalPageRelevantView;
import com.tencent.mm.plugin.websearch.api.e;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.Map;

final class FTSMainUI$21
  implements j.b
{
  FTSMainUI$21(FTSMainUI paramFTSMainUI) {}
  
  public final void aWj()
  {
    String str = FTSMainUI.g(this.kCm).getQuery();
    if ((FTSMainUI.g(this.kCm).getVisibility() == 0) && (!bk.bl(str)) && (!FTSMainUI.h(this.kCm).containsKey(str)))
    {
      FTSMainUI.h(this.kCm).put(str, Integer.valueOf(1));
      ((e)g.r(e.class)).af(str, FTSMainUI.g(this.kCm).getSearchId(), FTSMainUI.g(this.kCm).getWordList());
    }
    FTSMainUI.f(this.kCm).kBw.kEl = 1;
  }
  
  public final void aWk()
  {
    if (FTSMainUI.i(this.kCm).getVisibility() == 0) {
      FTSMainUI.j(this.kCm).onResume();
    }
  }
  
  public final void aWl()
  {
    if (FTSMainUI.i(this.kCm).getVisibility() == 0) {
      FTSMainUI.j(this.kCm).onPause();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSMainUI.21
 * JD-Core Version:    0.7.0.1
 */