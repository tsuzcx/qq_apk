package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.protocal.protobuf.ada;
import com.tencent.mm.protocal.protobuf.adb;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;

public final class d
  extends a<adb>
{
  public d(String paramString, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(12454);
    ae.d("MicroMsg.CgiAddChatRoomAdmin", "roomName:%s,username:%s", new Object[] { paramString, bu.m(paramLinkedList, ";") });
    ada localada = new ada();
    localada.FNj = paramString;
    localada.FNk = paramLinkedList;
    paramString = new b.a();
    paramString.hQF = localada;
    paramString.hQG = new adb();
    paramString.uri = "/cgi-bin/micromsg-bin/delchatroomadmin";
    paramString.funcId = 259;
    c(paramString.aDS());
    AppMethodBeat.o(12454);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.d
 * JD-Core Version:    0.7.0.1
 */