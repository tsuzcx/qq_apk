package com.tencent.mm.live.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bpr;
import com.tencent.mm.protocal.protobuf.bps;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveGetOnlineMemberById;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "liveId", "", "idList", "", "", "(JLjava/util/List;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "request", "Lcom/tencent/mm/protocal/protobuf/GetLiveOnlineMemberByIdRequest;", "response", "Lcom/tencent/mm/protocal/protobuf/GetLiveOnlineMemberByIdResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getRemoteUserList", "Lcom/tencent/mm/protocal/protobuf/OnlineMemberInfo;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-logic_release"})
public final class n
  extends q
  implements m
{
  public static final a hKm;
  private i callback;
  private d hJu;
  private bpr hKk;
  public bps hKl;
  
  static
  {
    AppMethodBeat.i(207793);
    hKm = new a((byte)0);
    AppMethodBeat.o(207793);
  }
  
  public n(long paramLong, List<String> paramList)
  {
    AppMethodBeat.i(207792);
    Object localObject = new d.a();
    ((d.a)localObject).c((a)new bpr());
    ((d.a)localObject).d((a)new bps());
    ((d.a)localObject).sG(3816);
    ((d.a)localObject).MB("/cgi-bin/micromsg-bin/getliveonlinememberbyid");
    ((d.a)localObject).sI(0);
    ((d.a)localObject).sJ(0);
    localObject = ((d.a)localObject).aXF();
    p.g(localObject, "builder.buildInstance()");
    this.hJu = ((d)localObject);
    localObject = this.hJu.aYJ();
    if (localObject == null)
    {
      paramList = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveOnlineMemberByIdRequest");
      AppMethodBeat.o(207792);
      throw paramList;
    }
    this.hKk = ((bpr)localObject);
    this.hKk.hyH = paramLong;
    localObject = (Collection)paramList;
    if ((localObject == null) || (((Collection)localObject).isEmpty())) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = this.hKk.LXK;
        if (localObject != null) {
          ((LinkedList)localObject).addAll((Collection)paramList);
        }
      }
      Log.i("MicroMsg.LiveNetScene.NetSceneLiveGetOnlineMemberById", "get live info liveId:".concat(String.valueOf(paramLong)));
      AppMethodBeat.o(207792);
      return;
    }
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(207790);
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveGetOnlineMemberById", "doScene");
    this.callback = parami;
    int i = dispatch(paramg, (s)this.hJu, (m)this);
    AppMethodBeat.o(207790);
    return i;
  }
  
  public final int getType()
  {
    return 3816;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(207791);
    Log.i("MicroMsg.LiveNetScene.NetSceneLiveGetOnlineMemberById", "onGYNetEnd, errType: %s, errCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
      AppMethodBeat.o(207791);
      throw paramString;
    }
    params = ((d)params).aYK();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetLiveOnlineMemberByIdResponse");
      AppMethodBeat.o(207791);
      throw paramString;
    }
    this.hKl = ((bps)params);
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(207791);
      return;
    }
    AppMethodBeat.o(207791);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/cgi/NetSceneLiveGetOnlineMemberById$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.a.n
 * JD-Core Version:    0.7.0.1
 */