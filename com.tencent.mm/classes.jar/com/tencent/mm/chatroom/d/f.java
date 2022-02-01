package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.protocal.protobuf.afs;
import com.tencent.mm.protocal.protobuf.aft;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class f
  extends c<aft>
{
  public f(String paramString, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(194022);
    Log.d("MicroMsg.CgiOpenImDelChatRoomAdmin", "roomName:%s,username:%s", new Object[] { paramString, Util.listToString(paramLinkedList, ";") });
    afs localafs = new afs();
    localafs.dOe = paramString;
    localafs.ybk = paramLinkedList;
    paramString = new d.a();
    paramString.iLN = localafs;
    paramString.iLO = new aft();
    paramString.uri = "/cgi-bin/micromsg-bin/delopenimchatroomadmin";
    paramString.funcId = 3677;
    c(paramString.aXF());
    AppMethodBeat.o(194022);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.f
 * JD-Core Version:    0.7.0.1
 */