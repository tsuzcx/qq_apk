package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.model.aj;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.aaj;
import com.tencent.mm.protocal.protobuf.aak;
import com.tencent.mm.protocal.protobuf.bvj;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.w;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class d
  extends n
  implements k
{
  private com.tencent.mm.al.g callback;
  private String dlX;
  private final com.tencent.mm.al.b rr;
  
  public d(String paramString, LinkedList<bvj> paramLinkedList)
  {
    AppMethodBeat.i(151187);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new aaj();
    ((b.a)localObject).gUV = new aak();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/delopenimchatroommember";
    ((b.a)localObject).funcId = 943;
    this.rr = ((b.a)localObject).atI();
    this.dlX = paramString;
    localObject = (aaj)this.rr.gUS.gUX;
    ((aaj)localObject).hNI = paramString;
    ((aaj)localObject).CxK = paramLinkedList;
    ad.i("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "roomname: %s, size:%d", new Object[] { paramString, Integer.valueOf(paramLinkedList.size()) });
    AppMethodBeat.o(151187);
  }
  
  public final int doScene(e parame, com.tencent.mm.al.g paramg)
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
    ad.i("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.dlX });
    Object localObject;
    if (paramq.getRespObj().getRetCode() == 0)
    {
      localObject = (aak)((com.tencent.mm.al.b)paramq).gUT.gUX;
      paramArrayOfByte = this.dlX;
      if ((paramArrayOfByte.toLowerCase().endsWith("@im.chatroom")) && (!((aak)localObject).CxK.isEmpty())) {
        break label169;
      }
      ad.e("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "DelChatroomMember: room:[" + paramArrayOfByte + "] listCnt:" + ((aak)localObject).CxK.size());
    }
    for (;;)
    {
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(151188);
      return;
      label169:
      paramq = ((c)com.tencent.mm.kernel.g.ab(c.class)).apV();
      paramArrayOfByte = paramq.tH(paramArrayOfByte);
      List localList = w.aHC(paramArrayOfByte.field_memberlist);
      ad.d("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "DelChatroomMember before " + localList.size());
      localObject = ((aak)localObject).CxK.iterator();
      while (((Iterator)localObject).hasNext()) {
        localList.remove(((bvk)((Iterator)localObject).next()).userName);
      }
      ad.d("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "DelChatroomMember after " + localList.size());
      localObject = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.b.class)).ah(localList);
      paramArrayOfByte.gR(localList).field_displayname = ((String)localObject);
      ad.d("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "delChatroomMember ".concat(String.valueOf(paramq.replace(paramArrayOfByte))));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.b.d
 * JD-Core Version:    0.7.0.1
 */