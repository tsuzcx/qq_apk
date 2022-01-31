package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.a.a;
import com.tencent.mm.sdk.platformtools.ah;

final class ChatroomInfoUI$5
  extends a
{
  ChatroomInfoUI$5(ChatroomInfoUI paramChatroomInfoUI) {}
  
  public final void onClickImp(View paramView)
  {
    AppMethodBeat.i(103968);
    paramView = new Intent();
    paramView.setFlags(268435456);
    paramView.setClassName(ah.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
    paramView.putExtra("rawUrl", "https://weixin.qq.com/cgi-bin/newreadtemplate?t=work_wechat/about_group");
    ah.getContext().startActivity(paramView);
    AppMethodBeat.o(103968);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatroomInfoUI.5
 * JD-Core Version:    0.7.0.1
 */