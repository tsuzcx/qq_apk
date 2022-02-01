package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.protocal.protobuf.ayv;
import com.tencent.mm.protocal.protobuf.ayw;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderModEvent;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "scene", "", "eventTopicId", "", "finderUserName", "", "objectId", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILjava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getObjectId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getScene", "()I", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class bw
  extends ax
{
  public static final a tvK;
  private i callback;
  private d rr;
  public final int scene;
  public final Long tvJ;
  
  static
  {
    AppMethodBeat.i(242480);
    tvK = new a((byte)0);
    AppMethodBeat.o(242480);
  }
  
  public bw(int paramInt, Long paramLong1, String paramString, Long paramLong2, bbn parambbn)
  {
    super(parambbn);
    AppMethodBeat.i(242479);
    this.scene = paramInt;
    this.tvJ = paramLong2;
    d.a locala = new d.a();
    locala.sG(getType());
    ayv localayv = new ayv();
    if (paramLong1 != null) {
      localayv.LIT = ((Number)paramLong1).longValue();
    }
    localayv.LAt = paramString;
    paramLong2 = this.tvJ;
    if (paramLong2 != null) {
      localayv.object_id = ((Number)paramLong2).longValue();
    }
    localayv.scene = this.scene;
    paramLong2 = am.tuw;
    localayv.LBM = am.a(parambbn);
    aov localaov = localayv.LBM;
    if (localaov != null) {
      if (parambbn == null) {
        break label273;
      }
    }
    label273:
    for (paramLong2 = Integer.valueOf(parambbn.tyh);; paramLong2 = null)
    {
      localaov.scene = paramLong2.intValue();
      locala.c((a)localayv);
      paramLong2 = new ayw();
      paramLong2.setBaseResponse(new BaseResponse());
      locala.d((a)paramLong2);
      locala.MB("/cgi-bin/micromsg-bin/findermodevent");
      paramLong2 = locala.aXF();
      p.g(paramLong2, "builder.buildInstance()");
      this.rr = paramLong2;
      Log.i("Finder.NetSceneFinderModEvent", "NetSceneFinderModEvent init eventTopicId: " + paramLong1 + " userName: " + paramString + ", objectId:" + this.tvJ);
      AppMethodBeat.o(242479);
      return;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(242478);
    params = bb.tve;
    Log.i(bb.access$getTAG$cp(), "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if (this.callback != null)
    {
      params = this.callback;
      if (params == null) {
        p.hyc();
      }
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
    }
    AppMethodBeat.o(242478);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(242477);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(242477);
    return i;
  }
  
  public final int getType()
  {
    return 5909;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderModEvent$Companion;", "", "()V", "CANCEL_PIN_FEED_TOP_SCENE", "", "DELETE_SCENE", "PIN_FEED_TOP_SCENE", "REMOVE_SCENE", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bw
 * JD-Core Version:    0.7.0.1
 */