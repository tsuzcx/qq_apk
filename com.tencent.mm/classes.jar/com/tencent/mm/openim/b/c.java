package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.al.b.a;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.bvj;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.protocal.protobuf.zb;
import com.tencent.mm.protocal.protobuf.zc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends com.tencent.mm.roomsdk.a.a
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.al.g callback;
  private final com.tencent.mm.al.b rr;
  
  public c(LinkedList<bvj> paramLinkedList)
  {
    AppMethodBeat.i(151183);
    b.a locala = new b.a();
    locala.gUU = new zb();
    locala.gUV = new zc();
    locala.uri = "/cgi-bin/micromsg-bin/createopenimchatroom";
    locala.funcId = 371;
    this.rr = locala.atI();
    ((zb)this.rr.gUS.gUX).CxK = paramLinkedList;
    ad.i("MicroMsg.Openim.NetSceneCreateOpenIMChatRoom", "create size:%d", new Object[] { Integer.valueOf(paramLinkedList.size()) });
    AppMethodBeat.o(151183);
  }
  
  public final com.tencent.mm.roomsdk.a.b.a a(com.tencent.mm.roomsdk.a.b.a parama)
  {
    AppMethodBeat.i(151186);
    if ((parama != null) && ((parama instanceof com.tencent.mm.roomsdk.a.b.c)))
    {
      zc localzc = (zc)this.rr.gUT.gUX;
      if (localzc != null)
      {
        com.tencent.mm.openim.room.a.b.b localb = new com.tencent.mm.openim.room.a.b.b();
        localb.q(localzc.CxK);
        parama = (com.tencent.mm.roomsdk.a.b.c)parama;
        parama.chatroomName = localzc.hNI;
        parama.dpx = localb.foI.size();
        parama.dqB = localb.foI;
        parama.foI = localb.foI;
        parama.dqE = localb.dqE;
        parama.foJ = localb.foJ;
        parama.dqG = localb.dqG;
        parama.foK = localb.foK;
        parama.dqH = localb.dqH;
        AppMethodBeat.o(151186);
        return parama;
      }
    }
    AppMethodBeat.o(151186);
    return parama;
  }
  
  public final int doScene(e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(151185);
    this.callback = paramg;
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
      paramq = (zc)((com.tencent.mm.al.b)paramq).gUT.gUX;
      if (!bt.isNullOrNil(paramq.hNI))
      {
        if (paramq.hNI.toLowerCase().endsWith("@im.chatroom")) {
          break label151;
        }
        ad.e("MicroMsg.Openim.NetSceneCreateOpenIMChatRoom", "createChatroom: bad room:[" + paramq.hNI + "]");
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
      paramArrayOfByte = new af();
      paramArrayOfByte.setUsername(paramq.hNI);
      bg localbg = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM();
      if (!localbg.aIb(paramArrayOfByte.field_username)) {
        localbg.af(paramArrayOfByte);
      }
      if ((!bt.isNullOrNil(paramArrayOfByte.field_username)) && (!bt.isNullOrNil(paramq.Dbh)))
      {
        localObject = new i();
        ((i)localObject).username = paramArrayOfByte.field_username;
        ((i)localObject).gUg = paramq.Dbg;
        ((i)localObject).gUf = paramq.Dbh;
        ((i)localObject).evo = 3;
        ((i)localObject).ee(false);
        ((i)localObject).dtM = -1;
        p.auF().b((i)localObject);
      }
      Object localObject = new ArrayList();
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
            ((ArrayList)localObject).add(paramq.field_username);
            break;
            paramq = com.tencent.mm.openim.room.a.b.c.a(paramq, localbvk);
            localbg.af(paramq);
          }
        }
      }
      if (!((ArrayList)localObject).contains(u.aqG()))
      {
        ((ArrayList)localObject).add(u.aqG());
        ad.d("MicroMsg.Openim.NetSceneCreateOpenIMChatRoom", "respon has not self add one " + ((ArrayList)localObject).contains(u.aqG()));
      }
      ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.b.class)).a(paramArrayOfByte.field_username, (ArrayList)localObject, u.aqG());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.b.c
 * JD-Core Version:    0.7.0.1
 */