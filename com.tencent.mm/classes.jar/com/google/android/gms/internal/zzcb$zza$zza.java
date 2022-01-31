package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.AccountChangeEventsRequest;
import com.google.android.gms.auth.AccountChangeEventsResponse;

class zzcb$zza$zza
  implements zzcb
{
  private IBinder zzrk;
  
  zzcb$zza$zza(IBinder paramIBinder)
  {
    this.zzrk = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return this.zzrk;
  }
  
  public Bundle zza(Account paramAccount)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.auth.IAuthManagerService");
        if (paramAccount != null)
        {
          localParcel1.writeInt(1);
          paramAccount.writeToParcel(localParcel1, 0);
          this.zzrk.transact(7, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            paramAccount = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
            return paramAccount;
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
  
  public Bundle zza(Account paramAccount, String paramString, Bundle paramBundle)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.auth.IAuthManagerService");
        if (paramAccount != null)
        {
          localParcel1.writeInt(1);
          paramAccount.writeToParcel(localParcel1, 0);
          localParcel1.writeString(paramString);
          if (paramBundle != null)
          {
            localParcel1.writeInt(1);
            paramBundle.writeToParcel(localParcel1, 0);
            this.zzrk.transact(5, localParcel1, localParcel2, 0);
            localParcel2.readException();
            if (localParcel2.readInt() == 0) {
              break label143;
            }
            paramAccount = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
            return paramAccount;
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        localParcel1.writeInt(0);
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      continue;
      label143:
      paramAccount = null;
    }
  }
  
  public Bundle zza(Bundle paramBundle)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.auth.IAuthManagerService");
        if (paramBundle != null)
        {
          localParcel1.writeInt(1);
          paramBundle.writeToParcel(localParcel1, 0);
          this.zzrk.transact(6, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            paramBundle = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
            return paramBundle;
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramBundle = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public Bundle zza(String paramString, Bundle paramBundle)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.auth.IAuthManagerService");
        localParcel1.writeString(paramString);
        if (paramBundle != null)
        {
          localParcel1.writeInt(1);
          paramBundle.writeToParcel(localParcel1, 0);
          this.zzrk.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            paramString = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
            return paramString;
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramString = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public Bundle zza(String paramString1, String paramString2, Bundle paramBundle)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.auth.IAuthManagerService");
        localParcel1.writeString(paramString1);
        localParcel1.writeString(paramString2);
        if (paramBundle != null)
        {
          localParcel1.writeInt(1);
          paramBundle.writeToParcel(localParcel1, 0);
          this.zzrk.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            paramString1 = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
            return paramString1;
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramString1 = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public AccountChangeEventsResponse zza(AccountChangeEventsRequest paramAccountChangeEventsRequest)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.auth.IAuthManagerService");
        if (paramAccountChangeEventsRequest != null)
        {
          localParcel1.writeInt(1);
          paramAccountChangeEventsRequest.writeToParcel(localParcel1, 0);
          this.zzrk.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            paramAccountChangeEventsRequest = (AccountChangeEventsResponse)AccountChangeEventsResponse.CREATOR.createFromParcel(localParcel2);
            return paramAccountChangeEventsRequest;
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramAccountChangeEventsRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.internal.zzcb.zza.zza
 * JD-Core Version:    0.7.0.1
 */