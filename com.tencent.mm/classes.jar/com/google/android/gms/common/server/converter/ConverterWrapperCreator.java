package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ConverterWrapperCreator
  implements Parcelable.Creator<ConverterWrapper>
{
  public static final int CONTENT_DESCRIPTION = 0;
  
  public ConverterWrapper createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(11937);
    int j = SafeParcelReader.validateObjectHeader(paramParcel);
    int i = 0;
    StringToIntConverter localStringToIntConverter = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = SafeParcelReader.readHeader(paramParcel);
      switch (SafeParcelReader.getFieldId(k))
      {
      default: 
        SafeParcelReader.skipUnknownField(paramParcel, k);
        break;
      case 1: 
        i = SafeParcelReader.readInt(paramParcel, k);
        break;
      case 2: 
        localStringToIntConverter = (StringToIntConverter)SafeParcelReader.createParcelable(paramParcel, k, StringToIntConverter.CREATOR);
      }
    }
    SafeParcelReader.ensureAtEnd(paramParcel, j);
    paramParcel = new ConverterWrapper(i, localStringToIntConverter);
    AppMethodBeat.o(11937);
    return paramParcel;
  }
  
  public ConverterWrapper[] newArray(int paramInt)
  {
    return new ConverterWrapper[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.server.converter.ConverterWrapperCreator
 * JD-Core Version:    0.7.0.1
 */