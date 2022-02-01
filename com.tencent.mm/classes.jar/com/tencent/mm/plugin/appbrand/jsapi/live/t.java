package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.content.Context;
import android.os.Bundle;
import com.tencent.live2.jsplugin.pusher.V2TXLivePusherJSAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLivePusher.ITXAudioVolumeEvaluationListener;
import com.tencent.rtmp.TXLivePusher.ITXSnapshotListener;
import com.tencent.rtmp.TXLivePusher.OnBGMNotify;
import com.tencent.rtmp.ui.TXCloudVideoView;
import org.json.JSONObject;

public class t
  implements b
{
  private boolean cIG;
  private boolean cIH;
  protected V2TXLivePusherJSAdapter oVW;
  
  public t(Context paramContext)
  {
    AppMethodBeat.i(212837);
    this.cIG = false;
    this.cIH = false;
    this.oVW = new V2TXLivePusherJSAdapter(paramContext);
    AppMethodBeat.o(212837);
  }
  
  public k TK()
  {
    AppMethodBeat.i(212853);
    k localk = new k(this.oVW.unInitLivePusher());
    AppMethodBeat.o(212853);
    return localk;
  }
  
  public final k Ty()
  {
    AppMethodBeat.i(212857);
    if (this.cIG)
    {
      if (this.cIH)
      {
        localk = e("start", null);
        AppMethodBeat.o(212857);
        return localk;
      }
      localk = e("resume", null);
      AppMethodBeat.o(212857);
      return localk;
    }
    k localk = new k();
    AppMethodBeat.o(212857);
    return localk;
  }
  
  public k b(TXCloudVideoView paramTXCloudVideoView, Bundle paramBundle)
  {
    AppMethodBeat.i(212849);
    paramTXCloudVideoView = new k(this.oVW.initLivePusher(paramTXCloudVideoView, paramBundle));
    AppMethodBeat.o(212849);
    return paramTXCloudVideoView;
  }
  
  public final k cn(boolean paramBoolean)
  {
    AppMethodBeat.i(212855);
    this.cIG = this.oVW.isPushing();
    if (this.cIG)
    {
      if (paramBoolean)
      {
        this.cIH = paramBoolean;
        localk = e("stop", null);
        AppMethodBeat.o(212855);
        return localk;
      }
      localk = e("pause", null);
      AppMethodBeat.o(212855);
      return localk;
    }
    k localk = new k();
    AppMethodBeat.o(212855);
    return localk;
  }
  
  public k e(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(212852);
    paramString = new k(this.oVW.operateLivePusher(paramString, paramJSONObject));
    AppMethodBeat.o(212852);
    return paramString;
  }
  
  public final void notifyOrientationChanged(int paramInt)
  {
    AppMethodBeat.i(212839);
    this.oVW.notifyOrientationChanged(paramInt);
    AppMethodBeat.o(212839);
  }
  
  public final void setAudioVolumeListener(TXLivePusher.ITXAudioVolumeEvaluationListener paramITXAudioVolumeEvaluationListener)
  {
    AppMethodBeat.i(212845);
    this.oVW.setAudioVolumeListener(paramITXAudioVolumeEvaluationListener);
    AppMethodBeat.o(212845);
  }
  
  public final void setBGMNotifyListener(TXLivePusher.OnBGMNotify paramOnBGMNotify)
  {
    AppMethodBeat.i(212843);
    this.oVW.setBGMNotifyListener(paramOnBGMNotify);
    AppMethodBeat.o(212843);
  }
  
  public void setPushListener(ITXLivePushListener paramITXLivePushListener)
  {
    AppMethodBeat.i(212841);
    this.oVW.setPushListener(paramITXLivePushListener);
    AppMethodBeat.o(212841);
  }
  
  public final void setSnapshotListener(TXLivePusher.ITXSnapshotListener paramITXSnapshotListener)
  {
    AppMethodBeat.i(212847);
    this.oVW.setSnapshotListener(paramITXSnapshotListener);
    AppMethodBeat.o(212847);
  }
  
  public k u(Bundle paramBundle)
  {
    AppMethodBeat.i(212850);
    paramBundle = new k(this.oVW.updateLivePusher(paramBundle));
    AppMethodBeat.o(212850);
    return paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.t
 * JD-Core Version:    0.7.0.1
 */