package com.tencent.mm.network;

import android.os.Build.VERSION;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;

public final class ai
  extends k.a
{
  private MTimerHandler orP;
  private int ppV;
  private long ppW;
  private int ppX;
  private final RemoteCallbackList<p> ppY;
  
  public ai()
  {
    AppMethodBeat.i(132934);
    this.ppV = 4;
    this.ppX = 0;
    this.ppY = new RemoteCallbackList();
    this.orP = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(132933);
        int i = ai.b(ai.this).beginBroadcast();
        Log.i("MicroMsg.NetworkEvent", "listeners ct : %d", new Object[] { Integer.valueOf(i) });
        i -= 1;
        for (;;)
        {
          if (i >= 0)
          {
            p localp = (p)ai.b(ai.this).getBroadcastItem(i);
            try
            {
              localp.onNetworkChange(ai.c(ai.this));
              i -= 1;
            }
            catch (RemoteException localRemoteException)
            {
              for (;;)
              {
                Log.e("MicroMsg.NetworkEvent", "exception:%s", new Object[] { Util.stackTraceToString(localRemoteException) });
              }
            }
          }
        }
        ai.b(ai.this).finishBroadcast();
        AppMethodBeat.o(132933);
        return false;
      }
    }, false);
    AppMethodBeat.o(132934);
  }
  
  private boolean xC(int paramInt)
  {
    if (paramInt == this.ppV) {}
    do
    {
      do
      {
        return false;
        if (3 != paramInt) {
          break;
        }
      } while (this.ppV != 2);
      this.ppV = paramInt;
      return true;
      if (2 != paramInt) {
        break;
      }
    } while ((this.ppV == 0) || (this.ppV == 1));
    this.ppX += 1;
    if (this.ppX > 0)
    {
      this.ppV = 2;
      return true;
      if (4 == paramInt)
      {
        this.ppX = 0;
        this.ppV = 4;
        return true;
      }
      if ((Build.VERSION.SDK_INT >= 26) && (paramInt == -1))
      {
        this.ppV = 0;
        return true;
      }
    }
    this.ppV = paramInt;
    return true;
  }
  
  public final int bQP()
  {
    AppMethodBeat.i(132935);
    if (0L > Util.secondsToNow(this.ppW)) {}
    for (int i = 5;; i = this.ppV)
    {
      Log.i("MicroMsg.NetworkEvent", "getNowStatus = %d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(132935);
      return i;
    }
  }
  
  public final void bQQ()
  {
    AppMethodBeat.i(132938);
    this.ppY.kill();
    AppMethodBeat.o(132938);
  }
  
  public final long bQR()
  {
    return this.ppW;
  }
  
  public final boolean c(p paramp)
  {
    AppMethodBeat.i(132936);
    try
    {
      this.ppY.register(paramp);
      AppMethodBeat.o(132936);
      return true;
    }
    catch (Exception paramp)
    {
      for (;;)
      {
        Log.e("MicroMsg.NetworkEvent", "addListener %s", new Object[] { paramp });
        Log.e("MicroMsg.NetworkEvent", "exception:%s", new Object[] { Util.stackTraceToString(paramp) });
      }
    }
  }
  
  public final boolean d(p paramp)
  {
    boolean bool1 = false;
    AppMethodBeat.i(132937);
    try
    {
      boolean bool2 = this.ppY.unregister(paramp);
      bool1 = bool2;
    }
    catch (Exception paramp)
    {
      for (;;)
      {
        Log.e("MicroMsg.NetworkEvent", "removeListener %s", new Object[] { paramp });
        Log.e("MicroMsg.NetworkEvent", "exception:%s", new Object[] { Util.stackTraceToString(paramp) });
      }
    }
    AppMethodBeat.o(132937);
    return bool1;
  }
  
  public final void networkChange(int paramInt)
  {
    AppMethodBeat.i(132939);
    Log.i("MicroMsg.NetworkEvent", "networkChange : %d", new Object[] { Integer.valueOf(paramInt) });
    if (!xC(paramInt))
    {
      AppMethodBeat.o(132939);
      return;
    }
    if ((this.ppV != 0) && (this.ppV != 4) && (this.ppV != 6))
    {
      AppMethodBeat.o(132939);
      return;
    }
    this.orP.startTimer(1000L);
    AppMethodBeat.o(132939);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.network.ai
 * JD-Core Version:    0.7.0.1
 */