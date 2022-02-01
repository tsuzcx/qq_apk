package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class FeatureCreator
  implements Parcelable.Creator<Feature>
{
  public static final int CONTENT_DESCRIPTION = 0;
  
  public Feature createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(4379);
    int j = SafeParcelReader.validateObjectHeader(paramParcel);
    String str = null;
    int i = 0;
    long l = -1L;
    while (paramParcel.dataPosition() < j)
    {
      int k = SafeParcelReader.readHeader(paramParcel);
      switch (SafeParcelReader.getFieldId(k))
      {
      default: 
        SafeParcelReader.skipUnknownField(paramParcel, k);
        break;
      case 1: 
        str = SafeParcelReader.createString(paramParcel, k);
        break;
      case 2: 
        i = SafeParcelReader.readInt(paramParcel, k);
        break;
      case 3: 
        l = SafeParcelReader.readLong(paramParcel, k);
      }
    }
    SafeParcelReader.ensureAtEnd(paramParcel, j);
    paramParcel = new Feature(str, i, l);
    AppMethodBeat.o(4379);
    return paramParcel;
  }
  
  public Feature[] newArray(int paramInt)
  {
    return new Feature[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.common.FeatureCreator
 * JD-Core Version:    0.7.0.1
 */