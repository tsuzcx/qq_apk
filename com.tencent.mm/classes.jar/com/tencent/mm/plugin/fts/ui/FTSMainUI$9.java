package com.tencent.mm.plugin.fts.ui;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.ui.widget.FTSLocalPageRelevantView;
import com.tencent.mm.plugin.websearch.api.d;
import com.tencent.mm.protocal.protobuf.bti;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

final class FTSMainUI$9
  implements d
{
  FTSMainUI$9(FTSMainUI paramFTSMainUI) {}
  
  public final void a(boolean paramBoolean, bti parambti, String paramString1, String paramString2)
  {
    AppMethodBeat.i(61874);
    if (!this.mYi.query.equals(paramString2))
    {
      ab.i("MicroMsg.FTS.FTSMainUI", "IRelevantSearchCallback callback with query %s, current query is %s ", new Object[] { paramString2, this.mYi.query });
      AppMethodBeat.o(61874);
      return;
    }
    if (paramBoolean)
    {
      if (FTSMainUI.b(this.mYi).getVisibility() == 0)
      {
        FTSLocalPageRelevantView localFTSLocalPageRelevantView = FTSMainUI.f(this.mYi);
        int i;
        if ((parambti == null) || (parambti.wrp == null))
        {
          ab.w("MicroMsg.FTS.FTSLocalPageRelevantView", "configRelevantDatas param nil!");
          i = 0;
        }
        while (i != 0)
        {
          FTSMainUI.f(this.mYi).setVisibility(0);
          AppMethodBeat.o(61874);
          return;
          List localList = FTSLocalPageRelevantView.bX(parambti.wrp);
          if (localList.size() <= 0)
          {
            ab.w("MicroMsg.FTS.FTSLocalPageRelevantView", "configRelevantDatas size 0 items!");
            i = 0;
          }
          else
          {
            localFTSLocalPageRelevantView.query = paramString2;
            localFTSLocalPageRelevantView.hng = paramString1;
            localFTSLocalPageRelevantView.nbe = parambti.wrp;
            if (localFTSLocalPageRelevantView.jja == null)
            {
              localFTSLocalPageRelevantView.jja = new LinearLayout(localFTSLocalPageRelevantView.getContext());
              localFTSLocalPageRelevantView.jja.setOrientation(1);
              parambti = (LinearLayout.LayoutParams)localFTSLocalPageRelevantView.getLayoutParams();
              parambti.width = -1;
              parambti.height = -2;
              localFTSLocalPageRelevantView.addView(localFTSLocalPageRelevantView.jja, parambti);
            }
            localFTSLocalPageRelevantView.b(localList, localFTSLocalPageRelevantView.jja);
            localFTSLocalPageRelevantView.requestLayout();
            i = 1;
          }
        }
      }
    }
    else {
      FTSMainUI.f(this.mYi).setVisibility(8);
    }
    AppMethodBeat.o(61874);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSMainUI.9
 * JD-Core Version:    0.7.0.1
 */