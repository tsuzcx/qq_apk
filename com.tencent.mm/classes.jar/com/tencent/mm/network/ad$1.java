package com.tencent.mm.network;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;

final class ad$1
  implements ap.a
{
  ad$1(ad paramad) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(58683);
    int i = ad.b(this.geQ).beginBroadcast();
    ab.i("MicroMsg.NetworkEvent", "listeners ct : %d", new Object[] { Integer.valueOf(i) });
    i -= 1;
    for (;;)
    {
      if (i >= 0)
      {
        n localn = (n)ad.b(this.geQ).getBroadcastItem(i);
        try
        {
          localn.onNetworkChange(ad.c(this.geQ));
          i -= 1;
        }
        catch (RemoteException localRemoteException)
        {
          for (;;)
          {
            ab.e("MicroMsg.NetworkEvent", "exception:%s", new Object[] { bo.l(localRemoteException) });
          }
        }
      }
    }
    ad.b(this.geQ).finishBroadcast();
    AppMethodBeat.o(58683);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.network.ad.1
 * JD-Core Version:    0.7.0.1
 */