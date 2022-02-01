package com.tencent.mm.openim.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.protocal.protobuf.hc;
import com.tencent.mm.protocal.protobuf.hd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  extends c<hd>
{
  public a(String paramString1, String paramString2, String paramString3, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(151261);
    Log.d("MicroMsg.CgiOpenImApproveAddRoomMember", "CgiOpenImApproveAddRoomMember() inviterusername%s, roomname:%s, ticket:%s, username:%s", new Object[] { paramString1, paramString2, Util.secPrint(paramString3), paramLinkedList });
    hc localhc = new hc();
    localhc.dHx = paramString3;
    localhc.dOe = paramString2;
    paramString2 = new cvt();
    paramString2.userName = paramString1;
    localhc.KKL = paramString2;
    paramString1 = new LinkedList();
    paramString2 = paramLinkedList.iterator();
    while (paramString2.hasNext())
    {
      paramString3 = (String)paramString2.next();
      paramLinkedList = new cvt();
      paramLinkedList.userName = paramString3;
      paramString1.add(paramLinkedList);
    }
    localhc.KKM = paramString1;
    paramString1 = new d.a();
    paramString1.iLN = localhc;
    paramString1.iLO = new hd();
    paramString1.uri = "/cgi-bin/micromsg-bin/approveaddopenimchatroommember";
    paramString1.funcId = 941;
    c(paramString1.aXF());
    AppMethodBeat.o(151261);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.c.a.a
 * JD-Core Version:    0.7.0.1
 */