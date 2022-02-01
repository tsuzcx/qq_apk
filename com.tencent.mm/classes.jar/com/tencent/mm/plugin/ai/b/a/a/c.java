package com.tencent.mm.plugin.ai.b.a.a;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.abt;
import com.tencent.mm.f.a.me;
import com.tencent.mm.f.a.ua;
import com.tencent.mm.f.a.vf;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
{
  private static final int[] nnU = { 10, 30, 90 };
  private static c nnV;
  private String nnJ;
  private long nnK;
  private a nnW;
  private b nnX;
  private long nnY;
  private PBool nnZ;
  public IListener<me> noa;
  public IListener<vf> nob;
  public IListener<abt> noc;
  
  private c()
  {
    AppMethodBeat.i(239067);
    this.nnZ = null;
    this.noa = new c.1(this);
    this.nob = new IListener() {};
    this.noc = new IListener() {};
    this.nnW = new a();
    this.nnX = new b();
    this.nnJ = "";
    this.nnY = 0L;
    this.nnK = 0L;
    AppMethodBeat.o(239067);
  }
  
  private void a(final boolean paramBoolean, final long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(239069);
    h.ZvG.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(240168);
        c.a(c.this, paramBoolean, paramLong1, this.nog);
        AppMethodBeat.o(240168);
      }
    }, "Ai_thread");
    AppMethodBeat.o(239069);
  }
  
  private static void abp(String paramString)
  {
    AppMethodBeat.i(239070);
    Log.i("MicroMsg.AiFinderData", "notify to run ai [%s]", new Object[] { paramString });
    ua localua = new ua();
    localua.fTo.fTp = paramString;
    EventCenter.instance.publish(localua);
    AppMethodBeat.o(239070);
  }
  
  public static c bAX()
  {
    AppMethodBeat.i(239065);
    if (nnV == null) {
      nnV = new c();
    }
    c localc = nnV;
    AppMethodBeat.o(239065);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.b.a.a.c
 * JD-Core Version:    0.7.0.1
 */