package androidx.transition;

import android.view.View;
import android.view.WindowId;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ap
  implements aq
{
  private final WindowId cim;
  
  ap(View paramView)
  {
    AppMethodBeat.i(201496);
    this.cim = paramView.getWindowId();
    AppMethodBeat.o(201496);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(201505);
    if (((paramObject instanceof ap)) && (((ap)paramObject).cim.equals(this.cim)))
    {
      AppMethodBeat.o(201505);
      return true;
    }
    AppMethodBeat.o(201505);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(201513);
    int i = this.cim.hashCode();
    AppMethodBeat.o(201513);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.transition.ap
 * JD-Core Version:    0.7.0.1
 */