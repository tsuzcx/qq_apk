package com.tencent.mm.compatible.loader;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.SyncTask;
import com.tencent.mm.sdk.platformtools.Util;

public final class d
{
  public static c b(Application paramApplication, String paramString)
  {
    AppMethodBeat.i(155843);
    try
    {
      paramString = (c)MMApplicationContext.getContext().getClassLoader().loadClass(MMApplicationContext.getSourcePackageName() + paramString).newInstance();
      paramString.app = paramApplication;
      AppMethodBeat.o(155843);
      return paramString;
    }
    catch (Exception paramApplication)
    {
      Log.printErrStackTrace("MicroMsg.ProfileFactoryImpl", paramApplication, "", new Object[0]);
      AppMethodBeat.o(155843);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.loader.d
 * JD-Core Version:    0.7.0.1
 */