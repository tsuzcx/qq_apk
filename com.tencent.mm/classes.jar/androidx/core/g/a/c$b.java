package androidx.core.g.a;

import android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c$b
  implements AccessibilityManager.TouchExplorationStateChangeListener
{
  final c.a Ou;
  
  public c$b(c.a parama)
  {
    this.Ou = parama;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(252027);
    if (this == paramObject)
    {
      AppMethodBeat.o(252027);
      return true;
    }
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(252027);
      return false;
    }
    paramObject = (b)paramObject;
    boolean bool = this.Ou.equals(paramObject.Ou);
    AppMethodBeat.o(252027);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(252024);
    int i = this.Ou.hashCode();
    AppMethodBeat.o(252024);
    return i;
  }
  
  public final void onTouchExplorationStateChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(252028);
    this.Ou.onTouchExplorationStateChanged(paramBoolean);
    AppMethodBeat.o(252028);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.core.g.a.c.b
 * JD-Core Version:    0.7.0.1
 */