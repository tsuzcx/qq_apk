package androidx.transition;

import android.view.View;
import android.view.WindowId;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ap
  implements aq
{
  private final WindowId atD;
  
  ap(View paramView)
  {
    AppMethodBeat.i(193420);
    this.atD = paramView.getWindowId();
    AppMethodBeat.o(193420);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(193423);
    if (((paramObject instanceof ap)) && (((ap)paramObject).atD.equals(this.atD)))
    {
      AppMethodBeat.o(193423);
      return true;
    }
    AppMethodBeat.o(193423);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(193427);
    int i = this.atD.hashCode();
    AppMethodBeat.o(193427);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.transition.ap
 * JD-Core Version:    0.7.0.1
 */