package com.tencent.mm.plugin.finder.cgi;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.f;
import com.tencent.mm.ae.f.a;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.findersdk.b;
import com.tencent.mm.protocal.protobuf.aqe;
import com.tencent.mm.protocal.protobuf.atd;
import com.tencent.mm.protocal.protobuf.ate;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.w;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderTopicFollow;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "topicId", "", "topicNonceId", "", "opType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JLjava/lang/String;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getOpType", "()I", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getTopicId", "()J", "getTopicNonceId", "()Ljava/lang/String;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class co
  extends com.tencent.mm.plugin.findersdk.b.g
{
  private static final String TAG = "Finder.NetSceneFinderTopicFollow";
  private static final int xaO = 1;
  private static final int xaP = 2;
  private static final int xaQ = 3;
  public static final a xeg;
  private com.tencent.mm.an.i callback;
  public final int opType;
  private com.tencent.mm.an.d rr;
  public final long xee;
  private final String xef;
  
  static
  {
    AppMethodBeat.i(273950);
    xeg = new a((byte)0);
    TAG = "Finder.NetSceneFinderTopicFollow";
    xaO = 1;
    xaP = 2;
    xaQ = 3;
    AppMethodBeat.o(273950);
  }
  
  public co(long paramLong, String paramString, int paramInt, bid parambid)
  {
    super(parambid);
    AppMethodBeat.i(273949);
    this.xee = paramLong;
    this.xef = paramString;
    this.opType = paramInt;
    paramString = new com.tencent.mm.an.d.a();
    paramString.vD(getType());
    Object localObject1 = new atd();
    ((atd)localObject1).fSo = this.opType;
    ((atd)localObject1).xee = this.xee;
    ((atd)localObject1).xef = this.xef;
    Object localObject2 = ao.xcj;
    ((atd)localObject1).SFL = ao.a(parambid);
    localObject2 = ((atd)localObject1).SFL;
    if (localObject2 != null) {
      ((aqe)localObject2).scene = parambid.fGo;
    }
    localObject2 = b.BuZ;
    if (parambid.fGo != 0) {}
    for (boolean bool = true;; bool = false)
    {
      f.a.a((f)localObject2, "NetSceneFinderFollow_contextObj", bool, false, null, 28);
      paramString.c((a)localObject1);
      localObject1 = new ate();
      ((ate)localObject1).setBaseResponse(new jh());
      paramString.d((a)localObject1);
      paramString.TW("/cgi-bin/micromsg-bin/finderfollowtopic");
      paramString = paramString.bgN();
      p.j(paramString, "builder.buildInstance()");
      this.rr = paramString;
      Log.i(TAG, "FinderTopicFollow init topicId:" + this.xee + " topicNonceId:" + this.xef + " opType " + this.opType + " scene " + parambid.fGo + "enterType" + parambid.BmQ);
      AppMethodBeat.o(273949);
      return;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(273948);
    Log.i(TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      if ((BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED)) {
        w.makeText(MMApplicationContext.getContext(), (CharSequence)("is debug info FinderTopicFollow: " + paramInt2 + ' ' + paramInt3), 1).show();
      }
    }
    for (;;)
    {
      if (this.callback != null)
      {
        params = this.callback;
        if (params == null) {
          p.iCn();
        }
        params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      }
      AppMethodBeat.o(273948);
      return;
      params = n.zWF;
      params = n.Mp(this.xee);
      Object localObject;
      if (this.opType == xaO)
      {
        localObject = com.tencent.mm.plugin.finder.api.d.wZQ;
        localObject = com.tencent.mm.plugin.finder.api.i.xai;
        com.tencent.mm.plugin.finder.api.d.a.dP(params, com.tencent.mm.plugin.finder.api.i.dny());
      }
      else if (this.opType == xaP)
      {
        localObject = com.tencent.mm.plugin.finder.api.d.wZQ;
        localObject = com.tencent.mm.plugin.finder.api.i.xai;
        com.tencent.mm.plugin.finder.api.d.a.dP(params, com.tencent.mm.plugin.finder.api.i.dnz());
      }
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.an.i parami)
  {
    AppMethodBeat.i(273947);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(273947);
    return i;
  }
  
  public final int getType()
  {
    return 3844;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderTopicFollow$Companion;", "", "()V", "OP_TYPE_FOLLOW", "", "getOP_TYPE_FOLLOW", "()I", "OP_TYPE_UNAPPLY", "getOP_TYPE_UNAPPLY", "OP_TYPE_UNFOLLOW", "getOP_TYPE_UNFOLLOW", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.co
 * JD-Core Version:    0.7.0.1
 */