package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import com.google.android.gms.internal.stable.zza;
import com.google.android.gms.internal.stable.zzb;
import com.google.android.gms.internal.stable.zzc;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface IDynamiteLoaderV2
  extends IInterface
{
  public abstract IObjectWrapper loadModule(IObjectWrapper paramIObjectWrapper, String paramString, byte[] paramArrayOfByte);
  
  public abstract IObjectWrapper loadModule2(IObjectWrapper paramIObjectWrapper1, String paramString, int paramInt, IObjectWrapper paramIObjectWrapper2);
  
  public static abstract class Stub
    extends zzb
    implements IDynamiteLoaderV2
  {
    public Stub()
    {
      super();
    }
    
    public static IDynamiteLoaderV2 asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
      if ((localIInterface instanceof IDynamiteLoaderV2)) {
        return (IDynamiteLoaderV2)localIInterface;
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
        paramParcel1 = loadModule(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.createByteArray());
        paramParcel2.writeNoException();
        zzc.zza(paramParcel2, paramParcel1);
      }
      for (;;)
      {
        return true;
        paramParcel1 = loadModule2(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readInt(), IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        zzc.zza(paramParcel2, paramParcel1);
      }
    }
    
    public static class Proxy
      extends zza
      implements IDynamiteLoaderV2
    {
      Proxy(IBinder paramIBinder)
      {
        super("com.google.android.gms.dynamite.IDynamiteLoaderV2");
      }
      
      public IObjectWrapper loadModule(IObjectWrapper paramIObjectWrapper, String paramString, byte[] paramArrayOfByte)
      {
        AppMethodBeat.i(5467);
        Parcel localParcel = obtainAndWriteInterfaceToken();
        zzc.zza(localParcel, paramIObjectWrapper);
        localParcel.writeString(paramString);
        localParcel.writeByteArray(paramArrayOfByte);
        paramIObjectWrapper = transactAndReadException(1, localParcel);
        paramString = IObjectWrapper.Stub.asInterface(paramIObjectWrapper.readStrongBinder());
        paramIObjectWrapper.recycle();
        AppMethodBeat.o(5467);
        return paramString;
      }
      
      public IObjectWrapper loadModule2(IObjectWrapper paramIObjectWrapper1, String paramString, int paramInt, IObjectWrapper paramIObjectWrapper2)
      {
        AppMethodBeat.i(5468);
        Parcel localParcel = obtainAndWriteInterfaceToken();
        zzc.zza(localParcel, paramIObjectWrapper1);
        localParcel.writeString(paramString);
        localParcel.writeInt(paramInt);
        zzc.zza(localParcel, paramIObjectWrapper2);
        paramIObjectWrapper1 = transactAndReadException(2, localParcel);
        paramString = IObjectWrapper.Stub.asInterface(paramIObjectWrapper1.readStrongBinder());
        paramIObjectWrapper1.recycle();
        AppMethodBeat.o(5468);
        return paramString;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.dynamite.IDynamiteLoaderV2
 * JD-Core Version:    0.7.0.1
 */