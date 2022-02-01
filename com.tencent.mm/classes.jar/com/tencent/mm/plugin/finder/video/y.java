package com.tencent.mm.plugin.finder.video;

import com.tencent.mm.i.d;
import com.tencent.mm.i.h;
import com.tencent.mm.plugin.finder.loader.ac;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "", "checkVideoDataAvailable", "", "mediaId", "", "offset", "", "length", "onFinishDownload", "ret", "video", "Lcom/tencent/mm/plugin/finder/loader/IFinderMediaLoaderData;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onMoovReadyDownload", "total", "moovFirstDownloaded", "", "onProgressDownload", "onStartDownload", "onStopDownload", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "result", "plugin-finder-base_release"})
public abstract interface y
{
  public abstract void a(int paramInt1, int paramInt2, ac paramac);
  
  public abstract void a(int paramInt1, int paramInt2, ac paramac, boolean paramBoolean);
  
  public abstract void a(int paramInt, ac paramac, d paramd);
  
  public abstract void a(ac paramac, h paramh, d paramd);
  
  public abstract void ae(String paramString, int paramInt1, int paramInt2);
  
  public abstract void b(ac paramac);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.y
 * JD-Core Version:    0.7.0.1
 */