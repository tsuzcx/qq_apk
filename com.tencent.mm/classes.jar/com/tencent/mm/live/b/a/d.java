package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.live.b.u;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bxn;
import com.tencent.mm.protocal.protobuf.bxo;
import com.tencent.mm.protocal.protobuf.crz;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/model/cgi/NetSceneGetLiveOnlineStateRoom;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "wechatRoomId", "", "(JLjava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getLiveId", "()J", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/GetLiveOnlineStateByRoomRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/GetLiveOnlineStateByRoomResponse;", "getWechatRoomId", "()Ljava/lang/String;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class d
  extends q
  implements m
{
  private static final String TAG = "MicroMsg.LiveNetScene.NetSceneGetLiveOnlineStateRoom";
  public static final a kxc;
  private i callback;
  private final String ktU;
  private com.tencent.mm.an.d kwO;
  private bxn kxa;
  private bxo kxb;
  private final long liveId;
  
  static
  {
    AppMethodBeat.i(199625);
    kxc = new a((byte)0);
    TAG = "MicroMsg.LiveNetScene.NetSceneGetLiveOnlineStateRoom";
    AppMethodBeat.o(199625);
  }
  
  public d(long paramLong, String paramString)
  {
    AppMethodBeat.i(199624);
    this.liveId = paramLong;
    this.ktU = paramString;
    paramString = new com.tencent.mm.an.d.a();
    paramString.c((a)new bxn());
    paramString.d((a)new bxo());
    paramString.vD(3700);
    paramString.TW("/cgi-bin/micromsg-bin/getliveonlinestatebyroom");
    paramString.vF(0);
    paramString.vG(0);
    paramString = paramString.bgN();
    p.j(paramString, "builder.buildInstance()");
    this.kwO = paramString;
    paramString = this.kwO.bhX();
    if (paramString == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveOnlineStateByRoomRequest");
      AppMethodBeat.o(199624);
      throw paramString;
    }
    this.kxa = ((bxn)paramString);
    paramString = this.kxa;
    if (paramString != null) {
      paramString.klE = this.liveId;
    }
    paramString = this.kxa;
    if (paramString != null)
    {
      paramString.RFj = this.ktU;
      AppMethodBeat.o(199624);
      return;
    }
    AppMethodBeat.o(199624);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(199613);
    Log.i("MicroMsg.LiveNetScene.NetSceneGetLiveInfo", "doScene");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.kwO, (m)this);
    AppMethodBeat.o(199613);
    return i;
  }
  
  public final int getType()
  {
    return 3700;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(199620);
    Log.i(TAG, "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(199620);
      throw paramString;
    }
    params = ((com.tencent.mm.an.d)params).bhY();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveOnlineStateByRoomResponse");
      AppMethodBeat.o(199620);
      throw paramString;
    }
    this.kxb = ((bxo)params);
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
      AppMethodBeat.o(199620);
      return;
      paramArrayOfByte = this.kxb;
      if (paramArrayOfByte != null)
      {
        params = u.kwz;
        if (u.aOo().get(this.ktU) == null)
        {
          params = u.kwz;
          ((Map)u.aOo()).put(this.ktU, new o(new ArrayList(), Integer.valueOf(0)));
        }
        params = u.kwz;
        params = (o)u.aOo().get(this.ktU);
        if (params != null) {}
        ArrayList localArrayList;
        for (params = (ArrayList)params.Mx;; params = null)
        {
          if (params != null) {
            params.clear();
          }
          localArrayList = new ArrayList();
          paramArrayOfByte = paramArrayOfByte.Thd;
          p.j(paramArrayOfByte, "it.user_online_state_list");
          paramArrayOfByte = ((Iterable)paramArrayOfByte).iterator();
          while (paramArrayOfByte.hasNext()) {
            localArrayList.add(((crz)paramArrayOfByte.next()).TyL);
          }
        }
        if (params != null) {
          params.addAll((Collection)localArrayList);
        }
        Log.i(TAG, "idList:".concat(String.valueOf(localArrayList)));
        params = u.kwz;
        u.aOr().SOs = localArrayList.size();
      }
    }
    AppMethodBeat.o(199620);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/model/cgi/NetSceneGetLiveOnlineStateRoom$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.d
 * JD-Core Version:    0.7.0.1
 */