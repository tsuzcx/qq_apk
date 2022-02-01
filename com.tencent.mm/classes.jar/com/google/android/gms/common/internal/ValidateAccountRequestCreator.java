package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ValidateAccountRequestCreator
  implements Parcelable.Creator<ValidateAccountRequest>
{
  public static final int CONTENT_DESCRIPTION = 0;
  
  public ValidateAccountRequest createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(4747);
    int j = SafeParcelReader.validateObjectHeader(paramParcel);
    int i = 0;
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
      }
    }
    SafeParcelReader.ensureAtEnd(paramParcel, j);
    paramParcel = new ValidateAccountRequest(i);
    AppMethodBeat.o(4747);
    return paramParcel;
  }
  
  public ValidateAccountRequest[] newArray(int paramInt)
  {
    return new ValidateAccountRequest[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.common.internal.ValidateAccountRequestCreator
 * JD-Core Version:    0.7.0.1
 */