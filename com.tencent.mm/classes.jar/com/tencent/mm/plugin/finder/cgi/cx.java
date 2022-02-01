package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.atz;
import com.tencent.mm.protocal.protobuf.bpr;
import com.tencent.mm.protocal.protobuf.bps;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderModEvent;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "scene", "", "eventTopicId", "", "finderUserName", "", "objectId", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILjava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getObjectId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getScene", "()I", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class cx
  extends com.tencent.mm.plugin.findersdk.b.h
{
  public static final a ACO;
  public final Long ACP;
  private com.tencent.mm.am.h callback;
  private c rr;
  public final int scene;
  
  static
  {
    AppMethodBeat.i(336591);
    ACO = new a((byte)0);
    AppMethodBeat.o(336591);
  }
  
  public cx(int paramInt, Long paramLong1, String paramString, Long paramLong2, bui parambui)
  {
    super(parambui);
    AppMethodBeat.i(336586);
    this.scene = paramInt;
    this.ACP = paramLong2;
    c.a locala = new c.a();
    locala.funcId = getType();
    bpr localbpr = new bpr();
    if (paramLong1 != null) {
      localbpr.ZXX = ((Number)paramLong1).longValue();
    }
    localbpr.YIZ = paramString;
    paramLong2 = this.ACP;
    if (paramLong2 != null) {
      localbpr.object_id = ((Number)paramLong2).longValue();
    }
    localbpr.scene = this.scene;
    paramLong2 = bi.ABn;
    localbpr.YIY = bi.a(parambui);
    atz localatz = localbpr.YIY;
    if (localatz != null) {
      if (parambui != null) {
        break label266;
      }
    }
    label266:
    for (paramLong2 = null;; paramLong2 = Integer.valueOf(parambui.hLK))
    {
      localatz.scene = paramLong2.intValue();
      locala.otE = ((a)localbpr);
      paramLong2 = new bps();
      paramLong2.setBaseResponse(new kd());
      locala.otF = ((a)paramLong2);
      locala.uri = "/cgi-bin/micromsg-bin/findermodevent";
      paramLong2 = locala.bEF();
      kotlin.g.b.s.s(paramLong2, "builder.buildInstance()");
      this.rr = paramLong2;
      Log.i("Finder.NetSceneFinderModEvent", "NetSceneFinderModEvent init eventTopicId: " + paramLong1 + " userName: " + paramString + ", objectId:" + this.ACP);
      AppMethodBeat.o(336586);
      return;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(336607);
    Log.i("Finder.NetSceneFinderModEvent", "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if (this.callback != null)
    {
      params = this.callback;
      kotlin.g.b.s.checkNotNull(params);
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(336607);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(336598);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (m)this);
    AppMethodBeat.o(336598);
    return i;
  }
  
  public final int getType()
  {
    return 5909;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderModEvent$Companion;", "", "()V", "CANCEL_PIN_FEED_TOP_SCENE", "", "DELETE_SCENE", "PIN_FEED_TOP_SCENE", "REMOVE_SCENE", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.cx
 * JD-Core Version:    0.7.0.1
 */