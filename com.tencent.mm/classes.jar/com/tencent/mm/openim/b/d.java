package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.aq;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.chatroom.a.a;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.agd;
import com.tencent.mm.protocal.protobuf.age;
import com.tencent.mm.protocal.protobuf.dfd;
import com.tencent.mm.protocal.protobuf.dfe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ah;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class d
  extends q
  implements m
{
  private i callback;
  private String fHp;
  private final com.tencent.mm.an.d rr;
  
  public d(String paramString, LinkedList<dfd> paramLinkedList)
  {
    AppMethodBeat.i(151187);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new agd();
    ((d.a)localObject).lBV = new age();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/delopenimchatroommember";
    ((d.a)localObject).funcId = 943;
    this.rr = ((d.a)localObject).bgN();
    this.fHp = paramString;
    localObject = (agd)d.b.b(this.rr.lBR);
    ((agd)localObject).mye = paramString;
    ((agd)localObject).RIQ = paramLinkedList;
    Log.i("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "roomname: %s, size:%d", new Object[] { paramString, Integer.valueOf(paramLinkedList.size()) });
    AppMethodBeat.o(151187);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(151189);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(151189);
    return i;
  }
  
  public final int getType()
  {
    return 943;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151188);
    Log.i("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.fHp });
    Object localObject;
    if (params.getRespObj().getRetCode() == 0)
    {
      localObject = (age)d.c.b(((com.tencent.mm.an.d)params).lBS);
      paramArrayOfByte = this.fHp;
      if ((paramArrayOfByte.toLowerCase().endsWith("@im.chatroom")) && (!((age)localObject).RIQ.isEmpty())) {
        break label169;
      }
      Log.e("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "DelChatroomMember: room:[" + paramArrayOfByte + "] listCnt:" + ((age)localObject).RIQ.size());
    }
    for (;;)
    {
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(151188);
      return;
      label169:
      params = ((b)h.ae(b.class)).bbV();
      paramArrayOfByte = params.Rw(paramArrayOfByte);
      List localList = ah.bvC(paramArrayOfByte.field_memberlist);
      Log.d("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "DelChatroomMember before " + localList.size());
      localObject = ((age)localObject).RIQ.iterator();
      while (((Iterator)localObject).hasNext()) {
        localList.remove(((dfe)((Iterator)localObject).next()).userName);
      }
      Log.d("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "DelChatroomMember after " + localList.size());
      localObject = ((a)h.ae(a.class)).am(localList);
      paramArrayOfByte.jw(localList).field_displayname = ((String)localObject);
      Log.d("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "delChatroomMember ".concat(String.valueOf(params.replace(paramArrayOfByte))));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.b.d
 * JD-Core Version:    0.7.0.1
 */