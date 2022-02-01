package com.google.android.gms.gcm;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;

@VisibleForTesting
public class PendingCallback
  implements Parcelable, ReflectedParcelable
{
  public static final Parcelable.Creator<PendingCallback> CREATOR;
  final IBinder zzal;
  
  static
  {
    AppMethodBeat.i(3672);
    CREATOR = new zzj();
    AppMethodBeat.o(3672);
  }
  
  public PendingCallback(Parcel paramParcel)
  {
    AppMethodBeat.i(3670);
    this.zzal = paramParcel.readStrongBinder();
    AppMethodBeat.o(3670);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(3671);
    paramParcel.writeStrongBinder(this.zzal);
    AppMethodBeat.o(3671);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.gcm.PendingCallback
 * JD-Core Version:    0.7.0.1
 */