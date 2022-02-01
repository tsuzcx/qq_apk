package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.axj;
import com.tencent.mm.protocal.protobuf.axk;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderFileDump;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/FinderFileDumpResponse;", "clientId", "", "remoteUrl", "appId", "paramsJson", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "TAG", "getAppId", "()Ljava/lang/String;", "getClientId", "getParamsJson", "getRemoteUrl", "request", "Lcom/tencent/mm/protocal/protobuf/FinderFileDumpRequest;", "initCommReqResp", "", "onCgiBack", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
  extends b<axk>
{
  private final String AyS;
  private final String AyT;
  private axj AyU;
  private final String TAG;
  private final String appId;
  private final String clientId;
  
  public o(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(336429);
    this.clientId = paramString1;
    this.AyS = paramString2;
    this.appId = paramString3;
    this.AyT = paramString4;
    this.TAG = "Finder.CgiFinderFileDump";
    paramString1 = new axj();
    paramString1.username = z.bAW();
    paramString1.clientId = this.clientId;
    paramString1.url = this.AyS;
    paramString1.ZIw = this.appId;
    paramString1.ZIx = this.AyT;
    paramString2 = ah.aiuX;
    this.AyU = paramString1;
    Log.i(this.TAG, s.X("CgiFinderFileDump clientId:", this.clientId));
    paramString1 = new c.a();
    paramString1.otE = ((a)this.AyU);
    paramString2 = new axk();
    paramString2.setBaseResponse(new kd());
    paramString2.getBaseResponse().akjO = new etl();
    paramString1.otF = ((a)paramString2);
    paramString1.uri = "/cgi-bin/micromsg-bin/finderfiledump";
    paramString1.funcId = 4659;
    c(paramString1.bEF());
    AppMethodBeat.o(336429);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.o
 * JD-Core Version:    0.7.0.1
 */