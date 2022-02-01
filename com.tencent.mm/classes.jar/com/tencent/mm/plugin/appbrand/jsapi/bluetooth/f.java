package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.d;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/BluetoothBackgroundSupportException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "errorInfo", "Lcom/tencent/mm/plugin/appbrand/jsapi/errno/AppBrandErrors$ErrorInfo;", "msg", "", "(Lcom/tencent/mm/plugin/appbrand/jsapi/errno/AppBrandErrors$ErrorInfo;Ljava/lang/String;)V", "getErrorInfo", "()Lcom/tencent/mm/plugin/appbrand/jsapi/errno/AppBrandErrors$ErrorInfo;", "getMsg", "()Ljava/lang/String;", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends Exception
{
  final String msg;
  final a.d rKn;
  
  private f(a.d paramd)
  {
    super(null);
    AppMethodBeat.i(329513);
    this.rKn = paramd;
    this.msg = null;
    AppMethodBeat.o(329513);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.f
 * JD-Core Version:    0.7.0.1
 */