package com.tencent.mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ah;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.sdk.platformtools.bb.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a
  implements ah
{
  private static volatile a flD;
  private List<com.tencent.mm.model.ai> callbacks;
  private bb flB;
  private bb.a flC;
  private c flE;
  
  private a()
  {
    AppMethodBeat.i(149955);
    this.callbacks = new ArrayList();
    this.flB = new bb();
    this.flC = new bb.a()
    {
      public final void kn(int paramAnonymousInt)
      {
        AppMethodBeat.i(149953);
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(149953);
          return;
          ac.v("MicroMsg.BackgroundPlayer", "call end");
          a.this.Ud();
          AppMethodBeat.o(149953);
          return;
          ac.v("MicroMsg.BackgroundPlayer", "call start");
          a.this.Ue();
        }
      }
    };
    this.flB.a(this.flC);
    this.flB.iR(com.tencent.mm.sdk.platformtools.ai.getContext());
    if (this.flE == null) {
      this.flE = new a.2(this);
    }
    com.tencent.mm.sdk.b.a.GpY.c(this.flE);
    AppMethodBeat.o(149955);
  }
  
  public static a Uc()
  {
    AppMethodBeat.i(149956);
    if (flD == null) {}
    try
    {
      if (flD == null) {
        flD = new a();
      }
      a locala = flD;
      AppMethodBeat.o(149956);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(149956);
    }
  }
  
  public final void Ud()
  {
    AppMethodBeat.i(149959);
    if (this.callbacks == null)
    {
      AppMethodBeat.o(149959);
      return;
    }
    Iterator localIterator = this.callbacks.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.model.ai)localIterator.next()).ayt();
    }
    AppMethodBeat.o(149959);
  }
  
  public final void Ue()
  {
    AppMethodBeat.i(149960);
    if (this.callbacks == null)
    {
      AppMethodBeat.o(149960);
      return;
    }
    Iterator localIterator = this.callbacks.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.model.ai)localIterator.next()).ayu();
    }
    AppMethodBeat.o(149960);
  }
  
  public final void a(com.tencent.mm.model.ai paramai)
  {
    AppMethodBeat.i(149957);
    ac.d("MicroMsg.BackgroundPlayer", "add callback : %s", new Object[] { paramai.toString() });
    this.callbacks.add(paramai);
    AppMethodBeat.o(149957);
  }
  
  public final void b(com.tencent.mm.model.ai paramai)
  {
    AppMethodBeat.i(149958);
    this.callbacks.remove(paramai);
    AppMethodBeat.o(149958);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.booter.a
 * JD-Core Version:    0.7.0.1
 */