package com.tencent.mm.app;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.reflect.Method;

final class ae
{
  public static boolean cA(Context paramContext)
  {
    AppMethodBeat.i(239156);
    try
    {
      if (!((Boolean)Class.forName(MMApplicationContext.getSourcePackageName() + ".recovery.RecoveryInitializer").getMethod("init", new Class[] { Context.class }).invoke(null, new Object[] { paramContext })).booleanValue())
      {
        AppMethodBeat.o(239156);
        return true;
      }
      AppMethodBeat.o(239156);
      return false;
    }
    finally
    {
      Log.printErrStackTrace("MicroMsg.recovery.loader", paramContext, "recovery init fail", new Object[0]);
      AppMethodBeat.o(239156);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.ae
 * JD-Core Version:    0.7.0.1
 */