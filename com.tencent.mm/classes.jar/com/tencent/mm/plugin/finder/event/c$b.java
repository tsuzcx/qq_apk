package com.tencent.mm.plugin.finder.event;

import com.tencent.mm.i.d;
import com.tencent.mm.i.h;
import com.tencent.mm.plugin.finder.loader.ac;
import com.tencent.mm.plugin.finder.video.reporter.e;
import com.tencent.mm.plugin.finder.video.reporter.f;
import com.tencent.mm.plugin.finder.video.t;
import com.tencent.mm.protocal.protobuf.csg;
import java.util.LinkedList;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber$VideoPlayBehavior;", "", "checkVideoDataAvailable", "", "feedId", "", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "offset", "", "length", "video", "Lcom/tencent/mm/plugin/finder/loader/IFinderMediaLoaderData;", "onDownloadFinish", "ret", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onDownloadProgress", "total", "onDownloadStart", "onDownloadStop", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "onError", "errCode", "onFirstFrame", "prepareCostTime", "onFirstVideoFrameRendered", "onMoovReady", "onPause", "mediaList", "Ljava/util/LinkedList;", "onStopPlayData", "Lcom/tencent/mm/plugin/finder/video/reporter/OnStopPlayData;", "onPlayProgress", "onPlayerConfigChange", "playerConfig", "Lcom/tencent/mm/plugin/finder/video/reporter/PlayerConfig;", "onRealPlay", "onReplay", "onSeek", "currentSec", "seekSec", "onStartPlay", "mediaSource", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "position", "bgPreparedStatus", "onStopPlay", "onUserClickPause", "onWaiting", "onWaitingEnd", "plugin-finder-base_release"})
public abstract interface c$b
{
  public abstract void a(long paramLong, csg paramcsg, int paramInt);
  
  public abstract void a(long paramLong, csg paramcsg, int paramInt1, int paramInt2, ac paramac);
  
  public abstract void a(long paramLong, csg paramcsg, int paramInt, d paramd, ac paramac);
  
  public abstract void a(long paramLong, csg paramcsg, h paramh, d paramd, ac paramac);
  
  public abstract void a(long paramLong, csg paramcsg, ac paramac);
  
  public abstract void a(long paramLong1, csg paramcsg, ac paramac, long paramLong2);
  
  public abstract void a(long paramLong, csg paramcsg, ac paramac, e parame);
  
  public abstract void a(long paramLong, csg paramcsg, t paramt, int paramInt1, ac paramac, int paramInt2);
  
  public abstract void a(long paramLong, csg paramcsg, LinkedList<csg> paramLinkedList, ac paramac);
  
  public abstract void a(long paramLong, csg paramcsg, LinkedList<csg> paramLinkedList, ac paramac, e parame);
  
  public abstract void a(long paramLong, csg paramcsg, LinkedList<csg> paramLinkedList, ac paramac, f paramf);
  
  public abstract void b(long paramLong, csg paramcsg, int paramInt1, int paramInt2, ac paramac);
  
  public abstract void b(long paramLong, csg paramcsg, ac paramac);
  
  public abstract void c(long paramLong, csg paramcsg, int paramInt1, int paramInt2, ac paramac);
  
  public abstract void c(long paramLong, csg paramcsg, ac paramac);
  
  public abstract void d(long paramLong, csg paramcsg, int paramInt1, int paramInt2, ac paramac);
  
  public abstract void d(long paramLong, csg paramcsg, ac paramac);
  
  public abstract void e(long paramLong, csg paramcsg, int paramInt1, int paramInt2, ac paramac);
  
  public abstract void e(long paramLong, csg paramcsg, ac paramac);
  
  public abstract void f(long paramLong, csg paramcsg, ac paramac);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.c.b
 * JD-Core Version:    0.7.0.1
 */