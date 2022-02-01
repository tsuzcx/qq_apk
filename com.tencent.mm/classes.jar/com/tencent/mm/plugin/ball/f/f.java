package com.tencent.mm.plugin.ball.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.c.c;
import com.tencent.mm.sdk.platformtools.ae;

public final class f
{
  public static void bMs()
  {
    AppMethodBeat.i(224261);
    e(false, true, true);
    AppMethodBeat.o(224261);
  }
  
  public static void bMt()
  {
    AppMethodBeat.i(224262);
    e(true, true, true);
    AppMethodBeat.o(224262);
  }
  
  public static void e(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(184419);
    c localc = (c)g.ab(c.class);
    if (localc != null)
    {
      if (paramBoolean1)
      {
        ae.m("MicroMsg.FloatBallVisibilityUtil", "operateFloatBall, hide float ball, mark:%s", new Object[] { Boolean.valueOf(paramBoolean3) });
        if (paramBoolean3)
        {
          localc.iO(paramBoolean2);
          AppMethodBeat.o(184419);
          return;
        }
        localc.iM(paramBoolean2);
        AppMethodBeat.o(184419);
        return;
      }
      ae.m("MicroMsg.FloatBallVisibilityUtil", "operateFloatBall, show float ball, mark:%s", new Object[] { Boolean.valueOf(paramBoolean3) });
      if (paramBoolean3)
      {
        localc.iP(paramBoolean2);
        AppMethodBeat.o(184419);
        return;
      }
      localc.iN(paramBoolean2);
      AppMethodBeat.o(184419);
      return;
    }
    ae.i("MicroMsg.FloatBallVisibilityUtil", "operateFloatBall, service is null");
    AppMethodBeat.o(184419);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.f.f
 * JD-Core Version:    0.7.0.1
 */