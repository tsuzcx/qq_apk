package com.tencent.mm.plugin.appbrand.dynamic.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.plugin.appbrand.dynamic.i;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Collection;
import java.util.Iterator;

public final class a$1
  implements Runnable
{
  public final void run()
  {
    AppMethodBeat.i(10980);
    Iterator localIterator = i.azB().azC().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!b.PK().lX(str))
      {
        ab.i("MicroMsg.DynamicPkgUpdater", "has not Connected RemoteService, abort clearCache");
        AppMethodBeat.o(10980);
        return;
      }
      f.a(str, null, a.b.class, null);
    }
    AppMethodBeat.o(10980);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.j.a.1
 * JD-Core Version:    0.7.0.1
 */