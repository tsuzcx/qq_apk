package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aow;
import com.tencent.mm.protocal.protobuf.aox;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetFeedRelList;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListResp;", "feedId", "", "nonceId", "", "relatedListScene", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JLjava/lang/String;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "getFeedId", "()J", "getNonceId", "()Ljava/lang/String;", "getRelatedListScene", "()I", "request", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getFeedRelList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "onCgiBack", "", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class f
  extends w<aox>
{
  private final String TAG;
  private final long duw;
  private aow rPY;
  private final String rPZ;
  private final int rQa;
  private b rr;
  
  public f(long paramLong, String paramString, arn paramarn)
  {
    super(paramarn);
    AppMethodBeat.i(201446);
    this.duw = paramLong;
    this.rPZ = paramString;
    this.rQa = 5;
    this.TAG = "Finder.CgiFinderGetFeedRelList";
    this.rPY = new aow();
    paramString = this.rPY;
    v localv = v.rRb;
    paramString.GEg = v.a(paramarn);
    this.rPY.rRn = this.duw;
    this.rPY.objectNonceId = this.rPZ;
    this.rPY.scene = this.rQa;
    paramString = new b.a();
    paramString.c((a)this.rPY);
    paramarn = new aox();
    paramarn.setBaseResponse(new BaseResponse());
    paramarn.getBaseResponse().ErrMsg = new cxn();
    paramString.d((a)paramarn);
    paramString.DN("/cgi-bin/micromsg-bin/findergetrelatedlist");
    paramString.oS(3688);
    paramString = paramString.aDS();
    p.g(paramString, "builder.buildInstance()");
    this.rr = paramString;
    c(this.rr);
    ae.i(this.TAG, "init feedId:" + this.duw + ", relatedListScene:" + this.rQa);
    AppMethodBeat.o(201446);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.f
 * JD-Core Version:    0.7.0.1
 */