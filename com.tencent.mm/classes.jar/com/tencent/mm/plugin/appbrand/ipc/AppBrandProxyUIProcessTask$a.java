package com.tencent.mm.plugin.appbrand.ipc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.reflect.Constructor;

final class AppBrandProxyUIProcessTask$a
{
  static <_Model extends AppBrandProxyUIProcessTask> _Model BH(String paramString)
  {
    AppMethodBeat.i(73152);
    try
    {
      Object localObject = Class.forName(paramString).getDeclaredConstructor(new Class[0]);
      ((Constructor)localObject).setAccessible(true);
      localObject = (AppBrandProxyUIProcessTask)((Constructor)localObject).newInstance(new Object[0]);
      AppMethodBeat.o(73152);
      return localObject;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.AppBrand.IpcProxyUIModelFactory", "create mode object using className(%s), exp = %s", new Object[] { paramString, bo.l(localException) });
      AppMethodBeat.o(73152);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.a
 * JD-Core Version:    0.7.0.1
 */