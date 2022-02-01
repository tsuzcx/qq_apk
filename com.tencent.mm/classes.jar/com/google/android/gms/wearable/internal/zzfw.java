package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzfw
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzfw> CREATOR;
  private final int versionCode;
  private final zzem zzaz;
  
  static
  {
    AppMethodBeat.i(101328);
    CREATOR = new zzfx();
    AppMethodBeat.o(101328);
  }
  
  zzfw(int paramInt, IBinder paramIBinder)
  {
    AppMethodBeat.i(101326);
    this.versionCode = paramInt;
    if (paramIBinder != null)
    {
      if (paramIBinder == null) {
        paramIBinder = localIInterface;
      }
      for (;;)
      {
        this.zzaz = paramIBinder;
        AppMethodBeat.o(101326);
        return;
        localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableListener");
        if ((localIInterface instanceof zzem)) {
          paramIBinder = (zzem)localIInterface;
        } else {
          paramIBinder = new zzeo(paramIBinder);
        }
      }
    }
    this.zzaz = null;
    AppMethodBeat.o(101326);
  }
  
  public zzfw(zzem paramzzem)
  {
    this.versionCode = 1;
    this.zzaz = paramzzem;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(101327);
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.versionCode);
    if (this.zzaz == null) {}
    for (IBinder localIBinder = null;; localIBinder = this.zzaz.asBinder())
    {
      SafeParcelWriter.writeIBinder(paramParcel, 2, localIBinder, false);
      SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
      AppMethodBeat.o(101327);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzfw
 * JD-Core Version:    0.7.0.1
 */