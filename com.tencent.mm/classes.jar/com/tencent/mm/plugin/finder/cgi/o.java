package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.ati;
import com.tencent.mm.protocal.protobuf.atj;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderUtils;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderUtilsResp;", "type", "", "url", "", "(ILjava/lang/String;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderUtilsReq;", "getType", "()I", "getUrl", "()Ljava/lang/String;", "onCgiBack", "", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class o
  extends w<atj>
{
  private final String TAG;
  private ati rQL;
  private final int type;
  private final String url;
  
  public o(String paramString)
  {
    super(null);
    AppMethodBeat.i(201490);
    this.type = 1;
    this.url = paramString;
    this.TAG = "Finder.CgiFinderUtils";
    this.rQL = new ati();
    paramString = this.rQL;
    Object localObject = v.rRb;
    paramString.GEg = v.a(this.rQw);
    this.rQL.username = com.tencent.mm.model.v.aAK();
    this.rQL.type = this.type;
    this.rQL.url = this.url;
    paramString = new b.a();
    paramString.c((a)this.rQL);
    localObject = new atj();
    ((atj)localObject).setBaseResponse(new BaseResponse());
    ((atj)localObject).getBaseResponse().ErrMsg = new cxn();
    paramString.d((a)localObject);
    paramString.DN("/cgi-bin/micromsg-bin/finderutils");
    paramString.oS(4046);
    c(paramString.aDS());
    ae.i(this.TAG, "init type:" + this.type + ", url:" + this.url);
    AppMethodBeat.o(201490);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.o
 * JD-Core Version:    0.7.0.1
 */