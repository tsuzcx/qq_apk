package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class WakeLockEventCreator
  implements Parcelable.Creator<WakeLockEvent>
{
  public static final int CONTENT_DESCRIPTION = 0;
  
  public WakeLockEvent createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(5003);
    int n = SafeParcelReader.validateObjectHeader(paramParcel);
    int m = 0;
    long l3 = 0L;
    int k = 0;
    String str5 = null;
    int j = 0;
    ArrayList localArrayList = null;
    String str4 = null;
    long l2 = 0L;
    int i = 0;
    String str3 = null;
    String str2 = null;
    float f = 0.0F;
    long l1 = 0L;
    String str1 = null;
    while (paramParcel.dataPosition() < n)
    {
      int i1 = SafeParcelReader.readHeader(paramParcel);
      switch (SafeParcelReader.getFieldId(i1))
      {
      case 3: 
      case 7: 
      case 9: 
      default: 
        SafeParcelReader.skipUnknownField(paramParcel, i1);
        break;
      case 1: 
        m = SafeParcelReader.readInt(paramParcel, i1);
        break;
      case 2: 
        l3 = SafeParcelReader.readLong(paramParcel, i1);
        break;
      case 4: 
        str5 = SafeParcelReader.createString(paramParcel, i1);
        break;
      case 5: 
        j = SafeParcelReader.readInt(paramParcel, i1);
        break;
      case 6: 
        localArrayList = SafeParcelReader.createStringList(paramParcel, i1);
        break;
      case 8: 
        l2 = SafeParcelReader.readLong(paramParcel, i1);
        break;
      case 10: 
        str3 = SafeParcelReader.createString(paramParcel, i1);
        break;
      case 11: 
        k = SafeParcelReader.readInt(paramParcel, i1);
        break;
      case 12: 
        str4 = SafeParcelReader.createString(paramParcel, i1);
        break;
      case 13: 
        str2 = SafeParcelReader.createString(paramParcel, i1);
        break;
      case 14: 
        i = SafeParcelReader.readInt(paramParcel, i1);
        break;
      case 15: 
        f = SafeParcelReader.readFloat(paramParcel, i1);
        break;
      case 16: 
        l1 = SafeParcelReader.readLong(paramParcel, i1);
        break;
      case 17: 
        str1 = SafeParcelReader.createString(paramParcel, i1);
      }
    }
    SafeParcelReader.ensureAtEnd(paramParcel, n);
    paramParcel = new WakeLockEvent(m, l3, k, str5, j, localArrayList, str4, l2, i, str3, str2, f, l1, str1);
    AppMethodBeat.o(5003);
    return paramParcel;
  }
  
  public WakeLockEvent[] newArray(int paramInt)
  {
    return new WakeLockEvent[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.common.stats.WakeLockEventCreator
 * JD-Core Version:    0.7.0.1
 */