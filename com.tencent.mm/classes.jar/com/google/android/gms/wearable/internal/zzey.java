package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;

public final class zzey
  implements MessageApi.SendMessageResult
{
  private final int zzeh;
  private final Status zzp;
  
  public zzey(Status paramStatus, int paramInt)
  {
    this.zzp = paramStatus;
    this.zzeh = paramInt;
  }
  
  public final int getRequestId()
  {
    return this.zzeh;
  }
  
  public final Status getStatus()
  {
    return this.zzp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzey
 * JD-Core Version:    0.7.0.1
 */