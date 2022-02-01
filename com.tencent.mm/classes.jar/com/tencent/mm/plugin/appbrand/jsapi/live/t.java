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
  private boolean eCm;
  private boolean eCn;
  protected V2TXLivePusherJSAdapter sbu;
  
  public t(Context paramContext)
  {
    AppMethodBeat.i(326144);
    this.eCm = false;
    this.eCn = false;
    this.sbu = new V2TXLivePusherJSAdapter(paramContext);
    AppMethodBeat.o(326144);
  }
  
  public final k aud()
  {
    AppMethodBeat.i(326194);
    if (this.eCm)
    {
      if (this.eCn)
      {
        localk = e("start", null);
        AppMethodBeat.o(326194);
        return localk;
      }
      localk = e("resume", null);
      AppMethodBeat.o(326194);
      return localk;
    }
    k localk = new k();
    AppMethodBeat.o(326194);
    return localk;
  }
  
  public k aup()
  {
    AppMethodBeat.i(326186);
    k localk = new k(this.sbu.unInitLivePusher());
    AppMethodBeat.o(326186);
    return localk;
  }
  
  public k b(TXCloudVideoView paramTXCloudVideoView, Bundle paramBundle)
  {
    AppMethodBeat.i(326175);
    paramTXCloudVideoView = new k(this.sbu.initLivePusher(paramTXCloudVideoView, paramBundle));
    AppMethodBeat.o(326175);
    return paramTXCloudVideoView;
  }
  
  public final k cT(boolean paramBoolean)
  {
    AppMethodBeat.i(326189);
    this.eCm = this.sbu.isPushing();
    if (this.eCm)
    {
      if (paramBoolean)
      {
        this.eCn = paramBoolean;
        localk = e("stop", null);
        AppMethodBeat.o(326189);
        return localk;
      }
      localk = e("pause", null);
      AppMethodBeat.o(326189);
      return localk;
    }
    k localk = new k();
    AppMethodBeat.o(326189);
    return localk;
  }
  
  public k e(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(326183);
    paramString = new k(this.sbu.operateLivePusher(paramString, paramJSONObject));
    AppMethodBeat.o(326183);
    return paramString;
  }
  
  public final void notifyOrientationChanged(int paramInt)
  {
    AppMethodBeat.i(326149);
    this.sbu.notifyOrientationChanged(paramInt);
    AppMethodBeat.o(326149);
  }
  
  public final void setAudioVolumeListener(TXLivePusher.ITXAudioVolumeEvaluationListener paramITXAudioVolumeEvaluationListener)
  {
    AppMethodBeat.i(326166);
    this.sbu.setAudioVolumeListener(paramITXAudioVolumeEvaluationListener);
    AppMethodBeat.o(326166);
  }
  
  public final void setBGMNotifyListener(TXLivePusher.OnBGMNotify paramOnBGMNotify)
  {
    AppMethodBeat.i(326160);
    this.sbu.setBGMNotifyListener(paramOnBGMNotify);
    AppMethodBeat.o(326160);
  }
  
  public void setPushListener(ITXLivePushListener paramITXLivePushListener)
  {
    AppMethodBeat.i(326154);
    this.sbu.setPushListener(paramITXLivePushListener);
    AppMethodBeat.o(326154);
  }
  
  public final void setSnapshotListener(TXLivePusher.ITXSnapshotListener paramITXSnapshotListener)
  {
    AppMethodBeat.i(326169);
    this.sbu.setSnapshotListener(paramITXSnapshotListener);
    AppMethodBeat.o(326169);
  }
  
  public k z(Bundle paramBundle)
  {
    AppMethodBeat.i(326179);
    paramBundle = new k(this.sbu.updateLivePusher(paramBundle));
    AppMethodBeat.o(326179);
    return paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.t
 * JD-Core Version:    0.7.0.1
 */