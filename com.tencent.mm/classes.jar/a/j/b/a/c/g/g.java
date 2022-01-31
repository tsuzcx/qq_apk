package a.j.b.a.c.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class g
{
  private static volatile boolean Crn;
  private static final g Crp;
  final Map<g.a, i.f<?, ?>> Cro;
  
  static
  {
    AppMethodBeat.i(121496);
    Crn = false;
    Crp = new g((byte)0);
    AppMethodBeat.o(121496);
  }
  
  g()
  {
    AppMethodBeat.i(121494);
    this.Cro = new HashMap();
    AppMethodBeat.o(121494);
  }
  
  private g(byte paramByte)
  {
    AppMethodBeat.i(121495);
    this.Cro = Collections.emptyMap();
    AppMethodBeat.o(121495);
  }
  
  public static g emB()
  {
    AppMethodBeat.i(121492);
    g localg = new g();
    AppMethodBeat.o(121492);
    return localg;
  }
  
  public static g emC()
  {
    return Crp;
  }
  
  public final void a(i.f<?, ?> paramf)
  {
    AppMethodBeat.i(121493);
    this.Cro.put(new g.a(paramf.CrG, paramf.CrI.number), paramf);
    AppMethodBeat.o(121493);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.c.g.g
 * JD-Core Version:    0.7.0.1
 */