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
    AppMethodBeat.i(60673);
    AppMethodBeat.o(60673);
  }
  
  private zza(zza paramzza)
  {
    AppMethodBeat.i(60674);
    this.zzds = new WeakReference(paramzza);
    AppMethodBeat.o(60674);
  }
  
  public final ActivityLifecycleObserver onStopCallOnce(Runnable paramRunnable)
  {
    AppMethodBeat.i(60675);
    zza localzza = (zza)this.zzds.get();
    if (localzza == null)
    {
      paramRunnable = new IllegalStateException("The target activity has already been GC'd");
      AppMethodBeat.o(60675);
      throw paramRunnable;
    }
    zza.zza(localzza, paramRunnable);
    AppMethodBeat.o(60675);
    return this;
  }
  
  static class zza
    extends LifecycleCallback
  {
    private List<Runnable> zzdt;
    
    private zza(LifecycleFragment paramLifecycleFragment)
    {
      super();
      AppMethodBeat.i(60668);
      this.zzdt = new ArrayList();
      this.mLifecycleFragment.addCallback("LifecycleObserverOnStop", this);
      AppMethodBeat.o(60668);
    }
    
    private static zza zza(Activity paramActivity)
    {
      AppMethodBeat.i(60667);
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
        AppMethodBeat.o(60667);
      }
    }
    
    private final void zza(Runnable paramRunnable)
    {
      try
      {
        AppMethodBeat.i(60669);
        this.zzdt.add(paramRunnable);
        AppMethodBeat.o(60669);
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
      AppMethodBeat.i(60670);
      try
      {
        Object localObject1 = this.zzdt;
        this.zzdt = new ArrayList();
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((Runnable)((Iterator)localObject1).next()).run();
        }
        AppMethodBeat.o(60670);
      }
      finally
      {
        AppMethodBeat.o(60670);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zza
 * JD-Core Version:    0.7.0.1
 */