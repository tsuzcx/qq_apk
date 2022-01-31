package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.bj;
import java.util.Map;

final class ak$1
  extends bj<String>
{
  ak$1(ak paramak, r paramr) {}
  
  private String Mc()
  {
    AppMethodBeat.i(140097);
    try
    {
      Object localObject = ak.a(this.bAW);
      if (localObject != null)
      {
        localObject = this.hxM.j("ok", (Map)localObject);
        AppMethodBeat.o(140097);
        return localObject;
      }
      localObject = this.hxM.j("fail", null);
      AppMethodBeat.o(140097);
      return localObject;
    }
    catch (Exception localException)
    {
      String str = this.hxM.j(localException.getMessage(), null);
      AppMethodBeat.o(140097);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ak.1
 * JD-Core Version:    0.7.0.1
 */