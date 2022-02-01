package com.tencent.mm.network;

import android.os.Build.VERSION;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;

public final class ah
  extends k.a
{
  private MTimerHandler lAo;
  private int mww;
  private long mwx;
  private int mwy;
  private final RemoteCallbackList<p> mwz;
  
  public ah()
  {
    AppMethodBeat.i(132934);
    this.mww = 4;
    this.mwy = 0;
    this.mwz = new RemoteCallbackList();
    this.lAo = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(132933);
        int i = ah.b(ah.this).beginBroadcast();
        Log.i("MicroMsg.NetworkEvent", "listeners ct : %d", new Object[] { Integer.valueOf(i) });
        i -= 1;
        for (;;)
        {
          if (i >= 0)
          {
            p localp = (p)ah.b(ah.this).getBroadcastItem(i);
            try
            {
              localp.onNetworkChange(ah.c(ah.this));
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
        ah.b(ah.this).finishBroadcast();
        AppMethodBeat.o(132933);
        return false;
      }
    }, false);
    AppMethodBeat.o(132934);
  }
  
  private boolean xE(int paramInt)
  {
    if (paramInt == this.mww) {}
    do
    {
      do
      {
        return false;
        if (3 != paramInt) {
          break;
        }
      } while (this.mww != 2);
      this.mww = paramInt;
      return true;
      if (2 != paramInt) {
        break;
      }
    } while ((this.mww == 0) || (this.mww == 1));
    this.mwy += 1;
    if (this.mwy > 0)
    {
      this.mww = 2;
      return true;
      if (4 == paramInt)
      {
        this.mwy = 0;
        this.mww = 4;
        return true;
      }
      if ((Build.VERSION.SDK_INT >= 26) && (paramInt == -1))
      {
        this.mww = 0;
        return true;
      }
    }
    this.mww = paramInt;
    return true;
  }
  
  public final int btg()
  {
    AppMethodBeat.i(132935);
    if (0L > Util.secondsToNow(this.mwx)) {}
    for (int i = 5;; i = this.mww)
    {
      Log.i("MicroMsg.NetworkEvent", "getNowStatus = %d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(132935);
      return i;
    }
  }
  
  public final void bth()
  {
    AppMethodBeat.i(132938);
    this.mwz.kill();
    AppMethodBeat.o(132938);
  }
  
  public final long bti()
  {
    return this.mwx;
  }
  
  public final boolean c(p paramp)
  {
    AppMethodBeat.i(132936);
    try
    {
      this.mwz.register(paramp);
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
      boolean bool2 = this.mwz.unregister(paramp);
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
    if (!xE(paramInt))
    {
      AppMethodBeat.o(132939);
      return;
    }
    if ((this.mww != 0) && (this.mww != 4) && (this.mww != 6))
    {
      AppMethodBeat.o(132939);
      return;
    }
    this.lAo.startTimer(1000L);
    AppMethodBeat.o(132939);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.network.ah
 * JD-Core Version:    0.7.0.1
 */