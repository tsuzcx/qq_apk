package com.tencent.mm.plugin.fts.ui;

import android.app.Dialog;

final class FTSAddFriendUI$8
  implements Runnable
{
  FTSAddFriendUI$8(FTSAddFriendUI paramFTSAddFriendUI) {}
  
  public final void run()
  {
    if (FTSAddFriendUI.j(this.kAI) != null)
    {
      FTSAddFriendUI.j(this.kAI).dismiss();
      FTSAddFriendUI.i(this.kAI);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSAddFriendUI.8
 * JD-Core Version:    0.7.0.1
 */