package com.tencent.mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.po;
import com.tencent.mm.model.ah;
import com.tencent.mm.model.ai;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.bc.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a
  implements ah
{
  private static volatile a fii;
  private List<ai> callbacks;
  private bc fig;
  private bc.a fih;
  private c fij;
  
  private a()
  {
    AppMethodBeat.i(149955);
    this.callbacks = new ArrayList();
    this.fig = new bc();
    this.fih = new bc.a()
    {
      public final void kq(int paramAnonymousInt)
      {
        AppMethodBeat.i(149953);
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(149953);
          return;
          ad.v("MicroMsg.BackgroundPlayer", "call end");
          a.this.Tj();
          AppMethodBeat.o(149953);
          return;
          ad.v("MicroMsg.BackgroundPlayer", "call start");
          a.this.Tk();
        }
      }
    };
    this.fig.a(this.fih);
    this.fig.iG(aj.getContext());
    if (this.fij == null) {
      this.fij = new c() {};
    }
    com.tencent.mm.sdk.b.a.ESL.c(this.fij);
    AppMethodBeat.o(149955);
  }
  
  public static a Ti()
  {
    AppMethodBeat.i(149956);
    if (fii == null) {}
    try
    {
      if (fii == null) {
        fii = new a();
      }
      a locala = fii;
      AppMethodBeat.o(149956);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(149956);
    }
  }
  
  public final void Tj()
  {
    AppMethodBeat.i(149959);
    if (this.callbacks == null)
    {
      AppMethodBeat.o(149959);
      return;
    }
    Iterator localIterator = this.callbacks.iterator();
    while (localIterator.hasNext()) {
      ((ai)localIterator.next()).arC();
    }
    AppMethodBeat.o(149959);
  }
  
  public final void Tk()
  {
    AppMethodBeat.i(149960);
    if (this.callbacks == null)
    {
      AppMethodBeat.o(149960);
      return;
    }
    Iterator localIterator = this.callbacks.iterator();
    while (localIterator.hasNext()) {
      ((ai)localIterator.next()).arD();
    }
    AppMethodBeat.o(149960);
  }
  
  public final void a(ai paramai)
  {
    AppMethodBeat.i(149957);
    ad.d("MicroMsg.BackgroundPlayer", "add callback : %s", new Object[] { paramai.toString() });
    this.callbacks.add(paramai);
    AppMethodBeat.o(149957);
  }
  
  public final void b(ai paramai)
  {
    AppMethodBeat.i(149958);
    this.callbacks.remove(paramai);
    AppMethodBeat.o(149958);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.booter.a
 * JD-Core Version:    0.7.0.1
 */