package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.plugin.finder.cgi.ax;
import com.tencent.mm.protocal.protobuf.asx;
import com.tencent.mm.protocal.protobuf.asy;
import com.tencent.mm.protocal.protobuf.axa;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/cgi/NetSceneFinderGetLiveReward;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "liveId", "", "objectId", "objectNonceId", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "(JJLjava/lang/String;Lcom/tencent/mm/protobuf/ByteString;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getLiveWecoinHotInfoList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRewardGainsInfo;", "getTotalWecoinHot", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class z
  extends ax
{
  public static final a ulw;
  private i callback;
  public d rr;
  
  static
  {
    AppMethodBeat.i(246353);
    ulw = new a((byte)0);
    AppMethodBeat.o(246353);
  }
  
  public z(long paramLong1, long paramLong2, String paramString, b paramb)
  {
    AppMethodBeat.i(246352);
    Object localObject = new d.a();
    ((d.a)localObject).sG(getType());
    asx localasx = new asx();
    am localam = am.tuw;
    localasx.LBM = am.cXY();
    localasx.LAt = com.tencent.mm.model.z.aUg();
    localasx.hyH = paramLong1;
    localasx.object_id = paramLong2;
    localasx.LDs = paramb;
    localasx.object_nonce_id = paramString;
    ((d.a)localObject).c((a)localasx);
    ((d.a)localObject).d((a)new asy());
    ((d.a)localObject).MB("/cgi-bin/micromsg-bin/findergetliverewardgains");
    localObject = ((d.a)localObject).aXF();
    p.g(localObject, "builder.buildInstance()");
    this.rr = ((d)localObject);
    Log.i("Finder.NetSceneFinderGetLiveReward", "NetSceneFinderGetLiveReward init, finderUsername = " + localasx.LAt + ", liveId = " + paramLong1 + ", objectId = " + paramLong2 + ", objectNonceId = " + paramString + ",  lastBuffer = " + paramb);
    AppMethodBeat.o(246352);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(246350);
    Log.i("Finder.NetSceneFinderGetLiveReward", "onGYNetEnd, errType:" + paramInt2 + ", errCode:" + paramInt3 + ", errMsg:" + paramString);
    if (this.callback != null)
    {
      params = this.callback;
      if (params == null) {
        p.hyc();
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
    }
    AppMethodBeat.o(246350);
  }
  
  public final LinkedList<axa> dgH()
  {
    AppMethodBeat.i(246351);
    Object localObject = this.rr.aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLiveRewardGainsResponse");
      AppMethodBeat.o(246351);
      throw ((Throwable)localObject);
    }
    LinkedList localLinkedList = ((asy)localObject).LAj;
    localObject = localLinkedList;
    if (localLinkedList == null) {
      localObject = new LinkedList();
    }
    AppMethodBeat.o(246351);
    return localObject;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(246349);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(246349);
    return i;
  }
  
  public final int getType()
  {
    return 4168;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/cgi/NetSceneFinderGetLiveReward$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.z
 * JD-Core Version:    0.7.0.1
 */