package com.android.vending.billing;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class IInAppBillingService$a
  extends Binder
  implements IInAppBillingService
{
  public IInAppBillingService$a()
  {
    attachInterface(this, "com.android.vending.billing.IInAppBillingService");
  }
  
  public static IInAppBillingService f(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.android.vending.billing.IInAppBillingService");
    if ((localIInterface != null) && ((localIInterface instanceof IInAppBillingService))) {
      return (IInAppBillingService)localIInterface;
    }
    return new IInAppBillingService.a.a(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.android.vending.billing.IInAppBillingService");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.android.vending.billing.IInAppBillingService");
      paramInt1 = b(paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.android.vending.billing.IInAppBillingService");
      paramInt1 = paramParcel1.readInt();
      String str1 = paramParcel1.readString();
      String str2 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0)
      {
        paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        paramParcel1 = getSkuDetails(paramInt1, str1, str2, paramParcel1);
        paramParcel2.writeNoException();
        if (paramParcel1 == null) {
          break label192;
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
      paramParcel1.enforceInterface("com.android.vending.billing.IInAppBillingService");
      paramParcel1 = a(paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
      }
      for (;;)
      {
        return true;
        paramParcel2.writeInt(0);
      }
    case 4: 
      label192:
      paramParcel1.enforceInterface("com.android.vending.billing.IInAppBillingService");
      paramParcel1 = b(paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
      }
      for (;;)
      {
        return true;
        paramParcel2.writeInt(0);
      }
    }
    paramParcel1.enforceInterface("com.android.vending.billing.IInAppBillingService");
    paramInt1 = c(paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readString());
    paramParcel2.writeNoException();
    paramParcel2.writeInt(paramInt1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.android.vending.billing.IInAppBillingService.a
 * JD-Core Version:    0.7.0.1
 */