package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.CapabilityClient.OnCapabilityChangedListener;
import com.google.android.gms.wearable.CapabilityInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzae
  implements CapabilityClient.OnCapabilityChangedListener
{
  private final String zzbc;
  private final CapabilityClient.OnCapabilityChangedListener zzby;
  
  zzae(CapabilityClient.OnCapabilityChangedListener paramOnCapabilityChangedListener, String paramString)
  {
    this.zzby = paramOnCapabilityChangedListener;
    this.zzbc = paramString;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(100968);
    if (this == paramObject)
    {
      AppMethodBeat.o(100968);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(100968);
      return false;
    }
    paramObject = (zzae)paramObject;
    if (!this.zzby.equals(paramObject.zzby))
    {
      AppMethodBeat.o(100968);
      return false;
    }
    boolean bool = this.zzbc.equals(paramObject.zzbc);
    AppMethodBeat.o(100968);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(100969);
    int i = this.zzby.hashCode();
    int j = this.zzbc.hashCode();
    AppMethodBeat.o(100969);
    return i * 31 + j;
  }
  
  public final void onCapabilityChanged(CapabilityInfo paramCapabilityInfo)
  {
    AppMethodBeat.i(100967);
    this.zzby.onCapabilityChanged(paramCapabilityInfo);
    AppMethodBeat.o(100967);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzae
 * JD-Core Version:    0.7.0.1
 */