package com.tencent.mm.plugin.appbrand.jsapi.p;

import a.f.b.j;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.permission.e;
import com.tencent.mm.plugin.appbrand.report.model.i;
import com.tencent.mm.sdk.platformtools.bo;

public final class a
  extends b
{
  public final SparseArray<c> hXR;
  
  public a()
  {
    AppMethodBeat.i(131429);
    this.hXR = new SparseArray();
    AppMethodBeat.o(131429);
  }
  
  public final void X(int paramInt, String paramString)
  {
    Object localObject1 = null;
    AppMethodBeat.i(131430);
    for (;;)
    {
      synchronized (this.hXR)
      {
        c localc = (c)this.hXR.get(paramInt, null);
        if (localc == null)
        {
          AppMethodBeat.o(131430);
          return;
        }
        this.hXR.remove(paramInt);
        j.q(localc, "info");
        ??? = localc.hXS;
        j.p(???, "info.component");
        ??? = ((h)???).getRuntime();
        if ((??? instanceof o)) {
          break label213;
        }
        localObject1 = (o)localObject1;
        if (localObject1 != null)
        {
          localObject1 = ((o)localObject1).wO();
          if (localObject1 != null)
          {
            paramInt = ((e)localObject1).a((com.tencent.mm.plugin.appbrand.jsapi.c)localc.hXS, localc.hXT, localc.data, false);
            long l1 = bo.yB();
            long l2 = localc.startTime;
            i.a(localc.hXS.getAppId(), localc.path, localc.hXT.getName(), localc.data, paramInt, l1 - l2, paramString);
            AppMethodBeat.o(131430);
            return;
          }
        }
      }
      paramInt = -1;
      continue;
      label213:
      localObject1 = ???;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.a
 * JD-Core Version:    0.7.0.1
 */