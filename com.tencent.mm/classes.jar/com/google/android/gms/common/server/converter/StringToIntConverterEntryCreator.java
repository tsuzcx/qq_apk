package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class StringToIntConverterEntryCreator
  implements Parcelable.Creator<StringToIntConverter.Entry>
{
  public static final int CONTENT_DESCRIPTION = 0;
  
  public StringToIntConverter.Entry createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(11954);
    int k = SafeParcelReader.validateObjectHeader(paramParcel);
    String str = null;
    int j = 0;
    int i = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = SafeParcelReader.readHeader(paramParcel);
      switch (SafeParcelReader.getFieldId(m))
      {
      default: 
        SafeParcelReader.skipUnknownField(paramParcel, m);
        break;
      case 1: 
        i = SafeParcelReader.readInt(paramParcel, m);
        break;
      case 2: 
        str = SafeParcelReader.createString(paramParcel, m);
        break;
      case 3: 
        j = SafeParcelReader.readInt(paramParcel, m);
      }
    }
    SafeParcelReader.ensureAtEnd(paramParcel, k);
    paramParcel = new StringToIntConverter.Entry(i, str, j);
    AppMethodBeat.o(11954);
    return paramParcel;
  }
  
  public StringToIntConverter.Entry[] newArray(int paramInt)
  {
    return new StringToIntConverter.Entry[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.common.server.converter.StringToIntConverterEntryCreator
 * JD-Core Version:    0.7.0.1
 */