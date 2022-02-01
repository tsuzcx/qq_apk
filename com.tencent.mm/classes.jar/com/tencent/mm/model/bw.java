package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;

public final class bw
  extends p
  implements m
{
  private long begin;
  private com.tencent.mm.am.h callback;
  private final a omG;
  private final String omH;
  
  public bw(a parama)
  {
    this(parama, null);
  }
  
  public bw(a parama, String paramString)
  {
    AppMethodBeat.i(132255);
    Log.i("MicroMsg.NetSceneLocalProxy", "init LocalProxy task:%s", new Object[] { paramString });
    this.omG = parama;
    this.omH = paramString;
    AppMethodBeat.o(132255);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(132256);
    prepareDispatcher(paramg);
    this.callback = paramh;
    this.begin = Util.currentTicks();
    com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(132253);
        bw.this.onGYNetEnd(0, 0, 0, null, null, null);
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
    if (this.omG != null)
    {
      Log.d("MicroMsg.NetSceneLocalProxy", "local proxy [%s] end, cost=%d", new Object[] { this.omH, Long.valueOf(Util.ticksToNow(this.begin)) });
      this.omG.b(super.dispatcher());
    }
    this.callback.onSceneEnd(0, 0, null, this);
    AppMethodBeat.o(132257);
  }
  
  public static abstract interface a
  {
    public abstract void b(g paramg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.bw
 * JD-Core Version:    0.7.0.1
 */