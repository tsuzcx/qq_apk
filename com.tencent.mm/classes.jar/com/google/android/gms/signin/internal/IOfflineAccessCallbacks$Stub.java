package com.google.android.gms.signin.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.stable.zzb;

public abstract class IOfflineAccessCallbacks$Stub
  extends zzb
  implements IOfflineAccessCallbacks
{
  public IOfflineAccessCallbacks$Stub()
  {
    super("com.google.android.gms.signin.internal.IOfflineAccessCallbacks");
  }
  
  public static IOfflineAccessCallbacks asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.signin.internal.IOfflineAccessCallbacks");
    if ((localIInterface instanceof IOfflineAccessCallbacks)) {
      return (IOfflineAccessCallbacks)localIInterface;
    }
    return new IOfflineAccessCallbacks.Stub.Proxy(paramIBinder);
  }
  
  public boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return false;
    case 2: 
      checkServerAuthorization(paramParcel1.readString(), paramParcel1.createTypedArrayList(Scope.CREATOR), ISignInService.Stub.asInterface(paramParcel1.readStrongBinder()));
    }
    for (;;)
    {
      paramParcel2.writeNoException();
      return true;
      uploadServerAuthCode(paramParcel1.readString(), paramParcel1.readString(), ISignInService.Stub.asInterface(paramParcel1.readStrongBinder()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.signin.internal.IOfflineAccessCallbacks.Stub
 * JD-Core Version:    0.7.0.1
 */