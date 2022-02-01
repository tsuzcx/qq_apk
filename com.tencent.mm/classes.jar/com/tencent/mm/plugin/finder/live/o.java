package com.tencent.mm.plugin.finder.live;

import kotlin.g.a.a;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/IFinderLivePlayView;", "", "isPlaying", "", "mediaSource", "Lcom/tencent/mm/plugin/finder/live/FinderLiveMediaSource;", "pause", "", "play", "onFirstFrameRendStart", "Lkotlin/Function0;", "release", "resume", "setMute", "mute", "start", "stop", "plugin-finder_release"})
public abstract interface o
{
  public abstract void a(g paramg, a<x> parama);
  
  public abstract boolean b(g paramg);
  
  public abstract void pause();
  
  public abstract void release();
  
  public abstract void resume();
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.o
 * JD-Core Version:    0.7.0.1
 */