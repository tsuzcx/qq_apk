package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.live.b.x;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bpt;
import com.tencent.mm.protocal.protobuf.bpu;
import com.tencent.mm.protocal.protobuf.cje;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/cgi/NetSceneGetLiveOnlineStateRoom;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "(JLjava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getLiveId", "()J", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/GetLiveOnlineStateByRoomRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/GetLiveOnlineStateByRoomResponse;", "getWechatRoomId", "()Ljava/lang/String;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class d
  extends q
  implements m
{
  private static final String TAG = "MicroMsg.LiveNetScene.NetSceneGetLiveOnlineStateRoom";
  public static final a hJI;
  private i callback;
  private final String hFW;
  private bpt hJG;
  private bpu hJH;
  private com.tencent.mm.ak.d hJu;
  private final long liveId;
  
  static
  {
    AppMethodBeat.i(207753);
    hJI = new a((byte)0);
    TAG = "MicroMsg.LiveNetScene.NetSceneGetLiveOnlineStateRoom";
    AppMethodBeat.o(207753);
  }
  
  public d(long paramLong, String paramString)
  {
    AppMethodBeat.i(207752);
    this.liveId = paramLong;
    this.hFW = paramString;
    paramString = new com.tencent.mm.ak.d.a();
    paramString.c((a)new bpt());
    paramString.d((a)new bpu());
    paramString.sG(3700);
    paramString.MB("/cgi-bin/micromsg-bin/getliveonlinestatebyroom");
    paramString.sI(0);
    paramString.sJ(0);
    paramString = paramString.aXF();
    p.g(paramString, "builder.buildInstance()");
    this.hJu = paramString;
    paramString = this.hJu.aYJ();
    if (paramString == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveOnlineStateByRoomRequest");
      AppMethodBeat.o(207752);
      throw paramString;
    }
    this.hJG = ((bpt)paramString);
    paramString = this.hJG;
    if (paramString != null) {
      paramString.hyH = this.liveId;
    }
    paramString = this.hJG;
    if (paramString != null)
    {
      paramString.KDQ = this.hFW;
      AppMethodBeat.o(207752);
      return;
    }
    AppMethodBeat.o(207752);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(207750);
    Log.i("MicroMsg.LiveNetScene.NetSceneGetLiveInfo", "doScene");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.hJu, (m)this);
    AppMethodBeat.o(207750);
    return i;
  }
  
  public final int getType()
  {
    return 3700;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(207751);
    Log.i(TAG, "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(207751);
      throw paramString;
    }
    params = ((com.tencent.mm.ak.d)params).aYK();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveOnlineStateByRoomResponse");
      AppMethodBeat.o(207751);
      throw paramString;
    }
    this.hJH = ((bpu)params);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      Log.e(TAG, "onGYNetEnd error");
    }
    for (;;)
    {
      params = this.callback;
      if (params == null) {
        break;
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(207751);
      return;
      paramArrayOfByte = this.hJH;
      if (paramArrayOfByte != null)
      {
        params = x.hJf;
        if (x.aGo().get(this.hFW) == null)
        {
          params = x.hJf;
          ((Map)x.aGo()).put(this.hFW, new o(new ArrayList(), Integer.valueOf(0)));
        }
        params = x.hJf;
        params = (o)x.aGo().get(this.hFW);
        if (params != null) {}
        ArrayList localArrayList;
        for (params = (ArrayList)params.first;; params = null)
        {
          if (params != null) {
            params.clear();
          }
          localArrayList = new ArrayList();
          paramArrayOfByte = paramArrayOfByte.LXM;
          p.g(paramArrayOfByte, "it.user_online_state_list");
          paramArrayOfByte = ((Iterable)paramArrayOfByte).iterator();
          while (paramArrayOfByte.hasNext()) {
            localArrayList.add(((cje)paramArrayOfByte.next()).MnR);
          }
        }
        if (params != null) {
          params.addAll((Collection)localArrayList);
        }
        Log.i(TAG, "idList:".concat(String.valueOf(localArrayList)));
        params = x.hJf;
        x.aGr().LIa = localArrayList.size();
      }
    }
    AppMethodBeat.o(207751);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/cgi/NetSceneGetLiveOnlineStateRoom$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.d
 * JD-Core Version:    0.7.0.1
 */