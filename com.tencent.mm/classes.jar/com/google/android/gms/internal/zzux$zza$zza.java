package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;

class zzux$zza$zza
  implements zzux
{
  private IBinder zzrk;
  
  zzux$zza$zza(IBinder paramIBinder)
  {
    this.zzrk = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return this.zzrk;
  }
  
  public void zza(Account paramAccount, int paramInt, zzuw paramzzuw)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.auth.api.accountactivationstate.internal.IAccountActivationStateService");
        if (paramAccount != null)
        {
          localParcel1.writeInt(1);
          paramAccount.writeToParcel(localParcel1, 0);
          localParcel1.writeInt(paramInt);
          if (paramzzuw != null)
          {
            paramAccount = paramzzuw.asBinder();
            localParcel1.writeStrongBinder(paramAccount);
            this.zzrk.transact(1, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramAccount = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.zzux.zza.zza
 * JD-Core Version:    0.7.0.1
 */