package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.ServiceConnection;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.Application;
import com.tencent.mm.plugin.appbrand.af.a;
import com.tencent.mm.ui.af;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;

public final class o
  extends MutableContextWrapper
{
  private boolean udS;
  private ContextThemeWrapper udT;
  private ab udU;
  
  private o(Context paramContext, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(177763);
    this.udS = false;
    this.udT = new a(paramContext.getApplicationContext(), paramInt);
    if (!(paramContext instanceof ContextThemeWrapper)) {
      super.setBaseContext(this.udT);
    }
    for (;;)
    {
      this.udS = (paramContext instanceof AppBrandUI);
      AppMethodBeat.o(177763);
      return;
      paramContext.setTheme(paramInt);
    }
  }
  
  public static o fj(Context paramContext)
  {
    AppMethodBeat.i(48774);
    paramContext = new o(paramContext, ac.cLF());
    AppMethodBeat.o(48774);
    return paramContext;
  }
  
  public final ab cLq()
  {
    AppMethodBeat.i(322232);
    if (this.udU == null) {
      this.udU = new ab(this);
    }
    ab localab = this.udU;
    AppMethodBeat.o(322232);
    return localab;
  }
  
  public final Object getSystemService(String paramString)
  {
    AppMethodBeat.i(48777);
    if ("layout_inflater".equals(paramString))
    {
      paramString = this.udT.getSystemService(paramString);
      AppMethodBeat.o(48777);
      return paramString;
    }
    paramString = super.getSystemService(paramString);
    AppMethodBeat.o(48777);
    return paramString;
  }
  
  public final void setBaseContext(final Context paramContext)
  {
    AppMethodBeat.i(48776);
    if (paramContext == getBaseContext())
    {
      AppMethodBeat.o(48776);
      return;
    }
    if (this.udS) {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimePersistentContextWrapper", "setBaseContext hash:%d, new:%s, old:%s, stack:%s", new Object[] { Integer.valueOf(hashCode()), paramContext, super.getBaseContext(), android.util.Log.getStackTraceString(new Throwable()) });
    }
    if ((paramContext instanceof Activity))
    {
      super.setBaseContext(paramContext);
      this.udS = true;
      ((Application)getApplicationContext()).registerActivityLifecycleCallbacks(new a()
      {
        public final void onActivityDestroyed(Activity paramAnonymousActivity)
        {
          AppMethodBeat.i(322128);
          if (paramContext == paramAnonymousActivity)
          {
            ((Application)o.this.getApplicationContext()).unregisterActivityLifecycleCallbacks(this);
            h.ahAA.o(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(322135);
                if (o.1.this.val$context == o.this.getBaseContext())
                {
                  com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimePersistentContextWrapper", "onActivityPostDestroyed auto release ref to %s", new Object[] { o.1.this.val$context });
                  o.a(o.this, o.a(o.this));
                }
                AppMethodBeat.o(322135);
              }
            }, 0L);
          }
          AppMethodBeat.o(322128);
        }
      });
    }
    for (;;)
    {
      this.udU = null;
      AppMethodBeat.o(48776);
      return;
      super.setBaseContext(this.udT);
    }
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
    AppMethodBeat.i(322264);
    try
    {
      super.unregisterReceiver(paramBroadcastReceiver);
      AppMethodBeat.o(322264);
      return;
    }
    catch (IllegalArgumentException paramBroadcastReceiver)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandRuntimePersistentContextWrapper", "unregisterReceiver IllegalArgumentException %s", new Object[] { paramBroadcastReceiver });
      AppMethodBeat.o(322264);
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
            this.mInflater = ((LayoutInflater)getApplicationContext().getSystemService(paramString)).cloneInContext(this);
            af.c(this.mInflater);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.o
 * JD-Core Version:    0.7.0.1
 */