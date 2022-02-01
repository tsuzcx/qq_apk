package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.openim.room.a.b.b;
import com.tencent.mm.openim.room.a.b.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.dfd;
import com.tencent.mm.protocal.protobuf.dfe;
import com.tencent.mm.protocal.protobuf.dg;
import com.tencent.mm.protocal.protobuf.dh;
import com.tencent.mm.roomsdk.a.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends com.tencent.mm.roomsdk.a.a
  implements m
{
  private i callback;
  private String fHp;
  private final com.tencent.mm.an.d rr;
  
  public a(String paramString1, LinkedList<dfd> paramLinkedList, String paramString2)
  {
    AppMethodBeat.i(151176);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new dg();
    ((d.a)localObject).lBV = new dh();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/addopenimchatroommember";
    ((d.a)localObject).funcId = 814;
    this.rr = ((d.a)localObject).bgN();
    this.fHp = paramString1;
    localObject = (dg)d.b.b(this.rr.lBR);
    ((dg)localObject).mye = paramString1;
    ((dg)localObject).RIQ = paramLinkedList;
    ((dg)localObject).desc = paramString2;
    Log.i("MicroMsg.Openim.NetSceneAddOpenIMChatRoomMember", "roomname: %s, size:%s, desc:%s", new Object[] { paramString1, Integer.valueOf(paramLinkedList.size()), paramString2 });
    AppMethodBeat.o(151176);
  }
  
  public final com.tencent.mm.roomsdk.a.b.a a(com.tencent.mm.roomsdk.a.b.a parama)
  {
    AppMethodBeat.i(151179);
    if ((parama != null) && ((parama instanceof c)))
    {
      dh localdh = (dh)d.c.b(this.rr.lBS);
      if (localdh != null)
      {
        b.b localb = new b.b();
        localb.q(localdh.RIQ);
        parama = (c)parama;
        parama.chatroomName = this.fHp;
        parama.fLk = localb.iWi.size();
        parama.fMr = localb.iWi;
        parama.iWi = localb.iWi;
        parama.fMt = localb.fMt;
        parama.iWj = localb.iWj;
        parama.fMv = localb.fMv;
        parama.iWk = localb.iWk;
        parama.fMw = localb.fMw;
        parama.RIR = localdh.RIR;
        AppMethodBeat.o(151179);
        return parama;
      }
    }
    AppMethodBeat.o(151179);
    return parama;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(151178);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(151178);
    return i;
  }
  
  public final int getType()
  {
    return 814;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151177);
    Log.i("MicroMsg.Openim.NetSceneAddOpenIMChatRoomMember", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.fHp });
    if (params.getRespObj().getRetCode() == 0)
    {
      params = (dh)d.c.b(((com.tencent.mm.an.d)params).lBS);
      paramArrayOfByte = this.fHp;
      if ((paramArrayOfByte.toLowerCase().endsWith("@im.chatroom")) && (!params.RIQ.isEmpty())) {
        break label169;
      }
      Log.e("MicroMsg.Openim.NetSceneAddOpenIMChatRoomMember", "AddChatroomMember: bad room:[" + paramArrayOfByte + "] listCnt:" + params.RIQ.size());
    }
    for (;;)
    {
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(151177);
      return;
      label169:
      ArrayList localArrayList = new ArrayList();
      bv localbv = ((n)h.ae(n.class)).bbL();
      Iterator localIterator = params.RIQ.iterator();
      while (localIterator.hasNext())
      {
        dfe localdfe = (dfe)localIterator.next();
        if (localdfe.status == 0)
        {
          params = localbv.RG(localdfe.userName);
          if ((int)params.jxt != 0)
          {
            params.axj();
            localbv.c(params.field_username, params);
          }
          for (;;)
          {
            localArrayList.add(params.field_username);
            break;
            params = b.c.a(params, localdfe);
            localbv.av(params);
          }
        }
      }
      if (!localArrayList.isEmpty()) {
        ((com.tencent.mm.plugin.chatroom.a.a)h.ae(com.tencent.mm.plugin.chatroom.a.a.class)).a(paramArrayOfByte, localArrayList, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.b.a
 * JD-Core Version:    0.7.0.1
 */