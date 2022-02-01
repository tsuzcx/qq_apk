package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.ServiceConnection;
import android.view.ContextThemeWrapper;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
  extends MutableContextWrapper
{
  private boolean nWr;
  private ContextThemeWrapper nWs;
  
  private n(Context paramContext, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(177763);
    this.nWr = false;
    this.nWs = new n.a(paramContext.getApplicationContext(), paramInt);
    if (!(paramContext instanceof ContextThemeWrapper)) {
      super.setBaseContext(this.nWs);
    }
    for (;;)
    {
      this.nWr = (paramContext instanceof AppBrandUI);
      AppMethodBeat.o(177763);
      return;
      paramContext.setTheme(paramInt);
    }
  }
  
  public static n eo(Context paramContext)
  {
    AppMethodBeat.i(48774);
    paramContext = new n(paramContext, x.bXG());
    AppMethodBeat.o(48774);
    return paramContext;
  }
  
  public final Object getSystemService(String paramString)
  {
    AppMethodBeat.i(48777);
    if ("layout_inflater".equals(paramString))
    {
      paramString = this.nWs.getSystemService(paramString);
      AppMethodBeat.o(48777);
      return paramString;
    }
    paramString = super.getSystemService(paramString);
    AppMethodBeat.o(48777);
    return paramString;
  }
  
  public final void setBaseContext(Context paramContext)
  {
    AppMethodBeat.i(48776);
    if (paramContext == getBaseContext())
    {
      AppMethodBeat.o(48776);
      return;
    }
    if (this.nWr) {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimePersistentContextWrapper", "setBaseContext hash:%d, new:%s, old:%s, stack:%s", new Object[] { Integer.valueOf(hashCode()), paramContext, super.getBaseContext(), android.util.Log.getStackTraceString(new Throwable()) });
    }
    if ((paramContext instanceof Activity))
    {
      super.setBaseContext(paramContext);
      this.nWr = true;
      AppMethodBeat.o(48776);
      return;
    }
    super.setBaseContext(this.nWs);
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
      com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.AppBrandRuntimePersistentContextWrapper", paramServiceConnection, "[CAPTURED CRASH]", new Object[0]);
      AppMethodBeat.o(48778);
    }
  }
  
  public final void unregisterReceiver(BroadcastReceiver paramBroadcastReceiver)
  {
    AppMethodBeat.i(227665);
    try
    {
      super.unregisterReceiver(paramBroadcastReceiver);
      AppMethodBeat.o(227665);
      return;
    }
    catch (IllegalArgumentException paramBroadcastReceiver)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandRuntimePersistentContextWrapper", "unregisterReceiver IllegalArgumentException %s", new Object[] { paramBroadcastReceiver });
      AppMethodBeat.o(227665);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.n
 * JD-Core Version:    0.7.0.1
 */