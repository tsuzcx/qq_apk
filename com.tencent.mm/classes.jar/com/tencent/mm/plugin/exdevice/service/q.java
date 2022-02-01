package com.tencent.mm.plugin.exdevice.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface q
  extends IInterface
{
  public abstract void a(double paramDouble1, int paramInt1, int paramInt2, byte[] paramArrayOfByte, double paramDouble2, int paramInt3, String paramString);
  
  public static abstract class a
    extends Binder
    implements q
  {
    public a()
    {
      attachInterface(this, "com.tencent.mm.plugin.exdevice.service.IIBeaconCallback_AIDL");
    }
    
    public static q cLt()
    {
      return a.rDP;
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
        paramParcel2.writeString("com.tencent.mm.plugin.exdevice.service.IIBeaconCallback_AIDL");
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mm.plugin.exdevice.service.IIBeaconCallback_AIDL");
      a(paramParcel1.readDouble(), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.createByteArray(), paramParcel1.readDouble(), paramParcel1.readInt(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    }
    
    static final class a
      implements q
    {
      public static q rDP;
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public final void a(double paramDouble1, int paramInt1, int paramInt2, byte[] paramArrayOfByte, double paramDouble2, int paramInt3, String paramString)
      {
        AppMethodBeat.i(23691);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.plugin.exdevice.service.IIBeaconCallback_AIDL");
          localParcel1.writeDouble(paramDouble1);
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          localParcel1.writeByteArray(paramArrayOfByte);
          localParcel1.writeDouble(paramDouble2);
          localParcel1.writeInt(paramInt3);
          localParcel1.writeString(paramString);
          if ((!this.mRemote.transact(1, localParcel1, localParcel2, 0)) && (q.a.cLt() != null))
          {
            q.a.cLt().a(paramDouble1, paramInt1, paramInt2, paramArrayOfByte, paramDouble2, paramInt3, paramString);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(23691);
        }
      }
      
      public final IBinder asBinder()
      {
        return this.mRemote;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.q
 * JD-Core Version:    0.7.0.1
 */