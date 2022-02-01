package com.tencent.mm.plugin.appbrand.ipc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.reflect.Constructor;

final class AppBrandProxyUIProcessTask$a
{
  static <_Model extends AppBrandProxyUIProcessTask> _Model HC(String paramString)
  {
    AppMethodBeat.i(45413);
    try
    {
      Object localObject = Class.forName(paramString).getDeclaredConstructor(new Class[0]);
      ((Constructor)localObject).setAccessible(true);
      localObject = (AppBrandProxyUIProcessTask)((Constructor)localObject).newInstance(new Object[0]);
      AppMethodBeat.o(45413);
      return localObject;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.AppBrand.IpcProxyUIModelFactory", "create mode object using className(%s), exp = %s", new Object[] { paramString, bt.m(localException) });
      AppMethodBeat.o(45413);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.a
 * JD-Core Version:    0.7.0.1
 */