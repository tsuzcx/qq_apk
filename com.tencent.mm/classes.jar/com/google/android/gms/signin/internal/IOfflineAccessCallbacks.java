package com.google.android.gms.signin.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.stable.zza;
import com.google.android.gms.internal.stable.zzb;
import com.google.android.gms.internal.stable.zzc;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public abstract interface IOfflineAccessCallbacks
  extends IInterface
{
  public abstract void checkServerAuthorization(String paramString, List<Scope> paramList, ISignInService paramISignInService);
  
  public abstract void uploadServerAuthCode(String paramString1, String paramString2, ISignInService paramISignInService);
  
  public static abstract class Stub
    extends zzb
    implements IOfflineAccessCallbacks
  {
    public Stub()
    {
      super();
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
      return new Proxy(paramIBinder);
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
    
    public static class Proxy
      extends zza
      implements IOfflineAccessCallbacks
    {
      Proxy(IBinder paramIBinder)
      {
        super("com.google.android.gms.signin.internal.IOfflineAccessCallbacks");
      }
      
      public void checkServerAuthorization(String paramString, List<Scope> paramList, ISignInService paramISignInService)
      {
        AppMethodBeat.i(12156);
        Parcel localParcel = obtainAndWriteInterfaceToken();
        localParcel.writeString(paramString);
        localParcel.writeTypedList(paramList);
        zzc.zza(localParcel, paramISignInService);
        transactAndReadExceptionReturnVoid(2, localParcel);
        AppMethodBeat.o(12156);
      }
      
      public void uploadServerAuthCode(String paramString1, String paramString2, ISignInService paramISignInService)
      {
        AppMethodBeat.i(12157);
        Parcel localParcel = obtainAndWriteInterfaceToken();
        localParcel.writeString(paramString1);
        localParcel.writeString(paramString2);
        zzc.zza(localParcel, paramISignInService);
        transactAndReadExceptionReturnVoid(3, localParcel);
        AppMethodBeat.o(12157);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.signin.internal.IOfflineAccessCallbacks
 * JD-Core Version:    0.7.0.1
 */