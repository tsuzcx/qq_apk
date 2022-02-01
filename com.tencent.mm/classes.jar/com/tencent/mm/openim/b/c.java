package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.ach;
import com.tencent.mm.protocal.protobuf.aci;
import com.tencent.mm.protocal.protobuf.cfm;
import com.tencent.mm.protocal.protobuf.cfn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends com.tencent.mm.roomsdk.a.a
  implements k
{
  private f callback;
  private final com.tencent.mm.ak.b rr;
  
  public c(LinkedList<cfm> paramLinkedList)
  {
    AppMethodBeat.i(151183);
    b.a locala = new b.a();
    locala.hQF = new ach();
    locala.hQG = new aci();
    locala.uri = "/cgi-bin/micromsg-bin/createopenimchatroom";
    locala.funcId = 371;
    this.rr = locala.aDS();
    ((ach)this.rr.hQD.hQJ).FNS = paramLinkedList;
    ae.i("MicroMsg.Openim.NetSceneCreateOpenIMChatRoom", "create size:%d", new Object[] { Integer.valueOf(paramLinkedList.size()) });
    AppMethodBeat.o(151183);
  }
  
  public final com.tencent.mm.roomsdk.a.b.a a(com.tencent.mm.roomsdk.a.b.a parama)
  {
    AppMethodBeat.i(151186);
    if ((parama != null) && ((parama instanceof com.tencent.mm.roomsdk.a.b.c)))
    {
      aci localaci = (aci)this.rr.hQE.hQJ;
      if (localaci != null)
      {
        com.tencent.mm.openim.room.a.b.b localb = new com.tencent.mm.openim.room.a.b.b();
        localb.q(localaci.FNS);
        parama = (com.tencent.mm.roomsdk.a.b.c)parama;
        parama.chatroomName = localaci.iKu;
        parama.dAb = localb.fML.size();
        parama.dBf = localb.fML;
        parama.fML = localb.fML;
        parama.dBi = localb.dBi;
        parama.fMM = localb.fMM;
        parama.dBk = localb.dBk;
        parama.fMN = localb.fMN;
        parama.dBl = localb.dBl;
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
    ae.i("MicroMsg.Openim.NetSceneCreateOpenIMChatRoom", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (paramq.getRespObj().getRetCode() == 0)
    {
      paramq = (aci)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
      if (!bu.isNullOrNil(paramq.iKu))
      {
        if (paramq.iKu.toLowerCase().endsWith("@im.chatroom")) {
          break label151;
        }
        ae.e("MicroMsg.Openim.NetSceneCreateOpenIMChatRoom", "createChatroom: bad room:[" + paramq.iKu + "]");
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
      paramArrayOfByte = new an();
      paramArrayOfByte.setUsername(paramq.iKu);
      bq localbq = ((l)g.ab(l.class)).azF();
      if (!localbq.aUO(paramArrayOfByte.field_username)) {
        localbq.an(paramArrayOfByte);
      }
      if ((!bu.isNullOrNil(paramArrayOfByte.field_username)) && (!bu.isNullOrNil(paramq.Gug)))
      {
        localObject = new i();
        ((i)localObject).username = paramArrayOfByte.field_username;
        ((i)localObject).hPQ = paramq.Guf;
        ((i)localObject).hPP = paramq.Gug;
        ((i)localObject).eQU = 3;
        ((i)localObject).eD(false);
        ((i)localObject).dEu = -1;
        p.aEN().b((i)localObject);
      }
      Object localObject = new ArrayList();
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
            ((ArrayList)localObject).add(paramq.field_username);
            break;
            paramq = com.tencent.mm.openim.room.a.b.c.a(paramq, localcfn);
            localbq.an(paramq);
          }
        }
      }
      if (!((ArrayList)localObject).contains(v.aAC()))
      {
        ((ArrayList)localObject).add(v.aAC());
        ae.d("MicroMsg.Openim.NetSceneCreateOpenIMChatRoom", "respon has not self add one " + ((ArrayList)localObject).contains(v.aAC()));
      }
      ((com.tencent.mm.plugin.chatroom.a.b)g.ab(com.tencent.mm.plugin.chatroom.a.b.class)).a(paramArrayOfByte.field_username, (ArrayList)localObject, v.aAC());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.b.c
 * JD-Core Version:    0.7.0.1
 */