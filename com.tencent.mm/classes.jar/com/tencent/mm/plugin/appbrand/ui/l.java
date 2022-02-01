package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.ServiceConnection;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.Application;
import com.tencent.mm.plugin.appbrand.ac.a;
import com.tencent.mm.ui.ad;

public final class l
  extends MutableContextWrapper
{
  private boolean qXR;
  private ContextThemeWrapper qXS;
  
  private l(Context paramContext, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(177763);
    this.qXR = false;
    this.qXS = new a(paramContext.getApplicationContext(), paramInt);
    if (!(paramContext instanceof ContextThemeWrapper)) {
      super.setBaseContext(this.qXS);
    }
    for (;;)
    {
      this.qXR = (paramContext instanceof AppBrandUI);
      AppMethodBeat.o(177763);
      return;
      paramContext.setTheme(paramInt);
    }
  }
  
  public static l en(Context paramContext)
  {
    AppMethodBeat.i(48774);
    paramContext = new l(paramContext, w.ckq());
    AppMethodBeat.o(48774);
    return paramContext;
  }
  
  public final Object getSystemService(String paramString)
  {
    AppMethodBeat.i(48777);
    if ("layout_inflater".equals(paramString))
    {
      paramString = this.qXS.getSystemService(paramString);
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
    if (this.qXR) {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimePersistentContextWrapper", "setBaseContext hash:%d, new:%s, old:%s, stack:%s", new Object[] { Integer.valueOf(hashCode()), paramContext, super.getBaseContext(), android.util.Log.getStackTraceString(new Throwable()) });
    }
    if ((paramContext instanceof Activity))
    {
      super.setBaseContext(paramContext);
      this.qXR = true;
      ((Application)getApplicationContext()).registerActivityLifecycleCallbacks(new a()
      {
        public final void onActivityDestroyed(Activity paramAnonymousActivity)
        {
          AppMethodBeat.i(279986);
          if (paramContext == paramAnonymousActivity)
          {
            ((Application)l.this.getApplicationContext()).unregisterActivityLifecycleCallbacks(this);
            h.ZvG.n(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(278408);
                if (l.1.this.val$context == l.this.getBaseContext())
                {
                  com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandRuntimePersistentContextWrapper", "onActivityPostDestroyed auto release ref to %s", new Object[] { l.1.this.val$context });
                  l.a(l.this, l.a(l.this));
                }
                AppMethodBeat.o(278408);
              }
            }, 0L);
          }
          AppMethodBeat.o(279986);
        }
      });
      AppMethodBeat.o(48776);
      return;
    }
    super.setBaseContext(this.qXS);
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
    AppMethodBeat.i(272705);
    try
    {
      super.unregisterReceiver(paramBroadcastReceiver);
      AppMethodBeat.o(272705);
      return;
    }
    catch (IllegalArgumentException paramBroadcastReceiver)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandRuntimePersistentContextWrapper", "unregisterReceiver IllegalArgumentException %s", new Object[] { paramBroadcastReceiver });
      AppMethodBeat.o(272705);
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
            ad.c(this.mInflater);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.l
 * JD-Core Version:    0.7.0.1
 */