package com.tencent.mm.plugin.finder.event;

import com.tencent.mm.g.h;
import com.tencent.mm.plugin.finder.loader.x;
import com.tencent.mm.plugin.finder.video.reporter.e;
import com.tencent.mm.plugin.finder.video.v;
import com.tencent.mm.plugin.findersdk.f.a;
import com.tencent.mm.protocal.protobuf.dji;
import java.util.LinkedList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber$VideoPlayBehavior;", "", "checkVideoDataAvailable", "", "feedId", "", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "offset", "", "length", "video", "Lcom/tencent/mm/plugin/finder/loader/IFinderMediaLoaderData;", "onDownloadFinish", "ret", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onDownloadProgress", "total", "onDownloadStart", "onDownloadStop", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "onError", "errCode", "onFirstFrame", "prepareCostTime", "onFirstVideoFrameRendered", "videoTrace", "Lcom/tencent/mm/plugin/findersdk/trace/FinderVideoPlayTrace;", "onMoovReady", "onPause", "mediaList", "Ljava/util/LinkedList;", "onStopPlayData", "Lcom/tencent/mm/plugin/finder/video/reporter/OnStopPlayData;", "onPlayProgress", "onPlayerConfigChange", "playerConfig", "Lcom/tencent/mm/plugin/finder/video/reporter/PlayerConfig;", "onRealPlay", "onReplay", "onSeek", "currentSec", "seekSec", "onStartPlay", "mediaSource", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "position", "bgPreparedStatus", "onStopPlay", "onUserClickPause", "onWaiting", "onWaitingEnd", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface c$b
{
  public abstract void a(long paramLong, dji paramdji, int paramInt);
  
  public abstract void a(long paramLong, dji paramdji, int paramInt1, int paramInt2, x paramx);
  
  public abstract void a(long paramLong, dji paramdji, int paramInt, com.tencent.mm.g.d paramd, x paramx);
  
  public abstract void a(long paramLong, dji paramdji, h paramh, com.tencent.mm.g.d paramd, x paramx);
  
  public abstract void a(long paramLong, dji paramdji, x paramx);
  
  public abstract void a(long paramLong1, dji paramdji, x paramx, long paramLong2);
  
  public abstract void a(long paramLong, dji paramdji, x paramx, com.tencent.mm.plugin.finder.video.reporter.d paramd);
  
  public abstract void a(long paramLong, dji paramdji, x paramx, a parama);
  
  public abstract void a(long paramLong, dji paramdji, v paramv, int paramInt1, x paramx, int paramInt2);
  
  public abstract void a(long paramLong, dji paramdji, LinkedList<dji> paramLinkedList, x paramx);
  
  public abstract void a(long paramLong, dji paramdji, LinkedList<dji> paramLinkedList, x paramx, com.tencent.mm.plugin.finder.video.reporter.d paramd);
  
  public abstract void a(long paramLong, dji paramdji, LinkedList<dji> paramLinkedList, x paramx, e parame);
  
  public abstract void b(long paramLong, dji paramdji, int paramInt1, int paramInt2, x paramx);
  
  public abstract void b(long paramLong, dji paramdji, x paramx);
  
  public abstract void c(long paramLong, dji paramdji, int paramInt1, int paramInt2, x paramx);
  
  public abstract void c(long paramLong, dji paramdji, x paramx);
  
  public abstract void d(long paramLong, dji paramdji, int paramInt1, int paramInt2, x paramx);
  
  public abstract void d(long paramLong, dji paramdji, x paramx);
  
  public abstract void e(long paramLong, dji paramdji, int paramInt1, int paramInt2, x paramx);
  
  public abstract void e(long paramLong, dji paramdji, x paramx);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.c.b
 * JD-Core Version:    0.7.0.1
 */