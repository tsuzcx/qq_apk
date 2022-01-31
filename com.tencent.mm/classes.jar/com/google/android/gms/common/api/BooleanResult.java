package com.google.android.gms.common.api;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

@KeepForSdk
public class BooleanResult
  implements Result
{
  private final Status mStatus;
  private final boolean zzck;
  
  @KeepForSdk
  public BooleanResult(Status paramStatus, boolean paramBoolean)
  {
    AppMethodBeat.i(60492);
    this.mStatus = ((Status)Preconditions.checkNotNull(paramStatus, "Status must not be null"));
    this.zzck = paramBoolean;
    AppMethodBeat.o(60492);
  }
  
  @KeepForSdk
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(60494);
    if (paramObject == this)
    {
      AppMethodBeat.o(60494);
      return true;
    }
    if (!(paramObject instanceof BooleanResult))
    {
      AppMethodBeat.o(60494);
      return false;
    }
    paramObject = (BooleanResult)paramObject;
    if ((this.mStatus.equals(paramObject.mStatus)) && (this.zzck == paramObject.zzck))
    {
      AppMethodBeat.o(60494);
      return true;
    }
    AppMethodBeat.o(60494);
    return false;
  }
  
  @KeepForSdk
  public Status getStatus()
  {
    return this.mStatus;
  }
  
  @KeepForSdk
  public boolean getValue()
  {
    return this.zzck;
  }
  
  @KeepForSdk
  public final int hashCode()
  {
    AppMethodBeat.i(60493);
    int j = this.mStatus.hashCode();
    if (this.zzck) {}
    for (int i = 1;; i = 0)
    {
      AppMethodBeat.o(60493);
      return i + (j + 527) * 31;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.common.api.BooleanResult
 * JD-Core Version:    0.7.0.1
 */