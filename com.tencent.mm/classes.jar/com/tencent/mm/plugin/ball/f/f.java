package com.tencent.mm.plugin.ball.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.ball.c.b;
import com.tencent.mm.sdk.platformtools.Log;

public final class f
{
  public static void cvI()
  {
    AppMethodBeat.i(191346);
    d(true, false, true);
    AppMethodBeat.o(191346);
  }
  
  public static void cwA()
  {
    AppMethodBeat.i(292791);
    d(false, true, true);
    AppMethodBeat.o(292791);
  }
  
  public static void cwB()
  {
    AppMethodBeat.i(292792);
    d(true, true, true);
    AppMethodBeat.o(292792);
  }
  
  public static void d(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(184419);
    b localb = (b)h.ae(b.class);
    if (localb != null)
    {
      if (paramBoolean1)
      {
        Log.printInfoStack("MicroMsg.FloatBallVisibilityUtil", "operateFloatBall, hide float ball, mark:%s", new Object[] { Boolean.valueOf(paramBoolean3) });
        if (paramBoolean3)
        {
          localb.kX(paramBoolean2);
          AppMethodBeat.o(184419);
          return;
        }
        localb.kV(paramBoolean2);
        AppMethodBeat.o(184419);
        return;
      }
      Log.printInfoStack("MicroMsg.FloatBallVisibilityUtil", "operateFloatBall, show float ball, mark:%s", new Object[] { Boolean.valueOf(paramBoolean3) });
      if (paramBoolean3)
      {
        localb.kY(paramBoolean2);
        AppMethodBeat.o(184419);
        return;
      }
      localb.kW(paramBoolean2);
      AppMethodBeat.o(184419);
      return;
    }
    Log.i("MicroMsg.FloatBallVisibilityUtil", "operateFloatBall, service is null");
    AppMethodBeat.o(184419);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.f.f
 * JD-Core Version:    0.7.0.1
 */