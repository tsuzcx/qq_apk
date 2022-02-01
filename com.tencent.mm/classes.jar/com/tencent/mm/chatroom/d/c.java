package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.protocal.protobuf.ha;
import com.tencent.mm.protocal.protobuf.hb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class c
  extends com.tencent.mm.ak.c<hb>
{
  public c(long paramLong, String paramString1, String paramString2, String paramString3, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(12453);
    Log.d("MicroMsg.CgiApproveAddChatRoomMember", "inviterusername%s,roomname:%s,ticket:%s,username:%s approvenewmsgid:%s", new Object[] { paramString1, paramString2, Util.secPrint(paramString3), paramLinkedList, Long.valueOf(paramLong) });
    ha localha = new ha();
    localha.jfS = paramString1;
    localha.dOe = paramString2;
    localha.dHx = paramString3;
    localha.KKJ = paramLinkedList;
    localha.KKK = paramLong;
    paramString1 = new d.a();
    paramString1.iLN = localha;
    paramString1.iLO = new hb();
    paramString1.uri = "/cgi-bin/micromsg-bin/approveaddchatroommember";
    paramString1.funcId = 774;
    c(paramString1.aXF());
    AppMethodBeat.o(12453);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.c
 * JD-Core Version:    0.7.0.1
 */