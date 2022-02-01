package com.tencent.mapsdk.internal;

import android.util.SparseArray;
import com.tencent.map.lib.models.IntersectionOverlayInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class nc
  extends mn<ne>
{
  public nc(sc paramsc)
  {
    super(paramsc);
  }
  
  private nd a(ne paramne)
  {
    AppMethodBeat.i(221387);
    paramne = new nd(this, paramne);
    AppMethodBeat.o(221387);
    return paramne;
  }
  
  private nd b(ne paramne)
  {
    try
    {
      AppMethodBeat.i(221394);
      paramne = (nd)super.b(paramne);
      AppMethodBeat.o(221394);
      return paramne;
    }
    finally
    {
      paramne = finally;
      throw paramne;
    }
  }
  
  protected final int a(long paramLong)
  {
    AppMethodBeat.i(221423);
    if ((this.a == null) || (paramLong == 0L))
    {
      AppMethodBeat.o(221423);
      return 0;
    }
    int i = this.a.a(paramLong);
    AppMethodBeat.o(221423);
    return i;
  }
  
  public final void f()
  {
    AppMethodBeat.i(221403);
    int j = this.c.size();
    int i = 0;
    while (i < j)
    {
      int k = this.c.keyAt(i);
      nd localnd = (nd)this.c.get(k);
      sc localsc = this.a;
      localnd.a(((Long)localsc.a(new sc.73(localsc, (IntersectionOverlayInfo)localnd.a()), Long.valueOf(0L))).longValue());
      i += 1;
    }
    AppMethodBeat.o(221403);
  }
  
  public final void g()
  {
    AppMethodBeat.i(221411);
    int j = this.e.size();
    int i = 0;
    while (i < j)
    {
      int k = this.e.keyAt(i);
      nd localnd = (nd)this.e.get(k);
      sc localsc = this.a;
      localsc.a(new sc.74(localsc, localnd.b(), (IntersectionOverlayInfo)localnd.a()));
      i += 1;
    }
    AppMethodBeat.o(221411);
  }
  
  public final void h()
  {
    AppMethodBeat.i(221417);
    int j = this.g.size();
    int i = 0;
    while (i < j)
    {
      int k = this.g.keyAt(i);
      mm localmm = (mm)this.g.get(k);
      this.a.b(localmm.b());
      i += 1;
    }
    AppMethodBeat.o(221417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.nc
 * JD-Core Version:    0.7.0.1
 */