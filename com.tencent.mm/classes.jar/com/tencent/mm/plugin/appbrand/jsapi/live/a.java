package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.os.Bundle;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayer.ITXAudioVolumeEvaluationListener;
import com.tencent.rtmp.TXLivePlayer.ITXSnapshotListener;
import com.tencent.rtmp.ui.TXCloudVideoView;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/live/ITXLivePlayerJSAdapter;", "", "enterBackground", "Lcom/tencent/mm/plugin/appbrand/jsapi/live/TXJSAdapterError;", "type", "", "enterForeground", "initLivePlayer", "videoView", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "params", "Landroid/os/Bundle;", "operateLivePlayer", "operateName", "", "param", "Lorg/json/JSONObject;", "setAudioVolumeListener", "", "listener", "Lcom/tencent/rtmp/TXLivePlayer$ITXAudioVolumeEvaluationListener;", "setPlayListener", "Lcom/tencent/rtmp/ITXLivePlayListener;", "setSnapshotListener", "Lcom/tencent/rtmp/TXLivePlayer$ITXSnapshotListener;", "takePhoto", "needCompress", "", "uninitLivePlayer", "updateLivePlayer", "luggage-qcloud-live-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface a
{
  public abstract k a(TXCloudVideoView paramTXCloudVideoView, Bundle paramBundle);
  
  public abstract k aud();
  
  public abstract k aue();
  
  public abstract k d(String paramString, JSONObject paramJSONObject);
  
  public abstract k mA(int paramInt);
  
  public abstract void setAudioVolumeListener(TXLivePlayer.ITXAudioVolumeEvaluationListener paramITXAudioVolumeEvaluationListener);
  
  public abstract void setPlayListener(ITXLivePlayListener paramITXLivePlayListener);
  
  public abstract void setSnapshotListener(TXLivePlayer.ITXSnapshotListener paramITXSnapshotListener);
  
  public abstract void takePhoto(boolean paramBoolean, TXLivePlayer.ITXSnapshotListener paramITXSnapshotListener);
  
  public abstract k v(Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.a
 * JD-Core Version:    0.7.0.1
 */