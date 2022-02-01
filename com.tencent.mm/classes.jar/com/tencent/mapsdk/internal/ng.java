package com.tencent.mapsdk.internal;

import android.util.SparseArray;
import com.tencent.map.lib.models.MarkerInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ng
  extends mn<nh>
{
  public ng(sc paramsc)
  {
    super(paramsc);
  }
  
  private nf a(nh paramnh)
  {
    AppMethodBeat.i(221663);
    paramnh = new nf(this, paramnh);
    AppMethodBeat.o(221663);
    return paramnh;
  }
  
  private nf b(int paramInt)
  {
    try
    {
      AppMethodBeat.i(221677);
      nf localnf = (nf)super.a(paramInt);
      AppMethodBeat.o(221677);
      return localnf;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private nf b(nh paramnh)
  {
    try
    {
      AppMethodBeat.i(221690);
      paramnh = (nf)super.b(paramnh);
      AppMethodBeat.o(221690);
      return paramnh;
    }
    finally
    {
      paramnh = finally;
      throw paramnh;
    }
  }
  
  protected final int a(long paramLong)
  {
    AppMethodBeat.i(221738);
    if ((this.a == null) || (paramLong == 0L))
    {
      AppMethodBeat.o(221738);
      return 0;
    }
    int i = this.a.a(paramLong);
    AppMethodBeat.o(221738);
    return i;
  }
  
  public final void f()
  {
    AppMethodBeat.i(221704);
    int j = this.c.size();
    int i = 0;
    while (i < j)
    {
      int k = this.c.keyAt(i);
      nf localnf = (nf)this.c.get(k);
      sc localsc = this.a;
      localnf.a(((Long)localsc.a(new sc.50(localsc, (MarkerInfo)localnf.a()), Long.valueOf(0L))).longValue());
      i += 1;
    }
    AppMethodBeat.o(221704);
  }
  
  public final void g()
  {
    AppMethodBeat.i(221714);
    int j = this.e.size();
    int i = 0;
    while (i < j)
    {
      int k = this.e.keyAt(i);
      nf localnf = (nf)this.e.get(k);
      sc localsc = this.a;
      localsc.a(new sc.52(localsc, localnf.b(), (MarkerInfo)localnf.a()));
      i += 1;
    }
    AppMethodBeat.o(221714);
  }
  
  public final void h()
  {
    AppMethodBeat.i(221723);
    int j = this.g.size();
    int i = 0;
    while (i < j)
    {
      int k = this.g.keyAt(i);
      nf localnf = (nf)this.g.get(k);
      this.a.b(localnf.b());
      i += 1;
    }
    AppMethodBeat.o(221723);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ng
 * JD-Core Version:    0.7.0.1
 */