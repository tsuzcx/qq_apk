package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import com.google.android.gms.internal.stable.zza;
import com.google.android.gms.internal.stable.zzb;
import com.google.android.gms.internal.stable.zzc;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface ISignInButtonCreator
  extends IInterface
{
  public abstract IObjectWrapper newSignInButton(IObjectWrapper paramIObjectWrapper, int paramInt1, int paramInt2);
  
  public abstract IObjectWrapper newSignInButtonFromConfig(IObjectWrapper paramIObjectWrapper, SignInButtonConfig paramSignInButtonConfig);
  
  public static abstract class Stub
    extends zzb
    implements ISignInButtonCreator
  {
    public Stub()
    {
      super();
    }
    
    public static ISignInButtonCreator asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
      if ((localIInterface instanceof ISignInButtonCreator)) {
        return (ISignInButtonCreator)localIInterface;
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
        paramParcel1 = newSignInButton(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        zzc.zza(paramParcel2, paramParcel1);
      }
      for (;;)
      {
        return true;
        paramParcel1 = newSignInButtonFromConfig(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), (SignInButtonConfig)zzc.zza(paramParcel1, SignInButtonConfig.CREATOR));
        paramParcel2.writeNoException();
        zzc.zza(paramParcel2, paramParcel1);
      }
    }
    
    public static class Proxy
      extends zza
      implements ISignInButtonCreator
    {
      Proxy(IBinder paramIBinder)
      {
        super("com.google.android.gms.common.internal.ISignInButtonCreator");
      }
      
      public IObjectWrapper newSignInButton(IObjectWrapper paramIObjectWrapper, int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(11844);
        Object localObject = obtainAndWriteInterfaceToken();
        zzc.zza((Parcel)localObject, paramIObjectWrapper);
        ((Parcel)localObject).writeInt(paramInt1);
        ((Parcel)localObject).writeInt(paramInt2);
        paramIObjectWrapper = transactAndReadException(1, (Parcel)localObject);
        localObject = IObjectWrapper.Stub.asInterface(paramIObjectWrapper.readStrongBinder());
        paramIObjectWrapper.recycle();
        AppMethodBeat.o(11844);
        return localObject;
      }
      
      public IObjectWrapper newSignInButtonFromConfig(IObjectWrapper paramIObjectWrapper, SignInButtonConfig paramSignInButtonConfig)
      {
        AppMethodBeat.i(11845);
        Parcel localParcel = obtainAndWriteInterfaceToken();
        zzc.zza(localParcel, paramIObjectWrapper);
        zzc.zza(localParcel, paramSignInButtonConfig);
        paramIObjectWrapper = transactAndReadException(2, localParcel);
        paramSignInButtonConfig = IObjectWrapper.Stub.asInterface(paramIObjectWrapper.readStrongBinder());
        paramIObjectWrapper.recycle();
        AppMethodBeat.o(11845);
        return paramSignInButtonConfig;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.internal.ISignInButtonCreator
 * JD-Core Version:    0.7.0.1
 */