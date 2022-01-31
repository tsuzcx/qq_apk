package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper.zza;

public abstract class zzaqd$zza
  extends Binder
  implements zzaqd
{
  public zzaqd$zza()
  {
    attachInterface(this, "com.google.android.gms.flags.IFlagProvider");
  }
  
  public static zzaqd asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.flags.IFlagProvider");
    if ((localIInterface != null) && ((localIInterface instanceof zzaqd))) {
      return (zzaqd)localIInterface;
    }
    return new zzaqd.zza.zza(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    int i = 0;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.flags.IFlagProvider");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.google.android.gms.flags.IFlagProvider");
      init(IObjectWrapper.zza.zzcd(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.google.android.gms.flags.IFlagProvider");
      String str = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        bool = getBooleanFlagValue(str, bool, paramParcel1.readInt());
        paramParcel2.writeNoException();
        paramInt1 = i;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      }
    case 3: 
      paramParcel1.enforceInterface("com.google.android.gms.flags.IFlagProvider");
      paramInt1 = getIntFlagValue(paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.google.android.gms.flags.IFlagProvider");
      long l = getLongFlagValue(paramParcel1.readString(), paramParcel1.readLong(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      paramParcel2.writeLong(l);
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.flags.IFlagProvider");
    paramParcel1 = getStringFlagValue(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readInt());
    paramParcel2.writeNoException();
    paramParcel2.writeString(paramParcel1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.internal.zzaqd.zza
 * JD-Core Version:    0.7.0.1
 */