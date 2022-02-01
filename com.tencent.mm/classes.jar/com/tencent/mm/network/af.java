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
  private av gTs;
  private int hMH;
  private long hMI;
  private int hMJ;
  private final RemoteCallbackList<n> hMK;
  
  public af()
  {
    AppMethodBeat.i(132934);
    this.hMH = 4;
    this.hMJ = 0;
    this.hMK = new RemoteCallbackList();
    this.gTs = new av(new av.a()
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
                ad.e("MicroMsg.NetworkEvent", "exception:%s", new Object[] { bt.m(localRemoteException) });
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
  
  private boolean pq(int paramInt)
  {
    if (paramInt == this.hMH) {}
    do
    {
      do
      {
        return false;
        if (3 != paramInt) {
          break;
        }
      } while (this.hMH != 2);
      this.hMH = paramInt;
      return true;
      if (2 != paramInt) {
        break;
      }
    } while ((this.hMH == 0) || (this.hMH == 1));
    this.hMJ += 1;
    if (this.hMJ > 0)
    {
      this.hMH = 2;
      return true;
      if (4 == paramInt)
      {
        this.hMJ = 0;
        this.hMH = 4;
        return true;
      }
      if ((Build.VERSION.SDK_INT >= 26) && (paramInt == -1))
      {
        this.hMH = 0;
        return true;
      }
    }
    this.hMH = paramInt;
    return true;
  }
  
  public final int aEJ()
  {
    AppMethodBeat.i(132935);
    if (0L > bt.lZ(this.hMI)) {}
    for (int i = 5;; i = this.hMH)
    {
      ad.i("MicroMsg.NetworkEvent", "getNowStatus = %d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(132935);
      return i;
    }
  }
  
  public final void aEK()
  {
    AppMethodBeat.i(132938);
    this.hMK.kill();
    AppMethodBeat.o(132938);
  }
  
  public final long aEL()
  {
    return this.hMI;
  }
  
  public final boolean c(n paramn)
  {
    AppMethodBeat.i(132936);
    try
    {
      this.hMK.register(paramn);
      AppMethodBeat.o(132936);
      return true;
    }
    catch (Exception paramn)
    {
      for (;;)
      {
        ad.e("MicroMsg.NetworkEvent", "addListener %s", new Object[] { paramn });
        ad.e("MicroMsg.NetworkEvent", "exception:%s", new Object[] { bt.m(paramn) });
      }
    }
  }
  
  public final boolean d(n paramn)
  {
    boolean bool1 = false;
    AppMethodBeat.i(132937);
    try
    {
      boolean bool2 = this.hMK.unregister(paramn);
      bool1 = bool2;
    }
    catch (Exception paramn)
    {
      for (;;)
      {
        ad.e("MicroMsg.NetworkEvent", "removeListener %s", new Object[] { paramn });
        ad.e("MicroMsg.NetworkEvent", "exception:%s", new Object[] { bt.m(paramn) });
      }
    }
    AppMethodBeat.o(132937);
    return bool1;
  }
  
  public final void pr(int paramInt)
  {
    AppMethodBeat.i(132939);
    ad.i("MicroMsg.NetworkEvent", "networkChange : %d", new Object[] { Integer.valueOf(paramInt) });
    if (!pq(paramInt))
    {
      AppMethodBeat.o(132939);
      return;
    }
    if ((this.hMH != 0) && (this.hMH != 4) && (this.hMH != 6))
    {
      AppMethodBeat.o(132939);
      return;
    }
    this.gTs.av(1000L, 1000L);
    AppMethodBeat.o(132939);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.network.af
 * JD-Core Version:    0.7.0.1
 */