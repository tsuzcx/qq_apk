package com.tencent.mm.plugin.finder.cgi;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.e.a;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.g;
import com.tencent.mm.plugin.finder.api.d;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.findersdk.b;
import com.tencent.mm.protocal.protobuf.atz;
import com.tencent.mm.protocal.protobuf.axr;
import com.tencent.mm.protocal.protobuf.axs;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.aa;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderTopicFollow;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "topicId", "", "topicNonceId", "", "opType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JLjava/lang/String;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getOpType", "()I", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getTopicId", "()J", "getTopicNonceId", "()Ljava/lang/String;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class dp
  extends com.tencent.mm.plugin.findersdk.b.h
{
  public static final a ADn;
  private static final int AyX;
  private static final int AyY;
  private static final int AyZ;
  private static final String TAG;
  public final long ADo;
  private final String ADp;
  private com.tencent.mm.am.h callback;
  public final int opType;
  private c rr;
  
  static
  {
    AppMethodBeat.i(336897);
    ADn = new a((byte)0);
    TAG = "Finder.NetSceneFinderTopicFollow";
    AyX = 1;
    AyY = 2;
    AyZ = 3;
    AppMethodBeat.o(336897);
  }
  
  public dp(long paramLong, String paramString, int paramInt, bui parambui)
  {
    super(parambui);
    AppMethodBeat.i(336880);
    this.ADo = paramLong;
    this.ADp = paramString;
    this.opType = paramInt;
    paramString = new c.a();
    paramString.funcId = getType();
    Object localObject1 = new axr();
    ((axr)localObject1).hYl = this.opType;
    ((axr)localObject1).ADo = this.ADo;
    ((axr)localObject1).ADp = this.ADp;
    Object localObject2 = bi.ABn;
    ((axr)localObject1).ZHY = bi.a(parambui);
    localObject2 = ((axr)localObject1).ZHY;
    if (localObject2 != null) {
      ((atz)localObject2).scene = parambui.hLK;
    }
    localObject2 = (e)b.HbT;
    if (parambui.hLK != 0) {}
    for (boolean bool = true;; bool = false)
    {
      e.a.a((e)localObject2, "NetSceneFinderFollow_contextObj", bool, null, false, null, 60);
      paramString.otE = ((a)localObject1);
      localObject1 = new axs();
      ((axs)localObject1).setBaseResponse(new kd());
      paramString.otF = ((a)localObject1);
      paramString.uri = "/cgi-bin/micromsg-bin/finderfollowtopic";
      paramString = paramString.bEF();
      kotlin.g.b.s.s(paramString, "builder.buildInstance()");
      this.rr = paramString;
      Log.i(TAG, "FinderTopicFollow init topicId:" + this.ADo + " topicNonceId:" + this.ADp + " opType " + this.opType + " scene " + parambui.hLK + "enterType" + parambui.GST);
      AppMethodBeat.o(336880);
      return;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(336922);
    Log.i(TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      if ((BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED)) {
        aa.makeText(MMApplicationContext.getContext(), (CharSequence)("is debug info FinderTopicFollow: " + paramInt2 + ' ' + paramInt3), 1).show();
      }
    }
    for (;;)
    {
      if (this.callback != null)
      {
        params = this.callback;
        kotlin.g.b.s.checkNotNull(params);
        params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
      }
      AppMethodBeat.o(336922);
      return;
      params = z.FrZ;
      params = z.pL(this.ADo);
      Object localObject;
      if (this.opType == AyX)
      {
        localObject = d.AwY;
        localObject = com.tencent.mm.plugin.finder.api.m.Axk;
        d.a.et(params, com.tencent.mm.plugin.finder.api.m.dUG());
      }
      else if (this.opType == AyY)
      {
        localObject = d.AwY;
        localObject = com.tencent.mm.plugin.finder.api.m.Axk;
        d.a.et(params, com.tencent.mm.plugin.finder.api.m.dUH());
      }
    }
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(336905);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (com.tencent.mm.network.m)this);
    AppMethodBeat.o(336905);
    return i;
  }
  
  public final int getType()
  {
    return 3844;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderTopicFollow$Companion;", "", "()V", "OP_TYPE_FOLLOW", "", "getOP_TYPE_FOLLOW", "()I", "OP_TYPE_UNAPPLY", "getOP_TYPE_UNAPPLY", "OP_TYPE_UNFOLLOW", "getOP_TYPE_UNFOLLOW", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.dp
 * JD-Core Version:    0.7.0.1
 */