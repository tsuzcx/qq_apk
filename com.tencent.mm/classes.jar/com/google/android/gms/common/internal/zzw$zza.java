package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.zza;

public abstract class zzw$zza
  extends Binder
  implements zzw
{
  public static zzw zzbv(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
    if ((localIInterface != null) && ((localIInterface instanceof zzw))) {
      return (zzw)localIInterface;
    }
    return new zzw.zza.zza(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    IObjectWrapper localIObjectWrapper2 = null;
    IObjectWrapper localIObjectWrapper1 = null;
    int i = 0;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.common.internal.IGoogleCertificatesApi");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
      localIObjectWrapper2 = zzyc();
      paramParcel2.writeNoException();
      paramParcel1 = localIObjectWrapper1;
      if (localIObjectWrapper2 != null) {
        paramParcel1 = localIObjectWrapper2.asBinder();
      }
      paramParcel2.writeStrongBinder(paramParcel1);
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
      localIObjectWrapper1 = zzyd();
      paramParcel2.writeNoException();
      paramParcel1 = localIObjectWrapper2;
      if (localIObjectWrapper1 != null) {
        paramParcel1 = localIObjectWrapper1.asBinder();
      }
      paramParcel2.writeStrongBinder(paramParcel1);
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
      bool = zze(paramParcel1.readString(), IObjectWrapper.zza.zzcd(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      if (bool) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        paramParcel2.writeInt(paramInt1);
        return true;
      }
    }
    paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
    boolean bool = zzf(paramParcel1.readString(), IObjectWrapper.zza.zzcd(paramParcel1.readStrongBinder()));
    paramParcel2.writeNoException();
    paramInt1 = i;
    if (bool) {
      paramInt1 = 1;
    }
    paramParcel2.writeInt(paramInt1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzw.zza
 * JD-Core Version:    0.7.0.1
 */