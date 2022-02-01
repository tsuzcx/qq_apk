package com.tencent.mapsdk.internal;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions;

public final class ay
  implements TileOverlay
{
  private final pz a;
  
  public ay(pz parampz)
  {
    this.a = parampz;
  }
  
  public final void clearTileCache()
  {
    AppMethodBeat.i(224087);
    if (this.a == null)
    {
      AppMethodBeat.o(224087);
      return;
    }
    this.a.f();
    AppMethodBeat.o(224087);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(224115);
    if (paramObject == null)
    {
      AppMethodBeat.o(224115);
      return false;
    }
    if (!(paramObject instanceof ay))
    {
      AppMethodBeat.o(224115);
      return false;
    }
    boolean bool = this.a.equals(((ay)paramObject).a);
    AppMethodBeat.o(224115);
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
    AppMethodBeat.i(224126);
    if (this.a == null)
    {
      AppMethodBeat.o(224126);
      return 0;
    }
    int i = this.a.hashCode();
    AppMethodBeat.o(224126);
    return i;
  }
  
  public final void reload()
  {
    AppMethodBeat.i(224047);
    if (this.a == null)
    {
      AppMethodBeat.o(224047);
      return;
    }
    this.a.e();
    AppMethodBeat.o(224047);
  }
  
  public final void remove()
  {
    AppMethodBeat.i(224060);
    if (this.a == null)
    {
      AppMethodBeat.o(224060);
      return;
    }
    this.a.remove();
    AppMethodBeat.o(224060);
  }
  
  public final void setDiskCacheDir(String paramString)
  {
    AppMethodBeat.i(224068);
    if (this.a == null)
    {
      AppMethodBeat.o(224068);
      return;
    }
    pz localpz = this.a;
    if ((localpz.p == null) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(224068);
      return;
    }
    localpz.p.diskCacheDir(paramString);
    localpz.q = localpz.g();
    AppMethodBeat.o(224068);
  }
  
  public final void setZindex(int paramInt)
  {
    AppMethodBeat.i(224079);
    if (this.a == null)
    {
      AppMethodBeat.o(224079);
      return;
    }
    this.a.a(paramInt);
    AppMethodBeat.o(224079);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ay
 * JD-Core Version:    0.7.0.1
 */