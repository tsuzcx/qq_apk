package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.k.a;
import com.tencent.mm.plugin.location_soso.SoSoProxyUI;
import com.tencent.mm.plugin.location_soso.api.SoSoMapView;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  implements com.tencent.mm.plugin.k.c
{
  public static Intent ar(Activity paramActivity)
  {
    AppMethodBeat.i(56077);
    paramActivity = new Intent(paramActivity, SoSoProxyUI.class);
    AppMethodBeat.o(56077);
    return paramActivity;
  }
  
  public static View gs(Context paramContext)
  {
    AppMethodBeat.i(56078);
    paramContext = new SoSoMapView(paramContext);
    paramContext.setId(2131301852);
    AppMethodBeat.o(56078);
    return paramContext;
  }
  
  public final a h(Activity paramActivity, int paramInt)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.d
 * JD-Core Version:    0.7.0.1
 */