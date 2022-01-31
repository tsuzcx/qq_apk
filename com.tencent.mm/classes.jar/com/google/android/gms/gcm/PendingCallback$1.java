package com.google.android.gms.gcm;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class PendingCallback$1
  implements Parcelable.Creator<PendingCallback>
{
  public final PendingCallback zzgn(Parcel paramParcel)
  {
    return new PendingCallback(paramParcel);
  }
  
  public final PendingCallback[] zzjE(int paramInt)
  {
    return new PendingCallback[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.gcm.PendingCallback.1
 * JD-Core Version:    0.7.0.1
 */