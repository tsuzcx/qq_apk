package com.tencent.mm.plugin.exdevice.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface k
  extends IInterface
{
  public abstract void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2);
  
  public static abstract class a
    extends Binder
    implements k
  {
    public a()
    {
      attachInterface(this, "com.tencent.mm.plugin.exdevice.service.IBTOnStateChange_AIDL");
    }
    
    public static k y(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mm.plugin.exdevice.service.IBTOnStateChange_AIDL");
      if ((localIInterface != null) && ((localIInterface instanceof k))) {
        return (k)localIInterface;
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
        paramParcel2.writeString("com.tencent.mm.plugin.exdevice.service.IBTOnStateChange_AIDL");
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IBTOnStateChange_AIDL");
      a(paramParcel1.readLong(), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readLong());
      paramParcel2.writeNoException();
      return true;
    }
    
    static final class a
      implements k
    {
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public final void a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2)
      {
        AppMethodBeat.i(23681);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IBTOnStateChange_AIDL");
          localParcel1.writeLong(paramLong1);
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          localParcel1.writeInt(paramInt3);
          localParcel1.writeLong(paramLong2);
          this.mRemote.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(23681);
        }
      }
      
      public final IBinder asBinder()
      {
        return this.mRemote;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.k
 * JD-Core Version:    0.7.0.1
 */