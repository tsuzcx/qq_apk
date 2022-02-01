package com.tencent.mm.plugin.finder.preload;

import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/preload/IVideoPreloadCallback;", "", "onCancel", "", "mediaId", "", "task", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "onFailure", "msg", "onFormatChange", "onPending", "progress", "", "targetPercent", "fileFormat", "codingFormat", "onProgress", "onSuccessfully", "isAllCompleted", "", "percent", "plugin-finder_release"})
public abstract interface b
{
  public abstract void a(String paramString1, int paramInt, String paramString2, String paramString3, c paramc);
  
  public abstract void a(String paramString1, String paramString2, c paramc);
  
  public abstract void a(String paramString, boolean paramBoolean, int paramInt, c paramc);
  
  public abstract void aVn(String paramString);
  
  public abstract void cU(String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.b
 * JD-Core Version:    0.7.0.1
 */