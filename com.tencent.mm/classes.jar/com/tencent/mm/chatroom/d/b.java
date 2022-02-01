package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.protocal.protobuf.ch;
import com.tencent.mm.protocal.protobuf.ci;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;

public final class b
  extends a<ci>
{
  public b(String paramString, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(12452);
    ae.d("MicroMsg.CgiAddChatRoomAdmin", "roomName:%s,username:%s", new Object[] { paramString, bu.m(paramLinkedList, ";") });
    ch localch = new ch();
    localch.FNj = paramString;
    localch.FNk = paramLinkedList;
    paramString = new b.a();
    paramString.hQF = localch;
    paramString.hQG = new ci();
    paramString.uri = "/cgi-bin/micromsg-bin/addchatroomadmin";
    paramString.funcId = 889;
    c(paramString.aDS());
    AppMethodBeat.o(12452);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.b
 * JD-Core Version:    0.7.0.1
 */