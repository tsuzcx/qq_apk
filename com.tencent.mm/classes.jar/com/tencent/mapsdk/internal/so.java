package com.tencent.mapsdk.internal;

import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;

public final class so
  implements fd
{
  private final sj a;
  
  public so(sj paramsj)
  {
    this.a = paramsj;
  }
  
  public final void b(int paramInt)
  {
    AppMethodBeat.i(223990);
    if ((this.a == null) || (paramInt != fv.c))
    {
      AppMethodBeat.o(223990);
      return;
    }
    Object localObject = this.a;
    paramInt = ((VectorMap)((bn)localObject).e_).r();
    ((sj)localObject).ab = true;
    ((sj)localObject).ac = true;
    if (paramInt <= ((sj)localObject).aa) {
      ((sj)localObject).ac = false;
    }
    fr localfr;
    while (!((sj)localObject).q.isEmpty())
    {
      localfr = new fr();
      localfr.f = 0;
      localfr.g = ((sj)localObject).ab;
      localfr.h = ((sj)localObject).ac;
      localObject = ((sj)localObject).q.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((ey)((Iterator)localObject).next()).a(localfr);
      }
      if (paramInt >= ((sj)localObject).Z) {
        ((sj)localObject).ab = false;
      }
    }
    localObject = this.a;
    if (!((sj)localObject).q.isEmpty())
    {
      localfr = new fr();
      localfr.f = 0;
      localfr.g = ((sj)localObject).ab;
      localfr.h = ((sj)localObject).ac;
      localObject = ((sj)localObject).q.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((ey)((Iterator)localObject).next()).a(localfr);
      }
    }
    AppMethodBeat.o(223990);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.so
 * JD-Core Version:    0.7.0.1
 */