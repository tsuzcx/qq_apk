package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatHosts;

final class ChatroomInfoUI$4
  extends com.tencent.mm.plugin.messenger.a.a
{
  ChatroomInfoUI$4(ChatroomInfoUI paramChatroomInfoUI) {}
  
  public final void onClickImp(View paramView)
  {
    AppMethodBeat.i(194067);
    Object localObject = new Intent();
    ((Intent)localObject).setFlags(268435456);
    ((Intent)localObject).setClassName(MMApplicationContext.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
    ((Intent)localObject).putExtra("rawUrl", "https://" + WeChatHosts.domainString(2131761749) + "/cgi-bin/newreadtemplate?t=work_wechat/about_group");
    paramView = MMApplicationContext.getContext();
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/chatroom/ui/ChatroomInfoUI$12", "onClickImp", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/chatroom/ui/ChatroomInfoUI$12", "onClickImp", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(194067);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatroomInfoUI.4
 * JD-Core Version:    0.7.0.1
 */