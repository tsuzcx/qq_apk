package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.protocal.protobuf.go;
import com.tencent.mm.protocal.protobuf.gp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class c
  extends com.tencent.mm.an.c<gp>
{
  public c(long paramLong, String paramString1, String paramString2, String paramString3, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(12453);
    Log.d("MicroMsg.CgiApproveAddChatRoomMember", "inviterusername%s,roomname:%s,ticket:%s,username:%s approvenewmsgid:%s", new Object[] { paramString1, paramString2, Util.secPrint(paramString3), paramLinkedList, Long.valueOf(paramLong) });
    go localgo = new go();
    localgo.lWt = paramString1;
    localgo.fHp = paramString2;
    localgo.fAo = paramString3;
    localgo.RLB = paramLinkedList;
    localgo.RLC = paramLong;
    paramString1 = new d.a();
    paramString1.lBU = localgo;
    paramString1.lBV = new gp();
    paramString1.uri = "/cgi-bin/micromsg-bin/approveaddchatroommember";
    paramString1.funcId = 774;
    c(paramString1.bgN());
    AppMethodBeat.o(12453);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.c
 * JD-Core Version:    0.7.0.1
 */