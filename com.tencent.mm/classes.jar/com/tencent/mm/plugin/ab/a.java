package com.tencent.mm.plugin.ab;

import com.tencent.mm.plugin.appbrand.m.i;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webjsapi/JSAPI;", "T", "Lcom/tencent/mm/plugin/webjsapi/JSAPIContext;", "", "name", "", "context", "(Ljava/lang/String;Lcom/tencent/mm/plugin/webjsapi/JSAPIContext;)V", "TAG", "getTAG", "()Ljava/lang/String;", "getContext", "()Lcom/tencent/mm/plugin/webjsapi/JSAPIContext;", "Lcom/tencent/mm/plugin/webjsapi/JSAPIContext;", "getName", "attach", "", "jsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "webview-sdk_release"})
public abstract class a<T extends b>
{
  protected final T IBa;
  final String TAG;
  private final String name;
  
  public a(String paramString, T paramT)
  {
    this.name = paramString;
    this.IBa = paramT;
    this.TAG = ("MicroMsg.JSAPI." + getClass().getSimpleName() + ':' + this.IBa.getClass().getSimpleName());
  }
  
  public final void f(i parami)
  {
    p.h(parami, "jsRuntime");
    parami.addJavascriptInterface(this, this.name);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ab.a
 * JD-Core Version:    0.7.0.1
 */