package com.tencent.mm.plugin.appbrand.b;

import android.support.v4.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i;
import java.util.Set;

final class c$1
  extends d
{
  c$1(c paramc, i parami)
  {
    super(parami);
  }
  
  final void a(b paramb)
  {
    AppMethodBeat.i(86832);
    c localc = this.gYl;
    synchronized (localc.gYk)
    {
      c.a[] arrayOfa = new c.a[localc.gYk.size()];
      arrayOfa = (c.a[])localc.gYk.keySet().toArray(arrayOfa);
      int j = arrayOfa.length;
      int i = 0;
      if (i < j)
      {
        arrayOfa[i].a(localc.gRG.mAppId, paramb);
        i += 1;
      }
    }
    AppMethodBeat.o(86832);
  }
  
  final void awq()
  {
    AppMethodBeat.i(86831);
    c localc = this.gYl;
    if (!localc.gRG.mFinished) {
      localc.gRG.finish();
    }
    AppMethodBeat.o(86831);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.b.c.1
 * JD-Core Version:    0.7.0.1
 */