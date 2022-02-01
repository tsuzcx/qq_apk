package com.tencent.mm.compatible.loader;

import android.app.Application;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;

public final class e
{
  public static d b(Application paramApplication, String paramString)
  {
    AppMethodBeat.i(155843);
    try
    {
      paramString = (d)ak.getContext().getClassLoader().loadClass(ak.fov() + paramString).newInstance();
      paramString.g(paramApplication);
      AppMethodBeat.o(155843);
      return paramString;
    }
    catch (Exception paramApplication)
    {
      ae.printErrStackTrace("MicroMsg.ProfileFactoryImpl", paramApplication, "", new Object[0]);
      AppMethodBeat.o(155843);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.compatible.loader.e
 * JD-Core Version:    0.7.0.1
 */