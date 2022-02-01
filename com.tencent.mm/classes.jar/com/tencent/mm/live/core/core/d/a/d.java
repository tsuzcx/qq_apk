package com.tencent.mm.live.core.core.d.a;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Message;
import android.view.TextureView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;

public final class d
  extends TXLivePlayer
{
  private boolean mPS;
  public c mPT;
  
  public d(Context paramContext, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(248074);
    this.mPS = false;
    this.mPT = null;
    this.mPS = true;
    if (this.mPS)
    {
      this.mPT = new c(paramContext);
      this.mPT.sT(paramInt);
    }
    AppMethodBeat.o(248074);
  }
  
  public final void setPlayListener(ITXLivePlayListener paramITXLivePlayListener)
  {
    AppMethodBeat.i(248137);
    if ((this.mPS) && (this.mPT != null)) {
      this.mPT.mPO = paramITXLivePlayListener;
    }
    super.setPlayListener(paramITXLivePlayListener);
    AppMethodBeat.o(248137);
  }
  
  public final void setPlayerView(TXCloudVideoView paramTXCloudVideoView)
  {
    AppMethodBeat.i(248120);
    Log.i("CustomRender.CustomTXLivePlayer", "setPlayerView");
    if ((this.mPS) && (this.mPT != null))
    {
      this.mPT.setPlayerView(paramTXCloudVideoView);
      AppMethodBeat.o(248120);
      return;
    }
    super.setPlayerView(paramTXCloudVideoView);
    AppMethodBeat.o(248120);
  }
  
  public final void setRenderMode(int paramInt)
  {
    AppMethodBeat.i(248084);
    if ((this.mPS) && (this.mPT != null))
    {
      c localc = this.mPT;
      localc.mRenderMode = paramInt;
      if ((localc.mPG != null) && (localc.mPQ != 1)) {
        localc.mPG.setRenderMode(paramInt);
      }
    }
    super.setRenderMode(paramInt);
    AppMethodBeat.o(248084);
  }
  
  public final void setRenderRotation(int paramInt)
  {
    AppMethodBeat.i(248090);
    if ((this.mPS) && (this.mPT != null))
    {
      c localc = this.mPT;
      localc.mRenderRotation = paramInt;
      if ((localc.mPG != null) && (localc.mPQ != 1)) {
        localc.mPG.setRenderRotation(localc.mRenderRotation % 360);
      }
    }
    super.setRenderRotation(paramInt);
    AppMethodBeat.o(248090);
  }
  
  public final int startPlay(String paramString, int paramInt)
  {
    AppMethodBeat.i(248149);
    Log.i("CustomRender.CustomTXLivePlayer", "startPlay");
    c localc;
    if ((this.mPS) && (this.mPT != null))
    {
      super.setVideoRenderListener(this.mPT, null);
      localc = this.mPT;
      localc.mPL = true;
      localc.mPJ = true;
      if (Build.VERSION.SDK_INT < 21) {
        break label115;
      }
    }
    label115:
    for (localc.mPJ = true;; localc.mPJ = false)
    {
      if (localc.mPF != null)
      {
        localc.mPF.clearLog();
        localc.mPF.setVisibility(0);
      }
      if (localc.eDa != null) {
        localc.eDa.setVisibility(0);
      }
      paramInt = super.startPlay(paramString, paramInt);
      AppMethodBeat.o(248149);
      return paramInt;
    }
  }
  
  public final int stopPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(248155);
    Log.i("CustomRender.CustomTXLivePlayer", "stopPlay");
    if ((this.mPS) && (this.mPT != null))
    {
      c localc = this.mPT;
      localc.mPJ = false;
      localc.mPL = false;
      if (paramBoolean)
      {
        if (localc.mPF != null) {
          localc.mPF.setVisibility(8);
        }
        if (localc.eDa != null) {
          localc.eDa.setVisibility(8);
        }
      }
      if (localc.mPK != null) {
        localc.mPE.obtainMessage(3, null).sendToTarget();
      }
      if ((localc.mPK != null) && (localc.mContext != null)) {
        localc.mPK.dA(localc.mContext);
      }
    }
    int i = super.stopPlay(paramBoolean);
    AppMethodBeat.o(248155);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.core.core.d.a.d
 * JD-Core Version:    0.7.0.1
 */