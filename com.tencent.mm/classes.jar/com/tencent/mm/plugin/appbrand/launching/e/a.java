package com.tencent.mm.plugin.appbrand.launching.e;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.os.Looper;
import android.support.v4.e.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.ab;
import com.tencent.mm.plugin.appbrand.launching.av;
import com.tencent.mm.plugin.appbrand.launching.e.a;
import com.tencent.mm.plugin.appbrand.launching.f.a;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.launching.u;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.plugin.appbrand.task.p;
import com.tencent.mm.plugin.appbrand.ui.AppBrandXWebDownloadProxyUI;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.AvailabilityAlertSupplier;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.xwalk.core.XWalkEnvironment;

public abstract class a
  extends MutableContextWrapper
{
  private volatile boolean mYT = false;
  volatile boolean mYU = false;
  protected boolean mYV = true;
  private final Queue<Runnable> mYW = new ConcurrentLinkedQueue();
  private MMHandler mYX;
  private LaunchParcel mYY;
  
  public a()
  {
    super(MMApplicationContext.getContext());
  }
  
  private boolean bOd()
  {
    Object localObject = getBaseContext();
    if ((localObject instanceof AppBrandLaunchProxyUI))
    {
      localObject = (AppBrandLaunchProxyUI)localObject;
      return (!((AppBrandLaunchProxyUI)localObject).isDestroyed()) && (!((AppBrandLaunchProxyUI)localObject).isFinishing());
    }
    return false;
  }
  
  private Context bOg()
  {
    Object localObject1 = getBaseContext();
    Object localObject2 = bOf();
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
  
  protected final void a(final LaunchParcel paramLaunchParcel, final String paramString)
  {
    MMHandler localMMHandler = new MMHandler("AppBrandLaunchProxyUI-PrepareThread");
    this.mYX = localMMHandler;
    localMMHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(47428);
        new com.tencent.mm.plugin.appbrand.launching.f(paramLaunchParcel, paramString, new e.a()new f.a {}, new f.a()
        {
          public final void bto()
          {
            AppMethodBeat.i(175006);
            com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AppBrand.Precondition.AbstractLaunchPreconditionProcess", "AppBrandPreLaunchProcessWC showPrompt, username[%s] appId[%s] currentInUiEnv[%b]", new Object[] { a.3.this.mZb.username, a.3.this.mZb.appId, Boolean.valueOf(a.c(a.this)) });
            a.this.ab(new Runnable()
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
                  localAppBrandLaunchProxyUI.mQp.removeCallbacks(localAppBrandLaunchProxyUI.mQq);
                  localAppBrandLaunchProxyUI.mQp.post(localAppBrandLaunchProxyUI.mQq);
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
  
  protected final void ab(Runnable paramRunnable)
  {
    if (bOd())
    {
      ((Activity)getBaseContext()).runOnUiThread(paramRunnable);
      return;
    }
    if (this.mYT)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.Precondition.AbstractLaunchPreconditionProcess", "runOnUiEnv but destroyed, clear mUiEnvQueue, call stack = %s", new Object[] { android.util.Log.getStackTraceString(new Throwable()) });
      this.mYW.clear();
      return;
    }
    this.mYW.offer(paramRunnable);
  }
  
  public final void bOc()
  {
    this.mYT = true;
    this.mYW.clear();
    super.setBaseContext(MMApplicationContext.getContext());
  }
  
  protected final void bOe()
  {
    ab(new Runnable()
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
  
  protected Context bOf()
  {
    return null;
  }
  
  protected final boolean bOh()
  {
    return (bOd()) && (((AppBrandLaunchProxyUI)getBaseContext()).isDestroyed());
  }
  
  protected void c(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    if (paramAppBrandInitConfigWC != null) {
      i.b(bOg(), paramAppBrandInitConfigWC, paramAppBrandStatObject);
    }
    for (;;)
    {
      if (this.mYV) {
        bOe();
      }
      this.mYU = true;
      if ((this.mYX != null) && (this.mYX.getLooper() != Looper.getMainLooper())) {
        this.mYX.postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(47429);
            a.d(a.this).quit();
            AppMethodBeat.o(47429);
          }
        });
      }
      return;
      this.mYV = true;
      if (this.mYY != null)
      {
        paramAppBrandInitConfigWC = u.mTD;
        paramAppBrandInitConfigWC = u.yi(this.mYY.mYS);
        if ((paramAppBrandInitConfigWC != null) && (paramAppBrandInitConfigWC.kHN != null)) {
          paramAppBrandInitConfigWC.kHN.bud();
        }
      }
    }
  }
  
  protected boolean d(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    if (DebuggerShell.bAx())
    {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.Precondition.AbstractLaunchPreconditionProcess", "shouldCheckTbsBeforeAppLaunch inMonkeyEnv");
      return true;
    }
    if ((h.bWb().afi(paramAppBrandInitConfigWC.appId)) || (paramAppBrandInitConfigWC.NA())) {}
    for (int i = 1;; i = 0)
    {
      boolean bool = i | paramAppBrandInitConfigWC.ldK | com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.g.e(paramAppBrandInitConfigWC, paramAppBrandStatObject);
      i = bool;
      if (!paramAppBrandInitConfigWC.ldK)
      {
        i = bool;
        if (paramAppBrandInitConfigWC.ldN)
        {
          i = bool;
          if (com.tencent.mm.plugin.appbrand.f.a(paramAppBrandInitConfigWC)) {
            i = 0;
          }
        }
      }
      if (paramAppBrandInitConfigWC.NA()) {
        com.tencent.mm.plugin.expansions.a.cMr();
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
    return (bOd()) && (((AppBrandLaunchProxyUI)getBaseContext()).isFinishing());
  }
  
  public final void setBaseContext(Context paramContext)
  {
    super.setBaseContext(paramContext);
    if (bOd())
    {
      if (!this.mYT) {
        break label46;
      }
      this.mYW.clear();
    }
    for (;;)
    {
      return;
      try
      {
        label46:
        do
        {
          ((Runnable)this.mYW.poll()).run();
          if (this.mYW.isEmpty()) {
            break;
          }
        } while (bOd());
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.Precondition.AbstractLaunchPreconditionProcess", "fileAllPendingUiTasks but !currentInUiEnv, return");
        this.mYW.clear();
        return;
      }
      catch (ClassCastException paramContext)
      {
        while (!paramContext.getMessage().endsWith("cannot be cast to com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI")) {}
        com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.AppBrand.Precondition.AbstractLaunchPreconditionProcess", paramContext, "mUiEnvQueue.poll().run()", new Object[0]);
        this.mYW.clear();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.e.a
 * JD-Core Version:    0.7.0.1
 */