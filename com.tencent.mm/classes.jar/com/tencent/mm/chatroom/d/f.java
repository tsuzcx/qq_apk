package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.protocal.protobuf.abg;
import com.tencent.mm.protocal.protobuf.abh;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.LinkedList;

public final class f
  extends a<abh>
{
  public f(String paramString, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(197028);
    ac.d("MicroMsg.CgiOpenImDelChatRoomAdmin", "roomName:%s,username:%s", new Object[] { paramString, bs.n(paramLinkedList, ";") });
    abg localabg = new abg();
    localabg.djF = paramString;
    localabg.DQf = paramLinkedList;
    paramString = new b.a();
    paramString.hvt = localabg;
    paramString.hvu = new abh();
    paramString.uri = "/cgi-bin/micromsg-bin/delopenimchatroomadmin";
    paramString.funcId = 3677;
    this.rr = paramString.aAz();
    AppMethodBeat.o(197028);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.f
 * JD-Core Version:    0.7.0.1
 */