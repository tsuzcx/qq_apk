package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.adi;
import com.tencent.mm.protocal.protobuf.adj;
import com.tencent.mm.protocal.protobuf.ces;
import com.tencent.mm.protocal.protobuf.cet;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class d
  extends n
  implements k
{
  private f callback;
  private String dvs;
  private final com.tencent.mm.al.b rr;
  
  public d(String paramString, LinkedList<ces> paramLinkedList)
  {
    AppMethodBeat.i(151187);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new adi();
    ((b.a)localObject).hNN = new adj();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/delopenimchatroommember";
    ((b.a)localObject).funcId = 943;
    this.rr = ((b.a)localObject).aDC();
    this.dvs = paramString;
    localObject = (adi)this.rr.hNK.hNQ;
    ((adi)localObject).iHB = paramString;
    ((adi)localObject).Fvu = paramLinkedList;
    ad.i("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "roomname: %s, size:%d", new Object[] { paramString, Integer.valueOf(paramLinkedList.size()) });
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
    ad.i("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.dvs });
    Object localObject;
    if (paramq.getRespObj().getRetCode() == 0)
    {
      localObject = (adj)((com.tencent.mm.al.b)paramq).hNL.hNQ;
      paramArrayOfByte = this.dvs;
      if ((paramArrayOfByte.toLowerCase().endsWith("@im.chatroom")) && (!((adj)localObject).Fvu.isEmpty())) {
        break label169;
      }
      ad.e("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "DelChatroomMember: room:[" + paramArrayOfByte + "] listCnt:" + ((adj)localObject).Fvu.size());
    }
    for (;;)
    {
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(151188);
      return;
      label169:
      paramq = ((c)g.ab(c.class)).azz();
      paramArrayOfByte = paramq.AN(paramArrayOfByte);
      List localList = ab.aSK(paramArrayOfByte.field_memberlist);
      ad.d("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "DelChatroomMember before " + localList.size());
      localObject = ((adj)localObject).Fvu.iterator();
      while (((Iterator)localObject).hasNext()) {
        localList.remove(((cet)((Iterator)localObject).next()).userName);
      }
      ad.d("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "DelChatroomMember after " + localList.size());
      localObject = ((com.tencent.mm.plugin.chatroom.a.b)g.ab(com.tencent.mm.plugin.chatroom.a.b.class)).af(localList);
      paramArrayOfByte.hq(localList).field_displayname = ((String)localObject);
      ad.d("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "delChatroomMember ".concat(String.valueOf(paramq.replace(paramArrayOfByte))));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.b.d
 * JD-Core Version:    0.7.0.1
 */