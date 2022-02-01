package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a;
import com.tencent.mm.al.b.a;
import com.tencent.mm.protocal.protobuf.ce;
import com.tencent.mm.protocal.protobuf.cf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public final class b
  extends a<cf>
{
  public b(String paramString, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(12452);
    ad.d("MicroMsg.CgiAddChatRoomAdmin", "roomName:%s,username:%s", new Object[] { paramString, bt.n(paramLinkedList, ";") });
    ce localce = new ce();
    localce.Cxb = paramString;
    localce.Cxc = paramLinkedList;
    paramString = new b.a();
    paramString.gUU = localce;
    paramString.gUV = new cf();
    paramString.uri = "/cgi-bin/micromsg-bin/addchatroomadmin";
    paramString.funcId = 889;
    this.rr = paramString.atI();
    AppMethodBeat.o(12452);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.b
 * JD-Core Version:    0.7.0.1
 */