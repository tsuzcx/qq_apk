package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.report.d;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.plugin.finder.upload.action.f;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aiu;
import com.tencent.mm.protocal.protobuf.alp;
import com.tencent.mm.protocal.protobuf.alq;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLikeFeed;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeResponse;", "action", "Lcom/tencent/mm/plugin/finder/upload/action/LikeAction;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/upload/action/LikeAction;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getAction", "()Lcom/tencent/mm/plugin/finder/upload/action/LikeAction;", "likeId", "", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLikeRequest;", "initCommReqResp", "", "onCgiBack", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class h
  extends r<alq>
{
  private static long qWM;
  public static final a qXa;
  private final String TAG;
  private long qWK;
  private alp qWV;
  private final f qWZ;
  
  static
  {
    AppMethodBeat.i(165171);
    qXa = new a((byte)0);
    AppMethodBeat.o(165171);
  }
  
  public h(f paramf, anm paramanm)
  {
    super(paramanm);
    AppMethodBeat.i(201109);
    this.qWZ = paramf;
    this.TAG = "Finder.CgiFinderLikeFeed";
    this.qWK = ce.azI();
    long l;
    if (this.qWK < qWM)
    {
      l = qWM;
      qWM = 1L + l;
      this.qWK = l;
    }
    qWM = this.qWK;
    this.qWV = new alp();
    paramf = this.qWV;
    Object localObject = b.rCU;
    if (b.cyx())
    {
      l = 0L;
      paramf.qXP = l;
      this.qWV.objectNonceId = this.qWZ.objectNonceId;
      this.qWV.qWK = this.qWK;
      this.qWV.username = u.axE();
      this.qWV.scene = this.qWZ.scene;
      paramf = this.qWV;
      if (!this.qWZ.rNX) {
        break label528;
      }
    }
    label528:
    for (int i = 3;; i = 4)
    {
      paramf.opType = i;
      paramf = this.qWV;
      localObject = q.qXH;
      paramf.EDL = q.a(paramanm);
      paramf = this.qWV;
      paramanm = d.rxr;
      paramf.sessionBuffer = d.G(this.qWZ.dig, this.qWV.EDL.scene);
      ac.i(this.TAG, "likeId:" + this.qWK + " objectId:" + this.qWV.qXP + " opType:" + this.qWV.opType + " likeId:" + this.qWV.qWK + " username:" + this.qWV.username + " action:" + this.qWZ.rNX);
      paramf = new b.a();
      paramf.c((a)this.qWV);
      paramanm = new alq();
      paramanm.setBaseResponse(new BaseResponse());
      paramanm.getBaseResponse().ErrMsg = new crm();
      paramf.d((a)paramanm);
      paramf.Am("/cgi-bin/micromsg-bin/finderlike");
      paramf.op(3710);
      c(paramf.aAz());
      ac.i(this.TAG, "likeId:" + this.qWK + " CgiFinderLikeComment init " + this.qWV.qXP + " and userName " + this.qWZ.rNG.getUserName() + " nickname " + this.qWZ.rNG.getNickName() + " totalCount:" + this.qWZ.rNG.getLikeCount());
      AppMethodBeat.o(201109);
      return;
      l = this.qWZ.dig;
      break;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLikeFeed$Companion;", "", "()V", "GlobalLikeFeedId", "", "getGlobalLikeFeedId", "()J", "setGlobalLikeFeedId", "(J)V", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.h
 * JD-Core Version:    0.7.0.1
 */