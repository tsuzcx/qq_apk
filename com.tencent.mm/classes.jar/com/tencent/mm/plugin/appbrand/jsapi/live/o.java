package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayer.ITXAudioVolumeEvaluationListener;
import com.tencent.rtmp.TXLivePlayer.ITXSnapshotListener;
import com.tencent.rtmp.ui.TXCloudVideoView;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/live/TXLivePlayerJSAdapter;", "Lcom/tencent/mm/plugin/appbrand/jsapi/live/ITXLivePlayerJSAdapter;", "context", "Landroid/content/Context;", "realJsAdapter", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/jsapi/live/ITXLivePlayerJSAdapter;)V", "enterBackground", "Lcom/tencent/mm/plugin/appbrand/jsapi/live/TXJSAdapterError;", "type", "", "enterForeground", "initLivePlayer", "videoView", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "params", "Landroid/os/Bundle;", "operateLivePlayer", "operateName", "", "param", "Lorg/json/JSONObject;", "setAudioVolumeListener", "", "listener", "Lcom/tencent/rtmp/TXLivePlayer$ITXAudioVolumeEvaluationListener;", "setPlayListener", "Lcom/tencent/rtmp/ITXLivePlayListener;", "setSnapshotListener", "Lcom/tencent/rtmp/TXLivePlayer$ITXSnapshotListener;", "takePhoto", "needCompress", "", "uninitLivePlayer", "updateLivePlayer", "luggage-qcloud-live-ext_release"})
public final class o
  implements a
{
  public o(Context paramContext, byte paramByte)
  {
    this(paramContext);
  }
  
  private o(a parama)
  {
    AppMethodBeat.i(213098);
    this.oVQ = parama;
    AppMethodBeat.o(213098);
  }
  
  public final k Ty()
  {
    AppMethodBeat.i(213102);
    k localk = this.oVQ.Ty();
    AppMethodBeat.o(213102);
    return localk;
  }
  
  public final k Tz()
  {
    AppMethodBeat.i(213114);
    k localk = this.oVQ.Tz();
    AppMethodBeat.o(213114);
    return localk;
  }
  
  public final k a(TXCloudVideoView paramTXCloudVideoView, Bundle paramBundle)
  {
    AppMethodBeat.i(213104);
    paramTXCloudVideoView = this.oVQ.a(paramTXCloudVideoView, paramBundle);
    AppMethodBeat.o(213104);
    return paramTXCloudVideoView;
  }
  
  public final k d(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145907);
    paramString = this.oVQ.d(paramString, paramJSONObject);
    AppMethodBeat.o(145907);
    return paramString;
  }
  
  public final k iY(int paramInt)
  {
    AppMethodBeat.i(213100);
    k localk = this.oVQ.iY(paramInt);
    AppMethodBeat.o(213100);
    return localk;
  }
  
  public final k q(Bundle paramBundle)
  {
    AppMethodBeat.i(213116);
    paramBundle = this.oVQ.q(paramBundle);
    AppMethodBeat.o(213116);
    return paramBundle;
  }
  
  public final void setAudioVolumeListener(TXLivePlayer.ITXAudioVolumeEvaluationListener paramITXAudioVolumeEvaluationListener)
  {
    AppMethodBeat.i(213105);
    this.oVQ.setAudioVolumeListener(paramITXAudioVolumeEvaluationListener);
    AppMethodBeat.o(213105);
  }
  
  public final void setPlayListener(ITXLivePlayListener paramITXLivePlayListener)
  {
    AppMethodBeat.i(213108);
    this.oVQ.setPlayListener(paramITXLivePlayListener);
    AppMethodBeat.o(213108);
  }
  
  public final void setSnapshotListener(TXLivePlayer.ITXSnapshotListener paramITXSnapshotListener)
  {
    AppMethodBeat.i(213110);
    this.oVQ.setSnapshotListener(paramITXSnapshotListener);
    AppMethodBeat.o(213110);
  }
  
  public final void takePhoto(boolean paramBoolean, TXLivePlayer.ITXSnapshotListener paramITXSnapshotListener)
  {
    AppMethodBeat.i(145908);
    this.oVQ.takePhoto(paramBoolean, paramITXSnapshotListener);
    AppMethodBeat.o(145908);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.o
 * JD-Core Version:    0.7.0.1
 */