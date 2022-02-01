package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface d
  extends IInterface
{
  public abstract void N(Bundle paramBundle);
  
  public abstract void O(Bundle paramBundle);
  
  public abstract void a(IBinder paramIBinder, String paramString);
  
  public static abstract class a
    extends Binder
    implements d
  {
    public a()
    {
      attachInterface(this, "com.tencent.mm.plugin.appbrand.ipc.IMainProcessService");
    }
    
    public static d bDS()
    {
      return a.lwO;
    }
    
    public static d r(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mm.plugin.appbrand.ipc.IMainProcessService");
      if ((localIInterface != null) && ((localIInterface instanceof d))) {
        return (d)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      Object localObject2 = null;
      Object localObject1 = null;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.tencent.mm.plugin.appbrand.ipc.IMainProcessService");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.appbrand.ipc.IMainProcessService");
        paramParcel2 = (Parcel)localObject1;
        if (paramParcel1.readInt() != 0) {
          paramParcel2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        N(paramParcel2);
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.appbrand.ipc.IMainProcessService");
        localObject1 = localObject2;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        O((Bundle)localObject1);
        paramParcel2.writeNoException();
        if (localObject1 != null)
        {
          paramParcel2.writeInt(1);
          ((Bundle)localObject1).writeToParcel(paramParcel2, 1);
        }
        for (;;)
        {
          return true;
          paramParcel2.writeInt(0);
        }
      }
      paramParcel1.enforceInterface("com.tencent.mm.plugin.appbrand.ipc.IMainProcessService");
      a(paramParcel1.readStrongBinder(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    }
    
    static final class a
      implements d
    {
      public static d lwO;
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public final void N(Bundle paramBundle)
      {
        AppMethodBeat.i(140617);
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.tencent.mm.plugin.appbrand.ipc.IMainProcessService");
          if (paramBundle != null)
          {
            localParcel.writeInt(1);
            paramBundle.writeToParcel(localParcel, 0);
          }
          while ((!this.mRemote.transact(1, localParcel, null, 1)) && (d.a.bDS() != null))
          {
            d.a.bDS().N(paramBundle);
            return;
            localParcel.writeInt(0);
          }
          localParcel.recycle();
        }
        finally
        {
          localParcel.recycle();
          AppMethodBeat.o(140617);
        }
        AppMethodBeat.o(140617);
      }
      
      public final void O(Bundle paramBundle)
      {
        AppMethodBeat.i(140618);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.appbrand.ipc.IMainProcessService");
          if (paramBundle != null)
          {
            localParcel1.writeInt(1);
            paramBundle.writeToParcel(localParcel1, 0);
          }
          while ((!this.mRemote.transact(2, localParcel1, localParcel2, 0)) && (d.a.bDS() != null))
          {
            d.a.bDS().O(paramBundle);
            return;
            localParcel1.writeInt(0);
          }
          localParcel2.readException();
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(140618);
        }
        if (localParcel2.readInt() != 0) {
          paramBundle.readFromParcel(localParcel2);
        }
        localParcel2.recycle();
        localParcel1.recycle();
        AppMethodBeat.o(140618);
      }
      
      public final void a(IBinder paramIBinder, String paramString)
      {
        AppMethodBeat.i(140619);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.appbrand.ipc.IMainProcessService");
          localParcel1.writeStrongBinder(paramIBinder);
          localParcel1.writeString(paramString);
          if ((!this.mRemote.transact(3, localParcel1, localParcel2, 0)) && (d.a.bDS() != null))
          {
            d.a.bDS().a(paramIBinder, paramString);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(140619);
        }
      }
      
      public final IBinder asBinder()
      {
        return this.mRemote;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.d
 * JD-Core Version:    0.7.0.1
 */