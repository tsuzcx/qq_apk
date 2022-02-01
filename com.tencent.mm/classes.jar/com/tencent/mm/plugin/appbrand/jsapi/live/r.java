package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLivePusher.ITXAudioVolumeEvaluationListener;
import com.tencent.rtmp.TXLivePusher.ITXSnapshotListener;
import com.tencent.rtmp.TXLivePusher.OnBGMNotify;
import com.tencent.rtmp.ui.TXCloudVideoView;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/live/TXLivePusherJSAdapter;", "Lcom/tencent/mm/plugin/appbrand/jsapi/live/ITXLivePusherJSAdapter;", "context", "Landroid/content/Context;", "realJsAdapter", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/jsapi/live/ITXLivePusherJSAdapter;)V", "enterBackground", "Lcom/tencent/mm/plugin/appbrand/jsapi/live/TXJSAdapterError;", "forceStop", "", "enterForeground", "initLivePusher", "videoView", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "params", "Landroid/os/Bundle;", "notifyOrientationChanged", "", "angle", "", "operateLivePusher", "operateName", "", "Lorg/json/JSONObject;", "setAudioVolumeListener", "listener", "Lcom/tencent/rtmp/TXLivePusher$ITXAudioVolumeEvaluationListener;", "setBGMNotifyListener", "Lcom/tencent/rtmp/TXLivePusher$OnBGMNotify;", "setPushListener", "Lcom/tencent/rtmp/ITXLivePushListener;", "setSnapshotListener", "Lcom/tencent/rtmp/TXLivePusher$ITXSnapshotListener;", "unInitLivePusher", "updateLivePusher", "luggage-qcloud-live-ext_release"})
public final class r
  implements b
{
  public r(Context paramContext, byte paramByte)
  {
    this(paramContext);
  }
  
  private r(b paramb)
  {
    AppMethodBeat.i(212671);
    this.oVU = paramb;
    AppMethodBeat.o(212671);
  }
  
  public final k TK()
  {
    AppMethodBeat.i(212698);
    k localk = this.oVU.TK();
    AppMethodBeat.o(212698);
    return localk;
  }
  
  public final k Ty()
  {
    AppMethodBeat.i(145926);
    k localk = this.oVU.Ty();
    AppMethodBeat.o(145926);
    return localk;
  }
  
  public final k b(TXCloudVideoView paramTXCloudVideoView, Bundle paramBundle)
  {
    AppMethodBeat.i(212684);
    paramTXCloudVideoView = this.oVU.b(paramTXCloudVideoView, paramBundle);
    AppMethodBeat.o(212684);
    return paramTXCloudVideoView;
  }
  
  public final k cn(boolean paramBoolean)
  {
    AppMethodBeat.i(145925);
    k localk = this.oVU.cn(paramBoolean);
    AppMethodBeat.o(145925);
    return localk;
  }
  
  public final k e(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145921);
    paramString = this.oVU.e(paramString, paramJSONObject);
    AppMethodBeat.o(145921);
    return paramString;
  }
  
  public final void notifyOrientationChanged(int paramInt)
  {
    AppMethodBeat.i(145919);
    this.oVU.notifyOrientationChanged(paramInt);
    AppMethodBeat.o(145919);
  }
  
  public final void setAudioVolumeListener(TXLivePusher.ITXAudioVolumeEvaluationListener paramITXAudioVolumeEvaluationListener)
  {
    AppMethodBeat.i(212690);
    this.oVU.setAudioVolumeListener(paramITXAudioVolumeEvaluationListener);
    AppMethodBeat.o(212690);
  }
  
  public final void setBGMNotifyListener(TXLivePusher.OnBGMNotify paramOnBGMNotify)
  {
    AppMethodBeat.i(212692);
    this.oVU.setBGMNotifyListener(paramOnBGMNotify);
    AppMethodBeat.o(212692);
  }
  
  public final void setPushListener(ITXLivePushListener paramITXLivePushListener)
  {
    AppMethodBeat.i(212694);
    this.oVU.setPushListener(paramITXLivePushListener);
    AppMethodBeat.o(212694);
  }
  
  public final void setSnapshotListener(TXLivePusher.ITXSnapshotListener paramITXSnapshotListener)
  {
    AppMethodBeat.i(212696);
    this.oVU.setSnapshotListener(paramITXSnapshotListener);
    AppMethodBeat.o(212696);
  }
  
  public final k u(Bundle paramBundle)
  {
    AppMethodBeat.i(212700);
    paramBundle = this.oVU.u(paramBundle);
    AppMethodBeat.o(212700);
    return paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.r
 * JD-Core Version:    0.7.0.1
 */