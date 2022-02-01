package com.google.android.gms.common.api.internal;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class zza
  extends ActivityLifecycleObserver
{
  private final WeakReference<zza> zzds;
  
  public zza(Activity paramActivity)
  {
    this(zza.zzb(paramActivity));
    AppMethodBeat.i(11165);
    AppMethodBeat.o(11165);
  }
  
  private zza(zza paramzza)
  {
    AppMethodBeat.i(11166);
    this.zzds = new WeakReference(paramzza);
    AppMethodBeat.o(11166);
  }
  
  public final ActivityLifecycleObserver onStopCallOnce(Runnable paramRunnable)
  {
    AppMethodBeat.i(11167);
    zza localzza = (zza)this.zzds.get();
    if (localzza == null)
    {
      paramRunnable = new IllegalStateException("The target activity has already been GC'd");
      AppMethodBeat.o(11167);
      throw paramRunnable;
    }
    zza.zza(localzza, paramRunnable);
    AppMethodBeat.o(11167);
    return this;
  }
  
  static class zza
    extends LifecycleCallback
  {
    private List<Runnable> zzdt;
    
    private zza(LifecycleFragment paramLifecycleFragment)
    {
      super();
      AppMethodBeat.i(11160);
      this.zzdt = new ArrayList();
      this.mLifecycleFragment.addCallback("LifecycleObserverOnStop", this);
      AppMethodBeat.o(11160);
    }
    
    private static zza zza(Activity paramActivity)
    {
      AppMethodBeat.i(11159);
      try
      {
        LifecycleFragment localLifecycleFragment = getFragment(paramActivity);
        zza localzza2 = (zza)localLifecycleFragment.getCallbackOrNull("LifecycleObserverOnStop", zza.class);
        zza localzza1 = localzza2;
        if (localzza2 == null) {
          localzza1 = new zza(localLifecycleFragment);
        }
        return localzza1;
      }
      finally
      {
        AppMethodBeat.o(11159);
      }
    }
    
    private final void zza(Runnable paramRunnable)
    {
      try
      {
        AppMethodBeat.i(11161);
        this.zzdt.add(paramRunnable);
        AppMethodBeat.o(11161);
        return;
      }
      finally
      {
        paramRunnable = finally;
        throw paramRunnable;
      }
    }
    
    public void onStop()
    {
      AppMethodBeat.i(11162);
      try
      {
        Object localObject1 = this.zzdt;
        this.zzdt = new ArrayList();
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((Runnable)((Iterator)localObject1).next()).run();
        }
        AppMethodBeat.o(11162);
      }
      finally
      {
        AppMethodBeat.o(11162);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zza
 * JD-Core Version:    0.7.0.1
 */