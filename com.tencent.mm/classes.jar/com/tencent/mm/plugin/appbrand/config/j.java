package com.tencent.mm.plugin.appbrand.config;

import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum j
{
  public static int Ac(String paramString)
  {
    AppMethodBeat.i(140822);
    localObject = null;
    try
    {
      t.ayI();
      WxaAttributes localWxaAttributes = t.AF(paramString);
      localObject = localWxaAttributes;
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        d.printErrStackTrace("MicroMsg.AppServiceSettingsResolver", localSecurityException, "queryWithAppId(%s)", new Object[] { paramString });
        continue;
        int i = localObject.ayD().hjW.bDG;
        continue;
        i = 5;
      }
    }
    if (localObject == null)
    {
      i = -1;
      d.i("MicroMsg.AppServiceSettingsResolver", "readAppFileStorageMaxSizeInBytes, appId = %s, MaxLocalstorageSize = %d", new Object[] { paramString, Integer.valueOf(i) });
      if (localObject == null) {
        break label105;
      }
      i = localObject.ayD().hjW.bDG;
      AppMethodBeat.o(140822);
      return i * 1048576;
    }
  }
  
  public static int Ad(String paramString)
  {
    AppMethodBeat.i(140823);
    localObject = null;
    try
    {
      t.ayI();
      WxaAttributes localWxaAttributes = t.AF(paramString);
      localObject = localWxaAttributes;
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        d.printErrStackTrace("MicroMsg.AppServiceSettingsResolver", localSecurityException, "queryWithAppId(%s)", new Object[] { paramString });
        continue;
        int i = localObject.ayD().hjW.hjY;
        continue;
        i = 5;
      }
    }
    if (localObject == null)
    {
      i = -1;
      d.i("MicroMsg.AppServiceSettingsResolver", "readAppOpendataLocalStorageMaxSizeInBytes, appId = %s, MaxLocalstorageSize = %d", new Object[] { paramString, Integer.valueOf(i) });
      if (localObject == null) {
        break label105;
      }
      i = localObject.ayD().hjW.hjY;
      AppMethodBeat.o(140823);
      return i * 1048576;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.j
 * JD-Core Version:    0.7.0.1
 */