package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.protocal.protobuf.cx;
import com.tencent.mm.protocal.protobuf.cy;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;

public final class e
  extends a<cy>
{
  public e(String paramString, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(217107);
    ae.d("MicroMsg.CgiOpenImAddChatRoomAdmin", "roomName:%s,username:%s", new Object[] { paramString, bu.m(paramLinkedList, ";") });
    cx localcx = new cx();
    localcx.dwx = paramString;
    localcx.uIU = paramLinkedList;
    paramString = new b.a();
    paramString.hQF = localcx;
    paramString.hQG = new cy();
    paramString.uri = "/cgi-bin/micromsg-bin/addopenimchatroomadmin";
    paramString.funcId = 776;
    c(paramString.aDS());
    AppMethodBeat.o(217107);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.e
 * JD-Core Version:    0.7.0.1
 */