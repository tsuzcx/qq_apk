package com.google.android.gms.gcm;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class zzb$zza
  extends Binder
  implements zzb
{
  public static zzb zzcV(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.gcm.INetworkTaskCallback");
    if ((localIInterface != null) && ((localIInterface instanceof zzb))) {
      return (zzb)localIInterface;
    }
    return new zza(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.gcm.INetworkTaskCallback");
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.gcm.INetworkTaskCallback");
    zzjC(paramParcel1.readInt());
    paramParcel2.writeNoException();
    return true;
  }
  
  private static class zza
    implements zzb
  {
    private IBinder zzrk;
    
    zza(IBinder paramIBinder)
    {
      this.zzrk = paramIBinder;
    }
    
    public IBinder asBinder()
    {
      return this.zzrk;
    }
    
    public void zzjC(int paramInt)
    {
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.gcm.INetworkTaskCallback");
        localParcel1.writeInt(paramInt);
        this.zzrk.transact(2, localParcel1, localParcel2, 0);
        localParcel2.readException();
        return;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.gcm.zzb.zza
 * JD-Core Version:    0.7.0.1
 */