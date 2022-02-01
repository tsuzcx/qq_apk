package com.tencent.mm.plugin.game.chatroom.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgPack;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgText;
import com.tencent.mm.plugin.game.autogen.chatroom.MsgContent;
import com.tencent.mm.plugin.game.autogen.chatroom.MsgOptions;
import com.tencent.mm.plugin.game.autogen.chatroom.SendChatroomMsgRequest;
import com.tencent.mm.plugin.game.autogen.chatroom.SendChatroomMsgResponse;
import com.tencent.mm.plugin.game.chatroom.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class n
  extends q
  implements m
{
  private i callback;
  public final d jTk;
  
  public n(b.b paramb)
  {
    AppMethodBeat.i(210817);
    Object localObject1 = new d.a();
    ((d.a)localObject1).lBU = new SendChatroomMsgRequest();
    ((d.a)localObject1).lBV = new SendChatroomMsgResponse();
    ((d.a)localObject1).uri = "/cgi-bin/mmgame-bin/gamegamelifeappsvr/sendchatroommsg";
    ((d.a)localObject1).funcId = getType();
    ((d.a)localObject1).lBW = 0;
    ((d.a)localObject1).respCmdId = 0;
    this.jTk = ((d.a)localObject1).bgN();
    localObject1 = (SendChatroomMsgRequest)d.b.b(this.jTk.lBR);
    ((SendChatroomMsgRequest)localObject1).chatroom_name = paramb.fwY;
    ChatroomMsgPack localChatroomMsgPack = new ChatroomMsgPack();
    localChatroomMsgPack.msg_type = paramb.msgType;
    localChatroomMsgPack.from_username = paramb.userName;
    if (Util.isNullOrNil(paramb.CrQ)) {
      paramb.CrQ = String.format("gamelife_chatroom_%s%s%s_%s", new Object[] { MD5Util.getMD5String(paramb.userName), paramb.fwY, Integer.valueOf(Util.getIntRandom(10, 0)), Long.valueOf(System.currentTimeMillis()) });
    }
    localChatroomMsgPack.cli_msg_id = paramb.CrQ;
    localChatroomMsgPack.send_time = System.currentTimeMillis();
    Object localObject2 = new MsgContent();
    ChatroomMsgText localChatroomMsgText = new ChatroomMsgText();
    localChatroomMsgText.content = paramb.content;
    ((MsgContent)localObject2).chatroom_text = localChatroomMsgText;
    localChatroomMsgPack.msg_content = ((MsgContent)localObject2);
    if (paramb.CrP != null)
    {
      localObject2 = new MsgOptions();
      ((MsgOptions)localObject2).at_list.addAll(paramb.CrP);
      Log.i("GameChatRoom.CgiSendChatRoomMsg", "at member list:%s", new Object[] { ((MsgOptions)localObject2).at_list.toString() });
      localChatroomMsgPack.msg_options = ((MsgOptions)localObject2);
    }
    ((SendChatroomMsgRequest)localObject1).msg_pack = localChatroomMsgPack;
    AppMethodBeat.o(210817);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(210820);
    this.callback = parami;
    int i = dispatch(paramg, this.jTk, this);
    AppMethodBeat.o(210820);
    return i;
  }
  
  public final int getType()
  {
    return 4993;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(210822);
    Log.i("GameChatRoom.CgiSendChatRoomMsg", "errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(210822);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.c.n
 * JD-Core Version:    0.7.0.1
 */