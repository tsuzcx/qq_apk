package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class zzacl$zza
  extends Binder
  implements zzacl
{
  public static zzacl zzbB(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.service.ICommonService");
    if ((localIInterface != null) && ((localIInterface instanceof zzacl))) {
      return (zzacl)localIInterface;
    }
    return new zzacl.zza.zza(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.common.internal.service.ICommonService");
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.common.internal.service.ICommonService");
    zza(zzack.zza.zzbA(paramParcel1.readStrongBinder()));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.zzacl.zza
 * JD-Core Version:    0.7.0.1
 */