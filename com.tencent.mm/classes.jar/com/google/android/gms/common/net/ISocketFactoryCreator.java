package com.google.android.gms.common.net;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import com.google.android.gms.internal.stable.zza;
import com.google.android.gms.internal.stable.zzb;
import com.google.android.gms.internal.stable.zzc;
import com.tencent.matrix.trace.core.AppMethodBeat;

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
      return new Proxy(paramIBinder);
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
    
    public static class Proxy
      extends zza
      implements ISocketFactoryCreator
    {
      Proxy(IBinder paramIBinder)
      {
        super("com.google.android.gms.common.net.ISocketFactoryCreator");
      }
      
      public IObjectWrapper newSocketFactory(IObjectWrapper paramIObjectWrapper1, IObjectWrapper paramIObjectWrapper2, IObjectWrapper paramIObjectWrapper3, boolean paramBoolean)
      {
        AppMethodBeat.i(4919);
        Parcel localParcel = obtainAndWriteInterfaceToken();
        zzc.zza(localParcel, paramIObjectWrapper1);
        zzc.zza(localParcel, paramIObjectWrapper2);
        zzc.zza(localParcel, paramIObjectWrapper3);
        zzc.zza(localParcel, paramBoolean);
        paramIObjectWrapper1 = transactAndReadException(1, localParcel);
        paramIObjectWrapper2 = IObjectWrapper.Stub.asInterface(paramIObjectWrapper1.readStrongBinder());
        paramIObjectWrapper1.recycle();
        AppMethodBeat.o(4919);
        return paramIObjectWrapper2;
      }
      
      public IObjectWrapper newSocketFactoryWithCacheDir(IObjectWrapper paramIObjectWrapper1, IObjectWrapper paramIObjectWrapper2, IObjectWrapper paramIObjectWrapper3, String paramString)
      {
        AppMethodBeat.i(4920);
        Parcel localParcel = obtainAndWriteInterfaceToken();
        zzc.zza(localParcel, paramIObjectWrapper1);
        zzc.zza(localParcel, paramIObjectWrapper2);
        zzc.zza(localParcel, paramIObjectWrapper3);
        localParcel.writeString(paramString);
        paramIObjectWrapper1 = transactAndReadException(2, localParcel);
        paramIObjectWrapper2 = IObjectWrapper.Stub.asInterface(paramIObjectWrapper1.readStrongBinder());
        paramIObjectWrapper1.recycle();
        AppMethodBeat.o(4920);
        return paramIObjectWrapper2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.common.net.ISocketFactoryCreator
 * JD-Core Version:    0.7.0.1
 */