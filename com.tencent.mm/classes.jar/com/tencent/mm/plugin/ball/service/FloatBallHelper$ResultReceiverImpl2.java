package com.tencent.mm.plugin.ball.service;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

class FloatBallHelper$ResultReceiverImpl2
  extends ResultReceiver
{
  protected WeakReference<FloatBallHelper> vkb;
  
  public FloatBallHelper$ResultReceiverImpl2(Handler paramHandler, FloatBallHelper paramFloatBallHelper)
  {
    super(paramHandler);
    AppMethodBeat.i(288423);
    this.vkb = new WeakReference(paramFloatBallHelper);
    AppMethodBeat.o(288423);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(288430);
    FloatBallHelper localFloatBallHelper = (FloatBallHelper)this.vkb.get();
    if (localFloatBallHelper == null)
    {
      AppMethodBeat.o(288430);
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(288430);
      return;
      int i;
      if (paramBundle != null)
      {
        i = paramBundle.getInt("type", 0);
        paramBundle = paramBundle.getString("key", null);
        if (i != 0)
        {
          localFloatBallHelper.as(i, paramBundle);
          Log.i("MicroMsg.FloatBallHelper", "onReceiveResult:%s(ADD_BALL_INFO), type:%d, key: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramBundle });
          AppMethodBeat.o(288430);
          return;
        }
        Log.i("MicroMsg.FloatBallHelper", "onReceiveResult:%s(ADD_BALL_INFO), no type", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(288430);
        return;
      }
      Log.i("MicroMsg.FloatBallHelper", "onReceiveResult:%s(ADD_BALL_INFO), no resultData", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(288430);
      return;
      Log.i("MicroMsg.FloatBallHelper", "onReceiveResult:%s(UPDATE_BALL_INFO)", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(288430);
      return;
      Log.i("MicroMsg.FloatBallHelper", "onReceiveResult:%s(REMOVE_BALL_INFO)", new Object[] { Integer.valueOf(paramInt) });
      localFloatBallHelper.coj();
      AppMethodBeat.o(288430);
      return;
      Log.i("MicroMsg.FloatBallHelper", "onReceiveResult:%s(FINISH_WHEN_SWITCH_BALL)", new Object[] { Integer.valueOf(paramInt) });
      localFloatBallHelper.bhV();
      AppMethodBeat.o(288430);
      return;
      if (paramBundle != null)
      {
        i = paramBundle.getInt("ActiveCount", 0);
        localFloatBallHelper.FI(i);
        Log.i("MicroMsg.FloatBallHelper", "onReceiveResult:%s(BALL_INFO_COUNT_CHANGED), activeCount:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        AppMethodBeat.o(288430);
        return;
      }
      Log.i("MicroMsg.FloatBallHelper", "onReceiveResult:%s(BALL_INFO_COUNT_CHANGED), no resultData", new Object[] { Integer.valueOf(paramInt) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.service.FloatBallHelper.ResultReceiverImpl2
 * JD-Core Version:    0.7.0.1
 */