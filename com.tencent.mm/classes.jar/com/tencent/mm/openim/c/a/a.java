package com.tencent.mm.openim.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.protocal.protobuf.bia;
import com.tencent.mm.protocal.protobuf.fm;
import com.tencent.mm.protocal.protobuf.fn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  extends com.tencent.mm.ai.a<fn>
{
  public a(String paramString1, String paramString2, String paramString3, LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(78917);
    ab.d("MicroMsg.CgiOpenImApproveAddRoomMember", "CgiOpenImApproveAddRoomMember() inviterusername%s, roomname:%s, ticket:%s, username:%s", new Object[] { paramString1, paramString2, bo.aqg(paramString3), paramLinkedList });
    fm localfm = new fm();
    localfm.crs = paramString3;
    localfm.gfK = paramString2;
    paramString2 = new bia();
    paramString2.userName = paramString1;
    localfm.wrB = paramString2;
    paramString1 = new LinkedList();
    paramString2 = paramLinkedList.iterator();
    while (paramString2.hasNext())
    {
      paramString3 = (String)paramString2.next();
      paramLinkedList = new bia();
      paramLinkedList.userName = paramString3;
      paramString1.add(paramLinkedList);
    }
    localfm.wrC = paramString1;
    paramString1 = new b.a();
    paramString1.fsX = localfm;
    paramString1.fsY = new fn();
    paramString1.uri = "/cgi-bin/micromsg-bin/approveaddopenimchatroommember";
    paramString1.funcId = 941;
    this.rr = paramString1.ado();
    AppMethodBeat.o(78917);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.openim.c.a.a
 * JD-Core Version:    0.7.0.1
 */