package com.tencent.mm.plugin.appbrand.launching.e;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.os.Looper;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.gdpr.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.ab;
import com.tencent.mm.plugin.appbrand.launching.ba;
import com.tencent.mm.plugin.appbrand.launching.e.a;
import com.tencent.mm.plugin.appbrand.launching.f.a;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.AppBrandXWebDownloadProxyUI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.xwalk.core.XWalkEnvironment;

public abstract class a
  extends MutableContextWrapper
{
  private volatile boolean lpM = false;
  volatile boolean lpN = false;
  protected boolean lpO = true;
  private final Queue<Runnable> lpP = new ConcurrentLinkedQueue();
  private ao lpQ;
  
  public a()
  {
    super(ai.getContext());
  }
  
  private boolean bod()
  {
    Object localObject = getBaseContext();
    if ((localObject instanceof AppBrandLaunchProxyUI))
    {
      localObject = (AppBrandLaunchProxyUI)localObject;
      return (!((AppBrandLaunchProxyUI)localObject).isDestroyed()) && (!((AppBrandLaunchProxyUI)localObject).isFinishing());
    }
    return false;
  }
  
  protected final void Z(Runnable paramRunnable)
  {
    if (bod())
    {
      ((Activity)getBaseContext()).runOnUiThread(paramRunnable);
      return;
    }
    if (this.lpM)
    {
      ac.e("MicroMsg.AppBrand.Precondition.AbstractLaunchPreconditionProcess", "runOnUiEnv but destroyed, clear mUiEnvQueue, call stack = %s", new Object[] { Log.getStackTraceString(new Throwable()) });
      this.lpP.clear();
      return;
    }
    this.lpP.offer(paramRunnable);
  }
  
  protected final void a(final LaunchParcel paramLaunchParcel, final String paramString)
  {
    ao localao = new ao("AppBrandLaunchProxyUI-PrepareThread");
    this.lpQ = localao;
    localao.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(47428);
        new com.tencent.mm.plugin.appbrand.launching.f(paramLaunchParcel, paramString, new e.a()new f.a {}, new f.a()
        {
          public final void bnb()
          {
            AppMethodBeat.i(175006);
            ac.d("MicroMsg.AppBrand.Precondition.AbstractLaunchPreconditionProcess", "AppBrandPreLaunchProcessWC showPrompt, username[%s] appId[%s] currentInUiEnv[%b]", new Object[] { a.3.this.kNH.username, a.3.this.kNH.appId, Boolean.valueOf(a.b(a.this)) });
            a.this.Z(new Runnable()
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
                  ac.d("MicroMsg.AppBrandLaunchProxyUI", "revealProgressLayoutImmediately destroyed[%b]", new Object[] { Boolean.valueOf(bool1) });
                  localAppBrandLaunchProxyUI.lhe.removeCallbacks(localAppBrandLaunchProxyUI.lhf);
                  localAppBrandLaunchProxyUI.lhe.post(localAppBrandLaunchProxyUI.lhf);
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
      Context localContext = bof();
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
      localObject2 = com.tencent.mm.sdk.f.a.jg((Context)localObject1);
      if ((localObject2 == null) || (((Activity)localObject2).isFinishing())) {
        localObject1 = ai.getContext();
      }
      i.b((Context)localObject1, paramAppBrandInitConfigWC, paramAppBrandStatObject);
    }
    for (;;)
    {
      if (this.lpO) {
        boe();
      }
      this.lpN = true;
      if ((this.lpQ != null) && (this.lpQ.getLooper() != Looper.getMainLooper())) {
        this.lpQ.postToWorker(new Runnable()
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
      this.lpO = true;
    }
  }
  
  public final void boc()
  {
    this.lpM = true;
    this.lpP.clear();
    super.setBaseContext(ai.getContext());
  }
  
  protected final void boe()
  {
    Z(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(47421);
        ac.i("MicroMsg.AppBrand.Precondition.AbstractLaunchPreconditionProcess", "finishUiEnv InUiEnv");
        if ((a.this.getBaseContext() instanceof AppBrandLaunchProxyUI)) {
          ((AppBrandLaunchProxyUI)a.this.getBaseContext()).finish();
        }
        a.this.setBaseContext(ai.getContext());
        a.a(a.this);
        AppMethodBeat.o(47421);
      }
    });
  }
  
  protected Context bof()
  {
    return null;
  }
  
  protected final boolean bog()
  {
    return (bod()) && (((AppBrandLaunchProxyUI)getBaseContext()).isDestroyed());
  }
  
  protected boolean c(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    if (DebuggerShell.baW())
    {
      ac.i("MicroMsg.AppBrand.Precondition.AbstractLaunchPreconditionProcess", "shouldCheckTbsBeforeAppLaunch inMonkeyEnv");
      return true;
    }
    if ((com.tencent.mm.plugin.appbrand.task.f.QZ(paramAppBrandInitConfigWC.appId)) || (paramAppBrandInitConfigWC.CC())) {}
    for (int i = 1;; i = 0)
    {
      boolean bool = i | paramAppBrandInitConfigWC.jDv | com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.f.d(paramAppBrandInitConfigWC, paramAppBrandStatObject);
      i = bool;
      if (!paramAppBrandInitConfigWC.jDv)
      {
        i = bool;
        if (paramAppBrandInitConfigWC.jDy)
        {
          i = bool;
          if (com.tencent.mm.plugin.appbrand.f.a(paramAppBrandInitConfigWC)) {
            i = 0;
          }
        }
      }
      if (paramAppBrandInitConfigWC.CC()) {
        com.tencent.mm.plugin.expansions.a.cil();
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
    return (bod()) && (((AppBrandLaunchProxyUI)getBaseContext()).isFinishing());
  }
  
  public final void setBaseContext(Context paramContext)
  {
    super.setBaseContext(paramContext);
    if (bod())
    {
      if (this.lpM) {
        this.lpP.clear();
      }
    }
    else {
      return;
    }
    do
    {
      ((Runnable)this.lpP.poll()).run();
      if (this.lpP.isEmpty()) {
        break;
      }
    } while (bod());
    ac.e("MicroMsg.AppBrand.Precondition.AbstractLaunchPreconditionProcess", "fileAllPendingUiTasks but !currentInUiEnv, return");
    this.lpP.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.e.a
 * JD-Core Version:    0.7.0.1
 */