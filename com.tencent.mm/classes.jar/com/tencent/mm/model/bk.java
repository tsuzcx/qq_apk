package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

public final class bk
  extends m
  implements k
{
  private f callback;
  private final a fnh;
  private final String fni;
  private long fnj;
  
  public bk(a parama)
  {
    this(parama, null);
  }
  
  public bk(a parama, String paramString)
  {
    AppMethodBeat.i(58111);
    ab.i("MicroMsg.NetSceneLocalProxy", "init LocalProxy task:%s [%s] ", new Object[] { paramString, bo.dtY() });
    this.fnh = parama;
    this.fni = paramString;
    AppMethodBeat.o(58111);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(58112);
    prepareDispatcher(parame);
    this.callback = paramf;
    this.fnj = bo.yB();
    g.RO().ac(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(58109);
        bk.this.onGYNetEnd(0, 0, 0, null, null, null);
        AppMethodBeat.o(58109);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(58110);
        String str = super.toString() + "|doScene";
        AppMethodBeat.o(58110);
        return str;
      }
    });
    AppMethodBeat.o(58112);
    return 0;
  }
  
  public final int getType()
  {
    return 0;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(58113);
    if (this.fnh != null)
    {
      ab.d("MicroMsg.NetSceneLocalProxy", "local proxy [%s] end, cost=%d", new Object[] { this.fni, Long.valueOf(bo.av(this.fnj)) });
      this.fnh.a(super.dispatcher());
    }
    this.callback.onSceneEnd(0, 0, null, this);
    AppMethodBeat.o(58113);
  }
  
  public static abstract interface a
  {
    public abstract void a(e parame);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.bk
 * JD-Core Version:    0.7.0.1
 */