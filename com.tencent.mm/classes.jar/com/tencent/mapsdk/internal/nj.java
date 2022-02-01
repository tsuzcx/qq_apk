package com.tencent.mapsdk.internal;

import android.util.SparseArray;
import com.tencent.map.lib.models.ScatterPlotInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class nj
  extends mn<nk>
{
  public nj(sc paramsc)
  {
    super(paramsc);
  }
  
  private mm<nk> a(nk paramnk)
  {
    AppMethodBeat.i(221634);
    paramnk = new ni(this, paramnk);
    AppMethodBeat.o(221634);
    return paramnk;
  }
  
  private ni b(nk paramnk)
  {
    try
    {
      AppMethodBeat.i(221639);
      paramnk = (ni)super.b(paramnk);
      AppMethodBeat.o(221639);
      return paramnk;
    }
    finally
    {
      paramnk = finally;
      throw paramnk;
    }
  }
  
  public final void c()
  {
    AppMethodBeat.i(221679);
    int j = this.b.size();
    boolean bool = this.a.m();
    int i = 0;
    while (i < j)
    {
      int k = this.b.keyAt(i);
      bool |= ((nk)((ni)this.b.get(k)).a()).isAnimate();
      i += 1;
    }
    if (bool) {
      this.a.j.v = true;
    }
    AppMethodBeat.o(221679);
  }
  
  public final void e()
  {
    AppMethodBeat.i(221687);
    if (this.a.x()) {
      this.a.j.v = true;
    }
    AppMethodBeat.o(221687);
  }
  
  public final void f()
  {
    AppMethodBeat.i(221650);
    int j = this.c.size();
    int i = 0;
    while (i < j)
    {
      int k = this.c.keyAt(i);
      ni localni = (ni)this.c.get(k);
      sc localsc = this.a;
      localni.a(((Long)localsc.a(new sc.65(localsc, (ScatterPlotInfo)localni.a()), Long.valueOf(0L))).longValue());
      i += 1;
    }
    AppMethodBeat.o(221650);
  }
  
  public final void g()
  {
    AppMethodBeat.i(221658);
    int j = this.e.size();
    int i = 0;
    while (i < j)
    {
      int k = this.e.keyAt(i);
      ni localni = (ni)this.e.get(k);
      sc localsc = this.a;
      localsc.a(new sc.66(localsc, localni.b(), (ScatterPlotInfo)localni.a()));
      i += 1;
    }
    AppMethodBeat.o(221658);
  }
  
  public final void h()
  {
    AppMethodBeat.i(221666);
    int j = this.g.size();
    int i = 0;
    while (i < j)
    {
      int k = this.g.keyAt(i);
      mm localmm = (mm)this.g.get(k);
      this.a.c(localmm.b());
      i += 1;
    }
    AppMethodBeat.o(221666);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.nj
 * JD-Core Version:    0.7.0.1
 */