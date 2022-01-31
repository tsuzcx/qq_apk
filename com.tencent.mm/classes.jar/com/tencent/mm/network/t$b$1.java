package com.tencent.mm.network;

import android.os.RemoteException;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class t$b$1
  extends bf<Object>
{
  t$b$1(t.b paramb, r paramr, int paramInt1, int paramInt2)
  {
    super(1000L, null, (byte)0);
  }
  
  protected final Object run()
  {
    try
    {
      t.a(t.b.a(this.eOv), this.eOu);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.network.t.b.1
 * JD-Core Version:    0.7.0.1
 */