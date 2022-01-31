package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.tencent.matrix.trace.core.AppMethodBeat;

@KeepForSdk
@SafeParcelable.Class(creator="ScopeCreator")
public final class Scope
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<Scope> CREATOR;
  @SafeParcelable.VersionField(id=1)
  private final int zzal;
  @SafeParcelable.Field(getter="getScopeUri", id=2)
  private final String zzdp;
  
  static
  {
    AppMethodBeat.i(89451);
    CREATOR = new zzd();
    AppMethodBeat.o(89451);
  }
  
  @SafeParcelable.Constructor
  Scope(@SafeParcelable.Param(id=1) int paramInt, @SafeParcelable.Param(id=2) String paramString)
  {
    AppMethodBeat.i(89447);
    Preconditions.checkNotEmpty(paramString, "scopeUri must not be null or empty");
    this.zzal = paramInt;
    this.zzdp = paramString;
    AppMethodBeat.o(89447);
  }
  
  public Scope(String paramString)
  {
    this(1, paramString);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(89448);
    if (this == paramObject)
    {
      AppMethodBeat.o(89448);
      return true;
    }
    if (!(paramObject instanceof Scope))
    {
      AppMethodBeat.o(89448);
      return false;
    }
    boolean bool = this.zzdp.equals(((Scope)paramObject).zzdp);
    AppMethodBeat.o(89448);
    return bool;
  }
  
  @KeepForSdk
  public final String getScopeUri()
  {
    return this.zzdp;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(89449);
    int i = this.zzdp.hashCode();
    AppMethodBeat.o(89449);
    return i;
  }
  
  public final String toString()
  {
    return this.zzdp;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(89450);
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zzal);
    SafeParcelWriter.writeString(paramParcel, 2, getScopeUri(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    AppMethodBeat.o(89450);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.Scope
 * JD-Core Version:    0.7.0.1
 */