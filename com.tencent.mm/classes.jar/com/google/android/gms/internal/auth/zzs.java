package com.google.android.gms.internal.auth;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

final class zzs
  implements Result
{
  private final Status mStatus;
  
  public zzs(Status paramStatus)
  {
    this.mStatus = paramStatus;
  }
  
  public final Status getStatus()
  {
    return this.mStatus;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.auth.zzs
 * JD-Core Version:    0.7.0.1
 */