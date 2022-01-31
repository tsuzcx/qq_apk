package com.tencent.mm.plugin.fts.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.websearch.api.ao;
import com.tencent.mm.sdk.platformtools.bk;

final class FTSAddWw$4
  implements View.OnClickListener
{
  FTSAddWw$4(FTSAddWw paramFTSAddWw) {}
  
  public final void onClick(View paramView)
  {
    if (!bk.bl(this.kAM.bVk))
    {
      this.kAM.kAA = true;
      ao.i(this.kAM.bVk, FTSAddWw.b(this.kAM), 1, 16);
    }
    FTSAddWw.c(this.kAM);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSAddWw.4
 * JD-Core Version:    0.7.0.1
 */