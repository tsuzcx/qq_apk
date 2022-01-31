package com.tencent.mm.network;

import android.os.Build.VERSION;
import android.os.RemoteCallbackList;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;

public final class ad
  extends i.a
{
  private ap frx;
  private int geM;
  private long geN;
  private int geO;
  private final RemoteCallbackList<n> geP;
  
  public ad()
  {
    AppMethodBeat.i(58684);
    this.geM = 4;
    this.geO = 0;
    this.geP = new RemoteCallbackList();
    this.frx = new ap(new ad.1(this), false);
    AppMethodBeat.o(58684);
  }
  
  private boolean mB(int paramInt)
  {
    if (paramInt == this.geM) {}
    do
    {
      do
      {
        return false;
        if (3 != paramInt) {
          break;
        }
      } while (this.geM != 2);
      this.geM = paramInt;
      return true;
      if (2 != paramInt) {
        break;
      }
    } while ((this.geM == 0) || (this.geM == 1));
    this.geO += 1;
    if (this.geO > 0)
    {
      this.geM = 2;
      return true;
      if (4 == paramInt)
      {
        this.geO = 0;
        this.geM = 4;
        return true;
      }
      if ((Build.VERSION.SDK_INT >= 26) && (paramInt == -1))
      {
        this.geM = 0;
        return true;
      }
    }
    this.geM = paramInt;
    return true;
  }
  
  public final int anj()
  {
    AppMethodBeat.i(58685);
    if (0L > bo.gz(this.geN)) {}
    for (int i = 5;; i = this.geM)
    {
      ab.i("MicroMsg.NetworkEvent", "getNowStatus = %d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(58685);
      return i;
    }
  }
  
  public final void ank()
  {
    AppMethodBeat.i(58688);
    this.geP.kill();
    AppMethodBeat.o(58688);
  }
  
  public final long anl()
  {
    return this.geN;
  }
  
  public final boolean c(n paramn)
  {
    AppMethodBeat.i(58686);
    try
    {
      this.geP.register(paramn);
      AppMethodBeat.o(58686);
      return true;
    }
    catch (Exception paramn)
    {
      for (;;)
      {
        ab.e("MicroMsg.NetworkEvent", "addListener %s", new Object[] { paramn });
        ab.e("MicroMsg.NetworkEvent", "exception:%s", new Object[] { bo.l(paramn) });
      }
    }
  }
  
  public final boolean d(n paramn)
  {
    boolean bool1 = false;
    AppMethodBeat.i(58687);
    try
    {
      boolean bool2 = this.geP.unregister(paramn);
      bool1 = bool2;
    }
    catch (Exception paramn)
    {
      for (;;)
      {
        ab.e("MicroMsg.NetworkEvent", "removeListener %s", new Object[] { paramn });
        ab.e("MicroMsg.NetworkEvent", "exception:%s", new Object[] { bo.l(paramn) });
      }
    }
    AppMethodBeat.o(58687);
    return bool1;
  }
  
  public final void mC(int paramInt)
  {
    AppMethodBeat.i(58689);
    ab.i("MicroMsg.NetworkEvent", "networkChange : %d", new Object[] { Integer.valueOf(paramInt) });
    if (!mB(paramInt))
    {
      AppMethodBeat.o(58689);
      return;
    }
    if ((this.geM != 0) && (this.geM != 4) && (this.geM != 6))
    {
      AppMethodBeat.o(58689);
      return;
    }
    this.frx.ag(1000L, 1000L);
    AppMethodBeat.o(58689);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.network.ad
 * JD-Core Version:    0.7.0.1
 */