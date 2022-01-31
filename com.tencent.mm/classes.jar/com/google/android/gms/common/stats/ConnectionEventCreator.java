package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ConnectionEventCreator
  implements Parcelable.Creator<ConnectionEvent>
{
  public static final int CONTENT_DESCRIPTION = 0;
  
  public ConnectionEvent createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(89950);
    int k = SafeParcelReader.validateObjectHeader(paramParcel);
    int j = 0;
    long l3 = 0L;
    int i = 0;
    String str6 = null;
    String str5 = null;
    String str4 = null;
    String str3 = null;
    String str2 = null;
    String str1 = null;
    long l2 = 0L;
    long l1 = 0L;
    while (paramParcel.dataPosition() < k)
    {
      int m = SafeParcelReader.readHeader(paramParcel);
      switch (SafeParcelReader.getFieldId(m))
      {
      case 3: 
      case 9: 
      default: 
        SafeParcelReader.skipUnknownField(paramParcel, m);
        break;
      case 1: 
        j = SafeParcelReader.readInt(paramParcel, m);
        break;
      case 2: 
        l3 = SafeParcelReader.readLong(paramParcel, m);
        break;
      case 4: 
        str6 = SafeParcelReader.createString(paramParcel, m);
        break;
      case 5: 
        str5 = SafeParcelReader.createString(paramParcel, m);
        break;
      case 6: 
        str4 = SafeParcelReader.createString(paramParcel, m);
        break;
      case 7: 
        str3 = SafeParcelReader.createString(paramParcel, m);
        break;
      case 8: 
        str2 = SafeParcelReader.createString(paramParcel, m);
        break;
      case 10: 
        l2 = SafeParcelReader.readLong(paramParcel, m);
        break;
      case 11: 
        l1 = SafeParcelReader.readLong(paramParcel, m);
        break;
      case 12: 
        i = SafeParcelReader.readInt(paramParcel, m);
        break;
      case 13: 
        str1 = SafeParcelReader.createString(paramParcel, m);
      }
    }
    SafeParcelReader.ensureAtEnd(paramParcel, k);
    paramParcel = new ConnectionEvent(j, l3, i, str6, str5, str4, str3, str2, str1, l2, l1);
    AppMethodBeat.o(89950);
    return paramParcel;
  }
  
  public ConnectionEvent[] newArray(int paramInt)
  {
    return new ConnectionEvent[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.stats.ConnectionEventCreator
 * JD-Core Version:    0.7.0.1
 */