package com.tencent.mm.plugin.exdevice.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface s
  extends IInterface
{
  public abstract void d(long paramLong, byte[] paramArrayOfByte);
  
  public static abstract class a
    extends Binder
    implements s
  {
    public a()
    {
      attachInterface(this, "com.tencent.mm.plugin.exdevice.service.ISimpleBTOnRecv_AIDL");
    }
    
    public static s dGA()
    {
      return a.yvy;
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
        paramParcel2.writeString("com.tencent.mm.plugin.exdevice.service.ISimpleBTOnRecv_AIDL");
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.ISimpleBTOnRecv_AIDL");
      d(paramParcel1.readLong(), paramParcel1.createByteArray());
      paramParcel2.writeNoException();
      return true;
    }
    
    static final class a
      implements s
    {
      public static s yvy;
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public final IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public final void d(long paramLong, byte[] paramArrayOfByte)
      {
        AppMethodBeat.i(23692);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.ISimpleBTOnRecv_AIDL");
          localParcel1.writeLong(paramLong);
          localParcel1.writeByteArray(paramArrayOfByte);
          if ((!this.mRemote.transact(1, localParcel1, localParcel2, 0)) && (s.a.dGA() != null))
          {
            s.a.dGA().d(paramLong, paramArrayOfByte);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(23692);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.s
 * JD-Core Version:    0.7.0.1
 */