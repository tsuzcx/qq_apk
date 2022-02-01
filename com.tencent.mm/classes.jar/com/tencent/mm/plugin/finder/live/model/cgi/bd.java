package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.protocal.protobuf.azy;
import com.tencent.mm.protocal.protobuf.azz;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/NetSceneFinderGetLiveReward;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "liveId", "", "objectId", "objectNonceId", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "rewardType", "", "(JJLjava/lang/String;Lcom/tencent/mm/protobuf/ByteString;I)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getLiveWecoinHotInfoList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRewardGainsInfo;", "getNewTotalWecoinHot", "getTotalWecoinHot", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bd
  extends com.tencent.mm.plugin.findersdk.b.h
{
  public static final a CKT;
  private com.tencent.mm.am.h callback;
  private c rr;
  
  static
  {
    AppMethodBeat.i(360166);
    CKT = new a((byte)0);
    AppMethodBeat.o(360166);
  }
  
  public bd(long paramLong1, long paramLong2, String paramString, b paramb, int paramInt)
  {
    AppMethodBeat.i(360159);
    Object localObject = new c.a();
    ((c.a)localObject).funcId = getType();
    azy localazy = new azy();
    bi localbi = bi.ABn;
    localazy.YIY = bi.dVu();
    localazy.YIZ = z.bAW();
    localazy.mMJ = paramLong1;
    localazy.object_id = paramLong2;
    localazy.ZEQ = paramb;
    localazy.object_nonce_id = paramString;
    localazy.ZKO = paramInt;
    ((c.a)localObject).otE = ((a)localazy);
    ((c.a)localObject).otF = ((a)new azz());
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/findergetliverewardgains";
    localObject = ((c.a)localObject).bEF();
    kotlin.g.b.s.s(localObject, "builder.buildInstance()");
    this.rr = ((c)localObject);
    Log.i("Finder.NetSceneFinderGetLiveReward", "NetSceneFinderGetLiveReward init, finderUsername = " + localazy.YIZ + ", liveId = " + paramLong1 + ", objectId = " + paramLong2 + ", objectNonceId = " + paramString + ",  lastBuffer = " + paramb + ", reward_type:" + paramInt);
    AppMethodBeat.o(360159);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(360182);
    Log.i("Finder.NetSceneFinderGetLiveReward", "onGYNetEnd, errType:" + paramInt2 + ", errCode:" + paramInt3 + ", errMsg:" + paramString);
    if (this.callback != null)
    {
      params = this.callback;
      kotlin.g.b.s.checkNotNull(params);
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(360182);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(360171);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (m)this);
    AppMethodBeat.o(360171);
    return i;
  }
  
  public final LinkedList<bmd> emF()
  {
    AppMethodBeat.i(360192);
    Object localObject = c.c.b(this.rr.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLiveRewardGainsResponse");
      AppMethodBeat.o(360192);
      throw ((Throwable)localObject);
    }
    localObject = ((azz)localObject).ZDA;
    if (localObject == null)
    {
      localObject = new LinkedList();
      AppMethodBeat.o(360192);
      return localObject;
    }
    AppMethodBeat.o(360192);
    return localObject;
  }
  
  public final long emG()
  {
    AppMethodBeat.i(360202);
    Object localObject = c.c.b(this.rr.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLiveRewardGainsResponse");
      AppMethodBeat.o(360202);
      throw ((Throwable)localObject);
    }
    long l = ((azz)localObject).ZKy;
    AppMethodBeat.o(360202);
    return l;
  }
  
  public final long emH()
  {
    AppMethodBeat.i(360208);
    Object localObject = c.c.b(this.rr.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLiveRewardGainsResponse");
      AppMethodBeat.o(360208);
      throw ((Throwable)localObject);
    }
    long l = ((azz)localObject).ZKR;
    AppMethodBeat.o(360208);
    return l;
  }
  
  public final int getType()
  {
    return 4168;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/NetSceneFinderGetLiveReward$Companion;", "", "()V", "TAG", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.bd
 * JD-Core Version:    0.7.0.1
 */