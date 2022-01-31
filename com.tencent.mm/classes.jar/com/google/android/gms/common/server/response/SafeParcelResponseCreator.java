package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SafeParcelResponseCreator
  implements Parcelable.Creator<SafeParcelResponse>
{
  public static final int CONTENT_DESCRIPTION = 0;
  
  public SafeParcelResponse createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(61623);
    int j = SafeParcelReader.validateObjectHeader(paramParcel);
    int i = 0;
    FieldMappingDictionary localFieldMappingDictionary = null;
    Parcel localParcel = null;
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
        localParcel = SafeParcelReader.createParcel(paramParcel, k);
        break;
      case 3: 
        localFieldMappingDictionary = (FieldMappingDictionary)SafeParcelReader.createParcelable(paramParcel, k, FieldMappingDictionary.CREATOR);
      }
    }
    SafeParcelReader.ensureAtEnd(paramParcel, j);
    paramParcel = new SafeParcelResponse(i, localParcel, localFieldMappingDictionary);
    AppMethodBeat.o(61623);
    return paramParcel;
  }
  
  public SafeParcelResponse[] newArray(int paramInt)
  {
    return new SafeParcelResponse[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.common.server.response.SafeParcelResponseCreator
 * JD-Core Version:    0.7.0.1
 */