package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class Scope
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<Scope> CREATOR;
  private final int zzal;
  private final String zzdp;
  
  static
  {
    AppMethodBeat.i(4473);
    CREATOR = new zzd();
    AppMethodBeat.o(4473);
  }
  
  Scope(int paramInt, String paramString)
  {
    AppMethodBeat.i(4469);
    Preconditions.checkNotEmpty(paramString, "scopeUri must not be null or empty");
    this.zzal = paramInt;
    this.zzdp = paramString;
    AppMethodBeat.o(4469);
  }
  
  public Scope(String paramString)
  {
    this(1, paramString);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(4470);
    if (this == paramObject)
    {
      AppMethodBeat.o(4470);
      return true;
    }
    if (!(paramObject instanceof Scope))
    {
      AppMethodBeat.o(4470);
      return false;
    }
    boolean bool = this.zzdp.equals(((Scope)paramObject).zzdp);
    AppMethodBeat.o(4470);
    return bool;
  }
  
  public final String getScopeUri()
  {
    return this.zzdp;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(4471);
    int i = this.zzdp.hashCode();
    AppMethodBeat.o(4471);
    return i;
  }
  
  public final String toString()
  {
    return this.zzdp;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(4472);
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zzal);
    SafeParcelWriter.writeString(paramParcel, 2, getScopeUri(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    AppMethodBeat.o(4472);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.api.Scope
 * JD-Core Version:    0.7.0.1
 */