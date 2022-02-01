package com.tencent.mobileqq.pluginsdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface OnPluginInstallListener
  extends IInterface
{
  public abstract void onInstallBegin(String paramString)
    throws RemoteException;
  
  public abstract void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
    throws RemoteException;
  
  public abstract void onInstallError(String paramString, int paramInt)
    throws RemoteException;
  
  public abstract void onInstallFinish(String paramString)
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements OnPluginInstallListener
  {
    static final int a = 1;
    static final int b = 2;
    static final int c = 3;
    static final int d = 4;
    private static final String e = "com.tencent.mobileqq.pluginsdk.OnPluginInstallListener";
    
    public Stub()
    {
      attachInterface(this, "com.tencent.mobileqq.pluginsdk.OnPluginInstallListener");
    }
    
    public static OnPluginInstallListener asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mobileqq.pluginsdk.OnPluginInstallListener");
      if ((localIInterface != null) && ((localIInterface instanceof OnPluginInstallListener))) {
        return (OnPluginInstallListener)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.tencent.mobileqq.pluginsdk.OnPluginInstallListener");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.pluginsdk.OnPluginInstallListener");
        onInstallBegin(paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.pluginsdk.OnPluginInstallListener");
        onInstallDownloadProgress(paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.mobileqq.pluginsdk.OnPluginInstallListener");
        onInstallFinish(paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mobileqq.pluginsdk.OnPluginInstallListener");
      onInstallError(paramParcel1.readString(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    }
    
    private static class a
      implements OnPluginInstallListener
    {
      private IBinder a;
      
      a(IBinder paramIBinder)
      {
        this.a = paramIBinder;
      }
      
      public String a()
      {
        return "com.tencent.mobileqq.pluginsdk.OnPluginInstallListener";
      }
      
      public IBinder asBinder()
      {
        return this.a;
      }
      
      public void onInstallBegin(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mobileqq.pluginsdk.OnPluginInstallListener");
          localParcel1.writeString(paramString);
          this.a.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mobileqq.pluginsdk.OnPluginInstallListener");
          localParcel1.writeString(paramString);
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          this.a.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void onInstallError(String paramString, int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mobileqq.pluginsdk.OnPluginInstallListener");
          localParcel1.writeString(paramString);
          localParcel1.writeInt(paramInt);
          this.a.transact(4, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void onInstallFinish(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mobileqq.pluginsdk.OnPluginInstallListener");
          localParcel1.writeString(paramString);
          this.a.transact(3, localParcel1, localParcel2, 0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.OnPluginInstallListener
 * JD-Core Version:    0.7.0.1
 */