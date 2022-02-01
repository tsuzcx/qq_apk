package com.tencent.mm.plugin.game.chatroom.ui;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.b.o;
import com.tencent.mm.cd.b;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgPack;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgText;
import com.tencent.mm.plugin.game.autogen.chatroom.MsgContent;
import com.tencent.mm.plugin.game.autogen.chatroom.MsgOptions;
import com.tencent.mm.plugin.game.chatroom.b.b;
import com.tencent.mm.plugin.game.chatroom.c.n;
import com.tencent.mm.plugin.game.chatroom.view.GameChatCommentFooter;
import com.tencent.mm.plugin.game.chatroom.view.GameChatCommentFooter.a;
import com.tencent.mm.plugin.game.chatroom.view.GameChatListView;
import com.tencent.mm.plugin.game.chatroom.view.GameChatListView.3;
import com.tencent.mm.plugin.game.chatroom.view.GameChatListView.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

final class GameChatRoomUI$3
  implements GameChatCommentFooter.a
{
  GameChatRoomUI$3(GameChatRoomUI paramGameChatRoomUI) {}
  
  public final void sc(boolean paramBoolean)
  {
    AppMethodBeat.i(211960);
    if (paramBoolean)
    {
      GameChatRoomUI.p(this.Cwp).setVisibility(0);
      com.tencent.e.h.ZvG.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(210799);
          GameChatListView localGameChatListView = GameChatRoomUI.o(GameChatRoomUI.3.this.Cwp);
          localGameChatListView.CyG.setVisibility(8);
          Log.i("GameChatRoom.GameChatListView", "adjustKeyboard, cache list size:%d", new Object[] { Integer.valueOf(localGameChatListView.CyM.size()) });
          if (localGameChatListView.CyM.size() > 0) {
            localGameChatListView.w(localGameChatListView.CyM, 7);
          }
          int i = localGameChatListView.jbn.kJ();
          int j = localGameChatListView.jbn.kL();
          int k = localGameChatListView.CyC.getItemCount() - 1;
          if ((k < i) || (k > j)) {
            localGameChatListView.jbn.au(k, 0);
          }
          localGameChatListView.post(new GameChatListView.3(localGameChatListView, k));
          AppMethodBeat.o(210799);
        }
      }, 250L);
      AppMethodBeat.o(211960);
      return;
    }
    GameChatRoomUI.p(this.Cwp).setVisibility(8);
    AppMethodBeat.o(211960);
  }
  
  public final void x(String paramString, List paramList)
  {
    AppMethodBeat.i(211958);
    Log.v("GameChatRoom.GameChatRoomUI", "comment send requested");
    Object localObject = new b.b();
    ((b.b)localObject).userName = GameChatRoomUI.n(this.Cwp);
    ((b.b)localObject).fwY = GameChatRoomUI.a(this.Cwp);
    ((b.b)localObject).msgType = 1;
    ((b.b)localObject).content = paramString;
    ((b.b)localObject).CrP = paramList;
    paramString = new n((b.b)localObject);
    com.tencent.mm.kernel.h.aGY().a(paramString, 0);
    paramString = GameChatRoomUI.o(this.Cwp);
    if (!Util.isNullOrNil(((b.b)localObject).content))
    {
      paramString.CyC.CyV.put(((b.b)localObject).CrQ, localObject);
      paramList = new ChatroomMsgPack();
      paramList.msg_type = 1;
      paramList.from_username = ((b.b)localObject).userName;
      paramList.cli_msg_id = ((b.b)localObject).CrQ;
      MsgContent localMsgContent = new MsgContent();
      ChatroomMsgText localChatroomMsgText = new ChatroomMsgText();
      localChatroomMsgText.content = ((b.b)localObject).content;
      localMsgContent.chatroom_text = localChatroomMsgText;
      paramList.msg_content = localMsgContent;
      localObject = new MsgOptions();
      ((MsgOptions)localObject).cli_local_data = new b(o.bA(paramString.CyD << 4 | 0x1));
      paramString.CyD += 1;
      paramList.msg_options = ((MsgOptions)localObject);
      localObject = new LinkedList();
      ((List)localObject).add(paramList);
      paramString.w((List)localObject, 5);
    }
    paramString = GameChatRoomUI.l(this.Cwp);
    paramString.Cyw.clear();
    paramString.kFl.setText("");
    AppMethodBeat.o(211958);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.ui.GameChatRoomUI.3
 * JD-Core Version:    0.7.0.1
 */