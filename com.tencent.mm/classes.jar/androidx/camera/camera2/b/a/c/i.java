package androidx.camera.camera2.b.a.c;

import android.util.Size;
import androidx.camera.camera2.b.a.b.h;
import androidx.camera.camera2.b.a.b.p;
import androidx.camera.core.impl.bg.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class i
{
  private final p FU;
  
  public i()
  {
    this((p)h.f(p.class));
    AppMethodBeat.i(198209);
    AppMethodBeat.o(198209);
  }
  
  private i(p paramp)
  {
    this.FU = paramp;
  }
  
  public final List<Size> a(bg.b paramb, List<Size> paramList)
  {
    AppMethodBeat.i(198217);
    if (this.FU == null)
    {
      AppMethodBeat.o(198217);
      return paramList;
    }
    paramb = p.a(paramb);
    if (paramb == null)
    {
      AppMethodBeat.o(198217);
      return paramList;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramb);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Size localSize = (Size)paramList.next();
      if (!localSize.equals(paramb)) {
        localArrayList.add(localSize);
      }
    }
    AppMethodBeat.o(198217);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.camera.camera2.b.a.c.i
 * JD-Core Version:    0.7.0.1
 */