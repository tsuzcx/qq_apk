package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.beg;
import com.tencent.mm.protocal.protobuf.beh;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderUtils;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderUtilsResp;", "type", "", "url", "", "(ILjava/lang/String;)V", "TAG", "request", "Lcom/tencent/mm/protocal/protobuf/FinderUtilsReq;", "getType", "()I", "getUrl", "()Ljava/lang/String;", "onCgiEnd", "", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class ad
  extends an<beh>
{
  private final String TAG;
  private beg tud;
  private final int type;
  private final String url;
  
  public ad(String paramString)
  {
    super(null);
    AppMethodBeat.i(242296);
    this.type = 1;
    this.url = paramString;
    this.TAG = "Finder.CgiFinderUtils";
    this.tud = new beg();
    paramString = this.tud;
    Object localObject = am.tuw;
    paramString.LAI = am.a(this.ttO);
    this.tud.username = z.aUg();
    this.tud.type = this.type;
    this.tud.url = this.url;
    paramString = new d.a();
    paramString.c((a)this.tud);
    localObject = new beh();
    ((beh)localObject).setBaseResponse(new BaseResponse());
    ((beh)localObject).getBaseResponse().ErrMsg = new dqi();
    paramString.d((a)localObject);
    paramString.MB("/cgi-bin/micromsg-bin/finderutils");
    paramString.sG(4046);
    c(paramString.aXF());
    Log.i(this.TAG, "init type:" + this.type + ", url:" + this.url);
    AppMethodBeat.o(242296);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ad
 * JD-Core Version:    0.7.0.1
 */