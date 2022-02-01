package com.tencent.mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.qi;
import com.tencent.mm.model.ai;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.bc.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a
  implements ai
{
  private static volatile a fDK;
  private List<com.tencent.mm.model.aj> callbacks;
  private bc fDI;
  private bc.a fDJ;
  private c fDL;
  
  private a()
  {
    AppMethodBeat.i(149955);
    this.callbacks = new ArrayList();
    this.fDI = new bc();
    this.fDJ = new bc.a()
    {
      public final void kK(int paramAnonymousInt)
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
          a.this.Wu();
          AppMethodBeat.o(149953);
          return;
          ad.v("MicroMsg.BackgroundPlayer", "call start");
          a.this.Wv();
        }
      }
    };
    this.fDI.a(this.fDJ);
    this.fDI.jb(com.tencent.mm.sdk.platformtools.aj.getContext());
    if (this.fDL == null) {
      this.fDL = new c() {};
    }
    com.tencent.mm.sdk.b.a.IbL.c(this.fDL);
    AppMethodBeat.o(149955);
  }
  
  public static a Wt()
  {
    AppMethodBeat.i(149956);
    if (fDK == null) {}
    try
    {
      if (fDK == null) {
        fDK = new a();
      }
      a locala = fDK;
      AppMethodBeat.o(149956);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(149956);
    }
  }
  
  public final void Wu()
  {
    AppMethodBeat.i(149959);
    if (this.callbacks == null)
    {
      AppMethodBeat.o(149959);
      return;
    }
    Iterator localIterator = this.callbacks.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.model.aj)localIterator.next()).aBx();
    }
    AppMethodBeat.o(149959);
  }
  
  public final void Wv()
  {
    AppMethodBeat.i(149960);
    if (this.callbacks == null)
    {
      AppMethodBeat.o(149960);
      return;
    }
    Iterator localIterator = this.callbacks.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.model.aj)localIterator.next()).aBy();
    }
    AppMethodBeat.o(149960);
  }
  
  public final void a(com.tencent.mm.model.aj paramaj)
  {
    AppMethodBeat.i(149957);
    ad.d("MicroMsg.BackgroundPlayer", "add callback : %s", new Object[] { paramaj.toString() });
    this.callbacks.add(paramaj);
    AppMethodBeat.o(149957);
  }
  
  public final void b(com.tencent.mm.model.aj paramaj)
  {
    AppMethodBeat.i(149958);
    this.callbacks.remove(paramaj);
    AppMethodBeat.o(149958);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.booter.a
 * JD-Core Version:    0.7.0.1
 */