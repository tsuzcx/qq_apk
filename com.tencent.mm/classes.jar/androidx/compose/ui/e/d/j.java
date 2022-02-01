package androidx.compose.ui.e.d;

import androidx.compose.runtime.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/vector/VectorApplier;", "Landroidx/compose/runtime/AbstractApplier;", "Landroidx/compose/ui/graphics/vector/VNode;", "root", "(Landroidx/compose/ui/graphics/vector/VNode;)V", "insertBottomUp", "", "index", "", "instance", "insertTopDown", "move", "from", "to", "count", "onClear", "remove", "asGroup", "Landroidx/compose/ui/graphics/vector/GroupComponent;", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends a<i>
{
  public j(i parami)
  {
    super(parami);
    AppMethodBeat.i(206404);
    AppMethodBeat.o(206404);
  }
  
  private static c a(i parami)
  {
    AppMethodBeat.i(206411);
    if ((parami instanceof c))
    {
      parami = (c)parami;
      AppMethodBeat.o(206411);
      return parami;
    }
    parami = (Throwable)new IllegalStateException("Cannot only insert VNode into Group".toString());
    AppMethodBeat.o(206411);
    throw parami;
  }
  
  public final void G(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(206417);
    a((i)nN()).G(paramInt1, paramInt2);
    AppMethodBeat.o(206417);
  }
  
  public final void d(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 0;
    int j = 0;
    AppMethodBeat.i(206432);
    c localc = a((i)nN());
    i locali;
    if (paramInt1 > paramInt2)
    {
      i = paramInt2;
      paramInt2 = j;
      while (paramInt2 < paramInt3)
      {
        locali = (i)localc.aAO.get(paramInt1);
        localc.aAO.remove(paramInt1);
        localc.aAO.add(i, locali);
        i += 1;
        paramInt2 += 1;
      }
    }
    while (i < paramInt3)
    {
      locali = (i)localc.aAO.get(paramInt1);
      localc.aAO.remove(paramInt1);
      localc.aAO.add(paramInt2 - 1, locali);
      i += 1;
    }
    localc.invalidate();
    AppMethodBeat.o(206432);
  }
  
  public final void nP()
  {
    AppMethodBeat.i(206426);
    c localc = a((i)nM());
    localc.G(0, localc.uQ());
    AppMethodBeat.o(206426);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.d.j
 * JD-Core Version:    0.7.0.1
 */