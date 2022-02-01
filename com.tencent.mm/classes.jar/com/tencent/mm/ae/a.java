package com.tencent.mm.ae;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

public final class a
  implements Application.ActivityLifecycleCallbacks
{
  private static final WeakHashMap<Activity, Integer> ghG;
  
  static
  {
    AppMethodBeat.i(125087);
    ghG = new WeakHashMap();
    AppMethodBeat.o(125087);
  }
  
  public static String agO()
  {
    AppMethodBeat.i(125080);
    StringBuilder localStringBuilder;
    Object localObject2;
    synchronized (ghG)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(ghG.size());
      localObject2 = new ArrayList();
    }
    try
    {
      ((List)localObject2).addAll(ghG.keySet());
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Activity localActivity = (Activity)((Iterator)localObject2).next();
        if (localActivity != null)
        {
          localStringBuilder.append("|");
          localStringBuilder.append(localActivity.getClass().getSimpleName());
          localStringBuilder.append(":");
          localStringBuilder.append(ghG.get(localActivity));
        }
      }
      localObject1 = finally;
      AppMethodBeat.o(125080);
      throw localObject1;
    }
    catch (ConcurrentModificationException localConcurrentModificationException)
    {
      for (;;)
      {
        ad.w("MicroMsg.ActivityRefDump", "ConcurrentModificationException occur.");
        localObject1.append("concurrent modification exception");
      }
      String str = localObject1.toString();
      AppMethodBeat.o(125080);
      return str;
    }
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle arg2)
  {
    AppMethodBeat.i(125081);
    synchronized (ghG)
    {
      ghG.put(paramActivity, Integer.valueOf(0));
      AppMethodBeat.o(125081);
      return;
    }
  }
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    AppMethodBeat.i(125082);
    synchronized (ghG)
    {
      ghG.put(paramActivity, Integer.valueOf(5));
      AppMethodBeat.o(125082);
      return;
    }
  }
  
  public final void onActivityPaused(Activity paramActivity)
  {
    AppMethodBeat.i(125085);
    synchronized (ghG)
    {
      ghG.put(paramActivity, Integer.valueOf(3));
      AppMethodBeat.o(125085);
      return;
    }
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    AppMethodBeat.i(125084);
    synchronized (ghG)
    {
      ghG.put(paramActivity, Integer.valueOf(2));
      AppMethodBeat.o(125084);
      return;
    }
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity)
  {
    AppMethodBeat.i(125083);
    synchronized (ghG)
    {
      ghG.put(paramActivity, Integer.valueOf(1));
      AppMethodBeat.o(125083);
      return;
    }
  }
  
  public final void onActivityStopped(Activity paramActivity)
  {
    AppMethodBeat.i(125086);
    synchronized (ghG)
    {
      ghG.put(paramActivity, Integer.valueOf(4));
      AppMethodBeat.o(125086);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ae.a
 * JD-Core Version:    0.7.0.1
 */