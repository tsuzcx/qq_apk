package com.tencent.mm.plugin.appbrand.permission.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.d;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/permission/jsauth/JsAuthExecuteContext;", "", "env", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "api", "", "args", "callbackId", "", "(Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;Ljava/lang/String;Ljava/lang/String;I)V", "getApi", "()Ljava/lang/String;", "getArgs", "getCallbackId", "()I", "getEnv", "()Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "toString", "luggage-wechat-full-sdk_release"})
public final class c
{
  private final int kje;
  private final String lOY;
  final d miS;
  final String miT;
  
  public c(d paramd, String paramString, byte paramByte)
  {
    this(paramd, paramString);
  }
  
  public c(d paramd, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(192378);
    this.miS = paramd;
    this.miT = paramString1;
    this.lOY = paramString2;
    this.kje = paramInt;
    AppMethodBeat.o(192378);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(192377);
    String str = "JsAuthExecuteContext(appId='" + this.miS.getAppId() + "', api='" + this.miT + "', callbackId=" + this.kje + ')';
    AppMethodBeat.o(192377);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.a.c
 * JD-Core Version:    0.7.0.1
 */