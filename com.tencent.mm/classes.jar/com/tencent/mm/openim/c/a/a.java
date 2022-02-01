package com.tencent.mm.openim.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.protocal.protobuf.cfm;
import com.tencent.mm.protocal.protobuf.gp;
import com.tencent.mm.protocal.protobuf.gq;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  extends com.tencent.mm.ak.a<gq>
{
  public a(String paramString1, String paramString2, String paramString3, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(151261);
    ae.d("MicroMsg.CgiOpenImApproveAddRoomMember", "CgiOpenImApproveAddRoomMember() inviterusername%s, roomname:%s, ticket:%s, username:%s", new Object[] { paramString1, paramString2, bu.aSM(paramString3), paramLinkedList });
    gp localgp = new gp();
    localgp.dqk = paramString3;
    localgp.dwx = paramString2;
    paramString2 = new cfm();
    paramString2.userName = paramString1;
    localgp.FRe = paramString2;
    paramString1 = new LinkedList();
    paramString2 = paramLinkedList.iterator();
    while (paramString2.hasNext())
    {
      paramString3 = (String)paramString2.next();
      paramLinkedList = new cfm();
      paramLinkedList.userName = paramString3;
      paramString1.add(paramLinkedList);
    }
    localgp.FRf = paramString1;
    paramString1 = new b.a();
    paramString1.hQF = localgp;
    paramString1.hQG = new gq();
    paramString1.uri = "/cgi-bin/micromsg-bin/approveaddopenimchatroommember";
    paramString1.funcId = 941;
    c(paramString1.aDS());
    AppMethodBeat.o(151261);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.c.a.a
 * JD-Core Version:    0.7.0.1
 */