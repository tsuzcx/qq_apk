package com.tencent.luggage.xweb_ext.extendplugin.component.live.a;

import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import com.tencent.mm.plugin.appbrand.jsapi.live.k;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/liveplayer/ITXLivePlayerJSAdapterSameLayerSupport;", "Lcom/tencent/mm/plugin/appbrand/jsapi/live/ITXLivePlayerJSAdapter;", "enterBackground", "Lcom/tencent/mm/plugin/appbrand/jsapi/live/TXJSAdapterError;", "initLivePlayer", "params", "Landroid/os/Bundle;", "isMuted", "", "isPlaying", "sendHandupStop", "", "sendWeChatStop", "setSurface", "surface", "Landroid/view/Surface;", "setSurfaceSize", "width", "", "height", "setThreadHandler", "handler", "Landroid/os/Handler;", "luggage-xweb-ext_release"})
public abstract interface a
  extends com.tencent.mm.plugin.appbrand.jsapi.live.a
{
  public abstract k To();
  
  public abstract void Tp();
  
  public abstract void Tq();
  
  public abstract k cn(int paramInt1, int paramInt2);
  
  public abstract k e(Surface paramSurface);
  
  public abstract boolean isMuted();
  
  public abstract boolean isPlaying();
  
  public abstract k p(Bundle paramBundle);
  
  public abstract void setThreadHandler(Handler paramHandler);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a
 * JD-Core Version:    0.7.0.1
 */