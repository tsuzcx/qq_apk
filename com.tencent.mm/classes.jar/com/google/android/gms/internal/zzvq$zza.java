package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.proxy.ProxyResponse;

public abstract class zzvq$zza
  extends Binder
  implements zzvq
{
  public zzvq$zza()
  {
    attachInterface(this, "com.google.android.gms.auth.api.internal.IAuthCallbacks");
  }
  
  public static zzvq zzaI(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.auth.api.internal.IAuthCallbacks");
    if ((localIInterface != null) && ((localIInterface instanceof zzvq))) {
      return (zzvq)localIInterface;
    }
    return new zzvq.zza.zza(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.auth.api.internal.IAuthCallbacks");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.google.android.gms.auth.api.internal.IAuthCallbacks");
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (ProxyResponse)ProxyResponse.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        zza(paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    }
    paramParcel1.enforceInterface("com.google.android.gms.auth.api.internal.IAuthCallbacks");
    zzcu(paramParcel1.readString());
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.zzvq.zza
 * JD-Core Version:    0.7.0.1
 */