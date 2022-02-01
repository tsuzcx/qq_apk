package com.tencent.luggage.xweb_ext.extendplugin.component.live.a;

import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import com.tencent.mm.plugin.appbrand.jsapi.live.k;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/liveplayer/ITXLivePlayerJSAdapterSameLayerSupport;", "Lcom/tencent/mm/plugin/appbrand/jsapi/live/ITXLivePlayerJSAdapter;", "enterBackground", "Lcom/tencent/mm/plugin/appbrand/jsapi/live/TXJSAdapterError;", "initLivePlayer", "params", "Landroid/os/Bundle;", "isMuted", "", "isPlaying", "sendHandupStop", "", "sendWeChatStop", "setSurface", "surface", "Landroid/view/Surface;", "setSurfaceSize", "width", "", "height", "setThreadHandler", "handler", "Landroid/os/Handler;", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface a
  extends com.tencent.mm.plugin.appbrand.jsapi.live.a
{
  public abstract k atT();
  
  public abstract void atU();
  
  public abstract void atV();
  
  public abstract k dc(int paramInt1, int paramInt2);
  
  public abstract k h(Surface paramSurface);
  
  public abstract boolean isMuted();
  
  public abstract boolean isPlaying();
  
  public abstract void setThreadHandler(Handler paramHandler);
  
  public abstract k u(Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a
 * JD-Core Version:    0.7.0.1
 */