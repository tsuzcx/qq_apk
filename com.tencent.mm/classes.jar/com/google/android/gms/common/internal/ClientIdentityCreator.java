package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ClientIdentityCreator
  implements Parcelable.Creator<ClientIdentity>
{
  public static final int CONTENT_DESCRIPTION = 0;
  
  public ClientIdentity createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(11805);
    int j = SafeParcelReader.validateObjectHeader(paramParcel);
    int i = 0;
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
      }
    }
    SafeParcelReader.ensureAtEnd(paramParcel, j);
    paramParcel = new ClientIdentity(i, str);
    AppMethodBeat.o(11805);
    return paramParcel;
  }
  
  public ClientIdentity[] newArray(int paramInt)
  {
    return new ClientIdentity[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.common.internal.ClientIdentityCreator
 * JD-Core Version:    0.7.0.1
 */