package com.tencent.mm.plugin.ax;

import com.tencent.mm.plugin.appbrand.n.i;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webjsapi/JSAPI;", "T", "Lcom/tencent/mm/plugin/webjsapi/JSAPIContext;", "", "name", "", "context", "(Ljava/lang/String;Lcom/tencent/mm/plugin/webjsapi/JSAPIContext;)V", "TAG", "getTAG", "()Ljava/lang/String;", "getContext", "()Lcom/tencent/mm/plugin/webjsapi/JSAPIContext;", "Lcom/tencent/mm/plugin/webjsapi/JSAPIContext;", "getName", "attach", "", "jsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a<T extends b>
{
  private final String TAG;
  protected final T WlE;
  private final String name;
  
  public a(String paramString, T paramT)
  {
    this.name = paramString;
    this.WlE = paramT;
    this.TAG = ("MicroMsg.JSAPI." + getClass().getSimpleName() + ':' + this.WlE.getClass().getSimpleName());
  }
  
  protected final String getTAG()
  {
    return this.TAG;
  }
  
  public final void l(i parami)
  {
    s.u(parami, "jsRuntime");
    parami.addJavascriptInterface(this, this.name);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ax.a
 * JD-Core Version:    0.7.0.1
 */