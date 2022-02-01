package com.github.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.plugins.a.b;
import io.flutter.plugin.a.d;
import io.flutter.plugin.a.k;

public final class b
  implements io.flutter.embedding.engine.plugins.a, io.flutter.embedding.engine.plugins.a.a
{
  private a.b bbC;
  private a bbD;
  
  public final void a(a.b paramb)
  {
    this.bbC = paramb;
  }
  
  public final void a(io.flutter.embedding.engine.plugins.a.c paramc)
  {
    AppMethodBeat.i(199078);
    this.bbD = new a();
    a locala = this.bbD;
    paramc = paramc.getActivity();
    io.flutter.plugin.a.c localc = this.bbC.SOH;
    locala.activity = paramc;
    locala.bbv = new k(localc, "sososdk.github.com/orientation");
    locala.bbv.a(locala);
    locala.bbw = new d(localc, "sososdk.github.com/orientationEvent");
    locala.bbw.a(new a.1(locala, paramc));
    AppMethodBeat.o(199078);
  }
  
  public final void b(a.b paramb)
  {
    this.bbC = null;
  }
  
  public final void b(io.flutter.embedding.engine.plugins.a.c paramc)
  {
    AppMethodBeat.i(199080);
    a(paramc);
    AppMethodBeat.o(199080);
  }
  
  public final void sU()
  {
    AppMethodBeat.i(199079);
    if (this.bbD == null)
    {
      AppMethodBeat.o(199079);
      return;
    }
    a locala = this.bbD;
    if (locala.bbv != null)
    {
      locala.bbv.a(null);
      locala.bbv = null;
    }
    if (locala.bbw != null)
    {
      locala.bbw.a(null);
      locala.bbw = null;
    }
    AppMethodBeat.o(199079);
  }
  
  public final void sV()
  {
    AppMethodBeat.i(199081);
    sU();
    AppMethodBeat.o(199081);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.github.a.a.b
 * JD-Core Version:    0.7.0.1
 */