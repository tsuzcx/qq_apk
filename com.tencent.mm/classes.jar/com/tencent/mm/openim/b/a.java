package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.g.c.av;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.cab;
import com.tencent.mm.protocal.protobuf.cac;
import com.tencent.mm.protocal.protobuf.cy;
import com.tencent.mm.protocal.protobuf.cz;
import com.tencent.mm.roomsdk.a.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends com.tencent.mm.roomsdk.a.a
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.ak.g callback;
  private String djF;
  private final com.tencent.mm.ak.b rr;
  
  public a(String paramString1, LinkedList<cab> paramLinkedList, String paramString2)
  {
    AppMethodBeat.i(151176);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new cy();
    ((b.a)localObject).hvu = new cz();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/addopenimchatroommember";
    ((b.a)localObject).funcId = 814;
    this.rr = ((b.a)localObject).aAz();
    this.djF = paramString1;
    localObject = (cy)this.rr.hvr.hvw;
    ((cy)localObject).ioe = paramString1;
    ((cy)localObject).DQg = paramLinkedList;
    ((cy)localObject).desc = paramString2;
    ac.i("MicroMsg.Openim.NetSceneAddOpenIMChatRoomMember", "roomname: %s, size:%s, desc:%s", new Object[] { paramString1, Integer.valueOf(paramLinkedList.size()), paramString2 });
    AppMethodBeat.o(151176);
  }
  
  public final com.tencent.mm.roomsdk.a.b.a a(com.tencent.mm.roomsdk.a.b.a parama)
  {
    AppMethodBeat.i(151179);
    if ((parama != null) && ((parama instanceof c)))
    {
      cz localcz = (cz)this.rr.hvs.hvw;
      if (localcz != null)
      {
        com.tencent.mm.openim.room.a.b.b localb = new com.tencent.mm.openim.room.a.b.b();
        localb.q(localcz.DQg);
        parama = (c)parama;
        parama.chatroomName = this.djF;
        parama.dni = localb.fsi.size();
        parama.dom = localb.fsi;
        parama.fsi = localb.fsi;
        parama.dop = localb.dop;
        parama.fsj = localb.fsj;
        parama.dor = localb.dor;
        parama.fsk = localb.fsk;
        parama.dos = localb.dos;
        parama.DQh = localcz.DQh;
        AppMethodBeat.o(151179);
        return parama;
      }
    }
    AppMethodBeat.o(151179);
    return parama;
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
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
    ac.i("MicroMsg.Openim.NetSceneAddOpenIMChatRoomMember", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.djF });
    if (paramq.getRespObj().getRetCode() == 0)
    {
      paramq = (cz)((com.tencent.mm.ak.b)paramq).hvs.hvw;
      paramArrayOfByte = this.djF;
      if ((paramArrayOfByte.toLowerCase().endsWith("@im.chatroom")) && (!paramq.DQg.isEmpty())) {
        break label169;
      }
      ac.e("MicroMsg.Openim.NetSceneAddOpenIMChatRoomMember", "AddChatroomMember: bad room:[" + paramArrayOfByte + "] listCnt:" + paramq.DQg.size());
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
      bj localbj = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB();
      Iterator localIterator = paramq.DQg.iterator();
      while (localIterator.hasNext())
      {
        cac localcac = (cac)localIterator.next();
        if (localcac.status == 0)
        {
          paramq = localbj.aNt(localcac.userName);
          if ((int)paramq.fLJ != 0)
          {
            paramq.aae();
            localbj.c(paramq.field_username, paramq);
          }
          for (;;)
          {
            localArrayList.add(paramq.field_username);
            break;
            paramq = com.tencent.mm.openim.room.a.b.c.a(paramq, localcac);
            localbj.ag(paramq);
          }
        }
      }
      if (!localArrayList.isEmpty()) {
        ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.b.class)).a(paramArrayOfByte, localArrayList, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.b.a
 * JD-Core Version:    0.7.0.1
 */