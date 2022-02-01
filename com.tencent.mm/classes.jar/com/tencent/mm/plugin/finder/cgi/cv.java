package com.tencent.mm.plugin.finder.cgi;

import android.arch.lifecycle.ViewModelProvider;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.cnk;
import com.tencent.mm.protocal.protobuf.cny;
import com.tencent.mm.protocal.protobuf.cnz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneMegaVideoGetRelatedList;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneMegaVideoBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "feedId", "", "nonceId", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "scene", "", "fromUserName", "toUserName", "sessionId", "sessionBuffer", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JLjava/lang/String;Lcom/tencent/mm/protobuf/ByteString;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getFeedId", "()J", "getFromUserName", "()Ljava/lang/String;", "getNonceId", "pullType", "getPullType", "()I", "setPullType", "(I)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getScene", "setScene", "getSessionBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getSessionId", "getToUserName", "buildStatsRequest", "", "request", "Lcom/tencent/mm/protocal/protobuf/MegaVideoGetRelatedListReq;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getContinueFlag", "getFeedList", "", "Lcom/tencent/mm/protocal/protobuf/FinderMegaVideo;", "getRespLastBuffer", "getTotalCount", "getType", "onCgiEnd", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class cv
  extends cr
  implements m
{
  public static final a twL;
  private i callback;
  private final String dJw;
  private final String dYs;
  private final long feedId;
  private final String hwg;
  public int pullType;
  private com.tencent.mm.ak.d rr;
  private int scene;
  private final String sessionId;
  private final b tvj;
  
  static
  {
    AppMethodBeat.i(242566);
    twL = new a((byte)0);
    AppMethodBeat.o(242566);
  }
  
  private cv(long paramLong, String paramString1, b paramb1, String paramString2, String paramString3, String paramString4, b paramb2, bbn parambbn)
  {
    AppMethodBeat.i(242564);
    this.feedId = paramLong;
    this.hwg = paramString1;
    this.scene = 1;
    this.dYs = paramString2;
    this.dJw = paramString3;
    this.sessionId = paramString4;
    this.tvj = paramb2;
    paramString1 = new cny();
    paramString2 = ap.tuF;
    paramString1.MtV = ap.b(parambbn);
    paramString1.twJ = this.feedId;
    paramString1.LOd = this.hwg;
    paramString2 = com.tencent.mm.ui.component.a.PRN;
    com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
    paramString2 = FinderGlobalLocationVM.dHP();
    paramString1.dTj = ((Number)paramString2.first).floatValue();
    paramString1.latitude = ((Number)paramString2.second).floatValue();
    paramString1.lastBuffer = paramb1;
    paramString1.dkU = this.dYs;
    paramString1.dkV = this.dJw;
    paramString1.scene = this.scene;
    paramString1.Muo = this.tvj;
    paramString2 = new cnk();
    paramString2.osName = com.tencent.mm.protocal.d.KyL;
    paramString2.osVersion = com.tencent.mm.protocal.d.KyM;
    paramString2.deviceBrand = com.tencent.mm.protocal.d.KyI;
    paramString2.deviceModel = com.tencent.mm.protocal.d.KyJ;
    paramString2.LBe = NetStatusUtil.getNetTypeString(MMApplicationContext.getContext());
    paramString3 = k.vfA;
    paramString2.netType = k.dod();
    paramString2.LBf = CdnLogic.getRecentAverageSpeed(2);
    paramString2.MtQ.add("h264");
    if (e.sX(4)) {
      paramString2.MtQ.add("h265");
    }
    paramString1.Mup = paramString2;
    paramString2 = new d.a();
    paramString2.MB("/cgi-bin/micromsg-bin/megavideogetrelatedlist");
    paramString2.sG(getType());
    paramString2.c((com.tencent.mm.bw.a)paramString1);
    paramString2.d((com.tencent.mm.bw.a)new cnz());
    paramString1 = paramString2.aXF();
    p.g(paramString1, "builder.buildInstance()");
    this.rr = paramString1;
    Log.i("NetSceneMegaVideoGetRelatedList", "NetSceneMegaVideoGetRelatedList lastBuffer ".concat(String.valueOf(paramb1)));
    AppMethodBeat.o(242564);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(242563);
    params = this.callback;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(242563);
      return;
    }
    AppMethodBeat.o(242563);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(242562);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(242562);
    return i;
  }
  
  public final int getType()
  {
    return 6432;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneMegaVideoGetRelatedList$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.cv
 * JD-Core Version:    0.7.0.1
 */