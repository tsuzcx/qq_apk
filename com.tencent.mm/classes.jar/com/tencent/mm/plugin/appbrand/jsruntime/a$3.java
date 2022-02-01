package com.tencent.mm.plugin.appbrand.jsruntime;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.j;
import java.util.ArrayList;

final class a$3
  implements Runnable
{
  a$3(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(144156);
    synchronized (this.lFY)
    {
      ArrayList localArrayList = new ArrayList(a.e(this.lFY));
      a.e(this.lFY).clear();
      int i = 0;
      if (i < localArrayList.size())
      {
        ??? = (m.a)localArrayList.get(i);
        if (??? != null) {
          ((m.a)???).onDestroy();
        }
        i += 1;
      }
    }
    if (j.IS_FLAVOR_RED)
    {
      synchronized (this.lFY)
      {
        if (a.e(this.lFY).size() != 0)
        {
          IllegalStateException localIllegalStateException = new IllegalStateException("OnDestroyListener execute failed. Add Destroy listener recursively is forbidden.");
          AppMethodBeat.o(144156);
          throw localIllegalStateException;
        }
      }
      AppMethodBeat.o(144156);
      return;
    }
    AppMethodBeat.o(144156);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsruntime.a.3
 * JD-Core Version:    0.7.0.1
 */