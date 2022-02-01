package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.protocal.protobuf.gg;
import com.tencent.mm.protocal.protobuf.gh;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.LinkedList;

public final class c
  extends com.tencent.mm.ak.c<gh>
{
  public c(long paramLong, String paramString1, String paramString2, String paramString3, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(12453);
    ac.d("MicroMsg.CgiApproveAddChatRoomMember", "inviterusername%s,roomname:%s,ticket:%s,username:%s approvenewmsgid:%s", new Object[] { paramString1, paramString2, bs.aLJ(paramString3), paramLinkedList, Long.valueOf(paramLong) });
    gg localgg = new gg();
    localgg.hOM = paramString1;
    localgg.djF = paramString2;
    localgg.ddJ = paramString3;
    localgg.DTl = paramLinkedList;
    localgg.DTm = paramLong;
    paramString1 = new b.a();
    paramString1.hvt = localgg;
    paramString1.hvu = new gh();
    paramString1.uri = "/cgi-bin/micromsg-bin/approveaddchatroommember";
    paramString1.funcId = 774;
    this.rr = paramString1.aAz();
    AppMethodBeat.o(12453);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.c
 * JD-Core Version:    0.7.0.1
 */