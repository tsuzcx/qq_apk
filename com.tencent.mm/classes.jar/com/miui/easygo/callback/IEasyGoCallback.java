package com.miui.easygo.callback;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface IEasyGoCallback
  extends IInterface
{
  public abstract void callback(int paramInt, Bundle paramBundle);
  
  public static class Default
    implements IEasyGoCallback
  {
    public IBinder asBinder()
    {
      return null;
    }
    
    public void callback(int paramInt, Bundle paramBundle) {}
  }
  
  public static abstract class Stub
    extends Binder
    implements IEasyGoCallback
  {
    private static final String DESCRIPTOR = "com.miui.easygo.callback.IEasyGoCallback";
    static final int TRANSACTION_callback = 1;
    
    public Stub()
    {
      attachInterface(this, "com.miui.easygo.callback.IEasyGoCallback");
    }
    
    public static IEasyGoCallback asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.miui.easygo.callback.IEasyGoCallback");
      if ((localIInterface != null) && ((localIInterface instanceof IEasyGoCallback))) {
        return (IEasyGoCallback)localIInterface;
      }
      return new Proxy(paramIBinder);
    }
    
    public static IEasyGoCallback getDefaultImpl()
    {
      return Proxy.sDefaultImpl;
    }
    
    public static boolean setDefaultImpl(IEasyGoCallback paramIEasyGoCallback)
    {
      if ((Proxy.sDefaultImpl == null) && (paramIEasyGoCallback != null))
      {
        Proxy.sDefaultImpl = paramIEasyGoCallback;
        return true;
      }
      return false;
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
        paramParcel2.writeString("com.miui.easygo.callback.IEasyGoCallback");
        return true;
      }
      paramParcel1.enforceInterface("com.miui.easygo.callback.IEasyGoCallback");
      paramInt1 = paramParcel1.readInt();
      paramParcel1 = new Bundle();
      callback(paramInt1, paramParcel1);
      paramParcel2.writeNoException();
      paramParcel2.writeInt(1);
      paramParcel1.writeToParcel(paramParcel2, 1);
      return true;
    }
    
    static class Proxy
      implements IEasyGoCallback
    {
      public static IEasyGoCallback sDefaultImpl;
      private IBinder mRemote;
      
      Proxy(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public void callback(int paramInt, Bundle paramBundle)
      {
        AppMethodBeat.i(222733);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.miui.easygo.callback.IEasyGoCallback");
          localParcel1.writeInt(paramInt);
          if ((!this.mRemote.transact(1, localParcel1, localParcel2, 0)) && (IEasyGoCallback.Stub.getDefaultImpl() != null))
          {
            IEasyGoCallback.Stub.getDefaultImpl().callback(paramInt, paramBundle);
            return;
          }
          localParcel2.readException();
          if (localParcel2.readInt() != 0) {
            paramBundle.readFromParcel(localParcel2);
          }
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(222733);
        }
      }
      
      public String getInterfaceDescriptor()
      {
        return "com.miui.easygo.callback.IEasyGoCallback";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.miui.easygo.callback.IEasyGoCallback
 * JD-Core Version:    0.7.0.1
 */