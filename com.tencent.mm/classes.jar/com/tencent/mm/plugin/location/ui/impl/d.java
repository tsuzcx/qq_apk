package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.mm.plugin.location_soso.api.SoSoMapView;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.p.a;
import com.tencent.mm.sdk.platformtools.y;

public final class d
  implements com.tencent.mm.plugin.p.c
{
  public static View dH(Context paramContext)
  {
    paramContext = new SoSoMapView(paramContext);
    paramContext.setId(a.e.g_mapView);
    return paramContext;
  }
  
  public final a c(Activity paramActivity, int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    default: 
      return null;
    case 2: 
      return new c(paramActivity);
    case 4: 
      return new h(paramActivity);
    }
    y.i("MicroMsg.MapFactoryImp", "share map");
    return new g(paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.d
 * JD-Core Version:    0.7.0.1
 */