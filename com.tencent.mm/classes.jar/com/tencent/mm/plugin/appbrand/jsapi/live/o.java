package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayer.ITXAudioVolumeEvaluationListener;
import com.tencent.rtmp.TXLivePlayer.ITXSnapshotListener;
import com.tencent.rtmp.ui.TXCloudVideoView;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/live/TXLivePlayerJSAdapter;", "Lcom/tencent/mm/plugin/appbrand/jsapi/live/ITXLivePlayerJSAdapter;", "context", "Landroid/content/Context;", "realJsAdapter", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/jsapi/live/ITXLivePlayerJSAdapter;)V", "enterBackground", "Lcom/tencent/mm/plugin/appbrand/jsapi/live/TXJSAdapterError;", "type", "", "enterForeground", "initLivePlayer", "videoView", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "params", "Landroid/os/Bundle;", "operateLivePlayer", "operateName", "", "param", "Lorg/json/JSONObject;", "setAudioVolumeListener", "", "listener", "Lcom/tencent/rtmp/TXLivePlayer$ITXAudioVolumeEvaluationListener;", "setPlayListener", "Lcom/tencent/rtmp/ITXLivePlayListener;", "setSnapshotListener", "Lcom/tencent/rtmp/TXLivePlayer$ITXSnapshotListener;", "takePhoto", "needCompress", "", "uninitLivePlayer", "updateLivePlayer", "luggage-qcloud-live-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
  implements a
{
  public o(Context paramContext, byte paramByte)
  {
    this(paramContext);
  }
  
  private o(a parama)
  {
    AppMethodBeat.i(326129);
    this.sbo = parama;
    AppMethodBeat.o(326129);
  }
  
  public final k a(TXCloudVideoView paramTXCloudVideoView, Bundle paramBundle)
  {
    AppMethodBeat.i(326140);
    paramTXCloudVideoView = this.sbo.a(paramTXCloudVideoView, paramBundle);
    AppMethodBeat.o(326140);
    return paramTXCloudVideoView;
  }
  
  public final k aud()
  {
    AppMethodBeat.i(326137);
    k localk = this.sbo.aud();
    AppMethodBeat.o(326137);
    return localk;
  }
  
  public final k aue()
  {
    AppMethodBeat.i(326165);
    k localk = this.sbo.aue();
    AppMethodBeat.o(326165);
    return localk;
  }
  
  public final k d(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145907);
    paramString = this.sbo.d(paramString, paramJSONObject);
    AppMethodBeat.o(145907);
    return paramString;
  }
  
  public final k mA(int paramInt)
  {
    AppMethodBeat.i(326133);
    k localk = this.sbo.mA(paramInt);
    AppMethodBeat.o(326133);
    return localk;
  }
  
  public final void setAudioVolumeListener(TXLivePlayer.ITXAudioVolumeEvaluationListener paramITXAudioVolumeEvaluationListener)
  {
    AppMethodBeat.i(326146);
    this.sbo.setAudioVolumeListener(paramITXAudioVolumeEvaluationListener);
    AppMethodBeat.o(326146);
  }
  
  public final void setPlayListener(ITXLivePlayListener paramITXLivePlayListener)
  {
    AppMethodBeat.i(326151);
    this.sbo.setPlayListener(paramITXLivePlayListener);
    AppMethodBeat.o(326151);
  }
  
  public final void setSnapshotListener(TXLivePlayer.ITXSnapshotListener paramITXSnapshotListener)
  {
    AppMethodBeat.i(326155);
    this.sbo.setSnapshotListener(paramITXSnapshotListener);
    AppMethodBeat.o(326155);
  }
  
  public final void takePhoto(boolean paramBoolean, TXLivePlayer.ITXSnapshotListener paramITXSnapshotListener)
  {
    AppMethodBeat.i(145908);
    this.sbo.takePhoto(paramBoolean, paramITXSnapshotListener);
    AppMethodBeat.o(145908);
  }
  
  public final k v(Bundle paramBundle)
  {
    AppMethodBeat.i(326170);
    paramBundle = this.sbo.v(paramBundle);
    AppMethodBeat.o(326170);
    return paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.o
 * JD-Core Version:    0.7.0.1
 */