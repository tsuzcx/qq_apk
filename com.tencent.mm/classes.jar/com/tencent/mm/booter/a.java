package com.tencent.mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ae;
import com.tencent.mm.model.af;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.ax.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a
  implements ae
{
  private static volatile a dYx;
  private List<af> callbacks;
  private ax dYv;
  private ax.a dYw;
  private c dYy;
  
  private a()
  {
    AppMethodBeat.i(77621);
    this.callbacks = new ArrayList();
    this.dYv = new ax();
    this.dYw = new a.1(this);
    this.dYv.a(this.dYw);
    this.dYv.hd(ah.getContext());
    if (this.dYy == null) {
      this.dYy = new a.2(this);
    }
    com.tencent.mm.sdk.b.a.ymk.c(this.dYy);
    AppMethodBeat.o(77621);
  }
  
  public static a Ia()
  {
    AppMethodBeat.i(77622);
    if (dYx == null) {}
    try
    {
      if (dYx == null) {
        dYx = new a();
      }
      a locala = dYx;
      AppMethodBeat.o(77622);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(77622);
    }
  }
  
  public final void Ib()
  {
    AppMethodBeat.i(77625);
    if (this.callbacks == null)
    {
      AppMethodBeat.o(77625);
      return;
    }
    Iterator localIterator = this.callbacks.iterator();
    while (localIterator.hasNext()) {
      ((af)localIterator.next()).aah();
    }
    AppMethodBeat.o(77625);
  }
  
  public final void Ic()
  {
    AppMethodBeat.i(77626);
    if (this.callbacks == null)
    {
      AppMethodBeat.o(77626);
      return;
    }
    Iterator localIterator = this.callbacks.iterator();
    while (localIterator.hasNext()) {
      ((af)localIterator.next()).aai();
    }
    AppMethodBeat.o(77626);
  }
  
  public final void a(af paramaf)
  {
    AppMethodBeat.i(77623);
    ab.d("MicroMsg.BackgroundPlayer", "add callback : %s", new Object[] { paramaf.toString() });
    this.callbacks.add(paramaf);
    AppMethodBeat.o(77623);
  }
  
  public final void b(af paramaf)
  {
    AppMethodBeat.i(77624);
    this.callbacks.remove(paramaf);
    AppMethodBeat.o(77624);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.booter.a
 * JD-Core Version:    0.7.0.1
 */