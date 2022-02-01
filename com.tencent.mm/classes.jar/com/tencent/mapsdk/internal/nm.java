package com.tencent.mapsdk.internal;

import android.util.SparseArray;
import com.tencent.map.lib.models.TrailOverlayInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class nm
  extends mn<nn>
{
  public nm(sc paramsc)
  {
    super(paramsc);
  }
  
  private mm<nn> a(nn paramnn)
  {
    AppMethodBeat.i(221615);
    paramnn = new nl(this, paramnn);
    AppMethodBeat.o(221615);
    return paramnn;
  }
  
  private nl b(nn paramnn)
  {
    try
    {
      AppMethodBeat.i(221620);
      paramnn = (nl)super.b(paramnn);
      AppMethodBeat.o(221620);
      return paramnn;
    }
    finally
    {
      paramnn = finally;
      throw paramnn;
    }
  }
  
  public final void c()
  {
    AppMethodBeat.i(221657);
    int j = this.b.size();
    boolean bool = this.a.m();
    int i = 0;
    while (i < j)
    {
      int k = this.b.keyAt(i);
      bool |= ((nn)((nl)this.b.get(k)).a()).getIsAnimate();
      i += 1;
    }
    if (bool) {
      this.a.j.v = true;
    }
    AppMethodBeat.o(221657);
  }
  
  public final void e()
  {
    AppMethodBeat.i(221667);
    if (this.a.x()) {
      this.a.j.v = true;
    }
    AppMethodBeat.o(221667);
  }
  
  public final void f()
  {
    AppMethodBeat.i(221630);
    int j = this.c.size();
    int i = 0;
    while (i < j)
    {
      int k = this.c.keyAt(i);
      nl localnl = (nl)this.c.get(k);
      sc localsc = this.a;
      localnl.a(((Long)localsc.a(new sc.67(localsc, (TrailOverlayInfo)localnl.a()), Long.valueOf(0L))).longValue());
      i += 1;
    }
    AppMethodBeat.o(221630);
  }
  
  public final void g()
  {
    AppMethodBeat.i(221641);
    int j = this.e.size();
    int i = 0;
    while (i < j)
    {
      int k = this.e.keyAt(i);
      nl localnl = (nl)this.e.get(k);
      sc localsc = this.a;
      localsc.a(new sc.69(localsc, localnl.b(), (TrailOverlayInfo)localnl.a()));
      i += 1;
    }
    AppMethodBeat.o(221641);
  }
  
  public final void h()
  {
    AppMethodBeat.i(221646);
    int j = this.g.size();
    int i = 0;
    while (i < j)
    {
      int k = this.g.keyAt(i);
      mm localmm = (mm)this.g.get(k);
      this.a.c(localmm.b());
      i += 1;
    }
    AppMethodBeat.o(221646);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.nm
 * JD-Core Version:    0.7.0.1
 */