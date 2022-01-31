package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.sdk.platformtools.y;
import java.util.concurrent.Callable;

final class WxaCommLibRuntimeReader$1
  implements Callable<Object>
{
  public final Object call()
  {
    try
    {
      Object localObject = XIPCInvoker.a("com.tencent.mm", IPCVoid.dHo, WxaCommLibRuntimeReader.c.class);
      return localObject;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.WxaCommLibRuntimeReader", localException, "load() ipc read lib", new Object[0]);
      return localException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader.1
 * JD-Core Version:    0.7.0.1
 */