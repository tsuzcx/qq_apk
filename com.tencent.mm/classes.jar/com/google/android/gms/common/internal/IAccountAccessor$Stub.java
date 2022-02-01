package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.stable.zza;
import com.google.android.gms.internal.stable.zzb;
import com.google.android.gms.internal.stable.zzc;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class IAccountAccessor$Stub
  extends zzb
  implements IAccountAccessor
{
  public IAccountAccessor$Stub()
  {
    super("com.google.android.gms.common.internal.IAccountAccessor");
  }
  
  public static IAccountAccessor asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
    if ((localIInterface instanceof IAccountAccessor)) {
      return (IAccountAccessor)localIInterface;
    }
    return new Proxy(paramIBinder);
  }
  
  public boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    if (paramInt1 == 2)
    {
      paramParcel1 = getAccount();
      paramParcel2.writeNoException();
      zzc.zzb(paramParcel2, paramParcel1);
      return true;
    }
    return false;
  }
  
  public static class Proxy
    extends zza
    implements IAccountAccessor
  {
    Proxy(IBinder paramIBinder)
    {
      super("com.google.android.gms.common.internal.IAccountAccessor");
    }
    
    public Account getAccount()
    {
      AppMethodBeat.i(4688);
      Parcel localParcel = transactAndReadException(2, obtainAndWriteInterfaceToken());
      Account localAccount = (Account)zzc.zza(localParcel, Account.CREATOR);
      localParcel.recycle();
      AppMethodBeat.o(4688);
      return localAccount;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.common.internal.IAccountAccessor.Stub
 * JD-Core Version:    0.7.0.1
 */