package com.tencent.mm.plugin.exdevice.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface o
  extends IInterface
{
  public abstract long cLk();
  
  public abstract byte[] cLl();
  
  public abstract int cLm();
  
  public abstract int cLn();
  
  public abstract int cLo();
  
  public static abstract class a
    extends Binder
    implements o
  {
    public a()
    {
      attachInterface(this, "com.tencent.mm.plugin.exdevice.service.IExDeviceTaskReq_AIDL");
    }
    
    public static o B(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mm.plugin.exdevice.service.IExDeviceTaskReq_AIDL");
      if ((localIInterface != null) && ((localIInterface instanceof o))) {
        return (o)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public static o cLp()
    {
      return a.rDN;
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
        paramParcel2.writeString("com.tencent.mm.plugin.exdevice.service.IExDeviceTaskReq_AIDL");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IExDeviceTaskReq_AIDL");
        long l = cLk();
        paramParcel2.writeNoException();
        paramParcel2.writeLong(l);
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IExDeviceTaskReq_AIDL");
        paramParcel1 = cLl();
        paramParcel2.writeNoException();
        paramParcel2.writeByteArray(paramParcel1);
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IExDeviceTaskReq_AIDL");
        paramInt1 = cLm();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IExDeviceTaskReq_AIDL");
        paramInt1 = cLn();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IExDeviceTaskReq_AIDL");
      paramInt1 = cLo();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    }
    
    static final class a
      implements o
    {
      public static o rDN;
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public final IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public final long cLk()
      {
        AppMethodBeat.i(23684);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IExDeviceTaskReq_AIDL");
          if ((!this.mRemote.transact(1, localParcel1, localParcel2, 0)) && (o.a.cLp() != null))
          {
            l = o.a.cLp().cLk();
            return l;
          }
          localParcel2.readException();
          long l = localParcel2.readLong();
          return l;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(23684);
        }
      }
      
      public final byte[] cLl()
      {
        AppMethodBeat.i(23685);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IExDeviceTaskReq_AIDL");
          if ((!this.mRemote.transact(2, localParcel1, localParcel2, 0)) && (o.a.cLp() != null))
          {
            arrayOfByte = o.a.cLp().cLl();
            return arrayOfByte;
          }
          localParcel2.readException();
          byte[] arrayOfByte = localParcel2.createByteArray();
          return arrayOfByte;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(23685);
        }
      }
      
      public final int cLm()
      {
        AppMethodBeat.i(23686);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IExDeviceTaskReq_AIDL");
          if ((!this.mRemote.transact(3, localParcel1, localParcel2, 0)) && (o.a.cLp() != null))
          {
            i = o.a.cLp().cLm();
            return i;
          }
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(23686);
        }
      }
      
      public final int cLn()
      {
        AppMethodBeat.i(23687);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IExDeviceTaskReq_AIDL");
          if ((!this.mRemote.transact(4, localParcel1, localParcel2, 0)) && (o.a.cLp() != null))
          {
            i = o.a.cLp().cLn();
            return i;
          }
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(23687);
        }
      }
      
      public final int cLo()
      {
        AppMethodBeat.i(23688);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IExDeviceTaskReq_AIDL");
          if ((!this.mRemote.transact(5, localParcel1, localParcel2, 0)) && (o.a.cLp() != null))
          {
            i = o.a.cLp().cLo();
            return i;
          }
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(23688);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.o
 * JD-Core Version:    0.7.0.1
 */