package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.cab;
import com.tencent.mm.protocal.protobuf.cac;
import com.tencent.mm.protocal.protobuf.zy;
import com.tencent.mm.protocal.protobuf.zz;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends com.tencent.mm.roomsdk.a.a
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.ak.g callback;
  private final com.tencent.mm.ak.b rr;
  
  public c(LinkedList<cab> paramLinkedList)
  {
    AppMethodBeat.i(151183);
    b.a locala = new b.a();
    locala.hvt = new zy();
    locala.hvu = new zz();
    locala.uri = "/cgi-bin/micromsg-bin/createopenimchatroom";
    locala.funcId = 371;
    this.rr = locala.aAz();
    ((zy)this.rr.hvr.hvw).DQg = paramLinkedList;
    ac.i("MicroMsg.Openim.NetSceneCreateOpenIMChatRoom", "create size:%d", new Object[] { Integer.valueOf(paramLinkedList.size()) });
    AppMethodBeat.o(151183);
  }
  
  public final com.tencent.mm.roomsdk.a.b.a a(com.tencent.mm.roomsdk.a.b.a parama)
  {
    AppMethodBeat.i(151186);
    if ((parama != null) && ((parama instanceof com.tencent.mm.roomsdk.a.b.c)))
    {
      zz localzz = (zz)this.rr.hvs.hvw;
      if (localzz != null)
      {
        com.tencent.mm.openim.room.a.b.b localb = new com.tencent.mm.openim.room.a.b.b();
        localb.q(localzz.DQg);
        parama = (com.tencent.mm.roomsdk.a.b.c)parama;
        parama.chatroomName = localzz.ioe;
        parama.dni = localb.fsi.size();
        parama.dom = localb.fsi;
        parama.fsi = localb.fsi;
        parama.dop = localb.dop;
        parama.fsj = localb.fsj;
        parama.dor = localb.dor;
        parama.fsk = localb.fsk;
        parama.dos = localb.dos;
        AppMethodBeat.o(151186);
        return parama;
      }
    }
    AppMethodBeat.o(151186);
    return parama;
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
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
    ac.i("MicroMsg.Openim.NetSceneCreateOpenIMChatRoom", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (paramq.getRespObj().getRetCode() == 0)
    {
      paramq = (zz)((com.tencent.mm.ak.b)paramq).hvs.hvw;
      if (!bs.isNullOrNil(paramq.ioe))
      {
        if (paramq.ioe.toLowerCase().endsWith("@im.chatroom")) {
          break label151;
        }
        ac.e("MicroMsg.Openim.NetSceneCreateOpenIMChatRoom", "createChatroom: bad room:[" + paramq.ioe + "]");
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
      paramArrayOfByte = new ai();
      paramArrayOfByte.setUsername(paramq.ioe);
      bj localbj = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB();
      if (!localbj.aNw(paramArrayOfByte.field_username)) {
        localbj.ag(paramArrayOfByte);
      }
      if ((!bs.isNullOrNil(paramArrayOfByte.field_username)) && (!bs.isNullOrNil(paramq.Eug)))
      {
        localObject = new i();
        ((i)localObject).username = paramArrayOfByte.field_username;
        ((i)localObject).huF = paramq.Euf;
        ((i)localObject).huE = paramq.Eug;
        ((i)localObject).exK = 3;
        ((i)localObject).ez(false);
        ((i)localObject).drx = -1;
        p.aBw().b((i)localObject);
      }
      Object localObject = new ArrayList();
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
            ((ArrayList)localObject).add(paramq.field_username);
            break;
            paramq = com.tencent.mm.openim.room.a.b.c.a(paramq, localcac);
            localbj.ag(paramq);
          }
        }
      }
      if (!((ArrayList)localObject).contains(u.axw()))
      {
        ((ArrayList)localObject).add(u.axw());
        ac.d("MicroMsg.Openim.NetSceneCreateOpenIMChatRoom", "respon has not self add one " + ((ArrayList)localObject).contains(u.axw()));
      }
      ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.b.class)).a(paramArrayOfByte.field_username, (ArrayList)localObject, u.axw());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.b.c
 * JD-Core Version:    0.7.0.1
 */