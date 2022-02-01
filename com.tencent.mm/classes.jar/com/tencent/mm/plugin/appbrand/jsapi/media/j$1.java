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

final class j$1
  implements Runnable
{
  j$1(j paramj, r paramr, String paramString, WeakReference paramWeakReference, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(139871);
    Iterator localIterator = j.Mn().iterator();
    Object localObject1 = null;
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject2 = ((j.b)localIterator.next()).i(this.cjR.getRuntime(), this.val$url);
      localObject1 = localObject2;
      if (localObject2 != null) {
        localObject1 = localObject2;
      }
    }
    if ((this.kYC.get() != null) && (((r)this.kYC.get()).isRunning()))
    {
      if (localObject1 != null)
      {
        switch (j.2.kYE[((j.e)localObject1.get(0)).ordinal()])
        {
        default: 
          localObject1 = this.kYD.e("fail", null);
        }
        for (;;)
        {
          ((r)this.kYC.get()).h(this.cjS, (String)localObject1);
          AppMethodBeat.o(139871);
          return;
          localObject1 = this.kYD.e("fail:file not found", null);
          continue;
          localObject2 = new HashMap(2);
          ((Map)localObject2).put("width", Integer.valueOf(((j.c)((a)localObject1).get(1)).width));
          ((Map)localObject2).put("height", Integer.valueOf(((j.c)((a)localObject1).get(1)).height));
          ((Map)localObject2).put("orientation", ((j.c)((a)localObject1).get(1)).cpm);
          ((Map)localObject2).put("type", ((j.c)((a)localObject1).get(1)).type);
          localObject1 = this.kYD.n("ok", (Map)localObject2);
        }
      }
      ((r)this.kYC.get()).h(this.cjS, this.kYD.e("fail:file not found", null));
    }
    AppMethodBeat.o(139871);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.j.1
 * JD-Core Version:    0.7.0.1
 */