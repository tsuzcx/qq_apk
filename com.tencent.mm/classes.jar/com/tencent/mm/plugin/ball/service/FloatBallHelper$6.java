package com.tencent.mm.plugin.ball.service;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

class FloatBallHelper$6
  extends ResultReceiver
{
  FloatBallHelper$6(a parama, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(224565);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(224565);
      return;
      int i;
      if (paramBundle != null)
      {
        i = paramBundle.getInt("type", 0);
        paramBundle = paramBundle.getString("key", null);
        if (i != 0)
        {
          this.nLP.ad(i, paramBundle);
          ae.i("MicroMsg.FloatBallHelper", "onReceiveResult:%s(ADD_BALL_INFO), type:%d, key: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramBundle });
          AppMethodBeat.o(224565);
          return;
        }
        ae.i("MicroMsg.FloatBallHelper", "onReceiveResult:%s(ADD_BALL_INFO), no type", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(224565);
        return;
      }
      ae.i("MicroMsg.FloatBallHelper", "onReceiveResult:%s(ADD_BALL_INFO), no resultData", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(224565);
      return;
      ae.i("MicroMsg.FloatBallHelper", "onReceiveResult:%s(UPDATE_BALL_INFO)", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(224565);
      return;
      ae.i("MicroMsg.FloatBallHelper", "onReceiveResult:%s(REMOVE_BALL_INFO)", new Object[] { Integer.valueOf(paramInt) });
      this.nLP.bhm();
      AppMethodBeat.o(224565);
      return;
      ae.i("MicroMsg.FloatBallHelper", "onReceiveResult:%s(FINISH_WHEN_SWITCH_BALL)", new Object[] { Integer.valueOf(paramInt) });
      this.nLP.bhl();
      AppMethodBeat.o(224565);
      return;
      if (paramBundle != null)
      {
        i = paramBundle.getInt("ActiveCount", 0);
        this.nLP.yb(i);
        ae.i("MicroMsg.FloatBallHelper", "onReceiveResult:%s(BALL_INFO_COUNT_CHANGED), activeCount:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        AppMethodBeat.o(224565);
        return;
      }
      ae.i("MicroMsg.FloatBallHelper", "onReceiveResult:%s(BALL_INFO_COUNT_CHANGED), no resultData", new Object[] { Integer.valueOf(paramInt) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.FloatBallHelper.6
 * JD-Core Version:    0.7.0.1
 */