package com.tencent.mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aj;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bd.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a
  implements aj
{
  private static volatile a fFO;
  private List<com.tencent.mm.model.ak> callbacks;
  private bd fFM;
  private bd.a fFN;
  private c fFP;
  
  private a()
  {
    AppMethodBeat.i(149955);
    this.callbacks = new ArrayList();
    this.fFM = new bd();
    this.fFN = new bd.a()
    {
      public final void kM(int paramAnonymousInt)
      {
        AppMethodBeat.i(149953);
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(149953);
          return;
          ae.v("MicroMsg.BackgroundPlayer", "call end");
          a.this.WC();
          AppMethodBeat.o(149953);
          return;
          ae.v("MicroMsg.BackgroundPlayer", "call start");
          a.this.WD();
        }
      }
    };
    this.fFM.a(this.fFN);
    this.fFM.jg(com.tencent.mm.sdk.platformtools.ak.getContext());
    if (this.fFP == null) {
      this.fFP = new a.2(this);
    }
    com.tencent.mm.sdk.b.a.IvT.c(this.fFP);
    AppMethodBeat.o(149955);
  }
  
  public static a WB()
  {
    AppMethodBeat.i(149956);
    if (fFO == null) {}
    try
    {
      if (fFO == null) {
        fFO = new a();
      }
      a locala = fFO;
      AppMethodBeat.o(149956);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(149956);
    }
  }
  
  public final void WC()
  {
    AppMethodBeat.i(149959);
    if (this.callbacks == null)
    {
      AppMethodBeat.o(149959);
      return;
    }
    Iterator localIterator = this.callbacks.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.model.ak)localIterator.next()).aBN();
    }
    AppMethodBeat.o(149959);
  }
  
  public final void WD()
  {
    AppMethodBeat.i(149960);
    if (this.callbacks == null)
    {
      AppMethodBeat.o(149960);
      return;
    }
    Iterator localIterator = this.callbacks.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.model.ak)localIterator.next()).aBO();
    }
    AppMethodBeat.o(149960);
  }
  
  public final void a(com.tencent.mm.model.ak paramak)
  {
    AppMethodBeat.i(149957);
    ae.d("MicroMsg.BackgroundPlayer", "add callback : %s", new Object[] { paramak.toString() });
    this.callbacks.add(paramak);
    AppMethodBeat.o(149957);
  }
  
  public final void b(com.tencent.mm.model.ak paramak)
  {
    AppMethodBeat.i(149958);
    this.callbacks.remove(paramak);
    AppMethodBeat.o(149958);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.booter.a
 * JD-Core Version:    0.7.0.1
 */