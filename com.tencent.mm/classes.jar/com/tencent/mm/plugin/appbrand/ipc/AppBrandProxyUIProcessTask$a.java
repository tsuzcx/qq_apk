package com.tencent.mm.plugin.appbrand.ipc;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.reflect.Constructor;

final class AppBrandProxyUIProcessTask$a
{
  static <_Model extends AppBrandProxyUIProcessTask> _Model tI(String paramString)
  {
    try
    {
      Object localObject = Class.forName(paramString).getDeclaredConstructor(new Class[0]);
      ((Constructor)localObject).setAccessible(true);
      localObject = (AppBrandProxyUIProcessTask)((Constructor)localObject).newInstance(new Object[0]);
      return localObject;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.AppBrand.IpcProxyUIModelFactory", "create mode object using className(%s), exp = %s", new Object[] { paramString, bk.j(localException) });
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.a
 * JD-Core Version:    0.7.0.1
 */