package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.protocal.protobuf.cw;
import com.tencent.mm.protocal.protobuf.cx;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.LinkedList;

public final class e
  extends a<cx>
{
  public e(String paramString, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(197027);
    ac.d("MicroMsg.CgiOpenImAddChatRoomAdmin", "roomName:%s,username:%s", new Object[] { paramString, bs.n(paramLinkedList, ";") });
    cw localcw = new cw();
    localcw.djF = paramString;
    localcw.DQf = paramLinkedList;
    paramString = new b.a();
    paramString.hvt = localcw;
    paramString.hvu = new cx();
    paramString.uri = "/cgi-bin/micromsg-bin/addopenimchatroomadmin";
    paramString.funcId = 776;
    this.rr = paramString.aAz();
    AppMethodBeat.o(197027);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.e
 * JD-Core Version:    0.7.0.1
 */