package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.appcache.an;
import com.tencent.mm.plugin.appbrand.appcache.ar;
import com.tencent.mm.sdk.platformtools.bk;

final class ac
{
  static String aW(String paramString, int paramInt)
  {
    Object localObject = null;
    an localan = com.tencent.mm.plugin.appbrand.app.e.abb().a(paramString, paramInt, new String[] { "versionMd5", "pkgPath" });
    paramString = localObject;
    if (localan != null)
    {
      paramString = localObject;
      if (!bk.bl(localan.field_pkgPath))
      {
        paramString = localObject;
        if (com.tencent.mm.vfs.e.bK(localan.field_pkgPath))
        {
          paramString = localObject;
          if (!bk.bl(localan.field_versionMd5))
          {
            paramString = localObject;
            if (localan.field_pkgPath.equals(com.tencent.mm.vfs.e.aeY(localan.field_pkgPath))) {
              paramString = localan.field_versionMd5;
            }
          }
        }
      }
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ac
 * JD-Core Version:    0.7.0.1
 */