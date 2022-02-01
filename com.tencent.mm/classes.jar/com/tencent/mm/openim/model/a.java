package com.tencent.mm.openim.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.openim.room.a.b.b;
import com.tencent.mm.openim.room.a.b.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.dq;
import com.tencent.mm.protocal.protobuf.dr;
import com.tencent.mm.protocal.protobuf.dxf;
import com.tencent.mm.protocal.protobuf.dxg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends com.tencent.mm.roomsdk.model.a
  implements m
{
  private com.tencent.mm.am.h callback;
  private String hMM;
  private final com.tencent.mm.am.c rr;
  
  public a(String paramString1, LinkedList<dxf> paramLinkedList, String paramString2)
  {
    AppMethodBeat.i(151176);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new dq();
    ((c.a)localObject).otF = new dr();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/addopenimchatroommember";
    ((c.a)localObject).funcId = 814;
    this.rr = ((c.a)localObject).bEF();
    this.hMM = paramString1;
    localObject = (dq)c.b.b(this.rr.otB);
    ((dq)localObject).pss = paramString1;
    ((dq)localObject).YFR = paramLinkedList;
    ((dq)localObject).desc = paramString2;
    Log.i("MicroMsg.Openim.NetSceneAddOpenIMChatRoomMember", "roomname: %s, size:%s, desc:%s", new Object[] { paramString1, Integer.valueOf(paramLinkedList.size()), paramString2 });
    AppMethodBeat.o(151176);
  }
  
  public final com.tencent.mm.roomsdk.model.b.a a(com.tencent.mm.roomsdk.model.b.a parama)
  {
    AppMethodBeat.i(151179);
    if ((parama != null) && ((parama instanceof com.tencent.mm.roomsdk.model.b.c)))
    {
      dr localdr = (dr)c.c.b(this.rr.otC);
      if (localdr != null)
      {
        b.b localb = new b.b();
        localb.q(localdr.YFR);
        parama = (com.tencent.mm.roomsdk.model.b.c)parama;
        parama.chatroomName = this.hMM;
        parama.hQS = localb.lyj.size();
        parama.hSb = localb.lyj;
        parama.lyj = localb.lyj;
        parama.hSd = localb.hSd;
        parama.lyk = localb.lyk;
        parama.hSf = localb.hSf;
        parama.lyl = localb.lyl;
        parama.hSg = localb.hSg;
        parama.YFS = localdr.YFS;
        AppMethodBeat.o(151179);
        return parama;
      }
    }
    AppMethodBeat.o(151179);
    return parama;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(151178);
    this.callback = paramh;
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
    Log.i("MicroMsg.Openim.NetSceneAddOpenIMChatRoomMember", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.hMM });
    if (params.getRespObj().getRetCode() == 0)
    {
      params = (dr)c.c.b(((com.tencent.mm.am.c)params).otC);
      paramArrayOfByte = this.hMM;
      if ((paramArrayOfByte.toLowerCase().endsWith("@im.chatroom")) && (!params.YFR.isEmpty())) {
        break label166;
      }
      Log.e("MicroMsg.Openim.NetSceneAddOpenIMChatRoomMember", "AddChatroomMember: bad room:[" + paramArrayOfByte + "] listCnt:" + params.YFR.size());
    }
    for (;;)
    {
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(151177);
      return;
      label166:
      ArrayList localArrayList = new ArrayList();
      bx localbx = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA();
      Iterator localIterator = params.YFR.iterator();
      while (localIterator.hasNext())
      {
        dxg localdxg = (dxg)localIterator.next();
        if (localdxg.status == 0)
        {
          params = localbx.JE(localdxg.userName);
          if ((int)params.maN != 0)
          {
            params.aRJ();
            localbx.d(params.field_username, params);
          }
          for (;;)
          {
            localArrayList.add(params.field_username);
            break;
            params = b.c.a(params, localdxg);
            localbx.aB(params);
          }
        }
      }
      if (!localArrayList.isEmpty()) {
        ((com.tencent.mm.plugin.chatroom.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.a.class)).a(paramArrayOfByte, localArrayList, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.model.a
 * JD-Core Version:    0.7.0.1
 */