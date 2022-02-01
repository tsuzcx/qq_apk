package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.os.Bundle;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLivePusher.ITXAudioVolumeEvaluationListener;
import com.tencent.rtmp.TXLivePusher.ITXSnapshotListener;
import com.tencent.rtmp.TXLivePusher.OnBGMNotify;
import com.tencent.rtmp.ui.TXCloudVideoView;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/live/ITXLivePusherJSAdapter;", "", "enterBackground", "Lcom/tencent/mm/plugin/appbrand/jsapi/live/TXJSAdapterError;", "forceStop", "", "enterForeground", "initLivePusher", "videoView", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "params", "Landroid/os/Bundle;", "notifyOrientationChanged", "", "angle", "", "operateLivePusher", "operateName", "", "Lorg/json/JSONObject;", "setAudioVolumeListener", "listener", "Lcom/tencent/rtmp/TXLivePusher$ITXAudioVolumeEvaluationListener;", "setBGMNotifyListener", "Lcom/tencent/rtmp/TXLivePusher$OnBGMNotify;", "setPushListener", "Lcom/tencent/rtmp/ITXLivePushListener;", "setSnapshotListener", "Lcom/tencent/rtmp/TXLivePusher$ITXSnapshotListener;", "unInitLivePusher", "updateLivePusher", "luggage-qcloud-live-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface b
{
  public abstract k aud();
  
  public abstract k aup();
  
  public abstract k b(TXCloudVideoView paramTXCloudVideoView, Bundle paramBundle);
  
  public abstract k cT(boolean paramBoolean);
  
  public abstract k e(String paramString, JSONObject paramJSONObject);
  
  public abstract void notifyOrientationChanged(int paramInt);
  
  public abstract void setAudioVolumeListener(TXLivePusher.ITXAudioVolumeEvaluationListener paramITXAudioVolumeEvaluationListener);
  
  public abstract void setBGMNotifyListener(TXLivePusher.OnBGMNotify paramOnBGMNotify);
  
  public abstract void setPushListener(ITXLivePushListener paramITXLivePushListener);
  
  public abstract void setSnapshotListener(TXLivePusher.ITXSnapshotListener paramITXSnapshotListener);
  
  public abstract k z(Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.b
 * JD-Core Version:    0.7.0.1
 */