package com.tencent.matrix.openglleak.statistics;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.tencent.matrix.openglleak.a.a;
import com.tencent.matrix.openglleak.a.a.a;
import com.tencent.matrix.openglleak.statistics.resource.ResRecordManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class d
  implements Application.ActivityLifecycleCallbacks
{
  private List<a> eXq = new LinkedList();
  
  public abstract void a(com.tencent.matrix.openglleak.statistics.resource.c paramc);
  
  public void d(Application arg1)
  {
    ???.registerActivityLifecycleCallbacks(this);
    com.tencent.matrix.e.c.i("matrix.LeakMonitorDefault", "start", new Object[0]);
    ??? = a.getActivity();
    a locala;
    if (??? != null)
    {
      locala = new a(???.hashCode(), new c());
      locala.start();
    }
    synchronized (this.eXq)
    {
      this.eXq.add(locala);
      return;
    }
  }
  
  public void onActivityCreated(Activity arg1, Bundle paramBundle)
  {
    paramBundle = new a(???.hashCode(), new c());
    paramBundle.start();
    com.tencent.matrix.e.c.i("matrix.LeakMonitorDefault", "onActivityCreated ".concat(String.valueOf(paramBundle)), new Object[0]);
    synchronized (this.eXq)
    {
      this.eXq.add(paramBundle);
      return;
    }
  }
  
  public void onActivityDestroyed(Activity arg1)
  {
    ??? = Integer.valueOf(???.hashCode());
    com.tencent.matrix.e.c.i("matrix.LeakMonitorDefault", "onActivityDestroyed ".concat(String.valueOf(???)), new Object[0]);
    for (;;)
    {
      a locala;
      synchronized (this.eXq)
      {
        localObject2 = this.eXq.iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label229;
        }
        locala = (a)((Iterator)localObject2).next();
        if ((locala == null) || (locala.eXr != ???.intValue())) {
          continue;
        }
        ((Iterator)localObject2).remove();
        ??? = new ArrayList();
        if (locala.eXs == null)
        {
          ??? = ???.iterator();
          if (!???.hasNext()) {
            break label229;
          }
          localObject2 = (com.tencent.matrix.openglleak.statistics.resource.c)???.next();
          if ((localObject2 == null) || (((com.tencent.matrix.openglleak.statistics.resource.c)localObject2).eXM == null) || (((com.tencent.matrix.openglleak.statistics.resource.c)localObject2).eXM.eXZ != locala.eXr)) {
            continue;
          }
          a((com.tencent.matrix.openglleak.statistics.resource.c)localObject2);
        }
      }
      Object localObject2 = locala.eXs;
      com.tencent.matrix.openglleak.statistics.resource.d locald = ((c)localObject2).eXp;
      ResRecordManager localResRecordManager = ResRecordManager.ayR();
      label229:
      synchronized (localResRecordManager.eXT)
      {
        localResRecordManager.eXT.remove(locald);
        ??? = ((c)localObject2).eXp.eXW;
      }
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    com.tencent.matrix.e.c.i("matrix.LeakMonitorDefault", "onActivityPaused " + paramActivity.hashCode(), new Object[0]);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    com.tencent.matrix.e.c.i("matrix.LeakMonitorDefault", "onActivityResumed " + paramActivity.hashCode(), new Object[0]);
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    com.tencent.matrix.e.c.i("matrix.LeakMonitorDefault", "onActivityStarted " + paramActivity.hashCode(), new Object[0]);
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    com.tencent.matrix.e.c.i("matrix.LeakMonitorDefault", "onActivityStopped " + paramActivity.hashCode(), new Object[0]);
  }
  
  final class a
  {
    int eXr;
    c eXs;
    
    a(int paramInt, c paramc)
    {
      this.eXr = paramInt;
      this.eXs = paramc;
    }
    
    final void start()
    {
      if (this.eXs != null) {
        this.eXs.ayO();
      }
    }
    
    public final String toString()
    {
      return "ActivityLeakMonitor{mActivityHashCode=" + this.eXr + ", mMonitor=" + this.eXs + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.openglleak.statistics.d
 * JD-Core Version:    0.7.0.1
 */