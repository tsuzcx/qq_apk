package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aqz;
import com.tencent.mm.protocal.protobuf.ara;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderFileDump;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/FinderFileDumpResponse;", "clientId", "", "remoteUrl", "appId", "paramsJson", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "TAG", "getAppId", "()Ljava/lang/String;", "getClientId", "getParamsJson", "getRemoteUrl", "request", "Lcom/tencent/mm/protocal/protobuf/FinderFileDumpRequest;", "initCommReqResp", "", "onCgiBack", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class j
  extends c<ara>
{
  private final String TAG;
  private final String appId;
  private final String clientId;
  private aqz tsV;
  private final String tsW;
  private final String tsX;
  
  public j(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(242218);
    this.clientId = paramString1;
    this.tsW = paramString2;
    this.appId = paramString3;
    this.tsX = paramString4;
    this.TAG = "Finder.CgiFinderFileDump";
    paramString1 = new aqz();
    paramString1.username = z.aUg();
    paramString1.clientId = this.clientId;
    paramString1.url = this.tsW;
    paramString1.LCL = this.appId;
    paramString1.LCM = this.tsX;
    this.tsV = paramString1;
    Log.i(this.TAG, "CgiFinderFileDump clientId:" + this.clientId);
    paramString1 = new d.a();
    paramString1.c((a)this.tsV);
    paramString2 = new ara();
    paramString2.setBaseResponse(new BaseResponse());
    paramString2.getBaseResponse().ErrMsg = new dqi();
    paramString1.d((a)paramString2);
    paramString1.MB("/cgi-bin/micromsg-bin/finderfiledump");
    paramString1.sG(4659);
    c(paramString1.aXF());
    AppMethodBeat.o(242218);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.j
 * JD-Core Version:    0.7.0.1
 */