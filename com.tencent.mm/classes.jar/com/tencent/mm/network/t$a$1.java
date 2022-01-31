package com.tencent.mm.network;

import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.bo;

final class t$a$1
  extends bj<Object>
{
  t$a$1(t.a parama, r paramr, int paramInt1, int paramInt2, String paramString)
  {
    super(1000L, null, (byte)0);
  }
  
  public final Object run()
  {
    AppMethodBeat.i(58565);
    try
    {
      t.a(t.a.a(this.geh), this.gef, this.geg);
      AppMethodBeat.o(58565);
      return null;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ab.e("MicroMsg.MMAutoAuth", "exception:%s", new Object[] { bo.l(localRemoteException) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.network.t.a.1
 * JD-Core Version:    0.7.0.1
 */