package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.task.e;
import com.tencent.mm.plugin.appbrand.utils.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vending.g.c;

public final class as
{
  private static final WxaCommLibRuntimeReader.a kMa;
  
  static
  {
    AppMethodBeat.i(44336);
    kMa = new WxaCommLibRuntimeReader.a();
    AppMethodBeat.o(44336);
  }
  
  public static void bvQ()
  {
    AppMethodBeat.i(44332);
    doNotify();
    AppMethodBeat.o(44332);
  }
  
  public static void bvR()
  {
    AppMethodBeat.i(44333);
    doNotify();
    AppMethodBeat.o(44333);
  }
  
  public static void bvS()
  {
    AppMethodBeat.i(44334);
    try
    {
      WxaCommLibRuntimeReader.a locala = kMa;
      IPCVoid localIPCVoid = IPCVoid.hnE;
      locala.bvZ();
      AppMethodBeat.o(44334);
      return;
    }
    catch (WxaCommLibRuntimeReader.AccountNotReadyError localAccountNotReadyError)
    {
      com.tencent.mm.model.b localb = new com.tencent.mm.model.b();
      AppMethodBeat.o(44334);
      throw localb;
    }
  }
  
  private static void doNotify()
  {
    AppMethodBeat.i(44335);
    Object localObject1 = kMa;
    Object localObject2 = IPCVoid.hnE;
    localObject2 = ((WxaCommLibRuntimeReader.a)localObject1).bvZ();
    if ((localObject2 instanceof WxaPkgWrappingInfo))
    {
      localObject1 = (WxaPkgWrappingInfo)localObject2;
      Log.i("MicroMsg.AppBrand.WxaCommLibPreloadNotify", "doNotify check ok ret[%s]", new Object[] { localObject2 });
      localObject2 = com.tencent.mm.kernel.g.hrf;
      int j = localObject2.length;
      int i = 0;
      while (i < j)
      {
        String str = localObject2[i];
        str = MMApplicationContext.getPackageName() + str;
        if (MMApplicationContext.isProcessExist(str)) {
          XIPCInvoker.a(str, localObject1, a.class, null);
        }
        i += 1;
      }
      AppMethodBeat.o(44335);
      return;
    }
    Log.e("MicroMsg.AppBrand.WxaCommLibPreloadNotify", "doNotify check failed ret[%s]", new Object[] { localObject2 });
    AppMethodBeat.o(44335);
  }
  
  static final class a
    implements com.tencent.mm.ipcinvoker.b<WxaPkgWrappingInfo, IPCVoid>
  {}
  
  static final class b
    implements com.tencent.mm.vending.c.a<Void, Void>
  {
    private WxaPkgWrappingInfo kMf;
    
    public b(WxaPkgWrappingInfo paramWxaPkgWrappingInfo)
    {
      this.kMf = paramWxaPkgWrappingInfo;
    }
    
    public final Void buw()
    {
      AppMethodBeat.i(226362);
      boolean bool = WxaCommLibRuntimeReader.b(this.kMf);
      int i = com.tencent.mm.plugin.appbrand.a.bqV();
      Log.i("MicroMsg.AppBrand.WxaCommLibPreloadNotify", "IPC_resetAppBrandCommLibReader#invoke() waitForPreloaded entered, process[%s], pkgInfo[%s], globalReaderUpdated[%b], runningRuntimeCount[%d]", new Object[] { MMApplicationContext.getProcessName(), this.kMf, Boolean.valueOf(bool), Integer.valueOf(i) });
      if ((bool) && (i <= 0)) {
        e.bVQ();
      }
      Void localVoid = QZL;
      AppMethodBeat.o(226362);
      return localVoid;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.as
 * JD-Core Version:    0.7.0.1
 */