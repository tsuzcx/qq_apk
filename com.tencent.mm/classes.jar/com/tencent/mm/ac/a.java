package com.tencent.mm.ac;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

public final class a
  implements Application.ActivityLifecycleCallbacks
{
  private static final WeakHashMap<Activity, Integer> eMw;
  
  static
  {
    AppMethodBeat.i(115069);
    eMw = new WeakHashMap();
    AppMethodBeat.o(115069);
  }
  
  public static String SU()
  {
    AppMethodBeat.i(115062);
    StringBuilder localStringBuilder;
    Object localObject2;
    synchronized (eMw)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(eMw.size());
      localObject2 = new ArrayList();
    }
    try
    {
      ((List)localObject2).addAll(eMw.keySet());
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Activity localActivity = (Activity)((Iterator)localObject2).next();
        if (localActivity != null)
        {
          localStringBuilder.append("|");
          localStringBuilder.append(localActivity.getClass().getSimpleName());
          localStringBuilder.append(":");
          localStringBuilder.append(eMw.get(localActivity));
        }
      }
      localObject1 = finally;
      AppMethodBeat.o(115062);
      throw localObject1;
    }
    catch (ConcurrentModificationException localConcurrentModificationException)
    {
      for (;;)
      {
        ab.w("MicroMsg.ActivityRefDump", "ConcurrentModificationException occur.");
        localObject1.append("concurrent modification exception");
      }
      String str = localObject1.toString();
      AppMethodBeat.o(115062);
      return str;
    }
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle arg2)
  {
    AppMethodBeat.i(115063);
    synchronized (eMw)
    {
      eMw.put(paramActivity, Integer.valueOf(0));
      AppMethodBeat.o(115063);
      return;
    }
  }
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    AppMethodBeat.i(115064);
    synchronized (eMw)
    {
      eMw.put(paramActivity, Integer.valueOf(5));
      AppMethodBeat.o(115064);
      return;
    }
  }
  
  public final void onActivityPaused(Activity paramActivity)
  {
    AppMethodBeat.i(115067);
    synchronized (eMw)
    {
      eMw.put(paramActivity, Integer.valueOf(3));
      AppMethodBeat.o(115067);
      return;
    }
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    AppMethodBeat.i(115066);
    synchronized (eMw)
    {
      eMw.put(paramActivity, Integer.valueOf(2));
      AppMethodBeat.o(115066);
      return;
    }
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity)
  {
    AppMethodBeat.i(115065);
    synchronized (eMw)
    {
      eMw.put(paramActivity, Integer.valueOf(1));
      AppMethodBeat.o(115065);
      return;
    }
  }
  
  public final void onActivityStopped(Activity paramActivity)
  {
    AppMethodBeat.i(115068);
    synchronized (eMw)
    {
      eMw.put(paramActivity, Integer.valueOf(4));
      AppMethodBeat.o(115068);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ac.a
 * JD-Core Version:    0.7.0.1
 */