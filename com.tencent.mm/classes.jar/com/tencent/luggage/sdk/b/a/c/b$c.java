package com.tencent.luggage.sdk.b.a.c;

import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.appbrand.v8.x;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.utils.q.b;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.concurrent.atomic.AtomicInteger;

final class b$c
  implements q.b
{
  private final String cki;
  private final String ckj;
  private final long ckk;
  private boolean ckl;
  private m.c ckm;
  private final AtomicInteger ckn;
  private final c coR;
  private final boolean coS;
  
  private b$c(String paramString1, String paramString2, c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(146793);
    this.ckl = false;
    this.ckm = null;
    this.ckn = new AtomicInteger(2);
    this.cki = paramString1;
    this.ckj = paramString2;
    this.coR = paramc;
    this.coS = paramBoolean;
    this.ckk = System.currentTimeMillis();
    AppMethodBeat.o(146793);
  }
  
  private void Dh()
  {
    AppMethodBeat.i(146797);
    long l1;
    if (this.ckn.decrementAndGet() == 0)
    {
      if (this.ckm != null) {
        break label105;
      }
      l1 = this.ckk;
      if (this.ckm != null) {
        break label116;
      }
    }
    label105:
    label116:
    for (long l2 = System.currentTimeMillis();; l2 = this.ckm.cYJ)
    {
      d.a locala = new d.a();
      locala.scriptName = this.cki;
      locala.cnv = this.ckj;
      locala.cnw = bt.nullAsNil(this.ckj).length();
      this.coR.a(locala, this.ckl, l1, l2, this.ckm);
      AppMethodBeat.o(146797);
      return;
      l1 = this.ckm.cYI;
      break;
    }
  }
  
  public final void a(m.c paramc)
  {
    AppMethodBeat.i(146794);
    this.ckm = paramc;
    Dh();
    AppMethodBeat.o(146794);
  }
  
  public final void cT(String paramString)
  {
    AppMethodBeat.i(146796);
    this.ckl = false;
    Dh();
    AppMethodBeat.o(146796);
  }
  
  public final void onSuccess(String paramString)
  {
    int i = 1;
    AppMethodBeat.i(146795);
    this.ckl = true;
    Dh();
    long l1;
    long l2;
    if (this.cki.equals("WAService.js"))
    {
      l1 = System.currentTimeMillis();
      l2 = this.ckk;
      if (!this.coS) {
        break label81;
      }
    }
    for (;;)
    {
      x.a(2, l1 - l2, i, this.coR.getAppId(), -1, 0, this.coR.aVF().aZp());
      AppMethodBeat.o(146795);
      return;
      label81:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.c.b.c
 * JD-Core Version:    0.7.0.1
 */