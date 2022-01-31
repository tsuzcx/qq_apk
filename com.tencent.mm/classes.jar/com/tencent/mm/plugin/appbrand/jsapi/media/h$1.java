package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.vending.j.a;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

final class h$1
  implements Runnable
{
  h$1(h paramh, r paramr, String paramString, WeakReference paramWeakReference, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(114357);
    Iterator localIterator = h.Br().iterator();
    Object localObject1 = null;
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject2 = ((h.b)localIterator.next()).h(this.bAW.getRuntime(), this.val$url);
      localObject1 = localObject2;
      if (localObject2 != null) {
        localObject1 = localObject2;
      }
    }
    if ((this.hSa.get() != null) && (((r)this.hSa.get()).isRunning()))
    {
      if (localObject1 != null)
      {
        switch (h.2.hSc[((h.e)localObject1.get(0)).ordinal()])
        {
        default: 
          localObject1 = this.hSb.j("fail", null);
        }
        for (;;)
        {
          ((r)this.hSa.get()).h(this.bAX, (String)localObject1);
          AppMethodBeat.o(114357);
          return;
          localObject1 = this.hSb.j("fail:file not found", null);
          continue;
          localObject2 = new HashMap(2);
          ((Map)localObject2).put("width", Integer.valueOf(((h.c)((a)localObject1).get(1)).width));
          ((Map)localObject2).put("height", Integer.valueOf(((h.c)((a)localObject1).get(1)).height));
          ((Map)localObject2).put("orientation", ((h.c)((a)localObject1).get(1)).hha);
          ((Map)localObject2).put("type", ((h.c)((a)localObject1).get(1)).type);
          localObject1 = this.hSb.j("ok", (Map)localObject2);
        }
      }
      ((r)this.hSa.get()).h(this.bAX, this.hSb.j("fail:file not found", null));
    }
    AppMethodBeat.o(114357);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.h.1
 * JD-Core Version:    0.7.0.1
 */