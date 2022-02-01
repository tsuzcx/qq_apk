package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;

public final class bu
  extends q
  implements m
{
  private long begin;
  private i callback;
  private final a iFh;
  private final String iFi;
  
  public bu(a parama)
  {
    this(parama, null);
  }
  
  public bu(a parama, String paramString)
  {
    AppMethodBeat.i(132255);
    Log.i("MicroMsg.NetSceneLocalProxy", "init LocalProxy task:%s [%s] ", new Object[] { paramString, Util.getStack() });
    this.iFh = parama;
    this.iFi = paramString;
    AppMethodBeat.o(132255);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(132256);
    prepareDispatcher(paramg);
    this.callback = parami;
    this.begin = Util.currentTicks();
    com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(132253);
        bu.this.onGYNetEnd(0, 0, 0, null, null, null);
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(132257);
    if (this.iFh != null)
    {
      Log.d("MicroMsg.NetSceneLocalProxy", "local proxy [%s] end, cost=%d", new Object[] { this.iFi, Long.valueOf(Util.ticksToNow(this.begin)) });
      this.iFh.a(super.dispatcher());
    }
    this.callback.onSceneEnd(0, 0, null, this);
    AppMethodBeat.o(132257);
  }
  
  public static abstract interface a
  {
    public abstract void a(com.tencent.mm.network.g paramg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.bu
 * JD-Core Version:    0.7.0.1
 */