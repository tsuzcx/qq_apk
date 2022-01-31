package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.i;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.bia;
import com.tencent.mm.protocal.protobuf.bib;
import com.tencent.mm.protocal.protobuf.vx;
import com.tencent.mm.protocal.protobuf.vy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends com.tencent.mm.roomsdk.a.a
  implements k
{
  private f callback;
  private final com.tencent.mm.ai.b rr;
  
  public c(LinkedList<bia> paramLinkedList)
  {
    AppMethodBeat.i(78839);
    b.a locala = new b.a();
    locala.fsX = new vx();
    locala.fsY = new vy();
    locala.uri = "/cgi-bin/micromsg-bin/createopenimchatroom";
    locala.funcId = 371;
    this.rr = locala.ado();
    ((vx)this.rr.fsV.fta).wpb = paramLinkedList;
    ab.i("MicroMsg.Openim.NetSceneCreateOpenIMChatRoom", "create size:%d", new Object[] { Integer.valueOf(paramLinkedList.size()) });
    AppMethodBeat.o(78839);
  }
  
  public final com.tencent.mm.roomsdk.a.b.a a(com.tencent.mm.roomsdk.a.b.a parama)
  {
    AppMethodBeat.i(78842);
    if ((parama != null) && ((parama instanceof com.tencent.mm.roomsdk.a.b.c)))
    {
      vy localvy = (vy)this.rr.fsW.fta;
      if (localvy != null)
      {
        com.tencent.mm.openim.room.a.b.b localb = new com.tencent.mm.openim.room.a.b.b();
        localb.q(localvy.wpb);
        parama = (com.tencent.mm.roomsdk.a.b.c)parama;
        parama.chatroomName = localvy.gfM;
        parama.czr = localb.een.size();
        parama.cAs = localb.een;
        parama.een = localb.een;
        parama.cAv = localb.cAv;
        parama.eeo = localb.eeo;
        parama.cAx = localb.cAx;
        parama.eep = localb.eep;
        parama.cAy = localb.cAy;
        AppMethodBeat.o(78842);
        return parama;
      }
    }
    AppMethodBeat.o(78842);
    return parama;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(78841);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78841);
    return i;
  }
  
  public final int getType()
  {
    return 371;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78840);
    ab.i("MicroMsg.Openim.NetSceneCreateOpenIMChatRoom", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (paramq.getRespObj().getRetCode() == 0)
    {
      paramq = (vy)((com.tencent.mm.ai.b)paramq).fsW.fta;
      if (!bo.isNullOrNil(paramq.gfM))
      {
        if (paramq.gfM.toLowerCase().endsWith("@im.chatroom")) {
          break label151;
        }
        ab.e("MicroMsg.Openim.NetSceneCreateOpenIMChatRoom", "createChatroom: bad room:[" + paramq.gfM + "]");
      }
    }
    for (;;)
    {
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(78840);
      return;
      label151:
      paramArrayOfByte = new ad();
      paramArrayOfByte.setUsername(paramq.gfM);
      bd localbd = ((j)g.E(j.class)).YA();
      if (!localbd.ary(paramArrayOfByte.field_username)) {
        localbd.Y(paramArrayOfByte);
      }
      if ((!bo.isNullOrNil(paramArrayOfByte.field_username)) && (!bo.isNullOrNil(paramq.wOB)))
      {
        localObject = new h();
        ((h)localObject).username = paramArrayOfByte.field_username;
        ((h)localObject).fsl = paramq.wOA;
        ((h)localObject).fsk = paramq.wOB;
        ((h)localObject).dqB = 3;
        ((h)localObject).cM(false);
        ((h)localObject).bsY = -1;
        o.adg().b((h)localObject);
      }
      Object localObject = new ArrayList();
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
            ((ArrayList)localObject).add(paramq.field_username);
            break;
            paramq = com.tencent.mm.openim.room.a.b.c.a(paramq, localbib);
            localbd.Y(paramq);
          }
        }
      }
      if (!((ArrayList)localObject).contains(r.Zn()))
      {
        ((ArrayList)localObject).add(r.Zn());
        ab.d("MicroMsg.Openim.NetSceneCreateOpenIMChatRoom", "respon has not self add one " + ((ArrayList)localObject).contains(r.Zn()));
      }
      ((com.tencent.mm.plugin.chatroom.a.b)g.E(com.tencent.mm.plugin.chatroom.a.b.class)).a(paramArrayOfByte.field_username, (ArrayList)localObject, r.Zn());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.b.c
 * JD-Core Version:    0.7.0.1
 */