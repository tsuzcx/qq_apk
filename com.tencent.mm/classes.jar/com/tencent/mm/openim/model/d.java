package com.tencent.mm.openim.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.z;
import com.tencent.mm.modelavatar.j;
import com.tencent.mm.modelavatar.k;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.openim.room.a.b.b;
import com.tencent.mm.openim.room.a.b.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.ahc;
import com.tencent.mm.protocal.protobuf.ahd;
import com.tencent.mm.protocal.protobuf.dxf;
import com.tencent.mm.protocal.protobuf.dxg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class d
  extends com.tencent.mm.roomsdk.model.a
  implements m
{
  private com.tencent.mm.am.h callback;
  private final com.tencent.mm.am.c rr;
  
  public d(LinkedList<dxf> paramLinkedList)
  {
    AppMethodBeat.i(151183);
    c.a locala = new c.a();
    locala.otE = new ahc();
    locala.otF = new ahd();
    locala.uri = "/cgi-bin/micromsg-bin/createopenimchatroom";
    locala.funcId = 371;
    this.rr = locala.bEF();
    ((ahc)c.b.b(this.rr.otB)).YFR = paramLinkedList;
    Log.i("MicroMsg.Openim.NetSceneCreateOpenIMChatRoom", "create size:%d", new Object[] { Integer.valueOf(paramLinkedList.size()) });
    AppMethodBeat.o(151183);
  }
  
  public final com.tencent.mm.roomsdk.model.b.a a(com.tencent.mm.roomsdk.model.b.a parama)
  {
    AppMethodBeat.i(151186);
    if ((parama != null) && ((parama instanceof com.tencent.mm.roomsdk.model.b.c)))
    {
      ahd localahd = (ahd)c.c.b(this.rr.otC);
      if (localahd != null)
      {
        b.b localb = new b.b();
        localb.q(localahd.YFR);
        parama = (com.tencent.mm.roomsdk.model.b.c)parama;
        parama.chatroomName = localahd.pss;
        parama.hQS = localb.lyj.size();
        parama.hSb = localb.lyj;
        parama.lyj = localb.lyj;
        parama.hSd = localb.hSd;
        parama.lyk = localb.lyk;
        parama.hSf = localb.hSf;
        parama.lyl = localb.lyl;
        parama.hSg = localb.hSg;
        AppMethodBeat.o(151186);
        return parama;
      }
    }
    AppMethodBeat.o(151186);
    return parama;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(151185);
    this.callback = paramh;
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
      params = (ahd)c.c.b(((com.tencent.mm.am.c)params).otC);
      if (!Util.isNullOrNil(params.pss))
      {
        if (params.pss.toLowerCase().endsWith("@im.chatroom")) {
          break label148;
        }
        Log.e("MicroMsg.Openim.NetSceneCreateOpenIMChatRoom", "createChatroom: bad room:[" + params.pss + "]");
      }
    }
    for (;;)
    {
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(151184);
      return;
      label148:
      paramArrayOfByte = new au();
      paramArrayOfByte.setUsername(params.pss);
      bx localbx = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA();
      if (!localbx.bxy(paramArrayOfByte.field_username)) {
        localbx.aB(paramArrayOfByte);
      }
      if ((!Util.isNullOrNil(paramArrayOfByte.field_username)) && (!Util.isNullOrNil(params.Zqg)))
      {
        localObject = new j();
        ((j)localObject).username = paramArrayOfByte.field_username;
        ((j)localObject).osN = params.Zqf;
        ((j)localObject).osM = params.Zqg;
        ((j)localObject).jZY = 3;
        ((j)localObject).gX(false);
        ((j)localObject).eQp = -1;
        q.bFE().b((j)localObject);
      }
      Object localObject = new ArrayList();
      Iterator localIterator = params.YFR.iterator();
      while (localIterator.hasNext())
      {
        dxg localdxg = (dxg)localIterator.next();
        if (localdxg.status == 0)
        {
          params = localbx.JE(localdxg.userName);
          if ((int)params.maN != 0)
          {
            params.aRJ();
            localbx.d(params.field_username, params);
          }
          for (;;)
          {
            ((ArrayList)localObject).add(params.field_username);
            break;
            params = b.c.a(params, localdxg);
            localbx.aB(params);
          }
        }
      }
      if (!((ArrayList)localObject).contains(z.bAM()))
      {
        ((ArrayList)localObject).add(z.bAM());
        Log.d("MicroMsg.Openim.NetSceneCreateOpenIMChatRoom", "respon has not self add one " + ((ArrayList)localObject).contains(z.bAM()));
      }
      ((com.tencent.mm.plugin.chatroom.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.a.class)).a(paramArrayOfByte.field_username, (ArrayList)localObject, z.bAM());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.model.d
 * JD-Core Version:    0.7.0.1
 */