package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class FieldMappingDictionaryCreator
  implements Parcelable.Creator<FieldMappingDictionary>
{
  public static final int CONTENT_DESCRIPTION = 0;
  
  public FieldMappingDictionary createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(61575);
    int j = SafeParcelReader.validateObjectHeader(paramParcel);
    int i = 0;
    String str = null;
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
        localArrayList = SafeParcelReader.createTypedList(paramParcel, k, FieldMappingDictionary.Entry.CREATOR);
        break;
      case 3: 
        str = SafeParcelReader.createString(paramParcel, k);
      }
    }
    SafeParcelReader.ensureAtEnd(paramParcel, j);
    paramParcel = new FieldMappingDictionary(i, localArrayList, str);
    AppMethodBeat.o(61575);
    return paramParcel;
  }
  
  public FieldMappingDictionary[] newArray(int paramInt)
  {
    return new FieldMappingDictionary[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.common.server.response.FieldMappingDictionaryCreator
 * JD-Core Version:    0.7.0.1
 */