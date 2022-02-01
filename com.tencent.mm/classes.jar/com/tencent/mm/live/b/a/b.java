package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.live.b.x;
import com.tencent.mm.model.v;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bpj;
import com.tencent.mm.protocal.protobuf.bpk;
import com.tencent.mm.protocal.protobuf.civ;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/cgi/NetSceneGetLiveInfo;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "roomId", "", "isForCheck", "", "(JLjava/lang/String;Z)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()Z", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/GetLiveInfoRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/GetLiveInfoResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getLiveInfo", "Lcom/tencent/mm/protocal/protobuf/LiveInfo;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class b
  extends q
  implements m
{
  public static final a hJB;
  private i callback;
  private final boolean hJA;
  private d hJu;
  private bpj hJy;
  private bpk hJz;
  
  static
  {
    AppMethodBeat.i(207745);
    hJB = new a((byte)0);
    AppMethodBeat.o(207745);
  }
  
  public b(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(207744);
    this.hJA = paramBoolean;
    Object localObject = new d.a();
    ((d.a)localObject).c((a)new bpj());
    ((d.a)localObject).d((a)new bpk());
    ((d.a)localObject).sG(3806);
    ((d.a)localObject).MB("/cgi-bin/micromsg-bin/getliveinfo");
    ((d.a)localObject).sI(0);
    ((d.a)localObject).sJ(0);
    localObject = ((d.a)localObject).aXF();
    p.g(localObject, "builder.buildInstance()");
    this.hJu = ((d)localObject);
    localObject = this.hJu.aYJ();
    if (localObject == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveInfoRequest");
      AppMethodBeat.o(207744);
      throw paramString;
    }
    this.hJy = ((bpj)localObject);
    this.hJy.hyH = paramLong;
    this.hJy.KDQ = paramString;
    Log.i("MicroMsg.LiveNetScene.NetSceneGetLiveInfo", "get live info liveId:" + paramLong + ", roomId:" + paramString);
    AppMethodBeat.o(207744);
  }
  
  public final civ aGr()
  {
    bpk localbpk = this.hJz;
    if (localbpk != null) {
      return localbpk.LpG;
    }
    return null;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(207742);
    Log.i("MicroMsg.LiveNetScene.NetSceneGetLiveInfo", "doScene");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.hJu, (m)this);
    AppMethodBeat.o(207742);
    return i;
  }
  
  public final int getType()
  {
    return 3806;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(207743);
    paramArrayOfByte = new StringBuilder("onGYNetEnd, errType:").append(paramInt2).append(", errCode:").append(paramInt3).append(", isForCheck:").append(this.hJA).append(", LiveAnchorTRTCCore.hasInstance:");
    Object localObject1 = com.tencent.mm.live.core.core.a.b.hyv;
    paramArrayOfByte = paramArrayOfByte.append(com.tencent.mm.live.core.core.a.b.a.aDp()).append(" LiveVisitorTRTCCore.hasInstance:");
    localObject1 = com.tencent.mm.live.core.core.d.b.hCo;
    Log.i("MicroMsg.LiveNetScene.NetSceneGetLiveInfo", com.tencent.mm.live.core.core.d.b.a.aDp());
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(207743);
      throw paramString;
    }
    params = ((d)params).aYK();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveInfoResponse");
      AppMethodBeat.o(207743);
      throw paramString;
    }
    this.hJz = ((bpk)params);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      Log.e("MicroMsg.LiveNetScene.NetSceneGetLiveInfo", "onGYNetEnd error");
    }
    for (;;)
    {
      params = this.callback;
      if (params == null) {
        break;
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(207743);
      return;
      if (!this.hJA)
      {
        params = com.tencent.mm.live.core.core.d.b.hCo;
        if (!com.tencent.mm.live.core.core.d.b.a.aDp())
        {
          params = com.tencent.mm.live.core.core.a.b.hyv;
          if (!com.tencent.mm.live.core.core.a.b.a.aDp()) {}
        }
        else
        {
          params = aGr();
          if (params != null)
          {
            paramArrayOfByte = params.MnJ;
            localObject1 = (Collection)paramArrayOfByte;
            if ((localObject1 == null) || (((Collection)localObject1).isEmpty())) {}
            for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
            {
              localObject1 = ((Iterable)paramArrayOfByte).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                String str = (String)((Iterator)localObject1).next();
                paramInt1 = v.Ie(str);
                Object localObject2 = x.hJf;
                if (x.aGo().get(str) == null)
                {
                  localObject2 = x.hJf;
                  localObject2 = (Map)x.aGo();
                  p.g(str, "it");
                  ((Map)localObject2).put(str, new o(new ArrayList(), Integer.valueOf(paramInt1)));
                }
              }
            }
            Log.i("MicroMsg.LiveNetScene.NetSceneGetLiveInfo", "roomList:".concat(String.valueOf(paramArrayOfByte)));
            paramArrayOfByte = x.hJf;
            x.a(params);
          }
        }
      }
    }
    AppMethodBeat.o(207743);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/cgi/NetSceneGetLiveInfo$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.b
 * JD-Core Version:    0.7.0.1
 */