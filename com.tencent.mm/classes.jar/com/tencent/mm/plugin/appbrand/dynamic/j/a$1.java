package com.tencent.mm.plugin.appbrand.dynamic.j;

import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.plugin.appbrand.dynamic.i;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Collection;
import java.util.Iterator;

public final class a$1
  implements Runnable
{
  public final void run()
  {
    Iterator localIterator = i.aeX().aeY().iterator();
    for (;;)
    {
      String str;
      if (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        if (!b.BT().fC(str)) {
          y.i("MicroMsg.DynamicPkgUpdater", "has not Connected RemoteService, abort clearCache");
        }
      }
      else
      {
        return;
      }
      f.a(str, null, a.b.class, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.j.a.1
 * JD-Core Version:    0.7.0.1
 */