package com.github.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.plugins.a.b;
import io.flutter.plugin.a.d;
import io.flutter.plugin.a.k;

public final class b
  implements io.flutter.embedding.engine.plugins.a, io.flutter.embedding.engine.plugins.a.a
{
  private a.b aLa;
  private a aLb;
  
  public final void a(a.b paramb)
  {
    this.aLa = paramb;
  }
  
  public final void a(io.flutter.embedding.engine.plugins.a.c paramc)
  {
    AppMethodBeat.i(215362);
    this.aLb = new a();
    a locala = this.aLb;
    paramc = paramc.getActivity();
    io.flutter.plugin.a.c localc = this.aLa.aaqF;
    locala.activity = paramc;
    locala.aKT = new k(localc, "sososdk.github.com/orientation");
    locala.aKT.a(locala);
    locala.aKU = new d(localc, "sososdk.github.com/orientationEvent");
    locala.aKU.a(new a.1(locala, paramc));
    AppMethodBeat.o(215362);
  }
  
  public final void b(a.b paramb)
  {
    this.aLa = null;
  }
  
  public final void b(io.flutter.embedding.engine.plugins.a.c paramc)
  {
    AppMethodBeat.i(215366);
    a(paramc);
    AppMethodBeat.o(215366);
  }
  
  public final void qI()
  {
    AppMethodBeat.i(215364);
    if (this.aLb == null)
    {
      AppMethodBeat.o(215364);
      return;
    }
    a locala = this.aLb;
    if (locala.aKT != null)
    {
      locala.aKT.a(null);
      locala.aKT = null;
    }
    if (locala.aKU != null)
    {
      locala.aKU.a(null);
      locala.aKU = null;
    }
    AppMethodBeat.o(215364);
  }
  
  public final void qJ()
  {
    AppMethodBeat.i(215367);
    qI();
    AppMethodBeat.o(215367);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.github.a.a.b
 * JD-Core Version:    0.7.0.1
 */