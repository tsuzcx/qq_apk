package com.tencent.mm.plugin.game.chatroom.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.game.report.d;
import com.tencent.mm.game.report.d.a;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomData;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomUserData;
import com.tencent.mm.plugin.game.autogen.chatroom.Lbs;
import com.tencent.mm.plugin.game.chatroom.c.i;
import com.tencent.mm.plugin.game.chatroom.e;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

final class JoinChatRoomConfirmView$1
  implements View.OnClickListener
{
  JoinChatRoomConfirmView$1(JoinChatRoomConfirmView paramJoinChatRoomConfirmView, ChatroomUserData paramChatroomUserData, ChatroomData paramChatroomData, Lbs paramLbs) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(211940);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/game/chatroom/view/JoinChatRoomConfirmView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    paramView = d.jTj;
    d.a.b(1L, 13L, 0L, JoinChatRoomConfirmView.a(this.Cza), JoinChatRoomConfirmView.b(this.Cza));
    if (this.CyY.is_authorized)
    {
      paramView = new i(this.CyZ.chatroom_name, this.Cyi, true, JoinChatRoomConfirmView.a(this.Cza), JoinChatRoomConfirmView.b(this.Cza));
      h.aGY().a(paramView, 0);
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/game/chatroom/view/JoinChatRoomConfirmView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(211940);
      return;
      paramView = new JSONObject();
      try
      {
        paramView.put("source_id", 1311L);
        label149:
        paramView = URLEncoder.encode(paramView.toString());
        e.a(JoinChatRoomConfirmView.c(this.Cza), this.CyY.create_account_jump_info, 11, paramView);
      }
      catch (JSONException localJSONException)
      {
        break label149;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.view.JoinChatRoomConfirmView.1
 * JD-Core Version:    0.7.0.1
 */