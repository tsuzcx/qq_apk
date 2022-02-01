package com.tencent.mapsdk.internal;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;

public final class rt
  extends sj
{
  public rt(Context paramContext, TencentMapOptions paramTencentMapOptions, ViewGroup paramViewGroup)
  {
    super(paramContext, paramTencentMapOptions, paramViewGroup);
  }
  
  public final VectorMap a(mk parammk)
  {
    AppMethodBeat.i(223690);
    parammk = new rs(parammk);
    AppMethodBeat.o(223690);
    return parammk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.rt
 * JD-Core Version:    0.7.0.1
 */