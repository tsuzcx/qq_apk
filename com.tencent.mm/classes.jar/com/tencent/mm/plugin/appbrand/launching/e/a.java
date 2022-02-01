package com.tencent.mm.plugin.appbrand.launching.e;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Looper;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.gdpr.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.e.a;
import com.tencent.mm.plugin.appbrand.launching.f.a;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class a
  extends MutableContextWrapper
{
  private volatile boolean lNh = false;
  volatile boolean lNi = false;
  protected boolean lNj = true;
  private final Queue<Runnable> lNk = new ConcurrentLinkedQueue();
  private ap lNl;
  
  public a()
  {
    super(aj.getContext());
  }
  
  private boolean brW()
  {
    Object localObject = getBaseContext();
    if ((localObject instanceof AppBrandLaunchProxyUI))
    {
      localObject = (AppBrandLaunchProxyUI)localObject;
      return (!((AppBrandLaunchProxyUI)localObject).isDestroyed()) && (!((AppBrandLaunchProxyUI)localObject).isFinishing());
    }
    return false;
  }
  
  protected final void Y(Runnable paramRunnable)
  {
    if (brW())
    {
      ((Activity)getBaseContext()).runOnUiThread(paramRunnable);
      return;
    }
    if (this.lNh)
    {
      ad.e("MicroMsg.AppBrand.Precondition.AbstractLaunchPreconditionProcess", "runOnUiEnv but destroyed, clear mUiEnvQueue, call stack = %s", new Object[] { Log.getStackTraceString(new Throwable()) });
      this.lNk.clear();
      return;
    }
    this.lNk.offer(paramRunnable);
  }
  
  protected final void a(final LaunchParcel paramLaunchParcel, final String paramString)
  {
    ap localap = new ap("AppBrandLaunchProxyUI-PrepareThread");
    this.lNl = localap;
    localap.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(47428);
        new com.tencent.mm.plugin.appbrand.launching.f(paramLaunchParcel, paramString, new e.a()new f.a {}, new f.a()
        {
          public final void bqM()
          {
            AppMethodBeat.i(175006);
            ad.d("MicroMsg.AppBrand.Precondition.AbstractLaunchPreconditionProcess", "AppBrandPreLaunchProcessWC showPrompt, username[%s] appId[%s] currentInUiEnv[%b]", new Object[] { a.3.this.lkk.username, a.3.this.lkk.appId, Boolean.valueOf(a.b(a.this)) });
            a.this.Y(new Runnable()
            {
              public final void run()
              {
                boolean bool2 = true;
                AppMethodBeat.i(175005);
                AppBrandLaunchProxyUI localAppBrandLaunchProxyUI;
                if ((a.this.getBaseContext() instanceof AppBrandLaunchProxyUI))
                {
                  localAppBrandLaunchProxyUI = (AppBrandLaunchProxyUI)a.this.getBaseContext();
                  bool1 = bool2;
                  if (!localAppBrandLaunchProxyUI.isFinishing()) {
                    if (!localAppBrandLaunchProxyUI.isDestroyed()) {
                      break label108;
                    }
                  }
                }
                label108:
                for (boolean bool1 = bool2;; bool1 = false)
                {
                  ad.d("MicroMsg.AppBrandLaunchProxyUI", "revealProgressLayoutImmediately destroyed[%b]", new Object[] { Boolean.valueOf(bool1) });
                  localAppBrandLaunchProxyUI.lEc.removeCallbacks(localAppBrandLaunchProxyUI.lEd);
                  localAppBrandLaunchProxyUI.lEc.post(localAppBrandLaunchProxyUI.lEd);
                  AppMethodBeat.o(175005);
                  return;
                }
              }
            });
            AppMethodBeat.o(175006);
          }
        }).run();
        AppMethodBeat.o(47428);
      }
    });
  }
  
  public final void brV()
  {
    this.lNh = true;
    this.lNk.clear();
    super.setBaseContext(aj.getContext());
  }
  
  protected final void brX()
  {
    Y(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(47421);
        ad.i("MicroMsg.AppBrand.Precondition.AbstractLaunchPreconditionProcess", "finishUiEnv InUiEnv");
        if ((a.this.getBaseContext() instanceof AppBrandLaunchProxyUI)) {
          ((AppBrandLaunchProxyUI)a.this.getBaseContext()).finish();
        }
        a.this.setBaseContext(aj.getContext());
        a.a(a.this);
        AppMethodBeat.o(47421);
      }
    });
  }
  
  protected Context brY()
  {
    return null;
  }
  
  protected final boolean brZ()
  {
    return (brW()) && (((AppBrandLaunchProxyUI)getBaseContext()).isDestroyed());
  }
  
  protected void c(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    if (paramAppBrandInitConfigWC != null)
    {
      Object localObject2 = getBaseContext();
      Context localContext = brY();
      Object localObject1;
      if (!(localObject2 instanceof Activity))
      {
        localObject1 = localContext;
        if (localContext != null) {}
      }
      else
      {
        localObject1 = localObject2;
      }
      localObject2 = com.tencent.mm.sdk.f.a.jq((Context)localObject1);
      if ((localObject2 == null) || (((Activity)localObject2).isFinishing())) {
        localObject1 = aj.getContext();
      }
      i.b((Context)localObject1, paramAppBrandInitConfigWC, paramAppBrandStatObject);
    }
    for (;;)
    {
      if (this.lNj) {
        brX();
      }
      this.lNi = true;
      if ((this.lNl != null) && (this.lNl.getLooper() != Looper.getMainLooper())) {
        this.lNl.postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(47429);
            a.c(a.this).quit();
            AppMethodBeat.o(47429);
          }
        });
      }
      return;
      this.lNj = true;
    }
  }
  
  protected boolean d(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    if (DebuggerShell.bew())
    {
      ad.i("MicroMsg.AppBrand.Precondition.AbstractLaunchPreconditionProcess", "shouldCheckTbsBeforeAppLaunch inMonkeyEnv");
      return true;
    }
    if ((com.tencent.mm.plugin.appbrand.task.f.UF(paramAppBrandInitConfigWC.appId)) || (paramAppBrandInitConfigWC.Eb())) {}
    for (int i = 1;; i = 0)
    {
      boolean bool = i | paramAppBrandInitConfigWC.jXr | g.e(paramAppBrandInitConfigWC, paramAppBrandStatObject);
      i = bool;
      if (!paramAppBrandInitConfigWC.jXr)
      {
        i = bool;
        if (paramAppBrandInitConfigWC.jXu)
        {
          i = bool;
          if (com.tencent.mm.plugin.appbrand.f.a(paramAppBrandInitConfigWC)) {
            i = 0;
          }
        }
      }
      if (paramAppBrandInitConfigWC.Eb()) {
        com.tencent.mm.plugin.expansions.a.cmP();
      }
      if ((i & 0x1) == 0) {
        break;
      }
      return false;
    }
  }
  
  protected final void finish()
  {
    c(null, null);
  }
  
  protected final boolean isFinishing()
  {
    return (brW()) && (((AppBrandLaunchProxyUI)getBaseContext()).isFinishing());
  }
  
  public final void setBaseContext(Context paramContext)
  {
    super.setBaseContext(paramContext);
    if (brW())
    {
      if (this.lNh) {
        this.lNk.clear();
      }
    }
    else {
      return;
    }
    do
    {
      ((Runnable)this.lNk.poll()).run();
      if (this.lNk.isEmpty()) {
        break;
      }
    } while (brW());
    ad.e("MicroMsg.AppBrand.Precondition.AbstractLaunchPreconditionProcess", "fileAllPendingUiTasks but !currentInUiEnv, return");
    this.lNk.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.e.a
 * JD-Core Version:    0.7.0.1
 */