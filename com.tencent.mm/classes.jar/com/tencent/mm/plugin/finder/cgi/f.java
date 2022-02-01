package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aoj;
import com.tencent.mm.protocal.protobuf.aok;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetFeedRelList;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListResp;", "feedId", "", "nonceId", "", "relatedListScene", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JLjava/lang/String;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "getFeedId", "()J", "getNonceId", "()Ljava/lang/String;", "getRelatedListScene", "()I", "request", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getFeedRelList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "onCgiBack", "", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class f
  extends w<aok>
{
  private final String TAG;
  private final long dtq;
  private aoj rHN;
  private final String rHO;
  private final int rHP;
  private b rr;
  
  public f(long paramLong, String paramString, aqy paramaqy)
  {
    super(paramaqy);
    AppMethodBeat.i(201024);
    this.dtq = paramLong;
    this.rHO = paramString;
    this.rHP = 5;
    this.TAG = "Finder.CgiFinderGetFeedRelList";
    this.rHN = new aoj();
    paramString = this.rHN;
    v localv = v.rIR;
    paramString.Gle = v.a(paramaqy);
    this.rHN.rIZ = this.dtq;
    this.rHN.objectNonceId = this.rHO;
    this.rHN.scene = this.rHP;
    paramString = new b.a();
    paramString.c((a)this.rHN);
    paramaqy = new aok();
    paramaqy.setBaseResponse(new BaseResponse());
    paramaqy.getBaseResponse().ErrMsg = new cwt();
    paramString.d((a)paramaqy);
    paramString.Dl("/cgi-bin/micromsg-bin/findergetrelatedlist");
    paramString.oP(3688);
    paramString = paramString.aDC();
    p.g(paramString, "builder.buildInstance()");
    this.rr = paramString;
    c(this.rr);
    ad.i(this.TAG, "init feedId:" + this.dtq + ", relatedListScene:" + this.rHP);
    AppMethodBeat.o(201024);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.f
 * JD-Core Version:    0.7.0.1
 */