package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.IAccountAccessor.Stub;
import com.google.android.gms.common.internal.IResolveAccountCallbacks;
import com.google.android.gms.common.internal.IResolveAccountCallbacks.Stub;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.internal.stable.zza;
import com.google.android.gms.internal.stable.zzb;
import com.google.android.gms.internal.stable.zzc;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface ISignInService
  extends IInterface
{
  public abstract void authAccount(AuthAccountRequest paramAuthAccountRequest, ISignInCallbacks paramISignInCallbacks);
  
  public abstract void clearAccountFromSessionStore(int paramInt);
  
  public abstract void getCurrentAccount(ISignInCallbacks paramISignInCallbacks);
  
  public abstract void onCheckServerAuthorization(CheckServerAuthResult paramCheckServerAuthResult);
  
  public abstract void onUploadServerAuthCode(boolean paramBoolean);
  
  public abstract void recordConsent(RecordConsentRequest paramRecordConsentRequest, ISignInCallbacks paramISignInCallbacks);
  
  public abstract void resolveAccount(ResolveAccountRequest paramResolveAccountRequest, IResolveAccountCallbacks paramIResolveAccountCallbacks);
  
  public abstract void saveAccountToSessionStore(int paramInt, Account paramAccount, ISignInCallbacks paramISignInCallbacks);
  
  public abstract void saveDefaultAccountToSharedPref(IAccountAccessor paramIAccountAccessor, int paramInt, boolean paramBoolean);
  
  public abstract void setGamesHasBeenGreeted(boolean paramBoolean);
  
  public abstract void signIn(SignInRequest paramSignInRequest, ISignInCallbacks paramISignInCallbacks);
  
  public static abstract class Stub
    extends zzb
    implements ISignInService
  {
    public Stub()
    {
      super();
    }
    
    public static ISignInService asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
      if ((localIInterface instanceof ISignInService)) {
        return (ISignInService)localIInterface;
      }
      return new Proxy(paramIBinder);
    }
    
    public boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      switch (paramInt1)
      {
      case 6: 
      default: 
        return false;
      case 2: 
        authAccount((AuthAccountRequest)zzc.zza(paramParcel1, AuthAccountRequest.CREATOR), ISignInCallbacks.Stub.asInterface(paramParcel1.readStrongBinder()));
      }
      for (;;)
      {
        paramParcel2.writeNoException();
        return true;
        onCheckServerAuthorization((CheckServerAuthResult)zzc.zza(paramParcel1, CheckServerAuthResult.CREATOR));
        continue;
        onUploadServerAuthCode(zzc.zza(paramParcel1));
        continue;
        resolveAccount((ResolveAccountRequest)zzc.zza(paramParcel1, ResolveAccountRequest.CREATOR), IResolveAccountCallbacks.Stub.asInterface(paramParcel1.readStrongBinder()));
        continue;
        clearAccountFromSessionStore(paramParcel1.readInt());
        continue;
        saveAccountToSessionStore(paramParcel1.readInt(), (Account)zzc.zza(paramParcel1, Account.CREATOR), ISignInCallbacks.Stub.asInterface(paramParcel1.readStrongBinder()));
        continue;
        saveDefaultAccountToSharedPref(IAccountAccessor.Stub.asInterface(paramParcel1.readStrongBinder()), paramParcel1.readInt(), zzc.zza(paramParcel1));
        continue;
        recordConsent((RecordConsentRequest)zzc.zza(paramParcel1, RecordConsentRequest.CREATOR), ISignInCallbacks.Stub.asInterface(paramParcel1.readStrongBinder()));
        continue;
        getCurrentAccount(ISignInCallbacks.Stub.asInterface(paramParcel1.readStrongBinder()));
        continue;
        signIn((SignInRequest)zzc.zza(paramParcel1, SignInRequest.CREATOR), ISignInCallbacks.Stub.asInterface(paramParcel1.readStrongBinder()));
        continue;
        setGamesHasBeenGreeted(zzc.zza(paramParcel1));
      }
    }
    
    public static class Proxy
      extends zza
      implements ISignInService
    {
      Proxy(IBinder paramIBinder)
      {
        super("com.google.android.gms.signin.internal.ISignInService");
      }
      
      public void authAccount(AuthAccountRequest paramAuthAccountRequest, ISignInCallbacks paramISignInCallbacks)
      {
        AppMethodBeat.i(12163);
        Parcel localParcel = obtainAndWriteInterfaceToken();
        zzc.zza(localParcel, paramAuthAccountRequest);
        zzc.zza(localParcel, paramISignInCallbacks);
        transactAndReadExceptionReturnVoid(2, localParcel);
        AppMethodBeat.o(12163);
      }
      
      public void clearAccountFromSessionStore(int paramInt)
      {
        AppMethodBeat.i(12167);
        Parcel localParcel = obtainAndWriteInterfaceToken();
        localParcel.writeInt(paramInt);
        transactAndReadExceptionReturnVoid(7, localParcel);
        AppMethodBeat.o(12167);
      }
      
      public void getCurrentAccount(ISignInCallbacks paramISignInCallbacks)
      {
        AppMethodBeat.i(12171);
        Parcel localParcel = obtainAndWriteInterfaceToken();
        zzc.zza(localParcel, paramISignInCallbacks);
        transactAndReadExceptionReturnVoid(11, localParcel);
        AppMethodBeat.o(12171);
      }
      
      public void onCheckServerAuthorization(CheckServerAuthResult paramCheckServerAuthResult)
      {
        AppMethodBeat.i(12164);
        Parcel localParcel = obtainAndWriteInterfaceToken();
        zzc.zza(localParcel, paramCheckServerAuthResult);
        transactAndReadExceptionReturnVoid(3, localParcel);
        AppMethodBeat.o(12164);
      }
      
      public void onUploadServerAuthCode(boolean paramBoolean)
      {
        AppMethodBeat.i(12165);
        Parcel localParcel = obtainAndWriteInterfaceToken();
        zzc.zza(localParcel, paramBoolean);
        transactAndReadExceptionReturnVoid(4, localParcel);
        AppMethodBeat.o(12165);
      }
      
      public void recordConsent(RecordConsentRequest paramRecordConsentRequest, ISignInCallbacks paramISignInCallbacks)
      {
        AppMethodBeat.i(12170);
        Parcel localParcel = obtainAndWriteInterfaceToken();
        zzc.zza(localParcel, paramRecordConsentRequest);
        zzc.zza(localParcel, paramISignInCallbacks);
        transactAndReadExceptionReturnVoid(10, localParcel);
        AppMethodBeat.o(12170);
      }
      
      public void resolveAccount(ResolveAccountRequest paramResolveAccountRequest, IResolveAccountCallbacks paramIResolveAccountCallbacks)
      {
        AppMethodBeat.i(12166);
        Parcel localParcel = obtainAndWriteInterfaceToken();
        zzc.zza(localParcel, paramResolveAccountRequest);
        zzc.zza(localParcel, paramIResolveAccountCallbacks);
        transactAndReadExceptionReturnVoid(5, localParcel);
        AppMethodBeat.o(12166);
      }
      
      public void saveAccountToSessionStore(int paramInt, Account paramAccount, ISignInCallbacks paramISignInCallbacks)
      {
        AppMethodBeat.i(12168);
        Parcel localParcel = obtainAndWriteInterfaceToken();
        localParcel.writeInt(paramInt);
        zzc.zza(localParcel, paramAccount);
        zzc.zza(localParcel, paramISignInCallbacks);
        transactAndReadExceptionReturnVoid(8, localParcel);
        AppMethodBeat.o(12168);
      }
      
      public void saveDefaultAccountToSharedPref(IAccountAccessor paramIAccountAccessor, int paramInt, boolean paramBoolean)
      {
        AppMethodBeat.i(12169);
        Parcel localParcel = obtainAndWriteInterfaceToken();
        zzc.zza(localParcel, paramIAccountAccessor);
        localParcel.writeInt(paramInt);
        zzc.zza(localParcel, paramBoolean);
        transactAndReadExceptionReturnVoid(9, localParcel);
        AppMethodBeat.o(12169);
      }
      
      public void setGamesHasBeenGreeted(boolean paramBoolean)
      {
        AppMethodBeat.i(12173);
        Parcel localParcel = obtainAndWriteInterfaceToken();
        zzc.zza(localParcel, paramBoolean);
        transactAndReadExceptionReturnVoid(13, localParcel);
        AppMethodBeat.o(12173);
      }
      
      public void signIn(SignInRequest paramSignInRequest, ISignInCallbacks paramISignInCallbacks)
      {
        AppMethodBeat.i(12172);
        Parcel localParcel = obtainAndWriteInterfaceToken();
        zzc.zza(localParcel, paramSignInRequest);
        zzc.zza(localParcel, paramISignInCallbacks);
        transactAndReadExceptionReturnVoid(12, localParcel);
        AppMethodBeat.o(12172);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.signin.internal.ISignInService
 * JD-Core Version:    0.7.0.1
 */