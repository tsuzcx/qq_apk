package androidx.compose.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/material/ripple/RippleHostMap;", "", "()V", "hostToIndicationMap", "", "Landroidx/compose/material/ripple/RippleHostView;", "Landroidx/compose/material/ripple/AndroidRippleIndicationInstance;", "indicationToHostMap", "get", "indicationInstance", "rippleHostView", "remove", "", "set", "material-ripple_release"}, k=1, mv={1, 5, 1}, xi=48)
final class j
{
  final Map<a, k> akF;
  final Map<k, a> akG;
  
  public j()
  {
    AppMethodBeat.i(201799);
    this.akF = ((Map)new LinkedHashMap());
    this.akG = ((Map)new LinkedHashMap());
    AppMethodBeat.o(201799);
  }
  
  public final k b(a parama)
  {
    AppMethodBeat.i(201808);
    s.u(parama, "indicationInstance");
    parama = (k)this.akF.get(parama);
    AppMethodBeat.o(201808);
    return parama;
  }
  
  public final void c(a parama)
  {
    AppMethodBeat.i(201815);
    s.u(parama, "indicationInstance");
    k localk = (k)this.akF.get(parama);
    if (localk != null) {
      this.akG.remove(localk);
    }
    this.akF.remove(parama);
    AppMethodBeat.o(201815);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.b.a.j
 * JD-Core Version:    0.7.0.1
 */