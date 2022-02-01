package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.live.b.c;
import com.tencent.mm.live.b.g;
import com.tencent.mm.live.b.i;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bdx;
import com.tencent.mm.protocal.protobuf.bdy;
import com.tencent.mm.protocal.protobuf.bvi;
import com.tencent.mm.protocal.protobuf.bvj;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveGetLiveMessage;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "offline", "", "(JLjava/lang/String;Z)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "duration", "getDuration", "()J", "setDuration", "(J)V", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/GetLiveMessageRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/GetLiveMessageResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class m
  extends n
  implements k
{
  public static final a gSM;
  private f callback;
  public long duration;
  private com.tencent.mm.ak.b gRX;
  private final bdx gSK;
  private bdy gSL;
  
  static
  {
    AppMethodBeat.i(215836);
    gSM = new a((byte)0);
    AppMethodBeat.o(215836);
  }
  
  public m(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(215835);
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new bdx());
    ((b.a)localObject).d((a)new bdy());
    ((b.a)localObject).oS(3767);
    ((b.a)localObject).DN("/cgi-bin/micromsg-bin/getlivemessage");
    ((b.a)localObject).oU(0);
    ((b.a)localObject).oV(0);
    ((b.a)localObject).aEW();
    ((b.a)localObject).aEX();
    localObject = ((b.a)localObject).aDS();
    p.g(localObject, "builder.buildInstance()");
    this.gRX = ((com.tencent.mm.ak.b)localObject);
    localObject = this.gRX.aEU();
    if (localObject == null)
    {
      paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveMessageRequest");
      AppMethodBeat.o(215835);
      throw paramString;
    }
    this.gSK = ((bdx)localObject);
    this.gSK.FKy = paramLong;
    this.gSK.FKz = paramString;
    localObject = this.gSK;
    g localg = g.gQZ;
    ((bdx)localObject).GTs = com.tencent.mm.bw.b.cm(g.anG());
    this.gSK.GTt = paramBoolean;
    ae.i("MicroMsg.LiveNetScene.NetSceneLiveGetLiveMessage", "get live message:" + paramLong + " wechatRoomId:" + paramString + " offline:" + paramBoolean);
    AppMethodBeat.o(215835);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(215833);
    this.duration = System.currentTimeMillis();
    this.callback = paramf;
    int i = dispatch(parame, (q)this.gRX, (k)this);
    AppMethodBeat.o(215833);
    return i;
  }
  
  public final int getType()
  {
    return 3767;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    paramArrayOfByte = null;
    AppMethodBeat.i(215834);
    p.h(paramq, "rr");
    ae.i("MicroMsg.LiveNetScene.NetSceneLiveGetLiveMessage", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.duration = (System.currentTimeMillis() - this.duration);
    Object localObject1 = com.tencent.mm.live.b.e.gPA;
    if (com.tencent.mm.live.b.e.cV(paramInt2, paramInt3))
    {
      i.a(i.gRP);
      paramq = this.callback;
      if (paramq != null)
      {
        paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
        AppMethodBeat.o(215834);
        return;
      }
      AppMethodBeat.o(215834);
      return;
    }
    paramq = ((com.tencent.mm.ak.b)paramq).aEV();
    if (paramq == null)
    {
      paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveMessageResponse");
      AppMethodBeat.o(215834);
      throw paramString;
    }
    this.gSL = ((bdy)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ae.e("MicroMsg.LiveNetScene.NetSceneLiveGetLiveMessage", "onGYNetEnd error");
      switch (paramInt3)
      {
      }
    }
    for (;;)
    {
      paramq = this.callback;
      if (paramq != null)
      {
        paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
        AppMethodBeat.o(215834);
        return;
        paramq = c.gPx;
        c.ane();
        continue;
        localObject1 = this.gSL;
        if (localObject1 == null) {
          continue;
        }
        Object localObject2;
        if (((bdy)localObject1).GTy)
        {
          paramq = g.gQZ;
          if (g.anH().GTv != ((bdy)localObject1).GTv)
          {
            paramq = c.gPx;
            c.anf();
          }
          paramq = g.gQZ;
          g.anH().GTv = ((bdy)localObject1).GTv;
          paramq = g.gQZ;
          paramq = g.anH();
          localObject2 = g.gQZ;
          paramq.GTx = Math.max(g.anH().GTx, ((bdy)localObject1).GTx);
          paramq = g.gQZ;
          g.anD().clear();
          paramq = g.gQZ;
          localObject2 = g.anD();
          paramq = ((bdy)localObject1).GTw;
          if (paramq == null) {
            break label700;
          }
          paramq = (Collection)paramq;
          label367:
          ((ArrayList)localObject2).addAll(paramq);
          paramq = g.gQZ;
          g.a(new bvi());
          paramq = g.gQZ;
          localObject2 = (a)g.anN();
          paramq = ((bdy)localObject1).GTz;
          if (paramq == null) {
            break label715;
          }
          paramq = paramq.Hid;
          if (paramq == null) {
            break label715;
          }
          paramq = paramq.getBytes();
        }
        try
        {
          for (;;)
          {
            ((a)localObject2).parseFrom(paramq);
            paramq = com.tencent.mm.live.b.d.b.gTR;
            paramq = g.gQZ;
            localObject2 = g.anF();
            paramq = ((bdy)localObject1).GTu;
            if (paramq == null) {
              break label744;
            }
            paramq = (List)paramq;
            Object localObject3 = com.tencent.mm.model.v.aAC();
            p.g(localObject3, "ConfigStorageLogic.getUsernameFromUserInfo()");
            com.tencent.mm.live.b.d.b.a((ArrayList)localObject2, paramq, (String)localObject3);
            paramq = c.gPx;
            c.and();
            paramq = g.gQZ;
            paramq = ((bdy)localObject1).GTs;
            p.g(paramq, "it.live_cookies");
            g.P(paramq.getBytes());
            paramq = new StringBuilder("onlineCount:");
            localObject2 = g.gQZ;
            paramq = paramq.append(g.anH().GTv).append(" headerList:");
            localObject2 = g.gQZ;
            localObject2 = paramq.append(g.anD().size()).append(" remoteMsgSize:");
            localObject3 = ((bdy)localObject1).GTu;
            paramq = paramArrayOfByte;
            if (localObject3 != null) {
              paramq = Integer.valueOf(((LinkedList)localObject3).size());
            }
            paramq = ((StringBuilder)localObject2).append(paramq).append(", msgSize:");
            paramArrayOfByte = g.gQZ;
            paramq = paramq.append(g.anF().size()).append(" likeCount:");
            paramArrayOfByte = g.gQZ;
            ae.i("MicroMsg.LiveNetScene.NetSceneLiveGetLiveMessage", g.anH().GTx + ", needUpdate:" + ((bdy)localObject1).GTy);
            break;
            label700:
            paramq = (Collection)new ArrayList();
            break label367;
            label715:
            paramq = null;
          }
        }
        catch (Exception paramq)
        {
          for (;;)
          {
            ae.l("safeParser", "", new Object[] { paramq });
            continue;
            label744:
            paramq = (List)new ArrayList();
          }
        }
      }
    }
    AppMethodBeat.o(215834);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveGetLiveMessage$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.m
 * JD-Core Version:    0.7.0.1
 */