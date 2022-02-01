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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class a
  extends MutableContextWrapper
{
  private volatile boolean lRI = false;
  volatile boolean lRJ = false;
  protected boolean lRK = true;
  private final Queue<Runnable> lRL = new ConcurrentLinkedQueue();
  private aq lRM;
  
  public a()
  {
    super(ak.getContext());
  }
  
  private boolean bsH()
  {
    Object localObject = getBaseContext();
    if ((localObject instanceof AppBrandLaunchProxyUI))
    {
      localObject = (AppBrandLaunchProxyUI)localObject;
      return (!((AppBrandLaunchProxyUI)localObject).isDestroyed()) && (!((AppBrandLaunchProxyUI)localObject).isFinishing());
    }
    return false;
  }
  
  protected final void W(Runnable paramRunnable)
  {
    if (bsH())
    {
      ((Activity)getBaseContext()).runOnUiThread(paramRunnable);
      return;
    }
    if (this.lRI)
    {
      ae.e("MicroMsg.AppBrand.Precondition.AbstractLaunchPreconditionProcess", "runOnUiEnv but destroyed, clear mUiEnvQueue, call stack = %s", new Object[] { Log.getStackTraceString(new Throwable()) });
      this.lRL.clear();
      return;
    }
    this.lRL.offer(paramRunnable);
  }
  
  protected final void a(final LaunchParcel paramLaunchParcel, final String paramString)
  {
    aq localaq = new aq("AppBrandLaunchProxyUI-PrepareThread");
    this.lRM = localaq;
    localaq.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(47428);
        new com.tencent.mm.plugin.appbrand.launching.f(paramLaunchParcel, paramString, new e.a()new f.a {}, new f.a()
        {
          public final void brw()
          {
            AppMethodBeat.i(175006);
            ae.d("MicroMsg.AppBrand.Precondition.AbstractLaunchPreconditionProcess", "AppBrandPreLaunchProcessWC showPrompt, username[%s] appId[%s] currentInUiEnv[%b]", new Object[] { a.3.this.loI.username, a.3.this.loI.appId, Boolean.valueOf(a.b(a.this)) });
            a.this.W(new Runnable()
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
                  ae.d("MicroMsg.AppBrandLaunchProxyUI", "revealProgressLayoutImmediately destroyed[%b]", new Object[] { Boolean.valueOf(bool1) });
                  localAppBrandLaunchProxyUI.lIB.removeCallbacks(localAppBrandLaunchProxyUI.lIC);
                  localAppBrandLaunchProxyUI.lIB.post(localAppBrandLaunchProxyUI.lIC);
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
  
  public final void bsG()
  {
    this.lRI = true;
    this.lRL.clear();
    super.setBaseContext(ak.getContext());
  }
  
  protected final void bsI()
  {
    W(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(47421);
        ae.i("MicroMsg.AppBrand.Precondition.AbstractLaunchPreconditionProcess", "finishUiEnv InUiEnv");
        if ((a.this.getBaseContext() instanceof AppBrandLaunchProxyUI)) {
          ((AppBrandLaunchProxyUI)a.this.getBaseContext()).finish();
        }
        a.this.setBaseContext(ak.getContext());
        a.a(a.this);
        AppMethodBeat.o(47421);
      }
    });
  }
  
  protected Context bsJ()
  {
    return null;
  }
  
  protected final boolean bsK()
  {
    return (bsH()) && (((AppBrandLaunchProxyUI)getBaseContext()).isDestroyed());
  }
  
  protected void c(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    if (paramAppBrandInitConfigWC != null)
    {
      Object localObject2 = getBaseContext();
      Context localContext = bsJ();
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
      localObject2 = com.tencent.mm.sdk.f.a.jw((Context)localObject1);
      if ((localObject2 == null) || (((Activity)localObject2).isFinishing())) {
        localObject1 = ak.getContext();
      }
      i.b((Context)localObject1, paramAppBrandInitConfigWC, paramAppBrandStatObject);
    }
    for (;;)
    {
      if (this.lRK) {
        bsI();
      }
      this.lRJ = true;
      if ((this.lRM != null) && (this.lRM.getLooper() != Looper.getMainLooper())) {
        this.lRM.postToWorker(new Runnable()
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
      this.lRK = true;
    }
  }
  
  protected boolean d(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    if (DebuggerShell.bfe())
    {
      ae.i("MicroMsg.AppBrand.Precondition.AbstractLaunchPreconditionProcess", "shouldCheckTbsBeforeAppLaunch inMonkeyEnv");
      return true;
    }
    if ((com.tencent.mm.plugin.appbrand.task.f.Vq(paramAppBrandInitConfigWC.appId)) || (paramAppBrandInitConfigWC.Ee())) {}
    for (int i = 1;; i = 0)
    {
      boolean bool = i | paramAppBrandInitConfigWC.kaG | g.e(paramAppBrandInitConfigWC, paramAppBrandStatObject);
      i = bool;
      if (!paramAppBrandInitConfigWC.kaG)
      {
        i = bool;
        if (paramAppBrandInitConfigWC.kaJ)
        {
          i = bool;
          if (com.tencent.mm.plugin.appbrand.f.a(paramAppBrandInitConfigWC)) {
            i = 0;
          }
        }
      }
      if (paramAppBrandInitConfigWC.Ee()) {
        com.tencent.mm.plugin.expansions.a.cof();
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
    return (bsH()) && (((AppBrandLaunchProxyUI)getBaseContext()).isFinishing());
  }
  
  public final void setBaseContext(Context paramContext)
  {
    super.setBaseContext(paramContext);
    if (bsH())
    {
      if (this.lRI) {
        this.lRL.clear();
      }
    }
    else {
      return;
    }
    do
    {
      ((Runnable)this.lRL.poll()).run();
      if (this.lRL.isEmpty()) {
        break;
      }
    } while (bsH());
    ae.e("MicroMsg.AppBrand.Precondition.AbstractLaunchPreconditionProcess", "fileAllPendingUiTasks but !currentInUiEnv, return");
    this.lRL.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.e.a
 * JD-Core Version:    0.7.0.1
 */