package com.tencent.mm.plugin.ab;

import com.tencent.mm.plugin.webview.d.d;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webjsapi/WxJsEngineContextAPIContext;", "Lcom/tencent/mm/plugin/webjsapi/JSEngineAPIContext;", "basePkgVersion", "", "getBasePkgVersion", "()I", "bizPkgVersion", "getBizPkgVersion", "jsApiHandler", "Lcom/tencent/mm/plugin/webview/jsapi/IWebCanvasJsApiHandler;", "getJsApiHandler", "()Lcom/tencent/mm/plugin/webview/jsapi/IWebCanvasJsApiHandler;", "getLocalData", "", "key", "onInvoke", "", "func", "message", "setLocalData", "data", "validCgi", "", "cmdId", "cgiUrl", "webview-sdk_release"})
public abstract interface k
  extends c
{
  public abstract boolean aD(int paramInt, String paramString);
  
  public abstract d cna();
  
  public abstract void fe(String paramString1, String paramString2);
  
  public abstract int getBasePkgVersion();
  
  public abstract int getBizPkgVersion();
  
  public abstract String getLocalData(String paramString);
  
  public abstract void setLocalData(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ab.k
 * JD-Core Version:    0.7.0.1
 */