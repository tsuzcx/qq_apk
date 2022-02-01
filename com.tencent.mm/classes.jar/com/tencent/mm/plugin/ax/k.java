package com.tencent.mm.plugin.ax;

import com.tencent.mm.plugin.webview.jsapi.f;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webjsapi/WxJsEngineContextAPIContext;", "Lcom/tencent/mm/plugin/webjsapi/JSEngineAPIContext;", "basePkgVersion", "", "getBasePkgVersion", "()I", "bizPkgVersion", "getBizPkgVersion", "jsApiHandler", "Lcom/tencent/mm/plugin/webview/jsapi/IWebCanvasJsApiHandler;", "getJsApiHandler", "()Lcom/tencent/mm/plugin/webview/jsapi/IWebCanvasJsApiHandler;", "getLocalData", "", "key", "onInvoke", "", "func", "message", "setLocalData", "data", "validCgi", "", "cmdId", "cgiUrl", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface k
  extends c
{
  public abstract boolean aS(int paramInt, String paramString);
  
  public abstract f ddL();
  
  public abstract void fM(String paramString1, String paramString2);
  
  public abstract int getBasePkgVersion();
  
  public abstract int getBizPkgVersion();
  
  public abstract String getLocalData(String paramString);
  
  public abstract void setLocalData(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ax.k
 * JD-Core Version:    0.7.0.1
 */