package com.google.android.gms.common.server.response;

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

@SafeParcelable.Class(creator="FieldMapPairCreator")
public class FieldMappingDictionary$FieldMapPair
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<FieldMapPair> CREATOR;
  @SafeParcelable.VersionField(id=1)
  private final int versionCode;
  @SafeParcelable.Field(id=2)
  final String zzxo;
  @SafeParcelable.Field(id=3)
  final FastJsonResponse.Field<?, ?> zzxp;
  
  static
  {
    AppMethodBeat.i(61563);
    CREATOR = new FieldMapPairCreator();
    AppMethodBeat.o(61563);
  }
  
  @SafeParcelable.Constructor
  FieldMappingDictionary$FieldMapPair(@SafeParcelable.Param(id=1) int paramInt, @SafeParcelable.Param(id=2) String paramString, @SafeParcelable.Param(id=3) FastJsonResponse.Field<?, ?> paramField)
  {
    this.versionCode = paramInt;
    this.zzxo = paramString;
    this.zzxp = paramField;
  }
  
  FieldMappingDictionary$FieldMapPair(String paramString, FastJsonResponse.Field<?, ?> paramField)
  {
    this.versionCode = 1;
    this.zzxo = paramString;
    this.zzxp = paramField;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(61562);
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.versionCode);
    SafeParcelWriter.writeString(paramParcel, 2, this.zzxo, false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, this.zzxp, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    AppMethodBeat.o(61562);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.server.response.FieldMappingDictionary.FieldMapPair
 * JD-Core Version:    0.7.0.1
 */