package com.tencent.mm.network;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class ac$1
  implements am.a
{
  ac$1(ac paramac) {}
  
  public final boolean tC()
  {
    int i = ac.b(this.ePd).beginBroadcast();
    y.i("MicroMsg.NetworkEvent", "listeners ct : %d", new Object[] { Integer.valueOf(i) });
    i -= 1;
    for (;;)
    {
      if (i >= 0)
      {
        n localn = (n)ac.b(this.ePd).getBroadcastItem(i);
        try
        {
          localn.et(ac.c(this.ePd));
          i -= 1;
        }
        catch (RemoteException localRemoteException)
        {
          for (;;)
          {
            y.e("MicroMsg.NetworkEvent", "exception:%s", new Object[] { bk.j(localRemoteException) });
          }
        }
      }
    }
    ac.b(this.ePd).finishBroadcast();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.network.ac.1
 * JD-Core Version:    0.7.0.1
 */