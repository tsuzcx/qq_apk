package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.openim.room.a.b.b;
import com.tencent.mm.openim.room.a.b.c;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.protocal.protobuf.cvu;
import com.tencent.mm.protocal.protobuf.di;
import com.tencent.mm.protocal.protobuf.dj;
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
  private String dOe;
  private final d rr;
  
  public a(String paramString1, LinkedList<cvt> paramLinkedList, String paramString2)
  {
    AppMethodBeat.i(151176);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new di();
    ((d.a)localObject).iLO = new dj();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/addopenimchatroommember";
    ((d.a)localObject).funcId = 814;
    this.rr = ((d.a)localObject).aXF();
    this.dOe = paramString1;
    localObject = (di)this.rr.iLK.iLR;
    ((di)localObject).jHa = paramString1;
    ((di)localObject).KHx = paramLinkedList;
    ((di)localObject).desc = paramString2;
    Log.i("MicroMsg.Openim.NetSceneAddOpenIMChatRoomMember", "roomname: %s, size:%s, desc:%s", new Object[] { paramString1, Integer.valueOf(paramLinkedList.size()), paramString2 });
    AppMethodBeat.o(151176);
  }
  
  public final com.tencent.mm.roomsdk.a.b.a a(com.tencent.mm.roomsdk.a.b.a parama)
  {
    AppMethodBeat.i(151179);
    if ((parama != null) && ((parama instanceof com.tencent.mm.roomsdk.a.b.c)))
    {
      dj localdj = (dj)this.rr.iLL.iLR;
      if (localdj != null)
      {
        b.b localb = new b.b();
        localb.q(localdj.KHx);
        parama = (com.tencent.mm.roomsdk.a.b.c)parama;
        parama.chatroomName = this.dOe;
        parama.dRN = localb.grX.size();
        parama.dSU = localb.grX;
        parama.grX = localb.grX;
        parama.dSX = localb.dSX;
        parama.grY = localb.grY;
        parama.dSZ = localb.dSZ;
        parama.grZ = localb.grZ;
        parama.dTa = localb.dTa;
        parama.KHy = localdj.KHy;
        AppMethodBeat.o(151179);
        return parama;
      }
    }
    AppMethodBeat.o(151179);
    return parama;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
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
    Log.i("MicroMsg.Openim.NetSceneAddOpenIMChatRoomMember", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.dOe });
    if (params.getRespObj().getRetCode() == 0)
    {
      params = (dj)((d)params).iLL.iLR;
      paramArrayOfByte = this.dOe;
      if ((paramArrayOfByte.toLowerCase().endsWith("@im.chatroom")) && (!params.KHx.isEmpty())) {
        break label169;
      }
      Log.e("MicroMsg.Openim.NetSceneAddOpenIMChatRoomMember", "AddChatroomMember: bad room:[" + paramArrayOfByte + "] listCnt:" + params.KHx.size());
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
      bv localbv = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN();
      Iterator localIterator = params.KHx.iterator();
      while (localIterator.hasNext())
      {
        cvu localcvu = (cvu)localIterator.next();
        if (localcvu.status == 0)
        {
          params = localbv.Kn(localcvu.userName);
          if ((int)params.gMZ != 0)
          {
            params.aqP();
            localbv.c(params.field_username, params);
          }
          for (;;)
          {
            localArrayList.add(params.field_username);
            break;
            params = b.c.a(params, localcvu);
            localbv.ap(params);
          }
        }
      }
      if (!localArrayList.isEmpty()) {
        ((b)com.tencent.mm.kernel.g.af(b.class)).a(paramArrayOfByte, localArrayList, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.b.a
 * JD-Core Version:    0.7.0.1
 */