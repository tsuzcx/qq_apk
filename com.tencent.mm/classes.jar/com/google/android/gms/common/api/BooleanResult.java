package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.zzac;

public class BooleanResult
  implements Result
{
  private final Status zzair;
  private final boolean zzayS;
  
  public BooleanResult(Status paramStatus, boolean paramBoolean)
  {
    this.zzair = ((Status)zzac.zzb(paramStatus, "Status must not be null"));
    this.zzayS = paramBoolean;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof BooleanResult)) {
        return false;
      }
      paramObject = (BooleanResult)paramObject;
    } while ((this.zzair.equals(paramObject.zzair)) && (this.zzayS == paramObject.zzayS));
    return false;
  }
  
  public Status getStatus()
  {
    return this.zzair;
  }
  
  public boolean getValue()
  {
    return this.zzayS;
  }
  
  public final int hashCode()
  {
    int j = this.zzair.hashCode();
    if (this.zzayS) {}
    for (int i = 1;; i = 0) {
      return i + (j + 527) * 31;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.api.BooleanResult
 * JD-Core Version:    0.7.0.1
 */