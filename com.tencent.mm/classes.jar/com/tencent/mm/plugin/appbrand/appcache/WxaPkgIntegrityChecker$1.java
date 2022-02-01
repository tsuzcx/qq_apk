package com.tencent.mm.plugin.appbrand.appcache;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.a.b;
import org.apache.commons.c.i;

final class WxaPkgIntegrityChecker$1
  implements b<String[], Boolean>
{
  WxaPkgIntegrityChecker$1(String paramString1, String paramString2) {}
  
  public final Boolean m(String[] paramArrayOfString)
  {
    AppMethodBeat.i(320265);
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      if ((!TextUtils.isEmpty(str)) && (str.equals(this.qGX)))
      {
        paramArrayOfString = Boolean.TRUE;
        AppMethodBeat.o(320265);
        return paramArrayOfString;
      }
      i += 1;
    }
    Log.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "checkPkg, appId[%s] checksumMd5List[%s] != file.md5[%s]", new Object[] { this.etl, i.b(paramArrayOfString, ","), this.qGX });
    paramArrayOfString = Boolean.FALSE;
    AppMethodBeat.o(320265);
    return paramArrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker.1
 * JD-Core Version:    0.7.0.1
 */