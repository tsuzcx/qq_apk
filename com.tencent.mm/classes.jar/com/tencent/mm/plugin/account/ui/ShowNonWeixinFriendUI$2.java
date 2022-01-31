package com.tencent.mm.plugin.account.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.g.a.c;

final class ShowNonWeixinFriendUI$2
  implements View.OnClickListener
{
  ShowNonWeixinFriendUI$2(ShowNonWeixinFriendUI paramShowNonWeixinFriendUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(125590);
    paramView = new c(this.gKq.getString(2131306163));
    Bundle localBundle = new Bundle();
    localBundle.putString("message", this.gKq.getString(2131299633));
    localBundle.putString("to", Long.toString(ShowNonWeixinFriendUI.a(this.gKq)));
    paramView.a(this.gKq, "apprequests", localBundle, new ShowNonWeixinFriendUI.2.1(this));
    AppMethodBeat.o(125590);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.ShowNonWeixinFriendUI.2
 * JD-Core Version:    0.7.0.1
 */