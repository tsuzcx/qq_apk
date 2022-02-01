package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.e.a;
import com.tencent.mm.am.c.a;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.upload.action.h;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.atz;
import com.tencent.mm.protocal.protobuf.axp;
import com.tencent.mm.protocal.protobuf.axq;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.gdd;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.u;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderFollow;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderFollowResponse;", "action", "Lcom/tencent/mm/plugin/finder/upload/action/FollowAction;", "isFromTimeline", "", "isFromShareUI", "(Lcom/tencent/mm/plugin/finder/upload/action/FollowAction;ZZ)V", "TAG", "", "getAction", "()Lcom/tencent/mm/plugin/finder/upload/action/FollowAction;", "onCgiEnd", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p
  extends c<axq>
{
  public static final a AyV;
  private static final int AyX;
  private static final int AyY;
  private static final int AyZ;
  private final h AyW;
  private final String TAG;
  
  static
  {
    AppMethodBeat.i(336468);
    AyV = new a((byte)0);
    bh localbh = bh.ABm;
    AyX = bh.dVr();
    localbh = bh.ABm;
    AyY = bh.dVs();
    localbh = bh.ABm;
    AyZ = bh.dVt();
    AppMethodBeat.o(336468);
  }
  
  public p(h paramh, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramh.Auc);
    AppMethodBeat.i(336447);
    this.AyW = paramh;
    this.TAG = "Finder.CgiFinderFollow";
    axp localaxp = new axp();
    localaxp.ZHf = this.AyW.hLI;
    int i;
    Object localObject2;
    label169:
    label207:
    label215:
    label345:
    StringBuilder localStringBuilder;
    if (((CharSequence)this.AyW.Gdc).length() > 0)
    {
      i = 1;
      if (i != 0) {
        localaxp.finderUsername = this.AyW.Gdc;
      }
      localaxp.opType = this.AyW.opType;
      localaxp.refObjectId = this.AyW.feedId;
      paramh = bi.ABn;
      localaxp.CJv = bi.a(this.Auc);
      localObject2 = localaxp.CJv;
      if (localObject2 != null)
      {
        if ((paramBoolean2) || (paramBoolean1)) {
          break label719;
        }
        paramh = this.Auc;
        if (paramh != null) {
          break label708;
        }
        paramh = null;
        ((atz)localObject2).scene = paramh.intValue();
      }
      paramh = (e)com.tencent.mm.plugin.findersdk.b.HbT;
      localObject2 = this.Auc;
      if ((localObject2 == null) || (((bui)localObject2).hLK != 0)) {
        break label744;
      }
      i = 1;
      if (i != 0) {
        break label750;
      }
      paramBoolean2 = bool;
      e.a.a(paramh, "NetSceneFinderFollow_fromCommentScene_0", paramBoolean2, null, false, (kotlin.g.a.a)1.Aza, 28);
      paramh = z.FrZ;
      long l = this.AyW.feedId;
      paramh = localaxp.CJv;
      if (paramh != null) {
        break label755;
      }
      i = 0;
      label258:
      localaxp.sessionBuffer = z.p(l, i);
      if (this.AyW.ACR <= 0) {
        break label764;
      }
      i = this.AyW.ACR;
      label289:
      localaxp.ACR = i;
      if (paramBoolean1) {
        localaxp.ACR = 21;
      }
      localaxp.ZIR = this.AyW.Gdd;
      paramh = bi.ABn;
      paramh = localaxp.CJv;
      localObject2 = localaxp.CJv;
      if (localObject2 != null) {
        break label788;
      }
      i = j;
      bi.a(paramh, kotlin.a.p.listOf(new r(Integer.valueOf(i), Long.valueOf(this.AyW.feedId))), this.Auc);
      if (this.AyW.opType == AyX)
      {
        paramh = new gdd();
        paramh.acaW = new gol().df(com.tencent.mm.plugin.normsg.a.d.MtP.aQo("ce_feed_follow"));
        paramh.acaX = new gol().df(com.tencent.mm.plugin.normsg.a.d.MtP.gtE());
        localObject2 = localaxp.CJv;
        if (localObject2 != null) {
          ((atz)localObject2).ZEq = new com.tencent.mm.bx.b(paramh.toByteArray());
        }
        paramh = com.tencent.mm.plugin.secinforeport.a.d.Pmb;
        com.tencent.mm.plugin.secinforeport.a.d.asyncReportFinderSecurityInfoThroughCgi(540999688);
      }
      paramh = new c.a();
      paramh.otE = ((com.tencent.mm.bx.a)localaxp);
      localObject2 = new axq();
      ((axq)localObject2).setBaseResponse(new kd());
      ((axq)localObject2).getBaseResponse().akjO = new etl();
      paramh.otF = ((com.tencent.mm.bx.a)localObject2);
      paramh.uri = "/cgi-bin/micromsg-bin/finderfollow";
      paramh.funcId = 3867;
      c(paramh.bEF());
      localObject2 = this.TAG;
      localStringBuilder = new StringBuilder("CgiFinderFollow init, ").append(this.AyW.hLI).append(" opType ").append(this.AyW.opType).append(" scene ");
      paramh = this.Auc;
      if (paramh != null) {
        break label798;
      }
      paramh = null;
      label626:
      localStringBuilder = localStringBuilder.append(paramh).append(" feedId ").append(this.AyW.feedId).append(" enterType");
      paramh = this.Auc;
      if (paramh != null) {
        break label809;
      }
    }
    label788:
    label798:
    label809:
    for (paramh = localObject1;; paramh = Integer.valueOf(paramh.GST))
    {
      Log.i((String)localObject2, paramh + " finderUsername:" + localaxp.finderUsername);
      AppMethodBeat.o(336447);
      return;
      i = 0;
      break;
      label708:
      paramh = Integer.valueOf(paramh.hLK);
      break label169;
      label719:
      paramh = this.Auc;
      if (paramh == null)
      {
        paramh = null;
        break label169;
      }
      paramh = Integer.valueOf(paramh.AJo);
      break label169;
      label744:
      i = 0;
      break label207;
      label750:
      paramBoolean2 = false;
      break label215;
      label755:
      i = paramh.scene;
      break label258;
      label764:
      paramh = this.Auc;
      if (paramh == null)
      {
        i = 0;
        break label289;
      }
      i = paramh.GST;
      break label289;
      i = ((atz)localObject2).scene;
      break label345;
      paramh = Integer.valueOf(paramh.hLK);
      break label626;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderFollow$Companion;", "", "()V", "OP_TYPE_FOLLOW", "", "getOP_TYPE_FOLLOW", "()I", "OP_TYPE_UNAPPLY", "getOP_TYPE_UNAPPLY", "OP_TYPE_UNFOLLOW", "getOP_TYPE_UNFOLLOW", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.p
 * JD-Core Version:    0.7.0.1
 */