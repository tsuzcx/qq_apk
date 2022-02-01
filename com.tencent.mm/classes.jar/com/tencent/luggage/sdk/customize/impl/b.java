package com.tencent.luggage.sdk.customize.impl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.m;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.reflect.Modifier;
import junit.framework.Assert;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/sdk/customize/impl/LuggageBLEScanStatsAgent;", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/scan/IAppScanStats;", "()V", "ipcInvokeService", "RET", "PARAM", "params", "invoke", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "(Ljava/lang/Object;Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;)Ljava/lang/Object;", "ipcInvokeServiceAsync", "", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "(Ljava/lang/Object;Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;)V", "isScanningTooFrequently", "", "recordScanStart", "", "recordScanStop", "id", "luggage-wechat-full-sdk_release"})
public final class b
  implements com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.f
{
  public static final b cya;
  
  static
  {
    AppMethodBeat.i(238668);
    cya = new b();
    AppMethodBeat.o(238668);
  }
  
  private static <PARAM, RET> RET a(m<PARAM, RET> paramm)
  {
    AppMethodBeat.i(238666);
    Assert.assertTrue(Modifier.isStatic(paramm.getClass().getModifiers()));
    paramm = XIPCInvoker.a(MMApplicationContext.getApplicationId(), null, paramm.getClass());
    AppMethodBeat.o(238666);
    return paramm;
  }
  
  public final int QI()
  {
    AppMethodBeat.i(238663);
    IPCInteger localIPCInteger = (IPCInteger)a((m)b.cyc);
    if (localIPCInteger != null) {}
    for (int i = localIPCInteger.value;; i = -1)
    {
      Log.i("MicroMsg.AppBrand.LuggageBLEScanStats", "recordScanStart#Agent, id: ".concat(String.valueOf(i)));
      AppMethodBeat.o(238663);
      return i;
    }
  }
  
  public final boolean QJ()
  {
    AppMethodBeat.i(238665);
    IPCBoolean localIPCBoolean = (IPCBoolean)a((m)a.cyb);
    if (localIPCBoolean != null) {}
    for (boolean bool = localIPCBoolean.value;; bool = false)
    {
      Log.i("MicroMsg.AppBrand.LuggageBLEScanStats", "isScanningTooFrequently#Agent, isTooFrequently: ".concat(String.valueOf(bool)));
      AppMethodBeat.o(238665);
      return bool;
    }
  }
  
  public final void iQ(int paramInt)
  {
    AppMethodBeat.i(238664);
    IPCInteger localIPCInteger = new IPCInteger(paramInt);
    d locald = (d)c.cyd;
    com.tencent.mm.ipcinvoker.f localf = (com.tencent.mm.ipcinvoker.f)b.d.cye;
    Assert.assertTrue(Modifier.isStatic(locald.getClass().getModifiers()));
    XIPCInvoker.a(MMApplicationContext.getApplicationId(), localIPCInteger, locald.getClass(), localf);
    AppMethodBeat.o(238664);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/ipcinvoker/type/IPCBoolean;", "<anonymous parameter 0>", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a<InputType, ResultType>
    implements m<IPCVoid, IPCBoolean>
  {
    public static final a cyb;
    
    static
    {
      AppMethodBeat.i(244587);
      cyb = new a();
      AppMethodBeat.o(244587);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/ipcinvoker/type/IPCInteger;", "<anonymous parameter 0>", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b<InputType, ResultType>
    implements m<IPCVoid, IPCInteger>
  {
    public static final b cyc;
    
    static
    {
      AppMethodBeat.i(234333);
      cyc = new b();
      AppMethodBeat.o(234333);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "data", "Lcom/tencent/mm/ipcinvoker/type/IPCInteger;", "kotlin.jvm.PlatformType", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class c<InputType, ResultType>
    implements d<IPCInteger, IPCVoid>
  {
    public static final c cyd;
    
    static
    {
      AppMethodBeat.i(244210);
      cyd = new c();
      AppMethodBeat.o(244210);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.sdk.customize.impl.b
 * JD-Core Version:    0.7.0.1
 */