package com.tencent.mm.plugin.ball.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.c.c;
import com.tencent.mm.sdk.platformtools.ad;

public final class f
{
  public static void bAp()
  {
    AppMethodBeat.i(205923);
    d(false, true, true);
    AppMethodBeat.o(205923);
  }
  
  public static void bAq()
  {
    AppMethodBeat.i(205924);
    d(true, true, true);
    AppMethodBeat.o(205924);
  }
  
  public static void d(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(184419);
    c localc = (c)g.ab(c.class);
    if (localc != null)
    {
      if (paramBoolean1)
      {
        ad.m("MicroMsg.FloatBallVisibilityUtil", "operateFloatBall, hide float ball, mark:%s", new Object[] { Boolean.valueOf(paramBoolean3) });
        if (paramBoolean3)
        {
          localc.ig(paramBoolean2);
          AppMethodBeat.o(184419);
          return;
        }
        localc.ie(paramBoolean2);
        AppMethodBeat.o(184419);
        return;
      }
      ad.m("MicroMsg.FloatBallVisibilityUtil", "operateFloatBall, show float ball, mark:%s", new Object[] { Boolean.valueOf(paramBoolean3) });
      if (paramBoolean3)
      {
        localc.ih(paramBoolean2);
        AppMethodBeat.o(184419);
        return;
      }
      localc.jdMethod_if(paramBoolean2);
      AppMethodBeat.o(184419);
      return;
    }
    ad.i("MicroMsg.FloatBallVisibilityUtil", "operateFloatBall, service is null");
    AppMethodBeat.o(184419);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.f.f
 * JD-Core Version:    0.7.0.1
 */