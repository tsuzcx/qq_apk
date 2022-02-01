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

public abstract interface IDynamiteLoader
  extends IInterface
{
  public abstract IObjectWrapper createModuleContext(IObjectWrapper paramIObjectWrapper, String paramString, int paramInt);
  
  public abstract int getModuleVersion(IObjectWrapper paramIObjectWrapper, String paramString);
  
  public abstract int getModuleVersion2(IObjectWrapper paramIObjectWrapper, String paramString, boolean paramBoolean);
  
  public static abstract class Stub
    extends zzb
    implements IDynamiteLoader
  {
    public Stub()
    {
      super();
    }
    
    public static IDynamiteLoader asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
      if ((localIInterface instanceof IDynamiteLoader)) {
        return (IDynamiteLoader)localIInterface;
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
        paramInt1 = getModuleVersion(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
      }
      for (;;)
      {
        return true;
        paramParcel1 = createModuleContext(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        zzc.zza(paramParcel2, paramParcel1);
        continue;
        paramInt1 = getModuleVersion2(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), paramParcel1.readString(), zzc.zza(paramParcel1));
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
      }
    }
    
    public static class Proxy
      extends zza
      implements IDynamiteLoader
    {
      Proxy(IBinder paramIBinder)
      {
        super("com.google.android.gms.dynamite.IDynamiteLoader");
      }
      
      public IObjectWrapper createModuleContext(IObjectWrapper paramIObjectWrapper, String paramString, int paramInt)
      {
        AppMethodBeat.i(5465);
        Parcel localParcel = obtainAndWriteInterfaceToken();
        zzc.zza(localParcel, paramIObjectWrapper);
        localParcel.writeString(paramString);
        localParcel.writeInt(paramInt);
        paramIObjectWrapper = transactAndReadException(2, localParcel);
        paramString = IObjectWrapper.Stub.asInterface(paramIObjectWrapper.readStrongBinder());
        paramIObjectWrapper.recycle();
        AppMethodBeat.o(5465);
        return paramString;
      }
      
      public int getModuleVersion(IObjectWrapper paramIObjectWrapper, String paramString)
      {
        AppMethodBeat.i(5464);
        Parcel localParcel = obtainAndWriteInterfaceToken();
        zzc.zza(localParcel, paramIObjectWrapper);
        localParcel.writeString(paramString);
        paramIObjectWrapper = transactAndReadException(1, localParcel);
        int i = paramIObjectWrapper.readInt();
        paramIObjectWrapper.recycle();
        AppMethodBeat.o(5464);
        return i;
      }
      
      public int getModuleVersion2(IObjectWrapper paramIObjectWrapper, String paramString, boolean paramBoolean)
      {
        AppMethodBeat.i(5466);
        Parcel localParcel = obtainAndWriteInterfaceToken();
        zzc.zza(localParcel, paramIObjectWrapper);
        localParcel.writeString(paramString);
        zzc.zza(localParcel, paramBoolean);
        paramIObjectWrapper = transactAndReadException(3, localParcel);
        int i = paramIObjectWrapper.readInt();
        paramIObjectWrapper.recycle();
        AppMethodBeat.o(5466);
        return i;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.dynamite.IDynamiteLoader
 * JD-Core Version:    0.7.0.1
 */