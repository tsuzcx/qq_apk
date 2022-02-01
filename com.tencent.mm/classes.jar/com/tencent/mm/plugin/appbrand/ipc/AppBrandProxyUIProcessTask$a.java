package com.tencent.mm.plugin.appbrand.ipc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.lang.reflect.Constructor;

final class AppBrandProxyUIProcessTask$a
{
  static <_Model extends AppBrandProxyUIProcessTask> _Model PI(String paramString)
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
      ae.e("MicroMsg.AppBrand.IpcProxyUIModelFactory", "create mode object using className(%s), exp = %s", new Object[] { paramString, bu.o(localException) });
      AppMethodBeat.o(45413);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.a
 * JD-Core Version:    0.7.0.1
 */