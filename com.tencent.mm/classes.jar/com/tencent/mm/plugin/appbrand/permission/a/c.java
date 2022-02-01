package com.tencent.mm.plugin.appbrand.permission.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/permission/jsauth/JsAuthExecuteContext;", "", "env", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "api", "", "args", "privateArgs", "callbackId", "", "(Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getApi", "()Ljava/lang/String;", "getArgs", "getCallbackId", "()I", "getEnv", "()Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "getPrivateArgs", "toString", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  final g rGz;
  private final int ror;
  final String tFV;
  final String tFW;
  private final String tgs;
  
  public c(g paramg, String paramString, byte paramByte)
  {
    this(paramg, paramString);
    AppMethodBeat.i(318828);
    AppMethodBeat.o(318828);
  }
  
  public c(g paramg, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(318816);
    this.rGz = paramg;
    this.tFV = paramString1;
    this.tgs = paramString2;
    this.tFW = paramString3;
    this.ror = paramInt;
    AppMethodBeat.o(318816);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(318832);
    StringBuilder localStringBuilder = new StringBuilder("JsAuthExecuteContext(appId='").append(this.rGz.getAppId()).append("', api='").append(this.tFV).append("', privateArgs='");
    String str2 = this.tFW;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    str1 = str1 + "', callbackId=" + this.ror + ')';
    AppMethodBeat.o(318832);
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.a.c
 * JD-Core Version:    0.7.0.1
 */