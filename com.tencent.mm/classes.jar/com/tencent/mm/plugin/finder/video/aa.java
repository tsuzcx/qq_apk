package com.tencent.mm.plugin.finder.video;

import com.tencent.mm.g.d;
import com.tencent.mm.g.h;
import com.tencent.mm.plugin.finder.loader.x;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "", "checkVideoDataAvailable", "", "mediaId", "", "offset", "", "length", "onFinishDownload", "ret", "video", "Lcom/tencent/mm/plugin/finder/loader/IFinderMediaLoaderData;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onMoovReadyDownload", "total", "moovFirstDownloaded", "", "onProgressDownload", "onStartDownload", "onStopDownload", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "result", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface aa
{
  public abstract void a(int paramInt1, int paramInt2, x paramx);
  
  public abstract void a(int paramInt1, int paramInt2, x paramx, boolean paramBoolean);
  
  public abstract void a(int paramInt, x paramx, d paramd);
  
  public abstract void a(x paramx, h paramh, d paramd);
  
  public abstract void aj(String paramString, int paramInt1, int paramInt2);
  
  public abstract void b(x paramx);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.aa
 * JD-Core Version:    0.7.0.1
 */