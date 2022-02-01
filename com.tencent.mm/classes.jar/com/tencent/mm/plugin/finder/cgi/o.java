package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.u;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.ass;
import com.tencent.mm.protocal.protobuf.ast;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderUtils;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderUtilsResp;", "type", "", "url", "", "(ILjava/lang/String;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderUtilsReq;", "getType", "()I", "getUrl", "()Ljava/lang/String;", "onCgiBack", "", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class o
  extends w<ast>
{
  private final String TAG;
  private ass rIB;
  private final int type;
  private final String url;
  
  public o(String paramString)
  {
    super(null);
    AppMethodBeat.i(201072);
    this.type = 1;
    this.url = paramString;
    this.TAG = "Finder.CgiFinderUtils";
    this.rIB = new ass();
    paramString = this.rIB;
    Object localObject = v.rIR;
    paramString.Gle = v.a(this.rIl);
    this.rIB.username = u.aAu();
    this.rIB.type = this.type;
    this.rIB.url = this.url;
    paramString = new b.a();
    paramString.c((a)this.rIB);
    localObject = new ast();
    ((ast)localObject).setBaseResponse(new BaseResponse());
    ((ast)localObject).getBaseResponse().ErrMsg = new cwt();
    paramString.d((a)localObject);
    paramString.Dl("/cgi-bin/micromsg-bin/finderutils");
    paramString.oP(4046);
    c(paramString.aDC());
    ad.i(this.TAG, "init type:" + this.type + ", url:" + this.url);
    AppMethodBeat.o(201072);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.o
 * JD-Core Version:    0.7.0.1
 */