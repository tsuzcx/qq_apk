package com.tencent.mapsdk.core;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.mapsdk.internal.gy;
import com.tencent.mapsdk.internal.s;
import com.tencent.mapsdk.internal.u;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions.IMapKernel;

public class MapDelegateFactoryImpl
  implements s
{
  public MapDelegate createDelegate(Context paramContext, TencentMapOptions paramTencentMapOptions, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(221124);
    TencentMapOptions.IMapKernel localIMapKernel = paramTencentMapOptions.getMapKernel();
    Class localClass1 = gy.a("com.tencent.mapsdk.navi.MapKernelNavi", localIMapKernel.getClass().getClassLoader());
    Class localClass2 = gy.a("com.tencent.mapsdk.compat.MapKernelCompat", localIMapKernel.getClass().getClassLoader());
    if ((localClass2 != null) && (localClass2 == localIMapKernel.getClass())) {
      paramContext = (MapDelegate)gy.a(gy.a("com.tencent.mapsdk.compat.VectorMapCompatDelegateProxy", MapDelegate.class, u.a().b()), new Object[] { paramContext, paramTencentMapOptions, paramViewGroup });
    }
    for (;;)
    {
      if (paramContext != null) {
        paramContext.onCreated();
      }
      AppMethodBeat.o(221124);
      return paramContext;
      if ((localClass1 != null) && (localClass1 == localIMapKernel.getClass())) {
        paramContext = (MapDelegate)gy.a(gy.a("com.tencent.mapsdk.navi.VectorMapNaviDelegateProxy", MapDelegate.class, u.a().b()), new Object[] { paramContext, paramTencentMapOptions, paramViewGroup });
      } else {
        paramContext = (MapDelegate)gy.a(gy.a("com.tencent.mapsdk.vector.VectorMapDelegateProxy", MapDelegate.class, u.a().b()), new Object[] { paramContext, paramTencentMapOptions, paramViewGroup });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.core.MapDelegateFactoryImpl
 * JD-Core Version:    0.7.0.1
 */