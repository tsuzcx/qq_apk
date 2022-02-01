package com.tencent.mapsdk.internal;

import android.util.SparseArray;
import com.tencent.map.lib.models.HeatmapInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class na
  extends mn<nb>
{
  public na(sc paramsc)
  {
    super(paramsc);
  }
  
  private mm<nb> a(nb paramnb)
  {
    AppMethodBeat.i(221422);
    paramnb = new mz(this, paramnb);
    AppMethodBeat.o(221422);
    return paramnb;
  }
  
  private mz b(nb paramnb)
  {
    try
    {
      AppMethodBeat.i(221426);
      paramnb = (mz)super.b(paramnb);
      AppMethodBeat.o(221426);
      return paramnb;
    }
    finally
    {
      paramnb = finally;
      throw paramnb;
    }
  }
  
  public final void c()
  {
    AppMethodBeat.i(221456);
    int j = this.b.size();
    boolean bool = this.a.m();
    int i = 0;
    while (i < j)
    {
      int k = this.b.keyAt(i);
      bool |= ((nb)((mz)this.b.get(k)).a()).isAnimate();
      i += 1;
    }
    if (bool) {
      this.a.j.v = true;
    }
    AppMethodBeat.o(221456);
  }
  
  public final void e()
  {
    AppMethodBeat.i(221460);
    if (this.a.x()) {
      this.a.j.v = true;
    }
    AppMethodBeat.o(221460);
  }
  
  public final void f()
  {
    AppMethodBeat.i(221435);
    int j = this.c.size();
    int i = 0;
    while (i < j)
    {
      int k = this.c.keyAt(i);
      mz localmz = (mz)this.c.get(k);
      sc localsc = this.a;
      localmz.a(((Long)localsc.a(new sc.59(localsc, (HeatmapInfo)localmz.a()), Long.valueOf(0L))).longValue());
      i += 1;
    }
    AppMethodBeat.o(221435);
  }
  
  public final void g()
  {
    AppMethodBeat.i(221447);
    int j = this.e.size();
    int i = 0;
    while (i < j)
    {
      int k = this.e.keyAt(i);
      mz localmz = (mz)this.e.get(k);
      sc localsc = this.a;
      localsc.a(new sc.60(localsc, localmz.b(), (HeatmapInfo)localmz.a()));
      i += 1;
    }
    AppMethodBeat.o(221447);
  }
  
  public final void h()
  {
    AppMethodBeat.i(221443);
    int j = this.g.size();
    int i = 0;
    while (i < j)
    {
      int k = this.g.keyAt(i);
      mm localmm = (mm)this.g.get(k);
      this.a.c(localmm.b());
      i += 1;
    }
    AppMethodBeat.o(221443);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.na
 * JD-Core Version:    0.7.0.1
 */