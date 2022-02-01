package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.adq;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;

public final class f
  extends a<adq>
{
  public f(String paramString, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(217108);
    ae.d("MicroMsg.CgiOpenImDelChatRoomAdmin", "roomName:%s,username:%s", new Object[] { paramString, bu.m(paramLinkedList, ";") });
    adp localadp = new adp();
    localadp.dwx = paramString;
    localadp.uIU = paramLinkedList;
    paramString = new b.a();
    paramString.hQF = localadp;
    paramString.hQG = new adq();
    paramString.uri = "/cgi-bin/micromsg-bin/delopenimchatroomadmin";
    paramString.funcId = 3677;
    c(paramString.aDS());
    AppMethodBeat.o(217108);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.f
 * JD-Core Version:    0.7.0.1
 */