package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.CapabilityApi.CapabilityListener;
import com.google.android.gms.wearable.CapabilityInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzv
  implements CapabilityApi.CapabilityListener
{
  private final String zzbc;
  private final CapabilityApi.CapabilityListener zzbs;
  
  zzv(CapabilityApi.CapabilityListener paramCapabilityListener, String paramString)
  {
    this.zzbs = paramCapabilityListener;
    this.zzbc = paramString;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(101457);
    if (this == paramObject)
    {
      AppMethodBeat.o(101457);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(101457);
      return false;
    }
    paramObject = (zzv)paramObject;
    if (!this.zzbs.equals(paramObject.zzbs))
    {
      AppMethodBeat.o(101457);
      return false;
    }
    boolean bool = this.zzbc.equals(paramObject.zzbc);
    AppMethodBeat.o(101457);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(101458);
    int i = this.zzbs.hashCode();
    int j = this.zzbc.hashCode();
    AppMethodBeat.o(101458);
    return i * 31 + j;
  }
  
  public final void onCapabilityChanged(CapabilityInfo paramCapabilityInfo)
  {
    AppMethodBeat.i(101456);
    this.zzbs.onCapabilityChanged(paramCapabilityInfo);
    AppMethodBeat.o(101456);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzv
 * JD-Core Version:    0.7.0.1
 */