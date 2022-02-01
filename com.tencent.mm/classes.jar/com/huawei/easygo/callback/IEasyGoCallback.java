package com.huawei.easygo.callback;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract interface IEasyGoCallback
  extends IInterface
{
  public abstract void callback(int paramInt, Bundle paramBundle);
  
  public static abstract class Stub
    extends Binder
    implements IEasyGoCallback
  {
    private static final String DESCRIPTOR = "com.huawei.easygo.callback.IEasyGoCallback";
    static final int TRANSACTION_callback = 1;
    
    public Stub()
    {
      attachInterface(this, "com.huawei.easygo.callback.IEasyGoCallback");
    }
    
    public static IEasyGoCallback asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.huawei.easygo.callback.IEasyGoCallback");
      if ((localIInterface != null) && ((localIInterface instanceof IEasyGoCallback))) {
        return (IEasyGoCallback)localIInterface;
      }
      return new Proxy(paramIBinder);
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
        paramParcel2.writeString("com.huawei.easygo.callback.IEasyGoCallback");
        return true;
      }
      paramParcel1.enforceInterface("com.huawei.easygo.callback.IEasyGoCallback");
      paramInt1 = paramParcel1.readInt();
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        callback(paramInt1, paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    }
    
    static class Proxy
      implements IEasyGoCallback
    {
      private IBinder mRemote;
      
      Proxy(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public IBinder asBinder()
      {
        return this.mRemote;
      }
      
      /* Error */
      public void callback(int paramInt, Bundle paramBundle)
      {
        // Byte code:
        //   0: ldc 25
        //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: invokestatic 37	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore_3
        //   9: invokestatic 37	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   12: astore 4
        //   14: aload_3
        //   15: ldc 39
        //   17: invokevirtual 43	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload_3
        //   21: iload_1
        //   22: invokevirtual 46	android/os/Parcel:writeInt	(I)V
        //   25: aload_2
        //   26: ifnull +49 -> 75
        //   29: aload_3
        //   30: iconst_1
        //   31: invokevirtual 46	android/os/Parcel:writeInt	(I)V
        //   34: aload_2
        //   35: aload_3
        //   36: iconst_0
        //   37: invokevirtual 52	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   40: aload_0
        //   41: getfield 19	com/huawei/easygo/callback/IEasyGoCallback$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   44: iconst_1
        //   45: aload_3
        //   46: aload 4
        //   48: iconst_0
        //   49: invokeinterface 58 5 0
        //   54: pop
        //   55: aload 4
        //   57: invokevirtual 61	android/os/Parcel:readException	()V
        //   60: aload 4
        //   62: invokevirtual 64	android/os/Parcel:recycle	()V
        //   65: aload_3
        //   66: invokevirtual 64	android/os/Parcel:recycle	()V
        //   69: ldc 25
        //   71: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   74: return
        //   75: aload_3
        //   76: iconst_0
        //   77: invokevirtual 46	android/os/Parcel:writeInt	(I)V
        //   80: goto -40 -> 40
        //   83: astore_2
        //   84: aload 4
        //   86: invokevirtual 64	android/os/Parcel:recycle	()V
        //   89: aload_3
        //   90: invokevirtual 64	android/os/Parcel:recycle	()V
        //   93: ldc 25
        //   95: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   98: aload_2
        //   99: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	100	0	this	Proxy
        //   0	100	1	paramInt	int
        //   0	100	2	paramBundle	Bundle
        //   8	82	3	localParcel1	Parcel
        //   12	73	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   14	25	83	finally
        //   29	40	83	finally
        //   40	60	83	finally
        //   75	80	83	finally
      }
      
      public String getInterfaceDescriptor()
      {
        return "com.huawei.easygo.callback.IEasyGoCallback";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.huawei.easygo.callback.IEasyGoCallback
 * JD-Core Version:    0.7.0.1
 */