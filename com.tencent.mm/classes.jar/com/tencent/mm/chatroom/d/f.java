package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.am.c.a;
import com.tencent.mm.protocal.protobuf.do;
import com.tencent.mm.protocal.protobuf.dp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class f
  extends b<dp>
{
  public f(String paramString, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(241425);
    Log.d("MicroMsg.CgiOpenImAddChatRoomAdmin", "roomName:%s,username:%s", new Object[] { paramString, Util.listToString(paramLinkedList, ";") });
    do localdo = new do();
    localdo.hMM = paramString;
    localdo.username_list = paramLinkedList;
    paramString = new c.a();
    paramString.otE = localdo;
    paramString.otF = new dp();
    paramString.uri = "/cgi-bin/micromsg-bin/addopenimchatroomadmin";
    paramString.funcId = 776;
    c(paramString.bEF());
    AppMethodBeat.o(241425);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.f
 * JD-Core Version:    0.7.0.1
 */