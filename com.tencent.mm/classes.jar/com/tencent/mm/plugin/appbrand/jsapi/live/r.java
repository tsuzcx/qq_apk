package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLivePusher.ITXAudioVolumeEvaluationListener;
import com.tencent.rtmp.TXLivePusher.ITXSnapshotListener;
import com.tencent.rtmp.TXLivePusher.OnBGMNotify;
import com.tencent.rtmp.ui.TXCloudVideoView;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/live/TXLivePusherJSAdapter;", "Lcom/tencent/mm/plugin/appbrand/jsapi/live/ITXLivePusherJSAdapter;", "context", "Landroid/content/Context;", "realJsAdapter", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/jsapi/live/ITXLivePusherJSAdapter;)V", "enterBackground", "Lcom/tencent/mm/plugin/appbrand/jsapi/live/TXJSAdapterError;", "forceStop", "", "enterForeground", "initLivePusher", "videoView", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "params", "Landroid/os/Bundle;", "notifyOrientationChanged", "", "angle", "", "operateLivePusher", "operateName", "", "Lorg/json/JSONObject;", "setAudioVolumeListener", "listener", "Lcom/tencent/rtmp/TXLivePusher$ITXAudioVolumeEvaluationListener;", "setBGMNotifyListener", "Lcom/tencent/rtmp/TXLivePusher$OnBGMNotify;", "setPushListener", "Lcom/tencent/rtmp/ITXLivePushListener;", "setSnapshotListener", "Lcom/tencent/rtmp/TXLivePusher$ITXSnapshotListener;", "unInitLivePusher", "updateLivePusher", "luggage-qcloud-live-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r
  implements b
{
  public r(Context paramContext, byte paramByte)
  {
    this(paramContext);
  }
  
  private r(b paramb)
  {
    AppMethodBeat.i(326138);
    this.sbs = paramb;
    AppMethodBeat.o(326138);
  }
  
  public final k aud()
  {
    AppMethodBeat.i(145926);
    k localk = this.sbs.aud();
    AppMethodBeat.o(145926);
    return localk;
  }
  
  public final k aup()
  {
    AppMethodBeat.i(326185);
    k localk = this.sbs.aup();
    AppMethodBeat.o(326185);
    return localk;
  }
  
  public final k b(TXCloudVideoView paramTXCloudVideoView, Bundle paramBundle)
  {
    AppMethodBeat.i(326157);
    paramTXCloudVideoView = this.sbs.b(paramTXCloudVideoView, paramBundle);
    AppMethodBeat.o(326157);
    return paramTXCloudVideoView;
  }
  
  public final k cT(boolean paramBoolean)
  {
    AppMethodBeat.i(145925);
    k localk = this.sbs.cT(paramBoolean);
    AppMethodBeat.o(145925);
    return localk;
  }
  
  public final k e(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145921);
    paramString = this.sbs.e(paramString, paramJSONObject);
    AppMethodBeat.o(145921);
    return paramString;
  }
  
  public final void notifyOrientationChanged(int paramInt)
  {
    AppMethodBeat.i(145919);
    this.sbs.notifyOrientationChanged(paramInt);
    AppMethodBeat.o(145919);
  }
  
  public final void setAudioVolumeListener(TXLivePusher.ITXAudioVolumeEvaluationListener paramITXAudioVolumeEvaluationListener)
  {
    AppMethodBeat.i(326172);
    this.sbs.setAudioVolumeListener(paramITXAudioVolumeEvaluationListener);
    AppMethodBeat.o(326172);
  }
  
  public final void setBGMNotifyListener(TXLivePusher.OnBGMNotify paramOnBGMNotify)
  {
    AppMethodBeat.i(326177);
    this.sbs.setBGMNotifyListener(paramOnBGMNotify);
    AppMethodBeat.o(326177);
  }
  
  public final void setPushListener(ITXLivePushListener paramITXLivePushListener)
  {
    AppMethodBeat.i(326180);
    this.sbs.setPushListener(paramITXLivePushListener);
    AppMethodBeat.o(326180);
  }
  
  public final void setSnapshotListener(TXLivePusher.ITXSnapshotListener paramITXSnapshotListener)
  {
    AppMethodBeat.i(326182);
    this.sbs.setSnapshotListener(paramITXSnapshotListener);
    AppMethodBeat.o(326182);
  }
  
  public final k z(Bundle paramBundle)
  {
    AppMethodBeat.i(326188);
    paramBundle = this.sbs.z(paramBundle);
    AppMethodBeat.o(326188);
    return paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.r
 * JD-Core Version:    0.7.0.1
 */