package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.widget.input.d.e;
import com.tencent.mm.plugin.appbrand.widget.input.i;
import com.tencent.mm.plugin.appbrand.widget.input.l;
import java.lang.ref.WeakReference;

final class h$5
  implements Runnable
{
  h$5(h paramh, WeakReference paramWeakReference, i parami, e parame, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(123549);
    Object localObject1 = (v)this.hMF.get();
    if ((localObject1 == null) || (((v)localObject1).iuy == null))
    {
      AppMethodBeat.o(123549);
      return;
    }
    localObject1 = this.hMD;
    Object localObject2 = this.hMO;
    int i = this.hMP;
    int j = this.hMQ;
    ((i)localObject1).jli = ((e)localObject2);
    localObject2 = (v)((e)localObject2).jkD.get();
    if (localObject2 != null) {
      new l((v)localObject2);
    }
    ((i)localObject1).dx(i, j);
    AppMethodBeat.o(123549);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.d.h.5
 * JD-Core Version:    0.7.0.1
 */