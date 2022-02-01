package com.tencent.mm.plugin.appbrand.launching.e;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.os.Looper;
import com.tencent.luggage.sdk.processes.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.at;
import com.tencent.mm.plugin.appbrand.launching.d.a;
import com.tencent.mm.plugin.appbrand.launching.e;
import com.tencent.mm.plugin.appbrand.launching.e.a;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.launching.t;
import com.tencent.mm.plugin.appbrand.launching.z;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.AppBrandXWebDownloadProxyUI;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.xwalk.core.XWalkEnvironment;

public abstract class a
  extends MutableContextWrapper
{
  private volatile boolean pZr = false;
  volatile boolean pZs = false;
  protected boolean pZt = true;
  private final Queue<Runnable> pZu = new ConcurrentLinkedQueue();
  private MMHandler pZv;
  private LaunchParcel pZw;
  
  public a()
  {
    super(MMApplicationContext.getContext());
  }
  
  private Context caA()
  {
    Object localObject1 = getBaseContext();
    Object localObject2 = caz();
    if ((!(localObject1 instanceof Activity)) && (localObject2 != null)) {
      localObject1 = localObject2;
    }
    for (;;)
    {
      localObject2 = AndroidContextUtil.castActivityOrNull((Context)localObject1);
      if ((localObject2 == null) || (((Activity)localObject2).isFinishing())) {
        localObject1 = MMApplicationContext.getContext();
      }
      return localObject1;
    }
  }
  
  private boolean cax()
  {
    Object localObject = getBaseContext();
    if ((localObject instanceof AppBrandLaunchProxyUI))
    {
      localObject = (AppBrandLaunchProxyUI)localObject;
      return (!((AppBrandLaunchProxyUI)localObject).isDestroyed()) && (!((AppBrandLaunchProxyUI)localObject).isFinishing());
    }
    return false;
  }
  
  protected final void a(final LaunchParcel paramLaunchParcel, final String paramString)
  {
    this.pZw = paramLaunchParcel;
    MMHandler localMMHandler = new MMHandler("AppBrandLaunchProxyUI-PrepareThread");
    this.pZv = localMMHandler;
    localMMHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(47428);
        new e(paramLaunchParcel, paramString, new d.a()new e.a {}, new e.a()
        {
          public final void bEl()
          {
            AppMethodBeat.i(175006);
            com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AppBrand.Precondition.AbstractLaunchPreconditionProcess", "AppBrandPreLaunchProcessWC showPrompt, username[%s] appId[%s] currentInUiEnv[%b]", new Object[] { a.3.this.pZz.username, a.3.this.pZz.appId, Boolean.valueOf(a.d(a.this)) });
            a.this.ae(new Runnable()
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
                  com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AppBrandLaunchProxyUI", "revealProgressLayoutImmediately destroyed[%b]", new Object[] { Boolean.valueOf(bool1) });
                  localAppBrandLaunchProxyUI.pRi.removeCallbacks(localAppBrandLaunchProxyUI.pRj);
                  localAppBrandLaunchProxyUI.pRi.post(localAppBrandLaunchProxyUI.pRj);
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
  
  protected final void ae(Runnable paramRunnable)
  {
    if (cax())
    {
      ((Activity)getBaseContext()).runOnUiThread(paramRunnable);
      return;
    }
    if (this.pZr)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.Precondition.AbstractLaunchPreconditionProcess", "runOnUiEnv but destroyed, clear mUiEnvQueue, call stack = %s", new Object[] { android.util.Log.getStackTraceString(new Throwable()) });
      this.pZu.clear();
      return;
    }
    this.pZu.offer(paramRunnable);
  }
  
  protected void c(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    if (paramAppBrandInitConfigWC != null) {
      i.b(caA(), paramAppBrandInitConfigWC, paramAppBrandStatObject);
    }
    for (;;)
    {
      if (this.pZt) {
        cay();
      }
      this.pZs = true;
      if (this.pZv != null) {
        this.pZv.removeCallbacksAndMessages(null);
      }
      return;
      this.pZt = true;
      if (this.pZw != null)
      {
        paramAppBrandInitConfigWC = t.pUE;
        paramAppBrandInitConfigWC = t.BI(this.pZw.pZq);
        if ((paramAppBrandInitConfigWC != null) && (paramAppBrandInitConfigWC.nBG != null)) {
          paramAppBrandInitConfigWC.nBG.bFd();
        }
      }
    }
  }
  
  protected final boolean caB()
  {
    return (cax()) && (((AppBrandLaunchProxyUI)getBaseContext()).isDestroyed());
  }
  
  public final void caw()
  {
    this.pZr = true;
    this.pZu.clear();
    super.setBaseContext(MMApplicationContext.getContext());
  }
  
  protected final void cay()
  {
    ae(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(47421);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.Precondition.AbstractLaunchPreconditionProcess", "finishUiEnv InUiEnv");
        if ((a.this.getBaseContext() instanceof AppBrandLaunchProxyUI)) {
          ((AppBrandLaunchProxyUI)a.this.getBaseContext()).finish();
        }
        a.this.setBaseContext(MMApplicationContext.getContext());
        a.a(a.this);
        AppMethodBeat.o(47421);
      }
    });
  }
  
  protected Context caz()
  {
    return null;
  }
  
  protected boolean d(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    if (DebuggerShell.bLS())
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.Precondition.AbstractLaunchPreconditionProcess", "shouldCheckTbsBeforeAppLaunch inMonkeyEnv");
      return true;
    }
    if ((com.tencent.mm.plugin.appbrand.task.i.cjb().w(paramAppBrandInitConfigWC.appId, -1)) || (paramAppBrandInitConfigWC.Qv())) {}
    for (int i = 1;; i = 0)
    {
      boolean bool = i | paramAppBrandInitConfigWC.nXY | com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.g.e(paramAppBrandInitConfigWC, paramAppBrandStatObject);
      i = bool;
      if (!paramAppBrandInitConfigWC.nXY)
      {
        i = bool;
        if (paramAppBrandInitConfigWC.nYb)
        {
          i = bool;
          if (com.tencent.mm.plugin.appbrand.i.a(paramAppBrandInitConfigWC)) {
            i = 0;
          }
        }
      }
      if (paramAppBrandInitConfigWC.Qv()) {
        com.tencent.mm.plugin.expansions.a.dbf();
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
    return (cax()) && (((AppBrandLaunchProxyUI)getBaseContext()).isFinishing());
  }
  
  public final void setBaseContext(Context paramContext)
  {
    super.setBaseContext(paramContext);
    if (cax())
    {
      if (!this.pZr) {
        break label46;
      }
      this.pZu.clear();
    }
    for (;;)
    {
      return;
      try
      {
        label46:
        do
        {
          ((Runnable)this.pZu.poll()).run();
          if (this.pZu.isEmpty()) {
            break;
          }
        } while (cax());
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.Precondition.AbstractLaunchPreconditionProcess", "fileAllPendingUiTasks but !currentInUiEnv, return");
        this.pZu.clear();
        return;
      }
      catch (ClassCastException paramContext)
      {
        if (paramContext.getMessage().endsWith("cannot be cast to com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI"))
        {
          com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.AppBrand.Precondition.AbstractLaunchPreconditionProcess", paramContext, "mUiEnvQueue.poll().run()", new Object[0]);
          this.pZu.clear();
          return;
        }
        throw paramContext;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.e.a
 * JD-Core Version:    0.7.0.1
 */