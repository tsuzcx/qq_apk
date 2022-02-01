package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.i.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.location_soso.SoSoProxyUI;
import com.tencent.mm.plugin.location_soso.api.SoSoMapView;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.p.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.tencentmap.mapsdk.map.TencentMapOptions;

public final class d
  implements com.tencent.mm.plugin.p.c
{
  public static Intent aY(Activity paramActivity)
  {
    AppMethodBeat.i(56077);
    paramActivity = new Intent(paramActivity, SoSoProxyUI.class);
    paramActivity.addFlags(67108864);
    AppMethodBeat.o(56077);
    return paramActivity;
  }
  
  public static SoSoMapView iL(Context paramContext)
  {
    AppMethodBeat.i(264966);
    boolean bool = isOverseasUser();
    Log.i("MicroMsg.MapFactoryImp", "isOverseasUser:%b", new Object[] { Boolean.valueOf(bool) });
    TencentMapOptions localTencentMapOptions;
    if (bool)
    {
      localTencentMapOptions = new TencentMapOptions();
      localTencentMapOptions.setServiceProtocol(1, Integer.valueOf(a.d.sdk_protocol));
    }
    for (paramContext = new SoSoMapView(paramContext, localTencentMapOptions);; paramContext = new SoSoMapView(paramContext))
    {
      paramContext.setId(a.e.g_mapView);
      AppMethodBeat.o(264966);
      return paramContext;
    }
  }
  
  private static boolean isOverseasUser()
  {
    AppMethodBeat.i(264967);
    boolean bool = "CN".equalsIgnoreCase((String)com.tencent.mm.kernel.h.baE().ban().d(274436, null));
    Log.i("MicroMsg.MapFactoryImp", "chinaReg:%b", new Object[] { Boolean.valueOf(bool) });
    if (!bool)
    {
      AppMethodBeat.o(264967);
      return true;
    }
    AppMethodBeat.o(264967);
    return false;
  }
  
  public final a j(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(56079);
    switch (paramInt)
    {
    case 3: 
    default: 
      AppMethodBeat.o(56079);
      return null;
    case 2: 
      Log.i("MicroMsg.MapFactoryImp", "poi map");
      paramActivity = new c(paramActivity);
    }
    for (;;)
    {
      AppMethodBeat.o(56079);
      return paramActivity;
      Log.i("MicroMsg.MapFactoryImp", "track map");
      paramActivity = new j(paramActivity);
      continue;
      Log.i("MicroMsg.MapFactoryImp", "share map");
      paramActivity = new h(paramActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.d
 * JD-Core Version:    0.7.0.1
 */