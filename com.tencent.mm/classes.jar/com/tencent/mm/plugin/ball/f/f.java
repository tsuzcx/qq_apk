package com.tencent.mm.plugin.ball.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.c.b;
import com.tencent.mm.sdk.platformtools.Log;

public final class f
{
  public static void cji()
  {
    AppMethodBeat.i(258315);
    e(false, true, true);
    AppMethodBeat.o(258315);
  }
  
  public static void cjj()
  {
    AppMethodBeat.i(258316);
    e(true, true, true);
    AppMethodBeat.o(258316);
  }
  
  public static void cjk()
  {
    AppMethodBeat.i(188581);
    e(true, false, true);
    AppMethodBeat.o(188581);
  }
  
  public static void e(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(184419);
    b localb = (b)g.af(b.class);
    if (localb != null)
    {
      if (paramBoolean1)
      {
        Log.printInfoStack("MicroMsg.FloatBallVisibilityUtil", "operateFloatBall, hide float ball, mark:%s", new Object[] { Boolean.valueOf(paramBoolean3) });
        if (paramBoolean3)
        {
          localb.jN(paramBoolean2);
          AppMethodBeat.o(184419);
          return;
        }
        localb.jL(paramBoolean2);
        AppMethodBeat.o(184419);
        return;
      }
      Log.printInfoStack("MicroMsg.FloatBallVisibilityUtil", "operateFloatBall, show float ball, mark:%s", new Object[] { Boolean.valueOf(paramBoolean3) });
      if (paramBoolean3)
      {
        localb.jO(paramBoolean2);
        AppMethodBeat.o(184419);
        return;
      }
      localb.jM(paramBoolean2);
      AppMethodBeat.o(184419);
      return;
    }
    Log.i("MicroMsg.FloatBallVisibilityUtil", "operateFloatBall, service is null");
    AppMethodBeat.o(184419);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.f.f
 * JD-Core Version:    0.7.0.1
 */