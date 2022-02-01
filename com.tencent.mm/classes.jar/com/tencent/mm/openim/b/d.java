package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.al;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.adr;
import com.tencent.mm.protocal.protobuf.ads;
import com.tencent.mm.protocal.protobuf.cfm;
import com.tencent.mm.protocal.protobuf.cfn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.ac;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class d
  extends n
  implements k
{
  private f callback;
  private String dwx;
  private final com.tencent.mm.ak.b rr;
  
  public d(String paramString, LinkedList<cfm> paramLinkedList)
  {
    AppMethodBeat.i(151187);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new adr();
    ((b.a)localObject).hQG = new ads();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/delopenimchatroommember";
    ((b.a)localObject).funcId = 943;
    this.rr = ((b.a)localObject).aDS();
    this.dwx = paramString;
    localObject = (adr)this.rr.hQD.hQJ;
    ((adr)localObject).iKu = paramString;
    ((adr)localObject).FNS = paramLinkedList;
    ae.i("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "roomname: %s, size:%d", new Object[] { paramString, Integer.valueOf(paramLinkedList.size()) });
    AppMethodBeat.o(151187);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(151189);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(151189);
    return i;
  }
  
  public final int getType()
  {
    return 943;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151188);
    ae.i("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.dwx });
    Object localObject;
    if (paramq.getRespObj().getRetCode() == 0)
    {
      localObject = (ads)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
      paramArrayOfByte = this.dwx;
      if ((paramArrayOfByte.toLowerCase().endsWith("@im.chatroom")) && (!((ads)localObject).FNS.isEmpty())) {
        break label169;
      }
      ae.e("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "DelChatroomMember: room:[" + paramArrayOfByte + "] listCnt:" + ((ads)localObject).FNS.size());
    }
    for (;;)
    {
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(151188);
      return;
      label169:
      paramq = ((c)g.ab(c.class)).azP();
      paramArrayOfByte = paramq.Bx(paramArrayOfByte);
      List localList = ac.aUj(paramArrayOfByte.field_memberlist);
      ae.d("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "DelChatroomMember before " + localList.size());
      localObject = ((ads)localObject).FNS.iterator();
      while (((Iterator)localObject).hasNext()) {
        localList.remove(((cfn)((Iterator)localObject).next()).userName);
      }
      ae.d("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "DelChatroomMember after " + localList.size());
      localObject = ((com.tencent.mm.plugin.chatroom.a.b)g.ab(com.tencent.mm.plugin.chatroom.a.b.class)).af(localList);
      paramArrayOfByte.hA(localList).field_displayname = ((String)localObject);
      ae.d("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "delChatroomMember ".concat(String.valueOf(paramq.replace(paramArrayOfByte))));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.b.d
 * JD-Core Version:    0.7.0.1
 */