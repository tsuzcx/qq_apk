package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepName;
import com.tencent.matrix.trace.core.AppMethodBeat;

@KeepName
public final class BinderWrapper
  implements Parcelable
{
  public static final Parcelable.Creator<BinderWrapper> CREATOR;
  private IBinder zzry;
  
  static
  {
    AppMethodBeat.i(89584);
    CREATOR = new zza();
    AppMethodBeat.o(89584);
  }
  
  public BinderWrapper()
  {
    this.zzry = null;
  }
  
  public BinderWrapper(IBinder paramIBinder)
  {
    this.zzry = null;
    this.zzry = paramIBinder;
  }
  
  private BinderWrapper(Parcel paramParcel)
  {
    AppMethodBeat.i(89582);
    this.zzry = null;
    this.zzry = paramParcel.readStrongBinder();
    AppMethodBeat.o(89582);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final IBinder getBinder()
  {
    return this.zzry;
  }
  
  public final void setBinder(IBinder paramIBinder)
  {
    this.zzry = paramIBinder;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(89583);
    paramParcel.writeStrongBinder(this.zzry);
    AppMethodBeat.o(89583);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.common.internal.BinderWrapper
 * JD-Core Version:    0.7.0.1
 */