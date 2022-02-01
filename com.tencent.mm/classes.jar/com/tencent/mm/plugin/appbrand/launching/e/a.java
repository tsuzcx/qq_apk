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
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class a
  extends MutableContextWrapper
{
  private volatile boolean kOn = false;
  volatile boolean kOo = false;
  protected boolean kOp = true;
  private final Queue<Runnable> kOq = new ConcurrentLinkedQueue();
  private ap kOr;
  
  public a()
  {
    super(aj.getContext());
  }
  
  private boolean bhj()
  {
    Object localObject = getBaseContext();
    if ((localObject instanceof AppBrandLaunchProxyUI))
    {
      localObject = (AppBrandLaunchProxyUI)localObject;
      return (!((AppBrandLaunchProxyUI)localObject).isDestroyed()) && (!((AppBrandLaunchProxyUI)localObject).isFinishing());
    }
    return false;
  }
  
  protected final void X(Runnable paramRunnable)
  {
    if (bhj())
    {
      ((Activity)getBaseContext()).runOnUiThread(paramRunnable);
      return;
    }
    if (this.kOn)
    {
      ad.e("MicroMsg.AppBrand.Precondition.AbstractLaunchPreconditionProcess", "runOnUiEnv but destroyed, clear mUiEnvQueue, call stack = %s", new Object[] { Log.getStackTraceString(new Throwable()) });
      this.kOq.clear();
      return;
    }
    this.kOq.offer(paramRunnable);
  }
  
  protected final void a(final LaunchParcel paramLaunchParcel, final String paramString)
  {
    ap localap = new ap("AppBrandLaunchProxyUI-PrepareThread");
    this.kOr = localap;
    localap.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(47428);
        new com.tencent.mm.plugin.appbrand.launching.f(paramLaunchParcel, paramString, new e.a()new f.a {}, new f.a()
        {
          public final void bgh()
          {
            AppMethodBeat.i(175006);
            ad.d("MicroMsg.AppBrand.Precondition.AbstractLaunchPreconditionProcess", "AppBrandPreLaunchProcessWC showPrompt, username[%s] appId[%s] currentInUiEnv[%b]", new Object[] { a.3.this.kmp.username, a.3.this.kmp.appId, Boolean.valueOf(a.b(a.this)) });
            a.this.X(new Runnable()
            {
              public final void run()
              {
                boolean bool2 = true;
                AppMethodBeat.i(175005);
                AppBrandLaunchProxyUI localAppBrandLaunchProxyUI = (AppBrandLaunchProxyUI)a.this.getBaseContext();
                boolean bool1 = bool2;
                if (!localAppBrandLaunchProxyUI.isFinishing()) {
                  if (!localAppBrandLaunchProxyUI.isDestroyed()) {
                    break label89;
                  }
                }
                label89:
                for (bool1 = bool2;; bool1 = false)
                {
                  ad.d("MicroMsg.AppBrandLaunchProxyUI", "revealProgressLayoutImmediately destroyed[%b]", new Object[] { Boolean.valueOf(bool1) });
                  localAppBrandLaunchProxyUI.kFL.removeCallbacks(localAppBrandLaunchProxyUI.kFM);
                  localAppBrandLaunchProxyUI.kFL.post(localAppBrandLaunchProxyUI.kFM);
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
  
  protected void b(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    if (paramAppBrandInitConfigWC != null)
    {
      Object localObject2 = getBaseContext();
      Context localContext = bhl();
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
      localObject2 = com.tencent.mm.sdk.f.a.iV((Context)localObject1);
      if ((localObject2 == null) || (((Activity)localObject2).isFinishing())) {
        localObject1 = aj.getContext();
      }
      i.b((Context)localObject1, paramAppBrandInitConfigWC, paramAppBrandStatObject);
    }
    for (;;)
    {
      if (this.kOp) {
        bhk();
      }
      this.kOo = true;
      if ((this.kOr != null) && (this.kOr.getLooper() != Looper.getMainLooper())) {
        this.kOr.postToWorker(new Runnable()
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
      this.kOp = true;
    }
  }
  
  public final void bhi()
  {
    this.kOn = true;
    this.kOq.clear();
    super.setBaseContext(aj.getContext());
  }
  
  protected final void bhk()
  {
    X(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(47421);
        ad.i("MicroMsg.AppBrand.Precondition.AbstractLaunchPreconditionProcess", "finishUiEnv InUiEnv");
        ((AppBrandLaunchProxyUI)a.this.getBaseContext()).finish();
        a.this.setBaseContext(aj.getContext());
        a.a(a.this);
        AppMethodBeat.o(47421);
      }
    });
  }
  
  protected Context bhl()
  {
    return null;
  }
  
  protected final boolean bhm()
  {
    return (bhj()) && (((AppBrandLaunchProxyUI)getBaseContext()).isDestroyed());
  }
  
  protected boolean c(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    if (DebuggerShell.aTY())
    {
      ad.i("MicroMsg.AppBrand.Precondition.AbstractLaunchPreconditionProcess", "shouldCheckTbsBeforeAppLaunch inMonkeyEnv");
      return true;
    }
    if ((com.tencent.mm.plugin.appbrand.task.f.MQ(paramAppBrandInitConfigWC.appId)) || (paramAppBrandInitConfigWC.CZ())) {}
    for (int i = 1;; i = 0)
    {
      boolean bool = i | paramAppBrandInitConfigWC.jdi | com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.f.d(paramAppBrandInitConfigWC, paramAppBrandStatObject);
      i = bool;
      if (!paramAppBrandInitConfigWC.jdi)
      {
        i = bool;
        if (paramAppBrandInitConfigWC.jdl)
        {
          i = bool;
          if (com.tencent.mm.plugin.appbrand.f.a(paramAppBrandInitConfigWC)) {
            i = 0;
          }
        }
      }
      if (paramAppBrandInitConfigWC.CZ()) {
        com.tencent.mm.plugin.expansions.a.cbc();
      }
      if ((i & 0x1) == 0) {
        break;
      }
      return false;
    }
  }
  
  protected final void finish()
  {
    b(null, null);
  }
  
  protected final boolean isFinishing()
  {
    return (bhj()) && (((AppBrandLaunchProxyUI)getBaseContext()).isFinishing());
  }
  
  public final void setBaseContext(Context paramContext)
  {
    super.setBaseContext(paramContext);
    if (bhj())
    {
      if (this.kOn) {
        this.kOq.clear();
      }
    }
    else {
      return;
    }
    do
    {
      ((Runnable)this.kOq.poll()).run();
      if (this.kOq.isEmpty()) {
        break;
      }
    } while (bhj());
    ad.e("MicroMsg.AppBrand.Precondition.AbstractLaunchPreconditionProcess", "fileAllPendingUiTasks but !currentInUiEnv, return");
    this.kOq.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.e.a
 * JD-Core Version:    0.7.0.1
 */