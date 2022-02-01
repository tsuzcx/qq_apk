package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.content.Context;
import android.os.Bundle;
import com.tencent.live2.jsplugin.V2TXJSAdapterError;
import com.tencent.live2.jsplugin.player.V2TXLivePlayerJSAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayer.ITXAudioVolumeEvaluationListener;
import com.tencent.rtmp.TXLivePlayer.ITXSnapshotListener;
import com.tencent.rtmp.ui.TXCloudVideoView;
import org.json.JSONObject;

public class q
  implements a
{
  private boolean eyE;
  private boolean eyF;
  protected ITXLivePlayListener ezq;
  private boolean ezy;
  private boolean sbp;
  protected V2TXLivePlayerJSAdapter sbr;
  
  public q(Context paramContext)
  {
    AppMethodBeat.i(326139);
    this.sbp = false;
    this.ezy = false;
    this.eyE = true;
    this.eyF = true;
    this.sbr = new V2TXLivePlayerJSAdapter(paramContext);
    AppMethodBeat.o(326139);
  }
  
  private void ac(Bundle paramBundle)
  {
    AppMethodBeat.i(326141);
    this.ezy = paramBundle.getBoolean("needEvent", this.ezy);
    this.eyE = paramBundle.getBoolean("autoPauseIfNavigate", this.eyE);
    this.eyF = paramBundle.getBoolean("autoPauseIfOpenNative", this.eyF);
    AppMethodBeat.o(326141);
  }
  
  public k a(TXCloudVideoView paramTXCloudVideoView, Bundle paramBundle)
  {
    AppMethodBeat.i(326161);
    paramTXCloudVideoView = this.sbr.initLivePlayer(paramTXCloudVideoView, paramBundle);
    if (-1 != paramTXCloudVideoView.errorCode) {
      ac(paramBundle);
    }
    paramTXCloudVideoView = new k(paramTXCloudVideoView);
    AppMethodBeat.o(326161);
    return paramTXCloudVideoView;
  }
  
  public k aud()
  {
    AppMethodBeat.i(326181);
    if (this.sbp)
    {
      localk = d("resume", null);
      AppMethodBeat.o(326181);
      return localk;
    }
    k localk = new k();
    AppMethodBeat.o(326181);
    return localk;
  }
  
  public final k aue()
  {
    AppMethodBeat.i(326178);
    k localk = new k(this.sbr.uninitLivePlayer());
    AppMethodBeat.o(326178);
    return localk;
  }
  
  public final k d(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(326173);
    paramString = new k(this.sbr.operateLivePlayer(paramString, paramJSONObject));
    AppMethodBeat.o(326173);
    return paramString;
  }
  
  public final k mA(int paramInt)
  {
    AppMethodBeat.i(326184);
    Log.i("TXLivePlayerJSAdapterV2", "enterBackground");
    if (((paramInt == 2) && (!this.eyF)) || ((paramInt == 1) && (!this.eyE)))
    {
      this.sbp = false;
      localk = new k();
      AppMethodBeat.o(326184);
      return localk;
    }
    this.sbp = this.sbr.isPlaying();
    if (this.sbp)
    {
      if ((this.ezy) && (this.ezq != null)) {
        this.ezq.onPlayEvent(6000, new Bundle());
      }
      localk = d("pause", null);
      AppMethodBeat.o(326184);
      return localk;
    }
    k localk = new k();
    AppMethodBeat.o(326184);
    return localk;
  }
  
  public final void setAudioVolumeListener(TXLivePlayer.ITXAudioVolumeEvaluationListener paramITXAudioVolumeEvaluationListener)
  {
    AppMethodBeat.i(326156);
    this.sbr.setAudioVolumeListener(paramITXAudioVolumeEvaluationListener);
    AppMethodBeat.o(326156);
  }
  
  public final void setPlayListener(ITXLivePlayListener paramITXLivePlayListener)
  {
    AppMethodBeat.i(326145);
    this.ezq = paramITXLivePlayListener;
    this.sbr.setPlayListener(paramITXLivePlayListener);
    AppMethodBeat.o(326145);
  }
  
  public final void setSnapshotListener(TXLivePlayer.ITXSnapshotListener paramITXSnapshotListener)
  {
    AppMethodBeat.i(326150);
    this.sbr.setSnapshotListener(paramITXSnapshotListener);
    AppMethodBeat.o(326150);
  }
  
  public final void takePhoto(boolean paramBoolean, TXLivePlayer.ITXSnapshotListener paramITXSnapshotListener)
  {
    AppMethodBeat.i(326187);
    this.sbr.takePhoto(paramBoolean, paramITXSnapshotListener);
    AppMethodBeat.o(326187);
  }
  
  public k v(Bundle paramBundle)
  {
    AppMethodBeat.i(326167);
    V2TXJSAdapterError localV2TXJSAdapterError = this.sbr.updateLivePlayer(paramBundle);
    if ((-1 != localV2TXJSAdapterError.errorCode) && (-3 != localV2TXJSAdapterError.errorCode)) {
      ac(paramBundle);
    }
    paramBundle = new k(localV2TXJSAdapterError);
    AppMethodBeat.o(326167);
    return paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.q
 * JD-Core Version:    0.7.0.1
 */