package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.proxy.ProxyRequest;
import com.google.android.gms.auth.api.proxy.zza;

public abstract interface zzvr
  extends IInterface
{
  public abstract void zza(zzvq paramzzvq);
  
  public abstract void zza(zzvq paramzzvq, ProxyRequest paramProxyRequest);
  
  public abstract void zza(zzvq paramzzvq, zza paramzza);
  
  public static abstract class zza
    extends Binder
    implements zzvr
  {
    public static zzvr zzaJ(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.auth.api.internal.IAuthService");
      if ((localIInterface != null) && ((localIInterface instanceof zzvr))) {
        return (zzvr)localIInterface;
      }
      return new zzvr.zza.zza(paramIBinder);
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      zzvq localzzvq1 = null;
      Object localObject = null;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.auth.api.internal.IAuthService");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.auth.api.internal.IAuthService");
        localzzvq1 = zzvq.zza.zzaI(paramParcel1.readStrongBinder());
        if (paramParcel1.readInt() != 0) {
          localObject = (ProxyRequest)ProxyRequest.CREATOR.createFromParcel(paramParcel1);
        }
        zza(localzzvq1, (ProxyRequest)localObject);
        paramParcel2.writeNoException();
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.auth.api.internal.IAuthService");
        zzvq localzzvq2 = zzvq.zza.zzaI(paramParcel1.readStrongBinder());
        localObject = localzzvq1;
        if (paramParcel1.readInt() != 0) {
          localObject = (zza)zza.CREATOR.createFromParcel(paramParcel1);
        }
        zza(localzzvq2, (zza)localObject);
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.google.android.gms.auth.api.internal.IAuthService");
      zza(zzvq.zza.zzaI(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.zzvr
 * JD-Core Version:    0.7.0.1
 */