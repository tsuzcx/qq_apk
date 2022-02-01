package com.tencent.mm.plugin.ball.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.c.c;
import com.tencent.mm.sdk.platformtools.ac;

public final class f
{
  public static void bHl()
  {
    AppMethodBeat.i(210298);
    e(false, true, true);
    AppMethodBeat.o(210298);
  }
  
  public static void bHm()
  {
    AppMethodBeat.i(210299);
    e(true, true, true);
    AppMethodBeat.o(210299);
  }
  
  public static void e(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(184419);
    c localc = (c)g.ab(c.class);
    if (localc != null)
    {
      if (paramBoolean1)
      {
        ac.m("MicroMsg.FloatBallVisibilityUtil", "operateFloatBall, hide float ball, mark:%s", new Object[] { Boolean.valueOf(paramBoolean3) });
        if (paramBoolean3)
        {
          localc.iG(paramBoolean2);
          AppMethodBeat.o(184419);
          return;
        }
        localc.iE(paramBoolean2);
        AppMethodBeat.o(184419);
        return;
      }
      ac.m("MicroMsg.FloatBallVisibilityUtil", "operateFloatBall, show float ball, mark:%s", new Object[] { Boolean.valueOf(paramBoolean3) });
      if (paramBoolean3)
      {
        localc.iH(paramBoolean2);
        AppMethodBeat.o(184419);
        return;
      }
      localc.iF(paramBoolean2);
      AppMethodBeat.o(184419);
      return;
    }
    ac.i("MicroMsg.FloatBallVisibilityUtil", "operateFloatBall, service is null");
    AppMethodBeat.o(184419);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.f.f
 * JD-Core Version:    0.7.0.1
 */