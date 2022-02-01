package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.server.response.FastJsonResponse.FieldConverter;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ConverterWrapper
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<ConverterWrapper> CREATOR;
  private final int zzal;
  private final StringToIntConverter zzwd;
  
  static
  {
    AppMethodBeat.i(11936);
    CREATOR = new ConverterWrapperCreator();
    AppMethodBeat.o(11936);
  }
  
  ConverterWrapper(int paramInt, StringToIntConverter paramStringToIntConverter)
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
    AppMethodBeat.i(11933);
    if ((paramFieldConverter instanceof StringToIntConverter))
    {
      paramFieldConverter = new ConverterWrapper((StringToIntConverter)paramFieldConverter);
      AppMethodBeat.o(11933);
      return paramFieldConverter;
    }
    paramFieldConverter = new IllegalArgumentException("Unsupported safe parcelable field converter class.");
    AppMethodBeat.o(11933);
    throw paramFieldConverter;
  }
  
  public FastJsonResponse.FieldConverter<?, ?> unwrap()
  {
    AppMethodBeat.i(11934);
    if (this.zzwd != null)
    {
      localObject = this.zzwd;
      AppMethodBeat.o(11934);
      return localObject;
    }
    Object localObject = new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
    AppMethodBeat.o(11934);
    throw ((Throwable)localObject);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(11935);
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zzal);
    SafeParcelWriter.writeParcelable(paramParcel, 2, this.zzwd, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    AppMethodBeat.o(11935);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.server.converter.ConverterWrapper
 * JD-Core Version:    0.7.0.1
 */