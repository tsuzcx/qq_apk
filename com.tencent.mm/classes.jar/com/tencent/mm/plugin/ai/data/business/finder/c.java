package com.tencent.mm.plugin.ai.data.business.finder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.adq;
import com.tencent.mm.autogen.a.nk;
import com.tencent.mm.autogen.a.vq;
import com.tencent.mm.autogen.a.wv;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;

public final class c
{
  private static final int[] qlb = { 10, 30, 90 };
  private static c qlc;
  private String qkQ;
  private long qkR;
  private a qld;
  private b qle;
  private long qlf;
  private PBool qlg;
  public IListener<nk> qlh;
  public IListener<wv> qli;
  public IListener<adq> qlj;
  
  private c()
  {
    AppMethodBeat.i(267477);
    this.qlg = null;
    this.qlh = new AiFinderData.1(this, f.hfK);
    this.qli = new AiFinderData.2(this, f.hfK);
    this.qlj = new AiFinderData.3(this, f.hfK);
    this.qld = new a();
    this.qle = new b();
    this.qkQ = "";
    this.qlf = 0L;
    this.qkR = 0L;
    AppMethodBeat.o(267477);
  }
  
  private static void TG(String paramString)
  {
    AppMethodBeat.i(267492);
    Log.i("MicroMsg.AiFinderData", "notify to run ai [%s]", new Object[] { paramString });
    vq localvq = new vq();
    localvq.hZm.hZn = paramString;
    localvq.publish();
    AppMethodBeat.o(267492);
  }
  
  private void a(final boolean paramBoolean, final long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(267484);
    h.ahAA.g(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(267506);
        c.a(c.this, paramBoolean, paramLong1, this.qln);
        AppMethodBeat.o(267506);
      }
    }, "Ai_thread");
    AppMethodBeat.o(267484);
  }
  
  public static c bZK()
  {
    AppMethodBeat.i(267468);
    if (qlc == null) {
      qlc = new c();
    }
    c localc = qlc;
    AppMethodBeat.o(267468);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.data.business.finder.c
 * JD-Core Version:    0.7.0.1
 */