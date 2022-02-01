package com.tencent.mm.plugin.appbrand.permission.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.d;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/permission/jsauth/JsAuthExecuteContext;", "", "env", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "api", "", "args", "callbackId", "", "(Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;Ljava/lang/String;Ljava/lang/String;I)V", "getApi", "()Ljava/lang/String;", "getArgs", "getCallbackId", "()I", "getEnv", "()Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "toString", "luggage-wechat-full-sdk_release"})
public final class c
{
  private final int lqe;
  private final String nbc;
  final d nyB;
  final String nyC;
  
  public c(d paramd, String paramString, byte paramByte)
  {
    this(paramd, paramString);
  }
  
  public c(d paramd, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(230131);
    this.nyB = paramd;
    this.nyC = paramString1;
    this.nbc = paramString2;
    this.lqe = paramInt;
    AppMethodBeat.o(230131);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(230130);
    String str = "JsAuthExecuteContext(appId='" + this.nyB.getAppId() + "', api='" + this.nyC + "', callbackId=" + this.lqe + ')';
    AppMethodBeat.o(230130);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.a.c
 * JD-Core Version:    0.7.0.1
 */