package com.tencent.mm.plugin.finder.preload;

import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/preload/IVideoPreloadCallback;", "", "onCancel", "", "mediaId", "", "task", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "onFailure", "msg", "onFormatChange", "onPending", "progress", "", "targetPercent", "fileFormat", "codingFormat", "onProgress", "onReject", "onSuccessfully", "isAllCompleted", "", "percent", "plugin-finder_release"})
public abstract interface b
{
  public abstract void a(String paramString1, int paramInt, String paramString2, String paramString3, d paramd);
  
  public abstract void a(String paramString1, String paramString2, d paramd);
  
  public abstract void a(String paramString, boolean paramBoolean, int paramInt, d paramd);
  
  public abstract void aDB(String paramString);
  
  public abstract void aDC(String paramString);
  
  public abstract void dT(String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.b
 * JD-Core Version:    0.7.0.1
 */