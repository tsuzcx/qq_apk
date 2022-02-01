package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.TencentMapComponent.Component;

final class bm$a
{
  Class<? extends TencentMapComponent.Component> a;
  Class<? extends TencentMapComponent.Component> b;
  
  public bm$a(Class<? extends TencentMapComponent.Component> paramClass1, Class<? extends TencentMapComponent.Component> paramClass2)
  {
    this.a = paramClass1;
    this.b = paramClass2;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(222150);
    if (this == paramObject)
    {
      AppMethodBeat.o(222150);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(222150);
      return false;
    }
    paramObject = (a)paramObject;
    if (this.a != null)
    {
      if (this.a.equals(paramObject.a)) {}
    }
    else {
      while (paramObject.a != null)
      {
        AppMethodBeat.o(222150);
        return false;
      }
    }
    if (this.b != null)
    {
      boolean bool = this.b.equals(paramObject.b);
      AppMethodBeat.o(222150);
      return bool;
    }
    if (paramObject.b == null)
    {
      AppMethodBeat.o(222150);
      return true;
    }
    AppMethodBeat.o(222150);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(222159);
    if (this.a != null) {}
    for (int i = this.a.hashCode();; i = 0)
    {
      if (this.b != null) {
        j = this.b.hashCode();
      }
      AppMethodBeat.o(222159);
      return i * 31 + j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mapsdk.internal.bm.a
 * JD-Core Version:    0.7.0.1
 */