package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ai;

final class ChatroomInfoUI$5
  extends com.tencent.mm.plugin.messenger.a.a
{
  ChatroomInfoUI$5(ChatroomInfoUI paramChatroomInfoUI) {}
  
  public final void onClickImp(View paramView)
  {
    AppMethodBeat.i(12514);
    Object localObject = new Intent();
    ((Intent)localObject).setFlags(268435456);
    ((Intent)localObject).setClassName(ai.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
    ((Intent)localObject).putExtra("rawUrl", "https://weixin.qq.com/cgi-bin/newreadtemplate?t=work_wechat/about_group");
    paramView = ai.getContext();
    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/chatroom/ui/ChatroomInfoUI$13", "onClickImp", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/chatroom/ui/ChatroomInfoUI$13", "onClickImp", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(12514);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatroomInfoUI.5
 * JD-Core Version:    0.7.0.1
 */