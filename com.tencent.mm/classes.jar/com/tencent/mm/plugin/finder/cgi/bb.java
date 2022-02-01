package com.tencent.mm.plugin.finder.cgi;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.cgi.report.b;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.u;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderFollow;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "finderUser", "", "opType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "feedId", "", "(Ljava/lang/String;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;J)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getFeedId", "()J", "getFinderUser", "()Ljava/lang/String;", "getOpType", "()I", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "isEnableReport", "Lcom/tencent/mm/plugin/finder/cgi/report/EnableValue;", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class bb
  extends ax
{
  private static final String TAG = "Finder.NetSceneFinderFollow";
  private static final int tvb = 1;
  private static final int tvc = 2;
  private static final int tvd = 3;
  public static final a tve;
  private i callback;
  private final String dNc;
  private final long feedId;
  private final int opType;
  private d rr;
  
  static
  {
    AppMethodBeat.i(165213);
    tve = new a((byte)0);
    TAG = "Finder.NetSceneFinderFollow";
    tvb = 1;
    tvc = 2;
    tvd = 3;
    AppMethodBeat.o(165213);
  }
  
  public bb(String paramString, int paramInt, bbn parambbn, long paramLong)
  {
    super(parambbn);
    AppMethodBeat.i(242373);
    this.dNc = paramString;
    this.opType = paramInt;
    this.feedId = paramLong;
    paramString = new d.a();
    paramString.sG(getType());
    Object localObject1 = new arf();
    ((arf)localObject1).LCo = this.dNc;
    ((arf)localObject1).opType = this.opType;
    ((arf)localObject1).refObjectId = this.feedId;
    Object localObject2 = am.tuw;
    ((arf)localObject1).uli = am.a(parambbn);
    localObject2 = ((arf)localObject1).uli;
    if (localObject2 != null) {
      ((aov)localObject2).scene = parambbn.tyh;
    }
    localObject2 = k.vfA;
    paramLong = this.feedId;
    localObject2 = ((arf)localObject1).uli;
    if (localObject2 != null) {}
    for (paramInt = ((aov)localObject2).scene;; paramInt = 0)
    {
      ((arf)localObject1).sessionBuffer = k.G(paramLong, paramInt);
      ((arf)localObject1).vkj = parambbn.wyY;
      paramString.c((a)localObject1);
      localObject1 = new arg();
      ((arg)localObject1).setBaseResponse(new BaseResponse());
      paramString.d((a)localObject1);
      paramString.MB("/cgi-bin/micromsg-bin/finderfollow");
      paramString = paramString.aXF();
      p.g(paramString, "builder.buildInstance()");
      this.rr = paramString;
      Log.i(TAG, "NetSceneFinderFollow init " + this.dNc + " opType " + this.opType + " scene " + parambbn.tyh + " feedId " + this.feedId + " enterType" + parambbn.wyY);
      AppMethodBeat.o(242373);
      return;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(242372);
    Log.i(TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED)) {
        u.makeText(MMApplicationContext.getContext(), (CharSequence)("is debug info finderfollow: " + paramInt2 + ' ' + paramInt3), 1).show();
      }
      if (this.callback != null)
      {
        params = this.callback;
        if (params == null) {
          p.hyc();
        }
        params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      }
      AppMethodBeat.o(242372);
      return;
    }
    params = this.rr.aYK();
    if (params == null)
    {
      paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderFollowResponse");
      AppMethodBeat.o(242372);
      throw paramString;
    }
    Object localObject = ((arg)params).contact;
    if (localObject != null)
    {
      Log.i(TAG, "newContact.followFlag: " + ((FinderContact)localObject).followFlag);
      params = c.tsp;
      params = this.dNc;
      paramInt1 = ((FinderContact)localObject).followFlag;
    }
    for (;;)
    {
      c.a.du(params, paramInt1);
      break;
      params = c.tsp;
      params = this.dNc;
      if (this.opType == tvb)
      {
        localObject = com.tencent.mm.plugin.finder.api.g.tsD;
        paramInt1 = com.tencent.mm.plugin.finder.api.g.cXO();
      }
      else
      {
        localObject = com.tencent.mm.plugin.finder.api.g.tsD;
        paramInt1 = com.tencent.mm.plugin.finder.api.g.cXP();
      }
    }
  }
  
  public final b cXS()
  {
    return b.tye;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(165210);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(165210);
    return i;
  }
  
  public final int getType()
  {
    return 3867;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderFollow$Companion;", "", "()V", "OP_TYPE_FOLLOW", "", "getOP_TYPE_FOLLOW", "()I", "OP_TYPE_UNAPPLY", "getOP_TYPE_UNAPPLY", "OP_TYPE_UNFOLLOW", "getOP_TYPE_UNFOLLOW", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bb
 * JD-Core Version:    0.7.0.1
 */