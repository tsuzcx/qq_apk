package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.k.a;
import com.tencent.mm.plugin.location_soso.SoSoProxyUI;
import com.tencent.mm.plugin.location_soso.api.SoSoMapView;
import com.tencent.mm.sdk.platformtools.ab;

public final class d
  implements com.tencent.mm.plugin.k.c
{
  public static Intent V(Activity paramActivity)
  {
    AppMethodBeat.i(113645);
    paramActivity = new Intent(paramActivity, SoSoProxyUI.class);
    AppMethodBeat.o(113645);
    return paramActivity;
  }
  
  public static View et(Context paramContext)
  {
    AppMethodBeat.i(113646);
    paramContext = new SoSoMapView(paramContext);
    paramContext.setId(2131820622);
    AppMethodBeat.o(113646);
    return paramContext;
  }
  
  public final a f(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(113647);
    switch (paramInt)
    {
    case 3: 
    default: 
      AppMethodBeat.o(113647);
      return null;
    case 2: 
      paramActivity = new c(paramActivity);
    }
    for (;;)
    {
      AppMethodBeat.o(113647);
      return paramActivity;
      paramActivity = new h(paramActivity);
      continue;
      ab.i("MicroMsg.MapFactoryImp", "share map");
      paramActivity = new g(paramActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.d
 * JD-Core Version:    0.7.0.1
 */