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
import com.tencent.mm.protocal.protobuf.azp;
import com.tencent.mm.protocal.protobuf.azq;
import com.tencent.mm.protocal.protobuf.bam;
import com.tencent.mm.protocal.protobuf.bdo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/NetSceneFinderLiveLotteryHistory;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "scene", "", "liveId", "", "objectId", "objectNonceId", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "(IJJLjava/lang/String;Lcom/tencent/mm/protobuf/ByteString;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "pullType", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getLiveList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryRecord;", "kotlin.jvm.PlatformType", "getLiveListContinueFlag", "getLiveListLastBuffer", "getLotteryInfoListContinueFlag", "()Ljava/lang/Integer;", "getLotteryInfoListLastBuffer", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class aq
  extends com.tencent.mm.plugin.findersdk.b.g
{
  public static final a ykp;
  private i callback;
  public int pullType;
  public d rr;
  
  static
  {
    AppMethodBeat.i(268546);
    ykp = new a((byte)0);
    AppMethodBeat.o(268546);
  }
  
  public aq(int paramInt, long paramLong1, long paramLong2, String paramString, b paramb)
  {
    AppMethodBeat.i(268545);
    Object localObject = new d.a();
    ((d.a)localObject).vD(getType());
    azp localazp = new azp();
    localazp.scene = paramInt;
    ao localao = ao.xcj;
    localazp.SDi = ao.dnO();
    localazp.finderUsername = z.bdh();
    localazp.liveId = paramLong1;
    localazp.xbk = paramLong2;
    localazp.lastBuffer = paramb;
    localazp.objectNonceId = paramString;
    ((d.a)localObject).c((a)localazp);
    ((d.a)localObject).d((a)new azq());
    ((d.a)localObject).TW("/cgi-bin/micromsg-bin/finderlivegetlotteryhistory");
    localObject = ((d.a)localObject).bgN();
    p.j(localObject, "builder.buildInstance()");
    this.rr = ((d)localObject);
    Log.i("NetSceneFinderLiveLotteryHistory", "NetSceneFinderLiveLotteryHistory init, finderUsername = " + localazp.finderUsername + ", liveId = " + paramLong1 + ", objectId = " + paramLong2 + ", objectNonceId = " + paramString + ", scene = " + paramInt + ",  lastBuffer = " + paramb);
    AppMethodBeat.o(268545);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(268543);
    if (this.callback != null)
    {
      params = this.callback;
      if (params == null) {
        p.iCn();
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
    }
    AppMethodBeat.o(268543);
  }
  
  public final LinkedList<bam> dAb()
  {
    AppMethodBeat.i(268544);
    Object localObject = this.rr.bhY();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveGetLotteryHistoryResponse");
      AppMethodBeat.o(268544);
      throw ((Throwable)localObject);
    }
    localObject = ((azq)localObject).SLo;
    if (localObject != null)
    {
      LinkedList localLinkedList = ((bdo)localObject).SOA;
      localObject = localLinkedList;
      if (localLinkedList != null) {}
    }
    else
    {
      localObject = new LinkedList();
    }
    AppMethodBeat.o(268544);
    return localObject;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(268541);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(268541);
    return i;
  }
  
  public final int getType()
  {
    return 6484;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/cgi/NetSceneFinderLiveLotteryHistory$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.aq
 * JD-Core Version:    0.7.0.1
 */