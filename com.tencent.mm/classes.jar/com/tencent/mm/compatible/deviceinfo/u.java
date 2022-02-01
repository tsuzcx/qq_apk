package com.tencent.mm.compatible.deviceinfo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Method;

public final class u
{
  public static boolean aPw()
  {
    AppMethodBeat.i(240856);
    try
    {
      Object localObject = Class.forName("com.huawei.system.BuildEx");
      localObject = (String)((Class)localObject).getMethod("getOsBrand", new Class[0]).invoke(localObject, new Object[0]);
      Log.i("MicroMsg.HarmonyOSHelper", "OsBrand: %s", new Object[] { localObject });
      boolean bool = "harmony".equals(localObject);
      AppMethodBeat.o(240856);
      return bool;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Log.e("MicroMsg.HarmonyOSHelper", "occured ClassNotFoundException");
      AppMethodBeat.o(240856);
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