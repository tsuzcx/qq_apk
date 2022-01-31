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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public enum AppForegroundDelegate
{
  private Set<j> bLQ;
  public volatile boolean bLR;
  volatile boolean bRB;
  Handler bTu;
  private Runnable bXl;
  b bXm;
  private boolean bXn;
  
  static
  {
    AppMethodBeat.i(146094);
    bXk = new AppForegroundDelegate("INSTANCE");
    bXo = new AppForegroundDelegate[] { bXk };
    AppMethodBeat.o(146094);
  }
  
  private AppForegroundDelegate()
  {
    AppMethodBeat.i(146089);
    this.bTu = new Handler(Looper.getMainLooper());
    this.bLQ = new HashSet();
    this.bLR = false;
    this.bXm = new b((byte)0);
    this.bRB = false;
    this.bXn = false;
    AppMethodBeat.o(146089);
  }
  
  public final boolean AX()
  {
    return this.bLR;
  }
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(146090);
    if (this.bLR) {
      paramj.onAppForeground(this.bXm.bXz.activity);
    }
    synchronized (this.bLQ)
    {
      this.bLQ.add(paramj);
      AppMethodBeat.o(146090);
      return;
    }
  }
  
  public final void b(j paramj)
  {
    AppMethodBeat.i(146091);
    synchronized (this.bLQ)
    {
      this.bLQ.remove(paramj);
      AppMethodBeat.o(146091);
      return;
    }
  }
  
  public static class Provider
    extends ContentProvider
  {
    public Bundle call(String paramString1, String paramString2, Bundle paramBundle)
    {
      AppMethodBeat.i(146086);
      if (paramString1.equals("isAppForeground"))
      {
        paramString1 = new Bundle();
        paramString1.putString("com.tencent.mm.AppForegroundDelegate.ACTIVITY_NAME", AppForegroundDelegate.a(AppForegroundDelegate.bXk).bXz.activity);
        paramString1.putBoolean("isAppForeground", AppForegroundDelegate.c(AppForegroundDelegate.bXk));
        AppMethodBeat.o(146086);
        return paramString1;
      }
      paramString1 = super.call(paramString1, paramString2, paramBundle);
      AppMethodBeat.o(146086);
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
      AppMethodBeat.i(146069);
      bXr = new a("CREATED", 0, "com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVITY_CREATED");
      bXs = new a("STARTED", 1, "com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVITY_STARTED");
      bXt = new a("RESUMED", 2, "com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVITY_RESUMED");
      bXu = new a("PAUSED", 3, "com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVITY_PAUSED");
      bXv = new a("STOPPED", 4, "com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVITY_STOPPED");
      bXw = new a("DESTROY", 5, "com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVITY_DESTROY");
      bXx = new a[] { bXr, bXs, bXt, bXu, bXv, bXw };
      AppMethodBeat.o(146069);
    }
    
    private a(String paramString)
    {
      this.value = paramString;
    }
    
    public static a ds(String paramString)
    {
      AppMethodBeat.i(146068);
      if (paramString.equals(bXs.value))
      {
        paramString = bXs;
        AppMethodBeat.o(146068);
        return paramString;
      }
      if (paramString.equals(bXt.value))
      {
        paramString = bXt;
        AppMethodBeat.o(146068);
        return paramString;
      }
      if (paramString.equals(bXu.value))
      {
        paramString = bXu;
        AppMethodBeat.o(146068);
        return paramString;
      }
      if (paramString.equals(bXv.value))
      {
        paramString = bXv;
        AppMethodBeat.o(146068);
        return paramString;
      }
      AppMethodBeat.o(146068);
      return null;
    }
  }
  
  final class b
  {
    a bXy;
    AppForegroundDelegate.c bXz;
    
    private b()
    {
      AppMethodBeat.i(146083);
      this.bXy = new a((byte)0);
      this.bXz = new AppForegroundDelegate.c(AppForegroundDelegate.this, (byte)0);
      AppMethodBeat.o(146083);
    }
    
    final class a
      extends BroadcastReceiver
      implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2
    {
      private HashSet<String> bXA;
      
      private a()
      {
        AppMethodBeat.i(146073);
        this.bXA = new HashSet();
        AppMethodBeat.o(146073);
      }
      
      private static void a(AppForegroundDelegate.a parama, String paramString)
      {
        AppMethodBeat.i(146075);
        Intent localIntent = new Intent();
        localIntent.setAction(AppForegroundDelegate.a.a(parama));
        localIntent.putExtra("_application_context_process_", ah.getProcessName());
        localIntent.putExtra("com.tencent.mm.AppForegroundDelegate.ACTIVITY_NAME", paramString);
        ah.getContext().sendBroadcast(localIntent, "com.tencent.mm.permission.MM_MESSAGE");
        AppMethodBeat.o(146075);
      }
      
      private void a(final String paramString1, String paramString2, AppForegroundDelegate.a parama)
      {
        AppMethodBeat.i(146076);
        ab.i("MicroMsg.AppForegroundDelegate", "[checkAlive] activityName:%s process:%s action:%s", new Object[] { paramString1, paramString2, parama.name() });
        if (parama == AppForegroundDelegate.a.bXs)
        {
          if (!AppForegroundDelegate.c(AppForegroundDelegate.this)) {
            AppForegroundDelegate.c.c(true, paramString1);
          }
          this.bXA.remove(paramString1);
        }
        if (((parama == AppForegroundDelegate.a.bXr) || (parama == AppForegroundDelegate.a.bXs) || (parama == AppForegroundDelegate.a.bXt) || (parama == AppForegroundDelegate.a.bXu)) && (AppForegroundDelegate.d(AppForegroundDelegate.this) != null))
        {
          AppForegroundDelegate.e(AppForegroundDelegate.this).removeCallbacks(AppForegroundDelegate.d(AppForegroundDelegate.this));
          AppForegroundDelegate.a(AppForegroundDelegate.this, null);
        }
        if (parama == AppForegroundDelegate.a.bXt)
        {
          AppForegroundDelegate.e(AppForegroundDelegate.this).postDelayed(AppForegroundDelegate.a(AppForegroundDelegate.this, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(146070);
              if (!AppForegroundDelegate.c(AppForegroundDelegate.this)) {
                AppForegroundDelegate.c.c(true, paramString1);
              }
              AppMethodBeat.o(146070);
            }
          }), 600L);
          AppMethodBeat.o(146076);
          return;
        }
        if (parama == AppForegroundDelegate.a.bXu)
        {
          AppForegroundDelegate.e(AppForegroundDelegate.this).postDelayed(AppForegroundDelegate.a(AppForegroundDelegate.this, new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(146071);
              if ((AppForegroundDelegate.c(AppForegroundDelegate.this)) && (AppForegroundDelegate.b.a.a(AppForegroundDelegate.b.a.this).remove(paramString1)))
              {
                AppForegroundDelegate.c.c(false, paramString1);
                AppMethodBeat.o(146071);
                return;
              }
              AppForegroundDelegate.a(AppForegroundDelegate.this, null);
              ab.w("MicroMsg.AppForegroundDelegate", "[PAUSED] delay to check background in stop!");
              AppMethodBeat.o(146071);
            }
          }), 600L);
          AppMethodBeat.o(146076);
          return;
        }
        if ((parama == AppForegroundDelegate.a.bXv) || (parama == AppForegroundDelegate.a.bXw))
        {
          if (parama == AppForegroundDelegate.a.bXv) {
            this.bXA.add(paramString1);
          }
          if (AppForegroundDelegate.d(AppForegroundDelegate.this) == null) {
            AppForegroundDelegate.e(AppForegroundDelegate.this).postDelayed(AppForegroundDelegate.a(AppForegroundDelegate.this, new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(146072);
                if (AppForegroundDelegate.c(AppForegroundDelegate.this)) {
                  AppForegroundDelegate.c.c(false, paramString1);
                }
                AppMethodBeat.o(146072);
              }
            }), 600L);
          }
        }
        AppMethodBeat.o(146076);
      }
      
      public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
      {
        AppMethodBeat.i(146077);
        paramActivity = paramActivity.getClass().getName();
        if (ah.dsT())
        {
          a(paramActivity, ah.getProcessName(), AppForegroundDelegate.a.bXr);
          AppMethodBeat.o(146077);
          return;
        }
        a(AppForegroundDelegate.a.bXr, paramActivity);
        AppMethodBeat.o(146077);
      }
      
      public final void onActivityDestroyed(Activity paramActivity)
      {
        AppMethodBeat.i(146082);
        paramActivity = paramActivity.getClass().getName();
        if (ah.dsT())
        {
          a(paramActivity, ah.getProcessName(), AppForegroundDelegate.a.bXw);
          AppMethodBeat.o(146082);
          return;
        }
        a(AppForegroundDelegate.a.bXw, paramActivity);
        AppMethodBeat.o(146082);
      }
      
      public final void onActivityPaused(Activity paramActivity)
      {
        AppMethodBeat.i(146080);
        paramActivity = paramActivity.getClass().getName();
        if (ah.dsT())
        {
          a(paramActivity, ah.getProcessName(), AppForegroundDelegate.a.bXu);
          AppMethodBeat.o(146080);
          return;
        }
        a(AppForegroundDelegate.a.bXu, paramActivity);
        AppMethodBeat.o(146080);
      }
      
      public final void onActivityResumed(Activity paramActivity)
      {
        AppMethodBeat.i(146079);
        paramActivity = paramActivity.getClass().getName();
        if (ah.dsT())
        {
          a(paramActivity, ah.getProcessName(), AppForegroundDelegate.a.bXt);
          AppMethodBeat.o(146079);
          return;
        }
        a(AppForegroundDelegate.a.bXt, paramActivity);
        AppMethodBeat.o(146079);
      }
      
      public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
      
      public final void onActivityStarted(Activity paramActivity)
      {
        AppMethodBeat.i(146078);
        paramActivity = paramActivity.getClass().getName();
        if (ah.dsT())
        {
          a(paramActivity, ah.getProcessName(), AppForegroundDelegate.a.bXs);
          AppMethodBeat.o(146078);
          return;
        }
        a(AppForegroundDelegate.a.bXs, paramActivity);
        AppMethodBeat.o(146078);
      }
      
      public final void onActivityStopped(Activity paramActivity)
      {
        AppMethodBeat.i(146081);
        paramActivity = paramActivity.getClass().getName();
        if (ah.dsT())
        {
          a(paramActivity, ah.getProcessName(), AppForegroundDelegate.a.bXv);
          AppMethodBeat.o(146081);
          return;
        }
        a(AppForegroundDelegate.a.bXv, paramActivity);
        AppMethodBeat.o(146081);
      }
      
      public final void onConfigurationChanged(Configuration paramConfiguration) {}
      
      public final void onLowMemory() {}
      
      public final void onReceive(Context paramContext, Intent paramIntent)
      {
        AppMethodBeat.i(146074);
        if (paramIntent == null)
        {
          AppMethodBeat.o(146074);
          return;
        }
        paramContext = paramIntent.getAction();
        if (("android.intent.action.SCREEN_OFF".equals(paramContext)) || ("android.intent.action.SCREEN_ON".equals(paramContext)))
        {
          ab.i("MicroMsg.AppForegroundDelegate", "ACTION_SCREEN:%s", new Object[] { paramContext });
          if ("android.intent.action.SCREEN_OFF".equals(paramContext))
          {
            AppForegroundDelegate.a(AppForegroundDelegate.this, true);
            AppMethodBeat.o(146074);
            return;
          }
          AppForegroundDelegate.a(AppForegroundDelegate.this, false);
          AppMethodBeat.o(146074);
          return;
        }
        paramContext = AppForegroundDelegate.a.ds(paramContext);
        if (paramContext != null)
        {
          String str = paramIntent.getStringExtra("_application_context_process_");
          a(paramIntent.getStringExtra("com.tencent.mm.AppForegroundDelegate.ACTIVITY_NAME"), str, paramContext);
        }
        AppMethodBeat.o(146074);
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
      AppMethodBeat.i(146085);
      Intent localIntent = new Intent();
      if (paramBoolean) {}
      for (String str = "com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVE";; str = "com.tencent.mm.AppForegroundDelegate.ACTION_DEAD")
      {
        localIntent.setAction(str);
        localIntent.putExtra("com.tencent.mm.AppForegroundDelegate.ACTIVITY_NAME", paramString);
        ah.getContext().sendBroadcast(localIntent, "com.tencent.mm.permission.MM_MESSAGE");
        AppMethodBeat.o(146085);
        return;
      }
    }
    
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(146084);
      if (paramIntent == null)
      {
        AppMethodBeat.o(146084);
        return;
      }
      paramContext = paramIntent.getAction();
      this.activity = paramIntent.getStringExtra("com.tencent.mm.AppForegroundDelegate.ACTIVITY_NAME");
      if ("com.tencent.mm.AppForegroundDelegate.ACTION_ACTIVE".equalsIgnoreCase(paramContext))
      {
        AppForegroundDelegate.a(AppForegroundDelegate.this, this.activity);
        AppMethodBeat.o(146084);
        return;
      }
      AppForegroundDelegate.b(AppForegroundDelegate.this, this.activity);
      AppMethodBeat.o(146084);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.AppForegroundDelegate
 * JD-Core Version:    0.7.0.1
 */