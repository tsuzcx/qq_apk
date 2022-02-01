package com.tencent.mm.plugin.ball.service;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.c.c;
import com.tencent.mm.sdk.platformtools.ae;

class FloatBallHelper$1
  extends ResultReceiver
{
  FloatBallHelper$1(a parama, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(106061);
    if ((paramInt == 2) && (paramBundle != null))
    {
      boolean bool = paramBundle.getBoolean("can_add_float_ball_when_hide", false);
      if ((bool) && (this.nLP.bLv()))
      {
        ae.i("MicroMsg.FloatBallHelper", "alvinluo autoAddFloatBall onReceiveResult add new after remove floatBall done");
        this.nLP.bLD().nLE = 1;
        this.nLP.o(true, 7);
        AppMethodBeat.o(106061);
        return;
      }
      if (this.nLP.nLK != null)
      {
        ae.i("MicroMsg.FloatBallHelper", "alvinluo autoAddFloatBall onReceiveResult not add, canAdd: %b", new Object[] { Boolean.valueOf(bool) });
        this.nLP.bLD().nLE = 2;
        ((c)g.ab(c.class)).s(this.nLP.nLK);
      }
    }
    AppMethodBeat.o(106061);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.FloatBallHelper.1
 * JD-Core Version:    0.7.0.1
 */