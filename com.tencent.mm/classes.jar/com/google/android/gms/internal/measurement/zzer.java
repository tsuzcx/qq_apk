package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

public final class zzer
  extends AbstractSafeParcelable
  implements Iterable<String>
{
  public static final Parcelable.Creator<zzer> CREATOR;
  private final Bundle zzafy;
  
  static
  {
    AppMethodBeat.i(1262);
    CREATOR = new zzet();
    AppMethodBeat.o(1262);
  }
  
  zzer(Bundle paramBundle)
  {
    this.zzafy = paramBundle;
  }
  
  final Object get(String paramString)
  {
    AppMethodBeat.i(1254);
    paramString = this.zzafy.get(paramString);
    AppMethodBeat.o(1254);
    return paramString;
  }
  
  final Long getLong(String paramString)
  {
    AppMethodBeat.i(1255);
    long l = this.zzafy.getLong(paramString);
    AppMethodBeat.o(1255);
    return Long.valueOf(l);
  }
  
  final String getString(String paramString)
  {
    AppMethodBeat.i(1257);
    paramString = this.zzafy.getString(paramString);
    AppMethodBeat.o(1257);
    return paramString;
  }
  
  public final Iterator<String> iterator()
  {
    AppMethodBeat.i(1261);
    zzes localzzes = new zzes(this);
    AppMethodBeat.o(1261);
    return localzzes;
  }
  
  public final int size()
  {
    AppMethodBeat.i(1258);
    int i = this.zzafy.size();
    AppMethodBeat.o(1258);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(1259);
    String str = this.zzafy.toString();
    AppMethodBeat.o(1259);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(1253);
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeBundle(paramParcel, 2, zzif(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    AppMethodBeat.o(1253);
  }
  
  final Double zzbh(String paramString)
  {
    AppMethodBeat.i(1256);
    double d = this.zzafy.getDouble(paramString);
    AppMethodBeat.o(1256);
    return Double.valueOf(d);
  }
  
  public final Bundle zzif()
  {
    AppMethodBeat.i(1260);
    Bundle localBundle = new Bundle(this.zzafy);
    AppMethodBeat.o(1260);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzer
 * JD-Core Version:    0.7.0.1
 */