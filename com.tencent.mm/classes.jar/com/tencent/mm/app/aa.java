package com.tencent.mm.app;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.lang.reflect.Method;

final class aa
{
  public static boolean bs(Context paramContext)
  {
    AppMethodBeat.i(207438);
    try
    {
      if (!((Boolean)Class.forName(aj.getPackageName() + ".recovery.RecoveryInitializer").getMethod("init", new Class[] { Context.class }).invoke(null, new Object[] { paramContext })).booleanValue())
      {
        AppMethodBeat.o(207438);
        return true;
      }
      AppMethodBeat.o(207438);
      return false;
    }
    catch (Throwable paramContext)
    {
      ad.printErrStackTrace("MicroMsg.recovery.loader", paramContext, "recovery init fail", new Object[0]);
      AppMethodBeat.o(207438);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.aa
 * JD-Core Version:    0.7.0.1
 */