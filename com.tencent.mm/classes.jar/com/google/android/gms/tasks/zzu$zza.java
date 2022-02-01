package com.google.android.gms.tasks;

import android.app.Activity;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class zzu$zza
  extends LifecycleCallback
{
  private final List<WeakReference<zzq<?>>> zzagi;
  
  private zzu$zza(LifecycleFragment paramLifecycleFragment)
  {
    super(paramLifecycleFragment);
    AppMethodBeat.i(13413);
    this.zzagi = new ArrayList();
    this.mLifecycleFragment.addCallback("TaskOnStopCallback", this);
    AppMethodBeat.o(13413);
  }
  
  public static zza zze(Activity paramActivity)
  {
    AppMethodBeat.i(13412);
    LifecycleFragment localLifecycleFragment = getFragment(paramActivity);
    zza localzza = (zza)localLifecycleFragment.getCallbackOrNull("TaskOnStopCallback", zza.class);
    paramActivity = localzza;
    if (localzza == null) {
      paramActivity = new zza(localLifecycleFragment);
    }
    AppMethodBeat.o(13412);
    return paramActivity;
  }
  
  public void onStop()
  {
    AppMethodBeat.i(13415);
    synchronized (this.zzagi)
    {
      Iterator localIterator = this.zzagi.iterator();
      while (localIterator.hasNext())
      {
        zzq localzzq = (zzq)((WeakReference)localIterator.next()).get();
        if (localzzq != null) {
          localzzq.cancel();
        }
      }
    }
    this.zzagi.clear();
    AppMethodBeat.o(13415);
  }
  
  public final <T> void zzb(zzq<T> paramzzq)
  {
    AppMethodBeat.i(13414);
    synchronized (this.zzagi)
    {
      this.zzagi.add(new WeakReference(paramzzq));
      AppMethodBeat.o(13414);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.tasks.zzu.zza
 * JD-Core Version:    0.7.0.1
 */