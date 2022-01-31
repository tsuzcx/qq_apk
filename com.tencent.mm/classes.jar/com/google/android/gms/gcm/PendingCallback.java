package com.google.android.gms.gcm;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;

public class PendingCallback
  implements Parcelable, ReflectedParcelable
{
  public static final Parcelable.Creator<PendingCallback> CREATOR = new PendingCallback.1();
  final IBinder zzaFz;
  
  public PendingCallback(Parcel paramParcel)
  {
    this.zzaFz = paramParcel.readStrongBinder();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public IBinder getIBinder()
  {
    return this.zzaFz;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeStrongBinder(this.zzaFz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.gcm.PendingCallback
 * JD-Core Version:    0.7.0.1
 */