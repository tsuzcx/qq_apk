package com.tencent.mm.compatible.loader;

import android.app.Application;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class f
{
  public static e c(Application paramApplication, String paramString)
  {
    AppMethodBeat.i(93038);
    try
    {
      paramString = (e)ah.getContext().getClassLoader().loadClass(ah.dsO() + paramString).newInstance();
      paramString.b(paramApplication);
      AppMethodBeat.o(93038);
      return paramString;
    }
    catch (Exception paramApplication)
    {
      ab.printErrStackTrace("MicroMsg.ProfileFactoryImpl", paramApplication, "", new Object[0]);
      AppMethodBeat.o(93038);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.compatible.loader.f
 * JD-Core Version:    0.7.0.1
 */