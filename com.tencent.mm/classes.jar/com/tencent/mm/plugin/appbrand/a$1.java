package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.t.g;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;

final class a$1
  extends g
{
  public final void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(154308);
    ab.i("MicroMsg.AppBrandBridge", "onTrimMemory level=%d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(154308);
      return;
    }
    synchronized (a.access$000())
    {
      Iterator localIterator = new LinkedList(a.asV().values()).iterator();
      while (localIterator.hasNext())
      {
        o localo = (o)localIterator.next();
        if (!localo.mResumed)
        {
          a.asV().remove(localo.mAppId);
          localo.atC();
        }
      }
    }
    AppMethodBeat.o(154308);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.a.1
 * JD-Core Version:    0.7.0.1
 */