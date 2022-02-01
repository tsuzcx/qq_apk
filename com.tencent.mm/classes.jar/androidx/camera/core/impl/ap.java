package androidx.camera.core.impl;

import androidx.camera.core.m;
import androidx.camera.core.n;
import androidx.core.f.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ap
  implements m
{
  public int MO;
  
  public ap(int paramInt)
  {
    this.MO = paramInt;
  }
  
  public final List<n> F(List<n> paramList)
  {
    AppMethodBeat.i(198632);
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      n localn = (n)paramList.next();
      f.checkArgument(localn instanceof s, "The camera info doesn't contain internal implementation.");
      Integer localInteger = ((s)localn).gW();
      if ((localInteger != null) && (localInteger.intValue() == this.MO)) {
        localArrayList.add(localn);
      }
    }
    AppMethodBeat.o(198632);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.impl.ap
 * JD-Core Version:    0.7.0.1
 */