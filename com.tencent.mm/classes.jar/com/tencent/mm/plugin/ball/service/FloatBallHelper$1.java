package com.tencent.mm.plugin.ball.service;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

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
    if ((paramInt == 2) && (paramBundle != null) && (this.nGn.bKy()))
    {
      boolean bool = paramBundle.getBoolean("can_add_float_ball_when_hide", false);
      ad.i("MicroMsg.FloatBallHelper", "alvinluo autoAddFloatBall canAdd: %b after remove floatBall done", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        this.nGn.gf(true);
      }
    }
    AppMethodBeat.o(106061);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.FloatBallHelper.1
 * JD-Core Version:    0.7.0.1
 */