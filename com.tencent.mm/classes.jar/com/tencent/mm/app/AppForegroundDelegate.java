package com.tencent.mm.app;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks2;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public enum AppForegroundDelegate
{
  Handler aAO;
  Handler cHN;
  private Runnable cHO;
  public final Set<o> cHP;
  b cHQ;
  private boolean cHR;
  private final Set<n> cqb;
  public volatile boolean cqc;
  volatile boolean cqf;
  
  static
  {
    AppMethodBeat.i(131766);
    cHM = new AppForegroundDelegate("INSTANCE");
    cHS = new AppForegroundDelegate[] { cHM };
    AppMethodBeat.o(131766);
  }
  
  private AppForegroundDelegate()
  {
    AppMethodBeat.i(131761);
    this.aAO = new Handler(Looper.getMainLooper());
    this.cqb = new HashSet();
    this.cHP = new HashSet();
    this.cqc = false;
    this.cHQ = new b((byte)0);
    this.cqf = false;
    this.cHR = false;
    AppMethodBeat.o(131761);
  }
  
  public final String Kh()
  {
    return this.cHQ.cIc.activity;
  }
  
  public final boolean Ki()
  {
    return this.cqc;
  }
  
  public final void a(n paramn)
  {
    AppMethodBeat.i(131762);
    if (this.cqc) {
      paramn.onAppForeground(this.cHQ.cIc.activity);
    }
    synchronized (this.cqb)
    {
      this.cqb.add(paramn);
      AppMethodBeat.o(131762);
      return;
    }
  }
  
  public final void b(n paramn)
  {
    AppMethodBeat.i(131763);
    synchronized (this.cqb)
    {
      this.cqb.remove(paramn);
      AppMethodBeat.o(131763);
      return;
    }
  }
  
  public static class Provider
    extends ContentProvider
  {
    public Bundle call(String paramString1, String paramString2, Bundle paramBundle)
    {
      AppMethodBeat.i(131758);
      if (paramString1.equals("isAppForeground"))
      {
        paramString1 = new Bundle();
        paramString1.putString("com.tencent.mm.AppForegroundDelegate.ACTIVITY_NAME", AppForegroundDelegate.a(AppForegroundDelegate.cHM).cIc.activity);
        paramString1.putBoolean("isAppForeground", AppForegroundDelegate.c(AppForegroundDelegate.cHM));
        AppMethodBeat.o(131758);
        return paramString1;
      }
      paramString1 = super.call(paramString1, paramString2, paramBundle);
      AppMethodBeat.o(131758);
      return paramString1;
    }
    
    public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
    {
      return 0;
    }
    
    public String getType(Uri paramUri)
    {
      return null;
    }
    
    public Uri insert(Uri paramUri, ContentValues paramContentValues)
    {
      return null;
    }
    
    public boolean onCreate()
    {
      return true;
    }
    
    public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
    {
      return null;
    }
    
    public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
    {
      return 0;
    }
  }
  
  static enum a
  {
    private String value;
    
    static
    {
      AppMethodBeat.i(131741);
      cHU = new a("CREATED", 0, "com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVITY_CREATED");
      cHV = new a("STARTED", 1, "com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVITY_STARTED");
      cHW = new a("RESUMED", 2, "com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVITY_RESUMED");
      cHX = new a("PAUSED", 3, "com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVITY_PAUSED");
      cHY = new a("STOPPED", 4, "com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVITY_STOPPED");
      cHZ = new a("DESTROY", 5, "com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVITY_DESTROY");
      cIa = new a[] { cHU, cHV, cHW, cHX, cHY, cHZ };
      AppMethodBeat.o(131741);
    }
    
    private a(String paramString)
    {
      this.value = paramString;
    }
    
    public static a ek(String paramString)
    {
      AppMethodBeat.i(131740);
      if (paramString.equals(cHV.value))
      {
        paramString = cHV;
        AppMethodBeat.o(131740);
        return paramString;
      }
      if (paramString.equals(cHW.value))
      {
        paramString = cHW;
        AppMethodBeat.o(131740);
        return paramString;
      }
      if (paramString.equals(cHX.value))
      {
        paramString = cHX;
        AppMethodBeat.o(131740);
        return paramString;
      }
      if (paramString.equals(cHY.value))
      {
        paramString = cHY;
        AppMethodBeat.o(131740);
        return paramString;
      }
      AppMethodBeat.o(131740);
      return null;
    }
  }
  
  final class b
  {
    a cIb;
    AppForegroundDelegate.c cIc;
    
    private b()
    {
      AppMethodBeat.i(131755);
      this.cIb = new a((byte)0);
      this.cIc = new AppForegroundDelegate.c(AppForegroundDelegate.this, (byte)0);
      AppMethodBeat.o(131755);
    }
    
    final class a
      extends BroadcastReceiver
      implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2
    {
      private HashSet<String> cId;
      
      private a()
      {
        AppMethodBeat.i(131745);
        this.cId = new HashSet();
        AppMethodBeat.o(131745);
      }
      
      private static void a(AppForegroundDelegate.a parama, String paramString)
      {
        AppMethodBeat.i(131747);
        Intent localIntent = new Intent();
        localIntent.setAction(AppForegroundDelegate.a.a(parama));
        localIntent.putExtra("_application_context_process_", ai.getProcessName());
        localIntent.putExtra("com.tencent.mm.AppForegroundDelegate.ACTIVITY_NAME", paramString);
        ai.getContext().sendBroadcast(localIntent, "com.tencent.mm.permission.MM_MESSAGE");
        AppMethodBeat.o(131747);
      }
      
      private void a(final String paramString1, String paramString2, AppForegroundDelegate.a parama)
      {
        AppMethodBeat.i(131748);
        ac.i("MicroMsg.AppForegroundDelegate", "[checkAlive] activityName:%s process:%s action:%s", new Object[] { paramString1, paramString2, parama.name() });
        if (parama == AppForegroundDelegate.a.cHV)
        {
          if (!AppForegroundDelegate.c(AppForegroundDelegate.this)) {
            AppForegroundDelegate.c.c(true, paramString1);
          }
          this.cId.remove(paramString1);
        }
        if (((parama == AppForegroundDelegate.a.cHU) || (parama == AppForegroundDelegate.a.cHV) || (parama == AppForegroundDelegate.a.cHW) || (parama == AppForegroundDelegate.a.cHX)) && (AppForegroundDelegate.f(AppForegroundDelegate.this) != null))
        {
          AppForegroundDelegate.g(AppForegroundDelegate.this).removeCallbacks(AppForegroundDelegate.f(AppForegroundDelegate.this));
          AppForegroundDelegate.a(AppForegroundDelegate.this, null);
        }
        if (parama == AppForegroundDelegate.a.cHW)
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
        if (parama == AppForegroundDelegate.a.cHX)
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
              ac.w("MicroMsg.AppForegroundDelegate", "[PAUSED] delay to check background in stop!");
              AppMethodBeat.o(131744);
            }
          }), 600L);
          AppMethodBeat.o(131748);
          return;
        }
        if ((parama == AppForegroundDelegate.a.cHY) || (parama == AppForegroundDelegate.a.cHZ))
        {
          if (parama == AppForegroundDelegate.a.cHY) {
            this.cId.add(paramString1);
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
        if (ai.cin())
        {
          a(paramActivity, ai.getProcessName(), AppForegroundDelegate.a.cHU);
          AppMethodBeat.o(131749);
          return;
        }
        a(AppForegroundDelegate.a.cHU, paramActivity);
        AppMethodBeat.o(131749);
      }
      
      public final void onActivityDestroyed(Activity paramActivity)
      {
        AppMethodBeat.i(131754);
        paramActivity = paramActivity.getClass().getName() + "@" + paramActivity.hashCode();
        if (ai.cin())
        {
          a(paramActivity, ai.getProcessName(), AppForegroundDelegate.a.cHZ);
          AppMethodBeat.o(131754);
          return;
        }
        a(AppForegroundDelegate.a.cHZ, paramActivity);
        AppMethodBeat.o(131754);
      }
      
      public final void onActivityPaused(Activity paramActivity)
      {
        AppMethodBeat.i(131752);
        paramActivity = paramActivity.getClass().getName() + "@" + paramActivity.hashCode();
        if (ai.cin())
        {
          a(paramActivity, ai.getProcessName(), AppForegroundDelegate.a.cHX);
          AppMethodBeat.o(131752);
          return;
        }
        a(AppForegroundDelegate.a.cHX, paramActivity);
        AppMethodBeat.o(131752);
      }
      
      public final void onActivityResumed(Activity paramActivity)
      {
        AppMethodBeat.i(131751);
        paramActivity = paramActivity.getClass().getName() + "@" + paramActivity.hashCode();
        if (ai.cin())
        {
          a(paramActivity, ai.getProcessName(), AppForegroundDelegate.a.cHW);
          AppMethodBeat.o(131751);
          return;
        }
        a(AppForegroundDelegate.a.cHW, paramActivity);
        AppMethodBeat.o(131751);
      }
      
      public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
      
      public final void onActivityStarted(Activity paramActivity)
      {
        AppMethodBeat.i(131750);
        paramActivity = paramActivity.getClass().getName() + "@" + paramActivity.hashCode();
        if (ai.cin())
        {
          a(paramActivity, ai.getProcessName(), AppForegroundDelegate.a.cHV);
          AppMethodBeat.o(131750);
          return;
        }
        a(AppForegroundDelegate.a.cHV, paramActivity);
        AppMethodBeat.o(131750);
      }
      
      public final void onActivityStopped(Activity paramActivity)
      {
        AppMethodBeat.i(131753);
        paramActivity = paramActivity.getClass().getName() + "@" + paramActivity.hashCode();
        if (ai.cin())
        {
          a(paramActivity, ai.getProcessName(), AppForegroundDelegate.a.cHY);
          AppMethodBeat.o(131753);
          return;
        }
        a(AppForegroundDelegate.a.cHY, paramActivity);
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
          ac.i("MicroMsg.AppForegroundDelegate", "ACTION_SCREEN:%s", new Object[] { paramContext });
          if ("android.intent.action.SCREEN_OFF".equals(paramContext)) {
            AppForegroundDelegate.a(AppForegroundDelegate.this, true);
          }
          for (;;)
          {
            h.JZN.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(131742);
                synchronized (AppForegroundDelegate.d(AppForegroundDelegate.this))
                {
                  LinkedList localLinkedList = new LinkedList(AppForegroundDelegate.d(AppForegroundDelegate.this));
                  ??? = localLinkedList.iterator();
                  if (((Iterator)???).hasNext()) {
                    ((o)((Iterator)???).next()).cb(AppForegroundDelegate.e(AppForegroundDelegate.this));
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
        paramContext = AppForegroundDelegate.a.ek(paramContext);
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
        ai.getContext().sendBroadcast(localIntent, "com.tencent.mm.permission.MM_MESSAGE");
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