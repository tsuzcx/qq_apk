package com.tencent.matrix.c;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.tencent.matrix.a.a.a.g.b;
import com.tencent.matrix.a.a.d.b;
import com.tencent.mm.sdk.platformtools.ApplicationGlobal;
import java.util.HashMap;
import java.util.Map;

public final class e
  extends com.tencent.matrix.a.a.a.a
{
  final Map<String, g.b> cZu = new HashMap();
  Application.ActivityLifecycleCallbacks cZv;
  
  public static void fo(String paramString)
  {
    e locale = (e)com.tencent.matrix.a.a.Z(e.class);
    if (locale != null) {
      locale.fq(paramString);
    }
  }
  
  public static void fp(String paramString)
  {
    e locale = (e)com.tencent.matrix.a.a.Z(e.class);
    if (locale != null) {
      locale.fr(paramString);
    }
  }
  
  public final void VZ()
  {
    super.VZ();
    this.cZv = new Application.ActivityLifecycleCallbacks()
    {
      private static String l(Activity paramAnonymousActivity)
      {
        paramAnonymousActivity = paramAnonymousActivity.getClass().getName();
        int i = -1;
        switch (paramAnonymousActivity.hashCode())
        {
        }
        for (;;)
        {
          switch (i)
          {
          default: 
            return null;
            if (paramAnonymousActivity.equals("com.tencent.mm.plugin.finder.ui.FinderHomeUI"))
            {
              i = 0;
              continue;
              if (paramAnonymousActivity.equals("com.tencent.mm.plugin.finder.feed.ui.FinderLiveVisitorWithoutAffinityUI"))
              {
                i = 1;
                continue;
                if (paramAnonymousActivity.equals("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorWithoutAffinityUI"))
                {
                  i = 2;
                  continue;
                  if (paramAnonymousActivity.equals("com.tencent.mm.plugin.voip.ui.VideoActivity"))
                  {
                    i = 3;
                    continue;
                    if (paramAnonymousActivity.equals("com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI")) {
                      i = 4;
                    }
                  }
                }
              }
            }
            break;
          }
        }
        return "Finder";
        return "FinderLive";
        return "FinderLiveAnchor";
        return "VoIp";
        return "VoIpMulti";
      }
      
      public final void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
      {
        paramAnonymousActivity = l(paramAnonymousActivity);
        if (paramAnonymousActivity != null) {
          e.this.fq(paramAnonymousActivity);
        }
      }
      
      public final void onActivityDestroyed(Activity paramAnonymousActivity)
      {
        paramAnonymousActivity = l(paramAnonymousActivity);
        if (paramAnonymousActivity != null) {
          e.this.fr(paramAnonymousActivity);
        }
      }
      
      public final void onActivityPaused(Activity paramAnonymousActivity) {}
      
      public final void onActivityResumed(Activity paramAnonymousActivity) {}
      
      public final void onActivitySaveInstanceState(Activity paramAnonymousActivity, Bundle paramAnonymousBundle) {}
      
      public final void onActivityStarted(Activity paramAnonymousActivity) {}
      
      public final void onActivityStopped(Activity paramAnonymousActivity) {}
    };
    ApplicationGlobal.context().registerActivityLifecycleCallbacks(this.cZv);
  }
  
  public final void Wa()
  {
    super.Wa();
    if (this.cZv != null) {
      ApplicationGlobal.context().unregisterActivityLifecycleCallbacks(this.cZv);
    }
    this.cZu.clear();
  }
  
  public final int Wh()
  {
    return 0;
  }
  
  public final void fq(final String paramString)
  {
    com.tencent.matrix.a.a.a(new d.b() {});
  }
  
  public final void fr(final String paramString)
  {
    if (this.cZu.containsKey(paramString)) {
      com.tencent.matrix.a.a.a(new d.b() {});
    }
  }
  
  public final String getTag()
  {
    return "Matrix.battery.ModuleJiffiesMonitor";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.c.e
 * JD-Core Version:    0.7.0.1
 */