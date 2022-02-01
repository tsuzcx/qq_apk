package com.tencent.mm.network;

import android.os.Build.VERSION;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;

public final class af
  extends i.a
{
  private au htR;
  private int ine;
  private long inf;
  private int ing;
  private final RemoteCallbackList<n> inh;
  
  public af()
  {
    AppMethodBeat.i(132934);
    this.ine = 4;
    this.ing = 0;
    this.inh = new RemoteCallbackList();
    this.htR = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(132933);
        int i = af.b(af.this).beginBroadcast();
        ac.i("MicroMsg.NetworkEvent", "listeners ct : %d", new Object[] { Integer.valueOf(i) });
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
                ac.e("MicroMsg.NetworkEvent", "exception:%s", new Object[] { bs.m(localRemoteException) });
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
  
  private boolean qe(int paramInt)
  {
    if (paramInt == this.ine) {}
    do
    {
      do
      {
        return false;
        if (3 != paramInt) {
          break;
        }
      } while (this.ine != 2);
      this.ine = paramInt;
      return true;
      if (2 != paramInt) {
        break;
      }
    } while ((this.ine == 0) || (this.ine == 1));
    this.ing += 1;
    if (this.ing > 0)
    {
      this.ine = 2;
      return true;
      if (4 == paramInt)
      {
        this.ing = 0;
        this.ine = 4;
        return true;
      }
      if ((Build.VERSION.SDK_INT >= 26) && (paramInt == -1))
      {
        this.ine = 0;
        return true;
      }
    }
    this.ine = paramInt;
    return true;
  }
  
  public final int aLA()
  {
    AppMethodBeat.i(132935);
    if (0L > bs.pN(this.inf)) {}
    for (int i = 5;; i = this.ine)
    {
      ac.i("MicroMsg.NetworkEvent", "getNowStatus = %d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(132935);
      return i;
    }
  }
  
  public final void aLB()
  {
    AppMethodBeat.i(132938);
    this.inh.kill();
    AppMethodBeat.o(132938);
  }
  
  public final long aLC()
  {
    return this.inf;
  }
  
  public final boolean c(n paramn)
  {
    AppMethodBeat.i(132936);
    try
    {
      this.inh.register(paramn);
      AppMethodBeat.o(132936);
      return true;
    }
    catch (Exception paramn)
    {
      for (;;)
      {
        ac.e("MicroMsg.NetworkEvent", "addListener %s", new Object[] { paramn });
        ac.e("MicroMsg.NetworkEvent", "exception:%s", new Object[] { bs.m(paramn) });
      }
    }
  }
  
  public final boolean d(n paramn)
  {
    boolean bool1 = false;
    AppMethodBeat.i(132937);
    try
    {
      boolean bool2 = this.inh.unregister(paramn);
      bool1 = bool2;
    }
    catch (Exception paramn)
    {
      for (;;)
      {
        ac.e("MicroMsg.NetworkEvent", "removeListener %s", new Object[] { paramn });
        ac.e("MicroMsg.NetworkEvent", "exception:%s", new Object[] { bs.m(paramn) });
      }
    }
    AppMethodBeat.o(132937);
    return bool1;
  }
  
  public final void qf(int paramInt)
  {
    AppMethodBeat.i(132939);
    ac.i("MicroMsg.NetworkEvent", "networkChange : %d", new Object[] { Integer.valueOf(paramInt) });
    if (!qe(paramInt))
    {
      AppMethodBeat.o(132939);
      return;
    }
    if ((this.ine != 0) && (this.ine != 4) && (this.ine != 6))
    {
      AppMethodBeat.o(132939);
      return;
    }
    this.htR.au(1000L, 1000L);
    AppMethodBeat.o(132939);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.network.af
 * JD-Core Version:    0.7.0.1
 */