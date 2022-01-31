package com.tencent.mm.chatroom.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.protocal.protobuf.fk;
import com.tencent.mm.protocal.protobuf.fl;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public final class c
  extends a<fl>
{
  public c(long paramLong, String paramString1, String paramString2, String paramString3, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(103908);
    ab.d("MicroMsg.CgiApproveAddChatRoomMember", "inviterusername%s,roomname:%s,ticket:%s,username:%s approvenewmsgid:%s", new Object[] { paramString1, paramString2, bo.aqg(paramString3), paramLinkedList, Long.valueOf(paramLong) });
    fk localfk = new fk();
    localfk.fLx = paramString1;
    localfk.gfK = paramString2;
    localfk.crs = paramString3;
    localfk.wrz = paramLinkedList;
    localfk.wrA = paramLong;
    paramString1 = new b.a();
    paramString1.fsX = localfk;
    paramString1.fsY = new fl();
    paramString1.uri = "/cgi-bin/micromsg-bin/approveaddchatroommember";
    paramString1.funcId = 774;
    this.rr = paramString1.ado();
    AppMethodBeat.o(103908);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.c.c
 * JD-Core Version:    0.7.0.1
 */