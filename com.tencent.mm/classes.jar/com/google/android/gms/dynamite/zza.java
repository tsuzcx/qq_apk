package com.google.android.gms.dynamite;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.zza;

public abstract interface zza
  extends IInterface
{
  public abstract int zza(IObjectWrapper paramIObjectWrapper, String paramString, boolean paramBoolean);
  
  public abstract IObjectWrapper zza(IObjectWrapper paramIObjectWrapper, String paramString, int paramInt);
  
  public abstract int zze(IObjectWrapper paramIObjectWrapper, String paramString);
  
  public static abstract class zza
    extends Binder
    implements zza
  {
    public static zza zzce(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
      if ((localIInterface != null) && ((localIInterface instanceof zza))) {
        return (zza)localIInterface;
      }
      return new zza.zza.zza(paramIBinder);
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.dynamite.IDynamiteLoader");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.dynamite.IDynamiteLoader");
        paramInt1 = zze(IObjectWrapper.zza.zzcd(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.dynamite.IDynamiteLoader");
        paramParcel1 = zza(IObjectWrapper.zza.zzcd(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        if (paramParcel1 != null) {}
        for (paramParcel1 = paramParcel1.asBinder();; paramParcel1 = null)
        {
          paramParcel2.writeStrongBinder(paramParcel1);
          return true;
        }
      }
      paramParcel1.enforceInterface("com.google.android.gms.dynamite.IDynamiteLoader");
      IObjectWrapper localIObjectWrapper = IObjectWrapper.zza.zzcd(paramParcel1.readStrongBinder());
      String str = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        paramInt1 = zza(localIObjectWrapper, str, bool);
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.dynamite.zza
 * JD-Core Version:    0.7.0.1
 */