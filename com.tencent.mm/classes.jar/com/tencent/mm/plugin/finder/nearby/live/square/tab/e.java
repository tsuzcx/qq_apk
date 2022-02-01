package com.tencent.mm.plugin.finder.nearby.live.square.tab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.protocal.protobuf.ave;
import com.tencent.mm.protocal.protobuf.avf;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.ui.component.g.a;
import kotlin.l;
import kotlin.o;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/square/tab/NetSceneFetchSquareTabs;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "scene", "", "byPass", "", "title", "encrypted_object_id", "object_nonce_id", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getByPass", "()Ljava/lang/String;", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getEncrypted_object_id", "getObject_nonce_id", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getScene", "()I", "getTitle", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveTabsResponse;", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "plugin-finder-nearby_release"})
public final class e
  extends com.tencent.mm.plugin.findersdk.b.g
{
  private i callback;
  private final String object_nonce_id;
  d rr;
  private final int scene;
  private final String title;
  private final String zGJ;
  private final String zGK;
  
  public e(bid parambid, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    super(parambid);
    AppMethodBeat.i(200097);
    this.scene = paramInt;
    this.zGJ = paramString1;
    this.title = paramString2;
    this.zGK = paramString3;
    this.object_nonce_id = paramString4;
    paramString1 = com.tencent.mm.ui.component.g.Xox;
    paramString1 = ((com.tencent.mm.plugin.finder.viewmodel.a)com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.a.class)).dnl();
    paramString2 = new d.a();
    paramString3 = new ave();
    paramString4 = ao.xcj;
    paramString3.RLM = ao.a(parambid);
    paramString3.longitude = ((Number)paramString1.Mx).floatValue();
    paramString3.latitude = ((Number)paramString1.My).floatValue();
    paramString3.scene = this.scene;
    paramString3.zDZ = this.zGJ;
    paramString3.zGK = this.zGK;
    paramString3.object_nonce_id = this.object_nonce_id;
    paramString3.title = this.title;
    paramString2.c((com.tencent.mm.cd.a)paramString3);
    paramString2.d((com.tencent.mm.cd.a)new avf());
    paramString2.TW("/cgi-bin/micromsg-bin/findergetlivetabs");
    paramString2.vD(4210);
    this.rr = paramString2.bgN();
    AppMethodBeat.o(200097);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(200095);
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(200095);
      return;
    }
    AppMethodBeat.o(200095);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(200094);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(200094);
    return i;
  }
  
  public final int getType()
  {
    return 4210;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.square.tab.e
 * JD-Core Version:    0.7.0.1
 */