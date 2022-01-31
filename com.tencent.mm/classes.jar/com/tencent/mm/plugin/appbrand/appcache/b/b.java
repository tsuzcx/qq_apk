package com.tencent.mm.plugin.appbrand.appcache.b;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a.a;
import com.tencent.mm.cm.f;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.plugin.appbrand.launching.h;
import com.tencent.mm.protocal.protobuf.bne;
import com.tencent.mm.protocal.protobuf.bnf;
import com.tencent.mm.protocal.protobuf.cjb;
import com.tencent.mm.vending.g.c.a;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/CgiPreDownloadCode;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/PreDownloadCodeResp;", "username", "", "(Ljava/lang/String;)V", "TAG", "getUsername", "()Ljava/lang/String;", "createSingleReqInfo", "Lcom/tencent/mm/protocal/protobuf/SyncVersionSingleReqInfo;", "run", "Lcom/tencent/mm/wx/WxPipeline;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "plugin-appbrand-integration_release"})
public final class b
  extends com.tencent.mm.ai.a<bnf>
{
  private final String TAG;
  private final String username;
  
  public b(String paramString)
  {
    AppMethodBeat.i(134471);
    this.username = paramString;
    this.TAG = "MicroMsg.AppBrand.CgiPreDownloadCode";
    com.tencent.mm.ai.b.a locala = new com.tencent.mm.ai.b.a();
    bne localbne = new bne();
    paramString = this.username;
    cjb localcjb = new cjb();
    localcjb.xTl = paramString;
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label222;
      }
      paramString = null;
      label92:
      if (paramString == null) {
        break label237;
      }
      localObject = paramString.ayE();
      if (localObject == null) {
        break label237;
      }
      i = ((WxaAttributes.WxaVersionInfo)localObject).bDc;
      label113:
      localcjb.xTm = i;
      if (paramString == null) {
        break label242;
      }
      paramString = paramString.field_appId;
      if (paramString == null) {
        break label242;
      }
      paramString = h.bl(paramString, 0);
      i = j;
      if (paramString == null) {}
    }
    label222:
    label237:
    label242:
    for (int i = paramString.gXf;; i = k)
    {
      localcjb.xTn = i;
      localbne.xBt = localcjb;
      locala.a((com.tencent.mm.bv.a)localbne);
      locala.b((com.tencent.mm.bv.a)new bnf());
      locala.rl("/cgi-bin/mmbiz-bin/wxasync/wxaapp_predownloadcode");
      locala.kT(1479);
      a(locala.ado());
      AppMethodBeat.o(134471);
      return;
      i = 0;
      break;
      paramString = com.tencent.mm.plugin.appbrand.app.g.auF().d(paramString, new String[0]);
      break label92;
      i = 0;
      break label113;
    }
  }
  
  public final f<a.a<bnf>> adl()
  {
    AppMethodBeat.i(134470);
    Object localObject = (CharSequence)this.username;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      localObject = com.tencent.mm.cm.g.c((c.a)new b.a(this));
      j.p(localObject, "pipelineExt {\n          …          )\n            }");
      AppMethodBeat.o(134470);
      return localObject;
    }
    localObject = super.adl();
    j.p(localObject, "super.run()");
    AppMethodBeat.o(134470);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.b
 * JD-Core Version:    0.7.0.1
 */