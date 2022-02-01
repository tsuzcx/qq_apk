package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.f.a;
import com.tencent.mm.an.d.a;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.upload.action.h;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.aqe;
import com.tencent.mm.protocal.protobuf.atb;
import com.tencent.mm.protocal.protobuf.atc;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.fgr;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.a.j;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderFollow;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderFollowResponse;", "action", "Lcom/tencent/mm/plugin/finder/upload/action/FollowAction;", "isFromTimeline", "", "isFromShareUI", "(Lcom/tencent/mm/plugin/finder/upload/action/FollowAction;ZZ)V", "TAG", "", "getAction", "()Lcom/tencent/mm/plugin/finder/upload/action/FollowAction;", "onCgiEnd", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class o
  extends c<atc>
{
  private static final int xaO = 1;
  private static final int xaP = 2;
  private static final int xaQ = 3;
  public static final a xaR;
  private final String TAG;
  private final h xaN;
  
  static
  {
    AppMethodBeat.i(264466);
    xaR = new a((byte)0);
    an localan = an.xci;
    xaO = an.dnL();
    localan = an.xci;
    xaP = an.dnM();
    localan = an.xci;
    xaQ = an.dnN();
    AppMethodBeat.o(264466);
  }
  
  public o(h paramh, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramh.xbu);
    AppMethodBeat.i(264465);
    this.xaN = paramh;
    this.TAG = "Finder.CgiFinderFollow";
    Object localObject2 = new atb();
    ((atb)localObject2).SFp = this.xaN.fGm;
    ((atb)localObject2).opType = this.xaN.opType;
    ((atb)localObject2).refObjectId = this.xaN.feedId;
    paramh = ao.xcj;
    ((atb)localObject2).yjp = ao.a(this.xbu);
    Object localObject3 = ((atb)localObject2).yjp;
    label168:
    int i;
    if (localObject3 != null)
    {
      if ((paramBoolean2) || (paramBoolean1)) {
        break label633;
      }
      paramh = this.xbu;
      if (paramh != null)
      {
        paramh = Integer.valueOf(paramh.fGo);
        ((aqe)localObject3).scene = paramh.intValue();
      }
    }
    else
    {
      paramh = com.tencent.mm.plugin.findersdk.b.BuZ;
      localObject3 = this.xbu;
      if ((localObject3 != null) && (((bid)localObject3).fGo == 0)) {
        break label658;
      }
      paramBoolean2 = true;
      f.a.a(paramh, "NetSceneFinderFollow_fromCommentScene_0", paramBoolean2, false, (kotlin.g.a.a)1.xaS, 12);
      paramh = n.zWF;
      long l = this.xaN.feedId;
      paramh = ((atb)localObject2).yjp;
      if (paramh == null) {
        break label663;
      }
      i = paramh.scene;
      label213:
      ((atb)localObject2).sessionBuffer = n.N(l, i);
      if (this.xaN.xbJ <= 0) {
        break label669;
      }
      i = this.xaN.xbJ;
      label244:
      ((atb)localObject2).xbJ = i;
      if (paramBoolean1) {
        ((atb)localObject2).xbJ = 21;
      }
      paramh = ao.xcj;
      paramh = ((atb)localObject2).yjp;
      localObject3 = ((atb)localObject2).yjp;
      i = j;
      if (localObject3 != null) {
        i = ((aqe)localObject3).scene;
      }
      ao.a(paramh, j.listOf(new kotlin.o(Integer.valueOf(i), Long.valueOf(this.xaN.feedId))));
      if (this.xaN.opType == xaO)
      {
        paramh = new fgr();
        paramh.UGO = new eae().dc(com.tencent.mm.plugin.normsg.a.d.GxJ.fjn());
        localObject3 = ((atb)localObject2).yjp;
        if (localObject3 != null) {
          ((aqe)localObject3).SDs = new com.tencent.mm.cd.b(paramh.toByteArray());
        }
        paramh = com.tencent.mm.plugin.secinforeport.a.d.Jcm;
        com.tencent.mm.plugin.secinforeport.a.d.asyncReportFinderSecurityInfoThroughCgi(540999688);
      }
      paramh = new d.a();
      paramh.c((com.tencent.mm.cd.a)localObject2);
      localObject2 = new atc();
      ((atc)localObject2).setBaseResponse(new jh());
      ((atc)localObject2).getBaseResponse().Tef = new eaf();
      paramh.d((com.tencent.mm.cd.a)localObject2);
      paramh.TW("/cgi-bin/micromsg-bin/finderfollow");
      paramh.vD(3867);
      c(paramh.bgN());
      localObject2 = this.TAG;
      localObject3 = new StringBuilder("CgiFinderFollow init, ").append(this.xaN.fGm).append(" opType ").append(this.xaN.opType).append(" scene ");
      paramh = this.xbu;
      if (paramh == null) {
        break label693;
      }
    }
    label658:
    label663:
    label669:
    label693:
    for (paramh = Integer.valueOf(paramh.fGo);; paramh = null)
    {
      localObject3 = ((StringBuilder)localObject3).append(paramh).append(" feedId ").append(this.xaN.feedId).append(" enterType");
      bid localbid = this.xbu;
      paramh = localObject1;
      if (localbid != null) {
        paramh = Integer.valueOf(localbid.BmQ);
      }
      Log.i((String)localObject2, paramh);
      AppMethodBeat.o(264465);
      return;
      paramh = null;
      break;
      label633:
      paramh = this.xbu;
      if (paramh != null)
      {
        paramh = Integer.valueOf(paramh.xkX);
        break;
      }
      paramh = null;
      break;
      paramBoolean2 = false;
      break label168;
      i = 0;
      break label213;
      paramh = this.xbu;
      if (paramh != null)
      {
        i = paramh.BmQ;
        break label244;
      }
      i = 0;
      break label244;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderFollow$Companion;", "", "()V", "OP_TYPE_FOLLOW", "", "getOP_TYPE_FOLLOW", "()I", "OP_TYPE_UNAPPLY", "getOP_TYPE_UNAPPLY", "OP_TYPE_UNFOLLOW", "getOP_TYPE_UNFOLLOW", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.o
 * JD-Core Version:    0.7.0.1
 */