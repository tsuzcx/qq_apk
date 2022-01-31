package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.DataItem;

public class zzah$zza
  implements DataApi.DataItemResult
{
  private final Status zzair;
  private final DataItem zzbUs;
  
  public zzah$zza(Status paramStatus, DataItem paramDataItem)
  {
    this.zzair = paramStatus;
    this.zzbUs = paramDataItem;
  }
  
  public DataItem getDataItem()
  {
    return this.zzbUs;
  }
  
  public Status getStatus()
  {
    return this.zzair;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzah.zza
 * JD-Core Version:    0.7.0.1
 */