package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import com.tencent.mm.plugin.appbrand.jsapi.live.b;
import com.tencent.mm.plugin.appbrand.jsapi.live.k;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/ITXLivePusherJSAdapterSameLayerSupport;", "Lcom/tencent/mm/plugin/appbrand/jsapi/live/ITXLivePusherJSAdapter;", "getMaxZoom", "", "initLivePusher", "Lcom/tencent/mm/plugin/appbrand/jsapi/live/TXJSAdapterError;", "params", "Landroid/os/Bundle;", "sendHandupStop", "", "sendWeChatStop", "setFocusPosition", "x", "", "y", "setSurface", "surface", "Landroid/view/Surface;", "setSurfaceSize", "width", "height", "setThreadHandler", "handler", "Landroid/os/Handler;", "setZoom", "value", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface m
  extends b
{
  public abstract k aa(float paramFloat1, float paramFloat2);
  
  public abstract void atU();
  
  public abstract void atV();
  
  public abstract k dc(int paramInt1, int paramInt2);
  
  public abstract int getMaxZoom();
  
  public abstract k h(Surface paramSurface);
  
  public abstract k mF(int paramInt);
  
  public abstract void setThreadHandler(Handler paramHandler);
  
  public abstract k y(Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.m
 * JD-Core Version:    0.7.0.1
 */