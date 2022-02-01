package com.tencent.mm.plugin.appbrand.permission.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/permission/jsauth/JsAuthExecuteContext;", "", "env", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "api", "", "args", "callbackId", "", "(Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;Ljava/lang/String;Ljava/lang/String;I)V", "getApi", "()Ljava/lang/String;", "getArgs", "getCallbackId", "()I", "getEnv", "()Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "toString", "luggage-wechat-full-sdk_release"})
public final class c
{
  final g oDq;
  private final int okO;
  final String qAN;
  private final String qbr;
  
  public c(g paramg, String paramString, byte paramByte)
  {
    this(paramg, paramString);
  }
  
  public c(g paramg, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(246255);
    this.oDq = paramg;
    this.qAN = paramString1;
    this.qbr = paramString2;
    this.okO = paramInt;
    AppMethodBeat.o(246255);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(246253);
    String str = "JsAuthExecuteContext(appId='" + this.oDq.getAppId() + "', api='" + this.qAN + "', callbackId=" + this.okO + ')';
    AppMethodBeat.o(246253);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.a.c
 * JD-Core Version:    0.7.0.1
 */