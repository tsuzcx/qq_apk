package com.tencent.luggage.sdk.customize.impl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.m;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import junit.framework.Assert;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/sdk/customize/impl/LuggageBLEScanStatsAgent;", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/scan/IAppScanStats;", "()V", "ipcInvokeService", "RET", "PARAM", "params", "invoke", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "(Ljava/lang/Object;Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;)Ljava/lang/Object;", "ipcInvokeServiceAsync", "", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "(Ljava/lang/Object;Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;)V", "isScanningTooFrequently", "", "recordScanStart", "", "recordScanStop", "id", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.f
{
  public static final b eqx;
  
  static
  {
    AppMethodBeat.i(220385);
    eqx = new b();
    AppMethodBeat.o(220385);
  }
  
  private static final IPCInteger a(IPCVoid paramIPCVoid)
  {
    AppMethodBeat.i(220364);
    int i = c.eqy.aqV();
    Log.i("MicroMsg.AppBrand.LuggageBLEScanStats", s.X("invoke, recordScanStart, id: ", Integer.valueOf(i)));
    paramIPCVoid = new IPCInteger(i);
    AppMethodBeat.o(220364);
    return paramIPCVoid;
  }
  
  private static <PARAM, RET> RET a(m<PARAM, RET> paramm)
  {
    AppMethodBeat.i(220359);
    Assert.assertTrue(com.tencent.mm.ipcinvoker.g.b.au(paramm.getClass()));
    paramm = XIPCInvoker.a(MMApplicationContext.getApplicationId(), null, paramm.getClass());
    AppMethodBeat.o(220359);
    return paramm;
  }
  
  private static final void a(IPCInteger paramIPCInteger, com.tencent.mm.ipcinvoker.f paramf)
  {
    AppMethodBeat.i(220367);
    if (paramIPCInteger == null) {}
    for (int i = -1;; i = paramIPCInteger.value)
    {
      Log.i("MicroMsg.AppBrand.LuggageBLEScanStats", s.X("invoke, recordScanStop, id: ", Integer.valueOf(i)));
      c.eqy.mr(i);
      if (paramf != null) {
        paramf.onCallback(IPCVoid.mzv);
      }
      AppMethodBeat.o(220367);
      return;
    }
  }
  
  private static final void b(IPCVoid paramIPCVoid)
  {
    AppMethodBeat.i(220375);
    Log.i("MicroMsg.AppBrand.LuggageBLEScanStats", "onCallback, recordScanStop");
    AppMethodBeat.o(220375);
  }
  
  private static final IPCBoolean c(IPCVoid paramIPCVoid)
  {
    AppMethodBeat.i(220380);
    boolean bool = c.eqy.aqW();
    Log.i("MicroMsg.AppBrand.LuggageBLEScanStats", s.X("invoke, isScanningTooFrequently, isTooFrequently: ", Boolean.valueOf(bool)));
    paramIPCVoid = new IPCBoolean(bool);
    AppMethodBeat.o(220380);
    return paramIPCVoid;
  }
  
  public final int aqV()
  {
    AppMethodBeat.i(220408);
    IPCInteger localIPCInteger = (IPCInteger)a(b..ExternalSyntheticLambda3.INSTANCE);
    if (localIPCInteger == null) {}
    for (int i = -1;; i = localIPCInteger.value)
    {
      Log.i("MicroMsg.AppBrand.LuggageBLEScanStats", s.X("recordScanStart#Agent, id: ", Integer.valueOf(i)));
      AppMethodBeat.o(220408);
      return i;
    }
  }
  
  public final boolean aqW()
  {
    AppMethodBeat.i(220419);
    IPCBoolean localIPCBoolean = (IPCBoolean)a(b..ExternalSyntheticLambda2.INSTANCE);
    if (localIPCBoolean == null) {}
    for (boolean bool = false;; bool = localIPCBoolean.value)
    {
      Log.i("MicroMsg.AppBrand.LuggageBLEScanStats", s.X("isScanningTooFrequently#Agent, isTooFrequently: ", Boolean.valueOf(bool)));
      AppMethodBeat.o(220419);
      return bool;
    }
  }
  
  public final void mr(int paramInt)
  {
    AppMethodBeat.i(220414);
    IPCInteger localIPCInteger = new IPCInteger(paramInt);
    b..ExternalSyntheticLambda0 localExternalSyntheticLambda0 = b..ExternalSyntheticLambda0.INSTANCE;
    b..ExternalSyntheticLambda1 localExternalSyntheticLambda1 = b..ExternalSyntheticLambda1.INSTANCE;
    Assert.assertTrue(com.tencent.mm.ipcinvoker.g.b.au(localExternalSyntheticLambda0.getClass()));
    XIPCInvoker.a(MMApplicationContext.getApplicationId(), localIPCInteger, localExternalSyntheticLambda0.getClass(), localExternalSyntheticLambda1);
    AppMethodBeat.o(220414);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.sdk.customize.impl.b
 * JD-Core Version:    0.7.0.1
 */