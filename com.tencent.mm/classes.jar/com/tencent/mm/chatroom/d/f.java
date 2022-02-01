package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a;
import com.tencent.mm.al.b.a;
import com.tencent.mm.protocal.protobuf.adg;
import com.tencent.mm.protocal.protobuf.adh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public final class f
  extends a<adh>
{
  public f(String paramString, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(213396);
    ad.d("MicroMsg.CgiOpenImDelChatRoomAdmin", "roomName:%s,username:%s", new Object[] { paramString, bt.m(paramLinkedList, ";") });
    adg localadg = new adg();
    localadg.dvs = paramString;
    localadg.uxr = paramLinkedList;
    paramString = new b.a();
    paramString.hNM = localadg;
    paramString.hNN = new adh();
    paramString.uri = "/cgi-bin/micromsg-bin/delopenimchatroomadmin";
    paramString.funcId = 3677;
    c(paramString.aDC());
    AppMethodBeat.o(213396);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.f
 * JD-Core Version:    0.7.0.1
 */