package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.cfm;
import com.tencent.mm.protocal.protobuf.cfn;
import com.tencent.mm.protocal.protobuf.cz;
import com.tencent.mm.protocal.protobuf.da;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends com.tencent.mm.roomsdk.a.a
  implements k
{
  private f callback;
  private String dwx;
  private final com.tencent.mm.ak.b rr;
  
  public a(String paramString1, LinkedList<cfm> paramLinkedList, String paramString2)
  {
    AppMethodBeat.i(151176);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new cz();
    ((b.a)localObject).hQG = new da();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/addopenimchatroommember";
    ((b.a)localObject).funcId = 814;
    this.rr = ((b.a)localObject).aDS();
    this.dwx = paramString1;
    localObject = (cz)this.rr.hQD.hQJ;
    ((cz)localObject).iKu = paramString1;
    ((cz)localObject).FNS = paramLinkedList;
    ((cz)localObject).desc = paramString2;
    ae.i("MicroMsg.Openim.NetSceneAddOpenIMChatRoomMember", "roomname: %s, size:%s, desc:%s", new Object[] { paramString1, Integer.valueOf(paramLinkedList.size()), paramString2 });
    AppMethodBeat.o(151176);
  }
  
  public final com.tencent.mm.roomsdk.a.b.a a(com.tencent.mm.roomsdk.a.b.a parama)
  {
    AppMethodBeat.i(151179);
    if ((parama != null) && ((parama instanceof com.tencent.mm.roomsdk.a.b.c)))
    {
      da localda = (da)this.rr.hQE.hQJ;
      if (localda != null)
      {
        com.tencent.mm.openim.room.a.b.b localb = new com.tencent.mm.openim.room.a.b.b();
        localb.q(localda.FNS);
        parama = (com.tencent.mm.roomsdk.a.b.c)parama;
        parama.chatroomName = this.dwx;
        parama.dAb = localb.fML.size();
        parama.dBf = localb.fML;
        parama.fML = localb.fML;
        parama.dBi = localb.dBi;
        parama.fMM = localb.fMM;
        parama.dBk = localb.dBk;
        parama.fMN = localb.fMN;
        parama.dBl = localb.dBl;
        parama.FNT = localda.FNT;
        AppMethodBeat.o(151179);
        return parama;
      }
    }
    AppMethodBeat.o(151179);
    return parama;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(151178);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(151178);
    return i;
  }
  
  public final int getType()
  {
    return 814;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151177);
    ae.i("MicroMsg.Openim.NetSceneAddOpenIMChatRoomMember", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.dwx });
    if (paramq.getRespObj().getRetCode() == 0)
    {
      paramq = (da)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
      paramArrayOfByte = this.dwx;
      if ((paramArrayOfByte.toLowerCase().endsWith("@im.chatroom")) && (!paramq.FNS.isEmpty())) {
        break label169;
      }
      ae.e("MicroMsg.Openim.NetSceneAddOpenIMChatRoomMember", "AddChatroomMember: bad room:[" + paramArrayOfByte + "] listCnt:" + paramq.FNS.size());
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
      bq localbq = ((l)g.ab(l.class)).azF();
      Iterator localIterator = paramq.FNS.iterator();
      while (localIterator.hasNext())
      {
        cfn localcfn = (cfn)localIterator.next();
        if (localcfn.status == 0)
        {
          paramq = localbq.BH(localcfn.userName);
          if ((int)paramq.ght != 0)
          {
            paramq.acR();
            localbq.c(paramq.field_username, paramq);
          }
          for (;;)
          {
            localArrayList.add(paramq.field_username);
            break;
            paramq = com.tencent.mm.openim.room.a.b.c.a(paramq, localcfn);
            localbq.an(paramq);
          }
        }
      }
      if (!localArrayList.isEmpty()) {
        ((com.tencent.mm.plugin.chatroom.a.b)g.ab(com.tencent.mm.plugin.chatroom.a.b.class)).a(paramArrayOfByte, localArrayList, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.b.a
 * JD-Core Version:    0.7.0.1
 */