package com.tencent.mm.openim.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.am.c.a;
import com.tencent.mm.protocal.protobuf.dxf;
import com.tencent.mm.protocal.protobuf.hj;
import com.tencent.mm.protocal.protobuf.hk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  extends b<hk>
{
  public a(String paramString1, String paramString2, String paramString3, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(151261);
    Log.d("MicroMsg.CgiOpenImApproveAddRoomMember", "CgiOpenImApproveAddRoomMember() inviterusername%s, roomname:%s, ticket:%s, username:%s", new Object[] { paramString1, paramString2, Util.secPrint(paramString3), paramLinkedList });
    hj localhj = new hj();
    localhj.hFb = paramString3;
    localhj.hMM = paramString2;
    paramString2 = new dxf();
    paramString2.userName = paramString1;
    localhj.YIO = paramString2;
    paramString1 = new LinkedList();
    paramString2 = paramLinkedList.iterator();
    while (paramString2.hasNext())
    {
      paramString3 = (String)paramString2.next();
      paramLinkedList = new dxf();
      paramLinkedList.userName = paramString3;
      paramString1.add(paramLinkedList);
    }
    localhj.YIP = paramString1;
    paramString1 = new c.a();
    paramString1.otE = localhj;
    paramString1.otF = new hk();
    paramString1.uri = "/cgi-bin/micromsg-bin/approveaddopenimchatroommember";
    paramString1.funcId = 941;
    c(paramString1.bEF());
    AppMethodBeat.o(151261);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.openim.b.a.a
 * JD-Core Version:    0.7.0.1
 */