package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.j;
import com.tencent.mm.am.k;
import com.tencent.mm.am.q;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.openim.room.a.b.b;
import com.tencent.mm.openim.room.a.b.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.aeq;
import com.tencent.mm.protocal.protobuf.aer;
import com.tencent.mm.protocal.protobuf.dfd;
import com.tencent.mm.protocal.protobuf.dfe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends com.tencent.mm.roomsdk.a.a
  implements m
{
  private i callback;
  private final com.tencent.mm.an.d rr;
  
  public c(LinkedList<dfd> paramLinkedList)
  {
    AppMethodBeat.i(151183);
    d.a locala = new d.a();
    locala.lBU = new aeq();
    locala.lBV = new aer();
    locala.uri = "/cgi-bin/micromsg-bin/createopenimchatroom";
    locala.funcId = 371;
    this.rr = locala.bgN();
    ((aeq)d.b.b(this.rr.lBR)).RIQ = paramLinkedList;
    Log.i("MicroMsg.Openim.NetSceneCreateOpenIMChatRoom", "create size:%d", new Object[] { Integer.valueOf(paramLinkedList.size()) });
    AppMethodBeat.o(151183);
  }
  
  public final com.tencent.mm.roomsdk.a.b.a a(com.tencent.mm.roomsdk.a.b.a parama)
  {
    AppMethodBeat.i(151186);
    if ((parama != null) && ((parama instanceof com.tencent.mm.roomsdk.a.b.c)))
    {
      aer localaer = (aer)d.c.b(this.rr.lBS);
      if (localaer != null)
      {
        b.b localb = new b.b();
        localb.q(localaer.RIQ);
        parama = (com.tencent.mm.roomsdk.a.b.c)parama;
        parama.chatroomName = localaer.mye;
        parama.fLk = localb.iWi.size();
        parama.fMr = localb.iWi;
        parama.iWi = localb.iWi;
        parama.fMt = localb.fMt;
        parama.iWj = localb.iWj;
        parama.fMv = localb.fMv;
        parama.iWk = localb.iWk;
        parama.fMw = localb.fMw;
        AppMethodBeat.o(151186);
        return parama;
      }
    }
    AppMethodBeat.o(151186);
    return parama;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(151185);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(151185);
    return i;
  }
  
  public final int getType()
  {
    return 371;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151184);
    Log.i("MicroMsg.Openim.NetSceneCreateOpenIMChatRoom", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (params.getRespObj().getRetCode() == 0)
    {
      params = (aer)d.c.b(((com.tencent.mm.an.d)params).lBS);
      if (!Util.isNullOrNil(params.mye))
      {
        if (params.mye.toLowerCase().endsWith("@im.chatroom")) {
          break label151;
        }
        Log.e("MicroMsg.Openim.NetSceneCreateOpenIMChatRoom", "createChatroom: bad room:[" + params.mye + "]");
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
      paramArrayOfByte = new as();
      paramArrayOfByte.setUsername(params.mye);
      bv localbv = ((n)h.ae(n.class)).bbL();
      if (!localbv.bwl(paramArrayOfByte.field_username)) {
        localbv.av(paramArrayOfByte);
      }
      if ((!Util.isNullOrNil(paramArrayOfByte.field_username)) && (!Util.isNullOrNil(params.Sre)))
      {
        localObject = new j();
        ((j)localObject).username = paramArrayOfByte.field_username;
        ((j)localObject).lBe = params.Srd;
        ((j)localObject).lBd = params.Sre;
        ((j)localObject).hDc = 3;
        ((j)localObject).gg(false);
        ((j)localObject).cUP = -1;
        q.bhP().b((j)localObject);
      }
      Object localObject = new ArrayList();
      Iterator localIterator = params.RIQ.iterator();
      while (localIterator.hasNext())
      {
        dfe localdfe = (dfe)localIterator.next();
        if (localdfe.status == 0)
        {
          params = localbv.RG(localdfe.userName);
          if ((int)params.jxt != 0)
          {
            params.axj();
            localbv.c(params.field_username, params);
          }
          for (;;)
          {
            ((ArrayList)localObject).add(params.field_username);
            break;
            params = b.c.a(params, localdfe);
            localbv.av(params);
          }
        }
      }
      if (!((ArrayList)localObject).contains(z.bcZ()))
      {
        ((ArrayList)localObject).add(z.bcZ());
        Log.d("MicroMsg.Openim.NetSceneCreateOpenIMChatRoom", "respon has not self add one " + ((ArrayList)localObject).contains(z.bcZ()));
      }
      ((com.tencent.mm.plugin.chatroom.a.a)h.ae(com.tencent.mm.plugin.chatroom.a.a.class)).a(paramArrayOfByte.field_username, (ArrayList)localObject, z.bcZ());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.b.c
 * JD-Core Version:    0.7.0.1
 */