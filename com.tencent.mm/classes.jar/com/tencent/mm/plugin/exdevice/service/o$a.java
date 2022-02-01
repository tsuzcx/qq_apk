package com.tencent.mm.plugin.exdevice.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class o$a
  extends Binder
  implements o
{
  public o$a()
  {
    attachInterface(this, "com.tencent.mm.plugin.exdevice.service.IExDeviceTaskReq_AIDL");
  }
  
  public static o A(IBinder paramIBinder)
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
      long l = chi();
      paramParcel2.writeNoException();
      paramParcel2.writeLong(l);
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IExDeviceTaskReq_AIDL");
      paramParcel1 = chj();
      paramParcel2.writeNoException();
      paramParcel2.writeByteArray(paramParcel1);
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IExDeviceTaskReq_AIDL");
      paramInt1 = chk();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IExDeviceTaskReq_AIDL");
      paramInt1 = chl();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    }
    paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IExDeviceTaskReq_AIDL");
    paramInt1 = chm();
    paramParcel2.writeNoException();
    paramParcel2.writeInt(paramInt1);
    return true;
  }
  
  static final class a
    implements o
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
    
    public final long chi()
    {
      AppMethodBeat.i(23684);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IExDeviceTaskReq_AIDL");
        this.mRemote.transact(1, localParcel1, localParcel2, 0);
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
    
    public final byte[] chj()
    {
      AppMethodBeat.i(23685);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IExDeviceTaskReq_AIDL");
        this.mRemote.transact(2, localParcel1, localParcel2, 0);
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
    
    public final int chk()
    {
      AppMethodBeat.i(23686);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IExDeviceTaskReq_AIDL");
        this.mRemote.transact(3, localParcel1, localParcel2, 0);
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
    
    public final int chl()
    {
      AppMethodBeat.i(23687);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IExDeviceTaskReq_AIDL");
        this.mRemote.transact(4, localParcel1, localParcel2, 0);
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
    
    public final int chm()
    {
      AppMethodBeat.i(23688);
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IExDeviceTaskReq_AIDL");
        this.mRemote.transact(5, localParcel1, localParcel2, 0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.o.a
 * JD-Core Version:    0.7.0.1
 */