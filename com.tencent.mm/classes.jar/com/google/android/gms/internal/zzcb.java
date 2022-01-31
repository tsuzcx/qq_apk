package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.AccountChangeEventsRequest;
import com.google.android.gms.auth.AccountChangeEventsResponse;

public abstract interface zzcb
  extends IInterface
{
  public abstract Bundle zza(Account paramAccount);
  
  public abstract Bundle zza(Account paramAccount, String paramString, Bundle paramBundle);
  
  public abstract Bundle zza(Bundle paramBundle);
  
  public abstract Bundle zza(String paramString, Bundle paramBundle);
  
  public abstract Bundle zza(String paramString1, String paramString2, Bundle paramBundle);
  
  public abstract AccountChangeEventsResponse zza(AccountChangeEventsRequest paramAccountChangeEventsRequest);
  
  public static abstract class zza
    extends Binder
    implements zzcb
  {
    public static zzcb zza(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.auth.IAuthManagerService");
      if ((localIInterface != null) && ((localIInterface instanceof zzcb))) {
        return (zzcb)localIInterface;
      }
      return new zzcb.zza.zza(paramIBinder);
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      Object localObject;
      String str;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.google.android.auth.IAuthManagerService");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.auth.IAuthManagerService");
        localObject = paramParcel1.readString();
        str = paramParcel1.readString();
        if (paramParcel1.readInt() != 0)
        {
          paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
          paramParcel1 = zza((String)localObject, str, paramParcel1);
          paramParcel2.writeNoException();
          if (paramParcel1 == null) {
            break label160;
          }
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
        }
        for (;;)
        {
          return true;
          paramParcel1 = null;
          break;
          paramParcel2.writeInt(0);
        }
      case 2: 
        paramParcel1.enforceInterface("com.google.android.auth.IAuthManagerService");
        localObject = paramParcel1.readString();
        if (paramParcel1.readInt() != 0)
        {
          paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
          paramParcel1 = zza((String)localObject, paramParcel1);
          paramParcel2.writeNoException();
          if (paramParcel1 == null) {
            break label234;
          }
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
        }
        for (;;)
        {
          return true;
          paramParcel1 = null;
          break;
          paramParcel2.writeInt(0);
        }
      case 3: 
        paramParcel1.enforceInterface("com.google.android.auth.IAuthManagerService");
        if (paramParcel1.readInt() != 0)
        {
          paramParcel1 = (AccountChangeEventsRequest)AccountChangeEventsRequest.CREATOR.createFromParcel(paramParcel1);
          paramParcel1 = zza(paramParcel1);
          paramParcel2.writeNoException();
          if (paramParcel1 == null) {
            break label300;
          }
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
        }
        for (;;)
        {
          return true;
          paramParcel1 = null;
          break;
          paramParcel2.writeInt(0);
        }
      case 5: 
        paramParcel1.enforceInterface("com.google.android.auth.IAuthManagerService");
        if (paramParcel1.readInt() != 0)
        {
          localObject = (Account)Account.CREATOR.createFromParcel(paramParcel1);
          str = paramParcel1.readString();
          if (paramParcel1.readInt() == 0) {
            break label398;
          }
          paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
          paramParcel1 = zza((Account)localObject, str, paramParcel1);
          paramParcel2.writeNoException();
          if (paramParcel1 == null) {
            break label403;
          }
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
        }
        for (;;)
        {
          return true;
          localObject = null;
          break;
          paramParcel1 = null;
          break label361;
          paramParcel2.writeInt(0);
        }
      case 6: 
        label160:
        label234:
        paramParcel1.enforceInterface("com.google.android.auth.IAuthManagerService");
        label300:
        label361:
        if (paramParcel1.readInt() != 0)
        {
          paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
          paramParcel1 = zza(paramParcel1);
          paramParcel2.writeNoException();
          if (paramParcel1 == null) {
            break label469;
          }
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
        }
        for (;;)
        {
          label398:
          label403:
          return true;
          paramParcel1 = null;
          break;
          label469:
          paramParcel2.writeInt(0);
        }
      }
      paramParcel1.enforceInterface("com.google.android.auth.IAuthManagerService");
      if (paramParcel1.readInt() != 0)
      {
        paramParcel1 = (Account)Account.CREATOR.createFromParcel(paramParcel1);
        paramParcel1 = zza(paramParcel1);
        paramParcel2.writeNoException();
        if (paramParcel1 == null) {
          break label535;
        }
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
      }
      for (;;)
      {
        return true;
        paramParcel1 = null;
        break;
        label535:
        paramParcel2.writeInt(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.zzcb
 * JD-Core Version:    0.7.0.1
 */