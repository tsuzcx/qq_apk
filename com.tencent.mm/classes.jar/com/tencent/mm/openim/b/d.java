package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ag;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.bia;
import com.tencent.mm.protocal.protobuf.bib;
import com.tencent.mm.protocal.protobuf.xc;
import com.tencent.mm.protocal.protobuf.xd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.u;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class d
  extends m
  implements k
{
  private f callback;
  private String gfK;
  private final com.tencent.mm.ai.b rr;
  
  public d(String paramString, LinkedList<bia> paramLinkedList)
  {
    AppMethodBeat.i(78843);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new xc();
    ((b.a)localObject).fsY = new xd();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/delopenimchatroommember";
    ((b.a)localObject).funcId = 943;
    this.rr = ((b.a)localObject).ado();
    this.gfK = paramString;
    localObject = (xc)this.rr.fsV.fta;
    ((xc)localObject).gfM = paramString;
    ((xc)localObject).wpb = paramLinkedList;
    ab.i("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "roomname: %s, size:%d", new Object[] { paramString, Integer.valueOf(paramLinkedList.size()) });
    AppMethodBeat.o(78843);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(78845);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78845);
    return i;
  }
  
  public final int getType()
  {
    return 943;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78844);
    ab.i("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.gfK });
    Object localObject;
    if (paramq.getRespObj().getRetCode() == 0)
    {
      localObject = (xd)((com.tencent.mm.ai.b)paramq).fsW.fta;
      paramArrayOfByte = this.gfK;
      if ((paramArrayOfByte.toLowerCase().endsWith("@im.chatroom")) && (!((xd)localObject).wpb.isEmpty())) {
        break label169;
      }
      ab.e("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "DelChatroomMember: room:[" + paramArrayOfByte + "] listCnt:" + ((xd)localObject).wpb.size());
    }
    for (;;)
    {
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(78844);
      return;
      label169:
      paramq = ((c)g.E(c.class)).YJ();
      paramArrayOfByte = paramq.oU(paramArrayOfByte);
      List localList = u.aqZ(paramArrayOfByte.field_memberlist);
      ab.d("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "DelChatroomMember before " + localList.size());
      localObject = ((xd)localObject).wpb.iterator();
      while (((Iterator)localObject).hasNext()) {
        localList.remove(((bib)((Iterator)localObject).next()).userName);
      }
      ab.d("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "DelChatroomMember after " + localList.size());
      localObject = ((com.tencent.mm.plugin.chatroom.a.b)g.E(com.tencent.mm.plugin.chatroom.a.b.class)).R(localList);
      paramArrayOfByte.ex(localList).field_displayname = ((String)localObject);
      ab.d("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "delChatroomMember ".concat(String.valueOf(paramq.replace(paramArrayOfByte))));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.b.d
 * JD-Core Version:    0.7.0.1
 */