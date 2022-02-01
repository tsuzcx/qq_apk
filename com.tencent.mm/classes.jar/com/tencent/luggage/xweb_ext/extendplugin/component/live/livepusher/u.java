package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.live.k;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLivePusher.ITXAudioVolumeEvaluationListener;
import com.tencent.rtmp.TXLivePusher.ITXSnapshotListener;
import com.tencent.rtmp.TXLivePusher.OnBGMNotify;
import com.tencent.rtmp.ui.TXCloudVideoView;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/TXLivePusherJSAdapter;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/ITXLivePusherJSAdapterSameLayerSupport;", "context", "Landroid/content/Context;", "realJsAdapter", "(Landroid/content/Context;Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/ITXLivePusherJSAdapterSameLayerSupport;)V", "enterBackground", "Lcom/tencent/mm/plugin/appbrand/jsapi/live/TXJSAdapterError;", "forceStop", "", "enterForeground", "getMaxZoom", "", "initLivePusher", "params", "Landroid/os/Bundle;", "videoView", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "notifyOrientationChanged", "", "angle", "operateLivePusher", "operateName", "", "Lorg/json/JSONObject;", "sendHandupStop", "sendWeChatStop", "setAudioVolumeListener", "listener", "Lcom/tencent/rtmp/TXLivePusher$ITXAudioVolumeEvaluationListener;", "setBGMNotifyListener", "Lcom/tencent/rtmp/TXLivePusher$OnBGMNotify;", "setFocusPosition", "x", "", "y", "setPushListener", "Lcom/tencent/rtmp/ITXLivePushListener;", "setSnapshotListener", "Lcom/tencent/rtmp/TXLivePusher$ITXSnapshotListener;", "setSurface", "surface", "Landroid/view/Surface;", "setSurfaceSize", "width", "height", "setThreadHandler", "handler", "Landroid/os/Handler;", "setZoom", "value", "unInitLivePusher", "updateLivePusher", "Companion", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class u
  implements m
{
  public static final u.a eCf;
  
  static
  {
    AppMethodBeat.i(220867);
    eCf = new u.a((byte)0);
    AppMethodBeat.o(220867);
  }
  
  public u(Context paramContext, byte paramByte)
  {
    this(paramContext);
  }
  
  private u(m paramm)
  {
    AppMethodBeat.i(220833);
    this.eCg = paramm;
    AppMethodBeat.o(220833);
  }
  
  public static final void a(p.b paramb)
  {
    AppMethodBeat.i(220860);
    s.u(paramb, "weEffectFactory");
    if (com.tencent.mm.plugin.appbrand.jsapi.live.m.csD())
    {
      x.a(paramb);
      AppMethodBeat.o(220860);
      return;
    }
    v.a(paramb);
    AppMethodBeat.o(220860);
  }
  
  public final k aa(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(220957);
    k localk = this.eCg.aa(paramFloat1, paramFloat2);
    AppMethodBeat.o(220957);
    return localk;
  }
  
  public final void atU()
  {
    AppMethodBeat.i(220935);
    this.eCg.atU();
    AppMethodBeat.o(220935);
  }
  
  public final void atV()
  {
    AppMethodBeat.i(220943);
    this.eCg.atV();
    AppMethodBeat.o(220943);
  }
  
  public final k aud()
  {
    AppMethodBeat.i(220885);
    k localk = this.eCg.aud();
    AppMethodBeat.o(220885);
    return localk;
  }
  
  public final k aup()
  {
    AppMethodBeat.i(220987);
    k localk = this.eCg.aup();
    AppMethodBeat.o(220987);
    return localk;
  }
  
  public final k b(TXCloudVideoView paramTXCloudVideoView, Bundle paramBundle)
  {
    AppMethodBeat.i(220913);
    paramTXCloudVideoView = this.eCg.b(paramTXCloudVideoView, paramBundle);
    AppMethodBeat.o(220913);
    return paramTXCloudVideoView;
  }
  
  public final k cT(boolean paramBoolean)
  {
    AppMethodBeat.i(220877);
    k localk = this.eCg.cT(paramBoolean);
    AppMethodBeat.o(220877);
    return localk;
  }
  
  public final k dc(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(220973);
    k localk = this.eCg.dc(paramInt1, paramInt2);
    AppMethodBeat.o(220973);
    return localk;
  }
  
  public final k e(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(220931);
    paramString = this.eCg.e(paramString, paramJSONObject);
    AppMethodBeat.o(220931);
    return paramString;
  }
  
  public final int getMaxZoom()
  {
    AppMethodBeat.i(220893);
    int i = this.eCg.getMaxZoom();
    AppMethodBeat.o(220893);
    return i;
  }
  
  public final k h(Surface paramSurface)
  {
    AppMethodBeat.i(220968);
    paramSurface = this.eCg.h(paramSurface);
    AppMethodBeat.o(220968);
    return paramSurface;
  }
  
  public final k mF(int paramInt)
  {
    AppMethodBeat.i(220982);
    k localk = this.eCg.mF(paramInt);
    AppMethodBeat.o(220982);
    return localk;
  }
  
  public final void notifyOrientationChanged(int paramInt)
  {
    AppMethodBeat.i(138901);
    this.eCg.notifyOrientationChanged(paramInt);
    AppMethodBeat.o(138901);
  }
  
  public final void setAudioVolumeListener(TXLivePusher.ITXAudioVolumeEvaluationListener paramITXAudioVolumeEvaluationListener)
  {
    AppMethodBeat.i(220950);
    this.eCg.setAudioVolumeListener(paramITXAudioVolumeEvaluationListener);
    AppMethodBeat.o(220950);
  }
  
  public final void setBGMNotifyListener(TXLivePusher.OnBGMNotify paramOnBGMNotify)
  {
    AppMethodBeat.i(220953);
    this.eCg.setBGMNotifyListener(paramOnBGMNotify);
    AppMethodBeat.o(220953);
  }
  
  public final void setPushListener(ITXLivePushListener paramITXLivePushListener)
  {
    AppMethodBeat.i(220961);
    this.eCg.setPushListener(paramITXLivePushListener);
    AppMethodBeat.o(220961);
  }
  
  public final void setSnapshotListener(TXLivePusher.ITXSnapshotListener paramITXSnapshotListener)
  {
    AppMethodBeat.i(220966);
    this.eCg.setSnapshotListener(paramITXSnapshotListener);
    AppMethodBeat.o(220966);
  }
  
  public final void setThreadHandler(Handler paramHandler)
  {
    AppMethodBeat.i(220979);
    this.eCg.setThreadHandler(paramHandler);
    AppMethodBeat.o(220979);
  }
  
  public final k y(Bundle paramBundle)
  {
    AppMethodBeat.i(220904);
    paramBundle = this.eCg.y(paramBundle);
    AppMethodBeat.o(220904);
    return paramBundle;
  }
  
  public final k z(Bundle paramBundle)
  {
    AppMethodBeat.i(220992);
    paramBundle = this.eCg.z(paramBundle);
    AppMethodBeat.o(220992);
    return paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.u
 * JD-Core Version:    0.7.0.1
 */