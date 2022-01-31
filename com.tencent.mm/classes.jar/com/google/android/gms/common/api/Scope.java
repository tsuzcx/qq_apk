package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzac;

public final class Scope
  extends zza
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<Scope> CREATOR = new zzg();
  final int zzaiI;
  private final String zzazw;
  
  Scope(int paramInt, String paramString)
  {
    zzac.zzh(paramString, "scopeUri must not be null or empty");
    this.zzaiI = paramInt;
    this.zzazw = paramString;
  }
  
  public Scope(String paramString)
  {
    this(1, paramString);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof Scope)) {
      return false;
    }
    return this.zzazw.equals(((Scope)paramObject).zzazw);
  }
  
  public final int hashCode()
  {
    return this.zzazw.hashCode();
  }
  
  public final String toString()
  {
    return this.zzazw;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzg.zza(this, paramParcel, paramInt);
  }
  
  public final String zzvt()
  {
    return this.zzazw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.common.api.Scope
 * JD-Core Version:    0.7.0.1
 */