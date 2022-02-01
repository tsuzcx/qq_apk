package com.tencent.mapsdk.internal;

import android.util.SparseArray;
import com.tencent.map.lib.models.AggregationOverlayInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.VectorHeatAggregationUnit;

public final class ms
  extends mn<mr>
{
  public ms(sc paramsc)
  {
    super(paramsc);
  }
  
  private mm<mr> a(mr parammr)
  {
    AppMethodBeat.i(222881);
    parammr = new mq(this, parammr);
    AppMethodBeat.o(222881);
    return parammr;
  }
  
  private mq b(mr parammr)
  {
    try
    {
      AppMethodBeat.i(222888);
      parammr = (mq)super.b(parammr);
      AppMethodBeat.o(222888);
      return parammr;
    }
    finally
    {
      parammr = finally;
      throw parammr;
    }
  }
  
  final VectorHeatAggregationUnit a(long paramLong, LatLng paramLatLng)
  {
    AppMethodBeat.i(222963);
    if (this.a == null)
    {
      AppMethodBeat.o(222963);
      return null;
    }
    sc localsc = this.a;
    paramLatLng = (VectorHeatAggregationUnit)localsc.a(new sc.62(localsc, paramLong, paramLatLng), null);
    AppMethodBeat.o(222963);
    return paramLatLng;
  }
  
  public final void c()
  {
    AppMethodBeat.i(222949);
    int j = this.b.size();
    boolean bool = this.a.m();
    int i = 0;
    while (i < j)
    {
      int k = this.b.keyAt(i);
      bool |= ((mr)((mq)this.b.get(k)).a()).isAnimate();
      i += 1;
    }
    if (bool) {
      this.a.j.v = true;
    }
    AppMethodBeat.o(222949);
  }
  
  public final void e()
  {
    AppMethodBeat.i(222957);
    if (this.a.x()) {
      this.a.j.v = true;
    }
    AppMethodBeat.o(222957);
  }
  
  public final void f()
  {
    AppMethodBeat.i(222908);
    int j = this.c.size();
    int i = 0;
    while (i < j)
    {
      int k = this.c.keyAt(i);
      mq localmq = (mq)this.c.get(k);
      sc localsc = this.a;
      localmq.a(((Long)localsc.a(new sc.56(localsc, (AggregationOverlayInfo)localmq.a()), Long.valueOf(0L))).longValue());
      i += 1;
    }
    AppMethodBeat.o(222908);
  }
  
  public final void g()
  {
    AppMethodBeat.i(222932);
    int j = this.e.size();
    int i = 0;
    while (i < j)
    {
      int k = this.e.keyAt(i);
      mq localmq = (mq)this.e.get(k);
      sc localsc = this.a;
      localsc.a(new sc.58(localsc, localmq.b(), (AggregationOverlayInfo)localmq.a()));
      i += 1;
    }
    AppMethodBeat.o(222932);
  }
  
  public final void h()
  {
    AppMethodBeat.i(222923);
    int j = this.g.size();
    int i = 0;
    while (i < j)
    {
      int k = this.g.keyAt(i);
      mm localmm = (mm)this.g.get(k);
      this.a.c(localmm.b());
      i += 1;
    }
    AppMethodBeat.o(222923);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ms
 * JD-Core Version:    0.7.0.1
 */