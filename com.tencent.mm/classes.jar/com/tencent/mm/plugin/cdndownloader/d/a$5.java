package com.tencent.mm.plugin.cdndownloader.d;

import android.os.RemoteException;
import com.tencent.mm.network.n.a;
import com.tencent.mm.sdk.platformtools.y;

final class a$5
  extends n.a
{
  a$5(a parama) {}
  
  public final void et(int paramInt)
  {
    a locala = this.iAG;
    y.i("MicroMsg.CDNDownloadClient", "notifyNetworkChange: " + paramInt);
    if (locala.iAz != null) {}
    try
    {
      locala.iAz.pi(paramInt);
      return;
    }
    catch (RemoteException localRemoteException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.d.a.5
 * JD-Core Version:    0.7.0.1
 */