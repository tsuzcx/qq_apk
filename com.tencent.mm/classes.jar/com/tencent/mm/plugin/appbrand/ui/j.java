package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.ServiceConnection;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.z;

public final class j
  extends MutableContextWrapper
{
  private ContextThemeWrapper mdV;
  
  private j(Context paramContext, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(177763);
    this.mdV = new a(paramContext.getApplicationContext(), paramInt);
    if (!(paramContext instanceof ContextThemeWrapper))
    {
      super.setBaseContext(this.mdV);
      AppMethodBeat.o(177763);
      return;
    }
    paramContext.setTheme(paramInt);
    AppMethodBeat.o(177763);
  }
  
  public static j dO(Context paramContext)
  {
    AppMethodBeat.i(48774);
    paramContext = new j(paramContext, q.bvA());
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
    super.setBaseContext(this.mdV);
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
      ac.printErrStackTrace("MicroMsg.AppBrandRuntimePersistentContextWrapper", paramServiceConnection, "[CAPTURED CRASH]", new Object[0]);
      AppMethodBeat.o(48778);
    }
  }
  
  static final class a
    extends ContextThemeWrapper
  {
    private volatile LayoutInflater mInflater;
    
    public a(Context paramContext, int paramInt)
    {
      super(paramInt);
    }
    
    public final Object getSystemService(String paramString)
    {
      AppMethodBeat.i(177762);
      if ("layout_inflater".equals(paramString)) {
        try
        {
          if (this.mInflater == null)
          {
            this.mInflater = ((LayoutInflater)super.getSystemService(paramString));
            this.mInflater = z.b(this.mInflater);
          }
          paramString = this.mInflater;
          return paramString;
        }
        finally
        {
          AppMethodBeat.o(177762);
        }
      }
      paramString = super.getSystemService(paramString);
      AppMethodBeat.o(177762);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.j
 * JD-Core Version:    0.7.0.1
 */