package com.tencent.mm.live.core.core.d.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayConfig;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;

public final class b
  implements com.tencent.mm.live.core.core.c.b
{
  public d mPA;
  
  public b(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(248080);
    this.mPA = null;
    this.mPA = new d(paramContext, paramInt);
    AppMethodBeat.o(248080);
  }
  
  public final void D(String paramString, boolean paramBoolean)
  {
    int i = 30;
    AppMethodBeat.i(248184);
    int j = paramString.length();
    if (j > 30) {}
    for (;;)
    {
      Log.i("CustomLiveTXPlayer", "callExperimentalAPI jsonStr:" + paramString.substring(0, i) + ",debugClose:" + paramBoolean);
      if (paramBoolean)
      {
        AppMethodBeat.o(248184);
        return;
      }
      if ((this.mPA != null) && (!Util.isNullOrNil(paramString)))
      {
        this.mPA.callExperimentalAPI(paramString);
        com.tencent.mm.live.core.core.model.b.F(this.mPA.hashCode(), paramString);
      }
      AppMethodBeat.o(248184);
      return;
      i = j;
    }
  }
  
  public final void Y(String paramString, int paramInt)
  {
    AppMethodBeat.i(248103);
    if (this.mPA != null) {
      this.mPA.startPlay(paramString, paramInt);
    }
    AppMethodBeat.o(248103);
  }
  
  public final boolean enableHardwareDecode(boolean paramBoolean)
  {
    AppMethodBeat.i(248141);
    if (this.mPA != null)
    {
      paramBoolean = this.mPA.enableHardwareDecode(paramBoolean);
      AppMethodBeat.o(248141);
      return paramBoolean;
    }
    AppMethodBeat.o(248141);
    return false;
  }
  
  public final void fD(boolean paramBoolean)
  {
    AppMethodBeat.i(248122);
    if (this.mPA != null) {
      this.mPA.stopPlay(paramBoolean);
    }
    AppMethodBeat.o(248122);
  }
  
  public final void fG(boolean paramBoolean)
  {
    if (this.mPA != null)
    {
      a locala = this.mPA.mPT.mPK;
      if (locala.mPz != null) {
        locala.mPz.mQh = paramBoolean;
      }
    }
  }
  
  public final TXLivePlayer getPlayer()
  {
    return this.mPA;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(248157);
    if (this.mPA != null)
    {
      boolean bool = this.mPA.isPlaying();
      AppMethodBeat.o(248157);
      return bool;
    }
    AppMethodBeat.o(248157);
    return false;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(248115);
    if (this.mPA != null) {
      this.mPA.pause();
    }
    AppMethodBeat.o(248115);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(248108);
    if (this.mPA != null) {
      this.mPA.resume();
    }
    AppMethodBeat.o(248108);
  }
  
  public final void setConfig(TXLivePlayConfig paramTXLivePlayConfig)
  {
    AppMethodBeat.i(248171);
    if (this.mPA != null) {
      this.mPA.setConfig(paramTXLivePlayConfig);
    }
    AppMethodBeat.o(248171);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(248162);
    if (this.mPA != null) {
      this.mPA.setMute(paramBoolean);
    }
    AppMethodBeat.o(248162);
  }
  
  public final void setPlayListener(ITXLivePlayListener paramITXLivePlayListener)
  {
    AppMethodBeat.i(248130);
    if (this.mPA != null) {
      this.mPA.setPlayListener(paramITXLivePlayListener);
    }
    AppMethodBeat.o(248130);
  }
  
  public final void setPlayerView(TXCloudVideoView paramTXCloudVideoView)
  {
    AppMethodBeat.i(248152);
    if (this.mPA != null) {
      this.mPA.setPlayerView(paramTXCloudVideoView);
    }
    AppMethodBeat.o(248152);
  }
  
  public final void setRenderMode(int paramInt)
  {
    AppMethodBeat.i(248148);
    if (this.mPA != null) {
      this.mPA.setRenderMode(paramInt);
    }
    AppMethodBeat.o(248148);
  }
  
  public final void setVolume(int paramInt)
  {
    AppMethodBeat.i(248179);
    if (this.mPA != null) {
      this.mPA.setVolume(paramInt);
    }
    AppMethodBeat.o(248179);
  }
  
  public final int switchStream(String paramString)
  {
    AppMethodBeat.i(248167);
    if (this.mPA != null)
    {
      int i = this.mPA.switchStream(paramString);
      AppMethodBeat.o(248167);
      return i;
    }
    AppMethodBeat.o(248167);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.core.core.d.a.b
 * JD-Core Version:    0.7.0.1
 */