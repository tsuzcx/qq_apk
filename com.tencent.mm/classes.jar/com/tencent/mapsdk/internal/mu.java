package com.tencent.mapsdk.internal;

import android.util.SparseArray;
import com.tencent.map.lib.models.ArcLineOverlayInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class mu
  extends mn<mv>
{
  public mu(sc paramsc)
  {
    super(paramsc);
  }
  
  private mm<mv> a(mv parammv)
  {
    AppMethodBeat.i(221544);
    parammv = new mt(this, parammv);
    AppMethodBeat.o(221544);
    return parammv;
  }
  
  private mt b(mv parammv)
  {
    try
    {
      AppMethodBeat.i(221552);
      parammv = (mt)super.b(parammv);
      AppMethodBeat.o(221552);
      return parammv;
    }
    finally
    {
      parammv = finally;
      throw parammv;
    }
  }
  
  public final void c()
  {
    AppMethodBeat.i(221594);
    int j = this.b.size();
    boolean bool = this.a.m();
    int i = 0;
    while (i < j)
    {
      int k = this.b.keyAt(i);
      bool |= ((mv)((mt)this.b.get(k)).a()).getIsAnimate();
      i += 1;
    }
    if (bool) {
      this.a.j.v = true;
    }
    AppMethodBeat.o(221594);
  }
  
  public final void e()
  {
    AppMethodBeat.i(221609);
    if (this.a.x()) {
      this.a.j.v = true;
    }
    AppMethodBeat.o(221609);
  }
  
  public final void f()
  {
    AppMethodBeat.i(221561);
    int j = this.c.size();
    int i = 0;
    while (i < j)
    {
      int k = this.c.keyAt(i);
      mt localmt = (mt)this.c.get(k);
      sc localsc = this.a;
      localmt.a(((Long)localsc.a(new sc.63(localsc, (ArcLineOverlayInfo)localmt.a()), Long.valueOf(0L))).longValue());
      i += 1;
    }
    AppMethodBeat.o(221561);
  }
  
  public final void g()
  {
    AppMethodBeat.i(221583);
    int j = this.e.size();
    int i = 0;
    while (i < j)
    {
      int k = this.e.keyAt(i);
      mt localmt = (mt)this.e.get(k);
      sc localsc = this.a;
      localsc.a(new sc.64(localsc, localmt.b(), (ArcLineOverlayInfo)localmt.a()));
      i += 1;
    }
    AppMethodBeat.o(221583);
  }
  
  public final void h()
  {
    AppMethodBeat.i(221571);
    int j = this.g.size();
    int i = 0;
    while (i < j)
    {
      int k = this.g.keyAt(i);
      mm localmm = (mm)this.g.get(k);
      this.a.c(localmm.b());
      i += 1;
    }
    AppMethodBeat.o(221571);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.mu
 * JD-Core Version:    0.7.0.1
 */