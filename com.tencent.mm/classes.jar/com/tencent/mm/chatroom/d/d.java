package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.aas;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.LinkedList;

public final class d
  extends a<aas>
{
  public d(String paramString, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(12454);
    ac.d("MicroMsg.CgiAddChatRoomAdmin", "roomName:%s,username:%s", new Object[] { paramString, bs.n(paramLinkedList, ";") });
    aar localaar = new aar();
    localaar.DPx = paramString;
    localaar.DPy = paramLinkedList;
    paramString = new b.a();
    paramString.hvt = localaar;
    paramString.hvu = new aas();
    paramString.uri = "/cgi-bin/micromsg-bin/delchatroomadmin";
    paramString.funcId = 259;
    this.rr = paramString.aAz();
    AppMethodBeat.o(12454);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.d
 * JD-Core Version:    0.7.0.1
 */