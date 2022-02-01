package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatHosts;

final class ChatroomInfoUI$6
  extends com.tencent.mm.plugin.messenger.a.a
{
  ChatroomInfoUI$6(ChatroomInfoUI paramChatroomInfoUI)
  {
    super(1);
  }
  
  public final void onClickImp(View paramView)
  {
    AppMethodBeat.i(241789);
    Object localObject = new Intent();
    ((Intent)localObject).setFlags(268435456);
    ((Intent)localObject).setClassName(MMApplicationContext.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
    ((Intent)localObject).putExtra("rawUrl", "https://" + WeChatHosts.domainString(a.i.host_weixin_qq_com) + "/cgi-bin/newreadtemplate?t=work_wechat/about_group");
    paramView = MMApplicationContext.getContext();
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/chatroom/ui/ChatroomInfoUI$11", "onClickImp", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/chatroom/ui/ChatroomInfoUI$11", "onClickImp", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(241789);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatroomInfoUI.6
 * JD-Core Version:    0.7.0.1
 */