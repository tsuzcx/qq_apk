package com.tencent.mm.plugin.finder.video;

import com.tencent.mm.plugin.finder.video.reporter.d;
import com.tencent.mm.plugin.finder.video.reporter.e;
import com.tencent.mm.plugin.findersdk.f.a;
import com.tencent.mm.protocal.protobuf.dji;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "", "onBeforePlay", "", "info", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "mediaSource", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "bgPreparedStatus", "", "onBgPrepared", "onFirstFrameUpdate", "prepareCostTime", "", "onFirstVideoFrameRendered", "videoTrace", "Lcom/tencent/mm/plugin/findersdk/trace/FinderVideoPlayTrace;", "onPause", "onStopPlayData", "Lcom/tencent/mm/plugin/finder/video/reporter/OnStopPlayData;", "onPlay", "onPlayProgress", "offset", "total", "onPlayProgressMs", "offsetMs", "totalMs", "onPlayerConfigChange", "playerConfig", "Lcom/tencent/mm/plugin/finder/video/reporter/PlayerConfig;", "onReplay", "onStopPlay", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface ab
{
  public abstract void a(d paramd);
  
  public abstract void a(e parame);
  
  public abstract void a(v paramv, int paramInt);
  
  public abstract void a(v paramv, d paramd);
  
  public abstract void a(a parama);
  
  public abstract void a(dji paramdji);
  
  public abstract void a(dji paramdji, int paramInt1, int paramInt2);
  
  public abstract void ar(long paramLong1, long paramLong2);
  
  public abstract void eCP();
  
  public abstract void egu();
  
  public abstract void ph(long paramLong);
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.ab
 * JD-Core Version:    0.7.0.1
 */