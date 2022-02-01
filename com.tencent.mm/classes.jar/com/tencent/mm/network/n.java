package com.tencent.mm.network;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface n
  extends IInterface
{
  public abstract void a(int paramInt1, int paramInt2, int paramInt3, String paramString, t paramt, byte[] paramArrayOfByte);
  
  public static abstract class a
    extends Binder
    implements n
  {
    public a()
    {
      attachInterface(this, "com.tencent.mm.network.IOnGYNetEnd_AIDL");
    }
    
    public static n bQU()
    {
      return a.pnT;
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
        paramParcel2.writeString("com.tencent.mm.network.IOnGYNetEnd_AIDL");
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mm.network.IOnGYNetEnd_AIDL");
      a(paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readString(), t.a.u(paramParcel1.readStrongBinder()), paramParcel1.createByteArray());
      paramParcel2.writeNoException();
      return true;
    }
    
    static final class a
      implements n
    {
      public static n pnT;
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, t paramt, byte[] paramArrayOfByte)
      {
        AppMethodBeat.i(132746);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IOnGYNetEnd_AIDL");
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          localParcel1.writeInt(paramInt3);
          localParcel1.writeString(paramString);
          if (paramt != null) {}
          for (IBinder localIBinder = paramt.asBinder();; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            localParcel1.writeByteArray(paramArrayOfByte);
            if ((this.mRemote.transact(1, localParcel1, localParcel2, 0)) || (n.a.bQU() == null)) {
              break;
            }
            n.a.bQU().a(paramInt1, paramInt2, paramInt3, paramString, paramt, paramArrayOfByte);
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(132746);
        }
      }
      
      public final IBinder asBinder()
      {
        return this.mRemote;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.network.n
 * JD-Core Version:    0.7.0.1
 */