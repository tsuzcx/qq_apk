package com.tencent.mm.chatroom.c;

import com.tencent.mm.ah.a;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.protocal.c.ej;
import com.tencent.mm.protocal.c.ek;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class c
  extends a<ek>
{
  public c(long paramLong, String paramString1, String paramString2, String paramString3, LinkedList<String> paramLinkedList)
  {
    y.d("MicroMsg.CgiApproveAddChatRoomMember", "inviterusername%s,roomname:%s,ticket:%s,username:%s approvenewmsgid:%s", new Object[] { paramString1, paramString2, bk.aac(paramString3), paramLinkedList, Long.valueOf(paramLong) });
    ej localej = new ej();
    localej.evK = paramString1;
    localej.ePP = paramString2;
    localej.bJY = paramString3;
    localej.sxW = paramLinkedList;
    localej.sxX = paramLong;
    paramString1 = new b.a();
    paramString1.ecH = localej;
    paramString1.ecI = new ek();
    paramString1.uri = "/cgi-bin/micromsg-bin/approveaddchatroommember";
    paramString1.ecG = 774;
    this.dmK = paramString1.Kt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.c.c
 * JD-Core Version:    0.7.0.1
 */