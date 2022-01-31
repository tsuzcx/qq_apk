package com.tencent.mm.plugin.fts.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.websearch.api.ao;
import com.tencent.mm.sdk.platformtools.bk;

final class FTSAddFriendUI$4
  implements View.OnClickListener
{
  FTSAddFriendUI$4(FTSAddFriendUI paramFTSAddFriendUI) {}
  
  public final void onClick(View paramView)
  {
    if (!bk.bl(this.kAI.bVk))
    {
      this.kAI.kAA = true;
      ao.i(this.kAI.bVk, FTSAddFriendUI.b(this.kAI), 1, 16);
    }
    FTSAddFriendUI.c(this.kAI);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSAddFriendUI.4
 * JD-Core Version:    0.7.0.1
 */