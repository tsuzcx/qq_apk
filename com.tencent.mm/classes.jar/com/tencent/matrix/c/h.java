package com.tencent.matrix.c;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.matrix.a.a.a.f;
import com.tencent.matrix.a.a.d;
import com.tencent.mm.sdk.platformtools.ApplicationGlobal;
import java.util.HashMap;
import java.util.Map;

public final class h
  extends com.tencent.matrix.a.a.a.a
{
  final Map<String, f> eWv = new HashMap();
  Application.ActivityLifecycleCallbacks eWw;
  
  public static void gF(String paramString)
  {
    h localh = (h)com.tencent.matrix.a.a.aj(h.class);
    if (localh != null) {
      localh.gH(paramString);
    }
  }
  
  public static void gG(String paramString)
  {
    h localh = (h)com.tencent.matrix.a.a.aj(h.class);
    if (localh != null) {
      localh.gI(paramString);
    }
  }
  
  public final void awI()
  {
    super.awI();
    this.eWw = new Application.ActivityLifecycleCallbacks()
    {
      private static String m(Activity paramAnonymousActivity)
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
              if (paramAnonymousActivity.equals("com.tencent.mm.plugin.finder.ui.FinderHomeAffinityUI"))
              {
                i = 1;
                continue;
                if (paramAnonymousActivity.equals("com.tencent.mm.plugin.finder.feed.ui.FinderLiveVisitorWithoutAffinityUI"))
                {
                  i = 2;
                  continue;
                  if (paramAnonymousActivity.equals("com.tencent.mm.plugin.finder.nearby.NearbyUI"))
                  {
                    i = 3;
                    continue;
                    if (paramAnonymousActivity.equals("com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorWithoutAffinityUI"))
                    {
                      i = 4;
                      continue;
                      if (paramAnonymousActivity.equals("com.tencent.mm.plugin.voip.ui.VideoActivity"))
                      {
                        i = 5;
                        continue;
                        if (paramAnonymousActivity.equals("com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI")) {
                          i = 6;
                        }
                      }
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
        return "VoIp";
      }
      
      public final void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
      {
        paramAnonymousActivity = m(paramAnonymousActivity);
        if (paramAnonymousActivity != null) {
          h.this.gH(paramAnonymousActivity);
        }
      }
      
      public final void onActivityDestroyed(Activity paramAnonymousActivity)
      {
        paramAnonymousActivity = m(paramAnonymousActivity);
        if (paramAnonymousActivity != null) {
          h.this.gI(paramAnonymousActivity);
        }
      }
      
      public final void onActivityPaused(Activity paramAnonymousActivity) {}
      
      public final void onActivityResumed(Activity paramAnonymousActivity) {}
      
      public final void onActivitySaveInstanceState(Activity paramAnonymousActivity, Bundle paramAnonymousBundle) {}
      
      public final void onActivityStarted(Activity paramAnonymousActivity) {}
      
      public final void onActivityStopped(Activity paramAnonymousActivity) {}
    };
    ApplicationGlobal.context().registerActivityLifecycleCallbacks(this.eWw);
  }
  
  public final void awJ()
  {
    super.awJ();
    if (this.eWw != null) {
      ApplicationGlobal.context().unregisterActivityLifecycleCallbacks(this.eWw);
    }
    this.eWv.clear();
  }
  
  public final int awQ()
  {
    return 0;
  }
  
  public final void gH(String paramString)
  {
    this.eNY.mHandler.post(new h..ExternalSyntheticLambda2(this, paramString));
  }
  
  public final void gI(String paramString)
  {
    if (this.eWv.containsKey(paramString)) {
      this.eNY.mHandler.post(new h..ExternalSyntheticLambda1(this, paramString));
    }
  }
  
  public final String getTag()
  {
    return "Matrix.battery.ModuleJiffiesMonitor";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.c.h
 * JD-Core Version:    0.7.0.1
 */