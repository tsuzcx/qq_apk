package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.live.b.c;
import com.tencent.mm.live.b.i;
import com.tencent.mm.model.u;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.azd;
import com.tencent.mm.protocal.protobuf.aze;
import com.tencent.mm.protocal.protobuf.bqb;
import com.tencent.mm.protocal.protobuf.bqc;
import com.tencent.mm.protocal.protobuf.bqd;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveGetLiveMessage;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "offline", "", "(JLjava/lang/String;Z)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "duration", "getDuration", "()J", "setDuration", "(J)V", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/GetLiveMessageRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/GetLiveMessageResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class m
  extends n
  implements com.tencent.mm.network.k
{
  public static final m.a gwt;
  private com.tencent.mm.ak.g callback;
  public long duration;
  private com.tencent.mm.ak.b gvE;
  private final azd gwr;
  private aze gws;
  
  static
  {
    AppMethodBeat.i(189930);
    gwt = new m.a((byte)0);
    AppMethodBeat.o(189930);
  }
  
  public m(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(189929);
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new azd());
    ((b.a)localObject).d((a)new aze());
    ((b.a)localObject).op(3767);
    ((b.a)localObject).Am("/cgi-bin/micromsg-bin/getlivemessage");
    ((b.a)localObject).or(0);
    ((b.a)localObject).os(0);
    ((b.a)localObject).aBE();
    ((b.a)localObject).aBF();
    localObject = ((b.a)localObject).aAz();
    d.g.b.k.g(localObject, "builder.buildInstance()");
    this.gvE = ((com.tencent.mm.ak.b)localObject);
    localObject = this.gvE.aBC();
    if (localObject == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveMessageRequest");
      AppMethodBeat.o(189929);
      throw paramString;
    }
    this.gwr = ((azd)localObject);
    this.gwr.DMV = paramLong;
    this.gwr.DMW = paramString;
    localObject = this.gwr;
    com.tencent.mm.live.b.g localg = com.tencent.mm.live.b.g.guG;
    ((azd)localObject).EQB = com.tencent.mm.bw.b.cc(com.tencent.mm.live.b.g.akE());
    this.gwr.EQC = paramBoolean;
    ac.i("MicroMsg.LiveNetScene.NetSceneLiveGetLiveMessage", "get live message:" + paramLong + " wechatRoomId:" + paramString + " offline:" + paramBoolean);
    AppMethodBeat.o(189929);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(189927);
    this.duration = System.currentTimeMillis();
    this.callback = paramg;
    int i = dispatch(parame, (q)this.gvE, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(189927);
    return i;
  }
  
  public final int getType()
  {
    return 3767;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    paramArrayOfByte = null;
    AppMethodBeat.i(189928);
    d.g.b.k.h(paramq, "rr");
    ac.i("MicroMsg.LiveNetScene.NetSceneLiveGetLiveMessage", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.duration = (System.currentTimeMillis() - this.duration);
    Object localObject1 = com.tencent.mm.live.b.e.gtg;
    if (com.tencent.mm.live.b.e.cT(paramInt2, paramInt3))
    {
      i.a(i.gvw);
      paramq = this.callback;
      if (paramq != null)
      {
        paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
        AppMethodBeat.o(189928);
        return;
      }
      AppMethodBeat.o(189928);
      return;
    }
    paramq = ((com.tencent.mm.ak.b)paramq).aBD();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveMessageResponse");
      AppMethodBeat.o(189928);
      throw paramString;
    }
    this.gws = ((aze)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ac.e("MicroMsg.LiveNetScene.NetSceneLiveGetLiveMessage", "onGYNetEnd error");
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
        AppMethodBeat.o(189928);
        return;
        paramq = c.gtd;
        c.akd();
        continue;
        localObject1 = this.gws;
        if (localObject1 == null) {
          continue;
        }
        Object localObject2;
        if (((aze)localObject1).EQH)
        {
          paramq = com.tencent.mm.live.b.g.guG;
          if (com.tencent.mm.live.b.g.akF().EQE != ((aze)localObject1).EQE)
          {
            paramq = c.gtd;
            c.ake();
          }
          paramq = com.tencent.mm.live.b.g.guG;
          com.tencent.mm.live.b.g.akF().EQE = ((aze)localObject1).EQE;
          paramq = com.tencent.mm.live.b.g.guG;
          paramq = com.tencent.mm.live.b.g.akF();
          localObject2 = com.tencent.mm.live.b.g.guG;
          paramq.EQG = Math.max(com.tencent.mm.live.b.g.akF().EQG, ((aze)localObject1).EQG);
          paramq = com.tencent.mm.live.b.g.guG;
          com.tencent.mm.live.b.g.akB().clear();
          paramq = com.tencent.mm.live.b.g.guG;
          localObject2 = com.tencent.mm.live.b.g.akB();
          paramq = ((aze)localObject1).EQF;
          if (paramq == null) {
            break label700;
          }
          paramq = (Collection)paramq;
          label367:
          ((ArrayList)localObject2).addAll(paramq);
          paramq = com.tencent.mm.live.b.g.guG;
          com.tencent.mm.live.b.g.a(new bqb());
          paramq = com.tencent.mm.live.b.g.guG;
          localObject2 = (a)com.tencent.mm.live.b.g.akL();
          paramq = ((aze)localObject1).EQI;
          if (paramq == null) {
            break label715;
          }
          paramq = paramq.FeZ;
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
            paramq = com.tencent.mm.live.b.d.b.gxy;
            paramq = com.tencent.mm.live.b.g.guG;
            localObject2 = com.tencent.mm.live.b.g.akD();
            paramq = ((aze)localObject1).EQD;
            if (paramq == null) {
              break label744;
            }
            paramq = (List)paramq;
            Object localObject3 = u.axw();
            d.g.b.k.g(localObject3, "ConfigStorageLogic.getUsernameFromUserInfo()");
            com.tencent.mm.live.b.d.b.a((ArrayList)localObject2, paramq, (String)localObject3);
            paramq = c.gtd;
            c.akc();
            paramq = com.tencent.mm.live.b.g.guG;
            paramq = ((aze)localObject1).EQB;
            d.g.b.k.g(paramq, "it.live_cookies");
            com.tencent.mm.live.b.g.Q(paramq.getBytes());
            paramq = new StringBuilder("onlineCount:");
            localObject2 = com.tencent.mm.live.b.g.guG;
            paramq = paramq.append(com.tencent.mm.live.b.g.akF().EQE).append(" headerList:");
            localObject2 = com.tencent.mm.live.b.g.guG;
            localObject2 = paramq.append(com.tencent.mm.live.b.g.akB().size()).append(" remoteMsgSize:");
            localObject3 = ((aze)localObject1).EQD;
            paramq = paramArrayOfByte;
            if (localObject3 != null) {
              paramq = Integer.valueOf(((LinkedList)localObject3).size());
            }
            paramq = ((StringBuilder)localObject2).append(paramq).append(", msgSize:");
            paramArrayOfByte = com.tencent.mm.live.b.g.guG;
            paramq = paramq.append(com.tencent.mm.live.b.g.akD().size()).append(" likeCount:");
            paramArrayOfByte = com.tencent.mm.live.b.g.guG;
            ac.i("MicroMsg.LiveNetScene.NetSceneLiveGetLiveMessage", com.tencent.mm.live.b.g.akF().EQG + ", needUpdate:" + ((aze)localObject1).EQH);
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
            ac.l("safeParser", "", new Object[] { paramq });
            continue;
            label744:
            paramq = (List)new ArrayList();
          }
        }
      }
    }
    AppMethodBeat.o(189928);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.b.a.m
 * JD-Core Version:    0.7.0.1
 */