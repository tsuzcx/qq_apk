package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.asv;
import com.tencent.mm.protocal.protobuf.asw;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderFileDump;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/FinderFileDumpResponse;", "clientId", "", "remoteUrl", "appId", "paramsJson", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "TAG", "getAppId", "()Ljava/lang/String;", "getClientId", "getParamsJson", "getRemoteUrl", "request", "Lcom/tencent/mm/protocal/protobuf/FinderFileDumpRequest;", "initCommReqResp", "", "onCgiBack", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class n
  extends c<asw>
{
  private final String TAG;
  private final String appId;
  private final String clientId;
  private asv xaK;
  private final String xaL;
  private final String xaM;
  
  public n(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(275839);
    this.clientId = paramString1;
    this.xaL = paramString2;
    this.appId = paramString3;
    this.xaM = paramString4;
    this.TAG = "Finder.CgiFinderFileDump";
    paramString1 = new asv();
    paramString1.username = z.bdh();
    paramString1.clientId = this.clientId;
    paramString1.url = this.xaL;
    paramString1.SFX = this.appId;
    paramString1.SFY = this.xaM;
    this.xaK = paramString1;
    Log.i(this.TAG, "CgiFinderFileDump clientId:" + this.clientId);
    paramString1 = new d.a();
    paramString1.c((a)this.xaK);
    paramString2 = new asw();
    paramString2.setBaseResponse(new jh());
    paramString2.getBaseResponse().Tef = new eaf();
    paramString1.d((a)paramString2);
    paramString1.TW("/cgi-bin/micromsg-bin/finderfiledump");
    paramString1.vD(4659);
    c(paramString1.bgN());
    AppMethodBeat.o(275839);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.n
 * JD-Core Version:    0.7.0.1
 */