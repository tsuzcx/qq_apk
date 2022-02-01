package androidx.transition;

import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ao
  implements aq
{
  private final IBinder cT;
  
  ao(IBinder paramIBinder)
  {
    this.cT = paramIBinder;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(201531);
    if (((paramObject instanceof ao)) && (((ao)paramObject).cT.equals(this.cT)))
    {
      AppMethodBeat.o(201531);
      return true;
    }
    AppMethodBeat.o(201531);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(201538);
    int i = this.cT.hashCode();
    AppMethodBeat.o(201538);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.transition.ao
 * JD-Core Version:    0.7.0.1
 */