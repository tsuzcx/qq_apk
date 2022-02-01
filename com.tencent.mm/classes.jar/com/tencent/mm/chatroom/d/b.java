package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.protocal.protobuf.cg;
import com.tencent.mm.protocal.protobuf.ch;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.LinkedList;

public final class b
  extends a<ch>
{
  public b(String paramString, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(12452);
    ac.d("MicroMsg.CgiAddChatRoomAdmin", "roomName:%s,username:%s", new Object[] { paramString, bs.n(paramLinkedList, ";") });
    cg localcg = new cg();
    localcg.DPx = paramString;
    localcg.DPy = paramLinkedList;
    paramString = new b.a();
    paramString.hvt = localcg;
    paramString.hvu = new ch();
    paramString.uri = "/cgi-bin/micromsg-bin/addchatroomadmin";
    paramString.funcId = 889;
    this.rr = paramString.aAz();
    AppMethodBeat.o(12452);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.b
 * JD-Core Version:    0.7.0.1
 */