package com.tencent.mm.plugin.av;

import com.tencent.mm.plugin.appbrand.m.i;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webjsapi/JSAPI;", "T", "Lcom/tencent/mm/plugin/webjsapi/JSAPIContext;", "", "name", "", "context", "(Ljava/lang/String;Lcom/tencent/mm/plugin/webjsapi/JSAPIContext;)V", "TAG", "getTAG", "()Ljava/lang/String;", "getContext", "()Lcom/tencent/mm/plugin/webjsapi/JSAPIContext;", "Lcom/tencent/mm/plugin/webjsapi/JSAPIContext;", "getName", "attach", "", "jsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "webview-sdk_release"})
public abstract class a<T extends b>
{
  protected final T Pvj;
  final String TAG;
  private final String name;
  
  public a(String paramString, T paramT)
  {
    this.name = paramString;
    this.Pvj = paramT;
    this.TAG = ("MicroMsg.JSAPI." + getClass().getSimpleName() + ':' + this.Pvj.getClass().getSimpleName());
  }
  
  public final void h(i parami)
  {
    p.k(parami, "jsRuntime");
    parami.addJavascriptInterface(this, this.name);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.av.a
 * JD-Core Version:    0.7.0.1
 */