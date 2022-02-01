package com.tencent.luggage.game.b;

import com.tencent.luggage.game.g.a;
import com.tencent.luggage.game.g.a.a;
import com.tencent.magicbrush.a.b;
import com.tencent.magicbrush.a.c.b;
import com.tencent.magicbrush.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class e
{
  private static final a.a csR;
  
  static
  {
    AppMethodBeat.i(130481);
    csR = new a.a();
    AppMethodBeat.o(130481);
  }
  
  public final void OO()
  {
    AppMethodBeat.i(130478);
    a.a(csR, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(130472);
        e.this.OQ();
        AppMethodBeat.o(130472);
      }
    });
    AppMethodBeat.o(130478);
  }
  
  protected void OP()
  {
    AppMethodBeat.i(130479);
    long l = Util.currentTicks();
    b.loadLibraries();
    Log.i("MicroMsg.MBLogDelegateRegistry", "dl: load magicbrush [%d]ms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
    AppMethodBeat.o(130479);
  }
  
  protected final void OQ()
  {
    AppMethodBeat.i(130480);
    OP();
    c.c.a(new c.b()
    {
      public final void d(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(130473);
        Log.d(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(130473);
      }
      
      public final void e(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(130476);
        Log.e(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(130476);
      }
      
      public final void i(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(130474);
        Log.i(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(130474);
      }
      
      public final void printStackTrace(String paramAnonymousString1, Throwable paramAnonymousThrowable, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(130477);
        Log.printErrStackTrace(paramAnonymousString1, paramAnonymousThrowable, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(130477);
      }
      
      public final void w(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(130475);
        Log.w(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(130475);
      }
    });
    AppMethodBeat.o(130480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.game.b.e
 * JD-Core Version:    0.7.0.1
 */