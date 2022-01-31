package com.google.android.search.verification.a;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class a$a
  extends Binder
  implements a
{
  public static a f(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.search.verification.api.ISearchActionVerificationService");
    if ((localIInterface != null) && ((localIInterface instanceof a))) {
      return (a)localIInterface;
    }
    return new a.a.a(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.search.verification.api.ISearchActionVerificationService");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.google.android.search.verification.api.ISearchActionVerificationService");
      Intent localIntent;
      if (paramParcel1.readInt() != 0)
      {
        localIntent = (Intent)Intent.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label134;
        }
        paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        label101:
        boolean bool = a(localIntent, paramParcel1);
        paramParcel2.writeNoException();
        if (!bool) {
          break label139;
        }
      }
      label134:
      label139:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        paramParcel2.writeInt(paramInt1);
        return true;
        localIntent = null;
        break;
        paramParcel1 = null;
        break label101;
      }
    }
    paramParcel1.enforceInterface("com.google.android.search.verification.api.ISearchActionVerificationService");
    paramInt1 = getVersion();
    paramParcel2.writeNoException();
    paramParcel2.writeInt(paramInt1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.search.verification.a.a.a
 * JD-Core Version:    0.7.0.1
 */