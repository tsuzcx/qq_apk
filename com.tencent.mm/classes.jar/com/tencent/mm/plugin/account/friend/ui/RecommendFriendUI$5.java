package com.tencent.mm.plugin.account.friend.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.aa;

final class RecommendFriendUI$5
  implements DialogInterface.OnCancelListener
{
  RecommendFriendUI$5(RecommendFriendUI paramRecommendFriendUI, aa paramaa) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    g.Dk().c(this.fiB);
    this.fiz.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.RecommendFriendUI.5
 * JD-Core Version:    0.7.0.1
 */