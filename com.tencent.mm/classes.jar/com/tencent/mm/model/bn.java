package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;

public final class bn
  extends n
  implements k
{
  private com.tencent.mm.ak.g callback;
  private long cpR;
  private final a hpj;
  private final String hpk;
  
  public bn(a parama)
  {
    this(parama, null);
  }
  
  public bn(a parama, String paramString)
  {
    AppMethodBeat.i(132255);
    ac.i("MicroMsg.NetSceneLocalProxy", "init LocalProxy task:%s [%s] ", new Object[] { paramString, bs.eWi() });
    this.hpj = parama;
    this.hpk = paramString;
    AppMethodBeat.o(132255);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(132256);
    prepareDispatcher(parame);
    this.callback = paramg;
    this.cpR = bs.Gn();
    com.tencent.mm.kernel.g.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(132253);
        bn.this.onGYNetEnd(0, 0, 0, null, null, null);
        AppMethodBeat.o(132253);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(132254);
        String str = super.toString() + "|doScene";
        AppMethodBeat.o(132254);
        return str;
      }
    });
    AppMethodBeat.o(132256);
    return 0;
  }
  
  public final int getType()
  {
    return 0;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132257);
    if (this.hpj != null)
    {
      ac.d("MicroMsg.NetSceneLocalProxy", "local proxy [%s] end, cost=%d", new Object[] { this.hpk, Long.valueOf(bs.aO(this.cpR)) });
      this.hpj.a(super.dispatcher());
    }
    this.callback.onSceneEnd(0, 0, null, this);
    AppMethodBeat.o(132257);
  }
  
  public static abstract interface a
  {
    public abstract void a(e parame);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.bn
 * JD-Core Version:    0.7.0.1
 */