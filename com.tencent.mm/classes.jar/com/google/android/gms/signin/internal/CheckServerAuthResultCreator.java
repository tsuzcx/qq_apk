package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class CheckServerAuthResultCreator
  implements Parcelable.Creator<CheckServerAuthResult>
{
  public static final int CONTENT_DESCRIPTION = 0;
  
  public CheckServerAuthResult createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(12153);
    int j = SafeParcelReader.validateObjectHeader(paramParcel);
    ArrayList localArrayList = null;
    boolean bool = false;
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
        bool = SafeParcelReader.readBoolean(paramParcel, k);
        break;
      case 3: 
        localArrayList = SafeParcelReader.createTypedList(paramParcel, k, Scope.CREATOR);
      }
    }
    SafeParcelReader.ensureAtEnd(paramParcel, j);
    paramParcel = new CheckServerAuthResult(i, bool, localArrayList);
    AppMethodBeat.o(12153);
    return paramParcel;
  }
  
  public CheckServerAuthResult[] newArray(int paramInt)
  {
    return new CheckServerAuthResult[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.signin.internal.CheckServerAuthResultCreator
 * JD-Core Version:    0.7.0.1
 */