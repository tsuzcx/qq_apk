package com.tencent.mm.plugin.game.chatroom.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgPack;
import com.tencent.mm.plugin.game.autogen.chatroom.SendChatroomMsgRequest;
import com.tencent.mm.plugin.game.autogen.chatroom.SendChatroomMsgResponse;
import com.tencent.mm.plugin.game.chatroom.b.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;

public final class p
  extends com.tencent.mm.am.p
  implements m
{
  private h callback;
  public final c mtC;
  
  public p(b.d paramd)
  {
    AppMethodBeat.i(275783);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new SendChatroomMsgRequest();
    ((c.a)localObject).otF = new SendChatroomMsgResponse();
    ((c.a)localObject).uri = "/cgi-bin/mmgame-bin/gamegamelifeappsvr/sendchatroommsg";
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.mtC = ((c.a)localObject).bEF();
    localObject = (SendChatroomMsgRequest)c.b.b(this.mtC.otB);
    ((SendChatroomMsgRequest)localObject).chatroom_name = paramd.hBy;
    ChatroomMsgPack localChatroomMsgPack = new ChatroomMsgPack();
    localChatroomMsgPack.msg_type = paramd.msgType;
    localChatroomMsgPack.from_username = paramd.userName;
    if (Util.isNullOrNil(paramd.Ied)) {
      paramd.Ied = String.format("gamelife_chatroom_%s%s%s_%s", new Object[] { MD5Util.getMD5String(paramd.userName), paramd.hBy, Integer.valueOf(Util.getIntRandom(10, 0)), Long.valueOf(System.currentTimeMillis()) });
    }
    Log.i("GameChatRoom.CgiSendChatRoomMsg", "send chat msg, msgType:%d", new Object[] { Integer.valueOf(paramd.msgType) });
    localChatroomMsgPack.cli_msg_id = paramd.Ied;
    localChatroomMsgPack.channel_id = paramd.channelId;
    localChatroomMsgPack.send_time = System.currentTimeMillis();
    localChatroomMsgPack.msg_content = paramd.Ief;
    localChatroomMsgPack.msg_options = paramd.Iee;
    ((SendChatroomMsgRequest)localObject).msg_pack = localChatroomMsgPack;
    AppMethodBeat.o(275783);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(275797);
    this.callback = paramh;
    int i = dispatch(paramg, this.mtC, this);
    AppMethodBeat.o(275797);
    return i;
  }
  
  public final int getType()
  {
    return 4993;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(275806);
    Log.i("GameChatRoom.CgiSendChatRoomMsg", "errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(275806);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.c.p
 * JD-Core Version:    0.7.0.1
 */