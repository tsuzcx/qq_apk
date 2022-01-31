package com.tencent.mm.plugin.cdndownloader.d;

import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.n.a;
import com.tencent.mm.sdk.platformtools.ab;

final class a$5
  extends n.a
{
  a$5(a parama) {}
  
  public final void onNetworkChange(int paramInt)
  {
    AppMethodBeat.i(897);
    a locala = this.kDM;
    ab.i("MicroMsg.CDNDownloadClient", "notifyNetworkChange: ".concat(String.valueOf(paramInt)));
    if (locala.kDF != null) {
      try
      {
        locala.kDF.tx(paramInt);
        AppMethodBeat.o(897);
        return;
      }
      catch (RemoteException localRemoteException) {}
    }
    AppMethodBeat.o(897);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.d.a.5
 * JD-Core Version:    0.7.0.1
 */