package com.tencent.mm.compatible.deviceinfo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Method;

public final class u
{
  public static boolean avb()
  {
    AppMethodBeat.i(261692);
    try
    {
      Object localObject = Class.forName("com.huawei.system.BuildEx");
      localObject = (String)((Class)localObject).getMethod("getOsBrand", new Class[0]).invoke(localObject, new Object[0]);
      Log.i("MicroMsg.HarmonyOSHelper", "OsBrand: %s", new Object[] { localObject });
      boolean bool = "harmony".equals(localObject);
      AppMethodBeat.o(261692);
      return bool;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Log.e("MicroMsg.HarmonyOSHelper", "occured ClassNotFoundException");
      AppMethodBeat.o(261692);
      return false;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        Log.e("MicroMsg.HarmonyOSHelper", "occured NoSuchMethodException");
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.HarmonyOSHelper", "occur other problem");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.u
 * JD-Core Version:    0.7.0.1
 */