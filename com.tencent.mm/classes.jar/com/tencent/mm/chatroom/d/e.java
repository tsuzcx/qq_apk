package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.protocal.protobuf.dg;
import com.tencent.mm.protocal.protobuf.dh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class e
  extends c<dh>
{
  public e(String paramString, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(194021);
    Log.d("MicroMsg.CgiOpenImAddChatRoomAdmin", "roomName:%s,username:%s", new Object[] { paramString, Util.listToString(paramLinkedList, ";") });
    dg localdg = new dg();
    localdg.dOe = paramString;
    localdg.ybk = paramLinkedList;
    paramString = new d.a();
    paramString.iLN = localdg;
    paramString.iLO = new dh();
    paramString.uri = "/cgi-bin/micromsg-bin/addopenimchatroomadmin";
    paramString.funcId = 776;
    c(paramString.aXF());
    AppMethodBeat.o(194021);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.e
 * JD-Core Version:    0.7.0.1
 */