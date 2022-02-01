package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.ckc;
import com.tencent.mm.protocal.protobuf.ckd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderPoiListStream;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "friendUsername", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getPullType", "()I", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getPoiInfoList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderBindPoiInfo;", "getRequestBuffer", "getResponseBuffer", "getType", "hasContinue", "", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class dd
  extends com.tencent.mm.plugin.findersdk.b.h
{
  public static final a ACX;
  private com.tencent.mm.am.h callback;
  public final int pullType;
  public c rr;
  
  static
  {
    AppMethodBeat.i(336579);
    ACX = new a((byte)0);
    AppMethodBeat.o(336579);
  }
  
  public dd(String paramString, com.tencent.mm.bx.b paramb, int paramInt, bui parambui)
  {
    super(parambui);
    AppMethodBeat.i(336574);
    this.pullType = paramInt;
    c.a locala = new c.a();
    locala.funcId = getType();
    ckc localckc = new ckc();
    bi localbi = bi.ABn;
    localckc.YIY = bi.a(parambui);
    localckc.ZEQ = paramb;
    localckc.YIZ = paramString;
    localckc.ZER = this.pullType;
    paramString = k.aeZF;
    paramString = ((com.tencent.mm.plugin.finder.viewmodel.b)k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.b.class)).dUh();
    localckc.longitude = ((Number)paramString.bsC).floatValue();
    localckc.latitude = ((Number)paramString.bsD).floatValue();
    locala.otE = ((a)localckc);
    locala.otF = ((a)new ckd());
    locala.uri = "/cgi-bin/micromsg-bin/getfinderpoilist";
    paramString = locala.bEF();
    kotlin.g.b.s.s(paramString, "builder.buildInstance()");
    this.rr = paramString;
    AppMethodBeat.o(336574);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(336595);
    Log.i("Finder.NetSceneFinderPoiListStream", "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(336595);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(336587);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (m)this);
    AppMethodBeat.o(336587);
    return i;
  }
  
  public final int getType()
  {
    return 6850;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderPoiListStream$Companion;", "", "()V", "PULL_TYPE_AUDITING", "", "PULL_TYPE_BINDING", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.dd
 * JD-Core Version:    0.7.0.1
 */