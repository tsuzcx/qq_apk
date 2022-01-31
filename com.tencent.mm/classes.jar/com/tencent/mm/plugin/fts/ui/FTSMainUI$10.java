package com.tencent.mm.plugin.fts.ui;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.plugin.fts.ui.widget.FTSLocalPageRelevantView;
import com.tencent.mm.plugin.websearch.api.d;
import com.tencent.mm.protocal.c.bki;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

final class FTSMainUI$10
  implements d
{
  FTSMainUI$10(FTSMainUI paramFTSMainUI) {}
  
  public final void a(boolean paramBoolean, bki parambki, String paramString1, String paramString2)
  {
    if (!this.kCm.bVk.equals(paramString2)) {
      y.i("MicroMsg.FTS.FTSMainUI", "IRelevantSearchCallback callback with query %s, current query is %s ", new Object[] { paramString2, this.kCm.bVk });
    }
    for (;;)
    {
      return;
      if (!paramBoolean) {
        break;
      }
      if (FTSMainUI.b(this.kCm).getVisibility() == 0)
      {
        FTSLocalPageRelevantView localFTSLocalPageRelevantView = FTSMainUI.g(this.kCm);
        int i;
        if ((parambki == null) || (parambki.sxL == null))
        {
          y.w("MicroMsg.FTS.FTSLocalPageRelevantView", "configRelevantDatas param nil!");
          i = 0;
        }
        while (i != 0)
        {
          FTSMainUI.g(this.kCm).setVisibility(0);
          return;
          List localList = FTSLocalPageRelevantView.bC(parambki.sxL);
          if (localList.size() <= 0)
          {
            y.w("MicroMsg.FTS.FTSLocalPageRelevantView", "configRelevantDatas size 0 items!");
            i = 0;
          }
          else
          {
            localFTSLocalPageRelevantView.bVk = paramString2;
            localFTSLocalPageRelevantView.fTF = paramString1;
            localFTSLocalPageRelevantView.kEG = parambki.sxL;
            if (localFTSLocalPageRelevantView.fXV == null)
            {
              localFTSLocalPageRelevantView.fXV = new LinearLayout(localFTSLocalPageRelevantView.getContext());
              localFTSLocalPageRelevantView.fXV.setOrientation(1);
              parambki = (LinearLayout.LayoutParams)localFTSLocalPageRelevantView.getLayoutParams();
              parambki.width = -1;
              parambki.height = -2;
              localFTSLocalPageRelevantView.addView(localFTSLocalPageRelevantView.fXV, parambki);
            }
            localFTSLocalPageRelevantView.a(localList, localFTSLocalPageRelevantView.fXV);
            localFTSLocalPageRelevantView.requestLayout();
            i = 1;
          }
        }
      }
    }
    FTSMainUI.g(this.kCm).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSMainUI.10
 * JD-Core Version:    0.7.0.1
 */