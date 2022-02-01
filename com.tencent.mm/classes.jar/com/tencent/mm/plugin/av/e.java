package com.tencent.mm.plugin.av;

import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webjsapi/WxAdAPIContext;", "Lcom/tencent/mm/plugin/webjsapi/JSAPIContext;", "deleteAd", "", "msgId", "", "forceDelete", "", "getAdContext", "from", "", "getInfo", "", "key", "replaceAdData", "data", "webview-sdk_release"})
public abstract interface e
  extends b
{
  public abstract void deleteAd(String paramString, boolean paramBoolean);
  
  public abstract String getAdContext(int paramInt);
  
  public abstract Object getInfo(String paramString);
  
  public abstract void replaceAdData(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.av.e
 * JD-Core Version:    0.7.0.1
 */