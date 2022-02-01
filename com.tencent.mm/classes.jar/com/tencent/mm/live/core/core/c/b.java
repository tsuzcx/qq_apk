package com.tencent.mm.live.core.core.c;

import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayConfig;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/core/player/ILivePlayer;", "", "callExperimentalAPI", "", "jsonStr", "", "debugClose", "", "enableHardwareDecode", "enable", "getPlayer", "Lcom/tencent/rtmp/TXLivePlayer;", "isPlaying", "pause", "resume", "setConfig", "config", "Lcom/tencent/rtmp/TXLivePlayConfig;", "setMute", "mute", "setPlayListener", "listener", "Lcom/tencent/rtmp/ITXLivePlayListener;", "setPlayerView", "glRootView", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "setRenderMode", "mode", "", "setRenderRotation", "rotation", "setVolume", "volume", "startPlay", "url", "streamType", "stopPlay", "isNeedClearLastImg", "switchStream", "playUrl", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface b
{
  public abstract void D(String paramString, boolean paramBoolean);
  
  public abstract void Y(String paramString, int paramInt);
  
  public abstract boolean enableHardwareDecode(boolean paramBoolean);
  
  public abstract void fD(boolean paramBoolean);
  
  public abstract TXLivePlayer getPlayer();
  
  public abstract boolean isPlaying();
  
  public abstract void pause();
  
  public abstract void resume();
  
  public abstract void setConfig(TXLivePlayConfig paramTXLivePlayConfig);
  
  public abstract void setMute(boolean paramBoolean);
  
  public abstract void setPlayListener(ITXLivePlayListener paramITXLivePlayListener);
  
  public abstract void setPlayerView(TXCloudVideoView paramTXCloudVideoView);
  
  public abstract void setRenderMode(int paramInt);
  
  public abstract void setVolume(int paramInt);
  
  public abstract int switchStream(String paramString);
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.live.core.core.c.b
 * JD-Core Version:    0.7.0.1
 */