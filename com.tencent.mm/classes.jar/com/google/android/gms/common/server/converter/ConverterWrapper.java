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
import com.google.android.gms.common.server.response.FastJsonResponse.FieldConverter;
import com.tencent.matrix.trace.core.AppMethodBeat;

@SafeParcelable.Class(creator="ConverterWrapperCreator")
public class ConverterWrapper
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<ConverterWrapper> CREATOR;
  @SafeParcelable.VersionField(id=1)
  private final int zzal;
  @SafeParcelable.Field(getter="getStringToIntConverter", id=2)
  private final StringToIntConverter zzwd;
  
  static
  {
    AppMethodBeat.i(61444);
    CREATOR = new ConverterWrapperCreator();
    AppMethodBeat.o(61444);
  }
  
  @SafeParcelable.Constructor
  ConverterWrapper(@SafeParcelable.Param(id=1) int paramInt, @SafeParcelable.Param(id=2) StringToIntConverter paramStringToIntConverter)
  {
    this.zzal = paramInt;
    this.zzwd = paramStringToIntConverter;
  }
  
  private ConverterWrapper(StringToIntConverter paramStringToIntConverter)
  {
    this.zzal = 1;
    this.zzwd = paramStringToIntConverter;
  }
  
  public static ConverterWrapper wrap(FastJsonResponse.FieldConverter<?, ?> paramFieldConverter)
  {
    AppMethodBeat.i(61441);
    if ((paramFieldConverter instanceof StringToIntConverter))
    {
      paramFieldConverter = new ConverterWrapper((StringToIntConverter)paramFieldConverter);
      AppMethodBeat.o(61441);
      return paramFieldConverter;
    }
    paramFieldConverter = new IllegalArgumentException("Unsupported safe parcelable field converter class.");
    AppMethodBeat.o(61441);
    throw paramFieldConverter;
  }
  
  public FastJsonResponse.FieldConverter<?, ?> unwrap()
  {
    AppMethodBeat.i(61442);
    if (this.zzwd != null)
    {
      localObject = this.zzwd;
      AppMethodBeat.o(61442);
      return localObject;
    }
    Object localObject = new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
    AppMethodBeat.o(61442);
    throw ((Throwable)localObject);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(61443);
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zzal);
    SafeParcelWriter.writeParcelable(paramParcel, 2, this.zzwd, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    AppMethodBeat.o(61443);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.server.converter.ConverterWrapper
 * JD-Core Version:    0.7.0.1
 */