package com.tencent.mm.plugin.finder.video;

import com.tencent.mm.i.d;
import com.tencent.mm.i.h;
import com.tencent.mm.plugin.finder.loader.m;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "", "checkVideoDataAvailable", "", "mediaId", "", "offset", "", "length", "onFinishDownload", "ret", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onMoovReadyDownload", "total", "onProgressDownload", "onStartDownload", "onStopDownload", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "result", "plugin-finder_release"})
public abstract interface t
{
  public abstract void a(int paramInt1, int paramInt2, m paramm);
  
  public abstract void a(int paramInt, m paramm, d paramd);
  
  public abstract void a(m paramm, h paramh, d paramd);
  
  public abstract void ae(String paramString, int paramInt1, int paramInt2);
  
  public abstract void b(int paramInt1, int paramInt2, m paramm);
  
  public abstract void b(m paramm);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.t
 * JD-Core Version:    0.7.0.1
 */