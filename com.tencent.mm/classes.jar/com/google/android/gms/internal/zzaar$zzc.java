package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api.zze;
import java.util.ArrayList;
import java.util.Iterator;

class zzaar$zzc
  extends zzaar.zzf
{
  private final ArrayList<Api.zze> zzaBG;
  
  public zzaar$zzc(ArrayList<Api.zze> paramArrayList)
  {
    super(paramArrayList, null);
    Object localObject;
    this.zzaBG = localObject;
  }
  
  public void zzwe()
  {
    zzaar.zzd(this.zzaBA).zzaAw.zzaBR = zzaar.zzg(this.zzaBA);
    Iterator localIterator = this.zzaBG.iterator();
    while (localIterator.hasNext()) {
      ((Api.zze)localIterator.next()).zza(zzaar.zzh(this.zzaBA), zzaar.zzd(this.zzaBA).zzaAw.zzaBR);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.zzaar.zzc
 * JD-Core Version:    0.7.0.1
 */