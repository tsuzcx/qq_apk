package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.ServiceConnection;
import android.view.ContextThemeWrapper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

public final class l
  extends MutableContextWrapper
{
  private ContextThemeWrapper mJt;
  
  private l(Context paramContext, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(177763);
    this.mJt = new l.a(paramContext.getApplicationContext(), paramInt);
    if (!(paramContext instanceof ContextThemeWrapper))
    {
      super.setBaseContext(this.mJt);
      AppMethodBeat.o(177763);
      return;
    }
    paramContext.setTheme(paramInt);
    AppMethodBeat.o(177763);
  }
  
  public static l dR(Context paramContext)
  {
    AppMethodBeat.i(48774);
    paramContext = new l(paramContext, s.bAB());
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
    super.setBaseContext(this.mJt);
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
      ae.printErrStackTrace("MicroMsg.AppBrandRuntimePersistentContextWrapper", paramServiceConnection, "[CAPTURED CRASH]", new Object[0]);
      AppMethodBeat.o(48778);
    }
  }
  
  public final void unregisterReceiver(BroadcastReceiver paramBroadcastReceiver)
  {
    AppMethodBeat.i(223131);
    try
    {
      super.unregisterReceiver(paramBroadcastReceiver);
      AppMethodBeat.o(223131);
      return;
    }
    catch (IllegalArgumentException paramBroadcastReceiver)
    {
      ae.e("MicroMsg.AppBrandRuntimePersistentContextWrapper", "unregisterReceiver IllegalArgumentException %s", new Object[] { paramBroadcastReceiver });
      AppMethodBeat.o(223131);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.l
 * JD-Core Version:    0.7.0.1
 */