package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.n;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/IBluetoothBackgroundSupportClient;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandEnvContext;", "debugName", "", "getDebugName", "()Ljava/lang/String;", "isNeedKeepAlive", "", "()Z", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "getRuntime", "()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "addListener", "", "listener", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/IBluetoothBackgroundSupportClient$IListener;", "checkCanIEnable", "disable", "closeConnection", "enable", "removeListener", "IFactory", "IListener", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface l
  extends n
{
  public abstract void a(b paramb);
  
  public abstract void b(b paramb);
  
  public abstract boolean cjR();
  
  public abstract String com();
  
  public abstract void cqH();
  
  public abstract void cqI();
  
  public abstract void enable();
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/IBluetoothBackgroundSupportClient$IFactory;", "", "debugName", "", "getDebugName", "()Ljava/lang/String;", "create", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/IBluetoothBackgroundSupportClient;", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract l aj(AppBrandRuntime paramAppBrandRuntime);
    
    public abstract String com();
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/IBluetoothBackgroundSupportClient$IListener;", "", "debugName", "", "getDebugName", "()Ljava/lang/String;", "onStateChange", "", "isEnabled", "", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract String com();
    
    public abstract void iQ(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.l
 * JD-Core Version:    0.7.0.1
 */