package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.aby;
import com.tencent.mm.protocal.protobuf.abz;
import com.tencent.mm.protocal.protobuf.ces;
import com.tencent.mm.protocal.protobuf.cet;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends com.tencent.mm.roomsdk.a.a
  implements k
{
  private f callback;
  private final com.tencent.mm.al.b rr;
  
  public c(LinkedList<ces> paramLinkedList)
  {
    AppMethodBeat.i(151183);
    b.a locala = new b.a();
    locala.hNM = new aby();
    locala.hNN = new abz();
    locala.uri = "/cgi-bin/micromsg-bin/createopenimchatroom";
    locala.funcId = 371;
    this.rr = locala.aDC();
    ((aby)this.rr.hNK.hNQ).Fvu = paramLinkedList;
    ad.i("MicroMsg.Openim.NetSceneCreateOpenIMChatRoom", "create size:%d", new Object[] { Integer.valueOf(paramLinkedList.size()) });
    AppMethodBeat.o(151183);
  }
  
  public final com.tencent.mm.roomsdk.a.b.a a(com.tencent.mm.roomsdk.a.b.a parama)
  {
    AppMethodBeat.i(151186);
    if ((parama != null) && ((parama instanceof com.tencent.mm.roomsdk.a.b.c)))
    {
      abz localabz = (abz)this.rr.hNL.hNQ;
      if (localabz != null)
      {
        com.tencent.mm.openim.room.a.b.b localb = new com.tencent.mm.openim.room.a.b.b();
        localb.q(localabz.Fvu);
        parama = (com.tencent.mm.roomsdk.a.b.c)parama;
        parama.chatroomName = localabz.iHB;
        parama.dyW = localb.fKI.size();
        parama.dAa = localb.fKI;
        parama.fKI = localb.fKI;
        parama.dAd = localb.dAd;
        parama.fKJ = localb.fKJ;
        parama.dAf = localb.dAf;
        parama.fKK = localb.fKK;
        parama.dAg = localb.dAg;
        AppMethodBeat.o(151186);
        return parama;
      }
    }
    AppMethodBeat.o(151186);
    return parama;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(151185);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(151185);
    return i;
  }
  
  public final int getType()
  {
    return 371;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151184);
    ad.i("MicroMsg.Openim.NetSceneCreateOpenIMChatRoom", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (paramq.getRespObj().getRetCode() == 0)
    {
      paramq = (abz)((com.tencent.mm.al.b)paramq).hNL.hNQ;
      if (!bt.isNullOrNil(paramq.iHB))
      {
        if (paramq.iHB.toLowerCase().endsWith("@im.chatroom")) {
          break label151;
        }
        ad.e("MicroMsg.Openim.NetSceneCreateOpenIMChatRoom", "createChatroom: bad room:[" + paramq.iHB + "]");
      }
    }
    for (;;)
    {
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(151184);
      return;
      label151:
      paramArrayOfByte = new am();
      paramArrayOfByte.setUsername(paramq.iHB);
      bp localbp = ((l)g.ab(l.class)).azp();
      if (!localbp.aTn(paramArrayOfByte.field_username)) {
        localbp.ag(paramArrayOfByte);
      }
      if ((!bt.isNullOrNil(paramArrayOfByte.field_username)) && (!bt.isNullOrNil(paramq.Gbz)))
      {
        localObject = new i();
        ((i)localObject).username = paramArrayOfByte.field_username;
        ((i)localObject).hMX = paramq.Gby;
        ((i)localObject).hMW = paramq.Gbz;
        ((i)localObject).ePj = 3;
        ((i)localObject).eB(false);
        ((i)localObject).dDp = -1;
        p.aEx().b((i)localObject);
      }
      Object localObject = new ArrayList();
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
            ((ArrayList)localObject).add(paramq.field_username);
            break;
            paramq = com.tencent.mm.openim.room.a.b.c.a(paramq, localcet);
            localbp.ag(paramq);
          }
        }
      }
      if (!((ArrayList)localObject).contains(u.aAm()))
      {
        ((ArrayList)localObject).add(u.aAm());
        ad.d("MicroMsg.Openim.NetSceneCreateOpenIMChatRoom", "respon has not self add one " + ((ArrayList)localObject).contains(u.aAm()));
      }
      ((com.tencent.mm.plugin.chatroom.a.b)g.ab(com.tencent.mm.plugin.chatroom.a.b.class)).a(paramArrayOfByte.field_username, (ArrayList)localObject, u.aAm());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.b.c
 * JD-Core Version:    0.7.0.1
 */