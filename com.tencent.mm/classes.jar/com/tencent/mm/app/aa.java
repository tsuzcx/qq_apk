package com.tencent.mm.app;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import java.lang.reflect.Method;

final class aa
{
  public static boolean bu(Context paramContext)
  {
    AppMethodBeat.i(211730);
    try
    {
      if (!((Boolean)Class.forName(ak.getPackageName() + ".recovery.RecoveryInitializer").getMethod("init", new Class[] { Context.class }).invoke(null, new Object[] { paramContext })).booleanValue())
      {
        AppMethodBeat.o(211730);
        return true;
      }
      AppMethodBeat.o(211730);
      return false;
    }
    catch (Throwable paramContext)
    {
      ae.printErrStackTrace("MicroMsg.recovery.loader", paramContext, "recovery init fail", new Object[0]);
      AppMethodBeat.o(211730);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.aa
 * JD-Core Version:    0.7.0.1
 */