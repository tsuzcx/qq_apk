package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.protocal.protobuf.afd;
import com.tencent.mm.protocal.protobuf.afe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class d
  extends c<afe>
{
  public d(String paramString, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(12454);
    Log.d("MicroMsg.CgiAddChatRoomAdmin", "roomName:%s,username:%s", new Object[] { paramString, Util.listToString(paramLinkedList, ";") });
    afd localafd = new afd();
    localafd.KGO = paramString;
    localafd.KGP = paramLinkedList;
    paramString = new d.a();
    paramString.iLN = localafd;
    paramString.iLO = new afe();
    paramString.uri = "/cgi-bin/micromsg-bin/delchatroomadmin";
    paramString.funcId = 259;
    c(paramString.aXF());
    AppMethodBeat.o(12454);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.d
 * JD-Core Version:    0.7.0.1
 */