package com.tencent.mm.plugin.finder.video;

import com.tencent.mm.plugin.finder.video.reporter.e;
import com.tencent.mm.plugin.finder.video.reporter.f;
import com.tencent.mm.protocal.protobuf.csg;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "", "onBeforePlay", "", "info", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "mediaSource", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "bgPreparedStatus", "", "onBgPrepared", "onFirstFrameUpdate", "prepareCostTime", "", "onFirstVideoFrameRendered", "onPause", "onStopPlayData", "Lcom/tencent/mm/plugin/finder/video/reporter/OnStopPlayData;", "onPlay", "onPlayProgress", "offset", "total", "onPlayProgressMs", "offsetMs", "totalMs", "onPlayerConfigChange", "playerConfig", "Lcom/tencent/mm/plugin/finder/video/reporter/PlayerConfig;", "onReplay", "onStopPlay", "plugin-finder-base_release"})
public abstract interface z
{
  public abstract void Ma(long paramLong);
  
  public abstract void U(long paramLong1, long paramLong2);
  
  public abstract void a(e parame);
  
  public abstract void a(f paramf);
  
  public abstract void a(t paramt, int paramInt);
  
  public abstract void a(t paramt, e parame);
  
  public abstract void a(csg paramcsg);
  
  public abstract void a(csg paramcsg, int paramInt1, int paramInt2);
  
  public abstract void dJU();
  
  public abstract void dJV();
  
  public abstract void dJW();
  
  @l(iBK={1, 1, 16})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.z
 * JD-Core Version:    0.7.0.1
 */