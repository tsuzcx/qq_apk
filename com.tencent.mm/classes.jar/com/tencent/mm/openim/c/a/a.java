package com.tencent.mm.openim.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.c;
import com.tencent.mm.protocal.protobuf.cab;
import com.tencent.mm.protocal.protobuf.gi;
import com.tencent.mm.protocal.protobuf.gj;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  extends c<gj>
{
  public a(String paramString1, String paramString2, String paramString3, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(151261);
    ac.d("MicroMsg.CgiOpenImApproveAddRoomMember", "CgiOpenImApproveAddRoomMember() inviterusername%s, roomname:%s, ticket:%s, username:%s", new Object[] { paramString1, paramString2, bs.aLJ(paramString3), paramLinkedList });
    gi localgi = new gi();
    localgi.ddJ = paramString3;
    localgi.djF = paramString2;
    paramString2 = new cab();
    paramString2.userName = paramString1;
    localgi.DTn = paramString2;
    paramString1 = new LinkedList();
    paramString2 = paramLinkedList.iterator();
    while (paramString2.hasNext())
    {
      paramString3 = (String)paramString2.next();
      paramLinkedList = new cab();
      paramLinkedList.userName = paramString3;
      paramString1.add(paramLinkedList);
    }
    localgi.DTo = paramString1;
    paramString1 = new b.a();
    paramString1.hvt = localgi;
    paramString1.hvu = new gj();
    paramString1.uri = "/cgi-bin/micromsg-bin/approveaddopenimchatroommember";
    paramString1.funcId = 941;
    this.rr = paramString1.aAz();
    AppMethodBeat.o(151261);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.c.a.a
 * JD-Core Version:    0.7.0.1
 */