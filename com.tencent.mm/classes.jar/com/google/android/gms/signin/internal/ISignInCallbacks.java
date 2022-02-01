package com.google.android.gms.signin.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.stable.zza;
import com.google.android.gms.internal.stable.zzb;
import com.google.android.gms.internal.stable.zzc;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface ISignInCallbacks
  extends IInterface
{
  public abstract void onAuthAccountComplete(ConnectionResult paramConnectionResult, AuthAccountResult paramAuthAccountResult);
  
  public abstract void onGetCurrentAccountComplete(Status paramStatus, GoogleSignInAccount paramGoogleSignInAccount);
  
  public abstract void onRecordConsentComplete(Status paramStatus);
  
  public abstract void onSaveAccountToSessionStoreComplete(Status paramStatus);
  
  public abstract void onSignInComplete(SignInResponse paramSignInResponse);
  
  public static abstract class Stub
    extends zzb
    implements ISignInCallbacks
  {
    public Stub()
    {
      super();
    }
    
    public static ISignInCallbacks asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInCallbacks");
      if ((localIInterface instanceof ISignInCallbacks)) {
        return (ISignInCallbacks)localIInterface;
      }
      return new Proxy(paramIBinder);
    }
    
    public boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      switch (paramInt1)
      {
      case 5: 
      default: 
        return false;
      case 3: 
        onAuthAccountComplete((ConnectionResult)zzc.zza(paramParcel1, ConnectionResult.CREATOR), (AuthAccountResult)zzc.zza(paramParcel1, AuthAccountResult.CREATOR));
      }
      for (;;)
      {
        paramParcel2.writeNoException();
        return true;
        onSaveAccountToSessionStoreComplete((Status)zzc.zza(paramParcel1, Status.CREATOR));
        continue;
        onRecordConsentComplete((Status)zzc.zza(paramParcel1, Status.CREATOR));
        continue;
        onGetCurrentAccountComplete((Status)zzc.zza(paramParcel1, Status.CREATOR), (GoogleSignInAccount)zzc.zza(paramParcel1, GoogleSignInAccount.CREATOR));
        continue;
        onSignInComplete((SignInResponse)zzc.zza(paramParcel1, SignInResponse.CREATOR));
      }
    }
    
    public static class Proxy
      extends zza
      implements ISignInCallbacks
    {
      Proxy(IBinder paramIBinder)
      {
        super("com.google.android.gms.signin.internal.ISignInCallbacks");
      }
      
      public void onAuthAccountComplete(ConnectionResult paramConnectionResult, AuthAccountResult paramAuthAccountResult)
      {
        AppMethodBeat.i(12158);
        Parcel localParcel = obtainAndWriteInterfaceToken();
        zzc.zza(localParcel, paramConnectionResult);
        zzc.zza(localParcel, paramAuthAccountResult);
        transactAndReadExceptionReturnVoid(3, localParcel);
        AppMethodBeat.o(12158);
      }
      
      public void onGetCurrentAccountComplete(Status paramStatus, GoogleSignInAccount paramGoogleSignInAccount)
      {
        AppMethodBeat.i(12161);
        Parcel localParcel = obtainAndWriteInterfaceToken();
        zzc.zza(localParcel, paramStatus);
        zzc.zza(localParcel, paramGoogleSignInAccount);
        transactAndReadExceptionReturnVoid(7, localParcel);
        AppMethodBeat.o(12161);
      }
      
      public void onRecordConsentComplete(Status paramStatus)
      {
        AppMethodBeat.i(12160);
        Parcel localParcel = obtainAndWriteInterfaceToken();
        zzc.zza(localParcel, paramStatus);
        transactAndReadExceptionReturnVoid(6, localParcel);
        AppMethodBeat.o(12160);
      }
      
      public void onSaveAccountToSessionStoreComplete(Status paramStatus)
      {
        AppMethodBeat.i(12159);
        Parcel localParcel = obtainAndWriteInterfaceToken();
        zzc.zza(localParcel, paramStatus);
        transactAndReadExceptionReturnVoid(4, localParcel);
        AppMethodBeat.o(12159);
      }
      
      public void onSignInComplete(SignInResponse paramSignInResponse)
      {
        AppMethodBeat.i(12162);
        Parcel localParcel = obtainAndWriteInterfaceToken();
        zzc.zza(localParcel, paramSignInResponse);
        transactAndReadExceptionReturnVoid(8, localParcel);
        AppMethodBeat.o(12162);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.signin.internal.ISignInCallbacks
 * JD-Core Version:    0.7.0.1
 */