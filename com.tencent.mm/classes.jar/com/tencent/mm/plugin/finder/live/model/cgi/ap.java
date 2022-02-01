package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.cd.b;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.protocal.protobuf.ava;
import com.tencent.mm.protocal.protobuf.avb;
import com.tencent.mm.protocal.protobuf.bcc;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/NetSceneFinderGetLiveReward;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "liveId", "", "objectId", "objectNonceId", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "(JJLjava/lang/String;Lcom/tencent/mm/protobuf/ByteString;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getLiveWecoinHotInfoList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRewardGainsInfo;", "getNewTotalWecoinHot", "getTotalWecoinHot", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class ap
  extends com.tencent.mm.plugin.findersdk.b.g
{
  public static final a yko;
  private i callback;
  public d rr;
  
  static
  {
    AppMethodBeat.i(271490);
    yko = new a((byte)0);
    AppMethodBeat.o(271490);
  }
  
  public ap(long paramLong1, long paramLong2, String paramString, b paramb)
  {
    AppMethodBeat.i(271489);
    Object localObject = new d.a();
    ((d.a)localObject).vD(getType());
    ava localava = new ava();
    ao localao = ao.xcj;
    localava.RLM = ao.dnO();
    localava.RLN = z.bdh();
    localava.klE = paramLong1;
    localava.object_id = paramLong2;
    localava.SDI = paramb;
    localava.object_nonce_id = paramString;
    ((d.a)localObject).c((a)localava);
    ((d.a)localObject).d((a)new avb());
    ((d.a)localObject).TW("/cgi-bin/micromsg-bin/findergetliverewardgains");
    localObject = ((d.a)localObject).bgN();
    p.j(localObject, "builder.buildInstance()");
    this.rr = ((d)localObject);
    Log.i("Finder.NetSceneFinderGetLiveReward", "NetSceneFinderGetLiveReward init, finderUsername = " + localava.RLN + ", liveId = " + paramLong1 + ", objectId = " + paramLong2 + ", objectNonceId = " + paramString + ",  lastBuffer = " + paramb);
    AppMethodBeat.o(271489);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(271483);
    Log.i("Finder.NetSceneFinderGetLiveReward", "onGYNetEnd, errType:" + paramInt2 + ", errCode:" + paramInt3 + ", errMsg:" + paramString);
    if (this.callback != null)
    {
      params = this.callback;
      if (params == null) {
        p.iCn();
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
    }
    AppMethodBeat.o(271483);
  }
  
  public final long dAa()
  {
    AppMethodBeat.i(271488);
    Object localObject = this.rr.bhY();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLiveRewardGainsResponse");
      AppMethodBeat.o(271488);
      throw ((Throwable)localObject);
    }
    long l = ((avb)localObject).SHj;
    AppMethodBeat.o(271488);
    return l;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(271480);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(271480);
    return i;
  }
  
  public final LinkedList<bcc> dzZ()
  {
    AppMethodBeat.i(271485);
    Object localObject = this.rr.bhY();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLiveRewardGainsResponse");
      AppMethodBeat.o(271485);
      throw ((Throwable)localObject);
    }
    LinkedList localLinkedList = ((avb)localObject).SCI;
    localObject = localLinkedList;
    if (localLinkedList == null) {
      localObject = new LinkedList();
    }
    AppMethodBeat.o(271485);
    return localObject;
  }
  
  public final int getType()
  {
    return 4168;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/NetSceneFinderGetLiveReward$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.ap
 * JD-Core Version:    0.7.0.1
 */