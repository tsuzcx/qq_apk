package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.am.c.a;
import com.tencent.mm.protocal.protobuf.er;
import com.tencent.mm.protocal.protobuf.es;
import com.tencent.mm.protocal.protobuf.zi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
  extends b<es>
{
  public c(String paramString, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(241430);
    Log.d("MicroMsg.CgiAlterChatRoomWatchMembers", "roomname:%s", new Object[] { Util.nullAs(paramString, ""), Integer.valueOf(paramLinkedList.size()) });
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      String str = (String)paramLinkedList.next();
      zi localzi = new zi();
      localzi.UserName = str;
      localLinkedList.add(localzi);
    }
    paramLinkedList = new er();
    paramLinkedList.YFk = Util.nullAs(paramString, "");
    paramLinkedList.YGJ = localLinkedList.size();
    paramLinkedList.YGK = localLinkedList;
    paramString = new c.a();
    paramString.otE = paramLinkedList;
    paramString.otF = new es();
    paramString.uri = "/cgi-bin/micromsg-bin/alterchatroomwatchmembers";
    paramString.funcId = 447;
    c(paramString.bEF());
    AppMethodBeat.o(241430);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.c
 * JD-Core Version:    0.7.0.1
 */