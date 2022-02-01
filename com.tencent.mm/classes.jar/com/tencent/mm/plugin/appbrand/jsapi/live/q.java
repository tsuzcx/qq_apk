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
  private boolean cFq;
  private boolean cFr;
  protected ITXLivePlayListener cGc;
  private boolean cGk;
  private boolean oVR;
  protected V2TXLivePlayerJSAdapter oVT;
  
  public q(Context paramContext)
  {
    AppMethodBeat.i(212507);
    this.oVR = false;
    this.cGk = false;
    this.cFq = true;
    this.cFr = true;
    this.oVT = new V2TXLivePlayerJSAdapter(paramContext);
    AppMethodBeat.o(212507);
  }
  
  private void R(Bundle paramBundle)
  {
    AppMethodBeat.i(212510);
    this.cGk = paramBundle.getBoolean("needEvent", this.cGk);
    this.cFq = paramBundle.getBoolean("autoPauseIfNavigate", this.cFq);
    this.cFr = paramBundle.getBoolean("autoPauseIfOpenNative", this.cFr);
    AppMethodBeat.o(212510);
  }
  
  public k Ty()
  {
    AppMethodBeat.i(212534);
    if (this.oVR)
    {
      localk = d("resume", null);
      AppMethodBeat.o(212534);
      return localk;
    }
    k localk = new k();
    AppMethodBeat.o(212534);
    return localk;
  }
  
  public final k Tz()
  {
    AppMethodBeat.i(212533);
    k localk = new k(this.oVT.uninitLivePlayer());
    AppMethodBeat.o(212533);
    return localk;
  }
  
  public k a(TXCloudVideoView paramTXCloudVideoView, Bundle paramBundle)
  {
    AppMethodBeat.i(212525);
    paramTXCloudVideoView = this.oVT.initLivePlayer(paramTXCloudVideoView, paramBundle);
    if (-1 != paramTXCloudVideoView.errorCode) {
      R(paramBundle);
    }
    paramTXCloudVideoView = new k(paramTXCloudVideoView);
    AppMethodBeat.o(212525);
    return paramTXCloudVideoView;
  }
  
  public final k d(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(212530);
    paramString = new k(this.oVT.operateLivePlayer(paramString, paramJSONObject));
    AppMethodBeat.o(212530);
    return paramString;
  }
  
  public final k iY(int paramInt)
  {
    AppMethodBeat.i(212537);
    Log.i("TXLivePlayerJSAdapterV2", "enterBackground");
    if (((paramInt == 2) && (!this.cFr)) || ((paramInt == 1) && (!this.cFq)))
    {
      this.oVR = false;
      localk = new k();
      AppMethodBeat.o(212537);
      return localk;
    }
    this.oVR = this.oVT.isPlaying();
    if (this.oVR)
    {
      if ((this.cGk) && (this.cGc != null)) {
        this.cGc.onPlayEvent(6000, new Bundle());
      }
      localk = d("pause", null);
      AppMethodBeat.o(212537);
      return localk;
    }
    k localk = new k();
    AppMethodBeat.o(212537);
    return localk;
  }
  
  public k q(Bundle paramBundle)
  {
    AppMethodBeat.i(212528);
    V2TXJSAdapterError localV2TXJSAdapterError = this.oVT.updateLivePlayer(paramBundle);
    if ((-1 != localV2TXJSAdapterError.errorCode) && (-3 != localV2TXJSAdapterError.errorCode)) {
      R(paramBundle);
    }
    paramBundle = new k(localV2TXJSAdapterError);
    AppMethodBeat.o(212528);
    return paramBundle;
  }
  
  public final void setAudioVolumeListener(TXLivePlayer.ITXAudioVolumeEvaluationListener paramITXAudioVolumeEvaluationListener)
  {
    AppMethodBeat.i(212520);
    this.oVT.setAudioVolumeListener(paramITXAudioVolumeEvaluationListener);
    AppMethodBeat.o(212520);
  }
  
  public final void setPlayListener(ITXLivePlayListener paramITXLivePlayListener)
  {
    AppMethodBeat.i(212515);
    this.cGc = paramITXLivePlayListener;
    this.oVT.setPlayListener(paramITXLivePlayListener);
    AppMethodBeat.o(212515);
  }
  
  public final void setSnapshotListener(TXLivePlayer.ITXSnapshotListener paramITXSnapshotListener)
  {
    AppMethodBeat.i(212517);
    this.oVT.setSnapshotListener(paramITXSnapshotListener);
    AppMethodBeat.o(212517);
  }
  
  public final void takePhoto(boolean paramBoolean, TXLivePlayer.ITXSnapshotListener paramITXSnapshotListener)
  {
    AppMethodBeat.i(212538);
    this.oVT.takePhoto(paramBoolean, paramITXSnapshotListener);
    AppMethodBeat.o(212538);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.q
 * JD-Core Version:    0.7.0.1
 */