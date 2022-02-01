package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.live.b.c;
import com.tencent.mm.live.b.g;
import com.tencent.mm.live.b.i;
import com.tencent.mm.model.u;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bdh;
import com.tencent.mm.protocal.protobuf.bdi;
import com.tencent.mm.protocal.protobuf.buo;
import com.tencent.mm.protocal.protobuf.bup;
import com.tencent.mm.protocal.protobuf.buq;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveGetLiveMessage;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "offline", "", "(JLjava/lang/String;Z)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "duration", "getDuration", "()J", "setDuration", "(J)V", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/GetLiveMessageRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/GetLiveMessageResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class m
  extends n
  implements k
{
  public static final a gQe;
  private f callback;
  public long duration;
  private com.tencent.mm.al.b gPp;
  private final bdh gQc;
  private bdi gQd;
  
  static
  {
    AppMethodBeat.i(212216);
    gQe = new a((byte)0);
    AppMethodBeat.o(212216);
  }
  
  public m(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(212215);
    Object localObject = new b.a();
    ((b.a)localObject).c((a)new bdh());
    ((b.a)localObject).d((a)new bdi());
    ((b.a)localObject).oP(3767);
    ((b.a)localObject).Dl("/cgi-bin/micromsg-bin/getlivemessage");
    ((b.a)localObject).oR(0);
    ((b.a)localObject).oS(0);
    ((b.a)localObject).aEG();
    ((b.a)localObject).aEH();
    localObject = ((b.a)localObject).aDC();
    p.g(localObject, "builder.buildInstance()");
    this.gPp = ((com.tencent.mm.al.b)localObject);
    localObject = this.gPp.aEE();
    if (localObject == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveMessageRequest");
      AppMethodBeat.o(212215);
      throw paramString;
    }
    this.gQc = ((bdh)localObject);
    this.gQc.Fsa = paramLong;
    this.gQc.Fsb = paramString;
    localObject = this.gQc;
    g localg = g.gOr;
    ((bdh)localObject).GzS = com.tencent.mm.bx.b.cj(g.anq());
    this.gQc.GzT = paramBoolean;
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveGetLiveMessage", "get live message:" + paramLong + " wechatRoomId:" + paramString + " offline:" + paramBoolean);
    AppMethodBeat.o(212215);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(212213);
    this.duration = System.currentTimeMillis();
    this.callback = paramf;
    int i = dispatch(parame, (q)this.gPp, (k)this);
    AppMethodBeat.o(212213);
    return i;
  }
  
  public final int getType()
  {
    return 3767;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    paramArrayOfByte = null;
    AppMethodBeat.i(212214);
    p.h(paramq, "rr");
    ad.i("MicroMsg.LiveNetScene.NetSceneLiveGetLiveMessage", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.duration = (System.currentTimeMillis() - this.duration);
    Object localObject1 = com.tencent.mm.live.b.e.gMR;
    if (com.tencent.mm.live.b.e.cV(paramInt2, paramInt3))
    {
      i.a(i.gPh);
      paramq = this.callback;
      if (paramq != null)
      {
        paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
        AppMethodBeat.o(212214);
        return;
      }
      AppMethodBeat.o(212214);
      return;
    }
    paramq = ((com.tencent.mm.al.b)paramq).aEF();
    if (paramq == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveMessageResponse");
      AppMethodBeat.o(212214);
      throw paramString;
    }
    this.gQd = ((bdi)paramq);
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
        AppMethodBeat.o(212214);
        return;
        paramq = c.gMO;
        c.amP();
        continue;
        localObject1 = this.gQd;
        if (localObject1 == null) {
          continue;
        }
        Object localObject2;
        if (((bdi)localObject1).GzY)
        {
          paramq = g.gOr;
          if (g.ans().GzV != ((bdi)localObject1).GzV)
          {
            paramq = c.gMO;
            c.amQ();
          }
          paramq = g.gOr;
          g.ans().GzV = ((bdi)localObject1).GzV;
          paramq = g.gOr;
          paramq = g.ans();
          localObject2 = g.gOr;
          paramq.GzX = Math.max(g.ans().GzX, ((bdi)localObject1).GzX);
          paramq = g.gOr;
          g.ann().clear();
          paramq = g.gOr;
          localObject2 = g.ann();
          paramq = ((bdi)localObject1).GzW;
          if (paramq == null) {
            break label700;
          }
          paramq = (Collection)paramq;
          label367:
          ((ArrayList)localObject2).addAll(paramq);
          paramq = g.gOr;
          g.a(new buo());
          paramq = g.gOr;
          localObject2 = (a)g.any();
          paramq = ((bdi)localObject1).GzZ;
          if (paramq == null) {
            break label715;
          }
          paramq = paramq.GOD;
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
            paramq = com.tencent.mm.live.b.d.b.gRj;
            paramq = g.gOr;
            localObject2 = g.anp();
            paramq = ((bdi)localObject1).GzU;
            if (paramq == null) {
              break label744;
            }
            paramq = (List)paramq;
            Object localObject3 = u.aAm();
            p.g(localObject3, "ConfigStorageLogic.getUsernameFromUserInfo()");
            com.tencent.mm.live.b.d.b.a((ArrayList)localObject2, paramq, (String)localObject3);
            paramq = c.gMO;
            c.amO();
            paramq = g.gOr;
            paramq = ((bdi)localObject1).GzS;
            p.g(paramq, "it.live_cookies");
            g.P(paramq.getBytes());
            paramq = new StringBuilder("onlineCount:");
            localObject2 = g.gOr;
            paramq = paramq.append(g.ans().GzV).append(" headerList:");
            localObject2 = g.gOr;
            localObject2 = paramq.append(g.ann().size()).append(" remoteMsgSize:");
            localObject3 = ((bdi)localObject1).GzU;
            paramq = paramArrayOfByte;
            if (localObject3 != null) {
              paramq = Integer.valueOf(((LinkedList)localObject3).size());
            }
            paramq = ((StringBuilder)localObject2).append(paramq).append(", msgSize:");
            paramArrayOfByte = g.gOr;
            paramq = paramq.append(g.anp().size()).append(" likeCount:");
            paramArrayOfByte = g.gOr;
            ad.i("MicroMsg.LiveNetScene.NetSceneLiveGetLiveMessage", g.ans().GzX + ", needUpdate:" + ((bdi)localObject1).GzY);
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
            ad.l("safeParser", "", new Object[] { paramq });
            continue;
            label744:
            paramq = (List)new ArrayList();
          }
        }
      }
    }
    AppMethodBeat.o(212214);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveGetLiveMessage$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.m
 * JD-Core Version:    0.7.0.1
 */