package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a;
import com.tencent.mm.al.b.a;
import com.tencent.mm.protocal.protobuf.acr;
import com.tencent.mm.protocal.protobuf.acs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public final class d
  extends a<acs>
{
  public d(String paramString, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(12454);
    ad.d("MicroMsg.CgiAddChatRoomAdmin", "roomName:%s,username:%s", new Object[] { paramString, bt.m(paramLinkedList, ";") });
    acr localacr = new acr();
    localacr.FuL = paramString;
    localacr.FuM = paramLinkedList;
    paramString = new b.a();
    paramString.hNM = localacr;
    paramString.hNN = new acs();
    paramString.uri = "/cgi-bin/micromsg-bin/delchatroomadmin";
    paramString.funcId = 259;
    c(paramString.aDC());
    AppMethodBeat.o(12454);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.d
 * JD-Core Version:    0.7.0.1
 */