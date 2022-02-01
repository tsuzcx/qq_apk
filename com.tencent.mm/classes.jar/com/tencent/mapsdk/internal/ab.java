package com.tencent.mapsdk.internal;

import android.location.Location;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.LocationSource;
import com.tencent.tencentmap.mapsdk.maps.model.MyLocationStyle;

public final class ab
{
  public ah a = null;
  
  public ab(ah paramah)
  {
    this.a = paramah;
  }
  
  private void a()
  {
    if (this.a != null) {
      this.a = null;
    }
  }
  
  private void a(LocationSource paramLocationSource)
  {
    AppMethodBeat.i(223717);
    if (this.a != null) {
      this.a.a(paramLocationSource);
    }
    AppMethodBeat.o(223717);
  }
  
  private void a(MyLocationStyle paramMyLocationStyle)
  {
    AppMethodBeat.i(223757);
    if (this.a != null) {
      this.a.a(paramMyLocationStyle);
    }
    AppMethodBeat.o(223757);
  }
  
  private Location b()
  {
    AppMethodBeat.i(223708);
    if (this.a != null)
    {
      Location localLocation = this.a.e();
      AppMethodBeat.o(223708);
      return localLocation;
    }
    AppMethodBeat.o(223708);
    return null;
  }
  
  private void c()
  {
    AppMethodBeat.i(223724);
    if (this.a != null) {
      this.a.a();
    }
    AppMethodBeat.o(223724);
  }
  
  private void d()
  {
    AppMethodBeat.i(223731);
    if (this.a != null) {
      this.a.b();
    }
    AppMethodBeat.o(223731);
  }
  
  private void e()
  {
    AppMethodBeat.i(223740);
    if (this.a != null) {
      this.a.c();
    }
    AppMethodBeat.o(223740);
  }
  
  private boolean f()
  {
    AppMethodBeat.i(223749);
    if (this.a != null)
    {
      boolean bool = this.a.d();
      AppMethodBeat.o(223749);
      return bool;
    }
    AppMethodBeat.o(223749);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ab
 * JD-Core Version:    0.7.0.1
 */