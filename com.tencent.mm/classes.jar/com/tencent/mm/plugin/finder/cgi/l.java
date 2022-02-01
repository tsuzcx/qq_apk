package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.ato;
import com.tencent.mm.protocal.protobuf.atp;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetFeedRelList;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListResp;", "feedId", "", "nonceId", "", "relatedListScene", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JLjava/lang/String;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "getFeedId", "()J", "getNonceId", "()Ljava/lang/String;", "getRelatedListScene", "()I", "request", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListReq;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getFeedRelList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "onCgiEnd", "", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class l
  extends an<atp>
{
  private final String TAG;
  private final long feedId;
  private final String hwg;
  private d rr;
  private ato tta;
  private final int ttb;
  
  public l(long paramLong, String paramString, bbn parambbn)
  {
    super(parambbn);
    AppMethodBeat.i(242224);
    this.feedId = paramLong;
    this.hwg = paramString;
    this.ttb = 5;
    this.TAG = "Finder.CgiFinderGetFeedRelList";
    this.tta = new ato();
    paramString = this.tta;
    am localam = am.tuw;
    paramString.LAI = am.a(parambbn);
    this.tta.hFK = this.feedId;
    this.tta.objectNonceId = this.hwg;
    this.tta.scene = this.ttb;
    paramString = new d.a();
    paramString.c((a)this.tta);
    parambbn = new atp();
    parambbn.setBaseResponse(new BaseResponse());
    parambbn.getBaseResponse().ErrMsg = new dqi();
    paramString.d((a)parambbn);
    paramString.MB("/cgi-bin/micromsg-bin/findergetrelatedlist");
    paramString.sG(3688);
    paramString = paramString.aXF();
    p.g(paramString, "builder.buildInstance()");
    this.rr = paramString;
    c(this.rr);
    Log.i(this.TAG, "init feedId:" + this.feedId + ", relatedListScene:" + this.ttb);
    AppMethodBeat.o(242224);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.l
 * JD-Core Version:    0.7.0.1
 */