package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.g.c.au;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.bvj;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.protocal.protobuf.cw;
import com.tencent.mm.protocal.protobuf.cx;
import com.tencent.mm.roomsdk.a.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends com.tencent.mm.roomsdk.a.a
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.al.g callback;
  private String dlX;
  private final com.tencent.mm.al.b rr;
  
  public a(String paramString1, LinkedList<bvj> paramLinkedList, String paramString2)
  {
    AppMethodBeat.i(151176);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new cw();
    ((b.a)localObject).gUV = new cx();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/addopenimchatroommember";
    ((b.a)localObject).funcId = 814;
    this.rr = ((b.a)localObject).atI();
    this.dlX = paramString1;
    localObject = (cw)this.rr.gUS.gUX;
    ((cw)localObject).hNI = paramString1;
    ((cw)localObject).CxK = paramLinkedList;
    ((cw)localObject).desc = paramString2;
    ad.i("MicroMsg.Openim.NetSceneAddOpenIMChatRoomMember", "roomname: %s, size:%s, desc:%s", new Object[] { paramString1, Integer.valueOf(paramLinkedList.size()), paramString2 });
    AppMethodBeat.o(151176);
  }
  
  public final com.tencent.mm.roomsdk.a.b.a a(com.tencent.mm.roomsdk.a.b.a parama)
  {
    AppMethodBeat.i(151179);
    if ((parama != null) && ((parama instanceof c)))
    {
      cx localcx = (cx)this.rr.gUT.gUX;
      if (localcx != null)
      {
        com.tencent.mm.openim.room.a.b.b localb = new com.tencent.mm.openim.room.a.b.b();
        localb.q(localcx.CxK);
        parama = (c)parama;
        parama.chatroomName = this.dlX;
        parama.dpx = localb.foI.size();
        parama.dqB = localb.foI;
        parama.foI = localb.foI;
        parama.dqE = localb.dqE;
        parama.foJ = localb.foJ;
        parama.dqG = localb.dqG;
        parama.foK = localb.foK;
        parama.dqH = localb.dqH;
        parama.CxL = localcx.CxL;
        AppMethodBeat.o(151179);
        return parama;
      }
    }
    AppMethodBeat.o(151179);
    return parama;
  }
  
  public final int doScene(e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(151178);
    this.callback = paramg;
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
    ad.i("MicroMsg.Openim.NetSceneAddOpenIMChatRoomMember", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.dlX });
    if (paramq.getRespObj().getRetCode() == 0)
    {
      paramq = (cx)((com.tencent.mm.al.b)paramq).gUT.gUX;
      paramArrayOfByte = this.dlX;
      if ((paramArrayOfByte.toLowerCase().endsWith("@im.chatroom")) && (!paramq.CxK.isEmpty())) {
        break label169;
      }
      ad.e("MicroMsg.Openim.NetSceneAddOpenIMChatRoomMember", "AddChatroomMember: bad room:[" + paramArrayOfByte + "] listCnt:" + paramq.CxK.size());
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
      bg localbg = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM();
      Iterator localIterator = paramq.CxK.iterator();
      while (localIterator.hasNext())
      {
        bvk localbvk = (bvk)localIterator.next();
        if (localbvk.status == 0)
        {
          paramq = localbg.aHY(localbvk.userName);
          if ((int)paramq.fId != 0)
          {
            paramq.Zj();
            localbg.c(paramq.field_username, paramq);
          }
          for (;;)
          {
            localArrayList.add(paramq.field_username);
            break;
            paramq = com.tencent.mm.openim.room.a.b.c.a(paramq, localbvk);
            localbg.af(paramq);
          }
        }
      }
      if (!localArrayList.isEmpty()) {
        ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.b.class)).a(paramArrayOfByte, localArrayList, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.b.a
 * JD-Core Version:    0.7.0.1
 */