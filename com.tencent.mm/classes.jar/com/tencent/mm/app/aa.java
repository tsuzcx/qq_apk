package com.tencent.mm.app;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import java.lang.reflect.Method;

final class aa
{
  public static boolean bt(Context paramContext)
  {
    AppMethodBeat.i(205032);
    try
    {
      if (!((Boolean)Class.forName(ai.getPackageName() + ".recovery.RecoveryInitializer").getMethod("init", new Class[] { Context.class }).invoke(null, new Object[] { paramContext })).booleanValue())
      {
        AppMethodBeat.o(205032);
        return true;
      }
      AppMethodBeat.o(205032);
      return false;
    }
    catch (Throwable paramContext)
    {
      ac.printErrStackTrace("MicroMsg.recovery.loader", paramContext, "recovery init fail", new Object[0]);
      AppMethodBeat.o(205032);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.aa
 * JD-Core Version:    0.7.0.1
 */