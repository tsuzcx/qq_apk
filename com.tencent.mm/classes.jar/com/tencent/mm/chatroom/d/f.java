package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a;
import com.tencent.mm.al.b.a;
import com.tencent.mm.protocal.protobuf.aah;
import com.tencent.mm.protocal.protobuf.aai;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public final class f
  extends a<aai>
{
  public f(String paramString, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(196565);
    ad.d("MicroMsg.CgiOpenImDelChatRoomAdmin", "roomName:%s,username:%s", new Object[] { paramString, bt.n(paramLinkedList, ";") });
    aah localaah = new aah();
    localaah.dlX = paramString;
    localaah.CxJ = paramLinkedList;
    paramString = new b.a();
    paramString.gUU = localaah;
    paramString.gUV = new aai();
    paramString.uri = "/cgi-bin/micromsg-bin/delopenimchatroomadmin";
    paramString.funcId = 3677;
    this.rr = paramString.atI();
    AppMethodBeat.o(196565);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.f
 * JD-Core Version:    0.7.0.1
 */