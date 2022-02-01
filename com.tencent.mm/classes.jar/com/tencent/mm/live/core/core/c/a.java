package com.tencent.mm.live.core.core.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayConfig;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/core/player/BaseLiveTXPlayer;", "Lcom/tencent/mm/live/core/core/player/ILivePlayer;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "txLivePlayer", "Lcom/tencent/rtmp/TXLivePlayer;", "callExperimentalAPI", "", "jsonStr", "", "debugClose", "", "enableHardwareDecode", "enable", "getPlayer", "isPlaying", "pause", "resume", "setConfig", "config", "Lcom/tencent/rtmp/TXLivePlayConfig;", "setMute", "mute", "setPlayListener", "listener", "Lcom/tencent/rtmp/ITXLivePlayListener;", "setPlayerView", "glRootView", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "setRenderMode", "mode", "", "setRenderRotation", "rotation", "setVolume", "volume", "startPlay", "url", "streamType", "stopPlay", "isNeedClearLastImg", "switchStream", "playUrl", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements b
{
  private TXLivePlayer mPi;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(247974);
    this.mPi = new TXLivePlayer(paramContext);
    AppMethodBeat.o(247974);
  }
  
  public final void D(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(248075);
    s.u(paramString, "jsonStr");
    Log.i("BaseLiveTXPlayer", "callExperimentalAPI(debugClose:" + paramBoolean + ") jsonStr:" + n.bX(paramString, "encKey", paramString));
    if (paramBoolean)
    {
      AppMethodBeat.o(248075);
      return;
    }
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.mPi.callExperimentalAPI(paramString);
        com.tencent.mm.live.core.core.model.b.F(this.mPi.hashCode(), paramString);
      }
      AppMethodBeat.o(248075);
      return;
    }
  }
  
  public final void Y(String paramString, int paramInt)
  {
    AppMethodBeat.i(247986);
    s.u(paramString, "url");
    this.mPi.startPlay(paramString, paramInt);
    AppMethodBeat.o(247986);
  }
  
  public final boolean enableHardwareDecode(boolean paramBoolean)
  {
    AppMethodBeat.i(248014);
    paramBoolean = this.mPi.enableHardwareDecode(paramBoolean);
    AppMethodBeat.o(248014);
    return paramBoolean;
  }
  
  public final void fD(boolean paramBoolean)
  {
    AppMethodBeat.i(248001);
    this.mPi.stopPlay(paramBoolean);
    AppMethodBeat.o(248001);
  }
  
  public final TXLivePlayer getPlayer()
  {
    return this.mPi;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(248031);
    boolean bool = this.mPi.isPlaying();
    AppMethodBeat.o(248031);
    return bool;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(247997);
    this.mPi.pause();
    AppMethodBeat.o(247997);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(247992);
    this.mPi.resume();
    AppMethodBeat.o(247992);
  }
  
  public final void setConfig(TXLivePlayConfig paramTXLivePlayConfig)
  {
    AppMethodBeat.i(248053);
    s.u(paramTXLivePlayConfig, "config");
    this.mPi.setConfig(paramTXLivePlayConfig);
    AppMethodBeat.o(248053);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(248038);
    this.mPi.setMute(paramBoolean);
    AppMethodBeat.o(248038);
  }
  
  public final void setPlayListener(ITXLivePlayListener paramITXLivePlayListener)
  {
    AppMethodBeat.i(248007);
    this.mPi.setPlayListener(paramITXLivePlayListener);
    AppMethodBeat.o(248007);
  }
  
  public final void setPlayerView(TXCloudVideoView paramTXCloudVideoView)
  {
    AppMethodBeat.i(248024);
    this.mPi.setPlayerView(paramTXCloudVideoView);
    AppMethodBeat.o(248024);
  }
  
  public final void setRenderMode(int paramInt)
  {
    AppMethodBeat.i(248020);
    this.mPi.setRenderMode(paramInt);
    AppMethodBeat.o(248020);
  }
  
  public final void setVolume(int paramInt)
  {
    AppMethodBeat.i(248065);
    this.mPi.setVolume(paramInt);
    AppMethodBeat.o(248065);
  }
  
  public final int switchStream(String paramString)
  {
    AppMethodBeat.i(248043);
    s.u(paramString, "playUrl");
    int i = this.mPi.switchStream(paramString);
    AppMethodBeat.o(248043);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.core.core.c.a
 * JD-Core Version:    0.7.0.1
 */