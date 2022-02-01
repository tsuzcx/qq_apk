package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class FieldMapPairCreator
  implements Parcelable.Creator<FieldMappingDictionary.FieldMapPair>
{
  public static final int CONTENT_DESCRIPTION = 0;
  
  public FieldMappingDictionary.FieldMapPair createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(12048);
    int j = SafeParcelReader.validateObjectHeader(paramParcel);
    int i = 0;
    FastJsonResponse.Field localField = null;
    String str = null;
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
        str = SafeParcelReader.createString(paramParcel, k);
        break;
      case 3: 
        localField = (FastJsonResponse.Field)SafeParcelReader.createParcelable(paramParcel, k, FastJsonResponse.Field.CREATOR);
      }
    }
    SafeParcelReader.ensureAtEnd(paramParcel, j);
    paramParcel = new FieldMappingDictionary.FieldMapPair(i, str, localField);
    AppMethodBeat.o(12048);
    return paramParcel;
  }
  
  public FieldMappingDictionary.FieldMapPair[] newArray(int paramInt)
  {
    return new FieldMappingDictionary.FieldMapPair[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.server.response.FieldMapPairCreator
 * JD-Core Version:    0.7.0.1
 */