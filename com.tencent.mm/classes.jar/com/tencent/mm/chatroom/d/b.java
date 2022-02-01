package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.protocal.protobuf.cq;
import com.tencent.mm.protocal.protobuf.cr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class b
  extends c<cr>
{
  public b(String paramString, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(12452);
    Log.d("MicroMsg.CgiAddChatRoomAdmin", "roomName:%s,username:%s", new Object[] { paramString, Util.listToString(paramLinkedList, ";") });
    cq localcq = new cq();
    localcq.KGO = paramString;
    localcq.KGP = paramLinkedList;
    paramString = new d.a();
    paramString.iLN = localcq;
    paramString.iLO = new cr();
    paramString.uri = "/cgi-bin/micromsg-bin/addchatroomadmin";
    paramString.funcId = 889;
    c(paramString.aXF());
    AppMethodBeat.o(12452);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.b
 * JD-Core Version:    0.7.0.1
 */