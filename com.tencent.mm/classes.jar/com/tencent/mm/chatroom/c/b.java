package com.tencent.mm.chatroom.c;

import com.tencent.mm.ah.a;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.protocal.c.bq;
import com.tencent.mm.protocal.c.br;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class b
  extends a<br>
{
  public b(String paramString, LinkedList<String> paramLinkedList)
  {
    y.d("MicroMsg.CgiAddChatRoomAdmin", "roomName:%s,username:%s", new Object[] { paramString, bk.c(paramLinkedList, ";") });
    bq localbq = new bq();
    localbq.svm = paramString;
    localbq.svn = paramLinkedList;
    paramString = new b.a();
    paramString.ecH = localbq;
    paramString.ecI = new br();
    paramString.uri = "/cgi-bin/micromsg-bin/addchatroomadmin";
    paramString.ecG = 889;
    this.dmK = paramString.Kt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.c.b
 * JD-Core Version:    0.7.0.1
 */