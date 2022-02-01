package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.ServiceConnection;
import android.view.ContextThemeWrapper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class k
  extends MutableContextWrapper
{
  private ContextThemeWrapper mEo;
  
  private k(Context paramContext, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(177763);
    this.mEo = new k.a(paramContext.getApplicationContext(), paramInt);
    if (!(paramContext instanceof ContextThemeWrapper))
    {
      super.setBaseContext(this.mEo);
      AppMethodBeat.o(177763);
      return;
    }
    paramContext.setTheme(paramInt);
    AppMethodBeat.o(177763);
  }
  
  public static k dN(Context paramContext)
  {
    AppMethodBeat.i(48774);
    paramContext = new k(paramContext, r.bzG());
    AppMethodBeat.o(48774);
    return paramContext;
  }
  
  public final void setBaseContext(Context paramContext)
  {
    AppMethodBeat.i(48776);
    if (paramContext == getBaseContext())
    {
      AppMethodBeat.o(48776);
      return;
    }
    if ((paramContext instanceof Activity))
    {
      super.setBaseContext(paramContext);
      AppMethodBeat.o(48776);
      return;
    }
    super.setBaseContext(this.mEo);
    AppMethodBeat.o(48776);
  }
  
  public final void unbindService(ServiceConnection paramServiceConnection)
  {
    AppMethodBeat.i(48778);
    try
    {
      super.unbindService(paramServiceConnection);
      AppMethodBeat.o(48778);
      return;
    }
    catch (IllegalArgumentException paramServiceConnection)
    {
      ad.printErrStackTrace("MicroMsg.AppBrandRuntimePersistentContextWrapper", paramServiceConnection, "[CAPTURED CRASH]", new Object[0]);
      AppMethodBeat.o(48778);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.k
 * JD-Core Version:    0.7.0.1
 */