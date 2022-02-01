package com.tencent.mm.plugin.appbrand.media.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg.Info;

public final class f
{
  public static com.tencent.mm.al.e c(WxaPkg.Info paramInfo)
  {
    AppMethodBeat.i(182599);
    if (paramInfo == null)
    {
      AppMethodBeat.o(182599);
      return null;
    }
    if (g.cBA())
    {
      paramInfo = new e(paramInfo.fileName, paramInfo.qGx);
      AppMethodBeat.o(182599);
      return paramInfo;
    }
    paramInfo = new d(paramInfo.fileName, paramInfo.qGx);
    AppMethodBeat.o(182599);
    return paramInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.a.f
 * JD-Core Version:    0.7.0.1
 */