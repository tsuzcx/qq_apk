package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SignInButtonConfigCreator
  implements Parcelable.Creator<SignInButtonConfig>
{
  public static final int CONTENT_DESCRIPTION = 0;
  
  public SignInButtonConfig createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(61375);
    int m = SafeParcelReader.validateObjectHeader(paramParcel);
    Scope[] arrayOfScope = null;
    int k = 0;
    int j = 0;
    int i = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = SafeParcelReader.readHeader(paramParcel);
      switch (SafeParcelReader.getFieldId(n))
      {
      default: 
        SafeParcelReader.skipUnknownField(paramParcel, n);
        break;
      case 1: 
        i = SafeParcelReader.readInt(paramParcel, n);
        break;
      case 2: 
        j = SafeParcelReader.readInt(paramParcel, n);
        break;
      case 3: 
        k = SafeParcelReader.readInt(paramParcel, n);
        break;
      case 4: 
        arrayOfScope = (Scope[])SafeParcelReader.createTypedArray(paramParcel, n, Scope.CREATOR);
      }
    }
    SafeParcelReader.ensureAtEnd(paramParcel, m);
    paramParcel = new SignInButtonConfig(i, j, k, arrayOfScope);
    AppMethodBeat.o(61375);
    return paramParcel;
  }
  
  public SignInButtonConfig[] newArray(int paramInt)
  {
    return new SignInButtonConfig[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.common.internal.SignInButtonConfigCreator
 * JD-Core Version:    0.7.0.1
 */