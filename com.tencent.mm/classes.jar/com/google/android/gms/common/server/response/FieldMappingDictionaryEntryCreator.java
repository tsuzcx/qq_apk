package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class FieldMappingDictionaryEntryCreator
  implements Parcelable.Creator<FieldMappingDictionary.Entry>
{
  public static final int CONTENT_DESCRIPTION = 0;
  
  public FieldMappingDictionary.Entry createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(12070);
    int j = SafeParcelReader.validateObjectHeader(paramParcel);
    int i = 0;
    ArrayList localArrayList = null;
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
        localArrayList = SafeParcelReader.createTypedList(paramParcel, k, FieldMappingDictionary.FieldMapPair.CREATOR);
      }
    }
    SafeParcelReader.ensureAtEnd(paramParcel, j);
    paramParcel = new FieldMappingDictionary.Entry(i, str, localArrayList);
    AppMethodBeat.o(12070);
    return paramParcel;
  }
  
  public FieldMappingDictionary.Entry[] newArray(int paramInt)
  {
    return new FieldMappingDictionary.Entry[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.common.server.response.FieldMappingDictionaryEntryCreator
 * JD-Core Version:    0.7.0.1
 */