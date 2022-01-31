package com.tencent.mm.network;

import android.os.RemoteException;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class t$7
  extends bf<Integer>
{
  t$7(t paramt, Integer paramInteger, r paramr, l paraml)
  {
    super(3000L, paramInteger, (byte)0);
  }
  
  private Integer Uc()
  {
    try
    {
      int i = t.a(this.eNU, this.eOb, this.eOc);
      return Integer.valueOf(i);
    }
    catch (RemoteException localRemoteException)
    {
      y.e("MicroMsg.AutoAuth", "exception:%s", new Object[] { bk.j(localRemoteException) });
      t.a(this.eNU);
    }
    return Integer.valueOf(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.network.t.7
 * JD-Core Version:    0.7.0.1
 */