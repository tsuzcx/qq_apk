package androidx.compose.ui.platform;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.m.h;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/platform/ValueElementSequence;", "Lkotlin/sequences/Sequence;", "Landroidx/compose/ui/platform/ValueElement;", "()V", "elements", "", "iterator", "", "set", "", "name", "", "value", "", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class as
  implements h<ar>
{
  public static final int Ue = 8;
  private final List<ar> elements;
  
  public as()
  {
    AppMethodBeat.i(206715);
    this.elements = ((List)new ArrayList());
    AppMethodBeat.o(206715);
  }
  
  public final void i(String paramString, Object paramObject)
  {
    AppMethodBeat.i(206727);
    s.u(paramString, "name");
    this.elements.add(new ar(paramString, paramObject));
    AppMethodBeat.o(206727);
  }
  
  public final Iterator<ar> iterator()
  {
    AppMethodBeat.i(206722);
    Iterator localIterator = this.elements.iterator();
    AppMethodBeat.o(206722);
    return localIterator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.compose.ui.platform.as
 * JD-Core Version:    0.7.0.1
 */