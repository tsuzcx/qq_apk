package com.tencent.mm.network;

import android.os.RemoteException;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class t$a$1
  extends bf<Object>
{
  t$a$1(t.a parama, r paramr, int paramInt1, int paramInt2, String paramString)
  {
    super(1000L, null, (byte)0);
  }
  
  protected final Object run()
  {
    try
    {
      t.a(t.a.a(this.eOt), this.eOr, this.eOs);
      return null;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        y.e("MicroMsg.AutoAuth", "exception:%s", new Object[] { bk.j(localRemoteException) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.network.t.a.1
 * JD-Core Version:    0.7.0.1
 */