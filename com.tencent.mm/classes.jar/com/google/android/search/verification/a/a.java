package com.google.android.search.verification.a;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface a
  extends IInterface
{
  public abstract boolean a(Intent paramIntent, Bundle paramBundle);
  
  public abstract int getVersion();
  
  public static abstract class a
    extends Binder
    implements a
  {
    public static a h(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.search.verification.api.ISearchActionVerificationService");
      if ((localIInterface != null) && ((localIInterface instanceof a))) {
        return (a)localIInterface;
      }
      return new a(paramIBinder);
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
    
    static final class a
      implements a
    {
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public final boolean a(Intent paramIntent, Bundle paramBundle)
      {
        boolean bool = true;
        AppMethodBeat.i(73440);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.search.verification.api.ISearchActionVerificationService");
            if (paramIntent != null)
            {
              localParcel1.writeInt(1);
              paramIntent.writeToParcel(localParcel1, 0);
              if (paramBundle != null)
              {
                localParcel1.writeInt(1);
                paramBundle.writeToParcel(localParcel1, 0);
                this.mRemote.transact(1, localParcel1, localParcel2, 0);
                localParcel2.readException();
                int i = localParcel2.readInt();
                if (i == 0) {
                  break label144;
                }
                return bool;
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
            AppMethodBeat.o(73440);
          }
          continue;
          label144:
          bool = false;
        }
      }
      
      public final IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public final int getVersion()
      {
        AppMethodBeat.i(73441);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.search.verification.api.ISearchActionVerificationService");
          this.mRemote.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(73441);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.search.verification.a.a
 * JD-Core Version:    0.7.0.1
 */