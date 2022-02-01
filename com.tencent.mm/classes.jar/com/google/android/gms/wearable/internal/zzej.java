package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import com.google.android.gms.internal.wearable.zzb;

public abstract class zzej
  extends zzb
  implements zzei
{
  public zzej()
  {
    super("com.google.android.gms.wearable.internal.IChannelStreamCallbacks");
  }
  
  public final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    if (paramInt1 == 2)
    {
      zza(paramParcel1.readInt(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzej
 * JD-Core Version:    0.7.0.1
 */