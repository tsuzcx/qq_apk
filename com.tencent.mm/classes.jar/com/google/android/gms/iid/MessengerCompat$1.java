package com.google.android.gms.iid;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class MessengerCompat$1
  implements Parcelable.Creator<MessengerCompat>
{
  public final MessengerCompat zzgs(Parcel paramParcel)
  {
    paramParcel = paramParcel.readStrongBinder();
    if (paramParcel != null) {
      return new MessengerCompat(paramParcel);
    }
    return null;
  }
  
  public final MessengerCompat[] zzjK(int paramInt)
  {
    return new MessengerCompat[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.iid.MessengerCompat.1
 * JD-Core Version:    0.7.0.1
 */