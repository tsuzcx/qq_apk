package com.tencent.mm.plugin.account.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.f.a.c;

final class ShowNonWeixinFriendUI$2
  implements View.OnClickListener
{
  ShowNonWeixinFriendUI$2(ShowNonWeixinFriendUI paramShowNonWeixinFriendUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new c("290293790992170");
    Bundle localBundle = new Bundle();
    localBundle.putString("message", this.fsO.getString(q.j.facebook_invite_message));
    localBundle.putString("to", Long.toString(ShowNonWeixinFriendUI.a(this.fsO)));
    paramView.a(this.fsO, "apprequests", localBundle, new ShowNonWeixinFriendUI.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.ShowNonWeixinFriendUI.2
 * JD-Core Version:    0.7.0.1
 */