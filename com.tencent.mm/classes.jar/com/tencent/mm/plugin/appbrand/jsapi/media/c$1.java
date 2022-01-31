package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.vending.j.a;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

final class c$1
  implements Runnable
{
  c$1(c paramc, o paramo, String paramString, WeakReference paramWeakReference, int paramInt) {}
  
  public final void run()
  {
    Iterator localIterator = c.ajx().iterator();
    Object localObject1 = null;
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject2 = ((c.b)localIterator.next()).h(this.gcp.getRuntime(), this.val$url);
      localObject1 = localObject2;
      if (localObject2 != null) {
        localObject1 = localObject2;
      }
    }
    if ((this.gwf.get() != null) && (((o)this.gwf.get()).isRunning()))
    {
      if (localObject1 == null) {
        break label273;
      }
      switch (c.2.gwh[((c.e)localObject1.get(0)).ordinal()])
      {
      default: 
        localObject1 = this.gwg.h("fail", null);
      }
    }
    for (;;)
    {
      ((o)this.gwf.get()).C(this.dIS, (String)localObject1);
      return;
      localObject1 = this.gwg.h("fail:file not found", null);
      continue;
      localObject2 = new HashMap(2);
      ((Map)localObject2).put("width", Integer.valueOf(((c.c)((a)localObject1).get(1)).width));
      ((Map)localObject2).put("height", Integer.valueOf(((c.c)((a)localObject1).get(1)).height));
      ((Map)localObject2).put("orientation", ((c.c)((a)localObject1).get(1)).fNK);
      ((Map)localObject2).put("type", ((c.c)((a)localObject1).get(1)).type);
      localObject1 = this.gwg.h("ok", (Map)localObject2);
    }
    label273:
    ((o)this.gwf.get()).C(this.dIS, this.gwg.h("fail:file not found", null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.c.1
 * JD-Core Version:    0.7.0.1
 */