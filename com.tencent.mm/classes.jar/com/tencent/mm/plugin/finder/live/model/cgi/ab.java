package com.tencent.mm.plugin.finder.live.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.plugin.finder.cgi.ax;
import com.tencent.mm.protocal.protobuf.avv;
import com.tencent.mm.protocal.protobuf.avw;
import com.tencent.mm.protocal.protobuf.awj;
import com.tencent.mm.protocal.protobuf.axv;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/cgi/NetSceneFinderLiveLotteryHistory;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "scene", "", "liveId", "", "objectId", "objectNonceId", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "(IJJLjava/lang/String;Lcom/tencent/mm/protobuf/ByteString;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "pullType", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getLiveList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryRecord;", "kotlin.jvm.PlatformType", "getLiveListContinueFlag", "getLiveListLastBuffer", "getLotteryInfoListContinueFlag", "()Ljava/lang/Integer;", "getLotteryInfoListLastBuffer", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class ab
  extends ax
{
  public static final a uly;
  private i callback;
  public int pullType;
  public d rr;
  
  static
  {
    AppMethodBeat.i(246362);
    uly = new a((byte)0);
    AppMethodBeat.o(246362);
  }
  
  public ab(int paramInt, long paramLong1, long paramLong2, String paramString, b paramb)
  {
    AppMethodBeat.i(246361);
    Object localObject = new d.a();
    ((d.a)localObject).sG(getType());
    avv localavv = new avv();
    localavv.scene = paramInt;
    am localam = am.tuw;
    localavv.LAI = am.cXY();
    localavv.finderUsername = z.aUg();
    localavv.liveId = paramLong1;
    localavv.hFK = paramLong2;
    localavv.lastBuffer = paramb;
    localavv.objectNonceId = paramString;
    ((d.a)localObject).c((a)localavv);
    ((d.a)localObject).d((a)new avw());
    ((d.a)localObject).MB("/cgi-bin/micromsg-bin/finderlivegetlotteryhistory");
    localObject = ((d.a)localObject).aXF();
    p.g(localObject, "builder.buildInstance()");
    this.rr = ((d)localObject);
    Log.i("NetSceneFinderLiveLotteryHistory", "NetSceneFinderLiveLotteryHistory init, finderUsername = " + localavv.finderUsername + ", liveId = " + paramLong1 + ", objectId = " + paramLong2 + ", objectNonceId = " + paramString + ", scene = " + paramInt + ",  lastBuffer = " + paramb);
    AppMethodBeat.o(246361);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(246359);
    if (this.callback != null)
    {
      params = this.callback;
      if (params == null) {
        p.hyc();
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
    }
    AppMethodBeat.o(246359);
  }
  
  public final LinkedList<awj> dgI()
  {
    AppMethodBeat.i(246360);
    Object localObject = this.rr.aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveGetLotteryHistoryResponse");
      AppMethodBeat.o(246360);
      throw ((Throwable)localObject);
    }
    localObject = ((avw)localObject).LGr;
    if (localObject != null)
    {
      LinkedList localLinkedList = ((axv)localObject).LIc;
      localObject = localLinkedList;
      if (localLinkedList != null) {}
    }
    else
    {
      localObject = new LinkedList();
    }
    AppMethodBeat.o(246360);
    return localObject;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(246358);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(246358);
    return i;
  }
  
  public final int getType()
  {
    return 6484;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/cgi/NetSceneFinderLiveLotteryHistory$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.ab
 * JD-Core Version:    0.7.0.1
 */