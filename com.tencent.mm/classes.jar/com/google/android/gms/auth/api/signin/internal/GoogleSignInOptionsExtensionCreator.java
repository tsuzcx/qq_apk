package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GoogleSignInOptionsExtensionCreator
  implements Parcelable.Creator<GoogleSignInOptionsExtensionParcelable>
{
  public static final int CONTENT_DESCRIPTION = 0;
  
  public GoogleSignInOptionsExtensionParcelable createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(10875);
    int k = SafeParcelReader.validateObjectHeader(paramParcel);
    Bundle localBundle = null;
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
        localBundle = SafeParcelReader.createBundle(paramParcel, m);
      }
    }
    SafeParcelReader.ensureAtEnd(paramParcel, k);
    paramParcel = new GoogleSignInOptionsExtensionParcelable(i, j, localBundle);
    AppMethodBeat.o(10875);
    return paramParcel;
  }
  
  public GoogleSignInOptionsExtensionParcelable[] newArray(int paramInt)
  {
    return new GoogleSignInOptionsExtensionParcelable[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionCreator
 * JD-Core Version:    0.7.0.1
 */