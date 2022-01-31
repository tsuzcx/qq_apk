package com.tencent.mm.plugin.account.friend.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RecommendFriendUI$6
  implements DialogInterface.OnClickListener
{
  RecommendFriendUI$6(RecommendFriendUI paramRecommendFriendUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(108633);
    this.gAg.finish();
    AppMethodBeat.o(108633);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.RecommendFriendUI.6
 * JD-Core Version:    0.7.0.1
 */