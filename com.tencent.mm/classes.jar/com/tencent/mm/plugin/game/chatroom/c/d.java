package com.tencent.mm.plugin.game.chatroom.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.am.c.a;
import com.tencent.mm.plugin.game.autogen.chatroom.GetChatroomMemberInfoRequest;
import com.tencent.mm.plugin.game.autogen.chatroom.GetChatroomMemberInfoResponse;
import java.util.LinkedList;

public final class d
  extends b<GetChatroomMemberInfoResponse>
{
  public d(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(275841);
    c.a locala = new c.a();
    locala.otF = new GetChatroomMemberInfoResponse();
    GetChatroomMemberInfoRequest localGetChatroomMemberInfoRequest = new GetChatroomMemberInfoRequest();
    localGetChatroomMemberInfoRequest.username_list = paramLinkedList;
    locala.otE = localGetChatroomMemberInfoRequest;
    locala.uri = "/cgi-bin/mmgame-bin/gamegamelifeappsvr/getchatroommemberinfo";
    locala.funcId = 4982;
    c(locala.bEF());
    AppMethodBeat.o(275841);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.c.d
 * JD-Core Version:    0.7.0.1
 */