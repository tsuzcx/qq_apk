package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.ServiceConnection;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.w;

public final class g
  extends MutableContextWrapper
{
  private ContextThemeWrapper iOw;
  private volatile LayoutInflater mInflater;
  
  private g(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(143608);
    this.iOw = new ContextThemeWrapper(paramContext.getApplicationContext(), 2131493046);
    AppMethodBeat.o(143608);
  }
  
  public static g dc(Context paramContext)
  {
    AppMethodBeat.i(143607);
    paramContext = new g(paramContext);
    AppMethodBeat.o(143607);
    return paramContext;
  }
  
  public final Object getSystemService(String paramString)
  {
    AppMethodBeat.i(143610);
    if ("layout_inflater".equals(paramString)) {
      try
      {
        if (this.mInflater == null) {
          this.mInflater = w.hM(getBaseContext());
        }
        paramString = this.mInflater;
        return paramString;
      }
      finally
      {
        AppMethodBeat.o(143610);
      }
    }
    paramString = getBaseContext().getSystemService(paramString);
    AppMethodBeat.o(143610);
    return paramString;
  }
  
  public final void setBaseContext(Context paramContext)
  {
    AppMethodBeat.i(143609);
    if (paramContext == getBaseContext())
    {
      AppMethodBeat.o(143609);
      return;
    }
    if ((paramContext instanceof Activity)) {
      super.setBaseContext(paramContext);
    }
    for (;;)
    {
      try
      {
        this.mInflater = null;
        getSystemService("layout_inflater");
        return;
      }
      finally
      {
        AppMethodBeat.o(143609);
      }
      super.setBaseContext(this.iOw);
    }
  }
  
  public final void unbindService(ServiceConnection paramServiceConnection)
  {
    AppMethodBeat.i(154862);
    try
    {
      super.unbindService(paramServiceConnection);
      AppMethodBeat.o(154862);
      return;
    }
    catch (IllegalArgumentException paramServiceConnection)
    {
      ab.printErrStackTrace("MicroMsg.AppBrandRuntimePersistentContextWrapper", paramServiceConnection, "[CAPTURED CRASH]", new Object[0]);
      AppMethodBeat.o(154862);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.g
 * JD-Core Version:    0.7.0.1
 */