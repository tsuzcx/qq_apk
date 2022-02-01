package com.tencent.luggage.sdk.b.a.c;

import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.plugin.appbrand.utils.q.b;
import java.util.concurrent.atomic.AtomicInteger;

final class b$d
  implements q.b
{
  private final String cki;
  private final long ckk;
  private boolean ckl;
  private m.c ckm;
  private final AtomicInteger ckn;
  private final c coR;
  private int coT;
  
  private b$d(String paramString, c paramc)
  {
    AppMethodBeat.i(169433);
    this.coT = 0;
    this.ckl = false;
    this.ckm = null;
    this.ckn = new AtomicInteger(2);
    this.cki = paramString;
    this.coR = paramc;
    this.ckk = System.currentTimeMillis();
    AppMethodBeat.o(169433);
  }
  
  private void Dh()
  {
    AppMethodBeat.i(169437);
    long l1;
    if (this.ckn.decrementAndGet() == 0)
    {
      if (this.ckm != null) {
        break label90;
      }
      l1 = this.ckk;
      if (this.ckm != null) {
        break label101;
      }
    }
    label90:
    label101:
    for (long l2 = System.currentTimeMillis();; l2 = this.ckm.cYJ)
    {
      d.a locala = new d.a();
      locala.scriptName = this.cki;
      locala.cnw = this.coT;
      this.coR.a(locala, this.ckl, l1, l2, this.ckm);
      AppMethodBeat.o(169437);
      return;
      l1 = this.ckm.cYI;
      break;
    }
  }
  
  public final void a(m.c paramc)
  {
    AppMethodBeat.i(169434);
    this.ckm = paramc;
    this.coT = paramc.sourceLength;
    Dh();
    AppMethodBeat.o(169434);
  }
  
  public final void cT(String paramString)
  {
    AppMethodBeat.i(169436);
    this.ckl = false;
    Dh();
    AppMethodBeat.o(169436);
  }
  
  public final void onSuccess(String paramString)
  {
    AppMethodBeat.i(169435);
    this.ckl = true;
    Dh();
    AppMethodBeat.o(169435);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.c.b.d
 * JD-Core Version:    0.7.0.1
 */