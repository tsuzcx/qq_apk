package com.tencent.mm.plugin.ai.b.a.a;

import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.aal;
import com.tencent.mm.g.a.aam;
import com.tencent.mm.g.a.ln;
import com.tencent.mm.g.a.nm;
import com.tencent.mm.g.a.sz;
import com.tencent.mm.g.a.uc;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
{
  private static final int[] kvJ = { 10, 30, 90 };
  private static c kvK;
  private a kvL;
  private b kvM;
  private long kvN;
  private long kvO;
  private PBool kvP;
  public IListener<ln> kvQ;
  public IListener<uc> kvR;
  public IListener<aam> kvS;
  public IListener<aal> kvT;
  public IListener<nm> kvU;
  private String kvy;
  private long kvz;
  
  private c()
  {
    AppMethodBeat.i(238870);
    this.kvP = null;
    this.kvQ = new IListener() {};
    this.kvR = new IListener() {};
    this.kvS = new c.3(this);
    this.kvT = new IListener() {};
    this.kvU = new c.5(this);
    this.kvL = new a();
    this.kvM = new b();
    this.kvN = 0L;
    this.kvy = "";
    this.kvO = 0L;
    this.kvz = 0L;
    AppMethodBeat.o(238870);
  }
  
  private static void TG(String paramString)
  {
    AppMethodBeat.i(238872);
    Log.i("MicroMsg.AiFinderData", "notify to run ai [%s]", new Object[] { paramString });
    sz localsz = new sz();
    localsz.dZv.info = paramString;
    EventCenter.instance.publish(localsz);
    AppMethodBeat.o(238872);
  }
  
  private void a(final boolean paramBoolean, final long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(238871);
    h.RTc.b(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(238868);
        c.a(c.this, paramBoolean, paramLong1, this.kvY);
        AppMethodBeat.o(238868);
      }
    }, "Ai_thread");
    AppMethodBeat.o(238871);
  }
  
  public static c bqt()
  {
    AppMethodBeat.i(238869);
    if (kvK == null) {
      kvK = new c();
    }
    c localc = kvK;
    AppMethodBeat.o(238869);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.b.a.a.c
 * JD-Core Version:    0.7.0.1
 */