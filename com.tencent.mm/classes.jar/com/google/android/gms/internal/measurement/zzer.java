package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

@SafeParcelable.Class(creator="EventParamsCreator")
@SafeParcelable.Reserved({1})
public final class zzer
  extends AbstractSafeParcelable
  implements Iterable<String>
{
  public static final Parcelable.Creator<zzer> CREATOR;
  @SafeParcelable.Field(getter="z", id=2)
  private final Bundle zzafy;
  
  static
  {
    AppMethodBeat.i(68739);
    CREATOR = new zzet();
    AppMethodBeat.o(68739);
  }
  
  @SafeParcelable.Constructor
  zzer(@SafeParcelable.Param(id=2) Bundle paramBundle)
  {
    this.zzafy = paramBundle;
  }
  
  final Object get(String paramString)
  {
    AppMethodBeat.i(68731);
    paramString = this.zzafy.get(paramString);
    AppMethodBeat.o(68731);
    return paramString;
  }
  
  final Long getLong(String paramString)
  {
    AppMethodBeat.i(68732);
    long l = this.zzafy.getLong(paramString);
    AppMethodBeat.o(68732);
    return Long.valueOf(l);
  }
  
  final String getString(String paramString)
  {
    AppMethodBeat.i(68734);
    paramString = this.zzafy.getString(paramString);
    AppMethodBeat.o(68734);
    return paramString;
  }
  
  public final Iterator<String> iterator()
  {
    AppMethodBeat.i(68738);
    zzes localzzes = new zzes(this);
    AppMethodBeat.o(68738);
    return localzzes;
  }
  
  public final int size()
  {
    AppMethodBeat.i(68735);
    int i = this.zzafy.size();
    AppMethodBeat.o(68735);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(68736);
    String str = this.zzafy.toString();
    AppMethodBeat.o(68736);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(68730);
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeBundle(paramParcel, 2, zzif(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    AppMethodBeat.o(68730);
  }
  
  final Double zzbh(String paramString)
  {
    AppMethodBeat.i(68733);
    double d = this.zzafy.getDouble(paramString);
    AppMethodBeat.o(68733);
    return Double.valueOf(d);
  }
  
  public final Bundle zzif()
  {
    AppMethodBeat.i(68737);
    Bundle localBundle = new Bundle(this.zzafy);
    AppMethodBeat.o(68737);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzer
 * JD-Core Version:    0.7.0.1
 */