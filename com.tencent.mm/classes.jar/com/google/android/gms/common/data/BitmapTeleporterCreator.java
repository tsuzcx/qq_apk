package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class BitmapTeleporterCreator
  implements Parcelable.Creator<BitmapTeleporter>
{
  public static final int CONTENT_DESCRIPTION = 0;
  
  public BitmapTeleporter createFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(11509);
    int k = SafeParcelReader.validateObjectHeader(paramParcel);
    ParcelFileDescriptor localParcelFileDescriptor = null;
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
        localParcelFileDescriptor = (ParcelFileDescriptor)SafeParcelReader.createParcelable(paramParcel, m, ParcelFileDescriptor.CREATOR);
        break;
      case 3: 
        j = SafeParcelReader.readInt(paramParcel, m);
      }
    }
    SafeParcelReader.ensureAtEnd(paramParcel, k);
    paramParcel = new BitmapTeleporter(i, localParcelFileDescriptor, j);
    AppMethodBeat.o(11509);
    return paramParcel;
  }
  
  public BitmapTeleporter[] newArray(int paramInt)
  {
    return new BitmapTeleporter[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.data.BitmapTeleporterCreator
 * JD-Core Version:    0.7.0.1
 */