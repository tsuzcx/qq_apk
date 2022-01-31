package com.tencent.mm.chatroom.c;

import com.tencent.mm.ah.a;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.protocal.c.sn;
import com.tencent.mm.protocal.c.so;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class d
  extends a<so>
{
  public d(String paramString, LinkedList<String> paramLinkedList)
  {
    y.d("MicroMsg.CgiAddChatRoomAdmin", "roomName:%s,username:%s", new Object[] { paramString, bk.c(paramLinkedList, ";") });
    sn localsn = new sn();
    localsn.svm = paramString;
    localsn.svn = paramLinkedList;
    paramString = new b.a();
    paramString.ecH = localsn;
    paramString.ecI = new so();
    paramString.uri = "/cgi-bin/micromsg-bin/delchatroomadmin";
    paramString.ecG = 259;
    this.dmK = paramString.Kt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.chatroom.c.d
 * JD-Core Version:    0.7.0.1
 */