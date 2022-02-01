package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.protocal.protobuf.gn;
import com.tencent.mm.protocal.protobuf.go;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;

public final class c
  extends a<go>
{
  public c(long paramLong, String paramString1, String paramString2, String paramString3, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(12453);
    ae.d("MicroMsg.CgiApproveAddChatRoomMember", "inviterusername%s,roomname:%s,ticket:%s,username:%s approvenewmsgid:%s", new Object[] { paramString1, paramString2, bu.aSM(paramString3), paramLinkedList, Long.valueOf(paramLong) });
    gn localgn = new gn();
    localgn.ikT = paramString1;
    localgn.dwx = paramString2;
    localgn.dqk = paramString3;
    localgn.FRc = paramLinkedList;
    localgn.FRd = paramLong;
    paramString1 = new b.a();
    paramString1.hQF = localgn;
    paramString1.hQG = new go();
    paramString1.uri = "/cgi-bin/micromsg-bin/approveaddchatroommember";
    paramString1.funcId = 774;
    c(paramString1.aDS());
    AppMethodBeat.o(12453);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.c
 * JD-Core Version:    0.7.0.1
 */