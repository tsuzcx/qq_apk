package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.aj;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.abi;
import com.tencent.mm.protocal.protobuf.abj;
import com.tencent.mm.protocal.protobuf.cab;
import com.tencent.mm.protocal.protobuf.cac;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.x;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class d
  extends n
  implements k
{
  private com.tencent.mm.ak.g callback;
  private String djF;
  private final com.tencent.mm.ak.b rr;
  
  public d(String paramString, LinkedList<cab> paramLinkedList)
  {
    AppMethodBeat.i(151187);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new abi();
    ((b.a)localObject).hvu = new abj();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/delopenimchatroommember";
    ((b.a)localObject).funcId = 943;
    this.rr = ((b.a)localObject).aAz();
    this.djF = paramString;
    localObject = (abi)this.rr.hvr.hvw;
    ((abi)localObject).ioe = paramString;
    ((abi)localObject).DQg = paramLinkedList;
    ac.i("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "roomname: %s, size:%d", new Object[] { paramString, Integer.valueOf(paramLinkedList.size()) });
    AppMethodBeat.o(151187);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(151189);
    this.callback = paramg;
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
    ac.i("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.djF });
    Object localObject;
    if (paramq.getRespObj().getRetCode() == 0)
    {
      localObject = (abj)((com.tencent.mm.ak.b)paramq).hvs.hvw;
      paramArrayOfByte = this.djF;
      if ((paramArrayOfByte.toLowerCase().endsWith("@im.chatroom")) && (!((abj)localObject).DQg.isEmpty())) {
        break label169;
      }
      ac.e("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "DelChatroomMember: room:[" + paramArrayOfByte + "] listCnt:" + ((abj)localObject).DQg.size());
    }
    for (;;)
    {
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(151188);
      return;
      label169:
      paramq = ((c)com.tencent.mm.kernel.g.ab(c.class)).awK();
      paramArrayOfByte = paramq.xN(paramArrayOfByte);
      List localList = x.aMX(paramArrayOfByte.field_memberlist);
      ac.d("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "DelChatroomMember before " + localList.size());
      localObject = ((abj)localObject).DQg.iterator();
      while (((Iterator)localObject).hasNext()) {
        localList.remove(((cac)((Iterator)localObject).next()).userName);
      }
      ac.d("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "DelChatroomMember after " + localList.size());
      localObject = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.b.class)).ae(localList);
      paramArrayOfByte.he(localList).field_displayname = ((String)localObject);
      ac.d("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "delChatroomMember ".concat(String.valueOf(paramq.replace(paramArrayOfByte))));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.b.d
 * JD-Core Version:    0.7.0.1
 */