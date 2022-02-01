package com.tencent.mm.plugin.exdevice.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface p
  extends IInterface
{
  public abstract o chn();
  
  public abstract l cho();
  
  public static abstract class a
    extends Binder
    implements p
  {
    public a()
    {
      attachInterface(this, "com.tencent.mm.plugin.exdevice.service.IExDeviceTask_AIDL");
    }
    
    public static p B(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mm.plugin.exdevice.service.IExDeviceTask_AIDL");
      if ((localIInterface != null) && ((localIInterface instanceof p))) {
        return (p)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      o localo = null;
      l locall = null;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.tencent.mm.plugin.exdevice.service.IExDeviceTask_AIDL");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IExDeviceTask_AIDL");
        localo = chn();
        paramParcel2.writeNoException();
        paramParcel1 = locall;
        if (localo != null) {
          paramParcel1 = localo.asBinder();
        }
        paramParcel2.writeStrongBinder(paramParcel1);
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IExDeviceTask_AIDL");
      locall = cho();
      paramParcel2.writeNoException();
      paramParcel1 = localo;
      if (locall != null) {
        paramParcel1 = locall.asBinder();
      }
      paramParcel2.writeStrongBinder(paramParcel1);
      return true;
    }
    
    static final class a
      implements p
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
      
      public final o chn()
      {
        AppMethodBeat.i(23689);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IExDeviceTask_AIDL");
          this.mRemote.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          o localo = o.a.A(localParcel2.readStrongBinder());
          return localo;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(23689);
        }
      }
      
      public final l cho()
      {
        AppMethodBeat.i(23690);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IExDeviceTask_AIDL");
          this.mRemote.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          l locall = l.a.z(localParcel2.readStrongBinder());
          return locall;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(23690);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.p
 * JD-Core Version:    0.7.0.1
 */