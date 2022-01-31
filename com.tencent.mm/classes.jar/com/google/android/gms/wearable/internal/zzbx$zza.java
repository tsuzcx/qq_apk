package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzaad.zzb;
import java.lang.ref.WeakReference;
import java.util.Map;

class zzbx$zza<T>
  extends zzcw.zzb<Status>
{
  private WeakReference<Map<T, zzcy<T>>> zzbUI;
  private WeakReference<T> zzbUJ;
  
  zzbx$zza(Map<T, zzcy<T>> paramMap, T paramT, zzaad.zzb<Status> paramzzb)
  {
    super(paramzzb);
    this.zzbUI = new WeakReference(paramMap);
    this.zzbUJ = new WeakReference(paramT);
  }
  
  public void zza(Status paramStatus)
  {
    Map localMap = (Map)this.zzbUI.get();
    Object localObject = this.zzbUJ.get();
    if ((!paramStatus.getStatus().isSuccess()) && (localMap != null) && (localObject != null)) {}
    try
    {
      localObject = (zzcy)localMap.remove(localObject);
      if (localObject != null) {
        ((zzcy)localObject).clear();
      }
      zzaa(paramStatus);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzbx.zza
 * JD-Core Version:    0.7.0.1
 */