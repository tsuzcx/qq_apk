package com.tencent.mm.network;

import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.bo;

final class t$8
  extends bj<Integer>
{
  t$8(t paramt, Integer paramInteger, r paramr, l paraml)
  {
    super(3000L, paramInteger, (byte)0);
  }
  
  private Integer anp()
  {
    AppMethodBeat.i(58557);
    try
    {
      int i = t.a(this.gdI, this.gdP, this.gdQ);
      AppMethodBeat.o(58557);
      return Integer.valueOf(i);
    }
    catch (RemoteException localRemoteException)
    {
      ab.e("MicroMsg.MMAutoAuth", "exception:%s", new Object[] { bo.l(localRemoteException) });
      t.a(this.gdI);
      AppMethodBeat.o(58557);
    }
    return Integer.valueOf(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.network.t.8
 * JD-Core Version:    0.7.0.1
 */