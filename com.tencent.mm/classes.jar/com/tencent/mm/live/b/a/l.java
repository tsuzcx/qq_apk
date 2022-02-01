package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.live.b.c;
import com.tencent.mm.live.b.d;
import com.tencent.mm.live.b.f;
import com.tencent.mm.live.b.h;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.eac;
import com.tencent.mm.protocal.protobuf.ead;
import com.tencent.mm.protocal.protobuf.eaq;
import com.tencent.mm.protocal.protobuf.ear;
import com.tencent.mm.protocal.protobuf.eas;
import com.tencent.mm.sdk.platformtools.ad;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveGetLiveMessage;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "offline", "", "(JLjava/lang/String;Z)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "duration", "getDuration", "()J", "setDuration", "(J)V", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/GetLiveMessageRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/GetLiveMessageResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class l
  extends n
  implements com.tencent.mm.network.k
{
  public static final a zbX;
  private g callback;
  public long duration;
  private com.tencent.mm.al.b iaa;
  private final eac zbQ;
  private ead zbU;
  
  static
  {
    AppMethodBeat.i(202735);
    zbX = new a((byte)0);
    AppMethodBeat.o(202735);
  }
  
  public l(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(202734);
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new eac());
    ((b.a)localObject).d((a)new ead());
    ((b.a)localObject).nB(3767);
    ((b.a)localObject).wg("/cgi-bin/micromsg-bin/getlivemessage");
    ((b.a)localObject).nD(0);
    ((b.a)localObject).nE(0);
    ((b.a)localObject).fQK();
    ((b.a)localObject).fQL();
    localObject = ((b.a)localObject).atI();
    d.g.b.k.g(localObject, "builder.buildInstance()");
    this.iaa = ((com.tencent.mm.al.b)localObject);
    localObject = this.iaa.auL();
    if (localObject == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveMessageRequest");
      AppMethodBeat.o(202734);
      throw paramString;
    }
    this.zbQ = ((eac)localObject);
    this.zbQ.LwA = paramLong;
    this.zbQ.EEF = paramString;
    localObject = this.zbQ;
    f localf = f.rGw;
    ((eac)localObject).LyM = com.tencent.mm.bx.b.cd(f.eNF());
    this.zbQ.LyN = paramBoolean;
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveGetLiveMessage", "get live message:" + paramLong + " wechatRoomId:" + paramString + " offline:" + paramBoolean);
    AppMethodBeat.o(202734);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(202732);
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveGetLiveMessage", "doScene");
    this.duration = System.currentTimeMillis();
    this.callback = paramg;
    int i = dispatch(parame, (q)this.iaa, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(202732);
    return i;
  }
  
  public final int getType()
  {
    return 3767;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    paramArrayOfByte = null;
    AppMethodBeat.i(202733);
    d.g.b.k.h(paramq, "rr");
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveGetLiveMessage", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.duration = (System.currentTimeMillis() - this.duration);
    Object localObject1 = d.qYj;
    if (d.eq(paramInt2, paramInt3))
    {
      h.a(h.xfu);
      paramq = this.callback;
      if (paramq != null)
      {
        paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
        AppMethodBeat.o(202733);
        return;
      }
      AppMethodBeat.o(202733);
      return;
    }
    paramq = ((com.tencent.mm.al.b)paramq).auM();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveMessageResponse");
      AppMethodBeat.o(202733);
      throw paramString;
    }
    this.zbU = ((ead)paramq);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ad.e("MicroMsg.LiveNetScene.NetSceneLiveGetLiveMessage", "onGYNetEnd error");
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
        AppMethodBeat.o(202733);
        return;
        paramq = c.qYi;
        c.dRk();
        continue;
        localObject1 = this.zbU;
        if (localObject1 == null) {
          continue;
        }
        Object localObject2;
        if (((ead)localObject1).DZy)
        {
          paramq = f.rGw;
          f.eNG().LyP = ((ead)localObject1).LyP;
          paramq = f.rGw;
          f.agy(((ead)localObject1).LyP);
          paramq = f.rGw;
          paramq = f.eNG();
          localObject2 = f.rGw;
          paramq.LyR = Math.max(f.eNG().LyR, ((ead)localObject1).LyR);
          paramq = f.rGw;
          f.eNC().clear();
          paramq = f.rGw;
          localObject2 = f.eNC();
          paramq = ((ead)localObject1).LyQ;
          if (paramq == null) {
            break label686;
          }
          paramq = (Collection)paramq;
          label353:
          ((ArrayList)localObject2).addAll(paramq);
          paramq = f.rGw;
          f.a(new eaq());
          paramq = f.rGw;
          localObject2 = (a)f.eNM();
          paramq = ((ead)localObject1).LyS;
          if (paramq == null) {
            break label701;
          }
          paramq = paramq.LyZ;
          if (paramq == null) {
            break label701;
          }
          paramq = paramq.getBytes();
        }
        try
        {
          for (;;)
          {
            ((a)localObject2).parseFrom(paramq);
            paramq = com.tencent.mm.live.b.d.b.FwG;
            paramq = f.rGw;
            localObject2 = f.eNE();
            paramq = ((ead)localObject1).LyO;
            if (paramq == null) {
              break label730;
            }
            paramq = (List)paramq;
            Object localObject3 = u.aqG();
            d.g.b.k.g(localObject3, "ConfigStorageLogic.getUsernameFromUserInfo()");
            com.tencent.mm.live.b.d.b.a((ArrayList)localObject2, paramq, (String)localObject3);
            paramq = c.qYi;
            c.dRj();
            paramq = f.rGw;
            paramq = ((ead)localObject1).LyM;
            d.g.b.k.g(paramq, "it.live_cookies");
            f.jdMethod_do(paramq.getBytes());
            paramq = new StringBuilder("onlineCount:");
            localObject2 = f.rGw;
            paramq = paramq.append(f.eNG().LyP).append(" headerList:");
            localObject2 = f.rGw;
            localObject2 = paramq.append(f.eNC().size()).append(" remoteMsgSize:");
            localObject3 = ((ead)localObject1).LyO;
            paramq = paramArrayOfByte;
            if (localObject3 != null) {
              paramq = Integer.valueOf(((LinkedList)localObject3).size());
            }
            paramq = ((StringBuilder)localObject2).append(paramq).append(", msgSize:");
            paramArrayOfByte = f.rGw;
            paramq = paramq.append(f.eNE().size()).append(" likeCount:");
            paramArrayOfByte = f.rGw;
            ad.i("MicroMsg.LiveNetScene.NetSceneLiveGetLiveMessage", f.eNG().LyR + ", needUpdate:" + ((ead)localObject1).DZy);
            break;
            label686:
            paramq = (Collection)new ArrayList();
            break label353;
            label701:
            paramq = null;
          }
        }
        catch (Exception paramq)
        {
          for (;;)
          {
            ad.l("safeParser", "", new Object[] { paramq });
            continue;
            label730:
            paramq = (List)new ArrayList();
          }
        }
      }
    }
    AppMethodBeat.o(202733);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveGetLiveMessage$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.b.a.l
 * JD-Core Version:    0.7.0.1
 */