package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ConnectionResultCreator
  implements Parcelable.Creator<ConnectionResult>
{
  public static final int CONTENT_DESCRIPTION = 0;
  
  public ConnectionResult createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(4371);
    int k = SafeParcelReader.validateObjectHeader(paramParcel);
    String str = null;
    PendingIntent localPendingIntent = null;
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
        localPendingIntent = (PendingIntent)SafeParcelReader.createParcelable(paramParcel, m, PendingIntent.CREATOR);
        break;
      case 4: 
        str = SafeParcelReader.createString(paramParcel, m);
      }
    }
    SafeParcelReader.ensureAtEnd(paramParcel, k);
    paramParcel = new ConnectionResult(i, j, localPendingIntent, str);
    AppMethodBeat.o(4371);
    return paramParcel;
  }
  
  public ConnectionResult[] newArray(int paramInt)
  {
    return new ConnectionResult[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.ConnectionResultCreator
 * JD-Core Version:    0.7.0.1
 */