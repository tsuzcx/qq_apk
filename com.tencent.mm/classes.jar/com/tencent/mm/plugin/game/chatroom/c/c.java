package com.tencent.mm.plugin.game.chatroom.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.plugin.game.autogen.chatroom.GetChatroomMemberInfoRequest;
import com.tencent.mm.plugin.game.autogen.chatroom.GetChatroomMemberInfoResponse;
import java.util.LinkedList;

public final class c
  extends com.tencent.mm.an.c<GetChatroomMemberInfoResponse>
{
  public c(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(210956);
    d.a locala = new d.a();
    locala.lBV = new GetChatroomMemberInfoResponse();
    GetChatroomMemberInfoRequest localGetChatroomMemberInfoRequest = new GetChatroomMemberInfoRequest();
    localGetChatroomMemberInfoRequest.username_list = paramLinkedList;
    locala.lBU = localGetChatroomMemberInfoRequest;
    locala.uri = "/cgi-bin/mmgame-bin/gamegamelifeappsvr/getchatroommemberinfo";
    locala.funcId = 4982;
    c(locala.bgN());
    AppMethodBeat.o(210956);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.c.c
 * JD-Core Version:    0.7.0.1
 */