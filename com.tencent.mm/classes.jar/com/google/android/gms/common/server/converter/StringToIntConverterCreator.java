package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class StringToIntConverterCreator
  implements Parcelable.Creator<StringToIntConverter>
{
  public static final int CONTENT_DESCRIPTION = 0;
  
  public StringToIntConverter createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(11951);
    int j = SafeParcelReader.validateObjectHeader(paramParcel);
    int i = 0;
    ArrayList localArrayList = null;
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
        localArrayList = SafeParcelReader.createTypedList(paramParcel, k, StringToIntConverter.Entry.CREATOR);
      }
    }
    SafeParcelReader.ensureAtEnd(paramParcel, j);
    paramParcel = new StringToIntConverter(i, localArrayList);
    AppMethodBeat.o(11951);
    return paramParcel;
  }
  
  public StringToIntConverter[] newArray(int paramInt)
  {
    return new StringToIntConverter[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.server.converter.StringToIntConverterCreator
 * JD-Core Version:    0.7.0.1
 */