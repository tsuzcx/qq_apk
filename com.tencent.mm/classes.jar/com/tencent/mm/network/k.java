package com.tencent.mm.network;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface k
  extends IInterface
{
  public abstract int btg();
  
  public abstract void bth();
  
  public abstract long bti();
  
  public abstract boolean c(p paramp);
  
  public abstract boolean d(p paramp);
  
  public static abstract class a
    extends Binder
    implements k
  {
    public a()
    {
      attachInterface(this, "com.tencent.mm.network.INetworkEvent_AIDL");
    }
    
    public static k btj()
    {
      return a.mux;
    }
    
    public static k q(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mm.network.INetworkEvent_AIDL");
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
      int j = 0;
      int i = 0;
      boolean bool;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.tencent.mm.network.INetworkEvent_AIDL");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.tencent.mm.network.INetworkEvent_AIDL");
        paramInt1 = btg();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(paramInt1);
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.tencent.mm.network.INetworkEvent_AIDL");
        bool = c(p.a.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramInt1 = i;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.tencent.mm.network.INetworkEvent_AIDL");
        bool = d(p.a.asInterface(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        paramInt1 = j;
        if (bool) {
          paramInt1 = 1;
        }
        paramParcel2.writeInt(paramInt1);
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.tencent.mm.network.INetworkEvent_AIDL");
        bth();
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mm.network.INetworkEvent_AIDL");
      long l = bti();
      paramParcel2.writeNoException();
      paramParcel2.writeLong(l);
      return true;
    }
    
    static final class a
      implements k
    {
      public static k mux;
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public final IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public final int btg()
      {
        AppMethodBeat.i(132740);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.INetworkEvent_AIDL");
          if ((!this.mRemote.transact(1, localParcel1, localParcel2, 0)) && (k.a.btj() != null))
          {
            i = k.a.btj().btg();
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
          AppMethodBeat.o(132740);
        }
      }
      
      public final void bth()
      {
        AppMethodBeat.i(132743);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.INetworkEvent_AIDL");
          if ((!this.mRemote.transact(4, localParcel1, localParcel2, 0)) && (k.a.btj() != null))
          {
            k.a.btj().bth();
            return;
          }
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(132743);
        }
      }
      
      public final long bti()
      {
        AppMethodBeat.i(132744);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.INetworkEvent_AIDL");
          if ((!this.mRemote.transact(5, localParcel1, localParcel2, 0)) && (k.a.btj() != null))
          {
            l = k.a.btj().bti();
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
          AppMethodBeat.o(132744);
        }
      }
      
      public final boolean c(p paramp)
      {
        boolean bool = false;
        AppMethodBeat.i(132741);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.INetworkEvent_AIDL");
          if (paramp != null) {}
          for (IBinder localIBinder = paramp.asBinder();; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            if ((this.mRemote.transact(2, localParcel1, localParcel2, 0)) || (k.a.btj() == null)) {
              break;
            }
            bool = k.a.btj().c(paramp);
            return bool;
          }
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(132741);
        }
      }
      
      public final boolean d(p paramp)
      {
        boolean bool = false;
        AppMethodBeat.i(132742);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.INetworkEvent_AIDL");
          if (paramp != null) {}
          for (IBinder localIBinder = paramp.asBinder();; localIBinder = null)
          {
            localParcel1.writeStrongBinder(localIBinder);
            if ((this.mRemote.transact(3, localParcel1, localParcel2, 0)) || (k.a.btj() == null)) {
              break;
            }
            bool = k.a.btj().d(paramp);
            return bool;
          }
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
          AppMethodBeat.o(132742);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.network.k
 * JD-Core Version:    0.7.0.1
 */