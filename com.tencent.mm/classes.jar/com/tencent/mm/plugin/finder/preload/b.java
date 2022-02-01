package com.tencent.mm.plugin.finder.preload;

import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/preload/IVideoPreloadCallback;", "", "onCancel", "", "mediaId", "", "task", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "onFailure", "msg", "onFormatChange", "onPending", "progress", "", "targetPercent", "fileFormat", "codingFormat", "onProgress", "onSuccessfully", "isAllCompleted", "", "percent", "plugin-finder_release"})
public abstract interface b
{
  public abstract void a(String paramString1, int paramInt, String paramString2, String paramString3, c paramc);
  
  public abstract void a(String paramString1, String paramString2, c paramc);
  
  public abstract void a(String paramString, boolean paramBoolean, int paramInt, c paramc);
  
  public abstract void aum(String paramString);
  
  public abstract void dx(String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.b
 * JD-Core Version:    0.7.0.1
 */