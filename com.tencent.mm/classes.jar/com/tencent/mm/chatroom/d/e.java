package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a;
import com.tencent.mm.al.b.a;
import com.tencent.mm.protocal.protobuf.cx;
import com.tencent.mm.protocal.protobuf.cy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public final class e
  extends a<cy>
{
  public e(String paramString, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(213395);
    ad.d("MicroMsg.CgiOpenImAddChatRoomAdmin", "roomName:%s,username:%s", new Object[] { paramString, bt.m(paramLinkedList, ";") });
    cx localcx = new cx();
    localcx.dvs = paramString;
    localcx.uxr = paramLinkedList;
    paramString = new b.a();
    paramString.hNM = localcx;
    paramString.hNN = new cy();
    paramString.uri = "/cgi-bin/micromsg-bin/addopenimchatroomadmin";
    paramString.funcId = 776;
    c(paramString.aDC());
    AppMethodBeat.o(213395);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.e
 * JD-Core Version:    0.7.0.1
 */