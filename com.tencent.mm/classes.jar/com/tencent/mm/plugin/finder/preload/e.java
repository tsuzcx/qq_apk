package com.tencent.mm.plugin.finder.preload;

import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/preload/IVideoPreloadCallback;", "", "onCancel", "", "mediaId", "", "task", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "onFailure", "msg", "onFormatChange", "onPending", "progress", "", "targetPercent", "fileFormat", "codingFormat", "onProgress", "receivedSize", "", "onReject", "onSuccessfully", "isAllCompleted", "", "percent", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface e
{
  public abstract void B(String paramString, int paramInt, long paramLong);
  
  public abstract void a(String paramString1, int paramInt, String paramString2, String paramString3, g paramg);
  
  public abstract void a(String paramString, g paramg);
  
  public abstract void a(String paramString1, String paramString2, g paramg);
  
  public abstract void a(String paramString, boolean paramBoolean, int paramInt, g paramg, long paramLong);
  
  public abstract void azf(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.e
 * JD-Core Version:    0.7.0.1
 */