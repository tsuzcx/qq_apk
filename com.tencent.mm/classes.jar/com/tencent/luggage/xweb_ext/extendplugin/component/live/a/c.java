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
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/liveplayer/TXLivePlayerJSAdapter;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/liveplayer/ITXLivePlayerJSAdapterSameLayerSupport;", "context", "Landroid/content/Context;", "realJsAdapter", "(Landroid/content/Context;Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/liveplayer/ITXLivePlayerJSAdapterSameLayerSupport;)V", "enterBackground", "Lcom/tencent/mm/plugin/appbrand/jsapi/live/TXJSAdapterError;", "type", "", "enterForeground", "initLivePlayer", "params", "Landroid/os/Bundle;", "videoView", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "isMuted", "", "isPlaying", "operateLivePlayer", "operateName", "", "param", "Lorg/json/JSONObject;", "sendHandupStop", "", "sendWeChatStop", "setAudioVolumeListener", "listener", "Lcom/tencent/rtmp/TXLivePlayer$ITXAudioVolumeEvaluationListener;", "setPlayListener", "Lcom/tencent/rtmp/ITXLivePlayListener;", "setSnapshotListener", "Lcom/tencent/rtmp/TXLivePlayer$ITXSnapshotListener;", "setSurface", "surface", "Landroid/view/Surface;", "setSurfaceSize", "width", "height", "setThreadHandler", "handler", "Landroid/os/Handler;", "takePhoto", "needCompress", "uninitLivePlayer", "updateLivePlayer", "luggage-xweb-ext_release"})
public final class c
  implements a
{
  public c(Context paramContext, byte paramByte)
  {
    this(paramContext);
  }
  
  private c(a parama)
  {
    AppMethodBeat.i(222315);
    this.cFZ = parama;
    AppMethodBeat.o(222315);
  }
  
  public final k To()
  {
    AppMethodBeat.i(222320);
    k localk = this.cFZ.To();
    AppMethodBeat.o(222320);
    return localk;
  }
  
  public final void Tp()
  {
    AppMethodBeat.i(222341);
    this.cFZ.Tp();
    AppMethodBeat.o(222341);
  }
  
  public final void Tq()
  {
    AppMethodBeat.i(222343);
    this.cFZ.Tq();
    AppMethodBeat.o(222343);
  }
  
  public final k Ty()
  {
    AppMethodBeat.i(222327);
    k localk = this.cFZ.Ty();
    AppMethodBeat.o(222327);
    return localk;
  }
  
  public final k Tz()
  {
    AppMethodBeat.i(222356);
    k localk = this.cFZ.Tz();
    AppMethodBeat.o(222356);
    return localk;
  }
  
  public final k a(TXCloudVideoView paramTXCloudVideoView, Bundle paramBundle)
  {
    AppMethodBeat.i(222331);
    paramTXCloudVideoView = this.cFZ.a(paramTXCloudVideoView, paramBundle);
    AppMethodBeat.o(222331);
    return paramTXCloudVideoView;
  }
  
  public final k cn(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(222352);
    k localk = this.cFZ.cn(paramInt1, paramInt2);
    AppMethodBeat.o(222352);
    return localk;
  }
  
  public final k d(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(222339);
    paramString = this.cFZ.d(paramString, paramJSONObject);
    AppMethodBeat.o(222339);
    return paramString;
  }
  
  public final k e(Surface paramSurface)
  {
    AppMethodBeat.i(222350);
    paramSurface = this.cFZ.e(paramSurface);
    AppMethodBeat.o(222350);
    return paramSurface;
  }
  
  public final k iY(int paramInt)
  {
    AppMethodBeat.i(222322);
    k localk = this.cFZ.iY(paramInt);
    AppMethodBeat.o(222322);
    return localk;
  }
  
  public final boolean isMuted()
  {
    AppMethodBeat.i(222334);
    boolean bool = this.cFZ.isMuted();
    AppMethodBeat.o(222334);
    return bool;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(222335);
    boolean bool = this.cFZ.isPlaying();
    AppMethodBeat.o(222335);
    return bool;
  }
  
  public final k p(Bundle paramBundle)
  {
    AppMethodBeat.i(222329);
    paramBundle = this.cFZ.p(paramBundle);
    AppMethodBeat.o(222329);
    return paramBundle;
  }
  
  public final k q(Bundle paramBundle)
  {
    AppMethodBeat.i(222358);
    paramBundle = this.cFZ.q(paramBundle);
    AppMethodBeat.o(222358);
    return paramBundle;
  }
  
  public final void setAudioVolumeListener(TXLivePlayer.ITXAudioVolumeEvaluationListener paramITXAudioVolumeEvaluationListener)
  {
    AppMethodBeat.i(222344);
    this.cFZ.setAudioVolumeListener(paramITXAudioVolumeEvaluationListener);
    AppMethodBeat.o(222344);
  }
  
  public final void setPlayListener(ITXLivePlayListener paramITXLivePlayListener)
  {
    AppMethodBeat.i(222346);
    this.cFZ.setPlayListener(paramITXLivePlayListener);
    AppMethodBeat.o(222346);
  }
  
  public final void setSnapshotListener(TXLivePlayer.ITXSnapshotListener paramITXSnapshotListener)
  {
    AppMethodBeat.i(222348);
    this.cFZ.setSnapshotListener(paramITXSnapshotListener);
    AppMethodBeat.o(222348);
  }
  
  public final void setThreadHandler(Handler paramHandler)
  {
    AppMethodBeat.i(222354);
    this.cFZ.setThreadHandler(paramHandler);
    AppMethodBeat.o(222354);
  }
  
  public final void takePhoto(boolean paramBoolean, TXLivePlayer.ITXSnapshotListener paramITXSnapshotListener)
  {
    AppMethodBeat.i(138843);
    this.cFZ.takePhoto(paramBoolean, paramITXSnapshotListener);
    AppMethodBeat.o(138843);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.a.c
 * JD-Core Version:    0.7.0.1
 */