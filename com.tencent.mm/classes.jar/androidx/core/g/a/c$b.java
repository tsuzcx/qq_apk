package androidx.core.g.a;

import android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$b
  implements AccessibilityManager.TouchExplorationStateChangeListener
{
  final c.a buN;
  
  c$b(c.a parama)
  {
    this.buN = parama;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(195949);
    if (this == paramObject)
    {
      AppMethodBeat.o(195949);
      return true;
    }
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(195949);
      return false;
    }
    paramObject = (b)paramObject;
    boolean bool = this.buN.equals(paramObject.buN);
    AppMethodBeat.o(195949);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(195943);
    int i = this.buN.hashCode();
    AppMethodBeat.o(195943);
    return i;
  }
  
  public final void onTouchExplorationStateChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(195952);
    this.buN.onTouchExplorationStateChanged(paramBoolean);
    AppMethodBeat.o(195952);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     androidx.core.g.a.c.b
 * JD-Core Version:    0.7.0.1
 */