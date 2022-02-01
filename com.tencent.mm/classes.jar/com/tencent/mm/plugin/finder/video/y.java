package com.tencent.mm.plugin.finder.video;

import com.tencent.mm.plugin.finder.video.reporter.c;
import com.tencent.mm.protocal.protobuf.cjl;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "", "onBeforePlay", "", "info", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "mediaSource", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "bgPreparedStatus", "", "onBgPrepared", "onFirstFrameUpdate", "prepareCostTime", "", "onFirstVideoFrameRendered", "onPause", "onPlay", "onPlayProgress", "offset", "total", "onPlayProgressMs", "offsetMs", "totalMs", "onPlayerConfigChange", "playerConfig", "Lcom/tencent/mm/plugin/finder/video/reporter/PlayerConfig;", "onReplay", "onStopPlay", "plugin-finder_release"})
public abstract interface y
{
  public abstract void Gr(long paramLong);
  
  public abstract void a(c paramc);
  
  public abstract void a(s params, int paramInt);
  
  public abstract void a(cjl paramcjl, int paramInt1, int paramInt2);
  
  public abstract void b(s params);
  
  public abstract void dFK();
  
  public abstract void dFL();
  
  public abstract void dFM();
  
  public abstract void dFN();
  
  public abstract void dFO();
  
  public abstract void l(cjl paramcjl);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.y
 * JD-Core Version:    0.7.0.1
 */