package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ResolveAccountResponseCreator
  implements Parcelable.Creator<ResolveAccountResponse>
{
  public static final int CONTENT_DESCRIPTION = 0;
  
  public ResolveAccountResponse createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(11862);
    int j = SafeParcelReader.validateObjectHeader(paramParcel);
    boolean bool1 = false;
    boolean bool2 = false;
    ConnectionResult localConnectionResult = null;
    IBinder localIBinder = null;
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
        break;
      case 2: 
        localIBinder = SafeParcelReader.readIBinder(paramParcel, k);
        break;
      case 3: 
        localConnectionResult = (ConnectionResult)SafeParcelReader.createParcelable(paramParcel, k, ConnectionResult.CREATOR);
        break;
      case 4: 
        bool2 = SafeParcelReader.readBoolean(paramParcel, k);
        break;
      case 5: 
        bool1 = SafeParcelReader.readBoolean(paramParcel, k);
      }
    }
    SafeParcelReader.ensureAtEnd(paramParcel, j);
    paramParcel = new ResolveAccountResponse(i, localIBinder, localConnectionResult, bool2, bool1);
    AppMethodBeat.o(11862);
    return paramParcel;
  }
  
  public ResolveAccountResponse[] newArray(int paramInt)
  {
    return new ResolveAccountResponse[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.common.internal.ResolveAccountResponseCreator
 * JD-Core Version:    0.7.0.1
 */