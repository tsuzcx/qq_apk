package com.tencent.mm.plugin.finder.nearby.live.square.tab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.plugin.finder.viewmodel.b;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bad;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/square/tab/NetSceneFetchSquareTabs;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "scene", "", "byPass", "", "title", "encrypted_object_id", "object_nonce_id", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getByPass", "()Ljava/lang/String;", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getEncrypted_object_id", "getObject_nonce_id", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getScene", "()I", "getTitle", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveTabsResponse;", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends com.tencent.mm.plugin.findersdk.b.h
{
  private final String ELy;
  private final String EMd;
  private com.tencent.mm.am.h callback;
  private final String object_nonce_id;
  private com.tencent.mm.am.c rr;
  private final int scene;
  private final String title;
  
  public c(bui parambui, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    super(parambui);
    AppMethodBeat.i(341289);
    this.scene = paramInt;
    this.ELy = paramString1;
    this.title = paramString2;
    this.EMd = paramString3;
    this.object_nonce_id = paramString4;
    paramString1 = k.aeZF;
    paramString3 = ((b)k.cn(PluginFinder.class).q(b.class)).dUh();
    paramString1 = new c.a();
    paramString2 = new bac();
    paramString4 = bi.ABn;
    paramString2.YIY = bi.a(parambui);
    paramString2.longitude = ((Number)paramString3.bsC).floatValue();
    paramString2.latitude = ((Number)paramString3.bsD).floatValue();
    paramString2.scene = this.scene;
    paramString2.EIo = this.ELy;
    paramString2.EMd = this.EMd;
    paramString2.object_nonce_id = this.object_nonce_id;
    paramString2.title = this.title;
    parambui = ah.aiuX;
    paramString1.otE = ((a)paramString2);
    paramString1.otF = ((a)new bad());
    paramString1.uri = "/cgi-bin/micromsg-bin/findergetlivetabs";
    paramString1.funcId = 4210;
    this.rr = paramString1.bEF();
    AppMethodBeat.o(341289);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(341321);
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(341321);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(341302);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (m)this);
    AppMethodBeat.o(341302);
    return i;
  }
  
  public final bad eFE()
  {
    AppMethodBeat.i(341315);
    Object localObject = this.rr;
    kotlin.g.b.s.checkNotNull(localObject);
    localObject = c.c.b(((com.tencent.mm.am.c)localObject).otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetLiveTabsResponse");
      AppMethodBeat.o(341315);
      throw ((Throwable)localObject);
    }
    localObject = (bad)localObject;
    AppMethodBeat.o(341315);
    return localObject;
  }
  
  public final int getType()
  {
    return 4210;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.square.tab.c
 * JD-Core Version:    0.7.0.1
 */