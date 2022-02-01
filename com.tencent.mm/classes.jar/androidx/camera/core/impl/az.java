package androidx.camera.core.impl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class az
{
  private final List<ay> MZ;
  
  public az(List<ay> paramList)
  {
    AppMethodBeat.i(198884);
    this.MZ = new ArrayList(paramList);
    AppMethodBeat.o(198884);
  }
  
  public final <T extends ay> T f(Class<T> paramClass)
  {
    AppMethodBeat.i(198894);
    Iterator localIterator = this.MZ.iterator();
    while (localIterator.hasNext())
    {
      ay localay = (ay)localIterator.next();
      if (localay.getClass() == paramClass)
      {
        AppMethodBeat.o(198894);
        return localay;
      }
    }
    AppMethodBeat.o(198894);
    return null;
  }
  
  public final boolean g(Class<? extends ay> paramClass)
  {
    AppMethodBeat.i(198903);
    Iterator localIterator = this.MZ.iterator();
    while (localIterator.hasNext()) {
      if (paramClass.isAssignableFrom(((ay)localIterator.next()).getClass()))
      {
        AppMethodBeat.o(198903);
        return true;
      }
    }
    AppMethodBeat.o(198903);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.camera.core.impl.az
 * JD-Core Version:    0.7.0.1
 */