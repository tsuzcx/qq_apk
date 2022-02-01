package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.ces;
import com.tencent.mm.protocal.protobuf.cet;
import com.tencent.mm.protocal.protobuf.cz;
import com.tencent.mm.protocal.protobuf.da;
import com.tencent.mm.roomsdk.a.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends com.tencent.mm.roomsdk.a.a
  implements k
{
  private f callback;
  private String dvs;
  private final com.tencent.mm.al.b rr;
  
  public a(String paramString1, LinkedList<ces> paramLinkedList, String paramString2)
  {
    AppMethodBeat.i(151176);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new cz();
    ((b.a)localObject).hNN = new da();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/addopenimchatroommember";
    ((b.a)localObject).funcId = 814;
    this.rr = ((b.a)localObject).aDC();
    this.dvs = paramString1;
    localObject = (cz)this.rr.hNK.hNQ;
    ((cz)localObject).iHB = paramString1;
    ((cz)localObject).Fvu = paramLinkedList;
    ((cz)localObject).desc = paramString2;
    ad.i("MicroMsg.Openim.NetSceneAddOpenIMChatRoomMember", "roomname: %s, size:%s, desc:%s", new Object[] { paramString1, Integer.valueOf(paramLinkedList.size()), paramString2 });
    AppMethodBeat.o(151176);
  }
  
  public final com.tencent.mm.roomsdk.a.b.a a(com.tencent.mm.roomsdk.a.b.a parama)
  {
    AppMethodBeat.i(151179);
    if ((parama != null) && ((parama instanceof c)))
    {
      da localda = (da)this.rr.hNL.hNQ;
      if (localda != null)
      {
        com.tencent.mm.openim.room.a.b.b localb = new com.tencent.mm.openim.room.a.b.b();
        localb.q(localda.Fvu);
        parama = (c)parama;
        parama.chatroomName = this.dvs;
        parama.dyW = localb.fKI.size();
        parama.dAa = localb.fKI;
        parama.fKI = localb.fKI;
        parama.dAd = localb.dAd;
        parama.fKJ = localb.fKJ;
        parama.dAf = localb.dAf;
        parama.fKK = localb.fKK;
        parama.dAg = localb.dAg;
        parama.Fvv = localda.Fvv;
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
    ad.i("MicroMsg.Openim.NetSceneAddOpenIMChatRoomMember", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.dvs });
    if (paramq.getRespObj().getRetCode() == 0)
    {
      paramq = (da)((com.tencent.mm.al.b)paramq).hNL.hNQ;
      paramArrayOfByte = this.dvs;
      if ((paramArrayOfByte.toLowerCase().endsWith("@im.chatroom")) && (!paramq.Fvu.isEmpty())) {
        break label169;
      }
      ad.e("MicroMsg.Openim.NetSceneAddOpenIMChatRoomMember", "AddChatroomMember: bad room:[" + paramArrayOfByte + "] listCnt:" + paramq.Fvu.size());
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
      bp localbp = ((l)g.ab(l.class)).azp();
      Iterator localIterator = paramq.Fvu.iterator();
      while (localIterator.hasNext())
      {
        cet localcet = (cet)localIterator.next();
        if (localcet.status == 0)
        {
          paramq = localbp.Bf(localcet.userName);
          if ((int)paramq.gfj != 0)
          {
            paramq.acG();
            localbp.c(paramq.field_username, paramq);
          }
          for (;;)
          {
            localArrayList.add(paramq.field_username);
            break;
            paramq = com.tencent.mm.openim.room.a.b.c.a(paramq, localcet);
            localbp.ag(paramq);
          }
        }
      }
      if (!localArrayList.isEmpty()) {
        ((com.tencent.mm.plugin.chatroom.a.b)g.ab(com.tencent.mm.plugin.chatroom.a.b.class)).a(paramArrayOfByte, localArrayList, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.b.a
 * JD-Core Version:    0.7.0.1
 */