package com.tencent.mm.plugin.finder.video;

import com.tencent.mm.i.d;
import com.tencent.mm.i.h;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "", "checkVideoDataAvailable", "", "mediaId", "", "offset", "", "length", "onFinishDownload", "ret", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onMoovReadyDownload", "total", "onProgressDownload", "onStartDownload", "onStopDownload", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "result", "plugin-finder_release"})
public abstract interface s
{
  public abstract void a(int paramInt1, int paramInt2, com.tencent.mm.plugin.finder.loader.l paraml);
  
  public abstract void a(int paramInt, com.tencent.mm.plugin.finder.loader.l paraml, d paramd);
  
  public abstract void a(com.tencent.mm.plugin.finder.loader.l paraml);
  
  public abstract void a(com.tencent.mm.plugin.finder.loader.l paraml, h paramh, d paramd);
  
  public abstract void aa(String paramString, int paramInt1, int paramInt2);
  
  public abstract void b(int paramInt1, int paramInt2, com.tencent.mm.plugin.finder.loader.l paraml);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.s
 * JD-Core Version:    0.7.0.1
 */