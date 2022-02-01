package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.am.c.a;
import com.tencent.mm.protocal.protobuf.aio;
import com.tencent.mm.protocal.protobuf.aip;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class g
  extends b<aip>
{
  public g(String paramString, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(241422);
    Log.d("MicroMsg.CgiOpenImDelChatRoomAdmin", "roomName:%s,username:%s", new Object[] { paramString, Util.listToString(paramLinkedList, ";") });
    aio localaio = new aio();
    localaio.hMM = paramString;
    localaio.username_list = paramLinkedList;
    paramString = new c.a();
    paramString.otE = localaio;
    paramString.otF = new aip();
    paramString.uri = "/cgi-bin/micromsg-bin/delopenimchatroomadmin";
    paramString.funcId = 3677;
    c(paramString.bEF());
    AppMethodBeat.o(241422);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.g
 * JD-Core Version:    0.7.0.1
 */