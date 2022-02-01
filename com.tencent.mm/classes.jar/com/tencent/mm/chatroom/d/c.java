package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.protocal.protobuf.gc;
import com.tencent.mm.protocal.protobuf.gd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public final class c
  extends com.tencent.mm.al.c<gd>
{
  public c(long paramLong, String paramString1, String paramString2, String paramString3, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(12453);
    ad.d("MicroMsg.CgiApproveAddChatRoomMember", "inviterusername%s,roomname:%s,ticket:%s,username:%s approvenewmsgid:%s", new Object[] { paramString1, paramString2, bt.aGs(paramString3), paramLinkedList, Long.valueOf(paramLong) });
    gc localgc = new gc();
    localgc.hoj = paramString1;
    localgc.dlX = paramString2;
    localgc.dgo = paramString3;
    localgc.CAN = paramLinkedList;
    localgc.CAO = paramLong;
    paramString1 = new b.a();
    paramString1.gUU = localgc;
    paramString1.gUV = new gd();
    paramString1.uri = "/cgi-bin/micromsg-bin/approveaddchatroommember";
    paramString1.funcId = 774;
    this.rr = paramString1.atI();
    AppMethodBeat.o(12453);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.c
 * JD-Core Version:    0.7.0.1
 */