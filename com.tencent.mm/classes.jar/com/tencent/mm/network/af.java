package com.tencent.mm.network;

import android.os.Build.VERSION;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;

public final class af
  extends i.a
{
  private aw hPc;
  private int iJp;
  private long iJq;
  private int iJr;
  private final RemoteCallbackList<n> iJs;
  
  public af()
  {
    AppMethodBeat.i(132934);
    this.iJp = 4;
    this.iJr = 0;
    this.iJs = new RemoteCallbackList();
    this.hPc = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(132933);
        int i = af.b(af.this).beginBroadcast();
        ae.i("MicroMsg.NetworkEvent", "listeners ct : %d", new Object[] { Integer.valueOf(i) });
        i -= 1;
        for (;;)
        {
          if (i >= 0)
          {
            n localn = (n)af.b(af.this).getBroadcastItem(i);
            try
            {
              localn.onNetworkChange(af.c(af.this));
              i -= 1;
            }
            catch (RemoteException localRemoteException)
            {
              for (;;)
              {
                ae.e("MicroMsg.NetworkEvent", "exception:%s", new Object[] { bu.o(localRemoteException) });
              }
            }
          }
        }
        af.b(af.this).finishBroadcast();
        AppMethodBeat.o(132933);
        return false;
      }
    }, false);
    AppMethodBeat.o(132934);
  }
  
  private boolean qJ(int paramInt)
  {
    if (paramInt == this.iJp) {}
    do
    {
      do
      {
        return false;
        if (3 != paramInt) {
          break;
        }
      } while (this.iJp != 2);
      this.iJp = paramInt;
      return true;
      if (2 != paramInt) {
        break;
      }
    } while ((this.iJp == 0) || (this.iJp == 1));
    this.iJr += 1;
    if (this.iJr > 0)
    {
      this.iJp = 2;
      return true;
      if (4 == paramInt)
      {
        this.iJr = 0;
        this.iJp = 4;
        return true;
      }
      if ((Build.VERSION.SDK_INT >= 26) && (paramInt == -1))
      {
        this.iJp = 0;
        return true;
      }
    }
    this.iJp = paramInt;
    return true;
  }
  
  public final int aPh()
  {
    AppMethodBeat.i(132935);
    if (0L > bu.rZ(this.iJq)) {}
    for (int i = 5;; i = this.iJp)
    {
      ae.i("MicroMsg.NetworkEvent", "getNowStatus = %d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(132935);
      return i;
    }
  }
  
  public final void aPi()
  {
    AppMethodBeat.i(132938);
    this.iJs.kill();
    AppMethodBeat.o(132938);
  }
  
  public final long aPj()
  {
    return this.iJq;
  }
  
  public final boolean c(n paramn)
  {
    AppMethodBeat.i(132936);
    try
    {
      this.iJs.register(paramn);
      AppMethodBeat.o(132936);
      return true;
    }
    catch (Exception paramn)
    {
      for (;;)
      {
        ae.e("MicroMsg.NetworkEvent", "addListener %s", new Object[] { paramn });
        ae.e("MicroMsg.NetworkEvent", "exception:%s", new Object[] { bu.o(paramn) });
      }
    }
  }
  
  public final boolean d(n paramn)
  {
    boolean bool1 = false;
    AppMethodBeat.i(132937);
    try
    {
      boolean bool2 = this.iJs.unregister(paramn);
      bool1 = bool2;
    }
    catch (Exception paramn)
    {
      for (;;)
      {
        ae.e("MicroMsg.NetworkEvent", "removeListener %s", new Object[] { paramn });
        ae.e("MicroMsg.NetworkEvent", "exception:%s", new Object[] { bu.o(paramn) });
      }
    }
    AppMethodBeat.o(132937);
    return bool1;
  }
  
  public final void qK(int paramInt)
  {
    AppMethodBeat.i(132939);
    ae.i("MicroMsg.NetworkEvent", "networkChange : %d", new Object[] { Integer.valueOf(paramInt) });
    if (!qJ(paramInt))
    {
      AppMethodBeat.o(132939);
      return;
    }
    if ((this.iJp != 0) && (this.iJp != 4) && (this.iJp != 6))
    {
      AppMethodBeat.o(132939);
      return;
    }
    this.hPc.ay(1000L, 1000L);
    AppMethodBeat.o(132939);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.network.af
 * JD-Core Version:    0.7.0.1
 */