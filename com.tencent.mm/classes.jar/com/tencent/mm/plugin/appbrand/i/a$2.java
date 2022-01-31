package com.tencent.mm.plugin.appbrand.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.f;
import java.util.ArrayList;

final class a$2
  implements Runnable
{
  a$2(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(113930);
    synchronized (this.ijg)
    {
      ArrayList localArrayList = new ArrayList(a.b(this.ijg));
      a.b(this.ijg).clear();
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
    if (f.IS_FLAVOR_RED)
    {
      synchronized (this.ijg)
      {
        if (a.b(this.ijg).size() != 0)
        {
          IllegalStateException localIllegalStateException = new IllegalStateException("OnDestroyListener execute failed. Add Destroy listener recursively is forbidden.");
          AppMethodBeat.o(113930);
          throw localIllegalStateException;
        }
      }
      AppMethodBeat.o(113930);
      return;
    }
    AppMethodBeat.o(113930);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.i.a.2
 * JD-Core Version:    0.7.0.1
 */