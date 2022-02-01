package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.openim.room.a.b.b;
import com.tencent.mm.openim.room.a.b.c;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.aej;
import com.tencent.mm.protocal.protobuf.aek;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.protocal.protobuf.cvu;
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
  private com.tencent.mm.ak.i callback;
  private final d rr;
  
  public c(LinkedList<cvt> paramLinkedList)
  {
    AppMethodBeat.i(151183);
    d.a locala = new d.a();
    locala.iLN = new aej();
    locala.iLO = new aek();
    locala.uri = "/cgi-bin/micromsg-bin/createopenimchatroom";
    locala.funcId = 371;
    this.rr = locala.aXF();
    ((aej)this.rr.iLK.iLR).KHx = paramLinkedList;
    Log.i("MicroMsg.Openim.NetSceneCreateOpenIMChatRoom", "create size:%d", new Object[] { Integer.valueOf(paramLinkedList.size()) });
    AppMethodBeat.o(151183);
  }
  
  public final com.tencent.mm.roomsdk.a.b.a a(com.tencent.mm.roomsdk.a.b.a parama)
  {
    AppMethodBeat.i(151186);
    if ((parama != null) && ((parama instanceof com.tencent.mm.roomsdk.a.b.c)))
    {
      aek localaek = (aek)this.rr.iLL.iLR;
      if (localaek != null)
      {
        b.b localb = new b.b();
        localb.q(localaek.KHx);
        parama = (com.tencent.mm.roomsdk.a.b.c)parama;
        parama.chatroomName = localaek.jHa;
        parama.dRN = localb.grX.size();
        parama.dSU = localb.grX;
        parama.grX = localb.grX;
        parama.dSX = localb.dSX;
        parama.grY = localb.grY;
        parama.dSZ = localb.dSZ;
        parama.grZ = localb.grZ;
        parama.dTa = localb.dTa;
        AppMethodBeat.o(151186);
        return parama;
      }
    }
    AppMethodBeat.o(151186);
    return parama;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.ak.i parami)
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
      params = (aek)((d)params).iLL.iLR;
      if (!Util.isNullOrNil(params.jHa))
      {
        if (params.jHa.toLowerCase().endsWith("@im.chatroom")) {
          break label151;
        }
        Log.e("MicroMsg.Openim.NetSceneCreateOpenIMChatRoom", "createChatroom: bad room:[" + params.jHa + "]");
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
      paramArrayOfByte.setUsername(params.jHa);
      bv localbv = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN();
      if (!localbv.bjN(paramArrayOfByte.field_username)) {
        localbv.ap(paramArrayOfByte);
      }
      if ((!Util.isNullOrNil(paramArrayOfByte.field_username)) && (!Util.isNullOrNil(params.LpI)))
      {
        localObject = new com.tencent.mm.aj.i();
        ((com.tencent.mm.aj.i)localObject).username = paramArrayOfByte.field_username;
        ((com.tencent.mm.aj.i)localObject).iKX = params.LpH;
        ((com.tencent.mm.aj.i)localObject).iKW = params.LpI;
        ((com.tencent.mm.aj.i)localObject).fuz = 3;
        ((com.tencent.mm.aj.i)localObject).fv(false);
        ((com.tencent.mm.aj.i)localObject).cSx = -1;
        p.aYB().b((com.tencent.mm.aj.i)localObject);
      }
      Object localObject = new ArrayList();
      Iterator localIterator = params.KHx.iterator();
      while (localIterator.hasNext())
      {
        cvu localcvu = (cvu)localIterator.next();
        if (localcvu.status == 0)
        {
          params = localbv.Kn(localcvu.userName);
          if ((int)params.gMZ != 0)
          {
            params.aqP();
            localbv.c(params.field_username, params);
          }
          for (;;)
          {
            ((ArrayList)localObject).add(params.field_username);
            break;
            params = b.c.a(params, localcvu);
            localbv.ap(params);
          }
        }
      }
      if (!((ArrayList)localObject).contains(z.aTY()))
      {
        ((ArrayList)localObject).add(z.aTY());
        Log.d("MicroMsg.Openim.NetSceneCreateOpenIMChatRoom", "respon has not self add one " + ((ArrayList)localObject).contains(z.aTY()));
      }
      ((b)com.tencent.mm.kernel.g.af(b.class)).a(paramArrayOfByte.field_username, (ArrayList)localObject, z.aTY());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.b.c
 * JD-Core Version:    0.7.0.1
 */