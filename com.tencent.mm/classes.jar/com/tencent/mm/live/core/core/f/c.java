package com.tencent.mm.live.core.core.f;

import android.content.Context;
import com.tencent.rtmp.TXLivePlayConfig;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/core/visitor/IMMLiveVisitorCore;", "Lcom/tencent/mm/live/core/core/IMMLiveCore;", "cdnPausePlay", "", "cdnResumePlay", "cdnStartPlay", "streamType", "", "playerView", "Lcom/tencent/mm/live/core/view/LiveVideoView;", "playCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "cdnStopPlay", "keepLastFrame", "checkStartPlayState", "getTXLivePlayer", "Lcom/tencent/mm/live/core/core/player/ILivePlayer;", "context", "Landroid/content/Context;", "outterConfig", "Lcom/tencent/rtmp/TXLivePlayConfig;", "switchStreamCallback", "Lcom/tencent/mm/live/core/core/visitor/ILiveSwitchStreamCallback;", "vrLive", "isAudioMicing", "isPlaying", "key", "", "isVideoMicing", "makeRemotePreviewFullScreen", "pauseRender", "resumeRender", "setMute", "mute", "setPlayerView", "glRootView", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "setRenderMode", "mode", "setRenderRotation", "rotation", "setTXLivePlayer", "player", "setupLiveRoomInfo", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "startLinkMic", "previewView", "Lcom/tencent/mm/live/core/view/LivePreviewView;", "stopLinkMic", "switchAudioLinkMic", "switchVideoLinkMic", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface c
  extends com.tencent.mm.live.core.core.b
{
  public abstract com.tencent.mm.live.core.core.c.b a(Context paramContext, TXLivePlayConfig paramTXLivePlayConfig, b paramb, boolean paramBoolean);
  
  public abstract boolean bfC();
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.core.f.c
 * JD-Core Version:    0.7.0.1
 */