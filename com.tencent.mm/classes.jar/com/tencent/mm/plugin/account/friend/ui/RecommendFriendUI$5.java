package com.tencent.mm.plugin.account.friend.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.aa;

final class RecommendFriendUI$5
  implements DialogInterface.OnCancelListener
{
  RecommendFriendUI$5(RecommendFriendUI paramRecommendFriendUI, aa paramaa) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(108632);
    g.Rc().a(this.gAi);
    this.gAg.finish();
    AppMethodBeat.o(108632);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.RecommendFriendUI.5
 * JD-Core Version:    0.7.0.1
 */