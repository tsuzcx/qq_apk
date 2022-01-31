package com.tencent.mm.network;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract interface n
  extends IInterface
{
  public abstract void et(int paramInt);
  
  public static abstract class a
    extends Binder
    implements n
  {
    public a()
    {
      attachInterface(this, "com.tencent.mm.network.IOnNetworkChange_AIDL");
    }
    
    public static n o(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mm.network.IOnNetworkChange_AIDL");
      if ((localIInterface != null) && ((localIInterface instanceof n))) {
        return (n)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.tencent.mm.network.IOnNetworkChange_AIDL");
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mm.network.IOnNetworkChange_AIDL");
      et(paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    }
    
    private static final class a
      implements n
    {
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public final IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public final void et(int paramInt)
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IOnNetworkChange_AIDL");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.network.n
 * JD-Core Version:    0.7.0.1
 */