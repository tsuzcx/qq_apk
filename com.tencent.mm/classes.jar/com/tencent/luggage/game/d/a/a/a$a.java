package com.tencent.luggage.game.d.a.a;

import com.tencent.luggage.sdk.b.a.c.c;
import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.plugin.appbrand.utils.q.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.concurrent.atomic.AtomicInteger;

final class a$a
  implements q.b
{
  private final String cki;
  private final String ckj;
  private final long ckk;
  private boolean ckl;
  private m.c ckm;
  private final AtomicInteger ckn;
  
  a$a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(130541);
    this.ckk = this.cko;
    this.ckl = false;
    this.ckm = null;
    this.ckn = new AtomicInteger(2);
    this.cki = paramString2;
    Object localObject1;
    this.ckj = localObject1;
    AppMethodBeat.o(130541);
  }
  
  private void Dh()
  {
    AppMethodBeat.i(130545);
    long l1;
    if (this.ckn.decrementAndGet() == 0)
    {
      if (this.ckm != null) {
        break label111;
      }
      l1 = this.ckk;
      if (this.ckm != null) {
        break label122;
      }
    }
    label111:
    label122:
    for (long l2 = System.currentTimeMillis();; l2 = this.ckm.cYJ)
    {
      d.a locala = new d.a();
      locala.scriptName = this.cki;
      locala.cnv = this.ckj;
      locala.cnw = bt.nullAsNil(this.ckj).length();
      ((c)this.ckh.El()).a(locala, this.ckl, l1, l2, this.ckm);
      AppMethodBeat.o(130545);
      return;
      l1 = this.ckm.cYI;
      break;
    }
  }
  
  public final void a(m.c paramc)
  {
    AppMethodBeat.i(130542);
    this.ckm = paramc;
    Dh();
    AppMethodBeat.o(130542);
  }
  
  public final void cT(String paramString)
  {
    AppMethodBeat.i(130544);
    ad.e("Luggage.AppBrandGameServiceLogicImp", "Inject SDK WAGame Script Failed: %s", new Object[] { paramString });
    a.Dg();
    this.ckl = false;
    Dh();
    AppMethodBeat.o(130544);
  }
  
  public final void onSuccess(String paramString)
  {
    AppMethodBeat.i(130543);
    ad.i("Luggage.AppBrandGameServiceLogicImp", "Inject SDK WAGame Script suc: %s, filelen: %d", new Object[] { paramString, Integer.valueOf(this.ckp) });
    a.Df();
    this.ckl = true;
    Dh();
    AppMethodBeat.o(130543);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.luggage.game.d.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */