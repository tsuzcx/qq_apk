package com.tencent.luggage.xweb_ext.extendplugin.component.live.a;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.live.k;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayer.ITXAudioVolumeEvaluationListener;
import com.tencent.rtmp.TXLivePlayer.ITXSnapshotListener;
import com.tencent.rtmp.ui.TXCloudVideoView;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/liveplayer/TXLivePlayerJSAdapter;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/liveplayer/ITXLivePlayerJSAdapterSameLayerSupport;", "context", "Landroid/content/Context;", "realJsAdapter", "(Landroid/content/Context;Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/liveplayer/ITXLivePlayerJSAdapterSameLayerSupport;)V", "enterBackground", "Lcom/tencent/mm/plugin/appbrand/jsapi/live/TXJSAdapterError;", "type", "", "enterForeground", "initLivePlayer", "params", "Landroid/os/Bundle;", "videoView", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "isMuted", "", "isPlaying", "operateLivePlayer", "operateName", "", "param", "Lorg/json/JSONObject;", "sendHandupStop", "", "sendWeChatStop", "setAudioVolumeListener", "listener", "Lcom/tencent/rtmp/TXLivePlayer$ITXAudioVolumeEvaluationListener;", "setPlayListener", "Lcom/tencent/rtmp/ITXLivePlayListener;", "setSnapshotListener", "Lcom/tencent/rtmp/TXLivePlayer$ITXSnapshotListener;", "setSurface", "surface", "Landroid/view/Surface;", "setSurfaceSize", "width", "height", "setThreadHandler", "handler", "Landroid/os/Handler;", "takePhoto", "needCompress", "uninitLivePlayer", "updateLivePlayer", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements a
{
  public c(Context paramContext, byte paramByte)
  {
    this(paramContext);
  }
  
  private c(a parama)
  {
    AppMethodBeat.i(220654);
    this.ezn = parama;
    AppMethodBeat.o(220654);
  }
  
  public final k a(TXCloudVideoView paramTXCloudVideoView, Bundle paramBundle)
  {
    AppMethodBeat.i(220690);
    paramTXCloudVideoView = this.ezn.a(paramTXCloudVideoView, paramBundle);
    AppMethodBeat.o(220690);
    return paramTXCloudVideoView;
  }
  
  public final k atT()
  {
    AppMethodBeat.i(220665);
    k localk = this.ezn.atT();
    AppMethodBeat.o(220665);
    return localk;
  }
  
  public final void atU()
  {
    AppMethodBeat.i(220710);
    this.ezn.atU();
    AppMethodBeat.o(220710);
  }
  
  public final void atV()
  {
    AppMethodBeat.i(220715);
    this.ezn.atV();
    AppMethodBeat.o(220715);
  }
  
  public final k aud()
  {
    AppMethodBeat.i(220679);
    k localk = this.ezn.aud();
    AppMethodBeat.o(220679);
    return localk;
  }
  
  public final k aue()
  {
    AppMethodBeat.i(220755);
    k localk = this.ezn.aue();
    AppMethodBeat.o(220755);
    return localk;
  }
  
  public final k d(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(220706);
    paramString = this.ezn.d(paramString, paramJSONObject);
    AppMethodBeat.o(220706);
    return paramString;
  }
  
  public final k dc(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(220736);
    k localk = this.ezn.dc(paramInt1, paramInt2);
    AppMethodBeat.o(220736);
    return localk;
  }
  
  public final k h(Surface paramSurface)
  {
    AppMethodBeat.i(220731);
    paramSurface = this.ezn.h(paramSurface);
    AppMethodBeat.o(220731);
    return paramSurface;
  }
  
  public final boolean isMuted()
  {
    AppMethodBeat.i(220698);
    boolean bool = this.ezn.isMuted();
    AppMethodBeat.o(220698);
    return bool;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(220701);
    boolean bool = this.ezn.isPlaying();
    AppMethodBeat.o(220701);
    return bool;
  }
  
  public final k mA(int paramInt)
  {
    AppMethodBeat.i(220674);
    k localk = this.ezn.mA(paramInt);
    AppMethodBeat.o(220674);
    return localk;
  }
  
  public final void setAudioVolumeListener(TXLivePlayer.ITXAudioVolumeEvaluationListener paramITXAudioVolumeEvaluationListener)
  {
    AppMethodBeat.i(220719);
    this.ezn.setAudioVolumeListener(paramITXAudioVolumeEvaluationListener);
    AppMethodBeat.o(220719);
  }
  
  public final void setPlayListener(ITXLivePlayListener paramITXLivePlayListener)
  {
    AppMethodBeat.i(220721);
    this.ezn.setPlayListener(paramITXLivePlayListener);
    AppMethodBeat.o(220721);
  }
  
  public final void setSnapshotListener(TXLivePlayer.ITXSnapshotListener paramITXSnapshotListener)
  {
    AppMethodBeat.i(220725);
    this.ezn.setSnapshotListener(paramITXSnapshotListener);
    AppMethodBeat.o(220725);
  }
  
  public final void setThreadHandler(Handler paramHandler)
  {
    AppMethodBeat.i(220741);
    this.ezn.setThreadHandler(paramHandler);
    AppMethodBeat.o(220741);
  }
  
  public final void takePhoto(boolean paramBoolean, TXLivePlayer.ITXSnapshotListener paramITXSnapshotListener)
  {
    AppMethodBeat.i(138843);
    this.ezn.takePhoto(paramBoolean, paramITXSnapshotListener);
    AppMethodBeat.o(138843);
  }
  
  public final k u(Bundle paramBundle)
  {
    AppMethodBeat.i(220684);
    paramBundle = this.ezn.u(paramBundle);
    AppMethodBeat.o(220684);
    return paramBundle;
  }
  
  public final k v(Bundle paramBundle)
  {
    AppMethodBeat.i(220760);
    paramBundle = this.ezn.v(paramBundle);
    AppMethodBeat.o(220760);
    return paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.a.c
 * JD-Core Version:    0.7.0.1
 */