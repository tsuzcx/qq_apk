package com.tencent.mm.plugin.appbrand.permission.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.d;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/permission/jsauth/JsAuthExecuteContext;", "", "env", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "api", "", "args", "callbackId", "", "(Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;Ljava/lang/String;Ljava/lang/String;I)V", "getApi", "()Ljava/lang/String;", "getArgs", "getCallbackId", "()I", "getEnv", "()Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "toString", "luggage-wechat-full-sdk_release"})
public final class c
{
  private final int kmu;
  private final String lTz;
  final d mnP;
  final String mnQ;
  
  public c(d paramd, String paramString, byte paramByte)
  {
    this(paramd, paramString);
  }
  
  public c(d paramd, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(220991);
    this.mnP = paramd;
    this.mnQ = paramString1;
    this.lTz = paramString2;
    this.kmu = paramInt;
    AppMethodBeat.o(220991);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(220990);
    String str = "JsAuthExecuteContext(appId='" + this.mnP.getAppId() + "', api='" + this.mnQ + "', callbackId=" + this.kmu + ')';
    AppMethodBeat.o(220990);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.a.c
 * JD-Core Version:    0.7.0.1
 */