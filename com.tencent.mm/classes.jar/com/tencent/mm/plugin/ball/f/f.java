package com.tencent.mm.plugin.ball.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.ball.c.b;
import com.tencent.mm.sdk.platformtools.Log;

public final class f
{
  public static void d(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(184419);
    b localb = (b)h.ax(b.class);
    if (localb != null)
    {
      if (paramBoolean1)
      {
        if (paramBoolean3)
        {
          localb.mk(paramBoolean2);
          AppMethodBeat.o(184419);
          return;
        }
        localb.mi(paramBoolean2);
        AppMethodBeat.o(184419);
        return;
      }
      Log.printInfoStack("MicroMsg.FloatBallVisibilityUtil", "operateFloatBall, show float ball, mark:%s", new Object[] { Boolean.valueOf(paramBoolean3) });
      if (paramBoolean3)
      {
        localb.ml(paramBoolean2);
        AppMethodBeat.o(184419);
        return;
      }
      localb.mj(paramBoolean2);
      AppMethodBeat.o(184419);
      return;
    }
    Log.i("MicroMsg.FloatBallVisibilityUtil", "operateFloatBall, service is null");
    AppMethodBeat.o(184419);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.f.f
 * JD-Core Version:    0.7.0.1
 */