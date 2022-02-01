package com.tencent.mm.plugin.appbrand.u;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/nfc/WxaNFCDiscoverableFactory;", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/INFCDiscoverable$IFactory;", "()V", "TAG", "", "value", "", "useReaderMode", "getUseReaderMode", "()Z", "setUseReaderMode", "(Z)V", "create", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/INFCDiscoverable;", "appId", "activity", "Landroid/app/Activity;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "luggage-wxa-app-jsapi_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a tqf;
  static boolean tqg;
  
  static
  {
    AppMethodBeat.i(317037);
    tqf = new a();
    tqg = true;
    AppMethodBeat.o(317037);
  }
  
  public static void kh(boolean paramBoolean)
  {
    AppMethodBeat.i(317033);
    Log.i("MicroMsg.AppBrand.WxaNFCDiscoverableFactory", s.X("set#useReaderMode, value: ", Boolean.valueOf(paramBoolean)));
    tqg = paramBoolean;
    AppMethodBeat.o(317033);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.a
 * JD-Core Version:    0.7.0.1
 */