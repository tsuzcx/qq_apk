package com.tencent.mm.app;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public enum AppForegroundDelegate
{
  Handler azU;
  Handler cKF;
  private Runnable cKG;
  public final Set<o> cKH;
  b cKI;
  private boolean cKJ;
  private final Set<n> csT;
  public volatile boolean csU;
  volatile boolean csX;
  
  static
  {
    AppMethodBeat.i(131766);
    cKE = new AppForegroundDelegate("INSTANCE");
    cKK = new AppForegroundDelegate[] { cKE };
    AppMethodBeat.o(131766);
  }
  
  private AppForegroundDelegate()
  {
    AppMethodBeat.i(131761);
    this.azU = new Handler(Looper.getMainLooper());
    this.csT = new HashSet();
    this.cKH = new HashSet();
    this.csU = false;
    this.cKI = new b((byte)0);
    this.csX = false;
    this.cKJ = false;
    AppMethodBeat.o(131761);
  }
  
  public final boolean Kx()
  {
    return this.csU;
  }
  
  public final void a(n paramn)
  {
    AppMethodBeat.i(131762);
    if (this.csU) {
      paramn.onAppForeground(this.cKI.cKU.activity);
    }
    synchronized (this.csT)
    {
      this.csT.add(paramn);
      AppMethodBeat.o(131762);
      return;
    }
  }
  
  public final void b(n paramn)
  {
    AppMethodBeat.i(131763);
    synchronized (this.csT)
    {
      this.csT.remove(paramn);
      AppMethodBeat.o(131763);
      return;
    }
  }
  
  static enum a
  {
    private String value;
    
    static
    {
      AppMethodBeat.i(131741);
      cKM = new a("CREATED", 0, "com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVITY_CREATED");
      cKN = new a("STARTED", 1, "com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVITY_STARTED");
      cKO = new a("RESUMED", 2, "com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVITY_RESUMED");
      cKP = new a("PAUSED", 3, "com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVITY_PAUSED");
      cKQ = new a("STOPPED", 4, "com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVITY_STOPPED");
      cKR = new a("DESTROY", 5, "com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVITY_DESTROY");
      cKS = new a[] { cKM, cKN, cKO, cKP, cKQ, cKR };
      AppMethodBeat.o(131741);
    }
    
    private a(String paramString)
    {
      this.value = paramString;
    }
    
    public static a ev(String paramString)
    {
      AppMethodBeat.i(131740);
      if (paramString.equals(cKN.value))
      {
        paramString = cKN;
        AppMethodBeat.o(131740);
        return paramString;
      }
      if (paramString.equals(cKO.value))
      {
        paramString = cKO;
        AppMethodBeat.o(131740);
        return paramString;
      }
      if (paramString.equals(cKP.value))
      {
        paramString = cKP;
        AppMethodBeat.o(131740);
        return paramString;
      }
      if (paramString.equals(cKQ.value))
      {
        paramString = cKQ;
        AppMethodBeat.o(131740);
        return paramString;
      }
      AppMethodBeat.o(131740);
      return null;
    }
  }
  
  final class b
  {
    a cKT;
    AppForegroundDelegate.c cKU;
    
    private b()
    {
      AppMethodBeat.i(131755);
      this.cKT = new a((byte)0);
      this.cKU = new AppForegroundDelegate.c(AppForegroundDelegate.this, (byte)0);
      AppMethodBeat.o(131755);
    }
    
    final class a
      extends BroadcastReceiver
      implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2
    {
      private HashSet<String> cKV;
      
      private a()
      {
        AppMethodBeat.i(131745);
        this.cKV = new HashSet();
        AppMethodBeat.o(131745);
      }
      
      private static void a(AppForegroundDelegate.a parama, String paramString)
      {
        AppMethodBeat.i(131747);
        Intent localIntent = new Intent();
        localIntent.setAction(AppForegroundDelegate.a.a(parama));
        localIntent.putExtra("_application_context_process_", aj.getProcessName());
        localIntent.putExtra("com.tencent.mm.AppForegroundDelegate.ACTIVITY_NAME", paramString);
        aj.getContext().sendBroadcast(localIntent, "com.tencent.mm.permission.MM_MESSAGE");
        AppMethodBeat.o(131747);
      }
      
      private void a(final String paramString1, String paramString2, AppForegroundDelegate.a parama)
      {
        AppMethodBeat.i(131748);
        ad.i("MicroMsg.AppForegroundDelegate", "[checkAlive] activityName:%s process:%s action:%s", new Object[] { paramString1, paramString2, parama.name() });
        if (parama == AppForegroundDelegate.a.cKN)
        {
          if (!AppForegroundDelegate.c(AppForegroundDelegate.this)) {
            AppForegroundDelegate.c.c(true, paramString1);
          }
          this.cKV.remove(paramString1);
        }
        if (((parama == AppForegroundDelegate.a.cKM) || (parama == AppForegroundDelegate.a.cKN) || (parama == AppForegroundDelegate.a.cKO) || (parama == AppForegroundDelegate.a.cKP)) && (AppForegroundDelegate.f(AppForegroundDelegate.this) != null))
        {
          AppForegroundDelegate.g(AppForegroundDelegate.this).removeCallbacks(AppForegroundDelegate.f(AppForegroundDelegate.this));
          AppForegroundDelegate.a(AppForegroundDelegate.this, null);
        }
        if (parama == AppForegroundDelegate.a.cKO)
        {
          AppForegroundDelegate.g(AppForegroundDelegate.this).postDelayed(AppForegroundDelegate.a(AppForegroundDelegate.this, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(131743);
              if (!AppForegroundDelegate.c(AppForegroundDelegate.this)) {
                AppForegroundDelegate.c.c(true, paramString1);
              }
              AppMethodBeat.o(131743);
            }
          }), 600L);
          AppMethodBeat.o(131748);
          return;
        }
        if (parama == AppForegroundDelegate.a.cKP)
        {
          AppForegroundDelegate.g(AppForegroundDelegate.this).postDelayed(AppForegroundDelegate.a(AppForegroundDelegate.this, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(131744);
              if ((AppForegroundDelegate.c(AppForegroundDelegate.this)) && (AppForegroundDelegate.b.a.a(AppForegroundDelegate.b.a.this).remove(paramString1)))
              {
                AppForegroundDelegate.c.c(false, paramString1);
                AppMethodBeat.o(131744);
                return;
              }
              AppForegroundDelegate.a(AppForegroundDelegate.this, null);
              ad.w("MicroMsg.AppForegroundDelegate", "[PAUSED] delay to check background in stop!");
              AppMethodBeat.o(131744);
            }
          }), 600L);
          AppMethodBeat.o(131748);
          return;
        }
        if ((parama == AppForegroundDelegate.a.cKQ) || (parama == AppForegroundDelegate.a.cKR))
        {
          if (parama == AppForegroundDelegate.a.cKQ) {
            this.cKV.add(paramString1);
          }
          if (AppForegroundDelegate.f(AppForegroundDelegate.this) == null) {
            AppForegroundDelegate.g(AppForegroundDelegate.this).postDelayed(AppForegroundDelegate.a(AppForegroundDelegate.this, new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(182866);
                if (AppForegroundDelegate.c(AppForegroundDelegate.this)) {
                  AppForegroundDelegate.c.c(false, paramString1);
                }
                AppMethodBeat.o(182866);
              }
            }), 600L);
          }
        }
        AppMethodBeat.o(131748);
      }
      
      public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
      {
        AppMethodBeat.i(131749);
        paramActivity = paramActivity.getClass().getName() + "@" + paramActivity.hashCode();
        if (aj.cbe())
        {
          a(paramActivity, aj.getProcessName(), AppForegroundDelegate.a.cKM);
          AppMethodBeat.o(131749);
          return;
        }
        a(AppForegroundDelegate.a.cKM, paramActivity);
        AppMethodBeat.o(131749);
      }
      
      public final void onActivityDestroyed(Activity paramActivity)
      {
        AppMethodBeat.i(131754);
        paramActivity = paramActivity.getClass().getName() + "@" + paramActivity.hashCode();
        if (aj.cbe())
        {
          a(paramActivity, aj.getProcessName(), AppForegroundDelegate.a.cKR);
          AppMethodBeat.o(131754);
          return;
        }
        a(AppForegroundDelegate.a.cKR, paramActivity);
        AppMethodBeat.o(131754);
      }
      
      public final void onActivityPaused(Activity paramActivity)
      {
        AppMethodBeat.i(131752);
        paramActivity = paramActivity.getClass().getName() + "@" + paramActivity.hashCode();
        if (aj.cbe())
        {
          a(paramActivity, aj.getProcessName(), AppForegroundDelegate.a.cKP);
          AppMethodBeat.o(131752);
          return;
        }
        a(AppForegroundDelegate.a.cKP, paramActivity);
        AppMethodBeat.o(131752);
      }
      
      public final void onActivityResumed(Activity paramActivity)
      {
        AppMethodBeat.i(131751);
        paramActivity = paramActivity.getClass().getName() + "@" + paramActivity.hashCode();
        if (aj.cbe())
        {
          a(paramActivity, aj.getProcessName(), AppForegroundDelegate.a.cKO);
          AppMethodBeat.o(131751);
          return;
        }
        a(AppForegroundDelegate.a.cKO, paramActivity);
        AppMethodBeat.o(131751);
      }
      
      public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
      
      public final void onActivityStarted(Activity paramActivity)
      {
        AppMethodBeat.i(131750);
        paramActivity = paramActivity.getClass().getName() + "@" + paramActivity.hashCode();
        if (aj.cbe())
        {
          a(paramActivity, aj.getProcessName(), AppForegroundDelegate.a.cKN);
          AppMethodBeat.o(131750);
          return;
        }
        a(AppForegroundDelegate.a.cKN, paramActivity);
        AppMethodBeat.o(131750);
      }
      
      public final void onActivityStopped(Activity paramActivity)
      {
        AppMethodBeat.i(131753);
        paramActivity = paramActivity.getClass().getName() + "@" + paramActivity.hashCode();
        if (aj.cbe())
        {
          a(paramActivity, aj.getProcessName(), AppForegroundDelegate.a.cKQ);
          AppMethodBeat.o(131753);
          return;
        }
        a(AppForegroundDelegate.a.cKQ, paramActivity);
        AppMethodBeat.o(131753);
      }
      
      public final void onConfigurationChanged(Configuration paramConfiguration) {}
      
      public final void onLowMemory() {}
      
      public final void onReceive(Context paramContext, Intent paramIntent)
      {
        AppMethodBeat.i(131746);
        if (paramIntent == null)
        {
          AppMethodBeat.o(131746);
          return;
        }
        paramContext = paramIntent.getAction();
        if (("android.intent.action.SCREEN_OFF".equals(paramContext)) || ("android.intent.action.SCREEN_ON".equals(paramContext)))
        {
          ad.i("MicroMsg.AppForegroundDelegate", "ACTION_SCREEN:%s", new Object[] { paramContext });
          if ("android.intent.action.SCREEN_OFF".equals(paramContext)) {
            AppForegroundDelegate.a(AppForegroundDelegate.this, true);
          }
          for (;;)
          {
            h.Iye.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(131742);
                synchronized (AppForegroundDelegate.d(AppForegroundDelegate.this))
                {
                  LinkedList localLinkedList = new LinkedList(AppForegroundDelegate.d(AppForegroundDelegate.this));
                  ??? = localLinkedList.iterator();
                  if (((Iterator)???).hasNext()) {
                    ((o)((Iterator)???).next()).ca(AppForegroundDelegate.e(AppForegroundDelegate.this));
                  }
                }
                AppMethodBeat.o(131742);
              }
            }, "MicroMsg.AppForegroundDelegate");
            AppMethodBeat.o(131746);
            return;
            AppForegroundDelegate.a(AppForegroundDelegate.this, false);
          }
        }
        paramContext = AppForegroundDelegate.a.ev(paramContext);
        if (paramContext != null)
        {
          String str = paramIntent.getStringExtra("_application_context_process_");
          a(paramIntent.getStringExtra("com.tencent.mm.AppForegroundDelegate.ACTIVITY_NAME"), str, paramContext);
        }
        AppMethodBeat.o(131746);
      }
      
      public final void onTrimMemory(int paramInt) {}
    }
  }
  
  final class c
    extends BroadcastReceiver
  {
    public String activity;
    
    private c() {}
    
    public static void c(boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(131757);
      Intent localIntent = new Intent();
      if (paramBoolean) {}
      for (String str = "com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVE";; str = "com.tencent.mm.AppForegroundDelegate.ACTION_DEAD")
      {
        localIntent.setAction(str);
        localIntent.putExtra("com.tencent.mm.AppForegroundDelegate.ACTIVITY_NAME", paramString);
        aj.getContext().sendBroadcast(localIntent, "com.tencent.mm.permission.MM_MESSAGE");
        AppMethodBeat.o(131757);
        return;
      }
    }
    
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(131756);
      if (paramIntent == null)
      {
        AppMethodBeat.o(131756);
        return;
      }
      paramContext = paramIntent.getAction();
      this.activity = paramIntent.getStringExtra("com.tencent.mm.AppForegroundDelegate.ACTIVITY_NAME");
      if ("com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVE".equalsIgnoreCase(paramContext))
      {
        AppForegroundDelegate.a(AppForegroundDelegate.this, this.activity);
        AppMethodBeat.o(131756);
        return;
      }
      AppForegroundDelegate.b(AppForegroundDelegate.this, this.activity);
      AppMethodBeat.o(131756);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.AppForegroundDelegate
 * JD-Core Version:    0.7.0.1
 */