package com.tencent.mm.plugin.appbrand.launching.precondition;

import a.f;
import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.gdpr.b;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.av;
import com.tencent.mm.plugin.appbrand.launching.av.1;
import com.tencent.mm.plugin.appbrand.launching.av.2;
import com.tencent.mm.plugin.appbrand.launching.f.a;
import com.tencent.mm.plugin.appbrand.launching.g.a;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.launching.teenmode.AppBrandTeenModeTempAuthMgr;
import com.tencent.mm.plugin.appbrand.launching.v;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.expansions.e;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.AvailabilityAlertSupplier;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.threadpool.h;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.ah;
import kotlin.g.a.m;

public abstract class a
  extends MutableContextWrapper
{
  private volatile boolean tef = false;
  volatile boolean teg = false;
  protected boolean teh = true;
  private final Queue<Runnable> tei = new ConcurrentLinkedQueue();
  private MMHandler tej;
  private LaunchParcel tek;
  
  public a()
  {
    super(MMApplicationContext.getContext());
  }
  
  private boolean cAP()
  {
    Object localObject = getBaseContext();
    if ((localObject instanceof AppBrandLaunchProxyUI))
    {
      localObject = (AppBrandLaunchProxyUI)localObject;
      return (!((AppBrandLaunchProxyUI)localObject).isDestroyed()) && (!((AppBrandLaunchProxyUI)localObject).isFinishing());
    }
    return false;
  }
  
  private Context cAS()
  {
    Object localObject1 = getBaseContext();
    Object localObject2 = cAR();
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
    this.tek = paramLaunchParcel;
    MMHandler localMMHandler = new MMHandler("AbstractLaunchPreconditionProcess$AppBrandLaunchProxyUI-PrepareThread");
    this.tej = localMMHandler;
    localMMHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(47428);
        final long l = Util.currentTicks();
        new com.tencent.mm.plugin.appbrand.launching.g(paramLaunchParcel, paramString, new f.a()new g.a {}, new g.a()
        {
          public final void showPrompt()
          {
            AppMethodBeat.i(175006);
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.Precondition.AbstractLaunchPreconditionProcess", "AppBrandPreLaunchProcessWC showPrompt, username[%s] appId[%s] currentInUiEnv[%b]", new Object[] { a.3.this.teo.username, a.3.this.teo.appId, Boolean.valueOf(a.e(a.this)) });
            a.this.al(new Runnable()
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
                  localAppBrandLaunchProxyUI.sVR.removeCallbacks(localAppBrandLaunchProxyUI.sVS);
                  localAppBrandLaunchProxyUI.sVR.post(localAppBrandLaunchProxyUI.sVS);
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
  
  protected final void al(Runnable paramRunnable)
  {
    if (cAP())
    {
      ((Activity)getBaseContext()).runOnUiThread(paramRunnable);
      return;
    }
    if (this.tef)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.Precondition.AbstractLaunchPreconditionProcess", "runOnUiEnv but destroyed, clear mUiEnvQueue, call stack = %s", new Object[] { android.util.Log.getStackTraceString(new Throwable()) });
      this.tei.clear();
      return;
    }
    this.tei.offer(paramRunnable);
  }
  
  protected void b(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    if (paramAppBrandInitConfigWC != null) {
      k.b(cAS(), paramAppBrandInitConfigWC, paramAppBrandStatObject);
    }
    for (;;)
    {
      if (this.teh) {
        cAQ();
      }
      this.teg = true;
      if (this.tej != null) {
        this.tej.removeCallbacksAndMessages(null);
      }
      return;
      this.teh = true;
      if (this.tek != null)
      {
        paramAppBrandInitConfigWC = v.sZx;
        paramAppBrandInitConfigWC = v.BX(this.tek.tee);
        if ((paramAppBrandInitConfigWC != null) && (paramAppBrandInitConfigWC.qAU != null)) {
          paramAppBrandInitConfigWC.qAU.ceq();
        }
      }
    }
  }
  
  protected boolean c(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    if (DebuggerShell.cls()) {
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrand.Precondition.AbstractLaunchPreconditionProcess", "shouldCheckTbsBeforeAppLaunch inMonkeyEnv");
    }
    label98:
    label102:
    for (;;)
    {
      return true;
      boolean bool1;
      if ((com.tencent.mm.plugin.appbrand.task.i.cJV().fA(paramAppBrandInitConfigWC.appId)) || (paramAppBrandInitConfigWC.aqJ()))
      {
        bool1 = true;
        bool2 = bool1 | com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.g.d(paramAppBrandInitConfigWC, paramAppBrandStatObject);
        bool1 = bool2;
        if (paramAppBrandInitConfigWC.qYd)
        {
          bool1 = bool2;
          if (com.tencent.mm.plugin.appbrand.i.a(paramAppBrandInitConfigWC)) {
            bool1 = false;
          }
        }
        if ((paramAppBrandInitConfigWC.aqJ()) && (!e.aQh())) {
          break label98;
        }
      }
      for (boolean bool2 = true;; bool2 = false)
      {
        if (!(bool1 & bool2)) {
          break label102;
        }
        return false;
        bool1 = false;
        break;
      }
    }
  }
  
  public final void cAO()
  {
    this.tef = true;
    this.tei.clear();
    super.setBaseContext(MMApplicationContext.getContext());
  }
  
  protected final void cAQ()
  {
    al(new Runnable()
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
  
  protected Context cAR()
  {
    return null;
  }
  
  protected final boolean cAT()
  {
    return (cAP()) && (((AppBrandLaunchProxyUI)getBaseContext()).isDestroyed());
  }
  
  protected final void finish()
  {
    b(null, null);
  }
  
  protected final boolean isFinishing()
  {
    return (cAP()) && (((AppBrandLaunchProxyUI)getBaseContext()).isFinishing());
  }
  
  public final void setBaseContext(Context paramContext)
  {
    super.setBaseContext(paramContext);
    if (cAP())
    {
      if (!this.tef) {
        break label46;
      }
      this.tei.clear();
    }
    for (;;)
    {
      return;
      try
      {
        label46:
        do
        {
          ((Runnable)this.tei.poll()).run();
          if (this.tei.isEmpty()) {
            break;
          }
        } while (cAP());
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.Precondition.AbstractLaunchPreconditionProcess", "fileAllPendingUiTasks but !currentInUiEnv, return");
        this.tei.clear();
        return;
      }
      catch (ClassCastException paramContext)
      {
        if (paramContext.getMessage().endsWith("cannot be cast to com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI"))
        {
          com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.AppBrand.Precondition.AbstractLaunchPreconditionProcess", paramContext, "mUiEnvQueue.poll().run()", new Object[0]);
          this.tei.clear();
          return;
        }
        throw paramContext;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.precondition.a
 * JD-Core Version:    0.7.0.1
 */