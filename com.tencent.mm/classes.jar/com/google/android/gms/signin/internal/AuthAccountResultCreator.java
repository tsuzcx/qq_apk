package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AuthAccountResultCreator
  implements Parcelable.Creator<AuthAccountResult>
{
  public static final int CONTENT_DESCRIPTION = 0;
  
  public AuthAccountResult createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(12146);
    int k = SafeParcelReader.validateObjectHeader(paramParcel);
    Intent localIntent = null;
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
        j = SafeParcelReader.readInt(paramParcel, m);
        break;
      case 3: 
        localIntent = (Intent)SafeParcelReader.createParcelable(paramParcel, m, Intent.CREATOR);
      }
    }
    SafeParcelReader.ensureAtEnd(paramParcel, k);
    paramParcel = new AuthAccountResult(i, j, localIntent);
    AppMethodBeat.o(12146);
    return paramParcel;
  }
  
  public AuthAccountResult[] newArray(int paramInt)
  {
    return new AuthAccountResult[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.signin.internal.AuthAccountResultCreator
 * JD-Core Version:    0.7.0.1
 */