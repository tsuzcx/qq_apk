package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.live.b.n;
import com.tencent.mm.live.b.r;
import com.tencent.mm.live.b.x;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bpl;
import com.tencent.mm.protocal.protobuf.bpm;
import com.tencent.mm.protocal.protobuf.ciq;
import com.tencent.mm.protocal.protobuf.cis;
import com.tencent.mm.protocal.protobuf.civ;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveGetLiveMessage;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "offline", "", "(JLjava/lang/String;Z)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "duration", "getDuration", "()J", "setDuration", "(J)V", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/GetLiveMessageRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/GetLiveMessageResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class m
  extends q
  implements com.tencent.mm.network.m
{
  public static final a hKj;
  private i callback;
  public long duration;
  private d hJu;
  private final bpl hKh;
  private bpm hKi;
  
  static
  {
    AppMethodBeat.i(207789);
    hKj = new a((byte)0);
    AppMethodBeat.o(207789);
  }
  
  public m(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(207788);
    Object localObject = new d.a();
    ((d.a)localObject).c((a)new bpl());
    ((d.a)localObject).d((a)new bpm());
    ((d.a)localObject).sG(3767);
    ((d.a)localObject).MB("/cgi-bin/micromsg-bin/getlivemessage");
    ((d.a)localObject).sI(0);
    ((d.a)localObject).sJ(0);
    ((d.a)localObject).aYL();
    ((d.a)localObject).aYM();
    localObject = ((d.a)localObject).aXF();
    p.g(localObject, "builder.buildInstance()");
    this.hJu = ((d)localObject);
    localObject = this.hJu.aYJ();
    if (localObject == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveMessageRequest");
      AppMethodBeat.o(207788);
      throw paramString;
    }
    this.hKh = ((bpl)localObject);
    this.hKh.hyH = paramLong;
    this.hKh.KDQ = paramString;
    localObject = this.hKh;
    x localx = x.hJf;
    ((bpl)localObject).LFp = com.tencent.mm.bw.b.cD(x.aGq());
    this.hKh.AqQ = paramBoolean;
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveGetLiveMessage", "get live message:" + paramLong + " wechatRoomId:" + paramString + " offline:" + paramBoolean);
    AppMethodBeat.o(207788);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(207786);
    this.duration = System.currentTimeMillis();
    this.callback = parami;
    int i = dispatch(paramg, (s)this.hJu, (com.tencent.mm.network.m)this);
    AppMethodBeat.o(207786);
    return i;
  }
  
  public final int getType()
  {
    return 3767;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    paramArrayOfByte = null;
    AppMethodBeat.i(207787);
    p.h(params, "rr");
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveGetLiveMessage", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.duration = (System.currentTimeMillis() - this.duration);
    Object localObject1 = n.hGh;
    if (n.da(paramInt2, paramInt3))
    {
      r.a(r.hIg);
      params = this.callback;
      if (params != null)
      {
        params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
        AppMethodBeat.o(207787);
        return;
      }
      AppMethodBeat.o(207787);
      return;
    }
    params = ((d)params).aYK();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveMessageResponse");
      AppMethodBeat.o(207787);
      throw paramString;
    }
    this.hKi = ((bpm)params);
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
        AppMethodBeat.o(207787);
        return;
        params = com.tencent.mm.live.b.m.hGg;
        com.tencent.mm.live.b.m.aFf();
        continue;
        localObject1 = this.hKi;
        if (localObject1 == null) {
          continue;
        }
        Object localObject2;
        if (((bpm)localObject1).LXH)
        {
          params = x.hJf;
          if (x.aGr().LIa != ((bpm)localObject1).LIa)
          {
            params = com.tencent.mm.live.b.m.hGg;
            com.tencent.mm.live.b.m.aFg();
          }
          params = x.hJf;
          x.aGr().LIa = ((bpm)localObject1).LIa;
          params = x.hJf;
          params = x.aGr();
          localObject2 = x.hJf;
          params.LXG = Math.max(x.aGr().LXG, ((bpm)localObject1).LXG);
          params = x.hJf;
          x.aGn().clear();
          params = x.hJf;
          localObject2 = x.aGn();
          params = ((bpm)localObject1).LXF;
          if (params == null) {
            break label700;
          }
          params = (Collection)params;
          label367:
          ((ArrayList)localObject2).addAll(params);
          params = x.hJf;
          x.a(new ciq());
          params = x.hJf;
          localObject2 = (a)x.aGx();
          params = ((bpm)localObject1).LXI;
          if (params == null) {
            break label715;
          }
          params = params.MnG;
          if (params == null) {
            break label715;
          }
          params = params.zy;
        }
        try
        {
          for (;;)
          {
            ((a)localObject2).parseFrom(params);
            params = com.tencent.mm.live.b.d.b.hLo;
            params = x.hJf;
            localObject2 = x.aGp();
            params = ((bpm)localObject1).LXE;
            if (params == null) {
              break label744;
            }
            params = (List)params;
            Object localObject3 = z.aTY();
            p.g(localObject3, "ConfigStorageLogic.getUsernameFromUserInfo()");
            com.tencent.mm.live.b.d.b.a((ArrayList)localObject2, params, (String)localObject3);
            params = com.tencent.mm.live.b.m.hGg;
            com.tencent.mm.live.b.m.aFe();
            params = x.hJf;
            params = ((bpm)localObject1).LFp;
            p.g(params, "it.live_cookies");
            x.ad(params.zy);
            params = new StringBuilder("onlineCount:");
            localObject2 = x.hJf;
            params = params.append(x.aGr().LIa).append(" headerList:");
            localObject2 = x.hJf;
            localObject2 = params.append(x.aGn().size()).append(" remoteMsgSize:");
            localObject3 = ((bpm)localObject1).LXE;
            params = paramArrayOfByte;
            if (localObject3 != null) {
              params = Integer.valueOf(((LinkedList)localObject3).size());
            }
            params = ((StringBuilder)localObject2).append(params).append(", msgSize:");
            paramArrayOfByte = x.hJf;
            params = params.append(x.aGp().size()).append(" likeCount:");
            paramArrayOfByte = x.hJf;
            Log.i("MicroMsg.LiveNetScene.NetSceneLiveGetLiveMessage", x.aGr().LXG + ", needUpdate:" + ((bpm)localObject1).LXH);
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
    AppMethodBeat.o(207787);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveGetLiveMessage$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.m
 * JD-Core Version:    0.7.0.1
 */