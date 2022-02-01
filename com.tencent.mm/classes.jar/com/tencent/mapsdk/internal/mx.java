package com.tencent.mapsdk.internal;

import android.util.SparseArray;
import com.tencent.map.lib.models.GroundOverlayInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class mx
  extends mn<my>
{
  public mx(sc paramsc)
  {
    super(paramsc);
  }
  
  private mm<my> a(my parammy)
  {
    AppMethodBeat.i(221473);
    parammy = new mw(this, parammy);
    AppMethodBeat.o(221473);
    return parammy;
  }
  
  private mw b(my parammy)
  {
    try
    {
      AppMethodBeat.i(221481);
      parammy = (mw)super.b(parammy);
      AppMethodBeat.o(221481);
      return parammy;
    }
    finally
    {
      parammy = finally;
      throw parammy;
    }
  }
  
  public final void f()
  {
    AppMethodBeat.i(221490);
    int j = this.c.size();
    int i = 0;
    while (i < j)
    {
      int k = this.c.keyAt(i);
      mw localmw = (mw)this.c.get(k);
      sc localsc = this.a;
      localmw.a(((Long)localsc.a(new sc.71(localsc, (GroundOverlayInfo)localmw.a()), Long.valueOf(0L))).longValue());
      ((my)localmw.a()).setBitmap(null);
      ((my)localmw.a()).setLatLngBounds(null);
      i += 1;
    }
    AppMethodBeat.o(221490);
  }
  
  public final void g()
  {
    AppMethodBeat.i(221496);
    int j = this.e.size();
    int i = 0;
    while (i < j)
    {
      int k = this.e.keyAt(i);
      mw localmw = (mw)this.e.get(k);
      sc localsc = this.a;
      localsc.a(new sc.72(localsc, localmw.b(), (GroundOverlayInfo)localmw.a()));
      ((my)localmw.a()).setBitmap(null);
      ((my)localmw.a()).setLatLngBounds(null);
      i += 1;
    }
    AppMethodBeat.o(221496);
  }
  
  public final void h()
  {
    AppMethodBeat.i(221501);
    int j = this.g.size();
    int i = 0;
    while (i < j)
    {
      int k = this.g.keyAt(i);
      mm localmm = (mm)this.g.get(k);
      this.a.c(localmm.b());
      i += 1;
    }
    AppMethodBeat.o(221501);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.mx
 * JD-Core Version:    0.7.0.1
 */