package com.tencent.mm.plugin.finder.video;

import com.tencent.mm.i.d;
import com.tencent.mm.i.h;
import com.tencent.mm.plugin.finder.loader.s;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "", "checkVideoDataAvailable", "", "mediaId", "", "offset", "", "length", "onFinishDownload", "ret", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onMoovReadyDownload", "total", "moovFirstDownloaded", "", "onProgressDownload", "onStartDownload", "onStopDownload", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "result", "plugin-finder_release"})
public abstract interface x
{
  public abstract void a(int paramInt1, int paramInt2, s params);
  
  public abstract void a(int paramInt1, int paramInt2, s params, boolean paramBoolean);
  
  public abstract void a(int paramInt, s params, d paramd);
  
  public abstract void a(s params, h paramh, d paramd);
  
  public abstract void ac(String paramString, int paramInt1, int paramInt2);
  
  public abstract void b(s params);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.x
 * JD-Core Version:    0.7.0.1
 */