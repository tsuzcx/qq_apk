package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.sdk.platformtools.y;

public enum k
{
  public static int sn(String paramString)
  {
    WxaAttributes localWxaAttributes = e.aaT().e(paramString, new String[] { "dynamicInfo" });
    if (localWxaAttributes == null)
    {
      i = -1;
      y.i("MicroMsg.AppServiceSettingMMManager", "readAppFileStorageMaxSizeInBytes, appId = %s, MaxLocalstorageSize = %d", new Object[] { paramString, Integer.valueOf(i) });
      if (localWxaAttributes == null) {
        break label79;
      }
    }
    label79:
    for (int i = localWxaAttributes.aeo().fRk.fRm;; i = 5)
    {
      return i * 1048576;
      i = localWxaAttributes.aeo().fRk.fRm;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.k
 * JD-Core Version:    0.7.0.1
 */