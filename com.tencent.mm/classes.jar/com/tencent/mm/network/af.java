package com.tencent.mm.network;

import android.os.Build.VERSION;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;

public final class af
  extends i.a
{
  private av hMj;
  private int iGw;
  private long iGx;
  private int iGy;
  private final RemoteCallbackList<n> iGz;
  
  public af()
  {
    AppMethodBeat.i(132934);
    this.iGw = 4;
    this.iGy = 0;
    this.iGz = new RemoteCallbackList();
    this.hMj = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(132933);
        int i = af.b(af.this).beginBroadcast();
        ad.i("MicroMsg.NetworkEvent", "listeners ct : %d", new Object[] { Integer.valueOf(i) });
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
                ad.e("MicroMsg.NetworkEvent", "exception:%s", new Object[] { bt.n(localRemoteException) });
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
  
  private boolean qG(int paramInt)
  {
    if (paramInt == this.iGw) {}
    do
    {
      do
      {
        return false;
        if (3 != paramInt) {
          break;
        }
      } while (this.iGw != 2);
      this.iGw = paramInt;
      return true;
      if (2 != paramInt) {
        break;
      }
    } while ((this.iGw == 0) || (this.iGw == 1));
    this.iGy += 1;
    if (this.iGy > 0)
    {
      this.iGw = 2;
      return true;
      if (4 == paramInt)
      {
        this.iGy = 0;
        this.iGw = 4;
        return true;
      }
      if ((Build.VERSION.SDK_INT >= 26) && (paramInt == -1))
      {
        this.iGw = 0;
        return true;
      }
    }
    this.iGw = paramInt;
    return true;
  }
  
  public final int aOK()
  {
    AppMethodBeat.i(132935);
    if (0L > bt.rM(this.iGx)) {}
    for (int i = 5;; i = this.iGw)
    {
      ad.i("MicroMsg.NetworkEvent", "getNowStatus = %d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(132935);
      return i;
    }
  }
  
  public final void aOL()
  {
    AppMethodBeat.i(132938);
    this.iGz.kill();
    AppMethodBeat.o(132938);
  }
  
  public final long aOM()
  {
    return this.iGx;
  }
  
  public final boolean c(n paramn)
  {
    AppMethodBeat.i(132936);
    try
    {
      this.iGz.register(paramn);
      AppMethodBeat.o(132936);
      return true;
    }
    catch (Exception paramn)
    {
      for (;;)
      {
        ad.e("MicroMsg.NetworkEvent", "addListener %s", new Object[] { paramn });
        ad.e("MicroMsg.NetworkEvent", "exception:%s", new Object[] { bt.n(paramn) });
      }
    }
  }
  
  public final boolean d(n paramn)
  {
    boolean bool1 = false;
    AppMethodBeat.i(132937);
    try
    {
      boolean bool2 = this.iGz.unregister(paramn);
      bool1 = bool2;
    }
    catch (Exception paramn)
    {
      for (;;)
      {
        ad.e("MicroMsg.NetworkEvent", "removeListener %s", new Object[] { paramn });
        ad.e("MicroMsg.NetworkEvent", "exception:%s", new Object[] { bt.n(paramn) });
      }
    }
    AppMethodBeat.o(132937);
    return bool1;
  }
  
  public final void qH(int paramInt)
  {
    AppMethodBeat.i(132939);
    ad.i("MicroMsg.NetworkEvent", "networkChange : %d", new Object[] { Integer.valueOf(paramInt) });
    if (!qG(paramInt))
    {
      AppMethodBeat.o(132939);
      return;
    }
    if ((this.iGw != 0) && (this.iGw != 4) && (this.iGw != 6))
    {
      AppMethodBeat.o(132939);
      return;
    }
    this.hMj.az(1000L, 1000L);
    AppMethodBeat.o(132939);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.network.af
 * JD-Core Version:    0.7.0.1
 */