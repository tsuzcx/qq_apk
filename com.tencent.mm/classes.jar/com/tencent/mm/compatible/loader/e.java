package com.tencent.mm.compatible.loader;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.bt;

public final class e
{
  public static d c(Application paramApplication, String paramString)
  {
    AppMethodBeat.i(155843);
    try
    {
      paramString = (d)aj.getContext().getClassLoader().loadClass(aj.eFC() + paramString).newInstance();
      paramString.d(paramApplication);
      AppMethodBeat.o(155843);
      return paramString;
    }
    catch (Exception paramApplication)
    {
      ad.printErrStackTrace("MicroMsg.ProfileFactoryImpl", paramApplication, "", new Object[0]);
      AppMethodBeat.o(155843);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.loader.e
 * JD-Core Version:    0.7.0.1
 */