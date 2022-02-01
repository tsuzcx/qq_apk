package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.live.b.j;
import com.tencent.mm.live.b.k;
import com.tencent.mm.live.b.o;
import com.tencent.mm.live.b.u;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bxf;
import com.tencent.mm.protocal.protobuf.bxg;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.crn;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveGetLiveMessage;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "offline", "", "(JLjava/lang/String;Z)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "duration", "getDuration", "()J", "setDuration", "(J)V", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/GetLiveMessageRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/GetLiveMessageResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class m
  extends q
  implements com.tencent.mm.network.m
{
  public static final a kxD;
  private i callback;
  public long duration;
  private d kwO;
  private final bxf kxB;
  private bxg kxC;
  
  static
  {
    AppMethodBeat.i(195119);
    kxD = new a((byte)0);
    AppMethodBeat.o(195119);
  }
  
  public m(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(195117);
    Object localObject = new d.a();
    ((d.a)localObject).c((a)new bxf());
    ((d.a)localObject).d((a)new bxg());
    ((d.a)localObject).vD(3767);
    ((d.a)localObject).TW("/cgi-bin/micromsg-bin/getlivemessage");
    ((d.a)localObject).vF(0);
    ((d.a)localObject).vG(0);
    ((d.a)localObject).bia();
    ((d.a)localObject).bib();
    localObject = ((d.a)localObject).bgN();
    p.j(localObject, "builder.buildInstance()");
    this.kwO = ((d)localObject);
    localObject = this.kwO.bhX();
    if (localObject == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveMessageRequest");
      AppMethodBeat.o(195117);
      throw paramString;
    }
    this.kxB = ((bxf)localObject);
    this.kxB.klE = paramLong;
    this.kxB.RFj = paramString;
    localObject = this.kxB;
    u localu = u.kwz;
    ((bxf)localObject).RLO = com.tencent.mm.cd.b.cU(u.aOq());
    this.kxB.Gch = paramBoolean;
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveGetLiveMessage", "get live message:" + paramLong + " wechatRoomId:" + paramString + " offline:" + paramBoolean);
    AppMethodBeat.o(195117);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(195105);
    this.duration = System.currentTimeMillis();
    this.callback = parami;
    int i = dispatch(paramg, (s)this.kwO, (com.tencent.mm.network.m)this);
    AppMethodBeat.o(195105);
    return i;
  }
  
  public final int getType()
  {
    return 3767;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    paramArrayOfByte = null;
    AppMethodBeat.i(195116);
    p.k(params, "rr");
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveGetLiveMessage", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.duration = (System.currentTimeMillis() - this.duration);
    Object localObject1 = k.kuf;
    if (k.dw(paramInt2, paramInt3))
    {
      o.a(o.kvA);
      params = this.callback;
      if (params != null)
      {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
        AppMethodBeat.o(195116);
        return;
      }
      AppMethodBeat.o(195116);
      return;
    }
    params = ((d)params).bhY();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveMessageResponse");
      AppMethodBeat.o(195116);
      throw paramString;
    }
    this.kxC = ((bxg)params);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.e("MicroMsg.LiveNetScene.NetSceneLiveGetLiveMessage", "onGYNetEnd error");
      switch (paramInt3)
      {
      }
    }
    for (;;)
    {
      params = this.callback;
      if (params != null)
      {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
        AppMethodBeat.o(195116);
        return;
        params = j.kue;
        j.aNw();
        continue;
        localObject1 = this.kxC;
        if (localObject1 == null) {
          continue;
        }
        Object localObject2;
        if (((bxg)localObject1).TgY)
        {
          params = u.kwz;
          if (u.aOr().SOs != ((bxg)localObject1).SOs)
          {
            params = j.kue;
            j.aNx();
          }
          params = u.kwz;
          u.aOr().SOs = ((bxg)localObject1).SOs;
          params = u.kwz;
          params = u.aOr();
          localObject2 = u.kwz;
          params.TgX = Math.max(u.aOr().TgX, ((bxg)localObject1).TgX);
          params = u.kwz;
          u.aOn().clear();
          params = u.kwz;
          localObject2 = u.aOn();
          params = ((bxg)localObject1).TgW;
          if (params == null) {
            break label700;
          }
          params = (Collection)params;
          label367:
          ((ArrayList)localObject2).addAll(params);
          params = u.kwz;
          u.a(new crm());
          params = u.kwz;
          localObject2 = (a)u.aOx();
          params = ((bxg)localObject1).TgZ;
          if (params == null) {
            break label715;
          }
          params = params.TyB;
          if (params == null) {
            break label715;
          }
          params = params.UH;
        }
        try
        {
          for (;;)
          {
            ((a)localObject2).parseFrom(params);
            params = com.tencent.mm.live.b.d.b.kyI;
            params = u.kwz;
            localObject2 = u.aOp();
            params = ((bxg)localObject1).TgV;
            if (params == null) {
              break label744;
            }
            params = (List)params;
            Object localObject3 = z.bcZ();
            p.j(localObject3, "ConfigStorageLogic.getUsernameFromUserInfo()");
            com.tencent.mm.live.b.d.b.a((ArrayList)localObject2, params, (String)localObject3);
            params = j.kue;
            j.aNv();
            params = u.kwz;
            params = ((bxg)localObject1).RLO;
            p.j(params, "it.live_cookies");
            u.am(params.UH);
            params = new StringBuilder("onlineCount:");
            localObject2 = u.kwz;
            params = params.append(u.aOr().SOs).append(" headerList:");
            localObject2 = u.kwz;
            localObject2 = params.append(u.aOn().size()).append(" remoteMsgSize:");
            localObject3 = ((bxg)localObject1).TgV;
            params = paramArrayOfByte;
            if (localObject3 != null) {
              params = Integer.valueOf(((LinkedList)localObject3).size());
            }
            params = ((StringBuilder)localObject2).append(params).append(", msgSize:");
            paramArrayOfByte = u.kwz;
            params = params.append(u.aOp().size()).append(" likeCount:");
            paramArrayOfByte = u.kwz;
            Log.i("MicroMsg.LiveNetScene.NetSceneLiveGetLiveMessage", u.aOr().TgX + ", needUpdate:" + ((bxg)localObject1).TgY);
            break;
            label700:
            params = (Collection)new ArrayList();
            break label367;
            label715:
            params = null;
          }
        }
        catch (Exception params)
        {
          for (;;)
          {
            Log.printDebugStack("safeParser", "", new Object[] { params });
            continue;
            label744:
            params = (List)new ArrayList();
          }
        }
      }
    }
    AppMethodBeat.o(195116);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveGetLiveMessage$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.m
 * JD-Core Version:    0.7.0.1
 */