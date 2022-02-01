package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.live.k;
import com.tencent.mm.plugin.appbrand.jsapi.live.m;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLivePusher.ITXAudioVolumeEvaluationListener;
import com.tencent.rtmp.TXLivePusher.ITXSnapshotListener;
import com.tencent.rtmp.TXLivePusher.OnBGMNotify;
import com.tencent.rtmp.ui.TXCloudVideoView;
import kotlin.g.b.p;
import org.json.JSONObject;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/TXLivePusherJSAdapter;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/ITXLivePusherJSAdapterSameLayerSupport;", "context", "Landroid/content/Context;", "realJsAdapter", "(Landroid/content/Context;Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/ITXLivePusherJSAdapterSameLayerSupport;)V", "enterBackground", "Lcom/tencent/mm/plugin/appbrand/jsapi/live/TXJSAdapterError;", "forceStop", "", "enterForeground", "getMaxZoom", "", "initLivePusher", "params", "Landroid/os/Bundle;", "videoView", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "notifyOrientationChanged", "", "angle", "operateLivePusher", "operateName", "", "Lorg/json/JSONObject;", "sendHandupStop", "sendWeChatStop", "setAudioVolumeListener", "listener", "Lcom/tencent/rtmp/TXLivePusher$ITXAudioVolumeEvaluationListener;", "setBGMNotifyListener", "Lcom/tencent/rtmp/TXLivePusher$OnBGMNotify;", "setFocusPosition", "x", "", "y", "setPushListener", "Lcom/tencent/rtmp/ITXLivePushListener;", "setSnapshotListener", "Lcom/tencent/rtmp/TXLivePusher$ITXSnapshotListener;", "setSurface", "surface", "Landroid/view/Surface;", "setSurfaceSize", "width", "height", "setThreadHandler", "handler", "Landroid/os/Handler;", "setZoom", "value", "unInitLivePusher", "updateLivePusher", "Companion", "luggage-xweb-ext_release"})
public final class s
  implements l
{
  public static final s.a cIz;
  
  static
  {
    AppMethodBeat.i(225351);
    cIz = new s.a((byte)0);
    AppMethodBeat.o(225351);
  }
  
  public s(Context paramContext, byte paramByte)
  {
    this(paramContext);
  }
  
  private s(l paraml)
  {
    AppMethodBeat.i(225349);
    this.cIA = paraml;
    AppMethodBeat.o(225349);
  }
  
  public static final void a(n.b paramb)
  {
    AppMethodBeat.i(225383);
    p.k(paramb, "weEffectFactory");
    if (m.bSw())
    {
      u.a(paramb);
      AppMethodBeat.o(225383);
      return;
    }
    t.a(paramb);
    AppMethodBeat.o(225383);
  }
  
  public final k TK()
  {
    AppMethodBeat.i(225381);
    k localk = this.cIA.TK();
    AppMethodBeat.o(225381);
    return localk;
  }
  
  public final void Tp()
  {
    AppMethodBeat.i(225364);
    this.cIA.Tp();
    AppMethodBeat.o(225364);
  }
  
  public final void Tq()
  {
    AppMethodBeat.i(225366);
    this.cIA.Tq();
    AppMethodBeat.o(225366);
  }
  
  public final k Ty()
  {
    AppMethodBeat.i(225356);
    k localk = this.cIA.Ty();
    AppMethodBeat.o(225356);
    return localk;
  }
  
  public final k b(TXCloudVideoView paramTXCloudVideoView, Bundle paramBundle)
  {
    AppMethodBeat.i(225360);
    paramTXCloudVideoView = this.cIA.b(paramTXCloudVideoView, paramBundle);
    AppMethodBeat.o(225360);
    return paramTXCloudVideoView;
  }
  
  public final k cn(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(225376);
    k localk = this.cIA.cn(paramInt1, paramInt2);
    AppMethodBeat.o(225376);
    return localk;
  }
  
  public final k cn(boolean paramBoolean)
  {
    AppMethodBeat.i(225354);
    k localk = this.cIA.cn(paramBoolean);
    AppMethodBeat.o(225354);
    return localk;
  }
  
  public final k e(Surface paramSurface)
  {
    AppMethodBeat.i(225375);
    paramSurface = this.cIA.e(paramSurface);
    AppMethodBeat.o(225375);
    return paramSurface;
  }
  
  public final k e(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(225362);
    paramString = this.cIA.e(paramString, paramJSONObject);
    AppMethodBeat.o(225362);
    return paramString;
  }
  
  public final int getMaxZoom()
  {
    AppMethodBeat.i(225358);
    int i = this.cIA.getMaxZoom();
    AppMethodBeat.o(225358);
    return i;
  }
  
  public final k jc(int paramInt)
  {
    AppMethodBeat.i(225380);
    k localk = this.cIA.jc(paramInt);
    AppMethodBeat.o(225380);
    return localk;
  }
  
  public final void notifyOrientationChanged(int paramInt)
  {
    AppMethodBeat.i(138901);
    this.cIA.notifyOrientationChanged(paramInt);
    AppMethodBeat.o(138901);
  }
  
  public final void setAudioVolumeListener(TXLivePusher.ITXAudioVolumeEvaluationListener paramITXAudioVolumeEvaluationListener)
  {
    AppMethodBeat.i(225368);
    this.cIA.setAudioVolumeListener(paramITXAudioVolumeEvaluationListener);
    AppMethodBeat.o(225368);
  }
  
  public final void setBGMNotifyListener(TXLivePusher.OnBGMNotify paramOnBGMNotify)
  {
    AppMethodBeat.i(225370);
    this.cIA.setBGMNotifyListener(paramOnBGMNotify);
    AppMethodBeat.o(225370);
  }
  
  public final void setPushListener(ITXLivePushListener paramITXLivePushListener)
  {
    AppMethodBeat.i(225372);
    this.cIA.setPushListener(paramITXLivePushListener);
    AppMethodBeat.o(225372);
  }
  
  public final void setSnapshotListener(TXLivePusher.ITXSnapshotListener paramITXSnapshotListener)
  {
    AppMethodBeat.i(225373);
    this.cIA.setSnapshotListener(paramITXSnapshotListener);
    AppMethodBeat.o(225373);
  }
  
  public final void setThreadHandler(Handler paramHandler)
  {
    AppMethodBeat.i(225377);
    this.cIA.setThreadHandler(paramHandler);
    AppMethodBeat.o(225377);
  }
  
  public final k t(Bundle paramBundle)
  {
    AppMethodBeat.i(225359);
    paramBundle = this.cIA.t(paramBundle);
    AppMethodBeat.o(225359);
    return paramBundle;
  }
  
  public final k u(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(225371);
    k localk = this.cIA.u(paramFloat1, paramFloat2);
    AppMethodBeat.o(225371);
    return localk;
  }
  
  public final k u(Bundle paramBundle)
  {
    AppMethodBeat.i(225382);
    paramBundle = this.cIA.u(paramBundle);
    AppMethodBeat.o(225382);
    return paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.s
 * JD-Core Version:    0.7.0.1
 */