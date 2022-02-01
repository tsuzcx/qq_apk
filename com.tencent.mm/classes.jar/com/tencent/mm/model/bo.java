package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;

public final class bo
  extends n
  implements k
{
  private long cAI;
  private f callback;
  private final a hHB;
  private final String hHC;
  
  public bo(a parama)
  {
    this(parama, null);
  }
  
  public bo(a parama, String paramString)
  {
    AppMethodBeat.i(132255);
    ad.i("MicroMsg.NetSceneLocalProxy", "init LocalProxy task:%s [%s] ", new Object[] { paramString, bt.flS() });
    this.hHB = parama;
    this.hHC = paramString;
    AppMethodBeat.o(132255);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(132256);
    prepareDispatcher(parame);
    this.callback = paramf;
    this.cAI = bt.HI();
    g.ajF().ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(132253);
        bo.this.onGYNetEnd(0, 0, 0, null, null, null);
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
    if (this.hHB != null)
    {
      ad.d("MicroMsg.NetSceneLocalProxy", "local proxy [%s] end, cost=%d", new Object[] { this.hHC, Long.valueOf(bt.aO(this.cAI)) });
      this.hHB.a(super.dispatcher());
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
 * Qualified Name:     com.tencent.mm.model.bo
 * JD-Core Version:    0.7.0.1
 */