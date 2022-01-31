package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator="StringToIntConverterEntryCreator")
public final class StringToIntConverter$Entry
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<Entry> CREATOR;
  @SafeParcelable.VersionField(id=1)
  private final int versionCode;
  @SafeParcelable.Field(id=2)
  final String zzwh;
  @SafeParcelable.Field(id=3)
  final int zzwi;
  
  static
  {
    AppMethodBeat.i(61449);
    CREATOR = new StringToIntConverterEntryCreator();
    AppMethodBeat.o(61449);
  }
  
  @SafeParcelable.Constructor
  StringToIntConverter$Entry(@SafeParcelable.Param(id=1) int paramInt1, @SafeParcelable.Param(id=2) String paramString, @SafeParcelable.Param(id=3) int paramInt2)
  {
    this.versionCode = paramInt1;
    this.zzwh = paramString;
    this.zzwi = paramInt2;
  }
  
  StringToIntConverter$Entry(String paramString, int paramInt)
  {
    this.versionCode = 1;
    this.zzwh = paramString;
    this.zzwi = paramInt;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(61448);
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.versionCode);
    SafeParcelWriter.writeString(paramParcel, 2, this.zzwh, false);
    SafeParcelWriter.writeInt(paramParcel, 3, this.zzwi);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    AppMethodBeat.o(61448);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.common.server.converter.StringToIntConverter.Entry
 * JD-Core Version:    0.7.0.1
 */