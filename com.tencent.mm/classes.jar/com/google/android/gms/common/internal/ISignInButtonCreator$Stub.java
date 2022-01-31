package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import com.google.android.gms.internal.stable.zzb;
import com.google.android.gms.internal.stable.zzc;

public abstract class ISignInButtonCreator$Stub
  extends zzb
  implements ISignInButtonCreator
{
  public ISignInButtonCreator$Stub()
  {
    super("com.google.android.gms.common.internal.ISignInButtonCreator");
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
    return new ISignInButtonCreator.Stub.Proxy(paramIBinder);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.common.internal.ISignInButtonCreator.Stub
 * JD-Core Version:    0.7.0.1
 */