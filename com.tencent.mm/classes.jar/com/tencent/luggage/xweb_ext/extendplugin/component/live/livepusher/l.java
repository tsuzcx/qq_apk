package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import com.tencent.mm.plugin.appbrand.jsapi.live.b;
import com.tencent.mm.plugin.appbrand.jsapi.live.k;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/ITXLivePusherJSAdapterSameLayerSupport;", "Lcom/tencent/mm/plugin/appbrand/jsapi/live/ITXLivePusherJSAdapter;", "getMaxZoom", "", "initLivePusher", "Lcom/tencent/mm/plugin/appbrand/jsapi/live/TXJSAdapterError;", "params", "Landroid/os/Bundle;", "sendHandupStop", "", "sendWeChatStop", "setFocusPosition", "x", "", "y", "setSurface", "surface", "Landroid/view/Surface;", "setSurfaceSize", "width", "height", "setThreadHandler", "handler", "Landroid/os/Handler;", "setZoom", "value", "luggage-xweb-ext_release"})
public abstract interface l
  extends b
{
  public abstract void Tp();
  
  public abstract void Tq();
  
  public abstract k cn(int paramInt1, int paramInt2);
  
  public abstract k e(Surface paramSurface);
  
  public abstract int getMaxZoom();
  
  public abstract k jc(int paramInt);
  
  public abstract void setThreadHandler(Handler paramHandler);
  
  public abstract k t(Bundle paramBundle);
  
  public abstract k u(float paramFloat1, float paramFloat2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l
 * JD-Core Version:    0.7.0.1
 */