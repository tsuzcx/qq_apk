package com.tencent.mm.chatroom.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.protocal.protobuf.wn;
import com.tencent.mm.protocal.protobuf.wo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public final class d
  extends a<wo>
{
  public d(String paramString, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(103909);
    ab.d("MicroMsg.CgiAddChatRoomAdmin", "roomName:%s,username:%s", new Object[] { paramString, bo.d(paramLinkedList, ";") });
    wn localwn = new wn();
    localwn.wot = paramString;
    localwn.wou = paramLinkedList;
    paramString = new b.a();
    paramString.fsX = localwn;
    paramString.fsY = new wo();
    paramString.uri = "/cgi-bin/micromsg-bin/delchatroomadmin";
    paramString.funcId = 259;
    this.rr = paramString.ado();
    AppMethodBeat.o(103909);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.chatroom.c.d
 * JD-Core Version:    0.7.0.1
 */