package com.tencent.luggage.game.b;

import com.tencent.luggage.game.g.a;
import com.tencent.luggage.game.g.a.a;
import com.tencent.magicbrush.a.b;
import com.tencent.magicbrush.a.c.b;
import com.tencent.magicbrush.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public class d
{
  private static final a.a ciK;
  
  static
  {
    AppMethodBeat.i(130481);
    ciK = new a.a();
    AppMethodBeat.o(130481);
  }
  
  public final void Cx()
  {
    AppMethodBeat.i(130478);
    a.a(ciK, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(130472);
        d.this.Cz();
        AppMethodBeat.o(130472);
      }
    });
    AppMethodBeat.o(130478);
  }
  
  protected void Cy()
  {
    AppMethodBeat.i(130479);
    long l = bt.HI();
    b.loadLibraries();
    ad.i("MicroMsg.MBLogDelegateRegistry", "dl: load magicbrush [%d]ms", new Object[] { Long.valueOf(bt.aO(l)) });
    AppMethodBeat.o(130479);
  }
  
  protected final void Cz()
  {
    AppMethodBeat.i(130480);
    Cy();
    c.c.a(new c.b()
    {
      public final void d(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(130473);
        ad.d(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(130473);
      }
      
      public final void e(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(130476);
        ad.e(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(130476);
      }
      
      public final void i(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(130474);
        ad.i(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(130474);
      }
      
      public final void printStackTrace(String paramAnonymousString1, Throwable paramAnonymousThrowable, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(130477);
        ad.printErrStackTrace(paramAnonymousString1, paramAnonymousThrowable, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(130477);
      }
      
      public final void w(String paramAnonymousString1, String paramAnonymousString2, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(130475);
        ad.w(paramAnonymousString1, paramAnonymousString2, paramAnonymousVarArgs);
        AppMethodBeat.o(130475);
      }
    });
    AppMethodBeat.o(130480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.game.b.d
 * JD-Core Version:    0.7.0.1
 */