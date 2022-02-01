package com.tencent.mm.plugin.ax;

import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webjsapi/WxAdAPIContext;", "Lcom/tencent/mm/plugin/webjsapi/JSAPIContext;", "deleteAd", "", "msgId", "", "forceDelete", "", "getAdContext", "from", "", "getInfo", "", "key", "replaceAdData", "data", "setAdExposeParams", "exposureRatio", "exposureTme", "setAdInsertType", "type", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface e
  extends b
{
  public abstract void deleteAd(String paramString, boolean paramBoolean);
  
  public abstract String getAdContext(int paramInt);
  
  public abstract Object getInfo(String paramString);
  
  public abstract void replaceAdData(String paramString);
  
  public abstract void setAdExposeParams(int paramInt1, int paramInt2);
  
  public abstract void setAdInsertType(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ax.e
 * JD-Core Version:    0.7.0.1
 */