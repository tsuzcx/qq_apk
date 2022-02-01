package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.CustomLayer;

public final class at
  implements CustomLayer
{
  private final pz a;
  
  public at(pz parampz)
  {
    this.a = parampz;
  }
  
  public final void clearDiskCache()
  {
    AppMethodBeat.i(224325);
    if (this.a == null)
    {
      AppMethodBeat.o(224325);
      return;
    }
    this.a.f();
    AppMethodBeat.o(224325);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(224344);
    if (paramObject == null)
    {
      AppMethodBeat.o(224344);
      return false;
    }
    if (!(paramObject instanceof at))
    {
      AppMethodBeat.o(224344);
      return false;
    }
    boolean bool = this.a.equals(((at)paramObject).a);
    AppMethodBeat.o(224344);
    return bool;
  }
  
  public final String getId()
  {
    if (this.a == null) {
      return "";
    }
    return this.a.b_;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(224355);
    if (this.a == null)
    {
      AppMethodBeat.o(224355);
      return 0;
    }
    int i = this.a.hashCode();
    AppMethodBeat.o(224355);
    return i;
  }
  
  public final boolean isRemoved()
  {
    AppMethodBeat.i(224307);
    if (this.a != null)
    {
      boolean bool = this.a.isRemoved();
      AppMethodBeat.o(224307);
      return bool;
    }
    AppMethodBeat.o(224307);
    return false;
  }
  
  public final void releaseData()
  {
    AppMethodBeat.i(224317);
    if (this.a != null) {
      this.a.releaseData();
    }
    AppMethodBeat.o(224317);
  }
  
  public final void reload()
  {
    AppMethodBeat.i(224287);
    if (this.a == null)
    {
      AppMethodBeat.o(224287);
      return;
    }
    this.a.e();
    AppMethodBeat.o(224287);
  }
  
  public final void remove()
  {
    AppMethodBeat.i(224301);
    if (this.a == null)
    {
      AppMethodBeat.o(224301);
      return;
    }
    this.a.remove();
    kl.d("TCL");
    AppMethodBeat.o(224301);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.at
 * JD-Core Version:    0.7.0.1
 */