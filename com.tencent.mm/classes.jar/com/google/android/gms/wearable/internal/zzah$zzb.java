package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;

public class zzah$zzb
  implements DataApi.DeleteDataItemsResult
{
  private final Status zzair;
  private final int zzbUt;
  
  public zzah$zzb(Status paramStatus, int paramInt)
  {
    this.zzair = paramStatus;
    this.zzbUt = paramInt;
  }
  
  public int getNumDeleted()
  {
    return this.zzbUt;
  }
  
  public Status getStatus()
  {
    return this.zzair;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzah.zzb
 * JD-Core Version:    0.7.0.1
 */