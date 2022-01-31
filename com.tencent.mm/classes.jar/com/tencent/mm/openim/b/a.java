package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.bia;
import com.tencent.mm.protocal.protobuf.bib;
import com.tencent.mm.protocal.protobuf.co;
import com.tencent.mm.protocal.protobuf.cp;
import com.tencent.mm.roomsdk.a.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends com.tencent.mm.roomsdk.a.a
  implements k
{
  private f callback;
  private String gfK;
  private final com.tencent.mm.ai.b rr;
  
  public a(String paramString1, LinkedList<bia> paramLinkedList, String paramString2)
  {
    AppMethodBeat.i(78832);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new co();
    ((b.a)localObject).fsY = new cp();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/addopenimchatroommember";
    ((b.a)localObject).funcId = 814;
    this.rr = ((b.a)localObject).ado();
    this.gfK = paramString1;
    localObject = (co)this.rr.fsV.fta;
    ((co)localObject).gfM = paramString1;
    ((co)localObject).wpb = paramLinkedList;
    ((co)localObject).desc = paramString2;
    ab.i("MicroMsg.Openim.NetSceneAddOpenIMChatRoomMember", "roomname: %s, size:%s, desc:%s", new Object[] { paramString1, Integer.valueOf(paramLinkedList.size()), paramString2 });
    AppMethodBeat.o(78832);
  }
  
  public final com.tencent.mm.roomsdk.a.b.a a(com.tencent.mm.roomsdk.a.b.a parama)
  {
    AppMethodBeat.i(78835);
    if ((parama != null) && ((parama instanceof c)))
    {
      cp localcp = (cp)this.rr.fsW.fta;
      if (localcp != null)
      {
        com.tencent.mm.openim.room.a.b.b localb = new com.tencent.mm.openim.room.a.b.b();
        localb.q(localcp.wpb);
        parama = (c)parama;
        parama.chatroomName = this.gfK;
        parama.czr = localb.een.size();
        parama.cAs = localb.een;
        parama.een = localb.een;
        parama.cAv = localb.cAv;
        parama.eeo = localb.eeo;
        parama.cAx = localb.cAx;
        parama.eep = localb.eep;
        parama.cAy = localb.cAy;
        parama.wpc = localcp.wpc;
        AppMethodBeat.o(78835);
        return parama;
      }
    }
    AppMethodBeat.o(78835);
    return parama;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(78834);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78834);
    return i;
  }
  
  public final int getType()
  {
    return 814;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78833);
    ab.i("MicroMsg.Openim.NetSceneAddOpenIMChatRoomMember", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.gfK });
    if (paramq.getRespObj().getRetCode() == 0)
    {
      paramq = (cp)((com.tencent.mm.ai.b)paramq).fsW.fta;
      paramArrayOfByte = this.gfK;
      if ((paramArrayOfByte.toLowerCase().endsWith("@im.chatroom")) && (!paramq.wpb.isEmpty())) {
        break label169;
      }
      ab.e("MicroMsg.Openim.NetSceneAddOpenIMChatRoomMember", "AddChatroomMember: bad room:[" + paramArrayOfByte + "] listCnt:" + paramq.wpb.size());
    }
    for (;;)
    {
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(78833);
      return;
      label169:
      ArrayList localArrayList = new ArrayList();
      bd localbd = ((j)g.E(j.class)).YA();
      Iterator localIterator = paramq.wpb.iterator();
      while (localIterator.hasNext())
      {
        bib localbib = (bib)localIterator.next();
        if (localbib.status == 0)
        {
          paramq = localbd.arw(localbib.userName);
          if ((int)paramq.euF != 0)
          {
            paramq.Nw();
            localbd.b(paramq.field_username, paramq);
          }
          for (;;)
          {
            localArrayList.add(paramq.field_username);
            break;
            paramq = com.tencent.mm.openim.room.a.b.c.a(paramq, localbib);
            localbd.Y(paramq);
          }
        }
      }
      if (!localArrayList.isEmpty()) {
        ((com.tencent.mm.plugin.chatroom.a.b)g.E(com.tencent.mm.plugin.chatroom.a.b.class)).a(paramArrayOfByte, localArrayList, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.openim.b.a
 * JD-Core Version:    0.7.0.1
 */