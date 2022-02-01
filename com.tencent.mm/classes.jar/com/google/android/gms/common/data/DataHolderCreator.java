package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class DataHolderCreator
  implements Parcelable.Creator<DataHolder>
{
  public static final int CONTENT_DESCRIPTION = 0;
  
  public DataHolder createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(11615);
    int k = SafeParcelReader.validateObjectHeader(paramParcel);
    Bundle localBundle = null;
    int i = 0;
    CursorWindow[] arrayOfCursorWindow = null;
    String[] arrayOfString = null;
    int j = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = SafeParcelReader.readHeader(paramParcel);
      switch (SafeParcelReader.getFieldId(m))
      {
      default: 
        SafeParcelReader.skipUnknownField(paramParcel, m);
        break;
      case 1: 
        arrayOfString = SafeParcelReader.createStringArray(paramParcel, m);
        break;
      case 2: 
        arrayOfCursorWindow = (CursorWindow[])SafeParcelReader.createTypedArray(paramParcel, m, CursorWindow.CREATOR);
        break;
      case 3: 
        i = SafeParcelReader.readInt(paramParcel, m);
        break;
      case 4: 
        localBundle = SafeParcelReader.createBundle(paramParcel, m);
        break;
      case 1000: 
        j = SafeParcelReader.readInt(paramParcel, m);
      }
    }
    SafeParcelReader.ensureAtEnd(paramParcel, k);
    paramParcel = new DataHolder(j, arrayOfString, arrayOfCursorWindow, i, localBundle);
    paramParcel.validateContents();
    AppMethodBeat.o(11615);
    return paramParcel;
  }
  
  public DataHolder[] newArray(int paramInt)
  {
    return new DataHolder[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.common.data.DataHolderCreator
 * JD-Core Version:    0.7.0.1
 */