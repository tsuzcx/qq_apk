package com.tencent.mm.plugin.finder.cgi;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.f;
import com.tencent.mm.ac.f.a;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.protocal.protobuf.arh;
import com.tencent.mm.protocal.protobuf.ari;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.u;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderTopicFollow;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "topicId", "", "topicNonceId", "", "opType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JLjava/lang/String;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getOpType", "()I", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getTopicId", "()J", "getTopicNonceId", "()Ljava/lang/String;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class ck
  extends ax
{
  private static final String TAG = "Finder.NetSceneFinderFollow";
  private static final int tvb = 1;
  private static final int tvc = 2;
  private static final int tvd = 3;
  public static final a twr;
  private i callback;
  public final int opType;
  private d rr;
  public final long twp;
  private final String twq;
  
  static
  {
    AppMethodBeat.i(242518);
    twr = new a((byte)0);
    TAG = "Finder.NetSceneFinderFollow";
    tvb = 1;
    tvc = 2;
    tvd = 3;
    AppMethodBeat.o(242518);
  }
  
  public ck(long paramLong, String paramString, int paramInt, bbn parambbn)
  {
    super(parambbn);
    AppMethodBeat.i(242517);
    this.twp = paramLong;
    this.twq = paramString;
    this.opType = paramInt;
    paramString = new d.a();
    paramString.sG(getType());
    Object localObject1 = new arh();
    ((arh)localObject1).dYx = this.opType;
    ((arh)localObject1).twp = this.twp;
    ((arh)localObject1).twq = this.twq;
    Object localObject2 = am.tuw;
    ((arh)localObject1).LCA = am.a(parambbn);
    localObject2 = ((arh)localObject1).LCA;
    if (localObject2 != null) {
      ((aov)localObject2).scene = parambbn.tyh;
    }
    localObject2 = com.tencent.mm.plugin.finder.utils.c.vVc;
    if (parambbn.tyh != 0) {}
    for (boolean bool = true;; bool = false)
    {
      f.a.a((f)localObject2, "NetSceneFinderFollow_contextObj", bool, false, null, 28);
      paramString.c((a)localObject1);
      localObject1 = new ari();
      ((ari)localObject1).setBaseResponse(new BaseResponse());
      paramString.d((a)localObject1);
      paramString.MB("/cgi-bin/micromsg-bin/finderfollowtopic");
      paramString = paramString.aXF();
      p.g(paramString, "builder.buildInstance()");
      this.rr = paramString;
      paramString = bb.tve;
      Log.i(bb.access$getTAG$cp(), "FinderTopicFollow init topicId:" + this.twp + " topicNonceId:" + this.twq + " opType " + this.opType + " scene " + parambbn.tyh + "enterType" + parambbn.wyY);
      AppMethodBeat.o(242517);
      return;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(242516);
    Log.i(TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      if ((BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED)) {
        u.makeText(MMApplicationContext.getContext(), (CharSequence)("is debug info FinderTopicFollow: " + paramInt2 + ' ' + paramInt3), 1).show();
      }
    }
    for (;;)
    {
      if (this.callback != null)
      {
        params = this.callback;
        if (params == null) {
          p.hyc();
        }
        params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      }
      AppMethodBeat.o(242516);
      return;
      params = k.vfA;
      params = k.Fg(this.twp);
      Object localObject;
      if (this.opType == tvb)
      {
        localObject = com.tencent.mm.plugin.finder.api.c.tsp;
        localObject = com.tencent.mm.plugin.finder.api.g.tsD;
        c.a.du(params, com.tencent.mm.plugin.finder.api.g.cXO());
      }
      else if (this.opType == tvc)
      {
        localObject = com.tencent.mm.plugin.finder.api.c.tsp;
        localObject = com.tencent.mm.plugin.finder.api.g.tsD;
        c.a.du(params, com.tencent.mm.plugin.finder.api.g.cXP());
      }
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(242515);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(242515);
    return i;
  }
  
  public final int getType()
  {
    return 3844;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderTopicFollow$Companion;", "", "()V", "OP_TYPE_FOLLOW", "", "getOP_TYPE_FOLLOW", "()I", "OP_TYPE_UNAPPLY", "getOP_TYPE_UNAPPLY", "OP_TYPE_UNFOLLOW", "getOP_TYPE_UNFOLLOW", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ck
 * JD-Core Version:    0.7.0.1
 */