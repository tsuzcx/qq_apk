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
import com.tencent.mm.protocal.protobuf.bhy;
import com.tencent.mm.protocal.protobuf.bhz;
import com.tencent.mm.protocal.protobuf.bje;
import com.tencent.mm.protocal.protobuf.bok;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/NetSceneFinderLiveLotteryHistory;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "scene", "", "liveId", "", "objectId", "objectNonceId", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getType", "(IJJLjava/lang/String;Lcom/tencent/mm/protobuf/ByteString;I)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "pullType", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getLiveList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryRecord;", "kotlin.jvm.PlatformType", "getLiveListContinueFlag", "getLiveListLastBuffer", "getLotteryInfoListContinueFlag", "()Ljava/lang/Integer;", "getLotteryInfoListLastBuffer", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class be
  extends com.tencent.mm.plugin.findersdk.b.h
{
  public static final a CKU;
  private com.tencent.mm.am.h callback;
  public int pullType;
  public c rr;
  
  static
  {
    AppMethodBeat.i(360164);
    CKU = new a((byte)0);
    AppMethodBeat.o(360164);
  }
  
  public be(int paramInt1, long paramLong1, long paramLong2, String paramString, b paramb, int paramInt2)
  {
    AppMethodBeat.i(360156);
    Object localObject = new c.a();
    ((c.a)localObject).funcId = getType();
    bhy localbhy = new bhy();
    localbhy.scene = paramInt1;
    bi localbi = bi.ABn;
    localbhy.ZEc = bi.dVu();
    localbhy.finderUsername = z.bAW();
    localbhy.liveId = paramLong1;
    localbhy.hKN = paramLong2;
    localbhy.lastBuffer = paramb;
    localbhy.objectNonceId = paramString;
    localbhy.ZRf = paramInt2;
    ((c.a)localObject).otE = ((a)localbhy);
    ((c.a)localObject).otF = ((a)new bhz());
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/finderlivegetlotteryhistory";
    localObject = ((c.a)localObject).bEF();
    kotlin.g.b.s.s(localObject, "builder.buildInstance()");
    this.rr = ((c)localObject);
    Log.i("NetSceneFinderLiveLotteryHistory", "NetSceneFinderLiveLotteryHistory init, finderUsername = " + localbhy.finderUsername + ", liveId = " + paramLong1 + ", objectId = " + paramLong2 + ", objectNonceId = " + paramString + ", scene = " + paramInt1 + ",  lastBuffer = " + paramb + ", getType:" + paramInt2);
    AppMethodBeat.o(360156);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(360179);
    Log.i("NetSceneFinderLiveLotteryHistory", "onGYNetEnd, errType:" + paramInt2 + ", errCode:" + paramInt3 + ", errMsg:" + paramString);
    if (this.callback != null)
    {
      params = this.callback;
      kotlin.g.b.s.checkNotNull(params);
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(360179);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(360168);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (m)this);
    AppMethodBeat.o(360168);
    return i;
  }
  
  public final LinkedList<bje> emI()
  {
    AppMethodBeat.i(360188);
    Object localObject = c.c.b(this.rr.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveGetLotteryHistoryResponse");
      AppMethodBeat.o(360188);
      throw ((Throwable)localObject);
    }
    localObject = ((bhz)localObject).ZRg;
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = ((bok)localObject).ZWH)
    {
      localObject = new LinkedList();
      AppMethodBeat.o(360188);
      return localObject;
    }
    AppMethodBeat.o(360188);
    return localObject;
  }
  
  public final int getType()
  {
    return 6484;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/cgi/NetSceneFinderLiveLotteryHistory$Companion;", "", "()V", "TAG", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.cgi.be
 * JD-Core Version:    0.7.0.1
 */