package com.google.android.gms.common.net;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import com.google.android.gms.internal.stable.zzb;
import com.google.android.gms.internal.stable.zzc;

public abstract interface ISocketFactoryCreator
  extends IInterface
{
  public abstract IObjectWrapper newSocketFactory(IObjectWrapper paramIObjectWrapper1, IObjectWrapper paramIObjectWrapper2, IObjectWrapper paramIObjectWrapper3, boolean paramBoolean);
  
  public abstract IObjectWrapper newSocketFactoryWithCacheDir(IObjectWrapper paramIObjectWrapper1, IObjectWrapper paramIObjectWrapper2, IObjectWrapper paramIObjectWrapper3, String paramString);
  
  public static abstract class Stub
    extends zzb
    implements ISocketFactoryCreator
  {
    public Stub()
    {
      super();
    }
    
    public static ISocketFactoryCreator asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.net.ISocketFactoryCreator");
      if ((localIInterface instanceof ISocketFactoryCreator)) {
        return (ISocketFactoryCreator)localIInterface;
      }
      return new ISocketFactoryCreator.Stub.Proxy(paramIBinder);
    }
    
    public boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      switch (paramInt1)
      {
      default: 
        return false;
      case 1: 
        paramParcel1 = newSocketFactory(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), zzc.zza(paramParcel1));
        paramParcel2.writeNoException();
        zzc.zza(paramParcel2, paramParcel1);
      }
      for (;;)
      {
        return true;
        paramParcel1 = newSocketFactoryWithCacheDir(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        zzc.zza(paramParcel2, paramParcel1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.net.ISocketFactoryCreator
 * JD-Core Version:    0.7.0.1
 */