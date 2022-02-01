package com.tencent.mm.plugin.appbrand.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class a$3
  implements Runnable
{
  a$3(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(144156);
    synchronized (this.sTb)
    {
      ArrayList localArrayList = new ArrayList(a.e(this.sTb));
      localArrayList.addAll(a.f(this.sTb));
      a.e(this.sTb).clear();
      a.f(this.sTb).clear();
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
    synchronized (this.sTb)
    {
      if ((a.e(this.sTb).size() != 0) || (a.f(this.sTb).size() != 0))
      {
        IllegalStateException localIllegalStateException = new IllegalStateException("OnDestroyListener execute failed. Add Destroy listener recursively is forbidden.");
        AppMethodBeat.o(144156);
        throw localIllegalStateException;
      }
    }
    AppMethodBeat.o(144156);
    return;
    AppMethodBeat.o(144156);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n.a.3
 * JD-Core Version:    0.7.0.1
 */